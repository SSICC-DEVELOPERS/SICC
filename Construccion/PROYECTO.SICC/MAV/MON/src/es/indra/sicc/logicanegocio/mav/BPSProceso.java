package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocal;
import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.persistence.NoResultException;

public class BPSProceso {
    private Long oidBPS;

    public BPSProceso(Long oid) {
        oidBPS = oid;
    }

    public boolean registroValido() throws MareException {
        try {
            //tomo el oid periodo, findbyprimary sobre periodo y obtengo el canal
            UtilidadesLog.info("BPSProceso.registroValido(void): Entrada");
            BPSInterfaceMAVLocalHome instanciaBPS = new BPSInterfaceMAVLocalHome();
            BPSInterfaceMAVLocal periOid = instanciaBPS.findByPrimaryKey(this.oidBPS);

            //periodo desde CRA
            PeriodoLocalHome plh = new PeriodoLocalHome();
            PeriodoLocal pl = plh.findByPrimaryKey(periOid.getOidPeriodo());

            Long canal = pl.getOidCanal();

            //obtengo la oferta
            Long tipoOferta = periOid.getOidTipoOferta();

            //cierro el entity
            instanciaBPS = null;

            if(this.validarTipoOfertaCanal(tipoOferta, canal)){
                UtilidadesLog.debug("Valido TipoOfertaCanal - Devuelve true");
                UtilidadesLog.info("BPSProceso.registroValido(void): Salida");                
                return true;
            }
            else {
                UtilidadesLog.debug("No Valido TipoOfertaCanal - Devuelve false");            
                UtilidadesLog.info("BPSProceso.registroValido(void): Salida");                
                return false;
            }
        } catch(NoResultException ne) {
            UtilidadesLog.debug(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } 
    }

    private boolean validarTipoOfertaCanal(Long oidTipoOferta, Long oidCanal)
        throws MareException {
        UtilidadesLog.info("BPSProceso.validarTipoOfertaCanal(Long oidTipoOferta, Long oidCanal): Entrada");
        StringBuffer query = new StringBuffer();
        BelcorpService belcorpService = null;
        RecordSet rs = null;

        query.append("Select * ");
        query.append("from PRE_TIPO_OFERT ");
        query.append("where OID_TIPO_OFER = " + oidTipoOferta + " and ");
        query.append("CANA_OID_CANA = " + oidCanal);

        try {
            belcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = new RecordSet();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            if(rs.getRowCount() > 0) {
                UtilidadesLog.info("BPSProceso.validarTipoOfertaCanal(Long oidTipoOferta, Long oidCanal): Salida");
                return true;
            } else {
                //Genero registro de LOG
                UtilidadesLog.info("BPSProceso.validarTipoOfertaCanal(Long oidTipoOferta, Long oidCanal): Salida");
                LogAPP.error("validarTipoOfertaCanal, no existen registros en Tipo Oferta");
                return false;
            }
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

}