import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

public class LPActivarCerrarConcursos extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;
	private Long pais = null;
	private Long idioma = null;
	private Long marca = null;
	private Long canal = null;

	public LPActivarCerrarConcursos() { super(); }

	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try	{ 
			this.rastreo();    
			traza("*** Entrada - LPActivarCerrarConcursos - ejecucion ***");

			this.accion = conectorParametroLimpia("accion", "", true);
			this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			this.pais = UtilidadesSession.getPais(this);
			this.idioma = UtilidadesSession.getIdioma(this);

			traza("accion: " + accion);
			traza("opcionMenu: " + opcionMenu);
			traza("pais: " + pais);
			traza("idioma: " + idioma);


			if (accion.equals("") || accion.equals("recargarPeriodos")) { 
				cargarPantalla();
			} else if (accion.equals("cerrar")) {
				cerrar();
			} else if (accion.equals("activar")) {
				activar();
			}
			
			traza("*** Salida - LPActivarCerrarConcursos - ejecucion ***");

		} catch(Exception e) {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			lanzarPaginaError(e);
		}

	}

	private void cargarPantalla() throws Exception {
		traza("*** Entrada - LPActivarCerrarConcursos - cargarPantalla ***");
		
		if (accion.equals("recargarPeriodos")) {
			this.marca = new Long(conectorParametroLimpia("hOidMarca", "", false));
			this.canal = new Long(conectorParametroLimpia("hOidCanal", "", false));
			traza("this.marca: " + this.marca);
			traza("this.canal: " + this.canal);
		}

		pagina("contenido_concursos_activar_cerrar");

		asignarAtributoPagina("cod", "3365");
		getConfiguracionMenu("LPActivarCerrarConcursos", "");

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement element = null;

		// Obtener marcas
		element = new ComposerViewElement();
		element.setIDBusiness("SEGObtenerMarcasSinFiltro");
		element.setDTOE(null);
		list.addViewElement(element);

		// Obtener canales
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		element = new ComposerViewElement();
		element.setIDBusiness("SEGObtenerCanalesSinFiltro");
		element.setDTOE(dto);
		list.addViewElement(element);

		traza("Antes de conectar...");
		ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		traza("Despues de conectar, antes de asignar a los combos...");

		asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
		asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
		
		asignarAtributoPagina("cod", "3365");
		getConfiguracionMenu("LPActivarCerrarConcursos", "");
		
		if (accion.equals("recargarPeriodos")) {
			asignar("VAR", "hOidMarca", this.marca.toString());
			asignar("VAR", "hOidCanal", this.canal.toString());
			recargarPeriodos();
		}

		traza("*** Salida - LPActivarCerrarConcursos - cargarPantalla ***");
	}

	private void recargarPeriodos() throws Exception {

		traza("*** Entrada - LPActivarCerrarConcursos - recargarPeriodos ***");

		// Cargo los combos cbPeriodoCerrar y cbPeriodoActivar
		this.cargarCombosPeriodos();

		// Obtener periodo actual
		Long oidPeriodoActual = this.obtenerPeriodoActual();
		if (oidPeriodoActual != null) {
			asignar("VAR", "hOidPeriodoActual", oidPeriodoActual.toString());
		} else {
			asignar("VAR", "hOidPeriodoActual", "");
		}

		// Obtener periodo posterior al actual
		Long oidPeriodoPost = this.obtenerPeriodoPosteriorActual();
		if (oidPeriodoPost != null) {
			asignar("VAR", "hOidPeriodoPosteriorActual", oidPeriodoPost.toString());
		} else {
			asignar("VAR", "hOidPeriodoPosteriorActual", "");
		}

		traza("*** Salida - LPActivarCerrarConcursos - recargarPeriodos ***");
	}

	private void cargarCombosPeriodos() throws Exception {

		traza("*** Entrada - LPActivarCerrarConcursos - cargarCombosPeriodos ***");

		DTOPeriodo dtoPeriodo = new DTOPeriodo();
		dtoPeriodo.setPais(this.pais);
		dtoPeriodo.setOidPais(this.pais);
		dtoPeriodo.setOidIdioma(this.idioma);
		dtoPeriodo.setMarca(this.marca);
		dtoPeriodo.setCanal(this.canal);

		DTOID dtoId = new DTOID();
		dtoId.setPais(this.pais);
		dtoId.setOidPais(this.pais);
		dtoId.setMarca(this.marca);
		dtoId.setCanal(this.canal);

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement element = null;

		// Obtener todos los periodos para pais-marca-canal (periodos a cerrar)
		element = new ComposerViewElement();
		element.setIDBusiness("CRAObtienePeriodos");
		element.setDTOE(dtoPeriodo);
		list.addViewElement(element);

		// Obtener el periodo actual y los posteriores para pais-marca-canal (periodos a activar)
		element = new ComposerViewElement();
		element.setIDBusiness("CRAObtienePeriodoActualYPosteriores");
		element.setDTOE(dtoId);
		list.addViewElement(element);

		traza("Antes de conectar...");
		ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		traza("Luego de conectar, antes de setear combos de periodos...");

		asignar("COMBO", "cbPeriodoCerrar", resultados, "CRAObtienePeriodos");
		asignar("COMBO", "cbPeriodoActivar", resultados, "CRAObtienePeriodoActualYPosteriores");

		traza("*** Salida - LPActivarCerrarConcursos - cargarCombosPeriodos ***");
	}

	private Long obtenerPeriodoActual() throws Exception {
		traza("*** Entrada - LPActivarCerrarConcursos - obtenerPeriodoActual ***");

		DTOID dtoId = new DTOID();
		dtoId.setPais(this.pais);
		dtoId.setOidPais(this.pais);
		dtoId.setMarca(this.marca);
		dtoId.setCanal(this.canal);
		MareBusinessID id = new MareBusinessID("CRAObtenerPeriodoActual");
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoId);
		paramsEntrada.add(id);

		traza("Antes de conectar con CRAObtenerPeriodoActual, con DTOID: " + dtoId);
		DruidaConector conector = conectar("ConectorObtenerPeriodoActual", paramsEntrada);
		traza("Luego de conectar con CRAObtenerPeriodoActual");

		DTOID dtoIdPeriodoActual = (DTOID)conector.objeto("dtoSalida");
		traza("dtoIdPeriodoActual: " + dtoIdPeriodoActual);

		traza("*** Salida - LPActivarCerrarConcursos - obtenerPeriodoActual ***");
		return (dtoIdPeriodoActual != null)? dtoIdPeriodoActual.getOid() : null;
	}

	private Long obtenerPeriodoPosteriorActual() throws Exception {
		traza("*** Entrada - LPActivarCerrarConcursos - obtenerPeriodoPosteriorActual ***");

		DTOID dtoId = new DTOID();
		dtoId.setPais(this.pais);
		dtoId.setOidPais(this.pais);
		dtoId.setMarca(this.marca);
		dtoId.setCanal(this.canal);
		MareBusinessID id = new MareBusinessID("CRAObtenerPeriodoPosteriorActual");
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoId);
		paramsEntrada.add(id);

		traza("Antes de conectar con CRAObtenerPeriodoPosteriorActual, con DTOID: " + dtoId);
		DruidaConector conector = conectar("ConectorObtenerPeriodoPosteriorActual", paramsEntrada);
		traza("Luego de conectar con CRAObtenerPeriodoPosteriorActual");

		Object dtoSalida = conector.objeto("dtoSalida");
		if (dtoSalida != null) {
			traza("dtoSalida(" + dtoSalida.getClass() + "): " + dtoSalida);
		} else {
			traza("dtoSalida es null");
		}
		
		DTOID dtoIdPeriodoPost = (DTOID)dtoSalida;
		traza("dtoIdPeriodoPost: " + dtoIdPeriodoPost);

		traza("*** Salida - LPActivarCerrarConcursos - obtenerPeriodoPosteriorActual ***");
		return (dtoIdPeriodoPost != null)? dtoIdPeriodoPost.getOid() : null;
	}

	private void activar() throws Exception {
		traza("*** Entrada- LPActivarCerrarConcursos - activar ***");

		Long oidPeriodoActivar = new Long(conectorParametroLimpia("hOidPeriodoActivar", "", false));
		traza("oidPeriodoActivar: " + oidPeriodoActivar);

		this.marca = new Long(conectorParametroLimpia("hOidMarca", "", false));
		this.canal = new Long(conectorParametroLimpia("hOidCanal", "", false));
		traza("this.marca: " + this.marca);
		traza("this.canal: " + this.canal);

		pagina("salidaGenerica");

		MareDTO dto = new MareDTO();
		dto.setProperty(ConstantesCRA.DATO_PAIS, this.pais);
		dto.setProperty(ConstantesCRA.DATO_MARCA, this.marca);
		dto.setProperty(ConstantesCRA.DATO_CANAL, this.canal);
		dto.setProperty(ConstantesCRA.DATO_PERIODO, oidPeriodoActivar);
		dto.setProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_INC));

		MareBusinessID id = new MareBusinessID("INCLanzarActivacionConcursosBatch");
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dto);
		paramsEntrada.add(id);

		traza("Antes de conectar con INCLanzarActivacionConcursosBatch");
		DruidaConector conector = conectar("ConectorActivarConcursosBatch", paramsEntrada);
		traza("Luego de conectar con INCLanzarActivacionConcursosBatch");

		asignar("VAR", "ejecutar", "ok()");

		traza("*** Salida - LPActivarCerrarConcursos - activar ***");
	}

	private void cerrar() throws Exception {
		traza("*** Entrada- LPActivarCerrarConcursos - cerrar ***");

		Long oidPeriodoCerrar = new Long(conectorParametroLimpia("hOidPeriodoCerrar", "", false));
		Boolean variableEntorno = Boolean.valueOf(conectorParametroLimpia("hVariableEntorno", "", false));
		traza("oidPeriodoCerrar: " + oidPeriodoCerrar);
		traza("variableEntorno: " + variableEntorno);

		this.marca = new Long(conectorParametroLimpia("hOidMarca", "", false));
		this.canal = new Long(conectorParametroLimpia("hOidCanal", "", false));
		traza("this.marca: " + this.marca);
		traza("this.canal: " + this.canal);

		pagina("salidaGenerica");

		MareDTO dto = new MareDTO();
		dto.setProperty(ConstantesCRA.DATO_PAIS, this.pais);
		dto.setProperty(ConstantesCRA.DATO_MARCA, this.marca);
		dto.setProperty(ConstantesCRA.DATO_CANAL, this.canal);
		dto.setProperty(ConstantesCRA.DATO_PERIODO, oidPeriodoCerrar);
		dto.setProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_INC));
		dto.setProperty(ConstantesCRA.DATO_VARIABLE_ENTORNO, variableEntorno);

		MareBusinessID id = new MareBusinessID("INCLanzarCerradoConcursosBatch");
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dto);
		paramsEntrada.add(id);

		traza("Antes de conectar con INCLanzarCerradoConcursosBatch");
		DruidaConector conector = conectar("ConectorCerrarConcursosBatch", paramsEntrada);
		traza("Luego de conectar con INCLanzarCerradoConcursosBatch");

		asignar("VAR", "ejecutar", "ok()");

		traza("*** Salida - LPActivarCerrarConcursos - cerrar ***");
	}
}
