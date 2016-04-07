/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

/**
 * Sistema:           Belcorp
 * Modulo:            ZON 
 * Submódulo:         Zonificación
 * Componente:        DTO's
 * Fecha:             06/11/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-ZON-201-300
 *                    (Subido al portal el //)
 * @version           1.0
 * @autor             Fernando Laffaye
 */

public class DTOListaFicheroDisp 
    extends DTOAuditableSICC
{

    private ArrayList lista;

    public DTOListaFicheroDisp() {
        super();
    }

    public DTOListaFicheroDisp(ArrayList array){
        super();
        this.lista = array;
    }

    public ArrayList getLista(){
        return this.lista;
    } 
    
    public void setLista(ArrayList l){
        this.lista = l;
    }
}