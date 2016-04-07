import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;    

public class LPConsultarHistoricoCobranza extends LPSICCBase {
  private Long hPais;
  private Long hIdioma;

  private String accion = null;     
    
  public  LPConsultarHistoricoCobranza() {  super();  }

  public void inicio() throws Exception {       
        pagina("contenido_historico_cobranza_consultar");
  }

  public void ejecucion() throws Exception {
	  	 hPais = UtilidadesSession.getPais(this);
         hIdioma = UtilidadesSession.getIdioma(this);

		 asignarAtributo("VAR","hPais", "valor", hPais.toString());
		 asignarAtributo("VAR","hIdioma", "valor", hIdioma.toString());
        
        try {
          setTrazaFichero();
          accion = conectorParametroLimpia("accion","",true);
          traza("La accion es: " + accion);
          if( accion.equals("")) {
            cargarPagina();
          } else  if( accion.equals("clienteSeleccionado") ) {
            clienteSeleccionado();        
          }
          
          getConfiguracionMenu();
        }
        catch (Exception e) {
          System.out.println("Entró en catch por...");
          lanzarPaginaError(e);
          e.printStackTrace();
        }        
  } 
     
 /*
  *  -> Crear un DTOBelcorp con pais e idioma de la sesión 
  *  -> Llamar al subsistema "GestorCargaPantalla" con los siguientes datos: 
  *  - idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena el combo de "canal" 
  *  - idBusiness = "SEGConsultaMarcas" => se llena el combo de "marca" 
  *  -> Mostrar página
  */
  private void cargarPagina() throws Exception  {
    traza("Entro a cargarPagina()...");
    ComposerViewElementList cvel = crearParametrosEntrada2();
    ConectorComposerView conector = new ConectorComposerView(cvel, this.getRequest());
    
    conector.ejecucion();
    
    DruidaConector resultados = conector.getConector();

    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales"); 
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
    asignarAtributo("VAR","hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
    traza("salio de cargarPagina....");

      
  }

  private ComposerViewElementList crearParametrosEntrada2() throws Exception{
    
    ComposerViewElementList lista = new ComposerViewElementList();
    DTOBelcorp dtoBel = new DTOBelcorp();
    
    dtoBel.setOidPais(UtilidadesSession.getPais(this));
    dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

    ComposerViewElement cve = new ComposerViewElement();        
    cve.setIDBusiness("SEGConsultaCanales");
    cve.setDTOE(dtoBel);
    
    ComposerViewElement cve2 = new ComposerViewElement();        
    cve2.setIDBusiness("SEGConsultaMarcas");
    cve2.setDTOE(dtoBel);
    
    
    lista.addViewElement(cve);
    lista.addViewElement(cve2);

    return lista;
  }


 /*
  *  -> Tomar de sesión el parámetro "codigoCliente" y mapearlo en el campo 
  *     "codigoCliente" de la pantalla 
  *  -> Deshabilitar el campo "codigoCliente" y el botón de búsqueda de 
  *     clientes para que el usuario no pueda cambiarlo 
  *  -> Mostrar página
  */
  private void clienteSeleccionado() throws Exception {
  
    String codigoCliente = (String) conectorParametro("oid");
	 String marca = (String) conectorParametro("marcaH");
	 String canal = (String)  conectorParametro("canalH");
	 String periodo = (String)  conectorParametro("periodoH");
					 
    cargarPagina();
    asignarAtributo("VAR", "hCodigoCliente", "valor", codigoCliente);
    asignarAtributo("VAR", "hMarca", "valor", marca);
	 asignarAtributo("VAR", "hCanal", "valor", canal);
	 asignarAtributo("VAR", "hPeriodo", "valor", periodo);
	 traza("hPeriodo es-->"+ periodo);
	 traza(" codigo cliente : --->"+codigoCliente);
    asignarAtributo("VAR", "accion", "valor", "clienteSeleccionado");   
	 asignarAtributo("VAR", "llamadaExterna", "valor", "true");  
   
  }
}
  
  
     
