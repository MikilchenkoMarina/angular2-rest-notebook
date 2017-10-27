package com.mikilm.entity;

import javax.persistence.*;

/**
 * @author mmikilchenko on 01.04.2017.
 */
@Entity
@Table(name = "public.note")
public class Note {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "title", length = 30)
    private String title;

    @Basic
    @Column(name = "text", length = 300)
    private String text;


    public Note() {
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;

    }

    public int getId() {
        return id;
    }

    public void setId(int pid) {
        this.id = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
