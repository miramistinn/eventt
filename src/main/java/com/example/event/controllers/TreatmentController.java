package com.example.event.controllers;

import com.example.event.dto.ApplicationDTO;
import com.example.event.dto.SmetaCreationDTO;
import com.example.event.dto.SmetaDTO;
import com.example.event.dto.TreatmentSheduleDto;
import com.example.event.entity.Application;
import com.example.event.entity.Rejected;
import com.example.event.entity.Smeta;
import com.example.event.entity.Treatment;
import com.example.event.services.ApplicationService;
import com.example.event.services.Smetaservice;
import com.example.event.services.TreatmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TreatmentController {
    private Smetaservice smetaservice;
    private TreatmentService treatmentService;
    @PostMapping("/create/treatment/{applicationId}")
    public ResponseEntity<Treatment> create(@PathVariable Long applicationId) {
        System.out.println("Пришло на сервер");
        Treatment treatment = treatmentService.createTreatment(applicationId);
        return new ResponseEntity<>(treatment, HttpStatus.OK);
    }
    @GetMapping("application/treatment/readAll")
    public ResponseEntity<List<Treatment>> readAll(){
        System.out.println("пришло на сервер");
        return new ResponseEntity<>(treatmentService.treatment(), HttpStatus.OK);
    }

    @GetMapping("application/closed/readAll")
    public ResponseEntity<List<Treatment>> readAllclosed(){
        System.out.println("пришло на сервер zxc");
        return new ResponseEntity<>(treatmentService.closed(), HttpStatus.OK);
    }
    @GetMapping("/treatment/read")
    public ResponseEntity<Treatment> readById(@RequestParam("id") Long id) {
        System.out.println("открытие страницы ифыу");
        Treatment treatment = treatmentService.findBiId(id);
        return ResponseEntity.ok(treatment);
    }
    @GetMapping("/treatment/read/shedule")
    public ResponseEntity<String> readScheduleById(@RequestParam("id") Long id) {
        System.out.println("поиск расписания");
        System.out.println(id);
        return ResponseEntity.ok(treatmentService.findshedule(id));
    }
    @PostMapping("/treatment/shedule")
    public HttpStatus shedule(@RequestBody TreatmentSheduleDto dto) {
        System.out.println("создание расписнаия");
        treatmentService.shedule(dto);
        return  HttpStatus.OK;
    }
    @PostMapping("/treatment/close")
    public HttpStatus close( @RequestParam("id") Long id) {
        System.out.println("закрытие заявки");
        treatmentService.close(id);
        return  HttpStatus.OK;
    }
    @GetMapping("/treatment/read/smeta")
    public ResponseEntity<List<Smeta>> readSmeta(@RequestParam("id") Long id) {
        System.out.println("поиск сметы");
        System.out.println(id);
        System.out.println(smetaservice.readByTreatment(id));
        return new ResponseEntity<>(smetaservice.readByTreatment(id), HttpStatus.OK);
    }
    @PostMapping("/treatment/create/smeta")
    public HttpStatus createSmeta(@RequestParam("id") Long id,@RequestBody SmetaCreationDTO dto) {
        System.out.println("добавление сметы");
        System.out.println(dto);
        smetaservice.createSmeta(dto, id);
        return  HttpStatus.OK;
    }
    @PostMapping("/treatment/change/smeta")
    public HttpStatus changeSmeta(@RequestBody SmetaDTO dto) {
        System.out.println("измененпие сметы");
        smetaservice.update(dto);
        return  HttpStatus.OK;
    }
    @PostMapping("/treatment/delete/smeta")
    public HttpStatus deleteSmeta(@RequestParam("id") Long id) {
        System.out.println("delete сметы");
        System.out.println(id);
        smetaservice.delete(id);
        return  HttpStatus.OK;
    }

}
