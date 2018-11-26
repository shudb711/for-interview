package all.javalearn.spring.aop.action.sub;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/11 9:40
 **/
@RestController
public class SubAopController
{
    @RequestMapping(value = "/testSubAop",method = RequestMethod.POST)
    public void testSubAop()
    {
        System.out.println("========test subaop========");
    }
}
