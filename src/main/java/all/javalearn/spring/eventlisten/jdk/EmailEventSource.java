package all.javalearn.spring.eventlisten.jdk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created on 2020/7/16 9:50
 *
 * @author shudebao@limikeji.com
 */
public class EmailEventSource {
    // 监听器容器
    private Set<EmailListener> listener;

    public EmailEventSource() {
        this.listener = new HashSet<EmailListener>();
    }

    // 给事件源注册监听器
    public void addEmailListener(EmailListener cel) {
        this.listener.add(cel);
    }

    // 当事件发生时,通知注册在该事件源上的所有监听器做出相应的反应（调用回调方法）
    protected void notifies() {
        EmailListener cel = null;
        Iterator<EmailListener> iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            cel = iterator.next();
            cel.onObtain(new EmailEvent(this));
        }
    }

    /**
     * 模拟事件触发器，收到邮件时，触发事件。
     * @param content
     */
    public void obtainEmail(String content) {
        System.out.println(content);
        notifies();
    }
}
