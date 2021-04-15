package all.javalearn.spring.eventlisten.jdk;

import java.util.EventListener;

/**
 * Created on 2020/7/16 9:44
 *
 * @author shudebao@limikeji.com
 */
public interface EmailListener extends EventListener {
    public void onObtain(EmailEvent emailEvent);
}
