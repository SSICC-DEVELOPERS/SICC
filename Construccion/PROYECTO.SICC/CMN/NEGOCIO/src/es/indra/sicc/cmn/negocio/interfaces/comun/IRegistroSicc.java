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

/**
 * pperanzola - 14/09/2005
 *      [1] se agrega la constante SAM4_CODIGO_UNICO_VENTA
 */
package es.indra.sicc.cmn.negocio.interfaces.comun;

public interface IRegistroSicc 
{
   // BAN-1
    public static final String BAN1_CODIGO_BANCO_SICC = "codigoBancoSICC";
    public static final String BAN1_CODIGO_CONSULTORA = "codigoConsultora";
    public static final String BAN1_CODIGO_PAIS = "codigoPais";
    public static final String BAN1_CONSECUTIVO_TRANSACCION = "consecutivoTransaccion";
    public static final String BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA = "digitoChequeoNumeroFactura";
    public static final String BAN1_EMPRESA = "empresa";
    public static final String BAN1_FECHA_PAGO = "fechaPago";
    public static final String BAN1_FECHA_PROCESO = "fechaProceso";
    public static final String BAN1_HORARIO_NORMAL_ADICIONAL = "horarioNormalAdicional";
    public static final String BAN1_HORA_PROCESO = "horaProceso";
    public static final String BAN1_NOMBRE_OFICINA = "nombreOficina";
    public static final String BAN1_NUMERO_CUPON = "numeroCupon";
    public static final String BAN1_NUMERO_DOCUMENTO = "numeroDocumento";
    public static final String BAN1_NUMERO_FACTURA_BOLETA = "numeroFacturaBoleta";
    public static final String BAN1_NUMERO_LOTE = "numeroLote";
    public static final String BAN1_OFICINA_RECAUDADORA = "oficinaRecaudadora";
    public static final String BAN1_TIPO_TRANSACCION = "tipoTransaccion";
    public static final String BAN1_USUARIO_PROCESO = "usuarioProceso";
    public static final String BAN1_VALOR_PAGO = "valorPago";
    
    // BAN-2
    public static final String BAN2_APELLIDO1 = "apellido1";
    public static final String BAN2_APELLIDO2 = "apellido2";
    public static final String BAN2_CLASIFICACION = "clasificacion";
    public static final String BAN2_CODIGO_CONSULTORA = "codigoConsultora";
    public static final String BAN2_CODIGO_SUBTIPO_CLIENTE = "codigoSubtipoCliente";
    public static final String BAN2_CODIGO_TIPO_CLIENTE = "codigoTipoCliente";
    public static final String BAN2_DEUDA = "deuda";
    public static final String BAN2_DIGITO_CHEQUEO_CLIENTE = "digitoChequeoCliente";
    public static final String BAN2_DIGITO_CONTROL_DOCUMENTO_IDENTIDAD = "digitoControlDocumentoIdentidad";
    public static final String BAN2_NOMBRE1 = "nombre1";
    public static final String BAN2_NOMBRE2 = "nombre2";
    public static final String BAN2_NUMERO_DOCUMENTO_IDENTIDAD = "numeroDocumentoIdentidad";
    public static final String BAN2_TIPO_CLASIFICACION = "tipoClasificacion";
    public static final String BAN2_TIPO_DOCUMENTO = "tipoDocumento";
    public static final String BAN2_ZONA_CONSULTORA = "zonaConsultora";
    
