import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by Jesse on 6/11/16.
 */
public class MethodAreaOOM {
    public static void main(String[] args) {
        try {
            int i = 0;
            while (true) {
                FileOutputStream fos = null;
                String fileName = "OOMObject" + i + ".java";
                try {
                    String content = "public class OOMObject" + i + " {}";
                    fos = new FileOutputStream(fileName);
                    fos.write(content.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fos.close();
                    } catch (Exception e) {
                    }
                }

                JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
                javaCompiler.run(null, null, null, fileName);
                MethodAreaOOM.class.getClassLoader().loadClass("OOMObject" + i);

                File file = new File(fileName);
                file.delete();
                file = new File("OOMObject" + i + ".class");
                file.delete();
                i++;
            }
        } catch (Throwable e) {
            System.out.println(e);
        }
    }
}
