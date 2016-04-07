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

/*
    INDRA/CAR/PROY
    $Id: LPUtilidadesEDU.java,v 1.1 2009/12/03 18:42:56 pecbazalar Exp $
    DESC
*/

import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
  
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTOCurso;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;
import es.indra.sicc.dtos.edu.DTODependientesCarga;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;


public abstract class LPUtilidadesEDU extends LPSICCBase {
          
	// Nombres de los campos de la página
	protected static String nombresCampos[] = {"Marca", "Canal", "TipoCurso", "NombreCurso",
			"ObjetivoCurso", "ContenidoCurso", "AccesoInformacion", "AccesoSeleccionDM",
			"FrecuenciaDictado", "FechaDisponible", "FechaLanzamiento",
			"FechaFin", "AlcanceGeografico", "SubgerenciaVentas", "Region",
			"Zona", "Seccion", "Territorio", "NOptimo",
			"TipoCliente", "Bloqueo", "Capacitador", "Relacion",
			"SubtipoCliente", "Clasificacion", "TipoClasificacion", "StatusCliente",
			"StatusCursosExigidos", "NOrdenes", "PeriodoInicio", "PeriodoFin",
			"Monto", "PeriodoInicioV", "PeriodoFinV", "PeriodoIngreso", 
			"FechaIngreso", "NCondicion", "FechaUltimo", "ProductoEntregar",
			"NRegaloParticipantes", "MomentoEntregar", "CondicionPedido", "ControlMorosidad",
			"DescripcionD"}; 
                    
	// Tabla hash que asocia nombres de parámetros con nombres de
    // campos de la página
	private static HashMap nombresParam = null;
	private static final int NUM_PARAMETROS = 44;
         
	// Posición de los campos que son combos independientes
	private static int posCombosIndependientes[] = {0, 1, 19, 26, 38, 8, 40};
	private static int posCombosDependientes[] = {2, 6, 13, 14, 15, 16, 17, 21, 23, 24, 25, 27, 29, 30, 32, 33, 34};
          
	// Constantes que indican el tipo de elemento
	private static final int T_COMBO = 1;
	private static final int T_TEXT = 2;
	private static final int T_RADIO = 3;
	private static final int T_COMBO2 = 4;
	private static final int T_COMBO_MULTI = 5;
	private static final int T_AREATEXTO = 6;
         
	// Arrays con los tipos de elementos
	private static String tiposElementos[]={"COMBO","TEXT","RBINPUT","COMBO","COMBO","AREATEXTO"};
         
	// Plantilla XSL para generar la página
	private static final String PLANTILLA_XSL = "contenido_plantilla_cursos_insertar";
          
	private  boolean modoConsulta = false;
	private String casoUso = null;
	private DTOCurso curso = null;
          
	static {
    	// Se inicializa la tabla Hash que asocia nombres de parametros con nombres de
		// campos de la página
		nombresParam = new HashMap();
		for (int i=0; i < NUM_PARAMETROS;i++) {
			nombresParam.put(new Long((long)i), nombresCampos[i]);
		}
	}
          
    public LPUtilidadesEDU() {
		super();
    }
    
    // Método para obtener los detalles de una plantilla
    public DTOCargaCursos obtieneDetallesPlantilla (Long plantilla) throws Exception {
          setTrazaFichero();
          traza("*** Entrada - LPUtilidadesEDU - obtieneDetallesPlantilla ***");
          
          // Obtenemos el pais y el idioma de la sesion
          Long pais = UtilidadesSession.getPais(this); 
          Long idioma = UtilidadesSession.getIdioma(this);

          // Se instancia un DTOOID y se rellena con el parametro plantilla,
          // el pais y el idioma
          traza("*** Plantilla " + plantilla);
          DTOOID dtoEntrada = new DTOOID();
          dtoEntrada.setOid(plantilla);
          dtoEntrada.setOidPais(pais);
          dtoEntrada.setOidIdioma(idioma);

          // Se crea idNegocio = "EDUObtieneDetallesPlantilla"
          MareBusinessID idBussiness = new MareBusinessID("EDUObtieneDetallesPlantilla");
          
          //Almacenamos los parametros de entrada
          Vector paramEntrada = new Vector();
          paramEntrada.addElement(dtoEntrada);
          paramEntrada.addElement(idBussiness);
         
          // Se invoca al conector ConectorObtieneDetallesPlantilla
          traza("***** Antes druida conector " + plantilla + "*****");
          DruidaConector conector = conectar("ConectorObtieneDetallesPlantilla", paramEntrada);
          traza("***** Despues druida conector *****");
          // Se recibe un DTOCargaCursos devuelto por el conector
          DTOCargaCursos dtoSalida = (DTOCargaCursos)conector.objeto("DTOCargaCursos");
          
          traza("*** Salida - LPUtilidadesEDU - obtieneDetallesPlantilla ***");
          return dtoSalida;
    }
    
    public void muestraDetallesPlantilla(DTOCargaCursos dtoCargaCursos, Boolean modoConsulta)
         throws Exception {
		this.modoConsulta = modoConsulta.booleanValue();
		setTrazaFichero();
		traza("*** Entrada - LPUtilidadesEDU - muestraDetallesPlantilla ***");
          
		boolean consulta = true;
		if (modoConsulta != null && !modoConsulta.booleanValue()) {
			consulta = false;
		}
         
		// Se almacena en sesión los oids de los parámetros
		RecordSet rsParametros = dtoCargaCursos.getParametros();
		Vector oidsParametros = rsParametros.getColumn(0);
		conectorParametroSesion("oidsParametros", oidsParametros);
         
        // Se obtienen los detalles de la plantilla
		ArrayList detalles = dtoCargaCursos.getPlantilla().getDetalles();
         
		// Se genera dinámicamente la página en función de los parámetros
		this.generaPaginaDinamica(rsParametros);
		 
		// Se cargan los combos independientes de la página
		this.cargaCombos(dtoCargaCursos,detalles);
            
		// Se muestra el nombre de la plantilla
		DTOI18nSICC attriTraducible[] = dtoCargaCursos.getPlantilla().getAttriTraducible();
		String nombrePlantilla = attriTraducible[0].getValorI18n();
		asignarAtributo("TEXT","txtNombrePlantilla","valor",nombrePlantilla);
		if (consulta) {
			asignarAtributoElemento("txtNombrePlantilla","disabled","S");
		}
		
		ArrayList noVisibles = new ArrayList();
		ArrayList noModificables = new ArrayList();
		ArrayList noObligatorios = new ArrayList();
		
		// Se rellenan los campos de la tabla con la información de detalles de la 
		// plantilla
		traza("****LPUtilidades despues de los combos ****");
		for (int i=0; i < rsParametros.getRowCount(); i++) {
			Vector filaParam = rsParametros.getRow(i);
		 
		 	Long oidParametro = new Long(((BigDecimal)filaParam.elementAt(0)).longValue());
			Integer tipoParametro = new Integer(((BigDecimal)filaParam.elementAt(2)).intValue());
			
			// Se obtiene el nombre del campo de la página asociado al nombre
			// del parametro
			String nombreCampo = (String)nombresParam.get(new Long((long) i));
			traza("*** Recontratraza " + i + " OIDParametro " + oidParametro + " TipoParamtro " + tipoParametro);
			if (nombreCampo == null) continue;
			// Se muestra la informacion de cada detalle en la página
			traza("****LPUtilidades  Antesdetalle**** " + i + " " + nombreCampo);
			DTODetallePlantillaCurso dtoDetalle = (DTODetallePlantillaCurso)detalles.get(i);
			traza("****LPUtilidades  AntesMuestra**** " + i + " " + nombreCampo);
			muestraDetalle(nombreCampo,tipoParametro.intValue(),consulta,dtoDetalle);
			traza("****LPUtilidades  DespuesMuestra**** " + i + " " + nombreCampo + " " + tipoParametro.intValue());
			
			// Si el campo no es visible, se añade a la lista
			Boolean visible = dtoDetalle.getVisible();
			if (visible != null && !visible.booleanValue()) {
				noVisibles.add(nombreCampo);
			}
			
			// Si el campo no es modificable, se añade a la lista
			Boolean modificable = dtoDetalle.getModificable();
			if (modificable != null && !modificable.booleanValue()) {
				noModificables.add(nombreCampo);
			}
			
			// Si el campo no es obligatorio, se añade a la lista
			Boolean obligatorio = dtoDetalle.getObligatorio();
			if (obligatorio != null && !obligatorio.booleanValue()) {
				noObligatorios.add(nombreCampo);
			} 
			traza ("Fin bucle " + i);
		}
		
		// Se asigna a un campo hidden los nombres de los campos no visibles
		int i = 0;
		String strNoVisibles = "";
		for (Iterator iterator = noVisibles.iterator(); iterator.hasNext(); i++) {
			if (i == 0) {
				strNoVisibles += (String)iterator.next();
			} else {
				strNoVisibles += "|" + (String)iterator.next();
			}
		}
		traza("traza al azar 1");
		asignarAtributo("VAR","noVisibles","valor",strNoVisibles);
		
		// Se asigna a un campo hidden los nombres de los campos no modificables
		i = 0;
		String strNoModificables = "";
		for (Iterator iterator = noModificables.iterator(); iterator.hasNext(); i++) {
			if (i == 0) {
				strNoModificables += (String)iterator.next();
			} else {
				strNoModificables += "|" + (String)iterator.next();
			}
		}
		traza("traza al azar 2");
		asignarAtributo("VAR","noModificables","valor",strNoModificables);
		
		// Se asigna a un campo hidden los nombres de los campos no obligatorios
		i = 0;
		String strNoObligatorios = "";
		for (Iterator iterator = noObligatorios.iterator(); iterator.hasNext(); i++) {
			if (i == 0) {
				strNoObligatorios += (String)iterator.next();
			} else {
				strNoObligatorios += "|" + (String)iterator.next();
			}
		}
		traza("traza al azar 3");
		asignarAtributo("VAR","noModificables","valor",strNoObligatorios);
		  
		traza("*** Salida - LPUtilidadesEDU - muestraDetallesPlantilla ***");
	}
         
