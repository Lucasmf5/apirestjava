package br.com.gerenciamentodepessoas.apirestjava.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
public class People {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotBlank(message = "O nome deve ser informado.")
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    @Min(19000000)
    private Integer bornDate;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotBlank(message = "O endereço principal deve ser informado.")
    private String principalAdress;

    @Getter
    @Setter
    @Column()
    private String secondAdress;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotBlank(message = "O logradouro do endereço principal deve ser informado.")
    private String publicPlacePrincipalAdress;

    @Getter
    @Setter
    @Column(nullable = false)
    @Min(value = 10000000, message = "O CEP deve conter oito digitos")
    @Max(value = 100000000, message = "O CEP deve conter oito digitos")
    private Integer cepPrincipalAdress;

    @Getter
    @Setter
    @Column(nullable = false)
    @Min(value = 0)
    private Integer numberPrincipalAdress;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotBlank(message = "A cidade do endereço principal deve ser informada.")
    private String cityPrincipalAdress;

    @Getter
    @Setter
    @Column(nullable = false)
    @NotBlank(message = "O estado do endereço principal deve ser informado.")
    private String statePrincipalAdress;

}
