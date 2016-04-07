/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ccc.DTOBuscarRegistroVentas;
import es.indra.sicc.dtos.ccc.DTOFecha;
import es.indra.sicc.dtos.ccc.DTONumRegistros;

import es.indra.sicc.dtos.ccc.DTORegistroVentas;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.Vector;
import java.text.SimpleDateFormat;

public class DAORegistroVentas  {
	
	private String usuario;

	public DAORegistroVentas(String usuario) {
		this.usuario = usuario;
	}
	
//String usuario, Long oidPais, Date fechaEmisionDesde, Date fechaEmisionHasta, String codigoClienteDesde, String codigoClienteHasta, Long oidImpuestos),																
	public RecordSet  buscarRegistroVentas(DTOBuscarRegistroVentas dtoe, String usuario) throws MareException {
	    try{
	    UtilidadesLog.info("DAORegistroVentas.buscarRegistroVentas(DTOBuscarRegistroVentas dtoe, String usuario): Entrada");
	            Vector parametros = new Vector();
	            BelcorpService bs;
	            StringBuffer sql = new StringBuffer();
	                                                            
	    // vbongiov -- Cambio 20070451 --14/11/2008                             
	            if("S".equals(dtoe.getExportar())){ 
	    
	        sql.append(" SELECT r.FEC_EMIS, ");
	        sql.append(" c.COD_CLIE, f.DES_TIPO_DOCU, r.VAL_SERI_DOCU_LEGA," );
	        sql.append(" r.VAL_NUME_DOCU_LEGA, ");            
	        sql.append(" r.VAL_BASE_IMPO, r.VAL_DESC,");                       
	        sql.append(" r.VAL_BASE_IMPO_NETO, r.IMP_IMPU, r.IMP_TOTA,");                           
	        sql.append(" t.VAL_TASA_IMPU, r.IND_ESTA,");                      
	        sql.append(" r.VAL_INDI_RUV ");  
	    
	    } else  {
	    
	        sql.append(" SELECT "); //el OID a que campo so lo pongo 
	        sql.append(" r.OID_REGI OID, r.FEC_EMIS, ");//BELC300007721
	        sql.append(" c.COD_CLIE, f.OID_TIPO_DOCU, f.DES_TIPO_DOCU, r.VAL_SERI_DOCU_LEGA," );
	    sql.append(" r.VAL_NUME_DOCU_LEGA, ");
	        //modificado por incidencia 14536
	        //r.TAIM_OID_TASA_IMPU,");                  
	    /*    sql.append(" (SELECT v.VAL_I18N  FROM V_GEN_I18N_SICC v ");
	        sql.append(" WHERE v.VAL_OID = r.TAIM_OID_TASA_IMPU ");
	        sql.append(" AND v.IDIO_OID_IDIO = ? ");
	        parametros.add(dtoe.getOidIdioma());
	        sql.append(" AND v.ATTR_NUM_ATRI = 1 ");
	        sql.append(" AND v.ATTR_ENTI = 'PED_TASA_IMPUE') AS Tipo_Impuesto, ");*/
	        
	        sql.append(" r.VAL_BASE_IMPO, r.VAL_DESC,");                       
	        sql.append(" r.VAL_BASE_IMPO_NETO, r.IMP_IMPU, r.IMP_TOTA,");                           
	        sql.append(" t.VAL_TASA_IMPU, r.IND_ESTA,");                      
	        sql.append(" r.VAL_INDI_RUV ");  //Indicencia  7576 se quita el campo t.VAL_INDI_IMPU_DESC     
	        
	    }
	                                                              
	            sql.append(" FROM ");                                             
	                                                              
	            sql.append(" FAC_REGIS_UNICO_VENTA r,");                          
	            //sql.append(" FAC_DOCUM_CONTA_CABEC d,");    se elimina por incidencia 8829                      
	            sql.append(" PED_TASA_IMPUE t,");                                 
	            sql.append(" VCA_SEG_PAIS p,");                                   
	            sql.append(" MAE_CLIEN c, "); 
	    sql.append(" FAC_TIPO_DOCUM f,");
	    sql.append(" SEG_SUBAC ");
	            /*sql.append(" VCA_SEG_SUBAC u,");                                  
	            sql.append(" VCA_SEG_ACCES a,");                                  
	            sql.append(" VCA_SEG_CANAL l,");          se quitan por incidencia 8829                       
	            sql.append(" VCA_SEG_SOCIE s");   */                                
	                                                              
	            sql.append(" WHERE ");                                            
	                                                              
	            sql.append(" r.CLIE_OID_CLIE=c.OID_CLIE(+)");                        
	            //sql.append(" AND r.DCCA_OID_CABE=d.OID_CABE");   se elimina por incidencia 8829                 
	            //sql.append(" AND r.SOCI_OID_SOCI=s.OID_SOCI");   se elimina por incidencia 8829                  
	            sql.append(" AND r.TAIM_OID_TASA_IMPU=t.OID_TASA_IMPU");               
	            sql.append(" AND r.PAIS_OID_PAIS=p.OID_PAIS");    
	            //sql.append(" AND r.SBAC_OID_SBAC=u.OID_SBAC");  se elimina por incidencia 8829                 
	            //sql.append(" AND u.ACCE_OID_ACCE=a.OID_ACCE");  se elimina por incidencia 8829                   
	            //sql.append(" AND a.CANA_OID_CANA=l.OID_CANA");  se elimina por incidencia 8829                   
	                                                              
	            sql.append(" AND p.OID_PAIS = ?");
	            parametros.add(dtoe.getOidPais());
	            sql.append(" AND r.TIDO_OID_TIPO_DOCU = f.OID_TIPO_DOCU ");
	    if(dtoe.getOidTipoDocLegal() != null)
	    {
	    sql.append("AND f.OID_TIPO_DOCU = ? ");
	    parametros.add(dtoe.getOidTipoDocLegal());
	    }
	    sql.append(" AND r.SBAC_OID_SBAC= SEG_SUBAC.OID_SBAC(+) ");
	    if(dtoe.getOidSubacceso() != null)
	    {
	    sql.append(" AND SEG_SUBAC.OID_SBAC = ? ");
	    parametros.add(dtoe.getOidSubacceso());
	    }
	            sql.append(" AND p.COD_USUA = ? ");
	    
	            /*sql.append(" AND s.COD_USUA = ? ");                       
	            sql.append(" AND u.COD_USUA = ? ");     se eliminan por incidencia 8829                     
	            sql.append(" AND a.COD_USUA = ? ");                       
	            sql.append(" AND l.COD_USUA = ? "); */
	            parametros.add(this.usuario);//incidencai 7576
	            /*parametros.add(this.usuario);
	            parametros.add(this.usuario);
	            parametros.add(this.usuario);           se eliminan por incidencia 8829
	            parametros.add(this.usuario);*/ 
	    
	            //se podria hacer sin pasar a sqlDate
	            /*SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
	            FieldPosition pos=new FieldPosition(0);
	                    
	            if(dtoe.getFechaEmisionDesde()!=null){   
	                    

	                    java.sql.Date fechaDesde = new java.sql.Date(dtoe.getFechaEmisionDesde().getTime());
	                    StringBuffer fechaStringD=new StringBuffer();
	                    StringBuffer fecha=formato.format(fechaDesde, fechaStringD, pos);
	                                                                             
	                    sql.append(" AND r.FEC_EMIS >= ? "); 
	                    parametros.add(fechaStringD.toString());
	            }
	            if(dtoe.getFechaEmisionHasta()!=null){
	                    java.sql.Date fechaHasta = new java.sql.Date(dtoe.getFechaEmisionHasta().getTime());
	                    StringBuffer fechaStringH=new StringBuffer();
	                    StringBuffer fechaH=formato.format(fechaHasta, fechaStringH, pos);

	                    sql.append(" AND r.FEC_EMIS <= ? ");  
	                    parametros.add(fechaStringH.toString());
	            }
	            */

	            
	            // Modificado por incidencia:  9231
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    
	            if(dtoe.getFechaEmisionDesde()!=null){   
	                    java.sql.Date fechaDesde = new java.sql.Date(dtoe.getFechaEmisionDesde().getTime());
	                    String sFechaDesde = sdf.format(fechaDesde);                                               
	                    sql.append(" AND (r.FEC_EMIS >= TO_DATE( ? ,'YYYY-MM-DD') ) "); 
	                    parametros.add(sFechaDesde);
	            }
	            if(dtoe.getFechaEmisionHasta()!=null){
	                    java.sql.Date fechaHasta = new java.sql.Date(dtoe.getFechaEmisionHasta().getTime());
	                    String sFechaHasta =sdf.format(fechaHasta);
	                    sql.append(" AND (r.FEC_EMIS <=  TO_DATE( ? ,'YYYY-MM-DD')) ");  
	                    parametros.add(sFechaHasta);
	            }


	            
	            if(dtoe.getCodigoClienteDesde()!=null){
	                    sql.append(" AND c.COD_CLIE >=? "); 
	                    parametros.add(dtoe.getCodigoClienteDesde());
	            }
	            if(dtoe.getCodigoClienteHasta()!=null){
	                    sql.append(" AND c.COD_CLIE <= ? ");
	                    parametros.add(dtoe.getCodigoClienteHasta());
	            }
	    if(dtoe.getNumeroDocLegalDesde() != null)
	    {
	    sql.append(" AND r.VAL_NUME_DOCU_LEGA >= ? ");
	    parametros.add(dtoe.getNumeroDocLegalDesde());
	    }
	    if(dtoe.getNumeroDocLegalHasta() != null)
	    {
	    sql.append(" AND r.VAL_NUME_DOCU_LEGA <= ?");
	    parametros.add(dtoe.getNumeroDocLegalHasta());
	    }
	            if(dtoe.getOidImpuestos()!=null){
	                    sql.append(" AND r.TAIM_OID_TASA_IMPU = ? ");
	                    parametros.add(dtoe.getOidImpuestos());
	            }   
                    
            //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010                      
            if(dtoe.getOid()!=null){
                    sql.append(" AND r.OID_REGI = ? ");
                    parametros.add(dtoe.getOid());
            }   
                    
	    String sqlPaginacion = null;
	    
	    bs = UtilidadesEJB.getBelcorpService();
	    RecordSet rs = null;
	    String codigoError = null;
	    if(dtoe.getExportar() != null ){
	      if(dtoe.getExportar().equals("S")){ 
	        try {
	              rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
	        } catch (Exception e) {

	            e.printStackTrace(); 
	            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
	            UtilidadesLog.error("buscarRegistroVentas: Exception",e);
	            this.logSql("buscarRegistroVentas. SQL: ",sql.toString(), parametros);
	            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
	        }
	      }
	      
	    
	    }else
	    {
	    sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dtoe);
	    
	    try {
	    rs = bs.dbService.executePreparedQuery(sqlPaginacion,parametros);
	    } catch (Exception e) {
	          e.printStackTrace();
	          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
	    UtilidadesLog.error("buscarRegistroVentas: Exception",e);
	    this.logSql("buscarRegistroVentas. SQL: ",sqlPaginacion, parametros);
	          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
	         
	    }
	    }
	    
	    
	    UtilidadesLog.info("DAORegistroVentas.buscarRegistroVentas(DTOBuscarRegistroVentas dtoe, String usuario): Salida");             
	            return rs;
	    
	    } catch (Exception e) {

	          e.printStackTrace(); 
	          UtilidadesLog.error("buscarRegistroVentas: Exception",e);
	          throw new MareException(e);
	      }		
       
	}
    
    
    //METODO buscarRegistroVentas
    //dtoSalida.setResultado(daoRegistroVentas.buscarRegistroVentas(usuario,dto.getOidPais(),dto.getOid())); 
	//String usuario, Long oidPais, Long oidReg
	public RecordSet buscarRegistroVentas(String usuario, Long oidPais, Long oidReg) throws MareException{ 	
	    UtilidadesLog.info("DAORegistroVentas.buscarRegistroVentas(String usuario, Long oidPais, Long oidReg): Entrada");
	           Vector parametros = new Vector();
	           StringBuffer sql=new StringBuffer();

	           sql.append("  SELECT ");                                    
	           sql.append("    r.SOCI_OID_SOCI,");  
	       //modificado por incidencia 14536
	           sql.append("    r.TAIM_OID_TASA_IMPU, ");
	       /*sql.append(" SELECT I.VAL_I18N  FROM V_GEN_I18N_SICC I  WHERE I.ATTR_ENTI = 'PED_TASA_IMPUE' "); 
	       sql.append(" AND I.ATTR_NUM_ATRI = 1  AND I.IDIO_OID_IDIO = ? ");
	       sql.append(" r.TAIM_OID_TASA_IMPU=t.OID_TASA_IMPU AS TipoImpuesto, ");*/
	       
	       sql.append(" t.VAL_INDI_IMPU ,");
	           sql.append("    r.FEC_EMIS,");                                    
	           sql.append("    r.CLIE_OID_CLIE, c.COD_CLIE, r.VAL_NOM1,");
	           sql.append("    r.VAL_NOM2, r.VAL_APE1, r.VAL_APE2,");
	           sql.append("    r.VAL_BASE_IMPO, r.IMP_IMPU, r.IMP_TOTA,");
	           sql.append("    t.VAL_TASA_IMPU,");
	           sql.append("    l.OID_CANA,a.OID_ACCE,r.SBAC_OID_SBAC,");                                    
	           sql.append("    r.VAL_PUNT_EMIS,");                                    
	           sql.append("    r.TIDO_OID_TIPO_DOCU,");                                    
	           sql.append("    r.VAL_SERI_DOCU_LEGA,");                                    
	           sql.append("    r.VAL_NUME_DOCU_LEGA,");                                    
	           sql.append("    r.VAL_NUME_IDEN_FISC,");                                    
	           sql.append("    r.VAL_NUME_IDEN_NNAL,");                                    
	           sql.append("    r.PAIS_OID_PAIS,");                                    
	           sql.append("    r.TIDO_TIPO_DOCU_REFE,");                                    
	           sql.append("    r.VAL_SERI_DOCU_REFE,");                                    
	           sql.append("    r.VAL_NUME_DOCU_REFE,");                                    
	           sql.append("    r.IND_ESTA,");                                    
	           sql.append("    r.IND_TRAN_GRAT,");                                    
	           sql.append("    r.VAL_INDI_RUV,");
                   sql.append("    r.VAL_DESC, ");
	           sql.append("    r.VAL_BASE_IMPO_NETO");
	                            
	           //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010                                            
                   sql.append("    ,r.TDOC_OID_TIPO_DOCU ");
                   sql.append("    ,r.FEC_EMIS_REFE");
	                                
	                                
	           sql.append("  FROM");                                    
	           sql.append("    FAC_REGIS_UNICO_VENTA r,");                                    
	           sql.append("    MAE_CLIEN c,");                                    
	           //sql.append("    FAC_DOCUM_CONTA_CABEC d,");   eliminado por la incidencia 11525                                  
	           sql.append("    VCA_SEG_SOCIE s,");                                    
	           sql.append("    PED_TASA_IMPUE t,");                                    
	           sql.append("    VCA_SEG_PAIS p,");                                    
	           sql.append("    VCA_SEG_SUBAC u,");                                    
	           //sql.append("    FAC_TIPO_DOCUM m,");      eliminado por la incidencia 11525                              
	           sql.append("    VCA_SEG_ACCES a  ,");                                    
	           sql.append("    VCA_SEG_CANAL l");                                    

	           sql.append("  WHERE ");                                    
	                                                        
	           sql.append("   r.CLIE_OID_CLIE=c.OID_CLIE(+) ");                                    
	           //sql.append("  AND r.DCCA_OID_CABE=d.OID_CABE ");  se eliminan por la incidencia 8829                                  
	           sql.append("  AND r.SOCI_OID_SOCI=s.OID_SOCI ");                                    
	           sql.append("  AND r.TAIM_OID_TASA_IMPU=t.OID_TASA_IMPU  "); //a falta de incidencia BELC300007644                                       
	           sql.append("  AND r.PAIS_OID_PAIS=p.OID_PAIS ");                                    
	           sql.append("  AND r.SBAC_OID_SBAC=u.OID_SBAC(+) ");  //Modificado por incidencia 11525                              
	           sql.append("  AND u.ACCE_OID_ACCE=a.OID_ACCE(+) ");  //Modificado por incidencia 11525                                  
	           sql.append("  AND a.CANA_OID_CANA=l.OID_CANA(+) ");  //Modificado por incidencia 11525                                                                  
	                                                                                     
	                                                                                     
	           sql.append(" AND p.OID_PAIS = ? ");
	           parametros.add(oidPais);
	           sql.append(" AND p.COD_USUA = ? "); 
	           parametros.add(this.usuario);
	           sql.append(" AND s.COD_USUA = ? "); 
	           parametros.add(this.usuario);                                        
	           sql.append(" AND u.COD_USUA (+)= ? "); //Modificado por incidencia 11525
	           parametros.add(this.usuario);                                        
	           sql.append(" AND a.COD_USUA (+)= ? "); //Modificado por incidencia 11525
	           parametros.add(this.usuario);                                        
	           sql.append(" AND l.COD_USUA (+)= ? "); //Modificado por incidencia 11525 
	           parametros.add(this.usuario);                                       
	                                                                   
	           sql.append(" AND r.OID_REGI = ? "); 
	           parametros.add(oidReg);
	           
	                                                                                     
	           BelcorpService bs = UtilidadesEJB.getBelcorpService();
	           RecordSet rs = null;
	           String codigoError = null;
	           try {
	                   rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
	           } catch (Exception e) {
	                   codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
	                   UtilidadesLog.error("buscarRegistroVentas(DTOOID): Exception",e);
	                   this.logSql("buscarRegistroVentasDTOOID. SQL: ",sql.toString(), parametros);
	                   throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
	           }
	           UtilidadesLog.info("DAORegistroVentas.buscarRegistroVentas(String usuario, Long oidPais, Long oidReg): Salida");
	           return rs;  
                
	
	}//metodo buscarRegistroVentas

	public DTONumRegistros reabrirRegistrosVentas(DTOFecha dtoe) throws MareException {
		/*El sistema actualiza la entidad "Registro único de ventas" (FAC)
		 * actualizando el atributo Estado RUV a '(A)ctivo' e inicializando
		 * a nulos la Fecha de Cierre.para todos los registros que tengan
		 * la fecha de cierre introducida por el usuario y Estado de RUV=(C)errado. 
		 */

		UtilidadesLog.info("DAORegistroVentas.reabrirRegistrosVentas(DTOFecha dtoe): Entrada");
		
		DTONumRegistros dtoNumReg = new DTONumRegistros();
		Vector parametros = new Vector();
		//si la fecha esta a null esto dara una nullpointerexception
		// Se crea el update SQL   
			java.sql.Date fechaSql = new java.sql.Date(dtoe.getFechaCierre().getTime());

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					
			StringBuffer update = new StringBuffer();

			update.append("	UPDATE FAC_REGIS_UNICO_VENTA SET ");
			update.append(" VAL_INDI_RUV = ?, FEC_CIER = NULL ");
            update.append(" WHERE FEC_CIER = TO_DATE( ? ,'YYYY-MM-DD') AND ");
			update.append(" VAL_INDI_RUV = ? ");

	
			parametros.add("A");
		//parametros.add(nul);
            String sFechaCierre = sdf.format(fechaSql);                                               
            parametros.add(sFechaCierre);
			parametros.add("C");

			BelcorpService bs = UtilidadesEJB.getBelcorpService();                 
			int modificados = 0;   // numero de registros modificados por el update                                               
			String codigoError = null;                         

		try{                                                              
			modificados = bs.dbService.executePreparedUpdate(update.toString(),parametros);        
		} catch (Exception e) {                                                
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("reabrirRegistrosVentas: Exception",e);           
			this.logSql("reabrirRegistrosVentas. SQL: ",update.toString(), parametros);   
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}                                                                       
		//Devolvemos el número de registros que se han "Reabierto". 
		Integer registros = new Integer(modificados);
		dtoNumReg.setNumeroRegistros(new Long(registros.longValue()));
		UtilidadesLog.info("DAORegistroVentas.reabrirRegistrosVentas(DTOFecha dtoe): Salida");
		return dtoNumReg;
	} // metodo reabrirRegistrosVentas


	public DTONumRegistros cerrarRegistrosVentas(DTOBuscarRegistroVentas dtoe) throws MareException {
		/*El sistema actualiza la entidad "Registro único de ventas" (FAC) 
		 * actualizando el atributo Estado RUV a '(C)errado' para todos los
		 * registros que cumplan los criterios introducidos y estuvieran en
		 * estado "Activo". Como fecha de cierre se introduce la proporcionada
		 * por el usuario. 
		 * Los criterios que vengan a "null" no se utilizarán para filtrar. 
		 */
		UtilidadesLog.info("DAORegistroVentas.cerrarRegistrosVentas(DTOBuscarRegistroVentas dtoe): Entrada");

		DTONumRegistros dtoNumReg = new DTONumRegistros();

		Vector parametros = new Vector();
		StringBuffer update = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		update.append("	UPDATE FAC_REGIS_UNICO_VENTA ");
		update.append(" SET VAL_INDI_RUV = ? , FEC_CIER = TO_DATE( ? ,'YYYY-MM-DD') ");
		parametros.add("C");

		java.sql.Date fechaCierre = new java.sql.Date(dtoe.getFechaCierre().getTime());
		String sFechaCierre = sdf.format(fechaCierre);                                               
		parametros.add(sFechaCierre);

		update.append(" WHERE VAL_INDI_RUV LIKE ? ");
		parametros.add("A");
		if (dtoe.getCodigoClienteDesde()!=null){
			update.append(" AND CLIE_OID_CLIE >= ? ");	
			parametros.add(dtoe.getCodigoClienteDesde());
		}
		if (dtoe.getCodigoClienteHasta()!=null){
			update.append(" AND CLIE_OID_CLIE <= ? ");
			parametros.add(dtoe.getCodigoClienteHasta());
		}
		
		// Cambiados los formatos de fecha por incidencia 11529
		if(dtoe.getFechaEmisionDesde()!=null){   
			java.sql.Date fechaDesde = new java.sql.Date(dtoe.getFechaEmisionDesde().getTime());
			String sFechaDesde = sdf.format(fechaDesde);                                               
			update.append(" AND (FEC_EMIS >= TO_DATE( ? ,'YYYY-MM-DD') ) "); 
			parametros.add(sFechaDesde);
		}
		if(dtoe.getFechaEmisionHasta()!=null){
			java.sql.Date fechaHasta = new java.sql.Date(dtoe.getFechaEmisionHasta().getTime());
			String sFechaHasta =sdf.format(fechaHasta);
			update.append(" AND (FEC_EMIS <=  TO_DATE( ? ,'YYYY-MM-DD')) ");  
			parametros.add(sFechaHasta);
		}

		if (dtoe.getOidImpuestos()!=null){
			update.append(" AND  TAIM_OID_TASA_IMPU = ? ");
			parametros.add(dtoe.getOidImpuestos());
		}

		BelcorpService bs = UtilidadesEJB.getBelcorpService();                 
		int modificados = 0;   // numero de registros modificados por el update                                               
		String codigoError = null;                         

		try {                                                                  
			modificados = bs.dbService.executePreparedUpdate(update.toString(),parametros);        
		} catch (Exception e) {                                                
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("cerrarRegistrosVentas: Exception",e);           
			this.logSql("cerrarRegistrosVentas. SQL: ",update.toString(), parametros);   
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}                                                                         
		//Devolvemos el número de registros que se han "cerrado". 
		Long registros = new Long(modificados);
		dtoNumReg.setNumeroRegistros(registros);
		UtilidadesLog.info("DAORegistroVentas.cerrarRegistrosVentas(DTOBuscarRegistroVentas dtoe): Salida");
		return dtoNumReg;
	} // metodo reabrirRegistrosVentas

    private void logSql(String metodo, String sql, Vector params) {
    
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}
   public void guardar(DTORegistroVentas dto, Long oidCliente)throws MareException
     {
          UtilidadesLog.info("DAORegistroVentas.gardar(DTORegistroVentas dto): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();     
          StringBuffer update = new StringBuffer();
          RecordSet rsPK = null;
          StringBuffer query = new StringBuffer();      
          Long id = null;
        
           query.append(" SELECT FAC_RUVE_SEQ.NEXTVAL FROM DUAL ");
          try {
               rsPK = bs.dbService.executeStaticQuery(query.toString());
                    
           } catch (Exception ex) {
                ex.printStackTrace();
           throw new MareException(ex, UtilidadesError.armarCodigoError(
                                     CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
          if(rsPK != null && !rsPK.esVacio()) {
                id = Long.valueOf(((BigDecimal)rsPK.getValueAt(0,0)).toString());
          }
          UtilidadesLog.debug("** oid_cliente: " + oidCliente);
          UtilidadesLog.debug("**subAcceso: " + dto.getOidSubAcceso());
          UtilidadesLog.debug("** pais: " + dto.getOidPais());
          UtilidadesLog.debug("** fechaEmision: " + dto.getFechaEmision());
          UtilidadesLog.debug("** ImporteImpuesto: " + dto.getImporteImpuesto());
          UtilidadesLog.debug("** ImporteTotal: " + dto.getImporteTotal());
          UtilidadesLog.debug("** EstadoAnulado: " + dto.getEstadoAnulado());
          UtilidadesLog.debug("** IdiTransGratuita: " + dto.getIndTransfGratuita());
          UtilidadesLog.debug("** oidEmpresa: " + dto.getOidEmpresa());
          UtilidadesLog.debug("** oidIdiImpuesto: " + dto.getOidIndImpuestos());
          UtilidadesLog.debug("** oidTipoDecuLegal: " + dto.getOidTipoDocumentoLegal());
          UtilidadesLog.debug("** oidTipoDecuRefe: " + dto.getOidTipoDocumentoRef() );
          UtilidadesLog.debug("** apellido1: " + dto.getApellido1() );
          UtilidadesLog.debug("** apellido2: " + dto.getApellido2());
          UtilidadesLog.debug("** BaseImponible: " + dto.getBaseImponible());
          UtilidadesLog.debug("** BaseImponibleNeto: " + dto.getBaseImponibleNeto());
          UtilidadesLog.debug("** Descuento: " + dto.getDescuento() );
          UtilidadesLog.debug("** EstadoRUV: " +  dto.getEstadoRUV());
          UtilidadesLog.debug("** Nombre1: " + dto.getNombre1());
          UtilidadesLog.debug("** Nombre2: " + dto.getNombre2());
          UtilidadesLog.debug("** NumeroDocLegal: " + dto.getNumeroDocumentoLegal());
          UtilidadesLog.debug("** NumDocuRefe: " + dto.getNumeroDocumentoRef());
          UtilidadesLog.debug("** NumIndFiscal: " + dto.getNumeroIdentificacionFiscal());
          UtilidadesLog.debug("** NumIndNacional: "  + dto.getNumeroIdentificacionNacional());
          UtilidadesLog.debug("** PuntoEmision: " + dto.getPuntoEmision());
          UtilidadesLog.debug("** SerieDocuLegal: " + dto.getSerieDocumentoLegal());
          UtilidadesLog.debug("** SerieDocuRefe: "+ dto.getSerieDocumentoRef());
          //sb
         UtilidadesLog.debug("** Numero control: "+ dto.getNumDocControlLegal());
         //UtilidadesLog.debug("** Numero control final legal: "+ dto.getNumDocControlFinalLegal());
          
          update.append("INSERT INTO  FAC_REGIS_UNICO_VENTA ( ");
          update.append("             OID_REGI ");
          update.append("             , CLIE_OID_CLIE ");
          update.append("             , DCCA_OID_CABE ");
          update.append("             , FEC_CIER ");
          update.append("             , FEC_EMIS ");
          update.append("             , IMP_IMPU ");
          update.append("             , IMP_TOTA ");
          update.append("             , IND_ESTA ");
          update.append("             , IND_FACT_GRAT ");
          update.append("             , IND_TRAN_GRAT ");
          update.append("             , NUM_DOCU_CONT_INTE ");
          update.append("             , PAIS_OID_PAIS ");
          update.append("             , SBAC_OID_SBAC ");
          update.append("             , SOCI_OID_SOCI ");
          update.append("             , TAIM_OID_TASA_IMPU ");
          update.append("             , TIDO_OID_TIPO_DOCU ");
          update.append("             , TIDO_TIPO_DOCU_REFE ");
          update.append("             , VAL_APE1 ");
          update.append("             , VAL_APE2 ");
          update.append("             , VAL_BASE_IMPO ");
          update.append("             , VAL_BASE_IMPO_NETO  ");
          update.append("             , VAL_COMI ");
          update.append("             , VAL_DESC ");
          update.append("             , VAL_DOCU_INTE ");
          update.append("             , VAL_EJER_DOCU_INTE ");
          update.append("             , VAL_FLET ");
          update.append("             , VAL_INDI_RUV ");
          update.append("             , VAL_INTE_MORA ");
          update.append("             , VAL_NOM1 ");
          update.append("             , VAL_NOM2 ");
          update.append("             , VAL_NUME_DOCU_LEGA ");
          update.append("             , VAL_NUME_DOCU_REFE ");
          update.append("             , VAL_NUME_IDEN_FISC ");
          update.append("             , VAL_NUME_IDEN_NNAL ");
          update.append("             , VAL_PUNT_EMIS ");
          update.append("             , VAL_SERI_DOCU_LEGA ");
          update.append("             , VAL_SERI_DOCU_REFE ");
          
          //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
          update.append("             , TDOC_OID_TIPO_DOCU ");
          update.append("             , FEC_EMIS_REFE ");
          //sbuchelli
          update.append("             , NUM_CONT_DOCU_LEGA ");
         //update.append("             , FEC_EMIS_REFE ");
         
          update.append(" ) VALUES ( ");
          update.append(id);
          if(oidCliente != null ){
              update.append(" , " + oidCliente); 
          }else
          {
              update.append(" , NULL");
          }
          update.append(" , NULL ");
          update.append(" , NULL ");
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");      
          update.append(" , TO_DATE('").append(sdf.format(dto.getFechaEmision())).append("','DD/MM/YYYY') ");//obligatorio
          update.append(" , " + dto.getImporteImpuesto()); //obligatorio
          update.append(" , " + dto.getImporteTotal() );// obligatrio
          if(dto.getEstadoAnulado().booleanValue()){
              update.append(" ,  1");
          }else
          {
             update.append(" , 0 ");
          }
          update.append(" , NULL ");
          if(dto.getIndTransfGratuita().booleanValue())
          {
              update.append(" , 1 ");  
          }else
          {
              update.append(" , 0 ");
          }
           
          update.append(" , NULL ");
          update.append(" , " + dto.getOidPais()); // obligatorio
          if(dto.getOidSubAcceso() != null){
              update.append(" , " + dto.getOidSubAcceso());
          }else
          {
              update.append(" , NULL");
          }
          update.append(" , " + dto.getOidEmpresa()); // obligatorio
          update.append(" , " + dto.getOidIndImpuestos());// obligatorio
          update.append(" , " + dto.getOidTipoDocumentoLegal());// obligatorio
          if(dto.getOidTipoDocumentoRef() != null ){
              update.append(" , " + dto.getOidTipoDocumentoRef());
          }else
          {
              update.append(" , NULL");
          }
          if(dto.getApellido1() != null || dto.getApellido1() != "''"){
              update.append(" , '" + dto.getApellido1()+"' ");
          }else
          {
              update.append(" , NULL");
          }
          if(dto.getApellido2() != null || !dto.getApellido2().equals("")){
              update.append(" , '" + dto.getApellido2()+"'");
          }else
          {
              update.append(" , NULL");
          }
          update.append(" , " + dto.getBaseImponible());//obligatorio
          update.append(" , " + dto.getBaseImponibleNeto());//obligatorio
          update.append(" ,  NULL");
          update.append(" , " + dto.getDescuento());//obligatorio
          update.append(" ,  NULL ");
          update.append(" ,  NULL ");
          update.append(" , NULL");
          if(dto.getEstadoRUV() != null || dto.getEstadoRUV() != ""){
              update.append(" , '" + dto.getEstadoRUV() + "'");
          }else     
          {
              update.append(" , NULL");
          }
           update.append(" , NULL");
          if(dto.getNombre1() != null || dto.getNombre1() != "''"){
             update.append(" , '" + dto.getNombre1() + "' ");
          }else
          {
             update.append(" , NULL ");
          }
          if(dto.getNombre2() != null || dto.getNombre2() != "''"){
             update.append(" , '" + dto.getNombre2() + "' ");
          }else
          {
             update.append(" , NULL");
          }
          update.append(" , " + dto.getNumeroDocumentoLegal() );// obligatorio
          if(dto.getNumeroDocumentoRef() != null || dto.getNumeroDocumentoRef() != "" ){
          update.append(" , " + dto.getNumeroDocumentoRef() );
          }else
          {
              update.append(" , NULL ");
          }
          if(dto.getNumeroIdentificacionFiscal() != null && dto.getNumeroIdentificacionFiscal() != ""){
              update.append(" , '" + dto.getNumeroIdentificacionFiscal() + "'");
              UtilidadesLog.debug(" NumeroIdentificacionFiscal(): " + dto.getNumeroIdentificacionFiscal() );
          }else
          {
              update.append(" , NULL");
          }
          if(dto.getNumeroIdentificacionNacional() != null && dto.getNumeroIdentificacionNacional() != ""){
              update.append(" , '" + dto.getNumeroIdentificacionNacional() + "' ");
              UtilidadesLog.debug("NumeroIdentificacionNacional(): " + dto.getNumeroIdentificacionNacional());
          }else
          {
              update.append(" , NULL");
          }
          if(dto.getPuntoEmision() != null && dto.getPuntoEmision() != ""){
              update.append(" , '" + dto.getPuntoEmision() + "'");
              UtilidadesLog.debug("PuntoEmision(): " + dto.getPuntoEmision());
          }else
          {
             update.append(" , NULL");
          }
          update.append(" , '" + dto.getSerieDocumentoLegal() + "'"); // obligatorio
          if(dto.getSerieDocumentoRef() != null && dto.getSerieDocumentoRef() != "''"){
             update.append(" , '" + dto.getSerieDocumentoRef() + "' ");
          }else
          {
            update.append(" , NULL");
          }
          
         //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010 
         if(dto.getOidTipoDocumento() != null ){
             update.append(" , " + dto.getOidTipoDocumento());
         }else
         {
             update.append(" , NULL");
         }
         if(dto.getFechaEmisionReferencia() != null ){
             update.append(" , TO_DATE('").append(sdf.format(dto.getFechaEmisionReferencia())).append("','DD/MM/YYYY') ");
         }else
         {
             update.append(" , NULL");
         }
          
          //numero control legal
           if(dto.getNumDocControlLegal() != null ){
               update.append(" , "+dto.getNumDocControlLegal());
           }else{
               update.append(" , NULL");
           }
          
          update.append("  ) ");
          try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
          } catch (Exception ex) {
               ex.printStackTrace();
              if(ex.toString().indexOf("ORA-00001")!= -1) {
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
              } else {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
           
          }
          UtilidadesLog.info("DAORegistroVentas.gardar(DTORegistroVentas dto): Entrada");
          
     }
    public int validarDocLegal(DTORegistroVentas dto)throws MareException
     {
         UtilidadesLog.info("DAORegistroVentas.ValidarDocLegal(DTORegistroVentas dto): Entrada");
         RecordSet rs = new RecordSet();
         int count = 0;
         StringBuffer query = new StringBuffer();
         Vector parametros = new Vector();
         BelcorpService bs;
         //Boolean rta= null;
         //rta = Boolean.FALSE;
         try{
                  bs = BelcorpService.getInstance();
            
         } catch(MareMiiServiceNotFoundException ex){
                    
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
         
         query.append(" SELECT  COUNT(*) ");
         query.append(" FROM FAC_REGIS_UNICO_VENTA ");
         // vbongiov -- RI 20070451 -- 18/12/2008
         query.append(" WHERE PAIS_OID_PAIS = " + dto.getOidPais());
          
         if(dto.getOidSubAcceso()!= null) {
             query.append(" AND SBAC_OID_SBAC = " + dto.getOidSubAcceso());
         } else {
             query.append(" AND SBAC_OID_SBAC IS NULL ");
         }
          
         query.append(" AND TIDO_OID_TIPO_DOCU = " + dto.getOidTipoDocumentoLegal());
         query.append(" AND VAL_SERI_DOCU_LEGA = '" + dto.getSerieDocumentoLegal() + "' ");
          
         query.append("  AND FAC_REGIS_UNICO_VENTA.VAL_NUME_DOCU_LEGA BETWEEN " + dto.getNumeroDocumentoLegal() + " AND " + dto.getNumeroDocumentoLegalFinal());
         
         try{
              
               rs = bs.dbService.executeStaticQuery(query.toString());
               UtilidadesLog.debug("Cantidad rs: " + rs);
               
         } catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         if(!rs.esVacio())
         {
            count = Integer.valueOf(((BigDecimal)rs.getValueAt(0,"COUNT(*)")).toString()).intValue();
         }
        return  count; 
             
     }
     
    public int validarRegistro(DTORegistroVentas dto)throws MareException
    {
          UtilidadesLog.info("DAORegistroVentas.ValidarRegistro(DTORegistroVentas dto): Entrada");
          RecordSet rs = new RecordSet();
          int count = 0;
          StringBuffer query = new StringBuffer();
          Vector parametros = new Vector();
          BelcorpService bs;
          Boolean rta = null;
          rta = Boolean.FALSE;
          try{
                   bs = BelcorpService.getInstance();
             
          } catch(MareMiiServiceNotFoundException ex){
                     
                   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
          }
          
          // vbongiov -- RI 20070451 -- 18/12/2008
          query.append(" SELECT COUNT(*) ");
          query.append("        FROM FAC_REGIS_UNICO_VENTA ");
          query.append("        WHERE FAC_REGIS_UNICO_VENTA.PAIS_OID_PAIS = " + dto.getOidPais());
          if(dto.getOidSubAcceso() != null){
          
               query.append("               AND FAC_REGIS_UNICO_VENTA.SBAC_OID_SBAC =  " + dto.getOidSubAcceso());
          }else
          {
               query.append("               AND FAC_REGIS_UNICO_VENTA.SBAC_OID_SBAC IS  NULL ");
          }
          if(dto.getOidTipoDocumentoLegal() != null)
          {
            query.append(" AND FAC_REGIS_UNICO_VENTA.TIDO_OID_TIPO_DOCU = " + dto.getOidTipoDocumentoLegal());
          }else
          {
            query.append(" AND FAC_REGIS_UNICO_VENTA.TIDO_OID_TIPO_DOCU IS NULL");
          }
          if(dto.getSerieDocumentoLegal() != null){
             query.append(" AND FAC_REGIS_UNICO_VENTA.VAL_SERI_DOCU_LEGA = '" + dto.getSerieDocumentoLegal() + "' ");
          }else
          {
              query.append(" AND FAC_REGIS_UNICO_VENTA.VAL_SERI_DOCU_LEGA IS NULL");
          }
          if(dto.getNumeroDocumentoLegal() != null){
             query.append(" AND FAC_REGIS_UNICO_VENTA.VAL_NUME_DOCU_LEGA = " + dto.getNumeroDocumentoLegal());
          }else
          {
            query.append(" AND FAC_REGIS_UNICO_VENTA.VAL_NUME_DOCU_LEGA IS NULL");
          }
          try{
                   
                  rs = bs.dbService.executeStaticQuery(query.toString());
                   UtilidadesLog.debug("Cantidad de registros: " + rs);
          } catch (Exception ex) {
                
                   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          if(!rs.esVacio())
          {
             count = Integer.valueOf(((BigDecimal)rs.getValueAt(0,"COUNT(*)")).toString()).intValue();
          }
          return count; 
            
     }
    public void update(DTORegistroVentas dto, Long oidCliente)throws MareException
     {
         UtilidadesLog.info("DAORegistroVentas.update(DTORegistroVentas dto, Long oidCliente): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
              
         StringBuffer update = new StringBuffer();
         update.append("UPDATE FAC_REGIS_UNICO_VENTA SET ");
         if(oidCliente != null)
         {
              update.append("  CLIE_OID_CLIE = " + oidCliente);
         }else
         {
           update.append("    CLIE_OID_CLIE = NULL");
         }
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");      
         update.append(" , FEC_EMIS = TO_DATE('").append(sdf.format(dto.getFechaEmision())).append("','DD/MM/YYYY') ");
         update.append(" , IMP_IMPU = " + dto.getImporteImpuesto());
         update.append(" , IMP_TOTA = " + dto.getImporteTotal());
         if(dto.getEstadoAnulado().booleanValue())
         {
            update.append(" , IND_ESTA = 1");
         }else
         {
           update.append(" , IND_ESTA = 0 ");
         }
         if(dto.getIndTransfGratuita().booleanValue())
         {
           update.append(" , IND_TRAN_GRAT = 1");
         }else
         {
           update.append(" , IND_TRAN_GRAT = 0");
         }
         update.append(" , PAIS_OID_PAIS = " + dto.getOidPais());
         update.append(" , SBAC_OID_SBAC = " + dto.getOidSubAcceso());
         update.append(" , SOCI_OID_SOCI = " + dto.getOidEmpresa());
         update.append(" , TAIM_OID_TASA_IMPU = " + dto.getOidIndImpuestos());
         update.append(" , TIDO_OID_TIPO_DOCU = " + dto.getOidTipoDocumentoLegal());
         if(dto.getOidTipoDocumentoRef() != null)
         {
           update.append(" ,TIDO_TIPO_DOCU_REFE = " + dto.getOidTipoDocumentoRef());
         }else
         {
           update.append("  , TIDO_TIPO_DOCU_REFE = NULL");
         }
         if(dto.getApellido1() != null)
         {
           update.append(" , VAL_APE1 = '" + dto.getApellido1() + "'");
         }else
         {
           update.append(" , VAL_APE1 = NULL");
         }
         if(dto.getApellido2() != null)
         {
           update.append(" , VAL_APE2 = '" + dto.getApellido2() + "'");
         }
         update.append(" , VAL_BASE_IMPO = " + dto.getBaseImponible());
         update.append(" , VAL_BASE_IMPO_NETO = " + dto.getBaseImponibleNeto());
         update.append(" , VAL_DESC = " + dto.getDescuento());
         if(dto.getEstadoRUV() != null)
         {
           update.append(" , VAL_INDI_RUV = '" + dto.getEstadoRUV()+"'");
         }else
         {
           update.append(" , VAL_INDI_RUV = NULL");
         }
         if(dto.getNombre1() != null)
         {
           update.append(" , VAL_NOM1 = '" + dto.getNombre1() + "'");
         }else
         {
           update.append(" , VAL_NOM1 = NULL");
         }
         if(dto.getNombre2() != null)
         {
           update.append(" , VAL_NOM2 = '" + dto.getNombre2() + "'");
         }else
         {
           update.append(" , VAL_NOM2 = NULL ");
         }
         update.append(" , VAL_NUME_DOCU_LEGA = " + dto.getNumeroDocumentoLegal() );
         if(dto.getNumeroDocumentoRef() != null )
         {
           update.append(" , VAL_NUME_DOCU_REFE = " + dto.getNumeroDocumentoRef() );
         }else
         {
           update.append(" , VAL_NUME_DOCU_REFE = NULL");
         }
         if(dto.getNumeroIdentificacionFiscal() != null)
         {
           update.append(" , VAL_NUME_IDEN_FISC = '" + dto.getNumeroIdentificacionFiscal() + "'");
         }
         else
         {
           update.append(" , VAL_NUME_IDEN_FISC = NULL");
         }
         if(dto.getNumeroIdentificacionNacional() != null)
         {
           update.append(" , VAL_NUME_IDEN_NNAL = '" + dto.getNumeroIdentificacionNacional() +"'");
         }else
         {
           update.append(" , VAL_NUME_IDEN_NNAL = NULL");
         }
         if(dto.getPuntoEmision() != null)
         {
           update.append(" , VAL_PUNT_EMIS = '" + dto.getPuntoEmision() +"'");
         }else
         {
           update.append(" , VAL_PUNT_EMIS = NULL ");
         }
         update.append(" , VAL_SERI_DOCU_LEGA = '" + dto.getSerieDocumentoLegal() + "'");
         if(dto.getSerieDocumentoRef() != null)
         {
           update.append(" , VAL_SERI_DOCU_REFE = '" + dto.getSerieDocumentoRef() +"'");
         }else
         {
           update.append(" , VAL_SERI_DOCU_REFE = NULL ");
         }
         
         //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
         if(dto.getOidTipoDocumento() != null)
         {
           update.append(" ,TDOC_OID_TIPO_DOCU = " + dto.getOidTipoDocumento());
         }else
         {
           update.append(" ,TDOC_OID_TIPO_DOCU = NULL");
         }
         if(dto.getFechaEmisionReferencia() != null)
         {
             update.append(" ,FEC_EMIS_REFE = TO_DATE('").append(sdf.format(dto.getFechaEmisionReferencia())).append("','DD/MM/YYYY') ");
         }else
         {
           update.append(" ,FEC_EMIS_REFE = NULL");
         }
                        
         update.append(" where OID_REGI = " + dto.getOidReg());
          try {
                 int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                   
            } catch (Exception ex) {
                 ex.printStackTrace();
                 if(ex.toString().indexOf("ORA-00001")!= -1) {
                      throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                 } else {
                       throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
         }
        UtilidadesLog.info("DAORegistroVentas.update(DTORegistroVentas dto, Long oidCliente): Salida ");  
     }
     
    public void remove(DTOOIDs dto)throws MareException
     {
        UtilidadesLog.info("DAORegistroVentas.remove(DTORegistroVentas dto): Entrada ");
        
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        String oidRegistro = "";
        DTORegistroVentas dtoe = null;
        for(int i=0; i<dto.getOids().length; i++){   
           oidRegistro = oidRegistro + "," + dto.getOids()[i]; 
        }
         update.append(" delete FAC_REGIS_UNICO_VENTA  ");
         update.append(" where OID_REGI in ( " + oidRegistro.substring(1) + ") ");
         try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
           } catch (Exception ex) {
               ex.printStackTrace();          
               if(ex.toString().indexOf("ORA-02292")!= -1) {
                     throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_BORRADO_DE_DATOS));
               } else {
                     throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }                   
           }
       UtilidadesLog.info("DAORegistroVentas.remove(DTORegistroVentas dto): Salida ");
     }
        

}//clase