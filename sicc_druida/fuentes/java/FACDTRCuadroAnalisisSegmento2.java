import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBoolean;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;


public class FACDTRCuadroAnalisisSegmento2 extends LPSICCBase {
   
   public FACDTRCuadroAnalisisSegmento2() {
     super();
   }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
		traza("*********la accion es " + accion);
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else if(accion.equals("validarPeriodos")){
      			 pagina("salidaGenerica");
	             validarPeriodos();	
		      }else{
                 cargarPagina();
                 getConfiguracionMenu("FACDTRCuadroAnalisisSegmento2");
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

  private void validarPeriodos() throws Exception{
     traza("****entro");
	 

     String marca = conectorParametroLimpia("hidMarca", "", true);
     String canal = conectorParametroLimpia("hidCanal", "", true);
	 String periodoDesde = conectorParametroLimpia("hidPeriodoDesde", "", true);
     String periodoHasta = conectorParametroLimpia("hidPeriodoHasta", "", true);
	 String region = conectorParametroLimpia("hidRegion", "", true);
     String zona = conectorParametroLimpia("hidZona", "", true);
	 String marcaDesc = conectorParametroLimpia("hidMarcaDesc", "", true);
     String canalDesc = conectorParametroLimpia("hidCanalDesc", "", true);
	 String periodoDesdeDesc = conectorParametroLimpia("hidPeriodoDesdeDesc", "", true);
     String periodoHastaDesc = conectorParametroLimpia("hidPeriodoHastaDesc", "", true);
   
	 DTOOIDs dto = new DTOOIDs();
	 Long[] oids = new Long[2];
	 oids[0] = new Long(periodoDesde);
	 oids[1] = new Long(periodoHasta);

	 dto.setOids(oids);

	 String params = marca + "|" + marcaDesc + "|" + canal + "|" + canalDesc + "|" + periodoDesde + "|" +
	                 periodoDesdeDesc + "|" + periodoHasta + "|" + periodoHastaDesc + "|" + region + "|" + zona;



     MareBusinessID id = new MareBusinessID("REPValidaPeriodos");
     Vector vec = new Vector();
     
     vec.add(dto);
     vec.add(id); 

     DTOBoolean dtoB = (DTOBoolean)conectar("ConectorPrimerPeriodo",vec).objeto("dtoSalida");
    
	 if(dtoB.getValor()){
        asignarAtributo("VAR", "ejecutar", "valor", "cadenaParam('" + params + "')");    
	 }else{
	    asignarAtributo("VAR", "ejecutar", "valor", "alertaErrorPeriodos()");    	 
     }
 
  }
  
  private void cargarPagina() throws Exception{
     
     pagina("contenido_fuente_venta_campana_1");
     asignarAtributoPagina("cod","0811");
     
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR", "lp", "valor", "FACDTRCuadroAnalisisSegmento2");
     this.generarHiddenFormatoFecha();
     
     
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidIdioma(UtilidadesSession.getIdioma(this)); 
     dto.setOidPais(UtilidadesSession.getPais(this)); 
      
     MareBusinessID id = new MareBusinessID("REPObtienePrimerPeriodo");
     Vector vec = new Vector();
     
     vec.add(dto);
     vec.add(id); 
     
     DTOOID dtoOid = (DTOOID)conectar("ConectorPrimerPeriodo",vec).objeto("dtoSalida");
     
     asignarAtributo("VAR", "primerPeriodo", "valor", dtoOid.getOid().toString());
     
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
        
      
     String reporte = null;
     
   
     datos.put(ConstantesREP.TITULO, "Cuadro de Análisis por Segmento de Consultora 2");
     traza("++++++Antes de enviar a reportes " + datos); 
     
     String formato = conectorParametroLimpia("formato", "", true);
     
       
     //ejecutarReporte(datos, "REPGenerarReporte", "RFD-006", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_RFD-006", formato);
    
          
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

















