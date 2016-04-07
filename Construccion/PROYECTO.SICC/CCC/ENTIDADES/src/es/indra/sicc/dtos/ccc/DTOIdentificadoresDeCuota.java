package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOIdentificadoresDeCuota extends DTOBelcorp {

   String ejercicioCuota=null;
   String identificadorEjercicioCuota=null;

   public DTOIdentificadoresDeCuota() {
      super();
   }


   public void setEjercicioCuota(String ejercicioCuota) {
      this.ejercicioCuota = ejercicioCuota;
   }


   public String getEjercicioCuota() {
      return ejercicioCuota;
   }


   public void setIdentificadorEjercicioCuota(String identificadorEjercicioCuota) {
      this.identificadorEjercicioCuota = identificadorEjercicioCuota;
   }


   public String getIdentificadorEjercicioCuota() {
      return identificadorEjercicioCuota;
   }

}