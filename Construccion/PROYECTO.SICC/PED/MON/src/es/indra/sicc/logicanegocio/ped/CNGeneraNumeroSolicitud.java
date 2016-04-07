package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDLocal;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;


public class CNGeneraNumeroSolicitud {

  public CNGeneraNumeroSolicitud(){
  }

  public String generaNumero(DTONumeroSolicitud dto) throws MareException{
      UtilidadesLog.info("CNGeneraNumeroSolicitud.generaNumero(DTONumeroSolicitud dto): Entrada  ");
      String numeroDocumento;
      SimpleDateFormat sdf = new SimpleDateFormat("yy");
      Date currentYear = new Date( System.currentTimeMillis());
      String yy = sdf.format(currentYear);   
      dto.setAnyo(new Integer(yy)); 
      obtenerCodigos(dto);
      numeroDocumento = this.generarNumeroDocumento(dto);
      UtilidadesLog.info("CNGeneraNumeroSolicitud.generaNumero(DTONumeroSolicitud dto): Salida  ");
      return numeroDocumento;
  }

  public String generaSecuencia(DTONumeroSolicitud dto) throws MareException{
    UtilidadesLog.info("CNGeneraNumeroSolicitud.generaSecuencia(DTONumeroSolicitud dto): Entrada ");
    String numeroDocumento;
    obtenerCodigos(dto);
    numeroDocumento = this.generarNumeroDocumento(dto);
    UtilidadesLog.info("CNGeneraNumeroSolicitud.generaSecuencia(DTONumeroSolicitud dto): Salida ");
    return numeroDocumento;
  } 

    /**
     * @cambio por RI 20090925
     * @autor gdemarzi
     */
    private String generarNumeroDocumento(DTONumeroSolicitud dtoNumero) throws MareException {
        UtilidadesLog.info("CNGeneraNumeroSolicitud.generarNumeroDocumento(): entrada");
        String proxNumeroSolicitud;
        String numeroDocumento;
    
        ArrayList arrayParametros = new ArrayList();
        arrayParametros.add(dtoNumero.getCodPais());
        arrayParametros.add(dtoNumero.getCodCanal());
        arrayParametros.add(dtoNumero.getCodAcceso());
        arrayParametros.add(dtoNumero.getCodSubacceso());
        arrayParametros.add(dtoNumero.getOperacion());
        arrayParametros.add(dtoNumero.getAnyo().toString());
        
        try {
            proxNumeroSolicitud = this.getMONProcesosPEDLocal().ejecutarFuncionNumeroSolicitud(arrayParametros);
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR al localizar un componente EJB",ne);
            throw new MareException(ne);
        }
        numeroDocumento = this.armarNumeroSolicitud(proxNumeroSolicitud, dtoNumero.getAnyo() );
        
        UtilidadesLog.info("CNGeneraNumeroSolicitud.generarNumeroDocumento(): salida");
        return numeroDocumento;      
    }


  /**
   * Se devuelve esta cadena:
   * AANNNNNNNN
   * - AA: propiedad anyo
   * - NNNNNNNN: Si ultimoNumSolicitud sabiendo que tiene que tener 8 números, 
   * si no llegara a 8 se rellena por la izquierda con ceros.
   */
  public String armarNumeroSolicitud(String ultimoNumSolicitud, Integer anio) {
    UtilidadesLog.info("CNGeneraNumeroSolicitud.armarNumeroSolicitud(DTONumeroSolicitud dto): Entrada ");
    StringBuffer strNumeroSolicitud = new StringBuffer();
    strNumeroSolicitud.append(cerosIzq(anio.toString(),2));
    strNumeroSolicitud.append(cerosIzq(ultimoNumSolicitud,8) ); 
    UtilidadesLog.debug("strNumeroSolicitud: " + strNumeroSolicitud);
    UtilidadesLog.info("CNGeneraNumeroSolicitud.armarNumeroSolicitud(DTONumeroSolicitud dto): Salida ");
    return strNumeroSolicitud.toString();   
  }

  /*
   * Metodo para rellenar con ceros a izquierda un string de longitud cantidad.
   */
    private String cerosIzq(String cadena1, int cantidad) {
        StringBuffer cantCeros = new StringBuffer("");
        for(int i=0; i < cantidad - cadena1.length() ;i++) {
            cantCeros.append("0");
        }
        StringBuffer cadena2 = new StringBuffer(cantCeros.toString());
        cadena2.append(cadena1);
        return cadena2.toString();
    }


  private void obtenerCodigos(DTONumeroSolicitud dto) throws MareException{  
    UtilidadesLog.info("CNGeneraNumeroSolicitud.obtenerCodigos(DTONumeroSolicitud dto): Entrada ");
    RecordSet rs = null;
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT (SELECT P.COD_PAIS ");
	  query.append(" 	FROM SEG_PAIS P ");
		query.append("WHERE P.OID_PAIS = ").append(dto.getOidPais());  	
	  query.append(" ) COD_PAIS, ");
	  query.append(" NVL((SELECT C.COD_CANA ");
	  query.append(" 	    FROM SEG_CANAL C ");
		query.append("	WHERE C.OID_CANA = ").append(dto.getOidCanal());
	  query.append(" ),'_') COD_CANA, ");
	  query.append(" NVL((SELECT ACC.COD_ACCE ");
	  query.append(" 	    FROM SEG_ACCES ACC ");
		query.append("	WHERE ACC.OID_ACCE = ").append(dto.getOidAcceso());	   
	  query.append(" ), '_') COD_ACCE, ");
	  query.append(" NVL((SELECT SUB.COD_SBAC ");
	  query.append("		FROM SEG_SUBAC SUB ");
		query.append("	WHERE SUB.OID_SBAC = ").append(dto.getOidSubacceso());	   
	  query.append(" ),'_') COD_SUBAC ");
    query.append(" FROM DUAL ");
    
    rs = this.executeQuery(query.toString());
        
    dto.setCodPais((String)rs.getValueAt(0,"COD_PAIS"));
    dto.setCodCanal((String)rs.getValueAt(0,"COD_CANA"));
    dto.setCodAcceso((String)rs.getValueAt(0,"COD_ACCE"));
    dto.setCodSubacceso((String)rs.getValueAt(0,"COD_SUBAC"));

    UtilidadesLog.info("CNGeneraNumeroSolicitud.obtenerCodigos(DTONumeroSolicitud dto): Salida ");
  }


  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("CNGeneraNumeroSolicitud.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("CNGeneraNumeroSolicitud.executeQuery(String query): Salida");
    return rs;
  }


    private MONProcesosPEDLocal getMONProcesosPEDLocal() throws NamingException, MareException {

        MONProcesosPEDLocalHome localHome = this.getMONProcesosPEDLocalHome();
        // Se obtiene el interfaz remoto
        MONProcesosPEDLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("Error en getMONProcesosPEDLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }

    private MONProcesosPEDLocalHome getMONProcesosPEDLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONProcesosPEDLocalHome) context.lookup( "java:comp/env/ejb/local/MONProcesosPED" );
    }
}