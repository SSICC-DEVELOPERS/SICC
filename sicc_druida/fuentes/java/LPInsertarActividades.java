/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 /*
    INDRA/CAR/PROY
    $Id: LPInsertarActividades.java,v 1.1 2009/12/03 18:40:40 pecbazalar Exp $
    DESC
 */
import LPSICCBase;


// Definicion de la clase
public class LPInsertarActividades extends LPSICCBase {
  
  
  // Definicion del constructor
  public LPInsertarActividades() { super(); }

  // Definicion del metodo abstracto inicio
  public void inicio() throws Exception {
    
  }
    
  // Definicion del metodo abstracto ejecucion

public void ejecucion() throws Exception {
   setTrazaFichero();
    try  {
      rastreo();
      traza("Caso de Uso = Insertar");
      conectorAction("LPMantieneActividades");
      conectorActionParametro("accion","muestraInsercion");
      
      
    }
    catch ( Exception e )  {
      e.printStackTrace();
      lanzarPaginaError(e);
    }

  }
}



