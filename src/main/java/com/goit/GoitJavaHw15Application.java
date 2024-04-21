package com.goit;

import com.goit.data.entity.NoteEntity;
import com.goit.data.repository.NoteRepository;
import com.goit.service.NoteService;
import com.goit.service.impl.NoteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class GoitJavaHw15Application {

    public static void main(String[] args) {SpringApplication.run(GoitJavaHw15Application.class, args);}

}
