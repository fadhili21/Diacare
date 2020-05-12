package com.example.Diacare.dao;

import com.example.Diacare.model.Caretaker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaretakerDao {
    /*here we put operations allowed by anyone who wishes to use this interface */
    int insertCaretaker(UUID id, Caretaker caretaker);

    default int insertCaretaker(Caretaker caretaker) {
        UUID id = UUID.randomUUID();
        return insertCaretaker(id, caretaker);
    }

    List<Caretaker> selectAllCaretaker();

    Optional<Caretaker> selectCaretakerById(UUID id);

    int deleteCaretakerByID(UUID id);

    int updateCaretakerById(UUID id, Caretaker caretaker);
}
