package com.inst.mall.cloud.backstage.service.impl;

import com.inst.mall.cloud.backstage.service.StringRedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author aaron
 * @since 2021-04-14
 */
@Service
public class StringRedisTemplateImpl implements StringRedisService {

    private final StringRedisTemplate stringRedisTemplate;

    public StringRedisTemplateImpl(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate=stringRedisTemplate;
    }

    /**
     * 存储字符串
     *
     * @param key   key
     * @param value value
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 存储字符串
     *
     * @param key   key
     * @param value value
     * @param time  过期时间
     */
    @Override
    public void set(String key, String value, long time) {
        stringRedisTemplate.opsForValue().set(key, value, time);
    }

    /**
     * 获取字符串数据
     *
     * @param key key
     * @return Object
     */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除字符串数据
     *
     * @param key key
     * @return Boolean
     */
    @Override
    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 批量删除字符串数据
     *
     * @param keys key集合
     * @return Long
     */
    @Override
    public Long delete(List<String> keys) {
        return stringRedisTemplate.delete(keys);
    }

    /**
     * 设置过期时间
     *
     * @param key  key
     * @param time 过期时间  默认 单位秒
     * @return Boolean
     */
    @Override
    public Boolean expire(String key, long time) {
        return stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 设置过期时间
     *
     * @param key  key
     * @param time 过期时间
     * @return Boolean
     */
    @Override
    public Boolean expire(String key, long time, TimeUnit timeUnit) {
        return stringRedisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 获取过期时间
     *
     * @param key key
     * @return Long
     */
    @Override
    public Long getExpire(String key) {
        return stringRedisTemplate.getExpire(key);
    }

    /**
     * 判断是否有该属性
     *
     * @param key key
     * @return Boolean
     */
    @Override
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key key
     * @return Long
     */
    @Override
    public Long increment(String key) {
        return stringRedisTemplate.opsForValue().increment(key);
    }

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Long
     */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 按delta递增 以增量的方式将double值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Long
     */
    @Override
    public Double increment(String key, double delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key key
     * @return Long
     */
    @Override
    public Long decrement(String key) {
        return stringRedisTemplate.opsForValue().decrement(key);
    }

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Long
     */
    @Override
    public Long decrement(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 按delta递增 以增量的方式将double值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Double
     */
    @Override
    public Double decrement(String key, double delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 获取Hash结构中的属性
     *
     * @param key     key
     * @param hashKey hash数据的key
     * @return Object
     */
    @Override
    public Object hashGet(String key, Object hashKey) {
        return stringRedisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 向Hash结构中放入一个属性 并设置整个Hash结构的过期时间
     *
     * @param key     key
     * @param hashKey hash数据的key
     * @param value   value
     * @param time    过期时间
     * @return Boolean
     */
    @Override
    public Boolean hashSet(String key, Object hashKey, Object value, long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForHash().put(key, hashKey, value);
        return expire(key, time, timeUnit);
    }

    /**
     * 向Hash结构中放入一个属性
     *
     * @param key     key
     * @param hashKey hash数据的key
     * @param value   value
     */
    @Override
    public void hashSet(String key, String hashKey, Object value) {
        stringRedisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 直接获取整个Hash结构
     *
     * @param key key
     * @return Map<Object, Object>
     */
    @Override
    public Map<Object, Object> hashGetAll(String key) {
        return stringRedisTemplate.opsForHash().entries(key);
    }

    /**
     * 直接设置整个Hash结构 并设置过期时间
     *
     * @param key  key
     * @param map  map
     * @param time 过期时间
     * @return Boolean
     */
    @Override
    public Boolean hashSetAll(String key, Map<String, Object> map, long time) {
        stringRedisTemplate.opsForHash().putAll(key, map);
        return expire(key, time);
    }

    /**
     * 直接设置整个Hash结构
     *
     * @param key      key
     * @param map      map
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @return Boolean
     */
    @Override
    public Boolean hashSetAll(String key, Map<String, Object> map, long time, TimeUnit timeUnit) {
        stringRedisTemplate.opsForHash().putAll(key, map);
        return expire(key, time, timeUnit);
    }

    /**
     * 直接设置整个Hash结构
     *
     * @param key key
     * @param map map
     */
    @Override
    public void hashSetAll(String key, Map<String, Object> map) {
        stringRedisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 删除Hash结构中的属性
     *
     * @param key     key
     * @param hashKey hashKey
     */
    @Override
    public void hashDelete(String key, Object... hashKey) {
        stringRedisTemplate.opsForHash().delete(key, hashKey);
    }

    /**
     * 判断Hash结构中是否有该属性
     *
     * @param key     key
     * @param hashKey hashKey
     * @return Boolean
     */
    @Override
    public Boolean hashHasKey(String key, Object hashKey) {
        return stringRedisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * Hash结构中属性递增
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Long
     */
    @Override
    public Long hashIncrement(String key, String hashKey, Long delta) {
        return stringRedisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    /**
     * Hash结构中属性递增
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Long
     */
    @Override
    public Double hashIncrement(String key, String hashKey, Double delta) {
        return stringRedisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    /**
     * Hash结构中属性递减
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Long
     */
    @Override
    public Long hashDecrement(String key, String hashKey, Long delta) {
        return stringRedisTemplate.opsForHash().increment(key, hashKey, -delta);
    }

    /**
     * Hash结构中属性递减
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Double
     */
    @Override
    public Double hashDecrement(String key, String hashKey, Double delta) {
        return stringRedisTemplate.opsForHash().increment(key, hashKey, -delta);
    }

    /**
     * 获取Set结构
     *
     * @param key key
     * @return Set<Object>
     */
    @Override
    public Set<String> setMembers(String key) {
        return stringRedisTemplate.opsForSet().members(key);
    }

    /**
     * 向Set结构中添加属性
     *
     * @param key    key
     * @param values values
     * @return Long
     */
    @Override
    public Long setAdd(String key, String... values) {
        return stringRedisTemplate.opsForSet().add(key, values);
    }

    /**
     * 向Set结构中添加属性
     *
     * @param key      key
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @param values   values
     * @return Long
     */
    @Override
    public Long setAdd(String key, long time, TimeUnit timeUnit, String... values) {
        Long count = stringRedisTemplate.opsForSet().add(key, values);
        expire(key, time, timeUnit);
        return count;
    }

    /**
     * 是否为Set中的属性
     *
     * @param key   key
     * @param value value
     * @return Boolean
     */
    @Override
    public Boolean setIsMember(String key, Object value) {
        return stringRedisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 获取Set结构的长度
     *
     * @param key key
     * @return Long
     */
    @Override
    public Long setSize(String key) {
        return stringRedisTemplate.opsForSet().size(key);
    }

    /**
     * 删除Set结构中的属性
     *
     * @param key    key
     * @param values values
     * @return Long
     */
    @Override
    public Long setRemove(String key, Object... values) {
        return stringRedisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 获取List结构中的属性
     *
     * @param key   key
     * @param start 起始
     * @param end   结束
     * @return List<String>
     */
    @Override
    public List<String> listRange(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取List结构的长度
     *
     * @param key key
     * @return Long
     */
    @Override
    public Long listSize(String key) {
        return stringRedisTemplate.opsForList().size(key);
    }

    /**
     * 根据索引获取List中的属性
     *
     * @param key   key
     * @param index 索引
     * @return Object
     */
    @Override
    public String listIndex(String key, long index) {
        return stringRedisTemplate.opsForList().index(key, index);
    }

    /**
     * 向List结构中添加属性
     *
     * @param key   key
     * @param value value
     * @return Long
     */
    @Override
    public Long listPush(String key, String value) {
        return stringRedisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 向List结构中添加属性
     *
     * @param key   key
     * @param value value
     * @param time  过期时间
     * @return Long
     */
    @Override
    public Long listPush(String key, String value, long time) {
        Long index = stringRedisTemplate.opsForList().rightPush(key, value);
        expire(key, time);
        return index;
    }

    /**
     * 向List结构中添加属性
     *
     * @param key      key
     * @param value    value
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @return Long
     */
    @Override
    public Long listPush(String key, String value, long time, TimeUnit timeUnit) {
        Long index = stringRedisTemplate.opsForList().rightPush(key, value);
        //todo 死锁
        expire(key, time, timeUnit);
        return index;
    }

    /**
     * 向List结构中批量添加属性
     *
     * @param key    key
     * @param values 属性集合
     * @return Long
     */
    @Override
    public Long listPushAll(String key, String... values) {
        return stringRedisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 向List结构中批量添加属性
     *
     * @param key    key
     * @param time   过期时间
     * @param values 属性集合
     * @return Long
     */
    @Override
    public Long listPushAll(String key, Long time, String... values) {
        Long count = stringRedisTemplate.opsForList().rightPushAll(key, values);
        expire(key, time);
        return count;
    }

    /**
     * 从List结构中移除属性
     *
     * @param key   key
     * @param count 数量
     * @param value 属性
     * @return Long
     */
    @Override
    public Long listRemove(String key, long count, String value) {
        return stringRedisTemplate.opsForList().remove(key, count, value);
    }
}
