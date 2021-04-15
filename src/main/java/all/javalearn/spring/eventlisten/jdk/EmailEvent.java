package all.javalearn.spring.eventlisten.jdk;

import java.util.EventObject;

/**
 * Created on 2020/7/16 9:43
 *
 * @author shudebao@limikeji.com
 */
public class EmailEvent extends EventObject {
    private Object source;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EmailEvent(Object source) {
        super(source);
        this.source = source;
    }
}
