package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;


//import es.indra.sicc.entidades.mae.ClienteClasificacionLocalHome;
public class MSGEjbLocators {
   /*
    * MONes
    */
   public static MONGestionMensajesHome getMONGestionMensajesHome()
      throws MareException {
      MONGestionMensajesHome localHome = (MONGestionMensajesHome) UtilidadesEJB.getHome("MONGestionMensajes",
            MONGestionMensajesHome.class);

      return localHome;
   }


}
