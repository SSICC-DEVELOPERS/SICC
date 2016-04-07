package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.UtilidadesEJB;


public class SEGEjbLocators {
   public static MONMantenimientoSEGHome getMONMantenimientoSEGHome()
      throws MareException {
      MONMantenimientoSEGHome localHome = (MONMantenimientoSEGHome) UtilidadesEJB.getHome("MONMantenimientoSEG",
            MONMantenimientoSEGHome.class);

      return localHome;
   }

}
