package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.msg.IBaseRequest;
import com.khanhhoang.helllo.msg.IBaseResponse;

public interface Task<T extends IBaseRequest, R extends IBaseResponse> {
    void run(T request, R response);
}
