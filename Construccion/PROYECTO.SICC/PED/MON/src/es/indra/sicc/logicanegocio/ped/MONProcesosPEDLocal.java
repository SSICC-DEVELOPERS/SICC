package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.mare.common.exception.MareException;

import java.util.ArrayList;

public interface MONProcesosPEDLocal extends EJBLocalObject  {
  String generaNumeroDocumento(DTONumeroSolicitud dto) throws MareException;

  String generaSecuenciaDocumento(DTONumeroSolicitud dto) throws MareException;

    String ejecutarFuncionNumeroSolicitud(ArrayList arrayParametros) throws MareException;
}
