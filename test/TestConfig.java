import com.yinglm.Tank2022v2.PropertyMgr;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: yingliming
 * @Date: 2022/6/26 0026 - 06 - 26 - 17:14
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 **/
public class TestConfig {
    public static void main(String[] args) {
//        Properties props= new Properties();
//        try {
//            props.load(TestConfig.class.getClassLoader().getResourceAsStream("config"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//       String str=(String)props.get("initTankCount");
//        System.out.println(str);

        System.out.println(PropertyMgr.get("initTankCount"));
    }



}
