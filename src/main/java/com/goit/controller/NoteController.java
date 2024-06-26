package com.goit.controller;

import com.goit.data.entity.NoteEntity;
import com.goit.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/test/note")
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView result = new ModelAndView("note/AllNotes");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "id") long id) {
        noteService.deleteById(id);
        return list();
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id") long id) {
        ModelAndView result = new ModelAndView("note/Edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id") long id,
                             @RequestParam(value = "title") String title,
                             @RequestParam(value = "content") String content) {
        NoteEntity note = noteService.getById(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return list();
    }
}
