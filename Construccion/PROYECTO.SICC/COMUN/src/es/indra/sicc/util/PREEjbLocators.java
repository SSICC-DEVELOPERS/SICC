package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.logicanegocio.pre.MONConfiguracionMFHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoEstrategiaHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.pre.MONOfertaHome;

public class PREEjbLocators {
   /*
    * MON's
    */
   public static MONConfiguracionMFHome getMONConfiguracionMFHome()
      throws MareException {
      MONConfiguracionMFHome localHome = (MONConfiguracionMFHome) UtilidadesEJB.getHome("MONConfiguracionMF",
            MONConfiguracionMFHome.class);

      return localHome;
   }

   public static MONMantenimientoEstrategiaHome getMONMantenimientoEstrategiaHome()
      throws MareException {
      MONMantenimientoEstrategiaHome localHome = (MONMantenimientoEstrategiaHome) UtilidadesEJB.getHome("MONMantenimientoEstrategia",
            MONMantenimientoEstrategiaHome.class);

      return localHome;
   }

   public static MONMantenimientoMFHome getMONMantenimientoMFHome()
      throws MareException {
      MONMantenimientoMFHome localHome = (MONMantenimientoMFHome) UtilidadesEJB.getHome("MONMantenimientoMF",
            MONMantenimientoMFHome.class);

      return localHome;
   }

   public static MONOfertaHome getMONOfertaHome() throws MareException {
      MONOfertaHome localHome = (MONOfertaHome) UtilidadesEJB.getHome("MONOferta",
            MONOfertaHome.class);

      return localHome;
   }

  
}
