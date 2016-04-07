 /**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/


import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import java.util.StringTokenizer;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.mare.common.dto.*;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.util.ArrayList;

public class LPEliminarCupon3 extends LPSICCBase {
          
	private String accion = null;
    private String casoUso = null;
    private Long pais;
    private Long idioma;
	private Long oidPais = null;
          
    public LPEliminarCupon3() {
    	super();
    }

    public void inicio() throws Exception {
    	pagina("contenido_cupon3_consultar");
                    
    }
    public void ejecucion() throws Exception {
    	setTrazaFichero();
    	try  {         
			traza("*** LPEliminarCupon3: Entrada ***");
			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","", true);
			traza("Accion definida : "+accion);
    		this.casoUso = "eliminar";
    		asignar("VAR", "casoUso", this.casoUso);
    		    		
    		asignar("VAR", "idioma", idioma.toString());
            traza("->Idioma : "+idioma);
            asignar("VAR", "pais", pais.toString());	
            traza("->Pais : "+pais);
            // Fecha:
            this.generarHiddenFormatoFecha();
			oidPais = UtilidadesSession.getPais(this);
            
            Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
            asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());
    		
    		asignarAtributo("PAGINA","contenido_cupon3_consultar", "cod", "0340");
            asignarAtributo("PAGINA","contenido_cupon3_consultar", "msgle", "Eliminar Cupón 3");
            getConfiguracionMenu("LPEliminarCupon3","");
    		
    		if(this.accion.equals("") ){
    			//Carga inicial de los combos:
				this.cargaInicial(oidPais, idioma);
			}
    
    		traza("*** LPEliminarCupon3: Salida ***");
    		
    
    	 }catch ( Exception e )  {
         	e.printStackTrace();
         	logStackTrace(e);
            lanzarPaginaError(e);
         }              
    
    }
    private void cargaInicial(Long idioma, Long pais) throws Exception {
		traza(" *** Metodo cargaInicial: Entrada ***");
    		//Con el gestor cargaPantalla cargamos: canal, banco y situacion 
		
		    ComposerViewElementList listelem = new ComposerViewElementList();
        	//SCS 02/06/08 ComposerViewElement canal = new ComposerViewElement(); 
        	ComposerViewElement banco = new ComposerViewElement();
        	ComposerViewElement situacion = new ComposerViewElement();
                    	                    	
        	DTOBelcorp dto = new DTOBelcorp();
        	dto.setOidPais(oidPais);
        	dto.setOidIdioma(idioma);
                    	
        	//SCS 02/06/08 canal.setIDBusiness("SEGConsultaCanales");
        	//SCS 02/06/08 canal.setDTOE(dto);
        	//SCS 02/06/08 traza("Elemento canal");
        
        	banco.setIDBusiness("CCCObtenerCuentasCorrientesBancarias");
        	banco.setDTOE(dto);
        	traza("Elemento banco");
        
        	situacion.setIDBusiness("CCCObtenerSituacionesCuponTodas");
        	situacion.setDTOE(dto);
        	traza("Elemento situacion");
                        
        	//SCS 02/06/08 listelem.addViewElement(canal);
        	listelem.addViewElement(banco);
        	listelem.addViewElement(situacion);
        	traza("Elementos anadidos");
        	//Se llama al subsistema GestorCargaPantalla. 
        	ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
        	traza("conector creado");
        	conector.ejecucion();
        	traza("ejecutado");
        	DruidaConector conConsultar = conector.getConector();
        	traza("Obtener conConsultar");
                 
        	//SCS 02/06/08 asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales");
        	//SCS 02/06/08 traza("Combo canal asignado");
		    asignar("COMBO","cbBanco", conConsultar,"CCCObtenerCuentasCorrientesBancarias");
        	traza("Combo banco asignado");
        	asignar("COMBO","cbSituacion", conConsultar,"CCCObtenerSituacionesCuponTodas");
        	traza("Combo situacion asignado");

			cargarMarcaCanal();

			Long oidMarcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
			Long oidCanalDefecto = UtilidadesSession.getCanalPorDefecto(this);

			asignarAtributo("VAR","hOidMarca","valor",oidMarcaDefecto.toString());
			asignarAtributo("VAR","hOidCanal","valor",oidCanalDefecto.toString());

			cargarPeriodo(oidPais, oidMarcaDefecto, oidCanalDefecto);
        
        	traza(" *** Metodo cargaInicial: Salida ***");        
                
	}

    /*, se comenta porq' el metodo de seg choca contra el esquema conceptual 
	private void cargarMarcaCanal() throws Exception{
		traza("Entró de cargarMarcaCanal()");
		DTOFiltroPMC paisMarcaCanal = new DTOFiltroPMC();
		paisMarcaCanal.setOidIdioma(idioma);
		paisMarcaCanal.setPaises(Boolean.TRUE);
		paisMarcaCanal.setMarcas(Boolean.TRUE);
		paisMarcaCanal.setCanales(Boolean.TRUE);

		Vector paramEntrada = new Vector();
		paramEntrada.add(paisMarcaCanal);

		paramEntrada.add(new MareBusinessID("CRAPaisMarcaCanal"));
		DruidaConector conectorCargarPaisMarcaCanal = conectar("ConectorCargarPaisMarcaCanal", paramEntrada);

		asignar("COMBO", "cbMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
		asignar("COMBO", "cbCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

		traza("Salio de cargarMarcaCanal()");
	}*/

	private void cargarMarcaCanal() throws Exception{
		traza("Entró de cargarMarcaCanal()");

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma); 
       	String[] idBusiness = {"SEGConsultaMarcas", "SEGConsultaCanales"};
        	             
       	ArrayList dtos = new ArrayList();
       	dtos.add(dtoBelcorp);
       	dtos.add(dtoBelcorp);
        	                                                               
       	String[] combos = {"cbMarca", "cbCanal"};      
		cargaCombos(dtoBelcorp, idBusiness, dtos, combos, null, null);

		traza("Salio de cargarMarcaCanal()");
	}
	
	private void cargaCombos(DTOBelcorp dtoBelcorp, 
                             	String[] idBusiness, 
                                	ArrayList dtos,
                                    	String[] combos, 
                                      		String[] seleccionados, 
                                      			String[] columnas) throws Exception {
                    
		traza("*** Entrada - cargaCombos ***");
                    
        try {
            	//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
            	ComposerViewElementList listelem = new ComposerViewElementList();
            	ComposerViewElement elem = null;
                
                // [1] DTOBelcorp unDto = null;
				int tamano = idBusiness.length;
                for (int i = 0; i < tamano; i++) {
                	
                	elem = new ComposerViewElement(); 
                	elem.setIDBusiness(idBusiness[i]);
                	//[1] unDto = (DTOBelcorp)dtos.get(i);
                	elem.setDTOE((DTOBelcorp)dtos.get(i));
                	listelem.addViewElement(elem);
                }

                //Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados. 
                ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());

                conector.ejecucion();
                              
               	//traza("*** antes de coger el conector ");	
               	DruidaConector conConsultar = conector.getConector();
               	//traza("*** despues de coger el conector ");
                              
                //Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
                //correspondiente utilizando el String que representa el BusinessID en cada caso. 
                                 
                asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas"); 
                asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales"); 
                                    
        } catch (Exception e) {
              	
              	this.logStackTrace(e);
              	lanzarPaginaError(e);  
        }
	
		//traza("*** Salida - cargaCombos ***");
          
	}
	
	private void cargarPeriodo(Long oidPais, Long oidMarca, Long oidCanal) throws Exception{
		traza("Entró de cargarPeriodo(Long oidPais, Long oidMarca, Long oidCanal)");
		DTOPeriodo paisMarcaCanal = new DTOPeriodo();
		paisMarcaCanal.setOidIdioma(idioma);
		paisMarcaCanal.setPais(oidPais);
		paisMarcaCanal.setMarca(oidMarca);
		paisMarcaCanal.setCanal(oidCanal);

		Vector paramEntrada = new Vector();
		paramEntrada.add(paisMarcaCanal);

		paramEntrada.add(new MareBusinessID("CRAObtienePeriodoActual"));
		DruidaConector conectorCargarPeriodo = conectar("ConectorObjeto", paramEntrada);

		IMareDTO dtoSalida = (IMareDTO)conectorCargarPeriodo.objeto("DTOSalida");
		DTOPeriodo dtoPeriodo = (DTOPeriodo)(dtoSalida.getProperty("periodoActual"));

		String periodoActual = dtoPeriodo.getOid().toString();
		asignarAtributo("VAR","hOidPeriodo","valor",periodoActual);
		traza("asigno periodo actual:"+periodoActual);

		traza("Salió de cargarPeriodo(Long oidPais, Long oidMarca, Long oidCanal)");
	}

       
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}      

    
    
}