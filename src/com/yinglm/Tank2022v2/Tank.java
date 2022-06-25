package com.yinglm.Tank2022v2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther: yingliming
 * @Date: 2022/6/24 0024 - 06 - 24 - 19:21
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public class Tank {
    private int x,y;
    private Dir dir;
    private boolean bL,bR,bU,bD;
    private static final int SPEED=5;
    private boolean moving = false;
    private Group group;

    TankFrame tf;

    public Tank(int x, int y,Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir=dir;
        this.group=group;
        this.tf=tf;
    }


    public void paint(Graphics g) {
        //g.fillRect(x,y,50,50);
        if(this.group==Group.GOOD){
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
        }

        if(this.group==Group.BAD){
            switch (dir){
                case L:
                    g.drawImage(ResourceMgr.badTankL,x,y,null);break;
                case U:
                    g.drawImage(ResourceMgr.badTankU,x,y,null);break;
                case R:
                    g.drawImage(ResourceMgr.badTankR,x,y,null);break;
                case D:
                    g.drawImage(ResourceMgr.badTankD,x,y,null);break;

            }
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
        tf.add(new Bullet(x,y,dir,group));

    }
}
