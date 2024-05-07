import java.util.*;

/*
IDEE PER IL TRAVLE:
-dato che verona ha molti confini, fare una modalità per rimuovere Verona dalle scelte.
-sito web trevol
-modalità dove scegli tu i comuni di inizio e di fine
-modalità facile con la griglia dei comuni mostarta (creare una mappa con la griglia, modificare il metodo nel controller createNewSVGFile())
-riguardare zona lago (confini torri del banaco, garda, costermano)...
-JOptionPane personalizzate per messaggi mostrati in maniera un po' più carina
-controllare che i comuni di inizio e di fine non siano direttamente confinanti (ok)
-aggiungere un pannello sotto alla barra di testo con i possibili suggerimenti (nomi dei comuni). Vedi es ChatGPT
*/


public class Main {
    public static void main(String[] args)  {
        Provincia provincia = new Provincia();
        View vista = new View("Trevol Verona", provincia.getS(), provincia.getD(), provincia.getShortestpath().size()-2);
        PrimaView primaView = new PrimaView(provincia.getComuni());
        Controller controller = new Controller(vista, primaView, provincia.getComuni(), provincia.getScelte());
    }
}
