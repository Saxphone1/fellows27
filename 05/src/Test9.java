import java.util.Objects;

public class Test9 {
    public static void main(String[] args) {
        Student s = new Student(1,"zs",14);
        System.out.println(s);
        Student s1 = new Student(1,"zs",14);
        System.out.println(s.equals(s1));
    }
}

class Student{
    private int sid;
    private String name;
    private int age;
    public Student(int sid,String name,int age){
        this.sid = sid;
        this.name = name;
        this.age = age;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

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

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Student){
            Student s = (Student) obj;
            if(this.sid != s.sid){
                return false;
            }
            if(!this.name.equals(s.name)){
                return false;
            }
            if(this.age != s.age){
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//    public String toString(){
//        return "sid="+sid+",name="+name+",age="+age;
//    }
}
