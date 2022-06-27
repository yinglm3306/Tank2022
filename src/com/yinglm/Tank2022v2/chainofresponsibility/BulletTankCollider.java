package com.yinglm.Tank2022v2.chainofresponsibility;

import com.yinglm.Tank2022v2.AbstractGameObject;
import com.yinglm.Tank2022v2.Bullet;
import com.yinglm.Tank2022v2.Tank;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 15:17
 * @Description: com.yinglm.Tank2022v2.chainofresponsibility
 * @Version: 1.0
 **/
public class BulletTankCollider implements Collider {
    @Override
    public void collide(AbstractGameObject go1, AbstractGameObject go2) {
        if(go1 instanceof Bullet && go2 instanceof Tank){
            Bullet b= (Bullet) go1;
            Tank t=(Tank) go2;
            b.collidesWithTank(t);
        } else if(go1 instanceof Tank && go2 instanceof Bullet){

            collide(go2,go1);
        }
    }
}
