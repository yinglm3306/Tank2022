package com.yinglm.Tank2022v2.strategy;

import com.yinglm.Tank2022v2.*;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 9:18
 * @Description: com.yinglm.Tank2022v2.strategy
 * @Version: 1.0
 **/
public class DefaultFireStrategy implements FireStrategy {


    @Override
    public void fire(Player p) {

        int bX = p.getX() + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
        int bY = p.getY() + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
        // TankFrame.INSTANCE.add(new Bullet(bX,bY,dir,group));
//        Dir[] dirs= Dir.values();
//        for (Dir d:dirs)
        TankFrame.INSTANCE.add(new Bullet(bX, bY, p.getDir(), p.getGroup()));

    }
}
