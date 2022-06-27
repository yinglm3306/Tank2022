package com.yinglm.Tank2022v2.chainofresponsibility;

import com.yinglm.Tank2022v2.AbstractGameObject;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 15:15
 * @Description: com.yinglm.Tank2022v2.chainofresponsibility
 * @Version: 1.0
 **/
public interface Collider {
    public void collide(AbstractGameObject go1, AbstractGameObject go2);
}