    // BAN-3
    public static final String BAN3_CODIGO_CONSULTORA = "codigoConsultora";
    public static final String BAN3_CODIGO_EMPRESA = "codigoEmpresa";
    public static final String BAN3_CONSULTORA_APELLIDO1 = "apellido1";
    public static final String BAN3_CONSULTORA_APELLIDO2 = "apellido2";
    public static final String BAN3_CONSULTORA_NOMBRE1 = "nombre1";
    public static final String BAN3_CONSULTORA_NOMBRE2 = "nombre2";
    public static final String BAN3_DEUDA = "deuda";
    public static final String BAN3_DIGITO_CONTROL_CHEQUEO = "digitoControlChequeo";
    public static final String BAN3_DIGITO_CONTROL_DOCUMENTO_IDENTIDAD = "digitoControlDocumentoIdentidad";
    public static final String BAN3_FECHA_DOCUMENTO = "fechaDocumento";
    public static final String BAN3_FECHA_VENCIMIENTO = "fechaVencimiento";
    public static final String BAN3_MODO_PAGO = "modoPago";
    public static final String BAN3_NUMERO_DOCUMENTO_IDENTIDAD = "numeroDocumentoIdentidad";
    public static final String BAN3_NUMERO_FACTURA_BOLETA = "numeroFacturaBoleta";
    public static final String BAN3_PERIODO = "periodo";
    public static final String BAN3_REFERENCIA_EXTERNA = "referenciaExterna";
    public static final String BAN3_TIPO_DOCUMENTO = "tipoDocumento";
    public static final String BAN3_TIPO_PERIODO = "tipoPeriodo";
    public static final String BAN3_ZONA_CONSULTORA = "zonaConsultora";
    
    // GIS-3
    public static final String GIS3_ACTIVO = "activo";
    public static final String GIS3_CODIGO_PAIS = "codigoPais";
    public static final String GIS3_CODIGO_TIPO_VIA = "tipoVia";
    public static final String GIS3_CODIGO_VIA = "codigoVia";
    public static final String GIS3_NOMBRE_VIA = "nombreVia";
    
    // SAM-1
    public static final String SAM1_CODIGO = "codigo";
    public static final String SAM1_CODIGO_IDIOMA = "codigoIdioma";
    public static final String SAM1_DESCRIPCION = "descripcion";
    
    // SAM-2
    public static final String SAM2_CODIGO_IDIOMA = "codigoIdioma";
    public static final String SAM2_CODIGO_SUPERGENERICO = "codigo";
    public static final String SAM2_DESCRIPCION = "descripcion";
    
    // SAM-3
    public static final String SAM3_CODIGO_GENERICO = "codigoGenerico";
    public static final String SAM3_CODIGO_IDIOMA = "codigoIdioma";
    public static final String SAM3_DESCRIPCION = "descripcion";
    
    // SAM-4
    public static final String SAM4_CODIGO_SAP = "codigoSAP";
    public static final String SAM4_DESCRIPCION_SAP = "descripcionSAP";
    public static final String SAM4_DIMENSION_ALTO = "dimensionAlto";
    public static final String SAM4_DIMENSION_ANCHO = "dimensionAncho";
    public static final String SAM4_DIMENSION_LARGO = "dimensionLargo";
    public static final String SAM4_ESTATUS_PRODUCTO = "estatusProducto";
    public static final String SAM4_GENERICO = "generico";
    public static final String SAM4_INDICADOR_DENTRO_FUERA_CAJA_BOLSA = "indicadorDentroFueraCajaBolsa";
    public static final String SAM4_INDICADOR_PRODUCTO_SERVICIO = "indicadorProductoServicio";
    public static final String SAM4_JERARQUIA_1 = "jerarquia1";
    public static final String SAM4_JERARQUIA_2 = "jerarquia2";
    public static final String SAM4_JERARQUIA_3 = "jerarquia3";
    public static final String SAM4_MARCA = "marca";
    public static final String SAM4_NEGOCIO = "negocio";
    public static final String SAM4_PAIS = "codigoPais";
    public static final String SAM4_PESO_BRUTO = "pesoBruto";
    public static final String SAM4_PRECIO_COSTE_ESTANDAR = "precioCosteEstandar";
    public static final String SAM4_SUPERGENERICO = "supergenerico";
    public static final String SAM4_UNIDAD_CODIGO_ANTIGUO = "codigoAntiguo";
    public static final String SAM4_UNIDAD_MEDIDA_PESO = "unidadMedidaPeso";
    public static final String SAM4_UNIDAD_MEDIDA_VOLUMEN = "unidadMedidaVolumen";
    public static final String SAM4_UNIDAD_NEGOCIO = "unidadNegocio";
    public static final String SAM4_VOLUMEN = "volumen";
    public static final String SAM4_GRUPO_ARTICULOS = "grupoArticulos";
    public static final String SAM4_CODIGO_UNICO_VENTA = "codigoUnicoVenta"; //[1]
    

    
    // SAM-5
    public static final String SAM5_CODIGO_IDIOMA = "codigoIdioma";
    public static final String SAM5_CODIGO_PRODUCTO = "codigoProducto";
    public static final String SAM5_DESCRIPCION_EN_IDIOMA = "descripcionEnIdioma";
    public static final String SAM5_PAIS = "codigoPais";
    
