package com.example.Diacare.service;

import com.example.Diacare.dao.CaretakerDao;
import com.example.Diacare.model.Caretaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CaretakerService {
    private  final CaretakerDao caretakerDao;
@Autowired
    public CaretakerService(@Qualifier("dummyDao") CaretakerDao caretakerDao) {
        this.caretakerDao = caretakerDao;
    }

    public int addCaretaker(Caretaker caretaker){
        return caretakerDao.insertCaretaker(caretaker);
    }
    public List<Caretaker> getAllCaretaker(){
        return caretakerDao.selectAllCaretaker();
    }
    public Optional<Caretaker> getCaretakerById(UUID id){
    return caretakerDao.selectCaretakerById(id);
    }
    public int deletecaretaker(UUID id){
    return caretakerDao.deleteCaretakerByID(id);
    }
    public int updateCaretaker(UUID id, Caretaker newCaretaker){
    return caretakerDao.updateCaretakerById( id, newCaretaker);
    }
}
