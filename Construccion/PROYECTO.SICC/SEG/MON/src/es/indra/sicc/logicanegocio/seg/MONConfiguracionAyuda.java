package es.indra.sicc.logicanegocio.seg;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.sicc.dtos.seg.AyudaDTO;
import es.indra.sicc.dtos.seg.PerfilesUsuarioDTO;
import es.indra.sicc.dtos.seg.FuncionesPerfilesUsuarioDTO;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOUsuario;

import es.indra.sicc.util.DTOSalida;

public interface MONConfiguracionAyuda extends EJBObject 
{
  AyudaDTO recuperaAyuda(AyudaDTO ayudaDTO) throws MareException, RemoteException;

  void modificarAyuda(AyudaDTO ayudaDTO) throws MareException, RemoteException;

  DTOSalida obtenerFunciones(DTOUsuario perfiles) throws RemoteException, MareException;
}