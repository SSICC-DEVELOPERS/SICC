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

public interface ISAPBPS  {
    public static final String SAB1_CODIGO  = "codigo";
    public static final String SAB1_CODIGO_IDIOMA  = "codigoIdioma";
    public static final String SAB1_DESCRIPCION_EN_IDIOMA  = "descripcionEnIdioma";
    public static final String SAB1_FACTOR_REPETICION  = "factorRepeticion";
    public static final String SAB1_ESTRATEGIA  = "estrategia";
    public static final String SAB2_CODIGO_CICLO_VIDA  = "codigoCicloVida";
    public static final String SAB2_CODIGO_IDIOMA  = "codigoIdioma";
    public static final String SAB2_DESCRIPCION_EN_IDIOMA  = "descripcionEnIdioma";
    public static final String SAB3_CODIGO_PAIS  = "codigoPais";
    public static final String SAB3_CODIGO_CANAL  = "codigoCanal";
    public static final String SAB3_CODIGO_MEDIO_CATALOGO  = "codigoMedioCatalogo";
    public static final String SAB3_CODIGO_IDIOMA  = "codigoIdioma";
    public static final String SAB3_DESCRIPCION_EN_IDIOMA  = "descripcionEnIdioma";
    public static final String SAB4_CODIGO_CONDICION_PROMOCION  = "codigoCondicionPromocion";
    public static final String SAB4_CODIGO_IDIOMA  = "codigoIdioma";
    public static final String SAB4_DESCRIPCION_EN_IDIOMA  = "descripcionEnIdioma";
    public static final String SAB5_CANAL  = "canal";
    public static final String SAB5_CODIGO  = "codigo";
    public static final String SAB5_FLAG_DESCUENTO  = "flagDescuento";
    public static final String SAB5_FLAG_ESTADISTICA  = "flagEstadistica";
    public static final String SAB5_FLAG_PUNTAJE  = "flagPuntaje";
    public static final String SAB5_FLAG_PEDIDO_MINIMO  = "flagPedidoMinimo";
    public static final String SAB5_FLAG_MONTO_ESCALA  = "flagMontoEscala";
    public static final String SAB5_CODIGO_FORMA_VENTA  = "codigoFormaVenta";
    public static final String SAB5_FLAG_GRATIS  = "flagGratis";
    public static final String SAB6_CODIGO_CANAL  = "codigoCanal"; 
    public static final String SAB6_CODIGO_TIPO_OFERTA  = "codigoTipoOferta";
    public static final String SAB6_CODIGO_IDIOMA  = "codigoIdioma";
    public static final String SAB6_DESCRIPCION_EN_IDIOMA  = "descripcionEnIdioma";


    public static final String SAB9_NUMERO_LOTE_TRANSACCION = "numeroLoteTransaccion";        
    public static final String SAB9_PAIS = "pais";                           
    public static final String SAB9_SOCIEDAD = "sociedad";                       
    public static final String SAB9_CANAL = "canal";                          
    public static final String SAB9_ACCESO = "acceso";                        
    public static final String SAB9_SUBACCESO = "subacceso";                      
    public static final String SAB9_TIPO_PERIODO = "tipoPeriodo";                    
    public static final String SAB9_PERIODO = "periodo";                        
    public static final String SAB9_CODIGO_PRODUCTO_SAP = "codigoProductoSAP";             
    public static final String SAB9_TIPO_OFERTA = "tipoOferta";                     
    public static final String SAB9_CICLO_VIDA = "cicloVida";                      
    public static final String SAB9_UNIDADES_ESTIMADAS = "unidadesEstimadas";              
    public static final String SAB9_VENTA_NETA_ESTIMADA = "ventaNetaEstimada";             
    public static final String SAB9_PRECIO_CATALOGO = "precioCatalogo";                 
    public static final String SAB9_PRECIO_POSICIONAMIENTO = "precioPosicionamiento";          
    public static final String SAB9_MONEDA_TRANSACCION = "monedaTransaccion";              
    public static final String SAB9_CATALOGO = "catalogo";                       
    public static final String SAB9_NUMERO_PAGINA_CATALOGO = "numeroPaginaCatalogo";          
    public static final String SAB9_POSICION_DENTRO_PAGINA = "posicionDentroPagina";
    public static final String SAB9_ARGUMENTO = "argumento";                      
    public static final String SAB9_ESTRATEGIA = "estrategia";                    
    public static final String SAB9_CONDICION_PROMOCION = "condicionPromocion";
    public static final String SAB9_CODIGO_FORMA_VENTA = "codigoFormaVenta";              
    public static final String SAB9_CENTRO = "centro";     
    public static final String SAB9_COSTE_ESTANDAR = "costeEstandar";     
    public static final String SAB9_CODIGO_FORMA_PAGO = "codigoFormaPago";     
    
