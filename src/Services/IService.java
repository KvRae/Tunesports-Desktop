/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author achou
 */
public interface IService <T> {
    void ajouter(T t);
    void modifier(T t);
    void suprimer(T t);
    List<T>afficher();
    public void recherche(T t);
    List<T> trie();
    List<T> triedesc();
    
}
