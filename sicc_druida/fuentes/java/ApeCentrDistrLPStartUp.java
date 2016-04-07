/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 *
 * Sistema:         Belcorp
 * Modulo:          APE
 * Fecha:             15/12/2005
 * Observaciones:     
 *                    
 * @version          1.0
 * @autor            
 * 
 * $Id: ApeCentrDistrLPStartUp.java,v 1.1 2009/12/03 18:39:20 pecbazalar Exp $
 */
import java.util.*;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;

import es.indra.utils.*;
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.belcorp.MMGNoLanguageException;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import java.text.DecimalFormatSymbols;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

public class ApeCentrDistrLPStartUp extends MMGDruidaBase{
	/* Constantes que definen la altura de los formularios según el modo */
	public static final short QUERYFORM_SIZE = 315;
	public static final short CREATEFORM_SIZE = 301;
	public static final short UPDATEFORM_SIZE = 301;
	public static final short VIEWFORM_SIZE = 301;

	/*
   * Cosntantes que definen elementos de la logica de negocio de las entidades
	 * y de los elementos asociados a la entidad
   */
	public static final String BUSINESSID_QUERY = 
                                    "MMGApeCentrDistrQueryFromToUserPage";
  public static final String BUSINESSID_PAISOIDPAIS_QUERY = 
                                                "MMGSegPaisViewQueryFromToUser";
  public static final String PAISOIDPAIS_COMBO_CONNECTOR = 
                                                    "SegPaisViewConectorCombo";
		
	/* Hashtables con los valores estáticos de radiobuttons y combos */
	
	
	/* Definicion del constructor */
	public ApeCentrDistrLPStartUp(){
      super();
	}

	public void inicio() throws Exception {
      pagina("ApeCentrDistrPage");
	}

	public void ejecucion() throws Exception {
      try {
        /*
         * Llamamos al metodo sobresctrito de la clase padre para 
         * ejecutar las acciones comunes:
         */
        super.ejecucion();
        
        this.getFormatosValidaciones();
        
        /* Activamos las trazas */
        setTrazaFichero();
        
        /* Establecemos el tamaño de la página */
        buildJsPageSize("ApeCentrDistr");
        
        /* Determinamos la acción y el origen */
        String accion = this.conectorParametro(PARAMETRO_GENERICO_ACCION);
        String origen = this.conectorParametro(PARAMETRO_GENERICO_ORIGEN);
        this.asignar("VAR", PARAMETRO_GENERICO_ACCION, accion);
        this.asignar("VAR", PARAMETRO_GENERICO_ORIGEN, origen);
        
        /*
         * Establecemos el valor del atributro cod de la pagina para 
         * que ponga el título i18nalizado
         * y para que funcione de forma correcta la configuración 
         * del menú secundario
         */
        this.asignarAtributo("PAGINA", 
                             "ApeCentrDistrPage", 
                             "cod", 
                             "ApeCentrDistr." + accion + ".label");
        
        /* 
         * Ponemos en la página el idioma de usuario, el idioma 
         * de la pagina para mostrar los errores, 
         * y el codigo del idioma por defecto
         */
           
        this.asignar("VAR", 
                      VAR_IDIOMA, 
                      MMGDruidaHelper.getUserDefaultLanguage(this));
        this.asignar("VAR", 
                      VAR_IDIOMA_XML, 
                      MMGDruidaHelper.getIdioma(this));
        this.asignar("VAR", 
                      VAR_DEFAULT_LANGUAGE_CODE, 
                      MMGDruidaHelper.getUserDefaultLanguage(this));
          
        /* Establecemos los tamaños y posiciones de la capas de la pantalla */
        this.establecerSizeCapas(accion, origen);
          
        /* Establecemos los valores por defecto de la entidades estructurales */
        this.setDefaultStructuralValues();
          
        /* Limpiamos la botonera */
        this.limpiarBotoneraLista("apeCentrDistr", accion);
          
        /* Ejecutanos la acción solicitada */
        System.out.println("accion " + accion + " origen " + origen);
        if (accion.equals(ACCION_LOV)) { 
            this.cmdLov();
        } else if (accion.equals(ACCION_QUERY)) { 
            this.cmdQuery();
        }	else if (accion.equals(ACCION_CREATE)) {
            this.cmdCreate();
        } else if (accion.equals(ACCION_REMOVE)) {
            this.cmdRemove();
        }	else if (accion.equals(ACCION_UPDATE) && origen.equals("menu")) { 
            this.cmdUpdate();
        } else if (accion.equals(ACCION_UPDATE) && origen.equals("pagina")) {
            this.cmdPreUpdateForm();
        }	else if (accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) {
            this.cmdUpdateForm();
        }	else if (accion.equals(ACCION_VIEW) && origen.equals("pagina")) { 
            this.cmdPreView();
        }	else if (accion.equals(ACCION_VIEW) && origen.equals("preview")) {
            this.cmdView();
        }
          
        /* Eliminamos los TRs del formulario que no tengan campos */
        this.eliminarTrsVacios(accion, origen);
		} catch(Exception e) {
			  handleException(e);
		}
	}
	
