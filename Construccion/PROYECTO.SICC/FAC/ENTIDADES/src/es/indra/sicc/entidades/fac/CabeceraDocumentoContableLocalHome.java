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

package es.indra.sicc.entidades.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import java.sql.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import javax.ejb.DuplicateKeyException;

public interface CabeceraDocumentoContableLocalHome extends EJBLocalHome  {

	CabeceraDocumentoContableLocal findByPrimaryKey(Long primaryKey) throws FinderException;

	CabeceraDocumentoContableLocal create(Long numDocumentoContableInterno, 
    Long zona, Long sugerenciaVenta, Long seccion, Long region, Long territorio, 
    Long empresa, Long formaPagoCabecera, Long clienteDirecion, Long pais, 
    Long periodo, Long subacceso, Long solicitudCabecera, Long formulario, 
    Long tipoDocumento, Timestamp fechaEmision, Timestamp fechaFacturacion, 
    Boolean status, String ejercicioDocumentoInterno, String nombre1, 
    String nombre2, String apellido1, String apellido2, 
    String numeroIdentificacionFiscal, Long numeroDocumentoLegal, 
    String serieDocumentoLegal, String direccionCompleta) throws  DuplicateKeyException, CreateException;

	CabeceraDocumentoContableLocal create(Long numDocumentoContableInterno, 
							Long zona, 
							Long sugerenciaVenta, 
							Long seccion, 
							Long region, 
							Long territorio, 
							Long empresa, 
							Long formaPagoCabecera, 
							Long clienteDirecion, 
							Long pais, 
							Long periodo, 
							Long subacceso, 
							Long solicitudCabecera, 
							Long formulario, 
							Long moneda, 
							Long tipoDocumento, 
							Timestamp fechaEmision, 
							Timestamp fechaFacturacion, 
							Boolean status, 
							String puntoEmision, 
							String ejercicioDocumentoInterno, 
							String numIdentificacionFiscal, 
							String numIdentificacionNacional, 
							String observaciones, 
							String nombre1, 
							String nombre2, 
							String apellido1, 
							String apellido2, 
							String serieDocumentolegal, 
							Integer numeroAbono, 
							Long numeroDocumentoLegal, 
							Integer unidadesAtendidasTotal,
							BigDecimal precioCatalogoTotalDocumento,
							BigDecimal precioCatalogoSinImpuestoTotalDocumento,
							BigDecimal precioContableTotalDocumento,
							BigDecimal precioContableSinImpuestoTotalDocumento,
							BigDecimal importeDescuento1TotalDocumento,
							BigDecimal importeDescuento1SinImpuestosTotalDocumento,
							BigDecimal importeDescuento3SinImpuestoTotalDocumento,
							BigDecimal importeDescuentoTotalDocumento,
							BigDecimal precioFacturaTotalDocumento,
							BigDecimal importeImpuestosTotalDocumento,
							BigDecimal precioTotalTotalDocumento,
							 Boolean indicadorImpresion,     
							 Long  numeroDocumentoOrigen,    
							 String tipoDireccion,    
							 String almacen,    
							 BigDecimal precioCatalogoSinImpuestoTotalLocal,                             
							 BigDecimal precioContableSinImpuestosTotalLocal,                             
							 BigDecimal precioCatalogoTotalLocal,                             
							 BigDecimal precioCatalogoTotalLocalUnidadesPorAtender,                             
							 BigDecimal precioContableTotalLocal,                             
							 BigDecimal importeDescuento1TotalLocal,                             
							 BigDecimal importeDescuento1SinImpuestosTotalLocal,                             
							 BigDecimal precioFacturaTotalLocal,                             
							 BigDecimal precioTotalTotalLocal,                             
							 BigDecimal importeDescuento3SinImpuestosTotalLocal,                             
							 BigDecimal importeDescuentoTotalLocal,                             
							 BigDecimal precioNetoTotalLocal,                             
							 BigDecimal importeImpuestosTotalLocal,                             
							 BigDecimal totalAPagarLocal,                             
							 BigDecimal totalAPagarDocumento,                             
							 BigDecimal importeRedondeoLocal,                             
							 BigDecimal importeRedondeoConsolidadoLocal,                                    
							 BigDecimal tipoCambio,                              
							 BigDecimal importeFleteTotalLocal,                             
							 BigDecimal importeFleteTotalDocumento,                             
							 BigDecimal importeDescuento3TotalLocal,                                          
							 BigDecimal importeDescuento3TotalDocumento,                                  
							 BigDecimal precioNetoTotalDocumento,
							 BigDecimal importeFleteSinImpuestosTotalDocumento,
							 BigDecimal importeRedondeoConsolidadoDocumento,                             
							 BigDecimal importeRedondeoDocumento,
                             Date fechaContable, 
                             String numeroLoteContable,
                             BigDecimal importeFleteSinImpuestosTotalLocal,
                             String direccionCompleta) throws CreateException, DuplicateKeyException;
}