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

import es.indra.sicc.dtos.ccc.DTOAlerta;
import es.indra.sicc.dtos.ccc.DTOGenerarAlertas;
import es.indra.sicc.dtos.ccc.DTOMovBancIndicadores;


import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ccc.DTORecuperacionTASPYMarcas;
import es.indra.sicc.dtos.ccc.DTORespuestaCancelacion;
import es.indra.sicc.dtos.ccc.DTOGenerarRegistrosCargosYAbonos;


public interface MONActualizarCCporAplicacion extends EJBObject {
    DTOMovBancIndicadores procesarMovBancporAplicacion(
        DTOMovBancIndicadores dto) throws MareException, RemoteException;

    DTOAlerta generarAlertas(DTOGenerarAlertas dto)
        throws MareException, RemoteException;

	void validarAlertas(DTOMovimientoBancario dto, Boolean indicadorSaldoUnico) throws MareException, RemoteException;

	Long validarCupon3(DTOMovimientoBancario dto, long numeroDiasCruceCupon3, boolean aplicaCupon3) throws RemoteException, MareException;

	DTORecuperacionTASPYMarcas recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto) throws MareException, RemoteException;

	DTORespuestaCancelacion cancelarCCSaldoUnico(DTORecuperacionTASPYMarcas dto) throws MareException, RemoteException;

	DTORespuestaCancelacion cancelarCCSaldoNoUnico(DTORecuperacionTASPYMarcas dto) throws MareException, RemoteException;

	void generarRegistrosCargosYAbonos(DTOGenerarRegistrosCargosYAbonos dto) throws MareException, RemoteException;
}
