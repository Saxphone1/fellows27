public class Dog implements Comparable<Dog>{
    private String name;
    private int age;

    public Dog(){

    }
    public Dog(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Dog d){
//        if(this.age > d.age) return 1;
//        if(this.age < d.age) return -1;
//        return 0;
        return this.age - d.age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

