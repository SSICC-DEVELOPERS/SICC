/* 
 *      LPConsultarLiquidacionComisionesCobranza.java
 */
 
 /**
  *   author: pperez
  */
  
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;    


public class LPConsultarLiquidacionComisionesCobranza extends LPSICCBase {

    private String accion = null; 
    private Long aPais = null; 
    private Long aIdioma = null; 
    
  public  LPConsultarLiquidacionComisionesCobranza() {
        super();
  }


 /* 
  * -> Asignar página "contenido_historico_cobranza_consultar" 
  */
  public void inicio() throws Exception {       

        pagina("contenido_liquidacion_comisiones_cobranza_consultar");
  }


 /*
  * Si (accion == "") entonces 
  *   -> ejecutar método "cargarPagina()" 
  * Si no Si (accion == "clienteSeleccionado") entonces 
  *   -> ejecutar método "clienteSeleccionado()" 
  * Si no Si (accion == "detalle") entonces 
  *    -> ejecutar método "detalle()" 
  * Fin Si
  */
  public void ejecucion() throws Exception {
        
        try {
          setTrazaFichero();
          accion = conectorParametroLimpia("accion","",true);
          aPais = UtilidadesSession.getPais(this);
          aIdioma = UtilidadesSession.getIdioma(this);
          
          traza("La accion es: " + accion);
          if( accion.equals("")) {
            cargarPagina();
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
    asignar("COMBO","cbUsuarioCobranza",resultados,"COBObtenerUsuariosCobCombo");
    asignarAtributo("VAR","hPais","valor",aPais.toString());
    asignarAtributo("VAR","hIdioma","valor",aIdioma.toString());
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
    
    ComposerViewElement cve3 = new ComposerViewElement();        
    cve3.setIDBusiness("COBObtenerUsuariosCobCombo");
    cve3.setDTOE(dtoBel);
    
    lista.addViewElement(cve);
    lista.addViewElement(cve2);
    lista.addViewElement(cve3);
    
    return lista;
  }
}
  
  
     
