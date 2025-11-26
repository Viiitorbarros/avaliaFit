package com.avaliaft.service;


import com.avaliaft.models.Avaliacao;
import com.avaliaft.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    ClienteService clienteService;

    public Avaliacao findById(Long id){

       return avaliacaoRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("\"Avaliação não encontrada com id: \" + id"));


    }

    //Criar avaliacao
    public Avaliacao create(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }


    //Deletar avaliacao
    public void delete(Long id){

      Optional<Avaliacao> avaliacaoExistente = avaliacaoRepository.findById(id);
      avaliacaoRepository.delete(avaliacaoExistente.orElseThrow(()->new RuntimeException("Avaliação nao encontrada.")));

    }


    public Avaliacao update (Avaliacao avaliacaoAtualizada,Long id){
        Avaliacao avaliacaoExistente = findById(id);

        //CADA IF REPRESENTA UMA ATUALIZAÇAO PARA CADA ITEM DA AVALIACAO

        if (avaliacaoAtualizada.getAbodmen() != null){
            avaliacaoExistente.setAbodmen(avaliacaoAtualizada.getAbodmen());
        }
        if (avaliacaoAtualizada.getAltura() != null){
            avaliacaoExistente.setAltura(avaliacaoAtualizada.getAltura());
        }
        if (avaliacaoAtualizada.getPeso() != null){
            avaliacaoExistente.setPeso(avaliacaoAtualizada.getPeso());
        }
        if (avaliacaoAtualizada.getTriceps() != null){
            avaliacaoExistente.setTriceps(avaliacaoAtualizada.getTriceps());
        }
        if (avaliacaoAtualizada.getPeitoral()!=null){
            avaliacaoExistente.setPeitoral(avaliacaoAtualizada.getPeitoral());
        }
        if (avaliacaoAtualizada.getSupraIliaca()!=null){
            avaliacaoExistente.setSupraIliaca(avaliacaoAtualizada.getSupraIliaca());
        }
        if (avaliacaoAtualizada.getAxialMedia()!=null){
            avaliacaoExistente.setAxialMedia(avaliacaoAtualizada.getAxialMedia());
        }
        if (avaliacaoAtualizada.getSubEscapular()!=null){
            avaliacaoExistente.setSubEscapular(avaliacaoAtualizada.getSubEscapular());
        }
        if (avaliacaoAtualizada.getCoxa()!= null){
            avaliacaoExistente.setCoxa(avaliacaoAtualizada.getCoxa());
        }

        return avaliacaoRepository.save(avaliacaoExistente);

    }






}
