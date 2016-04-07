import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.cob.DTOHistoricoMensajeLote;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.Date;
import java.text.SimpleDateFormat;



public class LPMarcarMensajesNoEnviadosLotes extends LPSICCBase 
{
  private String accion = null;
  private String spais = null;
  private String sidioma = null;
  private String oidLote = null;
  private String mostrarLista = "";
  
  public LPMarcarMensajesNoEnviadosLotes()
  {
    super();
  }
  public void inicio() throws Exception
  {
    pagina("contenido_mensajes_no_entregados_lote_marcar");
  }
  public void ejecucion() throws Exception
  {
        
    try
    {
      rastreo();
      setTrazaFichero();
      generarHiddenFormatoFecha();
      spais = UtilidadesSession.getPais(this).toString();
      traza(" pais en ejecucion: " + spais);
      sidioma = UtilidadesSession.getIdioma(this).toString();      
      traza(" idioma en ejecucion: " + sidioma);
      accion = this.conectorParametro("accion");
      traza(" accion en ejecucion: " + accion);
      if(this.accion==null){this.accion = "";
      asignarAtributo("VAR","accion","valor",accion);
      traza("accion: " + this.accion);}
      oidLote = this.conectorParametro("oidLote");
      traza(" oidLote en ejecucion: " + oidLote);
      if(this.oidLote==null){this.oidLote = "";
      traza("oidLote: " + this.oidLote);}
      
      traza("oidLote: " + this.oidLote);
      asignarAtributo("VAR","oidLote", "valor", oidLote);
      
      
      if(accion.equals("")){      
      cargarPagina();
      mostrarLista = "NO";
      asignarAtributo("VAR","ListadoDisponible","valor",mostrarLista);
      getConfiguracionMenu("LPMarcarMensajesNoEnviadosLotes", accion);
      } else 
      if(accion.equals("guardar")){
      mostrarLista = "NO";
      grabar();
      asignarAtributo("VAR","ListadoDisponible","valor",mostrarLista);
      cargarPagina();
      this.oidLote="";
      asignarAtributo("VAR","oidLote", "valor", oidLote);
      getConfiguracionMenu("LPMarcarMensajesNoEnviadosLotes", accion);
      
      } else
      if(accion.equals("buscar")){
      buscar();
      mostrarLista = "SI";
      asignarAtributo("VAR","ListadoDisponible","valor",mostrarLista);
      getConfiguracionMenu("LPMarcarMensajesNoEnviadosLotes", accion);
      cargarPagina();

      }
      
      
    }
    catch (Exception e)
    {
      traza("******** Entro al catch debido a...");
			e.printStackTrace(); 
			lanzarPaginaError(e);
    }
  }

  private void cargarPagina() throws Exception
  {
    cargarCombo();    
  }

