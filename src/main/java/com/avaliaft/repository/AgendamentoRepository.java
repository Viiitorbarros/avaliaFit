package com.avaliaft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.avaliaft.models.Agendamento;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByDataHora(LocalDateTime dataHora);

    //Optional<Agendamento> deleteAgendamentoById(Long id);
}
