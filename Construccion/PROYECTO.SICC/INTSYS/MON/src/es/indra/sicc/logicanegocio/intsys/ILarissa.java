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

public interface ILarissa 
{
	public static final String LAR1_COMPANIA = "compania";
	public static final String LAR1_FECHA_PROCESO = "fechaProceso";
	public static final String LAR1_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR1_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR1_PERIODO = "periodo";
	public static final String LAR1_CODIGO_ITEM = "codigoItem";
	public static final String LAR1_DESCRIPCION_ITEM = "descripcionItem";
	public static final String LAR1_MARCA = "marca";
	public static final String LAR1_UNIDAD_NEGOCIO = "unidadNegocio";
	public static final String LAR1_NEGOCIO = "negocio";
	public static final String LAR1_ESTATUS_PRODUCTO = "estatusProducto";
	public static final String LAR1_TOTAL_UNIDADES_PRODUCTO = "totalUnidadesProducto";
	public static final String LAR1_INDICADOR_DENTRO_FUERA_CAJA = "indicadorDentroFueraCaja";
	public static final String LAR1_LARGO_CENTIMETROS = "largoCentimetros";
	public static final String LAR1_ANCHO_CENTIMETROS = "anchoCentimetros";
	public static final String LAR1_ALTO_CENTIMETROS = "altoCentimetros";
	public static final String LAR1_PESO_BRUTO_GRAMOS = "pesoBrutoGramos";

	public static final String LAR2_COMPANIA = "compania";
	public static final String LAR2_FECHA_PROCESO = "fechaProceso";
	public static final String LAR2_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR2_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR2_PERIODO = "periodo";
	public static final String LAR2_CODIGO_ITEM = "codigoItem";
	public static final String LAR2_DESCRIPCION_ITEM = "descripcionItem";
	public static final String LAR2_MARCA = "marca";
	public static final String LAR2_UNIDAD_NEGOCIO = "unidadNegocio";
	public static final String LAR2_NEGOCIO = "negocio";
	public static final String LAR2_ESTATUS_PRODUCTO = "estatusProducto";
	public static final String LAR2_TOTAL_UNIDADES_PRODUCTO = "totalUnidadesProducto";
	public static final String LAR2_INDICADOR_DENTRO_FUERA_BOLSA = "indicadorDentroFueraBolsa";
	public static final String LAR2_LARGO_CENTIMETROS = "largoCentimetros";
	public static final String LAR2_ANCHO_CENTIMETROS = "anchoCentimetros";
	public static final String LAR2_ALTO_CENTIMETROS = "altoCentimetros";
	public static final String LAR2_PESO_BRUTO_GRAMOS = "pesoBrutoGramos";

	public static final String LAR3_COMPANIA = "compania";
	public static final String LAR3_FECHA_PROCESO = "fechaProceso";
	public static final String LAR3_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR3_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR3_PERIODO = "periodo";
	public static final String LAR3_CODIGO_ZONA = "codigoZona";
	public static final String LAR3_DESCRIPCION_ZONA = "descripcionZona";

	public static final String LAR4_COMPANIA = "compania";
	public static final String LAR4_FECHA_PROCESO = "fechaProceso";
	public static final String LAR4_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR4_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR4_PERIODO = "periodo";
	public static final String LAR4_CODIGO_TERRITORIO = "codigoTerritorio";
  public static final String LAR4_CODIGO_ZONA = "codigoZona";

	public static final String LAR5_COMPANIA = "compania";
	public static final String LAR5_FECHA_PROCESO = "fechaProceso";
	public static final String LAR5_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR5_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR5_PERIODO = "periodo";
	public static final String LAR5_CLASE_SOLICITUD = "claseSolicitud";
	public static final String LAR5_DESCRIPCION_CLASE = "descripcionClase";
	public static final String LAR5_TIPO_SOLICITUD = "tipoSolicitud";
	public static final String LAR5_DESCRIPCION_TIPO = "descripcionTipo";
	
	public static final String LAR6_COMPANIA = "compania";
	public static final String LAR6_FECHA_PROCESADO = "fechaProceso";
	public static final String LAR6_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR6_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR6_PERIODO = "periodo";
	public static final String LAR6_CODIGO_CLIENTE = "codigoCliente";
	public static final String LAR6_TRATAMIENTO = "tratamiento";
	public static final String LAR6_APELLIDO_PATERNO = "apellidoPaterno";
	public static final String LAR6_APELLIDO_MATERNO = "apellidoMaterno";
	public static final String LAR6_APELLIDO_CASADA = "apellidoCasada";
	public static final String LAR6_NOMBRE1 = "nombre1";
	public static final String LAR6_NOMBRE2 = "nombre2";
	public static final String LAR6_TIPO_VIA = "tipoVia";
	public static final String LAR6_NOMBRE_VIA = "nombreVia";
	public static final String LAR6_NUMERO_PRINCIPAL = "numeroPrincipal";
	public static final String LAR6_NUMERO_INTERIOR = "numeroInterior";
	public static final String LAR6_MANZANA = "manzana";
	public static final String LAR6_LOTE = "lote";
	public static final String LAR6_KM = "km";
	public static final String LAR6_BLOCK = "block";
	public static final String LAR6_REFERENCIA = "referencia";
	public static final String LAR6_ZONA = "zona";
	public static final String LAR6_TERRITORIO = "territorio";
	public static final String LAR6_INDICADOR_VIP = "indicadorVIP";
	public static final String LAR6_UBIGEO1 = "ubigeo1";
	public static final String LAR6_UBIGEO2 = "ubigeo2";
	public static final String LAR6_UBIGEO3 = "ubigeo3";
	public static final String LAR6_UBIGEO4 = "ubigeo4";
	public static final String LAR6_UBIGEO5 = "ubigeo5";
	public static final String LAR6_UBIGEO6 = "ubigeo6";
	public static final String LAR6_UBIGEO7 = "ubigeo7";
	public static final String LAR6_UBIGEO8 = "ubigeo8";
	
