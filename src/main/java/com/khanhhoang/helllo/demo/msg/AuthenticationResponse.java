package com.khanhhoang.helllo.demo.msg;

import com.khanhhoang.helllo.model.UserEntity;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private UserEntity user;
}
