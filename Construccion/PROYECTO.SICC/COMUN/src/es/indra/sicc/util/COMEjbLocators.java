package es.indra.sicc.util;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.com.ComisionesMetasLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesAccesoLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocalHome;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocalHome;
import es.indra.sicc.entidades.com.ComisionesLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentasLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasClienteLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasLocalHome;
import es.indra.sicc.entidades.com.ComisionesClientesLocalHome;
import es.indra.sicc.logicanegocio.com.MONCalcularComisionesHome;
import es.indra.sicc.logicanegocio.com.MONCalcularVolumenFacturasHome;
import es.indra.sicc.entidades.com.CongeladosLocalHome;
import es.indra.sicc.entidades.com.CuotasTramoComisionesCalculadasLocalHome;

public class COMEjbLocators 
{
   

   // Entidades
   public static PlantillasComisionesLocalHome getPlantillasComisionesLocalHome()
      throws MareException 
   {
      return (PlantillasComisionesLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/PlantillasComisiones");
   }


   
   public static PlantillasComisionesAccesoLocalHome getPlantillasComisionesAccesoLocalHome()
      throws MareException 
   {
      return (PlantillasComisionesAccesoLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/PlantillasComisionesAcceso");
   }
   
   public static PlantillasComisionesMarcaLocalHome getPlantillasComisionesMarcaLocalHome()
      throws MareException 
   {
      return (PlantillasComisionesMarcaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/PlantillasComisionesMarca");
   }
   
   public static PlantillasComisionesPaisLocalHome getPlantillasComisionesPaisLocalHome()
      throws MareException 
   {
      return (PlantillasComisionesPaisLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/PlantillasComisionesPais");
   }
   
   
   public static ComisionesLocalHome getComisionesLocalHome()
      throws MareException 
   {
      return (ComisionesLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/Comisiones");
   }
   
   public static ComisionesClientesLocalHome getComisionesClientesLocalHome()
      throws MareException 
   {
      return (ComisionesClientesLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesClientes");
   }

   
   public static ComisionesVentasLocalHome getComisionesVentasLocalHome()
      throws MareException 
   {
      return (ComisionesVentasLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesVentas");
   }

   public static ComisionesVentaHistoricaLocalHome getComisionesVentaHistoricaLocalHome()
      throws MareException 
   {
      return (ComisionesVentaHistoricaLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesVentaHistorica");
   }

   public static ComisionesMetasLocalHome getComisionesMetasLocalHome()
      throws MareException 
   {
      return (ComisionesMetasLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesMetas");
   }

   public static ComisionesCalculadasLocalHome getComisionesCalculadasLocalHome()
      throws MareException 
   {
      return (ComisionesCalculadasLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesCalculadas");
   }
   
    public static ComisionesCobranzasAcumuladasLocalHome getComisionesCobranzasAcumuladasLocalHome()
      throws MareException 
   {
      return (ComisionesCobranzasAcumuladasLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesCobranzasAcumuladas");
   }
   
   public static ComisionesCobranzasAcumuladasClienteLocalHome getComisionesCobranzasAcumuladasClienteLocalHome()
      throws MareException 
   {
      return (ComisionesCobranzasAcumuladasClienteLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/ComisionesCobranzasAcumuladasCliente");
   }
   
   
   
   public static CongeladosLocalHome getCongeladosLocalHome()
      throws MareException 
   {
      return (CongeladosLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/Congelados");
   }
   
   public static CuotasTramoComisionesCalculadasLocalHome getCuotasTramoComisionesCalculadasLocalHome()
      throws MareException 
   {
      return (CuotasTramoComisionesCalculadasLocalHome) UtilidadesEJB.getLocalHome(
         "java:comp/env/CuotasTramoComisionesCalculadas");
   }
   
   
   /*
   * MONes
   */
   public static MONCalcularVolumenFacturasHome getMONCalcularVolumenFacturasHome()
      throws MareException {
      MONCalcularVolumenFacturasHome localHome = (MONCalcularVolumenFacturasHome) UtilidadesEJB.getHome("MONCalcularVolumenFacturas",
            MONCalcularVolumenFacturasHome.class);

      return localHome;
   }
   
   public static MONCalcularComisionesHome getMONCalcularComisionesHome()
      throws MareException {
      MONCalcularComisionesHome localHome = (MONCalcularComisionesHome) UtilidadesEJB.getHome("MONCalcularComisiones",
            MONCalcularComisionesHome.class);

      return localHome;
   }    
    
}