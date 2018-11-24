public class Test8 {
    public static void main(String[] args) {
        ISave is = new NetSave();
        UserService bs = new UserService();
        bs.setIsave(is);
        bs.save("user");
//        bs.save("user");
    }
}
abstract class ISave{
    public abstract void save(String data);
}

class FileSave extends ISave{
    public void save(String data){
        System.out.println("保存到文件中"+data);
    }
}

class NetSave extends ISave{
    public void save(String data){
        System.out.println("保存到网络中"+data);
    }
}

abstract class BaseService{
    public ISave isave;
    public void setIsave(ISave isave){
        this.isave = isave;
    }
    public void save(String data) {
        isave.save(data);
    }
}
class UserService extends BaseService{

}

class StudentService extends BaseService{

}
