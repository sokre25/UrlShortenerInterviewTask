package hr.infobip.urlshortenertask.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handler for BAD REQUEST message.
 */
@ControllerAdvice
@RestController
public class RequestValidationHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException args) {

        Map<String, String> errorResponseMsg = new HashMap<>();
        errorResponseMsg.put("status", HttpStatus.BAD_REQUEST.name());
        errorResponseMsg.put("code", (String.valueOf(HttpStatus.BAD_REQUEST.value())));

        List<ObjectError> errorList = args.getBindingResult().getAllErrors();
        errorList.forEach(error -> {
            String field = ((FieldError) error).getField();
            String errorMsg = error.getDefaultMessage();

            errorResponseMsg.put(field, errorMsg);

        });

        return errorResponseMsg;
    }
}
