package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.inc.MONConcurso;
import es.indra.sicc.logicanegocio.inc.MONConcursoHome;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class MONConcursoClient {
    public static void main(String[] args) {
        MONConcursoClient mONConcursoClient = new MONConcursoClient();

        try {
            Context context = INCTest.getInitialContext();
            MONConcursoHome mONConcursoHome = (MONConcursoHome) PortableRemoteObject.narrow(context.lookup("MONConcurso"), MONConcursoHome.class);
            MONConcurso mONConcurso;

            // Use one of the create() methods below to create a new instance
            mONConcurso = mONConcursoHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONConcurso.obtenerVersionesSuperiores( es.indra.sicc.dtos.inc.DTOVersion dtoe );
            // mONConcurso.obtenerVersionesConcurso( es.indra.sicc.dtos.inc.DTOBuscarPlantillas dtoOid );
            // mONConcurso.obtenerVariablesVentaProyectada( es.indra.sicc.util.DTOOID dtoe );
            // mONConcurso.obtenerVariablesVenta( es.indra.sicc.util.DTOOID dtoe );
            // mONConcurso.obtenerTiposVentaIncremental( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerTiposRequisito( es.indra.sicc.util.DTOBelcorp dtoE );
            // mONConcurso.obtenerTiposProducto( es.indra.sicc.dtos.inc.DTOTipoProducto DTOE );
            // mONConcurso.obtenerTiposIncremento( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerTiposExigencia( es.indra.sicc.util.DTOBelcorp dtoE );
            // mONConcurso.obtenerTiposDeterminacionMetas( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerTipoPremiosPuntos( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerTipoPremioMonetario( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerTipoPremio( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerTipoPremiacion( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerTipoMontoVentaRecomendada( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerTipoEleccion( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerTipoDescuento( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerTipoCumplimiento( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerRequisitosPremiacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProgramaNuevas( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosValidos( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosExigidosPremiacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosExigidos( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosExcluidosCalificacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosExcluidos( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosBonificados( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerProductosACalificar( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerParametrosPremiacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerParametrosGeneralesConcurso( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerParametrosConsultoras( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerParametrosCalificacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerObtencionPuntos( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerNivelesPremiacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerMultinivel( es.indra.sicc.util.DTOOID dtoe );
            // mONConcurso.obtenerMontoVentaRecomendadas( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerMaximoNumeroPremio( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerMarcas( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerListasClasificacion( es.indra.sicc.dtos.inc.DTOClasificacionParticipantes DTOE );
            // mONConcurso.obtenerListaVersionesConcurso( es.indra.sicc.dtos.inc.DTOBuscarPlantillas dtoe );
            // mONConcurso.obtenerListaParticipantes( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerListaEstatusVentaConsultora( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerListaClasificacionParticipantes( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerListaAmbitosGeograficos( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerIncrementosPorRango( java.lang.Long oidConcurso );
            // mONConcurso.obtenerFormaPago( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerFormaCalculoMetas( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerFormaCalculo( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerDespachoPremios( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerDatosConcurso( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerCursosExigidosPremiacion( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.obtenerCalculoPremio( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.obtenerAgrupacion( es.indra.sicc.util.DTOBelcorp dtoe );
            // mONConcurso.obtenerAccesos( es.indra.sicc.util.DTOOID DTOE );
            // mONConcurso.insertarVersion( es.indra.sicc.dtos.inc.DTOVersion dtoe );
            // mONConcurso.guardarVersion( es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarVariablesVentaProyectada( es.indra.sicc.dtos.inc.DTOVariablesVentaProyectada DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarVariablesVenta( es.indra.sicc.dtos.inc.DTOVariablesVenta DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarRequisitosPremiacion( es.indra.sicc.dtos.inc.DTORequisitosPremiacion DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProgramaNuevas( es.indra.sicc.dtos.inc.DTOProgramaNuevas DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosValidos( es.indra.sicc.dtos.inc.DTOProducto DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosExigidosPremiacion( es.indra.sicc.dtos.inc.DTOProductosExigidosPremiacion DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosExigidos( es.indra.sicc.dtos.inc.DTOProducto DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosExcluidosCalificacion( es.indra.sicc.dtos.inc.DTOProducto DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosExcluidos( es.indra.sicc.dtos.inc.DTOProducto DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosBonificados( es.indra.sicc.dtos.inc.DTOProducto DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductosACalificar( es.indra.sicc.dtos.inc.DTOProducto DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarProductos( es.indra.sicc.dtos.inc.DTOConcurso DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarPremioPuntos( es.indra.sicc.dtos.inc.DTOPremioPuntos DTOE, java.lang.Long oidNivel );
            // mONConcurso.guardarPremioMonetario( es.indra.sicc.dtos.inc.DTOPremioMonetario DTOE, java.lang.Long oidNivel );
            // mONConcurso.guardarPremioDescuento( es.indra.sicc.dtos.inc.DTOPremioDescuento DTOE, java.lang.Long oidNivel );
            // mONConcurso.guardarPremioArticulo( es.indra.sicc.dtos.inc.DTOPremioArticulo DTOE, java.lang.Long oidNivel );
            // mONConcurso.guardarParametrosPremiacion( es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarParametrosGerentes( es.indra.sicc.dtos.inc.DTOParametrosGerentes DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarParametrosGeneralesConcurso( es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso DTOE );
            // mONConcurso.guardarParametrosConsultoras( es.indra.sicc.dtos.inc.DTOParametrosConsultoras DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarParametrosCalificacion( es.indra.sicc.dtos.inc.DTOParametrosCalificacion DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarObtencionPuntos( es.indra.sicc.dtos.inc.DTOObtencionPuntos DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarNivelesPremiacion( es.indra.sicc.dtos.inc.DTONivelesPremiacion DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarMultinivel( es.indra.sicc.dtos.inc.DTOMultinivel DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarMontoVentaRecomendadas( es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas DTOE, java.lang.Long oid );
            // mONConcurso.guardarIncrementosPorRango( java.lang.Long oidConcurso, java.util.ArrayList lista );
            // mONConcurso.guardarEstatusVenta( es.indra.sicc.dtos.inc.DTOConcurso DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarDespachoPremios( es.indra.sicc.dtos.inc.DTODespachoPremios DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarDatosConcurso( es.indra.sicc.dtos.inc.DTOConcurso DTOE );
            // mONConcurso.guardarCursosExigidosPremiacion( es.indra.sicc.dtos.inc.DTOCursosExigidosPremiacion DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarClasificacionParticipantesCalificacion( es.indra.sicc.dtos.inc.DTOCalificacionParticipantes DTOE, java.lang.Long oidConcurso, java.lang.Long oidDirigidoA );
            // mONConcurso.guardarClasificacionParticipantes( es.indra.sicc.dtos.inc.DTOClasificacionParticipantes DTOE, java.lang.Long oidConcurso );
            // mONConcurso.guardarAmbitosGeograficos( es.indra.sicc.dtos.inc.DTOListaAmbitosGeograficos DTOE, java.lang.Long oidConcurso );
            // mONConcurso.crearConcursoNuevaVersion( es.indra.sicc.dtos.inc.DTOVersion dtoe );
            // mONConcurso.cargarNroPlantilla( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.cargarNroConcurso( es.indra.sicc.util.DTOBelcorp DTOE );
            // mONConcurso.buscarListaPlantillas( es.indra.sicc.dtos.inc.DTOBuscarPlantillas DTOE );
            // mONConcurso.buscarCtaCtePtos( es.indra.sicc.dtos.inc.DTOBuscarCtaCtePtos DTOE );
            // mONConcurso.buscarConcursos( es.indra.sicc.dtos.inc.DTOBuscarConcursos DTOE );
            // mONConcurso.borrarPremios( java.lang.Long oidParamNivelPremiacion );
            // mONConcurso.borrarConcurso( es.indra.sicc.dtos.inc.DTOVersion dtoe );
            // mONConcurso.actualizarNuevaVersion( es.indra.sicc.dtos.inc.DTONuevaVersion dtoe );
            // mONConcurso.actualizarEstadoVersion( es.indra.sicc.dtos.inc.DTOVersion dtoe );
            // mONConcurso.actualizarEstadoPlantilla( es.indra.sicc.dtos.inc.DTOPlantilla DTOE );
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
