package com.wantscart.jade.cache;

/**
 * 定义 Cache 实例，一个 Cache 实例代表一个缓存实例，支持其中的 get, set 等缓存操作。
 * 
 * @author han.liao
 */
public interface Cache {

    /**
     * 从 Cache 缓存池取出对象。
     * 
     *  key - 缓存关键字
     * 
     *  之前缓存的对象。
     */
    Object get(String key);

    /**
     * 将缓存的对象放入 Cache 缓存池。
     * 
     *  key - 缓存关键字
     *  value - 缓存的对象
     *  expiry - 缓存过期时间
     * 
     *  之前缓存的对象。
     */
    boolean set(String key, Object value, int expiry);

    /**
     * 从 Cache 缓存池删除对象。
     * 
     *  key - 缓存关键字
     */
    boolean delete(String key);
}
