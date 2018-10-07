package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
