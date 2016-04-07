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
package es.indra.sicc.dtos.intsys;

import java.util.ArrayList;

import es.indra.sicc.util.DTOBelcorp;
public class DTOINTDocumentosContables extends DTOBelcorp {
    ArrayList documentosVentasSinTransportista;
    ArrayList documentosAbonosSinTransportista;
    ArrayList documentosTransportistas;

    public DTOINTDocumentosContables()
    {
    }

    public ArrayList getDocumentosAbonosSinTransportista()
    {
        return documentosAbonosSinTransportista;
    }

    public void setDocumentosAbonosSinTransportista(ArrayList documentosAbonosSinTransportista)
    {
        this.documentosAbonosSinTransportista = documentosAbonosSinTransportista;
    }

    public ArrayList getDocumentosTransportistas()
    {
        return documentosTransportistas;
    }

    public void setDocumentosTransportistas(ArrayList documentosTransportistas)
    {
        this.documentosTransportistas = documentosTransportistas;
    }

    public ArrayList getDocumentosVentasSinTransportista()
    {
        return documentosVentasSinTransportista;
    }

    public void setDocumentosVentasSinTransportista(ArrayList documentosVentasSinTransportista)
    {
        this.documentosVentasSinTransportista = documentosVentasSinTransportista;
    }
}