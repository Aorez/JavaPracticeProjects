package com.bjsxt.plane;

import java.awt.*;

/**
 * ��ը��
 */
public class Explode {
    //λ��
    double x,y;

    static Image[] imgs = new Image[16];

    int count;

    static {
        for(int i=0;i<16;i++) {
            imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
//            imgs[i].getWidth(null);     //������������⡣Ŀǰû�����⣬�ӺͲ��Ӷ��С�
        }
    }

    public void drawMySelf(Graphics g) {
        if(count<16) {
            g.drawImage(imgs[count],(int)x,(int)y,null);
            count++;
        }
    }


    public Explode(){
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
