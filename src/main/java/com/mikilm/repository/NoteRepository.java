package com.mikilm.repository;

import com.mikilm.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mmikilchenko on 01.04.2017.
 */
public interface NoteRepository extends JpaRepository<Note, Integer> {
    Note saveAndFlush(Note person);

    List<Note> findAll();

    Note findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}
