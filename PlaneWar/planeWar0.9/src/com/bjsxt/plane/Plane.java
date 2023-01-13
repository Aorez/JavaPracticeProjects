package com.bjsxt.plane;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {

    boolean left,right,up,down; //�ɻ��ķ������

    boolean live = true;   //����

    @Override
    public void drawMyself(Graphics g) {

        if(live){
            super.drawMyself(g);

            //�ɻ����е��㷨�����������趨
//        x += speed;

            if(left) {
                x -= speed;
            }
            if(right){
                x += speed;
            }
            if(up){
                y -= speed;
            }
            if(down) {
                y += speed;
            }

        }

    }

    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;

        }
    }

    public void minusDirection(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;

        }
    }


    public Plane(Image img, double x, double y, int speed) {
        super(img, x, y, speed);
    }
}