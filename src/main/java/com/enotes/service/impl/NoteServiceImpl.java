package com.enotes.service.impl;
import com.enotes.dto.NoteRequestDto;
import com.enotes.dto.NoteResponseDto;
import com.enotes.mapper.NoteMapper;
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

    @Override
    public NoteResponseDto saveNote(NoteRequestDto requestDto) {


        Note note = noteMapper.toEntity(requestDto);
        System.out.println("Mapped title: " + note.getTitle());
        Note savedNote = noteRepository.save(note);
        System.out.println(requestDto.getTitle());
        return noteMapper.toDto(savedNote);

    }

    @Override
    public List<Note> getAllNotes() {

        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {

        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);

    }
}
