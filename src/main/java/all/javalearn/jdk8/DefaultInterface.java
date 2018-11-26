package all.javalearn.jdk8;

public interface DefaultInterface {
    default public void doc()
    {
        System.out.println("process in interface!");
    }
}
