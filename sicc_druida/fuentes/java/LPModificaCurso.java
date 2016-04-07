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
    $Id: LPModificaCurso.java,v 1.1 2009/12/03 18:38:13 pecbazalar Exp $
    DESC
*/
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
  
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTOCargaCursos;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;
import es.indra.sicc.dtos.edu.DTOCurso;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//***************
import java.util.Calendar;
import java.util.StringTokenizer;
//***************

// Definicion de la clase
public class LPModificaCurso extends LPUtilidadesEDU {
    // Definicion del constructor
    public LPModificaCurso() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

            // Defino el nombre de la vista
            pagina("contenido_cursos_modificar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    	rastreo();
    	try{
         	setTrazaFichero();
         	traza("***Entrada - LPModificaCurso - ejecucion***");
	          
         	String accion = conectorParametroLimpia("accion","",true);
         	traza("***accion : "+accion);
	          
          	//Bifurcamos la accion
          	if ( accion.equals("")) {
              		accionVacia();
          	}
          	if ( accion.equals("modificar")) {
              		accionModificar();
           		    this.generarHiddenFormatoFecha();
          	}
          	if ( accion.equals("guardar")) {
              		pagina("salidaGenerica");
                    asignarAtributo("VAR", "cerrarVentana", "valor", "true");
                    this.accionGuardar();
          	}
          	getConfiguracionMenu("LPModificaCurso",accion);
          	traza("***Salida - LPModificaCurso - ejecucion***");
 	}catch(Exception e){
 		logStackTrace(e);
       		lanzarPaginaError(e);
        }
    }
    
    private void accionVacia() throws Exception {
         //Quitamos la visivilidad a la lista y marcamos el caso de uso
         traza("***Entrada -  LPModificaCruso - accionVacia");
        
         //- Se crea una instancia DTOBelcorp y se rellena con los datos de sesión. 
         //Obtenemos el pais y el idioma de la sesion
         UtilidadesSession sesion = new UtilidadesSession();
         Long pais = sesion.getPais(this); 
         Long idioma = sesion.getIdioma(this);

         //Se instancia un DTOBelcorp
         DTOBelcorp dtoEntrada = new DTOBelcorp();
         dtoEntrada.setOidPais(pais);
         dtoEntrada.setOidIdioma(idioma);
                  
    	 //- Se crea idNegocio "EDUDatosConsultaCursos" 
         MareBusinessID idBussiness = new MareBusinessID("EDUDatosConsultaCursos");
         
         //Almacenamos los parametros de entrada
         Vector paramEntrada = new Vector();
         paramEntrada.addElement(dtoEntrada);
         paramEntrada.addElement(idBussiness);
        
         traza ("Llamo a conectar");
         
         //- Se invoca al ConectorObtieneDatosConsultaCursos 
         DruidaConector conector = conectar("ConectorObtieneDatosConsultaCursos", paramEntrada);
         
         //- Se obtiene un DTOCargaCursos relleno tan sólo con las marcas y los 
	     //canales y se mostrarán los mismos en el cmbMarcas y cmbCanales de PaginaEliminarCurso 
         DTOCargaCursos dtoSalida = (DTOCargaCursos) conector.objeto("DTOCargaCursos");
         
         // Se obtiene el DTO de salida DTOCargaCursos relleno 
         DTOCargaCursos dtoCargaCursos = (DTOCargaCursos)conector.objeto("DTOCargaCursos");
            
         // Se cargan los combos de marcas y canales 
         RecordSet rsMarcas = dtoCargaCursos.getMarcas();
         RecordSet rsCanales = dtoCargaCursos.getCanales();
         
         traza("Cargando combos ...");
         
         Vector cols = rsMarcas.getColumnIdentifiers();
         DruidaConector conectorMarcas = UtilidadesBelcorp.generarConector(
             "DTOCargaCursos.marcas",rsMarcas,cols);
         asignar("COMBO","cbMarca",conectorMarcas,"DTOCargaCursos.marcas");
         
         cols = rsCanales.getColumnIdentifiers();
         DruidaConector conectorCanales = UtilidadesBelcorp.generarConector(
             "DTOCargaCursos.canales",rsCanales,cols);
         asignar("COMBO","cbCanal",conectorCanales,"DTOCargaCursos.canales");
         
         traza("Combos cargados ...");
         
         asignarAtributo("VAR","idioma","valor",idioma.toString());
         asignarAtributo("VAR","casoUso","valor","modificar");
         asignarAtributo("PAGINA","contenido_cursos_modificar","cod","0466");
         traza("***Salida -  LPModificaCruso - accionVacia");
    }
    
