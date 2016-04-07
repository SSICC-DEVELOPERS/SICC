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
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

public class LPMantenerFuncionDistribucion extends LPSICCBase {	
    public LPMantenerFuncionDistribucion () { super(); }
	
	private String opcionMenu = null;
	private String accion = null;
	private Long pais = null;     
	private Long idioma = null;
	
	public void inicio() throws Exception { }
	
    public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPMantenerFuncionDistribucion.ejecucion() - Entrada");

     	accion = conectorParametroLimpia("accion", "", true);
     	opcionMenu = conectorParametroLimpia("opcionMenu", "", true);		
	    pais = UtilidadesSession.getPais(this);
		idioma = UtilidadesSession.getIdioma(this);

		traza("**** accion : " + accion);
		traza("**** opcionMenu : " + opcionMenu);
		traza("**** pais : " + pais);
		traza("**** idioma : " + idioma);
	    
		try  {			
			if(accion.equals("") && opcionMenu.equals("consultar")) {
				obtenerFuncionDistribucion();
			}			
			
			cargarMenuSecundario();
			traza("LPMantenerFuncionDistribucion.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
            e.printStackTrace();
			traza("Exception en LPMantenerFuncionDistribucion");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

    public void obtenerFuncionDistribucion() throws Exception {
		traza("LPMantenerFuncionDistribucion.obtenerFuncionDistribucion() - Entrada");

		pagina("contenido_funcion_distribucion_consultar");  

		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		this.getFormatosValidaciones();

		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		MareBusinessID businessID = new MareBusinessID("APEObtenerFuncionDistribucion");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);
		
		traza("*** Llamando a APEObtenerFuncionDistribucion");
		DruidaConector con = conectar("ConectorObtenerFuncionDistribucion", parametros);
		traza("*** Despues de llamar a APEObtenerFuncionDistribucion");

		DTOSalida dtoSalida = (DTOSalida)con.objeto("dtoSalida");
		traza("******** DTOSalida: " + dtoSalida.getResultado());
		
		if(dtoSalida.getResultado() != null) {
			DruidaConector conLista = generarConectorLista(dtoSalida.getResultado());
			this.asignar("LISTADOA", "listado1", conLista, "dtoSalida");
		}

		traza("LPMantenerFuncionDistribucion.obtenerFuncionDistribucion() - Salida");
	}

	private void cargarMenuSecundario() throws Exception {     
		traza("LPMantenerFuncionDistribucion.cargarMenuSecundario() - Entrada");		
		
		if(accion.equals("") && opcionMenu.equals("consultar")) {
			getConfiguracionMenu("LPMantenerFuncionDistribucion","");
		    asignarAtributoPagina("cod","01069");
		}	

		traza("LPMantenerFuncionDistribucion.cargarMenuSecundario() - Salida");
	}

	 private DruidaConector generarConectorLista(RecordSet rsFunciones) throws Exception {
  		 traza("LPMantenerFuncionDistribucion.generarConectorLista() - Entrada");
         int cant = rsFunciones.getRowCount();
  
         RecordSet rs = new RecordSet();
         Vector v = null;
    
         rs.addColumn("OID_FUNC_DIST");	
         rs.addColumn("COD_FUNC_DIST");
         rs.addColumn("VAL_I18N");
         rs.addColumn("VAL_PROG");
  
         for (int i = 0; i<cant ; i++){
             v = new Vector();

			 v.add(rsFunciones.getValueAt(i, "OID_FUNC_DIST"));
             v.add(rsFunciones.getValueAt(i, "COD_FUNC_DIST"));
             v.add(rsFunciones.getValueAt(i, "VAL_I18N"));
             v.add(rsFunciones.getValueAt(i, "VAL_PROG"));
             
			 rs.addRow(v);
         }

		 traza("* * * * * RecordSet: " + rs);
		 traza("LPMantenerFuncionDistribucion.generarConectorLista() - Salida");
         return UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());
    }
}