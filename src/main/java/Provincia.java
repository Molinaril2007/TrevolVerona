import java.util.*;

public class Provincia {
    ArrayList<Comune> comuni = new ArrayList<>();
    int V;
    List<List<Integer>> graph;
    Random rnd = new Random();
    Map<Integer, Comune> nomiComuni = new HashMap<>();
    ArrayList<Comune> scelte = new ArrayList<>();
    Comune S = null;
    Comune D = null;
    List<Integer> shortestpath;
    Comune affi, albaredoDAdige, angiari, arcole, badiaCalavena, bardolino, belfiore, bevilacqua, bonavigo, boschiSantAnna, boscoChiesanuova, bovolone, brentinoBelluno, brenzoneSulGarda, bussolengo, buttapietra, caldiero, caprinoVeronese, casaleone, castagnaro, castelDAzzano, castelnuovoDelGarda, cavaionVeronese, cazzanoDiTramigna, cerea, cerroVeronese, colognaVeneta, colognolaAiColli, concamarise, costermanoSulGarda, dolce, erbe, erbezzo, ferraraDiMonteBaldo, fumane, garda, gazzoVeronese, grezzana, illasi, isolaDellaScala, isolaRizza, lavagno, lazise, legnago, malcesine, maranoDiValpolicella, mezzaneDiSotto, minerbe, montecchiaDiCrosara, monteforteDAlpone, mozzecane, negrarDiValpolicella, nogara, nogaroleRocca, oppeano, palu, pastrengo, pescantina, peschieraDelGarda, poveglianoVeronese, pressana, rivoliVeronese, ronca, roncoAllAdige, roverchiara, rovereVeronese, roveredoDiGua, salizzole, sanBonifacio, sanGiovanniIlarione, sanGiovanniLupatoto, sanMartinoBuonAlbergo, sanMauroDiSaline, sanPietroDiMorubio, sanPietroInCariano, sanZenoDiMontagna, sanguinetto, santAmbrogioDiValpolicella, santAnnaDAlfaedo, selvaDiProgno, soave, sommacampagna, sona, sorga, terrazzo, torriDelBenaco, tregnago, trevenzuolo, valeggioSulMincio, veloVeronese, verona, veronella, vestenanova, vigasio, villaBartolomea, villafranca, zevio, zimella;

