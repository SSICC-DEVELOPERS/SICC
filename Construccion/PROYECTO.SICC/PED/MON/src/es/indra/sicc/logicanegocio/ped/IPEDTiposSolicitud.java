package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOP;
import es.indra.mare.common.exception.MareException;
public interface IPEDTiposSolicitud  {
  DTOTipoSolicitudOP obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto) throws MareException;
}