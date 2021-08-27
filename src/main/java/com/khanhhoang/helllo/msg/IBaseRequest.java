package com.khanhhoang.helllo.msg;

public interface IBaseRequest {

    public boolean isStopped();

    public boolean isFailed();

    public void fail();

    public void fail(int result);

    public void stop();

}
