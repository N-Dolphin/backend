package org.example.backend.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "certification")
@Table(name = "certification")
public class CertificationEntity {

    @Column
    private String Id;

    @Id
    private String email;

    @Column
    private String certificationNumber;
}
