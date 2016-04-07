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

public class DTOFicheroDisp 
    extends DTOAuditableSICC
{
    private String pathFichero;
    private String nombreFichero;
    private String descripcion;
    private String typeProc;
    private Object datos;


    public DTOFicheroDisp() {
        super();
    }

    public DTOFicheroDisp(String filePath,String fileName,String description,
                        String typeProc,Object data)
    {
        super();
        this.pathFichero    = filePath;
        this.nombreFichero  = fileName;
        this.descripcion    = description;
        this.typeProc       = typeProc;
        this.datos          = data;        
    }

    public void setPathFichero(String filePath){
        this.pathFichero = filePath;
    }

    public void setNombreFichero(String fileName){
        this.nombreFichero = fileName;
    }

    public String getNombreFichero(){
        return this.nombreFichero;
    }
    
    public String getPathFichero(){
        return this.pathFichero;
    }

    public void setDescripcion(String newDescripcion){
        this.descripcion = newDescripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setTypeProc(String typeProc){
        this.typeProc = typeProc;
    }

    public String getTypeProc(){
        return this.typeProc;
    }    

    public void setDatos(Object data){
        this.datos = data;
    }

    public Object getDatos(){
        return datos;
    }

}
