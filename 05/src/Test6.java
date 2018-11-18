public class Test6 {
    public static void main(String[] args) {
        Chicken hc = new HomeChicken("咯咯哒");
//        hc.eat();
        Chicken yc = new YeChicken("小野鸡");
        Chicken jjc = new JianjiaoChicken("尖椒鸡");
//        yc.eat();
        speak(jjc);
    }
    public static void speak(Chicken c){
//        JianjiaoChicken jc = (JianjiaoChicken)c;
        c.eat();
        if(c instanceof JianjiaoChicken){
            JianjiaoChicken jc = (JianjiaoChicken)c;
            jc.song();
        }
    }
}
abstract class Chicken{
    protected String name;
    public Chicken(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void eat();
}

class HomeChicken extends Chicken{
    public HomeChicken(String name){
        super(name);
    }
    public void eat(){
        System.out.println("我叫"+this.name+",我吃小米");
    }
}
class YeChicken extends Chicken{
    public YeChicken(String name){
        super(name);
    }
    public void eat(){
        System.out.println("我叫"+this.name+",我吃虫子");
    }
}
class JianjiaoChicken extends Chicken{
    public JianjiaoChicken(String name){
        super(name);
    }
    public void eat(){
        System.out.println("我叫"+this.name+",我不吃饭");
    }
    public void song(){
        System.out.println("gogogogo");
    }
}

