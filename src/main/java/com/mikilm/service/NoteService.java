package com.mikilm.service;

import com.mikilm.entity.Note;
import com.mikilm.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mmikilchenko on 01.04.2017.
 */
@Transactional
@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void addNote(Note note) {
        noteRepository.saveAndFlush(note);
    }

    public Note findNoteById(Integer id) {
        return noteRepository.findById(id);
    }

    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);
    }


    public void updatePersonByPid(Note person) {

        Note p = findNoteById(person.getId());
        p.setTitle(person.getTitle());
        p.setText(person.getText());

        noteRepository.saveAndFlush(p);
    }

}
