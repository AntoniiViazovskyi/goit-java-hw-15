package com.goit.data.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class NoteEntity {
    private UUID id;
    private String title;
    private String content;
}
