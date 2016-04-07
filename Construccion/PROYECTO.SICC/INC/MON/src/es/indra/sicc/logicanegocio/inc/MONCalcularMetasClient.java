package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONCalcularMetas;
import es.indra.sicc.logicanegocio.inc.MONCalcularMetasHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONCalcularMetasClient {
    public static void main(String[] args) {
        MONCalcularMetasClient mONCalcularMetasClient = new MONCalcularMetasClient();

        try {
            Context context = INCTest.getInitialContext();
            MONCalcularMetasHome mONCalcularMetasHome = (MONCalcularMetasHome) PortableRemoteObject.narrow(context.lookup("MONCalcularMetas"),
                                                                                                           MONCalcularMetasHome.class);
            MONCalcularMetas mONCalcularMetas;

            // Use one of the create() methods below to create a new instance
            mONCalcularMetas = mONCalcularMetasHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONCalcularMetas.obtenerMetasVentaProyectadaZona( java.lang.Long oidConcurso );
            // mONCalcularMetas.obtenerMetasVentaProyectadaZona( es.indra.sicc.util.DTOOID oidConcurso );
            // mONCalcularMetas.obtenerMetasVentaProyectadaSubgerencia( java.lang.Long oidConcurso );
            // mONCalcularMetas.obtenerMetasVentaProyectadaSubgerencia( es.indra.sicc.util.DTOOID oidConcurso );
            // mONCalcularMetas.obtenerMetasVentaProyectadaRegion( java.lang.Long oidConcurso );
            // mONCalcularMetas.obtenerMetasVentaProyectadaRegion( es.indra.sicc.util.DTOOID oidConcurso );
            // mONCalcularMetas.obtenerMetasTipoVenta( java.lang.Long oidConcurso );
            // mONCalcularMetas.obtenerMetasTipoVenta( es.indra.sicc.util.DTOOID oid );
            // mONCalcularMetas.guardarMetasVentaProyectadaZona( java.lang.Long oidConcurso, es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada listaMetas );
            // mONCalcularMetas.guardarMetasVentaProyectadaSubgerencia( java.lang.Long oidConcurso, es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada listaMetas );
            // mONCalcularMetas.guardarMetasVentaProyectadaRegion( java.lang.Long oidConcurso, es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada listaMetas );
            // mONCalcularMetas.guardarMetasTipoVenta( java.lang.Long oidConcurso, es.indra.sicc.dtos.inc.DTOListaMetasTipoVenta listaMetas, java.math.BigDecimal valorIncremento );
            // mONCalcularMetas.estaTipificacionCliente( java.lang.Long oidCliente, java.util.ArrayList listaClasiParti );
            // mONCalcularMetas.esUltimoPeriodo( java.lang.Long oidPeriodo, es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada listaMetas );
            // mONCalcularMetas.esPrimerPeriodo( java.lang.Long oidPeriodo, es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada listaMetas );
            // mONCalcularMetas.calcularMetasVentaProyectadaBatch( es.indra.sicc.dtos.inc.DTOConcurso dto );
            // mONCalcularMetas.calcularMetasVentaProyectada( es.indra.sicc.cmn.negocio.batch.DTOBatch DTOE );
            // mONCalcularMetas.calcularMetasTipoVentaGerentes( es.indra.sicc.dtos.inc.DTOConcurso DTOE );
            // mONCalcularMetas.calcularMetasTipoVentaConsultoras( es.indra.sicc.dtos.inc.DTOConcurso DTOE );
            // mONCalcularMetas.calcularMetasTipoVentaBatch( es.indra.sicc.dtos.inc.DTOConcurso DTOE );
            // mONCalcularMetas.calcularMetasTipoVenta( es.indra.sicc.cmn.negocio.batch.DTOBatch DTOE );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
