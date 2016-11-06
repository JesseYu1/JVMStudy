/**
 * VM Args: -Xss160k
 * Created by Jesse on 6/11/16.
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println(stackSOF.stackLength);
            throw e;
        }
    }
}
