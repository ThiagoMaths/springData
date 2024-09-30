package br.com.springData.dao;

import br.com.springData.model.UsuarioSpringData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends JpaRepository<UsuarioSpringData, Long> {

    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    public List<UsuarioSpringData> findByNome(String nome);


    @Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
    public UsuarioSpringData findByNomeParam(@Param("paramnome") String paramnome);

    @Modifying
    @Transactional
    @Query(value = "delete from UsuarioSpringData u where u.nome = ?1 ")
    public void  deleteByNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
    public void updateByEmailByAndNome(String email, String nome);

}
