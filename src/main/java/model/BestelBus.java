package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stijn Crombach <s.crombach@st.hanze.nl>
 * Purpose of program
 */
public class BestelBus<E extends GeneriekPakket> {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<E> lading;

    public BestelBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.maximumGewicht = maximumGewicht;
        this.totaalGewicht = 0;
        this.lading = new ArrayList<>();
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public List<E> getLading() {
        return lading;
    }

    public void laadPakket(E pakket) {
        if (pakket.getGewicht() < 0 || (maximumGewicht - totaalGewicht) < pakket.getGewicht()) {
            return;
        }

        lading.add(pakket);
        totaalGewicht += pakket.getGewicht();
    }

    public E zoekZwaarstePakket() {
        if (lading.isEmpty()) {
            return null;
        }

        return zoekZwaarstePakket(0);
    }

    public E zoekZwaarstePakket(int index) {
        if (index == lading.size()) {
            return lading.get(index - 1);
        }

        E zwaarstePakket = lading.get(index);

        if (zwaarstePakket.getGewicht() < zoekZwaarstePakket(index + 1).getGewicht()) {
            zwaarstePakket = zoekZwaarstePakket(index + 1);
        }
        return zwaarstePakket;
    }
}
