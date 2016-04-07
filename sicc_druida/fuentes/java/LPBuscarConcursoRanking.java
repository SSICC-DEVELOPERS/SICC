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
 * la dalistribución de este código sin permiso expreso.
 * 
 * 
 * @Autor:
 */
 
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;
import es.indra.sicc.util.UtilidadesSession;


public class LPBuscarConcursoRanking extends LPSICCBase {

  private String pais;
  private String idioma;
  private String opcionMenu;
  
  
  public LPBuscarConcursoRanking() {
    super();  
  }
  
  public void inicio() throws Exception { 
        this.pagina("contenido_concurso_ranking_buscar"); 
  }
  
  
// ---------------------------------------------------------------------------------------  
  public void ejecucion() throws Exception {
  this.setTrazaFichero();
  
  try {
      
      String sAccion = this.conectorParametroLimpia("accion", "", true);
      String opcionMenu = this.conectorParametroLimpia("opcionMenu", "",true);
      
      traza("opcionMenu: " + opcionMenu);
      traza("sAccion: " + sAccion); 
       
      if ( sAccion.equals("") ) {
          this.cargarPGBuscarConcursoRanking();
      }
      
      if (opcionMenu.equals("Consultar Concurso Ranking")){
          getConfiguracionMenu("LPBuscarConcursoRanking", "Consultar Concurso Ranking");
          asignarAtributoPagina("cod", "0525");
      }else if (opcionMenu.equals("Modificar Concurso Ranking")){
          getConfiguracionMenu("LPBuscarConcursoRanking", "Modificar Concurso Ranking");
          asignarAtributoPagina("cod", "0524");  
        }
      
      
      
      pais = UtilidadesSession.getPais(this).toString();
      
      traza("pais " + pais);
      idioma = UtilidadesSession.getIdioma(this).toString();
      traza("idioma " + idioma );

      asignarAtributo("VAR","hIdioma","valor", idioma );
      asignarAtributo("VAR","hPais","valor",  pais );
      
      traza("*****");
      
      asignarAtributo("VAR","opcionMenu","valor",opcionMenu);
      
      
       traza("$$$$$$$");
      
      } catch (Exception ex) {
            ex.printStackTrace();
            this.lanzarPaginaError(ex);
      }
  }
  
// ---------------------------------------------------------------------------------------    
  public void cargarPGBuscarConcursoRanking() throws Exception {
    traza("Entrando a LPBuscarConcursoRanking.cargarPGBuscarConcursoRanking()");

    DTOBelcorp dtoBelcorp = new DTOBelcorp();    
    DTOBuscarNumConcurso dtoBn = new DTOBuscarNumConcurso();
    
    String opcionMenu = this.conectorParametroLimpia("opcionMenu", "",true);
    
    
    ComposerViewElementList cList = new ComposerViewElementList();
    ComposerViewElement cView1 = new ComposerViewElement();
    ComposerViewElement cView2 = new ComposerViewElement();
    ComposerViewElement cView3 = new ComposerViewElement();    
    ComposerViewElement cView4 = new ComposerViewElement();
    
    DruidaConector con = null;    
    
    // ----- Genero DTOS para ComposerView -------------------------------
    Long oidIdiomaSesion = UtilidadesSession.getIdioma(this);
    Long oidPaisSesion = UtilidadesSession.getPais(this);
    
    dtoBelcorp.setOidIdioma(oidIdiomaSesion);
    dtoBelcorp.setOidPais(oidPaisSesion);
    
    dtoBn.setOidIdioma(oidIdiomaSesion);
    dtoBn.setOidPais(oidPaisSesion);
    
    if(opcionMenu.equals("Modificar Concurso Ranking")){
        dtoBn.setIndActivo(Integer.valueOf("0"));
    } else if(opcionMenu.equals("Consultar Concurso Ranking")){
        dtoBn.setIndActivo(Integer.valueOf("2"));
    }
    
    dtoBn.setIndRanking(Integer.valueOf("1"));

    // ------ Armo ComposerView -----------------------------------------
    cView1.setIDBusiness("INCCargarNroConcurso"); 
    cView1.setDTOE(dtoBn);

    cView2.setIDBusiness("SEGConsultaCanales"); 
    cView2.setDTOE(dtoBelcorp);
    
    cView3.setIDBusiness("SEGConsultaMarcas"); 
    cView3.setDTOE(dtoBelcorp);

    cList.addViewElement(cView1);
    cList.addViewElement(cView2);
    cList.addViewElement(cView3);
    
    
    ConectorComposerView cConector =  new ConectorComposerView(cList, this.getRequest() );
    
    // ------ Invoco al ComposerView -----------------------------------
    traza("Antes de Conectar...");
    cConector.ejecucion();
    traza("Luego de Conectar");
    
    con = cConector.getConector();
    
    
    this.asignar("COMBO", "cbNumConcurso", con, "INCCargarNroConcurso");
    this.asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");
    this.asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");    


  }
  
// ---------------------------------------------------------------------------------------  


}
