package com.avaliaft.service;

import com.avaliaft.models.Avaliacao;
import com.avaliaft.models.Cliente;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CalculoService {

   DecimalFormat decimalFormat = new DecimalFormat("#,##");

    public Double calcularImc(Double peso, Double altura){

        Double imc = peso / (altura * altura);

        imc = Double.valueOf(decimalFormat.format(imc));

        return imc;
    }


    public Double calcularPercentualGordura(Avaliacao avaliacao){

        Double somaDasDobras = avaliacao.getAbdomen() + avaliacao.getCoxa() + avaliacao.getAxialMedia() +
                avaliacao.getSubEscapular() + avaliacao.getPeitoral() +  avaliacao.getTriceps() + avaliacao.getSupraIliaca();

        Double densidadeCorporal;

        Cliente cliente = avaliacao.getCliente();

        ///  Calculo caso seja Masculino
        if (cliente.getSexo().equals("masculino")){
            densidadeCorporal = 1.112 - (0.00043499 * somaDasDobras) + (0.00000055  * (somaDasDobras * somaDasDobras)) -
                    (0.00028826 * cliente.getIdade());


        /// Calculo caso seja Feminino
        } else {

           densidadeCorporal = 1.097 - (0.00046971 * somaDasDobras ) + (0.00000056 * (somaDasDobras * somaDasDobras)) -
                    (0.00012828 * cliente.getIdade());

        }

        ///  Converter PG


        Double percentualGordura = ((4.95 / densidadeCorporal) - 4.50 ) * 100;
        percentualGordura = Double.valueOf(decimalFormat.format(percentualGordura));



        return percentualGordura;

    }



}