	public static final String LAR7_COMPANIA = "compania";
	public static final String LAR7_FECHA_PROCESO = "fechaProceso";
	public static final String LAR7_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR7_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR7_PERIODO = "periodo";
	public static final String LAR7_NUMERO_PERIODO = "numeroPeriodo";
	public static final String LAR7_CODIGO_ITEM = "codigoItem";
	public static final String LAR7_UNIDADES_POR_ATENDER = "unidadesPorAtender";
	public static final String LAR7_INDICADOR_DENTRO_FUERA_CAJA = "indicadorDentroFueraCaja";
	public static final String LAR7_CLASE_SOLICITUD = "claseSolicitud";
	public static final String LAR7_TIPO_SOLICITUD = "tipoSolicitud";
	public static final String LAR7_CODIGO_EMPRESA = "codigoEmpresa";
    //añadido por incidencia 14391
    public static final String LAR7_NUMERO_PEDIDO = "numeroPedido";
    public static final String LAR7_CODIGO_CLIENTE = "codigoCliente";
    public static final String LAR7_FECHA_PEDIDO = "fechaPedido";
    public static final String LAR7_INDICADOR_PEDIDO_A_CHEQUEAR = "indicadorPedidoAChequear";
    public static final String LAR7_TOTAL_ITEMS_POR_PEDIDO = "totalItemsPorPedido";
    public static final String LAR7_TOTAL_UNIDADES_POR_PEDIDO = "totalUnidadesPorPedido";
    public static final String LAR7_INDICADOR_PEDIDO_EXPRESS = "indicadorPedidoExpress";
    public static final String LAR7_FECHA_CITA = "fechaCita";
    public static final String LAR7_HORA_CITA = "horaCita";    
	
	public static final String LAR8_COMPANIA = "compania";
	public static final String LAR8_FECHA_PROCESO = "fechaProceso";
	public static final String LAR8_LOTE_ENVIO_DIA = "loteEnvioDia";
	public static final String LAR8_TIPO_PERIODO = "tipoPeriodo";
	public static final String LAR8_PERIODO = "periodo";
	public static final String LAR8_TIPO_CODIGO_EMPRESA = "codigoEmpresa";
	public static final String LAR8_NUMERO_PEDIDO = "numeroPedido";
	public static final String LAR8_TIPO_FORMULARIO = "tipoFormulario";
	public static final String LAR8_NUMERO_FORMULARIO = "numeroFormulario";
	public static final String LAR8_CLASE_SOLICITUD = "claseSolicitud";
	public static final String LAR8_TIPO_SOLICITUD = "tipoSolicitud";
	public static final String LAR8_TIPOFORMULARIOGU = "GU";
    public static final String LAR8_TIPOFORMULARIOESGU = "2";
    public static final String LAR8_TIPOFORMULARIONOESGU = "1";

    //añadido por Sapaza, fecha 28/04/2008, nuevas interfaces LAR9 y LAR10
    public static final String LAR9_CODIGO_ZONA = "codigoZona";
    public static final String LAR9_RUTA = "ruta";
    public static final String LAR9_CODIGO_TERRITORIO = "codigoTerritorio";
    public static final String LAR9_NUMERO_PEDIDO = "numeroPedido";
    public static final String LAR9_SECUENCIA_TERRITORIO = "secuenciaTerritorio";
    public static final String LAR9_INDICADOR_PEDIDO_SERVICIO = "indicadorPedidoServicio";

    public static final String LAR10_CODIGO_CLIENTE = "codigoCliente";
    public static final String LAR10_NUMERO_DOCUMENTO_IDENTIDAD = "numeroDocumentoIdentidad";
    public static final String LAR10_CODIGO_UNIDAD_GEOGRAFICA1 = "codigoUnidadGeografica1";
    public static final String LAR10_CODIGO_UNIDAD_GEOGRAFICA2 = "codigoUnidadGeografica2";
    public static final String LAR10_CODIGO_UNIDAD_GEOGRAFICA3 = "codigoUnidadGeografica3";
    public static final String LAR10_DESCRIPCION_UNIDAD_GEOGRAFICA1 = "descripcionUnidadGeografica1";
    public static final String LAR10_DESCRIPCION_UNIDAD_GEOGRAFICA2 = "descripcionUnidadGeografica2";
    public static final String LAR10_DESCRIPCION_UNIDAD_GEOGRAFICA3 = "descripcionUnidadGeografica3";
    public static final String LAR10_TELEFONO = "telefono";    

}