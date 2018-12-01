import java.io.IOException;
import java.util.Arrays;

public class Test8 {
    public static void main(String[] args) {
        System.err.print("错误");

        int[] a1 = {1,2,3,4,5,6,7};
        int[] a2 = new int[a1.length];
        System.arraycopy(a1,2,a2,1,5);
        System.out.println(Arrays.toString(a2));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.name"));

        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量：" + rt.availableProcessors()+" 个");
        System.out.println("Jvm总内存数 ："+ rt.totalMemory()+" byte");
        System.out.println("Jvm空闲内存数： "+ rt.freeMemory()+" byte");
        System.out.println("Jvm可用最大内存数： "+ rt.maxMemory()+" byte");

            //在单独的进程中执行指定的字符串命令。
        try{
            rt.exec("notepad");
        }catch (IOException e){
            System.out.println();
        }



    }
}
