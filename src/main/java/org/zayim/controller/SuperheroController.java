package org.zayim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.zayim.model.Superhero;
import org.zayim.model.SuperheroError;
import org.zayim.service.SuperheroService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/superhero")
public class SuperheroController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperheroController.class);

    @Autowired
    private SuperheroService superheroService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Superhero> add(@Valid @RequestBody Superhero superhero) {

        LOGGER.debug("add(superhero={})", superhero);

        return ResponseEntity.ok(superheroService.save(superhero));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Superhero>> getAll() {

        LOGGER.debug("getAll()");

        return ResponseEntity.ok(superheroService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Superhero> getById(@PathVariable Integer id) {

        LOGGER.debug("getById(id={})", id);

        Superhero superhero = superheroService.findById(id);
        return superhero != null ?
                ResponseEntity.ok(superhero) :
                new ResponseEntity<>(superhero, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<SuperheroError> handleValidationException(MethodArgumentNotValidException e) {

        return new ResponseEntity<>(SuperheroError.of(e.getBindingResult().getAllErrors().get(0)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SuperheroError> handleInternalException(Exception e) {

        LOGGER.error("exception", e);

        return new ResponseEntity<>(SuperheroError.of("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
