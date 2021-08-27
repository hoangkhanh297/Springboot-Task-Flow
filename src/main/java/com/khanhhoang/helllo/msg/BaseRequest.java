package com.khanhhoang.helllo.msg;

public abstract class BaseRequest implements IBaseRequest {
    private long time = System.currentTimeMillis();
    private BaseResponse response = new BaseResponse(this.time);

    @Override
    public void fail() {
        this.response.setStopped(true);
        this.response.setFailed(true);
    }

    @Override
    public boolean isStopped() {
        return response.isStopped();
    }

    @Override
    public boolean isFailed() {
        return response.isFailed();
    }

    @Override
    public void fail(int result) {
        fail();
        this.response.setResult(result);
    }

    @Override
    public void stop() {
        this.response.setStopped(true);
    }

    public BaseResponse getResponse() {
        return response;
    }

    public void setResponse(BaseResponse response) {
        this.response = response;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
