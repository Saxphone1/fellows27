public class Test9 {
    public static void main(String[] args) {
        Teacher t =  new Teacher(1,"张老师",60);
        Student s1 = new Student(1,"小明",t);
        Student s2 = new Student(2,"小明2",t);
        Student s3 = new Student(3,"小明3",t);
        Student s4 = new Student(4,"小明4",t);
        t.getStudentList().add(s1);
        t.getStudentList().add(s2);
        t.getStudentList().add(s3);
        t.getStudentList().add(s4);

        System.out.println(t);

    }
}
