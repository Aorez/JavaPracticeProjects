package com.bjsxt.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ������
 */
public class MyGameFrame extends Frame {

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
