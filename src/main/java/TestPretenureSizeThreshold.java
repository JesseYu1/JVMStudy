/**
 * VM Args: -XX:+UseConcMarkSweepGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold=3145728
 * Created by Jesse on 27/11/16.
 *
 * Output:
 * Heap
 * par new generation   total 9216K, used 1327K [0x00000007f9a00000, 0x00000007fa400000, 0x00000007fa400000)
 * eden space 8192K,  16% used [0x00000007f9a00000, 0x00000007f9b4be68, 0x00000007fa200000)
 * from space 1024K,   0% used [0x00000007fa200000, 0x00000007fa200000, 0x00000007fa300000)
 * to   space 1024K,   0% used [0x00000007fa300000, 0x00000007fa300000, 0x00000007fa400000)
 * concurrent mark-sweep generation total 10240K, used 4096K [0x00000007fa400000, 0x00000007fae00000, 0x00000007fae00000)
 * concurrent-mark-sweep perm gen total 21248K, used 2987K [0x00000007fae00000, 0x00000007fc2c0000, 0x0000000800000000)
 */
public class TestPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB]; // directly into old generation
    }
}
