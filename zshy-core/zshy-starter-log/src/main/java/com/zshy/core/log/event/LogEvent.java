package com.zshy.core.log.event;

import org.springframework.context.ApplicationEvent;
import com.zshy.core.common.dto.CommonLog;

/**
 * 日志事件
 * @author yanghaifeng 694939483@qq.com
 * @since 2020-7-15
 */
public class LogEvent extends ApplicationEvent {

    public LogEvent(CommonLog source) {
        super(source);
    }
}
