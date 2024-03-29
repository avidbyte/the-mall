package com.inst.mall.cloud.backstage.service;

/**
 * redis 自增主键
 *
 * @author aaron
 * @since 2021-04-19
 */
public interface IncrementSequenceService {

    /**
     * 获取值
     *
     * @return Long
     */
    Long getSequence();
}
