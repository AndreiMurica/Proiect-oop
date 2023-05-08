package service;

import model.produse.Antichitate;
import model.produse.Arta;
import model.produse.Celebritate;
import model.tranzactii.Oferta;
import model.utilizatori.Cumparator;
import model.utilizatori.Vanzator;

import java.util.ArrayList;
import java.util.List;
public class AuctionService {
    private List<Cumparator> cumparatori = new ArrayList<>();
    private List<Vanzator> vanzatori = new ArrayList<>();
    private List<Oferta> oferte = new ArrayList<>();
    public void AdaugaVanzator (String nume, int varsta, int balanta){
        Vanzator vanzator = new Vanzator(nume, varsta, balanta);
        vanzatori.add(vanzator);
    }

    public void AfisareVanzatori(){
        for (Vanzator vanzator : vanzatori) {
            System.out.println("ID: " + vanzator.getID() + " Nume: " + vanzator.getNume() + " Varsta: " + vanzator.getVarsta() + " Balanta: " + vanzator.getBalanta() );
            for (int i = 0; i < vanzator.getObiecte().size(); i++) {
                System.out.println(vanzator.getObiecte().get(i).toString());
            }
        }
    }

    public void AdaugaCumparator (String nume, int varsta, int balanta){
        Cumparator cumparator = new Cumparator(nume, varsta, balanta);
        cumparatori.add(cumparator);
    }

    public void AfisareCumparatori(){
        for (Cumparator cumparator : cumparatori) {
            System.out.println("ID: " + cumparator.getID() + " Nume: " + cumparator.getNume() + " Varsta: " + cumparator.getVarsta() + " Balanta: " + cumparator.getBalanta() );
            for (int i = 0; i < cumparator.getObiecte().size(); i++) {
                System.out.println(cumparator.getObiecte().get(i).toString());
            }
        }
    }

    public void AdaugareArta(int ID, String nume, int estimare, int an, String numePictor){
        for (Vanzator vanzator : vanzatori) {
            if (vanzator.getID() == ID){
                Arta arta = new Arta(nume, estimare, ID, numePictor, an);
                vanzator.adaugaObiect(arta);
            }
        }
        for (Cumparator cumparator : cumparatori) {
            if (cumparator.getID() == ID){
                Arta arta = new Arta(nume, estimare, ID, numePictor, an);
                cumparator.adaugaObiect(arta);
            }
        }
    }

    public void AdaugareAntichitate(int ID, String nume, int estimare, int an, String zona){
        for (Vanzator vanzator : vanzatori) {
            if (vanzator.getID() == ID){
                Antichitate antichitate = new Antichitate(nume, estimare, ID, an, zona);
                vanzator.adaugaObiect(antichitate);
            }
        }
        for (Cumparator cumparator : cumparatori) {
            if (cumparator.getID() == ID){
                Antichitate antichitate = new Antichitate(nume, estimare, ID, an, zona);
                cumparator.adaugaObiect(antichitate);
            }
        }
    }

    public void AdaugareCelebritate(int ID, String nume, int estimare, String numeCelebritate){
        for (Vanzator vanzator : vanzatori) {
            if (vanzator.getID() == ID){
                Celebritate celebritate = new Celebritate(nume, estimare, ID, numeCelebritate);
                vanzator.adaugaObiect(celebritate);
            }
        }
        for (Cumparator cumparator : cumparatori) {
            if (cumparator.getID() == ID){
                Celebritate celebritate = new Celebritate(nume, estimare, ID, numeCelebritate);
                cumparator.adaugaObiect(celebritate);
            }
        }
    }

    public void StergedinColectie(int PersoanaID, int ObiectId) {
        for (Vanzator vanzator : vanzatori) {
            if (vanzator.getID() == PersoanaID) {
                for (int i = 0; i < vanzator.getObiecte().size(); i++) {
                    if (vanzator.getObiecte().get(i).getID() == ObiectId) {
                        vanzator.StergeObiect(vanzator.getObiecte().get(i));
                    }
                }
            }
        }
    }

    public void AfisareAvere(int ID){
        for (Vanzator vanzator : vanzatori) {
            if (vanzator.getID() == ID){
                int suma = 0;
                for (int i = 0; i < vanzator.getObiecte().size(); i++) {
                    suma += vanzator.getObiecte().get(i).getEstimare();
                }
                System.out.println(" Nume: " + vanzator.getNume() + " are in balanta " + vanzator.getBalanta() + " si are o colectie de " + suma);
            }
        }
        for (Cumparator cumparator : cumparatori) {
            if (cumparator.getID() == ID){
                System.out.println("ID: " + cumparator.getID() + " Nume: " + cumparator.getNume() + " Varsta: " + cumparator.getVarsta() + " Balanta: " + cumparator.getBalanta() );
                for (int i = 0; i < cumparator.getObiecte().size(); i++) {
                    System.out.println(cumparator.getObiecte().get(i).toString());
                }
            }
        }
    }

    public void CreareOferta(int ProdusID, int CumparatorID, int suma) {
        for (Vanzator vanzator : vanzatori) {
            if (vanzator.getID() == ProdusID) {
                for (int i = 0; i < vanzator.getObiecte().size(); i++) {
                    if (vanzator.getObiecte().get(i).getID() == ProdusID) {
                        Oferta oferta = new Oferta(suma, CumparatorID, vanzator.getID(), ProdusID);
                        oferte.add(oferta);
                    }
                }
            }
        }
    }
}