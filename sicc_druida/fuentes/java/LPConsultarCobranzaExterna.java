/* 
 *      LPConsultarCobranzaExterna.java
 */
 
 /**
  *   author: pperez
  */
  
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOUsuariosYGruposCOB;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.util.Vector;    


public class LPConsultarCobranzaExterna extends LPSICCBase {

    private String accion = null; 
    private Long aPais = null; 
    private Long aIdioma = null; 
    
  public  LPConsultarCobranzaExterna() {
        super();
  }


 /* 
  * -> Asignar página "contenido_historico_cobranza_consultar" 
  */
  public void inicio() throws Exception {       

        pagina("Contenido_reporte_cobranza_externa_generar");
		 
		  this.getFormatosValidaciones();

  }


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
     
  private void cargarPagina() throws Exception  {
    traza("Entro a cargarPagina()...");
    ComposerViewElementList cvel = crearParametrosEntrada2();
    ConectorComposerView conector = new ConectorComposerView(cvel, this.getRequest());
    
    conector.ejecucion();
    
    DruidaConector resultados = conector.getConector();

    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales"); 
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
    asignar("COMBO","cbTipoCargo",resultados,"CCCObtenerTiposCargo");
	 //inicio inc.17787
	 asignar("COMBO","cbEtapaDeuda",resultados,"COBObtenerEtapasDeuda");
	 //fin inc. 17787
    asignarAtributo("VAR","hPais","valor",aPais.toString());
    asignarAtributo("VAR","hIdioma","valor",aIdioma.toString());

    MareBusinessID marebusinessid = new MareBusinessID("COBCargarUsuariosYGruposCOB");
    DTOBelcorp dtoBelcorp = new DTOBelcorp();
    
    dtoBelcorp.setOidPais(aPais);
    dtoBelcorp.setOidIdioma(aIdioma);
    
    Vector vector = new Vector();
    vector.addElement(dtoBelcorp);
    vector.addElement(marebusinessid);
    
    traza(" ANTES DE CONECTAR");
    DruidaConector druidaconector = conectar("ConectorCargarUsuariosYGruposCOB",vector);
    traza(" DESPUES DE CONECTAR");
    
    DTOUsuariosYGruposCOB dtoUsuarios =  (DTOUsuariosYGruposCOB) druidaconector.objeto("DTOSalida");
    
    
    Vector vecUsuarios = dtoUsuarios.getUsuarios().getColumnIdentifiers();
    DruidaConector usuarios = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",dtoUsuarios.getUsuarios(),vecUsuarios);
    asignar("COMBO","cbCodUsuario",usuarios,"DTOSalida.resultado_ROWSET");                                           

    Vector vecGrupoUsuarios = dtoUsuarios.getGrupos().getColumnIdentifiers();
    DruidaConector grupoUsuarios = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",dtoUsuarios.getGrupos(),vecGrupoUsuarios);
    asignar("COMBO","cbCodGrupoUsuario",grupoUsuarios,"DTOSalida.resultado_ROWSET");                                           
    
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
    cve3.setIDBusiness("CCCObtenerTiposCargo");
    cve3.setDTOE(dtoBel);

	 ComposerViewElement cve4 = new ComposerViewElement();        
    cve4.setIDBusiness("COBObtenerEtapasDeuda");
    cve4.setDTOE(dtoBel);
    
    lista.addViewElement(cve);
    lista.addViewElement(cve2);
    lista.addViewElement(cve3);
    lista.addViewElement(cve4);
    
    return lista;
  }
}
