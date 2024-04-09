package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    boolean existsByTutorIdAndStatus(Long idTutor, StatusAdocao status);

    @Query("SELECT COUNT(a) >= 5 FROM Adocao a WHERE a.tutor.id = :idTutor AND a.status = :status")
    boolean existsByTutorIdAndStatusLimit5(Long idTutor, StatusAdocao status);
}
