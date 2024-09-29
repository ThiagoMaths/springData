package br.com.springData.test;

import br.com.springData.dao.InterfaceSpringDataUser;
import br.com.springData.model.UsuarioSpringData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Test
    public void testInsert(){
        UsuarioSpringData user = new UsuarioSpringData();
        user.setNome("Matheus");
        user.setEmail("joao@gmail.com");
        user.setSenha("123456");
        user.setLogin("joao");
        user.setIdade(18);

    interfaceSpringDataUser.save(user);

    System.out.println("usuários cadastrados -> " + interfaceSpringDataUser.count());
    }
    @Test
    public void testConsulta(){
        Optional<UsuarioSpringData> user = interfaceSpringDataUser.findById(2L);

        System.out.println(user.get().getEmail());
        System.out.println(user.get().getSenha());
        System.out.println(user.get().getLogin());
        System.out.println(user.get().getIdade());
        System.out.println(user.get().getNome());



    }
}
