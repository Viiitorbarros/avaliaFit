package com.avaliaft.service;


import com.avaliaft.models.Avaliacao;
import com.avaliaft.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;


    public Avaliacao findById(Long id){

       return avaliacaoRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("\"Avaliação não encontrada com id: \" + id"));


    }








}
