package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOBusquedaConfiguracionCampo;
import es.indra.sicc.dtos.mae.DTOCombosConfiguracionCampos;
import es.indra.sicc.dtos.mae.DTOConfiguracionCampo;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposProducto;
import es.indra.sicc.dtos.mae.DTOConsultaConfiguracionCampos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONConfiguracionCampos extends EJBObject 
{
    DTOConfiguracionCamposProducto obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto dto) throws RemoteException, MareException;

  DTOConfiguracionCamposCliente obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente dto) throws RemoteException, MareException;

  DTOSalida buscar(DTOBusquedaConfiguracionCampo dto) throws RemoteException, MareException;

  DTOConsultaConfiguracionCampos consultar(DTOOID oid) throws RemoteException, MareException;

  DTOCombosConfiguracionCampos rellenarCombos(DTOBelcorp dto) throws RemoteException, MareException;

  void insertar(DTOConfiguracionCampo dto) throws RemoteException, MareException;

  void eliminar(DTOOIDs dto) throws RemoteException, MareException;

	void actualizar(DTOConfiguracionCampo dto) throws MareException, RemoteException;

    DTOSalida obtenerValoresDefectoClientes(DTOBelcorp dtoe) throws MareException, RemoteException;
}