	/* Acciones que se realizan cuando la pantalla se arranca en modo lov */
	protected void cmdLov() throws Exception {
	    /* 
       * Establecemos los codigos de internacionalización para 
       * las etiquetas de los campos con búsqueda por intervalo
       */
		  this.setIntervalSearchFromLavels();
	
      /* Cargamos las combos finales de las jerarquías de herencia */
		  this.loadLeafDependenceCombos(null);
		
      /* Asignamos las validaciones */
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);

  		String datePattern = UtilidadesSession.getFormatoFecha(this);
    	String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
      String decimales = UtilidadesSession.getFormatoNumerico(this);
      String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
      
      this.asignarAtributo("TEXT", 
                           "valCentDist", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
                           
      this.asignarAtributo("TEXT", 
                           "valDesc", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
                           
      this.asignarAtributo("TEXT", 
                           "valNiveOuts", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
                           
      this.asignarAtributo("TEXT", 
                           "valSistCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
                           
      this.asignarAtributo("TEXT", 
                           "valProgCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
                           
      this.asignarAtributo("TEXT", 
                           "valProg", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		
      /*
       * Primero determianmos el nombre del campo en la entidad 
       * de origen donde se van a cargar los datos.
       */
      this.asignar("VAR", 
                   "idAttributeLovOpener", 
                   conectorParametro(PARAMETRO_LOV_ATTRIBUTO) );
                   
      this.asignar("VAR", 
                   "idEntityLovOpener", 
                   conectorParametro(PARAMETRO_LOV_ENTIDAD));
                   
      this.asignarAtributo("PAGINA", 
                           "ApeCentrDistrPage", 
                           "onblur", 
                           "window.focus();");
		
      /* Borramos los elementos de internacionalización() */
      this.removeLocalizationElements();
      this.removeNonSearchElements();
	}

	/* 
   * Acción previa para poder permitir la carga de datos en el formulario 
	 * de view con ventana oculta. 
   * Para ello simplemente redireccionamos al método
   */
	protected void cmdPreView() throws Exception {
      /* metemos en la sesión las query para realizar la requery */
      String sLastQueryToSession = 
              this.conectorParametro(VAR_LAST_QUERY_TO_SESSION);
                                
      this.conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
                                   sLastQueryToSession != null ?
                                        sLastQueryToSession: "");
  
      /*
       * Redirigimos a la acción de view pasando la accion, 
       * y la acción anterior y actulizando el origen
       */
       
      String sIdSelection = this.conectorParametro("idSelection");
      String sParametroGenericoAccion = 
              this.conectorParametro(PARAMETRO_GENERICO_ACCION);
      String sApplyStructuralEntity = 
              this.conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY);
      String sAccionAnterior = this.conectorParametro(VAR_ACCION_ANTERIOR);
                                
      this.conectorAction("ApeCentrDistrLPStartUp");
      this.conectorActionParametro("idSelection", sIdSelection);
      
      this.conectorActionParametro(PARAMETRO_GENERICO_ACCION, 
                                   sParametroGenericoAccion!= null?  
                                      sParametroGenericoAccion:"");
                                      
      this.conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preview");
      
      this.conectorActionParametro(VAR_ACCION_ANTERIOR, 
                                   sAccionAnterior != null?
                                      sAccionAnterior: "");
                                      
      this.conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, 
                                   sApplyStructuralEntity);
	}
	
	/*
   * Acciones que se realizan cunado la pantalla se arranca en modo view
   */
	protected void cmdView() throws Exception{
	    /*
       * Construimos el mso con los elementos de la búsqueda a partir del id que
       * lo sacamos de la request.
		   */
       
      String sIdSelection = this.conectorParametro("idSelection");
      String sAccionAnterior = this.conectorParametro("VAR_ACCION_ANTERIOR");
      
      ApeCentrDistrData apeCentrDistrQuery = new ApeCentrDistrData();
      apeCentrDistrQuery.setId(Long.valueOf(sIdSelection));
      
      /*
       * Asiganmos el valor a la variable de acción anterior para 
       * poder volver hacia atras y hacer requery}
       */
      this.asignar("VAR", 
                   VAR_ACCION_ANTERIOR, 
                   sAccionAnterior);
      
      /* Sacamos de la base de datos la entidad a visualizar */
      ApeCentrDistrData datosResult = 
              (ApeCentrDistrData)getSingleObject(BUSINESSID_QUERY, 
                                                 apeCentrDistrQuery, 
                                                 apeCentrDistrQuery.clone(),
                                                 "apeCentrDistr");
      
      
      /* Comprobamos que haya datos. Si no indicamos la situación */
      if (datosResult == null) {
          throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
      }
		
  		/* 
       * Cargamos los combos y seleccionamos en los combos 
       * los valores correspondientes
       */
      loadLeafDependenceCombos(datosResult);
      loadNonLeafDependenceCombos(datosResult);
		
      /* Damos los valores a los labels del modo view */
      String sDecimalPattern = 
              MMGDruidaHelper.getUserDecimalFormatPattern(this);
              
      DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
      decimalFormatSymbols.setDecimalSeparator(
              UtilidadesSession.getSeparadorDecimales(this).charAt(0));
      decimalFormatSymbols.setGroupingSeparator(
              UtilidadesSession.getSeparadorDecimales(this).equals(".") ? ",".charAt(0) : ".".charAt(0));
              
      ApeCentrDistrData apeCentrDistr = datosResult;
      this.asignar("TEXT", 
                   "valCentDist", 
                   FormatUtils.formatObject(apeCentrDistr.getValCentDist(), 
                                            sDecimalPattern, 
                                            decimalFormatSymbols) );
      this.asignar("TEXT", 
                   "valDesc", 
                   FormatUtils.formatObject(apeCentrDistr.getValDesc(), 
                                            sDecimalPattern, 
                                            decimalFormatSymbols));
      this.asignar("TEXT", 
                   "valNiveOuts", 
                   FormatUtils.formatObject(apeCentrDistr.getValNiveOuts(), 
                                            sDecimalPattern, 
                                            decimalFormatSymbols));
                                            
      this.asignar("TEXT",
                   "valSistCubi", 
                   FormatUtils.formatObject(apeCentrDistr.getValSistCubi(), 
                                            sDecimalPattern, 
                                            decimalFormatSymbols));
                                            
      this.asignar("TEXT", 
                   "valProgCubi", 
                   FormatUtils.formatObject(apeCentrDistr.getValProgCubi(), 
                                            sDecimalPattern, 
                                            decimalFormatSymbols));
                                            
      this.asignar("TEXT", 
                   "valProg", 
                   FormatUtils.formatObject(apeCentrDistr.getValProg(), 
                                            sDecimalPattern, 
                                            decimalFormatSymbols));
			
      /* 
       * Sacamos la información de los campos internacionalizables. 
       * Para cada campo internacionalizable
       * Construimos el mso con los elementos de la búsqueda
       * Creamos el dto y metemos la información necesaria para ejecutar la query
       * Invocamos la lógica de negocio
       */
		
			
      /* Deshabilitamos todos los campos para que no se editen */
      this.asignarAtributo("TEXT", "valCentDist", "disabled", "S");
      this.asignarAtributo("TEXT", "valDesc", "disabled", "S");
      this.asignarAtributo("TEXT", "valNiveOuts", "disabled", "S");
      this.asignarAtributo("TEXT", "valSistCubi", "disabled", "S");
      this.asignarAtributo("TEXT", "valProgCubi", "disabled", "S");
      this.asignarAtributo("TEXT", "valProg", "disabled", "S");
	
      /* Ponemos la pagina en modo view: Eliminamos el botón de buscar
       * Borramos tambien las celdas con los botones 
       * Borramos tambien todos los elementos de from y to 
       * dejando sólo el campo simple
       * Eliminamos los elementos correspondientes a la internacionalizacion
       */
      this.removeLovElements();
      this.removeQueryElements();
      this.removeNonViewElements();
		
	}
	
	/* Acciones que se realizan cuando la pantalla se arranca en modo create */
	protected void cmdCreate() throws Exception {
  
		  /* Cargamos las combos finales de las jerarquías de herencia */
		  this.loadLeafDependenceCombos(null);
	
      /* Ponemos los campos requeridos a true */
      this.asignarAtributo("TEXT", "valCentDist", "req", "S");
      this.asignarAtributo("TEXT", "valDesc", "req", "S");
      this.asignarAtributo("TEXT", "valNiveOuts", "req", "S");
		
      /* 
       * Asiganamos a los campos internacionalizables la función de onblur 
       * para actualizar el valor del idioma por defecto
       */
		
      /* Asignamos las validaciones */
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);
  
      String datePattern = UtilidadesSession.getFormatoFecha(this);
      String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
      String decimales = UtilidadesSession.getFormatoNumerico(this);
      String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
      this.asignarAtributo("TEXT", 
                           "valCentDist", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
                           
      this.asignarAtributo("TEXT", 
                           "valDesc", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
                           
      this.asignarAtributo("TEXT", 
                           "valNiveOuts", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
                           
      this.asignarAtributo("TEXT", 
                           "valSistCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
                           
      this.asignarAtributo("TEXT", 
                           "valProgCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
                           
      this.asignarAtributo("TEXT", 
                           "valProg", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      
      /* 
       * Ponemos la pagina en modo view: 
       * Eliminamos el botón de buscar
       * Borramos tambien las celdas con los botones
       * borramos tambien todos los elementos de from y to dejando sólo el campo simple
       */
  		this.removeLovElements();
    	this.removeQueryElements();
      this.removeNonInsertElements();
	}
	
	/* Acciones a ejecutar cuando la ventana se abre en modo remove */
	protected void cmdRemove() throws Exception{
      /* 
       * Establecemos los codigos de internacionalización 
       * para las etiquetas de los campos con búsqueda por intervalo
       */
      this.setIntervalSearchFromLavels();

      /* Asignamos las validaciones */
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
            Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);

      String datePattern = UtilidadesSession.getFormatoFecha(this);
      String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
      String decimales = UtilidadesSession.getFormatoNumerico(this);
      String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
      this.asignarAtributo("TEXT", 
                           "valCentDist", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
      this.asignarAtributo("TEXT", 
                           "valDesc", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
      this.asignarAtributo("TEXT", 
                           "valNiveOuts", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
      this.asignarAtributo("TEXT",
                           "valSistCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      this.asignarAtributo("TEXT", 
                           "valProgCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      this.asignarAtributo("TEXT", 
                           "valProg", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		
		
      /* Actualizamos el legend del formulario para indicar criterios de búsqueda */
      this.asignarAtributo("LABEL", 
                           "legendLbl", 
                           "cod", 
                           "MMGGlobal.legend.searchcriteria.label");

      /* 
       * Si hay que hacer requery por volver hacia a tras lo marcamos 
       * en las variables de la página.
       * Cargamos las combos finales de las jerarquías de herencia
       */
      if (isPerformRequery() ) {
          loadNonLeafDependenceCombosForRequery();
          performActionForRequery();
      } else {
          loadLeafDependenceCombos(null);
      }

      /* 
       * Eliminamos los elementos correspondientes a la internacionalizacion
       * y lov.
       */
      this.removeLocalizationElements();
      this.removeLovElements();
      this.removeNonSearchElements();
	}

	/*Acciones a ejecutar cuando la ventana se abre en modo query*/
	protected void cmdQuery() throws Exception{
		  /*
       * Establecemos los codigos de internacionalización para las 
       * etiquetas de los campos con búsqueda por intervalo
       */
		  this.setIntervalSearchFromLavels();
	 	
  		/* Asignamos las validaciones */
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
    	userProperties.put("loidPais",loidPais);

      String datePattern = UtilidadesSession.getFormatoFecha(this);
      String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
      String decimales = UtilidadesSession.getFormatoNumerico(this);
      String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
      
      this.asignarAtributo("TEXT", 
                           "valCentDist", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
      this.asignarAtributo("TEXT", 
                           "valDesc", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
      this.asignarAtributo("TEXT", 
                           "valNiveOuts", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
      this.asignarAtributo("TEXT", 
                           "valSistCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      this.asignarAtributo("TEXT", 
                           "valProgCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      this.asignarAtributo("TEXT", 
                           "valProg", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		
		
      /* Actualizamos el legend del formulario para indicar criterios de búsqueda */
      this.asignarAtributo("LABEL", 
                           "legendLbl", 
                           "cod", 
                           "MMGGlobal.legend.searchcriteria.label");

      /* 
       * Cargamos las combos finales de las jerarquías de herencia
       * Si hay que hacer requery por volver hacia a tras lo 
       * marcamos en las variables de la página
       */
      if (isPerformRequery()) {
          this.loadNonLeafDependenceCombosForRequery();
          this.performActionForRequery();
      }
      this.loadLeafDependenceCombos(null);
  
      /*
       * Eliminamos los elementos correspondientes a la internacionalizacion
       * elimnamos el botón lov de null selection
       */
      this.removeLocalizationElements();
      this.removeLovElements();
      this.removeNonSearchElements();
	}
	
	/* Acciones a ejecutar cuando la ventana se abre en modo update */
	protected void cmdUpdate() throws Exception {
      /*
       * Establecemos los codigos de internacionalización para las 
       * etiquetas de los campos con búsqueda por intervalo
       */
      this.setIntervalSearchFromLavels();

      /* Asignamos las validaciones */
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	    Long loidPais = UtilidadesSession.getPais(this);
	    userProperties.put("loidPais",loidPais);

      String datePattern = UtilidadesSession.getFormatoFecha(this);
      String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
      String decimales = UtilidadesSession.getFormatoNumerico(this);
      String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
      this.asignarAtributo("TEXT", 
                           "valCentDist", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
      this.asignarAtributo("TEXT", 
                           "valDesc", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
      this.asignarAtributo("TEXT", 
                           "valNiveOuts", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
      this.asignarAtributo("TEXT", 
                           "valSistCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      this.asignarAtributo("TEXT", 
                           "valProgCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
      this.asignarAtributo("TEXT", 
                           "valProg", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
		
      /* Actualizamos el legend del formulario para indicar criterios de búsqueda */
      this.asignarAtributo("LABEL",   
                           "legendLbl", 
                           "cod", 
                           "MMGGlobal.legend.searchcriteria.label");

      /*
       * Cargamos las combos finales de las jerarquías de herencia
       * Si hay que hacer requery por volver hacia a tras lo 
       * marcamos en las variables de la página
       */
      if (isPerformRequery()) {
          this.loadNonLeafDependenceCombosForRequery();
          this.performActionForRequery();
      }
      this.loadLeafDependenceCombos(null);

      /*
       * Simplemente elimnamos el botón lov de null selection y la 
       * internacionalización
       */
      this.removeLocalizationElements();
      this.removeLovElements();
      this.removeNonSearchElements();
	}

	
	/*
   * Acción previa para poder permitir la carga de datos en el formulario 
   * de updatecon ventana oculta. Para ello simplemente redireccionamos al método
   */
	protected void cmdPreUpdateForm() throws Exception {
      /* metemos en la sesión las query para realizar la requery */
      String sVarLastQuery = this.conectorParametro(VAR_LAST_QUERY_TO_SESSION);
      conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
                              sVarLastQuery != null ? sVarLastQuery: "");

      /* Redirigimos al update form */
      String sIdSelection = this.conectorParametro("idSelection");
      String sAccion = conectorParametro("accion");
      String sAccionAnterior = conectorParametro(VAR_ACCION_ANTERIOR);
      String sApplyStructuralEntity = 
              conectorParametro(VAR_APPLY_STRUCTURAL_ENTITY);
      
      this.conectorAction("ApeCentrDistrLPStartUp");
      this.conectorActionParametro("idSelection", sIdSelection);
      this.conectorActionParametro(PARAMETRO_GENERICO_ACCION, 
                                   sAccion != null ? sAccion: "");
      conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "preupdate");
      
      conectorActionParametro(VAR_ACCION_ANTERIOR, 
                              sAccionAnterior != null?
                                  sAccionAnterior: "");
                                  
      conectorActionParametro(VAR_APPLY_STRUCTURAL_ENTITY, 
                              sApplyStructuralEntity);
			
	}
	
	/* 
   * Prepara el formulario para mostrar los datos de un elemento de la entidad
   * y estos puedan ser modificados
   */  
	protected void cmdUpdateForm() throws Exception{
      /*
       * Asiganmos el valor a la variable de acción anterior para poder volver 
       * hacia atras y hacer requery
       */
      this.asignar("VAR", 
                   VAR_ACCION_ANTERIOR, 
                   conectorParametro(VAR_ACCION_ANTERIOR));

		
      /* Ponemos los campos requeridos a true */
      this.asignarAtributo("TEXT", "valCentDist", "req", "S");
      this.asignarAtributo("TEXT", "valDesc", "req", "S");
      this.asignarAtributo("TEXT", "valNiveOuts", "req", "S");
		
      /* 
       * Asignamos a los campos internacionalizables la función de onblur para 
       * actualizar el valor para el idioma por defecto.
       */
		
		  /* Asignamos las validaciones */
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);

      String datePattern = UtilidadesSession.getFormatoFecha(this);
      String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
      String decimales = UtilidadesSession.getFormatoNumerico(this);
      String separadorMiles = decimalSeparator.equals(".") ? "," : ".";
      String codigoIdioma = MMGDruidaHelper.getUserDefaultLanguage(this);
		
			this.asignarAtributo("TEXT", 
                           "valCentDist", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 2);");
			this.asignarAtributo("TEXT",
                           "valDesc", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 30);");
			this.asignarAtributo("TEXT", 
                           "valNiveOuts", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 1, 1);");
			this.asignarAtributo("TEXT", 
                           "valSistCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
			this.asignarAtributo("TEXT", 
                           "valProgCubi", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");
			this.asignarAtributo("TEXT", 
                           "valProg", 
                           "validacion", 
                           "mensaje = ValidaLongitud(cdos_trim(valor), 0, 2);");

      /* Obtenemos el id del elemento a seleccionar */
      traza("MMG::Creando ApeCentrDistr");
      String id = conectorParametro("idSelection");
      traza("MMG:: id del atributo a modificar: " + id);
	
		  /* Construimos el mso con los elementos de la búsqueda */
      ApeCentrDistrData apeCentrDistrQuery= new ApeCentrDistrData();
      apeCentrDistrQuery.setId(new Long(id));

      /* Sacamos de la base de datos la entidad a modificar */
      ApeCentrDistrData  datosResult = 
              (ApeCentrDistrData)getSingleObject(BUSINESSID_QUERY,
                                                 apeCentrDistrQuery, 
                                                 apeCentrDistrQuery.clone(), 
                                                 "apeCentrDistr");
		

      /* Comprobamos que haya datos. Si no indicamos la situación */
      if (datosResult == null) { 
          throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
      }
		
      /* 
       * Cargamos los combos y seleccionamos en los combos los valores 
       * correspondientes
       */
      this.loadLeafDependenceCombos(datosResult);
      this.loadNonLeafDependenceCombos(datosResult);
		
      /* 
       * Vamos cargamos los datos en el formulario. 
       * Muy importante es establecer id del elemento que estamos modificando
       */
      ApeCentrDistrData apeCentrDistr = datosResult;
      asignar("VAR", "idSelection", id);
      
      String sFormatPattern = MMGDruidaHelper.getUserDecimalFormatPattern(this);      
      DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
      String sDecimales = UtilidadesSession.getSeparadorDecimales(this);
      char chDecimalSeparator = sDecimales.charAt(0);
      
      decimalFormatSymbols.setDecimalSeparator(chDecimalSeparator);
      decimalFormatSymbols.setGroupingSeparator(sDecimales.equals(".") ? ",".charAt(0):
                                                ".".charAt(0));
                                                
      this.asignar("TEXT", 
                   "valCentDist", 
                   FormatUtils.formatObject(apeCentrDistr.getValCentDist(), 
                                            sFormatPattern, 
                                            decimalFormatSymbols));
      this.asignar("TEXT", 
                   "valDesc", 
                   FormatUtils.formatObject(apeCentrDistr.getValDesc(), 
                                            sFormatPattern, 
                                            decimalFormatSymbols));
      this.asignar("TEXT", 
                   "valNiveOuts", 
                   FormatUtils.formatObject(apeCentrDistr.getValNiveOuts(), 
                                            sFormatPattern, 
                                            decimalFormatSymbols));
                                          
      this.asignar("TEXT", 
                   "valSistCubi", 
                   FormatUtils.formatObject(apeCentrDistr.getValSistCubi(), 
                                            sFormatPattern, 
                                            decimalFormatSymbols));
                                            
      this.asignar("TEXT", 
                   "valProgCubi", 
                   FormatUtils.formatObject(apeCentrDistr.getValProgCubi(), 
                                            sFormatPattern, 
                                            decimalFormatSymbols));
                                            
      this.asignar("TEXT", 
                   "valProg", 
                   FormatUtils.formatObject(apeCentrDistr.getValProg(), 
                                            sFormatPattern, 
                                            decimalFormatSymbols));
		

      /*
       * Sacamos la información de los campos internacionalizables. 
       * Para cada campo internacionalizable
       * Construimos el mso con los elementos de la búsqueda
       * Creamos el dto y metemos la información necesaria para ejecutar la query
       * Invocamos la lógica de negocio
       */
		
		
      /*
       * Sobreescribimos el valor de origen para que en la siguiente 
       * llamada de la acción vaya directamente al metodo que realmente modifica
       */
      this.asignar("VAR",
                   PARAMETRO_GENERICO_ORIGEN,
                   "pagina");
		
      /* 
       * Guardamos el timestamp del elemento que se está modificando
       * Por ahora el timestamp no se usa ya que no existen bloqueos....(no comment)
       * asignar("VAR","timestamp",Long.toString(apeCentrDistr.jdoGetTimeStamp()));
       */
		
      /* 
       * Ponemos la pagina en modo view: Eliminamos el botón de buscar
       * Borramos tambien las celdas con los botones
       * Borramos tambien todos los elementos de from y to dejando sólo el campo simple
       * Borramos los elementos correspondientes a la internacionalización
       */
      this.removeLovElements();
      this.removeQueryElements();
      this.removeNonModifyFields();
      /** por eloy mier pérez para agregar funcionalidad de desactivacion 
       *  de campos */
      traza("MMG: antes de llamar a desactivateNonModifyFields .....");
      this.desactivateNonModifyFields();
      traza("MMG: despues de llamar a desactivateNonModifyFields ......");
      /** 
        por eloy mier pérez para agregar funcionalidad de desactivacion de campos
        para reescribir funciones ontab y onshtab.
       */
      this.cambiarAcciones();
	}

	/*
   * Por EMP. 
   * Nos permite cambiar el evento ontab y onshtab de los objetos druida 
   * necesarios en el modo de modificación.
	 */
	protected void cambiarAcciones() throws Exception {
	    this.asignarAtributo("AREATEXTO", 
                           "id", 
                           "ontab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",1, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "id", 
                           "onshtab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",1, false)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valCentDist", 
                           "ontab",
                           "ejecutarAccionFocoModificacion" +
                                   "(\"apeCentrDistrFrm\",2, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valCentDist", 
                           "onshtab",
                           "ejecutarAccionFocoModificacion" +
                                   "(\"apeCentrDistrFrm\",2, false)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valDesc", 
                           "ontab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",3, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valDesc", 
                           "onshtab","ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",3, false)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valNiveOuts",
                           "ontab","ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",4, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valNiveOuts", 
                           "onshtab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",4, false)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valSistCubi", 
                           "ontab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",5, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valSistCubi", 
                           "onshtab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",5, false)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valProgCubi", 
                           "ontab", 
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",6, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valProgCubi", 
                           "onshtab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",6, false)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valProg", 
                           "ontab", 
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",7, true)");
                                   
      this.asignarAtributo("AREATEXTO", 
                           "valProg", 
                           "onshtab",
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",7, false)");
                                   
      this.asignarAtributo("COMBO", 
                           "paisOidPais", 
                           "ontab", 
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",8, true)");
                                   
      this.asignarAtributo("COMBO",
                           "paisOidPais", 
                           "onshtab", 
                           "ejecutarAccionFocoModificacion" + 
                                   "(\"apeCentrDistrFrm\",8, false)");
	}
	
	/*
   * Nos permite eliminar de la página todos los elementos correspondiente
   * a las internacionalizacion
   */
	protected void removeLocalizationElements() throws Exception{
	}
	
	protected void removeLovElements() throws Exception{
		  this.borrarNodo("TD","nombre","apeCentrDistrTdLovNullSelectionButton");
	}
	
	protected void removeQueryElements() throws Exception{
		/* Borramos los botones para realizar la búsuqeda */
		this.borrarNodo("TR","nombre","apeCentrDistrTrButtons");

		/*
     * Borramos los elementos no necesarios de la búsqueda para los campos con búsquda
     * por intervalo
     */
	}
	
	/*
	 * Nos permite elimnar los campos del formulario que 
   * no deben aparecer en el formulario en el modo de view
	 */
	protected void removeNonViewElements() throws Exception{
      this.borrarCampo("id");
      this.borrarCampo("paisOidPais");
	}

	/*
	 * Nos permite eliminar los campos del formulario que 
   * no deben aparecer en el formulario en el modo de inserción
	 */
	protected void removeNonInsertElements() throws Exception{
      this.borrarCampo("id");
      this.borrarCampo("paisOidPais");
	}

	/*
	 * Nos permite eliminar los campos del formulario que 
   * no deben aparecer en el formulario en el modo de remove
	 */
	protected void removeNonSearchElements() throws Exception{
      this.borrarCampo("id");
      this.borrarCampo("paisOidPais");
	}
	
	/*
	 * Nos permite eliminar los campos del formulario que 
   * no deben aparecer en el formulario de modificación
	 */
	protected void removeNonModifyFields() throws Exception{
      this.borrarCampo("id");
      this.borrarCampo("paisOidPais");
	}
	
	/*
	 * Nos permite desactivar los campos del formulario que 
   * no deben aparecer en el formulario para modificación
	 */
	protected void desactivateNonModifyFields() throws Exception {
	    traza("MMG: en desactivateNonModifyFields ");		
      traza("MMG: el atributo es id...");		
      traza("MMG: el atributo es valCentDist...");		
      traza("MMG: el atributo es valDesc...");		
      traza("MMG: el atributo es valNiveOuts...");		
      traza("MMG: el atributo es valSistCubi...");		
      traza("MMG: el atributo es valProgCubi...");		
      traza("MMG: el atributo es valProg...");		
      traza("MMG: el atributo es paisOidPais...");		
	}

	/*
	 * Nos permite establecer el tamaño de las capas de la pantalla según el modo
	 * Esto se debe a que dependiendo del modo aparecen unos campos u otros 
	 */
	protected void establecerSizeCapas(String accion, String origen) 
                                                            throws Exception{
      /* Dependiendo del modo el tamaño del formualrio será uno u otro */
      int sizeForm = 0;
      if (accion.equals(ACCION_LOV)){ 
          sizeForm = QUERYFORM_SIZE;
      }	else if (accion.equals(ACCION_VIEW)) {
          sizeForm = VIEWFORM_SIZE;
      } else if (accion.equals(ACCION_CREATE)) {
          sizeForm = CREATEFORM_SIZE;
      }	else if (accion.equals(ACCION_REMOVE)) { 
          sizeForm = QUERYFORM_SIZE;
      }	else if (accion.equals(ACCION_QUERY)) { 
          sizeForm = QUERYFORM_SIZE;
      } else if (accion.equals(ACCION_UPDATE) && origen.equals("menu")) {
          sizeForm = QUERYFORM_SIZE;
      } else if (accion.equals(ACCION_UPDATE) && origen.equals("pagina")) {
          sizeForm = UPDATEFORM_SIZE;
      }	else if (accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) {
          sizeForm = UPDATEFORM_SIZE;
      }
		
 	  	/* Establecemos el tamaño de la capa del formulario */
  		this.asignarAtributo("CAPA",
                           "apeCentrDistrFormLayer", 
                           "alto", 
                           String.valueOf(sizeForm));		
		
      /* 
       * Estabelcemos la posicion y de la capa correspondiente a 
       * la lista y de su botonera
       */
      this.asignarAtributo("CAPA",
                           "apeCentrDistrListLayer", 
                           "y", 
                           String.valueOf(sizeForm + 26));		
                           
      this.asignarAtributo("CAPA",
                           "apeCentrDistrListButtonsLayer", 
                           "y", 
                           String.valueOf(sizeForm + 278));		
	}

	/*
	 * Nos permite cargar las combos finales de la jerarquías de dependencia
	 */
	protected void loadLeafDependenceCombos(ApeCentrDistrData apeCentrDistr) 
          throws Exception {
      HashMap checkedCombos = new HashMap();
      SegPaisViewData paisOidPais = new SegPaisViewData();
		
			this.asignarComboResultados(BUSINESSID_PAISOIDPAIS_QUERY,
                                  PAISOIDPAIS_COMBO_CONNECTOR, 
                                  paisOidPais, 
                                  paisOidPais.clone(), 
                                  "segPaisView", 
                                  "paisOidPais", 
                                  "result_ROWSET");
                                  
		if (apeCentrDistr != null && apeCentrDistr.getPaisOidPais() != null) {
		    this.checkCombo("paisOidPais" , 
                        apeCentrDistr.getPaisOidPais().getId().toString());
		}
		String paisOidPaisDefaultValue = 
          MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPaisView");
          
		if (paisOidPaisDefaultValue != null && 
                                  !paisOidPaisDefaultValue.trim().equals("")) {
        this.checkCombo("paisOidPais", paisOidPaisDefaultValue);
        checkedCombos.put("paisOidPais", paisOidPaisDefaultValue);
        this.cascadeComboLoad(checkedCombos, "paisOidPais");
		}						 
		
	}
	
	/*
	 * Nos permite cargar en cascada jerarquía de combos dependientes por la selección de valor en uno de sus elementos
	 */
	public void cascadeComboLoad(HashMap checkedCombos, String comboName) 
                                                              throws Exception {
		
	}
	
	/*
	 * Este método carga todos los combos de una jerarquía de dependencia. La carga se realiza c
	 * se realiza en función de los datos de un mso del mantenimiento. 
	 * @param apeCentrDistr La el objetopar la cual se va a realizar la carga
	 */
	protected void loadNonLeafDependenceCombos(ApeCentrDistrData apeCentrDistr) 
		throws Exception{
		
	}
	
	/*
	 * Nos permite cargar los combos y seleccionar los elementos 
   * tal como estaban en la última query
	 */
	protected void loadNonLeafDependenceCombosForRequery() throws Exception {
      /* 
       * Priemero obtenemos lso objetos from y to con todos los 
       * datos de la búsqueda
       */
      ApeCentrDistrData apeCentrDistr = (ApeCentrDistrData) 
              conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM);
		
      /* 
       * Cargamos todos los objetos completos correspodnientes a los valores de los
       * Campos que sean raiz de una jerarquía de combos dependientes
       */
      if (apeCentrDistr.getPaisOidPais() != null) {
          apeCentrDistr.setPaisOidPais( (es.indra.belcorp.mso.SegPaisViewData)
          getSingleObject(BUSINESSID_PAISOIDPAIS_QUERY, 
                          apeCentrDistr.getPaisOidPais(),
                          apeCentrDistr.getPaisOidPais().clone(),
                          "segPaisView"));
      }
		
      /* 
       * Una vez que tenemos completo los datos de los atributos 
       * raices de jerarquías de dependencias
       * cargamos las combos y seleccionamos elementos
       */
      this.loadNonLeafDependenceCombos(apeCentrDistr);
      this.loadLeafDependenceCombos(apeCentrDistr);
	}
	
	/*
	 *	Por defecto en los campos que tienen la búsqueda por intervalo el 
   *  label del campo es el label correspondiente a campos normal 
   *  (como si no fuera un campo con intervalor). En los modos de busqueda 
	 *	(search, update search y remove search) tendremos que poner el 
   *  label a la búsqueda "desde"
	 */
	protected void setIntervalSearchFromLavels() throws Exception{
	}
	
	/*
   *	Metodo que nos elimina los trs que quedan vacíos por 
   *  no aparecer sus campos por el modo
	 */
	protected void eliminarTrsVacios(String accion, String origen) 
                                                            throws Exception {
                                                            
		if ( accion.equals(ACCION_QUERY) || accion.equals(ACCION_LOV) ||
			   (accion.equals(ACCION_UPDATE) && origen.equals("menu")) ||
			   (accion.equals(ACCION_REMOVE) && origen.equals("menu"))) {

        borrarNodo("TR","nombre","formTr0");
        borrarNodo("TR","nombre","formGapTr0");
        borrarNodo("TR","nombre","formTr7");
        borrarNodo("TR","nombre","formGapTr7");
			
		} else if (accion.equals(ACCION_VIEW) && origen.equals("preview")) {
        borrarNodo("TR","nombre","formTr0");
        borrarNodo("TR","nombre","formGapTr0");
        borrarNodo("TR","nombre","formTr7");
        borrarNodo("TR","nombre","formGapTr7");
		}else if (accion.equals(ACCION_CREATE)) {
        borrarNodo("TR","nombre","formTr0");
        borrarNodo("TR","nombre","formGapTr0");
        borrarNodo("TR","nombre","formTr7");
        borrarNodo("TR","nombre","formGapTr7");
		}else if (accion.equals(ACCION_UPDATE) && origen.equals("preupdate")) {
        borrarNodo("TR","nombre","formTr0");
        borrarNodo("TR","nombre","formGapTr0");
        borrarNodo("TR","nombre","formTr7");
        borrarNodo("TR","nombre","formGapTr7");
		}
	}
	
}





