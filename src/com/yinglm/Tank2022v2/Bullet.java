package com.yinglm.Tank2022v2;

import java.awt.*;

public class Bullet extends AbstractGameObject {
    public static final int SPEED = 10;
    private int x, y;
    private Dir dir;
    private Group group;
    private boolean live = true;
    private int w=ResourceMgr.bulletU.getWidth();
    private int h=ResourceMgr.bulletU.getHeight();

    private Rectangle rect;

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect= new Rectangle(x,y,w,h);
    }

    /**
     * 以下测试代码自己加入
     * @return
     */

//    public Dir getDir() {
//        return dir;
//    }
//
//    public void setDir(Dir dir) {
//        this.dir = dir;
//    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void paint(Graphics g) {

        switch (dir) {
            case L:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case U:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case R:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case D:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;

        }
        move();
        rect.x=x;
        rect.y=y;

    }

    private void move() {
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case D:
                y += SPEED;
                break;


        }
        //update the rect
//        rect.x=x;
//        rect.y=y;

        boundsCheck();
    }

    public void collidesWithTank(Tank tank) {
        if(!this.isLive() || !tank.isLive()) return;
        if(this.group==tank.getGroup()) return;
       // Rectangle rect = new Rectangle(x, y, ResourceMgr.bulletU.getWidth(), ResourceMgr.bulletU.getHeight());
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(), ResourceMgr.goodTankU.getWidth(), ResourceMgr.goodTankU.getHeight());

        if(rect.intersects(rectTank)){
            this.die();
            tank.die();
        }
    }

    public Rectangle getRect(){
        return rect;
    }

    private void boundsCheck() {
        if (x < 0 || y < 30 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;

        }
    }

    public void die(){
        this.setLive(false);

    }

    @Override
    public String toString() {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", group=" + group +
                ", live=" + live +
                ", w=" + w +
                ", h=" + h +
                ", rect=" + rect +
                '}';
    }
}
