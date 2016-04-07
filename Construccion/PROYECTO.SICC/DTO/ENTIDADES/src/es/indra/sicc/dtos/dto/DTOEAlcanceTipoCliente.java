package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOOIDs;

import java.util.ArrayList;

public class DTOEAlcanceTipoCliente extends DTOAuditableSICC {

   private Long oidDescuento;
   private DTOOIDs tipoCliente;
   private DTOOIDs subtipoCliente;
   private ArrayList listaDescuentos;

   private ArrayList descTipoCliente;
   private ArrayList descSubTipoCliente;
   private Boolean definirCliente;
   
   public DTOEAlcanceTipoCliente() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public void setOidDescuento(Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }

   public DTOOIDs getTipoCliente()
   {
      return this.tipoCliente;
   }

   public void setTipoCliente(DTOOIDs tipoCliente)
   {
      this.tipoCliente = tipoCliente;
   }

   public DTOOIDs getSubtipoCliente()
   {
      return this.subtipoCliente;
   }

   public void setSubtipoCliente(DTOOIDs subtipoCliente)
   {
      this.subtipoCliente = subtipoCliente;
   }

    public ArrayList getListaDescuentos() {
        return listaDescuentos;
    }

    public void setListaDescuentos(ArrayList newListaDescuentos) {
        listaDescuentos = newListaDescuentos;
    }


    public ArrayList getDescTipoCliente() {
        return descTipoCliente;
    }

    public void setDescTipoCliente(ArrayList newdescTipoCliente) {
        descTipoCliente = newdescTipoCliente;
    }


    public ArrayList getDescSubTipoCliente() {
        return descSubTipoCliente;
    }

    public void setDescSubTipoCliente(ArrayList newdescSubTipoCliente) {
        descSubTipoCliente = newdescSubTipoCliente;
    }

    
    public Boolean getDefinirCliente() {
        return definirCliente;
    }

    public void setDefinirCliente(Boolean definirCliente) {
        definirCliente = definirCliente;
    }
    
}