package es.indra.sicc.logicanegocio.seg;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.seg.PaginaDefinirNivelesDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.seg.AsociacionNivelesDTO;
import es.indra.sicc.dtos.seg.PaginaEliminarNivelesDTO;
import es.indra.sicc.dtos.seg.DTOListaAsociacionNiveles;

public interface MONMantenimientoNiveles extends EJBObject  {
    PaginaDefinirNivelesDTO cargarPaginaDefinirNiveles(Long oidPais, Long oidIdioma) throws RemoteException, MareException;

    PaginaEliminarNivelesDTO cargarPaginaEliminarNiveles(Long oidPais, Long oidIdioma) throws RemoteException, MareException;

    DTOSalida recuperarTiposNivelesSocioeconomicosPersonales(Long oidPais, Long oidIdioma) throws RemoteException, MareException;

    DTOSalida recuperarNivelesSocioEconomicosBelcorp() throws RemoteException, MareException;

    DTOSalida recuperarAsociacionesNiveles(Long oidPais, Long oidIdioma) throws RemoteException, MareException;

    void definirAsociacionNiveles(DTOListaAsociacionNiveles asociacion) throws RemoteException, MareException;

    void eliminarAsociacionNiveles(DTOListaAsociacionNiveles asociacion) throws RemoteException, MareException;
}