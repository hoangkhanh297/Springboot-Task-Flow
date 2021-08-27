package com.khanhhoang.helllo.flow;

import com.khanhhoang.helllo.msg.BaseRequest;
import com.khanhhoang.helllo.msg.BaseResponse;
import com.khanhhoang.helllo.task.Task;

import java.util.List;

public abstract class AbstractFlow<T extends BaseRequest, R extends BaseResponse> implements Flow<T, R> {

    private void runATask(T request, R response, int index) {
        List<Task<T, R>> tasks = listTasks();
        if (index == tasks.size() || request.isStopped()) {
            return;
        }
        tasks.get(index).run(request, response);
        runATask(request, response, index + 1);
    }

    @Override
    public void run(T request, R response) {
        request.setResponse(response);
        runATask(request, response, 0);
    }

    protected abstract List<Task<T, R>> listTasks();
}
