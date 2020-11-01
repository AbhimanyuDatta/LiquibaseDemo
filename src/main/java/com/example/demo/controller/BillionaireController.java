package com.example.demo.controller;

import com.example.demo.model.dto.BillionaireDto;
import com.example.demo.service.BillionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillionaireController {

    private final BillionaireService billionaireService;

    @Autowired
    public BillionaireController(BillionaireService billionaireService) {
        this.billionaireService = billionaireService;
    }

    @PostMapping("/{first_name}/{last_name}/{career}")
    public boolean add(@PathVariable("first_name") String firstName, @PathVariable("last_name") String lastName, @PathVariable("career") String career) {
        BillionaireDto billionaireDto = BillionaireDto.builder()
                .firstName(firstName)
                .lastName(lastName)
                .career(career)
                .build();
        return billionaireService.add(billionaireDto);
    }

    @GetMapping("/{first_name}/{last_name}")
    public BillionaireDto findByName(@PathVariable("first_name") String firstName, @PathVariable("last_name") String lastName) {
        return billionaireService.findByName(firstName, lastName);
    }

}
