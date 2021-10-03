package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.base.data.ErrorCode;
import com.khanhhoang.helllo.msg.BaseRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTask<T extends BaseRequest> implements Task<T> {
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
