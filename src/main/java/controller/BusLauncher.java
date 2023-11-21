package controller;

import model.BestelBus;
import model.Pakket;
import model.PakketLezer;
import model.PakkettenBus;

import java.util.List;

public class BusLauncher {

    public static void main(String[] args) {
        PakkettenBus kuBus = new PakkettenBus("rode bus", 170);
        BestelBus<Pakket> bestelBus = new BestelBus<>("BestelBus", 170);
        List<Pakket> lijstVanBestand;

        PakketLezer lezerBestand = new PakketLezer();
        lijstVanBestand = lezerBestand.leesPakketLijst("src/main/resources/pakketlijst.txt");

        System.out.println(lijstVanBestand);

        for (Pakket p : lijstVanBestand) {
            bestelBus.laadPakket(p);
        }

        Pakket pakket = bestelBus.zoekZwaarstePakket();
        System.out.println(pakket);

    }
}
