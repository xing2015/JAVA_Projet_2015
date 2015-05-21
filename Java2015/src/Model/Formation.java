/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;

/**
 *
 * @author xing
 */
public class Formation {
    private String nom;
    private int duree;
    private Module[] listeModule;

    public Formation(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    public void setListeModule(Module m) {
        
    }  
    
    public void getListeModule() {
        
    }
    
    
}
