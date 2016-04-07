package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONPremiacionMultinivel;
import es.indra.sicc.logicanegocio.inc.MONPremiacionMultinivelHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONPremiacionMultinivelClient {
    public static void main(String[] args) {
        MONPremiacionMultinivelClient mONPremiacionMultinivelClient = new MONPremiacionMultinivelClient();

        try {
            Context context = INCTest.getInitialContext();
            MONPremiacionMultinivelHome mONPremiacionMultinivelHome = (MONPremiacionMultinivelHome) PortableRemoteObject.narrow(context.lookup("MONPremiacionMultinivel"),
                                                                                                                                MONPremiacionMultinivelHome.class);
            MONPremiacionMultinivel mONPremiacionMultinivel;

            // Use one of the create() methods below to create a new instance
            mONPremiacionMultinivel = mONPremiacionMultinivelHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONPremiacionMultinivel.determinarGanadoraMultinivel( java.lang.Long oidPeriodo );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
