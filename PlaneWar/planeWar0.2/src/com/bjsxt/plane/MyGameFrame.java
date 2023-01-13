package com.bjsxt.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ������
 */
public class MyGameFrame extends Frame {


    @Override
    public void paint(Graphics g) {     //g������һ֧����

        Color  c = g.getColor();

//        g.setColor(Color.red);
        g.setColor(new Color(255,0,255));

        //��ֱ��
        g.drawLine(100,100,400,400);

        //������
        g.drawRect(100,100,300,200);

        //����Բ
        g.drawOval(100,100,300,200);

        //���ַ���
        g.drawString("www.bjsxt.com",300,300);


        g.setColor(c);

    }

    //��ʼ������
    public void launchFrame(){
        this.setTitle("�ɻ���ս-��ѧ��");
        setVisible(true);   //�����Ƿ�ɼ�

        setSize(500,500);   //���ڴ�С

        setLocation(400,400);       //���ڴ򿪵�λ��

        //���ӹرմ��ڵĶ���
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);     //�����˳�����
            }
        });

    }

    public static void main(String[] args) {
        MyGameFrame  gameFrame = new MyGameFrame();
        gameFrame.launchFrame();
    }



}
