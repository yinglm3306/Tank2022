package com.yinglm.Tank2022v2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Auther: yingliming
 * @Date: 2022/6/24 0024 - 06 - 24 - 19:21
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public class Tank {
    private int x, y;
    private Dir dir;
    private boolean bL, bR, bU, bD;
    private static final int SPEED = 5;
    private boolean moving = true;
    private Group group;
    private boolean live = true;


    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
        //g.fillRect(x,y,50,50);
        if (!this.isLive()) return;

        switch (dir) {
            case L:
                g.drawImage(ResourceMgr.badTankL, x, y, null);
                break;
            case U:
                g.drawImage(ResourceMgr.badTankU, x, y, null);
                break;
            case R:
                g.drawImage(ResourceMgr.badTankR, x, y, null);
                break;
            case D:
                g.drawImage(ResourceMgr.badTankD, x, y, null);
                break;

        }

        move();
    }


    private void setMainDir() {
        if (!bL && !bR && !bU && !bD) moving = false;

        else {
            moving = true;
            if (bL && !bR && !bU && !bD) dir = Dir.L;
            if (!bL && bR && !bU && !bD) dir = Dir.R;
            if (!bL && !bR && bU && !bD) dir = Dir.U;
            if (!bL && !bR && !bU && bD) dir = Dir.D;
        }

    }

    private void move() {
        if (!moving) return;
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
        randomDir();
        if (r.nextInt(100) > 90) fire();

    }

    private Random r = new Random();


    private void randomDir() {
        if (r.nextInt(100) > 90)
            this.dir = Dir.randomDir();

    }


    private void fire() {

        int bX = x + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
        int bY = y + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
        TankFrame.INSTANCE.add(new Bullet(bX, bY, dir, group));

    }

    public void die() {
        this.setLive(false);
    }
}
