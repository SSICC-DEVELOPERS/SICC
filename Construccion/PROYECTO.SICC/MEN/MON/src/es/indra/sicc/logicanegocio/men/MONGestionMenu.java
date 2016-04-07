package es.indra.sicc.logicanegocio.men;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.men.DTOSFormato;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOPais;

public interface MONGestionMenu extends EJBObject  {
	DTOSFormato cargaformatosSesion(DTOPais dtoe) throws RemoteException, MareException;
}