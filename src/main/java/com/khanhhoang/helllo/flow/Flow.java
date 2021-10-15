package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.base.data.ResponseData;

public interface Flow<T, R> {
    ResponseData<R> run(T request);

    ResponseData<R> run();
}
