package com.inst.mall.cloud.backstage.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 通过 SpringRedisTemplate 操作redis
 *
 * @author aaron
 * @since 2020-11-23
 */
public interface StringRedisService {


    /**
     * 存储字符串
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 存储字符串
     *
     * @param key   key
     * @param value value
     * @param time  过期时间
     */
    void set(String key, String value, long time);

    /**
     * 获取字符串数据
     *
     * @param key key
     * @return String
     */
    String get(String key);

    /**
     * 删除字符串数据
     *
     * @param key key
     * @return Boolean
     */
    Boolean delete(String key);

    /**
     * 批量删除字符串数据
     *
     * @param keys key集合
     * @return Long
     */
    Long delete(List<String> keys);


    /**
     * 设置过期时间
     *
     * @param key  key
     * @param time 过期时间  默认 单位秒
     * @return Boolean
     */
    Boolean expire(String key, long time);

    /**
     * 设置过期时间
     *
     * @param key      key
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @return Boolean
     */
    Boolean expire(String key, long time, TimeUnit timeUnit);


    /**
     * 获取过期时间
     *
     * @param key key
     * @return Long
     */
    Long getExpire(String key);


    /**
     * 判断是否有该属性
     *
     * @param key key
     * @return Boolean
     */
    Boolean hasKey(String key);


    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key key
     * @return Long
     */
    Long increment(String key);

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Long
     */
    Long increment(String key, long delta);

    /**
     * 按delta递增 以增量的方式将double值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Double
     */
    Double increment(String key, double delta);

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key key
     * @return Long
     */
    Long decrement(String key);

    /**
     * 按delta递增 以增量的方式将long值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Long
     */
    Long decrement(String key, long delta);

    /**
     * 按delta递增 以增量的方式将double值存储在变量中
     *
     * @param key   key
     * @param delta 变量
     * @return Double
     */
    Double decrement(String key, double delta);


    /**
     * 获取Hash结构中的属性
     *
     * @param key     key
     * @param hashKey hash数据的key
     * @return Object
     */
    Object hashGet(String key, Object hashKey);


    /**
     * 向Hash结构中放入一个属性
     *
     * @param key      key
     * @param hashKey  hash数据的key
     * @param value    value
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @return Boolean
     */
    Boolean hashSet(String key, Object hashKey, Object value, long time, TimeUnit timeUnit);

    /**
     * 向Hash结构中放入一个属性
     *
     * @param key     key
     * @param hashKey hash数据的key
     * @param value   value
     */
    void hashSet(String key, String hashKey, Object value);

    /**
     * 直接获取整个Hash结构
     *
     * @param key key
     * @return Map<Object, Object>
     */
    Map<Object, Object> hashGetAll(String key);


    /**
     * 直接设置整个Hash结构
     *
     * @param key  key
     * @param map  map
     * @param time 过期时间
     * @return Boolean
     */
    Boolean hashSetAll(String key, Map<String, Object> map, long time);

    /**
     * 直接设置整个Hash结构
     *
     * @param key      key
     * @param map      map
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @return Boolean
     */
    Boolean hashSetAll(String key, Map<String, Object> map, long time, TimeUnit timeUnit);

    /**
     * 直接设置整个Hash结构
     *
     * @param key key
     * @param map map
     */
    void hashSetAll(String key, Map<String, Object> map);

    /**
     * 删除Hash结构中的属性
     *
     * @param key     key
     * @param hashKey hashKey
     */
    void hashDelete(String key, Object... hashKey);


    /**
     * 判断Hash结构中是否有该属性
     *
     * @param key     key
     * @param hashKey hashKey
     * @return Boolean
     */
    Boolean hashHasKey(String key, Object hashKey);

    /**
     * Hash结构中属性递增
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Long
     */
    Long hashIncrement(String key, String hashKey, Long delta);

    /**
     * Hash结构中属性递增
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Long
     */
    Double hashIncrement(String key, String hashKey, Double delta);

    /**
     * Hash结构中属性递减
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Long
     */
    Long hashDecrement(String key, String hashKey, Long delta);

    /**
     * Hash结构中属性递减
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return Double
     */
    Double hashDecrement(String key, String hashKey, Double delta);

    /**
     * 获取Set结构
     *
     * @param key key
     * @return Set<String>
     */
    Set<String> setMembers(String key);

    /**
     * 向Set结构中添加属性
     *
     * @param key    key
     * @param values values
     * @return Long
     */
    Long setAdd(String key, String... values);

    /**
     * 向Set结构中添加属性
     *
     * @param key      key
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @param values   values
     * @return Long
     */
    Long setAdd(String key, long time, TimeUnit timeUnit, String... values);

    /**
     * 是否为Set中的属性
     *
     * @param key   key
     * @param value value
     * @return Boolean
     */
    Boolean setIsMember(String key, Object value);

    /**
     * 获取Set结构的长度
     *
     * @param key key
     * @return Long
     */
    Long setSize(String key);

    /**
     * 删除Set结构中的属性
     *
     * @param key    key
     * @param values values
     * @return Long
     */
    Long setRemove(String key, Object... values);

    /**
     * 获取List结构中的属性
     *
     * @param key   key
     * @param start 起始
     * @param end   结束
     * @return List<String>
     */
    List<String> listRange(String key, long start, long end);

    /**
     * 获取List结构的长度
     *
     * @param key key
     * @return Long
     */
    Long listSize(String key);

    /**
     * 根据索引获取List中的属性
     *
     * @param key   key
     * @param index 索引
     * @return Object
     */
    String listIndex(String key, long index);

    /**
     * 向List结构中添加属性
     *
     * @param key   key
     * @param value value
     * @return Long
     */
    Long listPush(String key, String value);

    /**
     * 向List结构中添加属性
     *
     * @param key   key
     * @param value value
     * @param time  过期时间
     * @return Long
     */
    Long listPush(String key, String value, long time);

    /**
     * 向List结构中添加属性
     *
     * @param key      key
     * @param value    value
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @return Long
     */
    Long listPush(String key, String value, long time, TimeUnit timeUnit);

    /**
     * 向List结构中批量添加属性
     *
     * @param key    key
     * @param values 属性集合
     * @return Long
     */
    Long listPushAll(String key, String... values);

    /**
     * 向List结构中批量添加属性
     *
     * @param key    key
     * @param time   过期时间
     * @param values 属性集合
     * @return Long
     */
    Long listPushAll(String key, Long time, String... values);

    /**
     * 从List结构中移除属性
     *
     * @param key   key
     * @param count 数量
     * @param value 属性
     * @return Long
     */
    Long listRemove(String key, long count, String value);
}
