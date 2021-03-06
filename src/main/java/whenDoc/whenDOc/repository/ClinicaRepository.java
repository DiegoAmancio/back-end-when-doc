package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Clinica;


@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

}
