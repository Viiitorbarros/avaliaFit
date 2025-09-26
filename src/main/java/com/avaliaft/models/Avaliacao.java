package com.avaliaft.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "avaliacao")
public class Avaliacao

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    double peso;
    double idade;

    double triceps;
    double peitoral;
    double supraIliaca;
    double axialMedia;
    double subEscapular;
    double abodmen;
    double coxa;

}
