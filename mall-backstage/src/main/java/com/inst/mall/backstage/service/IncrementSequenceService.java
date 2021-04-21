package com.inst.mall.backstage.service;

import org.springframework.beans.factory.annotation.Value;

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
