import com.weichuang.Dog;
import org.junit.Test;

import java.lang.reflect.*;

public class Test2 {
    @Test
    public void test4(){
        Class dogClass = Dog.class;
        Dog dog = new Dog("小白",2,"red");
        //所有公共方法，包括继承的
//        Method[] methods = dogClass.getMethods();
//        for (int i = 0; i <methods.length ; i++) {
//            System.out.println(methods[i].getName());
//        }

        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i <declaredMethods.length ; i++) {
            if(declaredMethods[i].getName().equals("set")){
                // 去掉修饰符
                declaredMethods[i].setAccessible(true);
                try {
                    declaredMethods[i].invoke(dog);
//                    System.out.println(s);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test3(){
        Class dogClass = Dog.class;
        Field[] fields = dogClass.getFields();
        for (int i = 0; i <fields.length ; i++) {
            System.out.println(fields[i].getName());
        }

        Field[] declaredFields = dogClass.getDeclaredFields();
        for (int i = 0; i <declaredFields.length ; i++) {
            System.out.println(declaredFields[i].getName());
            System.out.println(declaredFields[i].getModifiers());
        }

    }

    @Test
    public void test2(){
        Class dogClass = Dog.class;

        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());


    }

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

            try {
                //调用有参构造进行实例化
                Constructor constructor = dogClass.getConstructor(String.class, int.class, String.class);
                Dog o = (Dog)constructor.newInstance("小黑", 3, "green");
                System.out.println(o);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
