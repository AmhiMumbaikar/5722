package CS5722.FlightApiEngine.SearchApi.Advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> badRequest ( MethodArgumentNotValidException methodArgumentNotValidException ) {

        Map<String, String> response = new HashMap<>();

        var allErrors = methodArgumentNotValidException.getBindingResult().getAllErrors();

        var errorMessage = new StringBuilder();

        for (var error : allErrors) {
            errorMessage.append(error.getDefaultMessage()).append("; ");
        }

        response.put("errorMessage",errorMessage.toString());

        return response;
    }
}
