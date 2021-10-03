package com.khanhhoang.helllo.base.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ErrorCode {
    public static final ErrorCode SUCCESS = of(1, "Success", "Thành công");
    public static final ErrorCode SYSTEM_ERROR = of(2, "System error", "Lỗi hệ thống");
    private int code;
    private String messageEN;
    private String messageVN;


}
