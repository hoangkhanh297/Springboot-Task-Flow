package com.khanhhoang.helllo.msg;

import com.khanhhoang.helllo.base.data.ErrorCode;

public interface IBaseRequest {

    boolean isStopped();

    boolean isFailed();

    void fail();

    void fail(ErrorCode result);

    void stop();

}
