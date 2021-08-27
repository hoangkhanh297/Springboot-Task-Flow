package com.khanhhoang.helllo.msg;

public class BaseResponse implements IBaseResponse{
    private long time = System.currentTimeMillis();
    private boolean stopped;
    private boolean failed;
    private int result;

    public BaseResponse(long time) {
        this.time = time;
    }

    public BaseResponse() {
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public long getTime() {
        return time;
    }
}
