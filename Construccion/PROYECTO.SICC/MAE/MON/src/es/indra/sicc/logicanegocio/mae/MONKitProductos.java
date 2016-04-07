package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOBusquedaKit;
import es.indra.sicc.dtos.mae.DTOBusquedaPeriodos;
import es.indra.sicc.dtos.mae.DTOCombosKit;
import es.indra.sicc.dtos.mae.DTOConsultaKit;
import es.indra.sicc.dtos.mae.DTOKitModificar;
import es.indra.sicc.dtos.mae.DTOKit;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONKitProductos extends EJBObject  {

    DTOCombosKit rellenarCombos(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida buscarPeriodos(DTOBusquedaPeriodos dto) throws RemoteException, MareException;

    void inserta(DTOKit dtoKit) throws  MareException, RemoteException;

	 DTOSalida busquedaPorCriterios(DTOBusquedaKit criterios) throws MareException, RemoteException;

    DTOConsultaKit consultar (DTOOID dto)  throws MareException, RemoteException;

    DTOKitModificar obtenerKit(DTOOID dto) throws  MareException, RemoteException;

    void actualiza(DTOKit dtoKit) throws  MareException, RemoteException;

  DTOSalida obtenerMarcaProducto(DTOBelcorp dto) throws MareException, RemoteException;



}