    public static final String SAB10_PAIS = "pais";                           
    public static final String SAB10_CANAL = "canal";                          
    public static final String SAB10_MARCA = "marca";                          
    public static final String SAB10_CATALOGO = "catalogo";                       
    public static final String SAB10_EJERCICIO = "ejercicio";                      
    public static final String SAB10_PERIODO = "periodo";                        
    public static final String SAB10_CICLO_VIDA = "cicloVida";                     
    public static final String SAB10_TIPO_OFERTA = "tipoOferta";                    
    public static final String SAB10_CODIGO_ARTICULO = "codigoArticulo";                
    public static final String SAB10_DESCRIPCION_CRITERIO = "descripcionCriterio";           
    public static final String SAB10_TIPO_CLIENTE = "tipoCliente";                   
    public static final String SAB10_BASE_DESTINATARIOS = "baseDestinatarios";             
    public static final String SAB10_FACTOR_CORRECCION = "factorCorreccion";              
    public static final String SAB10_PROMEDIO_UNIDADES_DESTINATARIOS = "promedioUnidadesDestinatarios"; 
    public static final String SAB10_UNIDADES = "unidades";                       
    public static final String SAB10_ATRIBUTO_CONSULTA = "atributoConsulta";              
    public static final String SAB10_PRECIO_ESTANDAR = "precioEstandar";

	public static final String COD_INTERFAZ_SAB11 = "SAB-11"; 
	public static final String COD_INTERFAZ_SAB12 = "SAB-12";
	public static final String COD_INTERFAZ_SAB13 = "SAB-13"; 
	public static final String COD_INTERFAZ_SAB14 = "SAB-14"; 
	public static final String COD_INTERFAZ_SAB20 = "SAB-20"; 
	public static final String COD_INTERFAZ_SAB21 = "SAB-21"; 

    // Incidencia BELC300016668 
    public static final String SAB11_PAIS = "pais"; 
    public static final String SAB11_SOCIEDAD = "sociedad";
    public static final String SAB11_CENTRO = "codigoAlmacenSAP"; 
    public static final String SAB11_CANAL = "canal"; 
    public static final String SAB11_ANIO_COMERCIAL = "anioComercial"; 
    public static final String SAB11_MONEDA = "moneda"; 
    public static final String SAB11_CAMPANIA_PERIODO = "campaniaPeriodo"; 
    public static final String SAB11_ZONA = "zona"; 
    public static final String SAB11_REGION = "region"; 
    public static final String SAB11_ACTIVAS_INICIALES = "activasIniciales"; 
    public static final String SAB11_ACTIVAS_FINALES = "activasFinales"; 
    public static final String SAB11_INGRESOS = "ingresos"; 
    public static final String SAB11_REINGRESOS = "reingresos"; 
    public static final String SAB11_EGRESOS = "egresos"; 
    public static final String SAB11_REZONIFICADAS_RECIBIDAS = "rezonificadasRecibidas"; 
    public static final String SAB11_REZONIFICADAS_ENTREGADAS = "rezonificadasEntregadas"; 
    public static final String SAB11_NUMERO_ORDENES = "numeroOrdenes"; 
    public static final String SAB11_NUMERO_PEDIDOS = "numeroPedidos"; 
    public static final String SAB11_UNIDADES_VENDIDAS = "unidadesVendidas"; 
    public static final String SAB11_NUMERO_CLIENTES = "numeroClientes"; 
    public static final String SAB11_VENTA_NETA = "ventaNeta"; 
    public static final String SAB11_FECHA_CIERRE = "fechaCierre"; 
    public static final String SAB11_MARCA = "marca"; // Cambio SAPBPS 001
    // Cambio SiCC 20070511 - dmorello
    public static final String SAB11_ACTIVIDAD_INFLADA_ZONA = "actividadInfladaZona";
    public static final String SAB11_NRO_CONSULTORAS_CLIENTES_PRIVILEGE = "nroConsultorasClientesPrivilege";
    public static final String SAB11_NRO_CLIENTES_INSCRITOS_PRIVILEGE = "nroClientesInscritosPrivilege";
    public static final String SAB11_NRO_CLIENTES_TRANSACCIONES_PRIVILEGE = "nroClientesTransaccionesPrivilege";
    public static final String SAB11_RETENCION_2DO_PEDIDO = "retencion2doPedido";
    public static final String SAB11_RETENCION_3ER_PEDIDO = "retencion3erPedido";
    public static final String SAB11_RETENCION_4TO_PEDIDO = "retencion4toPedido";
    public static final String SAB11_RETENCION_ACTIVAS = "retencionActivas";
    public static final String SAB11_PORCENTAJE_ROTACION = "porcentajeRotacion";
    public static final String SAB11_POSIBLES_EGRESOS = "posiblesEgresos";
    public static final String SAB11_RETENCION_POSIBLES_EGRESOS = "retencionPosiblesEgresos";
    public static final String SAB11_PORCENTAJE_EGRESOS = "porcentajeEgresos";
    public static final String SAB11_PUP = "pup";
    public static final String SAB11_PPU = "ppu";
    // Fin dmorello
    
