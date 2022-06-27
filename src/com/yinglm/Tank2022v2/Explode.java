package com.yinglm.Tank2022v2;

import java.awt.*;

public class Explode extends AbstractGameObject {

    private int x, y;
    private int width, height;
//	private Dir dir;
//	private Group group;
//	private boolean live = true;

//	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
//	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
//
//	private int x, y;

    //private boolean living = true;

    private int step = 0;
    private boolean live = true;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = ResourceMgr.explodes[0].getWidth();
        this.height = ResourceMgr.explodes[0].getHeight();

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void paint(Graphics g) {
    	if(!live) return;

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >=ResourceMgr.explodes.length)
            this.die();
//			TankFrame.INSTANCE.explodes.remove(this);


    }

    private void die() {
        this.live = false;
    }


}
