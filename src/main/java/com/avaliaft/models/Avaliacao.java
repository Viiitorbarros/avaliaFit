package com.avaliaft.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    double peso;
    double altura;

    double triceps;
    double peitoral;
    double supraIliaca;
    double axialMedia;
    double subEscapular;
    double abodmen;
    double coxa;

    public Avaliacao(){

    }


    public Avaliacao(long id, double peso, double altura, double triceps, double peitoral, double supraIliaca, double axialMedia, double subEscapular, double abodmen, double coxa) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.triceps = triceps;
        this.peitoral = peitoral;
        this.supraIliaca = supraIliaca;
        this.axialMedia = axialMedia;
        this.subEscapular = subEscapular;
        this.abodmen = abodmen;
        this.coxa = coxa;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getTriceps() {
        return triceps;
    }

    public void setTriceps(double triceps) {
        this.triceps = triceps;
    }

    public double getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(double peitoral) {
        this.peitoral = peitoral;
    }

    public double getSupraIliaca() {
        return supraIliaca;
    }

    public void setSupraIliaca(double supraIliaca) {
        this.supraIliaca = supraIliaca;
    }

    public double getAxialMedia() {
        return axialMedia;
    }

    public void setAxialMedia(double axialMedia) {
        this.axialMedia = axialMedia;
    }

    public double getSubEscapular() {
        return subEscapular;
    }

    public void setSubEscapular(double subEscapular) {
        this.subEscapular = subEscapular;
    }

    public double getAbodmen() {
        return abodmen;
    }

    public void setAbodmen(double abodmen) {
        this.abodmen = abodmen;
    }

    public double getCoxa() {
        return coxa;
    }

    public void setCoxa(double coxa) {
        this.coxa = coxa;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return id == avaliacao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
