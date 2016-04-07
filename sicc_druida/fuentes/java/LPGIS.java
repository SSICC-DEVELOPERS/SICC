import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
 import es.indra.sicc.dtos.intsys.DTOINTEnviarInfCliente;
import java.util.Vector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;



public class LPGIS extends LPSICCBase {

  private String accion = null;  
  private String pais = null;
  private String idioma = null;
  private String formatoFechaPais = null;
  
  
  public LPGIS() {	
      super();	
  }


  public void inicio() throws Exception {	
    pagina("contenido_informacion_enviar");    
    this.getFormatosValidaciones();
  }
  
  
  
  public void ejecucion() throws Exception {
  setTrazaFichero();

	accion     	= conectorParametroLimpia("accion", "", true);
	traza("accion>>>> " + accion);
	
	pais 	  	= UtilidadesSession.getPais(this).toString();
	traza("pais >>>>  "  +pais );
	
  idioma  	= UtilidadesSession.getIdioma(this).toString();
	traza("idioma >>>> " + idioma);	
  
  formatoFechaPais         = UtilidadesSession.getFormatoFecha(this);
traza("NUEVA TRAZA PARA VERIFICAR NUEVO FUENTE COMPILADO. JA TODO NUEVO!");
	try {
			
      traza("antes de cargar>>>>");	
      rastreo();
      getConfiguracionMenu("LPGIS","");
			asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
      asignarAtributo("VAR","hPais","valor",pais);
		  asignarAtributo("VAR","hIdioma","valor",idioma);	     
			traza("FECHA>>>> " + formatoFechaPais);
      
     /* String fec = conectorParametroLimpia("hFormatoFechaPais", "", true);
      traza("fec- " + fec.toString());*/
      traza("accion>>>> " + accion);
      
      if (accion.equals("")) 
			{ 
				/** 
         * Llama al metodo cargarCombo()
         * Creamos un DTOString con la constante IGestorInterfaces.COD_INTERFAZ_GIS6 
         * (además del pais y el idioma) 
         * Llamamos al ConectorObjeto con el idBusiness "INTCargaInicialInterfaz" 
         * y el dto. 
         * Con el DTOCargaInicialInterfaz obtenido mostramos la pantallaSeleccionDatos 
         * cargando los campos numeroLote y descripcionLote con los atributos 
         * numeroLote y descripcionInterfaz
         *          
         * */
         
          cargarCombo();
         
          DTOString dtos = new DTOString();
          //Asigno la constante
          dtos.setOidIdioma(new Long(idioma));
          dtos.setOidPais(new Long(pais));
          
          //IGestorInterfaces.COD_INTERFAZ_GIS6 ---->>>Falta agregar esto!!!!
          dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_GIS6);
          
          traza("antes de setea businessid");
          MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
          
          Vector vec = new Vector();
          vec.add(dtos);
          vec.add(mid);
          
          traza("antes de llamar al conector");
          DruidaConector dc = conectar("ConectorObjeto", vec);
          traza("despues de conector");
          
          DTOCargaInicialInterfaz dtocii = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
          traza("antes de asignar a la pantalla");
          asignarAtributo("LABELC", "lblvalorLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
          asignarAtributo("VAR", "descripcionH", "valor", (dtocii.getDescripcion()==null? "": dtocii.getDescripcion()));
          asignarAtributo("VAR", "loteH", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
     } 
		
    else{	
          if (accion.equals("enviar")) 
          { 
                /**
                * 
                *  Creamos un DTOINTEnviarInfCliente que rellenamos con los campos 
                *  recogidos de la pantalla (además del pais y el idioma) 
                *  Llamamos al ConectorEnviarInformacionClienteBatch con el dto 
                *  creado y el idBusiness "INTEnviarInformacionClienteBatch" 
                * */
                
                pagina("salidaGenerica");
                traza("esta en accion ::::  " + accion);
                
                String marca = conectorParametro("marcaH");
                traza("marca**** " + marca);
                
                String canal = conectorParametro("canalH");         
                traza("canal**** " + canal);
                
                String periodo = conectorParametro("periodoH");
                traza("periodo**** " + periodo);
                
                String observaciones = conectorParametro("observacionesH");
                traza("observaciones**** " + observaciones);
                
                String descripcion = conectorParametro("descripcionH");
                traza("descripcion**** " + descripcion);
                  
                String lote = conectorParametro("loteH");
                traza("lote**** " + lote);
                
                DTOINTEnviarInfCliente dto = new DTOINTEnviarInfCliente();
                
                dto.setNumeroLote(new Long(lote));
                dto.setOidIdioma(new Long(idioma));
                dto.setOidPais(new Long(pais));
             
               
                dto.setOidCanal(new Long(canal));
                dto.setOidMarca(new Long(marca));
               
                
                if (!observaciones.equals("")){
                    dto.setObservaciones(observaciones);
                } 
                
                if (!descripcion.equals("")){
                    dto.setDescripcionLote(descripcion);
                }
                 
                dto.setOidPeriodo(new Long(periodo));
          
                traza("el dto DTOINTEnviarInfCliente, que mando, contiene: " + dto);
              
              
                traza("antes de setea businessid");
                MareBusinessID mid = new MareBusinessID("INTEnviarInformacionClienteBatch");
                
                Vector vec = new Vector();
                vec.add(dto);
                vec.add(mid);
                
                traza("antes de llamar al conector");
                DruidaConector dc = conectar("ConectorEnviarInformacionClienteBatch", vec);
                traza("despues de conector");
                
                conectorAction("LPInicioBelcorp");
                conectorActionParametro("accion","");
             } 
    }
  }
    catch ( Exception e )  {
      traza("Exception en LPGIS");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
 
 
 
 private void cargarCombo() throws Exception
 {	
    traza("en cargarCombo >>>");
 	
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidIdioma(new Long(idioma));
    dtoe.setOidPais(new Long(pais));
    traza("PASO 1");
    ComposerViewElementList lista = new ComposerViewElementList();  
    traza("PASO 2");
    /** Obtenemos los patrones */
    ComposerViewElement cmb1 = new ComposerViewElement();
    cmb1.setIDBusiness("SEGConsultaCanales");
    cmb1.setDTOE(dtoe);  
    
    /** Obtenemos los tipos de períodos */
    ComposerViewElement cmb2 = new ComposerViewElement();
    cmb2.setIDBusiness("SEGConsultaMarcas"); 
    cmb2.setDTOE(dtoe);
  
    lista.addViewElement(cmb1);
    lista.addViewElement(cmb2);
    traza("PASO 3");
    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    conector.ejecucion();
    traza("PASO 4");
    DruidaConector resultados = conector.getConector();
    
    traza("resultados>>>>> " + resultados);
    
    asignar("COMBO","cbCanal", resultados,"SEGConsultaCanales");					
    asignar("COMBO","cbMarca", resultados,"SEGConsultaMarcas");	
  }
	

}
