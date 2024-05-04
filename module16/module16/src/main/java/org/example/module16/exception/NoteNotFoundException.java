package org.example.module16.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(Long id) {
        super(String.format("Note not found with ID: " + id));
    }
}