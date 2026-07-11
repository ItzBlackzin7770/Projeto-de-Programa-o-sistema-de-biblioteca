package com.project.Projeto.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class NotFoundException extends ChangeSetPersister.NotFoundException {

    public NotFoundException(String message) {
        new RuntimeException(message);
    }
}
