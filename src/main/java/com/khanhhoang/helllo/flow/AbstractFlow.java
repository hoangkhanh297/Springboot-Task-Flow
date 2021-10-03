package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.msg.BaseRequest;
import com.khanhhoang.helllo.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFlow<T extends BaseRequest> implements Flow<T> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private final List<Task<T>> tasks = new ArrayList<>();
    private final List<Integer> alwaysRun = new ArrayList<>();

    private void runATask(T request, int index) {
        if (index == tasks.size()) {
            return;
        }
        if (!request.isStopped() || alwaysRun.contains(index)) {
            tasks.get(index).run(request);
        }
        runATask(request, index + 1);
    }

    @Override
    public void run(T request) {
        runATask(request, 0);
    }

    protected void addTask(Task<T> task, boolean isAlwaysRun) {
        tasks.add(task);
        if (isAlwaysRun) {
            alwaysRun.add(tasks.size() - 1);
        }
    }
}