    // SAM-6
    public static final String SAM6_ALMACEN_SICC = "almacenSICC";
    public static final String SAM6_CODIGO = "codigoPais";
    public static final String SAM6_PRODUCTO_SAP = "productoSAP";
    public static final String SAM6_STOCK_LIBRE_DISPOSICION = "stockLibreDisposicion";
    
    // SAM-7
    public static final String SAM7_NUMEROLOTE = "numeroLote";
    public static final String SAM7_ACCESO = "acceso";
    public static final String SAM7_ALMACEN_DESTINO_SICC = "almacenDestinoSICC";
    public static final String SAM7_ALMACEN_NUMERO_DOCUMENTO = "numeroDocumento";
    public static final String SAM7_ALMACEN_ORIGEN_SICC = "almacenOrigenSICC";
    public static final String SAM7_CANAL = "canal";
    public static final String SAM7_CANTIDAD = "cantidad";
    public static final String SAM7_CODIGO_SAP = "codigoSAP";
    public static final String SAM7_FECHA = "fecha";
    public static final String SAM7_INDICADOR_IST = "indicadorIST";
    public static final String SAM7_MARCA_PRODUCTO = "marcaProducto";
    public static final String SAM7_NEGOCIO = "negocio";
    public static final String SAM7_PAIS = "codigoPais";
    public static final String SAM7_PERIODO = "periodo";
    public static final String SAM7_PRECIO_CONTABLE = "precioContable";
    public static final String SAM7_PRECIO_VENTA_NETO = "precioVentaNeto";
    public static final String SAM7_SUBACCESO = "subacceso";
    public static final String SAM7_TIPO_MOVIMIENTO = "tipoMovimiento";
    public static final String SAM7_TIPO_OFERTA = "tipoOferta";
    public static final String SAM7_TIPO_PERIODO = "tipoPeriodo";
    //Agregado por Cristian Valenzuela - 26/9/2005 (CAMBIOS SAM01)
    public static final String SAM7_TIPO_POSICION = "tipoPosicion";   
    public static final String SAM7_SUBTIPO_POSICION = "subtipoPosicion";    
    //FIN - Agregado por Cristian Valenzuela - 26/9/2005
    
    // SAM50
    public static final String SAM50_PAIS = "pais";
    public static final String SAM50_CANAL = "canal";
    public static final String SAM50_ACCESO = "acceso";
    public static final String SAM50_SUBACCESO = "subacceso";
    public static final String SAM50_FECHA_RECEPCION_INT = "fechaRecepcion";
    public static final String SAM50_CODIGO_PRODUCTO = "codigoProductoSAP";
    public static final String SAM50_UNIDADES_CONFIRMADAS = "cantidad";
    public static final String SAM50_NUMERO_SOLICITUD_REPOSICION = "numeroDocumento";
    
