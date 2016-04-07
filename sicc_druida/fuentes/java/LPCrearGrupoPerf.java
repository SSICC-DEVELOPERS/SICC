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
    $Id: LPCrearGrupoPerf.java,v 1.1 2009/12/03 18:32:15 pecbazalar Exp $
    DESC
*/

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOEstrategia;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.w3c.dom.Element;

import es.indra.sicc.util.DTOOID;

public class LPCrearGrupoPerf extends LPSICCBase {

  String accion = "";  
  Integer grupoActual;

  Boolean cuadreGrupos;
  DTOEstrategia estrategia;
  MareBusinessID id;
  DTOOID dtoOID;
  DruidaConector conectorGenerico;
  Vector params;
  DTOSalida dtoSalida;
  Integer numeroGrupos;
  RecordSet opcionesCombo;
  Element comboElement;
  DruidaConector dc;

  private long TiempoDeCargaInicio;
  private long TiempoDeCargaFin;

  // Definicion del constructor
  public LPCrearGrupoPerf() {
    super();
	}

  // Definicion del metodo abstracto inicio
  public void inicio() throws Exception {
    // Defino el nombre de la vista
    pagina("contenido_grupo_crear_perf");
  }

  public void ejecucion() throws Exception {
    TiempoDeCargaInicio=System.currentTimeMillis();
    setTrazaFichero();

    traza("entro a lp");
	
  	//Recupera variables de la pagina
		accion = conectorParametroLimpia("accion", "", true);    
    
    try{
      //acciones
      if( accion.equals("") ){          
          cargarPantalla();
      }

      this.getConfiguracionMenu( "LPCrearGrupoPerf", "" );

      TiempoDeCargaFin = System.currentTimeMillis();
      traza("El tiempo de carga de LPCrearGrupoPerf es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
    } catch (Exception ex){
      logStackTrace( ex );
      this.lanzarPaginaError(ex);
    }
  }

  //****************************************************************************
  // METODOS DE SERVICIO
  //****************************************************************************


  private void cargarPantalla() throws Exception {

    this.getFormatosValidaciones();

    this.asignarAtributo("VAR", "cteCuadreTotalMontos", "valor", String.valueOf(ConstantesPRE.CUADRE_TOTAL_MONTOS));
    
  }

  private void logStackTrace(Throwable e) throws Exception {
      traza("Se produjo la excepcion: " + e.getMessage());
 
      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      if (e instanceof MareException) {
        MareException e2=(MareException)e;
        traza("Es una mare Exception con codigo de error: "+e2.getCode());
      }
      e.printStackTrace(out);
      traza("stack Trace : " +  pila.toString());
   }

}
