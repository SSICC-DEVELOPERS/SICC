package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.util.UtilidadesEJB;


public class CMNEjbLocators {
   public CMNEjbLocators() {
   }

   public static MONI18nHome getMONI18nHome() throws MareException {
      MONI18nHome localHome = (MONI18nHome) UtilidadesEJB.getHome("MONI18n",
            MONI18nHome.class);

      return localHome;
   }

   public static MONGestorInterfacesHome getMONGestorInterfacesHome() throws MareException {
      MONGestorInterfacesHome localHome = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces",
            MONGestorInterfacesHome.class);

      return localHome;
   }   
}
