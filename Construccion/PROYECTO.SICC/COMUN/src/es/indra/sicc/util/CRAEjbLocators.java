package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;


public class CRAEjbLocators {
   /*
    * MONes
    */
   public static MONPeriodosHome getMONPeriodosHome() throws MareException {
      MONPeriodosHome localHome = (MONPeriodosHome) UtilidadesEJB.getHome("MONPeriodos",
            MONPeriodosHome.class);

      return localHome;
   }

}
