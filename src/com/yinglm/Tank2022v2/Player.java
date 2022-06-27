package com.yinglm.Tank2022v2;

import com.yinglm.Tank2022v2.strategy.DefaultFireStrategy;
import com.yinglm.Tank2022v2.strategy.FireStrategy;
import com.yinglm.Tank2022v2.strategy.FourFireStrategy;
import com.yinglm.Tank2022v2.strategy.LeftRightFireStrategy;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Auther: yingliming
 * @Date: 2022/6/24 0024 - 06 - 24 - 19:21
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public class Player {
    private int x,y;
    private Dir dir;
    private boolean bL,bR,bU,bD;
    private static final int SPEED=5;
    private boolean moving = false;
    private Group group;
    private boolean live=true;



    public Player(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir=dir;
        this.group=group;

    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
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
        if(!this.isLive()) return;
            switch (dir){
                case L:
                    g.drawImage(ResourceMgr.goodTankL,x,y,null);break;
                case U:
                    g.drawImage(ResourceMgr.goodTankU,x,y,null);break;
                case R:
                    g.drawImage(ResourceMgr.goodTankR,x,y,null);break;
                case D:
                    g.drawImage(ResourceMgr.goodTankD,x,y,null);break;
            }

        move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_LEFT : bL=true; break;
            case KeyEvent.VK_UP : bU=true; break;
            case KeyEvent.VK_RIGHT : bR=true; break;
            case KeyEvent.VK_DOWN : bD=true; break;

        }
        setMainDir();

    }

    private void setMainDir() {
        if(!bL&&!bR&&!bU&&!bD)   moving=false;

        else
        {
            moving=true;
            if(bL&&!bR&&!bU&&!bD)   dir=Dir.L;
            if(!bL&&bR&&!bU&&!bD)   dir=Dir.R;
            if(!bL&&!bR&&bU&&!bD)   dir=Dir.U;
            if(!bL&&!bR&&!bU&&bD)   dir=Dir.D;
        }

    }

    private void move() {
        if(!moving) return;
        switch (dir){
            case L:  x-=SPEED; break;
            case U:  y-=SPEED; break;
            case R:  x+=SPEED; break;
            case D:  y+=SPEED; break;


        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_LEFT : bL=false; break;
            case KeyEvent.VK_UP : bU=false; break;
            case KeyEvent.VK_RIGHT : bR=false; break;
            case KeyEvent.VK_DOWN : bD=false; break;
            case KeyEvent.VK_CONTROL : fire(); break;


        }
        setMainDir();


    }

    private void fire() {

        FireStrategy strategy=new LeftRightFireStrategy();
        strategy.fire(this);
//        int bX= x+ ResourceMgr.goodTankU.getWidth()/2- ResourceMgr.bulletU.getWidth()/2;
//        int bY= y+ ResourceMgr.goodTankU.getHeight()/2- ResourceMgr.bulletU.getHeight()/2;
//       // TankFrame.INSTANCE.add(new Bullet(bX,bY,dir,group));
//        Dir[] dirs= Dir.values();
//        for (Dir d:dirs)
//            TankFrame.INSTANCE.add(new Bullet(bX,bY,d,group));

    }

    public void die() {
        this.setLive(false);
    }
}
