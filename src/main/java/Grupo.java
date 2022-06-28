import java.util.Observable;

public class Grupo extends Observable {

    private String nomeGrupo;

    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public void receberMensagem() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return this.nomeGrupo;
    }
}