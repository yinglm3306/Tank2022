package com.yinglm.Tank2022v2;

import java.awt.*;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 12:28
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public class Wall extends AbstractGameObject {
    private int x,y,w,h;
    private Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        rect= new Rectangle(x,y,w,h);
    }

    public void paint(Graphics g){
        Color c= g.getColor();
        g.setColor(Color.gray);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }

    @Override
    public boolean isLive() {
        return true;
    }

    public Rectangle getRect() {
        return rect;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                ", rect=" + rect +
                '}';
    }
}
