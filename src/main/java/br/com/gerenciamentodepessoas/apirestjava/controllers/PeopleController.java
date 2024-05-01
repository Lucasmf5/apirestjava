package br.com.gerenciamentodepessoas.apirestjava.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentodepessoas.apirestjava.Repositories.PeopleRepository;
import br.com.gerenciamentodepessoas.apirestjava.models.People;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping("")
    public java.util.List<People> list() {
        return peopleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> listByID(@PathVariable Integer id) {
        Optional<People> people = peopleRepository.findById(id);
        if (!people.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<People>(people.get(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid People people) {

        People newPeople = peopleRepository.save(people);
        return new ResponseEntity<Object>(newPeople, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody @Valid People people) {
        Optional<People> oldPeople = peopleRepository.findById(id);
        if (!oldPeople.isPresent()) {
            return ResponseEntity.badRequest().body("A pessoa informada não existe");
        }

        People updatePeople = oldPeople.get();
        updatePeople.setName(people.getName());
        updatePeople.setBornDate(people.getBornDate());
        updatePeople.setSecondAdress(people.getSecondAdress());
        updatePeople.setPrincipalAdress(people.getPrincipalAdress());
        updatePeople.setNumberPrincipalAdress(people.getNumberPrincipalAdress());
        updatePeople.setPublicPlacePrincipalAdress(people.getPublicPlacePrincipalAdress());
        updatePeople.setCityPrincipalAdress(people.getCityPrincipalAdress());
        updatePeople.setStatePrincipalAdress(people.getStatePrincipalAdress());

        peopleRepository.save(updatePeople);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/adress/{id}")
    public ResponseEntity<Object> updateAdress(@PathVariable Integer id, @RequestBody @Valid People people) {
        Optional<People> oldPeople = peopleRepository.findById(id);
        if (!oldPeople.isPresent()) {
            return ResponseEntity.badRequest().body("A pessoa informada não existe");
        }

        People updatePeople = oldPeople.get();

        updatePeople.setSecondAdress(people.getSecondAdress());
        updatePeople.setPrincipalAdress(people.getPrincipalAdress());
        updatePeople.setNumberPrincipalAdress(people.getNumberPrincipalAdress());
        updatePeople.setPublicPlacePrincipalAdress(people.getPublicPlacePrincipalAdress());
        updatePeople.setCityPrincipalAdress(people.getCityPrincipalAdress());
        updatePeople.setStatePrincipalAdress(people.getStatePrincipalAdress());

        peopleRepository.save(updatePeople);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Optional<People> oldPeople = peopleRepository.findById(id);
        if (!oldPeople.isPresent()) {
            return ResponseEntity.badRequest().body("A pessoa informada não existe");
        }
        peopleRepository.delete(oldPeople.get());
        return ResponseEntity.noContent().build();
    }

}
