package com.khanhhoang.helllo.base.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ResultCode {
    public static final ResultCode SUCCESS = of(1, "Success", "Thành công");
    public static final ResultCode SYSTEM_ERROR = of(2, "System error", "Lỗi hệ thống");
    @Min(value = 100, message = "Code must be greater then 100")
    private Integer code;
    private String messageEN;
    private String messageVN;

    public static final class User {
        public static final ResultCode USERNAME_ALREADY_EXISTS = of(100, "Username already exists", "Tài khoản đã tồn tại");
    }
}
