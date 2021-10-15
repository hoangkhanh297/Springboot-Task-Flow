package com.khanhhoang.helllo.msg;

import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.base.data.ResultCode;

public interface IDelegate<T> {

    boolean isStopped();

    boolean isFailed();

    void fail();

    void fail(ResultCode result);

    void fail(ResultCode result, boolean isRemoveExistedResponse);

    void fail(ResultCode resultCode, Throwable exception);

    void fail(ResultCode result, boolean isRemoveExistedResponse, Throwable exception);

    void stop();

    ResponseData<T> getResponse();

}
