package all.javalearn.concurrent.sonthread;

/**
 * @Function:
 * @Author:shudb
 * @Date:2019/1/12 19:47
 **/
public class ThreadLocalProvider
{
    private static final ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void set(String value)
    {
        threadLocal.set(value);
    }

    public static String get()
    {
        return threadLocal.get();
    }

}
