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
 
package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOAsignacionImpresoras;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOAsignacionImpresoras 
{
    public DTOSalida obtenerImpresorasVirtuales () throws MareException
    {
        UtilidadesLog.info("DAOAsisgnacionImpresoras.obtenerImpresorasVirtuales(): Entrada");
        StringBuffer sql = new StringBuffer();
        
        sql.append (" SELECT OID_IMPR, DES_IMPR ");
        sql.append (" FROM FAC_IMPRE_VIRTU ");
        sql.append (" WHERE IND_ESTA_ACTI = 1 ");
        sql.append (" ORDER BY DES_IMPR ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerImpresorasVirtuales: Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.debug("Recordset recibido: " + rs);
        
        DTOSalida dtoSalida = new DTOSalida();
        
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOAsisgnacionImpresoras.obtenerImpresorasVirtuales(): Salida");
        return dtoSalida;
    }
    
    public DTOSalida consultarAsignacionImpresoras (DTOAsignacionImpresoras DTOE)throws MareException
    {
        UtilidadesLog.info("DAOAsisgnacionImpresoras.consultarAsignacionImpresoras(DTOAsignacionImpresoras DTOE): Entrada");
        StringBuffer sql = new StringBuffer();
        
        sql.append (" SELECT * ");
        sql.append (" FROM ");
        sql.append (" (SELECT ROWNUM OID, tabla.* ");
        sql.append (" FROM ");
		sql.append (" ( ");
        
        sql.append (" SELECT ASIG.OID_ASIG_IMPR, IMPRE.OID_IMPR, IMPRE.DES_IMPR, CANAL.OID_CANA,  ");
        
        sql.append (" (SELECT VAL_I18N  ");
        sql.append (" FROM V_GEN_I18N_SICC  ");
        sql.append (" WHERE canal.OID_CANA = VAL_OID  ");
        sql.append (" AND ATTR_ENTI = 'SEG_CANAL'  ");
        sql.append (" AND IDIO_OID_IDIO = " + DTOE.getOidIdioma() );
        sql.append (" ) canal,  ");
        
        sql.append (" acceso.OID_ACCE, "); 
        
        sql.append (" (SELECT VAL_I18N  ");
        sql.append (" FROM V_GEN_I18N_SICC  ");
        sql.append (" WHERE acceso.OID_ACCE = VAL_OID  ");
        sql.append (" AND ATTR_ENTI = 'SEG_ACCES'  ");
        sql.append (" AND IDIO_OID_IDIO = " + DTOE.getOidIdioma() ); 
        
        sql.append (" )acceso,  ");
        
        sql.append (" subac.OID_SBAC,  ");
        
        sql.append (" (SELECT VAL_I18N  ");
        sql.append (" FROM V_GEN_I18N_SICC  ");
        sql.append (" WHERE subac.OID_SBAC = VAL_OID  ");
        sql.append (" AND ATTR_ENTI = 'SEG_SUBAC'  ");
        sql.append (" AND IDIO_OID_IDIO =" + DTOE.getOidIdioma());
        
        sql.append (" ) subacceso,  ");
        
        sql.append (" formu.OID_form,formu.VAL_NOMB_FORM  ");
        
        // dmorello, 29/08/2006: Para evitar el cartel de error cuando se intenta
        // avanzar a la página siguiente y no hay más datos que mostrar
        sql.append (" , COUNT(*) OVER() AS TOTAL_LINEAS ");
        
        sql.append (" FROM FAC_ASIGN_IMPRE asig, SEG_SUBAC subac, SEG_ACCES acceso, SEG_CANAL canal, FAC_IMPRE_VIRTU impre, FAC_FORMU formu ");
        sql.append (" WHERE ASIG.IMVI_OID_IMPR = IMPRE.OID_IMPR ");
        sql.append (" AND ASIG.SBAC_OID_SBAC = SUBAC.OID_SBAC ");
        sql.append (" AND SUBAC.ACCE_OID_ACCE = ACCESO.OID_ACCE ");
        sql.append (" AND ACCESO.CANA_OID_CANA = CANAL.OID_CANA ");
        sql.append (" AND asig.FORS_OID_FORM = formu.OID_form ");

        
        if (DTOE.getFormulario() != null)
        {
            sql.append (" AND FORMU.OID_form = " + DTOE.getFormulario());    
        }
        
        if (DTOE.getImpresoraVirtual() != null)
        {
            sql.append (" AND IMPRE.OID_IMPR = " + DTOE.getImpresoraVirtual());
        }
        
        if (DTOE.getCanal() != null) {
            sql.append(" AND CANAL.OID_CANA =  " + DTOE.getCanal());
        }
        
        if (DTOE.getAcceso() != null) {
            sql.append(" AND ACCESO.OID_ACCE =  " + DTOE.getAcceso());
        }
        
        if (DTOE.getSubAcceso() != null)
        {
            sql.append (" AND SUBAC.OID_SBAC = " + DTOE.getSubAcceso());
        }
        
        sql.append (" ORDER BY DES_IMPR, CANAL, ACCESO, SUBACCESO, VAL_NOMB_FORM ");
        sql.append (" ) tabla ) ");
		
        sql.append (" WHERE ROWNUM <=  " + DTOE.getTamanioPagina());
        sql.append (" AND OID>  " + DTOE.getIndicadorSituacion());
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("consultarAsignacionImpresoras: Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    
    if (rs.esVacio()) {
      codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
      throw new MareException((Exception)null, UtilidadesError.armarCodigoError(codigoError));
    }
        
        DTOSalida dtoSalida = new DTOSalida();
        
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOAsisgnacionImpresoras.consultarAsignacionImpresoras(DTOAsignacionImpresoras DTOE): Salida");
        return dtoSalida;
    }
}