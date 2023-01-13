package com.bjsxt.plane;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * ��Ϸ������
 */
public class MyGameFrame extends Frame {


    Image  planeImg = GameUtil.getImage("images/plane.png");
    Image  bg = GameUtil.getImage("images/bg.jpg");


    Plane p1 = new Plane(planeImg,100,100,7);

    Shell[] shells = new Shell[50];

    Explode explode;    //��ը

    Date start = new Date();     //��Ϸ��ʼ��ʱ��
    Date end;       //��Ϸ������ʱ��(�ɻ�������һ��)
    long period = 0;   //���˶�����


    @Override
    public void paint(Graphics g) {     //g������һ֧����
        //������
       g.drawImage(bg,0,0,500,500,null);

        //��ʱ��
        drawTime(g);


       //���ɻ�
        p1.drawMyself(g);

        //���ڵ�
        for(int i=0;i<shells.length;i++) {
            if(shells[i]!=null) {
                shells[i].drawMyself(g);
            }

            //��ײ��⡣�����е��ڵ��ͷɻ����н��м�⣬����û����ײ
            boolean peng = shells[i].getRec().intersects(p1.getRec());
            if(peng) {
//                System.out.println("�ɻ��������ˣ���");
                p1.live = false;

                //����ըЧ��
                if(explode==null) {
                    explode = new Explode(p1.x,p1.y);
                }
                explode.drawMySelf(g);
            }

        }


    }


    public void drawTime(Graphics g){
        Color c = g.getColor();
        Font  f = g.getFont();

        g.setColor(Color.green);
        if(p1.live) {
            period = (System.currentTimeMillis()-start.getTime())/1000;
            g.drawString("��֣�"+period,30,50);
        }else{
            if(end==null) {
                end = new Date();
                period = (end.getTime()- start.getTime())/1000;
            }

            g.setColor(Color.red);
            g.setFont(new Font("΢���ź�",Font.BOLD,30));
            g.drawString("����ʱ�䣺"+period,200,200);
        }

        g.setColor(c);
        g.setFont(f);
    }


    //��ʼ������
    public void launchFrame(){
        this.setTitle("�ɻ���ս-��ѧ��");
        setVisible(true);   //�����Ƿ�ɼ�

        setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);   //���ڴ�С

        setLocation(400,400);       //���ڴ򿪵�λ��

        //���ӹرմ��ڵĶ���
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);     //�����˳�����
            }
        });

        new PaintThread().start();  //�����ػ����ڵ��߳�
        this.addKeyListener(new KeyMonitor());  //�������̼���


        //��ʼ������50���ڵ�����
        for(int i=0;i<shells.length;i++) {
            shells[i] = new Shell();
        }

    }


    /**
     * ������һ���ػ����ڵ��߳��ࡣ
     * ������ڲ�����Ϊ�˷���ֱ��ʹ�ô��������ط���
     */
    class PaintThread extends Thread {
        @Override
        public void run() {
            while(true) {
                repaint();      //�ڲ������ֱ��ʹ���ⲿ��ĳ�Ա��

                try {
                    Thread.sleep(50);           //1s=1000ms��  1s��20�Σ�20*50=1000��
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    //�ڲ��࣬ʵ�ּ��̵ļ�������
    class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("���£�"+e.getKeyCode());
            /*if(e.getKeyCode()==KeyEvent.VK_LEFT){
                left = true;
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                right = true;
            }*/

            p1.addDirection(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println("̧��"+e.getKeyCode());
            p1.minusDirection(e);
        }
    }




    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public static void main(String[] args) {
        MyGameFrame  gameFrame = new MyGameFrame();
        gameFrame.launchFrame();
    }



}