	private void generaPaginaDinamica(RecordSet rsParametros) throws Exception {
		traza("*** Entrada - LPUtilidadesEDU - generaPaginaDinamica ***");
                  
		// Se genera un conector a partir del RecordSet
		Vector cols = rsParametros.getColumnIdentifiers();
		DruidaConector conectorParametros = UtilidadesBelcorp.generarConector(
             "DTOCargaCursos.parametros",rsParametros,cols);
         
		// Se llama a la función transformar para generar dinamicamente la página,
		// aplicando la plantilla xsl
		DruidaConector conectorTransforma = transformar(PLANTILLA_XSL,conectorParametros);
		//traza("XML Generado: ",conectorTransforma);    
         
		// Sustituye el tag <CAMBIATODO> de la página por las etiquetas druida 
		// contenidas en el conector conectorTransforma, y que son resultado de aplicar
		// la plantilla XSL 
		asignar("CAMBIATODO","cambiaTodo",conectorTransforma);
                  
        traza("*** Salida - LPUtilidadesEDU - generaPaginaDinamica ***");
	}
         
	private void cargaCombos(DTOCargaCursos dtoCargaCursos, ArrayList detalles) throws Exception {
		traza("*** Entrada - LPUtilidadesEDU - cargaCombos ***");
                  
		// Se obtienen los RecordSet del DTO
		RecordSet rsMarcas = dtoCargaCursos.getMarcas();
		RecordSet rsCanales = dtoCargaCursos.getCanales();
		RecordSet rsTiposClientes = dtoCargaCursos.getTiposCliente();
		RecordSet rsEstatusClientes = dtoCargaCursos.getStatusClientes();
		RecordSet rsRegalos = dtoCargaCursos.getRegalos();
		RecordSet rsFrecuenciasCursos = dtoCargaCursos.getFrecuenciasCursos();
		RecordSet rsMomentoEntrega = dtoCargaCursos.getMomentoEntrega();
		
		int i =0;
		
		// Se cargan los combos de marca, canal, tipo de cliente, 
		// estatus de cliente, producto y frecuencia de dictado. 
		int posicion = posCombosIndependientes[i++];
		DTODetallePlantillaCurso dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsMarcas,"DTOCargaCursos.marcas","ValorMarca",dtoDetalle.getValor());
		
