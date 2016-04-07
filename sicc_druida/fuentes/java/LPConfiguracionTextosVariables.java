import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ape.DTODatosTextoVariable;

public class LPConfiguracionTextosVariables extends LPSICCBase {	

    public LPConfiguracionTextosVariables () { super(); }

	private String casoUso = null;
	private String accion = null;
	private Long pais = null;     
	private Long idioma = null;

	public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPConfiguracionTextosVariables.ejecucion() - Entrada");

     	accion = conectorParametroLimpia("accion", "", true);
	    pais = UtilidadesSession.getPais(this);
		idioma = UtilidadesSession.getIdioma(this);

		traza("**** accion : " + accion);
		traza("**** pais : " + pais);
		traza("**** idioma : " + idioma);
	    
		try  {			
			if (accion.equals("insertar") || accion.equals("modificar") ||
				accion.equals("consultar") || accion.equals("eliminar")) {
				cargarPantalla(); 
			}
			else if(accion.equals("guardar")) {
				guardar();
			}			
			else if(accion.equals("detalle")) {
				detalle();
			}			
			else if(accion.equals("modificacion")) {
				modificacion();
			}	
			
			cargarMenuSecundario();
			traza("LPConfiguracionTextosVariables.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
            e.printStackTrace();
			traza("Exception en LPConfiguracionTextosVariables");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

    public void detalle() throws Exception {
		traza("LPConfiguracionTextosVariables.detalle() - Entrada");		
		pagina("contenido_textos_variables_insertar"); 
		cargarComboTipoCliente();

		asignarAtributo("VAR", "casoUso", "valor", "detalle");
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		String oidSeleccionado = conectorParametroLimpia("oidSeleccionado", "", true);
		String oidTipoCliente = conectorParametroLimpia("oidTipoCliente", "", true);
		String oidSubtipoCliente = conectorParametroLimpia("oidSubtipoCliente", "", true);
		String oidTipoClasificacion = conectorParametroLimpia("oidTipoClasificacion", "", true);
		String oidClasificacion = conectorParametroLimpia("oidClasificacion", "", true);
		String textoVariable = conectorParametroLimpia("textoVariable", "", true);

		traza("******** oidSeleccionado " + oidSeleccionado);
		traza("******** oidTipoCliente " + oidTipoCliente);
		traza("******** oidSubtipoCliente " + oidSubtipoCliente);
		traza("******** oidTipoClasificacion " + oidTipoClasificacion);
		traza("******** oidClasificacion " + oidClasificacion);
		traza("******** textoVariable " + textoVariable);

		asignarAtributo("VAR", "oidSeleccionado", "valor", oidSeleccionado);
		asignarAtributo("VAR", "oidTipoCliente", "valor", oidTipoCliente);
		asignarAtributo("VAR", "oidSubtipoCliente", "valor", oidSubtipoCliente);
		asignarAtributo("VAR", "oidTipoClasificacion", "valor", oidTipoClasificacion);
		asignarAtributo("VAR", "oidClasificacion", "valor", oidClasificacion);
		asignarAtributo("VAR", "textoVariable", "valor", textoVariable);		

		traza("LPConfiguracionTextosVariables.detalle() - Salida");
	}

	public void modificacion() throws Exception {
		traza("LPConfiguracionTextosVariables.modificacion() - Entrada");
		pagina("contenido_textos_variables_insertar"); 
		cargarComboTipoCliente();

		asignarAtributo("VAR", "casoUso", "valor", "modificacion");
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		String oidSeleccionado = conectorParametroLimpia("oidSeleccionado", "", true);
		String oidTipoCliente = conectorParametroLimpia("oidTipoCliente", "", true);
		String oidSubtipoCliente = conectorParametroLimpia("oidSubtipoCliente", "", true);
		String oidTipoClasificacion = conectorParametroLimpia("oidTipoClasificacion", "", true);
		String oidClasificacion = conectorParametroLimpia("oidClasificacion", "", true);
		String textoVariable = conectorParametroLimpia("textoVariable", "", true);

		traza("******** oidSeleccionado " + oidSeleccionado);
		traza("******** oidTipoCliente " + oidTipoCliente);
		traza("******** oidSubtipoCliente " + oidSubtipoCliente);
		traza("******** oidTipoClasificacion " + oidTipoClasificacion);
		traza("******** oidClasificacion " + oidClasificacion);
		traza("******** textoVariable " + textoVariable);

		asignarAtributo("VAR", "oidSeleccionado", "valor", oidSeleccionado);
		asignarAtributo("VAR", "oidTipoCliente", "valor", oidTipoCliente);
		asignarAtributo("VAR", "oidSubtipoCliente", "valor", oidSubtipoCliente);
		asignarAtributo("VAR", "oidTipoClasificacion", "valor", oidTipoClasificacion);
		asignarAtributo("VAR", "oidClasificacion", "valor", oidClasificacion);
		asignarAtributo("VAR", "textoVariable", "valor", textoVariable);

		traza("LPConfiguracionTextosVariables.modificacion() - Salida");
	}

	private void cargarComboTipoCliente() throws Exception {
		traza("LPConfiguracionTextosVariables.cargarComboTipoCliente() - Entrada");
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidIdioma(idioma);

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("MAEObtenerTipos");
		composer1.setDTOE(dtoe);
		lista.addViewElement(composer1);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		conector.ejecucion();
		DruidaConector con = conector.getConector();
		asignar("COMBO", "comboTipoCliente", con, "MAEObtenerTipos");
		traza("LPConfiguracionTextosVariables.cargarComboTipoCliente() - Salida");
	}

    public void cargarPantalla() throws Exception {
		traza("LPConfiguracionTextosVariables.cargarPantalla() - Entrada");

		if (accion.equals("insertar")) {
			pagina("contenido_textos_variables_insertar");  
		}
		else {
			pagina("contenido_textos_variables_consultar");  
		}

		asignarAtributo("VAR", "casoUso", "valor", accion);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		this.getFormatosValidaciones();
		cargarComboTipoCliente();
		traza("LPConfiguracionTextosVariables.cargarPantalla() - Salida");
	}

	public void guardar() throws Exception {
		traza("LPConfiguracionTextosVariables.guardar() - Entrada");
		pagina("salidaGenerica");
		
		String oidSeleccionado = conectorParametroLimpia("oidSeleccionado", "", true);
		String oidTipoCliente = conectorParametroLimpia("oidTipoCliente", "", true);
		String oidSubtipoCliente = conectorParametroLimpia("oidSubtipoCliente", "", true);
		String oidTipoClasificacion = conectorParametroLimpia("oidTipoClasificacion", "", true);
		String oidClasificacion = conectorParametroLimpia("oidClasificacion", "", true);
		String textoVariable = conectorParametroLimpia("textoVariable", "", true);

		traza("***** oidSeleccionado " + oidSeleccionado);
		traza("***** oidTipoCliente " + oidTipoCliente);
		traza("***** oidSubtipoCliente " + oidSubtipoCliente);
		traza("***** oidTipoClasificacion " + oidTipoClasificacion);
		traza("***** oidClasificacion " + oidClasificacion);
		traza("***** textoVariable " + textoVariable);

		DTODatosTextoVariable dtoe = new DTODatosTextoVariable();
		if(!oidSeleccionado.equals("")) {
			dtoe.setOidConfiguracionTextoVariable(new Long(oidSeleccionado));
		}		

		dtoe.setOidTipoCliente(new Long(oidTipoCliente));

		if(!oidSubtipoCliente.equals("")) {
			dtoe.setOidSubtipoCliente(new Long(oidSubtipoCliente));
		}

		if(!oidTipoClasificacion.equals("")) {
			dtoe.setOidTipoClasificacion(new Long(oidTipoClasificacion));
		}		

		if(!oidClasificacion.equals("")) {
			dtoe.setOidClasificacion(new Long(oidClasificacion));		
		}

		dtoe.setTextoVariable(textoVariable);
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

  	    MareBusinessID businessID = new MareBusinessID("APEGuardarConfiguracionTextoVariable");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorGuardarConfiguracionTextoVariable", parametros);
			traza("******************* Despues de conectar");
		    asignarAtributo("VAR","ejecutar","valor","fGuardarOK()");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
			asignarAtributo("VAR", "ejecutarError", "valor", "fGuardarERR()");  
			throw e;
		}

		traza("LPConfiguracionTextosVariables.guardar() - Salida");
	}

	private void cargarMenuSecundario() throws Exception {     
		traza("LPConfiguracionTextosVariables.cargarMenuSecundario() - Entrada");		
		if(accion.equals("insertar")) {
			getConfiguracionMenu("LPConfiguracionTextosVariables","insertar");
		    asignarAtributoPagina("cod","01065");
		}	
		else if(accion.equals("modificar") || accion.equals("modificacion")) {
			getConfiguracionMenu("LPConfiguracionTextosVariables","modificar");
		    asignarAtributoPagina("cod","01067");
		}		
		else if(accion.equals("consultar") || accion.equals("detalle")) {
			getConfiguracionMenu("LPConfiguracionTextosVariables","consultar");
		    asignarAtributoPagina("cod","01066");
		}		
		else if(accion.equals("eliminar")) {
			getConfiguracionMenu("LPConfiguracionTextosVariables","eliminar");
		    asignarAtributoPagina("cod","01068");
		}		
		traza("LPConfiguracionTextosVariables.cargarMenuSecundario() - Salida");
	}
}