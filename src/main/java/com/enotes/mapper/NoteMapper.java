package com.enotes.mapper;
import org.mapstruct.Mapper;
import com.enotes.dto.NoteRequestDto;
import com.enotes.dto.NoteResponseDto;
import com.enotes.entity.Note;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    Note toEntity(NoteRequestDto dto);

    NoteResponseDto toDto(Note note);
}
