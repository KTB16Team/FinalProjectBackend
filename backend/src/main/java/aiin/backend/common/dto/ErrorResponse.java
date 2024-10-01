package aiin.backend.common.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import aiin.backend.common.exception.ErrorCode;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse extends BaseResponse {

	private final String message;
	private final List<String> reasons;

	private ErrorResponse(HttpStatus status, String message, List<String> reasons) {
		super(status);
		this.message = message;
		this.reasons = reasons;
	}

	public static ErrorResponse of(ErrorCode errorCode, List<String> reasons) {
		HttpStatus status = errorCode.getHttpStatus();
		String message = errorCode.getMessage();

		return new ErrorResponse(status, message, reasons);
	}

}
