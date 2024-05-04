package org.example.module16.service;


import org.example.module16.model.Note;

import java.util.List;

public interface NoteService {

    Note createNote(Note note);

    Note getNoteById(Long noteId);

    List<Note> getAllNotes();

    Note updateNote(Long noteId, Note note);

    void deleteNoteById(Long noteId);
}