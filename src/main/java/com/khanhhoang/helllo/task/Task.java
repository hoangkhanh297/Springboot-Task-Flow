package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.msg.IBaseRequest;

public interface Task<T extends IBaseRequest> {
    void run(T request);
}
