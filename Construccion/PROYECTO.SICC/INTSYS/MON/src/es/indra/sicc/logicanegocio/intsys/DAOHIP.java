package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import java.util.Vector;

import java.math.BigDecimal;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTODatosRuvContaCentral;
import es.indra.sicc.dtos.intsys.DTONomApeCliente;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DAOHIP 
{
  public DAOHIP()
  {
  }
  public DTOOID obtenerOidSubAcc(String codSubacceso) throws MareException
  {
    UtilidadesLog.info("DAOHIP.obtenerOidSubAcc(String codSubacceso): Entrada");
    
    StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
    
    consulta.append("SELECT S.OID_SBAC ");
    consulta.append("FROM SEG_SUBAC S,SEG_ACCES A, SEG_CANAL C ");
    consulta.append("WHERE S.ACCE_OID_ACCE = A.OID_ACCE ");
    consulta.append("AND A.CANA_OID_CANA = C.OID_CANA ");
    consulta.append("AND S.COD_SBAC = ?");
    consulta.append(" AND ROWNUM = 1");
    parametros.add(codSubacceso);
  
    
    UtilidadesLog.debug("***** Consulta: " + consulta.toString());
    
    // se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet resultado = null;
    String codigoError = null;
      
    try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    DTOOID dto = new DTOOID();
    
    if(!resultado.esVacio()){
      dto.setOid(new Long(((BigDecimal)resultado.getValueAt(0,"OID_SBAC")).longValue()));
    }
    
    UtilidadesLog.info("DAOHIP.obtenerOidSubAcc(String codSubacceso): Salida");
    return dto;
  }
  //Modificado tipo de codCliente a String y oidPais a Long por incidencia 17192
  public DTONomApeCliente obtenerNomApeCliente(String codCliente,Long oidPais) throws MareException
  {
    UtilidadesLog.info("DAOHIP.obtenerNomApeCliente(String codCliente,Long oidPais): Entrada");
    
    StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
    
    consulta.append("SELECT C.OID_CLIE OID, C.VAL_NOM1, C.VAL_NOM2, C.VAL_APE1, C.VAL_APE2 ");
    consulta.append("FROM MAE_CLIEN C ");
    consulta.append("WHERE C.COD_CLIE = ?");
    consulta.append(" AND C.PAIS_OID_PAIS = ?");
    parametros.add(codCliente);
    parametros.add(oidPais);
    
    UtilidadesLog.debug("***** Consulta: " + consulta.toString());
    
    // se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet resultado = null;
    String codigoError = null;
      
    try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    DTONomApeCliente dto= new DTONomApeCliente();
    if(!resultado.esVacio())
    {
      dto.setApellido1((String)resultado.getValueAt(0,"VAL_APE1"));
      dto.setApellido2((String)resultado.getValueAt(0,"VAL_APE2"));
      dto.setNombre1((String)resultado.getValueAt(0,"VAL_NOM1"));
      dto.setNombre2((String)resultado.getValueAt(0,"VAL_NOM2"));
      dto.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(0,"OID")).longValue()));
    }
    
    UtilidadesLog.info("DAOHIP.obtenerNomApeCliente(String codCliente,Long oidPais): Salida");
    return dto;
  }
   
    public Long obtenerOidDocumentoIdentidad(String tipoDocumentoIdentidad) throws MareException
    {
      UtilidadesLog.info("DAOHIP.obtenerOidDocumentoIdentidad(String tipoDocumentoIdentidad): Entrada");
      Long oid=null;
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      consulta.append("SELECT S.OID_TIPO_DOCU ");
      consulta.append("FROM MAE_TIPO_DOCUM S ");
      consulta.append("WHERE S.COD_TIPO_DOCU = ? ");
      parametros.add(tipoDocumentoIdentidad);
    
      
      UtilidadesLog.debug("***** Consulta: " + consulta.toString());
      
      // se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
        
      try {
           resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
                  } catch(Exception e) {
           UtilidadesLog.error(e);
           codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;         
           throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
    
      
      if(!resultado.esVacio()){
        oid= ((BigDecimal)resultado.getValueAt(0,"OID_TIPO_DOCU")).longValue();
      }
      
        UtilidadesLog.info("DAOHIP.obtenerOidDocumentoIdentidad(String tipoDocumentoIdentidad): Salida");
      return oid;
    } 
    
    public DTODatosRuvContaCentral obtenerDatosRuvContabilidadCentral(String numeroIdentidad) throws MareException
    {  
      UtilidadesLog.info("DAOHIP.obtenerDatosRuvContabilidadCentral(String numeroIdentidad): Entrada");
      DTODatosRuvContaCentral dto=null;
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      consulta.append(" SELECT OID_RUV_CONT_CENT_EXTE, VAL_NUME_IDEN_PROV_EXTE, VAL_NUME_IDEN_NNAL, TDOC_OID_TIPO_DOCU,VAL_NOMB ");
      consulta.append(" FROM RUV_CONTA_CENTR_EXTER ");
      consulta.append(" WHERE VAL_NUME_IDEN_PROV_EXTE = ? ");
      consulta.append(" AND ROWNUM=1 ");
      parametros.add(numeroIdentidad);
    
      
      UtilidadesLog.debug("***** Consulta: " + consulta.toString());
      
      // se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
        
      try {
           resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
                  } catch(Exception e) {
           UtilidadesLog.error(e);
           codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;         
           throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
    
      
      if(!resultado.esVacio()){
         dto=new DTODatosRuvContaCentral();
         dto.setOid(new Long(((BigDecimal)resultado.getValueAt(0,"OID_RUV_CONT_CENT_EXTE")).longValue()));
         dto.setIdentidadFiscal((String)resultado.getValueAt(0,"VAL_NUME_IDEN_PROV_EXTE"));
         dto.setIdentidadNacional((String)resultado.getValueAt(0,"VAL_NUME_IDEN_NNAL"));
         dto.setOidTipoDocumento(new Long(((BigDecimal)resultado.getValueAt(0,"TDOC_OID_TIPO_DOCU")).longValue()));
         dto.setNombre((String)resultado.getValueAt(0,"VAL_NOMB"));
      }
      
      UtilidadesLog.info("DAOHIP.obtenerDatosRuvContabilidadCentral(String numeroIdentidad): Salida");
      return dto;
    } 
   
}