package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionCamposHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.mae.MONEstatusClienteHome;
import es.indra.sicc.logicanegocio.mae.MONFichasInscripcionHome;
import es.indra.sicc.logicanegocio.mae.MONImpuestosUBIGEOHome;
import es.indra.sicc.logicanegocio.mae.MONKitProductosHome;
import es.indra.sicc.logicanegocio.mae.MONMantenimientoMAEHome;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;


public class MAEEjbLocators {
   /*
    * MONes
    */
   public static MONClientesHome getMONClientesHome() throws MareException {
      MONClientesHome localHome = (MONClientesHome) UtilidadesEJB.getHome("MONClientes",
            MONClientesHome.class);

      return localHome;
   }

   public static MONEstatusClienteHome getMONEstatusClienteHome()
      throws MareException {
      MONEstatusClienteHome localHome = (MONEstatusClienteHome) UtilidadesEJB.getHome("MONEstatusCliente",
            MONEstatusClienteHome.class);

      return localHome;
   }

   public static MONConfiguracionCamposHome getMONConfiguracionCamposHome()
      throws MareException {
      MONConfiguracionCamposHome localHome = (MONConfiguracionCamposHome) UtilidadesEJB.getHome("MONConfiguracionCampos",
            MONConfiguracionCamposHome.class);

      return localHome;
   }

   public static MONConfiguracionClientesHome getMONConfiguracionClientesHome()
      throws MareException {
      MONConfiguracionClientesHome localHome = (MONConfiguracionClientesHome) UtilidadesEJB.getHome("MONConfiguracionClientes",
            MONConfiguracionClientesHome.class);

      return localHome;
   }

   public static MONFichasInscripcionHome getMONFichasInscripcionHome()
      throws MareException {
      MONFichasInscripcionHome localHome = (MONFichasInscripcionHome) UtilidadesEJB.getHome("MONFichasInscripcion",
            MONFichasInscripcionHome.class);

      return localHome;
   }

   public static MONImpuestosUBIGEOHome getMONImpuestosUBIGEOHome()
      throws MareException {
      MONImpuestosUBIGEOHome localHome = (MONImpuestosUBIGEOHome) UtilidadesEJB.getHome("MONImpuestosUBIGEO",
            MONImpuestosUBIGEOHome.class);

      return localHome;
   }

   public static MONKitProductosHome getMONKitProductosHome()
      throws MareException {
      MONKitProductosHome localHome = (MONKitProductosHome) UtilidadesEJB.getHome("MONKitProductos",
            MONKitProductosHome.class);

      return localHome;
   }

   public static MONMantenimientoMAEHome getMONMantenimientoMAEHome()
      throws MareException {
      MONMantenimientoMAEHome localHome = (MONMantenimientoMAEHome) UtilidadesEJB.getHome("MONMantenimientoMAE",
            MONMantenimientoMAEHome.class);

      return localHome;
   }

   public static MONProductosHome getMONProductosHome()
      throws MareException {
      MONProductosHome localHome = (MONProductosHome) UtilidadesEJB.getHome("MONProductos",
            MONProductosHome.class);

      return localHome;
   }

   /*
    * ENTIDADES
    */
   public static MaestroProductosLocalHome getMaestroProductosLocalHome()
      throws MareException {
      return (MaestroProductosLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/MaestroProductos");
   }

}
