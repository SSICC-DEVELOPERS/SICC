package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.mae.DTOCombosImpuestos;
import es.indra.sicc.dtos.fac.DTOTiposImpuestosUbigeo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public interface MONTiposImpuestosUbigeo extends EJBObject  {
  DTOCombosImpuestos buscaTiposImpuestosPorUbigeo(DTOBelcorp dtoE) throws RemoteException, MareException;

  void guardarTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE) throws MareException, RemoteException;

  DTOSalida consultarTiposImpuestosPorUbigeo(DTOSiccPaginacion dtoE) throws RemoteException, MareException;

  void eliminarTiposImpuestosUbigeo(DTOOIDs dtoE) throws MareException, RemoteException;
}