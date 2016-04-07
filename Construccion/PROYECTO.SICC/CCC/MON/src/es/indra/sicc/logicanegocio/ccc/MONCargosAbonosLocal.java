package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOBuscarCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOBuscarMovimientosReasignacion;
import es.indra.sicc.dtos.ccc.DTOCargaInicialCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTOCargaInicialGeneracionVencimientos;
import es.indra.sicc.dtos.ccc.DTOCargaMasiva;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCasoUso;
import es.indra.sicc.dtos.ccc.DTOConceptosGastosAbonos;
import es.indra.sicc.dtos.ccc.DTODatosCargaInicialConceptos;
import es.indra.sicc.dtos.ccc.DTOObtenerCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOParametrosSubproceso;
import es.indra.sicc.dtos.ccc.DTOReasignacionPagos;
import es.indra.sicc.dtos.ccc.DTOValidarNumeroDocumento;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;

import javax.ejb.EJBLocalObject;

public interface MONCargosAbonosLocal extends EJBLocalObject 
{
  void aplicarCargosAbonos(DTOCargosAbonos dto) throws MareException;

  DTOString bloquearCliente(DTOString dto) throws MareException;

  DTOSalida buscar(DTOBuscarCargosAbonos dto) throws MareException;

  short cancelacionCuotas(RecordSet movimientos, CabeceraCargosAbonosDirectosLocal cabecera, short numDetalle, DTOParametrosSubproceso parametros, DTOCargosAbonos dtoCargosAbonos) throws MareException;

  DTODatosCargaInicialConceptos cargaInicialConceptos(DTOCargaInicialConceptos dto) throws MareException;

  DTOCargaInicialGeneracionVencimientos cargaInicialVencimientos(DTOBelcorp dto) throws MareException;

  void eliminar(DTOOIDs oids) throws MareException;

  void enviarMensaje(DTOConceptosGastosAbonos dto) throws MareException;

  void enviarMensajesGastosAbonos(RecordSet conceptos, Long pais) throws MareException;

  DTOCargosAbonos obtener(DTOObtenerCargosAbonos dto) throws MareException;

  DTOCargaInicialCargosAbonos obtenerDatosInicialesCargosAbonos(DTOCasoUso dto) throws MareException;

  DTOSalida obtenerDatosInicialesProcesos(DTOBelcorp dto) throws MareException;

  DTOSalida obtenerTiposCargo(DTOBelcorp dto) throws MareException;

  DTOSalida recargaSubprocesos(DTOOID dto) throws MareException;

  DTOCargaMasiva validarCarteraMasiva(DTOCargaMasiva cartera) throws MareException;

  DTOCargaInicialCargosAbonos obtenerNumeroIdentificacion(DTOCasoUso dto) throws MareException;

  DTOString validarNumeroDocumento(DTOValidarNumeroDocumento dto) throws MareException;

   void validarBloqueo(DTOBelcorp dto) throws MareException;

    DTOSalida buscarBancosReasignar(DTOBuscarMovimientosReasignacion dtoe) throws MareException;

  void reasignarBancos(DTOReasignacionPagos dtoE) throws MareException;
}