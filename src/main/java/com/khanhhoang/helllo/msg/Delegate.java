package com.khanhhoang.helllo.msg;

import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.base.data.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Delegate<T> implements IDelegate<T> {
    private long time = System.currentTimeMillis();
    private boolean stopped;
    private boolean failed;
    private Map<String, Object> extras = new HashMap<>();
    private ResponseData<T> response = ResponseData.ok(null);
    private Throwable exception;

    @Override
    public void fail() {
        fail(ResultCode.SYSTEM_ERROR, false, null);
    }

    @Override
    public void fail(ResultCode resultCode) {
        fail(resultCode, false, null);
    }

    @Override
    public void fail(ResultCode resultCode, Throwable exception) {
        fail(resultCode, false, exception);
    }

    @Override
    public void fail(ResultCode result, boolean isRemoveExistedResponse) {
        fail(result, isRemoveExistedResponse, null);
    }

    @Override
    public void fail(ResultCode result, boolean isRemoveExistedResponse, Throwable exception) {
        setStopped(true);
        setFailed(true);
        response.setResult(result);
        this.exception = exception;
        if (isRemoveExistedResponse) {
            response.setData(null);
        }
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
    public void stop() {
        setStopped(true);
    }

    public void setResponseData(T responseData) {
        this.getResponse().setData(responseData);
    }

    public Object getExtra(String key) {
        return extras.get(key);
    }

    public Object addExtra(String key, Object value) {
        return extras.put(key, value);
    }

    public Object getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }

    public void removeExtra(String key) {
        extras.remove(key);
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}
