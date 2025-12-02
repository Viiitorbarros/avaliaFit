package com.avaliaft.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double peso;
    private Double altura;

    private Double triceps;
    private Double peitoral;
    private Double supraIliaca;
    private Double axialMedia;
    private Double subEscapular;
    private Double abodmen;
    private Double coxa;
    private Double imc;
    private Double percentualGordura;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cliente cliente;

    public Avaliacao(){

    }


    public Avaliacao(long id, Double peso, Double altura, Double triceps, Double peitoral, Double supraIliaca, Double axialMedia, Double subEscapular, Double abodmen, Double coxa) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getTriceps() {
        return triceps;
    }

    public void setTriceps(Double triceps) {
        this.triceps = triceps;
    }

    public Double getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(Double peitoral) {
        this.peitoral = peitoral;
    }

    public Double getSupraIliaca() {
        return supraIliaca;
    }

    public void setSupraIliaca(Double supraIliaca) {
        this.supraIliaca = supraIliaca;
    }

    public Double getAxialMedia() {
        return axialMedia;
    }

    public void setAxialMedia(Double axialMedia) {
        this.axialMedia = axialMedia;
    }

    public Double getSubEscapular() {
        return subEscapular;
    }

    public void setSubEscapular(Double subEscapular) {
        this.subEscapular = subEscapular;
    }

    public Double getAbodmen() {
        return abodmen;
    }

    public void setAbodmen(Double abodmen) {
        this.abodmen = abodmen;
    }

    public Double getCoxa() {
        return coxa;
    }

    public void setCoxa(Double coxa) {
        this.coxa = coxa;
    }

    public Double getImc(){
        return imc;
    }
    public void setImc(Double imc){
        this.imc = imc;
    }

    public Double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(Double percentualGordura) {
        this.percentualGordura = percentualGordura;
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
