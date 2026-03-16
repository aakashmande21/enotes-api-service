package com.enotes.service;
import com.enotes.dto.NoteRequestDto;
import com.enotes.dto.NoteResponseDto;
import  com.enotes.entity.Note;
import  java.util.List;
public interface NoteService {

    NoteResponseDto saveNote(NoteRequestDto requestDto);
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    void  deleteNote(Long id);
}
