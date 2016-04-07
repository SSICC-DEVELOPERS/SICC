/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.FinderException;
import es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion;
import es.indra.sicc.entidades.mae.TipoClasificacionLocalHome;
import es.indra.sicc.entidades.mae.TipoClasificacionLocal;
import es.indra.sicc.entidades.mae.ClienteClasificacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteClasificacionLocal;
import es.indra.sicc.util.MAEEjbLocators;
import javax.ejb.RemoveException;
import java.util.ArrayList;

import javax.persistence.NoResultException;

public class DAORecepcionarClasificacion  {

  public DAORecepcionarClasificacion() { }
  
   /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       7/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
  public Long obtenerClasificacion (Long oidTipoClasificacion) throws MareException {
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerClasificacion(Long oidTipoClasificacion): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();
    BelcorpService belcorpService = null;
    
    if(oidTipoClasificacion==null)  return null;
    
    query.append(" SELECT MC.OID_CLAS ");
    query.append(" FROM MAE_CLASI MC ");
    query.append(" WHERE MC.COD_CLAS = '" + ConstantesCPR.CPR1_COD_CLASI + "'");
    query.append(" AND MC.TCCL_OID_TIPO_CLAS = " + oidTipoClasificacion);
     
    try {
        rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    }
    catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
        
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerClasificacion(Long oidTipoClasificacion): Salida");
    if(!rs.esVacio()) return Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_CLAS")).toString());
    else return null;           
  }
  
   /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       7/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
  public Long obtenerOIDTipoClasificacion(String codigoClasificacion, Long oidCliente) throws MareException  {
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerOIDTipoClasificacion(String codigoClasificacion, Long oidCliente): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();
    BelcorpService belcorpService = null;
    
    query.append(" SELECT MTCC.OID_TIPO_CLAS ");
    query.append(" FROM MAE_TIPO_CLASI_CLIEN MTCC, ");
    query.append(" MAE_CLIEN_TIPO_SUBTI MCTS ");
    query.append(" WHERE ");
    
    if(oidCliente!=null)  {
        query.append(" MCTS.OID_CLIE_TIPO_SUBT = " + oidCliente + " AND ");    
    }   
    
    query.append(" MTCC.SBTI_OID_SUBT_CLIE = MCTS.SBTI_OID_SUBT_CLIE ");
    query.append(" AND MTCC.COD_TIPO_CLAS = '" + codigoClasificacion + "'");
     
    try {
        rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    }
    catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
        
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerOIDTipoClasificacion(String codigoClasificacion, Long oidCliente): Salida");
    if(!rs.esVacio()) return Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_TIPO_CLAS")).toString());
    else return null;                
  }
  
  
   /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       7/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Comentarios: Consulta modificada en incidencia 21202
    */
  
