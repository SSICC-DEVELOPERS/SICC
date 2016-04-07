 import java.util.HashMap;
 import es.indra.sicc.util.UtilidadesSession;
 import es.indra.sicc.util.DTOBelcorp;
 import es.indra.sicc.dtos.msg.DTOSeleccionMensajes; 
 import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
 import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
 import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
 import es.indra.mare.common.exception.MareException;
 import es.indra.mare.common.mln.MareBusinessID; 
 import es.indra.druida.DruidaConector;
 import java.io.ByteArrayOutputStream;
 import java.io.PrintStream;
 import java.util.Vector; 

public class LPImprimirMensajesEditor extends LPSICCBase {
  private HashMap param = new HashMap();
  private String pais = null;
  private String idioma = null;  
  private String oidPatron  = null;
  private String codigoCliente = null;
  private String oidPeriodo = null;
  
  public LPImprimirMensajesEditor() { super(); }
    
  public void inicio() throws Exception { pagina("contenido_msg_imprimir"); }

  public void ejecucion() throws Exception {
      String accion = conectorParametro("accion");
      accion = (accion==null )?"":accion;
      param=conectorParametro();
      setTrazaFichero();
      traza("Parametros de entrada" + param);
      traza("Entro a LP con accion = "+ accion);
      
      pais = UtilidadesSession.getPais(this).toString();
      traza("pais >>>>  "  +pais );
	
      idioma = UtilidadesSession.getIdioma(this).toString();
      traza("idioma >>>> " + idioma);      

	  try {      
		  getConfiguracionMenu("LPConsultarMensajes","");
          asignarAtributoPagina("cod", "0330");              
          
          if(accion.equals("")){
            cargarPGImprimirMensajes(); 
          }

          if(accion.equals("Imprimir mensajes")){
			pagina("salidaGenerica");
            traza("al metodo");
            imprimirMensajesDesdeEditor(); 
          }
      }
	  catch(Exception ex){
		this.traza("Error en ejecucion");
        this.lanzarPaginaError(ex);
        logStackTrace(ex);
      }
  }

	private void cargarPGImprimirMensajes()throws Exception{
		traza("********* Entro a cargarPGImprimirMensajes");

		ComposerViewElementList cv = this.crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

		traza("********* Va a cargar combos");
		asignar("COMBO","comboPatron",resultados,"MSGObtenerTodosPatrones");
		asignar("COMBO","comboTipoPeriodo",resultados,"SEGObtenerTiposPeriodo");

		traza("********* Asignando variables de pagina");
		asignarAtributo("VAR","hPais","valor", pais);
	    asignarAtributo("VAR","hIdioma","valor", idioma);

    /*DTOSeleccionMensajes dto = new DTOSeleccionMensajes();
    
    //idioma = UtilidadesSession.getIdioma(this);
    ComposerViewElementList cbCodigoPatron  = this.getConectores("MSGObtenerTodosPatrones",(DTOBelcorp)dto ,"es.indra.sicc.util.DTOBelcorp",0,1);
    ComposerViewElementList cbTipoPeriodo  = this.getConectores("SEGObtenerTiposPeriodo",(DTOBelcorp)dto ,"es.indra.sicc.util.DTOBelcorp",0,1);
    ConectorComposerView conectorCodigoPatron = new ConectorComposerView(cbCodigoPatron,this.getRequest());
    ConectorComposerView conectorTipoPeriodo = new ConectorComposerView(cbTipoPeriodo,this.getRequest());
    conectorCodigoPatron.ejecucion();
    conectorTipoPeriodo.ejecucion();
    DruidaConector tipoPeriodo = conectorTipoPeriodo.getConector();
    DruidaConector patron = conectorCodigoPatron.getConector();  
    asignar("COMBO","comboPatron",patron,"MSGObtenerTodosPatrones");
    asignar("COMBO","comboTipoPeriodo",tipoPeriodo,"SEGObtenerTiposPeriodo");
    asignarAtributo("VAR","hPais","valor",UtilidadesSession.getPais(this).toString());
    asignarAtributo("VAR","hIdioma","valor",UtilidadesSession.getIdioma(this).toString());*/
  }

   private ComposerViewElementList crearParametrosEntrada() throws Exception {
 	    traza("********* Entro a crearParametrosEntrada");
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(new Long(pais));
        dtoe.setOidIdioma(new Long(idioma));

		ComposerViewElementList lista = new ComposerViewElementList(); 
        ComposerViewElement cve = null;
    
		//Carga el combo Cód. patrón
        cve = new ComposerViewElement();
		cve.setIDBusiness("MSGObtenerTodosPatrones");
		cve.setDTOE(dtoe);
		cve.setPosOID((byte)0);
        cve.setPosDesc((byte)1);    
        lista.addViewElement(cve);

		//Carga el combo Tipo periodo
        cve = new ComposerViewElement();
		cve.setIDBusiness("SEGObtenerTiposPeriodo");
		cve.setDTOE(dtoe);
		cve.setPosOID((byte)0);
        cve.setPosDesc((byte)1);    
        lista.addViewElement(cve);
    
        return lista;
    }

  private void imprimirMensajesDesdeEditor()throws Exception{
    pagina("salidaGenerica");

	traza("************* Entro a imprimirMensajesDesdeEditor");
    DTOSeleccionMensajes dto = new DTOSeleccionMensajes();
   
    oidPatron = conectorParametroLimpia("oidPatronH", "", true);	
    codigoCliente = conectorParametroLimpia("codigoClienteH", "", true);	
    oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);

	traza("************* oidPatron " + oidPatron);
	traza("************* codigoCliente " + codigoCliente);
	traza("************* oidPeriodo " + oidPeriodo);    
    
    dto.setOidPatron(new Long(oidPatron));
    
    if( (codigoCliente != null) || !codigoCliente.equals("")){
       dto.setCodigoCliente(codigoCliente);
    }
    
    if(!oidPeriodo.equals("")){
      dto.setOidPeriodo(new Long(oidPeriodo));
    }    
    
    dto.setOidIdioma(new Long(idioma));
	dto.setOidPais(new Long(pais));	
	dto.setOidSubacceso(UtilidadesSession.getSubaccesoPorDefecto(this));
    
    Vector objBussines = new Vector();
    MareBusinessID id = new MareBusinessID("MSGImprimirMensajesDesdeEditor");
    
    objBussines.add(dto);
    objBussines.add(id);
    
    try {
		  traza("************* Antes de conectar");
          DruidaConector con = conectar("ConectorImprimirMensajeDesdeEditor", objBussines);
		  traza("************* Despues de conectar");
    
    } catch(Exception e){    
          asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
          asignarAtributo("VAR", "errCodigo", "valor", "MSG_0021");
		  throw e;
    }      
  }

 /*ComposerViewElementList getConectores(String negocio,Object objto,String clase,int posOid, int posDesc)
	 throws Exception{
     ComposerViewElementList lista = new ComposerViewElementList();
    
     Class c = Class.forName(clase);
     Object Dto = c.newInstance();
     Dto = objto;
     ComposerViewElement c1 = new ComposerViewElement();     
     
     c1.setIDBusiness(negocio);
     c1.setDTOE((DTOBelcorp)Dto);
     c1.setPosOID((byte)posOid);
     c1.setPosDesc((byte)posDesc);    

     lista.addViewElement(c1);     

     return lista;
  }*/

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
}