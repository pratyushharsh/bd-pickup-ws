package com.snumbers.bdpickupws.exception;

import com.snumbers.bdpickupws.ui.model.response.ErrorMessage;
import com.snumbers.bdpickupws.ui.model.response.ErrorMessages;
import org.hibernate.HibernateException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {OrderServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(OrderServiceException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(new Date(), ex.getMessage());
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {JDBCConnectionException.class, TransactionException.class, HibernateException.class})
    public ResponseEntity<Object> handleDatabaseException(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(new Date(), ErrorMessages.SERVICE_UNAVAILABLE.getErrorMessage());
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(new Date(), ex.getMessage());
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {PickUpdateException.class})
    public ResponseEntity<Object> handleUpdateException(PickUpdateException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(new Date(), ex.getMessage());
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
