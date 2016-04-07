package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONMantenimientoPremiacion;
import es.indra.sicc.logicanegocio.inc.MONMantenimientoPremiacionHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONMantenimientoPremiacionClient {
    public static void main(String[] args) {
        MONMantenimientoPremiacionClient mONMantenimientoPremiacionClient = new MONMantenimientoPremiacionClient();

        try {
            Context context = INCTest.getInitialContext();
            MONMantenimientoPremiacionHome mONMantenimientoPremiacionHome = (MONMantenimientoPremiacionHome) PortableRemoteObject.narrow(context.lookup("MONMantenimientoPremiacion"),
                                                                                                                                         MONMantenimientoPremiacionHome.class);
            MONMantenimientoPremiacion mONMantenimientoPremiacion;

            // Use one of the create() methods below to create a new instance
            mONMantenimientoPremiacion = mONMantenimientoPremiacionHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONMantenimientoPremiacion.obtenerConcursosPorCliente( es.indra.sicc.util.DTOOID dtoe );
            // mONMantenimientoPremiacion.guardarPremiosElegidos( es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos dtoe );
            // mONMantenimientoPremiacion.guardarPremio( es.indra.sicc.dtos.inc.DTOElegirPremiosRec dtoe );
            // mONMantenimientoPremiacion.cargarEleccionPremios( es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos dtoe );
            // mONMantenimientoPremiacion.buscarNivelesPremiacion( es.indra.sicc.dtos.inc.DTOElegirPremiosRec dtoe );
            // mONMantenimientoPremiacion.buscarConcursosPremiosRec( es.indra.sicc.dtos.inc.DTOElegirPremiosRec dtoe );
            // mONMantenimientoPremiacion.buscarCabeceraDetallePremElectivos( es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos dtoe );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
