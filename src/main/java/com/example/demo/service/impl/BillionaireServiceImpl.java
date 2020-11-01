package com.example.demo.service.impl;

import com.example.demo.model.dto.BillionaireDto;
import com.example.demo.model.entity.Billionaire;
import com.example.demo.repo.BillionaireRepo;
import com.example.demo.service.BillionaireService;
import liquibase.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillionaireServiceImpl implements BillionaireService {

    private final BillionaireRepo billionaireRepo;

    @Autowired
    public BillionaireServiceImpl(BillionaireRepo billionaireRepo) {
        this.billionaireRepo = billionaireRepo;
    }

    @Override
    public boolean add(BillionaireDto billionaireDto) {
        if (null == billionaireDto || StringUtils.isEmpty(billionaireDto.getFirstName()) || StringUtils.isEmpty(billionaireDto.getLastName())) {
            return false;
        }
        Billionaire billionaire = new Billionaire();
        BeanUtils.copyProperties(billionaireDto, billionaire);
        billionaireRepo.save(billionaire);
        return true;
    }

    @Override
    public BillionaireDto findByName(String firstName, String lastName) {
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)) {
            return null;
        }
        Billionaire billionaire = billionaireRepo.findByFirstNameAndLastName(firstName, lastName);
        if (null != billionaire) {
            return BillionaireDto.builder()
                    .firstName(billionaire.getFirstName())
                    .lastName(billionaire.getLastName())
                    .career(billionaire.getCareer())
                    .build();
        }
        return null;
    }

}
