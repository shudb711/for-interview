package all.javalearn.spring.ioc;//package all.javalearn.spring.ioc;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.propertyeditors.CustomCollectionEditor;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//
//public class FactoryListEditor extends CustomCollectionEditor {
//
//    public FactoryListEditor() {
//        super(FactoryArrayList.class);
//        this.addPropertyChangeListener(new InitializingBeanListener());
//    }
//
//    private class InitializingBeanListener implements PropertyChangeListener {
//
//        @Override
//        public void propertyChange(PropertyChangeEvent evt) {
//            Object value = ((FactoryListEditor) evt.getSource()).getValue();
//            if (value instanceof InitializingBean) {
//                try {
//                    ((InitializingBean) value).afterPropertiesSet();
//                } catch (Exception e) {
//                    throw new RuntimeException("初始化bean afterPropertiesSet异常", e);
//                }
//
//                new RedisTemplate<>().opsForHash().
//            }
//        }
//
//    }
//}