    public static final String SAB12_PAIS = "pais"; 
    public static final String SAB12_SOCIEDAD = "sociedad"; 
    public static final String SAB12_CENTRO = "centro"; 
    public static final String SAB12_CANAL = "canal"; 
    public static final String SAB12_MEDIO = "medio"; 
    public static final String SAB12_ANIO_COMERCIAL = "anioComercial"; 
    public static final String SAB12_CAMPANIA = "campania"; 
    public static final String SAB12_FECHA_FACTURACION = "fechaFacturacion"; 
    public static final String SAB12_NUMERO_ORDENES_DIA = "numeroOrdenesTotalesDia"; 
    public static final String SAB12_NUMERO_PEDIDOS_ACUMULADOS = "numeroPedidosAcumulados"; 
    public static final String SAB12_NUMERO_PEDIDOS_PROYECTADOS = "numeroPedidosProyectados"; 
    public static final String SAB12_MARCA = "marca"; 
    
    public static final String SAB13_PAIS = "pais"; 
    public static final String SAB13_SOCIEDAD = "sociedad"; 
    public static final String SAB13_CENTRO = "centro"; 
    public static final String SAB13_CANAL = "canal"; 
    public static final String SAB13_MEDIO = "medio"; 
    public static final String SAB13_ANIO_COMERCIAL = "anioComercial"; 
    public static final String SAB13_CAMPANIA  = "campania"; 
    public static final String SAB13_MARCA = "marca"; 
    public static final String SAB13_FECHA_FACTURACION = "fechaFacturacion"; 
    public static final String SAB13_NUMERO_ORDENES_DIA = "numeroOrdenesTotalesDia"; 
    public static final String SAB13_NUMERO_PEDIDOS_ACUMULADOS = "numeroPedidosAcumulados"; 
 
    // Incidencia BELC300016672
    public static final String SAB14_PAIS = "pais"; 
    public static final String SAB14_SOCIEDAD = "sociedad"; 
    public static final String SAB14_CENTRO = "centro"; 
    public static final String SAB14_CANAL = "canal"; 
    public static final String SAB14_MEDIO = "medio"; 
    public static final String SAB14_ANIO_COMERCIAL = "anioComercial"; 
    public static final String SAB14_CAMPANIA = "campania"; 
    public static final String SAB14_CODIGO_PRODUCTO = "codigoProducto"; 
    public static final String SAB14_CICLO_VIDA = "cicloVida"; 
    public static final String SAB14_TIPO_OFERTA = "tipoOferta"; 
    public static final String SAB14_CONDICION_PROMOCION = "condicionPromocion"; 
    public static final String SAB14_FECHA = "fecha"; 
    public static final String SAB14_FLAG_VENTA = "flagVenta"; 
    public static final String SAB14_MONEDA_TRANSACCION = "monedaTransaccion"; 
    public static final String SAB14_UNIDADES_PROYECTADAS = "unidadesProyectadas"; 
    public static final String SAB14_UNIDADES_VENDIDAS = "unidadesVendidas"; 
    public static final String SAB14_UNIDADES_FALTANTES = "unidadesFaltantes"; 
    public static final String SAB14_UNIDADES_DEVUELTAS = "unidadesDevueltas"; 
    public static final String SAB14_UNIDADES_ANULADAS = "unidadesAnuladas"; 
    public static final String SAB14_UNIDADES_CANJE = "unidadesCanje"; 
    public static final String SAB14_UNIDADES_TRUEQUE = "unidadesTrueque"; 
    public static final String SAB14_VENTA_NETA_PROYECTADA = "ventaNetaProyectada"; 
    public static final String SAB14_VENTA_NETA_ATENDIDAS = "ventaNetaAtendida"; 
    public static final String SAB14_VENTA_NETA_FALTANTE = "ventaNetaFaltante"; 
    public static final String SAB14_VENTA_NETA_DEVOLUCIONES = "ventaNetaDevoluciones"; 
    public static final String SAB14_VENTA_NETA_ANULACIONES = "ventaNetaAnulaciones"; 
    public static final String SAB14_VENTA_NETA_CANJES = "ventaNetaCanjes";
    public static final String SAB14_VENTA_NETA_TRUEQUES = "ventaNetaTrueques";
    public static final String SAB14_VENTA_BRUTA_REAL =  "ventaBrutaReal";
    public static final String SAB14_VENTA_BRUTA_FALTANTE = "ventaBrutaFaltante";
    public static final String SAB14_MARCA_PRODUCTO = "marcaProducto" ;// Cambio P2
    public static final String SAB14_TERRITORIO = "territorio" ;// Cambio P2
    
