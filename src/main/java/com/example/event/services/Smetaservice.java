package com.example.event.services;

import com.example.event.dto.SmetaCreationDTO;
import com.example.event.dto.SmetaDTO;
import com.example.event.dto.TreatmentSheduleDto;
import com.example.event.entity.Admin;
import com.example.event.entity.Smeta;
import com.example.event.entity.Treatment;
import com.example.event.repository.SmetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Smetaservice {
    final private SmetaRepository smetaRepository;
    final private TreatmentService treatmentService;

    public Smeta createSmeta(SmetaCreationDTO dto, Long id) {
        return smetaRepository.save(Smeta.builder()
                .category(dto.getCategory())
                .name(dto.getName())
                .expenses(dto.getExpenses())
                .treatment(treatmentService.findBiId(id))
                .build());
    }

    public void delete(Long id) {
        smetaRepository.deleteById(id);
    }

    public List<Smeta> readByTreatment(Long id) {
        System.out.println(id);
        return smetaRepository.findByTreatment_Id(id);
    }

    public Smeta findSmeta(SmetaDTO dto) {
        Smeta smeta = smetaRepository.findById(dto.getId()).orElseThrow();
        return smeta;
    }

    public Smeta update(SmetaDTO dto) {
        Smeta smeta = findSmeta(dto);
        smeta.setCategory(dto.getCategory());
        smeta.setName(dto.getName());
        smeta.setExpenses(dto.getExpenses());
        return smetaRepository.save(smeta);
    }

}