    private void accionModificar() throws Exception {
         traza("***Entrada -  LPModificaCruso - accionModificar");
         // Defino el nombre de la vista
         pagina("contenido_cursos_insertar");
         //- Llamamos oid al oid del curso seleccionado y se invoca a 
	     //muestraDetalleCurso(obtieneDetallesCurso(oid), false); 
	     //- Nótese que ambos métodos están declarados en el padre LPUtilidadesEDU. 
	 	 String oid = conectorParametroLimpia("oid", "", true);
		 this.muestraDetallesCurso(this.obtieneDetallesCurso(new Long(oid)),new Boolean(true)); 
	 
		 //Rellena datos generales de la pagina
		 UtilidadesSession session = new UtilidadesSession();
         Long pais = session.getPais(this);
         Long idioma = session.getIdioma(this);
         asignarAtributo("VAR", "idioma", "valor", idioma.toString());
         asignarAtributo("VAR", "pais", "valor", pais.toString());
         asignarAtributo("VAR", "casoUso", "valor", "modificar");
         asignarAtributo("VAR", "oid", "valor", oid);

		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this); 
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) separadorMiles = "."; 
		asignar("VAR","hid_SeparadorMiles", separadorMiles); 
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);          
         
         this.generarHiddenFormatoFecha();
         anyadeHiddensI18N(true, "EDU_MATRI_CURSO", new Long(oid), new Integer(1), "formularioInsertarCurso", "txtNombreCurso", false); 
	 	 //Titulo
	 	 asignarAtributo("PAGINA","contenido_cursos_insertar","cod","0466");
	 	 asignarAtributo("PAGINA","contenido_cursos_insertar","msgle","Modificar cursos");

         traza("***Salida -  LPModificaCruso - accionModificar");
   }
   
   /*	15/02/2006 [1] pperanzola : se modifica CursosRecibidos por CursosExigidos
	*
    */
   private void accionGuardar() throws Exception {
                     /*
                    * - Se instancia un DTOCurso y se rellena con toda la información que aparece en pantalla. Los campos que no aparezcan se rellenan como null. En el apartado de notas adjunto el mapeo de la pantalla al dto: 

                    * - Se crea idNegocio = "EDUInsertaCurso" 
                    * - Se invoca al conector ConectorEscribeCurso 
                    * - Si se recibe una excepción se muestra el detalle de la excepción en un mensaje. 
                    */ 
                   // Se obtienen los parametros
                   Long pais = UtilidadesSession.getPais(this);
                   Long idioma = UtilidadesSession.getIdioma(this);


                   DTORelacionesCurso dtoRelaciones = new DTORelacionesCurso();
                   dtoRelaciones.setOidPais(pais);
                   dtoRelaciones.setOidIdioma(idioma);
                   DTOCurso dto = new DTOCurso();
                   dto.setOidPais(pais);
                   dto.setOidIdioma(idioma);
                   Date fecha = null;

                   traza("*** guardar: parametros "+ conectorParametros());
                  
                   String parametro = conectorParametroLimpia("Plantilla", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidPlantilla(Long.valueOf(parametro)); 

                   parametro = conectorParametroLimpia("cbMarca", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidMarca(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbCanal", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidCanal(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbTipoCurso", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidTipoCurso(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("txtObjetivoCurso", "", true);
                   if(!parametro.equals(""))
                            dto.setObjetivo(parametro);

                   parametro = conectorParametroLimpia("txtContenidoCurso", "", true);
                   if(!parametro.equals(""))
                            dto.setContenido(parametro);

                   parametro = conectorParametroLimpia("cbAccesoInfo", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidAcceso(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("rbAccesoSeleccion", "", true);
                   dto.setAccesoDataMart(this.obtieneBoolean(parametro));

                   /*parametro = conectorParametroLimpia("txtPath", "", true);
                   if(!parametro.equals(""))
                            dto.setPathFichero(parametro);*/

                   parametro = conectorParametroLimpia("cbFrecuenciaDictado", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidFrecuencia(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("txtFechaDisponible", "", true);
                   if(!parametro.equals(""))
                            dto.setFechaDisponible(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro,UtilidadesSession.getFormatoFecha(this))).getTime()));

                   parametro = conectorParametroLimpia("txtFechaLanzamiento", "", true);
                   if(!parametro.equals(""))
                            dto.setFechaLanzamiento(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro,UtilidadesSession.getFormatoFecha(this))).getTime()));

                   parametro = conectorParametroLimpia("txtFechaFinalizacion", "", true);
                   if(!parametro.equals(""))
                            dto.setFechaFin(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro,UtilidadesSession.getFormatoFecha(this))).getTime()));

                   parametro = conectorParametroLimpia("rbAlcanceGeoNacional", "", true);
                   dto.setAlcance(this.obtieneBoolean(parametro));

                   parametro = conectorParametroLimpia("cbSubVentas", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidSubgerencia(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbRegion", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidRegion(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbZona", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidZona(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbSeccion", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidSeccion(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbTerritorio", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidTerritorio(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("txtOptimoParticipantes", "", true);
                   if(!parametro.equals(""))
                            dto.setNumeroParticipantes(Integer.valueOf(parametro));

                   parametro = conectorParametroLimpia("rbBloqueo", "", true);
                   dto.setBloqueoExtemporaneas(this.obtieneBoolean(parametro));

                   parametro = conectorParametroLimpia("txtMaterialAEmplear", "", true);
                   if(!parametro.equals(""))
                            dto.setRelacionMaterial(parametro);

                   parametro = conectorParametroLimpia("cbCapacitador", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidCapacitador(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("txtNOrdenes", "", true);
                   if(!parametro.equals(""))
                            dto.setNumeroOrdenes(Integer.valueOf(parametro));

                   //Cursos requeridos
                   Long cursosRequeridos[] =null;
                   parametro = conectorParametroLimpia("cbCursosExigidos", "", true);
                   if(!parametro.equals("")) {
                            traza("*** guardar: cursos: " + parametro);
                            java.util.StringTokenizer st = new java.util.StringTokenizer(parametro, "|");
                            if (st.countTokens() > 0){
                                     cursosRequeridos = new Long[st.countTokens()];                                     
									 for (int i = 0; i < cursosRequeridos.length; i++) {
                                              cursosRequeridos[i] = Long.valueOf (st.nextToken());
                                     }
                            }
                   }

                   parametro = conectorParametroLimpia("txtMontoVentasComp", "", true);
                   if(!parametro.equals(""))
 						dto.setMontoVentas(new BigDecimal(this.quitaSeparadorMiles(parametro)));

                   parametro = conectorParametroLimpia("txtFechaUltimo", "", true);
                   if(!parametro.equals(""))
                            dto.setFechaUltimo(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro,UtilidadesSession.getFormatoFecha(this))).getTime()));

                   parametro = conectorParametroLimpia("rbCondicionPedido", "", true);
                   dto.setCondicionPedido(this.obtieneBoolean(parametro));

                   parametro = conectorParametroLimpia("rbControlMorosidad", "", true);
                   dto.setControlMorosidad(this.obtieneBoolean(parametro));

                   parametro = conectorParametroLimpia("areaDescDetallada", "", true);
                   if(!parametro.equals(""))
                            dto.setDescripcion(parametro);

                   parametro = conectorParametroLimpia("cbTipoCliente", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidTipoCliente(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbSubtipoCliente", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidSubtipoCliente(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbClasificacion", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidClasificacion(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbTipoClasificacion", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidTipoClasificacion(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbEstatusCli", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidStatusCliente(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbPerConstInicio", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidPeriodoIniConstancia(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbPerConstFin", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidPeriodoFinConstancia(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbPerVentInicio", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidPeriodoIniComparativo(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbPerVentFin", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidPeriodoFinComparativo(Long.valueOf(parametro));

                            traza("*** guardar: 5");
                   parametro = conectorParametroLimpia("cbPerIngresoCondicion", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidPeriodoIngreso(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("txtFechaIngresoCondicion", "", true);
                   if(!parametro.equals(""))
                            dto.setFechaIngreso(new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(parametro,UtilidadesSession.getFormatoFecha(this))).getTime()));

                   parametro = conectorParametroLimpia("txtNPeriodosCondicion", "", true);
                   if(!parametro.equals(""))
                            dto.setNumeroCampanyas(Integer.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbProductoAEntregar", "", true);
                   if(!parametro.equals(""))
                            dtoRelaciones.setOidRegalo(Long.valueOf(parametro));

                   parametro = conectorParametroLimpia("txtUniRegalo", "", true);
                   if(!parametro.equals(""))
                            dto.setNumeroUnidades(Integer.valueOf(parametro));

                   parametro = conectorParametroLimpia("cbMomentoEntrega", "", true);
                   if(!parametro.equals(""))
 						dtoRelaciones.setOidMomentoEntrega(Long.valueOf(parametro));

                   dto.setRelacion(dtoRelaciones);
                   dto.setCursosExigidos(cursosRequeridos); //[1]

                   Vector vIdiomas = this.recuperaTraduccionesI18N(new Integer(1));
                   DTOI18nSICC idiomas [] = null;
                   if (vIdiomas != null){
                            idiomas = new DTOI18nSICC[vIdiomas.size()];
                            for (int i = 0; i < vIdiomas.size(); i++){
                                     idiomas [i] = (DTOI18nSICC)vIdiomas.get(i);
                                     traza("*** Atributo traducible: dto: "+ idiomas[i].getValorI18n());  
                            }
                   } 
                   
                   dto.setAttriTraducible(idiomas);
                   DTOI18nSICC dtoTrad[]=dto.getAttriTraducible();
		   
				   //Almacenamos el oid del curso a modificar
				   String oid = conectorParametroLimpia("oid", "", true);	
				   dto.setOid(new Long(oid));	   	
  
                   // Se invoca al conector ConectorEscribePlantilla 
                   Vector paramEntrada = new Vector();
                   paramEntrada.add(dto);
                   paramEntrada.add(new MareBusinessID("EDUModificaCurso"));
                   traza("*** guardar: dto: "+ dto.toString());

                   DruidaConector conector = conectar("ConectorEscribeCurso", paramEntrada);
                   traza("*** guardar: fin ");         
                           
   }
   	private java.sql.Date obtieneFecha(SimpleDateFormat sdf, String parametro) throws Exception {
         java.sql.Date resultado = new java.sql.Date((sdf.parse(parametro)).getTime());
         return resultado;
       }
                  
       private Boolean obtieneBoolean(String parametro) {
             if(parametro.equals("N"))
                  return new Boolean(false);
             else if (parametro.equals("S")) 
                  return new Boolean(true);
             return null;
       } 

	private String quitaSeparadorMiles(String parametro) {
		String resultado = "";
		String separadorMiles = ",";
		if ((UtilidadesSession.getSeparadorDecimales(this)).equals(",")) separadorMiles = ".";

		if (parametro != null) {
			//quitar separador miles
			java.util.StringTokenizer st = new java.util.StringTokenizer(parametro, separadorMiles);
			while (st.countTokens() > 0){
				resultado += st.nextToken();
			}
			//Convertir separador decimal a '.' si es necesario
			if (UtilidadesSession.getSeparadorDecimales(this).equals(","))
				resultado = resultado.replace(',', '.' );

			return resultado;
		} else return null;
	}
}