    // Incidencia BELC300017106
    public static final String COD_INTERFAZ_SAB25 = "SAB-25";    
	public static final String SAB25_CODIGO_PAIS = "pais"; 
    public static final String SAB25_CODIGO_ZONA = "codigoZona"; 
    public static final String SAB25_CODIGO_REGION = "codigoRegion"; 
    public static final String SAB25_DESCRIPCION_ZONA = "descripcionZona"; 
    public static final String SAB25_CODIGO_SOCIEDAD = "sociedad"; //cambio P2
    public static final String SAB25_MARCA = "marca"; //cambio P2
    public static final String SAB25_CANAL_BPS = "canalBPS"; //cambio P2
    public static final String SAB25_SUBGERENCIA_VENTAS = "subgerenciaVentas"; //cambio P2
	
    // Incidencia BELC300016713
    // Incidencia BELC300017106
    // Incidencia BELC300017288
    public static final String COD_INTERFAZ_SAB26 = "SAB-26";    
    public static final String SAB26_CODIGO_PAIS = "pais"; 
    public static final String SAB26_CODIGO_REGION = "codigoRegion"; 
    public static final String SAB26_DESCRIPCION_REGION = "descripcionRegion";    
    public static final String SAB26_CODIGO_SOCIEDAD = "sociedad"; //cambio P2
    public static final String SAB26_MARCA = "marca"; //cambio P2
    public static final String SAB26_CANAL_BPS = "canalBPS"; //cambio P2
    public static final String SAB26_SUBGERENCIA_VENTAS = "subgerenciaVentas"; //cambio P2
  
    // Incidencia BELC300017106
	public static final String COD_INTERFAZ_SAB16 = "SAB-16"; 
    public static final String SAB16_CODIGO_PAIS = "pais"; 
    public static final String SAB16_CODIGO_SOCIEDAD = "sociedad"; 
    public static final String SAB16_CODIGO_ALMACEN = "centro"; 
    public static final String SAB16_CANAL_BPS = "canal"; 
    public static final String SAB16_MEDIO = "medio"; 
    public static final String SAB16_ANIO_COMERCIAL = "anioComercial"; 
    public static final String SAB16_CAMPANIA = "campania"; 
    public static final String SAB16_CODIGO_PRODUCTO = "codigoProducto"; 
    public static final String SAB16_CICLO_VIDA = "cicloVida"; 
    public static final String SAB16_TIPO_OFERTA = "tipoOferta"; 
    public static final String SAB16_CODIGO_DEMANDA_ANORMAL = "codigoDemandaAnormal"; 

