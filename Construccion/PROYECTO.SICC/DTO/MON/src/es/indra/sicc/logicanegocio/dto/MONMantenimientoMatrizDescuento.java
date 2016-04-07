package es.indra.sicc.logicanegocio.dto;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.dto.DTOEMatrizCanal;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;
import es.indra.sicc.dtos.dto.DTOEMatrizTiposCliente;
import es.indra.sicc.dtos.dto.DTOEMatrizAccesos;
import es.indra.sicc.dtos.dto.DTOBuscarMatricesDescuento;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOMatrizDescuento;
import es.indra.sicc.dtos.dto.DTOSCargarPaginaCrearMatrizDTO;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.dto.DTOEMatrizTipoClasificacion;


public interface MONMantenimientoMatrizDescuento extends EJBObject  {
    DTOSalida obtenerMarcasDTOMatrizSeleccionada(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerAccesosPorCanalDTOMatrizSeleccionada(DTOEMatrizCanal dto) throws RemoteException, MareException;

    DTOSalida obtenerSubaccesosMultiAccesoDTOMatrizSeleccionada(DTOEMatrizAccesos dto) throws RemoteException, MareException;

    DTOSalida obtenerCanalesDTOMatrizSeleccionada(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerTiposClienteDTOMatrizSeleccionada(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(DTOEMatrizTiposCliente dto) throws RemoteException, MareException;

    DTOSalida obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(DTOEMatrizSubtiposCliente dto) throws RemoteException, MareException;

    DTODatosMatrizDescuentos consultarMatrizDescuentos(DTOOID dto) throws RemoteException, MareException;

    void crearMatrizDescuentos(DTODatosMatrizDescuentos dto) throws RemoteException, MareException;

    void eliminarMatrizDescuentos(DTOOIDs dto) throws RemoteException, MareException;

    void copiarMatrizDescuentos(DTOMatrizDescuento dto) throws RemoteException, MareException;

    DTOSalida buscarMatricesDescuento(DTOBuscarMatricesDescuento dto) throws RemoteException, MareException;

    DTOSalida cargarParametrosMatrizDescuento() throws RemoteException, MareException;

    DTOSalida compruebaDescuentosAsociados(Integer oidCabeceraMatriz) throws RemoteException, MareException;

    DTOSCargarPaginaCrearMatrizDTO cargarPaginaCrearMatrizDescuento(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtenerSubaccesosDTOMatrizSeleccionada(DTOOID dto) throws RemoteException, MareException;


    DTOSalida obtenerSubtiposClienteDTOMatrizSeleccionada(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(DTOEMatrizTipoClasificacion dto) throws RemoteException, MareException;

  DTOSalida obtenerNumerosDescuentos(DTOOID dto) throws RemoteException, MareException;

}