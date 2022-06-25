package com.yinglm.Tank2022v2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    private Tank myTank;
    private Tank enemy;
    public static final  int GAME_WIDTH=800;
    public static final  int GAME_HEIGHT=600;


    public TankFrame(){
        this.setTitle("tank war");
        this.setLocation(200,100);
        this.setSize(GAME_WIDTH,GAME_HEIGHT);

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

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
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
