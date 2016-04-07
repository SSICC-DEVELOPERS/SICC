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
 
import java.util.HashMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
 
public class LPInsertaPlantilla extends LPSICCBase 
{
 	// Nombres de los campos de la página
    private static String nombresCampos[] = {"Marca", "Canal", "TipoCurso", "NombreCurso",
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
        	
    private static final String FORMULARIO = "frmInsertarPlantilla";
    private static final String NOMBRE_PLANTILLA = "txtNombrePlantilla";
    private static final String CABECERA_PLANTILLA = "EDU_PLANT_CURSO_CABEC";
    private static final String PLANTILLA_XSL = "contenido_plantilla_cursos_insertar";
        
    public LPInsertaPlantilla() {
 		super();
 	}
 	
 	public void inicio() throws Exception {
    	pagina("contenido_plantilla_cursos_insertar");    
    }
    
	public void ejecucion() throws Exception {
		rastreo();
		setTrazaFichero();
        traza("*** Entrada - LPInsertaPlantilla - ejecucion ***");
        
		// Dependiendo del valor del parámetro accion, se
		// invoca al método adecuado
        try {
            String accion  = conectorParametroLimpia("accion","",true);
            traza("accion = "+accion);
            
            if (accion.equals("")) {
                this.cargaPagina();
            } else if (accion.equalsIgnoreCase("guardar")) {
                this.insertaPlantilla();
            }
        } catch (Exception e) {
        	logStackTrace(e);
            lanzarPaginaError(e);
        }
        
        traza("*** Salida - LPInsertaPlantilla - ejecucion ***");
	}
	
	private void cargaPagina() throws Exception {
		traza("*** Entrada - LPInsertaPlantilla - cargaPagina ***");
		
        // Se obtiene la sesión
        UtilidadesSession session = new UtilidadesSession();
        
		// Se instancia un DTOBelcorp y se rellena 
		// con el oid del país y el idioma del usuario
		Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(pais);
        dtoBelcorp.setOidIdioma(idioma);
        
        // Se invoca al conector ConectorCargaPlantilla 
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoBelcorp);
        paramEntrada.add(new MareBusinessID("EDUCargaPlantilla"));
        DruidaConector conectorCargaPlantilla = null;
        conectorCargaPlantilla = conectar("ConectorCargaPlantilla",paramEntrada);
        
        // Se obtiene el DTO devuelto por el conector
        DTOCargaCursos dtoCargaCursos = (DTOCargaCursos)conectorCargaPlantilla.objeto("DTOCargaCursos");
               
        // Se almacena en sesión los oids de los parámetros
        RecordSet rsParametros = dtoCargaCursos.getParametros();
        Vector oidsParametros = rsParametros.getColumn(0);
        conectorParametroSesion("oidsParametros", oidsParametros);
        
        // Se genera dinámicamente la página en función de los parámetros
        this.generaPaginaDinamica(rsParametros);
        
        // Se cargan los combos de la página
        this.cargaCombos(dtoCargaCursos);
        
        // Asigna a campos hidden el idioma, el pais, caso de uso y código de título
        // de la página
        asignarAtributo("VAR","idioma","valor",idioma.toString());
        asignarAtributo("VAR","pais","valor",pais.toString());
        asignarAtributo("VAR","casoUso","valor","insertar");
        asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","cod","0462");
        
        // Asigna valores a campos hidden para realizar la validacion de 
        // números con formato de miles y decimales
        asignaHiddensValidacion();
       
        // Añade campos hiddens para la internacionalización del nombre de
        // la plantilla
		anyadeHiddensI18N(true,CABECERA_PLANTILLA,null,new Integer(1),FORMULARIO,
			NOMBRE_PLANTILLA,false);
        
        // Genera un campo oculto que contiene el formato de fecha
        generarHiddenFormatoFecha();

        // Muestra el menú secundario
        getConfiguracionMenu("LPInsertaPlantilla","");
        
        traza("*** Salida - LPInsertaPlantilla - cargaPagina ***");
	}
	