    // HIP
    public static final String HIP1_CODIGO_PAIS = "codigoPais"; 
    public static final String HIP1_CODIGO_SOCIEDAD = "codigoSociedad"; 
    public static final String HIP1_TIPO_IMPUESTO = "tipoImpuesto"; 
    public static final String HIP1_TASA_IMPUESTO = "tasaImpuesto"; 
    public static final String HIP1_TIPO_DOCUMENTO_LEGAL = "tipoDocumentoLegal"; 
    public static final String HIP1_SERIE_DOCUMENTO_LEGAL = "serieDocumentoLegal"; 
    public static final String HIP1_NUMERO_DOCUMENTO_LEGAL = "numeroDocumentoLegal"; 
    public static final String HIP1_FECHA_EMISION = "fechaEmision"; 
    public static final String HIP1_DOCUMENTO_INTERNO_BELCORP = "docuentoInternoBelcorp"; 
    public static final String HIP1_CODIGO_CLIENTE = "codigoCliente"; 
    public static final String HIP_NOMBRE_CLIENTE = "nombreCliente"; 
    public static final String HIP_TIPO_DOCUMENTO_IDENTIDAD = "tipoDocumentoIdentidad"; 
    public static final String HIP1_NUMERO_DOCUMENTO_IDENTIDAD = "numeroDocumentoIdentidad"; 
    public static final String HIP1_TIPO_DOCUMENTO_REFERENCIA = "tipoDocumentoReferencia"; 
    public static final String HIP1_SERIE_DOCUMENTO_REFERENCIA = "serieDocumentoReferencia"; 
    public static final String HIP1_NUMERO_DOCUMENTO_REFERENCIA = "numeroDocumentoReferencia"; 
    public static final String HIP1_INTERESES_MORA = "interesesMora"; 
    public static final String HIP1_BASE_IMPONIBLE = "baseImponible"; 
    public static final String HIP1_DESCUENTO = "descuento"; 
    public static final String HIP1_COMISIONES = "comisiones"; 
    public static final String HIP1_FLETE = "flete"; 
    public static final String HIP1_BASE_IMPONIBLE_NETO = "baseImponibleNeto"; 
    public static final String HIP1_IMPUESTO = "impuesto"; 
    public static final String HIP1_IMPUESTO_TOTAL = "importeTotal"; 
    public static final String HIP1_FACTURA_GRATUITA = "facturaGratuita"; 
    public static final String HIP1_CODIGO_SUBACCESO = "codigoSubacceso"; 
    public static final String HIP1_CODIGO_PUNTO_EMISION = "codigoPuntoEmision"; 
    public static final String HIP1_PROGRAM_ID = "programId"; 
    public static final String HIP1_CODIGO_USUARIO = "codigoUsuario"; 
    public static final String HIP1_HORA_PROCESO = "horaProceso"; 
    public static final String HIP1_FECHA_PROCESO = "fechaProceso"; 
    public static final String HIP_ESTADO_RUV = "estadoRUV"; 
    public static final String HIP1_INDICADOR_FACTURA_ANULADA = "indicadorFacturaAnulada"; 
    public static final String HIP1_FECHA_EMISION_DOCUMENTO = "fechaEmisionDocumentoReferencia"; 
    public static final String HIP1_TIPO_DOCUMENTO_IDENTIDAD = "codigoTipoDocumentoIdentidad";
    public static final String HIP1_VAL_NOMBRE_CLIENTE = "valNombreCliente";
    //COR1
    public static final String COR1_CODIGO_SOCIEDAD = "codigoSociedad"; 
    public static final String COR1_CLASE_SOLICITUD = "claseSolicitud";
    public static final String COR1_TIPO_SOLICITUD = "tipoSolicitud";
    public static final String COR1_CODIGO_CLIENTE = "codigoCliente"; 
    public static final String COR1_COD_REPARTIDOR_LARISSA = "codigoRepartidorLarissa";
    public static final String COR1_DOCU_IDENT_REPARTIDOR = "documentoIdentidadRepartidor";
    public static final String COR1_NUMERO_PEDIDO = "numeroPedido"; 
    public static final String COR1_CHIP = "chip";
    public static final String COR1_FECHA_INICIO_LINEA_SACADO = "fechaInicioLineaSacado";
    public static final String COR1_HORA_INICIO_LINEA_SACADO = "horaInicioLineaSacado"; 
    public static final String COR1_FECHA_FIN_LINEA_SACADO = "fechaFinLineaSacado";
    public static final String COR1_HORA_FIN_LINEA_SACADO = "horaFinLineaSacado"; 
    public static final String COR1_CANTIDAD_BULTOS = "cantidadBultos";
    public static final String COR1_FECHA_DESPACHO = "fechaDespacho";
    public static final String COR1_HORA_DESPACHO = "horaDespacho"; 
    public static final String COR1_NUMERO_DESPACHO = "numeroDespacho";//BELC300013388    
    
   //COR2 cambios por BELC300013348
    public static final String COR2_CHIP = "chip"; //cor-2                         
    public static final String COR2_CODIGO_ZONA = "codigoZona";//cor-2                      
    public static final String COR2_FECHA_FACTURACION = "fechaFacturacion";//cor-2          
    public static final String COR2_NUMERO_SECUENCIA = "numeroSecuencia"; //cor2
    public static final String COR2_FECHA_REPARTO = "fechaReparto";   //cor-2                      
    public static final String COR2_HORA_REPARTO = "horaReparto"; //cor-2                          
    public static final String COR2_TIPO_DIRECCION_REPARTO = "tipoDireccionReparto";//cor-2  

