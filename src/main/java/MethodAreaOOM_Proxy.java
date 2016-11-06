import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * This is not work in java 1.7
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by Jesse on 6/11/16.
 */
public class MethodAreaOOM_Proxy {
    interface BookFacade {
        void addBook();
    }

    static class BookFacadeImpl implements BookFacade {
        @Override
        public void addBook() {
            System.out.println("添加图书");
        }
    }

    static class BookFacadeProxy implements InvocationHandler {
        BookFacade bookFacade;

        public BookFacade proxyBookFacade(BookFacade bookFacade) {
            this.bookFacade = bookFacade;
            return (BookFacade) Proxy.newProxyInstance(bookFacade.getClass().getClassLoader(),
                    bookFacade.getClass().getInterfaces(),
                    this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            System.out.println("proxy start, method: " + method.getName());
            result = method.invoke(bookFacade, args);
            System.out.println("proxy end, method: " + method.getName());
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        List<BookFacade> list = new ArrayList<>();
        while (true) {
            BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
            bookFacadeProxy.proxyBookFacade(new BookFacadeImpl());
        }
    }
}
