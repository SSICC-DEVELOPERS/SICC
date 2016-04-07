package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.dtos.ped.DTOProceso;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.inc.MONIncentivos;
import es.indra.sicc.logicanegocio.inc.MONIncentivosHome;

import java.math.BigDecimal;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONIncentivosClient {
    public static void main(String[] args) {
        MONIncentivosClient mONIncentivosClient = new MONIncentivosClient();

        try {
            Context context = INCTest.getInitialContext();
            MONIncentivosHome mONIncentivosHome = (MONIncentivosHome) PortableRemoteObject.narrow(context.lookup("MONIncentivos"),
                                                                                                  MONIncentivosHome.class);
            MONIncentivos mONIncentivos;

            // Use one of the create() methods below to create a new instance
            mONIncentivos = mONIncentivosHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONIncentivos.revertirPuntajes( es.indra.sicc.dtos.ped.DTOSolicitudValidacion solicitudValidacion );
            DTOSolicitudValidacion solicitud = new DTOSolicitudValidacion();
            solicitud.setIndOrdenCompra(new Boolean(true));
            solicitud.setIndPedGTZona(new Boolean(true));
            solicitud.setIndSimulacion(new Boolean(true));
            solicitud.setIndUnionSolicitud(new Boolean(true));
            solicitud.setNumDecimales(new Integer(2));
            solicitud.setNumSolicitud("123456");
            solicitud.setOidAcceso(new Long(1));
            solicitud.setOidCanal(new Long(1));
            solicitud.setOidCliente(new Long(1));
            solicitud.setOidIdioma(new Long(1));
            solicitud.setOidMarca(new Long(1));
            solicitud.setOidModulo(new Long(1));
            solicitud.setOidMoneda(new Long(1));
            solicitud.setOidPais(new Long(1));
            solicitud.setOidPeriodo(new Long(1));
            solicitud.setOidSolicitud(new Long(1));
            solicitud.setOidSubAcceso(new Long(1));
            solicitud.setOidTipoSolPais(new Long(1));
            solicitud.setOrden(new Long(1));
            solicitud.setOrdenMonitor(new Long(1));
            solicitud.setPrograma("Programa nuevo");
            solicitud.setTipoCambio(new BigDecimal(3));
            solicitud.setUbigeo(new Long(1));
            solicitud.setZona(new Long(1));

            DTOProceso dTOProceso = new DTOProceso();
            dTOProceso.setBusinessID("123");
            dTOProceso.setCodProceso("1");
            dTOProceso.setOidIdioma(new Long(1));
            dTOProceso.setOidPais(new Long(1));
            dTOProceso.setOidProceso(new Long(1));
            dTOProceso.setOidSubTipoPosicion(new Long(1));
            dTOProceso.setOidTipoPosicion(new Long(1));
            dTOProceso.setPrograma("1234");
            dTOProceso.setSecuencia(new Integer(1));
            solicitud.setProceso(dTOProceso);

            mONIncentivos.concursarSolicitud(solicitud);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
