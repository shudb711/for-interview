package all.javalearn.spring.ioc;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
    public Cat() {
        System.out.println("create cat.....");
    }

    @Override
    public boolean matching(String factor) {
        if ("cat".equals(factor)) {
            return true;
        }
        return false;
    }
}
