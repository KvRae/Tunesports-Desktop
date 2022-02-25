/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

public interface IService<T> {
    void ajouter(T t);
    void supprimer(int t);
    void modifier(T t);
    List<T> rechercher(int t);
    List<T> afficher();
    List<T> trie();
    
}
