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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOBloqueo extends DTOBelcorp {

	private Long  oidBloqueo;
	private String usuario;
   private Date fecha;
   private String descripcionProceso; 
	
	
	public DTOBloqueo() {
		super();
	}

   public String getDescripcionProceso() {
      return descripcionProceso;
   }

   public void setDescripcionProceso(String descripcionProceso) {
      this.descripcionProceso = descripcionProceso;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public Long getOidBloqueo() {
      return oidBloqueo;
   }

   public void setOidBloqueo(Long oidBloqueo) {
      this.oidBloqueo = oidBloqueo;
   }

   public String getUsuario() {
      return usuario;
   }

   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }




}