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
import java.util.Date;

public class DTOINTCurso extends DTOBelcorp  {
    private Date fechaCurso;
    private Long codigoPlantilla;
    private String codigoCurso;
    private String tipoCurso;
    private String codigoAsistente;

    public DTOINTCurso() {
    }

    public Date getFechaCurso() {
        return fechaCurso;
    }

    public void setFechaCurso(Date fechaCurso) {
        this.fechaCurso = fechaCurso;
    }

    public Long getCodigoPlantilla() {
        return codigoPlantilla;
    }

    public void setCodigoPlantilla(Long codigoPlantilla) {
        this.codigoPlantilla = codigoPlantilla;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getCodigoAsistente() {
        return codigoAsistente;
    }

    public void setCodigoAsistente(String codigoAsistente) {
        this.codigoAsistente = codigoAsistente;
    }
}