		posicion = posCombosIndependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsCanales,"DTOCargaCursos.canales","ValorCanal",dtoDetalle.getValor());
		
		posicion = posCombosIndependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsTiposClientes,"DTOCargaCursos.tiposClientes","ValorTipoCliente",dtoDetalle.getValor());
		
		posicion = posCombosIndependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsEstatusClientes,"DTOCargaCursos.estatusClientes","ValorStatusCliente",dtoDetalle.getValor());
				
		posicion = posCombosIndependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsRegalos,"DTOCargaCursos.regalos","ValorProductoEntregar",dtoDetalle.getValor());
		
		posicion = posCombosIndependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsFrecuenciasCursos,"DTOCargaCursos.frecuenciasCursos","ValorFrecuenciaDictado",
			dtoDetalle.getValor());

		posicion = posCombosIndependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		cargaCombo(rsMomentoEntrega, "DTOCargaCursos.momentoEntrega", "ValorMomentoEntregar", dtoDetalle.getValor());

		// Se cargan los combos dependientes, 
		DTODependientesCarga dtoDependientesCarga = dtoCargaCursos.getDependientes();
		i = 0;
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getTiposCurso() != null && !dtoDependientesCarga.getTiposCurso().esVacio())
			cargaCombo(dtoDependientesCarga.getTiposCurso(), "DTODependientesCarga.tiposCurso", "ValorTipoCurso", dtoDetalle.getValor());

		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getAccesos() != null && !dtoDependientesCarga.getAccesos().esVacio())
			cargaCombo(dtoDependientesCarga.getAccesos(), "DTODependientesCarga.accesos", "ValorAccesoInformacion", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getSubgerencias() != null && !dtoDependientesCarga.getSubgerencias().esVacio())
			cargaCombo(dtoDependientesCarga.getSubgerencias(), "DTODependientesCarga.subgerencias", "ValorSubgerenciaVentas", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getRegiones() != null && !dtoDependientesCarga.getRegiones().esVacio())
			cargaCombo(dtoDependientesCarga.getRegiones(), "DTODependientesCarga.regiones", "ValorRegion", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getZonas() != null && !dtoDependientesCarga.getZonas().esVacio())
			cargaCombo(dtoDependientesCarga.getZonas(), "DTODependientesCarga.zonas", "ValorZona", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getSecciones() != null && !dtoDependientesCarga.getSecciones().esVacio())
			cargaCombo(dtoDependientesCarga.getSecciones(), "DTODependientesCarga.secciones", "ValorSeccion", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getTerritorios() != null && !dtoDependientesCarga.getTerritorios().esVacio())
			cargaCombo(dtoDependientesCarga.getTerritorios(), "DTODependientesCarga.territorios", "ValorTerritorio", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getCapacitadores() != null && !dtoDependientesCarga.getCapacitadores().esVacio())
			cargaCombo(dtoDependientesCarga.getCapacitadores(), "DTODependientesCarga.capacitadores", "ValorCapacitador", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getSubtiposCliente() != null && !dtoDependientesCarga.getSubtiposCliente().esVacio())
			cargaCombo(dtoDependientesCarga.getSubtiposCliente(), "DTODependientesCarga.subtiposCliente", "ValorSubtipoCliente", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getClasificaciones() != null && !dtoDependientesCarga.getClasificaciones().esVacio())
			cargaCombo(dtoDependientesCarga.getClasificaciones(), "DTODependientesCarga.clasificaciones", "ValorClasificacion", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoDependientesCarga.getTiposClasificacion() != null && !dtoDependientesCarga.getTiposClasificacion().esVacio())
			cargaCombo(dtoDependientesCarga.getTiposClasificacion(), "DTODependientesCarga.tiposClasificacion", "ValorTipoClasificacion", dtoDetalle.getValor());
		
		posicion = posCombosDependientes[i++];
		dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
		if (dtoCargaCursos.getCursos() != null && !dtoCargaCursos.getCursos().esVacio())
			cargaCursos(dtoCargaCursos.getCursos(), "DTODependientesCarga.cursos", "ValorStatusCursosExigidos", dtoDetalle.getCursosRequisito());

		
		if (dtoDependientesCarga.getPeriodos() != null && !dtoDependientesCarga.getPeriodos().esVacio()) {
			Vector cols = dtoDependientesCarga.getPeriodos().getColumnIdentifiers();
			String columna = cols.get(0).toString();
			DruidaConector conector = UtilidadesBelcorp.generarConector("DTODependientesCarga.periodos", dtoDependientesCarga.getPeriodos(), cols);
			posicion = posCombosDependientes[i++];
			dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
			cargaPeriodos(conector, columna, "ValorPeriodoInicio", dtoDetalle.getValor());
			posicion = posCombosDependientes[i++];
			dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
			cargaPeriodos(conector, columna, "ValorPeriodoFin", dtoDetalle.getValor());
			posicion = posCombosDependientes[i++];
			dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
			cargaPeriodos(conector, columna, "ValorPeriodoInicioV", dtoDetalle.getValor());
			posicion = posCombosDependientes[i++];
			dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
			cargaPeriodos(conector, columna, "ValorPeriodoFinV", dtoDetalle.getValor());
			posicion = posCombosDependientes[i++];
			dtoDetalle = (DTODetallePlantillaCurso)detalles.get(posicion);
			cargaPeriodos(conector, columna, "ValorPeriodoIngreso", dtoDetalle.getValor());
		}
		
		traza("*** Salida - LPUtilidadesEDU - cargaCombos ***");
	}
	

	private void cargaCursos(RecordSet datos, String rowset, String combo, Long [] valor) throws Exception {

		RecordSet recordset = datos;
		//Si es consulta sólo mostramos los seleccionados
		if (this.modoConsulta) {
        	// Se eliminan las filas del recordset cuyo oid no está en valor
			recordset = new RecordSet();
        
        	if (datos != null && !datos.esVacio() && valor != null && valor.length > 0) {
				recordset.setColumnIdentifiers(datos.getColumnIdentifiers());
            	/*for (int i=0; i < recordsetOrigen.getColumnCount(); i++) {
               	 recordsetDestino.addColumn(recordsetOrigen.getColumnName(i));    
            	}*/
            
            	for (int i = 0; i < datos.getRowCount(); i++) {
                	Vector fila = datos.getRow(i);
                	Long oid = new Long(((BigDecimal)fila.elementAt(0)).longValue());
                
                	for (int j = 0; j < valor.length; j++) {
                		//si el curso de la fila actual esta contenido en valor pasa a ser una opcion del combo, en caso contrario no
                		if (oid.longValue() == valor[j].longValue()) {
                			recordset.addRow(fila);
                			break;
                		}
                	}
            	}   
        	} 
		}

		// Se genera el conector 
		Vector cols = recordset.getColumnIdentifiers();
		DruidaConector conector = UtilidadesBelcorp.generarConector(rowset,recordset,cols);
		    
		// Se carga el combo
		asignar("COMBO", combo, conector, rowset);
		if (valor != null && valor.length > 0) {
			asignar("VAR", "hStatusCursosExigidos", obtieneCadenaCursos(valor).toString());
		}
	}


	private void cargaPeriodos(DruidaConector conector, String columna, String combo, String valor) throws Exception {
		    
		if (valor == null || valor.equals("")) {
			// Se carga el combo
			asignar("COMBO", combo, conector, "DTODependientesCarga.periodos");
		} else {
			// Se carga el combo y se selecciona un elemento del mismo
			traza("********************************* columna: " +  columna);
			asignar("COMBO", combo, conector, "DTODependientesCarga.periodos", columna, valor);
		}
	}

	private void cargaCombo(RecordSet recordset, String rowset, String combo, String valor) throws Exception {
			traza("********************************* recordset_combo: " +  recordset + "_" + combo);
		if (recordset != null && !recordset.esVacio()) {
		// Se genera el conector 
		Vector cols = recordset.getColumnIdentifiers();
			traza("********************************* cols size: " +  cols.size());
		DruidaConector conector = UtilidadesBelcorp.generarConector(rowset,recordset,cols);
		    
		if (valor == null || valor.equals("")) {
			// Se carga el combo
			asignar("COMBO", combo, conector, rowset);
		} else {
			// Se carga el combo y se selecciona un elemento del mismo
			String columna = cols.get(0).toString();
			traza("********************************* columna: " +  columna);
			asignar("COMBO", combo, conector, rowset, columna, valor);
		}
		}
	}
		
         
	private void muestraDetalle(String nombreCampo, int tipo, boolean consulta, 
		DTODetallePlantillaCurso dtoDetalle) throws Exception {
		
		String valor = dtoDetalle.getValor() != null ? dtoDetalle.getValor() : "";
		traza("**** valor " + nombreCampo + ":" + valor);
		if (nombreCampo.equals("Monto") && !valor.equals("")) {
			String monto = formateaMonto(valor);
			valor = new String(monto);
		}
		
		// Se rellenan las cajas de texto, los radio buttons y las areas de texto. Para los combos
		// se almacena su valor en un campo oculto 
		switch (tipo) {
			case T_TEXT:
			case T_AREATEXTO:
				asignarAtributo(tiposElementos[tipo-1],"Valor"+nombreCampo,"valor",valor);
				asignarAtributo("VAR","h"+nombreCampo,"valor",valor);
				if (consulta) {
					asignarAtributoElemento("Valor"+nombreCampo,"disabled","S");
				}
				break;
			case T_RADIO:
				// Se desactivan los dos radio buttons
				String nombreRadioSi = "Valor"+nombreCampo+"_S";
				String nombreRadioNo = "Valor"+nombreCampo+"_N";
				asignarAtributo(tiposElementos[tipo-1],nombreRadioSi,"check","N");
				asignarAtributo(tiposElementos[tipo-1],nombreRadioNo,"check","N");
				
				// Se activa el radio button correspondiente
				String nombreRadio = "Valor"+nombreCampo+"_"+valor;
				asignarAtributo(tiposElementos[tipo-1],nombreRadio,"check","S");
				asignarAtributo("VAR","h"+nombreCampo,"valor",valor);
				if (consulta) {
					asignarAtributoElemento("Valor"+nombreCampo,"disabled","S");
				}
				break;
			case T_COMBO:
			case T_COMBO2:
		    	asignarAtributo("VAR","h"+nombreCampo,"valor",valor);
		    	if (consulta) {
					asignarAtributoElemento("Valor"+nombreCampo,"disabled","S");
				}
		        break;
			case T_COMBO_MULTI:
				asignarAtributo("VAR","h"+nombreCampo,"valor",valor);
		    	
		    	// La lista multiselección no se desactiva
		        break;
		}
		         
		// Se rellenan los checkbox de visible, modificable u obligatorio
		asignarAtributo("CHECKBOX","Visible"+nombreCampo,"check",this.toString(dtoDetalle.getVisible()));
		asignarAtributo("CHECKBOX","Modificable"+nombreCampo,"check",this.toString(dtoDetalle.getModificable()));
		asignarAtributo("CHECKBOX","Obligatorio"+nombreCampo,"check",this.toString(dtoDetalle.getObligatorio()));
		
		if (consulta) {
			asignarAtributoElemento("Visible"+nombreCampo,"disabled","S");
			asignarAtributoElemento("Modificable"+nombreCampo,"disabled","S");
			asignarAtributoElemento("Obligatorio"+nombreCampo,"disabled","S");
		}
	}
    
    // Método para obtener los detalles de un curso
    public DTOCargaCursos obtieneDetallesCurso (Long curso) throws Exception {
		setTrazaFichero();
		
		//Obtenemos el pais y el idioma de la sesion
		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);
		
		//Se instancia un DTOOID y se rellena con el parametro "curso",
		//pais e idioma
		DTOOID dtoEntrada = new DTOOID();
		dtoEntrada.setOid(curso);
		dtoEntrada.setOidPais(pais);
		dtoEntrada.setOidIdioma(idioma);
		          
		//Se crea idNegocio = "EDUObtieneDetallesCurso"
		MareBusinessID idBussiness = new MareBusinessID("EDUObtieneDetallesCurso");
		
		//Almacenamos los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoEntrada);
		paramEntrada.addElement(idBussiness);
		
		// Invocar al conector - ConectorObtieneDetallesCurso 
		DruidaConector conector = conectar("ConectorObtieneDetallesCurso", paramEntrada);
		
		// Se recibe un DTOCargaCursos devuelto por el conector 
		DTOCargaCursos dtoSalida = (DTOCargaCursos) conector.objeto("DTOCargaCursos");
		traza("********* obtieneDetallesCurso: " + dtoSalida);
		
		return dtoSalida;
    }
    
    
          
	public void muestraDetallesCurso(DTOCargaCursos dto, Boolean modoConsulta) throws Exception {
		/*
		 * Con el dto que recibe por parámetro se muestra la PaginaInsertarDetalles del siguiente modo: 
		
		 * 1) El único atributo del dto que se necesita es dto.plantilla, que contiene lo siguiente: 
		 * - oid (código de la plantilla) 
		 * - nombre (nombre de la plantilla) 
		 * - detalles (parámetros de la plantilla). 
		
		 * 2) Por cada dto.plantilla.detalle[i] existe un control en la pantalla. Por ejemplo el control Marcas (combobox y etiqueta "Marcas") lleva asociada la información del dto.plantilla.detalle[i] asociado al parámetro Marcas (parámetro de oid 0 en Parametros). 
		
		 * El control cumple lo indicado en detalles, del siguiente modo: 
		 * - Si dto.plantilla.detalle[i].visible se muestra el control y su etiqueta, en caso contrario no se muestra. 
		 * - Si dto.plantilla.detalle[i].modificable se muestra el control habilitado y su etiqueta, en caso contrario aparecerá deshabilitado. El contenido del control será dto.plantilla.detalle[i].valor. 
		 * - Si dto.plantilla.detalle[i].obligatorio habrá que indicar a la pantalla que al guardar los cambios, el control debe contener un valor
		 */
		asignarAtributo("VAR", "Plantilla", "valor", dto.getPlantilla().getOid().toString());
		this.modoConsulta = modoConsulta.booleanValue();
		this.casoUso = conectorParametroLimpia("casoUso", "", true);
		this.curso = dto.getCurso();
		setTrazaFichero();
		traza("********************************* MuestraDetallesCurso: 1");
	  
		// Se obtienen los campos del DTO
		RecordSet rsMarcas = dto.getMarcas();
		RecordSet rsCanales = dto.getCanales();
		RecordSet rsTiposClientes = dto.getTiposCliente();
		RecordSet rsEstatusClientes = dto.getStatusClientes();
		RecordSet rsRegalos = dto.getRegalos();
		RecordSet rsFrecuenciasCursos = dto.getFrecuenciasCursos();  

		DTODependientesCarga dtoDependientesCarga = dto.getDependientes();
		if (dtoDependientesCarga == null) dtoDependientesCarga = new DTODependientesCarga();
		DruidaConector conectorCargaComboPeriodo = null;
		String columnaPeriodo = null;
		if (dtoDependientesCarga != null && dtoDependientesCarga.getPeriodos() != null && !dtoDependientesCarga.getPeriodos().esVacio()) {
			traza("********************************* Periodos: " + dtoDependientesCarga.getPeriodos());
			columnaPeriodo = dtoDependientesCarga.getPeriodos().getColumnIdentifiers().get(0).toString();
			conectorCargaComboPeriodo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", dtoDependientesCarga.getPeriodos(), dtoDependientesCarga.getPeriodos().getColumnIdentifiers());
		}
		
		traza("********************************* MuestraDetallesCurso: 2");
		ArrayList detalles = dto.getPlantilla().getDetalles();
		
		Vector activos = new Vector(); // se guarda el orden en que aparecen en la pantalla
		//if (!casoUso.equals("consultar") && !casoUso.equals("eliminar")) {
			for (int i = 0; i < 8; i++) {
				activos.add(new Long(i));
			}
			for (int i = 9; i < 20; i++) {
				activos.add(new Long(i));
			}
			activos.add(new Long(21));
			activos.add(new Long(23));
			activos.add(new Long(22));
			activos.add(new Long(29));
			activos.add(new Long(28));
			activos.add(new Long(32));
			activos.add(new Long(38));
			activos.add(new Long(42));
			activos.add(new Long(43));
			activos.add(new Long(44));
			activos.add(new Long(20));
			activos.add(new Long(24));
			activos.add(new Long(26));
			activos.add(new Long(25));
			activos.add(new Long(27));
			activos.add(new Long(30));
			activos.add(new Long(31));
			activos.add(new Long(33));
			activos.add(new Long(34));
			activos.add(new Long(35));
			activos.add(new Long(36));
			activos.add(new Long(37));
			activos.add(new Long(39));
			activos.add(new Long(40));
			activos.add(new Long(41));
		//}		
		Vector noExisten = new Vector();
		for (int i = 0; i < 8; i++) {
		          noExisten.add(new Long(i));
		}
		for (int i = 9; i < 45; i++) {
		          noExisten.add(new Long(i));
		}
	          
		traza("********************************* MuestraDetallesCurso: 3");
		RecordSet rsParametros = dto.getParametros();
		for (int i=0; i < detalles.size(); i++) {
			DTODetallePlantillaCurso detalle = (DTODetallePlantillaCurso)detalles.get(i);
			int param = detalle.getParametro().getOid().intValue();
			traza("********************************* PARAM: " + param);
			if (detalle.getVisible().booleanValue()) {
				noExisten.remove(detalle.getParametro().getOid());
				if ((!detalle.getModificable().booleanValue() || casoUso.equals("consultar") || casoUso.equals("eliminar")) && param != 28 )
					activos.remove(detalle.getParametro().getOid());
			} else
				activos.remove(detalle.getParametro().getOid());
			
			switch (param) {
				case 0:
					this.gestionaCombo(rsMarcas, "cbMarca", "lblMarca", detalle, curso!=null?curso.getRelacion().getOidMarca():null, false);
					break;
				case 1:
					this.gestionaCombo(rsCanales,  "cbCanal", "lblCanal", detalle, curso!=null?curso.getRelacion().getOidCanal():null, false);
					break;
				case 20:
					this.gestionaCombo(rsTiposClientes, "cbTipoCliente", "lblTipoCliente", detalle, curso!=null?curso.getRelacion().getOidTipoCliente():null, false);
					break;
				case 27:
					this.gestionaCombo(rsEstatusClientes, "cbEstatusCli", "lblEstatusCli", detalle, curso!=null?curso.getRelacion().getOidStatusCliente():null, false);
					break;
				case 39:
					this.gestionaCombo(rsRegalos, "cbProductoAEntregar", "lblProductoAEntregar", detalle, curso!=null?curso.getRelacion().getOidRegalo():null, false);
					break;
				case 9:
					this.gestionaCombo(rsFrecuenciasCursos, "cbFrecuenciaDictado", "lblFrecuenciaDictado", detalle, curso!=null?curso.getRelacion().getOidFrecuencia():null, false);
					break;
				case 2:
					this.gestionaCombo(dtoDependientesCarga.getTiposCurso(), "cbTipoCurso", "lblTipoCurso", detalle, curso!=null?curso.getRelacion().getOidTipoCurso():null, true);
					break;
				case 3:
					this.gestionaComponente(detalle, "TEXT", "txtNombreCurso", "lblNombreCurso", curso!=null?curso.getNombre():null);
					break;
				case 4:
					this.gestionaComponente(detalle, "TEXT", "txtObjetivoCurso", "lblObjetivoCurso", curso!=null?curso.getObjetivo():null);
					break;
				case 5:
					this.gestionaComponente(detalle, "TEXT", "txtContenidoCurso", "lblContenidoCurso", curso!=null?curso.getContenido():null);
					break;
				case 6:
					this.gestionaCombo(dtoDependientesCarga.getAccesos(), "cbAccesoInfo", "lblAccesoInfo", detalle, curso!=null?curso.getRelacion().getOidAcceso():null, true);
					break;
				case 7:
					this.gestionaComponente(detalle, "RADIOB", "rbAccesoSeleccion", "lblAccesoSeleccion", curso!=null?obtieneCadenaBoolean(curso.getAccesoDataMart()):null);
					break;
				/*case 8:
					this.gestionaComponente(detalle, "TEXT", "txtPath", "lblPath", curso!=null?curso.getPathFichero():null);
					break;*/
				case 10:
					this.gestionaComponente(detalle, "TEXT", "txtFechaDisponible", "lblFechaDisponible", curso!=null?obtieneCadenaFecha(curso.getFechaDisponible()):null);
					break;
				case 11:
					this.gestionaComponente(detalle, "TEXT", "txtFechaLanzamiento", "lblFechaLanzamiento", curso!=null?obtieneCadenaFecha(curso.getFechaLanzamiento()):null);
					break;
				case 12:
					this.gestionaComponente(detalle, "TEXT", "txtFechaFinalizacion", "lblFechaFinalizacion", curso!=null?obtieneCadenaFecha(curso.getFechaFin()):null);
					break;
				case 13:
					this.gestionaComponente(detalle, "RADIOB", "rbAlcanceGeoNacional", "lblAlcanceGeoNacional", curso!=null?obtieneCadenaBoolean(curso.getAlcance()):null);
					break;
				case 14:
					this.gestionaCombo(dtoDependientesCarga.getSubgerencias(), "cbSubVentas", "lblSubVentas", detalle, curso!=null?curso.getRelacion().getOidSubgerencia():null, true);
					break;
				case 15:
					this.gestionaCombo(dtoDependientesCarga.getRegiones(), "cbRegion", "lblRegion", detalle, curso!=null?curso.getRelacion().getOidRegion():null, true);
					break;
				case 16:
					this.gestionaCombo(dtoDependientesCarga.getZonas(), "cbZona", "lblZona", detalle, curso!=null?curso.getRelacion().getOidZona():null, true);
					break;
				case 17:
					this.gestionaCombo(dtoDependientesCarga.getSecciones(), "cbSeccion", "lblSeccion", detalle, curso!=null?curso.getRelacion().getOidSeccion():null, true);
					break;
				case 18:
					this.gestionaCombo(dtoDependientesCarga.getTerritorios(), "cbTerritorio", "lblTerritorio", detalle, curso!=null?curso.getRelacion().getOidTerritorio():null, true);
					break;
				case 19:
					this.gestionaComponente(detalle, "TEXT", "txtOptimoParticipantes", "lblOptimoParticipantes", curso!=null?curso.getNumeroParticipantes():null);
					break;
				case 21:
					this.gestionaComponente(detalle, "RADIOB", "rbBloqueo", "lblBloqueo", curso!=null?obtieneCadenaBoolean(curso.getBloqueoExtemporaneas()):null);
					break;
				case 22:
					this.gestionaCombo(dtoDependientesCarga.getCapacitadores(), "cbCapacitador", "lblCapacitador", detalle, curso!=null?curso.getRelacion().getOidCapacitador():null, true);
					break;
				case 23:
					this.gestionaComponente(detalle, "TEXT", "txtMaterialAEmplear", "lblMaterialAEmplear", curso!=null?curso.getRelacionMaterial():null);
					break;
				case 24:
					this.gestionaCombo(dtoDependientesCarga.getSubtiposCliente(), "cbSubtipoCliente", "lblSubtipoCliente", detalle, curso!=null?curso.getRelacion().getOidSubtipoCliente():null, true);
					break;
				case 25:
					this.gestionaCombo(dtoDependientesCarga.getClasificaciones(), "cbClasificacion", "lblClasificacion", detalle, curso!=null?curso.getRelacion().getOidClasificacion():null, true);
					break;
				case 26:
					this.gestionaCombo(dtoDependientesCarga.getTiposClasificacion(), "cbTipoClasificacion", "lblTipoClasificacion", detalle, curso!=null?curso.getRelacion().getOidTipoClasificacion():null, true);
					break;
				case 28:
					this.gestionaCursos(dto.getCursos(), detalle, "cbCursosExigidos", "lblEstatusCursos");
					break;
				case 29:
					this.gestionaComponente(detalle, "TEXT", "txtNOrdenes", "lblNOrdenes", curso!=null?curso.getNumeroOrdenes():null);
					break;
				case 30:
					this.gestionaPeriodos(conectorCargaComboPeriodo, columnaPeriodo, "cbPerConstInicio", "lblPerConstInicio", detalle, curso!=null?curso.getRelacion().getOidPeriodoIniConstancia():null);
					break;
				case 31:
					this.gestionaPeriodos(conectorCargaComboPeriodo, columnaPeriodo, "cbPerConstFin", "lblPerConstFin", detalle, curso!=null?curso.getRelacion().getOidPeriodoFinConstancia():null);
					break;
				case 32:
					this.gestionaComponenteMonto(detalle, "TEXT", "txtMontoVentasComp", "lblMontoVentasComp", curso!=null?curso.getMontoVentas():null);
					break;
				case 33:
					this.gestionaPeriodos(conectorCargaComboPeriodo, columnaPeriodo, "cbPerVentInicio", "lblPerVentInicio", detalle, curso!=null?curso.getRelacion().getOidPeriodoIniComparativo():null);
					break;
				case 34:
					this.gestionaPeriodos(conectorCargaComboPeriodo, columnaPeriodo, "cbPerVentFin", "lblPerVentFin", detalle, curso!=null?curso.getRelacion().getOidPeriodoFinComparativo():null);
					break;
				case 35:
					this.gestionaPeriodos(conectorCargaComboPeriodo, columnaPeriodo, "cbPerIngresoCondicion", "lblPerIngresoCondicion", detalle, curso!=null?curso.getRelacion().getOidPeriodoIngreso():null);
					break;
				case 36:
					this.gestionaComponente(detalle, "TEXT", "txtFechaIngresoCondicion", "lblFechaIngresoCondicion", curso!=null?obtieneCadenaFecha(curso.getFechaIngreso()):null);
					break;
				case 37:
					this.gestionaComponente(detalle, "TEXT", "txtNPeriodosCondicion", "lblNPeriodosCondicion", curso!=null?curso.getNumeroCampanyas():null);
					break;
				case 38:
					this.gestionaComponente(detalle, "TEXT", "txtFechaUltimo", "lblFechaUltimo", curso!=null?obtieneCadenaFecha(curso.getFechaUltimo()):null);
					break;
				case 40:
					this.gestionaComponente(detalle, "TEXT", "txtUniRegalo", "lblUniRegalo", curso!=null?curso.getNumeroUnidades():null);
					break;
				case 41:
					this.gestionaCombo(dto.getMomentoEntrega(), "cbMomentoEntrega", "lblMomentoEntrega", detalle, curso!=null?curso.getRelacion().getOidMomentoEntrega():null, false);
					break;
				case 42:
					this.gestionaComponente(detalle, "RADIOB", "rbCondicionPedido", "lblCondicionPedido", curso!=null?obtieneCadenaBoolean(curso.getCondicionPedido()):null);
					break;
				case 43:
					this.gestionaComponente(detalle, "RADIOB", "rbControlMorosidad", "lblControlMorosidad", curso!=null?obtieneCadenaBoolean(curso.getControlMorosidad()):null);
					break;
				case 44:
					this.gestionaComponente(detalle, "AREATEXTO", "areaDescDetallada", "lblDescDetallada", curso!=null?curso.getDescripcion():null);
					break;
			}
		}
         
        //eliminar los detalles no informados 
		for (int i=0; i < noExisten.size(); i++) {
			if (activos.contains((Long)noExisten.get(i)))
				activos.remove((Long)noExisten.get(i));
			int param = ((Long)noExisten.get(i)).intValue();
			switch (param) {
				case 2:
					this.elimina("COMBO", "cbTipoCurso", "lblTipoCurso", false);
					break;
				case 3:
					this.elimina("TEXT", "txtNombreCurso", "lblNombreCurso", false);
					break;
				case 4:
					this.elimina("TEXT", "txtObjetivoCurso", "lblObjetivoCurso", true);
					break;
				case 5:
					this.elimina("TEXT", "txtContenidoCurso", "lblContenidoCurso", false);
					break;
				case 7:
					this.elimina("RADIOB", "rbAccesoSeleccion", "lblAccesoSeleccion", false);
					break;
				/*case 8:
					this.elimina("TEXT", "txtPath", "lblPath", false);
					break;*/
				case 9:
					this.elimina("COMBO", "cbFrecuenciaDictado", "lblFrecuenciaDictado", true);
					break;
				case 10:
					this.elimina("TEXT", "txtFechaDisponible", "lblFechaDisponible", true);
					break;
				case 11:
					this.elimina("TEXT", "txtFechaLanzamiento", "lblFechaLanzamiento", true);
					break;
				case 12:
					this.elimina("TEXT", "txtFechaFinalizacion", "lblFechaFinalizacion", false);
					break;
				case 13:
					this.elimina("RADIOB", "rbAlcanceGeoNacional", "lblAlcanceGeoNacional", false);
					break;
				case 14:
					this.elimina("COMBO", "cbSubVentas", "lblSubVentas", false);
					break;
				case 15:
					this.elimina("COMBO", "cbRegion", "lblRegion", true);
					break;
				case 16:
					this.elimina("COMBO", "cbZona", "lblZona", false);
					break;
				case 17:
					this.elimina("COMBO", "cbSeccion", "lblSeccion", true);
					break;
				case 18:
					this.elimina("COMBO", "cbTerritorio", "lblTerritorio", false);
					break;
				case 19:
					this.elimina("TEXT", "txtOptimoParticipantes", "lblOptimoParticipantes", true);
					break;
				case 20:
					this.elimina("COMBO", "cbTipoCliente", "lblTipoCliente", false);
					break;
				case 21:
					this.elimina("RADIOB", "rbBloqueo", "lblBloqueo", true);
					break;
				case 22:
					this.elimina("COMBO", "cbCapacitador", "lblCapacitador", false);
					break;
				case 23:
					this.elimina("TEXT", "txtMaterialAEmplear", "lblMaterialAEmplear", false);
					break;
				case 24:
					this.elimina("COMBO", "cbSubtipoCliente", "lblSubtipoCliente", false);
					break;
				case 25:
					this.elimina("COMBO", "cbClasificacion", "lblClasificacion", false);
					break;
				case 26:
					this.elimina("COMBO", "cbTipoClasificacion", "lblTipoClasificacion", true);
					break;
				case 27:
					this.elimina("COMBO", "cbEstatusCli", "lblEstatusCli", false);
					break;
				case 28:
					this.elimina("COMBO", "cbCursosExigidos", "lblEstatusCursos", true);
					break;
				case 29:
					this.elimina("TEXT", "txtNOrdenes", "lblNOrdenes", true);
					break;
				case 30:
					this.elimina("COMBO", "cbPerConstInicio", "lblPerConstInicio", true);
					break;
				case 31:
					this.elimina("COMBO", "cbPerConstFin", "lblPerConstFin", false);
					break;
				case 32:
					this.elimina("TEXT", "txtMontoVentasComp", "lblMontoVentasComp", true);
					break;
				case 33:
					this.elimina("COMBO", "cbPerVentInicio", "lblPerVentInicio", true);
					break;
				case 34:
					this.elimina("COMBO", "cbPerVentFin", "lblPerVentFin", false);
					break;
				case 35:
					this.elimina("COMBO", "cbPerIngresoCondicion", "lblPerIngresoCondicion", true);
					break;
				case 36:
					this.elimina("TEXT", "txtFechaIngresoCondicion", "lblFechaIngresoCondicion", true);
					break;
				case 37:
					this.elimina("TEXT", "txtNPeriodosCondicion", "lblNPeriodosCondicion", false);
					break;
				case 38:
					this.elimina("TEXT", "txtFechaUltimo", "lblFechaUltimo", false);
					break;
				case 39:
					this.elimina("COMBO", "cbProductoAEntregar", "lblProductoAEntregar", true);
					break;
				case 40:
					this.elimina("TEXT", "txtUniRegalo", "lblUniRegalo", true);
					break;
				case 41:
					this.elimina("COMBO", "cbMomentoEntrega", "lblMomentoEntrega", false);
					break;
				case 42:
					this.elimina("RADIOB", "rbCondicionPedido", "lblCondicionPedido", true);
					break;
				case 43:
					this.elimina("RADIOB", "rbControlMorosidad", "lblControlMorosidad", true);
					break;
				case 44:
					this.elimina("AREATEXTO", "areaDescDetallada", "lblDescDetallada", false);
					break;
			}
		}
           
		eliminaNodos(noExisten);   
		obtieneUltimo(activos);                      
	}

	// Elimina de la página el componente y su literal, y la imagen espaciadora si es preciso
	private void elimina(String tipo, String nombre, String literal, boolean eliminaEspacio) throws Exception {
		//hacer invisible
		borrarNodo(tipo, nombre);
		borrarNodo("LABELC", literal);
		if (eliminaEspacio) {
			borrarNodo("IMG", nombre + "I");
			borrarNodo("IMG", literal + "I");
		}
	}
      
	//Eliminar las filas o bloques de informacion si los componentes que incluyen no son visibles
	private void eliminaNodos(Vector noExisten)  throws Exception {
		//Datos Generales, siempre aparecerán las líneas 1, 2 y 3
		//linea 4
		/*if (noExisten.contains(new Long(8))) {
			borrarNodo("table", "nodoDatosGenerales4");
		}*/

		//linea 5
		if (noExisten.contains(new Long(9)) && noExisten.contains(new Long(10)) && noExisten.contains(new Long(11)) && noExisten.contains(new Long(12))) { 
			borrarNodo("table", "nodoDatosGenerales5");
		}
                      
		//Datos Geograficos
		//linea 1 => no aparece ningún dato geofráfico
		if (noExisten.contains(new Long(13)) && noExisten.contains(new Long(14))) {
			borrarNodo("tr", "nodoDatosGeograficos");
			borrarNodo("tr", "nodoImagenDatosGeograficos");
		}
                      
		//linea 2
		if (noExisten.contains(new Long(15)) && noExisten.contains(new Long(16))) {
			borrarNodo("table", "nodoDatosGeograficos2");
		}
                           
		//linea 3
		if (noExisten.contains(new Long(17)) && noExisten.contains(new Long(18))) {
			borrarNodo("table", "nodoDatosGeograficos3");
		}

		//Datos Curso
		boolean apareceNodoDatosCurso = false;
		//linea 1
		if (noExisten.contains(new Long(19)) && noExisten.contains(new Long(21)) && noExisten.contains(new Long(23))) {
			borrarNodo("table", "nodoDatosCurso1");
		} else {
			apareceNodoDatosCurso = true;
		}
                           
		//linea 2
		if (noExisten.contains(new Long(22))) {
			borrarNodo("table", "nodoDatosCurso2");
		} else {
			apareceNodoDatosCurso = true;
		}
                           
		//linea 3
		if (noExisten.contains(new Long(28)) && noExisten.contains(new Long(38))) {
			borrarNodo("table", "nodoDatosCurso3");
		} else {
			apareceNodoDatosCurso = true;
		}
                           
		//linea 4
		if (noExisten.contains(new Long(42)) && noExisten.contains(new Long(43)) && noExisten.contains(new Long(44))) {
			borrarNodo("table", "nodoDatosCurso4");
		} else {
			apareceNodoDatosCurso = true;
		}
                      
		if (!apareceNodoDatosCurso) {
			borrarNodo("tr", "nodoDatosCurso");
			borrarNodo("tr", "nodoImagenDatosCurso");
		}
                                  

		//Clasificacion Cliente
		boolean apareceNodoClasificacionCliente = false;
		//linea 1
		if (noExisten.contains(new Long(20)) && noExisten.contains(new Long(24))) {
			borrarNodo("table", "nodoClasificacionCliente1");
		} else {
			apareceNodoClasificacionCliente = true;
		}
                           
		//linea 2
		if (noExisten.contains(new Long(25)) && noExisten.contains(new Long(26))) {
			borrarNodo("table", "nodoClasificacionCliente2");
		} else {
			apareceNodoClasificacionCliente = true;
		}                           
		//linea 3
		if (noExisten.contains(new Long(27))) {
			borrarNodo("table", "nodoClasificacionCliente3");
		} else {
			apareceNodoClasificacionCliente = true;
		}                           
		if (!apareceNodoClasificacionCliente) {
			borrarNodo("tr", "nodoClasificacionCliente");
			borrarNodo("tr", "nodoImagenClasificacionCliente");
		}
                           
                                  
		//Datos Constancia
		if (noExisten.contains(new Long(29)) && noExisten.contains(new Long(30)) && noExisten.contains(new Long(31))) {
			borrarNodo("tr", "nodoDatosConstancia");
			borrarNodo("tr", "nodoImagenDatosConstancia");
		}

		//Datos ventas
		if (noExisten.contains(new Long(32)) && noExisten.contains(new Long(33)) && noExisten.contains(new Long(34))) {
			borrarNodo("tr", "nodoDatosVentas");
			borrarNodo("tr", "nodoImagenDatosVentas");
		}
                           
		//Ingreso condicion
		if (noExisten.contains(new Long(35)) && noExisten.contains(new Long(36)) && noExisten.contains(new Long(37))) {
			borrarNodo("tr", "nodoCondicionIngreso");
			borrarNodo("tr", "nodoImagenCondicionIngreso");
		}
                                                      
		//Datos regalo
		if (noExisten.contains(new Long(39)) && noExisten.contains(new Long(40)) && noExisten.contains(new Long(41))) {
			borrarNodo("tr", "nodoDatosRegalo");
		}
	}
          
         
          
          
	/* Se asigna visibilidad, modificable y requerido
	 * Si es un combo el valor por defecto se asigna a un hidden, si no, se asigna al componente
	 */
	private void gestionaComponente(DTODetallePlantillaCurso detalle, String tipo, String nombre, String literal, Object valor) throws Exception {
		traza("********************************* gestionaComponente: " + nombre);
		if (!detalle.getVisible().booleanValue()){
			//hacer invisible
			borrarNodo(tipo, nombre);
			borrarNodo("LABELC", literal);
		} else {
			if (detalle.getObligatorio().booleanValue()) {
				//hacer Obligatorio
				asignarAtributo(tipo, nombre, "req", "S");
				asignar("VAR", nombre + "REQ", "S");
			}
			if (!detalle.getModificable().booleanValue() || casoUso.equals("consultar") || casoUso.equals("eliminar")) {
				//hacer no modificable
				asignarAtributoElemento( nombre, "disabled", "S");
				if (tipo.equals("COMBO"))
					asignar("VAR", nombre + "RO", "S");
			}
			if (!this.modoConsulta && detalle.getValor() != null) {
				if (tipo.equals("TEXT") || tipo.equals("AREATEXTO"))
					asignarAtributo(tipo, nombre, "valor", detalle.getValor());
				asignar("VAR", "h"+nombre, detalle.getValor());
                                         
			} else if (this.modoConsulta && valor != null){
				if (tipo.equals("TEXT") || tipo.equals("AREATEXTO"))
					asignarAtributo(tipo, nombre, "valor", valor.toString());
				asignar("VAR", "h"+nombre, valor.toString());
			}
		}
		traza("********************************* gestionaComponente FIN: " + nombre);
	}

	/* Se asigna visibilidad, modificable y requerido
	 * Si no es un combo el valor por defecto se asigna al componente
	 */
	private void gestionaComponenteMonto(DTODetallePlantillaCurso detalle, String tipo, String nombre, String literal, Object valor) throws Exception {
		traza("********************************* gestionaMonto: ");
		if (!detalle.getVisible().booleanValue()){
			//hacer invisible
			borrarNodo(tipo, nombre);
			borrarNodo("LABELC", literal);
		} else {
			if (detalle.getObligatorio().booleanValue()) {
				//hacer Obligatorio
				asignarAtributo(tipo, nombre, "req", "S");
				asignar("VAR", nombre + "REQ", "S");
			}
			if (!detalle.getModificable().booleanValue() || casoUso.equals("consultar") || casoUso.equals("eliminar")) {
				//hacer no modificable
				asignarAtributoElemento(nombre, "disabled", "S");
			}
			if (!this.modoConsulta && detalle.getValor() != null) {
				String montoFormateado = formateaMonto(detalle.getValor());
				if (tipo.equals("TEXT") || tipo.equals("AREATEXTO"))
					asignarAtributo(tipo, nombre, "valor", montoFormateado );
				asignar("VAR", "h"+nombre, montoFormateado);
                                         
			} else if (this.modoConsulta && valor != null){
				String montoFormateado = formateaMonto(valor.toString());

				if (tipo.equals("TEXT") || tipo.equals("AREATEXTO"))
					asignarAtributo(tipo, nombre, "valor", montoFormateado);
				asignar("VAR", "h"+nombre, montoFormateado);
			}
		}
		traza("********************************* gestionaMonto FIN: ");
	}


	/* Se asigna visibilidad, modificable y requerido y los valores a seleccionar se guardan en un hidden
	 * combo multiple de cursos
	 * 15/02/2006 [1] pperanzola se modifica porque se ha tocado en el DTOCurso el atributo CursosRecibidos por CursosExigidos
	 *				  y faltaba actualizarlo en la LP
	 */
	private void gestionaCursos(RecordSet datos, DTODetallePlantillaCurso detalle, String nombre, String literal) throws Exception {
		traza("********************************* gestionaCcursos: ");
		if (!detalle.getVisible().booleanValue()){
			//hacer invisible
			borrarNodo("COMBO", nombre);
			borrarNodo("LABELC", literal);
		} else {
			if (detalle.getObligatorio().booleanValue()) {
				//hacer Obligatorio
				asignarAtributo("COMBO", nombre, "req", "S");
				asignar("VAR", nombre + "REQ", "S");
			}
			/*if (!detalle.getModificable().booleanValue()) {
				//hacer no modificable
				//asignarAtributoElemento(nombre, "readonly", "S");
				//asignar("VAR", nombre + "RO", "S");
			}*/
			RecordSet recordset = datos;
			if (casoUso.equals("consultar") || casoUso.equals("eliminar")) {
        		// Se eliminan las filas del recordset cuyo oid no está en valor
				recordset = new RecordSet();
				        
        		if (datos != null && !datos.esVacio() && curso.getCursosExigidos() != null && curso.getCursosExigidos().length > 0) {//[1]
					
					recordset.setColumnIdentifiers(datos.getColumnIdentifiers());
            		/*for (int i=0; i < recordsetOrigen.getColumnCount(); i++) {
               	 	recordsetDestino.addColumn(recordsetOrigen.getColumnName(i));    
            		}*/
            
            		for (int i = 0; i < datos.getRowCount(); i++) {
                		Vector fila = datos.getRow(i);
                		Long oid = new Long(((BigDecimal)fila.elementAt(0)).longValue());
                
                		for (int j = 0; j < curso.getCursosExigidos().length; j++) { //[1]
                			//si el curso de la fila actual esta contenido en valor pasa a ser una opcion del combo, en caso contrario no
                			if (oid.longValue() == curso.getCursosExigidos()[j].longValue()) {//[1]
                				recordset.addRow(fila);
                				break;
                			}
                		}
            		}   
        		} 
			}

			if (recordset != null && !recordset.esVacio()) {
				Vector cols = recordset.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", recordset, cols);
				asignar("COMBO", nombre, conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			if (!this.modoConsulta && detalle.getCursosRequisito() != null && detalle.getCursosRequisito().length > 0) {
				//El valor se guarda en un hidden para seleccionarlo mediante javascript
				asignar("VAR", "h"+nombre, obtieneCadenaCursos(detalle.getCursosRequisito()).toString());
			} else if (this.modoConsulta && curso.getCursosExigidos() != null && curso.getCursosExigidos().length > 0) {//[1]
				asignar("VAR", "h"+nombre, obtieneCadenaCursos(curso.getCursosExigidos()).toString()); //[1]
			}
		}
		traza("********************************* gestionaCcursos FIN: ");
	}
	
	/* Se forma la cadena con los valores a seleccionar en el combo multiple de cursos
	 */
	private StringBuffer obtieneCadenaCursos(Long cursosRecibidos[]) throws Exception {
		StringBuffer cursos = new StringBuffer("");
		if (cursosRecibidos != null) {
			for (int i = 0; i < cursosRecibidos.length; i++)
				cursos.append(cursosRecibidos[i].toString() + "|");
			if (cursos.length() > 0) //aunque no venga null la longitud puede ser 0
				cursos.deleteCharAt(cursos.length() - 1);
		}
		return cursos;
	}

          
          
	/* Se asigna visibilidad, modificable y requerido a un combo y opciones que incluirá
	* además se selecciona la opción correspondiente al valor del detalle o el propio del curso
	*/
	private void gestionaCombo(RecordSet recordset, String nombre, String literal, DTODetallePlantillaCurso detalle, Object valor, boolean dependiente) throws Exception {
		traza("********************************* gestionaCombo: " + nombre);
		traza("********************************* gestionaCombo: " + recordset);
			if (!detalle.getVisible().booleanValue()){
				//hacer invisible
				borrarNodo("COMBO", nombre);
				borrarNodo("LABELC", literal);
			} else {
				if (detalle.getObligatorio().booleanValue()) {
					//hacer Obligatorio
					asignarAtributo("COMBO", nombre, "req", "S");
					asignar("VAR", nombre + "REQ", "S");
				}
				if (!detalle.getModificable().booleanValue() || casoUso.equals("consultar") || casoUso.equals("eliminar")) {
					//hacer no modificable
					asignarAtributoElemento(nombre, "disabled", "S");
					if (dependiente)
						asignar("VAR", nombre + "RO", "S");

				}

				if (recordset != null && !recordset.esVacio()) {
					Vector cols = recordset.getColumnIdentifiers();
					String selec = detalle.getValor(); //para insercion de curso (modoconsulta false)
					if (this.modoConsulta && valor != null) selec = valor.toString(); //para modificacion curso
					DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", recordset, cols);
					if (selec != null) {
						asignar("COMBO", nombre, conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), selec);
						asignar("VAR", "h"+nombre, selec);
					} else {
						asignar("COMBO", nombre, conectorCargaCombo, "DTOSalida.combo_ROWSET");
					}
				} 
			}
		traza("********************************* gestionaCombo FIN: " + nombre);
	}

	/* Se asigna visibilidad, modificable y requerido a un combo y opciones que incluirá
	* además se selecciona la opción correspondiente al valor del detalle o el propio del curso
	*/
	private void gestionaPeriodos(DruidaConector conectorCargaCombo, String columna, String nombre, String literal, DTODetallePlantillaCurso detalle, Object valor) throws Exception {
		traza("********************************* gestionaPeriodos: " + nombre);
			if (!detalle.getVisible().booleanValue()){
				//hacer invisible
				borrarNodo("COMBO", nombre);
				borrarNodo("LABELC", literal);
			} else {
				if (detalle.getObligatorio().booleanValue()) {
					//hacer Obligatorio
					asignarAtributo("COMBO", nombre, "req", "S");
					asignar("VAR", nombre + "REQ", "S");
				}
				if (!detalle.getModificable().booleanValue() || casoUso.equals("consultar") || casoUso.equals("eliminar")) {
					//hacer no modificable
					asignarAtributoElemento(nombre, "disabled", "S");
					asignar("VAR", nombre + "RO", "S");
				}

				if (conectorCargaCombo != null) {
					String selec = detalle.getValor(); //para insercion de curso (modoconsulta false)
					if (this.modoConsulta && valor != null) selec = valor.toString(); //para modificacion curso
					if (selec != null) {
						asignar("COMBO", nombre, conectorCargaCombo, "DTOSalida.combo_ROWSET", columna, selec);
						asignar("VAR", "h"+nombre, selec);
					} else {
						asignar("COMBO", nombre, conectorCargaCombo, "DTOSalida.combo_ROWSET");
					}
				} 
			}
		traza("********************************* gestionaPeriodos FIN: " + nombre);
	}

	// Devuelve cadena de fecha conforme al formato que está en sesion
	private String obtieneCadenaFecha(java.sql.Date valor) throws Exception {
		String fecha = new String("");
		if (valor != null) {
			fecha = UtilidadesBelcorp.fechaFormateada(valor, UtilidadesSession.getFormatoFecha(this));
		}
		
		return fecha;
	}

          
	// devolvemos S/N correspondiente al valor del Boolean
	private String obtieneCadenaBoolean(Boolean valor) {
		if (valor != null) {
			if (valor.booleanValue()) {
				return new String("S");
			} else {
				return new String("N");
			}
		}
		
		return new String("");
	}
         
         
	protected String toString(Boolean bool) {
		String resultado = "N";
		if (bool != null && bool.booleanValue()) {
			resultado = "S";
		}
                    
		return  resultado;
	}
          
	protected Boolean toBoolean(String str) {
		Boolean resultado = new Boolean(false);
		if (str != null && str.equalsIgnoreCase("S")) {
			resultado = new Boolean(true);
		}
                    
		return resultado;
	}  
         
	protected void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
                  
		traza("Stack Trace: " + baos.toString());
	}
         
	// determina cual el es ultimo elemento del formulario y asigna el atributo tab y onShtab correspondientes
	private void obtieneUltimo(Vector activos) throws Exception {
		                                 
		HashMap nombresCajas = new HashMap();
		nombresCajas.put("0", "cbMarca");
		nombresCajas.put("1", "cbCanal");
		nombresCajas.put("2", "cbTipoCurso");
		nombresCajas.put("3", "txtNombreCurso");
		nombresCajas.put("4", "txtObjetivoCurso");
		nombresCajas.put("5", "txtContenidoCurso");
		nombresCajas.put("6", "cbAccesoInfo");
		nombresCajas.put("7", "rbAccesoSeleccion");
		//nombresCajas.put("8", "txtPath");
		nombresCajas.put("9", "cbFrecuenciaDictado");
		nombresCajas.put("10", "txtFechaDisponible");
		nombresCajas.put("11", "txtFechaLanzamiento");
		nombresCajas.put("12", "txtFechaFinalizacion");
		nombresCajas.put("13", "rbAlcanceGeoNacional");
		nombresCajas.put("14", "cbSubVentas");
		nombresCajas.put("15", "cbRegion");
		nombresCajas.put("16", "cbZona");
		nombresCajas.put("17", "cbSeccion");
		nombresCajas.put("18", "cbTerritorio");
		nombresCajas.put("19", "txtOptimoParticipantes");
		nombresCajas.put("20", "cbTipoCliente");
		nombresCajas.put("21", "rbBloqueo");
		nombresCajas.put("22", "cbCapacitador");
		nombresCajas.put("23", "txtMaterialAEmplear");
		nombresCajas.put("24", "cbSubtipoCliente");
		nombresCajas.put("25", "cbClasificacion");
		nombresCajas.put("26", "cbTipoClasificacion");
		nombresCajas.put("27", "cbEstatusCli");
		nombresCajas.put("28", "cbCursosExigidos");
		nombresCajas.put("29", "txtNOrdenes");
		nombresCajas.put("30", "cbPerConstInicio");
		nombresCajas.put("31", "cbPerConstFin");
		nombresCajas.put("32", "txtMontoVentasComp");
		nombresCajas.put("33", "cbPerVentInicio");
		nombresCajas.put("34", "cbPerVentFin");
		nombresCajas.put("35", "cbPerIngresoCondicion");
		nombresCajas.put("36", "txtFechaIngresoCondicion");
		nombresCajas.put("37", "txtNPeriodosCondicion");
		nombresCajas.put("38", "txtFechaUltimo");
		nombresCajas.put("39", "cbProductoAEntregar");
		nombresCajas.put("40", "txtUniRegalo");
		nombresCajas.put("41", "cbMomentoEntrega");
		nombresCajas.put("42", "rbCondicionPedido");
		nombresCajas.put("43", "rbControlMorosidad");
		nombresCajas.put("44", "areaDescDetallada");

		String ultimo = "";
		if(activos.size() > 0)
			ultimo = (String)nombresCajas.get(((Long)activos.lastElement()).toString());
		asignar("VAR", "ultimo", ultimo);

		traza("******************** ultimo " + ultimo);
		String primero = "";
		if(activos.size() > 0)
			primero = (String)nombresCajas.get(((Long)activos.firstElement()).toString());
		traza("******************** primero " + primero);
		asignar("VAR", "primero", primero);
                         
		if (ultimo.equals("cbSubVentas") || ultimo.equals("cbRegion") || ultimo.equals("cbZona") || ultimo.equals("cbSeccion") || ultimo.equals("cbTerritorio")) {
			asignarAtributoElemento("rbAlcanceGeoNacional",  "ontab", "focalizaRBAlcanceTab();" );
		}
		asignarAtributoElemento(primero,  "onshtab", "focalizaUltimo();" );
		asignarAtributoElemento(ultimo,  "ontab", "focalizaPrimero();" );
	}
					
	private String formateaMonto(String dineroEntrada){
		String separadorMiles = ",";
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
		if (separadorDecimales.equals(",")) separadorMiles=".";
		
		StringTokenizer tokens=new StringTokenizer(dineroEntrada, ".");
		StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
		StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
		StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
		
		//Si ya contiene los separadores de mil no formateamos la cadena
		for (int i=0; i<bufferEntero.length(); i++) {
			if (bufferEntero.charAt(i) == separadorMiles.charAt(0)) return dineroEntrada;
		}
		int miles=0;
		while (bufferEntero.length()>0) {
			miles++;
			bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
			bufferEntero.deleteCharAt(bufferEntero.length()-1);
			if (miles==3 && bufferEntero.length()>0) {
				miles=0;
				bufferDinero.insert(0, separadorMiles);
			}
		}

		if (numeroDecimales != null && tokens.hasMoreTokens()) { 
			bufferDecimales.append(tokens.nextToken());
			//Scale siempre vendrá a 00? //creo que en plantillas puede ser de longitud 0
			if (!bufferDecimales.substring(0, bufferDecimales.length()).equals("00") && !bufferDecimales.substring(0, bufferDecimales.length()).equals("0")) {
				if (numeroDecimales.equals("1")) 
					bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
				else if (numeroDecimales.equals("2")) {
					if (bufferDecimales.length() == 2) 
						bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 2));
					else if (bufferDecimales.length() == 1)
						bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 1) + "0");
				}

			}
		}		
		
		
		return bufferDinero.toString();

	}

	
	   
}