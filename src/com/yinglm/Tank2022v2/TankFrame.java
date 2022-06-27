package com.yinglm.Tank2022v2;

import com.yinglm.Tank2022v2.chainofresponsibility.BulletTankCollider;
import com.yinglm.Tank2022v2.chainofresponsibility.BulletWallCollider;
import com.yinglm.Tank2022v2.chainofresponsibility.Collider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();

    private Player myTank;

    List<Collider> colliders;
    //private Tank enemy;

//    Explode e= new Explode(150,150);

//    private List<Explode> explodes;
//    private List<Tank> tanks;
//    private List<Bullet> bullets;
    List<AbstractGameObject> objects;
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;


    private TankFrame() {
        this.setTitle("tank war");
        this.setLocation(200, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);

        this.addKeyListener(new TankKeyListener());  //Observer

        initGameObjects();

        initColliders();


    }

    private void initColliders() {
        colliders = new ArrayList<>();
        String[] collidersNames= PropertyMgr.get("colliders").split(",");
        for (String name:collidersNames){

            try {
                Class clazz = Class.forName("com.yinglm.Tank2022v2.chainofresponsibility." + name);
              Collider c=  (Collider)(clazz.getConstructor().newInstance());
              colliders.add(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initGameObjects() {
        myTank = new Player(100, 100, Dir.R, Group.GOOD);
        //enemy  = new Tank(200,200,Dir.D,Group.BAD);

        objects= new ArrayList<>();

        int tankCount= Integer.parseInt(PropertyMgr.get("initTankCount"));

        for (int i = 0; i < tankCount; i++) {
            this.add(new Tank(100 + 50 * i, 200, Dir.D, Group.BAD));
        }
        this.add(new Wall(300,200,400,50));
    }

    public void add(AbstractGameObject go){

        objects.add(go);

    }

//    Collider collider= new BulletTankCollider();
//    Collider collider2= new BulletWallCollider();
//    List<Collider> colliders= Arrays.asList(new BulletTankCollider(),new BulletWallCollider());



    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("objects: " + objects.size(), 10, 50);
//        g.drawString("enemies: " + tanks.size(), 10, 70);
//        g.drawString("explodes: " + explodes.size(), 10, 90);
        g.setColor(c);

        myTank.paint(g);
        for (int i=0;i<objects.size();i++){

            if(!objects.get(i).isLive()) {
                objects.remove(i);
                break;
            }

            AbstractGameObject go1= objects.get(i);
            for (int j=0;j<objects.size();j++){
                AbstractGameObject go2=objects.get(j);
//                collider.collide(go1,go2);
//                collider2.collide(go1,go2);
                for (Collider collider:colliders){

                    collider.collide(go1,go2);
                }
            }

            if(objects.get(i).isLive()){
                objects.get(i).paint(g);
            }

        }

//        for (int i = 0; i < tanks.size(); i++) {
//            if (!tanks.get(i).isLive()) {
//                tanks.remove(i);
//            } else {
//                tanks.get(i).paint(g);
//            }
//
//        }
//        //enemy.paint(g);
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collidesWithTank(tanks.get(j));
//            }
//
//
//            if (!bullets.get(i).isLive()) {
//                bullets.remove(i);
//            } else {
//                bullets.get(i).paint(g);
//            }
//        }
//
//        for (int i = 0; i < explodes.size(); i++) {
//            if (!explodes.get(i).isLive()) {
//                explodes.remove(i);
//            } else {
//                explodes.get(i).paint(g);
//            }
//
//        }


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
