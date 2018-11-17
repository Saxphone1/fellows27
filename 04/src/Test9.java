/**
 * 单向引用
 * 双向引用
 * */
public class Test9 {
    public static void main(String[] args) {

        Hero liubei = new Hero();
        liubei.setName("小备");
        liubei.setAge(751);
        Weapon w1 = new Weapon();
        w1.setName("双股剑");
        w1.setGrade(3);
        liubei.setW(w1);

        w1.setH(liubei);
        System.out.println("我叫"+liubei.getName()+",我用"+liubei.getW().getName());



    }
}
class Hero{
    private String name;
    private int age;
    private Weapon w;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Weapon getW() {
        return w;
    }

    public void setW(Weapon w) {
        this.w = w;
    }
}

class Weapon{
    private String name;
    private int grade;
    private Hero h;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Hero getH() {
        return h;
    }

    public void setH(Hero h) {
        this.h = h;
    }
}
