package org.example.module16.controllers;


import lombok.RequiredArgsConstructor;
import org.example.module16.model.Note;
import org.example.module16.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;
    private static final String BASE_REDIRECT = "redirect:/note/list";
    private static final String TEMPLATE_EDIT_NOTE = "edit";
    private static final String TEMPLATE_CREATE_NOTE = "create";
    private static final String TEMPLATE_NOTES_LIST = "list";

    @GetMapping("/list")
    public String getAllNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return TEMPLATE_NOTES_LIST;
    }

    @GetMapping("/create")
    public String createNoteTemplate(Model model) {
        model.addAttribute("note", new Note());
        return TEMPLATE_CREATE_NOTE;
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") Note note) {
        noteService.createNote(note);
        return BASE_REDIRECT;
    }

    @PostMapping("/edit")
    public String createEditNoteById(@ModelAttribute("note") Note note) {
        createNote(note);
        return BASE_REDIRECT;
    }

    @GetMapping("/edit")
    public String editNoteById(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return TEMPLATE_EDIT_NOTE;
    }

    @GetMapping("/delete")
    public String deleteNoteById(@RequestParam("id") Long id) {
        noteService.deleteNoteById(id);
        return BASE_REDIRECT;
    }
}