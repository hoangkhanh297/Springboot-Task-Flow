package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.base.data.ErrorCode;
import com.khanhhoang.helllo.msg.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTask<T extends BaseRequest> implements Task<T> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(T request) {
        try {
            behaviors(request);
        } catch (Exception e) {
            log.error("Error while executing task {}: ", this.getClass(), e);
            request.fail(ErrorCode.SYSTEM_ERROR);
        }
    }

    protected abstract void behaviors(T request) throws Exception;
}
