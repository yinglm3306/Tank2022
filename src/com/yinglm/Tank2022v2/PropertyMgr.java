package com.yinglm.Tank2022v2;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: yingliming
 * @Date: 2022/6/26 0026 - 06 - 26 - 17:26
 * @Description: com.yinglm.Tank2022v2
 * @Version: 1.0
 **/
public class PropertyMgr {
    private static Properties props;

    static {
        try {
            props= new Properties();
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(String key){
        return (String) props.get(key);

    }
}
