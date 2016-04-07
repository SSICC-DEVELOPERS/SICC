/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.bel.DTOReportePedidos;


public interface IGenerarMovimientoAlmacen {
   
   DTOReportePedidos grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dto)throws MareException ;
   void reversionMovimientoAlmacen(DTOReversionMovimiento dto)throws MareException ; 
}