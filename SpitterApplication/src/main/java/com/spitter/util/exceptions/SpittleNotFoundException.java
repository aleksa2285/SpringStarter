package com.spitter.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Spittle not Found")
public class SpittleNotFoundException extends RuntimeException {
}
