package es.indra.sicc.rep.logicanegocio;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.rep.dtos.DTOBusquedaRapidaProductos;
import es.indra.sicc.rep.dtos.DTOCriteriosReportes;
import es.indra.sicc.rep.dtos.DTOEstructuraFacturacion;
import es.indra.sicc.rep.dtos.DTOPeriodoCorporativos;
import es.indra.sicc.rep.dtos.DTORecargaComisiones;
import es.indra.sicc.rep.dtos.DTOValidaCodigoVenta;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import java.util.StringTokenizer;

public class DAOFrontReport {

  public Long oid;
  
  public DAOFrontReport(){
  }
  
  /**
   * mdolce - 28/01/2005
   *
   * Metodo para buscar los reportes segun criterios 
   *
   * @param DTOCriteriosReportes
   *
   * @return RecordSet
   *
   * @throws MareException
  */
  
  public RecordSet consultarReportes(DTOCriteriosReportes dtoin) throws MareException { 
     RecordSet resultado = new RecordSet();
  /*Documentation
    Hace una consulta sobre la tabla GEN_REPORTS con un join con GEN_PROCE_BATCH filtrando por los criterios recibidos y retorna un recordSet. 
    Se utiliza el join con la tabla GEN_PROCE_BATCH para obtener el proceso de generacion del informe del campo VAL_ESTA. Los estados estan definidos en la clase Proceso de Batch. 
    Como primera columna retor el COD_PROC que actua como identificador. */

     // System.out.println("dentro de consultarReportes....");
      StringBuffer prQuery = new StringBuffer();

      prQuery.append(" SELECT gr.OID_REPO OID, gr.COD_PROC, gr.FEC_REPO, ");
      prQuery.append(" in1.val_i18n DESCR, "); 
      prQuery.append(" gr.VAL_MODU, ");
      prQuery.append(" in11.val_i18n DESCR1, gr.VAL_EXTE "); 
      prQuery.append(" from GEN_REPOR gr, ");
      prQuery.append(" v_gen_i18n_sicc in1, v_gen_i18n_sicc in11, GEN_PROCE_BATCH gpb ");
      prQuery.append(" where in1.attr_enti(+) = 'REP_REPOR' ");
      prQuery.append(" AND in1.val_oid(+) = gr.RREP_OID_REPO ");
      prQuery.append(" AND in1.attr_num_atri(+) = 1 ");
      prQuery.append(" AND in1.idio_oid_idio(+) = "  + dtoin.getOidIdioma());
      prQuery.append(" AND gpb.COD_PROC = gr.COD_PROC ");
      prQuery.append(" AND in11.attr_enti(+) = 'GEN_ESTAD_BATCH' ");
      prQuery.append(" AND in11.val_oid(+) = gpb.VAL_ESTA ");
      prQuery.append(" AND in11.attr_num_atri(+) = 1 ");
      prQuery.append(" AND in11.idio_oid_idio(+) = "  + dtoin.getOidIdioma());
      
      if((dtoin.getFechaDesde() != null) &&(!dtoin.getFechaDesde().equals(""))){
          prQuery.append(" and TO_DATE (gr.FEC_REPO) >= TO_DATE ('" + dtoin.getFechaDesde() + "', 'yyyy/MM/dd') ");
      }
      
      if((dtoin.getFechaHasta() != null) &&(!dtoin.getFechaHasta().equals(""))){
         prQuery.append(" and TO_DATE (gr.FEC_REPO) <= TO_DATE ('" + dtoin.getFechaHasta() + "', 'yyyy/MM/dd') "); 
      }
      
      if((dtoin.getCodModulo() != null) && (!dtoin.getCodModulo().equals(""))){
         prQuery.append(" and UPPER(gr.VAL_MODU) = '" + dtoin.getCodModulo().trim().toUpperCase() + "'");
      }
      
    //  System.out.println("a punto de ejecutar consulta: " + prQuery.toString());  
      
      try {           
          resultado = BelcorpService.getInstance().dbService.executeStaticQuery(prQuery.toString());
        //  System.out.println("se obtiene: " + resultado);
    
        } catch (MareException me) {
            throw me;
        } catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()){
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }else{
           return resultado;   
        }        
     
  }

  public Long statusGeneracion(String codRep) throws MareException { 
     // System.out.println("dentro de consultarReportes....");
      StringBuffer prQuery = new StringBuffer();
      RecordSet resultado = new RecordSet();

      prQuery.append(" SELECT gpb.VAL_ESTA ");
      prQuery.append(" from GEN_PROCE_BATCH gpb "); 
      prQuery.append(" where ");
      prQuery.append(" Trim(gpb.COD_PROC) = Trim('"+codRep+"')"); 
  
      try {           
        resultado = BelcorpService.getInstance().dbService.executeStaticQuery(prQuery.toString());
      } catch (MareException me) {
          throw me;
      } catch(Exception e) {
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      if (resultado.esVacio()){
        throw new MareException(null, null, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }else{
        return new Long(resultado.getValueAt(0,0).toString());
      }   
  }

  /**
   * CHANGELOG
   * ---------
   * Incidencia SiCC 20090889 - dmorello, 20/04/2009
   * - Se modifica la forma de introducir la fecha en el INSERT.
   * - Se agrega el parametro extension
   */
  public Long insertGenRep(String codProc, String usua, String fecha, String modulo, Long rOidRepo, String extension) throws CreateException {
  
     Vector parametros = new Vector();   
     Long secuencia = null;      
     
		 // Asignar el nuevo oid
		 try {
      secuencia = SecuenciadorOID.obtenerSiguienteValor("GEN_REPO_SEQ"); 
			setOid(secuencia);
		 } catch (MareException me) {
			throw new CreateException();
		 }
    
     StringBuffer consulta = new StringBuffer("");

		 consulta.append("INSERT INTO GEN_REPOR (");
		 consulta.append("oid_repo, ");
		 consulta.append("cod_proc, ");
	   consulta.append("val_usua, ");
		 consulta.append("fec_repo, ");
		 consulta.append("val_modu, ");          
		 consulta.append("rrep_oid_repo, ");
                 consulta.append("val_exte ");
     
     parametros.add(getOid());
     parametros.add(codProc);
     parametros.add(usua);
     parametros.add(fecha);
     parametros.add(modulo);
     parametros.add(rOidRepo);
     parametros.add(extension);
     
		 consulta.append(") VALUES (?, ?, ?, "); // oid, codProc, usuario
                 consulta.append("TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), ");
                 consulta.append("?, ?, ? ");  // modulo, rOidRepo, extension
     consulta.append(")");     
     
		try {
     // System.out.println("sentencia: " + consulta.toString());
			ejecutaSentencia(consulta.toString(), parametros);
		} catch (EJBException ejbe) {
			String falloSQL = (ejbe.getCausedByException()).getMessage();
			if (falloSQL.indexOf("ORA-00001") != -1)
				throw new DuplicateKeyException();
			else if (falloSQL.indexOf("ORA-02291") != -1)
				throw new CreateException();
			else
				throw ejbe;
		}
    
    return secuencia;
     
  }
  
  private int ejecutaSentencia(String query, Vector argumentos) 
		throws EJBException 
  	{
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }
        try {
		    return bs.dbService.executePreparedUpdate(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
  }  
  
	public void setOid(Long newOid) {
		oid = newOid;
	}
 
  public Long getOid() {
		return oid;
	}
    
    public DTOBoolean validaCodigoVenta(DTOValidaCodigoVenta dto) throws MareException{
    
        UtilidadesLog.info("DAOForntReport.validaCodigoVenta(DTOValidaCodigoVenta dto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOBoolean dtoB = new DTOBoolean();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
       
             
        query.append(" select detal.val_codi_vent, cabec.PERD_OID_PERI ");
        query.append(" from pre_ofert_detal detal, pre_ofert oferta, pre_matri_factu_cabec cabec ");
        query.append(" where detal.OFER_OID_OFER = oferta.OID_OFER ");
        query.append(" and   oferta.MFCA_OID_CABE = cabec.OID_CABE  ");
        query.append(" and   cabec.PERD_OID_PERI = " + dto.getPeriodoReferencia());
        query.append(" and   detal.VAL_CODI_VENT = '" + dto.getCodigoVenta() + "'");
            
        try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
      
         if (!rs.esVacio()){          
            dtoB.setValor(true);
        } else {
            dtoB.setValor(false);
        }
       
       
        UtilidadesLog.info("DAOFrontReport.validaCodigoVenta(DTOValidaCodigoVenta dto):Salida");
        return dtoB;
    }
    
    public DTOSalida obtenerPeriodosCorporativos(DTOPeriodoCorporativos dto) throws MareException{
        UtilidadesLog.info("DAOForntReport.obtenerPeriodosCorporativos(DTOPeriodoCorporativos dto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOSalida dtoS = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
       
             
        query.append(" select corpo.OID_PERI, corpo.COD_PERI ");
        query.append(" from seg_perio_corpo corpo, seg_canal canal ");
        query.append(" where corpo.VAL_ANIO = " + dto.getAnio());
        query.append(" and  canal.OID_CANA = " + dto.getOidCanal());
        query.append(" and  canal.TIPE_OID_TIPO_PERI = corpo.TIPE_OID_TIPO_PERI ");
        query.append(" order by 2 ");

            
        try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
           
        UtilidadesLog.info("DAOFrontReport.obtenerPeriodosCorporativos(DTOPeriodoCorporativos dto):Salida");
        dtoS.setResultado(rs);
        return dtoS;
    
    }
    
      public DTOSalida obtenerZonasParaListaOculta(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAOForntReport.obtenerZonasParaListaOculta(DTOBelcorp dto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOSalida dtoS = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
       
             
        query.append(" select zona.MARC_OID_MARC,zona.CANA_OID_CANA, zona.OID_ZONA, zona.DES_ZONA from zon_zona zona ");
        query.append(" where zona.IND_BORR = 0 ");
        query.append(" and zona.IND_ACTI = 1 ");
        query.append(" and zona.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" order by 3 ");
            
        try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
           
        UtilidadesLog.info("DAOFrontReport.obtenerZonasParaListaOculta(DTOBelcorp dto):Salida");
        dtoS.setResultado(rs);
        return dtoS;
    
    }
    
    public DTOSalida busquedaRapidaProductos(DTOBusquedaRapidaProductos dto) throws MareException    {
         UtilidadesLog.info(" DAOFrontReport.busquedaRapidaProductosREP(DTOBusquedaRapida) : Entrada");	
         BelcorpService bs;
         RecordSet resultado = new RecordSet();
         DTOSalida dtoS = new DTOSalida();
         bs = UtilidadesEJB.getBelcorpService();

         StringBuffer query = new StringBuffer();
         
    
         try {
               bs = BelcorpService.getInstance();
        
               query.append(" SELECT produ.oid_prod OID, produ.cod_sap, produ.des_cort, marca.des_marc_prod, ");
               query.append(" i18nego.val_i18n AS negocio, i18.val_i18n AS unidad ");
               query.append(" FROM mae_produ produ, ");
               query.append(" seg_marca_produ marca, ");
               query.append(" gen_i18n_sicc_pais i18nego, ");
               query.append(" gen_i18n_sicc_pais i18 ");
               query.append(" WHERE produ.mapr_oid_marc_prod = marca.oid_marc_prod(+) ");
               query.append(" AND produ.pais_oid_pais = " + dto.getOidPais());                                         
               query.append(" AND i18.attr_enti = 'MAE_UNIDA_NEGOC' ");
               query.append(" AND i18.idio_oid_idio = " + dto.getOidIdioma());                                          
               query.append(" AND i18.val_oid = produ.uneg_oid_unid_nego ");
               query.append(" AND i18nego.attr_enti = 'MAE_NEGOC' ");
               query.append(" AND i18nego.idio_oid_idio = " + dto.getOidIdioma());                                      
               query.append(" AND i18nego.val_oid = produ.nego_oid_nego ");
               
               if((dto.getCodSap() != null) && (!dto.getCodSap().equals(""))){
                  query.append(" and produ.COD_SAP like '" + dto.getCodSap() + "'") ;
               }
               
               if((dto.getDescCort() != null) && (!dto.getDescCort().equals(""))){
                  query.append(" and produ.DES_CORT like '" + dto.getDescCort() + "'");
               }
               
               if((dto.getMarcaProducto() != null) && (!dto.getMarcaProducto().equals(""))){
                  query.append(" and produ.MAPR_OID_MARC_PROD = " + dto.getMarcaProducto());
               }
                            
               if((dto.getNegocio() != null) && (!dto.getNegocio().equals(""))){
                  query.append("  and produ.NEGO_OID_NEGO = " + dto.getNegocio());
               }
               
               if((dto.getUnidadNegocio() != null) && (!dto.getUnidadNegocio().equals(""))){
                  query.append(" and produ.UNEG_OID_UNID_NEGO = " + dto.getUnidadNegocio());
               }
               
               query.append(" order by 2 ");
                          
               
               String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
                 resultado = bs.dbService.executeStaticQuery(sqlPaginacion);
          
             }
         catch(Exception e) {
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
    
         if (!resultado.esVacio()){
            dtoS.setResultado(resultado);
         }else{
              throw new MareException(null, null, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }        
         UtilidadesLog.info(" DAOFrontReport.busquedaRapidaProductosREP(DTOBusquedaRapida) : Salida");	
         return dtoS;
        }
        
         public DTOSalida periodosCronogramaTotalGrupo(DTOPeriodo dto) throws MareException    {
             UtilidadesLog.info(" DAOFrontReport.periodosCronogramaTotalGrupo(DTOPeriodo) : Entrada");	
             StringBuffer query = new StringBuffer();
             RecordSet rs = new RecordSet(); 
             DTOSalida dtoS = new DTOSalida();
             BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
             query.append(" SELECT perio.oid_peri, perio.val_nomb_peri ");
             query.append(" FROM cra_perio perio, seg_perio_corpo corpo, seg_canal canal ");
             query.append(" WHERE perio.pais_oid_pais = " + dto.getOidPais());
             query.append(" AND perio.marc_oid_marc = " + dto.getMarca());
             query.append(" AND perio.cana_oid_cana = "  + dto.getCanal());
             query.append(" AND  canal.oid_cana = perio.cana_oid_cana ");
             query.append(" and perio.peri_oid_peri = corpo.oid_peri ");
             query.append(" and corpo.TIPE_OID_TIPO_PERI = canal.TIPE_OID_TIPO_PERI  ");
             query.append(" order by 2 ");

         
               
                try {
                   rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
                } catch (Exception e) {
                     UtilidadesLog.error(e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                   
                UtilidadesLog.info("DAOFrontReport.periodosCronogramaTotalGrupo(DTOPeriodo dto):Salida");
                dtoS.setResultado(rs);
                return dtoS;
         }
         
        public DTOSalida obtenerModulos(DTOBelcorp dto) throws MareException{
             UtilidadesLog.info(" DAOFrontReport.obtenerModulos(DTOBelcorp) : Entrada");	
             StringBuffer query = new StringBuffer();
             RecordSet rs = new RecordSet(); 
             DTOSalida dtoS = new DTOSalida();
             BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
             query.append(" SELECT   modulo.oid_modu, des.val_i18n ");
             query.append(" FROM seg_modul modulo, gen_i18n_sicc_comun des ");
             query.append(" WHERE modulo.oid_modu = des.val_oid ");
             query.append(" AND des.attr_enti = 'SEG_MODUL' ");
             query.append(" AND des.attr_num_atri = 1 ");
             query.append(" AND des.idio_oid_idio = " + dto.getOidIdioma());
             query.append(" ORDER BY 2 ");         
               
                try {
                   rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
                } catch (Exception e) {
                     UtilidadesLog.error(e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                   
                UtilidadesLog.info("DAOFrontReport.obtenerModulos(DTOBelcorp dto):Salida");
                dtoS.setResultado(rs);
                return dtoS;
        }
        
        public DTOSalida obtenerMarcaProducto(DTOBelcorp dto) throws MareException{
             UtilidadesLog.info(" DAOFrontReport.obtenerMarcaProducto(DTOBelcorp) : Entrada");	
             StringBuffer query = new StringBuffer();
             RecordSet rs = new RecordSet(); 
             DTOSalida dtoS = new DTOSalida();
             BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
             query.append(" SELECT   marca.oid_marc_prod, marca.des_marc_prod ");
             query.append(" FROM seg_marca_produ marca ");
             query.append(" ORDER BY 2 ");
               
                try {
                   rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
                } catch (Exception e) {
                     UtilidadesLog.error(e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                   
                UtilidadesLog.info("DAOFrontReport.obtenerMarcaProducto(DTOBelcorp dto):Salida");
                dtoS.setResultado(rs);
                return dtoS;
    }
    
    public DTOSalida obtenerPeriodosEstructuraFacturacion(DTOEstructuraFacturacion dto) throws MareException{        
         UtilidadesLog.info(" DAOFrontReport.obtenerPeriodosEstructuraFacturacion(DTOEstructuraFacturacion) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" select perio.OID_PERI, perio.VAL_NOMB_PERI ");
         query.append(" from  cra_perio perio, seg_perio_corpo corpo, seg_canal canal ");
         query.append(" where perio.PERI_OID_PERI = corpo.OID_PERI ");
         
         if((dto.getAnio() != null) && (!dto.getAnio().equals(""))){
            query.append(" and   corpo.VAL_ANIO like '" + dto.getAnio() +"' ");
         } 
         
         query.append(" and   perio.MARC_OID_MARC = " + dto.getMarca());
         query.append(" and   perio.CANA_OID_CANA in(" + dto.getCanales() + ")");
         query.append(" and   perio.CANA_OID_CANA = canal.OID_CANA ");
         query.append(" and   corpo.TIPE_OID_TIPO_PERI = canal.TIPE_OID_TIPO_PERI ");
         query.append(" order by 2 ");
           
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtenerPeriodosEstructuraFacturacion(DTOEstructuraFacturacion dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }

    public DTOSalida obtenerZonasEstructuraFacturacion(DTOEstructuraFacturacion dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtenerZonasEstructuraFacturacion(DTOEstructuraFacturacion) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" select zona.OID_ZONA, zona.DES_ZONA ");
         query.append(" from zon_zona zona ");
         query.append(" where zona.PAIS_OID_PAIS = " + dto.getOidPais());
         query.append(" and  zona.MARC_OID_MARC = " + dto.getMarca());
         query.append(" and zona.CANA_OID_CANA in(" + dto.getCanales() +") ");
         query.append(" and zona.IND_ACTI = 1 ");
         query.append(" and zona.IND_BORR = 0 ");
         query.append(" order by 2 ");

           
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtenerZonasEstructuraFacturacion(DTOEstructuraFacturacion dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }
    
    public DTOSalida obtener5PeriodosPosteriores(DTOPeriodo dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtener5PeriodosPosteriores(DTOPeriodo) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT oid_peri, val_nomb_peri, fec_inic, fec_fina ");
         query.append(" FROM (SELECT oid_peri, val_nomb_peri, fec_inic, fec_fina, ROWNUM AS pos ");
         query.append(" FROM (SELECT   peri.oid_peri, val_nomb_peri, peri.fec_inic, ");
         query.append(" peri.fec_fina ");
         query.append(" FROM cra_perio peri, (SELECT fec_inic, fec_fina ");
         query.append(" FROM cra_perio ");
         query.append(" WHERE oid_peri = " + dto.getOid() +") ff ");
         query.append(" WHERE ff.fec_fina <= peri.fec_fina ");
         query.append(" AND peri.pais_oid_pais = " + dto.getPais());
         query.append(" AND peri.marc_oid_marc = " + dto.getMarca());
         query.append(" AND peri.cana_oid_cana = " + dto.getCanal());
         query.append(" ORDER BY peri.fec_inic)) ");
         query.append(" WHERE pos <= 5 ");

           
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtener5PeriodosPosteriores(DTOPeriodo dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }
                     
   
     public DTOSalida obtenerOperacionesSinAnulacion(DTOBelcorp dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtenerOperacionesSinAnulacion(DTOBelcorp) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT   operacion.oid_oper, operacion.val_desc_larg ");
         query.append("     FROM rec_opera operacion  ");
         query.append(" WHERE operacion.pais_oid_pais = " + dto.getOidPais());
         query.append(" and   operacion.IND_ANUL <> 1 ");
         query.append(" ORDER BY 2 ");

           
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtener5PeriodosPosteriores(DTOPeriodo dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }
    
      public DTOSalida obtenerConsursosMarcas(DTOString dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtenerConsursosMarcas(DTOOIDs) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT   concu.oid_para_gral, concu.num_conc || ' ' || concu.num_vers ");
         query.append(" FROM inc_concu_param_gener concu, inc_versi_concu vers ");
         query.append(" WHERE concu.pais_oid_pais =  " + dto.getOidPais());
         query.append(" AND concu.MARC_OID_MARC in(" + dto.getCadena() +") ");
         query.append(" AND concu.oid_para_gral = vers.copa_oid_para_gral ");
         query.append(" AND (vers.esc2_oid_esta_conc = 2 OR vers.esc2_oid_esta_conc = 11) ");
         query.append(" ORDER BY 2 ");
         

           
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtenerConsursosMarcas(DTOOIDs dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }
    
    public DTOSalida obtenerPeriodosConcurso(DTOOID dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtenerConsursosMarcas(DTOOIDs) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT perio.OID_PERI, perio.VAL_NOMB_PERI ");
         query.append(" FROM inc_concu_param_gener concu, cra_perio pini, cra_perio pfin, cra_perio perio ");
         query.append(" WHERE concu.oid_para_gral = " + dto.getOid());
         query.append(" AND concu.perd_oid_peri_desd = pini.oid_peri ");
         query.append(" AND concu.perd_oid_peri_hast = pfin.oid_peri ");
         query.append(" and perio.PAIS_OID_PAIS = pini.PAIS_OID_PAIS ");
         query.append(" and perio.marc_oid_marc = pini.MARC_OID_MARC ");
         query.append(" and perio.cana_oid_cana = pini.cana_oid_cana ");
         query.append(" and perio.fec_inic >= pini.fec_inic ");
         query.append(" and perio.fec_fina <= pfin.fec_fina ");
         query.append(" order by 2 ");
                   
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtenerConsursosMarcas(DTOOIDs dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }
  
    public DTOSalida obtener4PeriodosPosteriores(DTOOID dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtener4PeriodosPosteriores(DTOOID) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT oid_peri, val_nomb_peri ");
         query.append(" FROM (SELECT oid_peri, val_nomb_peri, ROWNUM AS pos ");
         query.append(" FROM (SELECT   peri.oid_peri, peri.val_nomb_peri ");
         query.append(" FROM cra_perio peri, ");
         query.append(" (SELECT fec_inic, pais_oid_pais, marc_oid_marc, ");
         query.append(" cana_oid_cana ");
         query.append(" FROM cra_perio ");
         query.append(" WHERE oid_peri = "+ dto.getOid() +") ff ");
         query.append(" WHERE ff.fec_inic <= peri.fec_inic ");
         query.append(" AND peri.pais_oid_pais = ff.pais_oid_pais ");
         query.append(" AND peri.marc_oid_marc = ff.marc_oid_marc ");
         query.append(" AND peri.cana_oid_cana = ff.cana_oid_cana ");
         query.append(" ORDER BY peri.fec_inic ASC)) ");
         query.append(" WHERE pos = 4 ");
                   
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtener4PeriodosPosteriores(DTOOID dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
    }
    
    public DTOSalida recargaComisiones(DTORecargaComisiones dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargaComisiones(DTORecargaComisiones) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT    distinct comision.oid_comi OID, descripcion.val_i18n ");
         query.append(" FROM com_comis comision,");
         query.append(" cra_perio peri,");
         query.append(" v_gen_i18n_sicc descripcion,");
         query.append(" (SELECT comision.oid_comi,");
         query.append(" (SELECT fec_inic");
         query.append(" FROM cra_perio");
         query.append(" WHERE oid_peri = comision.perd_oid_peri) fi,");
         query.append(" (SELECT fec_fina");
         query.append(" FROM cra_perio");
         query.append(" WHERE oid_peri = comision.perd_oid_peri_hast) ff");
         query.append(" FROM com_comis comision");
         query.append(" WHERE comision.ind_vent_cobr = 'C') fechas");
         query.append(" WHERE fechas.oid_comi = comision.oid_comi");
         query.append(" AND comision.ind_vent_cobr = 'C'");
         query.append(" AND fechas.fi <= peri.fec_inic");
         query.append(" AND fechas.ff >= peri.fec_fina");
         query.append(" AND peri.oid_peri in("+ dto.getPeriodos()+ ")");
         query.append(" AND peri.pais_oid_pais = " + dto.getOidPais());
         query.append(" AND peri.cana_oid_cana = " + dto.getCanal());
         query.append(" AND peri.marc_oid_marc = " + dto.getMarca());
         query.append(" AND descripcion.attr_enti = 'COM_COMIS'");
         query.append(" AND comision.oid_comi = descripcion.val_oid");
         query.append(" AND descripcion.idio_oid_idio = " + dto.getOidIdioma());
         query.append(" ORDER BY 2 ");
                   
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.recargaComisiones(DTORecargaComisiones dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
  }
  
   public DTOSalida obtenerMoneda(DTOBelcorp dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.obtenerMoneda(DTOBelcorp) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" select mone_oid_mone from seg_pais ");
         query.append(" where oid_pais = " +  dto.getOidPais());
                   
            try {
               rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                 UtilidadesLog.error(e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
               
            UtilidadesLog.info("DAOFrontReport.obtenerMoneda(DTOBelcorp dto):Salida");
            dtoS.setResultado(rs);
            return dtoS;
  }
  
   public DTOSalida cargarPeriodosREP(DTOPeriodo dto) throws MareException{
         UtilidadesLog.info(" DAOFrontReport.cargarPeriodosREP(DTOPeriodo) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" select p.OID_PERI, p.VAL_NOMB_PERI from cra_perio p ");
         query.append("where p.PAIS_OID_PAIS =  " + dto.getOidPais());
         
         if(dto.getMarca() != null){
            query.append("and p.MARC_OID_MARC = " + dto.getMarca());
         }
         
         if(dto.getCanal() != null){
            query.append("and p.CANA_OID_CANA = " + dto.getCanal());
         }
         
         query.append("order by 2 ");
                 
          try {
             rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
          } catch (Exception e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
               
          UtilidadesLog.info("DAOFrontReport.cargarPeriodosREP(DTOPeriodo dto):Salida");
          dtoS.setResultado(rs);
          return dtoS;
  }

/********Metodos utilizados para recargas de combos multiseleccion y asi evitar la carga de listas ocultas*********/ 
/****mdolce****/
  
  public DTOSalida recargarRegionesRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarRegionesRep(recargarRegionesRep) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT region.oid_regi, region.des_regi ");
         query.append(" FROM zon_regio region ");
         query.append(" WHERE region.ind_acti = 1 ");
         query.append(" AND region.ind_borr = 0 ");
         query.append(" and region.ZSGV_OID_SUBG_VENT in(" +convertirStringTOStringComas(dto.getCadena()) +") ");
         query.append(" and region.PAIS_OID_PAIS = " + dto.getOidPais());
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarRegionesRep(DTOBelcorp dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;
  }

  public DTOSalida recargarZonasRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarZonasRep(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT  zona.oid_zona, zona.des_zona ");
         query.append(" FROM zon_zona zona ");
         query.append(" WHERE zona.ind_acti = 1 ");
         query.append(" AND zona.ind_borr = 0 ");
         query.append(" AND zona.ZORG_OID_REGI in(" + convertirStringTOStringComas(dto.getCadena()) + ") ");
         query.append(" and zona.PAIS_OID_PAIS = " + dto.getOidPais());
         query.append(" ORDER BY zona.des_zona ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarZonasRep(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;
  }

  public DTOSalida recargarSeccionesRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarSeccionesRep(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append("  SELECT   seccion.oid_secc, seccion.des_secci ");
         query.append("  FROM zon_secci seccion ");
         query.append("  WHERE seccion.ind_acti = 1 ");
         query.append("  AND seccion.ind_borr = 0 ");
         query.append("  AND seccion.zzon_oid_zona IN (" + convertirStringTOStringComas(dto.getCadena()) + ") ");
         query.append("  ORDER BY seccion.des_secci ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarSeccionesRep(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;  
  }

  public DTOSalida recargarTerritoriosZonasRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarTerritoriosZonasRep(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append("   SELECT DISTINCT ta.terr_oid_terr, t.cod_terr ");
         query.append("   FROM zon_terri t, zon_terri_admin ta, zon_secci s ");
         query.append("   WHERE s.oid_secc = ta.zscc_oid_secc ");
         query.append("   AND t.oid_terr = ta.terr_oid_terr ");
         query.append("   AND s.ind_acti = 1 ");
         query.append("   AND s.ind_borr = 0 ");
         query.append("   AND t.ind_borr = 0 ");
         query.append("   AND ta.ind_borr = 0 ");
         query.append("   AND s.zzon_oid_zona IN (" + convertirStringTOStringComas(dto.getCadena())+")");
         query.append("   ORDER BY t.cod_terr ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarTerritoriosZonasRep(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;     
  
  }

  public DTOSalida recargarTerritoriosSeccionesRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarTerritoriosSeccionesRep(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT DISTINCT ta.terr_oid_terr, t.cod_terr ");
         query.append(" FROM zon_terri t, zon_terri_admin ta ");
         query.append(" WHERE t.oid_terr = ta.terr_oid_terr ");
         query.append(" AND t.ind_borr = 0 ");
         query.append(" AND ta.ind_borr = 0 ");
         query.append(" AND ta.zscc_oid_secc IN ( " + convertirStringTOStringComas(dto.getCadena())+ " ) ");
         query.append(" ORDER BY t.cod_terr ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarTerritoriosSeccionesRep(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;     
  }
  
   public DTOSalida recargarNivelesConcursos(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarNivelesConcursos(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT   parampremi.oid_para_nive_prem, ");
         query.append(" parampremi.num_nive ");
         query.append(" FROM inc_param_nivel_premi parampremi, inc_param_gener_premi genepremi ");
         query.append(" WHERE parampremi.pagp_oid_para_gene_prem = genepremi.oid_para_gene_prem ");
         query.append(" and   genepremi.COPA_OID_PARA_GRAL in("+ convertirStringTOStringComas(dto.getCadena()) +") ");
         query.append(" ORDER BY 2 ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarNivelesConcursos(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;     
  }
  
  private String convertirStringTOStringComas(String cadena) throws MareException {
    //Recibe un string separado por x y ldevuelve un string separado por comas
       StringTokenizer st = new StringTokenizer(cadena, "x");
       String cadenaSalida = new String();
       while (st.countTokens()> 0) {
          cadenaSalida = cadenaSalida + st.nextToken();
          if(cadenaSalida!=null){
             cadenaSalida = cadenaSalida + ",";
          }
       }
       
       cadenaSalida = cadenaSalida.substring(0, cadenaSalida.length() -1);
       return cadenaSalida;
  } 
  
    public DTOSalida recargaNumerosDescuentosRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargaNumerosDescuentosRep(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         
         query.append(" SELECT des.oid_desc, des.num_desc ");
         query.append(" FROM dto_descu des ");
         query.append(" WHERE  ");
         query.append(" des.MDES_OID_TIPO_DESC IN ( " + convertirStringTOStringComas(dto.getCadena())+ " ) ");
         query.append(" AND des.PAIS_OID_PAIS = " + dto.getOidPais());
         query.append(" ORDER BY des.num_desc ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargaNumerosDescuentosRep(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;     
  }  

   public DTOSalida recargaTipoSolicitudPorClaseRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargaTipoSolicitudPorClaseRep(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         
         query.append(" SELECT ped.OID_TIPO_SOLI, gen_i18.VAL_I18N ");
         query.append(" FROM ped_tipo_solic ped, gen_i18n_sicc gen_i18 ");
         query.append(" WHERE ped.OID_TIPO_SOLI = gen_i18.val_oid ");
         query.append(" AND  gen_i18.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
         query.append(" AND  gen_i18.ATTR_NUM_ATRI = 1 ");
         query.append(" AND  ped.CLSO_OID_CLAS_SOLI IN ( " + convertirStringTOStringComas(dto.getCadena())+ " ) ");
         query.append(" AND  gen_i18.IDIO_OID_IDIO = " + dto.getOidIdioma());
         query.append(" ORDER BY gen_i18.VAL_I18N ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargaTipoSolicitudPorClaseRep(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;     
  }
 
    public DTOSalida recargarRegionesParaListaCanalRep(DTOUnidadAdministrativa dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarRegionesParaListaCanalRep(DTOUnidadAdministrativa) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT region.oid_regi, region.des_regi ");
         query.append(" FROM zon_regio region ");
         query.append(" WHERE region.ind_acti = 1 ");
         query.append(" AND region.ind_borr = 0 ");
         query.append(" AND region.CANA_OID_CANA in(" +convertirStringTOStringComas(dto.getDescripcion()) +") ");
         query.append(" AND region.MARC_OID_MARC  = " + dto.getOidMarca());
         query.append(" AND region.PAIS_OID_PAIS = "  + dto.getOidPais());
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarRegionesParaListaCanalRep(DTOUnidadAdministrativa dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;
  }
  
   public DTOSalida recargarGerentesRegionRep(DTOString dto) throws MareException {
         UtilidadesLog.info(" DAOFrontReport.recargarGerentesRegionRep(DTOOID) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT B.OID_CLIE as oidCliente, ");
         query.append(" (B.val_nom1||' '||B.val_nom2||' '||B.val_ape1||' '||B.val_ape2) as nombreGerente ");
         /*query.append(" A.MARC_OID_MARC MARCA, ");
         query.append(" A.CANA_OID_CANA CANAL, ");
         query.append(" A.OID_REGI REGION  ");*/
         query.append(" FROM zon_regio A, ");
         query.append(" mae_clien B  ");
         query.append(" WHERE 1=1 ");

         if (dto.getCadena() != null) {
            query.append(" AND A.OID_REGI IN ( " + convertirStringTOStringComas(dto.getCadena())+ " ) ");
         }
         if (dto.getOidPais() != null) {
            query.append(" AND A.PAIS_OID_PAIS = " + dto.getOidPais() + "  ");
         }
         query.append(" AND B.oid_clie (+) = A.clie_oid_clie  ");
         query.append(" ORDER BY nombreGerente ");
         
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("DAOFrontReport.recargarGerentesRegionRep(DTOOID dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;
  } 
  
  
  /**
   * Creado por incidencia SiCC 20090889
   * Implementación JDBC equivalente al metodo finder GenReporLocalHome.findByCodProc
   * @author dmorello
   * @since 15-abr-2009
   */
  public RecordSet obtenerReportesPorCodProc(String codProc) throws MareException {
      UtilidadesLog.info("DAOFrontReport.obtenerReportesPorCodProc(String codProc): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Vector params = new Vector();
      String query = "SELECT * FROM GEN_REPOR WHERE COD_PROC = ?";
      params.add(codProc);
      
      RecordSet rs = null;
      try {
          rs = bs.dbService.executePreparedQuery(query, params);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOFrontReport.obtenerReportesPorCodProc(String codProc): Salida");
      return rs;
  }
  
    /**
     * Creado por incidencia SiCC 20090889
     * Actualiza el campo COD_PROC de un registro de la tabla GEN_REPOR
     * cuyo OID recibe por parametro.
     * @author dmorello
     * @since 20-abr-2009
     */
  public void actualizarProcessID(Long oidReporte, String processID) throws MareException {
      UtilidadesLog.info("DAOFrontReport.actualizarProcessID(Long oidReporte, String processID): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      String update = "UPDATE GEN_REPOR SET COD_PROC = ? WHERE OID_REPO = ?";
      Vector params = new Vector();
      params.add(processID);
      params.add(oidReporte);
      
      try {
          bs.dbService.executePreparedUpdate(update, params);
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOFrontReport.actualizarProcessID(Long oidReporte, String processID): Salida");
  }
  
}