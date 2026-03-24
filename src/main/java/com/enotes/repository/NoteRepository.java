package com.enotes.repository;
import org.hibernate.query.Page;
import  org.springframework.data.jpa.repository.JpaRepository;
import com.enotes.entity.Note;

import java.awt.print.Pageable;

public interface NoteRepository extends JpaRepository<Note, Long>{



}
