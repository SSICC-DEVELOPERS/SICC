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

public class DTOINTCampania extends DTOBelcorp  {
    private String anioCampania;
    private String codigoCanalVenta;
    private String periodoAnio;
    private String descripcionEstacion;
    private String anioCampaniaActual;

    public DTOINTCampania() {
    }

    public String getAnioCampania() {
        return anioCampania;
    }

    public void setAnioCampania(String anioCampania) {
        this.anioCampania = anioCampania;
    }

    public String getCodigoCanalVenta() {
        return codigoCanalVenta;
    }

    public void setCodigoCanalVenta(String codigoCanalVenta) {
        this.codigoCanalVenta = codigoCanalVenta;
    }

    public String getPeriodoAnio() {
        return periodoAnio;
    }

    public void setPeriodoAnio(String periodoAnio) {
        this.periodoAnio = periodoAnio;
    }

    public String getDescripcionEstacion() {
        return descripcionEstacion;
    }

    public void setDescripcionEstacion(String descripcionEstacion) {
        this.descripcionEstacion = descripcionEstacion;
    }

    public String getAnioCampaniaActual() {
        return anioCampaniaActual;
    }

    public void setAnioCampaniaActual(String anioCampaniaActual) {
        this.anioCampaniaActual = anioCampaniaActual;
    }
}