package com.example.demo.repo;

import com.example.demo.model.entity.Billionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillionaireRepo extends JpaRepository<Billionaire, Long> {

    Billionaire findByFirstNameAndLastName(String firstName, String lastName);

}