  public RecordSet obtenerClienteTipoSubTipo (String codigoCliente, String pais) throws MareException {
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerClienteTipoSubTipo(String codigoCliente, String pais): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();
    BelcorpService belcorpService = null;
    
    query.append(" SELECT MCTB.OID_CLIE_TIPO_SUBT  ");
    query.append(" FROM MAE_CLIEN_TIPO_SUBTI MCTB,  ");
    query.append(" MAE_CLIEN MC,  ");
    query.append(" MAE_TIPO_CLIEN MTC,  ");
    query.append(" SEG_PAIS SP, ");
	query.append(" MAE_SUBTI_CLIEN MSC ");
    query.append(" WHERE SP.OID_PAIS = " + pais);
    query.append(" AND MC.PAIS_OID_PAIS = SP.OID_PAIS  ");
    query.append(" AND MC.COD_CLIE = '" + codigoCliente + "' ");
    query.append(" AND MC.OID_CLIE = MCTB.CLIE_OID_CLIE  ");
    query.append(" AND MCTB.TICL_OID_TIPO_CLIE = MTC.OID_TIPO_CLIE  ");
    query.append(" AND MTC.COD_TIPO_CLIE = '" + ConstantesCPR.CPR1_TIPO_CLIENTE + "' ");
	query.append(" AND MCTB.SBTI_OID_SUBT_CLIE = MSC.OID_SUBT_CLIE ");
	query.append(" AND MSC.COD_SUBT_CLIE IN ('04', '06') ");
     
    try {
        rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    }
    catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }

    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerClienteTipoSubTipo(String codigoCliente, String pais): Salida");    
    return rs;
  }

  /**
   * Arma la sentencia IN con tipos de clasificaciones.
   */
  private StringBuffer generaTiposClasificacionIN(ArrayList arrayClasificaciones) throws MareException {
      StringBuffer strIn = new StringBuffer();
      strIn.append("  AND (");
      int count = 0;
      String oidsTiposClasificacion = "";
      Iterator it = (Iterator)arrayClasificaciones.iterator();            
      while (it.hasNext()){
        BigDecimal oidTipoClasificacion = new BigDecimal( it.next().toString());
        if (oidTipoClasificacion != null){
            if (count == 0) {
                oidsTiposClasificacion = oidTipoClasificacion.toString();
            } else { 
                oidsTiposClasificacion += "," + oidTipoClasificacion.toString();
            }
        }                    
        if (count == 999)  {
            strIn.append(" MCC.TCCL_OID_TIPO_CLASI IN (" + oidsTiposClasificacion.toString() + ") ");                     
            if (it.hasNext()){
                strIn.append("  OR ");
            }                    
            count = 0;
            oidsTiposClasificacion = "";             
        } else {
            if (!it.hasNext()){
                strIn.append(" MCC.TCCL_OID_TIPO_CLASI IN (" + oidsTiposClasificacion.toString() + ") ");        
            }                    
            count++;            
        } 
        
        if (!it.hasNext()){              
          strIn.append(")");
        }
      }
      return strIn;
  }
  


  /**
   * Arma la sentencia IN con codigos de cliente.
   */
  private StringBuffer generaCodigosClienteIN(Collection codigosCliente) throws MareException {
      StringBuffer strIn = new StringBuffer();
      strIn.append("  AND (");
      int count = 0;
      String strCodigosCliente = "";
      Iterator it = (Iterator)codigosCliente.iterator();            
      while (it.hasNext()){
        String codigo = (String)it.next();
        if (codigo != null){
            if (count == 0) {
                strCodigosCliente = "'" + codigo + "'";
            } else { 
                strCodigosCliente += "," + "'" + codigo + "'";
            }
        }                    
        if (count == 999)  {
            strIn.append(" CLIE.COD_CLIE IN (" + strCodigosCliente.toString() + ") ");                     
            if (it.hasNext()){
                strIn.append("  OR ");
            }                    
            count = 0;
            strCodigosCliente = "";             
        } else {
            if (!it.hasNext()){
                strIn.append(" CLIE.COD_CLIE IN (" + strCodigosCliente.toString() + ") ");        
            }                    
            count++;            
        } 
        
        if (!it.hasNext()){              
          strIn.append(")");
        }
      }
      return strIn;
  }
  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       12/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */      
  private String generaINClause(Long[] oids) throws MareException {
        UtilidadesLog.info("DAORecepcionarClasificacion.generaINClause(Long[] oids): Entrada");
        StringBuffer sClausula = new StringBuffer("");

        try {
            sClausula.append(" IN ( ");

            for (int i = 0; i < oids.length; i++) {
                Long oid = oids[i];
                if (i != 0) sClausula.append(", ");
                sClausula.append("" + oid);
            }

            sClausula.append(")");
        }
        catch (Exception ex) {
            UtilidadesLog.debug(ex);
        }

        UtilidadesLog.info("DAORecepcionarClasificacion.generaINClause(Long[] oids): Salida");
        return sClausula.toString();
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       12/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */    
    private String generaINClauseCodigos(String[] codigos) throws MareException {
        UtilidadesLog.info("DAORecepcionarClasificacion.generaINClauseCodigos(String[] codigos): Entrada");
        StringBuffer sClausula = new StringBuffer("");

        try {
            sClausula.append(" IN ( ");

            for (int i = 0; i < codigos.length; i++) {
                String codigo = codigos[i];
                if (i != 0) sClausula.append(", ");
                sClausula.append("'" + codigo + "'");
            }

            sClausula.append(")");
        }
        catch (Exception ex) {
            UtilidadesLog.debug(ex);
        }

        UtilidadesLog.info("DAORecepcionarClasificacion.generaINClauseCodigos(String[] codigos): Salida");
        return sClausula.toString();
    }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       6/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
  
  public RecordSet obtenerClientesClasificacion (RecordSet clasificaciones, 
    Collection clientes, String pais) throws MareException{
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerClientesClasificacion(RecordSet clasificaciones, Collection clientes):Entrada");
    StringBuffer query = new StringBuffer();
    
    RecordSet rs = new RecordSet();
    BelcorpService belcorpService = null;
    
    //1° - Creo un array de Long que tendra los oid de tipo clasificacion
    //lo utilizo para generar la clausula IN - ejemplo IN(1,2,3)
    int cant = clasificaciones.getRowCount();
    Long[] arrayClasificaciones = new Long[cant];
    
    for(int i=0 ; i<cant; i++) {
        arrayClasificaciones[i] = Long.valueOf(((BigDecimal)clasificaciones.getValueAt(i, "OID_TIPO_CLAS")).toString());              
    }
    
    String clausulaINTipoClasi = this.generaINClause(arrayClasificaciones);
    
    //2° - Creo un array de String que tendra los codigos de cliente
    //lo utilizo para generar la clausula IN - ejemplo IN('000000000002', '00000000003')    
    String clausulaINCodigosCliente = null;
    if(clientes!=null && clientes.size()>0) {
        String[] codigosCliente = new String[clientes.size()];
        int i=0;        
        Iterator it = clientes.iterator();    
        while(it.hasNext()) {
            codigosCliente[i] = (String)it.next();
            i++;
        }
        
        clausulaINCodigosCliente = this.generaINClauseCodigos(codigosCliente);        
    }    
    
    query.append(" SELECT MCC.OID_CLIE_CLAS ");
    query.append(" FROM MAE_CLIEN_CLASI MCC, ");
    query.append(" MAE_CLIEN CLIE, ");
    query.append(" MAE_CLIEN_TIPO_SUBTI MCTS, ");
    query.append(" MAE_TIPO_CLIEN MTC, ");
    query.append(" SEG_PAIS PAIS ");
    query.append(" WHERE PAIS.OID_PAIS = " + pais);
    query.append(" AND CLIE.PAIS_OID_PAIS = PAIS.OID_PAIS ");
    query.append(" AND MCTS.CLIE_OID_CLIE = CLIE.OID_CLIE ");
    query.append(" AND MCC.CTSU_OID_CLIE_TIPO_SUBT = MCTS.OID_CLIE_TIPO_SUBT ");
    query.append(" AND MTC.COD_TIPO_CLIE = '" + ConstantesCPR.CPR1_TIPO_CLIENTE + "'");
    query.append(" AND MCTS.TICL_OID_TIPO_CLIE = MTC.OID_TIPO_CLIE ");
    if(cant>0)  query.append(" AND MCC.TCCL_OID_TIPO_CLASI " + clausulaINTipoClasi);        
    if(clientes!=null && clientes.size()>0) query.append(" AND CLIE.COD_CLIE " + clausulaINCodigosCliente);    
     
    try {
        rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    }
    catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
      
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerClientesClasificacion(RecordSet clasificaciones, Collection clientes):Salida");
    return rs;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       6/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    
  public StringBuffer eliminarClienteClasificacion (Collection clientes, 
    RecordSet clasificaciones, String pais) throws MareException  {
    UtilidadesLog.info("DAORecepcionarClasificacion.eliminarClienteClasificacion(Collection clientes, RecordSet clasificaciones, String pais):Entrada");    
    StringBuffer query = new StringBuffer();
    
    BelcorpService belcorpService = null;
    
    //1° - Creo un array de Long que tendra los oid de tipo clasificacion
    //lo utilizo para generar la clausula IN - ejemplo IN(1,2,3)
    int cant = clasificaciones.getRowCount();
    ArrayList arrayClasificaciones = new ArrayList();
    
    for(int i=0 ; i<cant; i++) {
        arrayClasificaciones.add(Long.valueOf(((BigDecimal)clasificaciones.getValueAt(i, "OID_TIPO_CLAS")).toString()));              
    }
    
    StringBuffer clausulaINTipoClasi = this.generaTiposClasificacionIN(arrayClasificaciones);
    
    //2° - Genero la clausula IN con los codigos cliente - ejemplo IN('000000000002', '00000000003')    
    StringBuffer clausulaINCodigosCliente = null;
    if(clientes!=null && clientes.size()>0) {
        clausulaINCodigosCliente = this.generaCodigosClienteIN(clientes);        
    }    
    query.append(" delete from    MAE_CLIEN_CLASI where oid_clie_clas in( ");
    query.append(" SELECT MCC.OID_CLIE_CLAS ");
    query.append(" FROM MAE_CLIEN_CLASI MCC, ");
    query.append(" MAE_CLIEN CLIE, ");
    query.append(" MAE_CLIEN_TIPO_SUBTI MCTS, ");
    query.append(" MAE_TIPO_CLIEN MTC, ");
    query.append(" SEG_PAIS PAIS ");
    query.append(" WHERE PAIS.OID_PAIS = " + pais);
    query.append(" AND CLIE.PAIS_OID_PAIS = PAIS.OID_PAIS ");
    query.append(" AND MCTS.CLIE_OID_CLIE = CLIE.OID_CLIE ");
    query.append(" AND MCC.CTSU_OID_CLIE_TIPO_SUBT = MCTS.OID_CLIE_TIPO_SUBT ");
    query.append(" AND MTC.COD_TIPO_CLIE = '" + ConstantesCPR.CPR1_TIPO_CLIENTE + "'");
    query.append(" AND MCTS.TICL_OID_TIPO_CLIE = MTC.OID_TIPO_CLIE ");
    if(cant>0){
        query.append(clausulaINTipoClasi); // IN sobre MCC.TCCL_OID_TIPO_CLASI 
    }
    if(clientes!=null && clientes.size()>0){
        query.append(clausulaINCodigosCliente); // IN sobre CLIE.COD_CLIE    
    }
    query.append(" );");
     
    /*try {
        belcorpService.getInstance().dbService.executeUpdate(query.toString());
    }
    catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }*/
      
    UtilidadesLog.info("DAORecepcionarClasificacion.eliminarClienteClasificacion(Collection clientes, RecordSet clasificaciones, String pais):Salida");              
    
    return query;
    
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       6/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Comentarios: Consulta modificada por incidencia 21175
    */

  public RecordSet obtenerTipoClasificacion(DTOINTRecepcionarClasificacion dtoe) throws MareException {
      UtilidadesLog.info("DAORecepcionarClasificacion.obtenerTipoClasificacion(DTOINTRecepcionarClasificacion dtoe):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;

      query.append(" SELECT MTCC.OID_TIPO_CLAS  ");
      query.append(" FROM INT_PARAM_CLASI IPC,  ");
      query.append(" MAE_TIPO_CLASI_CLIEN MTCC  ");
      query.append(" WHERE IPC.CMEJ_OID_MODO_EJEC = " + dtoe.getModoEjecucion());
      query.append(" AND MTCC.COD_TIPO_CLAS = IPC.VAL_TIPO_CLAS ");
     
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      }
      catch (Exception e) {
          UtilidadesLog.error(e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAORecepcionarClasificacion.obtenerTipoClasificacion(DTOINTRecepcionarClasificacion dtoe):Salida");
      return rs;
  }
  
   /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       4/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

  public RecordSet obtenerModosEjecucion() throws MareException {
      UtilidadesLog.info("DAORecepcionarClasificacion.obtenerModosEjecucion():Entrada");
      
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
    
      query.append(" SELECT COD_MODO_EJEC, ");
      query.append(" DESC_MODO_EJEC ");
      query.append(" FROM INT_MODO_EJECU ");
     
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      }
      catch (Exception e) {
          UtilidadesLog.error(e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAORecepcionarClasificacion.obtenerModosEjecucion():Salida");
      return rs;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       22/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public Long obtenerPais(String codPais) throws MareException {
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerPais(String codPais): Entrada");
    
    try {
    PaisLocalHome paisLH= this.getPaisLocalHome();    
    PaisLocal pais = paisLH.findByUk(codPais);    
    UtilidadesLog.info("DAORecepcionarClasificacion.obtenerPais(String codPais): Salida");    
    return pais.getOid();
    
    } catch(NoResultException fe){
        UtilidadesLog.debug(fe);
        UtilidadesLog.info("DAORecepcionarClasificacion.obtenerPais(String codPais): Salida");
        
        return null;
    }
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       22/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public Long obtenerPeriodo(String codPeriodo, Long oidPais) throws MareException {
      UtilidadesLog.info("DAORecepcionarClasificacion.obtenerPeriodo(String codPeriodo, Long oidPais):Entrada");
      
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      Long oid = null;
      
      query.append(" SELECT per.OID_PERI  ");
      query.append(" FROM CRA_PERIO per, ");
	  query.append(" SEG_PERIO_CORPO perCorp,  ");
      query.append(" SEG_MARCA m, ");
	  query.append(" SEG_CANAL c  ");
      query.append(" WHERE per.MARC_OID_MARC = m.OID_MARC  ");
      query.append(" AND ( m.COD_MARC = '" + ConstantesINT.MARCA_GENERICA + "' OR m.COD_MARC = '"+ConstantesINT.MARCA_TODAS+"')");
      query.append(" AND per.PERI_OID_PERI = perCorp.OID_PERI ");
      query.append(" AND perCorp.COD_PERI = '" + codPeriodo + "' ");
      query.append(" AND per.CANA_OID_CANA = c.OID_CANA  ");
      query.append(" AND c.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD + "' ");
      query.append(" AND per.PAIS_OID_PAIS = " + oidPais);
     
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          UtilidadesLog.error(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("resultado: " + rs);
      
      if(!rs.esVacio()){
          oid = Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_PERI")).toString());
      } else {
          UtilidadesLog.info("DAORecepcionarClasificacion.obtenerPeriodo(String codPeriodo, Long oidPais):Salida");
          return null;
      }
      
      UtilidadesLog.info("DAORecepcionarClasificacion.obtenerPeriodo(String codPeriodo, Long oidPais):Salida");
      return oid;
  }
  
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }
  
}