package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONSoporteExterno;
import es.indra.sicc.logicanegocio.inc.MONSoporteExternoHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONSoporteExternoClient {
    public static void main(String[] args) {
        MONSoporteExternoClient mONSoporteExternoClient = new MONSoporteExternoClient();

        try {
            Context context = INCTest.getInitialContext();
            MONSoporteExternoHome mONSoporteExternoHome = (MONSoporteExternoHome) PortableRemoteObject.narrow(context.lookup("MONSoporteExterno"),
                                                                                                              MONSoporteExternoHome.class);
            MONSoporteExterno mONSoporteExterno;

            // Use one of the create() methods below to create a new instance
            mONSoporteExterno = mONSoporteExternoHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONSoporteExterno.obtenerPrecioReclamo( es.indra.sicc.dtos.inc.DTOPrecioReclamo dto );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
