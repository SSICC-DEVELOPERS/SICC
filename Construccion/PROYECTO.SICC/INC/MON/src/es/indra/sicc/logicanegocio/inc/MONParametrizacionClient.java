package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONParametrizacion;
import es.indra.sicc.logicanegocio.inc.MONParametrizacionHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONParametrizacionClient {
    public static void main(String[] args) {
        MONParametrizacionClient mONParametrizacionClient = new MONParametrizacionClient();

        try {
            Context context = INCTest.getInitialContext();
            MONParametrizacionHome mONParametrizacionHome = (MONParametrizacionHome) PortableRemoteObject.narrow(context.lookup("MONParametrizacionINC"),
                                                                                                                 MONParametrizacionHome.class);
            MONParametrizacion mONParametrizacion;

            // Use one of the create() methods below to create a new instance
            mONParametrizacion = mONParametrizacionHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONParametrizacion.obtenerPlantilla( es.indra.sicc.util.DTOOID DTOE );
            // mONParametrizacion.eliminarPlantilla( es.indra.sicc.util.DTOOIDs DTOE );
            // mONParametrizacion.consultarTiposVenta( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONParametrizacion.consultarTiposConcursoIVR( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONParametrizacion.consultarTiposCalificacion( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONParametrizacion.consultarDirigidoA( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONParametrizacion.consultarBasesCalculo( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONParametrizacion.buscarPlantillas( es.indra.sicc.dtos.inc.DTOBusquedaPlantilla DTOE );
            // mONParametrizacion.actualizarPlantilla( es.indra.sicc.dtos.inc.DTOPlantilla DTOE );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
