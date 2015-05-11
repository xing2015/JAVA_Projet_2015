/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;

/**
 *
 * @author IT
 */
public class Module {
    private String nom;
    private String abbreviation;
    private Color couleur;
    private int nbSeance;

    public Module(String nom, String abbreviation, Color couleur, int nbSeance) {
        this.nom = nom;
        this.abbreviation = abbreviation;
        this.couleur = couleur;
        this.nbSeance = nbSeance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getNbSeance() {
        return nbSeance;
    }

    public void setNbSeance(int nbSeance) {
        this.nbSeance = nbSeance;
    }
    
}
