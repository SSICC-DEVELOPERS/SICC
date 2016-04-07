/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTONotificar  extends DTOAuditableSICC{
    
    private ArrayList ordenes;

	public DTONotificar() {
	}

    public ArrayList getOrdenes()
    {
        return ordenes;
    }

    public void setOrdenes(ArrayList ordenes)
    {
        this.ordenes = ordenes;
    }

}