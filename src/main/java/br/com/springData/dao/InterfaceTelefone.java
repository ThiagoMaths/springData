package br.com.springData.dao;

import br.com.springData.model.Telefone;
import jakarta.data.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InterfaceTelefone extends JpaRepository<Telefone, Long> {


}
