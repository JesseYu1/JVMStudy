/**
 * VM Args: -Xss2M
 * Created by Jesse on 6/11/16.
 */
public class StackOOM {
    public static void main(String[] args) throws Throwable {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    while (true) {
                    }
                }
            });

            thread.start();
        }
    }
}
