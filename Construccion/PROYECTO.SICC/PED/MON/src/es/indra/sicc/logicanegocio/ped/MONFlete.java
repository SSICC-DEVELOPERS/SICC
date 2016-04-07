package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOFlete;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
public interface MONFlete extends EJBObject  {
	void elimina(DTOOIDs dto) throws MareException, RemoteException;

	void guarda(DTOFlete dto) throws MareException, RemoteException;

	DTOSalida consulta(DTOFlete dto) throws MareException, RemoteException;

	DTOFlete consultaDetalles(DTOOID dto) throws MareException, RemoteException;
}