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
    $Id: LPModificaPlantilla.java,v 1.1 2009/12/03 18:36:17 pecbazalar Exp $
    DESC
*/
import java.util.HashMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Enumeration;
import java.math.BigDecimal;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;


public class LPModificaPlantilla extends LPUtilidadesEDU 
{	   
	private static final String FORMULARIO = "frmInsertarPlantilla";
    private static final String NOMBRE_PLANTILLA = "txtNombrePlantilla";
    private static final String CABECERA_PLANTILLA = "EDU_PLANT_CURSO_CABEC";
    
    public LPModificaPlantilla() {
    	super();
    }

    public void inicio() throws Exception {
        pagina("contenido_plantilla_cursos_modificar");
    }
 
    public void ejecucion() throws Exception {
    	rastreo();
        setTrazaFichero();
        traza("*** Entrada - LPModificaPlantilla - ejecucion ***");
        
        // Dependiendo del valor del parámetro accion, se
		// invoca al método adecuado
        String accion = "";
        try {
        	accion = conectorParametroLimpia("accion","",true);
        	traza("*** Parámetro accion : "+accion);
        	
        	if (accion.equals("")) {
        		this.cargaPagina();
        	} else if (accion.equalsIgnoreCase("modificar")) {
        		this.accionModificar();
    		} else if (accion.equalsIgnoreCase("guardar")) {
    			this.accionGuardar();
    		}
    	} catch (Exception e) {
    		logStackTrace(e);
    		lanzarPaginaError(e);
    	}
       
       	traza("*** Salida - LPModificaPlantilla - ejecucion ***");
    }
    
    private void cargaPagina() throws Exception {
		traza("*** Entrada - LPModificaPlantilla - cargaPagina ***");
		
		// Obtiene el idioma y pais de sesión
		UtilidadesSession session = new UtilidadesSession();
        Long idioma = session.getIdioma(this);
        Long pais = session.getPais(this);
		
		// Asigna a campos hidden el idioma, el pais, caso de uso y código de título
        // de la página
		asignarAtributo("VAR","idioma","valor",idioma.toString());
		asignarAtributo("VAR","pais","valor",pais.toString());
		asignarAtributo("VAR","casoUso","valor","modificar");
		asignarAtributo("PAGINA","contenido_plantilla_cursos_modificar","cod","0463");
		
		// Muestra el menú secundario
        getConfiguracionMenu("LPModificaPlantilla","");
		
		traza("*** Salida - LPModificaPlantilla - cargaPagina ***");
	}
    
    private void accionModificar() throws Exception {
        traza("*** Entrada - LPModificaPlantilla - accionModificar ***");
        
        // Se define la página que se va a mostrar
    	pagina("contenido_plantilla_cursos_insertar");
        
        // Obtiene el oid de la plantilla que se va a modificar
        String strOid = conectorParametroLimpia("oid","",true);
        Long oidPlantilla = null;
        if (!strOid.equals("")) {
        	oidPlantilla = new Long(strOid);
    	}
    	
    	// Se llama a obtieneDetallesPlantilla y muestraDetallesPlantilla, definidos 
    	// en la clase base LPUtilidadesEDU, para cargar la página con los datos de la
    	// plantilla seleccionada
    	DTOCargaCursos dtoCargaCursos = obtieneDetallesPlantilla(oidPlantilla);
    	muestraDetallesPlantilla(dtoCargaCursos, new Boolean(false));
    	
        // Asigna a campos hidden el idioma, pais y caso de uso y el título de 
        // la página
        UtilidadesSession session = new UtilidadesSession();
		Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        asignarAtributo("VAR","idioma","valor",idioma.toString());
        asignarAtributo("VAR","pais","valor",pais.toString());
        asignarAtributo("VAR","casoUso","valor","modificar");
        asignarAtributo("VAR","oidPlantilla","valor",oidPlantilla.toString());
        asignarAtributo("PAGINA","contenido_plantilla_cursos_insertar","cod","0463");
        
        // Asigna valores a campos hidden para realizar la validacion de 
        // números con formato de miles y decimales
        asignaHiddensValidacion();
        
        // Añade campos hiddens para la internacionalización del nombre de
        // la plantilla
		anyadeHiddensI18N(true,CABECERA_PLANTILLA,oidPlantilla,new Integer(1),FORMULARIO,
			NOMBRE_PLANTILLA,false);
        
        // Genera un campo oculto que contiene el formato de fecha
        generarHiddenFormatoFecha();

        // Muestra el menú secundario
        getConfiguracionMenu("LPModificaPlantilla","modificar");
        
        traza("*** Salida - LPModificaPlantilla - accionModificar ***");
    }
    
    private void accionGuardar() throws Exception {
        traza("*** Entrada - LPModificaPlantilla - accionGuardar ***");
        
        // Se obtienen los parametros
        HashMap parametrosPagina = conectorParametro();
        
        // Se obtienen los oids de los parámetros de sesion
        Vector oidsParametros = (Vector)conectorParametroSesion("oidsParametros");
        		
        // Se rellenan los detalles de la plantilla
        ArrayList detalles = new ArrayList();
        
        int j=0;
        for (int i=0; i < nombresCampos.length; i++) {
			traza("gg, el campo que estoy viendo, es: " + nombresCampos[i]);
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
                
                // Si el campo es Status de Cursos recibidos, se almacenan los oids y los nombres de
                // los cursos en dos arrays  
	        	Long cursosRequisito[] = null;
	        	String nombresCursoRequisito[] = null;
	        	if (nombresCampos[i].equals("StatusCursosExigidos") && !valor.equals("")) {
					traza("gg : StatusCursosExigidos valor: " + valor );
					// Se obtienen los oids de los cursos requeridos
	        		StringTokenizer st = new StringTokenizer(valor,"|");
	        		cursosRequisito = new Long[st.countTokens()];
	        		int k = 0;
	        		while (st.hasMoreElements()) {
	        			cursosRequisito[k++] = new Long(st.nextToken());
	        		}
	        		
	        		// Se obtienen los nombres de los cursos requeridos
	        		String nombresCursos = (String)parametrosPagina.get("nombresCursos");
	        		st = new StringTokenizer(nombresCursos,"|");
	        		nombresCursoRequisito = new String[st.countTokens()];
	        		k = 0;
	        		while (st.hasMoreElements()) {
	        			nombresCursoRequisito[k++] = st.nextToken();
	        		}
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
        
        String strOid = conectorParametroLimpia("oidPlantilla","",true);
        Long oidPlantilla = null;
        if (!strOid.equals("")) {
        	oidPlantilla = new Long(strOid);
    	}
    	dtoPlantilla.setOid(oidPlantilla);
        
        // Se almacena el atributo traducible, que es el nombre de la plantilla
        DTOI18nSICC attriTraducible[] = this.rellenaAtributoTraducible(new Integer(1));
    	dtoPlantilla.setAttriTraducible(attriTraducible);
    	
    	// Se redirige hacia una página genérica de modo que la página original
  		// no se recargue. Se asigna al hidden ejecutar la función Javascript que se 
  		// debe ejecutar en la página original cuando la página genérica termine
    	pagina("salidaGenerica"); 
		asignarAtributo("VAR", "cerrarVentana", "valor", "true");
        
        // Se invoca al conector ConectorEscribePlantilla 
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoPlantilla);
        paramEntrada.add(new MareBusinessID("EDUModificaPlantilla"));
        DruidaConector conector = conectar("ConectorEscribePlantilla", paramEntrada);
              
        traza("*** Salida - LPModificaPlantilla - accionGuardar ***");
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