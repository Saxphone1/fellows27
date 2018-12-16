import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Test2 {

    @Test
    public void test1(){
        Dog dog = new Dog("小白",2,"red");
        Class dogClass = dog.getClass();

        try {
            //调用无参构造进行实例化
            Dog d = (Dog)dogClass.newInstance();
            System.out.println(d);

            Constructor[] constructors =
                    dogClass.getConstructors();
            for (int i = 0; i <constructors.length ; i++) {
                System.out.println(constructors[i].getName());
                System.out.println(constructors[i].getParameterCount());
                int m = constructors[i].getModifiers();
                System.out.println(Modifier.toString(m) + " "+ constructors[i].getName() );
            }



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
