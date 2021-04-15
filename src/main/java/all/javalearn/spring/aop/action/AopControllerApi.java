package all.javalearn.spring.aop.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AopControllerApi {

    @RequestMapping(value = "/testAop",method = RequestMethod.POST)
    public void testAop();
}
