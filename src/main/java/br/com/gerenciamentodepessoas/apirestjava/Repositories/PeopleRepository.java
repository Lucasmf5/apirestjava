package br.com.gerenciamentodepessoas.apirestjava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciamentodepessoas.apirestjava.models.People;

public interface PeopleRepository extends JpaRepository<People, Integer> {

}
