package com.example.event.services;

import com.example.event.dto.ApplicationDTO;
import com.example.event.dto.TreatmentSheduleDto;
import com.example.event.entity.Application;
import com.example.event.entity.Rejected;
import com.example.event.entity.Treatment;
import com.example.event.repository.ApplicationRepository;
import com.example.event.repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TreatmentService {
    private TreatmentRepository treatmentRepository;
    private ApplicationService applicationService;

    public Treatment createTreatment(Long id) {
        Application application = applicationService.readById(id);
        application.setStatus("treatment");
        applicationService.update(application);
        Treatment treatment = new Treatment();
        treatment.setName(application.getName());
        treatment.setPhone(application.getPhone());
        treatment.setComments(application.getComments());
        treatment.setSource(application.getSource());
        treatment.setStatus("treatment");
        treatment.setApplication_id(id);
        return treatmentRepository.save(treatment);
    }
    public Treatment findBiId(Long id){
        return treatmentRepository.findById(id).orElseThrow();
    }
    public  Treatment shedule(TreatmentSheduleDto dto){
        Treatment treatment = findBiId(dto.getId());
        treatment.setSchesule(dto.getShedule());
        return treatmentRepository.save(treatment);
    }
    public  String findshedule(Long id){
        String zxc=findBiId(id).getSchesule();
        if (zxc==null)  return "";
        return findBiId(id).getSchesule();
    }
    public  void close(Long id){
        Treatment treatment = findBiId(id);
        if (treatment.getStatus().equals("closed")) treatment.setStatus("treatment");
        else  treatment.setStatus("closed");
        treatmentRepository.save(treatment);
    }
    public List<Treatment> readAll() {
        return  treatmentRepository.findAll();

    }
    public List<Treatment> closed() {
        List<Treatment> treatments = readAll();
        return treatments.stream()
                .filter(treatment -> !treatment.getStatus().equals("treatment"))
                .collect(Collectors.toList());
    }
    public List<Treatment> treatment() {
        List<Treatment> treatments = readAll();
        return treatments.stream()
                .filter(treatment ->treatment.getStatus().equals("treatment"))
                .collect(Collectors.toList());
    }

}
