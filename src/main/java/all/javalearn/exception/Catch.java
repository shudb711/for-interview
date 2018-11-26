package all.javalearn.exception;

public class Catch
{
    public static void main(String[] args) {
        try
        {
            int i = 10/0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(111);
    }
}
