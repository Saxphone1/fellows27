public class Test7 {
    public static void main(String[] args) {
         BaseManager bm = new TeacherManager();
         bm.action("sss","add");
    }
}
abstract class BaseManager{
    public void action(String name,String method){
        if("admin".equals(name)){
            execute(method);
//            aa();
//            bb();
        }else{
            System.out.println("没有权限做此操作");
        }
    }
    public abstract void execute(String method);
//    public void aa(){
//        System.out.println("aaaaa....");
//    }
//    public abstract void bb();

}
class UserManager extends BaseManager{
    public void execute(String method){
        if("add".equals(method)){
            System.out.println("做添加操作。。。。");
        }else if("find".equals(method)){
            System.out.println("做查询操作。。。。");
        }
    }
}
class TeacherManager extends BaseManager{
    public void execute(String method){

    }
}
