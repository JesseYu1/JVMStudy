import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20m -XX:MaxDirectMemorySize=10M
 * MaxDirectMemorySize默认64M
 * http://www.docjar.com/html/api/sun/misc/VM.java.html
 * Created by Jesse on 13/11/16.
 */
public class DirectMemoryOOM {
    private static final int _5MB = 1024 * 1024 * 5;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            /**
             * 跳过了DirectByteBuffer, 直接向计算机申请内存, MaxDirectMemorySize不起作用
             */
            unsafe.allocateMemory(_5MB);
        }
    }
}
