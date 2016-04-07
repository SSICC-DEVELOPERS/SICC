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
 *
 */
 

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.dtos.cob.DTOEBuscarEtapas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.Vector;


public class LPGenerarAsignacionCarteraPeriodo extends LPSICCBase {
    //definicion de variables
    String accion = null;
    String casoDeUso = null;
    Long pais = null;
    Long idiomaUsuario = null;
    String ipCliente = null;
    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;
    private boolean debugging = false;

    // Definicion del constructor
    public LPGenerarAsignacionCarteraPeriodo() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        TiempoDeCargaInicio = System.currentTimeMillis();

        this.rastreo();
        setTrazaFichero();        

        accion = this.conectorParametroLimpia("accion", "", true);
        casoDeUso = this.conectorParametroLimpia("casoDeUso", "", true);
        if (debugging) {
          ipCliente = "192.168.119.144";
          idiomaUsuario = new Long(1);
          pais = new Long(1);
        } else {
          ipCliente = UtilidadesBelcorp.getIPCliente(this);
          idiomaUsuario = UtilidadesSession.getIdioma(this);
          pais = UtilidadesSession.getPais(this);          
        }

        try {
            if (accion.equals("")) {
                cargarPagina();
            } else if (accion.equals("buscar")) {
                buscar();
            } else if (accion.equals("asignar")) {
                asignar();
            }

            TiempoDeCargaFin = System.currentTimeMillis();
            traza("El tiempo de carga de LPGenerarAsignacionCarteraPeriodo es :" +
                (TiempoDeCargaFin - TiempoDeCargaInicio));
        } catch (Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }
    
