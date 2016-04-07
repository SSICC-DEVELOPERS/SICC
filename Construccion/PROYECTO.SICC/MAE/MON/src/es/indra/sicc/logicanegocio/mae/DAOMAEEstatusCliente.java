package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.mae.DTOCierreRegion;
import es.indra.sicc.dtos.mae.DTOEstados;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.ejb.CreateException;

public class DAOMAEEstatusCliente  {

	private final String usuario;
        private String listaPeriodosReingreso;

    public DAOMAEEstatusCliente(String usuario) {
		this.usuario = usuario;
    }
  
   public static DTOSalida obtenerPosiblesEstatusCliente(DTOBelcorp dto)
                                                        throws MareException {
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerPosiblesEstatusCliente(DTOBelcorp): Entrada");                                                        
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();

            query.append(" SELECT oid_esta_clie, i.val_i18n");
            query.append("   FROM mae_estat_clien e, v_gen_i18n_sicc i");
            query.append("  WHERE i.attr_enti = 'MAE_ESTAT_CLIEN'");
            query.append("    AND i.attr_num_atri = 1");
            query.append("    AND i.idio_oid_idio = " + dto.getOidIdioma() );
            query.append("    AND i.val_oid = e.oid_esta_clie");
            query.append("  ORDER BY 2");

            resultado = bs.dbService.executeStaticQuery(query.toString() );

        } catch(CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!resultado.esVacio()){
          dtos.setResultado(resultado);
        } else {
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        
        
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerPosiblesEstatusCliente(DTOBelcorp): Salida");                                                        
        return dtos;
    }

/**
* Modificado: SICC-DMCO-MAE-GCC-006 - Cleal
*/	
public RecordSet obtenerClientesActualizarIndActivo (DTOCierreRegion dto) throws MareException{
     UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerClientesActualizarIndActivo(DTOCierreRegion): Entrada");
	   BelcorpService bs;
     RecordSet resultado = new RecordSet();
     
	   bs = UtilidadesEJB.getBelcorpService();
	   StringBuffer query = new StringBuffer();
	   try {
            bs = BelcorpService.getInstance();
			query.append(" SELECT a.CLIE_OID_CLIE, p.NUM_PERI_RETI , a.NUM_CAMP_SIN_PEDI, a.OID_CLIE_DATO_ADIC "); 
			query.append(" FROM MAE_CLIEN_DATOS_ADICI a, MAE_CLIEN b, SEG_PAIS p "); 
			query.append(" WHERE a.CLIE_OID_CLIE = b.OID_CLIE "); 
			query.append(" AND b.PAIS_OID_PAIS = p.OID_PAIS "); 
			query.append(" AND p.OID_PAIS =  " + dto.getOidPais()); 
			query.append(" AND a.CLIE_OID_CLIE in ("); 
      
			query.append(" SELECT c.OID_CLIE "); 
			query.append(" FROM MAE_CLIEN c "); 
			query.append(" JOIN MAE_CLIEN_UNIDA_ADMIN u ON (u.CLIE_OID_CLIE = c.OID_CLIE) "); 
			query.append(" JOIN ZON_TERRI_ADMIN t ON (u.ZTAD_OID_TERR_ADMI = t.OID_TERR_ADMI)");  
			query.append(" JOIN ZON_SECCI s ON (t.ZSCC_OID_SECC = s.OID_SECC) "); 
			query.append(" JOIN ZON_ZONA z ON (s.ZZON_OID_ZONA = Z.OID_ZONA), CRA_PERIO periodoInicio, CRA_PERIO periodoActual "); 
			query.append(" WHERE u.PERD_OID_PERI_INI = periodoInicio.OID_PERI "); 
			query.append(" AND periodoActual.OID_PERI =  " + dto.getPeriodo()); 
			query.append(" AND periodoInicio.MARC_OID_MARC = periodoActual.MARC_OID_MARC "); 
			query.append(" AND periodoInicio.CANA_OID_CANA = periodoActual.CANA_OID_CANA  "); 
			query.append(" AND periodoInicio.FEC_INIC <= periodoActual.FEC_INIC  "); 
			query.append(" AND u.PERD_OID_PERI_FIN IS NULL "); 
			query.append(" AND ZORG_OID_REGI =  " + dto.getRegion().longValue() + " )"); 

			resultado = bs.dbService.executeStaticQuery(query.toString() );
			
		
	   }catch(Exception e) {
        if (e instanceof MareException) {
                ((MareException) e).getOriginalCause().printStackTrace();
                throw (MareException) e;
        } else {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
			
	   }
     UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerClientesActualizarIndActivo(DTOCierreRegion): Salida");
		return resultado;
	}

	
    /**
     * Modificado: SICC-DMCO-MAE-GCC-006 - Cleal
     * @observacion Perf. Deja de utilizarse en CU Asignar Estatus en Lote, ver 
     * obtenerClientesActualizarEstatusLote 
     */
    public static RecordSet obtenerClientesActualizarEstatus (DTOCierreRegion dto)
                                                        throws MareException {
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerClientesActualizarEstatus(DTOCierreRegion): Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
            query.append("SELECT a.CLIE_OID_CLIE, p.NUM_PERI_EGRE, a.NUM_CAMP_SIN_PEDI, a.OID_CLIE_DATO_ADIC, p.NUM_PERI_RETI, e.COD_ESTA_CLIE, a.IND_ACTI ");
            query.append("FROM MAE_CLIEN_DATOS_ADICI a, SEG_PAIS p, MAE_CLIEN b, MAE_CLIEN_TIPO_SUBTI ct, MAE_TIPO_CLIEN t, MAE_ESTAT_CLIEN e ");
            query.append("WHERE a.CLIE_OID_CLIE = b.OID_CLIE AND ");
            query.append("	  b.PAIS_OID_PAIS = p.OID_PAIS AND ");
            query.append("	  b.OID_CLIE = ct.CLIE_OID_CLIE AND ");
            query.append("	  ct.TICL_OID_TIPO_CLIE = t.OID_TIPO_CLIE AND ");
            query.append("	  a.ESTA_OID_ESTA_CLIE = e.OID_ESTA_CLIE AND ");
            //query.append("	  a.IND_ACTI = 1 AND ");
            query.append("	  a.ESTA_OID_ESTA_CLIE IS NOT NULL AND ");
            query.append("	  t.COD_TIPO_CLIE = '"+ ConstantesMAE.TIPO_CLIENTE_CONSULTORA + "' ");
            query.append("	  AND ");
            query.append("	  b.OID_CLIE IN ");
            query.append("	  ( ");
            query.append("	   			 SELECT c.OID_CLIE ");
            query.append("				 FROM MAE_CLIEN c JOIN MAE_CLIEN_UNIDA_ADMIN u ON (u.CLIE_OID_CLIE = c.OID_CLIE) ");
            query.append("				 	  JOIN ZON_TERRI_ADMIN t ON (u.ZTAD_OID_TERR_ADMI = t.OID_TERR_ADMI) ");
            query.append("				 	  JOIN ZON_SECCI s ON (t.ZSCC_OID_SECC = s.OID_SECC) ");
            query.append("				 	  JOIN ZON_ZONA z ON (s.ZZON_OID_ZONA = z.OID_ZONA), ");
            query.append("				 	  CRA_PERIO periodoInicio, ");
            query.append("					  CRA_PERIO periodoActual ");
            query.append("				WHERE u.PERD_OID_PERI_INI = periodoInicio.OID_PERI AND ");
            query.append("					  periodoActual.OID_PERI = " + dto.getPeriodo() + " AND ");
            query.append("					  periodoInicio.MARC_OID_MARC = periodoActual.MARC_OID_MARC AND ");
            query.append("					  periodoInicio.CANA_OID_CANA = periodoActual.CANA_OID_CANA AND ");
            query.append("					  periodoInicio.FEC_INIC <= periodoActual.FEC_INIC "); //El periodo de inicio tiene que ser anterior al periodo actual
            query.append("					  AND ");
            query.append("					  PERD_OID_PERI_FIN IS NULL AND ");
            query.append("					  ZORG_OID_REGI = "+ dto.getRegion().longValue() + " ");
            query.append("		) ");

            resultado = bs.dbService.executeStaticQuery(query.toString() );

        } catch(CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerClientesActualizarEstatus(DTOCierreRegion): Salida");

        return resultado;
    }
    
   /**
    * @observacion [15/Nov/2006] eiraola
    * Perf. Deja de utilizarse en CU Asignar Estatus en Lote, ver 
    * obtenerUltimoHistoricoLoteClientes
    */
    public Long obtenerUltimoHistorico(Long cliente, Long periodoNuevo, Long estadoCalculado) throws MareException{
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerUltimoHistorico(Long cliente, Long periodoNuevo, Long estadoCalculado): Entrada");
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        Long oid = null;

        StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT histo.oid_hist_esta OID");
        query.append(" FROM   mae_clien_histo_estat histo,");
        query.append(" cra_perio p_ini,");
        query.append(" cra_perio p_act");
        query.append(" WHERE  histo.clie_oid_clie = "+cliente);
        query.append(" AND histo.perd_oid_peri = p_ini.oid_peri AND");
        query.append(" p_ini.pais_oid_pais = p_act.pais_oid_pais AND");
        query.append(" p_ini.marc_oid_marc = p_act.marc_oid_marc AND");
        query.append(" p_ini.cana_oid_cana = p_act.cana_oid_cana AND");
        query.append(" p_ini.fec_inic <= p_act.fec_inic AND");
        query.append(" p_act.oid_peri = "+periodoNuevo);
        query.append(" AND histo.perd_oid_peri_peri_fin IS NULL AND");
        query.append(" histo.esta_oid_esta_clie <> "+estadoCalculado);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if(!rs.esVacio()){
            oid = new Long(rs.getValueAt(0, "OID").toString());
            UtilidadesLog.debug("*** OID: "+oid);
        }
        
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerUltimoHistorico(Long cliente, Long periodoNuevo, Long estadoCalculado): Salida");
        return oid;
    }
    
   /**
    * Recupera a partir de la region y periodo indicados, los datos de las 
    * Consultoras para poder ejecutar el proceso de Asignar Estatus de Clientes 
    * en lote. Incorpora el conteo de pedidos y la obtencion del futuro estatus.
    * @author eiraola
    * @date 12/Nov/2006
    * @observacion Metodo creado por performance. Basado en obtenerClientesActualizarEstatus
    * pero incorpora a la consulta otras subquerys para evitar posteriores accesos
    * a la base de datos
    */
    public static RecordSet obtenerClientesActualizarEstatusLote(DTOCierreRegion dto)
            throws MareException {
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerClientesActualizarEstatus(DTOCierreRegion): Entrada");
        final String REGISTRADO = "'" + ConstantesMAE.ESTATUS_REGISTRADO + "'"; // 01
        final String NUEVO      = "'" + ConstantesMAE.ESTATUS_NUEVO      + "'"; // 02
        final String NORMAL     = "'" + ConstantesMAE.ESTATUS_NORMAL     + "'"; // 03
        final String EGRESANTE  = "'" + ConstantesMAE.ESTATUS_EGRESANTE  + "'"; // 04
        final String EGRESADA   = "'" + ConstantesMAE.ESTATUS_EGRESADA   + "'"; // 05
        final String REINGRESO  = "'" + ConstantesMAE.ESTATUS_REINGRESO  + "'"; // 06
        final String RETIRADO   = "'" + ConstantesMAE.ESTATUS_RETIRADO   + "'"; // 07
        final String REACTIVADO = "'" + ConstantesMAE.ESTATUS_REACTIVADO + "'"; // 08
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        
        StringBuffer query = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
            
            query.append("SELECT consulta2.*, ");
			      query.append(" (SELECT mes.OID_ESTA_CLIE FROM MAE_ESTAT_CLIEN mes ");
            query.append("   WHERE mes.COD_ESTA_CLIE = consulta2.cod_esta_clie_nuevo");
            query.append("  ) esta_oid_esta_clie_nuevo ");
            query.append("  FROM ( ");
            query.append("SELECT consulta.*,   ");
            query.append("  CASE WHEN (cantidadPedidos > 0) THEN");             // Paso pedido en el Periodo actual
            query.append("    case when cod_esta_clie = "+ NORMAL +
                                 " then "+ NORMAL +" else ");                   // Normal -> Normal
            query.append("    case when cod_esta_clie = "+ REGISTRADO +
                                 " then "+ NUEVO +" else ");                    // Registrada -> Nueva
            query.append("    case when cod_esta_clie = "+ NUEVO +
                                 " then "+ NORMAL +" else ");                   // Nueva -> Normal
            query.append("    case when cod_esta_clie = "+ EGRESANTE +
                                 " then "+ NORMAL +" else ");                   // Egresante -> Normal
            // gPineda - 08/03/2007 - Sicc 20070092
            //query.append("    case when cod_esta_clie = "+ EGRESADA +" and (num_camp_sin_pedi < num_peri_reti)" + 
            query.append("    case when cod_esta_clie = "+ EGRESADA +
                                 " then "+ REINGRESO +" else ");                // Egresada -> Reingreso
            query.append("    case when cod_esta_clie = "+ REINGRESO +
                                 " then "+ NORMAL +" else ");                   // Reingreso -> Normal
            query.append("    case when cod_esta_clie = "+ RETIRADO +
                                 " then "+ REACTIVADO +" else ");               // Retirada -> Reactivada
            query.append("    case when cod_esta_clie = "+ REACTIVADO +
                                 " then "+ NORMAL +" ");                        // Reactivada -> Normal
            query.append("    else cod_esta_clie ");                            // En otro caso no cambia el estado
            query.append("    end end end end end end end end ");
            query.append("  ELSE ");                                            // No Paso pedido en el Periodo actual
            query.append("    case when cod_esta_clie = "+ NUEVO +" and ((num_camp_sin_pedi + 1) = 1)" +
                                 " then "+ EGRESANTE +" else ");                // Nuevo y un periodo sin hacer pedido -> Egresante 
            query.append("    case when cod_esta_clie = "+ NORMAL +" and ((num_camp_sin_pedi + 1) = 1)" +
                                 " then "+ EGRESANTE +" else ");                // Normal y un periodo sin hacer pedido -> Egresante 
            query.append("    case when cod_esta_clie = "+ EGRESANTE +" and ((num_camp_sin_pedi + 1) > num_peri_egre)" +
                                 " then "+ EGRESADA +" else ");                 // Egresante -> Egresada 
            query.append("    case when cod_esta_clie = "+ EGRESADA +" and ((num_camp_sin_pedi + 1) >= num_peri_reti)" +
                                 " then "+ RETIRADO +" else ");                 // Egresada -> Retirado 
            query.append("    case when cod_esta_clie = "+ REINGRESO +" and ((num_camp_sin_pedi + 1) = 1)" +
                                 " then "+ EGRESANTE +" else ");                // Reingreso -> Egresante
            query.append("    case when cod_esta_clie = "+ REACTIVADO +" and ((num_camp_sin_pedi + 1) = 1)" +
                                 " then "+ EGRESANTE +" else ");                // Reactivado -> Egresante
            /* gPineda - 08/03/2007 - Sicc 20070092
            query.append("    case when cod_esta_clie = "+ EGRESANTE +" and ((num_camp_sin_pedi + 1) <= num_peri_egre)" +
                                 " then "+ EGRESANTE +" else ");                // Egresante -> Egresante  */
            query.append("    case when cod_esta_clie = "+ EGRESADA +" and ((num_camp_sin_pedi + 1) < num_peri_reti)" +
                                  "then "+ EGRESADA +" ");                      // Egresada -> Egresada
            query.append(" 	  else cod_esta_clie ");                            // En otro caso no cambia el estado
            query.append("    end end end end end end end ");
            query.append("  END cod_esta_clie_nuevo ");
            query.append("  FROM (SELECT a.clie_oid_clie, a.oid_clie_dato_adic, a.num_camp_sin_pedi, ");
            query.append("               p.num_peri_egre, p.num_peri_reti, e.cod_esta_clie, ");
            query.append("               a.esta_oid_esta_clie, a.ind_acti, ");
            query.append("               (SELECT count(1) ");
            query.append("                  FROM PED_SOLIC_CABEC psc, ");
            query.append("                       PED_TIPO_SOLIC_PAIS tsp, ");
            query.append("                       PED_TIPO_SOLIC ts ");
            query.append("                 WHERE psc.ind_oc = 1 ");
            query.append("                   AND psc.clie_oid_clie = b.oid_clie ");
            query.append("                   AND psc.perd_oid_peri = "+ dto.getPeriodo());
            query.append("                   AND psc.FEC_FACT IS NOT null ");
            query.append("                   AND ((psc.IND_PEDI_PRUE is null) OR (psc.IND_PEDI_PRUE = 0)) ");
            query.append("                   AND psc.TSPA_OID_TIPO_SOLI_PAIS = tsp.OID_TIPO_SOLI_PAIS ");
            query.append("                   AND tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
            query.append("                   AND ts.IND_DEVO  = 0 ");
            query.append("                   AND psc.MODU_OID_MODU <> "+ConstantesPED.MODULO_RECLAMOS);
            query.append("                   AND ts.IND_ANUL  = 0  ");
            //BLO-01 jrivas 15/11/2007
            query.append("                   AND psc.IND_TS_NO_CONSO = 1) cantidadPedidos, p.oid_pais ");
            query.append("          FROM mae_clien_datos_adici a, ");
            query.append("               seg_pais p, ");
            query.append("               mae_clien b, ");
            query.append("               mae_clien_tipo_subti ct, ");
            query.append("               mae_tipo_clien t, ");
            query.append("               mae_estat_clien e ");
            query.append("         WHERE a.clie_oid_clie = b.oid_clie ");
            query.append("           AND b.pais_oid_pais = p.oid_pais ");
            query.append("           AND b.oid_clie = ct.clie_oid_clie ");
            query.append("           AND ct.ticl_oid_tipo_clie = t.oid_tipo_clie ");
            query.append("           AND a.esta_oid_esta_clie = e.oid_esta_clie ");
            query.append("           AND a.esta_oid_esta_clie IS NOT NULL ");
            query.append("           AND t.cod_tipo_clie = '"+ ConstantesMAE.TIPO_CLIENTE_CONSULTORA + "' ");
            query.append("           AND b.oid_clie IN ( ");
            query.append("             SELECT c.oid_clie FROM mae_clien c ");
            query.append("               JOIN mae_clien_unida_admin u ON (u.clie_oid_clie = c.oid_clie) ");
            query.append("               JOIN zon_terri_admin t ON (u.ztad_oid_terr_admi = t.oid_terr_admi) ");
            query.append("               JOIN zon_secci s ON (t.zscc_oid_secc = s.oid_secc) ");
            query.append("               JOIN zon_zona z ON (s.zzon_oid_zona = z.oid_zona), ");
            query.append("               cra_perio periodoinicio, cra_perio periodoactual ");
            query.append("             WHERE u.perd_oid_peri_ini = periodoinicio.oid_peri ");
            query.append("               AND periodoactual.oid_peri = " + dto.getPeriodo());
            query.append("               AND periodoinicio.marc_oid_marc = periodoactual.marc_oid_marc ");
            query.append("               AND periodoinicio.cana_oid_cana = periodoactual.cana_oid_cana ");
            query.append("               AND periodoinicio.fec_inic <= periodoactual.fec_inic ");
            
            // sapaza -- PER-SiCC-2012-0658 -- 19/07/2012
            //query.append("               AND perd_oid_peri_fin IS NULL ");
            query.append("               AND u.ind_acti = 1 ");
            
            query.append("               AND zorg_oid_regi = "+ dto.getRegion().longValue() +") ");
            query.append("       ) consulta ");
            query.append("   ) consulta2 ");

            resultado = bs.dbService.executeStaticQuery(query.toString() );

        } catch(Exception e) {
            UtilidadesLog.error("No se pudieron recuperar las consultoras para Asignar Estatus");
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info(" DAOMAEEstatusCliente.obtenerClientesActualizarEstatus(DTOCierreRegion): Salida");
        return resultado;
    }
    
   /**
    * Recibe un Hashtable con clientes agrupados en base a su nuevo valor 
    * de estatus. Se obtienen los ultimos registros de Historicos de Estatus de 
    * dichos clientes. Es muy importante que el resultado devuelto esta ordenado
    * por cliente, y por fecha de inicio descendiente (así al recorrerlo si hubiera
    * N registros por cada cliente se tomara solo el primero y mas cercano al 
    * periodo actual).
    * @author eiraola
    * @date 12/Nov/2006
    * @observacion Metodo creado por performance. Basado en obtenerUltimoHistorico
    * pero permite recuperar todos los registros al mismo tiempo (y no cliente a
    * cliente)
    */
    public RecordSet obtenerUltimoHistoricoLoteClientes(Hashtable clientesPorEstatusNuevo, 
            Long periodoActual) throws MareException {
        UtilidadesLog.info("DAOMAEEstatusCliente.obtenerUltimoHistoricoLoteClientes(): Entrada");
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        StringBuffer consulta = new StringBuffer();
        RecordSet historicos = new RecordSet();
        
        try {
            Enumeration oidsEstatusNuevo = clientesPorEstatusNuevo.keys();
            Long oidEstatusNuevo;
            ArrayList clientes;
            int cantClientes;
            Long oidCliente;
            
            // Preparamos la consulta que recupera el ultimo Historico de Estatus de cada cliente
            UtilidadesLog.debug("****** Preparando consulta del Ultimo Historico...");
            consulta.append("SELECT h.clie_oid_clie, h.oid_hist_esta, h.PERD_OID_PERI, i.FEC_INIC ");
            consulta.append("FROM mae_clien_histo_estat h, cra_perio i, cra_perio a ");
            consulta.append("WHERE h.perd_oid_peri_peri_fin IS NULL ");
            consulta.append("AND h.perd_oid_peri = i.oid_peri ");
            consulta.append("AND i.pais_oid_pais = a.pais_oid_pais ");
            consulta.append("AND i.marc_oid_marc = a.marc_oid_marc ");
            consulta.append("AND i.cana_oid_cana = a.cana_oid_cana ");
            consulta.append("AND i.fec_inic <= a.fec_inic ");
            consulta.append("AND a.oid_peri = " + periodoActual + " ");
            
            consulta.append("AND (");                                              // Abro (0)
            
            while (oidsEstatusNuevo.hasMoreElements()) {
                oidEstatusNuevo = (Long)oidsEstatusNuevo.nextElement();
                clientes = (ArrayList)clientesPorEstatusNuevo.get(oidEstatusNuevo);
                oidCliente = (Long)clientes.get(0);
                cantClientes = clientes.size();
                
                consulta.append(" ( h.esta_oid_esta_clie <> " + oidEstatusNuevo);  // Abro (1)
                consulta.append("   AND ( ");                                      // Abro (2)
                consulta.append("        h.clie_oid_clie IN (" + oidCliente);      // Abro (3)
                
                for (int i = 1; i < cantClientes; i++) {
                    oidCliente = (Long)clientes.get(i);
                    consulta.append(", " + oidCliente);
                    if ( i % 999 == 0 && (i + 1) < cantClientes ) {
                        i++;
                        oidCliente = (Long)clientes.get(i);
                        consulta.append(") OR h.clie_oid_clie IN (" + oidCliente);
                    } 
                }
                consulta.append(")");                                             // Cierro (3)
                consulta.append(")");                                             // Cierro (2)
                
                if (oidsEstatusNuevo.hasMoreElements()) {
                    consulta.append(") OR ");
                }
            }
            consulta.append(")");                                                 // Cierro (1)
            consulta.append(")");                                                 // Cierro (0)
            consulta.append(" ORDER BY CLIE_OID_CLIE, FEC_INIC DESC");
            
            // Ejecutamos la consulta para obtener el ultimo historico
            UtilidadesLog.debug("****** Ejecutando Consulta del Ultimo Historico...");
            historicos = bs.dbService.executeStaticQuery(consulta.toString());
            
        } catch (Exception e) {
            UtilidadesLog.error("No se pudieron obtener los registros de Historico Estatus de Cliente");
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEEstatusCliente.obtenerUltimoHistoricoLoteClientes(): Salida");
        return historicos;
    }
    
   /**
    * Recibe un ArrayList con oid de clientes y se recuperan las clasificaciones 
    * de los mismos.
    * @author eiraola
    * @date 12/Nov/2006
    * @observacion Metodo creado por performance. Basado en obtenerUltimoHistorico
    * pero permite recuperar todos los registros al mismo tiempo (y no cliente a
    * cliente)
    */
    public RecordSet obtenerClasificacionesLoteClientes(ArrayList clientes) 
            throws MareException {
        UtilidadesLog.info("DAOMAEEstatusCliente.obtenerClasificacionesLoteClientes(clientes): Entrada");
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        StringBuffer consulta = new StringBuffer();
        RecordSet clasificaciones = new RecordSet();
        
        try {
            int cantClientes = clientes.size();
            Long oidCliente;
            
            UtilidadesLog.debug("****** Preparando la Consulta de Clasificaciones...");
            
            consulta.append("SELECT t.CLIE_OID_CLIE, c.CLAS_OID_CLAS ");
            consulta.append("FROM MAE_CLIEN_CLASI c, MAE_CLIEN_TIPO_SUBTI t ");
            consulta.append("WHERE c.CTSU_OID_CLIE_TIPO_SUBT = t.OID_CLIE_TIPO_SUBT  ");
            oidCliente = (Long)clientes.get(0);
            consulta.append("AND ( t.CLIE_OID_CLIE in ("+ oidCliente);
            
            for (int i = 1; i < cantClientes; i++) {
                oidCliente = (Long)clientes.get(i);
                consulta.append(", " + oidCliente);
                
                if ( i % 999 == 0 && (i + 1) < cantClientes ) {
                    i++;
                    oidCliente = (Long)clientes.get(i);
                    consulta.append(") OR t.CLIE_OID_CLIE in (" + oidCliente);
                } 
            }
            consulta.append(") ) ORDER BY CLIE_OID_CLIE ASC ");
            
            
            // Ejecutamos la consulta para obtener las clasificaciones de los clientes
            UtilidadesLog.debug("****** Ejecutando Consulta de Clasificaciones...");
            clasificaciones = bs.dbService.executeStaticQuery(consulta.toString());
            
        } catch (Exception e) {
            UtilidadesLog.error("No se pudieron obtener las Clasificaciones de Clientes");
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEEstatusCliente.obtenerClasificacionesLoteClientes(clientes): Salida");
        return clasificaciones;
    }
 
    /**
     * Metodo que borra los registros hijos de la tabla (mae_histo_clasi) 
     * cuyo oid padre es de la tabla (mae_clien_histo_estat)
     * 
     * Agregado por HRCS - Fecha 01/03/2007 - Incidencia SICC 20070072
     */
    public void borraClientHistoClasi( Long oidHistoEstatus ) throws MareException{
        UtilidadesLog.info("DAOMAEEstatusCliente.borraClientHistoClasi: " + oidHistoEstatus + " - Entrada");
	  
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM mae_histo_clasi WHERE clhe_oid_hist_esta = " + oidHistoEstatus.longValue() );
    
        try {
            bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEEstatusCliente.borraClientHistoClasi: " + oidHistoEstatus + " - Salida");
    }

    /* Agregado por Brecha BLO-001 ------ jrivas INICIO*/     
     public int recuperarDatosBloqueos(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOMAEEstatusCliente.recuperarDatosBloqueos(Long oidPais): Entrada"); 
        StringBuffer query = new StringBuffer();
        int salida = 0;
        
        query.append("SELECT (SELECT SPIP.IND_EJRN ");
        query.append("          FROM SEG_PARAM_INTER_PAIS SPIP ");
        query.append("         WHERE SPIP.PAIS_OID_PAIS = " + oidPais );
        query.append("         ) IND_EJRN, ");
        query.append("       NVL ((SELECT NVL(MTB.NUM_NIVE_GRAV_BLOQ, 999) ");
        query.append("               FROM MAE_TIPO_BLOQU MTB ");
        query.append("              WHERE MTB.COD_TIPO_BLOQ = 'RN'), 0) NUM_NIVE_GRAV_BLOQ ");
        query.append("  FROM DUAL        ");
        
        RecordSet rs = null;
        rs = this.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio() && rs.getValueAt(0, "IND_EJRN")!= null) {
            salida = ((BigDecimal)rs.getValueAt(0, "NUM_NIVE_GRAV_BLOQ")).intValue();
        }
        UtilidadesLog.info("DAOMAEEstatusCliente.recuperarDatosBloqueos(Long oidPais): Salida " + salida);
        return salida;
     }   
    
     public boolean realizarBloqueos(Long oidPeriodo, Long oidCliente, int nivelBloqueo) throws MareException {
       UtilidadesLog.info("DAOMAEEstatusCliente.realizarBloqueos(Long oidPeriodo, Long oidCliente, int nivelBloqueo): Entrada"); 
       boolean bloqueoRealizado = false;
       
       StringBuffer query = new StringBuffer();
       
       query.append("SELECT MCB.OID_BLOQ, ");
       query.append("	    NVL(MTB.NUM_NIVE_GRAV_BLOQ, 999) - " + nivelBloqueo + " DIF_NIVEL "); 	    
       query.append("FROM MAE_CLIEN_BLOQU MCB, ");
       query.append("     MAE_TIPO_BLOQU MTB ");
       query.append("WHERE MCB.CLIE_OID_CLIE = " + oidCliente);
       query.append("  AND MCB.FEC_DESB IS NULL ");
       query.append("  AND MTB.OID_TIPO_BLOQ = MCB.TIBQ_OID_TIPO_BLOQ ");
    
       RecordSet rs = null;
       rs = this.executeQuery(query.toString());
       
       StringBuffer queryUpdate = new StringBuffer();
       if (rs != null && !rs.esVacio()) {
         if (this.bigDecimalToInteger((BigDecimal)rs.getValueAt(0, "DIF_NIVEL")).intValue() > 0) {
            Long oidBloqueo = this.bigDecimalToLong((BigDecimal)rs.getValueAt(0, "OID_BLOQ"));
            queryUpdate.append(this.armarStringDesbloqueo(oidBloqueo, true).toString());
            queryUpdate.append(this.armarStringBloqueo(oidCliente).toString());
            this.BloqueosIU(queryUpdate);
            bloqueoRealizado = true;
         }   
       } else {
         queryUpdate.append(this.armarStringBloqueo(oidCliente).toString());
         this.BloqueosIU(queryUpdate);
         bloqueoRealizado = true;
       }   
       
       UtilidadesLog.info("DAOMAEEstatusCliente.realizarBloqueos(Long oidPeriodo, Long oidCliente, int nivelBloqueo): Salida");   
       
       return bloqueoRealizado;
     }   
    
    public boolean validarHistoricoEstatus(Long oidPeriodo, Long oidCliente, String codigoEstatus) throws MareException {
        UtilidadesLog.info("DAOMAEEstatusCliente.validarHistoricoEstatus(Long oidPeriodo, Long oidCliente): Entrada"); 
        StringBuffer query2 = new StringBuffer();
        query2.append(" SELECT CHE.OID_HIST_ESTA FROM MAE_CLIEN_HISTO_ESTAT CHE, MAE_ESTAT_CLIEN EC ");
        query2.append(" WHERE CHE.CLIE_OID_CLIE = " + oidCliente);
        query2.append(" AND CHE.PERD_OID_PERI_PERI_FIN IN (" + this.listaPeriodosReingreso + ")");
        query2.append(" AND CHE.ESTA_OID_ESTA_CLIE = EC.OID_ESTA_CLIE ");
        query2.append(" AND EC.COD_ESTA_CLIE = '"+ codigoEstatus +"'");
        
        RecordSet rs2 = null;
        rs2 = this.executeQuery(query2.toString());
        UtilidadesLog.debug("rs2 " + rs2);        
        
        if (rs2 != null && !rs2.esVacio()) {
            UtilidadesLog.info("DAOMAEEstatusCliente.validarHistoricoEstatus(Long oidPeriodo, Long oidCliente): Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("DAOMAEEstatusCliente.validarHistoricoEstatus(Long oidPeriodo, Long oidCliente): Salida FALSE");
            return false;
        }
    }
    
     public void realizarDesbloqueos(Long oidCliente) throws MareException {
       UtilidadesLog.info("DAOMAEEstatusCliente.realizarDesbloqueos(Long oidCliente): Entrada"); 
       
       StringBuffer query = new StringBuffer();
       
       query.append(" SELECT CB.OID_BLOQ ");
       query.append("   FROM MAE_CLIEN_BLOQU CB, MAE_TIPO_BLOQU TB ");
       query.append("  WHERE CB.FEC_DESB IS NULL ");
       query.append("    AND CB.TIBQ_OID_TIPO_BLOQ = TB.OID_TIPO_BLOQ ");
       query.append("    AND TB.COD_TIPO_BLOQ = 'RN' ");
       query.append("    AND CB.CLIE_OID_CLIE = " + oidCliente);
    
       RecordSet rs = null;
       rs = this.executeQuery(query.toString());
       
       StringBuffer queryUpdate = new StringBuffer();
       if (rs != null && !rs.esVacio()) {
            Long oidBloqueo = this.bigDecimalToLong((BigDecimal)rs.getValueAt(0, "OID_BLOQ"));
            queryUpdate.append(this.armarStringDesbloqueo(oidBloqueo, false).toString());
            queryUpdate.append(this.armarStringFechaReingreso(oidCliente));
            this.BloqueosIU(queryUpdate);
       }  
       UtilidadesLog.info("DAOMAEEstatusCliente.realizarDesbloqueos(Long oidCliente): Salida");   
     }       

    private Integer bigDecimalToInteger(BigDecimal number)  {
        if(number == null)
            return null;
    
        return new Integer(number.intValue());
    }
    
    private Long bigDecimalToLong(BigDecimal number) {
        if(number == null)
            return null;
    
        return new Long(number.longValue());
    }    
    
     private void BloqueosIU(StringBuffer queryUpdate) throws MareException {
       try{
          BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", queryUpdate.toString());
       }catch(Exception e){
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
       }    
     }
    
     private StringBuffer armarStringDesbloqueo(Long oidBloqueo, boolean bloqueo) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE MAE_CLIEN_BLOQU SET FEC_DESB = SYSDATE, VAL_USUA_DESB = '" + usuario + "'");
        query.append(", MAAB_OID_VALO_ACCI_DESB = (SELECT OID_VALO_ACCI_BLOQ FROM MAE_VALOR_ACCIO_BLOQU  WHERE COD_VALO_BLOQ = 'A') ");
        if (bloqueo) {
            query.append(", OBS_DESB = 'Bloqueo por Reingreso no Autorizado - Automático' WHERE OID_BLOQ = " + oidBloqueo + ";");
        } else {
            query.append(", OBS_DESB = 'DesBloqueo por Reingreso no Autorizado - Automático' WHERE OID_BLOQ = " + oidBloqueo + ";");
        }
        return query;
     }  
    
     private StringBuffer armarStringBloqueo(Long oidCliente) {
        StringBuffer query = new StringBuffer();
        
        query.append("INSERT INTO MAE_CLIEN_BLOQU (OID_BLOQ, CLIE_OID_CLIE, TIBQ_OID_TIPO_BLOQ, FEC_BLOQ, VAL_USUA_BLOQ, VAL_MOTI_BLOQ, MAAB_OID_VALO_ACCI_BLOQ, OBS_BLOQ)"); 
        query.append("VALUES (MAE_CLBL_SEQ.NEXTVAL,  "+ oidCliente + ", (SELECT MTB.OID_TIPO_BLOQ FROM MAE_TIPO_BLOQU MTB WHERE MTB.COD_TIPO_BLOQ = 'RN'), SYSDATE, ");
        query.append("'" + usuario + "', 'Bloqueo por Reingreso no Autorizado - Automático', (SELECT OID_VALO_ACCI_BLOQ FROM MAE_VALOR_ACCIO_BLOQU  WHERE COD_VALO_BLOQ = 'A'), ");
        query.append("'Bloqueo por Reingreso no Autorizado - Automático');");
        
        return query;
     }  
     
     private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("DAOMAEEstatusCliente.executeQuery(String query): Entrada");
        RecordSet rs = null;
        
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }       
        UtilidadesLog.info("DAOMAEEstatusCliente.executeQuery(String query): Salida");  
        return rs;
      } 
    /* Agregado por Brecha BLO-001 ------ jrivas FIN*/     
    
    /**
    * Sistema:     Belcorp
    * Modulo:      MAE
    * Fecha:       17/01/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Cambio SiCC20070461 MAE
    */
  public RecordSet validarIndEvaluarEstatus(ArrayList oidTiposClientes) throws MareException {
      UtilidadesLog.info("DAOMAEEstatusCliente.validarIndEvaluarEstatus(ArrayList oidTiposClientes): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      int cantValores = oidTiposClientes.size();
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
  
      query.append(" select tipoCli.OID_TIPO_CLIE ");
      query.append(" from MAE_TIPO_CLIEN tipoCli ");
      query.append(" where tipoCli.IND_EVAL_ESTA = 1 ");
      query.append(" and tipoCli.OID_TIPO_CLIE in ( ");
                
      for (int i = 0; i < cantValores; i++) {
          if ( (i+1) < cantValores ) {
              if ((i+1)%1000 == 0) {
                  query.append(oidTiposClientes.get(i) + ") OR tipoCli.OID_TIPO_CLIE IN (");
              } else {
                  query.append(oidTiposClientes.get(i) + ",");
              }
          } else {
              query.append(oidTiposClientes.get(i));
          }
      }
      
      query.append(")");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
    
      UtilidadesLog.info("DAOMAEEstatusCliente.validarIndEvaluarEstatus(ArrayList oidTiposClientes): Salida");
      return rs;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      MAE
    * Fecha:       17/01/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Cambio SiCC20070461 MAE
    */
  public RecordSet verificaHistoricoEstatus(Long oidCliente) throws MareException {
      UtilidadesLog.info("DAOMAEEstatusCliente.verificaHistoricoEstatus(Long oidCliente): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
  
      query.append(" select hist.OID_HIST_ESTA ");
      query.append(" from MAE_CLIEN_HISTO_ESTAT hist ");
      query.append(" where hist.CLIE_OID_CLIE =" + oidCliente);
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
    
      UtilidadesLog.info("DAOMAEEstatusCliente.verificaHistoricoEstatus(Long oidCliente): Salida");
      return rs;
  }
  
  /**
   * Sistema: Belcorp
   * Módulo:  MAE
   * Fecha:   29/01/2008
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Cambio 20070458
   */
  public DTOSalida obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe) throws MareException {
      UtilidadesLog.info("DAOMAEEstatusCliente.obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      DTOSalida dtoSalida = new DTOSalida();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
  
      SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
      Timestamp date = new Timestamp(System.currentTimeMillis());

      //hacemos la consulta usando JDBC
      query.append(" select P.OID_PERI, p.VAL_NOMB_PERI ");
      query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
      query.append(" where FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') and to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') <= FEC_FINA ");
      query.append(" and PAIS_OID_PAIS = " + dtoe.getOidPais());
      //Si el oid de la marca es 0, metadato todos, entonces se omite el filtro de marca
      if (dtoe.getMarca().longValue() != 0) query.append(" and MARC_OID_MARC = " + dtoe.getMarca());
      query.append(" and CANA_OID_CANA = " + dtoe.getCanal());
      query.append(" and P.PERI_OID_PERI = PC.OID_PERI ");
      query.append(" ORDER BY FEC_INIC ");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
      
      dtoSalida.setResultado(rs);
    
      UtilidadesLog.info("DAOMAEEstatusCliente.obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe): Salida");
      return dtoSalida;
  }
  
  
  /**
   * Sistema: Belcorp
   * Módulo:  MAE
   * Fecha:   30/01/2008
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Cambio 20070458
   */
  public DTOOIDs obtieneRegiones(DTOFACCierreFacturacion dtoe) throws MareException {
      UtilidadesLog.info("DAOMAEEstatusCliente.obtieneRegiones(DTOFACCierreFacturacion dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      DTOOIDs oidRegiones = new DTOOIDs();
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      //hacemos la consulta usando JDBC
      query.append(" SELECT cierre.ZORG_OID_REGI ");
      query.append(" FROM FAC_CONTR_CIERR cierre, FAC_TIPOS_CIERR tipoCierre ");
      query.append(" WHERE cierre.TCIE_OID_TIPO_CIER = tipoCierre.OID_TIPO_CIER ");
      query.append(" and tipoCierre.COD_TIPO_CIER = '" + ConstantesFAC.TIPO_CIERRE_REGION + "' ");
      query.append(" and cierre.PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" and cierre.PERD_OID_PERI = " + dtoe.getPeriodo());
      query.append(" and cierre.VAL_PROC_EJEC = '" + ConstantesMAE.PROC_ASIG_ESTATUS_LOTES + "' ");
      query.append(" and cierre.VAL_RESU_PROC = '" + ConstantesFAC.PROCESO_CIERRE_OK + "' ");    
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
      
      int cantReg = rs.getRowCount();
      Long[] oidRegArray = new Long[cantReg];
      
      for(int i=0; i <cantReg; i++){
           oidRegArray[i] = Long.valueOf(((BigDecimal)rs.getValueAt(i,"ZORG_OID_REGI")).toString());
      }
      
      oidRegiones.setOids(oidRegArray);
    
      UtilidadesLog.info("DAOMAEEstatusCliente.obtieneRegiones(DTOFACCierreFacturacion dtoe): Salida");
      return oidRegiones;
  }
  
  /**
   * Sistema: Belcorp
   * Módulo:  MAE
   * Fecha:   4/02/2008
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Cambio 20070458
   */
  public void activarConsultoras(DTOFACCierreFacturacion dtoe) throws MareException {
      UtilidadesLog.info("DAOMAEEstatusCliente.activarConsultoras(DTOFACCierreFacturacion dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      DTOOIDs oidRegiones = new DTOOIDs();
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      //hacemos la consulta usando JDBC
      query.append(" UPDATE MAE_CLIEN_DATOS_ADICI datosAdic ");
      query.append(" SET datosAdic.IND_ACTI = 1 ");
      query.append(" where datosAdic.IND_ACTI = 0 ");
      query.append(" and exists(select 1 ");
      query.append(" from PED_SOLIC_CABEC ped ");
      query.append(" where ped.CLIE_OID_CLIE = datosAdic.CLIE_OID_CLIE ");
      query.append(" and ped.PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" and ped.PERD_OID_PERI = " + dtoe.getPeriodo());
      query.append(" and ped.FEC_FACT IS NOT NULL");
      query.append(" and ped.IND_OC = 1 ");
      query.append(" and ped.IND_TS_NO_CONSO = 1 ");
      query.append(" and ped.MODU_OID_MODU != " + ConstantesSEG.MODULO_REC);
      query.append(" and ped.IND_PEDI_PRUE != 1) ");         
      
      try {
          int cant = bs.dbService.executeUpdate(query.toString());
          UtilidadesLog.debug("actualizo: " + cant); 
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOMAEEstatusCliente.activarConsultoras(DTOFACCierreFacturacion dtoe): Salida");
  }

  // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
  public void cargarListaPeriodos(Long oidPeriodo, int numeroCampanas) throws MareException {
      UtilidadesLog.info("DAOMAEEstatusCliente.cargarListaPeriodos(Long oidPeriodo, int numeroCampanas): Entrada"); 
      
      StringBuffer query = new StringBuffer();
      StringBuffer salida = new StringBuffer();
      
      query.append(" SELECT CP2.OID_PERI ");
      query.append("    FROM CRA_PERIO CP, CRA_PERIO CP2 ");
      query.append("   WHERE CP.OID_PERI = " + oidPeriodo);
      query.append("     AND CP.PAIS_OID_PAIS = CP2.PAIS_OID_PAIS ");
      query.append("     AND CP.MARC_OID_MARC = CP2.MARC_OID_MARC ");
      query.append("     AND CP.CANA_OID_CANA = CP2.CANA_OID_CANA ");
      query.append("     AND CP2.FEC_INIC <= CP.FEC_INIC ");
      query.append(" ORDER BY CP2.FEC_INIC DESC ");
      
      RecordSet rs = null;
      rs = this.executeQuery(query.toString());
      
      if (rs != null && !rs.esVacio()) {
          int i = 0;
          while (i < numeroCampanas && rs.existeFila(i)) {
              salida.append(rs.getValueAt(i, "OID_PERI"));
              i++;
              if (i < numeroCampanas && rs.existeFila(i)) { 
                  salida.append(", ");
              }
          }
      }
      
      this.listaPeriodosReingreso = salida.toString();
      UtilidadesLog.debug("listaPeriodosReingreso: " + this.listaPeriodosReingreso); 
      
      UtilidadesLog.info("DAOMAEEstatusCliente.cargarListaPeriodos(Long oidPeriodo, int numeroCampanas): Entrada"); 
  }

    // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
    public int recuperarNumeroPeriodosReingreso(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOMAEEstatusCliente.recuperarNumeroPeriodosReingreso(Long oidPais): Entrada"); 
        StringBuffer query = new StringBuffer();
        int salida = 0;
        
        query.append("SELECT NUM_PERI_REIN ");
        query.append("  FROM SEG_PAIS ");
        query.append(" WHERE OID_PAIS = " + oidPais);
        
        RecordSet rs = null;
        rs = this.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio()) {
            salida = ((BigDecimal)rs.getValueAt(0, "NUM_PERI_REIN")).intValue();
        }
        UtilidadesLog.info("DAOMAEEstatusCliente.recuperarNumeroPeriodosReingreso(Long oidPais): Salida " + salida);
        return salida;
    }   

    private String armarStringFechaReingreso(Long oidCliente) {
       String query = "UPDATE MAE_CLIEN SET FEC_REIN = NULL WHERE OID_CLIE = " + oidCliente + ";";
       return query;
    }  
    
}
    
