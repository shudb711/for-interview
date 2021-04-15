package all.javalearn.mq.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2021/2/5 10:56
 *
 * @author shudebao@limikeji.com
 */
public class TransactionProducerTest {
    public static void main(String[] args) throws Exception {
        TransactionMQProducer transactionMQProducer = new TransactionMQProducer("transactionProducerGroup");
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        transactionMQProducer.setExecutorService(executorService);

        TransactionListener transactionListener = new TransactionListenerImpl();
        transactionMQProducer.setTransactionListener(transactionListener);

        transactionMQProducer.start();

        Message msg = new Message("transactionMQTopic", "testTag", "testKey", "订单支付消息".getBytes());
        try {
            TransactionSendResult transactionSendResult = transactionMQProducer.sendMessageInTransaction(msg, null);
            System.out.println(transactionSendResult);
        } catch (Exception e) {
            //发送half消息失败,抛异常不往下执行
        }
    }

    static class TransactionListenerImpl implements TransactionListener {

        //half消息发送成功了会回调此方法
        //若是一直没有回调此方法(即没有收到half消息发送成功的通知)，可以本地保存half消息，定时去跑任务查看一定时间还没有收到通知的消息，
        @Override
        public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
            //执行本地事务方法
            try {
                //若本地事务执行成功,返回COMMIT_MESSAGE
                return LocalTransactionState.COMMIT_MESSAGE;
            } catch (Exception e) {
                //如果本地事务执行失败，返回
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        }

        //因为各种原因没有返回返回COMMIT_MESSAGE或者ROLLBACK_MESSAGE
        @Override
        public LocalTransactionState checkLocalTransaction(MessageExt msg) {
            //检查本地事务执行状态
            Integer status = 0;
            if (status == 0) {
                return LocalTransactionState.COMMIT_MESSAGE;
            } else if (status == 2) {
                return LocalTransactionState.ROLLBACK_MESSAGE;
            } else if (status == 3) {
                return LocalTransactionState.UNKNOW;
            }

            return LocalTransactionState.UNKNOW;
        }
    }

}
