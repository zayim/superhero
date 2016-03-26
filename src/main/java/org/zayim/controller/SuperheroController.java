package org.zayim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zayim.service.SuperheroService;

@RestController
@RequestMapping("/superhero")
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

    @RequestMapping("/foo")
    public String foo() {
        return superheroService.foo();
    }
}
