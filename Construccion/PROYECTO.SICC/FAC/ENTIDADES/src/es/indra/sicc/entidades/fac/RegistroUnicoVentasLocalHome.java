package es.indra.sicc.entidades.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import java.sql.Date;
import java.math.BigDecimal;
import  javax.ejb.DuplicateKeyException;

public interface RegistroUnicoVentasLocalHome extends EJBLocalHome  {
	RegistroUnicoVentasLocal create() throws CreateException;

	RegistroUnicoVentasLocal findByPrimaryKey(Long primaryKey) throws FinderException;

	RegistroUnicoVentasLocal create( Long pais,
							Long sociedadVenta,
							//Long subacceso,  Incidencia 8146
							Date fechaEmision,
							BigDecimal baseImponible,
							BigDecimal importeImpuesto,
							BigDecimal importeTotal,
							String numeroIdentificacionFiscal,
							String nombre1,
							String nombre2,
							String apellido1,
							String apellido2,
							Long cliente,
							Boolean transferenciaGratuita,
							Long impuesto,
							Long tipoDocumentoLegal,
							Long numeroDocumentoLegal, // Cambiado a Long por la BELC300015038
							String serieDocumentoLegal,
							String fechaEmisionDocumento,
							Long oidTipoDocumentoIdentidad,
                                                        String valNombreCliente) 
						throws CreateException, DuplicateKeyException;

	RegistroUnicoVentasLocal create( Long pais,
							Long sociedadVenta,
							Long subacceso,
							String ejercicioDocumentoInterno, //tipo modificado por 10384
							Date fechaEmision,
							BigDecimal baseImponible,
							BigDecimal importeImpuesto,
							BigDecimal importeTotal,
							String puntoEmision,
							Long documentoInterno,
							String numeroIdentificacionFiscal,
							String numeroIdentificacionNacional,
							String serieDocumentoReferencia,
							Long numeroDocumentoReferencia, // Cambiado a Long por la BELC300015038
							String nombre1, 
							String nombre2,
							String apellido1,
							String apellido2,
							Long cliente,
							Boolean transferenciaGratuita,
							Long cabDocContable,
							Long impuesto,
							Long tipoDocumentoLegal,
							Long numeroDocumentoLegal, // Cambiado a Long por la BELC300015038
							String serieDocumentoLegal,
							Long tipoDocumentoReferencia, 
							BigDecimal interesesMora,
							BigDecimal descuento,
							BigDecimal comisiones, 
							BigDecimal flete,
							BigDecimal baseImponibleNeto,
							Boolean estado,
							Boolean facturaGratuita,
							Date fechaCierre,
							String estadoRUV,
							String documentoInternoHipersale,
							String fechaEmisionDocumento,
							Long oidTipoDocumentoIdentidad,
                                                        String valNombreCliente)
						throws CreateException, DuplicateKeyException;
}