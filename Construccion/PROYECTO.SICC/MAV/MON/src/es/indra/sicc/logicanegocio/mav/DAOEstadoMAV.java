package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mav.DTOEBuscarEstadosMAV;
import es.indra.sicc.util.*;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import java.rmi.RemoteException;

import javax.ejb.EJBException;


public class DAOEstadoMAV {
    public DAOEstadoMAV() {}

    public DTOSalida buscarEstados(DTOEBuscarEstadosMAV dto)
        throws Exception, MareException { /*
        Entrada: DTOEBuscarEstadosMAV
        Proceso:
        -> Hacer consulta JDBC sobre tabla MAV_ESTAD_MAV, para obtener los campos
        OID_ESTA_MAV y DES_ESTA_MAV, filtrando por los campos contenidos en el dto
        de entrada. El filtro de descripción será un "Like", es decir, entrarán
        todas las descripciónes que contengan el criterio. Esta búsqueda es paginada,
        por tanto habra que tener en cuenta las siguientes consideraciones:
        1.- oid del registro encontrado > dto.indicadorSituacion
        2.- ROWNUM <= dto.tamañoPagina
        -> Se devuelve el RecordSet dentro de un objeto "DTOSalida"
        */
        
        UtilidadesLog.info("DAOEstadoMAV.buscarEstados(DTOEBuscarEstadosMAV dto):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" select m.OID_ESTA_MAV as OID,m.OID_ESTA_MAV,i.val_i18n ");
        query.append(" from MAV_ESTAD_MAV m, v_gen_i18n_sicc i ");
        query.append(" where ");
        query.append(" i.attr_enti = 'MAV_ESTAD_MAV' ");
        query.append("   AND i.attr_num_atri = 1 ");
        query.append(" AND i.idio_oid_idio =" + dto.getOidIdioma().toString());
        query.append(" AND  m.PAIS_OID_PAIS = " + dto.getOidPais().toString());
        query.append(" AND i.val_oid = m.OID_ESTA_MAV ");

        if(dto.getOidEstadoMAV() != null)
            query.append(" AND m.OID_ESTA_MAV = " + dto.getOidEstadoMAV());

        if(dto.getDescripcion() != null)
            query.append(" AND i.val_i18n like '" + dto.getDescripcion() + "'");

        RecordSet rs;

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(
                        query.toString(), dto));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            }
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida salir = new DTOSalida(rs);
        UtilidadesLog.info("DAOEstadoMAV.buscarEstados(DTOEBuscarEstadosMAV dto):Salida");
        return salir;
    }

    public RecordSet obtenerPosiblesEstatusCliente(DTOBelcorp dto, String claves)
        throws MareException {
        UtilidadesLog.info("DAOEstadoMAV.obtenerPosiblesEstatusCliente(DTOBelcorp dto, String claves):Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        //DTOSalida dtos = new DTOSalida();

        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();

            query.append(" SELECT oid_esta_clie, i.val_i18n");
            query.append("   FROM mae_estat_clien e, v_gen_i18n_sicc i");
            query.append("  WHERE i.attr_enti = 'MAE_ESTAT_CLIEN'");
            query.append("    AND i.attr_num_atri = 1");
            query.append("    AND i.idio_oid_idio = " + dto.getOidIdioma());
            query.append("    AND i.val_oid = e.oid_esta_clie");
            query.append("    AND  e.oid_esta_clie in (" + claves + ")");
            query.append("  ORDER BY val_i18n");

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(resultado.esVacio())
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));

        UtilidadesLog.info("DAOEstadoMAV.obtenerPosiblesEstatusCliente(DTOBelcorp dto, String claves):Salida");
        return resultado;
    }

    private BelcorpService getBelcorpService() {
        try {
            return BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }
}