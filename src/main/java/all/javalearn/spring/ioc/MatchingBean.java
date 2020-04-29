package all.javalearn.spring.ioc;

/**
 * bean匹配
 * @author xiehui
 *
 */
public interface MatchingBean<T> {

    boolean matching(T factor);
    
}
