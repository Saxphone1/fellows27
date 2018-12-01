public class Test7 {
    public static void main(String[] args) {

        Student s1 = new Student();
//        Student s2 = s1;
//        s2.setName("zss");
        System.out.println(s1.getName());

        try{
            Student s3 = (Student)s1.clone();
            s3.setName("s3");
            System.out.println(s1);
            System.out.println(s3);
        }catch (CloneNotSupportedException e){
            System.out.println("jjjjjjj");
        }

    }
}
