import java.io.Serializable;
import java.util.*;

public class Comune implements Serializable {
    private static int progressive = 0;

    private String nome = "";
    private int id = 0;
    private Set<Comune> neighbours = new HashSet<>();

    public Comune(String nome) {
        this.nome = nome;
        this.id = Comune.progressive++;
    }

    public void addNeighbours(Comune ...comuni) {
        this.neighbours.addAll(Arrays.asList(comuni));
    }
    public void removeNeighbours (Comune comune) {
        this.neighbours.remove(comune);
    }


    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public Set<Comune> getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nome;
    }
}
