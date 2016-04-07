
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

public class PREValidacionEstimados extends LPSICCBase {           
   public PREValidacionEstimados() {	 
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
           getConfiguracionMenu("PREValidacionEstimados");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("PREValidacionEstimados");
               
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
      pagina("contenido_informe_validacion_estimados_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
          
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
      asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());           
      asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());           
     
        
   
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
     datos.put("MODULO", "PRE");
     
     //comienzo de los parametrso de filtrado
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);     
         
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);     
         
     String periodo        = conectorParametroLimpia("periodo", "", true);
     datos.put(ConstantesREP.PERIODO, periodo);     
     
     String diferenciaEstimado = conectorParametroLimpia("diferenciaEstimado", "", true);
     if(!diferenciaEstimado.equals("") && (diferenciaEstimado.equals("S"))){
        datos.put(ConstantesREP.DIFERENCIAESTIMADO,"1");
     }
     
     String diferenciaPrecio = conectorParametroLimpia("diferenciaPrecio", "", true);
     if(!diferenciaPrecio.equals("") && (diferenciaPrecio.equals("S"))){
        datos.put(ConstantesREP.DIFERENCIAPRECIO,"1");
     }
     
     String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCADESC, marcaDesc);     
         
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANALDESC, canalDesc);     
         
     String periodoDesc        = conectorParametroLimpia("periodoDesc", "", true);
          
     datos.put(ConstantesREP.TITULO, "Validacion de Estimados de Matriz de Facturacion Campaña " + periodoDesc);   
     traza("los datos son " + datos);
     traza("++++++Antes de enviar a reportes"); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-045", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-045", "pdf");
          
  } 
  
   
 


}


