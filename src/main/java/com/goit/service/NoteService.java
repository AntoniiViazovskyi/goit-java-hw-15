package com.goit.service;

import com.goit.data.entity.NoteEntity;

import java.util.List;

public interface NoteService {
    List<NoteEntity> listAll();
    NoteEntity add(NoteEntity note);
    void deleteById(long id);
    void update(NoteEntity note);
    NoteEntity getById(long id);
}
