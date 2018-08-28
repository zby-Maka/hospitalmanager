package com.dyhc.hospitalmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
/**
 * RedisDao配置操作redis的操作
 */
public class RedisDao {
    @Autowired
    private StringRedisTemplate template;

    /**
     * 设置键值
     * @param key
     * @param value
     */
    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    /**
     * 根据键获取值
     * @param key
     * @return
     */
    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

    /**
     * 根据键删除键值
     * @param key
     */
    public void delete(String key){
        ValueOperations<String, String> vo=template.opsForValue();
        vo.getOperations().delete(key);
    }

    /**
     * 递减值
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key, long delta){
        if(delta<0){
            throw new RuntimeException("递减因子必须大于0");
        }
        return template.opsForValue().increment(key, -delta);
    }
}
