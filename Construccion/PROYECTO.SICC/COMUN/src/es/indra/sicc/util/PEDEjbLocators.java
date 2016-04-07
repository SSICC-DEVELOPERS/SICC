package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONGrupoProcesoSolicitudHome;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosHome;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitudHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.fac.MONFacturacionHome;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;

public class PEDEjbLocators {
   /*
    * MON's
    */
   public static MONFacturacionHome getMONFacturacionHome()
      throws MareException {
      MONFacturacionHome localHome = (MONFacturacionHome) UtilidadesEJB.getHome("MONFacturacion",
            MONFacturacionHome.class);

      return localHome;
   }

   public static MONMantenimientoSEGHome getMONMantenimientoSEGHome()
      throws MareException {
      MONMantenimientoSEGHome localHome = (MONMantenimientoSEGHome) UtilidadesEJB.getHome("MONMantenimientoSEG",
            MONMantenimientoSEGHome.class);

      return localHome;
   }

   public static MONGrupoProcesoSolicitudHome getMONGrupoProcesoSolicitudHome()
      throws MareException {
      MONGrupoProcesoSolicitudHome localHome = (MONGrupoProcesoSolicitudHome) UtilidadesEJB.getHome("MONGrupoProcesoSolicitud",
            MONGrupoProcesoSolicitudHome.class);

      return localHome;
   }

   public static MONSeguimientoPedidosHome getMONSeguimientoPedidosHome()
      throws MareException {
      MONSeguimientoPedidosHome localHome = (MONSeguimientoPedidosHome) UtilidadesEJB.getHome("MONSeguimientoPedidos",
            MONSeguimientoPedidosHome.class);

      return localHome;
   }

   public static MONPedidosSolicitudHome getMONPedidosSolicitudHome()
      throws MareException {
      MONPedidosSolicitudHome localHome = (MONPedidosSolicitudHome) UtilidadesEJB.getHome("MONPedidosSolicitud",
            MONPedidosSolicitudHome.class);

      return localHome;
   }    
   
   public static MONProcesosPEDHome getMONProcesosPEDHome()
      throws MareException {
      MONProcesosPEDHome localHome = (MONProcesosPEDHome) UtilidadesEJB.getHome("MONProcesosPED",
            MONProcesosPEDHome.class);

      return localHome;
   }    
   
   public static MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome()
      throws MareException {
      MONGenerarSolicitudModulosExternosHome localHome = (MONGenerarSolicitudModulosExternosHome) UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos",
            MONGenerarSolicitudModulosExternosHome.class);

      return localHome;
   }    
   
    
}
