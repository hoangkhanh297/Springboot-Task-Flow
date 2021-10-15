package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.msg.Delegate;
import com.khanhhoang.helllo.task.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractFlow<T, R> implements Flow<T, R> {
    private final List<Task<T, R>> tasks = new ArrayList<>();
    private final List<Integer> alwaysRun = new ArrayList<>();

    private ResponseData<R> runATask(T request, Delegate<R> delegate, final int index) {
        if (index == tasks.size()) {
            return delegate.getResponse();
        }
        if (!delegate.isStopped() || alwaysRun.contains(index)) {
            tasks.get(index).run(request, delegate);
        }
        return runATask(request, delegate, index + 1);
    }

    private ResponseData<R> runATask(Delegate<R> delegate, final int index) {
        if (index == tasks.size()) {
            return delegate.getResponse();
        }
        if (!delegate.isStopped() || alwaysRun.contains(index)) {
            tasks.get(index).run(delegate);
        }
        return runATask(delegate, index + 1);
    }

    @Override
    public ResponseData<R> run(T request) {
        var delegate = new Delegate<R>();
        return runATask(request, delegate, 0);
    }

    @Override
    public ResponseData<R> run() {
        var delegate = new Delegate<R>();
        return runATask(delegate, 0);
    }

    protected void addTask(Task<T, R> task, boolean isAlwaysRun) {
        tasks.add(task);
        if (isAlwaysRun) {
            alwaysRun.add(tasks.size() - 1);
        }
    }
}
