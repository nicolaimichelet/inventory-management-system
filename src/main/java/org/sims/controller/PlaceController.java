package org.sims.controller;

import org.sims.model.Place;
import org.sims.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PlaceController {
    @Autowired
    PlaceRepository placeRepository;

    @GetMapping("/places")
    public List<Place> getAllPlaces() { return placeRepository.findAll(); }

    @PostMapping("/places")
    public Place createPlace(@Valid @RequestBody Place place) { return placeRepository.save(place); }



}
