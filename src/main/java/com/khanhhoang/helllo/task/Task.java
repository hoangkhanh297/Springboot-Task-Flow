package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.msg.BaseRequest;
import com.khanhhoang.helllo.msg.BaseResponse;

public interface Task<T extends BaseRequest, R extends BaseResponse> {
    public void behaviors(T request, R response);

    public void run(T request, R response);
}
