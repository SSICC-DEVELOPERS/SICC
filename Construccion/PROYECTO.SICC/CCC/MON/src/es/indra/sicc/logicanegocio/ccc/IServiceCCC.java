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

public interface IServiceCCC  {

    DTOTotal calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto)
        throws MareException;

    DTOTotalyDias calcularDeudaVencidaCCCliente(DTOSaldosPorDiasPeriodos dto)
        throws MareException;

    DTOTotal calcularCuponTramiteCliente(DTOSaldosPorFechas dto)
        throws MareException;

    DTODias calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto)
        throws MareException;
}