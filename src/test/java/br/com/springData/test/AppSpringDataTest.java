package br.com.springData.test;

import br.com.springData.dao.InterfaceSpringDataUser;
import br.com.springData.dao.InterfaceTelefone;
import br.com.springData.model.Telefone;
import br.com.springData.model.UsuarioSpringData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring-config.xml"})
public class AppSpringDataTest {

    @Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

    @Autowired
    private InterfaceTelefone interfaceTelefone;

    @Test
    public void testInsert() {
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
    public void testConsulta() {
        Optional<UsuarioSpringData> user = interfaceSpringDataUser.findById(2L);

        System.out.println(user.get().getEmail());
        System.out.println(user.get().getSenha());
        System.out.println(user.get().getLogin());
        System.out.println(user.get().getIdade());
        System.out.println(user.get().getNome());

    }

    @Test
    public void testConsultaTodos() {
        List<UsuarioSpringData> usuarios = interfaceSpringDataUser.findAll();

        for (UsuarioSpringData usuario : usuarios) {
            System.out.println(usuario.getNome());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getIdade());
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    @Test
    public void testUpdate() {
        Optional<UsuarioSpringData> user = interfaceSpringDataUser.findById(52l);
        UsuarioSpringData usuario = user.get();

        usuario.setNome("Thiago Matheus");

        interfaceSpringDataUser.save(usuario);
    }

    @Test
    public void testDelete() {
        interfaceSpringDataUser.deleteById(50L);

    }

    @Test
    public void consultaNome() {
        List<UsuarioSpringData> list = interfaceSpringDataUser.findByNome("Thiago");

        for (UsuarioSpringData usuario : list) {
            System.out.println(usuario.getNome());
            System.out.println(usuario.getEmail());
            System.out.println(usuario.getSenha());
            System.out.println(usuario.getLogin());
            System.out.println(usuario.getIdade());
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    @Test
    public void consultaNomeParam() {
        UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.findByNomeParam("Thiago");

        System.out.println(usuarioSpringData.getNome());
        System.out.println(usuarioSpringData.getEmail());
        System.out.println(usuarioSpringData.getSenha());
        System.out.println(usuarioSpringData.getLogin());
        System.out.println(usuarioSpringData.getIdade());
        System.out.println("-----------------------------------------------------------------------");

    }

    @Test
    public void deletePorNome() {
        interfaceSpringDataUser.deleteByNome("Alex");
    }

    @Test
    public void updateTestEmail() {
        interfaceSpringDataUser.updateByEmailByAndNome("springdatatest@gmail.com.br", "Thiago Matheus");

    }

    @Test
    public void testInsertTelefone() {

      Optional <UsuarioSpringData> user = interfaceSpringDataUser.findById(1L);

        Telefone fone = new Telefone();
        fone.setTipo("Celular");
        fone.setNumero("21999999999");
        fone.setUsuario(user.get());

        interfaceTelefone.save(fone);
    }
}
