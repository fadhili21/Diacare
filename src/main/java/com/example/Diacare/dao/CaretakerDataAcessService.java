package com.example.Diacare.dao;

import com.example.Diacare.model.Caretaker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("dummyDao") // for data access things we can change this to the database we re using
class CaretakerDataAccessService implements CaretakerDao {
    private static List<Caretaker> DB = new ArrayList<>();// this DB is the database list of caretakers

    @Override
    public int insertCaretaker(UUID id, @org.jetbrains.annotations.NotNull Caretaker caretaker) {
        DB.add(new Caretaker(id, caretaker.getName(), caretaker.getRelation(), caretaker.getPhoneNumber(), caretaker.getEmail()
                , caretaker.getAddress()));
        return 0;
    }

    @Override
    public List<Caretaker> selectAllCaretaker() {
        return DB;
    }


    @Override
    public Optional<Caretaker> selectCaretakerById(UUID id) {
        return DB.stream()
                .filter(caretaker -> caretaker.getId().equals(id))
                .findFirst();

    }

    @Override
    public int deleteCaretakerByID(UUID id) {
        Optional<Caretaker> caretakerMaybe = selectCaretakerById(id);
        if (caretakerMaybe.isPresent()) { //it's actully empty
            return 0;
        } else {
            DB.remove(caretakerMaybe.get());
            return 1;
        }
    }

    @Override
    public int updateCaretakerById(UUID id, Caretaker caretaker) {
        return selectCaretakerById(id)
                .map(c -> {
                    int indexOfCaretakerToDelete = DB.indexOf(caretaker);
                    if (indexOfCaretakerToDelete >= 0){
                        DB.set(indexOfCaretakerToDelete, caretaker);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
