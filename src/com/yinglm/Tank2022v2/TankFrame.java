package com.yinglm.Tank2022v2;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    public static final TankFrame INSTANCE= new TankFrame();

    private Player myTank;
    private Tank enemy;
    private List<Bullet> bullets;
    public static final  int GAME_WIDTH=800,GAME_HEIGHT=600;


    private TankFrame(){
        this.setTitle("tank war");
        this.setLocation(200,100);
        this.setSize(GAME_WIDTH,GAME_HEIGHT);

        this.addKeyListener(new TankKeyListener());  //Observer

        myTank = new Player(100,100,Dir.R,Group.GOOD);
        enemy  = new Tank(200,200,Dir.D,Group.BAD);
        bullets = new ArrayList<>();
    }

    public void add(Bullet bullet){
        this.bullets.add(bullet);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullets: "+bullets.size(),10,50);
       g.setColor(c);
        myTank.paint(g);
        enemy.paint(g);
        for(int i=0;i<bullets.size(); i++){
            bullets.get(i).collidesWithTank(enemy);

            if(!bullets.get(i).isLive()){ bullets.remove(i);}
            else {
                bullets.get(i).paint(g);}
        }



    }

    /**
     * 以下为游戏中解决闪屏问题
     */
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
