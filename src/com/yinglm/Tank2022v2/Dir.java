package com.yinglm.Tank2022v2;

import java.util.Random;

/**
 * @Auther: yingliming
 * @Date: 2022/6/24 0024 - 06 - 24 - 19:50
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public enum Dir {
    L,U,R,D;
    private static Random r= new Random();

    public static Dir randomDir(){
        return values()[r.nextInt(values().length)];
    }


}
