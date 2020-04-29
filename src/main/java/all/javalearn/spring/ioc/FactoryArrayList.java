package all.javalearn.spring.ioc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.OrderComparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class FactoryArrayList<E extends MatchingBean<K>, K> extends ArrayList<E> implements FactoryList<E, K>,InitializingBean {

    private static final long serialVersionUID = 5705342394882249201L;

    public FactoryArrayList() {
        super();
    }
    
    public FactoryArrayList(int size) {
        super(size);
    }

    @Override
    public E getBean(K factor) {
        Iterator<E> itr = iterator();
        while(itr.hasNext()) {
            E beanMatch = itr.next();
            if(beanMatch.matching(factor)) {
                return beanMatch;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void afterPropertiesSet() throws Exception {
        if (!isEmpty()) {
            Object[] a = toArray();
            OrderComparator.sort(a);
            ListIterator i = listIterator();
            for (Object anA : a) {
                i.next();
                i.set(anA);
            }
        }
    }
       
}
