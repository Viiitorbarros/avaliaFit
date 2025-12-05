package com.avaliaft.service;

import com.avaliaft.models.Avaliacao;
import com.avaliaft.models.Cliente;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class CalculoService {



    public Double calcularImc(Double peso, Double altura){

        Double imc = peso / (altura * altura);
        BigDecimal imcArredondado = BigDecimal.valueOf(imc);


        return arredondar(imc);
    }


    public Double calcularPercentualGordura(Avaliacao avaliacao){

        Double somaDasDobras = avaliacao.getAbdomen() + avaliacao.getCoxa() + avaliacao.getAxialMedia() +
                avaliacao.getSubEscapular() + avaliacao.getPeitoral() +  avaliacao.getTriceps() + avaliacao.getSupraIliaca();

        Double densidadeCorporal;

        Cliente cliente = avaliacao.getCliente();

        ///  Calculo caso seja Masculino
        if ("masculino".equalsIgnoreCase(cliente.getSexo())){
            densidadeCorporal = 1.112 - (0.00043499 * somaDasDobras) + (0.00000055  * (somaDasDobras * somaDasDobras)) -
                    (0.00028826 * cliente.getIdade());


        /// Calculo caso seja Feminino
        } else {

           densidadeCorporal = 1.097 - (0.00046971 * somaDasDobras ) + (0.00000056 * (somaDasDobras * somaDasDobras)) -
                    (0.00012828 * cliente.getIdade());

        }

        ///  Converter PG
        Double percentualGordura = ((4.95 / densidadeCorporal) - 4.50 ) * 100;

        return arredondar(percentualGordura);

    }


    private Double arredondar(Double valor) {
        if (valor == null || valor.isNaN() || valor.isInfinite()) return 0.0;

        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }


}
