import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class Test7 {
    public static void main(String[] args) {
        Cat c = new Cat(1,1,"1");
        Optional<Cat> o = Optional.ofNullable(c);
        System.out.println(getC(o));
    }

    public static Cat getC(Optional<Cat> c){

        return c.orElse(null);
    }
}
