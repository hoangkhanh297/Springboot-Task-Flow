package com.khanhhoang.helllo.msg;

import com.khanhhoang.helllo.base.data.ResultCode;

public interface IBaseRequest {

    boolean isStopped();

    boolean isFailed();

    void fail();

    void fail(ResultCode result);

    void stop();

}
