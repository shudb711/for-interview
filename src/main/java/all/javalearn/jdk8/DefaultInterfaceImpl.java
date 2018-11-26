package all.javalearn.jdk8;

public class DefaultInterfaceImpl implements DefaultInterface {

    public void doc() {
        System.out.println("process in class!");
    }

    public static void main(String[] args) {
        DefaultInterface defaultInterface = new DefaultInterfaceImpl();
        defaultInterface.doc();
    }
}
