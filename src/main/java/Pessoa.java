import java.util.Observable;
import java.util.Observer;

public class Pessoa implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void entrarGrupo(Grupo grupo) {
        grupo.addObserver(this);
    }

    public void update(Observable turma, Object arg1) {
        this.ultimaNotificacao = this.nome + ", nova mensagem no grupo " + turma.toString();
    }
}