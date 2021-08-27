package com.khanhhoang.helllo.flow;

public interface Flow<T extends Object, R extends Object> {
    public void run(T request, R response);
}
