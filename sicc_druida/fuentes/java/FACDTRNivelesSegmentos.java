import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.fac.DTOFACReporte;
import es.indra.mare.common.mln.MareBusinessID;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class FACDTRNivelesSegmentos extends LPSICCBase {           
   public FACDTRNivelesSegmentos() {	 
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
        }else
		if (accion.equals("generar2")){
           generarReporte2(); 
           traza("termino de generar el reporte2");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("FACDTRVariablesFuenteVenta1");
        }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      //  getConfiguracionMenu("EDUFichaTecnicaCurso");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
        BelcorpError error = new BelcorpError();
        DTOError dtoE = error.obtenerError(ex);
        
	      traza("EXCEPCION:" + stack.toString());
        traza("Codigo de error: "+dtoE.getCodigoError());
        if (dtoE.getCodigoError()!=null && dtoE.getCodigoError().equals("220101")){
            asignarAtributo("VAR","ejecutar","valor","mostrarErrorREP('"+dtoE.getCodigoError()+"')");
        }else{
            lanzarPaginaError(ex);
        }
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }
   
  }
  
 
  
  private void cargarPagina() throws Exception{
     pagina("contenido_niveles_segmentos");   
     asignarAtributoPagina("cod","01018");   
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR", "lp", "valor", "FACDTRNivelesSegmentos");
     this.generarHiddenFormatoFecha();  
      
  }
  
 
    
          
  
 private void generarReporte() throws Exception{
	   pagina("salidaGenerica");
	   traza("Generar Proceso");
       DTOFACReporte dtoe = new DTOFACReporte();
	   dtoe.setOidPais(UtilidadesSession.getPais(this));
       dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
	   dtoe.setMarca(Long.valueOf(conectorParametro("cbMarca")));
	   dtoe.setCanal(Long.valueOf(conectorParametro("cbCanal")));
	   dtoe.setPeriodo(Long.valueOf(conectorParametro("cbPeriodo")));
	   if (conectorParametro("cbZona").toString().length() >0)
		   dtoe.setZona(Long.valueOf(conectorParametro("cbZona")));
  	   if (conectorParametro("cbRegion").toString().length() >0)
		   dtoe.setRegion(Long.valueOf(conectorParametro("cbRegion")));
     
	   java.util.Vector vec = new java.util.Vector();  
	   vec.add(dtoe);
	   traza(dtoe);
 	   vec.add(new MareBusinessID("FACDTREjecutarProceso"));
   	   conectar("ConectorGenerico", vec);
  } 

  private void generarReporte2() throws Exception{
	   pagina("salidaGenerica");
	   traza("Generar Proceso2");
       DTOFACReporte dtoe = new DTOFACReporte();
	   dtoe.setOidPais(UtilidadesSession.getPais(this));
       dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
	   dtoe.setMarca(Long.valueOf(conectorParametro("cbMarca")));
	   dtoe.setCanal(Long.valueOf(conectorParametro("cbCanal")));
	   dtoe.setPeriodo(Long.valueOf(conectorParametro("cbPeriodo")));
	   if (conectorParametro("cbZona").toString().length() >0)
		   dtoe.setZona(Long.valueOf(conectorParametro("cbZona")));
  	   if (conectorParametro("cbRegion").toString().length() >0)
		   dtoe.setRegion(Long.valueOf(conectorParametro("cbRegion")));
     
	   java.util.Vector vec = new java.util.Vector();  
	   vec.add(dtoe);
	   traza(dtoe);
 	   vec.add(new MareBusinessID("FACDTREjecutarProceso2"));
	   conectar("ConectorGenerico", vec);
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