package com.goit.data.repository;

import com.goit.data.entity.NoteEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class NoteRepository {

    private final List<NoteEntity> noteList = new ArrayList<>();

    public NoteEntity save(NoteEntity note) {
        note.setId(UUID.randomUUID());
        noteList.add(note);
        return note;
    }

    public void deleteById(UUID id) {
        noteList.stream()
                .filter(noteEntity -> noteEntity.getId().equals(id))
                .findFirst().ifPresent(noteList::remove);
    }
    public void deleteById(long id) {
        noteList.stream()
                .filter(noteEntity -> noteEntity.getId().equals(id))
                .findFirst().ifPresent(noteList::remove);
    }

    public NoteEntity findById(UUID id) {
        Optional<NoteEntity> note = noteList.stream()
                .filter(noteEntity -> noteEntity.getId().equals(id))
                .findFirst();
        if(note.isPresent()) {
            return note.get();
        } else {
            throw new IllegalArgumentException("There is no note with id " + id);
        }
    }
    public NoteEntity findById(long id) {
        Optional<NoteEntity> note = noteList.stream()
                .filter(noteEntity -> noteEntity.getId().equals(id))
                .findFirst();
        if(note.isPresent()) {
            return note.get();
        } else {
            throw new IllegalArgumentException("There is no note with id " + id);
        }
    }

    public List<NoteEntity> getNoteList() {
        return noteList;
    }
}
