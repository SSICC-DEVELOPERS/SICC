package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONRanking;
import es.indra.sicc.logicanegocio.inc.MONRankingHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONRankingClient {
    public static void main(String[] args) {
        MONRankingClient mONRankingClient = new MONRankingClient();

        try {
            Context context = INCTest.getInitialContext();
            MONRankingHome mONRankingHome = (MONRankingHome) PortableRemoteObject.narrow(context.lookup("MONRanking"), MONRankingHome.class);
            MONRanking mONRanking;

            // Use one of the create() methods below to create a new instance
            mONRanking = mONRankingHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONRanking.evaluarRanking( es.indra.sicc.dtos.fac.DTOFACProcesoCierre dtoin );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