  /** 
   * Método para cargar la pagina principal
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private void cargarPagina() throws Exception {
    
        pagina("contenido_asignacion_cartera_periodo_generar");
        generarHiddenFormatoFecha();
        getFormatosValidaciones();
        this.getConfiguracionMenu("LPGenerarAsignacionCarteraPeriodo", "");

        cargaCombos();

        asignarAtributo("VAR","hoidPais","valor",(this.pais!=null?this.pais.toString():""));
        asignarAtributo("VAR","hoidIdioma","valor",(this.idiomaUsuario!=null?this.idiomaUsuario.toString():""));
       
    }


  /** 
   * Método para buscar el listado de etapas
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private void buscar() throws Exception { 
      cargarPagina();

      Long marca = ((conectorParametro("cbMarca")==null)||(conectorParametro("cbMarca").equals("")))?null:Long.valueOf(conectorParametro("cbMarca"));
      Long canal = ((conectorParametro("cbCanal")==null)||(conectorParametro("cbCanal").equals("")))?null:Long.valueOf(conectorParametro("cbCanal"));
      Long periodo = ((conectorParametro("cbPeriodo")==null)||(conectorParametro("cbPeriodo").equals("")))?null:Long.valueOf(conectorParametro("cbPeriodo"));
    
      DTOEBuscarEtapas dtoAsCob = new DTOEBuscarEtapas();
      dtoAsCob.setOidPais(this.pais);  
      dtoAsCob.setOidIdioma(this.idiomaUsuario);
      dtoAsCob.setMarca(marca);
      dtoAsCob.setCanal(canal);
      dtoAsCob.setPeriodo(periodo);     

      MareBusinessID id = new MareBusinessID("COBListadoEtapaGP");
      Vector vec = new Vector();
      vec.add(dtoAsCob);
      vec.add(id);
      //Invoco a ConectorListadoEtapaGEtapasGP 
      traza("antes de conectar ConectorListadoEtapaGEtapasGP");
      //pagina("salidaGenerica");
      //asignarAtributo("VAR", "ejecutarError", "valor", "quitaOculto();");
      DTOSalida dtoS = (DTOSalida) conectar("ConectorListadoEtapaGEtapasGP",
              vec).objeto("dtoSalida");
      RecordSet recordSet = dtoS.getResultado();
      
      recordSet = modificarFormatoFechas(recordSet);
      asignar("LISTADOA", "listado1",
          UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
              recordSet.getColumnIdentifiers()), "dtoSalida");

      asignarAtributo("VAR","hoidMarca","valor",conectorParametro("cbMarca"));
      asignarAtributo("VAR","hoidCanal","valor",conectorParametro("cbCanal"));
      asignarAtributo("VAR","hoidPeriodo","valor",conectorParametro("cbPeriodo"));
        
      //asignarAtributo("VAR", "ejecutar", "valor", "quitaOculto();");
      
    }
  /** 
   * Método para formatear la fecha del recordset al formato del pais.
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private RecordSet modificarFormatoFechas(RecordSet recordSet) throws Exception {    
        
          for (int i = 0;i<recordSet.getRowCount();i++)
          {
              traza("fecha sin formato"+recordSet.getValueAt(i,13));
              Date fechaSinFormato = (Date)recordSet.getValueAt(i,13);
              
              recordSet.setValueAt((String)obtenerFechaFormatoPais(fechaSinFormato),i,13);
          }
      
         return recordSet;          
    }
    
  /** 
   * Método para asignar la cartera
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */    
    private void asignar() throws Exception {    

/*
 * -> Se crea un DTOColeccion dtoColec 


-> Se crea un arrayList con DTOCronogramaCobranza. Por cada linea seleccionada en la lista editable tendremos un DTOCronogramaCobranza con los datos necesarios para realizar la asignacion de cada etapa 
-> Se asigna el arrayList al dtoColec 
-> Se crea el IDBusiness = COBAsignarCarteraPeriodos 
-> Asignar el conector ConectorAsignarCarteraPeriodos con IDBusiness y dtoColec 
 */
      traza("Entro en accion asignar");

      DTOColeccion dtoColec = new DTOColeccion();
      String listString = conectorParametroLimpia("listString","",true);
      traza("listString " + listString);
      
      StringTokenizer stRows = new StringTokenizer(listString, "$");
      int rowCount = stRows.countTokens();
      ArrayList cobranzas = new ArrayList();      
      for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
          StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");
          DTOCronogramaCobranza dtoCob = new DTOCronogramaCobranza();      
         
         traza("Entro en accion asignar1");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setIdCartera((Long)getNull(stCols.nextToken(),new Long(0)));//idCartera
          }          
          if (stCols.hasMoreTokens()) {
            stCols.nextToken();//usuCob
          }          
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//etapa
          }          
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//tipoCargo
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//marca
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//canal
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//VAL_NOMB_PERI
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//subgerencia
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//region
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//zona
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//seccion
          }
          if (stCols.hasMoreTokens()) { 
            stCols.nextToken();//territorio
          }
          traza("Entro en accion asignar2");
          if (stCols.hasMoreTokens()) {
            dtoCob.setFechaCierre(this.obtenerFechaFormatoDateDate(stCols.nextToken()));//fechaCierre
          }
          traza("Entro en accion asignar3");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidCobranza((Long) getNull(stCols.nextToken(),new Long(0)));//oidCronograma
          }
          traza("Entro en accion asignar4");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidUsuarioCobranza((Long) getNull(stCols.nextToken(),new Long(0)));//oidUsuarioCob
          }
          traza("Entro en accion asignar5");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidEtapa((Long) getNull(stCols.nextToken(),new Long(0)));//oidEtapa
          }
          traza("Entro en accion asignar6");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidTipoCargo((Long) getNull(stCols.nextToken(),new Long(0)));//oidTipoCargoAbono
          }
          traza("Entro en accion asignar7");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidMarca((Long) getNull(stCols.nextToken(),new Long(0)));//oidMarca
          }
          traza("Entro en accion asignar8");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidCanal((Long) getNull(stCols.nextToken(),new Long(0)));//oidCanal
          }
          traza("Entro en accion asignar9");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidPeriodo((Long) getNull(stCols.nextToken(),new Long(0)));//oidPeriodo
          }
          traza("Entro en accion asignar10");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidSubgerenciaVentas((Long) getNull(stCols.nextToken(),new Long(0)));//oidSubgerenciaVentas
          }
          traza("Entro en accion asignar11");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidRegion((Long) getNull(stCols.nextToken(),new Long(0)));//oidRegion
          }
          traza("Entro en accion asignar12");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidZona((Long) getNull(stCols.nextToken(),new Long(0)));//oidZona
          }
          traza("Entro en accion asignar13");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidSeccion((Long) getNull(stCols.nextToken(),new Long(0)));//oidSeccion
          }          
          traza("Entro en accion asignar14");
          if (stCols.hasMoreTokens()) { 
            dtoCob.setOidTerritorio((Long) getNull(stCols.nextToken(),new Long(0)));//oidTerritorio
          }    
          traza("Entro en accion asignar15");
          dtoCob.setOidPais(this.pais);
          dtoCob.setOidIdioma(this.idiomaUsuario);
       
          cobranzas.add(dtoCob);
      }      
      
      dtoColec.setLista(cobranzas);
      dtoColec.setOidPais(this.pais);
      dtoColec.setOidIdioma(this.idiomaUsuario);

      MareBusinessID id = new MareBusinessID("COBAsignarCarteraPeriodos");
      Vector vec = new Vector();
      vec.add(dtoColec);
      vec.add(id);
      //Invoco a ConectorAsignarCarteraPeriodos 
      traza("antes de conectar ConectorAsignarCarteraPeriodos");
      pagina("salidaGenerica");
      asignarAtributo("VAR", "ejecutarError", "valor", "quitaOculto();");
      DruidaConector conectorSalida = conectar("ConectorAsignarCarteraPeriodos",vec);
      asignarAtributo("VAR", "ejecutar", "valor", "quitaOculto();");
    }    
    
  /** 
   * Método de carga inicial de combos
   * @param void
   * @return void
   * @exception Exception
   * @author enozigli
   */
    private void cargaCombos() throws Exception{
      //Preparamos los parametros del subsistema
      ComposerViewElementList cv = crearParametrosEntrada();
		
      //Utilizamos el subsistema
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
		
      //Cargamos los combos con los resultados
      asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
      asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
    }

    private ComposerViewElementList crearParametrosEntrada(){
      ComposerViewElementList lista = new ComposerViewElementList(); 

      DTOBelcorp dtoe = new DTOBelcorp();    
      dtoe.setOidPais(this.pais);
      dtoe.setOidIdioma(this.idiomaUsuario);

      //Primer combo etapa
      ComposerViewElement ci1 = new ComposerViewElement();
      ci1.setIDBusiness("SEGConsultaMarcas");
      ci1.setDTOE(dtoe);    

      //Segundo combo canal
      ComposerViewElement ci2 = new ComposerViewElement();
      ci2.setIDBusiness("SEGConsultaCanales");
      ci2.setDTOE(dtoe);   

/*		//Refefinimos la posición de las columnas porque el resultado de 
		// la operación de negocio no es estándar
		ci2.setPosOID((byte)2);
		ci2.setPosDesc((byte)0);
  */    
      
      lista.addViewElement(ci1);
      lista.addViewElement(ci2);
    
      return lista;
    }
       
