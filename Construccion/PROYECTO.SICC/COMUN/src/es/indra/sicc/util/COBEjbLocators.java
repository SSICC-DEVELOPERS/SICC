package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

//import es.indra.sicc.logicanegocio.cob.MONParametrizacionCOBHome;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocalHome;
import es.indra.sicc.entidades.cob.CronogramaCobranzaLocalHome;
import es.indra.sicc.entidades.cob.EtapasDeudaLocalHome;
import es.indra.sicc.entidades.cob.GestionesCobranzaLocalHome;
import es.indra.sicc.entidades.cob.HistoricoMensajesLocalHome;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocalHome;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaCabeceraLocalHome;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaDetalleLocalHome;
import es.indra.sicc.entidades.cob.CompromisoPagoLocalHome;
import es.indra.sicc.entidades.cob.HistoricoComisionesCobranzaLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.logicanegocio.cob.MONGestionesDeCobranzaHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;

public class COBEjbLocators 
{
  /*
   * MONes
   */
     public static MONGestionMensajesHome getMONGestionMensajesHome()
      throws MareException {
      MONGestionMensajesHome localHome = (MONGestionMensajesHome) UtilidadesEJB.getHome("MONGestionMensajes",
            MONGestionMensajesHome.class);

      return localHome;
   }
   
    public static MONProcesosPEDHome getMONProcesosPEDHome()
      throws MareException {
      MONProcesosPEDHome localHome = (MONProcesosPEDHome) UtilidadesEJB.getHome("MONProcesosPED",
            MONProcesosPEDHome.class);

      return localHome;
   }
   
   public static MONGestionesDeCobranzaHome getMONGestionesDeCobranza()
      throws MareException {
      MONGestionesDeCobranzaHome localHome = (MONGestionesDeCobranzaHome) UtilidadesEJB.getHome("MONGestionesDeCobranza",
            MONGestionesDeCobranzaHome.class);

      return localHome;
   }
  /*
   * Entidades
   */
   public static UsuariosCobranzasLocalHome getUsuariosCobranzasLocalHome()
      throws MareException 
   {
      return (UsuariosCobranzasLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/UsuariosCobranzas");
   }
   
   public static UsuariosEtapaCobranzaCabeceraLocalHome getUsuariosEtapaCobranzaCabeceraLocalHome()
      throws MareException 
   {
      return (UsuariosEtapaCobranzaCabeceraLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/UsuariosEtapaCobranzaCabecera");
   }
   
   public static UsuariosEtapaCobranzaDetalleLocalHome getUsuariosEtapaCobranzaDetalleLocalHome()
      throws MareException 
   {
      return (UsuariosEtapaCobranzaDetalleLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/UsuariosEtapaCobranzaDetalle");
   }
   
   
   public static HistoricoMensajesLocalHome getHistoricoMensajesLocalHome()
      throws MareException 
   {
      return (HistoricoMensajesLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/HistoricoMensajes");
   }
   
   
   public static EtapasDeudaLocalHome getEtapasDeudaLocalHome()
      throws MareException 
   {
      return (EtapasDeudaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/EtapasDeuda");
   }
   
   public static MensajesLocalHome getMensajesLocalHome()
      throws MareException 
   {
      return (MensajesLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/Mensajes");
   }
   
   public static ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome()
      throws MareException 
   {
      return (ClienteDatosBasicosLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ClienteDatosBasicos");
   }
   
   public static CronogramaCobranzaLocalHome getCronogramaCobranzaLocalHome()
      throws MareException 
   {
      return (CronogramaCobranzaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/CronogramaCobranza");
   }
   
   
   public static AccionesCobranzaLocalHome getAccionesCobranzaLocalHome()
      throws MareException 
   {
      return (AccionesCobranzaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/AccionesCobranza");
   }
   
   public static GestionesCobranzaLocalHome getGestionesCobranzaLocalHome()
      throws MareException 
   {
      return (GestionesCobranzaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/GestionesCobranza");
   }
   
   public static CompromisoPagoLocalHome getCompromisoPagoLocalHome()
      throws MareException 
   {
      return (CompromisoPagoLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/CompromisoPago");
   }
   
   public static HistoricoComisionesCobranzaLocalHome getHistoricoComisionesCobranzaLocalHome()
      throws MareException 
   {
      return (HistoricoComisionesCobranzaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/HistoricoComisionesCobranza");
   }
   
}