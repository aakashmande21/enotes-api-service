package com.enotes.controller;
import com.enotes.dto.NoteRequestDto;
import com.enotes.dto.NoteResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.enotes.service.NoteService;
//import  com.enotes.entity.Note;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {


    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponseDto> createNote(@Valid @RequestBody NoteRequestDto requestDto){

        System.out.println("Title from request: " + requestDto.getTitle());

        NoteResponseDto saveNote = noteService.saveNote(requestDto);
        return ResponseEntity.ok(saveNote);
    }

}
