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
package es.indra.sicc.logicanegocio.intsys;

public interface IECM 
{

	public static final String ECM1_CODIGO_PAIS 					= "codigoPais"; 
	public static final String ECM1_CODIGO_CANAL 					= "codigoCanal"; 
	public static final String ECM1_CODIGO_SOCIEDAD 				= "codigoSociedad"; 
	public static final String ECM1_CODIGO_MARCA 					= "codigoMarca"; 
	public static final String ECM1_CODIGO_CONSULTORA 				= "codigoConsultora"; 
	public static final String ECM1_ID_CLIENTE_INTERNET 			= "idClienteInternet"; 
	public static final String ECM1_FECHA_INTERNET 					= "fechaInternet"; 
	public static final String ECM1_IMPORTE_VENTA_INTERNET 			= "importeVentaInternet"; 
	public static final String ECM1_IMPORTE_ABONO_CONSULTORA 		= "importeAbonoConsultora"; 
    
	public static final String ECM2_CODIGO_CLIENTE 					= "codigoCliente"; 
	public static final String ECM2_CODIGO_PAIS 					= "codigoPais"; 
	public static final String ECM2_APELLIDO_PATERNO 				= "apellidoPaterno";
	public static final String ECM2_APELLIDO_MATERNO 				= "apellidoMaterno"; 
	public static final String ECM2_APELLIDO_CASADA 				= "apellidoCasada"; 
	public static final String ECM2_NOMBRE_PRIMERO 					= "nombrePrimero"; 
	public static final String ECM2_NOMBRE_SEGUNDO 					= "nombreSegundo"; 	
	public static final String ECM2_FECHA_NACIMIENTO 				= "fechaNacimiento"; 
	public static final String ECM2_SEXO 							= "sexo"; 
	public static final String ECM2_TIPO_CLIENTE 					= "tipoCliente"; 
	public static final String ECM2_SUBTIPO_CLIENTE 				= "subtipoCliente"; 
	public static final String ECM2_NACIONALIDAD 					= "nacionalidad"; 
	public static final String ECM2_ESTADO_CIVIL 					= "estadoCivil"; 
	public static final String ECM2_TIPO_DOCUMENTO 					= "tipoDocumento"; 
	public static final String ECM2_NUMERO_DOCUMENTO 				= "numeroDocumento"; 
	public static final String ECM2_UBI_GEO 						= "ubiGeo"; 
	public static final String ECM2_CODIGO_MARCA 					= "codigoMarca";
	public static final String ECM2_CODIGO_PAIS_ANTIGUO 			= "codigoPaisAntiguo"; 
	public static final String ECM2_CODIGO_CLIENTE_ANTIGUO 			= "codigoClienteAntiguo"; 
	public static final String ECM2_CODIGO_CANAL 					= "codigoCanal"; 
	public static final String ECM2_PROFESION 						= "profesion"; 
	public static final String ECM2_OCUPACION 						= "ocupacion"; 
	public static final String ECM2_ESPECIALIDAD 					= "especialidad"; 
	public static final	String ECM2_CENTRO_TRABAJO 					= "centroTrabajo"; 
	public static final String ECM2_CARGO 							= "cargo"; 
	public static final String ECM2_NIVEL_ESTUDIOS 					= "nivelEstudios"; 
	public static final String ECM2_CENTRO_ESTUDIOS 				= "centroEstudios"; 
	public static final String ECM2_NUMERO_HIJOS 					= "numeroHijos"; 
	public static final String ECM2_TIPO_CLASIFICACION 				= "tipoClasificacion";
	public static final String ECM2_CLASIFICACION 					= "clasificacion"; 
	public static final String ECM2_TIPO_COMUNICACION 				= "tipoComunicacion"; 
	public static final String ECM2_TEXTO_MEDIO_COMUNICACION 		= "textoMedioComunicacion"; 
	public static final String ECM2_TIPO_CONTACTO 					= "tipoContacto"; 
	public static final String ECM2_FECHA_CONTACTO	 				= "fechaContacto"; 
	public static final String ECM2_TIPO_VINCULO 					= "tipoVinculo"; 
	public static final String ECM2_CODIGO_CLIENTE_VINCULO 			= "codigoClienteVinculo"; 
	public static final String ECM2_FECHA_DESDE 					= "fechaDesde"; 
	public static final String ECM2_FECHA_HASTA 					= "fechaHasta"; 
	public static final String ECM2_IND_VINCULO_PRINCIPAL 			= "indVinculoPrincipal"; 
        public static final String ECM2_IND_CONFIRMACION_COMUNICACION  ="indicadorConfirmacion";
    //Añadido por incidencia 14908
    public static final String ECM2_TIPO_VIA                        = "tipoVia";
    public static final String ECM2_NOMBRE_VIA                      = "nombreVia";
    public static final String ECM2_NUMERO_PRINCIPAL                = "numeroPrincipal";
    
    // gPineda - 15/03/2007 - Sicc 20070112
    public static final String ECM2_ESTATUS                         = "estado";
    //  Agregado por HRCS - 04/09/2007 - Cambio Sicc20070385
    public static final String ECM2_CODIGO_CANAL_ANTIGUO			= "codigoCanalAntiguo";
    public static final String ECM2_TRATAMIENTO			            = "tratamiento";
    public static final String ECM2_FORMA_PAGO			            = "formaPago";
    //  Agregado por HRCS  13/09/2007 - Cambio Sicc20070416
    public static final String ECM2_IND_CORRESPONDENCIA			    = "indCorrespondencia";
    public static final String ECM2_IND_COMUNICACION_PRINCIPAL      = "indComunicacionPrincipal";
}