package com.enotes.service.impl;
import com.enotes.dto.NoteRequestDto;
import com.enotes.dto.NoteResponseDto;
import com.enotes.mapper.NoteMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import  com.enotes.service.NoteService;
import com.enotes.repository.NoteRepository;
import  com.enotes.entity.Note;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }


//    CREATE NOTE (Post Api logic for creating new note)
    @Override
    public NoteResponseDto saveNote(NoteRequestDto requestDto) {


        Note note = noteMapper.toEntity(requestDto);
        System.out.println("Mapped title: " + note.getTitle());//only for print title
        Note savedNote = noteRepository.save(note);
        System.out.println(requestDto.getTitle());//only for print
        return noteMapper.toDto(savedNote);

    }

//    GET NOTES (Get Api logic for fetching all elements with pagination)
    @Override
    public Page<NoteResponseDto> getAllNotes(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Note> notePage = noteRepository.findAll(pageable);
        return notePage.map(noteMapper :: toDto);
    }


//    GET NOTE BY ID (get note by id Api logic for fetching particular note using id)
    @Override
    public NoteResponseDto getNoteById(Long id) {

        Note note = noteRepository.findById(id).orElseThrow(()-> new RuntimeException("Note not found with Id:"+id));
        return noteMapper.toDto(note);
    }



}
