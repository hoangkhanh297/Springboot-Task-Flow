package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.msg.BaseRequest;
import com.khanhhoang.helllo.msg.BaseResponse;
import com.khanhhoang.helllo.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFlow<T extends BaseRequest, R extends BaseResponse> implements Flow<T, R> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private final List<Task<T, R>> tasks = new ArrayList<>();
    private final List<Integer> alwaysRun = new ArrayList<>();

    private void runATask(T request, R response, int index) {
        if (index == tasks.size()) {
            return;
        }
        if (!request.isStopped() || alwaysRun.contains(index)) {
            tasks.get(index).run(request, response);
        }
        runATask(request, response, index + 1);
    }

    @Override
    public void run(T request, R response) {
        request.setResponse(response);
        runATask(request, response, 0);
    }

    protected void addTask(Task<T, R> task, boolean isAlwaysRun) {
        tasks.add(task);
        if (isAlwaysRun) {
            alwaysRun.add(tasks.size() - 1);
        }
    }
}
