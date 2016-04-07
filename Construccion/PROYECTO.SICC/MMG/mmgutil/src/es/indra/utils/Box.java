package es.indra.utils;

import java.util.*;

/**
 * Esta clase representa a una caja para guardar datos de la sesión
 *
 * Se implementa usando el patrón Singleton
 * 
 * @author Indra Sistemas, S.A.
 * @version 1.0
 */
public class Box extends Hashtable {
    protected Box() {
    }

    static private Box box = null;

    static public Box instance() {
        if (box == null) {
            box = new Box();   
        }   
        return box;
    }    
}
    