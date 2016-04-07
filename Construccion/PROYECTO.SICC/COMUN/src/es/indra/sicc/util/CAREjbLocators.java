package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.car.MONCARParametrizacionHome;
import es.indra.sicc.logicanegocio.car.MONValidarCreditosHome;
import es.indra.sicc.logicanegocio.car.MONSolicitudesBloqueadasHome;
import es.indra.sicc.logicanegocio.car.MONCreditoRiesgoHome;


public class CAREjbLocators {
   /*
    * MONes
    */
   public static MONCARParametrizacionHome getMONCARParametrizacionHome()
      throws MareException {
      MONCARParametrizacionHome localHome = (MONCARParametrizacionHome) UtilidadesEJB.getHome("MONCARParametrizacion",
            MONCARParametrizacionHome.class);

      return localHome;
   }

   public static MONValidarCreditosHome getMONValidarCreditosHome()
      throws MareException {
      MONValidarCreditosHome localHome = (MONValidarCreditosHome) UtilidadesEJB.getHome("MONValidarCreditos",
            MONValidarCreditosHome.class);

      return localHome;
   }

   public static MONSolicitudesBloqueadasHome getMONSolicitudesBloqueadasHome()
      throws MareException {
      MONSolicitudesBloqueadasHome localHome = (MONSolicitudesBloqueadasHome) UtilidadesEJB.getHome("MONSolicitudesBloqueadas",
            MONSolicitudesBloqueadasHome.class);

      return localHome;
   }
   
   public static MONCreditoRiesgoHome getMONCreditoRiesgoHome()
      throws MareException {
      MONCreditoRiesgoHome localHome = (MONCreditoRiesgoHome) UtilidadesEJB.getHome("MONCreditoRiesgo",
            MONCreditoRiesgoHome.class);

      return localHome;
   }

}
