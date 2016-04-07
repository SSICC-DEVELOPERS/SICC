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
package es.indra.sicc.dtos.cra;
import java.util.Vector;

public class DTOMatrizDias  extends  es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC{

  //DTOGrupoMatriz[]
  private Vector grupos;
  private Long dias;
  private Long marca;
  private Long canal;
  private Boolean esCrear;
  private Integer idVista;

  public DTOMatrizDias() {
  }

  public Vector getGrupos(){
    return grupos;
  }
  public void setGrupos(Vector newGrupos){
    this.grupos = newGrupos;
  }
  public Long getDias(){
    return dias;
  }
  public void setDias(Long newDias){
    dias = newDias;
  }
  public Long getMarca(){
    return this.marca;
  }
  public void setMarca(Long newMarca){
    this.marca = newMarca;
  }
 public Long getCanal(){
    return this.canal;
  }
  public void setCanal(Long newCanal){
    this.canal = newCanal;
  }

  public Boolean getEsCrear() {
    return esCrear;
  }

  public void setEsCrear(Boolean newEsCrear) {
    esCrear = newEsCrear;
  }

    public Integer getIdVista() {
        return idVista;
    }

    public void setIdVista(Integer newIdVista) {
        idVista = newIdVista;
    }
}