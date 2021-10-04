package com.khanhhoang.helllo.base.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
    private T data;
    private ResultCode result;

    public static <T> ResponseData<T> of(T data, ResultCode result) {
        return new ResponseData<>(data, result);
    }

    public static <T> ResponseData<T> error(ResultCode result) {
        return new ResponseData<>(null, result);
    }

    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<>(data, ResultCode.SUCCESS);
    }

}
