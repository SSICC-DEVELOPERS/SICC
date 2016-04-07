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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPMantenerAmbitoGeografico extends  LPIncentivos {      

    public LPMantenerAmbitoGeografico () {  super(); }
    
	public void inicio() throws Exception { 
		pagina("contenido_ambito_geografico_mantener");  
	}
    
    public void ejecucion() throws Exception {
		try{
			setTrazaFichero();
        
	        this.obtenerFlagsPestanyas();
			String accion = conectorParametro("accion")==null?"":conectorParametro("accion");
     //--Se modifica
     //--Pcabrera
		//	String opcion = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
     opcionMenu = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
			traza("accion: " + accion);
			traza("opcionMenu: " + opcionMenu);                  
       
			if (accion.equals("")){     
  			  pagina("contenido_ambito_geografico_mantener");          
			  cargarPantalla(); 
			  asignarAtributo("VAR","accion","valor",accion);
			  asignarAtributo("VAR","opcionMenu","valor",opcionMenu);      
			}
			if (accion.equals("almacenar")){
				almacenar(); 
				redirigir();
			}       
			if (accion.equals("redirigir")){
				redirigir();
			}       
			if (accion.equals("guardar")){
				almacenar();
				guardar();
			}              
			
			traza("********* Llamando a getConfiguracionMenu");
			getConfiguracionMenu("LPMantenerAmbitoGeografico"," ");     
      
      //-- Se ha agregado, para el caso de modificar - consultar
      //-- Pcabrera
        if(opcionMenu.equals("Crear concurso")){
          asignarAtributoPagina("cod", "0491");             
        }
        else if(opcionMenu.equals("Consultar Concurso")){
            asignarAtributoPagina("cod", "0493");
        }
        else if(opcionMenu.equals("Modificar Concurso")){
            asignarAtributoPagina("cod", "0486");
        }
    
      
        }
        catch(Exception e){
			lanzarPaginaError(e);
			traza(e);
		}       
    }
    
	public void cargarPantalla() throws Exception {
		traza("********** Entre a cargarPantalla");		
		pagina("contenido_ambito_geografico_mantener");          

	    this.cargarFlagsPestanyas();
		DTOConcurso dto = this.getConcurso();    
		DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
      
		dtoUA.setOidPais(UtilidadesSession.getPais(this));
		dtoUA.setOidMarca(dto.getParamGenerales().getOidMarca());
		dtoUA.setOidCanal(dto.getParamGenerales().getOidCanal());
      
		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
      
		composer1.setIDBusiness("ZONRecargaSubgerenciaVentas");
		composer1.setDTOE(dtoUA);
		lista.addViewElement(composer1);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("*********** Antes de llamar a ejecucion");
		conector.ejecucion();
		traza("*********** Despues de llamar a ejecucion");

		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbSubgerencia", con, "ZONRecargaSubgerenciaVentas");
      
		if(dto.getIndAmbitosGeograficos().booleanValue()){
			DTOListaAmbitosGeograficos dtoLAG = new DTOListaAmbitosGeograficos();
			dtoLAG = dto.getListaAmbitosGeograficos();
			ArrayList arr = dtoLAG.getAmbitoGeografico();
			RecordSet rs = new RecordSet();
			for(int j = 0; j < 11 ; j++)
				rs.addColumn(new Integer(j).toString());      
			
			int i = 0;
			Iterator it = arr.iterator();
			while(it.hasNext()){
				DTOIncAmbitoGeografico dtoIAG = (DTOIncAmbitoGeografico) it.next();
	            Vector vec = new Vector();
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
	        }
		    if(!rs.esVacio()){
			    String listado ="listado1";
				asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rs,rs.getColumnIdentifiers()),"dtoSalida");
           }
        }
    }
    
	public void almacenar() throws Exception {
		traza("******* Entre a almacenar");

        DTOConcurso dto = getConcurso();
        String indOblig = conectorParametroLimpia("indOblig","",true);
        traza("******** indOblig: "+indOblig);        
		dto.setIndObligAmbitosGeograficos(new Boolean(indOblig));
		dto.setIndAmbitosGeograficos(Boolean.TRUE);

        if(dto.getIndAmbitosGeograficos().booleanValue())
          dto.setListaAmbitosGeograficos(null);

        String datos = conectorParametroLimpia("datos","",true);
        traza("******** datos: "+datos);
        
		DTOListaAmbitosGeograficos dtoLAG = new DTOListaAmbitosGeograficos();
        ArrayList arr = new ArrayList();
        StringTokenizer stDatos = new StringTokenizer(datos,"|");

		while(stDatos.hasMoreTokens()){
            DTOIncAmbitoGeografico dtoIAG = new DTOIncAmbitoGeografico();
            StringTokenizer stRegistro = new StringTokenizer(stDatos.nextToken(),",");

            String cod = stRegistro.nextToken();
            dtoIAG.setDesSubgerencia(stRegistro.nextToken());
            
			String region = stRegistro.nextToken();
            if(!region.equals("undef"))
              dtoIAG.setDesRegion(region);
            
			String zona = stRegistro.nextToken();
            if(!zona.equals("undef"))              
              dtoIAG.setDesZona(zona);
            
			String seccion = stRegistro.nextToken();
            if(!seccion.equals("undef"))            
              dtoIAG.setDesSeccion(seccion);
            
			String terri = stRegistro.nextToken();
            if(!terri.equals("undef"))            
              dtoIAG.setDesTerritorio(terri);            

            dtoIAG.setOidSubgerencia(new Long(stRegistro.nextToken()));
            
			String oidRegion = stRegistro.nextToken();
            if(!oidRegion.equals("undef"))
              dtoIAG.setOidRegion(new Long(oidRegion));
            
			String oidZona = stRegistro.nextToken();
            if(!oidZona.equals("undef"))
              dtoIAG.setOidZona(new Long(oidZona));
            
			String oidSeccion = stRegistro.nextToken();
            if(!oidSeccion.equals("undef"))
              dtoIAG.setOidSeccion(new Long(oidSeccion));
            
			String oidTerri = stRegistro.nextToken();  
            if(!oidTerri.equals("undef"))
              dtoIAG.setOidTerritorio(new Long(oidTerri));    
            
			traza("este es el dtoIAG: "+dtoIAG);    
            arr.add(dtoIAG);  
        }
        
        dtoLAG.setAmbitoGeografico(arr);
        dto.setListaAmbitosGeograficos(dtoLAG);
        
        setConcurso(dto);
    }    
}
