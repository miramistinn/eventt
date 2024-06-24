package com.example.event.controllers;

import com.example.event.dto.ClientDTO;
import com.example.event.dto.RejectDTO;
import com.example.event.entity.Application;
import com.example.event.entity.Rejected;
import com.example.event.services.ApplicationService;
import com.example.event.services.RejectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RejectController {
    private ApplicationService applicationService;
    private RejectService rejectService;
    @PostMapping("application/reject/{id}")
    public ResponseEntity<Application> reject(@PathVariable Long id){
//        System.out.println(id);
//        Application application = applicationService.readById(id);
//        application.setStatus("rejected");
//        applicationService.update(application);
//        System.out.println("Был отменен");
        return new ResponseEntity<>(applicationService.readById(id), HttpStatus.OK);
    }
    @PostMapping("application/reject")
    public HttpStatus rejectId(@RequestBody RejectDTO dto){
        System.out.println(dto.getId());
        Application application = applicationService.readById(dto.getId());
        application.setStatus("rejected");
        applicationService.update(application);
        System.out.println("Был отменен");
        System.out.println(dto.getCommentByAdmin());
        rejectService.rejected(dto);
        return HttpStatus.OK;
    }

    @GetMapping("application/reject/readAll")
    public ResponseEntity<List<Rejected>> readAll(){
        System.out.println("пришло на сервер");
        return new ResponseEntity<>(rejectService.readAllRejected(), HttpStatus.OK);
    }

}
