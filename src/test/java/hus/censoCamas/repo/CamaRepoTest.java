package hus.censoCamas.repo;

import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Grupo;
import hus.censoCamas.model.Subgrupo;
import hus.censoCamas.model.Tipocama;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CamaRepoTest {
    @Autowired private CamaRepo undertest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByGrupoAndSubgrupoAndTipoAndEstado() {
        //given
        createCamas();
        String grupo = "UCI";
        String subgrupo = "QUIROFANOS";
        String tipo = "UNI";
        String estado = "";
        //when
        List<Cama> expected = undertest.findByGrupoAndSubgrupoAndTipoAndEstado(grupo, subgrupo,tipo, estado);
        //then
        assertThat(expected.size()).isEqualTo(2);


    }

    @Test
    void findByGrupoAndSubgrupo() {
    }

    @Test
    void findByGrupo() {
    }

    @Test
    void findByCodigo() {
    }

    @Test
    void findByCodigoAndDesocupada() {
    }

    @Test
    void findPaciente() {
    }

    @Test
    void findPacienteFinal() {
    }

    private void createCamas(){
        Grupo uci = new Grupo(1, "1","UCI");
        Subgrupo quirofano = new Subgrupo(1,"1","QUIROFANOS");
        Subgrupo adultos = new Subgrupo(2, "2","ADULTOS");
        Tipocama uni = new Tipocama(1,"1","UNI");
        Cama cama1 = new Cama(1, "CAMA1", "CAMA PRUEBA1", uci, quirofano, uni, 1);
        Cama cama2 = new Cama(2, "CAMA2", "CAMA PRUEBA2", uci, quirofano, uni, 2);
        Cama cama3 = new Cama(3, "CAMA3", "CAMA PRUEBA3", uci, adultos, uni, 3);
        undertest.save(cama1);
        undertest.save(cama2);
        undertest.save(cama3);
    }
}