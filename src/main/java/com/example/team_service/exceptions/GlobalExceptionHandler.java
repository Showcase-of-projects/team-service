package com.example.team_service.exceptions;

import com.example.team_service.exceptions.team.ThemeChangeNotAllowedException;
import com.example.team_service.exceptions.topic.TopicNotAvailableException;
import com.example.team_service.exceptions.topic.TopicNotFoundException;
import com.example.team_service.exceptions.user.UserAlreadyExistsException;
import com.example.team_service.exceptions.user.UserAlreadyHasTeamException;
import com.example.team_service.exceptions.user.UserDoesNotHaveActiveTeamException;
import com.example.team_service.exceptions.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> catchUserAlreadyExistsException(UserAlreadyExistsException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(UserAlreadyHasTeamException.class)
    public ResponseEntity<ExceptionResponse> catchUserAlreadyHasTeamException(UserAlreadyHasTeamException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> catchUserNotFoundException(UserNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(ThemeChangeNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> catchThemeChangeNotAllowedException(ThemeChangeNotAllowedException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(TopicNotAvailableException.class)
    public ResponseEntity<ExceptionResponse> catchTopicNotAvailableException(TopicNotAvailableException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(TopicNotFoundException.class)
    public ResponseEntity<ExceptionResponse> catchTopicNotFoundException(TopicNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(UserDoesNotHaveActiveTeamException.class)
    public ResponseEntity<ExceptionResponse> catchUserDoesNotHaveActiveTeamException(UserDoesNotHaveActiveTeamException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
