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

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Vector;

/**
 * Sistema:         Belcorp
 * Modulo:           MAE
 * Subm�dulo:     Mantenimiento de Materiales
 * Componente:   DTO's
 * Fecha:             02/12/2003
 * Observaciones:     
 *                    
 * @version          1.0
 * @autor             Luis Ramos
 */

public class DTOConfiguracionCamposProducto extends DTOAuditableSICC 
{
    private Vector campos;

    public DTOConfiguracionCamposProducto()
    {
    }

    public Vector getCampos()
    {
        return campos;
    }

    public void setCampos(Vector newCampos)
    {
        campos = newCampos;
    }


    
}