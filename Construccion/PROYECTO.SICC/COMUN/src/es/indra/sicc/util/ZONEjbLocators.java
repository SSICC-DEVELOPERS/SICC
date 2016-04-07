package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.zon.MONEstructuraGeoPoliticaHome;
import es.indra.sicc.logicanegocio.zon.MONEstructuraVialHome;
import es.indra.sicc.logicanegocio.zon.MONReestructuracionHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadAdmInterfaceGIS;
import es.indra.sicc.logicanegocio.zon.MONUnidadGeoInterfaceGISHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.logicanegocio.zon.MONZONLogHome;
import es.indra.sicc.util.UtilidadesEJB;


public class ZONEjbLocators {
   /*
    * MON's
    */
   public static MONZONLogHome getMONZONLogHome() throws MareException {
      MONZONLogHome localHome = (MONZONLogHome) UtilidadesEJB.getHome("MONZONLog",
            MONZONLogHome.class);

      return localHome;
   }

   public static MONUnidadGeoInterfaceGISHome getMONUnidadGeoInterfaceGISHome()
      throws MareException {
      MONUnidadGeoInterfaceGISHome localHome = (MONUnidadGeoInterfaceGISHome) UtilidadesEJB.getHome("MONUnidadGeoInterfaceGIS",
            MONUnidadGeoInterfaceGISHome.class);

      return localHome;
   }

   public static MONUnidadesGeograficasHome getMONUnidadesGeograficasHome()
      throws MareException {
      MONUnidadesGeograficasHome localHome = (MONUnidadesGeograficasHome) UtilidadesEJB.getHome("MONUnidadesGeograficas",
            MONUnidadesGeograficasHome.class);

      return localHome;
   }

   public static MONUnidadesAdministrativasHome getMONUnidadesAdministrativasHome()
      throws MareException {
      MONUnidadesAdministrativasHome localHome = (MONUnidadesAdministrativasHome) UtilidadesEJB.getHome("MONUnidadesAdministrativas",
            MONUnidadesAdministrativasHome.class);

      return localHome;
   }

   public static MONUnidadAdmInterfaceGIS getMONUnidadAdmInterfaceGIS()
      throws MareException {
      MONUnidadAdmInterfaceGIS localHome = (MONUnidadAdmInterfaceGIS) UtilidadesEJB.getHome("MONUnidadAdmInterface",
            MONUnidadAdmInterfaceGIS.class);

      return localHome;
   }

   public static MONReestructuracionHome getMONReestructuracionHome()
      throws MareException {
      MONReestructuracionHome localHome = (MONReestructuracionHome) UtilidadesEJB.getHome("MONReestructuracion",
            MONReestructuracionHome.class);

      return localHome;
   }

   public static MONEstructuraVialHome getMONEstructuraVialHome()
      throws MareException {
      MONEstructuraVialHome localHome = (MONEstructuraVialHome) UtilidadesEJB.getHome("MONEstructuraVial",
            MONEstructuraVialHome.class);

      return localHome;
   }

   public static MONEstructuraGeoPoliticaHome getMONEstructuraGeoPoliticaHome()
      throws MareException {
      MONEstructuraGeoPoliticaHome localHome = (MONEstructuraGeoPoliticaHome) UtilidadesEJB.getHome("MONEstructuraGeoPolitica",
            MONEstructuraGeoPoliticaHome.class);

      return localHome;
   }


}
