import java.util.*;

public class Provincia {
    ArrayList<Comune> comuni = new ArrayList<>();
    Random rnd = new Random();
    Map<Integer, Comune> nomiComuni = new HashMap<>();
    ArrayList<Comune> scelte = new ArrayList<>();
    Comune S = null;
    Comune D = null;
    List<Integer> shortestpath;
    public Provincia() {
        Comune affi = new Comune("Affi");
        Comune albaredoDAdige = new Comune("Albaredo d'Adige");
        Comune angiari = new Comune("Angiari");
        Comune arcole = new Comune("Arcole");
        Comune badiaCalavena = new Comune("Badia Calavena");
        Comune bardolino = new Comune("Bardolino");
        Comune belfiore = new Comune("Belfiore");
        Comune bevilacqua = new Comune("Bevilacqua");
        Comune bonavigo = new Comune("Bonavigo");
        Comune boschiSantAnna = new Comune("Boschi Sant'Anna");
        Comune boscoChiesanuova = new Comune("Bosco Chiesanuova");
        Comune bovolone = new Comune("Bovolone");
        Comune brentinoBelluno = new Comune("Brentino Belluno");
        Comune brenzoneSulGarda = new Comune("Brenzone sul Garda");
        Comune bussolengo = new Comune("Bussolengo");
        Comune buttapietra = new Comune("Buttapietra");
        Comune caldiero = new Comune("Caldiero");
        Comune caprinoVeronese = new Comune("Caprino Veronese");
        Comune casaleone = new Comune("Casaleone");
        Comune castagnaro = new Comune("Castagnaro");
        Comune castelDAzzano = new Comune("Castel D'Azzano");
        Comune castelnuovoDelGarda = new Comune("Castelnuovo del Garda");
        Comune cavaionVeronese = new Comune("Cavaion Veronese");
        Comune cazzanoDiTramigna = new Comune("Cazzano di Tramigna");
        Comune cerea = new Comune("Cerea");
        Comune cerroVeronese = new Comune("Cerro Veronese");
        Comune colognaVeneta = new Comune("Cologna Veneta");
        Comune colognolaAiColli = new Comune("Colognola ai Colli");
        Comune concamarise = new Comune("Concamarise");
        Comune costermanoSulGarda = new Comune("Costermano sul Garda");
        Comune dolce = new Comune("Dolc\u00e8");
        Comune erbe = new Comune("Erb\u00e8");
        Comune erbezzo = new Comune("Erbezzo");
        Comune ferraraDiMonteBaldo = new Comune("Ferrara di Monte Baldo");
        Comune fumane = new Comune("Fumane");
        Comune garda = new Comune("Garda");
        Comune gazzoVeronese = new Comune("Gazzo Veronese");
        Comune grezzana = new Comune("Grezzana");
        Comune illasi = new Comune("Illasi");
        Comune isolaDellaScala = new Comune("Isola della Scala");
        Comune isolaRizza = new Comune("Isola Rizza");
        Comune lavagno = new Comune("Lavagno");
        Comune lazise = new Comune("Lazise");
        Comune legnago = new Comune("Legnago");
        Comune malcesine = new Comune("Malcesine");
        Comune maranoDiValpolicella = new Comune("Marano di Valpolicella");
        Comune mezzaneDiSotto = new Comune("Mezzane di Sotto");
        Comune minerbe = new Comune("Minerbe");
        Comune montecchiaDiCrosara = new Comune("Montecchia di Crosara");
        Comune monteforteDAlpone = new Comune("Monteforte d'Alpone");
        Comune mozzecane = new Comune("Mozzecane");
        Comune negrarDiValpolicella = new Comune("Negrar di Valpolicella");
        Comune nogara = new Comune("Nogara");
        Comune nogaroleRocca = new Comune("Nogarole Rocca");
        Comune oppeano = new Comune("Oppeano");
        Comune palu = new Comune("Pal\u00f9");
        Comune pastrengo = new Comune("Pastrengo");
        Comune pescantina = new Comune("Pescantina");
        Comune peschieraDelGarda = new Comune("Peschiera del Garda");
        Comune poveglianoVeronese = new Comune("Povegliano Veronese");
        Comune pressana = new Comune("Pressana");
        Comune rivoliVeronese = new Comune("Rivoli Veronese");
        Comune ronca = new Comune("Ronc\u00e0");
        Comune roncoAllAdige = new Comune("Ronco all'Adige");
        Comune roverchiara = new Comune("Roverchiara");
        Comune rovereVeronese = new Comune("Rover\u00e8 Veronese");
        Comune roveredoDiGua = new Comune("Roveredo di Gu\u00e0");
        Comune salizzole = new Comune("Salizzole");
        Comune sanBonifacio = new Comune("San Bonifacio");
        Comune sanGiovanniIlarione = new Comune("San Giovanni Ilarione");
        Comune sanGiovanniLupatoto = new Comune("San Giovanni Lupatoto");
        Comune sanMartinoBuonAlbergo = new Comune("San Martino Buon Albergo");
        Comune sanMauroDiSaline = new Comune("San Mauro di Saline");
        Comune sanPietroDiMorubio = new Comune("San Pietro di Morubio");
        Comune sanPietroInCariano = new Comune("San Pietro in Cariano");
        Comune sanZenoDiMontagna = new Comune("San Zeno di Montagna");
        Comune sanguinetto = new Comune("Sanguinetto");
        Comune santAmbrogioDiValpolicella = new Comune("Sant'Ambrogio di Valpolicella");
        Comune santAnnaDAlfaedo = new Comune("Sant'Anna d'Alfaedo");
        Comune selvaDiProgno = new Comune("Selva di Progno");
        Comune soave = new Comune("Soave");
        Comune sommacampagna = new Comune("Sommacampagna");
        Comune sona = new Comune("Sona");
        Comune sorga = new Comune("Sorg\u00e0");
        Comune terrazzo = new Comune("Terrazzo");
        Comune torriDelBenaco = new Comune("Torri del Benaco");
        Comune tregnago = new Comune("Tregnago");
        Comune trevenzuolo = new Comune("Trevenzuolo");
        Comune valeggioSulMincio = new Comune("Valeggio sul Mincio");
        Comune veloVeronese = new Comune("Velo Veronese");
        Comune verona = new Comune("Verona");
        Comune veronella = new Comune("Veronella");
        Comune vestenanova = new Comune("Vestenanova");
        Comune vigasio = new Comune("Vigasio");
        Comune villaBartolomea = new Comune("Villa Bartolomea");
        Comune villafranca = new Comune("Villafranca di Verona");
        Comune zevio = new Comune("Zevio");
        Comune zimella = new Comune("Zimella");


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
        comuni.add(verona);
        comuni.add(veronella);
        comuni.add(vestenanova);
        comuni.add(vigasio);
        comuni.add(villaBartolomea);
        comuni.add(villafranca);
        comuni.add(zevio);
        comuni.add(zimella);

        int V = comuni.size();

        ArrayList<List<Integer>> graph = new ArrayList<>(V);

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

        do {
            S = comuni.get(rnd.nextInt(comuni.size()));
            D = comuni.get(rnd.nextInt(comuni.size()));
        } while (S.equals(D) || S.getNeighbours().contains(D));

        for (Comune c : comuni) {
            graph.add(new ArrayList<>());
        }

        for (Comune c : comuni) {
            ArrayList<Integer> neighbourIds = new ArrayList<>();
            for (Comune n : c.getNeighbours()) {
                neighbourIds.add(n.getId());
            }
            graph.set(c.getId(), neighbourIds);
        }

        for (Comune c : comuni) {
            nomiComuni.put(c.getId(), c);
        }

        shortestpath = ShortestPathBFS.shortestDistance(graph, S.getId(), D.getId(), V);
        for (Integer node : shortestpath) {
            Comune c = nomiComuni.get(node);
            scelte.add(c);
            System.out.println(c.getNome());
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
}
