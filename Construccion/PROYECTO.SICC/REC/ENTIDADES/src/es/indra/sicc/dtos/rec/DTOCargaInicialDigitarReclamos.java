/**
 * Copyright 2005 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
 
package es.indra.sicc.dtos.rec;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCargaInicialDigitarReclamos extends DTOBelcorp{
    
    public DTOCargaInicialDigitarReclamos(){
        super();
    }
    private RecordSet operacion;    
    private RecordSet asumePerdida;  

    public RecordSet getAsumePerdida(){
        return asumePerdida;
    }

    public void setAsumePerdida(RecordSet asumePerdida){
        this.asumePerdida = asumePerdida;
    }

    public RecordSet getOperacion(){
        return operacion;
    }

    public void setOperacion(RecordSet operacion){
        this.operacion = operacion;
    }

}