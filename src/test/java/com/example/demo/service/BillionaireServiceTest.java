package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.model.dto.BillionaireDto;
import com.example.demo.repo.BillionaireRepo;
import com.example.demo.service.impl.BillionaireServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class BillionaireServiceTest {

    @Autowired
    private BillionaireRepo billionaireRepo;

    private BillionaireService billionaireService;

    @BeforeEach
    public void before() {
        billionaireService = new BillionaireServiceImpl(billionaireRepo);
    }

    @Test
    public void findByName_GivenFirstAndLastName_ThenOk() {
        BillionaireDto billionaireDto = billionaireService.findByName("Abc", "Xyz");
        Assertions.assertNotNull(billionaireDto);
    }

}
