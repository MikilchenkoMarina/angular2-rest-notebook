package com.mikilm.controller;

import com.mikilm.entity.Note;
import com.mikilm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author mmikilchenko on 23.10.2017.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    NoteService noteService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Note> listAllUsersEty() {
        return noteService.getAllNotes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Note getUser(@PathVariable("id") int id) {
        return noteService.findNoteById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Note createNote(@RequestBody Note note, UriComponentsBuilder ucBuilder) {
        noteService.addNote(note);
        return noteService.findNoteById(note.getId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
