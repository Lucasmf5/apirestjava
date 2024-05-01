package br.com.gerenciamentodepessoas.apirestjava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer bornDate;

    @Column(nullable = false)
    private String principalAdress;

    @Column()
    private String adress;

    @Column(nullable = false)
    private String publicPlace;

    @Column(nullable = false)
    private Integer cep;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer city;

    @Column(nullable = false)
    private String state;

    public People(String name, Integer bornDate, String adress, String publicPlace, Integer cep, Integer number,
            Integer city, String state) {
        this.name = name;
        this.bornDate = bornDate;
        this.adress = adress;
        this.publicPlace = publicPlace;
        this.cep = cep;
        this.number = number;
        this.city = city;
        this.state = state;
    }

}
