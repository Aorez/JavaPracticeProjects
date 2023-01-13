package com.bjsxt.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * ��Ϸ�Ĺ�����
 */
public class GameUtil {

    //������˽�С���ֹ���˴�������Ķ���.
    private GameUtil(){
    }

    public static Image getImage(String path) {     //images/plane.png
        BufferedImage img = null;
        URL u = GameUtil.class.getClassLoader().getResource(path);
        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static void main(String[] args) {
        Image img = GameUtil.getImage("images/plane.png");
        System.out.println(img);
    }


}
