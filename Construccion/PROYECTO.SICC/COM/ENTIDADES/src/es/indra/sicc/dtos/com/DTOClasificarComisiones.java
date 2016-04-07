
package es.indra.sicc.dtos.com;

import es.indra.sicc.util.DTOBelcorp;

public class DTOClasificarComisiones extends DTOBelcorp {

   private Long oidMarca;
   private Long oidCanal;
   private Long oidPeriodo;
   private Long oidComision;
   private Long oidTipoComision;
   
   public DTOClasificarComisiones() {
   }
     
   public Long getOidMarca()
   {
      return this.oidMarca;
   }

   public Long getOidCanal()
   {
      return this.oidCanal;
   }
   
   public Long getOidPeriodo()
   {
      return this.oidPeriodo;
   }
 

   public void setOidMarca  (Long oidMarca)
   {
      this.oidMarca = oidMarca;
   }

   public void setOidCanal  (Long oidCanal)
   {
      this.oidCanal = oidCanal;
   }

   public void setOidPeriodo (Long oidPeriodo)
   {
      this.oidPeriodo = oidPeriodo;
   }

    public Long getOidComision()
    {
      return oidComision;
    }
  
    public void setOidComision(Long oidComision)
    {
      this.oidComision = oidComision;
    }

    public Long getOidTipoComision()
    {
      return oidTipoComision;
    }
  
    public void setOidTipoComision(Long oidTipoComision)
    {
      this.oidTipoComision = oidTipoComision;
    }


}