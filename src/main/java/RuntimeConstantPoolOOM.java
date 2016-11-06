import java.util.ArrayList;
import java.util.List;

/**
 * Only use in java 1.6
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by Jesse on 6/11/16.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            list.add(String.valueOf(i).intern());
        }
    }
}
