package com.example.batchprocessing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class PeopleController {

    @GetMapping("/persons")
    public List<Person> getPerson() {

        return Collections.EMPTY_LIST;
    }
}
