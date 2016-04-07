import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;

public class LPMantenimientoConcursos extends LPSICCBase{

  Long lIdioma;
  Long lPais;

  String accion;
  String opcionMenu;

  public void inicio() throws Exception {}
  
  public void ejecucion() throws Exception {
  
    this.setTrazaFichero();
  
    traza("entro a LPMantenimientoConcursos.ejecucion()");
  
    try{
      lIdioma = UtilidadesSession.getIdioma(this);
      lPais = UtilidadesSession.getPais(this);
    
      accion = this.conectorParametroLimpia("accion", "", true);
      opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);

      traza("LPMantenimientoConcursos.ejecucion() - opcionMenu: " + opcionMenu);

      if(accion.equalsIgnoreCase("")) {
          this.inicializar();
      }

      if (opcionMenu != null && opcionMenu.equalsIgnoreCase("crear concurso")) {
          this.getConfiguracionMenu("LPCrearConcurso", "");
      	  this.asignarAtributoPagina("cod", "0491");
          traza("LPMantenimientoConcursos.ejecucion() - asigno menu y titulo");
      } else if (opcionMenu != null && opcionMenu.equalsIgnoreCase("consultar concurso")){
          this.getConfiguracionMenu("LPMantenimientoConcursos", "consultar");
      	  this.asignarAtributoPagina("cod", "0493");
      } else if (opcionMenu != null && opcionMenu.equalsIgnoreCase("modificar concurso")){
          //this.getConfiguracionMenu("LPMantenimientoConcursos", "modificar");
          this.getConfiguracionMenu("LPMantenimientoConcursos", "busquedaModificar");
      	  this.asignarAtributoPagina("cod", "0486");
	  }

    }catch(Exception e){
      traza("Excepcion en LPMantenimientoConcursos: " + e.toString());
      traza(e);
      this.lanzarPaginaError(e);
    }
    
  }
  
  private void inicializar() throws Exception {
  
    traza("LPMantenimientoConcursos.inicializar()");
	traza("LPMantenimientoConcursos.inicializar() - opcionMenu: " + opcionMenu);

    if(opcionMenu != null && (opcionMenu.equalsIgnoreCase("modificar Concurso") ||
       opcionMenu.equalsIgnoreCase("Consultar Concurso"))){
      this.cargarPGBuscarConcurso();
    }else if(opcionMenu != null && opcionMenu.equalsIgnoreCase("crear Concurso")){
      this.cargarPGCrearConcurso();
    }
  }
  
  private void cargarPGCrearConcurso() throws Exception {
  
    traza("entro a LPMantenimientoConcursos.cargarPGCrearConcurso()");
  
    ComposerViewElementList cv = this.crearParametrosEntradaCrear();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
    
    //TODO: verificar que en la pagina los componentes tienen los nombres que
    //siguen
    this.pagina("contenido_concurso_crear");
    
    asignar("COMBO", "cbNumPlantilla", resultados, "INCCargarNroPlantilla");
  
    //TODO: agregar los siguientes hiddens a la pagina
    this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
    this.asignarAtributo("VAR", "accion", "valor", this.accion);
  }
  
  /* 
     Modificado por Cristian Valenzuela 
     4/5/2006
     Cambios de Versionado 
	*/
  private void cargarPGBuscarConcurso() throws Exception {
	traza("LPMantenimientoConcursos.cargarPGBuscarConcurso() - Entrada");
	this.pagina("contenido_concurso_modificar");  
    
    // Agregado por ssantana, 1/6/2005 
    // Se obtiene Pais e Idioma de Sesión, para enviar luego a la página.
    Long oidIdioma = UtilidadesSession.getIdioma(this);
    Long oidPais = UtilidadesSession.getPais(this);
  
    ComposerViewElementList cv = crearParametrosEntradaBuscar();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();

    asignar("COMBO", "cbNumPlantilla", resultados, "INCCargarNroPlantilla");
    asignar("COMBO", "cbNumConcurso", resultados, "INCCargarNroConcurso");
    asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
    asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
  
    this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
    this.asignarAtributo("VAR", "accion", "valor", this.accion);

    this.asignarAtributo("VAR", "hCteIndActivo", "valor", ConstantesINC.IND_ACTIVO.toString());
    this.asignarAtributo("VAR", "hCteIndInactivo", "valor", ConstantesINC.IND_INACTIVO.toString());

	this.asignarAtributo("VAR", "noVigencia", "valor", 
		ConstantesINC.OID_VIG_CONCU_NO_VIGENTE.toString());
    this.asignarAtributo("VAR", "estConcuAprobado", "valor", 
		ConstantesINC.OID_ESTADO_APROBADO.toString());
    
    // Agregado por ssantana, 1/6/2005
    // se setea en la pagina Idioma y Pais
    this.asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());
    this.asignarAtributo("VAR", "hPais", "valor", oidPais.toString());


	traza("LPMantenimientoConcursos.cargarPGBuscarConcurso() - Salida");
  }

  private ComposerViewElementList crearParametrosEntradaCrear() throws Exception {
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidPais(lPais);
    dtoe.setOidIdioma(lIdioma);

	ComposerViewElementList lista = new ComposerViewElementList(); 
    ComposerViewElement cve = null;
    
    // numeros de plantilla 
    cve = new ComposerViewElement();
	cve.setIDBusiness("INCCargarNroPlantilla");
	cve.setDTOE(dtoe);
    lista.addViewElement(cve);

    return lista;
  }

  /* 
     Modificado por Cristian Valenzuela 
	 4/5/2006
	 Cambios de Versionado 
  */
  private ComposerViewElementList crearParametrosEntradaBuscar() throws Exception {
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidPais(lPais);
    dtoe.setOidIdioma(lIdioma);

	DTOBuscarNumConcurso dtobn = new DTOBuscarNumConcurso();
	dtobn.setOidPais(lPais);
	dtobn.setOidIdioma(lIdioma);

	//if(opcionMenu.equals("Modificar Concurso")) {
	//	dtobn.setIndActivo(new Integer(0));
	//}
	//else if(opcionMenu.equals("Consultar Concurso")) { 
	//	dtobn.setIndActivo(new Integer(2));
	//}

	dtobn.setIndActivo(new Integer(2));

	//Agregado por incidencia 20568
	dtobn.setIndRanking(new Integer(0));
	//Agregado por incidencia 20568

	ComposerViewElementList lista = new ComposerViewElementList(); 
    ComposerViewElement cve = null;
    
    // números de plantilla 
	cve = new ComposerViewElement();
	cve.setIDBusiness("INCCargarNroPlantilla");
	cve.setDTOE(dtoe);
    lista.addViewElement(cve);

    // números de concurso 
	cve = new ComposerViewElement();
	cve.setIDBusiness("INCCargarNroConcurso");
	cve.setDTOE(dtobn);
    lista.addViewElement(cve);
    
    // canales 
	cve = new ComposerViewElement();
	cve.setIDBusiness("SEGConsultaCanales");
	cve.setDTOE(dtoe);
    lista.addViewElement(cve);
    
    // marcas     
	cve = new ComposerViewElement();
	cve.setIDBusiness("SEGConsultaMarcas");
	cve.setDTOE(dtoe);
    lista.addViewElement(cve);
    
    return lista;
  }
}