    // SAP F1
    public static final String SAPFI_NUMERO_LOTE_TRANSACCION = "numeroLoteTransaccion";
    public static final String SAPFI_PAIS = "pais";
    public static final String SAPFI_FECHA_CONTABLE = "fechaContable";
    public static final String SAPFI_SOCIEDAD = "sociedad";
    public static final String SAPFI_CANAL = "canal"; 
    public static final String SAPFI_ACCESO = "acceso"; 
    public static final String SAPFI_SUBACCESO = "subacceso";
    public static final String SAPFI_TIPO_PERIODO_COMERCIAL = "tipoPeriodoComercial";
    public static final String SAPFI_PERIODO_COMERCIAL = "periodoComercial";
    public static final String SAPFI_EJERCICIO_COMERCIAL = "ejercicioComercial";
    public static final String SAPFI_TIPOS_ASIENTO = "tiposAsiento";
    public static final String SAPFI_TIPO_MOVIMIENTO_SAPFI = "tipoMovimientoSAPFI";
    public static final String SAPFI_DOCUMENTO_IDENTIDAD_RUC_TRANSPORTISTA = "documentoIdentidadRUCTransportista";
    public static final String SAPFI_DESCRIPCION_APUNTE = "descripcionApunte";
    public static final String SAPFI_DEBE_HABER = "debeHaber";
    public static final String SAPFI_MARCA_PRODUCTO = "marcaProducto";
    public static final String SAPFI_GRUPO_ARTICULOS = "grupoArticulos";
    public static final String SAPFI_NEGOCIO_PRODUCTO = "negocioProducto";
    public static final String SAPFI_TIPO_OFERTA = "tipoOferta";
    public static final String SAPFI_CICLO_VIDA = "cicloVida";
    public static final String SAPFI_IMPORTE = "importe";
    public static final String SAPFI_MONEDA = "moneda";
    public static final String SAPFI_PERIODO_CONTABLE = "periodoContable";
    public static final String SAPFI_EJERCICIO_CONTABLE = "ejercicioContable";
    public static final String SAPFI_FECHA = "fecha";
    public static final String SAPFI_CODIGO_BANCO_SICC = "codigoBancoSICC";
    public static final String SAPFI_FECHA_PAGO_BANCOS = "fechaPagoBancos";
    public static final String SAPFI_FECHA_VALOR = "fechaValor";
    public static final String SAPFI_NUMERO_COMPROBANTE = "numeroComprobante";
    public static final String SAPFI_RECAUDADORA_SUCURSAL = "recaudadoraSucursal";
    public static final String SAPFI_ZONA = "zona";

    // GIS-6
    public static final String GIS6_CODIGO_MARCA = "codigoMarca";
    public static final String GIS6_CODIGO_CANAL = "codigoCanal";
    public static final String GIS6_CODIGO_PAIS = "codigoPais";    
    public static final String GIS6_CODIGO_ACCESO = "codigoAcceso";
    public static final String GIS6_CODIGO_SUBGERENCIA_VENTAS = "codigoSubgerenciaVentas";   
    public static final String GIS6_CODIGO_REGION = "codigoRegion";
    public static final String GIS6_CODIGO_ZONA = "codigoZona";    
    public static final String GIS6_CODIGO_SECCION = "codigoSeccion";
    public static final String GIS6_CODIGO_TERRITORIO = "codigoTerritorio";
    public static final String GIS6_CODIGO_CLIENTE = "codigoCliente";
    public static final String GIS6_CODIGO_PERIODO = "codigoPeriodo";
    public static final String GIS6_CODIGO_ATRIBUTO = "codigoAtributo";
    public static final String GIS6_VALOR_ATRIBUTO = "valorAtributo";
    
