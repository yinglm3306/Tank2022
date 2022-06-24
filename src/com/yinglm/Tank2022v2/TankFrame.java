package com.yinglm.Tank2022v2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    private Tank myTank;
    private Tank enemy;


    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(200,100);
        this.setSize(800,600);

        this.addKeyListener(new TankKeyListener());  //Observer

        myTank = new Tank(100,100,Dir.R);
        enemy  = new Tank(200,200,Dir.D);
    }

    @Override
    public void paint(Graphics g) {

        myTank.paint(g);
        enemy.paint(g);

      //  x++;
//        System.out.println("paint");  此方法画图时自动调用

    }

    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            myTank.keyPressed(e);


        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);

        }
    }
}
