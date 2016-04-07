
import LPSICCBase; 
import es.indra.druida.DruidaConector; 
import es.indra.druida.dom.DruidaDOMObjeto; 
import java.util.Vector; 
 
import es.indra.sicc.util.BelcorpError; 
import es.indra.sicc.util.DTOError; 
import es.indra.mare.common.exception.MareException; 
import java.io.ByteArrayOutputStream; 
import java.io.PrintStream; 
 
import es.indra.mare.common.mln.MareBusinessID; 
 
import es.indra.sicc.dtos.cra.DTOEntradaEliminarCronograma; 
import es.indra.sicc.dtos.cra.DTOEntradaConsultarCronograma; 
import es.indra.sicc.dtos.cra.DTOEntradaModificarCronograma; 
 
import es.indra.sicc.dtos.cra.DTOEntradaModificarCronograma; 
 
import java.sql.Date; 

import java.text.SimpleDateFormat;
 
// Definicion de la clase 
public class LPPresentarParametrosActividad extends LPSICCBase { 
 
  //Estas son las claves con las que se recuperan datos de sesion 
  final String CASO_DE_USO_SESION = "CRA_CRONO_CASO_DE_USO"; 
  final String MATRIZ_SESION      = "CRA_MODIFICAR_ELIMINAR_CRONOGRAMA_HASHTABLE"; 
  final String LPRETORNO_SESION   = "CRA_CRONO_LPRETORNO"; 
 
  //Valores que pueden venir en sesion con la variable CASO_DE_USO_SESION 
  final String CU_MODIFICAR_ACTIVIDAD = "CU_MODIFICAR_ACTIVIDAD"; 
  final String CU_ELIMINAR_ACTIVIDAD = "CU_ELIMINAR_ACTIVIDAD"; 
   
 
  //Valor que puede venir en LPRETORNO_SESION 
  final String LP_MODIFICAR_CRONOGRAMA = "LPModificarCronograma"; 
  final String CONECTOR_ZONAS_VALIDAS = "CRA_CRONO_CONECTORZONAS"; 
 
  String accion = null; 
  String casoDeUso = null; 
  
 
  //Variables 
  String pais                  = null; 
  String marca                 = null; 
  String canal                 = null; 
  String codActividad          = null; 
  String actividadReferenciada = null; 
  String nomActividad          = null; 
  String oidActividad          = null;
  String subGerenciaVentas     = null; 
  String region                = null; 
  String codPeriodo            = null; 
  String oidCronograma         = null; 
 
  String gruposZonas = null; 
  String zona = null; 
  String seccion = null; 
  String diasEjecucion = null; 
  String horaEjecucion = null; 
  String cadaCuantosDias = null; 
  String fechaInicio = null; 
  String fechaFin = null; 
  String estado = null; 
  String aniadirActAsoc = null; 
  String fija = null; 
  String tipoFactu = null; 
 
  MareBusinessID id = null; 
  DTOEntradaEliminarCronograma dtoEEC = null; 
  DTOEntradaConsultarCronograma dtoECC = null; 
  DTOEntradaModificarCronograma dtoEMC = null; 
 
   
  Vector paramEntrada = null; 
 
  // Definicion del constructor 
  public LPPresentarParametrosActividad() { 
    super(); 
  } 
 
  // Definicion del metodo abstracto inicio 
  public void inicio() throws Exception { 
    // Defino el nombre de la vista 
    pagina("contenido_parametros_actividad_cronograma"); 
  } 
 
