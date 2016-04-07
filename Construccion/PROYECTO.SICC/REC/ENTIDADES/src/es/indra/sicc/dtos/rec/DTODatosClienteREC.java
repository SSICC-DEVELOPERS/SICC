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

public class DTODatosClienteREC extends DTOBelcorp  {

    private Long tipoCliente;     
    private Long subtipoCliente; 

    public DTODatosClienteREC() {
        super();
    }

    public Long getSubtipoCliente()
    {
        return subtipoCliente;
    }

    public void setSubtipoCliente(Long subtipoCliente)
    {
        this.subtipoCliente = subtipoCliente;
    }

    public Long getTipoCliente()
    {
        return tipoCliente;
    }

    public void setTipoCliente(Long tipoCliente)
    {
        this.tipoCliente = tipoCliente;
    }
}