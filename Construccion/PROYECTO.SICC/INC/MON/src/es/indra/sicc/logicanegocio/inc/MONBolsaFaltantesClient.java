package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantes;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantesHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONBolsaFaltantesClient {
    public static void main(String[] args) {
        MONBolsaFaltantesClient mONBolsaFaltantesClient = new MONBolsaFaltantesClient();

        try {
            Context context = INCTest.getInitialContext();
            MONBolsaFaltantesHome mONBolsaFaltantesHome = (MONBolsaFaltantesHome) PortableRemoteObject.narrow(context.lookup("MONBolsaFaltantes"),
                                                                                                              MONBolsaFaltantesHome.class);
            MONBolsaFaltantes mONBolsaFaltantes;

            // Use one of the create() methods below to create a new instance
            mONBolsaFaltantes = mONBolsaFaltantesHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONBolsaFaltantes.recuperarCodConcursos( es.indra.sicc.util.DTOBelcorp dto );
            // mONBolsaFaltantes.obtenerTipoCambio( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONBolsaFaltantes.obtenerSituacionRegistro( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONBolsaFaltantes.guardarAsignacionFaltantes( es.indra.sicc.dtos.inc.DTOPremioSustitutivo dtosus );
            // mONBolsaFaltantes.buscarPremiosFaltantes( es.indra.sicc.dtos.inc.DTOBusquedaFaltantes dtoEnt );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