    // Incidencia BELC300017106 
    // Incidencia BELC300017117
	public static final String COD_INTERFAZ_SAB17 = "SAB-17"; 
    public static final String SAB17_CODIGO_PAIS = "pais"; 
    public static final String SAB17_CODIGO_SOCIEDAD = "sociedad"; 
    public static final String SAB17_CODIGO_ALMACEN = "centro"; 
    public static final String SAB17_CANAL_BPS = "canal"; 
    public static final String SAB17_MEDIO = "medio"; 
    public static final String SAB17_ANIO_COMERCIAL = "anioComercial"; 
    public static final String SAB17_CAMPANIA = "campania"; 
    public static final String SAB17_MONEDA_TRANSACCION = "monedaTransaccion"; 
    public static final String SAB17_UNIDADES_VENDIDAS = "unidadesVendidas"; 
    public static final String SAB17_UNIDADES_FALTANTES = "unidadesFaltantes"; 
    public static final String SAB17_UNIDADES_DEVUELTAS = "unidadesDevueltas"; 
    public static final String SAB17_UNIDADES_ANULADAS = "unidadesAnuladas"; 
    public static final String SAB17_UNIDADES_CANJE = "unidadesCanje"; 
    public static final String SAB17_UNIDADES_TRUEQUE = "unidadesTrueque"; 
    public static final String SAB17_VENTA_NETA_ATENDIDA = "ventaNetaAtendida"; 
    public static final String SAB17_VENTA_NETA_FALTANTE = "ventaNetaFaltante"; 
    public static final String SAB17_VENTA_NETA_DEVOLUCIONES = "ventaNetaDevoluciones"; 
    public static final String SAB17_VENTA_NETA_ANULACIONES = "ventaNetaAnulaciones"; 
    public static final String SAB17_VENTA_NETA_CANJES = "ventaNetaCanjes"; 
    public static final String SAB17_VENTA_NETA_TRUEQUES = "ventaNetaTrueques"; 
    public static final String SAB17_NUMERO_ZONAS = "numeroZonas"; 
    public static final String SAB17_NUMERO_ORDENES = "numeroOrdenes"; 
    public static final String SAB17_NUMERO_PEDIDOS = "numeroPedidos"; 
    public static final String SAB17_FECHA_CIERRE = "fechaCierre";
    
    //Incidencia BELC300017106
    //Incidencia BELC300017443
    public static final String COD_INTERFAZ_SAB27 = "SAB-27";
    public static final String SAB27_CODIGO_PAIS = "pais";
    public static final String SAB27_CODIGO_SOCIEDAD = "sociedad" ;
    public static final String SAB27_CODIGO_ALMACEN = "centro" ;
    public static final String SAB27_CANAL_BPS = "canal" ;
    public static final String SAB27_ANIO_COMERCIAL = "anioComercial" ;                    
    public static final String SAB27_MONEDA = "moneda" ;                                   
    public static final String SAB27_CAMPANIA = "campania" ;                               
    public static final String SAB27_MARCA_PRODUCTO = "marcaProducto" ;// Cambio P2
    public static final String SAB27_TERRITORIO = "territorio" ;// Cambio P2
    public static final String SAB27_CODIGO_ZONA = "zona" ;                          
    public static final String SAB27_CODIGO_REGION = "region" ;                      
    public static final String SAB27_ACTIVAS_INICIALES = "activasIniciales" ;              
    public static final String SAB27_ACTIVAS_FINALES = "activasFinales" ;                  
    public static final String SAB27_INGRESOS = "ingresos" ;                               
    public static final String SAB27_REINGRESOS = "reingresos" ;                           
    public static final String SAB27_EGRESOS = "egresos" ;                                 
    public static final String SAB27_REZONIFICADAS_RECIBIDAS = "rezonificadasRecibidas" ;  
    public static final String SAB27_REZONIFICADAS_ENTREGADAS = "rezonificadasEntregadas"; 
    public static final String SAB27_NUMERO_ORDENES = "numeroOrdenes" ;                    
    public static final String SAB27_NUMERO_PEDIDOS = "numeroPedidos" ;                    
    public static final String SAB27_UNIDADES_VENDIDAS = "unidadesVendidas" ;              
    public static final String SAB27_NUMERO_CLIENTES = "numeroClientes" ;                  
    public static final String SAB27_VENTA_NETA = "ventaNeta" ;                            
    public static final String SAB27_FECHA_CIERRE = "fechaCierre" ;    
    
    //CAMBIO P2
    public static final String COD_INTERFAZ_SAB28 = "SAB-28";
    public static final String SAB28_CODIGO_PAIS = "pais";
    public static final String SAB28_CODIGO_SOCIEDAD = "sociedad" ;
    public static final String SAB28_MARCA = "marca"; 
    public static final String SAB28_TERRITORIO = "territorio" ;
    public static final String SAB28_CODIGO_ZONA = "codigoZona"; 
    public static final String SAB28_CODIGO_REGION = "codigoRegion"; 
    public static final String SAB28_CANAL_BPS = "canalBPS" ;
    public static final String SAB28_SUBGERENCIA_VENTAS = "subgerenciaVentas"; 
    public static final String SAB28_SECCION = "seccion"; 
    
    /* SICC-GCC-INT-SAB-004 - dmorello, 23/11/2006 */
    public static final String COD_INTERFAZ_SAB29 = "SAB-29";

}
