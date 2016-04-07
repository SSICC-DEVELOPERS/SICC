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
import es.indra.sicc.util.DTOBelcorp;

public class DTOCambiosZON extends DTOBelcorp{
    public DTOCambiosZON()
    {
    }

    private String codSGVOrigen;
    private String codRegionOrigen;
    private String codZonaOrigen;
    private String codSeccionOrigen;
    private Long codTerritorioOrigen;
    private String codSGVDestino;
    private String codRegionDestino;
    private String codZonaDestino;
    private String codSeccionDestino;
    private Long codTerritorioDestino;
    private String nivelCambio;

    public String getCodRegionDestino()
    {
        return codRegionDestino;
    }

    public void setCodRegionDestino(String codRegionDestino)
    {
        this.codRegionDestino = codRegionDestino;
    }

    public String getCodRegionOrigen()
    {
        return codRegionOrigen;
    }

    public void setCodRegionOrigen(String codRegionOrigen)
    {
        this.codRegionOrigen = codRegionOrigen;
    }

    public String getCodSGVDestino()
    {
        return codSGVDestino;
    }

    public void setCodSGVDestino(String codSGVDestino)
    {
        this.codSGVDestino = codSGVDestino;
    }

    public String getCodSGVOrigen()
    {
        return codSGVOrigen;
    }

    public void setCodSGVOrigen(String codSGVOrigen)
    {
        this.codSGVOrigen = codSGVOrigen;
    }

    public String getCodSeccionDestino()
    {
        return codSeccionDestino;
    }

    public void setCodSeccionDestino(String codSeccionDestino)
    {
        this.codSeccionDestino = codSeccionDestino;
    }

    public String getCodSeccionOrigen()
    {
        return codSeccionOrigen;
    }

    public void setCodSeccionOrigen(String codSeccionOrigen)
    {
        this.codSeccionOrigen = codSeccionOrigen;
    }

    public Long getCodTerritorioDestino()
    {
        return codTerritorioDestino;
    }

    public void setCodTerritorioDestino(Long codTerritorioDestino)
    {
        this.codTerritorioDestino = codTerritorioDestino;
    }

    public Long getCodTerritorioOrigen()
    {
        return codTerritorioOrigen;
    }

    public void setCodTerritorioOrigen(Long codTerritorioOrigen)
    {
        this.codTerritorioOrigen = codTerritorioOrigen;
    }

    public String getCodZonaDestino()
    {
        return codZonaDestino;
    }

    public void setCodZonaDestino(String codZonaDestino)
    {
        this.codZonaDestino = codZonaDestino;
    }

    public String getCodZonaOrigen()
    {
        return codZonaOrigen;
    }

    public void setCodZonaOrigen(String codZonaOrigen)
    {
        this.codZonaOrigen = codZonaOrigen;
    }

    public String getNivelCambio()
    {
        return nivelCambio;
    }

    public void setNivelCambio(String nivelCambio)
    {
        this.nivelCambio = nivelCambio;
    }    
       
}