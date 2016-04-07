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
package es.indra.sicc.entidades.ccc;

import java.math.BigDecimal;

import java.sql.Date;

//import java.sql.Time;  ==>> No es usado
import java.sql.Timestamp;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import es.indra.mare.common.exception.MareException;


//import java.rmi.RemoteException;  ==>> No es usado
public interface MovimientosBancariosLocalHome extends EJBLocalHome {
    MovimientosBancariosLocal create() throws CreateException;

    /**
     * Metodo create con los datos que no pueden ser null en BBDD
     * @see #aaa
     * @param oid Long con el valor del campo oid
     * @param empresa Long con el valor del campo empresa
     * @param tipoTransaccion Long con el valor del campo tipoTransaccion
     * @param cuentaCorriente Long con el valor del campo cuentaCorriente
     * @param consecutivoTransaccion Integer con el valor del campo consecutivoTransaccion
     * @param numeroLote Integer con el valor del campo numeroLote
     * @exception DuplicateKeyException Se produce cuando intentamos dar de alta
     * un registro con un oid que ya existe
     * @exception CreateException Se produce cuando hay algún error controlado
     * al intentar dar de alta un registro.
     * @return MovimientosBancariosLocal
     */
    MovimientosBancariosLocal create(Long empresa, Long subProcesoCreacion,
        Long cuentaCorriente, Long pais, Long consultoraReal,
        Long tipoAbonoCreacion,	Long consecutivoTransaccion,
        Long numeroLote) throws DuplicateKeyException, CreateException;

    MovimientosBancariosLocal create(String codigoConsultora,
        Long consultoraReal, String codigoError, Long consecutivoTransaccion,
        Integer digitoChequeoFactura, String documentoAplicacionAnyo,
        String documentoAplicacionMesSerie, Integer documentoAplicacionNumero,
        String documentoCreacionAnyo, String documentoCreacionMesSerie,
        Integer documentoCreacionNumero,
        String estatusMovimientoPendienteAplicado, Date fechaContabilizacion,
        Timestamp fechaMovimientoAplicacion, Date fechaPago, Date fechaProceso,
        Timestamp horaProceso, String horarioNormalAdicional,
        String identificadorProceso, BigDecimal importePago,
        String nombreOficina, String numeroDocumento, Long numeroFacturaBoleta,
        Long numeroLote, String numeroLoteContabilizacion,
        String observaciones, 
        //modificado el tipo a String poir inc 21735
        String oficinaRecaudadora,
        String usuarioProceso, Long numeroCupon, Long empresa,
        Long tipoAbonoCreacion, Long tipoAbonoUltimo, Long tipoTransaccion,
        Long subprocesoMarcaCreacion, Long subprocesoMarcasUltimo,
        Long cuentaCorriente, Long numeroLoteExterno, Long nMovimientoCaja,
        BigDecimal saldoPendiente, String codigoUsuario,
        Integer numeroHistoria, BigDecimal importeAplicado, Long error,
        Long pais, Long subacceso, Long oidCliente)
        throws CreateException, DuplicateKeyException;

    MovimientosBancariosLocal findByPrimaryKey(Long primaryKey)
        throws FinderException;

    MovimientosBancariosLocal findByUK(Long pais, Long numeroLote,
        Long consecutivoTransaccion) throws FinderException;

    Collection findByParametros(Long cuentaCorriente, java.sql.Date fechaPago,
        BigDecimal importePago, Long consultoraReal)
        throws FinderException, Exception;

    Collection findAll() throws FinderException, Exception;

  

  MovimientosBancariosLocal create(Long oidSociedad, Long oidSubpMarcaCreacion, Long oidAbonoCreacion, Long oidCuentaCorriente, Long oidPais) throws MareException, CreateException;
}
