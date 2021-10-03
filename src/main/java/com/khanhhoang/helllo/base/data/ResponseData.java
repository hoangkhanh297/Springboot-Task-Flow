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
    private ErrorCode result;

    public static <T> ResponseData<T> of(T data, ErrorCode result) {
        return new ResponseData<>(data, result);
    }

    public static <T> ResponseData<T> error(ErrorCode result) {
        return new ResponseData<>(null, result);
    }

    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<>(data, ErrorCode.SUCCESS);
    }

}
