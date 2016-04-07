
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import java.util.Vector;


public class LPConsultarResumenAsignacion extends LPSICCBase 
{
    private String accion;
    private String pais;
    private String idioma;

  	public LPConsultarResumenAsignacion() {	super();	}

  	public void inicio() throws Exception {
      pagina ("contenido_resumen_asignacion_consultar");
    }
  
    public void ejecucion() throws Exception 
    {
    setTrazaFichero();
    try  {
          this.rastreo();
          traza(" Entrando a LPConsultarResumenAsignacion.ejecucion");
          pais = (UtilidadesSession.getPais(this)).toString();
          idioma = (UtilidadesSession.getIdioma(this)).toString();
          
          asignarAtributo("VAR","pais","valor", pais.toString());
          asignarAtributo("VAR","idioma","valor", idioma.toString());
          asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
          
          
          accion = conectorParametroLimpia("accion", "", true);
          traza("Accion de sesion: " + accion);
          if( accion.equals(""))
          {
            getConfiguracionMenu("LPConsultarResumenAsignacion",accion);	
            this.cargarPagina();
          }


   		   if ( accion.equals("VerificaCodigo") )   // Verifica Codigo de Cliente
         {
            this.verificaCodigoCliente();
         }
          
    }
    catch ( Exception e )  {
      traza("Exception en LPConsultarResumenAsignacion");
      e.printStackTrace();           
      if (accion.equals("VerificaCodigo"))
          this.asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda()");
      
      lanzarPaginaError(e);
    }
  }
  
  
  	private void cargarPagina() throws Exception{
    
    			DTOBelcorp dtoe = new DTOBelcorp();
          dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtoe.setOidPais(UtilidadesSession.getPais(this));
          ComposerViewElementList listaCompView = new ComposerViewElementList();
          ComposerViewElement elementoCV = new ComposerViewElement();
          elementoCV.setIDBusiness("COBObtenerUsuariosCobCombo");
          elementoCV.setDTOE(dtoe);
          listaCompView.addViewElement(elementoCV);
    
          traza ("listaCompView " + listaCompView);
          
          ConectorComposerView conector = new ConectorComposerView(listaCompView, this.getRequest());
          traza ("conector " +conector);
          conector.ejecucion();
          traza("Ejecutado");                                    
          // 5.- DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada); 
          DruidaConector conConsultar = conector.getConector(); 
          asignar("COMBO", "UsuarioCobranzas", conConsultar, "COBObtenerUsuariosCobCombo");
    
    }


    private void verificaCodigoCliente() throws Exception
    {
      traza("### Entro a verificaCodigoCliente ###");
      String sCodigoCliente = this.conectorParametroLimpia("hCodigoCliente", "", true);
      traza("Codigo de Cliente a Validar: " + sCodigoCliente);
      this.pagina("salidaGenerica");
      this.asignarAtributo("VAR", "cerrarVentana", "valor", "0");
      //this.asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda()");
      
      Vector vParam = new Vector();
      
      MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");

      DTOBusquedaRapidaCliente dtoBusqueda = new DTOBusquedaRapidaCliente();
      dtoBusqueda.setIndicadorSituacion(new Long(0));
      dtoBusqueda.setTamanioPagina(new Integer(1));
      dtoBusqueda.setOidPais(UtilidadesSession.getPais(this));
      dtoBusqueda.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoBusqueda.setCodigoCliente(sCodigoCliente);
      
      vParam.add(dtoBusqueda);
      vParam.add(idBusiness);
      
      traza("Conectando a ConectorBusquedaRapidaCliente... ");
      DruidaConector conector = this.conectar("ConectorBusquedaRapidaCliente", vParam);
      traza("Conectó.");
      
    }

  
  
}
