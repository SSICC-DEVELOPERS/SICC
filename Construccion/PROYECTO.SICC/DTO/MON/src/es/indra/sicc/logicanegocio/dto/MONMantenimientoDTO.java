package es.indra.sicc.logicanegocio.dto;


import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.dto.*;
import es.indra.sicc.util.*;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClienteDTO;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.dto.DTOSAlcanceTipoClienteDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentos;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;
import es.indra.sicc.dtos.dto.DTODescuento;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.inc.DTODescuentosIncentivos;
import es.indra.sicc.dtos.dto.DTOCodigoClienteDto;
import es.indra.sicc.dtos.dto.DTODescuentoCliente;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.dtos.dto.DTOListaDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOListaBasesAplicacionDto;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTOEBuscarProductosDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceAdministrativoDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOEAlcanceTipoCliente;
import es.indra.sicc.dtos.dto.DTOEBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOEBaseCalculo;

public interface MONMantenimientoDTO extends EJBObject  {
	DTOSalida buscarDescuentos(DTOEBuscarDescuentos dto) throws RemoteException, MareException;
  
	DTOSalida buscarDescuentosOrdenacion(DTOEBuscarDescuentosOrdenacion dto) throws RemoteException, MareException;

	DTOOID guardarDescuentoDG(DTOGlobalDescuento dtoe) throws RemoteException, MareException;

	void guardarOrdenacionDTO(DTOEDescuentosOrdenacion dto) throws RemoteException, MareException;

	void eliminarDescuentos(DTOOIDs dto) throws RemoteException, MareException;

	// Revisar PArametro Entrada
	DTOSalida consultarAlcanceAdministrativoDTO(DTOOID dto) throws RemoteException, MareException;

	DTOSalida consultarAlcanceClienteDTO(DTOEBuscarAlcanceClienteDTO dto) throws RemoteException, MareException;

	DTOSBaseCalculo consultarBaseCalculoDTO(DTOOID dto) throws RemoteException, MareException;

	DTOSalida consultarProductosDTO(DTOEBuscarProductosDTO dto) throws RemoteException, MareException;

	DTOSBaseAplicacion consultarBaseAplicacionDTO(DTOOID dto) throws RemoteException, MareException;

	void guardarAlcanceTipoCliente(DTOEAlcanceTipoCliente dto) throws RemoteException, MareException;

	void guardarAlcanceClasificacion(DTOEAlcanceClasificacionDTO dto) throws RemoteException, MareException;

	void guardarAlcanceCliente(DTOEDescuentoCliente dto) throws RemoteException, MareException;

	void guardarAlcanceAdministrativo(DTOEAlcanceAdministrativoDTO dto) throws RemoteException, MareException;

	void guardarBaseCalculoDTO(DTOEBaseCalculo dto) throws RemoteException, MareException;

	void guardarBaseAplicacionDTO(DTOEBaseAplicacion dto) throws RemoteException, MareException;

	DTOSalida buscarMatricesDTOActivas(DTOSiccPaginacion dto) throws RemoteException, MareException;

	void eliminarDTOSPorClasificacion(DTOOIDs dto) throws RemoteException, MareException;

	void eliminarDescuentosCliente(DTOOIDs dto) throws RemoteException, MareException;

	void eliminarAlcanceAdministrativoDTO(DTOOIDs dto) throws RemoteException, MareException;

	DTODescuentoDG consultarDescuentoDG(DTOOID dto) throws RemoteException, MareException;
/*
	DTOSalida consultarTiposClasificacionMatrizDTO(DTOOIDs dto) throws MareException, RemoteException;

*/	
    DTOSAlcanceTipoClienteDTO consultarAlcanceTipoClienteDTO(DTOOID dto) throws RemoteException, MareException;

	DTOSalida consultarAlcanceClasificacionDTO(DTOEBuscarAlcanceClasificacionDTO dto) throws RemoteException, MareException;

    DTOSPaginaAlcanceTiposClienteDetalle cargarPaginaAlcanceTiposClienteDetalle(DTOEMatrizSubtiposCliente dto) throws RemoteException, MareException;

    void guardarParametroNacional(DTODescuentoDG dto) throws RemoteException, MareException;

    DTOSalida obtenerDescuentosActivos(DTOSiccPaginacion dto) throws RemoteException, MareException;

    DTODescuento obtenerDescuento(DTOOID dto) throws RemoteException, MareException;

    DTOOIDs consultarBasesAplicacionDTO(DTOOID dto) throws RemoteException, MareException;

  DTOSalida buscarMatricesDTOActivasREP(DTOBelcorp dto) throws RemoteException, MareException;

  void ingresarDescuentosIncentivos(DTODescuentosIncentivos dtoDes) throws RemoteException, MareException;

    DTODescuentoCliente obtenerAlcanceClienteDetalle(DTOCodigoClienteDto dtoe) throws RemoteException, MareException;

    void guardarDatosDescuento(DTOGlobalDescuento dtoe) throws RemoteException, MareException;

    void guardarListaAlcanceCliente(DTOListaDescuentoCliente dto) throws RemoteException, MareException;

    DTOGlobalDescuento obtenerDatosDescuentos(DTOOID dtoe) throws RemoteException, MareException;

  DTODescuento obtenerDescuentoBatch(DTOOID dto) throws RemoteException, MareException;

    DTOSBaseAplicacion consultarBaseAplicacionDTOBatch(DTOOID dto) throws RemoteException, MareException;
    
}