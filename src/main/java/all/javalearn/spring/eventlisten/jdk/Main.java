package all.javalearn.spring.eventlisten.jdk;

/**
 * Created on 2020/7/16 9:58
 *
 * @author shudebao@limikeji.com
 */
public class Main {
    public static void main(String[] args) {
        EmailEventSource emailEventSource = new EmailEventSource();
        // 注册监听器
        emailEventSource.addEmailListener(new EmailListener(){
            @Override
            public void onObtain(EmailEvent emailEvent) {
                Object source = emailEvent.getSource();
                if (source instanceof EmailEventSource) {
                    System.out.println("reply for obtained email..");
                }
            }
        });
        // 触发事件
        emailEventSource.obtainEmail("obtain email from Tom..");
        emailEventSource.obtainEmail("obtain email from Jerry..");
    }
}
