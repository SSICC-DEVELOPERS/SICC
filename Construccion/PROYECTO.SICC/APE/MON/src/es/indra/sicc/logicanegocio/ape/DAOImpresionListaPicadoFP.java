/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOBusquedaListaPicadoFP;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;

public class DAOImpresionListaPicadoFP  {
     /**
     * Recupera Lista Picado cabecera
     * que indique el DTO de entrada.
     * @author hhernandez
     * @since 01/03/2007
     */
    public DTOSalida buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFP dtoE) throws MareException {
        UtilidadesLog.info("DAOImpresionListaPicadoFP.buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFP dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("		SELECT lis.oid_list_pica_cabe OID, lis.cod_list_pica, lis.fec_crea, ");
        query.append("		m.des_marc, c.cod_cana, z.cod_zona, s.cod_secc, lis.ind_impr, ");
        query.append("		lis.ccdi_oid_conf_cent_dist, p.pais_oid_pais ");
        query.append("		FROM ape_lista_picad_cabec lis, ");
        query.append("		cra_perio p, ");
        query.append("		seg_marca m, ");
        query.append("		seg_canal c, ");
        query.append("		zon_zona z, ");
        query.append("		zon_secci s ");
        query.append("		WHERE 1=1 ");
        
        if (dtoE.getOidZona() != null) {
          query.append("			AND lis.ZZON_OID_ZONA =  ");
          query.append(dtoE.getOidZona());
        }
        if (dtoE.getOidSeccion() != null) {
          query.append("			AND lis.ZSCC_OID_SECC = ");
          query.append(dtoE.getOidSeccion());
        }
        query.append("			AND lis.FEC_CREA = TO_DATE( '");
        
        SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
        String sFecha = miFecha.format(dtoE.getFechaArmado());
        query.append(sFecha + "' ,'DD/MM/YYYY')");
        
        query.append("			AND lis.PERD_OID_PERI = p.OID_PERI ");
        if (dtoE.getOidCanal() != null) {
          query.append("			AND p.CANA_OID_CANA = ");
          query.append(dtoE.getOidCanal());
        }
        if (dtoE.getOidMarca() != null) {
          query.append("			AND p.MARC_OID_MARC = ");
          query.append(dtoE.getOidMarca());
        }
        query.append("			AND lis.SOCA_OID_SOLI_CABE is null ");
        query.append("			AND m.oid_marc = p.marc_oid_marc ");
        query.append("			AND c.oid_cana = p.cana_oid_cana ");
        query.append("			AND z.oid_zona = lis.zzon_oid_zona ");
        query.append("			AND s.oid_secc = lis.zscc_oid_secc ");

        RecordSet rs = null;
        try {
            //String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoE);          
            //rs = bs.dbService.executeStaticQuery(queryPaginada);    
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {
            System.out.println("****buscarListaPicadoCabeceraFP: no hay datos ");				
             //throw new MareException("", UtilidadesError.armarCodigoError(modulo, error));
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOImpresionListaPicadoFP.buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFPº dtoe): Salida");
        return dtoSalida;
    }
}