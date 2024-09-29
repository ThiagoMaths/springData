package br.com.springData.dao;

import br.com.springData.model.UsuarioSpringData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceSpringDataUser extends JpaRepository<UsuarioSpringData, Long> {

}
