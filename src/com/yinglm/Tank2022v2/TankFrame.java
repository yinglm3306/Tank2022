package com.yinglm.Tank2022v2;

import java.awt.*;

public class TankFrame extends Frame {
    private int x =100;

    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(200,100);
        this.setSize(800,600);

        this.addKeyListener();  //Observer

    }

    @Override
    public void paint(Graphics g) {

        g.fillRect(x,100,50,50);
        x++;
//        System.out.println("paint");  此方法画图时自动调用

    }
}
