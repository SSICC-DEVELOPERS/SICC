/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 * @autor: Cnoziglia
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 * 
 */


package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOGerenteConcurso;
import es.indra.sicc.dtos.inc.DTOMetTipVtaPag;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


public class DAOMetas {
    public DAOMetas() {
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param ArrayList concursos, Periodo periodo
     * @return ArrayList
     * @documentation Accedemos a la tabla de INC SolicitudConcursoPuntaje de 
     * donde tendremos que recuperar los oidGerentes con el oidConcurso de cada 
     * registro que cumplan con alguno de los oidConcursos de concursos. y
     * oidPeriodo. Tendremos que crear por cada pareja oidGerente oidConcurso
     * (omitir las parejas repetidas) un objeto DTOGerenteConcurso y 
     * devolverlos todos en un ArrayList.
     *
     * @date 01/06/05
     * Modificado: Carlos Leal 8/7/2005
     */
    public ArrayList recuperarClientesConcursos(ArrayList concursos,
        Periodo periodo) throws MareException {
        UtilidadesLog.info("DAOMetas.recuperarClientesConcursos(ArrayList "
            +"concursos, Periodo periodo):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            if (!concursos.isEmpty()) {
                buf.append(
                    " SELECT DISTINCT CLIE_OID_CLIE_GERE, COPA_OID_PARA_GRAL");
                buf.append(" FROM INC_SOLIC_CONCU_PUNTA ");
                buf.append(" WHERE PERD_OID_PERI = " + 
                    periodo.getOidPeriodo());
                buf.append(" AND COPA_OID_PARA_GRAL IN (");
                Iterator it = concursos.iterator();
                while (it.hasNext()) {
                    buf.append(((Concurso) it.next()).getOidConcurso());

                    if (it.hasNext()) {
                        buf.append(", ");
                    }
                }
                buf.append(")");
                //Inc 20334
                buf.append(" AND CLIE_OID_CLIE_GERE IS NOT NULL ");

                rs = bs.dbService.executeStaticQuery(buf.toString());
                UtilidadesLog.debug("rs: " + rs);

                if (!rs.esVacio()) {
                    ArrayList respuesta = new ArrayList();

                    for (int i = 0; i < rs.getRowCount(); i++) {
                        DTOGerenteConcurso dtogerenteconcu = new DTOGerenteConcurso();
                        dtogerenteconcu.setOidConcurso(new Long(
                                ((BigDecimal) rs.getValueAt(i,
                                    "COPA_OID_PARA_GRAL")).longValue()));
                        dtogerenteconcu.setOidGerente(new Long(
                                ((BigDecimal) rs.getValueAt(i,
                                    "CLIE_OID_CLIE_GERE")).longValue()));
                        respuesta.add(dtogerenteconcu); //Cleal 29/07/2005
                    }

                    UtilidadesLog.info("DAOMetas.recuperarClientesConcursos("
                        +"ArrayList concursos, Periodo periodo):Salida");

                    return respuesta;
                } else {
                    UtilidadesLog.debug("Para el periodo y los concursos en no"
                        +"hay datos en INC_SOLIC_CONCU_PUNTA");
                    UtilidadesLog.info("DAOMetas.recuperarClientesConcursos("
                        +"ArrayList concursos, Periodo periodo):Salida");

                    return new ArrayList();
                }
            } else {
                UtilidadesLog.debug("No vienen concursos para obtenr los "
                    +"clientes");
                UtilidadesLog.info("DAOMetas.recuperarClientesConcursos(Array"
                    +"List concursos, Periodo periodo):Salida");

                return new ArrayList();
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Concurso concurso, Long oidCliente
     * @return Float
     * @documentation Se accede a la tabla Metas Tipo Venta y se filtra por 
     * oidCliente y oidConcurso para recuperar el campo Meta.
     * Se devuelve (Meta/concurso.FactorConversion*concurso.PuntosAAsignar)
     *
     * @date 01/06/05
     *
     */
    public Float recuperarMetas(Concurso concurso, Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOMetas.recuperarMetas(Concurso concurso, Long "
            +"oidCliente):Entrada");

        Float metas;
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT VAL_META ");
            buf.append("FROM INC_METAS_TIPO_VENTA ");
            buf.append("WHERE CLIE_OID_CLIE =").append(oidCliente);
            buf.append(" AND COPA_OID_PARA_GRAL =").append(concurso
                .getOidConcurso());
            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("rs: " + rs);

            if ((rs == null) || rs.esVacio()) {
                UtilidadesLog.info("DAOMetas.recuperarMetas(Concurso concurso,"
                    +"Long oidCliente):Salida");

                return new Float(0);
            } else {
                metas = new Float(((BigDecimal) rs.getValueAt(0, "VAL_META"))
                    .doubleValue());
                UtilidadesLog.debug("Concurso Factor de conversion: " +
                    concurso.getFactorConversion());
                UtilidadesLog.debug("Concurso Puntos a asignar: " +
                    concurso.getPuntosAsignar());

                //Inc 20381
                if ((concurso.getFactorConversion().doubleValue() != 0) &&
                        (concurso.getPuntosAsignar().doubleValue() != 0)) {
                    metas = new Float(metas.floatValue() / (concurso
                        .getFactorConversion().doubleValue() * concurso
                            .getPuntosAsignar().doubleValue()));
                } else {
                    metas = new Float(0);
                }
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMetas.recuperarMetas(Concurso concurso, Long "
            +"oidCliente):Salida");

        return metas;
    }

    /**
    * Fecha de Creacion: 18/05/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo obtiene el total de puntos de un cliente
    *
    */
    public Float obtenerSaldoPuntos(Long oidCliente, Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOMetas.obtenerSaldoPuntos(Long oidCliente, "
            +"Long oidConcurso):Entrada");

        Float metas;
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT SUM(NUM_PUNT) puntosObtendidos");
            buf.append(" FROM INC_CUENT_CORRI_PUNTO");
            buf.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
            buf.append(" AND COPA_OID_PARA_GRAL = " + oidConcurso);

            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("rs: " + rs);

            if (rs.getValueAt(0, "puntosObtendidos") == null) {
                //rs.esVacio() || rs == null){
                UtilidadesLog.info("DAOMetas.obtenerSaldoPuntos(Long oidClien"
                    +"te, Long oidConcurso):Salida");

                return new Float(0);
            } else {
                UtilidadesLog.info("DAOMetas.obtenerSaldoPuntos(Long oidClien"
                    +"te, Long oidConcurso):Salida");

                return new Float(((BigDecimal) rs.getValueAt(0,
                        "puntosObtendidos")).floatValue());
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

  /**
   * Obtiene las metas por tipo de venta para un determinado concurso
   * 
   * @param oidConcurso OID del concurso por el que se consulta
   * @throws es.indra.mare.common.exception.MareException
   * @author Rafael Romero
   * @date 
   * @return RecordSet con las Metas Tipo Venta
   */
    public RecordSet obtenerMetasTipoVentaPorConcurso(Long oidConcurso)
        throws MareException {

        UtilidadesLog.info(" DAOMetas.obtenerMetasTipoVentaPorConcurso("
            +"Long oidConcurso):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        
        /*
        query.append(" SELECT OID_META_TIPO_VENTA, IMP_MONTO_VENTA, ");
        query.append("   NUM_UNID_VEND, VAL_INCR, VAL_META, CLIE_OID_CLIE, ");
        query.append("   COPA_OID_PARA_GRAL ");
        query.append(" FROM INC_METAS_TIPO_VENTA");
        query.append(" WHERE COPA_OID_PARA_GRAL = "+oidConcurso.longValue()+" ");
        */
        
        query.append(" SELECT METATPVTA.OID_META_TIPO_VENTA, ");
        query.append("        METATPVTA.IMP_MONTO_VENTA, ");
        query.append("        METATPVTA.NUM_UNID_VEND, ");
        query.append("        METATPVTA.VAL_INCR, ");
        query.append("        METATPVTA.VAL_META, ");
        query.append("        METATPVTA.CLIE_OID_CLIE, ");
        query.append("        CLIE.COD_CLIE ");
        query.append("   FROM INC_METAS_TIPO_VENTA METATPVTA, MAE_CLIEN CLIE ");
        query.append("  WHERE METATPVTA.CLIE_OID_CLIE = CLIE.OID_CLIE ");
        query.append("    AND COPA_OID_PARA_GRAL = "+oidConcurso.longValue()+" ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info(" DAOMetas.obtenerMetasTipoVentaPorConcurso("
            +"Long oidConcurso):Salida");
            
        return rs;
    }

    /**
     * Metodo para obtener registros para el paginado de Metas por tipo de venta por cliente
     * @throws es.indra.mare.common.exception.MareException
     * @return Objeto con los registros a mostrar en el paginado
     * @param dtoe Datos para la consulta
     * @author Rafael Romero
     * @date 24-01-2007
     */
	public DTOSalida consultaMetasTipoVenta (DTOMetTipVtaPag dtoe) throws MareException {
		UtilidadesLog.info(" DAOMetas.consultaMetasTipoVenta(DTOMetTipVtaPag dtoe): Entrada");		

		Vector parametros = new Vector();
		StringBuffer consulta=new StringBuffer();

        consulta.append(" SELECT METATPVTA.OID_META_TIPO_VENTA OID, ");
        consulta.append("        METATPVTA.OID_META_TIPO_VENTA OIDMTV, ");
        consulta.append("        METATPVTA.CLIE_OID_CLIE OIDCLI, ");
        consulta.append("        CLIE.COD_CLIE CODCLI, ");
        consulta.append("        METATPVTA.VAL_META VALMETA ");
        consulta.append("   FROM INC_METAS_TIPO_VENTA METATPVTA, MAE_CLIEN CLIE ");
        consulta.append("  WHERE METATPVTA.CLIE_OID_CLIE = CLIE.OID_CLIE ");
        consulta.append("    AND METATPVTA.COPA_OID_PARA_GRAL = ? ");
        parametros.add(dtoe.getOidConcurso());
        if(dtoe.getCodCliente()!=null){
            consulta.append("    AND CLIE.COD_CLIE = ? ");
            parametros.add(dtoe.getCodCliente());
        }

		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoe);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql,parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("consultaAptas: Exception",e);
			       throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

        UtilidadesLog.debug("Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
		// Se crea un DTOSalida a partir del RecordSet
		DTOSalida dtoSalida = new DTOSalida(rs);
	
		UtilidadesLog.info(" DAOMetas.consultaMetasTipoVenta(DTOMetTipVtaPag dtoe): Salida");		
		return dtoSalida;
	}
    
     /**
     * Metodo para verificar si hay metas por tipo de venta para un concurso
     * @param oidConcurso OID del concurso
     * @return Boolean indicando si hay metas por tipo de venta
     * @throws es.indra.mare.common.exception.MareException
     * @author Rafael Romero
     * @date 24-01-2007
     */
	public Boolean existenMetasTipoVenta (Long oidConcurso) throws MareException {
		UtilidadesLog.info("DAOMetas.existenMetasTipoVenta(Long oidConcurso): Entrada --- oidConcurso["+oidConcurso+"]");
        Boolean retorno = Boolean.FALSE;
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        
        if(oidConcurso!=null){
            query.append("SELECT COUNT (oid_meta_tipo_venta) cnt ");
            query.append("  FROM inc_metas_tipo_venta metatpvta ");
            query.append(" WHERE copa_oid_para_gral = "+oidConcurso.longValue()+" ");
    
            try {
                RecordSet rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
                if(((BigDecimal)rs.getValueAt(0, "CNT")).longValue()>0) 
                retorno = Boolean.TRUE;
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        
		UtilidadesLog.info("DAOMetas.existenMetasTipoVenta(Long oidConcurso): Salida --- retorno["+retorno.booleanValue()+"]");
        return retorno;
    }
}