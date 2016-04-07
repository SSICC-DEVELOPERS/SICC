/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

public class ErroresDeNegocio {
	//BEL-0001 Faltan datos obligatorios
  public final static String FALTA_DATOS_OBLIGATORIOS = "0001";  

	// BEL-0002 Sólo puede haber una agrupación de stock por defecto
	public final static String AGRUPACION_POR_DEFECTO_YA_EXISTE = "0002";

	// BEL-0003 Saldo insuficiente para el producto
	public final static String SALDO_INSUFICIENTE_PARA_PRODUCTO = "0003";

  // BEL-0004 El Grupo Detalle debe contener al menos una línea
  public final static String GRUPO_DETALLE_VACIO = "0004";

  // BEL-0005 El número de cajas que ha realizado el cierre diario es menor que el número de cajas asignado al Belcenter
  public final static String NUMERO_CAJAS_MENOR_CAJAS_BELCENTER = "0005";

  // BEL-0006 Todas las cajas del Belcenter están cuadradas
  public final static String TODAS_CAJAS_CUADRADAS = "0006";  

  //BEL-0007 No existe Caja Principal: debe parametrizar esta caja para ejecutar este Caso de Uso
  public final static String CAJA_PRINCIPAL_INEXISTENTE = "0007";	

  //BEL-0008 El periodo no existe
  public final static String PERIODO_INEXISTENTE = "0008";	
  
  // BEL-0009	Producto no existe  
  public final static String PRODUCTO_NO_EXISTE = "0009";	
  
  // BEL-0010	Producto no existe  
  public final static String CAJA_DESCUADRADA_MODIFICAR = "0010";	
  
  // BEL-0011 //CAJA_CERRADA
  public final static String BEL_0011 = "0011";

  // BEL-0012
  public final static String BEL_0012 = "0012";  

  // BEL-0013
  public final static String BEL_0013 = "0013";  

  // BEL-0014
  public final static String BEL_0014 = "0014";  

  // BEL-0015
  public final static String BEL_0015 = "0015";  

  // BEL-0016
  public final static String BEL_0016 = "0016";  
  
  // BEL-0017
  //public final static String BEL_0017 = "0017";  

  
  // BEL-0018 Incidencia 14245  No existe un almacén asignado
  public final static String BEL_0018 = "0018";
  
  // BEL-0019 Incidencia 14298 No esta parametrizada la entidad Asignación de Almacén
  public final static String BEL_0019 = "0019";
  
  //Error pedido por Juan Pablo: "no se ha generado el consolidado"
  public final static String BEL_0020 = "0020";
  
  // BEL-0021 Incidencia 22840 No se ha podido generar movimientos de almancén...
  public final static String BEL_0021 = "0021";
}