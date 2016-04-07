/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOListaPicadoCajas extends DTOBelcorp {
    
    private DTODatosCaja datosCaja;
    private ArrayList listaCajas;
    
    public DTOListaPicadoCajas() {
    }

    public void setDatosCaja(DTODatosCaja datosCaja) {
        this.datosCaja = datosCaja;
    }

    public DTODatosCaja getDatosCaja() {
        return datosCaja;
    }

    public void setListaCajas(ArrayList listaCajas) {
        this.listaCajas = listaCajas;
    }

    public ArrayList getListaCajas() {
        return listaCajas;
    }
    
}