package com.yinglm.Tank2022v2;

import java.awt.*;

/**
 * @Auther: yingliming
 * @Date: 2022/6/27 0027 - 06 - 27 - 12:44
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public abstract class AbstractGameObject {
    public abstract void paint(Graphics g);

    public abstract boolean isLive();
}
