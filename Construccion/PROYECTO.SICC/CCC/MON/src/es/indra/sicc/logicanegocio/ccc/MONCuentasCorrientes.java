/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes;
import es.indra.sicc.dtos.ccc.DTOBuscarCuentasCorrientes;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ccc.DTONumeroRegistros;
import es.indra.sicc.dtos.ccc.DTONumerosLineaVistaLotes;


import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOIDs;
//import java.math.BigDecimal;
import es.indra.sicc.dtos.ccc.DTORevertirCCFac;

// Puesto por GPM para que compile 14/09/2004
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ccc.DTOBuscarLotesTrabajo;
import es.indra.sicc.dtos.ccc.DTOSiguienteNumeroCupon;
import es.indra.sicc.dtos.ccc.DTORepConsultaCCC;
import es.indra.sicc.dtos.ccc.DTOSaldoCampana;
import es.indra.sicc.dtos.ccc.DTORepBusquedaCC;
import es.indra.sicc.dtos.ccc.DTODetalleCargos;
import es.indra.sicc.dtos.ccc.DTOBloqueo;
import es.indra.sicc.dtos.ccc.DTOSigNroCupTram;


public interface MONCuentasCorrientes extends EJBObject  {
	public void retrocesoCuenta(DTOMovimientoCuentaCompleto dtoMov) throws MareException, RemoteException;
	//public void retrocesoCuenta(Long movimiento, Integer numeroHistoria) throws MareException, RemoteException;
	
	public DTOSalida buscarCuotasPendientesCancelacion(DTOBuscarCuentasCorrientes criterios) throws MareException, RemoteException;

	public void actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta) throws MareException, RemoteException;

	public DTOSalida cargaInicialAplicacionCobros(DTOOID dto) throws MareException, RemoteException;

	public DTOSalida buscarCuotasPendientes(DTOBuscarCuotasPendientes dto) throws MareException, RemoteException;

	DTOSalida obtieneSucursalesBanco(DTOOID dto) throws RemoteException, MareException;

	DTOSalida obtieneCuentasSucursal(DTOOID dto) throws RemoteException, MareException;

	DTOSalida obtenerDetalleMovimientos(DTOOIDs dto) throws MareException, RemoteException;

	DTONumeroRegistros eliminarBloqueoMovCC(DTOOIDs dto) throws RemoteException, MareException;

	DTONumeroRegistros eliminarBloqueoMovBanc(DTOOIDs dto) throws RemoteException, MareException;

	void retrocesoMovBancario(DTOMovimientoBancario dto) throws MareException, RemoteException;


	Boolean estanBloqueadosMovCC(DTOOIDs dto) throws MareException, RemoteException;

	Boolean estanBloqueadosMovBanc(DTOOIDs dto) throws MareException, RemoteException;

	Boolean estaBloqueadoMovCC(DTOOID dto) throws MareException, RemoteException;

	Boolean estaBloqueadoMovBanc(DTOOID dto) throws MareException, RemoteException;


	Boolean bloquearMovCC(DTOOID dto) throws MareException, RemoteException;


	Boolean bloquearMovBanc(DTOOID dto) throws MareException, RemoteException;


	void revertirCCFac(DTORevertirCCFac dto) throws MareException, RemoteException;


	
	//public void actualizarMovBancario(DTOMovimientoBancario movimientoBanc) throws MareException, RemoteException;

    	DTOSalida buscarLotesTrabajo(DTOBuscarLotesTrabajo dto) throws MareException, RemoteException; 

    	void eliminarLotes(DTOOIDs dto) throws MareException, RemoteException;

  	 DTOSalida obtieneBancos(DTOBelcorp dto) throws MareException, RemoteException; 

 	 DTOSalida obtieneCCPorBanco(DTOOID dto) throws MareException, RemoteException; 

   	 DTOOID insertarMovimientoBancario(DTOMovimientoBancario dto) throws RemoteException, MareException; 

 	 DTOSalida obtienePorEmpresa(DTOOID dto) throws MareException, RemoteException; 

  	 DTOSalida obtenerTiposTransaccion(DTOBelcorp dto) throws MareException, RemoteException;

	void generarCuentaCorriente(DTOMovimientoCuentaCompleto dto[]) throws MareException, RemoteException;

	void cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos, String tipoDeuda) throws RemoteException, MareException;


    void procesarLote(DTOOIDs dto) throws RemoteException, MareException;


    DTONumeroRegistros eliminarBloqueoMovCC()
        throws RemoteException, MareException;

    DTOSalida obtenerMovimientosLote(DTONumerosLineaVistaLotes dto)
        throws RemoteException, MareException, RemoteException;

    Boolean bloquearMovCC(DTOOIDs dtoOIDs) throws RemoteException, MareException;

	Boolean bloquearMovBanc(DTOOIDs dtos) throws MareException, RemoteException;

	Boolean sigueBloqueadoMovCC(DTOOIDs dtos) throws  RemoteException, MareException, RemoteException;

	Boolean sigueBloqueadoMovCC(DTOOID dto) throws RemoteException, MareException;

	Boolean sigueBloqueadoMovBanc(DTOOIDs dtos) throws  RemoteException, MareException, RemoteException;

	Boolean sigueBloqueadoMovBanc(DTOOID dto) throws MareException, RemoteException;

	DTONumeroRegistros eliminarBloqueoMovBanc() throws RemoteException, MareException;

	DTOSalida bloquearBloqueoMovBanc() throws  RemoteException, MareException, RemoteException;

	DTOSalida bloquearBloqueoMovCC() throws MareException, RemoteException;

	DTOSalida obtenerSituacionesCupon() throws RemoteException, MareException;

	void actualizarMovBancario(DTOMovimientoBancario movimientoBanc) throws MareException, RemoteException;


	DTOSiguienteNumeroCupon siguienteNumeroCuponTramite(DTOBelcorp dto) throws MareException, RemoteException;

    /** 
     * Método para generar un movimiento bancario bel
     * @param dto DTOMovimientoBancario con los datos del movimiento bancario
     * @exception MareException si no se pudo generara el movimiento
     */
    void generarMovimientoBEL (DTOMovimientoBancario dto) throws MareException, RemoteException;

  DTOSalida recargaCC(DTOBelcorp dto) throws MareException, RemoteException;

  DTORepConsultaCCC repConsultaCC(DTORepBusquedaCC dto) throws RemoteException, MareException;

  DTOSaldoCampana obtenerSaldoCampana(DTOSaldoCampana dto) throws RemoteException, MareException;

  DTODetalleCargos obtenerDetalleCargos(DTOOID dto) throws RemoteException, MareException;

  void aplicacionAutomaticaDeudaPositivaFacturacion(DTOMovimientoCuentaCompleto[] dtos) throws MareException, RemoteException;

  Integer obtenerSecuenciaPais(DTOBelcorp dtoBelcorp) throws RemoteException, MareException;

    DTOSalida obtenerCuentasCorrientesBancarias(DTOBelcorp dtoE) throws MareException, RemoteException;

   void actualizarCuentaDos(DTOMovimientoCuentaCompleto movimientoCuenta) throws MareException, RemoteException;

   void insertarBloqueo(DTOBloqueo dto) throws MareException, RemoteException;

   void eliminarBloqueo(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSiguienteNumeroCupon siguienteNumeroCuponTramiteNuevo(DTOSigNroCupTram dto) throws RemoteException, MareException;

    DTOSalida obtenerSituacionesCuponTodas() throws RemoteException, MareException;

}