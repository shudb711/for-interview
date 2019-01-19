package all.javalearn.spring.cglibproxy;

/**
 * @Function:
 * @Author:shudb
 * @Date:2019/1/19 14:48
 **/
public class PersonServiceImpl implements IPersonService {
    public PersonServiceImpl() {
        System.out.println("PersonService构造");
    }
    //该方法不能被子类覆盖
    final public String getPerson(String code) {
        System.out.println("PersonService:getPerson>>"+code);
        return "";
    }

    public void setPerson() {
        System.out.println("PersonService:setPerson");
    }
}
