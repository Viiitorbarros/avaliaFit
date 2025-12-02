package com.avaliaft.service;

import com.avaliaft.models.Avaliacao;
import com.avaliaft.models.Cliente;
import org.springframework.stereotype.Service;

@Service
public class CalculoService {


    public Double calcularImc(Double peso, Double altura){

        Double imc = peso / (altura * altura);

        return imc;
    }


    public Double calcularDensidadeCorporal (Avaliacao avaliacao){

        Double somaDasDobras = avaliacao.getAbodmen() + avaliacao.getCoxa() + avaliacao.getAxialMedia() +
                avaliacao.getSubEscapular() + avaliacao.getPeitoral() +  avaliacao.getTriceps() + avaliacao.getSupraIliaca();

        Double densidadeCorporal;

        Cliente cliente = avaliacao.getCliente();

        ///  Calculo caso seja Masculino
        if (cliente.getSexo() == "M"){
            densidadeCorporal = 1.112 - (0.00043499 * somaDasDobras) + (0.00000055  * (somaDasDobras * somaDasDobras)) -
                    (0.00028826 * cliente.getIdade());


        /// Calculo caso seja Feminino
        } else {

           densidadeCorporal = 1.097 - (0.00046971 * somaDasDobras ) + (0.00000056 * (somaDasDobras * somaDasDobras)) -
                    (0.00012828 * cliente.getIdade());

        }

        Double percentualGordura = ((4.95 / densidadeCorporal) - 4.50 ) * 100;

        return percentualGordura;

    }



}
