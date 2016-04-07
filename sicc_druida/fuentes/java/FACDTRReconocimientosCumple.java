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
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class FACDTRReconocimientosCumple extends LPSICCBase {           
   public FACDTRReconocimientosCumple() {	 
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
           getConfiguracionMenu("FACDTRReconocimientosCumple");
        }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      //  getConfiguracionMenu("EDUFichaTecnicaCurso");
               
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
     pagina("contenido_listado_reconocimientos");   
        
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
  
     this.generarHiddenFormatoFecha();
   
      
  }
  
 
    
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "FAC-DTR");
     
     //comienzo de los parametrso de filtrado
        
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);
     
     String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCADESC, marcaDesc);
     
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);
     
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANALDESC, canalDesc);
     
     String periodoDesde        = conectorParametroLimpia("periodoDesde", "", true);
     datos.put(ConstantesREP.PERIODODESDE, periodoDesde);
     
     String periodoDesdeDesc        = conectorParametroLimpia("periodoDesdeDesc", "", true);
     datos.put(ConstantesREP.PERIODODESDEDESC, periodoDesdeDesc);
     
     String periodoHasta        = conectorParametroLimpia("periodoHasta", "", true);
     datos.put(ConstantesREP.PERIODOHASTA, periodoHasta);
     
     String periodoHastaDesc        = conectorParametroLimpia("periodoHastaDesc", "", true);
     datos.put(ConstantesREP.PERIODOHASTADESC, periodoHastaDesc);
     
     String region        = conectorParametroLimpia("region", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGION, region);
     }
     
     String zona        = conectorParametroLimpia("zona", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONA, zona);
     }
     
     String mes        = conectorParametroLimpia("mes", "", true);
     if(!mes.equals("")){
        datos.put(ConstantesREP.MES, mes);
     }
        
      
     String reporte = null;
     
   
     datos.put(ConstantesREP.TITULO, "Listado de Reconocimientos");     
     traza("++++++Antes de enviar a reportes " + datos); 
     
     String formato = conectorParametroLimpia("formato", "", true);
     
       
     //ejecutarReporte(datos, "REPGenerarReporte", "RFD-010", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_RFD-010", formato);
    
          
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

  
            
}



















