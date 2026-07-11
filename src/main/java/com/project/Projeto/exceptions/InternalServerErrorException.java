package com.project.Projeto.exceptions;

import jakarta.annotation.Nullable;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.web.server.ServerErrorException;

public class InternalServerErrorException extends ServerErrorException {
    public InternalServerErrorException(String message, @Nullable Throwable cause) {
        super(message, cause);
    }
}