	private void generaPaginaDinamica(RecordSet rsParametros) throws Exception {
		traza("*** Entrada - LPInsertaPlantilla - generaPaginaDinamica ***");
		
		// Se genera un conector a partir del RecordSet
        Vector cols = rsParametros.getColumnIdentifiers();
        DruidaConector conectorParametros = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.parametros",rsParametros,cols);

		traza("*** Salida - LPInsertaPlantilla - CONECTOR ***", conectorParametros);
		
        
        // Se llama a la función transformar para generar dinamicamente la página,
        // aplicando la plantilla xsl
        DruidaConector conectorTransforma = transformar(PLANTILLA_XSL,conectorParametros);
        traza("XML Generado: ",conectorTransforma);    
        
        // Sustituye el tag <CAMBIATODO> de la página por las etiquetas druida 
        // contenidas en el conector conectorTransforma, y que son resultado de aplicar
        // la plantilla xsl 
        asignar("CAMBIATODO","cambiaTodo",conectorTransforma);
		
		traza("*** Salida - LPInsertaPlantilla - generaPaginaDinamica ***");
	}
	
	private void cargaCombos(DTOCargaCursos dtoCargaCursos) throws Exception {
		traza("*** Entrada - LPInsertaPlantilla - cargaCombos ***");
		
		// Se obtienen los RecordSet del DTO
		RecordSet rsMarcas = dtoCargaCursos.getMarcas();
        RecordSet rsCanales = dtoCargaCursos.getCanales();
        RecordSet rsTiposClientes = dtoCargaCursos.getTiposCliente();
        RecordSet rsEstatusClientes = dtoCargaCursos.getStatusClientes();
        RecordSet rsRegalos = dtoCargaCursos.getRegalos();
        RecordSet rsFrecuenciasCursos = dtoCargaCursos.getFrecuenciasCursos();
		RecordSet rsMomentoEntrega = dtoCargaCursos.getMomentoEntrega();
        
        // Se cargan los combos de marca, canal, tipo de cliente, 
        // estatus de cliente, producto y frecuencia de dictado. Para ello se
        // genera un conector a partir del recordset y se llama a asignar
        Vector cols = rsMarcas.getColumnIdentifiers();
        DruidaConector conectorMarcas = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.marcas",rsMarcas,cols);
        asignar("COMBO","ValorMarca",conectorMarcas, "DTOCargaCursos.marcas");
        
        cols = rsCanales.getColumnIdentifiers();
        DruidaConector conectorCanales = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.canales",rsCanales,cols);
        asignar("COMBO","ValorCanal",conectorCanales,"DTOCargaCursos.canales");
        
        cols = rsTiposClientes.getColumnIdentifiers();
        DruidaConector conectorTiposClientes = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.tiposClientes",rsTiposClientes,cols);
        asignar("COMBO", "ValorTipoCliente", conectorTiposClientes, "DTOCargaCursos.tiposClientes");
        
        cols = rsEstatusClientes.getColumnIdentifiers();
        DruidaConector conectorEstatusClientes = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.estatusClientes",rsEstatusClientes,cols);
        asignar("COMBO", "ValorStatusCliente", conectorEstatusClientes, "DTOCargaCursos.estatusClientes");
        
        cols = rsRegalos.getColumnIdentifiers();
        DruidaConector conectorRegalos = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.regalos",rsRegalos,cols);
        asignar("COMBO", "ValorProductoEntregar", conectorRegalos, "DTOCargaCursos.regalos");
        
        cols = rsFrecuenciasCursos.getColumnIdentifiers();
        DruidaConector conectorFrecuenciasCursos = UtilidadesBelcorp.generarConector(
            "DTOCargaCursos.frecuenciasCursos",rsFrecuenciasCursos,cols);
        asignar("COMBO", "ValorFrecuenciaDictado", conectorFrecuenciasCursos, "DTOCargaCursos.frecuenciasCursos");

 		if (rsMomentoEntrega != null) {
        	cols = rsMomentoEntrega.getColumnIdentifiers();
        	DruidaConector conectorMomentoEntrega = UtilidadesBelcorp.generarConector("DTOCargaCursos.momentoEntrega", rsMomentoEntrega, cols);
        	asignar("COMBO", "ValorMomentoEntregar", conectorMomentoEntrega, "DTOCargaCursos.momentoEntrega");
    	}
        
        traza("*** Salida - LPInsertaPlantilla - cargaCombos ***");
	}
	
