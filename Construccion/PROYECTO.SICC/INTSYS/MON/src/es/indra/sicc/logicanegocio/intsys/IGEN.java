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






package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;

public interface IGEN{
  
  void generarDescripcionIdiomaNoES (Long oidEntidad, String entidad, Long idioma, String descripcion) throws MareException;
}