  private void grabar() throws Exception
  {
    char separadorLinea = '^';
    try
    {
      String formatoFecha = UtilidadesSession.getFormatoFecha(this);
      formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.
      SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);
      
      DTOColeccion dtoColec = new DTOColeccion();
      ArrayList dTOHistoricoMensajeLoteList = new ArrayList();
      String valoresEditadosLista = this.conectorParametro("valoresEditadosLista");
      DTOHistoricoMensajeLote dtoHistoricoMensajeLote;
      StringTokenizer st1 = new StringTokenizer(valoresEditadosLista,"|");
      int cantLineas = st1.countTokens();
      traza("************ cantidad de lineas: " + cantLineas);
      for(int i = 0;i<cantLineas;i++){
        traza(" Linea nro: " + i);
    
        dtoHistoricoMensajeLote = new DTOHistoricoMensajeLote();        
        String linea = st1.nextToken();
        traza(" Linea: " + linea);

        StringTokenizer st2 = new StringTokenizer(linea,"^");
        int cantColumnas = st2.countTokens();
        traza("************ cantidad de Columnas: " + cantColumnas);
        int pos = 0;
        
          //-----
          String oid = "";
          String etapaDeuda = "";
          String periodo = "";
          String cliente ="";
          String fechaEntrega = "";
          String observaciones = "";
          String fechayobs = "";
          //-----
          traza(" paso 1 ");
          oid = st2.nextToken();       
          traza(" paso 2");
          dtoHistoricoMensajeLote.setOid(new Long(oid));
          pos = pos + oid.length();
          traza(" OID parseado: " + oid);
          etapaDeuda = st2.nextToken(); 
          traza(" EtapaDeuda parseado: " + etapaDeuda);
          pos = pos + etapaDeuda.length();
          
          
          periodo = st2.nextToken(); 
          pos = pos + periodo.length();
          traza(" Periodo parseado: " + periodo);
          
          cliente = st2.nextToken(); 
          pos = pos + cliente.length();
          traza(" Cliente parseado: " + cliente);
          

          
        pos = pos + 5; //5 es el nro de separadores que ya pase
        fechayobs = linea.substring(pos-1);
        traza(" Substring con fecha y Observaciones: " + fechayobs);
        if(fechayobs.charAt(0)==separadorLinea){//La fecha esta en blanco
          traza(" 1.-Fecha en blanco ");
          if(fechayobs.indexOf("^")!=(fechayobs.length()-1)){//Las observaciones no estan en blanco
            traza(" 2.- Observeciones no en blanco ");
            observaciones = fechayobs.substring(1);
          } 
        } else{
          traza(" 3.- Fecha no en blanco");
          fechaEntrega = st2.nextToken();
          //pos = pos + fechaEntrega.length();
          Date entrega = null;
          entrega = simpledateformat.parse(fechaEntrega);
          java.sql.Date sqlDate = new java.sql.Date(entrega.getTime());
          dtoHistoricoMensajeLote.setFechaEntrega(sqlDate);
          traza(" Fecha parseado: " + dtoHistoricoMensajeLote.getFechaEntrega().toString());
          if(fechayobs.indexOf("^")!=(fechayobs.length()-1)){//Las observaciones no estan en blanco
          traza(" 4.- Observaciones no en blanco");
          observaciones = fechayobs.substring(fechaEntrega.length()+1);}        
        }
        traza(" 5.- ");
        traza(" Observaciones parseado: " + observaciones);
        dtoHistoricoMensajeLote.setObservaciones(observaciones);
        dTOHistoricoMensajeLoteList.add(dtoHistoricoMensajeLote);
        traza(" Paso dTOHistoricoMensajeLoteList.add(dtoHistoricoMensajeLote);");  
        traza(" Linea nro: " + i);
      }
            
      dtoColec.setLista(dTOHistoricoMensajeLoteList);
      traza(" Paso   dtoColec.setLista(DTOHistoricoMensajeLoteList); ");
      MareBusinessID idBusiness = new MareBusinessID("COBGrabarMensajesLote");
      Vector params = new Vector();
      params.add(dtoColec);
      params.add(idBusiness);
      DruidaConector ConectorGrabarMensajesLote = conectar("ConectorGrabarMensajeLote", params);
    }
    catch (Exception e)
    {
      traza("******** Entro al catch debido a...");
			e.printStackTrace(); 
			lanzarPaginaError(e);
    }
    
  }

  private ComposerViewElementList crearParametrosEntrada() throws Exception
  {
    
    DTOBelcorp dtoEntrada = new DTOBelcorp();
    dtoEntrada.setOidPais(new Long(spais));
    traza("Pais de dtoEntrada  "+dtoEntrada.getOidPais());
    dtoEntrada.setOidIdioma(new Long(sidioma));
    traza("Idioma de dtoEntrada  "+dtoEntrada.getOidIdioma());
        
    ComposerViewElementList lista = new ComposerViewElementList(); 
    ComposerViewElement ci1 = new ComposerViewElement();
    //ci1.setIDBusiness("COBObtenerIdLotes");
    ci1.setIDBusiness("COBCargarIdLote");
    traza("IdBussines: "+ ci1.getIDBusiness());
    ci1.setDTOE(dtoEntrada);
    lista.addViewElement(ci1);
    traza("Salida de Metodo crearParametrosEntrada()");

    return lista;
  }

  private void cargarCombo() throws Exception
  {
    ComposerViewElementList cv = crearParametrosEntrada();
    traza ("1-");
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza ("El conector: "+conector);
    conector.ejecucion();
    traza ("2-");
    DruidaConector resultados = conector.getConector();
    traza ("3-");
    //asignar("COMBO", "cbIdentificadorLote", resultados, "COBObtenerIdLotes");
    asignar("COMBO", "cbIdentificadorLote", resultados, "COBCargarIdLote");
    traza("Salida de Metodo cargarCombo()");
  }

  private void buscar() throws Exception
  {
    try
    {
      DTOOID dtoOId = new DTOOID();
      
      dtoOId.setOidPais(new Long(spais));
      dtoOId.setOidIdioma(new Long(sidioma));
      traza("Parametro OidLote :"+oidLote);
	  // vbongiov --30/12/2008
      dtoOId.setOid(oidLote.equals("")?null:new Long(oidLote));
      
      MareBusinessID idBusiness = new MareBusinessID("COBCargarMensajesLote");
      Vector params = new Vector();
      params.add(dtoOId);
      params.add(idBusiness);
      traza("antes de conectar");
      DruidaConector conectorCargarMensajesLote = conectar("ConectorCargarMensajesLote", params);
      traza("El conector: "+ conectorCargarMensajesLote);      
      traza("despues de conectar");

        
        asignar("LISTA", "listado1", conectorCargarMensajesLote, "dtoSalida.resultado_ROWSET");
        
        traza("Salida de Metodo buscar()");

    }
    catch (Exception e)
    {
      traza("******** Entro al catch debido a...");
			e.printStackTrace(); 
			lanzarPaginaError(e);
    }
  
  }
     
}
