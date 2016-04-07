package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mav.DTOCampaniaEstimadosBP;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mav.DTODetalleCampaniaEstimadosBP;

public interface MONSimularEstimadosBPLocal extends EJBLocalObject 
{
    DTOSalida cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto) throws MareException;

    DTOSalida cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto) throws MareException;

    DTODetalleCampaniaEstimadosBP cargarFormularioRecalculo(DTOOID dto) throws MareException;

    Long consultarUnidadesDisponibles(Long pais, Long producto) throws MareException;

    DTODetalleCampaniaEstimadosBP recalcularDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto) throws MareException;

    void actualizarDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto) throws MareException;
}