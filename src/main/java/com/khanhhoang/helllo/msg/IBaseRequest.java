package com.khanhhoang.helllo.msg;

public interface IBaseRequest {

    boolean isStopped();

    boolean isFailed();

    void fail();

    void fail(int result);

    void stop();

}
