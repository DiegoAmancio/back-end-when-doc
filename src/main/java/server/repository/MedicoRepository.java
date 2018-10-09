package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.entities.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
