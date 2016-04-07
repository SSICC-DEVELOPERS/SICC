
/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.ape;

import java.util.ArrayList;
import es.indra.sicc.util.DTOBelcorp;

public class DTOCajaListaPicado extends DTOBelcorp{

    private Long numeroCaja;    
    private long cantProdDifParaEstaCaja;
    private ArrayList listaPicadoDetalleFacturacion;
    
    public DTOCajaListaPicado()
    {
    }


    public void setNumeroCaja(Long numeroCaja)
    {
        this.numeroCaja = numeroCaja;
    }


    public Long getNumeroCaja()
    {
        return numeroCaja;
    }


    public void setListaPicadoDetalleFacturacion(ArrayList listaPicadoDetalleFacturacion)
    {
        this.listaPicadoDetalleFacturacion = listaPicadoDetalleFacturacion;
    }


    public ArrayList getListaPicadoDetalleFacturacion()
    {
        return listaPicadoDetalleFacturacion;
    }


    public void setCantProdDifParaEstaCaja(long cantProdDifParaEstaCaja)
    {
        this.cantProdDifParaEstaCaja = cantProdDifParaEstaCaja;
    }


    public long getCantProdDifParaEstaCaja()
    {
        return cantProdDifParaEstaCaja;
    }
}