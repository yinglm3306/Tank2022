package com.yinglm.Tank2022v2.chainofresponsibility;

import com.yinglm.Tank2022v2.AbstractGameObject;
import com.yinglm.Tank2022v2.Bullet;
import com.yinglm.Tank2022v2.Wall;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 15:44
 * @Description: com.yinglm.Tank2022v2.chainofresponsibility
 * @Version: 1.0
 **/
public class BulletWallCollider implements Collider {
    @Override
    public void collide(AbstractGameObject go1, AbstractGameObject go2) {
        if(go1 instanceof Bullet && go2 instanceof Wall){

//            System.out.println(go1);
//            System.out.println(go2);

            Bullet b= (Bullet)go1;
            Wall w= (Wall)go2;
            if(b.isLive()){
                if(b.getRect().intersects(w.getRect())){
                    b.die();
                }
            }

        }else if(go1 instanceof Wall && go2 instanceof Bullet){
            collide(go2,go1);
        }
    }
}
