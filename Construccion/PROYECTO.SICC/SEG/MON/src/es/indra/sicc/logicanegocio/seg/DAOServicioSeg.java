package es.indra.sicc.logicanegocio.seg;



import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;



public class DAOServicioSeg  {
	public DAOServicioSeg() {
	}

/** DAOServicioSEG.obtenerPeriodosPorCanal(dto : DTOOID) : DTOSalida */ 
/*
Entrada: 
- dto : DTOOID (oid de canal) 
Proceso: 
-> Hacer consulta JDBC sobre la tabla SEG_PERIO_CORPO para obtener todos sus campos, incluída la descripción internacionalizada, para los siguientes criterios: 
-> Cruzar la tabla SEG_PERIO_CORPO con la tabla SEG_TIPO_PERIO y esta a su vez con SEG_CANAL 
-> SEG_CANAL.OID_CANA = dto.oid 
-> Devolver RecordSet obtenido encapsulado en un objeto DTOSalida
*/

	public DTOSalida obtenerPeriodosPorCanal(DTOOID dtoin) throws MareException {
        UtilidadesLog.info("DAOServicioSEG.obtenerPeriodosPorCanal(DTOOID):Entrada");
        RecordSet rs;
		
        BelcorpService bs = getBelcorpService();

        StringBuffer query = new StringBuffer();

        /*
          Cambio realizado el 25/10/2004 por Hugo Mansi (hmansi)
		  Por incidencia 9451 se cambió la siguiente linea para que el select solo devuelva los campos
          OID_PERI y COD_PERI, y no como indicaba la incidencia 8073 en donde se pedían todos los campos.
    	  query.append(" SELECT SEG_PERIO_CORPO.* ");
        */

  		query.append(" SELECT SEG_PERIO_CORPO.OID_PERI, SEG_PERIO_CORPO.COD_PERI ");
		query.append(" FROM SEG_CANAL, SEG_TIPO_PERIO, SEG_PERIO_CORPO ");
		query.append(" WHERE ( (SEG_TIPO_PERIO.OID_TIPO_PERI = SEG_CANAL.TIPE_OID_TIPO_PERI) AND ");
		query.append(" (SEG_TIPO_PERIO.OID_TIPO_PERI = SEG_PERIO_CORPO.TIPE_OID_TIPO_PERI) AND ");
		query.append(" (SEG_CANAL.OID_CANA = " + dtoin.getOid() + ") )");
        query.append(" ORDER BY seg_perio_corpo.cod_peri");
		
        try {            

            rs = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            if (e instanceof MareException) {
               UtilidadesLog.error(((MareException) e).getOriginalCause());
                throw (MareException) e;
            } else {
                UtilidadesLog.error(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("DAOServicioSEG.obtenerPeriodosPorCanal(DTOOID):Salida");
		return dtoSalida;
	}

	private BelcorpService getBelcorpService() throws MareException{

        try {
            BelcorpService bs = BelcorpService.getInstance();
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
		
	}

	public DTOOID obtenerOIDMonedaAltPais(Long oidPais, String codigoMonedaAlt) throws MareException {
        UtilidadesLog.info("DAOServicioSEG.obtenerOIDMonedaAltPais(Long, String):Entrada");
		RecordSet rs;
		
        BelcorpService bs = getBelcorpService();

        StringBuffer query = new StringBuffer();
		query.append(" SELECT mone_oid_mone_alt moneda ");
		query.append(" FROM seg_pais p, seg_moned m ");
		query.append(" WHERE p.mone_oid_mone_alt = m.oid_mone ");
		query.append(" AND p.oid_pais = " + oidPais );
		query.append(" AND m.COD_MONE = '" + codigoMonedaAlt + "'");
		
		DTOOID dto = new DTOOID();
        try {            

            rs = bs.dbService.executeStaticQuery(query.toString());			

			if (!rs.esVacio()){				
				dto.setOid(new Long (rs.getRow(0).get(0).toString()));
			}

        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error(((MareException) e).getOriginalCause());
                throw (MareException) e;
            } else {
                UtilidadesLog.error(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
		UtilidadesLog.info("DAOServicioSEG.obtenerOIDMonedaAltPais(Long, String):Salida");
		return dto;

	}		


/*Autor Marta Aurora Montiel
 * 29/03/05
 * Incidencia BELC300015496
 * */
  public DTOSalida obtenerMonedasPorPais(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("DAOServicioSEG.obtenerMonedasPorPais(DTOBelcorp):Entrada");
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();
        DTOSalida out = new DTOSalida();
        try{
            belcorpService = BelcorpService.getInstance();
            query.append(" SELECT B.OID_MONE, D.VAL_I18N ");
            query.append(" FROM SEG_PAIS A, SEG_MONED B, V_GEN_I18N_SICC D ");
            query.append(" WHERE A.OID_PAIS =  " + dto.getOidPais());
            query.append(" AND A.MONE_OID_MONE = B.OID_MONE ");
            query.append(" AND B.OID_MONE = D.VAL_OID ");
            query.append(" AND D.ATTR_NUM_ATRI = 1  ");
            query.append(" AND D.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND D.ATTR_ENTI = 'SEG_MONED' " );
            query.append(" UNION ");
            query.append(" SELECT C.OID_MONE, E.VAL_I18N ");
            query.append(" FROM SEG_PAIS A, ");
            query.append(" SEG_MONED C, ");
            query.append(" V_GEN_I18N_SICC E ");
            query.append(" WHERE A.OID_PAIS =  " + dto.getOidPais());
            query.append(" AND A.MONE_OID_MONE_ALT = C.OID_MONE ");
            query.append(" AND C.OID_MONE = E.VAL_OID ");
            query.append(" AND E.ATTR_NUM_ATRI = 1  ");
            query.append(" AND E.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND E.ATTR_ENTI = 'SEG_MONED' ");            
            
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            
        }catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        out.setResultado(rs);
        UtilidadesLog.info("DAOServicioSEG.obtenerMonedasPorPais(DTOBelcorp):Salida");
    return out; 
  }
  
    /**
     * @author mmaidana
     * @date 21/09/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * Creado por incidencia 23152
     */
    public DTOSalida obtenerOidCanalAccesoSubAcceso() throws MareException {
        UtilidadesLog.info("DAOServicioSEG.obtenerOidCanalAccesoSubAcceso():Entrada");
  
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();
        DTOSalida out = new DTOSalida();
  
        try{
            belcorpService = BelcorpService.getInstance();
            query.append("SELECT C.OID_CANA CANAL, A.OID_ACCE ACCESO, S.OID_SBAC SUBACCESO ");
            query.append("FROM SEG_CANAL C, SEG_ACCES A, SEG_SUBAC S ");
            query.append("WHERE C.OID_CANA = A.CANA_OID_CANA ");
            query.append("AND A.OID_ACCE = S.ACCE_OID_ACCE ");
            query.append("AND C.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD + "'");
            query.append(" AND A.COD_ACCE = '" + ConstantesSEG.ACCESO_GERENTES + "'");
            query.append(" AND S.COD_SBAC = '" + ConstantesSEG.SUBAC_GERENTES + "'");
            UtilidadesLog.debug(query.toString());
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        }catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        out.setResultado(rs);
        
        UtilidadesLog.info("DAOServicioSEG.obtenerOidCanalAccesoSubAcceso():Salida");
        
        return out; 
    }
  
  
}