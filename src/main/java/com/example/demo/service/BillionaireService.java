package com.example.demo.service;

import com.example.demo.model.dto.BillionaireDto;

public interface BillionaireService {

    boolean add(BillionaireDto billionaireDto);
    BillionaireDto findByName(String firstName, String lastName);
}
