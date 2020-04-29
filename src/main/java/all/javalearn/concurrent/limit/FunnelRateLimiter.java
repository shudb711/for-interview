package all.javalearn.concurrent.limit;/*
    created by shudb at 2020/2/21 14:31
*/

import java.util.HashMap;
import java.util.Map;

public class FunnelRateLimiter {
    /**
     * 限流算法
     */

    class Funnel{
        private int capacity;//容量
        private int left;//剩余
        private float rate;//速率
        private long leakTime;//流动时间

        public Funnel(int capacity, float rate) {
            this.capacity = capacity;
            this.left = capacity;
            this.rate = rate;
            this.leakTime = System.currentTimeMillis();
        }

        public boolean watering(int quota) {
            long nowTs = System.currentTimeMillis();
            int delta = (int)(rate * (nowTs - leakTime));
            leakTime = nowTs;
            if (delta > 0) {
                left += delta;
            }

            if (left >= quota) {
                left -= quota;
                return true;
            }
            return false;
        }
    }

    private Map<String,Funnel> map = new HashMap<>();
    public boolean isActionAllowed(String userId, String actionKey,int capacity, float rate) {
        String key = userId + "--" + actionKey;
        Funnel funnel = map.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, rate);
            map.put(key, funnel);
        }

        return funnel.watering(1);
    }

    public static void main(String[] args) throws InterruptedException {
        FunnelRateLimiter limiter = new FunnelRateLimiter();
        while (true) {
            boolean actionAllowed = limiter.isActionAllowed("shudb", "eat", 15, 0.001f);
            if (actionAllowed) {
                System.out.println("吃了一次饭。。。。");
            } else {
                System.out.println("没有机会吃了，请稍等。。。。");
                Thread.sleep(3000);
            }

        }

    }
}