  // Definicion del metodo abstracto ejecucion 
  public void ejecucion() throws Exception { 
 
    setTrazaFichero(); 
   
    try{ 
 
      /* 
       * paramPais 
       * paramCanal 
       * paramMarca 
       * paramCodPeriodo 
       * paramCodActividad 
       * paramNombreActividad 
       * paramFechaInicio 
       * paramFechaFin 
       * paramRegion 
       * paramSubVentas 
       * paramZona 
       *  
       * paramAccion 
       *  
       * CONSULTA 
       * las zonas vienen en CRA_CRONO_ZONAS (hay que ver en que container vienen) 
       * Para modificarcion usar el DTOEntradaConsultarCronograma 
       * Guardar el dto en sesion en CRA_DTOCRONO 
       *  
       *  
       * Para eliminacion usar el DTOEntradaEliminarCronograma 
       * */ 
 
      // MODIFICAR DE ACUERDO A LAS VARIABLES DE URL QUE SE ME ENVIAN ---------- 
      
      pais          = this.conectorParametroLimpia("paramPais", "", true); 
      marca         = this.conectorParametroLimpia("paramMarca", "", true); 
      canal         = this.conectorParametroLimpia("paramCanal", "", true); 
      codActividad  = this.conectorParametroLimpia("paramCodActividad", "", true); 
      oidActividad  = this.conectorParametroLimpia("paramOidActividad", "", true);
      nomActividad  = this.conectorParametroLimpia("paramNombreActividad", "", true); 
      oidCronograma = this.conectorParametroLimpia("paramOidCronograma", "", true);
 
      
      actividadReferenciada = this.conectorParametroLimpia("paramActividadReferenciada", "", true);   
      
      if (actividadReferenciada.equals("")) actividadReferenciada = null; 
      
      subGerenciaVentas = this.conectorParametroLimpia("paramSubVentas", "", true); 
      region        = this.conectorParametroLimpia("paramRegion", "", true); 
      codPeriodo    = this.conectorParametroLimpia("paramCodPeriodo", "", true); 
      fechaInicio   = this.conectorParametroLimpia("paramFechaInicio", "", true); 
      horaEjecucion = this.conectorParametroLimpia("paramHoraEjecucion", "", true); 
      fechaFin      = this.conectorParametroLimpia("paramFechaFin", "", true); 
      zona          = this.conectorParametroLimpia("paramZona", "", true); 
      gruposZonas   = this.conectorParametroLimpia("paramGruposZonas", "", true); 
      casoDeUso     = this.conectorParametroLimpia("paramCasoUso", "", true); 
      tipoFactu     = this.conectorParametroLimpia("paramTipoFacturacion", "", true); 
       
      //seccion = this.conectorParametroLimpia("hSeccion", "", true); 
      //a estos dos el mon no los devuelve 
      //diasEjecucion = this.conectorParametroLimpia("hDiasEjecucion", "", true); 
      //horaEjecucion = this.conectorParametroLimpia("hHoraEjecucion", "", true); 
       
      //cadaCuantosDias = this.conectorParametroLimpia("hCadaCuantosDias", "", true); 
      //estado = this.conectorParametroLimpia("hEstado", "", true); 
      //aniadirActAsoc = this.conectorParametroLimpia("hAniadirActAsoc", "", true); 
      //fija = this.conectorParametroLimpia("hFija", "", true); 
      // ----------------------------------------------------------------------- 
 
      //Se recupera el nombre de caso de uso (Modificar o Eliminar) de sesion 
      //y se asigna a la variable hidden (hidBorrar) de la pagina 
       
      if(casoDeUso.equalsIgnoreCase(CU_ELIMINAR_ACTIVIDAD)){ 
        asignarAtributo("VAR","hCasoDeUso", "valor", "eliminar"); 
      } 
      else{ 
        asignarAtributo("VAR","hCasoDeUso", "valor", "modificar"); 
      } 
 
	   	conectorParametroSesion("CRA_CASO_DE_USO", casoDeUso);

      accion = this.conectorParametroLimpia("accion", "", true); 
 
      traza("accion=" + accion);
      if(accion.equals("")){ 
        //Asignar los valores a las variables de la pagina 
        //DruidaConector conectorZonas = (DruidaConector) this.conectorParametroSesion(CONECTOR_ZONAS_VALIDAS); 

        asignarAtributo("VAR", "hZona", "valor", zona); 
        asignarAtributo("CTEXTO", "txtCodigoActividad", "valor", codActividad); 
        asignarAtributo("CTEXTO", "txtHora", "valor", horaEjecucion);
                 
        asignarAtributo("VAR","hidFechaIni", "valor", fechaInicio);
        asignarAtributo("VAR", "hidHora", "valor", horaEjecucion);

        DruidaConector conectorZonas = this.obtenerConectorZonas(); 
        this.guardarEnSesionZonasValidas(conectorZonas); 
        
        asignar("COMBO", "cbZona", conectorZonas, "dtoSalida.resultado_ROWSET"); 
        
        //asignarAtributo("CTEXT","txtDiasej", "valor", zona); 
        /* 
        asignarAtributo("CTEXT","txtFechaIni", "valor", fechaInicio); 
        traza("ASIGNO A FECHA INI: " + fechaInicio); 
        asignarAtributo("CTEXT","txtFechaFin", "valor", fechaFin); 
        traza("ASIGNO A FECHA FIN: " + fechaFin); 
        */ 
 
        asignarAtributo("VAR","fechaIni", "valor", fechaInicio); 
        asignarAtributo("VAR","fechaFin", "valor", fechaFin); 

		   	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  Date fechaInicPattern = new java.sql.Date(sdf.parse(fechaInicio + " " + horaEjecucion).getTime()); 
        
        if(casoDeUso.equalsIgnoreCase(CU_ELIMINAR_ACTIVIDAD)){ 
          traza("ENTRO AL CASO DE USO ELIMINAR"); 
          dtoEEC = new DTOEntradaEliminarCronograma(); 
          dtoEEC.setPais( (pais==null || pais.equals("")) ? null : Long.valueOf(pais) );
          
          dtoEEC.setMarca( (marca==null || marca.equals("")) ? null : Long.valueOf(marca) );
          
          dtoEEC.setCanal( (canal==null || canal.equals("")) ? null : Long.valueOf(canal) );
          

		  //dtoEEC.setFechaInicio( (fechaInicio==null || fechaInicio.equals("")) ? null : Date.valueOf(fechaInicio) ); 
		      dtoEEC.setFechaInicio( fechaInicPattern );
          
           
          dtoEEC.setCodigoActividad(Long.valueOf(codActividad ));
          dtoEEC.setSubgerenciaVentas( (subGerenciaVentas==null || subGerenciaVentas.equals("")) ? null : Long.valueOf(subGerenciaVentas) );
          dtoEEC.setZona( Long.valueOf(zona));
          dtoEEC.setGrupoZonas( Long.valueOf(gruposZonas));
          dtoEEC.setRegion( (region==null || region.equals("")) ? null : Long.valueOf(region) );
          dtoEEC.setCodigoPeriodo( new Long(codPeriodo) );
          dtoEEC.setOidCronograma( new Long(oidCronograma));
          
          
          
          this.conectorParametroSesion("CRA_DTOCRONO", dtoEEC);
          traza("DTO QUE VA A LA LP DE ELIMINAR:" + dtoEEC);
          traza("SE CARGO EL DTO EN SESION"); 
        } else if(casoDeUso.equalsIgnoreCase(CU_MODIFICAR_ACTIVIDAD)){ 
          traza("ENTRO AL CASO DE USO MODIFICAR"); 
         
          dtoEMC = new DTOEntradaModificarCronograma(); 
          dtoEMC.setPais( (pais==null || pais.equals("")) ? null : Long.valueOf(pais) ); 
          dtoEMC.setMarca( (marca==null || marca.equals("")) ? null : Long.valueOf(marca) ); 
          dtoEMC.setCanal( (canal==null || canal.equals("")) ? null : Long.valueOf(canal) ); 
          dtoEMC.setCodigoActividad(Long.valueOf(codActividad )); 
          dtoEMC.setSubgerenciaVentas( Long.valueOf(subGerenciaVentas) ); 
          dtoEMC.setRegion( Long.valueOf(region) ); 
          dtoEMC.setCodigoperiodo( Long.valueOf(codPeriodo) ); 

          //dtoEMC.setFechaInicio( (fechaInicio==null || fechaInicio.equals("")) ? null : Date.valueOf(fechaInicio) );      
		  dtoEMC.setFechaInicio( fechaInicPattern );

          dtoEMC.setFechafin( (fechaFin==null || fechaFin.equals("")) ? null : Date.valueOf(fechaFin) ); 
          dtoEMC.setZona( Long.valueOf(zona) ); 
          dtoEMC.setCodigoActividadReferenciada(Long.valueOf(actividadReferenciada)); 
          dtoEMC.setTipoFacturacion(tipoFactu); 
          traza("tipo factu: " + tipoFactu); 
          this.conectorParametroSesion("CRA_DTOCRONO", dtoEMC); 
        } 
      } 
       
      else if(accion.equalsIgnoreCase("modificar")){ 
        modificarActividad(); 
      } 
      else if(accion.equalsIgnoreCase("eliminar")){ 
        eliminarActividad(); 
      } 
    } 
    	catch (Exception ex) {
			logStackTrace(ex);
      lanzarPaginaError(ex);
 
     /* BelcorpError belcorpError = new BelcorpError(); 
      DTOError dtoError = null; 
 
      if (ex instanceof MareException) { 
        dtoError = belcorpError.obtenerError(((MareException)ex).getOriginalCause()); 
      }  
      else { 
        dtoError = belcorpError.obtenerError(ex); 
      } 
      asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError()); 
      asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError()); */
    } 
    getConfiguracionMenu("LPPresentarParametrosActividad");
  } 
 
