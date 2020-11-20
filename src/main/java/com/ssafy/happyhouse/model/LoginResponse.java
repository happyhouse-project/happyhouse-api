package com.ssafy.happyhouse.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

	private String accessToken;
}
