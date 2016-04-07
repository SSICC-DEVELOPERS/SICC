/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;
import java.sql.Timestamp;

import java.util.ArrayList;

/**
 * Sistema:           Belcorp
 * Modulo:            ZON 
 * Submódulo:         Zonificación
 * Componente:        DTO's
 * Fecha:             06/11/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-ZON-201-300
 *                    (Subido al portal el //)
 * @version           1.0
 * @autor             Fernando Laffaye
 */

public class DTOManagerFileResult 
    extends DTOAuditableSICC
{
    private Long estatus;
    private String  mensajeError;
    private String  reporteRegistros;
    private Long    iDProc;    
    private String  typeProc;
    private String fechaLog;

    //sapaza -- PER-SiCC-2010-0699 -- 10/12/2010
    private ArrayList listaRespuesta;

    public DTOManagerFileResult() {
        super();
    }

    public DTOManagerFileResult(Long estatus,String mens,String reportR,Long
        idProc,String typeProc,String fecha)
    {
        this.estatus            = estatus;
        this.mensajeError       = mens;
        this.reporteRegistros   = reportR;
        this.iDProc             = idProc;
        this.typeProc           = typeProc;
        this.fechaLog           = fecha;
    }

    

    public void setEstatus(Long s){
        this.estatus = s;
    }
    
    public Long getEstatus(){
        return this.estatus;
    }

    public void setMensajeError(String error){
        this.mensajeError = error;
    }
    
    public String getMensajeError(){
        return this.mensajeError;
    }

    public void setReporteRegistros(String r){
        this.reporteRegistros = r;
    }

    public String getReporteRegistros(){
        return this.reporteRegistros;
    }

    public void setIDProc(Long i){
        this.iDProc = i;
    }
    
    public Long getIDProc(){
        return this.iDProc;
    }

    public void setTypeProc(String typeProc){
        this.typeProc = typeProc;
    }

    public String getTypeProc(){
        return this.typeProc;
    }

    public String getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(String newFechaLog) {
        fechaLog = newFechaLog;
    }

    public void setListaRespuesta(ArrayList listaRespuesta) {
        this.listaRespuesta = listaRespuesta;
    }

    public ArrayList getListaRespuesta() {
        return listaRespuesta;
    }
}
