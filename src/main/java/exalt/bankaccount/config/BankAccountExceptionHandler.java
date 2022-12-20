package exalt.bankaccount.config;

import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankAccountExceptionHandler {
	@ExceptionHandler(BankAccountException.class)
	public ResponseEntity<Object> BankAccountException(BankAccountException ex) {

		ServerResponse serverresponse = ServerResponse.builder().message(ex.getMessage()).timestamp(LocalDateTime.now())
				.build();

		return new ResponseEntity<>(serverresponse, ex.getCode().getHttpStatus());
	}

}
