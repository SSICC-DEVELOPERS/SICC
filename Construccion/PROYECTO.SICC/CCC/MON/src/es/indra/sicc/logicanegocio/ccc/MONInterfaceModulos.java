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

import es.indra.sicc.dtos.ccc.DTODias;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTOEtapasDeCobranzas;


public interface MONInterfaceModulos extends EJBObject {
    DTOTotal calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto)
        throws MareException, RemoteException;

    DTOTotalyDias calcularDeudaVencidaCCCliente(DTOSaldosPorDiasPeriodos dto)
        throws MareException, RemoteException;

    DTOTotal calcularCuponTramiteCliente(DTOSaldosPorFechas dto)
        throws MareException, RemoteException;

    DTODias calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto)
        throws RemoteException, MareException;

	DTOTotal consultarCuentasCastigadasCliente(DTOSaldosPorFechasyVtos dto)
		throws RemoteException, MareException;

  DTOSalida consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto) throws RemoteException, MareException;

  Integer obtenerNroVecesProntoPago(Long oidCliente, Long oidPais) throws MareException, RemoteException;

  Integer obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais) throws MareException, RemoteException;

    String calcularSaldosCuentaCorriente(Long pais, Long codCliente) throws RemoteException, MareException;
}
