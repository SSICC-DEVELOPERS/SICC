import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.util.Vector;
import java.util.StringTokenizer;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.edu.DTOApta;
import es.indra.sicc.dtos.edu.DTOObtenerAptas;
import es.indra.sicc.dtos.edu.DTOInsertaApta;

public class LPHistoricoCursos extends LPSICCBase {
          
	private String accion = null;
	private String casoUso = null;   
	private Long idioma;
	private Long pais;   
	
	public LPHistoricoCursos() {
	super();
	}
	
	public void inicio() throws Exception {
	
	}
	public void ejecucion() throws Exception {
  	    //rastreo();
            setTrazaFichero();
            try  {         
            	 	
                   traza("****LPHistoricoCursos Entrada");
                   /*cod="0205" titulo="Generar Histórico de Cursos"*/
                   
                   pagina("contenido_historico_cursos_generar");                           
                   this.idioma = UtilidadesSession.getIdioma(this);
                   this.pais = UtilidadesSession.getPais(this);
                   this.accion = conectorParametroLimpia("accion","", true);
                   
                   traza("****LPHistoricoCursos Accion: "+ this.accion);
                   
                   if(this.accion.equals("")){
                            cargaInicial();
                   }
                   if(this.accion.equals("Historico")){
                            pasoHistorico();
                   }

                   traza("****LPHistoricoCursos Salida");
            }catch ( Exception e )  {
                      e.printStackTrace();
                      logStackTrace(e);
                      lanzarPaginaError(e);
            }              
  	}//metodo 

        
          	
				
	private void cargaInicial() throws Exception{
             traza("LPHistoricoCursos.cargaInicial Entrada");		
             try{
             	   asignar("VAR", "idioma", idioma.toString());
                   asignar("VAR", "pais", pais.toString());	
                   asignarAtributo("PAGINA","contenido_historico_cursos_generar", "cod", "0205");
                   asignarAtributo("PAGINA","contenido_historico_cursos_generar", "msgle", "Generar Histórico de Cursos");
                   this.generarHiddenFormatoFecha();     //esta en LPSICCBase   
                  
                           
                   //getConfiguracionMenu("LPHistoricoCursos","Deshabilitar"); 
                   getConfiguracionMenu("LPHistoricoCursos", ""); 
                        
                   ComposerViewElementList listelem = new ComposerViewElementList();
                   ComposerViewElement elem = new ComposerViewElement();
                   ComposerViewElement elem1 = new ComposerViewElement();
                   	
                   DTOBelcorp dto = new DTOBelcorp();
                   dto.setOidPais(pais);
                   dto.setOidIdioma(idioma);
                   	
                   elem.setIDBusiness("SEGConsultaMarcas");
                   elem.setDTOE(dto);
                   elem.setPosOID((byte)0);
                   elem.setPosDesc((byte)1);
                          traza("******Elemento 0");
                   elem1.setIDBusiness("SEGConsultaCanales");
                   elem1.setDTOE(dto);
                   elem1.setPosOID((byte)0);
                   elem1.setPosDesc((byte)1);
                   	traza("*****Elemento 1");
                   listelem.addViewElement(elem);//añadimos vectores
                   	traza("****Elemento 0 anandido");
                   listelem.addViewElement(elem1);//añadimos
                   	traza("***Elemento 1 anandido");
                   	//Se llama al subsistema GestorCargaPantalla. 
                   ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
                   	traza("*****conector creado");
                   conector.ejecucion();
                   	traza("ejecutado");
                   DruidaConector conConsultar = conector.getConector();
                   	traza("Obtener conConsultar");
         
                           //Con los datos obtenidos en el ROWSET SEGConsultaMarcas se carga la combo cmbMarca 
                           //Con los datos obtenidos en el ROWSET SEGConsultaCanales se carga la combo cmbCanal
                   asignar("COMBO","cbMarca", conConsultar,"SEGConsultaMarcas");
                   asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
         
                }catch ( Exception e )  {
                           e.printStackTrace();
                           this.logStackTrace(e);
                           lanzarPaginaError(e);
                 }                  
                 traza("LPHistoricoCursos.cargaInicial Salida"); 		
          }
      private void pasoHistorico() throws Exception{
              traza("LPHistoricoCursos.pasoHistorico Entrada");		
             try{		
     		   pagina("salidaGenerica");

                   DTOOID dto = new DTOOID();
                   dto.setOidPais(this.pais);
                   dto.setOidIdioma(this.idioma);
                   //dto.oid = oid del curso seleccionado en lstCursos 
                   traza("*****conectorParametroLimpia,oidSeleccionado: "+conectorParametroLimpia("oidSeleccionado", "", true));
                   if(!conectorParametroLimpia("oidSeleccionado", "", true).equals("")){
                   	
                   	Long oid = new Long(conectorParametroLimpia("oidSeleccionado", "", true));
                   	traza("*****Oid Seleccionado: "+oid);
                   	dto.setOid(oid);
                }
                   /*Se crea DTOOID 
		DTOOID.oid = el oid del curso seleccionado en lstCursos 
		IdNegocio = "EDUGenerarPasoHistorico" 
		Se invoca al conector ConectorGenerarPasoHistorico
		*/
 
                   Vector paramConector = new Vector();
                   paramConector.add(dto);            
                   paramConector.add(new MareBusinessID("EDUGenerarPasoHistorico"));            
                
                   traza("***********Antes de Conectar  ConectorGenerarPasoHistorico");
                   DruidaConector conector = conectar("ConectorGenerarPasoHistorico", paramConector);
                   traza("***********Despues de Conectar ConectorGenerarPasoHistorico");
                   //Se refresca la lista lstCursos
          }catch ( Exception e )  {
                   e.printStackTrace();
                   this.logStackTrace(e);
                   lanzarPaginaError(e);
          }                 
          traza("LPHistoricoCursos.pasoHistorico Salida");                
  }                         

   private void logStackTrace(Throwable e) throws Exception {
          traza("Se produjo la excepcion: " + e.getMessage());		
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(baos);
          e.printStackTrace(ps);		
          traza("Stack Trace: " + baos.toString());
  }      
        
        
        
}//clase