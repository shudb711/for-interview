package all.javalearn.spring.ioc;

import org.springframework.stereotype.Component;

@Component
public class Dog  implements Animal  {
    public Dog() {
        System.out.println("create dog.....");
    }

    @Override
    public boolean matching(String factor) {
        if ("dog".equals(factor)) {
            return true;
        }
        return false;
    }
}
