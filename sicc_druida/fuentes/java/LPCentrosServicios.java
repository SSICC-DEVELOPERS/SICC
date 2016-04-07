import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOCentroServicio;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;

public class LPCentrosServicios extends LPSICCBase {   
	public LPCentrosServicios() {super();}

	private String sDescPais = "";
    private String sIdioma = "";    
	private String sPais = ""; 
	private String accion = "";
    private String casoDeUso = "";    

    private String codCentroServicio = "";
    private String desCentroServicio = "";
    private String obsCentroServicio = "";
    private String oidCentroServicio = "";


	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
        rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPCentrosServicios - ejecucion ***");
		
		sPais = UtilidadesSession.getPais(this).toString();    
        traza(" pais en ejecucion: " + sPais);
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		try  {	
			accion = conectorParametroLimpia("accion", "", true);
			casoDeUso = conectorParametroLimpia("casoDeUso", "", true);

			traza("***** caso de uso '"+ casoDeUso +"'");      
			traza("***** accion      '"+ accion +"'");      

			if("insertar".equals(accion)){
				pagina("contenido_centros_servicios_insertar");
				asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
				asignarAtributoPagina("cod","3180");
			}

			if("guardar".equals(accion)){
				guardarCentroServicio();
				traza("asignando casoDeUso ");
				asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
				asignarAtributoPagina("cod","3180");
			}

			if("modificar".equals(accion) || "eliminar".equals(accion) || "consultar".equals(accion)) {
						mostrarPgBuscarCentroServicios();        
					if("modificar".equals(accion))
						asignarAtributoPagina("cod","3181");
					if("consultar".equals(accion))
						asignarAtributoPagina("cod","3182");
					if("eliminar".equals(accion))
						asignarAtributoPagina("cod","3183");      
			 }

			 if("modificar centro".equals(accion)){
					oidCentroServicio =  conectorParametroLimpia("oid", "", true); 		
					codCentroServicio = conectorParametroLimpia("codCentroServ", "", true);		
					desCentroServicio = conectorParametroLimpia("descripcion", "", true);
					obsCentroServicio = conectorParametroLimpia("observac", "", true);

					traza("********** oidCentroServicio " + oidCentroServicio);
					traza("********** codCentroServicio " + codCentroServicio);
					traza("********** desCentroServicio " + desCentroServicio);
					traza("********** obsCentroServicio " + obsCentroServicio);

					pagina("contenido_centros_servicios_insertar");

					asignarAtributo("CTEXTO","txtCodCentroServ","valor", codCentroServicio);  
					asignarAtributo("CTEXTO","txtDescripcion","valor", desCentroServicio);  
					asignarAtributo("AREATEXTO","areatxtObservaciones","valor", obsCentroServicio);
					
					asignarAtributo("VAR","oidCentroServicio","valor",oidCentroServicio);

					asignarAtributo("VAR","accion","valor",accion);
					asignarAtributoPagina("cod","3181");

			 }      

		} catch ( Exception e ) {
			traza("******** Entro al catch debido a...");
			asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
			e.printStackTrace(); 
			lanzarPaginaError(e);
		}	
        getConfiguracionMenu();
		traza("*** Salida - LPCentrosServicios - ejecucion ***");
	}

	private void guardarCentroServicio() throws Exception	{   
		pagina("salidaGenerica");
		
        codCentroServicio =  conectorParametroLimpia("txtCodCentroServ", "", true); 		
        desCentroServicio = conectorParametroLimpia("txtDescripcion", "", true);		
		obsCentroServicio = conectorParametroLimpia("areatxtObservaciones", "", true);
		oidCentroServicio = conectorParametroLimpia("oidCentroServicio", "", true);

		traza("********** codCentroServicio " + codCentroServicio);
		traza("********** desCentroServicio " + desCentroServicio);
		traza("********** obsCentroServicio " + obsCentroServicio);
		traza("********** oidCentroServicio " + oidCentroServicio);

        DTOCentroServicio dtoe = new DTOCentroServicio();	

        dtoe.setCodigo(codCentroServicio);	
        dtoe.setDescripcion(("".equals(desCentroServicio))?null:desCentroServicio);    
		dtoe.setObservaciones(("".equals(obsCentroServicio))?null:obsCentroServicio);    

		if(!oidCentroServicio.equals("")) {
			dtoe.setOidCentroServicio(new Long(oidCentroServicio)); 
		}

        dtoe.setOidPais(new Long(sPais));

		MareBusinessID businessID = new MareBusinessID("INCInsertarCentroServicio");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);

		String caso = conectorParametroLimpia("casoDeUso", "", true);
        traza("************ caso " + caso);

		try {
	        traza("antes de guardar");
			DruidaConector con = conectar("ConectorGuardarCentroServicio", params); 
			traza("despues de guardar" + accion);

			if(caso.equals("insertar")) {
		      traza("********** Ejecutar llama a reInicio");
			  asignarAtributo("VAR","ejecutar","valor","reInicio()");
	        }  else {
			  traza("********** Ejecutar llama a reModifica");
	          asignarAtributo("VAR","ejecutar","valor","reModifica();");
		    } 
		}
		catch (Exception e) {
			traza("******************* Entrando al catch...");
			traza("******************* accion " + accion);
			traza("******************* casoDeUso " + casoDeUso);
			asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso );
	        if(caso.equals("insertar")) {
               asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarI()");
		    } else {
	          asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarM()");
		    }  
			throw e;
		}
	}

    private void mostrarPgBuscarCentroServicios() throws Exception{
        pagina("contenido_centros_servicios_modificar");
        asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
	}

}

