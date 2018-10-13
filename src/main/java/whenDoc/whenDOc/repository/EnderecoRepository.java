package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Endereco;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}