package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.msg.IBaseRequest;

public interface Flow<T extends IBaseRequest> {
    void run(T request);
}
