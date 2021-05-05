package exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e){
		 HttpStatus badrequest   = HttpStatus.INTERNAL_SERVER_ERROR;
			ApiException apiException = new ApiException(
					e.getMessage()
				
					,badrequest
					,ZonedDateTime.now(ZoneId.of("Z"))
					);
	      
			return new ResponseEntity<>(apiException,badrequest);
	   };
	
}