	private void insertaPlantilla() throws Exception {
		traza("*** Entrada - LPInsertaPlantilla - insertaPlantilla ***");
		
        // Se obtienen los parametros
        HashMap parametrosPagina = conectorParametro();
		traza("parametrosPagina: " + parametrosPagina);
        
        // Se obtienen los oids de los parámetros de sesion
        Vector oidsParametros = (Vector)conectorParametroSesion("oidsParametros");
        		
        // Se rellenan los detalles de la plantilla
        ArrayList detalles = new ArrayList();
        
        int j=0;
        for (int i=0; i < nombresCampos.length; i++) {

			traza("SCS#, el campo que estoy viendo, es: " + nombresCampos[i]);

        	String strVisible = (String)parametrosPagina.get("Visible"+nombresCampos[i]);
        	if (strVisible != null) {
	        	String strObligatorio = (String)parametrosPagina.get("Obligatorio"+nombresCampos[i]);
	        	String strModificable = (String)parametrosPagina.get("Modificable"+nombresCampos[i]);
	        	String valor = (String)parametrosPagina.get("h"+nombresCampos[i]);

	        	// Se obtiene el oid del parametro correspondiente al detalle actual
	        	Long oidParametro = new Long(((BigDecimal)oidsParametros.elementAt(j)).longValue());
	        	j++;
	                    
	        	Boolean visible = this.toBoolean(strVisible);
	        	Boolean obligatorio = this.toBoolean(strObligatorio);
	        	Boolean modificable = this.toBoolean(strModificable);
                
                // Si el campo es Status de Cursos exigidos, se almacenan los oids y los nombres de
                // los cursos en dos arrays    
	        	Long cursosRequisito[] = null;
	        	String nombresCursoRequisito[] = null;
	        	if (nombresCampos[i].equals("StatusCursosExigidos") && !valor.equals("")) {
                        
					traza("SCS########, viendo: StatusCursosExigidos");
					traza("SCS#, valor, es: " + valor);

	        		// Se obtienen los oids de los cursos requeridos
	        		StringTokenizer st = new StringTokenizer(valor,"|");
	        		cursosRequisito = new Long[st.countTokens()];
					String valorCampo = new String();
	        		int k = 0;
	        		while (st.hasMoreElements()) {
						valorCampo = st.nextToken();
						traza("SCS#, valorCampo, es: " + valorCampo);
	        			cursosRequisito[k++] = new Long(valorCampo);
	        		}
	        		
	        		// Se obtienen los nombres de los cursos requeridos
	        		String nombresCursos = (String)parametrosPagina.get("nombresCursos");
					traza("SCS#, nombresCursos, es: " + nombresCursos);
	        		st = new StringTokenizer(nombresCursos,"|");
	        		nombresCursoRequisito = new String[st.countTokens()];
	        		k = 0;
	        		while (st.hasMoreElements()) {
	        			nombresCursoRequisito[k++] = st.nextToken();
	        		}

					// Se pone en blanco el atributo "valor" pues estos datos se pasan al atributo CursosRequisito
					valor = null;
					traza("SCS#, ahora el valor es null pues esta informacion va a una entidad luego.");
				}
	        	
	        	// Si el campo es Monto, se quita el separador de miles
	        	if (nombresCampos[i].equals("Monto") && !valor.equals("")) {
	        		String monto = quitaSeparadorMiles(valor);
	        		valor = new String(monto);
	        	}
        	
        		// Se rellena el DTO de detalle
	        	DTOParametro dtoParametro = new DTOParametro();
	        	dtoParametro.setOid(oidParametro);
	                    
	        	DTODetallePlantillaCurso dtoDetalle = new DTODetallePlantillaCurso();
	        	dtoDetalle.setValor(valor);
	        	dtoDetalle.setVisible(visible);
	        	dtoDetalle.setObligatorio(obligatorio);
	        	dtoDetalle.setModificable(modificable);
	        	dtoDetalle.setParametro(dtoParametro);
	        	dtoDetalle.setCursosRequisito(cursosRequisito);
	        	dtoDetalle.setNombresCursoRequisito(nombresCursoRequisito);
        		
	        	/*traza("Nombre campo: "+nombresCampos[i]);
	        	traza("\tVisible: "+strVisible);
	        	traza("\tModificable: "+strModificable);
	            traza("\tObligatorio: "+strObligatorio);
	            String strValor = (valor != null) ? valor : "null";
	            traza("\tValor: "+ strValor);
	            traza("\toidParametro: "+ oidParametro);
	            traza("\n");*/
	                
	        	// Se añade a la lista de detalles

				traza("SCS##, el detalle que voy a insertar, es: " + dtoDetalle);

	        	detalles.add(dtoDetalle);
        	}
        }
        
        UtilidadesSession session = new UtilidadesSession();
		Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        
        // Se rellena el DTO de plantilla   
        DTOPlantillaCurso dtoPlantilla = new DTOPlantillaCurso();
        dtoPlantilla.setOidPais(pais);
        dtoPlantilla.setOidIdioma(idioma);
        dtoPlantilla.setDetalles(detalles);
        
        // Se almacena el atributo traducible, que es el nombre de la plantilla
        DTOI18nSICC attriTraducible[] = this.rellenaAtributoTraducible(new Integer(1));
    	dtoPlantilla.setAttriTraducible(attriTraducible);

  		// Se redirige hacia una página genérica de modo que la página original
  		// no se recargue. Se asigna al hidden ejecutar la función Javascript que se 
  		// debe ejecutar en la página original cuando la página genérica termine
    	pagina("salidaGenerica"); 
		asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar()");
               
        // Se invoca al conector ConectorEscribePlantilla 
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoPlantilla);
        paramEntrada.add(new MareBusinessID("EDUInsertaPlantilla"));
        DruidaConector conector = conectar("ConectorEscribePlantilla", paramEntrada);
                
