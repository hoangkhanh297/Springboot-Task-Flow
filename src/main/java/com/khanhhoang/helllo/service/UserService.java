package com.khanhhoang.helllo.service;

import com.khanhhoang.helllo.base.data.ErrorCode;
import com.khanhhoang.helllo.base.data.ResponseData;
import com.khanhhoang.helllo.demo.msg.AddUserRequest;
import com.khanhhoang.helllo.demo.msg.GetAllUserRequest;
import com.khanhhoang.helllo.demo.msg.SearchUserRequest;
import com.khanhhoang.helllo.flow.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("GetAllUsersFlow")
    Flow<GetAllUserRequest> getAllUserFlow;
    @Autowired
    @Qualifier("AddUserFlow")
    Flow<AddUserRequest> addUserFlow;
    @Autowired
    @Qualifier("SearchUserFlow")
    Flow<SearchUserRequest> searchUserFlow;

    public ResponseData<?> getAll() {
        var request = new GetAllUserRequest();
        getAllUserFlow.run(request);
        if (request.isFailed()) {
            return ResponseData.error(ErrorCode.SYSTEM_ERROR);
        }
        return ResponseData.ok(request.getResponse());
    }

    public ResponseData<?> add(AddUserRequest request) {
        addUserFlow.run(request);
        if (request.isFailed()) {
            return ResponseData.error(ErrorCode.SYSTEM_ERROR);
        }
        return ResponseData.ok(request.getResponse());
    }

    public ResponseData<?> search(String keyword) {
        var searchRequest = new SearchUserRequest();
        searchRequest.setText(keyword);
        searchUserFlow.run(searchRequest);
        if (searchRequest.isFailed()) {
            return ResponseData.error(ErrorCode.SYSTEM_ERROR);
        }
        return ResponseData.ok(searchRequest.getResponse());
    }
}
