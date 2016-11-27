/**
 * VM Args: -XX:+UseConcMarkSweepGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * Created by Jesse on 27/11/16.
 *
 * Output:
 * [GC[ParNew: 7307K->355K(9216K), 0.0056560 secs] 7307K->6501K(19456K), 0.0056960 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
 * Heap
 * par new generation   total 9216K, used 4617K [0x00000007f9a00000, 0x00000007fa400000, 0x00000007fa400000)
 * eden space 8192K,  52% used [0x00000007f9a00000, 0x00000007f9e29788, 0x00000007fa200000)
 * from space 1024K,  34% used [0x00000007fa300000, 0x00000007fa358f70, 0x00000007fa400000)
 * to   space 1024K,   0% used [0x00000007fa200000, 0x00000007fa200000, 0x00000007fa300000)
 * concurrent mark-sweep generation total 10240K, used 6146K [0x00000007fa400000, 0x00000007fae00000, 0x00000007fae00000)
 * concurrent-mark-sweep perm gen total 21248K, used 2987K [0x00000007fae00000, 0x00000007fc2c0000, 0x0000000800000000)
 */
public class Allocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // Minor GC
    }
}
