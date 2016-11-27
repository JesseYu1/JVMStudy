/**
 * VM Args: -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:-HandlePromotionFailure has been disabled in JDK1.6 Update24
 * Created by Jesse on 27/11/16.
 */
public class TestHandlePromotion {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[3 * _1MB];
        allocation2 = new byte[3 * _1MB];
        allocation3 = new byte[3 * _1MB];
        allocation4 = new byte[3 * _1MB];
        allocation3 = null;
        allocation4 = null;
        allocation5 = new byte[3 * _1MB];
    }
}
