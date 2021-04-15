package all.javalearn.spring.aop.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/10 18:03
 **/

@RestController
public class AopController implements AopControllerApi {


    public void testAop()
    {
        System.out.println("===test aop=====");

        /**
         此种方式调用testInnerAop(),打印结方果如下所示，这是因为被调用的是未被代理的法(原始方法)
         ===========before================
         ===test aop=====
         ===test inner aop=====
         ===========after================
         */
//        testInnerAop();


        /*
        此种方式调用testInnerAop(),打印结果如下所示，这是因为被调用的是被代理后的方法
          ===========before================
          ===test aop=====
          ===========before================
          ===test inner aop=====
          ===========after================
          ===========after================
        * */
//        applicationContext.getBean(AopController.class).testInnerAop();
    }

    @RequestMapping(value = "/testInnerAop",method = RequestMethod.POST)
    public void testInnerAop()
    {
        System.out.println("===test inner aop=====");
    }

}
