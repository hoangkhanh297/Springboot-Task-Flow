package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.base.data.ResultCode;
import com.khanhhoang.helllo.msg.Delegate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTask<T, R> implements Task<T, R> {
    @Override
    public void run(T request, Delegate<R> delegate) {
        try {
            var start = System.currentTimeMillis();
            log.info("Start execute task [{}]", this.getClass().getName());
            behaviors(request, delegate);
            log.info("Executed task [{}] done after {}ms", this.getClass().getName(), System.currentTimeMillis() - start);
        } catch (Exception e) {
            log.error("Error while executing task {}: ", this.getClass(), e);
            delegate.fail(ResultCode.SYSTEM_ERROR, e);
        }
    }

    @Override
    public void run(Delegate<R> delegate) {
        run(null, delegate);
    }


    protected abstract void behaviors(T request, Delegate<R> delegate) throws Exception;
}
