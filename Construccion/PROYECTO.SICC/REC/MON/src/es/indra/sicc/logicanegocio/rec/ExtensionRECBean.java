/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public class ExtensionRECBean implements SessionBean 
{
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
    }

    public void validarMotivoDevolucionS(MareDTO dto) throws MareException
    {
        UtilidadesLog.info("ExtensionREC.validarMotivoDevolucionS(MareDTO):Entrada");
        RecordSet rs =null;
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
        Long paramPais = (Long) dto.getProperty("paisOidPais");
        Long paramOper = (Long) dto.getProperty("ropeOidOper");
        Boolean paramMarca = (Boolean) dto.getProperty("valMarcDefe");
        
        if (paramMarca.booleanValue()==true){
            query.append(" SELECT  ");
                query.append(" OID_MOTI_DEVO_OPER ");
            query.append(" FROM ");
                query.append(" REC_MOTIV_DEVOL_OPERA ");
            query.append(" WHERE ");
            query.append(" PAIS_OID_PAIS = " + paramPais);
            query.append(" AND ROPE_OID_OPER = " + paramOper);
            query.append(" AND VAL_MARC_DEFE = 1 ");
            UtilidadesLog.info("armado de qry terminado");
            try {  
                bs = BelcorpService.getInstance();
                rs = bs.dbService.executeStaticQuery(query.toString());
            }catch (MareMiiServiceNotFoundException ex) {
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            UtilidadesLog.info("ejecuto qry ");
            if (rs.getRowCount()>0){
                      UtilidadesLog.debug(" rs.getRowCount()>0 ");
                      throw new MareException ( null, null, UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_REC
                                                                                                , "", ErroresDeNegocio.REC_0006));
            }
            UtilidadesLog.debug(" rs.getRowCount()=0 ");
        }
        UtilidadesLog.info("ExtensionREC.validarMotivoDevolucionS(MareDTO):Salida");

    }
}