package com.khanhhoang.helllo.task;

import com.khanhhoang.helllo.msg.Delegate;

public interface Task<T, R> {
    void run(T request, Delegate<R> delegate);

    void run(Delegate<R> delegate);
}
