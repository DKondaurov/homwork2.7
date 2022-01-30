package com.example.homwork7;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CREATED)
public class EmployeeAlreadyExistsException extends RuntimeException {

}