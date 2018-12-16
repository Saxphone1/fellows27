import com.weichuang.Dog;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class Test3 {
    @Test
    public void test(){
        String name = "xiaoxiao";
        String age = "3";
        String color = "pink";
        String type = "二哈";

        Dog d = new Dog();
        try {
            BeanUtils.setProperty(d,"name",name);
            BeanUtils.setProperty(d,"age",age);
            BeanUtils.setProperty(d,"color",color);
            BeanUtils.setProperty(d,"type",type);

            System.out.println(d);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }




    }
}
