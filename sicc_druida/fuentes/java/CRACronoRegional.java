import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

public class CRACronoRegional extends LPSICCBase {           
   public CRACronoRegional() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("CRACronoRegional");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("CRACronoRegional");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
      pagina("contenido_informe_cronograma_regional_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
           
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
      asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     
           
   
  }
  
  
 
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo marca
     ComposerViewElement cbMarca = new ComposerViewElement();
     cbMarca.setIDBusiness("SEGConsultaMarcas");
     cbMarca.setDTOE(dtoBel);
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
                          
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
        
     
     return lista;
  }
         
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CRA");
     
     //comienzo de los parametrso de filtrado
     
    
     
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }
        
       
     String periodo        = conectorParametroLimpia("periodo", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODO, periodo);     
     }
     
     String actividad    = conectorParametroLimpia("actividad", "", true);
     if(!actividad.equals("")){
        datos.put(ConstantesREP.ACTIVIDADES, actividad);     
     }
     
     String region    = conectorParametroLimpia("region", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGION, region);     
     }
     
     datos.put(ConstantesREP.TITULO, "Cronograma por regional");
          
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-007", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-007", "pdf");
          
  } 
  
 
 


}



