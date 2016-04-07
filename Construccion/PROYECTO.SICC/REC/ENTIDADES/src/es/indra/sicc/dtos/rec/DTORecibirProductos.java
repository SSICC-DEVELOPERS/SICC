/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/
package es.indra.sicc.dtos.rec;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTORecibirProductos extends DTOBelcorp  {
    public DTORecibirProductos() {
    }
    
    private ArrayList lineas;

    public ArrayList getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList lineas) {
        this.lineas = lineas;
    }
}