package aiin.backend.common.exception;

import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
public class ApiExeption extends RuntimeException {
	private final HttpStatus httpStatus;
	private final String code;

	public ApiExeption(HttpStatus httpStatus, String message, String code) {
		super(message);
		this.httpStatus = httpStatus;
		this.code = code;
	}

	public static ApiExeption from(ErrorCode errorCode) {
		return new ApiExeption(errorCode.getHttpStatus(), errorCode.getMessage(), errorCode.getCode());
	}

	public static ApiExeption of(HttpStatus httpStatus, String message, String code) {
		return new ApiExeption(httpStatus, message, code);
	}
}
