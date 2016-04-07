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

package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTODatosConsultora extends DTOAuditableSICC {
    private Long oidBuzon;
    private Long oidMensaje;
    private Long oidCliente;
    private String codCliente;
    private String codClienteOld;
    private String nombreApellidos;
    private String datoVariable2;
    private String datoVariable3;
    private String datoVariable4;
    private String datoVariable5;
    private String datoVariable6;
    private String datoVariable7;
    private String datoVariable8;
    private String datoVariable9;
    private String datoVariable10;

    public DTODatosConsultora() {
    }

    public Long getOidBuzon() {
        return oidBuzon;
    }

    public void setOidBuzon(Long newOidBuzon) {
        oidBuzon = newOidBuzon;
    }

    public Long getOidMensaje() {
        return oidMensaje;
    }

    public void setOidMensaje(Long newOidMensaje) {
        oidMensaje = newOidMensaje;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String newCodCliente) {
        codCliente = newCodCliente;
    }

    public String getCodClienteOld() {
        return codClienteOld;
    }

    public void setCodClienteOld(String newCodClienteOld) {
        codClienteOld = newCodClienteOld;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String newNombreApellidos) {
        nombreApellidos = newNombreApellidos;
    }

    public String getDatoVariable2() {
        return datoVariable2;
    }

    public void setDatoVariable2(String newDatoVariable2) {
        datoVariable2 = newDatoVariable2;
    }

    public String getDatoVariable3() {
        return datoVariable3;
    }

    public void setDatoVariable3(String newDatoVariable3) {
        datoVariable3 = newDatoVariable3;
    }

    public String getDatoVariable4() {
        return datoVariable4;
    }

    public void setDatoVariable4(String newDatoVariable4) {
        datoVariable4 = newDatoVariable4;
    }

    public String getDatoVariable5() {
        return datoVariable5;
    }

    public void setDatoVariable5(String newDatoVariable5) {
        datoVariable5 = newDatoVariable5;
    }

    public String getDatoVariable6() {
        return datoVariable6;
    }

    public void setDatoVariable6(String newDatoVariable6) {
        datoVariable6 = newDatoVariable6;
    }

    public String getDatoVariable7() {
        return datoVariable7;
    }

    public void setDatoVariable7(String newDatoVariable7) {
        datoVariable7 = newDatoVariable7;
    }

    public String getDatoVariable8() {
        return datoVariable8;
    }

    public void setDatoVariable8(String newDatoVariable8) {
        datoVariable8 = newDatoVariable8;
    }

    public String getDatoVariable9() {
        return datoVariable9;
    }

    public void setDatoVariable9(String newDatoVariable9) {
        datoVariable9 = newDatoVariable9;
    }

    public String getDatoVariable10() {
        return datoVariable10;
    }

    public void setDatoVariable10(String newDatoVariable10) {
        datoVariable10 = newDatoVariable10;
    }
}
