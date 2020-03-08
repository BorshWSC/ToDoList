package ru.tpu.msk30.todolist.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.msk30.todolist.domain.CheckablePoint;
import ru.tpu.msk30.todolist.repo.CheckablePointRepo;

import java.util.List;

@RestController
@RequestMapping("point")
public class CheckablePointController {

    private final CheckablePointRepo checkablePointRepo;

    @Autowired
    public CheckablePointController(CheckablePointRepo checkablePointRepo) {
        this.checkablePointRepo = checkablePointRepo;
    }

    @GetMapping
    public List<CheckablePoint> list(){

        return checkablePointRepo.findAll();

    }

    @GetMapping("{id}")
    public CheckablePoint getOne(@PathVariable("id") CheckablePoint checkablePoint){
        return checkablePoint;
    }

    @PostMapping
    public CheckablePoint create(@RequestBody CheckablePoint checkablePoint){
        return checkablePointRepo.save(new CheckablePoint(checkablePoint.getText()));
    }

    @PutMapping("/{id}")
    public CheckablePoint update(
            @PathVariable("id") CheckablePoint pointFromDB,
            @RequestBody CheckablePoint checkablePoint
    ){
        BeanUtils.copyProperties(checkablePoint, pointFromDB, "id");
        return checkablePointRepo.save(pointFromDB);
    }

    @DeleteMapping("id")
    public void delete(@PathVariable("id") CheckablePoint checkablePoint){
        checkablePointRepo.delete(checkablePoint);
    }
}