    // GEO-1
    public static final String GEO1_CODIGO_CLIENTE = "codigoCliente";
    public static final String GEO1_CODIGO_PAIS = "codigoPais";
    public static final String GEO1_CODIGO_TERRITORIO = "codigoTerritorio";
    public static final String GEO1_CODIGO_TIPO_DIRECCION = "codigoTipoDireccion";
    public static final String GEO1_CONTROL_INTERFACE_GEORREFERENCIADOR = "estado";
    public static final String GEO1_COORDENADA_X = "geoRreferenciaLongitud";
    public static final String GEO1_COORDENADA_Y = "geoRreferenciaLatitud";
    public static final String GEO1_COORDENADA_Z = "altura";
    public static final String GEO1_DIRECCIONES = "direcciones";
    public static final String GEO1_NIVEL_SOCIO_ECONOMICO = "nivelSocioEconomico";
    public static final String GEO1_UBIGEO_NIVEL_1 = "codigoUbigeoNivel1";
    public static final String GEO1_UBIGEO_NIVEL_2 = "codigoUbigeoNivel2";
    public static final String GEO1_UBIGEO_NIVEL_3 = "codigoUbigeoNivel3";
    public static final String GEO1_UBIGEO_NIVEL_4 = "codigoUbigeoNivel4";
    
    // ZON - Log de rezonificar   Inc. DBLG500000146
    public static final String ZON_NOMBRE_FICHERO = "nombreFichero";
    public static final String ZON_FECHA_PROCESO = "fechaProceso";
    public static final String ZON_PAIS = "pais";
    public static final String ZON_MARCA = "marca";
    public static final String ZON_CANAL = "canal";
    public static final String ZON_TIPO_PERIODO = "tipoPeriodo";
    public static final String ZON_PERIODO_INICIO = "periodoInicio";
    public static final String ZON_FECHA_ACTUALIZACION = "fechaActualizacion";
    public static final String ZON_CREACION_GIS = "fechaCreacionGIS";
    public static final String ZON_DETALLE = "detalle";

    // RET-INI
    public static final String RETINI_CAMPO = "campo";

    // PTL-1
    public static final String PTL1_PREFIJO = "prefijo";
    public static final String PTL1_VALOR = "valor";
    
    // PTL-2
    public static final String PTL2_FACTURA = "factura";
    public static final String PTL2_NUMERO_CAJA_PTL_ANTIGUO = "numeroCajaPTLAntiguo";
    public static final String PTL2_NUMERO_CAJA = "numeroCaja";
    public static final String PTL2_NUMERO_TOTAL_CAJAS = "numeroTotalCajas";
    public static final String PTL2_TAMANIO_CAJA = "tamanioCaja";
    public static final String PTL2_INDICADOR_CHEQUEO = "indicadorChequeo";
    public static final String PTL2_NUMERO_CAJA_PTL_ACTUAL = "numeroCajaPTLActual";
    public static final String PTL2_CODIGO_IMPRESORA = "codigoImpresora";
    
    // PTL-3
    public static final String PTL3_PREFIJO = "prefijo";
    public static final String PTL3_VALOR = "valor";
    
    // PTL-4
    public static final String PTL4_NUMERO_ANAQUEL  = "numeroAnaquel";
    public static final String PTL4_CODIGO_PRODUCTO = "codigoProducto";
    public static final String PTL4_UNIDADES_CAJA1  = "unidadesCaja1";
    public static final String PTL4_UNIDADES_CAJA2  = "unidadesCaja2";    

    // PTL-5
    public static final String PTL5_ANAQUEL         = "numeroAnaquel";
    public static final String PTL5_CODIGO_PRODUCTO = "codigoProducto";
    public static final String PTL5_UNIDADES_CAJA1  = "unidadesCaja1";
    public static final String PTL5_UNIDADES_CAJA2  = "unidadesCaja2";
    
    public static final String APP01_CODIGO_PAIS    = "pais";
       public static final String APP01_CODIGO_ZONA    = "codigoZona";
       public static final String APP01_CODIGO_CLIENTE = "codigoCliente";
       public static final String APP01_SECUENCIA_CLIENTE = "secuenciaCliente";
       
       
    // SAF2
    public static final String SAF2_CODIGO_SAP = "codigoSAP";
    public static final String SAF2_IMPUESTO_PROD_NACIONAL = "impuestoProdNacional";
    public static final String SAF2_FECHA_ACTUALIZACION = "fechaActualizacion";


   public Object obtenerCampo( String campo );
   public void anyadirCampo( String nombre, Object valor ) throws InterfacesException;
   public int numeroCampos();
   public void vaciar();
}