//------------------------METODOS DE APOYO--------------------------------------------

    private Object getNull(String val, Object obj){
        if (val.equals(" ")){
            try{traza("Valor ---" + val  + "---") ;}catch(Exception e){}
            return null;
        }else{
            if(obj instanceof Double) return new Double(val);
            if(obj instanceof Long) return new Long(val);
            if(obj instanceof Integer) return new Integer(val);            
            if(obj instanceof Float) return new Float(val);        
        }
        return null;
    }
    
    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    /**
    * Retorna el string fecha segun el formato por pais.
    * La fecha a formatear viene en formato Date YYYY-MM-DD.
    */
    private String obtenerFechaFormatoPais(Date fecha) throws Exception {
      // obtenemos el formato de fecha segun el pais
      // String formatoFecha = conectorParametro("hFormatoFechaPais");
      String formatoFecha = null;
      if (debugging) {
        formatoFecha = new String("yyyy-MM-dd");
      } else { 
        formatoFecha = UtilidadesSession.getFormatoFecha(this);
      }
      // aseguro el indicador de mes a mayuscula  
      formatoFecha = formatoFecha.replace('m','M');
      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
      //formateamos la fecha segun el formato del pais
      String fechaFormatoPaisStr = null;
      if (fecha != null){
        fechaFormatoPaisStr = formatoPais.format(fecha);
      }
      //retorna la fecha formateada    
      return fechaFormatoPaisStr;
    }
    /**
     * Retorna string fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private String obtenerFechaFormatoDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = null;
        if (debugging){
          formatoFecha = new String("yyyy-MM-dd");
        } else {
          formatoFecha = UtilidadesSession.getFormatoFecha(this);
        }
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        Date fechaFormatoDate = new java.sql.Date(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate.toString();
    }    
    
    /**
     * Retorna date fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private java.sql.Date obtenerFechaFormatoDateDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = null;
        if (debugging){
          formatoFecha = new String("yyyy-MM-dd");
        } else {
          formatoFecha = UtilidadesSession.getFormatoFecha(this);
        }
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        java.sql.Date fechaFormatoDate = new java.sql.Date(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate;
    }      
    
//------------------------FIN METODOS DE APOYO--------------------------------------------
}
