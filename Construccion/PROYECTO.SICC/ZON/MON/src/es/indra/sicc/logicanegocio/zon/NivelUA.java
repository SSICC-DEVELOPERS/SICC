package es.indra.sicc.logicanegocio.zon;
import es.indra.sicc.util.UtilidadesLog;
import java.lang.*;

public class NivelUA 
{
  public NivelUA()
  {
  }
  
  public String obtenerEntidad(Integer nNivel)
  {
      UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Entrada");
      // Obtiene nombre de las tablas.
      int nivelTabla = nNivel.intValue();
      String sNombreTablaBD;

      switch (nivelTabla)
      {
        case 1:
          sNombreTablaBD = new String("ZON_SUB_GEREN_VENTA");
          UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
          return sNombreTablaBD;

        case 2:
          sNombreTablaBD = new String("ZON_REGIO");
          UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
          return sNombreTablaBD;          

        case 3:
          sNombreTablaBD = new String("ZON_ZONA");
          UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
          return sNombreTablaBD;          

        case 4:
          sNombreTablaBD = new String("ZON_SECCI");
          UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
          return sNombreTablaBD;

        case 5: 
          // Retorna TERRI_ADMIN porque territorio-seccion 
          // establecen una relacion m:n.
          sNombreTablaBD = new String("ZON_TERRI_ADMIN");
          UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
          return sNombreTablaBD;     

        case 6: 
          sNombreTablaBD = new String("ZON_TERRI");
          UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
          return sNombreTablaBD;
      }
      
      UtilidadesLog.info("NivelUA.obtenerEntidad(Integer nNivel): Salida");
      return null;
  }

  public String obtenerNombreRelacion(Integer nNivel)
  {
      UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Entrada");
      // Obtiene nombre de campos de FK.
      int nivelTabla = nNivel.intValue();
      String sRelacion;

      switch (nivelTabla)
      {

        case 2:
          sRelacion = new String("ZSGV_OID_SUBG_VENT");
          UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Salida");
          return sRelacion;          

        case 3:
          sRelacion = new String("ZORG_OID_REGI");
          UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Salida");
          return sRelacion;          

        case 4:
          sRelacion = new String("ZZON_OID_ZONA");
          UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Salida");
          return sRelacion;

        case 5: 
          sRelacion = new String("ZSCC_OID_SECC");
          UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Salida");
          return sRelacion;

        case 6: 
          sRelacion = new String("TERR_OID_TERR");
          UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Salida");
          return sRelacion;  
      }
    UtilidadesLog.info("NivelUA.obtenerNombreRelacion(Integer nNivel): Salida");
    return null;
  }

  public String obtenerNombreClave(Integer nNivel)
  {
      UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Entrada");
      int nivelTabla = nNivel.intValue();
      String sCampo;

      switch (nivelTabla)
      {

        case 1: // Entidad SGV.
          sCampo = new String("OID_SUBG_VENT");
          UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
          return sCampo;  

        case 2: // Entidad Region.
          sCampo = new String("OID_REGI");
          UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
          return sCampo;  

        case 3: // Entidad Zona.
          sCampo = new String("OID_ZONA");
          UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
          return sCampo;

        case 4: // Entidad Seccion
          sCampo = new String("OID_SECC");
          UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
          return sCampo;

        case 5:  // Entidad Territorio Administrativo.
          // Retorna TERRI_ADMIN porque territorio-seccion 
          // establecen una relacion m:n.
          sCampo = new String("TERR_OID_TERR");
          UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
          return sCampo;          

        case 6: // Entidad Territorio
          sCampo = new String("OID_TERR");
          UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
          return sCampo;
      }  
      UtilidadesLog.info("NivelUA.obtenerNombreClave(Integer nNivel): Salida");
      return null;
  }
  
}