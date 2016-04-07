import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.rec.DTOGenerarBoletasRecojoCierreZona;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.Vector;

public class LPGenerarBoletasRecojoCierreDeZona extends LPSICCBase {

	private String accion;
	private String opcionMenu;
	private Long oidPais;
	private Long oidIdioma;

	public void inicio() throws Exception {
		
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("*** Entrada - LPGenerarBoletasRecojoCierreDeZona - ejecucion ***");
		try	{
			this.oidPais = UtilidadesSession.getPais(this);
			this.oidIdioma = UtilidadesSession.getIdioma(this);
			accion = conectorParametroLimpia( "accion", "", true );
			opcionMenu = conectorParametroLimpia( "opcionMenu", "", true );

			if (accion.equals("")) {
				cargarPagina();
			} else if (accion.equals("generar")) {
				generar();
			}
		} catch (Exception e) {
			e.printStackTrace();
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPGenerarBoletasRecojoCierreDeZona - ejecucion ***");
	}

	private void cargarPagina() throws Exception {
		traza("*** Entrada - LPGenerarBoletasRecojoCierreDeZona - cargarPagina ***");
		
		pagina("contenido_boletas_recojo_cierre_zona_generar");
		asignarAtributoPagina("cod", "3445");
		getConfiguracionMenu("LPGenerarBoletasRecojoCierreDeZona", "");

		asignar("VAR", "opcionMenu", this.opcionMenu);
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "varPais", this.oidPais.toString());
		asignar("VAR", "varIdioma", this.oidIdioma.toString());

		// Cargo los combos cbMarca y cbCanal

        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidPais(this.oidPais);
        dto.setOidIdioma(this.oidIdioma);

		ComposerViewElementList lista = new ComposerViewElementList(); 
		
		ComposerViewElement element1 = new ComposerViewElement();
		element1.setDTOE(dto);
		element1.setIDBusiness("SEGObtenerMarcasSinFiltro");
		lista.addViewElement(element1);

		ComposerViewElement element2 = new ComposerViewElement();
		element2.setDTOE(dto);
		element2.setIDBusiness("SEGObtenerCanalesSinFiltro");
		lista.addViewElement(element2);
		
        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

		asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
		asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");

		traza("*** Salida - LPGenerarBoletasRecojoCierreDeZona - cargarPagina ***");
	}

	private void generar() throws Exception {
		traza("*** Entrada - LPGenerarBoletasRecojoCierreDeZona - generar ***");

		String strOidPeriodo = conectorParametroLimpia("hOidPeriodo", "", false);
		String strOidZona = conectorParametroLimpia("hOidZona", "", false);

		traza("strOidPeriodo: " + strOidPeriodo);
		traza("strOidZona: " + strOidZona);

		pagina("salidaGenerica");

		DTOGenerarBoletasRecojoCierreZona dto = new DTOGenerarBoletasRecojoCierreZona();
		dto.setOidPeriodo(Long.valueOf(strOidPeriodo));
		dto.setOidZona(Long.valueOf(strOidZona));
		dto.setOidPais(this.oidPais);

		MareBusinessID id = new MareBusinessID("RECGenerarBoletasRecojoCierreZonaBatch");
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dto);
		paramsEntrada.add(id);

		traza("Antes de conectar con RECGenerarBoletasRecojoCierreZonaBatch");
		DruidaConector conector = conectar("ConectorGenerarBoletasRecojoCierreZonaBatch", paramsEntrada);
		traza("Luego de conectar con RECGenerarBoletasRecojoCierreZonaBatch");

		asignar("VAR", "cerrarVentana", "false");
		asignar("VAR", "ejecutar", "cerrarVentana()");

		traza("*** Salida - LPGenerarBoletasRecojoCierreDeZona - generar ***");
	}

}