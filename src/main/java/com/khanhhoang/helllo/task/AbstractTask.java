package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.msg.BaseRequest;
import com.khanhhoang.helllo.msg.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTask<T extends BaseRequest, R extends BaseResponse> implements Task<T, R> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(T request, R response) {
        try {
            behaviors(request, response);
        } catch (Exception e) {
            log.error("Error while executing task {}: ", this.getClass(), e);
            request.fail(1);
        }
    }

    protected abstract void behaviors(T request, R response) throws Exception;
}
