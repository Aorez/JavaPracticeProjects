package com.bjsxt.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ������
 */
public class MyGameFrame extends Frame {



    Image  planeImg = GameUtil.getImage("images/plane.png");
    Image  bg = GameUtil.getImage("images/bg.jpg");

    static int count = 0;

    Plane p1 = new Plane(planeImg,100,100,3);
    Plane p2 = new Plane(planeImg,100,200,4);
    Plane p3 = new Plane(planeImg,100,300,2);


    @Override
    public void paint(Graphics g) {     //g������һ֧����
        System.out.println("���ƴ��ڴ�����"+count);
        count++;

       g.drawImage(bg,0,0,500,500,null);

        p1.drawMyself(g);
        p2.drawMyself(g);
        p3.drawMyself(g);

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
