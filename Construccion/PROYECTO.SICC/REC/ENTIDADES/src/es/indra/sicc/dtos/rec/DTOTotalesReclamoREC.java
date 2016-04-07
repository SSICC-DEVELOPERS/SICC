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
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOTotalesReclamoREC extends DTOBelcorp  {

    private BigDecimal totalAbono;     
    private BigDecimal totalCargo;

    public DTOTotalesReclamoREC() {
        super();
    }

    public BigDecimal getTotalAbono()
    {
        return totalAbono;
    }

    public void setTotalAbono(BigDecimal totalAbono)
    {
        this.totalAbono = totalAbono;
    }

    public BigDecimal getTotalCargo()
    {
        return totalCargo;
    }

    public void setTotalCargo(BigDecimal totalCargo)
    {
        this.totalCargo = totalCargo;
    }
}