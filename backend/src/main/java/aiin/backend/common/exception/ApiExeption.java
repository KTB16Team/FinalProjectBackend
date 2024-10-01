package aiin.backend.common.exception;

import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
public class ApiExeption extends RuntimeException {
	private final HttpStatus httpStatus;

	public ApiExeption(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public static ApiExeption from(ErrorCode errorCode) {
		return new ApiExeption(errorCode.getHttpStatus(), errorCode.getMessage());
	}

	public static ApiExeption of(HttpStatus httpStatus, String message) {
		return new ApiExeption(httpStatus, message);
	}
}
