package all.javalearn.redis.distributelock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/5/23 10:54
 * Author shudebao@limikeji.com
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    public boolean expire(String key, int seconds) {
        try {
            return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取过期时间
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        try {
            return redisTemplate.getExpire(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断某个key是否存在
     *
     * @param key key
     * @return Boolean
     */
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除key
     * @param key
     */
    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
        }
    }

//***************************************key-String***********************************************
    /**
     * 设置缓存
     *
     * @param key   key
     * @param value value
     * @return Boolean
     */
    public Boolean setKey(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return Boolean.TRUE;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置缓存（过期）
     *
     * @param key     key
     * @param value   value
     * @param timeout 过期时间
     * @return Boolean
     */
    public Boolean setKeyEx(String key, Object value, Long timeout) {
        try {
            redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
            return Boolean.TRUE;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 自增数值+delta  需要value可以转成数值  返回增加之后的新值
     * @param key
     * @param delta
     * @return
     */
    public Long incrByDelta(String key, long delta) {
        try {
            return redisTemplate.opsForValue().increment(key, delta);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * key的值+1
     * @param key
     * @return
     */
    public Long incr(String key) {
        try {
            return redisTemplate.opsForValue().increment(key, 1);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 不存在插入  1成功  0失败
     * @param key
     * @param value
     * @return
     */
    public boolean setNx(String key, Object value) {
        try {
            return redisTemplate.opsForValue().setIfAbsent(key, value);
        } catch (Exception e) {
            return false;
        }
    }

//    public Boolean setNxEx(String key, Object value, int seconds) {
//        try {
//            return redisTemplate.opsForValue().setIfAbsent(key, value, seconds, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            return false;
//        }
//    }



    /**
     * 获取缓存
     *
     * @param key key
     * @return String
     */
    public Object getKey(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            return null;
        }
    }

//***************************************key-List***********************************************

    /**
     * 设置list
     */
    public void putCacheList(String key, Object[] objects) {
        try {
            if (objects != null && objects.length > 0) {
                redisTemplate.opsForList().leftPushAll(key, objects);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 左侧插入一个值
     * @param key
     * @param item
     * @return
     */
    public Long lpush(String key, Object item) {
        try {
            return redisTemplate.opsForList().leftPush(key, item);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 左侧按索引开始查询 - 字符串
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> lrange(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 右侧插入一个值
     * @param key
     * @param item
     * @return
     */
    public Long rpush(String key, Object item) {
        try {
            return redisTemplate.opsForList().rightPush(key, item);
        } catch (Exception e) {
            return null;
        }
    }



    //***************************************key-set***********************************************

    /**
     * 插入key
     * @param key
     * @param member
     * @return
     */
    public Long sadd(String key, Object... member) {
        try {
            return redisTemplate.opsForSet().add(key, member);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 查询成员是否存在
     * @param key
     * @param value
     * @return
     */
    public Boolean sismember(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询所有成员 - 字符串
     * @param key
     * @return
     */
    public Set<Object> smembers(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            return null;
        }
    }



    /**
     * 移除单个成员
     * @param key
     * @param member
     * @return
     */
    public Long srem(String key, Object member) {
        try {
            return redisTemplate.opsForSet().remove(key, member);
        } catch (Exception e) {
            return null;
        }
    }

    //***************************************key-zset***********************************************

    /**
     * 插入一个key
     * @param key
     * @param member
     * @param score
     * @return
     */
    public boolean zadd(String key, Object member, double score) {
        try {
            return redisTemplate.opsForZSet().add(key, member, score);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 按索引范围查询（score 升序排列） - 字符串
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> zrange(String key, long start, long end) {
        try {
            return redisTemplate.opsForZSet().range(key, start, end);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 按score范围查询 - 字符串
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<Object> zrangebyscore(String key, double min, double max) {
        try {
            return redisTemplate.opsForZSet().rangeByScore(key, min, max);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 移除单个成员
     * @param key
     * @param member
     * @return
     */
    public Long zrem(String key, Object member) {
        try {
            return redisTemplate.opsForZSet().remove(key, member);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 分数+1
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Double incrementScore(String key, Object value, Integer score) {
        try {
            return redisTemplate.opsForZSet().incrementScore(key, value, score);
        } catch (Exception e) {
            return null;
        }
    }

    //***************************************key-hash***********************************************

    /**
     * 单条插入
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, Object value) {
        try {
            redisTemplate.opsForHash().put(key, field, value);
        } catch (Exception e) {
        }
    }

    /**
     * 查询hash的一个field查询单个value - 字符串
     * @param key
     * @param field
     * @return
     */
    public Object hget(String key, String field) {
        try {
            return redisTemplate.opsForHash().get(key, field);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询全部hash - 字符串
     * @param key
     * @return
     */
    public Map<Object, Object> hgetAll(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * hash删除
     * @param key
     * @param field
     * @return
     */
    public Long hdel(String key, String field) {
        try {
            return redisTemplate.opsForHash().delete(key, field);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean hexists(String key, String field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * 永久有效的
     * @param key hash 的 key
     * @param value hash的值
     */
    public void putHash(String key, Map<String, Object> value) {
        this.putHashEx(key, value, null);
    }

    /**
     * 存hash存储结构
     */
    public void putHashEx(String key, Map<String, Object> value, Long timeout) {
        try {
            if (!CollectionUtils.isEmpty(value)) {
                redisTemplate.opsForHash().putAll(key, value);
            }
            if (timeout != null) {
                redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
        }
    }


    /**
     * 取hash存储结构
     */
    public Map<Object, Object> getHash(String key) {
        Map<Object, Object> dataMap = new HashMap<>();
        try {
            dataMap = redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
        }
        return dataMap;
    }
}
