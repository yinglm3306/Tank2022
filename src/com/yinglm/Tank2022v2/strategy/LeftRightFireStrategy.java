package com.yinglm.Tank2022v2.strategy;

import com.yinglm.Tank2022v2.*;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 9:38
 * @Description: com.yinglm.Tank2022v2.strategy
 * @Version: 1.0
 **/
public class LeftRightFireStrategy implements FireStrategy {
    public void fire(Player p) {
        int bX = p.getX() + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
        int bY = p.getY() + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
        // TankFrame.INSTANCE.add(new Bullet(bX,bY,dir,group));
        Dir[] dirs = Dir.values();

            TankFrame.INSTANCE.add(new Bullet(bX, bY, Dir.L, p.getGroup()));
            TankFrame.INSTANCE.add(new Bullet(bX, bY, Dir.R, p.getGroup()));
    }

}
