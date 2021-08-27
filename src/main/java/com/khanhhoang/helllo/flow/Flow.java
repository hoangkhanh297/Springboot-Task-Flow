package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.msg.BaseRequest;
import com.khanhhoang.helllo.msg.BaseResponse;

public interface Flow<T extends BaseRequest, R extends BaseResponse> {
    void run(T request, R response);
}