  //---------------------------------------------------------------------------- 
  // METODOS DE SERVICIO ------------------------------------------------------- 
  //---------------------------------------------------------------------------- 
 
 
  /** 
   * Obtiene todas las zonas a las cuales puedo mover la actividad a modificar. 
   */ 
  private DruidaConector obtenerConectorZonas() throws Exception { 
    
    DTOEntradaModificarCronograma dtoe =	new DTOEntradaModificarCronograma();
    
    dtoe.setPais(new Long(this.pais));
    dtoe.setMarca(new Long(this.marca));
    dtoe.setCanal(new Long(this.canal));
    dtoe.setCodigoperiodo(new Long(this.codPeriodo));
    dtoe.setZona(new Long(this.zona));
    dtoe.setCodigoActividad(new Long(this.codActividad)); 
    dtoe.setGrupoZonas(new Long(this.gruposZonas));
    dtoe.setOidActividad(new Long(this.oidActividad));
    
       
		MareBusinessID id = new MareBusinessID("CRAObtieneZonasParaModificacion"); 
		Vector paramEntrada = new Vector(); 
		paramEntrada.add(dtoe); 
		paramEntrada.add(id);
    traza("dtoe:" + dtoe);
    traza("antes del conector");
		DruidaConector dc = conectar("ConectorObtenerZonasParaMoverActividad", paramEntrada); 
    traza("CONTENIDO DEL CONECTOR"+ dc.getXML().toString()); 
    return dc; 
  } 
 
 
 
