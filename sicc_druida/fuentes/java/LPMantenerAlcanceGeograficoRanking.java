/** 
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor: Cabrera Paola
 */


import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOIncAmbitoGeografico;
import es.indra.sicc.dtos.inc.DTOListaAmbitosGeograficos;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTODatosGeneralesConcursoRanking;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPMantenerAlcanceGeograficoRanking extends LPIncentivosRanking {   


  public LPMantenerAlcanceGeograficoRanking(){  
     super(); 
  }
    
	public void inicio() throws Exception{ 
		pagina("contenido_ambito_geografico_mantener_ranking");  
  }
    
  
  public void ejecucion() throws Exception{
    
		try{
          setTrazaFichero();        
	        this.obtenerFlagsPestanyas();	
          
          String accion = conectorParametro("accion")==null?"":conectorParametro("accion");          
          opcionMenu = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
                    
          traza("accion: " + accion);
          traza("opcionMenu: " + opcionMenu);            
                
          
          //Acciones
          if (accion.equals("")){
             this.cargarPantalla();
          }else if (accion.equals("almacenar")){
                      this.almacenar();
                      super.redirigir();
          }else if (accion.equals("redirigir")){
                      super.redirigir();                   
          } else if (accion.equals("guardar")){
                      this.almacenar();
                      super.guardar(); // Se hereda de la LPIncentivosRankig 
          }
          
          
          asignarAtributo("VAR", "accion", "valor", accion);
          asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
          
          getConfiguracionMenu("LPMantenerAmbitoGeograficoRanking","");
          asignarAtributoPagina("cod", "0508");               
          
          
          if (opcionMenu.equals("Crear Concurso Ranking")){
              asignarAtributoPagina("cod", "0508");  
          }else if (opcionMenu.equals("Consultar Concurso Ranking")){
			//  getConfiguracionMenu("LPMantenerAmbitoGeograficoRanking","Consultar Concurso Ranking");	
              asignarAtributoPagina("cod", "0525");
         } else if (opcionMenu.equals("Modificar Concurso Ranking")){
			//  getConfiguracionMenu("LPMantenerAmbitoGeograficoRanking","Modificar Concurso Ranking");
              asignarAtributoPagina("cod", "0524");
         }
                    
          
     }catch (Exception e){
          traza("Excepcion en LPMantenerAlcanceGeograficoRanking  " + e);
          logStackTrace(e);
          this.lanzarPaginaError(e);   
          
    }
        
 
 }
 
  
	public void cargarPantalla() throws Exception {
    
    traza("********** Entre a cargarPantalla");			
    this.cargarFlagsPestanyas();
	   
		DTOConcurso dto = this.getConcurso(); 
    
    
		DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();  
    
    traza("dto.getParamGenerales().getOidMarca() **" +dto.getParamGenerales().getOidMarca());
    traza("dto.getParamGenerales().getOidCanal() **" +dto.getParamGenerales().getOidCanal());
    
		dtoUA.setOidPais(UtilidadesSession.getPais(this));
		dtoUA.setOidMarca(dto.getParamGenerales().getOidMarca());
		dtoUA.setOidCanal(dto.getParamGenerales().getOidCanal());
    dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
      
		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
      
		composer1.setIDBusiness("ZONRecargaSubgerenciaVentas");
		composer1.setDTOE(dtoUA);
		lista.addViewElement(composer1);
    
    traza("lista " + lista);
    traza("composer1 " + composer1);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("* Antes de llamar a ejecucion");
		conector.ejecucion();
		traza("* Despues de llamar a ejecucion");


    //--Se carga el combo de subgerencia ----
		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbSubgerencia", con, "ZONRecargaSubgerenciaVentas");
   
   
   
   traza("(dto.getIndAmbitosGeograficos().booleanValue() " + dto.getIndAmbitosGeograficos().booleanValue());
   if(dto.getIndAmbitosGeograficos().booleanValue()){
   
   
         
			DTOListaAmbitosGeograficos dtoLAG = new DTOListaAmbitosGeograficos();
			dtoLAG = dto.getListaAmbitosGeograficos();
			ArrayList arr = dtoLAG.getAmbitoGeografico();
			RecordSet rs = new RecordSet();
			
      
      for(int j = 0; j < 11 ; j++){
				rs.addColumn(new Integer(j).toString());      
			}
      
			int i = 0;
			Iterator it = arr.iterator();
			while (it.hasNext()){//--while
				//Comentado, solo probar 
        DTOIncAmbitoGeografico dtoIAG = (DTOIncAmbitoGeografico) it.next();
         
	        Vector vec = new Vector();
          
          //-oid ambito geografico
		      vec.add(new Integer(i));
          
			    vec.add(dtoIAG.getDesSubgerencia());
	        vec.add(dtoIAG.getDesRegion());
		      vec.add(dtoIAG.getDesZona());
			    vec.add(dtoIAG.getDesSeccion());
				  vec.add(dtoIAG.getDesTerritorio());            
	        vec.add(dtoIAG.getOidSubgerencia());
		      vec.add(dtoIAG.getOidRegion());
			    vec.add(dtoIAG.getOidZona());
				  vec.add(dtoIAG.getOidSeccion());
	        vec.add(dtoIAG.getOidTerritorio());
		      rs.addRow(vec);
			
          i++;
	    
      }//-end while
		  
      if (!rs.esVacio()){
			    String listado ="listado1";
				  asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rs,rs.getColumnIdentifiers()),"dtoSalida");
      }
      
   }//--fin de dto.getIndAmbitosGeograficos().booleanValue()   
   
   if (opcionMenu.equals("Consultar Concurso Ranking")){
        asignarAtributo("VAR","botones","valor", "SI");   
   }

 }
    
 
    
	public void almacenar() throws Exception {
	 	
    traza("******* Entre a almacenar");

    DTOConcurso dto = getConcurso();
 
  //----Para probar!!!--------------------------------------------------
   // DTOConcurso dto = new DTOConcurso();
       
    
    String indOblig = conectorParametroLimpia("indOblig","",true);
    traza("*indOblig: "+indOblig);    
    
		dto.setIndObligAmbitosGeograficos(new Boolean(indOblig));
		dto.setIndAmbitosGeograficos(Boolean.TRUE);
    
    // Verifica si hay que registros en la base de datos
    opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    
    if(opcionMenu.equals("Modificar Concurso Ranking") && !dto.getIndObligAmbitosGeograficos().booleanValue()) {
        dto.setIndBorradoAmbitosGeograficos(Boolean.TRUE);
    }
    
    //--si la lista tiene elementos
    //--se borran de la misma    
    if (dto.getIndAmbitosGeograficos().booleanValue()){
        dto.setListaAmbitosGeograficos(null);
    }

    //--Valores de la lista editable
    String datos = conectorParametroLimpia("datos","",true);
    traza("** datos: "+datos);
    
    
		DTOListaAmbitosGeograficos dtoLAG = new DTOListaAmbitosGeograficos();
    ArrayList arr = new ArrayList();
    
    StringTokenizer stDatos = new StringTokenizer(datos,"|");

		while(stDatos.hasMoreTokens()){ //--comienzo while
            
            DTOIncAmbitoGeografico dtoIAG = new DTOIncAmbitoGeografico();
            StringTokenizer stRegistro = new StringTokenizer(stDatos.nextToken(),",");

            String cod = stRegistro.nextToken();
            dtoIAG.setDesSubgerencia(stRegistro.nextToken());
            
            String region = stRegistro.nextToken();
            traza("region " + region);
            
            if (!region.equals("undef")){
              dtoIAG.setDesRegion(region);
            }
            
            String zona = stRegistro.nextToken();
            traza("zona " + zona);
            
            if (!zona.equals("undef")){              
              dtoIAG.setDesZona(zona);
            }
            
            String seccion = stRegistro.nextToken();
            traza("seccion " + seccion);
            
            if (!seccion.equals("undef")){           
              dtoIAG.setDesSeccion(seccion);
            }
            
            String terri = stRegistro.nextToken();
            traza("terri " + terri);
            
            if (!terri.equals("undef")){            
              dtoIAG.setDesTerritorio(terri);            
            }
                        
            dtoIAG.setOidSubgerencia(new Long(stRegistro.nextToken()));
            
            
            String oidRegion = stRegistro.nextToken();
            traza("oidRegion " + oidRegion);
            
           
            if (!oidRegion.equals("undef")){
             
              dtoIAG.setOidRegion(new Long(oidRegion));
            }
            
            String oidZona = stRegistro.nextToken();
            traza("oidZona " + oidZona);
            
            if (!oidZona.equals("undef")){
              
              dtoIAG.setOidZona(new Long(oidZona));
            }
            
            String oidSeccion = stRegistro.nextToken();
            traza("oidSeccion " + oidSeccion);

            
            if (!oidSeccion.equals("undef")){
               
              dtoIAG.setOidSeccion(new Long(oidSeccion));
            }
            
            String oidTerri = stRegistro.nextToken();  
            traza("oidTerri " + oidTerri);
            
            if (!oidTerri.equals("undef")){
              
              dtoIAG.setOidTerritorio(new Long(oidTerri));    
            }
            
            traza("este es el dtoIAG: "+dtoIAG);    
            arr.add(dtoIAG);  
        
        }//--fin while
        
        
        traza("arr * " + arr);
        dtoLAG.setAmbitoGeografico(arr);
        dto.setListaAmbitosGeograficos(dtoLAG);
        
        
        traza("terminando de almacenar ***");
        setConcurso(dto);
        
 }  //--fin del metodo almacenar
    

  private void logStackTrace(Throwable e){
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex){
            e.printStackTrace();
         }
    }
    
} //--Fin LPMantenerAlcanceGeograficoRanking 
