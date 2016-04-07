package es.indra.sicc.dtos.dto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSAlcanceTipoClienteDTO extends DTOAuditableSICC {

   private RecordSet tiposCliente;
   private RecordSet subtiposCliente;
   private RecordSet alcanceClasificacion;
   
   public DTOSAlcanceTipoClienteDTO() {
   }

   public RecordSet getTiposCliente()
   {
         return this.tiposCliente;
   }

   public RecordSet getSubtiposCliente()
   {
         return this.subtiposCliente;
   }

   public RecordSet getAlcanceClasificacion()
   {
         return this.alcanceClasificacion;
   }

   public void setTiposCliente(RecordSet tiposCliente)
   {
      this.tiposCliente = tiposCliente;
   }

   public void setSubtiposCliente(RecordSet subtiposCliente)
   {
      this.subtiposCliente = subtiposCliente;
   }

   public void setAlcanceClasificacion(RecordSet alcanceClasificacion)
   {
      this.alcanceClasificacion = alcanceClasificacion;
   }
}