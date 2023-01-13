package com.bjsxt.plane;

import java.awt.*;

/**
 * �ڵ���
 */
public class Shell  extends GameObject {

    double degree; //�Ƕȡ��ڵ�����ָ���ĽǶȷ���

    public  Shell(){
        x = 200;
        y = 200;

        degree = Math.random()*Math.PI*2;

        width = 5;
        height = 5;

        speed = 3;
    }

    @Override
    public void drawMyself(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);

        g.fillOval((int)x,(int)y,width,height);

        g.setColor(c);

        //�����Լ��㷨ָ���ƶ���·��
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        //�����߽�ı䷽��
        if(y>Constant.GAME_HEIGHT-this.height||y<40) {
            degree = -degree;
        }

        if(x<0||x>Constant.GAME_WIDTH-this.width) {
            degree = Math.PI-degree;
        }

    }
}
