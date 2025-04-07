import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPartite implements Serializable {
    List<Partita> listaPartiteGiocate;

    public ListaPartite() {
        listaPartiteGiocate = new ArrayList<>();
    }

    @Override
    public String toString() {
        String temp = "Lista partite: ";
        for (Partita partita : listaPartiteGiocate) {
            temp += "\n"+partita;
        }
        return temp;
    }

    public List<Partita> getListaPartiteGiocate() {
        return listaPartiteGiocate;
    }

    public void setListaPartiteGiocate(List<Partita> listaPartiteGiocate) {
        this.listaPartiteGiocate = listaPartiteGiocate;
    }
}
