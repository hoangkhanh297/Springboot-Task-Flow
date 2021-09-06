package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.msg.IBaseRequest;
import com.khanhhoang.helllo.msg.IBaseResponse;

public interface Flow<T extends IBaseRequest, R extends IBaseResponse> {
    void run(T request, R response);
}
