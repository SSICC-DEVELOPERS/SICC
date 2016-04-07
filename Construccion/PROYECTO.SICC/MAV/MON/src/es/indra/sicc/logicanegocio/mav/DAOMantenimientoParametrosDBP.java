package es.indra.sicc.logicanegocio.mav;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mav.DTOValoresDefectoDatosBP;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOMantenimientoParametrosDBP  {
    public DAOMantenimientoParametrosDBP() {
    }

    DTOSalida obtenerValoresDefectoPorActividad(DTOValoresDefectoDatosBP dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoParametrosDBP.obtenerValoresDefectoPorActividad(DTOValoresDefectoDatosBP dtoe):Entrada");
        
        DTOSalida dtos = null;
        StringBuffer consulta = new StringBuffer();
        
        consulta.append("SELECT valdef.OID_PARA_DEFE OID, valdef.COD_PARA_DEFE COD, valdef.val_defe VAL ");
        consulta.append("  FROM MAV_PARAM_DEFEC_BPLAN valdef ");
        consulta.append(" WHERE valdef.acti_oid_acti = " + dtoe.getOidActividad() + " ");
        consulta.append("   AND valdef.pais_oid_pais = " + dtoe.getOidPais() );
        
        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(consulta.toString());
            if(rs!=null && !rs.esVacio()){
                dtos = new DTOSalida(rs);
            }else{
                dtos = new DTOSalida(new RecordSet());
            }
        }catch(MareException me){
            throw me;
        }catch(Exception e){
            throw new MareException(e);
        }
        
        UtilidadesLog.info("DAOMantenimientoParametrosDBP.obtenerValoresDefectoPorActividad(DTOValoresDefectoDatosBP dtoe):Salida");
        return dtos;
    }
 
    // sapaza -- PER-SiCC-2013-0355 -- 04/04/2013
    public String obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro) throws MareException {
        UtilidadesLog.info("DAOMantenimientoParametrosDBP.obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT pp.val_para  ");
        consulta.append("   FROM bas_param_pais pp, bas_pais bp, seg_pais sp  ");
        consulta.append("  WHERE sp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND sp.oid_pais =  " + oidPais.toString());
        consulta.append("    AND pp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND pp.cod_sist = '" + codigoModulo + "'");
        consulta.append("    AND pp.cod_para = '" + codigoParametro + "'");
        consulta.append("    AND pp.ind_acti =  '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {                 
            return (String)rs.getValueAt(0,0);        
        }

        UtilidadesLog.info("DAOMantenimientoParametrosDBP.obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Salida");

        return null;
    }    
    
    // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
    public String obtenerDescripcionAlmacen(Long oidActividad, Long oidIdioma) throws MareException {
        UtilidadesLog.info("DAOMantenimientoParametrosDBP.obtenerDescripcionAlmacen(Long oidActividad, Long oidIdioma): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT pq_apl_aux.Valor_Gen_I18n_Sicc(" + oidIdioma + ", ALMA_OID_ALMA, 'BEL_ALMAC')   ");
        consulta.append("   FROM MAV_ACTIV  ");
        consulta.append("   WHERE OID_ACTI = " + oidActividad);
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {   
            return (String)rs.getValueAt(0,0);        
        }

        UtilidadesLog.info("DAOMantenimientoParametrosDBP.obtenerDescripcionAlmacen(Long oidActividad, Long oidIdioma): Salida");

        return null;
    }
    
}