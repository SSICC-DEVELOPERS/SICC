package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOExtraerDatosFichero extends DTOAuditableSICC {
  private Long oidPais;
  private String codigoMensaje;
   private String nombreFichero;
  private Long oidMensaje;

    public DTOExtraerDatosFichero() {
    }

    public String getCodigoMensaje() {
        return codigoMensaje;
    }

    public void setCodigoMensaje(String newCodigoMensaje) {
        codigoMensaje = newCodigoMensaje;
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String newNombreFichero) {
        nombreFichero = newNombreFichero;
    }

    public Long getOidMensaje() {
    return oidMensaje;
    }

    public void setOidMensaje(Long newOidMensaje) {
    oidMensaje = newOidMensaje;
    }

    public Long getOidPais() {
    return oidPais;
    }

    public void setOidPais(Long newOidPais) {
    oidPais = newOidPais;
    }
}
