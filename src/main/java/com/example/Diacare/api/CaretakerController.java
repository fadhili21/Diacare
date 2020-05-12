package com.example.Diacare.api;

import com.example.Diacare.model.Caretaker;
import com.example.Diacare.service.CaretakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/caretaker")
@RestController
public class CaretakerController {
    public final CaretakerService caretakerService;
@Autowired
    public CaretakerController(CaretakerService caretakerService) {
        this.caretakerService = caretakerService;
    }
@PostMapping

    public void addCaretaker(@RequestBody Caretaker caretaker){
        caretakerService.addCaretaker(caretaker);
    }
@GetMapping
    public List<Caretaker> getAllCaretaker(){
    return caretakerService.getAllCaretaker();
    }
@GetMapping(path = "{id}")
    public Caretaker getCaretakerById(@PathVariable("id") UUID id){
    return caretakerService.getCaretakerById(id)
            .orElse( null);
    }
@DeleteMapping
    public void deleteCaretakerById(@PathVariable("id") UUID id ) {
    caretakerService.deletecaretaker(id);
    }
@PutMapping (path = "{id}")
public void updateCaretaker(@PathVariable ("id")UUID id ,@RequestBody  Caretaker caretakerToUpdate) {
    caretakerService.updateCaretaker( id , caretakerToUpdate);
}
}
