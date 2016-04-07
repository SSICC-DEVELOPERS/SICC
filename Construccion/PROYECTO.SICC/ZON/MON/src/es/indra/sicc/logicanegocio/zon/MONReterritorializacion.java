package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import es.indra.sicc.dtos.zon.DTOFicheroRezonificacion;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import java.util.HashMap;
import java.util.ArrayList;

public interface MONReterritorializacion extends EJBObject 
{
    DTOFicheroRezonificacion lanzarReterritorializacion(DTOFicheroDisp infoFichero) throws RemoteException, MareException;

    DTOSalidaBatch reterritorializacion(DTOBatch dtoBatch) throws RemoteException, MareException;

    void realizarOperacion(DTORezonificacionRegistro registro, HashMap mapValores) throws RemoteException, MareException;

  void actualizarClientesUnidadesAdminyStatus(ArrayList clientes, Long pais, Long marca, Long canal, Long periodoInicio, Long periodoFin, Long regionOrigen, Long regionDestino, Long territorioAdmOrigen, Long territorioAdmDestino) throws MareException, RemoteException;

}