        traza("*** Salida - LPInsertaPlantilla - insertaPlantilla ***");
	}
	
	private Boolean toBoolean(String str)
	{
		Boolean resultado = new Boolean(false);
		if (str != null && str.equalsIgnoreCase("S")) {
			resultado = new Boolean(true);
		}
		
		return resultado;
	}
	
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
	
	private DTOI18nSICC[] rellenaAtributoTraducible(Integer num) throws Exception {
		DTOI18nSICC attriTraducible[] = null;
        Vector traducciones = recuperaTraduccionesI18N(num);
        if (traducciones != null) {
        	attriTraducible = new DTOI18nSICC[traducciones.size()];
        	
        	int i = 0;
        	for (Enumeration e = traducciones.elements(); e.hasMoreElements(); i++) {
        		attriTraducible[i] = (DTOI18nSICC)e.nextElement();
        	} 
    	}
    	
    	return attriTraducible;
	}
	
	// Convierte un número con separador de miles en un numero normal
	private String quitaSeparadorMiles(String valor) {
		String resultado = "";
		String separadorMiles = ",";
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}

		if (valor != null) {
			// Quitar separador miles
			StringTokenizer st = new StringTokenizer(valor, separadorMiles);
			while (st.countTokens() > 0) {
				resultado += st.nextToken();
			}
			
			// Convertir separador decimal a '.' en caso de que el valor sea un número
			// decimal, ya que cuando se convierta a número espera un .
			if (separadorDecimales.equals(",")) {
				resultado.replace(',', '.' );
			}

			return resultado;
		} else {
			return null;
		}
	}
	
	private void asignaHiddensValidacion() throws Exception {
		// Campos hidden para realizar la validacion de números con formato de miles y decimales
		String formatoNumerico = UtilidadesSession.getFormatoNumerico(this);
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}
		
		asignarAtributo("VAR","hid_SeparadorMiles","valor",separadorMiles);
		asignarAtributo("VAR","hid_NumeroDecimales","valor",formatoNumerico);
		asignarAtributo("VAR","hid_SeparadorDecimales","valor",separadorDecimales);
	}
}