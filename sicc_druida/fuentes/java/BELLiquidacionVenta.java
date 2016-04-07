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

public class BELLiquidacionVenta extends LPSICCBase {           
   public BELLiquidacionVenta() {	 
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
           getConfiguracionMenu("BELLiquidacionVenta");
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
     pagina("contenido_liquidacion_venta_obtener");   
    
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
         
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
        
     this.generarHiddenFormatoFecha();
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "BEL");
     
     //comienzo de los parametrso de filtrado
             
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);     
          
     String acceso        = conectorParametroLimpia("acceso", "", true);
     datos.put(ConstantesREP.ACCESO, acceso);     
     
     
     String subacceso        = conectorParametroLimpia("subacceso", "", true);
     datos.put(ConstantesREP.SUBACCESOS, subacceso);     

	 String subaccesoDesc        = conectorParametroLimpia("subaccesoDesc", "", true);
     datos.put(ConstantesREP.DESCRIPCION, subaccesoDesc);     
	         
         
     
     
     String fechaCierre        = conectorParametroLimpia("fechaCierre", "", true);
     if(!fechaCierre.equals("")){
        datos.put(ConstantesREP.FECHACIERRE, fechaCierre);     
     }
            
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
    
     datos.put(ConstantesREP.TITULO, "Liquidacion de Venta");     
     traza("++++++Antes de enviar a reportes " + datos); 
          
     
     
     traza("el formaro es  " + formato);
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-094", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-094", formato);
          
  } 
  
   
    
    private ComposerViewElementList crearParametrosEntrada() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       
     ComposerViewElementList lista = new ComposerViewElementList();
      
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
                          
    
     lista.addViewElement(cbCanales);   
        
     
     return lista;
  }
  
  
 
  
  

    
  
 
 


}













