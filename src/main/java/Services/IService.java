/*
 *  Copyright (c) 2022.
 *  Written By KvRae.
 * I hate writing documentations.
 */

package Services;

import java.util.List;
//************************Implemented Interface for our service's classes*******************************
public interface IService<T> {
    void ajouter(T t);
    List<T> afficher();
    void modifier(T t);
    void supprimer(T t);

}