  private void guardarEnSesionZonasValidas(DruidaConector dc) throws Exception { 
    this.conectorParametroSesion(CONECTOR_ZONAS_VALIDAS, dc); 
  } 
   
 
 
 
  /** 
   * Modificar 
   */ 
  private void modificarActividad() throws Exception{ 
    this.conectorParametroSesion("CRA_DTOCRONO" , dtoEMC); 
  } 
 
  /** 
   * Eliminar 
   */ 
  private void eliminarActividad() throws Exception{ 
    traza("LLAMA A LA MLN DE ELIMINAR"); 
    this.conectorParametroSesion("CRA_DTOCRONO" , dtoEEC); 
    this.conectorAction("LPEliminarCronograma"); 
    traza("ELIMINACION EXITOSA"); 
  } 
 
  /** 
   * Carga campos, combos y etiquetas de la pagina con el valor correspondiente 
   */ 
  private void cargarCampos() throws Exception{ 
    //COMBOs 
    /* 
    asignarAtributo("COMBO", "cbZona", "valor", zona); 
    asignarAtributo("COMBO", "cbSeccion", "valor", seccion); 
    */ 
 
    //CTEXTOs 
    /* 
    asignarAtributo("CTEXT", "txtDiasej", "valor", diasEjecucion); 
    asignarAtributo("CTEXT", "txtHora", "valor", horaEjecucion); 
    asignarAtributo("CTEXT", "txtDias", "valor", cadaCuantosDias); 
    asignarAtributo("CTEXT", "txtFechaIni", "valor", fechaInicio); 
    asignarAtributo("CTEXT", "txtFechaFin", "valor", fechaFin); 
    */ 
 
    //Esto es un RADIOB (RebelEstado) 
    //asignarAtributo("CTEXT", "txtDiasDeDesplazamiento", "valor", estado); 
 
    //Esto es un CHECKBOX (chkAnadir) 
    //asignarAtributo("CTEXT", "txtDiasDeDesplazamiento", "valor", aniadirActAsoc); 
 
    //Esto es un CHECKBOX (chkFija) 
    //asignarAtributo("CTEXT", "txtDiasDeDesplazamiento", "valor", fija); 
 
  } 
 
  /** 
   * Imprime el stack trace en caso de errores. 
   */ 
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
 
 
