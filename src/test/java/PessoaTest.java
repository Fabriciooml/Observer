import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    @Test
    void deveNotificarUmaPessoa() {
        Grupo grupo = new Grupo("Amigos do Bruno");
        Pessoa pessoa = new Pessoa("João");
        pessoa.entrarGrupo(grupo);
        grupo.receberMensagem();
        assertEquals("João, nova mensagem no grupo Amigos do Bruno", pessoa.getUltimaNotificacao());
    }

    @Test
    void deveNotificarPessoas() {
        Grupo grupo = new Grupo("Ângelo e companhia");
        Pessoa pessoa1 = new Pessoa("João");
        Pessoa pessoa2 = new Pessoa("José");
        pessoa1.entrarGrupo(grupo);
        pessoa2.entrarGrupo(grupo);
        grupo.receberMensagem();
        assertEquals("João, nova mensagem no grupo Ângelo e companhia", pessoa1.getUltimaNotificacao());
        assertEquals("José, nova mensagem no grupo Ângelo e companhia", pessoa2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarPessoa() {
        Grupo grupo = new Grupo("Deserto");
        Pessoa pessoa = new Pessoa("Joaquim");
        grupo.receberMensagem();
        assertEquals(null, pessoa.getUltimaNotificacao());
    }

    @Test
    void deveNotificarPessoaGrupoA() {
        Grupo grupoA = new Grupo("Motoristas de Uber");
        Grupo grupoB = new Grupo("Táxistas");
        Pessoa pessoa1 = new Pessoa("João");
        Pessoa pessoa2 = new Pessoa("José");
        pessoa1.entrarGrupo(grupoA);
        pessoa2.entrarGrupo(grupoB);
        grupoA.receberMensagem();
        assertEquals("João, nova mensagem no grupo Motoristas de Uber", pessoa1.getUltimaNotificacao());
        assertEquals(null, pessoa2.getUltimaNotificacao());
    }
}