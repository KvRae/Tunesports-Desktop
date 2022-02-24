/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

public interface IService<T> {
    void ajouter(T t);
    void supprimer(T t);
    void modifier(T t);
    void recherche(T t);
    //void start(T t);
    //void pdf(T t);
    List<T> trie();
    List<T> triedesc();
    List<T> afficher();
    List<T> historique();
    
}
