package com.khanhhoang.helllo.msg;

import com.khanhhoang.helllo.base.data.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseRequest implements IBaseRequest {
    private long time = System.currentTimeMillis();
    private boolean stopped;
    private boolean failed;
    private ResultCode result;

    @Override
    public void fail() {
        setStopped(true);
        setFailed(true);
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }

    @Override
    public boolean isFailed() {
        return failed;
    }

    @Override
    public void fail(ResultCode result) {
        fail();
        setResult(result);
    }

    @Override
    public void stop() {
        setStopped(true);
    }

}
