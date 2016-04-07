package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.ccc.MONMantenimientoCCCHome;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocalHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;


public class CCCEjbLocators {
   /*
    * MONes
    */
   public static MONMantenimientoCCCHome getMONMantenimientoCCCHome()
      throws MareException {
      MONMantenimientoCCCHome localHome = (MONMantenimientoCCCHome) UtilidadesEJB.getHome("MONMantenimientoCCC",
            MONMantenimientoCCCHome.class);

      return localHome;
   }

   public static MONInterfaceModulosHome getMONInterfaceModulosHome()
      throws MareException {
      MONInterfaceModulosHome localHome = (MONInterfaceModulosHome) UtilidadesEJB.getHome("MONInterfaceModulos",
            MONInterfaceModulosHome.class);

      return localHome;
   }

    public static MovimientosBancariosLocalHome getMovimientosBancariosLocalHome() throws MareException {
            return (MovimientosBancariosLocalHome) UtilidadesEJB.getLocalHome(
               "java:comp/env/MovimientosBancarios");
    }
}
