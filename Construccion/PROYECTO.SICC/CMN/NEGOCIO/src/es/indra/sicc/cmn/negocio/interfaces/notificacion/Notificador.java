package es.indra.sicc.cmn.negocio.interfaces.notificacion;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

public abstract class Notificador { 
   private String codigoInt;
   
   public Notificador()
   {
   }      
    
   public abstract void notificar() throws InterfacesException;
   
   public String getCodigoInt()
   {
    return codigoInt;
    }   
    
   public void setCodigoInt(String newCodigoInt)
   {
        this.codigoInt=newCodigoInt;
    }   
}
