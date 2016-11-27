/**
 * VM Args: -XX:+UseSerialGC -Xms22m -Xmx22m -Xmn12m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * Created by Jesse on 27/11/16.
 */
public class TestTenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[5 * _1MB]; // first gc
        allocation3 = null;
        allocation3 = new byte[5 * _1MB]; // second gc
    }
}
