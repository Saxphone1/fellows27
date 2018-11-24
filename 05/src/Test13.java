public class Test13 {
    public static void main(String[] args) {
        Outer o = new Outer();
//        Outer.Inner i = o.new Inner();
//        i.print();
        o.outerPrint();

        System.out.println("---------------------");
        o.say(20);
        Outer.SInner os = new Outer.SInner();
        os.print2();
        o.pring3();
        o.print4();
        o.print5(new IHyd(){
            public void study() {
                System.out.println("..上午不来上课....");
            }
        });
    }
}
class Outer{
    static class SInner{
        public void print2(){
            System.out.println("静态内部类");
        }
    }
    public void outerPrint(){
        Inner i = new Inner();
        i.print();
    }

    private class Inner{
        public void print(){
            System.out.println("成员内部类");
        }
    }
    public void say(int a){
        int i = 10;
        class Inner1{
            public void print2(){
                System.out.println("方法内部类"+ i);
            }
        }
        Inner1 i1 = new Inner1();
        i1.print2();
    }

    public void pring3(){
        Animal1 cat = new Animal1(){
            public void speak(){
                System.out.println("我是一只猫,继承式内部类");
            }
        };

        cat.speak();
    }
    public void print4(){
        IHyd hyd = new IHyd(){
            public void study(){
                System.out.println("hyd是一只猫,接口式内部类");
            }
        };
        hyd.study();
    }

    public void print5(IHyd hyd){
        hyd.study();
    }
}

abstract class Animal1{
    public abstract void speak();
}

interface IHyd{
    public void study();
}