    public Provincia() {
        affi = new Comune("Affi");
        albaredoDAdige = new Comune("Albaredo d'Adige");
        angiari = new Comune("Angiari");
        arcole = new Comune("Arcole");
        badiaCalavena = new Comune("Badia Calavena");
        bardolino = new Comune("Bardolino");
        belfiore = new Comune("Belfiore");
        bevilacqua = new Comune("Bevilacqua");
        bonavigo = new Comune("Bonavigo");
        boschiSantAnna = new Comune("Boschi Sant'Anna");
        boscoChiesanuova = new Comune("Bosco Chiesanuova");
        bovolone = new Comune("Bovolone");
        brentinoBelluno = new Comune("Brentino Belluno");
        brenzoneSulGarda = new Comune("Brenzone sul Garda");
        bussolengo = new Comune("Bussolengo");
        buttapietra = new Comune("Buttapietra");
        caldiero = new Comune("Caldiero");
        caprinoVeronese = new Comune("Caprino Veronese");
        casaleone = new Comune("Casaleone");
        castagnaro = new Comune("Castagnaro");
        castelDAzzano = new Comune("Castel D'Azzano");
        castelnuovoDelGarda = new Comune("Castelnuovo del Garda");
        cavaionVeronese = new Comune("Cavaion Veronese");
        cazzanoDiTramigna = new Comune("Cazzano di Tramigna");
        cerea = new Comune("Cerea");
        cerroVeronese = new Comune("Cerro Veronese");
        colognaVeneta = new Comune("Cologna Veneta");
        colognolaAiColli = new Comune("Colognola ai Colli");
        concamarise = new Comune("Concamarise");
        costermanoSulGarda = new Comune("Costermano sul Garda");
        dolce = new Comune("Dolcè");
        erbe = new Comune("Erbè");
        erbezzo = new Comune("Erbezzo");
        ferraraDiMonteBaldo = new Comune("Ferrara di Monte Baldo");
        fumane = new Comune("Fumane");
        garda = new Comune("Garda");
        gazzoVeronese = new Comune("Gazzo Veronese");
        grezzana = new Comune("Grezzana");
        illasi = new Comune("Illasi");
        isolaDellaScala = new Comune("Isola della Scala");
        isolaRizza = new Comune("Isola Rizza");
        lavagno = new Comune("Lavagno");
        lazise = new Comune("Lazise");
        legnago = new Comune("Legnago");
        malcesine = new Comune("Malcesine");
        maranoDiValpolicella = new Comune("Marano di Valpolicella");
        mezzaneDiSotto = new Comune("Mezzane di Sotto");
        minerbe = new Comune("Minerbe");
        montecchiaDiCrosara = new Comune("Montecchia di Crosara");
        monteforteDAlpone = new Comune("Monteforte d'Alpone");
        mozzecane = new Comune("Mozzecane");
        negrarDiValpolicella = new Comune("Negrar di Valpolicella");
        nogara = new Comune("Nogara");
        nogaroleRocca = new Comune("Nogarole Rocca");
        oppeano = new Comune("Oppeano");
        palu = new Comune("Palù");
        pastrengo = new Comune("Pastrengo");
        pescantina = new Comune("Pescantina");
        peschieraDelGarda = new Comune("Peschiera del Garda");
        poveglianoVeronese = new Comune("Povegliano Veronese");
        pressana = new Comune("Pressana");
        rivoliVeronese = new Comune("Rivoli Veronese");
        ronca = new Comune("Roncà");
        roncoAllAdige = new Comune("Ronco all'Adige");
        roverchiara = new Comune("Roverchiara");
        rovereVeronese = new Comune("Roverè Veronese");
        roveredoDiGua = new Comune("Roveredo di Guà");
        salizzole = new Comune("Salizzole");
        sanBonifacio = new Comune("San Bonifacio");
        sanGiovanniIlarione = new Comune("San Giovanni Ilarione");
        sanGiovanniLupatoto = new Comune("San Giovanni Lupatoto");
        sanMartinoBuonAlbergo = new Comune("San Martino Buon Albergo");
        sanMauroDiSaline = new Comune("San Mauro di Saline");
        sanPietroDiMorubio = new Comune("San Pietro di Morubio");
        sanPietroInCariano = new Comune("San Pietro in Cariano");
        sanZenoDiMontagna = new Comune("San Zeno di Montagna");
        sanguinetto = new Comune("Sanguinetto");
        santAmbrogioDiValpolicella = new Comune("Sant'Ambrogio di Valpolicella");
        santAnnaDAlfaedo = new Comune("Sant'Anna d'Alfaedo");
        selvaDiProgno = new Comune("Selva di Progno");
        soave = new Comune("Soave");
        sommacampagna = new Comune("Sommacampagna");
        sona = new Comune("Sona");
        sorga = new Comune("Sorgà");
        terrazzo = new Comune("Terrazzo");
        torriDelBenaco = new Comune("Torri del Benaco");
        tregnago = new Comune("Tregnago");
        trevenzuolo = new Comune("Trevenzuolo");
        valeggioSulMincio = new Comune("Valeggio sul Mincio");
        veloVeronese = new Comune("Velo Veronese");
        veronella = new Comune("Veronella");
        vestenanova = new Comune("Vestenanova");
        vigasio = new Comune("Vigasio");
        villaBartolomea = new Comune("Villa Bartolomea");
        villafranca = new Comune("Villafranca");
        zevio = new Comune("Zevio");
        zimella = new Comune("Zimella");
        verona = new Comune("Verona");

        comuni.add(affi);
        comuni.add(albaredoDAdige);
        comuni.add(angiari);
        comuni.add(arcole);
        comuni.add(badiaCalavena);
        comuni.add(bardolino);
        comuni.add(belfiore);
        comuni.add(bevilacqua);
        comuni.add(bonavigo);
        comuni.add(boschiSantAnna);
        comuni.add(boscoChiesanuova);
        comuni.add(bovolone);
        comuni.add(brentinoBelluno);
        comuni.add(brenzoneSulGarda);
        comuni.add(bussolengo);
        comuni.add(buttapietra);
        comuni.add(caldiero);
        comuni.add(caprinoVeronese);
        comuni.add(casaleone);
        comuni.add(castagnaro);
        comuni.add(castelDAzzano);
        comuni.add(castelnuovoDelGarda);
        comuni.add(cavaionVeronese);
        comuni.add(cazzanoDiTramigna);
        comuni.add(cerea);
        comuni.add(cerroVeronese);
        comuni.add(colognaVeneta);
        comuni.add(colognolaAiColli);
        comuni.add(concamarise);
        comuni.add(costermanoSulGarda);
        comuni.add(dolce);
        comuni.add(erbe);
        comuni.add(erbezzo);
        comuni.add(ferraraDiMonteBaldo);
        comuni.add(fumane);
        comuni.add(garda);
        comuni.add(gazzoVeronese);
        comuni.add(grezzana);
        comuni.add(illasi);
        comuni.add(isolaDellaScala);
        comuni.add(isolaRizza);
        comuni.add(lavagno);
        comuni.add(lazise);
        comuni.add(legnago);
        comuni.add(malcesine);
        comuni.add(maranoDiValpolicella);
        comuni.add(mezzaneDiSotto);
        comuni.add(minerbe);
        comuni.add(montecchiaDiCrosara);
        comuni.add(monteforteDAlpone);
        comuni.add(mozzecane);
        comuni.add(negrarDiValpolicella);
        comuni.add(nogara);
        comuni.add(nogaroleRocca);
        comuni.add(oppeano);
        comuni.add(palu);
        comuni.add(pastrengo);
        comuni.add(pescantina);
        comuni.add(peschieraDelGarda);
        comuni.add(poveglianoVeronese);
        comuni.add(pressana);
        comuni.add(rivoliVeronese);
        comuni.add(ronca);
        comuni.add(roncoAllAdige);
        comuni.add(roverchiara);
        comuni.add(rovereVeronese);
        comuni.add(roveredoDiGua);
        comuni.add(salizzole);
        comuni.add(sanBonifacio);
        comuni.add(sanGiovanniIlarione);
        comuni.add(sanGiovanniLupatoto);
        comuni.add(sanMartinoBuonAlbergo);
        comuni.add(sanMauroDiSaline);
        comuni.add(sanPietroDiMorubio);
        comuni.add(sanPietroInCariano);
        comuni.add(sanZenoDiMontagna);
        comuni.add(sanguinetto);
        comuni.add(santAmbrogioDiValpolicella);
        comuni.add(santAnnaDAlfaedo);
        comuni.add(selvaDiProgno);
        comuni.add(soave);
        comuni.add(sommacampagna);
        comuni.add(sona);
        comuni.add(sorga);
        comuni.add(terrazzo);
        comuni.add(torriDelBenaco);
        comuni.add(tregnago);
        comuni.add(trevenzuolo);
        comuni.add(valeggioSulMincio);
        comuni.add(veloVeronese);
        comuni.add(veronella);
        comuni.add(vestenanova);
        comuni.add(vigasio);
        comuni.add(villaBartolomea);
        comuni.add(villafranca);
        comuni.add(zevio);
        comuni.add(zimella);
        comuni.add(verona);

        V = comuni.size();

        graph = new ArrayList<>(V);

        affi.addNeighbours(costermanoSulGarda, rivoliVeronese, cavaionVeronese, bardolino);
        albaredoDAdige.addNeighbours(veronella, roverchiara, bonavigo, roncoAllAdige, belfiore);
        angiari.addNeighbours(bonavigo, roverchiara, sanPietroDiMorubio, cerea, legnago);
        arcole.addNeighbours(zimella, veronella, belfiore, sanBonifacio);
        badiaCalavena.addNeighbours(vestenanova, tregnago, sanMauroDiSaline, veloVeronese, selvaDiProgno);
        bardolino.addNeighbours(lazise, pastrengo, cavaionVeronese, affi, costermanoSulGarda, torriDelBenaco);
        belfiore.addNeighbours(roncoAllAdige, zevio, caldiero, colognolaAiColli, soave, sanBonifacio, arcole, veronella, albaredoDAdige);
        bevilacqua.addNeighbours(boschiSantAnna, minerbe, terrazzo);
        bonavigo.addNeighbours(albaredoDAdige, veronella, minerbe, legnago, angiari, roverchiara);
        boschiSantAnna.addNeighbours(legnago, minerbe, bevilacqua, terrazzo);
        boscoChiesanuova.addNeighbours(erbezzo, grezzana, cerroVeronese, rovereVeronese);
        bovolone.addNeighbours(oppeano, isolaDellaScala, salizzole, concamarise, cerea, sanPietroDiMorubio, isolaRizza);
        brentinoBelluno.addNeighbours(caprinoVeronese, dolce, ferraraDiMonteBaldo, rivoliVeronese);
        brenzoneSulGarda.addNeighbours(sanZenoDiMontagna, malcesine, ferraraDiMonteBaldo, torriDelBenaco);
        bussolengo.addNeighbours(sona, pescantina, pastrengo, lazise, castelnuovoDelGarda, verona);
        buttapietra.addNeighbours(vigasio, castelDAzzano, sanGiovanniLupatoto, isolaDellaScala, oppeano, verona);
        caldiero.addNeighbours(sanMartinoBuonAlbergo, lavagno, colognolaAiColli, belfiore, zevio);
        caprinoVeronese.addNeighbours(sanZenoDiMontagna, ferraraDiMonteBaldo, brentinoBelluno, rivoliVeronese, costermanoSulGarda);
        casaleone.addNeighbours(sanguinetto, gazzoVeronese, cerea);
        castagnaro.addNeighbours(villaBartolomea, terrazzo);
        castelDAzzano.addNeighbours(vigasio, villafranca, verona);
        castelnuovoDelGarda.addNeighbours(peschieraDelGarda, lazise, bussolengo, sona, valeggioSulMincio);
        cavaionVeronese.addNeighbours(bardolino, affi, rivoliVeronese, santAmbrogioDiValpolicella);
        cazzanoDiTramigna.addNeighbours(colognolaAiColli, illasi, montecchiaDiCrosara, sanGiovanniIlarione, soave, tregnago);
        cerea.addNeighbours(casaleone, sanguinetto, concamarise, bovolone, sanPietroDiMorubio, angiari, legnago);
        cerroVeronese.addNeighbours(grezzana, boscoChiesanuova, rovereVeronese);
        colognaVeneta.addNeighbours(roveredoDiGua, pressana, veronella, zimella);
        colognolaAiColli.addNeighbours(caldiero, lavagno, illasi, cazzanoDiTramigna, soave, belfiore);
        concamarise.addNeighbours(sanguinetto, salizzole, bovolone, cerea);
        costermanoSulGarda.addNeighbours(garda, torriDelBenaco, sanZenoDiMontagna, caprinoVeronese, rivoliVeronese, affi, bardolino);
        dolce.addNeighbours(brentinoBelluno, rivoliVeronese, santAmbrogioDiValpolicella, fumane, santAnnaDAlfaedo);
        erbe.addNeighbours(sorga, isolaDellaScala, trevenzuolo, nogara);
        erbezzo.addNeighbours(santAnnaDAlfaedo, grezzana, boscoChiesanuova);
        ferraraDiMonteBaldo.addNeighbours(malcesine, brenzoneSulGarda, sanZenoDiMontagna, caprinoVeronese, brentinoBelluno);
        fumane.addNeighbours(dolce, santAmbrogioDiValpolicella, sanPietroInCariano, maranoDiValpolicella, santAnnaDAlfaedo);
        garda.addNeighbours(torriDelBenaco, costermanoSulGarda, bardolino);
        gazzoVeronese.addNeighbours(sorga, nogara, sanguinetto, casaleone);
        grezzana.addNeighbours(verona, negrarDiValpolicella, santAnnaDAlfaedo, boscoChiesanuova, erbezzo, cerroVeronese, rovereVeronese);
        illasi.addNeighbours(lavagno, mezzaneDiSotto, tregnago, cazzanoDiTramigna, colognolaAiColli);
        isolaDellaScala.addNeighbours(buttapietra, erbe, vigasio, trevenzuolo, sorga, oppeano, bovolone, salizzole, nogara);
        isolaRizza.addNeighbours(bovolone, oppeano, roncoAllAdige, roverchiara, sanPietroDiMorubio, bovolone);
        lavagno.addNeighbours(sanMartinoBuonAlbergo, mezzaneDiSotto, illasi, colognolaAiColli, caldiero);
        lazise.addNeighbours(bardolino, pastrengo, bussolengo, castelnuovoDelGarda);
        legnago.addNeighbours(cerea, angiari, bonavigo, minerbe, boschiSantAnna, terrazzo, villaBartolomea);
        malcesine.addNeighbours(brenzoneSulGarda, ferraraDiMonteBaldo);
        maranoDiValpolicella.addNeighbours(fumane, santAnnaDAlfaedo, negrarDiValpolicella, sanPietroInCariano);
        mezzaneDiSotto.addNeighbours(verona, tregnago, illasi, lavagno, sanMartinoBuonAlbergo);
        minerbe.addNeighbours(bevilacqua, pressana, boschiSantAnna, bonavigo, legnago, veronella);
        montecchiaDiCrosara.addNeighbours(cazzanoDiTramigna, monteforteDAlpone, ronca, sanGiovanniIlarione, soave);
        monteforteDAlpone.addNeighbours(montecchiaDiCrosara, sanBonifacio, soave);
        mozzecane.addNeighbours(poveglianoVeronese, nogaroleRocca, villafranca, valeggioSulMincio);
        negrarDiValpolicella.addNeighbours(grezzana, maranoDiValpolicella, sanPietroInCariano, santAnnaDAlfaedo, verona);
        nogara.addNeighbours(erbe, gazzoVeronese, isolaDellaScala, salizzole, sanguinetto, sorga);
        nogaroleRocca.addNeighbours(trevenzuolo, vigasio, mozzecane, poveglianoVeronese);
        oppeano.addNeighbours(bovolone, buttapietra, isolaDellaScala, isolaRizza, palu, roncoAllAdige, sanGiovanniLupatoto, zevio);
        palu.addNeighbours(oppeano, roncoAllAdige, zevio);
        pastrengo.addNeighbours(bardolino, bussolengo, cavaionVeronese, lazise, pescantina, santAmbrogioDiValpolicella);
        pescantina.addNeighbours(bussolengo, pastrengo, sanPietroInCariano, santAmbrogioDiValpolicella, verona);
        peschieraDelGarda.addNeighbours(castelnuovoDelGarda, valeggioSulMincio);
        poveglianoVeronese.addNeighbours(vigasio, nogaroleRocca, mozzecane, villafranca, castelDAzzano);
        pressana.addNeighbours(colognaVeneta, minerbe, roveredoDiGua, veronella);
        rivoliVeronese.addNeighbours(affi, brentinoBelluno, caprinoVeronese, cavaionVeronese, costermanoSulGarda, dolce, santAmbrogioDiValpolicella);
        ronca.addNeighbours(montecchiaDiCrosara, sanGiovanniIlarione);
        roncoAllAdige.addNeighbours(albaredoDAdige, belfiore, isolaRizza, oppeano, palu, roverchiara, zevio);
        roverchiara.addNeighbours(albaredoDAdige, angiari, bonavigo, isolaRizza, roncoAllAdige, sanPietroDiMorubio);
        rovereVeronese.addNeighbours(boscoChiesanuova, cerroVeronese, grezzana, sanMauroDiSaline, selvaDiProgno, veloVeronese, verona);
        roveredoDiGua.addNeighbours(colognaVeneta, pressana);
        salizzole.addNeighbours(bovolone, concamarise, isolaDellaScala, nogara, sanguinetto);
        sanBonifacio.addNeighbours(arcole, belfiore, monteforteDAlpone, soave);
        sanGiovanniIlarione.addNeighbours(cazzanoDiTramigna, montecchiaDiCrosara, ronca, tregnago, vestenanova);
        sanGiovanniLupatoto.addNeighbours(buttapietra, oppeano, sanMartinoBuonAlbergo, verona, zevio);
        sanMartinoBuonAlbergo.addNeighbours(caldiero, lavagno, mezzaneDiSotto, sanGiovanniLupatoto, verona, zevio);
        sanMauroDiSaline.addNeighbours(badiaCalavena, rovereVeronese, tregnago, veloVeronese, verona);
        sanPietroDiMorubio.addNeighbours(angiari, bovolone, cerea, isolaRizza, roverchiara);
        sanPietroInCariano.addNeighbours(fumane, maranoDiValpolicella, negrarDiValpolicella, pescantina, santAmbrogioDiValpolicella, verona);
        sanZenoDiMontagna.addNeighbours(brenzoneSulGarda, caprinoVeronese, costermanoSulGarda, ferraraDiMonteBaldo, torriDelBenaco);
        sanguinetto.addNeighbours(casaleone, cerea, concamarise, gazzoVeronese, nogara);
        santAmbrogioDiValpolicella.addNeighbours(pastrengo, cavaionVeronese, rivoliVeronese, dolce, fumane, sanPietroInCariano, pescantina);
        santAnnaDAlfaedo.addNeighbours(dolce, erbezzo, fumane, grezzana, maranoDiValpolicella, negrarDiValpolicella);
        selvaDiProgno.addNeighbours(badiaCalavena, boscoChiesanuova, rovereVeronese, veloVeronese, vestenanova);
        soave.addNeighbours(belfiore, cazzanoDiTramigna, colognolaAiColli, montecchiaDiCrosara, monteforteDAlpone, sanBonifacio);
        sommacampagna.addNeighbours(villafranca, valeggioSulMincio, sona, verona);
        sona.addNeighbours(bussolengo, castelnuovoDelGarda, sommacampagna, valeggioSulMincio, verona);
        sorga.addNeighbours(erbe, isolaDellaScala, nogara, gazzoVeronese);
        terrazzo.addNeighbours(bevilacqua, boschiSantAnna, legnago, villaBartolomea, castagnaro);
        torriDelBenaco.addNeighbours(brenzoneSulGarda, costermanoSulGarda, garda, sanZenoDiMontagna);
        tregnago.addNeighbours(badiaCalavena, cazzanoDiTramigna, illasi, mezzaneDiSotto, sanGiovanniIlarione, sanMauroDiSaline, verona, vestenanova);
        trevenzuolo.addNeighbours(erbe, isolaDellaScala, nogaroleRocca, vigasio);
        valeggioSulMincio.addNeighbours(sommacampagna, sona, villafranca, mozzecane, peschieraDelGarda, castelnuovoDelGarda);
        veloVeronese.addNeighbours(badiaCalavena, rovereVeronese, sanMauroDiSaline, selvaDiProgno);
        verona.addNeighbours(rovereVeronese, sanMauroDiSaline, tregnago, mezzaneDiSotto, sanMartinoBuonAlbergo, sanGiovanniLupatoto, buttapietra, castelDAzzano, villafranca, sommacampagna, sona, bussolengo, pescantina, sanPietroInCariano, negrarDiValpolicella, grezzana);
        veronella.addNeighbours(albaredoDAdige, arcole, belfiore, bonavigo, colognaVeneta, minerbe, pressana, zimella);
        vestenanova.addNeighbours(badiaCalavena, sanGiovanniIlarione, selvaDiProgno, tregnago);
        vigasio.addNeighbours(nogaroleRocca, buttapietra, isolaDellaScala, trevenzuolo, poveglianoVeronese, castelDAzzano);
        villaBartolomea.addNeighbours(castagnaro, legnago, terrazzo);
        villafranca.addNeighbours(castelDAzzano, mozzecane, poveglianoVeronese, sommacampagna, valeggioSulMincio, verona, vigasio);
        zevio.addNeighbours(belfiore, caldiero, oppeano, palu, roncoAllAdige, sanGiovanniLupatoto, sanMartinoBuonAlbergo);
        zimella.addNeighbours(arcole, colognaVeneta, veronella);



//        for (Comune c : comuni) {
//            graph.add(new ArrayList<>());
//        }



        for (Comune c : comuni) {
            nomiComuni.put(c.getId(), c);
        }


    }

    //Metodi Getter
    public ArrayList<Comune> getComuni() {
        return comuni;
    }
    public ArrayList<Comune> getScelte() {
        return scelte;
    }
    public Comune getS() {
        return S;
    }
    public Comune getD() {
        return D;
    }
    public List<Integer> getShortestpath() {
        return shortestpath;
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    public void setS(Comune s) {
        S = s;
    }

    public void setD(Comune d) {
        D = d;
    }

    public Comune getVerona() {
        return verona;
    }

    public void setVerona(Comune verona) {
        this.verona = verona;
    }

    public void setShortestpath(List<Integer> shortestpath) {
        this.shortestpath = shortestpath;
    }

    public List<List<Integer>> getGraph() {
        return graph;
    }

    public void setGraph(List<List<Integer>> graph) {
        this.graph = graph;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public Map<Integer, Comune> getNomiComuni() {
        return nomiComuni;
    }

    public void setNomiComuni(Map<Integer, Comune> nomiComuni) {
        this.nomiComuni = nomiComuni;
    }

    public void setComuni(ArrayList<Comune> comuni) {
        this.comuni = comuni;
    }
}
