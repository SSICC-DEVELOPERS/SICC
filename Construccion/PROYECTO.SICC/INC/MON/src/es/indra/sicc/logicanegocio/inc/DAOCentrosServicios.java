package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOCentroServicio;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOCentrosServicios 
{
    public DAOCentrosServicios() {
    }
    
    public DTOSalida buscarCentrosServicios(DTOCentroServicio dto) throws MareException{

        UtilidadesLog.info("DAOCentrosServicios.buscarCentrosServicios(DTOCentroServicio dto): Entrada ");
        Long tipoPrograma = null;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();

        query.append(" SELECT CS.OID_CENT_SERV OID, CS.COD_CENT_SERV, CS.DES_CENT_SERV, CS.VAL_OBSE ");
        query.append(" FROM INC_CENTR_SERVI CS ");
        query.append(" WHERE CS.PAIS_OID_PAIS=" + dto.getOidPais() );
        if (dto.getCodigo() != null) {
            query.append(" AND CS.COD_CENT_SERV LIKE '" + dto.getCodigo() + "' ");
        }
        if (dto.getDescripcion() != null) {
            query.append(" AND CS.DES_CENT_SERV LIKE '" + dto.getDescripcion() + "' ");
        }
        if (dto.getObservaciones() != null) {
            query.append(" AND CS.VAL_OBSE LIKE '" + dto.getObservaciones() + "' ");
        }

		try{
            respuesta = this.executeQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch (MareException e) {
            throw e;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (respuesta.esVacio()) {
            throw new MareException(new Exception(),  
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        
        
        UtilidadesLog.info("DAOCentrosServicios.buscarCentrosServicios(DTOCentroServicio dto): Salida ");
        return new DTOSalida(respuesta);
    }   
    
    public void insertarCentroServicio(DTOCentroServicio dto) throws MareException{

        UtilidadesLog.info("DAOCentrosServicios.insertarCentroServicio(DTOCentroServicio dto): Entrada ");
        Long tipoPrograma = null;
        int respuesta;
        StringBuffer query = new StringBuffer();

        query.append(" INSERT INTO INC_CENTR_SERVI (  ");
        query.append(" OID_CENT_SERV, COD_CENT_SERV, PAIS_OID_PAIS");
        if (dto.getDescripcion() != null) {
            query.append(", DES_CENT_SERV ");
        }
        if (dto.getObservaciones() != null) {
            query.append(", VAL_OBSE ");        
        }
        query.append(" ) VALUES (");
        
        query.append(" INC_CESE_SEQ.NEXTVAL, '" + dto.getCodigo() + "', " + dto.getOidPais());
        if (dto.getDescripcion() != null) {
            query.append(" , '" + dto.getDescripcion()  + "'");
        }
        if (dto.getObservaciones() != null) {
            query.append(" , '" + dto.getObservaciones()  + "'");
        }
        query.append(" ) ");
		try{
            respuesta = this.executeUpdate(query.toString());
        } catch (MareException e) {
            throw new MareException( e, 
              UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        }
        
        UtilidadesLog.info("DAOCentrosServicios.insertarCentroServicio(DTOCentroServicio dto): Salida ");
    }  
    
    public void modificarCentroServicio(DTOCentroServicio dto) throws MareException{

        UtilidadesLog.info("DAOCentrosServicios.modificarCentroServicio(DTOCentroServicio dto): Entrada ");
        Long tipoPrograma = null;
        int respuesta;
        StringBuffer query = new StringBuffer();

        query.append(" UPDATE INC_CENTR_SERVI SET  ");
        if (dto.getDescripcion() != null) {
            query.append(" DES_CENT_SERV= '" + dto.getDescripcion() + "' ");
        } else {
            query.append(" DES_CENT_SERV = '' ");
        }
        if (dto.getObservaciones() != null) {
            query.append(" , VAL_OBSE = '" + dto.getObservaciones() + "' ");
        } else {
            query.append(" , VAL_OBSE = '' ");
        }
        query.append(" WHERE OID_CENT_SERV = " + dto.getOidCentroServicio());

		try{
            respuesta = this.executeUpdate(query.toString());
        } catch (MareException e) {
            throw e;
        }
        
        UtilidadesLog.info("DAOCentrosServicios.modificarCentroServicio(DTOCentroServicio dto): Salida ");
    }  
    
    public void eliminarCentroServicio(DTOOIDs dto) throws MareException{

        UtilidadesLog.info("DAOCentrosServicios.eliminarCentroServicio(DTOOIDs dto): Entrada ");
        Long tipoPrograma = null;
        int respuesta;
        StringBuffer query = new StringBuffer();
        StringBuffer queryIN = new StringBuffer();

        if (dto != null && dto.getOids() != null && dto.getOids().length > 0) {
            Long[] oids = dto.getOids();
            queryIN.append("(");
            for (int i = 0; i < (oids.length - 1); i++) {
                queryIN.append(oids[i] + ", ");
            }
            queryIN.append(oids[oids.length - 1] + ")");
            
            query.append(" DELETE INC_CENTR_SERVI  ");
            query.append(" WHERE OID_CENT_SERV IN " + queryIN.toString());
    
            try{
                respuesta = this.executeUpdate(query.toString());
            } catch (MareException e) {
                throw new MareException( e, 
                  UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("DAOCentrosServicios.eliminarCentroServicio(DTOOIDs dto): Salida ");
    }  

    private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("DAOCentrosServicios.executeQuery(String query): Entrada");
        RecordSet rs = null;
        
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery( query );
        } catch (MareException e) {
            throw e;
        } catch ( Exception ex ) {
            throw new MareException( ex, 
              UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("DAOCentrosServicios.executeQuery(String query): Salida");  
        return rs;
    }   
    
    private int executeUpdate(String query) throws MareException {
        UtilidadesLog.info("DAOCentrosServicios.executeUpdate(String query): Entrada");
        int res;
        
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          res = belcorpService.dbService.executeUpdate( query );
        } catch (MareException e) {
            throw e;
        } catch ( Exception ex ) {
            throw new MareException( ex, 
              UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("DAOCentrosServicios.executeUpdate(String query): Salida");  
        return res;
    }     
    
    
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       11/10/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOSalida obtenerCentroServicio(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCentroServicio(DTOBelcorp dtoe): Entrada");
        
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

        query.append(" select cen.OID_CENT_SERV, cen.DES_CENT_SERV ");
        query.append(" from INC_CENTR_SERVI cen ");
        query.append(" where cen.PAIS_OID_PAIS = " + dtoe.getOidPais());
        query.append(" order by cen.DES_CENT_SERV ");        

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCentroServicio(DTOBelcorp dtoe): Salida");       
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       12/9/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOCentroServicio obtenerCentroServicio(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCentroServicio(DTOOID dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        DTOCentroServicio dtoCentroServicio = new DTOCentroServicio();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" select cen.COD_CENT_SERV, cen.DES_CENT_SERV ");
        query.append(" from INC_CENTR_SERVI cen ");
        query.append(" where cen.OID_CENT_SERV = " + dtoe.getOid());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
          dtoCentroServicio.setCodigo((String)rs.getValueAt(0, "COD_CENT_SERV"));
          dtoCentroServicio.setDescripcion((String)rs.getValueAt(0, "DES_CENT_SERV"));
        }
        
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCentroServicio(DTOOID dtoe): Salida");       
        return dtoCentroServicio;
    }

}