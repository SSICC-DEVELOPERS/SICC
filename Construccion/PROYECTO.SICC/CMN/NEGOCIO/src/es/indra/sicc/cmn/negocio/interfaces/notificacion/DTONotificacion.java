package es.indra.sicc.cmn.negocio.interfaces.notificacion;
    import java.io.Serializable;
    import java.util.Date;
    
    public abstract class DTONotificacion implements Serializable {
      private String codigoInt;
             
       public DTONotificacion() 
       {
       }
       
      public String getCodigoInt()
      {
        return codigoInt;
      }
    
      public void setCodigoInt(String newCodigoInt)
      {
        this.codigoInt = newCodigoInt;
      }
      
    }