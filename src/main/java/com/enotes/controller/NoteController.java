package com.enotes.controller;
import com.enotes.dto.NoteRequestDto;
import com.enotes.dto.NoteResponseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.enotes.service.NoteService;
//import  com.enotes.entity.Note;


@RestController
@RequestMapping("/api/notes")
public class NoteController {


    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }


//         CREATE NOTE API
    @PostMapping
    public ResponseEntity<NoteResponseDto> createNote(@Valid @RequestBody NoteRequestDto requestDto){

        System.out.println("Title from request: " + requestDto.getTitle());

        NoteResponseDto saveNote = noteService.saveNote(requestDto);
        return ResponseEntity.ok(saveNote);
    }

//    GET ALL NOTES API

    @GetMapping
    public ResponseEntity<Page<NoteResponseDto>> getAllNotes(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){

        Page<NoteResponseDto> notes = noteService.getAllNotes(page, size);
        return ResponseEntity.ok(notes);
    }

//    GET NOTE BY ID API

    @GetMapping("/{id}")
    public  ResponseEntity<NoteResponseDto> getNoteById(@PathVariable Long id){
        NoteResponseDto note = noteService.getNoteById(id);
        return  ResponseEntity.ok(note);
    }

}
