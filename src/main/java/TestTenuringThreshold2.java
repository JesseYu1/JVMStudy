/**
 * VM Args: -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 * Created by Jesse on 27/11/16.
 *
 * In survivor space, the size of the same age objects is larger than survivor space,
 * these objects and older objects will be moved into old generation.
 */
public class TestTenuringThreshold2 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB]; // first gc
        allocation4 = null;
        allocation4 = new byte[4 * _1MB]; // second gc
    }
}
