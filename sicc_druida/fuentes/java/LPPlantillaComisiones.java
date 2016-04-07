//$Id: LPPlantillaComisiones.java,v 1.1 2009/12/03 18:33:12 pecbazalar Exp $

/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
/**
 * Sistema:           Belcorp
 * Modulo:            COM
 * Submódulo:         Comisiones
 * Componente:        LP
 * Fecha:             03/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Marta Aurora Montiel
 * ult. modif.:       15/02/2005   idedough
 */


import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.dtos.com.DTOPlantillaDetalle;
import es.indra.sicc.dtos.com.DTOBusquedaPlantillas;
import es.indra.sicc.dtos.com.DTOBusquedaAccesosPlantilla;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
//import java.sql.Date;
import java.util.Date; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LPPlantillaComisiones extends LPSICCBase 
{

	public LPPlantillaComisiones() { super(); }	
	private String accion;
	private String casoDeUso;
    private String opcionMenu;
    private String sPais;     
    private String sIdioma;
	private String sDescPais; 
	private String oidPlantilla;
	private String descripcion;
	private String arrayPais;
	private String arraysMarca;
	private String oidCanal;
	private String arrayAcceso;
	private String oidTipoComision;
	private String comparativo;
	private String tratDiferencial;	
	private String oidsPlantillas;
	private String codPlantilla;
	private String estado;
	private MareBusinessID businessID;
	DTOPlantillaDetalle dtoDT = null;
	Vector parametros = null;

    public void inicio() throws Exception 
	{
    }

    public void ejecucion() throws Exception 
	{	setTrazaFichero();
		sPais = UtilidadesSession.getPais(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		accion =  conectorParametroLimpia("accion", "", true);
		casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
		traza("accion " + accion);
		try
		{	rastreo(); 
			if(accion.equals("")) 
			{	traza("antes del traducible oidPlantilla");
				//para el campo descripcion que es internacionalizable de la entidad PlantillaComision	
				anyadeHiddensI18N(false, "COM_PLAN_COMI", null, new Integer(1), "formulario", "txtDescripcionPlantilla", false);				
            }
		    else if (accion.equals("insertar")) 
			{	traza("antes del traducible oidPlantilla");
				pagina("contenido_plantilla_comisiones_insertar");
				mostrarPantallaInsertar();
				accion="insert";
				asignarAtributoPagina("cod","0516");
            }
			else if (accion.equals("detalle")) 
			{	mostrarPantallaDetalle();
			    accion="detalle";
				asignarAtributoPagina("cod","0516");
            }
			else if (accion.equals("grabar"))
			{	traza("INSERTAR PLANTILLA");
				insertarPlantilla();
				traza(" ................[OK]");			    	
			}
			else if (accion.equals("modificar")) 
			{	mostrarPantallaBusqueda();
				accion = "modificar";
				asignarAtributoPagina("cod","0521");
			}
			else if (accion.equals("modificar plantilla")) 
			{	pagina("contenido_plantilla_comisiones_insertar");
				mostrarPantallaInsertar();
				accion = "modif";
				asignarAtributoPagina("cod","0521");
			}
			else if (accion.equals("eliminar")) 
			{	mostrarPantallaBusqueda();
				accion="eliminar";
				asignarAtributoPagina("cod","0514");
			}
			else if (accion.equals("eliminar plantillas"))
			{	eliminarPlantillas();
				asignarAtributoPagina("cod","0514");
			}
			else if (accion.equals("consultar")) 
			{	mostrarPantallaBusqueda();
				accion="consultar";
				asignarAtributoPagina("cod","0511");
			}
			else if (accion.equals("consultar plantilla"))
			{	pagina("contenido_plantilla_comisiones_insertar");
				mostrarPantallaInsertar();
				accion = "consult";
				asignarAtributoPagina("cod","0511");
			}
			else if (accion.equals("copiar")) 
			{	mostrarPantallaBusqueda();
				accion="copiar";
				casoDeUso = "copiar";
				asignarAtributoPagina("cod","0513");
			}
			else if (accion.equals("copiar plantilla")) 
			{	DTOOID dtoe = new DTOOID();
				if(!"".equals(oidPlantilla) && oidPlantilla != null)
					dtoe.setOid(new Long(oidPlantilla));
				copiarPlantilla(dtoe);
				asignarAtributoPagina("cod","0513");
				
			}
			traza(" asigno accion: " + accion);
			asignarAtributo("VAR", "accion", "valor", accion );
			traza(" asigno casoDeUso: " + casoDeUso);
			asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso );

			asignarAtributo("VAR", "oidPais", "valor", sPais );
			asignarAtributo("VAR", "oidIdioma", "valor", sIdioma );     
			//getConfiguracionMenu();
		}
		catch(Exception e)
		{	traza("Exception en LPPlantillaComisiones");
		    traza("accion   " + accion);
	  	    traza("casoDeUso   " + casoDeUso);
			if(accion.equals("grabar") && casoDeUso.equals("modificar")){
				traza("entro en grabar y casoDeUso modificar vcxvvxvcxvx");
				pagina("contenido_plantilla_comisiones_insertar");
				asignarAtributo("VAR", "casoDeUso", "valor", "cerrar");			   
				lanzarPaginaError(e);
 			    e.printStackTrace();			   
				
			}else if("copiar plantilla".equals(accion))
			{
               traza("exception en copiar plantilla ");
			   pagina("contenido_plantilla_comisiones_insertar");
			   asignarAtributo("VAR", "casoDeUso", "valor", "cerrar");			   
			   lanzarPaginaError(e);
			   e.printStackTrace();			   
			   //asignarAtributo("VAR", "ejecutar", "valor", "closeDlg()");
			   //pagina("salidaGenerica");
			}
			else
			{			

				if(!"detalle".equals(accion) && !"modificar plantilla".equals(accion) && !"consultar plantilla".equals(accion))
				{   
						pagina("contenido_plantilla_comisiones_insertar");
						accion = "insertar";
						mostrarPantallaInsertar();
						preservaHiddensI18n(new Integer(1), "COM_PLAN_COMI", "formulario", "txtDescripcionPlantilla", false);
				}				
			    lanzarPaginaError(e);
				//getConfiguracionMenu();
			}
		}
		getConfiguracionMenu();
	}

    //######### METOD :  MOSTRAR_PANTALLA_INSERTAR #########

	/**
	 * Sistema:     Belcorp
	 * Modulo:      COM
	 * Fecha:       
	 * @version     1.0
	 * @autor       
	 * @modified	mmaidana
	 * Fecha		21/07/2005
	 * Resolucion inc. 17618.
	 * @modified pperanzola  30/08/2005 [1] segun incidencia 19377
	 */
	private void mostrarPantallaInsertar() throws Exception 
	{	traza("metodo mostrarPantallaInserta()");
        pagina("contenido_plantilla_comisiones_insertar");
		cargarCombos();
		cargarCanal();
		cargarCombosMulti();
        traza(" accion en mostrarPantallaInsertar " + accion);
		asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
		if("modificar plantilla".equals(accion) || "consultar plantilla".equals(accion)) 
		{  			
				/*Llama al metodo obtenerPlantilla() que devuelve un DTOPlantillaDetalle 
				mostrar la pantalla emergente y modal PantallaInsertarPlantillla
				- La lstResultados y el boton detalle , deshabilitados. 
				- La variable modificar a true */
				
				DTOOID dtoe = new DTOOID();
				if(oidPlantilla != null && !"".equals(oidPlantilla)  )
					dtoe.setOid(new Long(oidPlantilla));
				
				dtoDT = new DTOPlantillaDetalle();
				dtoDT = obtenerPlantilla(dtoe);
				traza("aca martuly "   + dtoDT);
				asignarAtributo("VAR", "oidPlantilla", "valor", dtoDT.getOidPlantilla().toString());
				asignarAtributo("VAR", "codPlantilla", "valor", dtoDT.getCodPlantilla().toString());
		
				boolean lec = "modificar plantilla".equals(accion)?false:"consultar plantilla".equals(accion)?true:false;
				
				traza(" dtoDT.getOidPlantilla() " + dtoDT.getOidPlantilla());
				traza(" dtoDT.getDescripcion() " + dtoDT.getDescripcion());
				if(dtoDT.getDescripcion() != null)
				   asignarAtributo("CTEXTO", "txtDescripcionPlantilla", "valor", dtoDT.getDescripcion());

				anyadeHiddensI18N(true, "COM_PLANT_COMIS", dtoDT.getOidPlantilla(), new Integer(1), "formulario", "txtDescripcionPlantilla", false);				

				if(dtoDT.getOidCanal() != null)
					asignarAtributo("VAR", "oidCanal", "valor", dtoDT.getOidCanal().toString());
					asignarAtributo("VAR", "oidPais", "valor", sPais);
					asignarAtributo("VAR", "oidIdioma", "valor", sIdioma);

				//convertir en array en el js antes de setear al combo
				//if(dtoDT.getArrayMarca() != null) [1]
					//asignarAtributo("VAR", "arrPais", "valor", armaString(dtoDT.getArrayMarca()) );[1]
				if(dtoDT.getArrayPais() != null) //[1]
					asignarAtributo("VAR", "arrPais", "valor", armaString(dtoDT.getArrayPais()) ); //[1]
				if(dtoDT.getArrayAcceso() != null)
					asignarAtributo("VAR", "arrAcceso", "valor", armaString(dtoDT.getArrayAcceso()));
				if(dtoDT.getArrayMarca() != null)
					asignarAtributo("VAR", "arrMarca", "valor", armaString(dtoDT.getArrayMarca()) );
				
				//FIN convertir
				if(dtoDT.getOidTipoComision() != null)
				  asignarAtributo("VAR", "oidTipoComision", "valor", dtoDT.getOidTipoComision().toString());


				if (dtoDT.getComparativo() == null || (!dtoDT.getComparativo().equals("0") 
						&& !dtoDT.getComparativo().equals("1"))){
					asignarAtributo("VAR", "comparativo", "valor", "");
				} else if (dtoDT.getComparativo().equals("0")){
					asignarAtributo("VAR", "comparativo", "valor", "COM_NO");
				} else if (dtoDT.getComparativo().equals("1")){
					asignarAtributo("VAR", "comparativo", "valor", "COM_SI");
				}

				//if (dtoDT.getComparativo() != null){
				//	asignarAtributo("VAR", "comparativo", "valor", ("1".equals(dtoDT.getComparativo().toString()))?"COM_SI":"COM_NO");
				//} else {
				//}

				if(dtoDT.getTratamientoDiferencial() != null ){
  				   if(!dtoDT.getTratamientoDiferencial().equals("")){
						asignarAtributo("VAR", "tratDifAntiguas", "valor", ("1".equals(dtoDT.getTratamientoDiferencial().toString()))?"COM_SI":"COM_NO");				
				   }else{
						asignarAtributo("VAR", "tratDifAntiguas", "valor", "");
				   }
				   
				}

				
					asignarAtributo("LISTAEDITABLE", "listado1","alto", "0");
					asignarAtributo("LISTAEDITABLE", "listado1","y", "0");
					asignarAtributo("CAPA", "capaEspacio","y", "0");
					asignarAtributo("BOTON", "primera1","y", "0");
					asignarAtributo("BOTON", "separa","y", "0");
					asignarAtributo("BOTON", "btnDetalle","y", "0");

					if("modificar plantilla".equals(accion))
					   asignarAtributo("VAR", "casoDeUso", "valor", "modificar");
					else if("consultar plantilla".equals(accion))
					   asignarAtributo("VAR", "casoDeUso", "valor", "consultar");


					traza(" ELEMENTOS SETEADOS ................................. [OK]");
					/*
					- La lstResultados, 
						 el boton detalle, 
						 el boton modificar, 
						 el boton insertar 
						 y todos los campos deshabilitados (excepto los combos de seleccion multiple) //pues es una consulta 
					*/	
		}	
		else
		  anyadeHiddensI18N(false, "COM_PLANT_COMIS", null, new Integer(1), "formulario", "txtDescripcionPlantilla", false);
	}
	

	private void cargarCombos() throws Exception 
	{	
		traza("METOD: cargarCombos()");
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(sPais));
		dto.setOidIdioma(new Long(sIdioma));
		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();

		composer1.setIDBusiness("COMObtenerTipoComision");
		composer1.setDTOE(dto);
		lista.addViewElement(composer1);
		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("		antes del conector en  COMObtenerTipoComision");
		conector.ejecucion();
		DruidaConector con = conector.getConector();
		traza("		8");
		if(con != null)
	      asignar("COMBO", "cbTipoComision", con, "COMObtenerTipoComision");
	}

	private void cargarCanal() throws Exception 
	{	traza("METOD:  cargarCanal()");
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(sPais));
		dto.setOidIdioma(new Long(sIdioma));	
		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("SEGConsultaCanales");
		composer1.setDTOE(dto);
		lista.addViewElement(composer1);
		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		conector.ejecucion();
		traza("		antes de llamar al conecto de SEGConsultaCanales");
		DruidaConector con = conector.getConector();
	    asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");
	}
	
	private void cargarCombosMulti() throws Exception 
	{	traza("metodo cargarCombosMulti()");
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(sPais));
		dto.setOidIdioma(new Long(sIdioma));
		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("SEGConsultaMarcas");
		composer1.setDTOE(dto);
		lista.addViewElement(composer1);
		ComposerViewElement composer2 = new ComposerViewElement();
		composer2.setIDBusiness("MENConsultaPaises");
		composer2.setDTOE(dto);
		lista.addViewElement(composer2);
		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("Antes del conector cargarCombosMulti ");
		conector.ejecucion();
		traza("antes de llamar al conector de SEGConsultaMarcas ");		
		DruidaConector con = conector.getConector();
	    asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
		//incidencia 13180
		asignar("COMBO", "cbPais", con, "MENConsultaPaises");		
	}

	private void cargarEstado() throws Exception 
	{   traza("metodo cargarEstado() ");
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(sPais));
		dto.setOidIdioma(new Long(sIdioma));
		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("COMObtenerEstadoPlantilla");
		composer1.setDTOE(dto);
		lista.addViewElement(composer1);
		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		conector.ejecucion();
		DruidaConector con = conector.getConector();
	    asignar("COMBO", "cbEstado", con, "COMObtenerEstadoPlantilla");
    }
	// @author pperanzola inc 19377 [1]
	private void mostrarPantallaDetalle() throws Exception 
	{	/*Llama al metodo obtenerPlantilla() que devuelve un DTOPlantillaDetalle 
			Llama al metodo cargarCombosMulti() 
			Muestra la pantallaDetallePlantilla modal y emergente con los atributos del DTOPlantillaDetalle recibido: 
			codPlantilla= DTOPlantillaDetalle.codPlantilla 
			descripcion=DTOPlantillaDetalle.descripcion 
			canal=DTOPlantillaDetalle.canal 
			oidCanal=DTOPlantillaDetalle.oidCanal 
			estado=DTOPlantillaDetalle.estado 
			fechaUltimoEstado=DTOPlantillaDetalle.fechaUltimoEstado 
			cbPais= seleccionar aquellas descripciones asociadas a DTOPlantillaDetalle.arrayPais 
			arrayAcceso=DTOPlantillaDetalle.arrayAcceso //el cdAcceso se cargara en el metodo onLoad de la pagina, segun el canal. 
			cbArrayMarca=seleccionar aquellas descripciones asociadas a DTOPlantillaDetalle.arrayMarca */
		
			traza("metodo mostrarPantallaDetalle()");
			pagina("contenido_plantilla_comisiones_insertar_detalle");
			cargarCombosMulti();
			DTOPlantillaDetalle dtoe = new DTOPlantillaDetalle();
			DTOOID dtoe1 = new DTOOID();
			if(oidPlantilla != null && !"".equals(oidPlantilla) )
				dtoe1.setOid(new Long(oidPlantilla));
			dtoe = obtenerPlantilla(dtoe1);
			traza("despues llamar de obtenerPlantilla dtoe "  + dtoe );


			//asignarAtributo("VAR", "oidPlantilla", "valor", dtoe.getOidPlantilla().toString());
			asignarAtributo("VAR", "codPlantilla", "valor", dtoe.getCodPlantilla().toString());
			traza(" dtoDT.getOidPlantilla() " + dtoe.getOidPlantilla());
			
			//anyadeHiddensI18N(true, "COM_PLAN_COMI", dtoe.getOidPlantilla(), new Integer(1), "formulario", "txtDescripcionPlantilla", false);
			
			if(dtoe.getOidCanal() != null)
				asignarAtributo("VAR", "oidCanal", "valor", dtoe.getOidCanal().toString());

			asignarAtributo("VAR", "oidPais", "valor", sPais);
			asignarAtributo("VAR", "oidIdioma", "valor", sIdioma);

			traza("dtoe.getArrayPais():   "  + dtoe.getArrayPais());

			//convertir en array en el js antes de setear al combo
			if(dtoe.getArrayPais() != null)
				//[1] asignarAtributo("VAR", "arrPaises", "valor", armaString(dtoe.getArrayPais()) );
				asignarAtributo("VAR", "arrPais", "valor", armaString(dtoe.getArrayPais()) ); //[1]
			if(dtoe.getArrayAcceso() != null)
				asignarAtributo("VAR", "arrAcceso", "valor", armaString(dtoe.getArrayAcceso()));
			if(dtoe.getArrayMarca() != null)
				asignarAtributo("VAR", "arrMarca", "valor", armaString(dtoe.getArrayMarca()) );
			
			//FIN convertir
			//asignarAtributo("VAR", "oidTipoComision", "valor", dtoe.getOidTipoComision().toString());
			//asignarAtributo("VAR", "comparativo", "valor", ("1".equals(dtoe.getComparativo().toString()))?"COM_SI":"COM_NO");
			//asignarAtributo("VAR", "tratDifAntiguas", "valor", ("1".equals(dtoe.getTratamientoDiferencial().toString()))?"COM_SI":"COM_NO");
			
			if(dtoe.getFechaUltimoEstado() != null)
				asignarAtributo("VAR", "fechaUltimoEstado", "valor", dateToString(dtoe.getFechaUltimoEstado()) );

			//if(dtoe.getCodPlantilla() != null)
			//{
				//traza("CodPlantilla en detalle " + dtoe.getCodPlantilla().toString());
			//	asignarAtributo("VAR", "codPlantilla","valor",dtoe.getCodPlantilla().toString());
			//}
			if(dtoe.getDescripcion() != null)
				asignarAtributo("VAR", "descripcion", "valor", dtoe.getDescripcion() ); 

			if(dtoe.getEstado() != null)
				asignarAtributo("VAR", "estado", "valor", dtoe.getEstado() ); 
			
			if(dtoe.getCanal() != null)
				asignarAtributo("VAR", "canal", "valor", dtoe.getCanal() );   
	}

	private void insertarPlantilla() throws Exception 
	{	traza("EN INSERTAR PLANTILLA");
		
		traza("1");
		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
		traza("2");

		codPlantilla = conectorParametroLimpia("codPlantilla", "", true);
		traza("3");
		traza("insertarPlantilla()  1");
		descripcion = conectorParametroLimpia("descripcion", "", true);
	    traza("insertarPlantilla()  2");
		arrayPais = conectorParametroLimpia("arrPais", "", true);
	    traza("insertarPlantilla()  3");
		arraysMarca = conectorParametroLimpia("arrMarca", "", true);
		traza("insertarPlantilla()  4" );
		oidCanal = conectorParametroLimpia("oidCanal", "", true);
		traza("insertarPlantilla()  5" + oidCanal);
		arrayAcceso = conectorParametroLimpia("arrAcceso", "", true);
		traza("insertarPlantilla()  6");
		oidTipoComision = conectorParametroLimpia("oidTipoComision", "", true);
		traza("oidTipoComision  " + oidTipoComision);
		comparativo = conectorParametroLimpia("comparativo", "", true);
		traza("comparativo  " + comparativo);
		tratDiferencial = conectorParametroLimpia("tratDiferencial", "", true); 
		traza("tratDiferencial  "  + tratDiferencial);
        
		DTOPlantillaDetalle dtoe = new DTOPlantillaDetalle();

        dtoe.setOidPais(new Long(sPais));
		dtoe.setOidIdioma(new Long(sIdioma));


		traza("oidPlantilla  "  + oidPlantilla);
		dtoe.setOidPlantilla(oidPlantilla.equals("")?null:new Long(oidPlantilla));
        traza("codPlantilla  "  + codPlantilla);
		dtoe.setCodPlantilla(codPlantilla.equals("")?null:new Long(codPlantilla));
        
			traza("traducciones: " + recuperaTraduccionesI18N(new Integer(1)));
			Vector traducciones = recuperaTraduccionesI18N(new Integer(1));
	
			traza(" SETEO DESCRIPCION " + traducciones);

			DTOI18nSICC[] arrI18nsicc = new DTOI18nSICC[traducciones.size()];
            int x = 0;
			for(Iterator it = traducciones.iterator();it.hasNext();)
			{              			  			  
			  arrI18nsicc[x] = (DTOI18nSICC)it.next();
			  x++;
			}

			dtoe.setAttriTraducible(arrI18nsicc);


		           
		traza("*** R: *** arrayAcceso  " + arrayAcceso);
			dtoe.setArrayAcceso(armaArrayLong(arrayAcceso));
        traza("*** R: *** arraysMarca  " + arraysMarca);
			dtoe.setArrayMarca(armaArrayLong(arraysMarca));
		traza("*** R: *** arrayPais  " + arrayPais);
			dtoe.setArrayPais(armaArrayLong(arrayPais));

        traza("*** R: *** oidCanal  " + oidCanal);
		dtoe.setOidCanal(oidCanal.equals("")?null:new Long(oidCanal));
		
						

        if(!"".equals(comparativo))
	   		dtoe.setComparativo(new String(comparativo));
		
        if(!"".equals(oidTipoComision))
			dtoe.setOidTipoComision(new Long(oidTipoComision));

		if(!"".equals(tratDiferencial))
		   dtoe.setTratamientoDiferencial(tratDiferencial);	

		traza(" ########################################### " );
		traza("dtoe a grabar " + dtoe);
        traza(" ########################################### " );

		businessID = new MareBusinessID("COMInsertarPlantillaCom");
		parametros = new Vector();
		parametros.add(dtoe);
		traza("DTOPlantillaDetalle 4" + dtoe);
		parametros.add(businessID);
		traza("antes del conector");
		DruidaConector con = conectar("ConectorInsertarPlantillaCom", parametros);
		traza("despues de conectar");
		traza(" oidPlantilla  " + oidPlantilla);
		if(!"".equals(oidPlantilla))
		{
		   pagina("contenido_plantilla_comisiones_insertar");
		   casoDeUso = "cerrar";
		}
		else
		{
			traza("MOSTRAR PANTALLA INSERTAR");
			mostrarPantallaInsertar();
			traza(" ................[OK]");
			asignarAtributoPagina("cod","0516");
		}			

    }

	private void mostrarPantallaBusqueda() throws Exception 
	{   traza("traza mostrarPantallaBusqueda() "  +  accion);
		pagina("contenido_plantilla_comisiones_modificar");
		cargarCombosMulti(); 
		cargarCanal();	
		cargarEstado();
		traza(" accion a asignar:   " + accion);
        this.getFormatosValidaciones();


        asignarAtributo("VAR", "constEliminado", "valor", ConstantesCOM.ELIMINADO);
		asignarAtributo("VAR", "casoDeUso", "valor", accion );
    }

	private DTOPlantillaDetalle obtenerPlantilla(DTOOID dtoe) throws Exception 
	{	
		traza(" METOD :: obtenerPlantilla ");
		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
		traza("oidPlantilla  " + oidPlantilla);

		DTOOID dtoe1 = new DTOOID();
		traza("idioma y pais  " + sIdioma + "  " + sPais);
		dtoe1.setOidIdioma(new Long(sIdioma));
        dtoe1.setOidPais(new Long(sPais));

		if(!"".equals(oidPlantilla) && oidPlantilla != null)
		    dtoe1.setOid(new Long(oidPlantilla));

		MareBusinessID businessID = new MareBusinessID("COMObtenerDetallePlantilla");
		parametros = new Vector();
		parametros.add(dtoe1);
		parametros.add(businessID);
		traza(" antes del conector ");
		DruidaConector con = conectar("ConectorObtenerDetallePlantilla", parametros);
		traza(" despues del conector ConectorObtenerDetallePlantilla ");
		DTOPlantillaDetalle dtoPlantillaDetalle = (DTOPlantillaDetalle)con.objeto("DTOSalida");	
		traza(" ................................................... [OK] ");
		traza(" RETURN dtoPlantillaDetalle:   " + dtoPlantillaDetalle);
		return dtoPlantillaDetalle;
    }


	private void eliminarPlantillas() throws Exception 
	{	/*Se crea un DTOE del tipo DTOOids con los oids recibidos de la pantalla 
		- Invocar conector ConectorEliminarPlantillaCom con el DTOE 
		- Crear IDBusiness="COMEliminarPlantillaCom"
		*/
		DTOOIDs dtoOids = new DTOOIDs();
		oidsPlantillas = conectorParametroLimpia("oidsPlantillas", "", true);

		StringTokenizer st = new StringTokenizer(oidsPlantillas, ",");
		Long[] arrOIDS = new Long[st.countTokens()];
		int i = 0;
        while (st.hasMoreElements()) 
		{  arrOIDS[i] = new Long(st.nextToken()); 
		   i++;
        }
		dtoOids.setOids(arrOIDS);
		dtoOids.setOidIdioma(new Long(sIdioma));
		dtoOids.setOidPais(new Long(sPais));

		// ...........
    }
    
	/*Recoge el oid recibido por pantalla. 
	Crea un DTOE del tipo DTOOid con este oid recibido. 
	Invocar al conector ConectorCopiarPlantillaCom con el DTOE 
	Crear IDBusiness="COMCopiarPlantillaCom" 
	Llama al metodo mostrarCopiadaModificar() */
	private void copiarPlantilla(DTOOID dtoe) throws Exception 
	{	
		traza(" METOD : COPIAR PLANTILLA!");
		oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
		DTOOID dto = new DTOOID();
		traza("oidPlantilla   " + oidPlantilla);
		dto.setOid(oidPlantilla.equals("")?null:new Long(oidPlantilla));
		traza(" sPais:  " + sPais);
	    dto.setOidPais(new Long(sPais));
		traza(" sIdioma:  " + sIdioma);
		dto.setOidIdioma(new Long(sIdioma));
		businessID = new MareBusinessID("COMCopiarPlantillaCom");
		parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);
		traza(" dtoOID: "  + dto);
		traza("      antes CONECTAR ");

		DruidaConector con = conectar("ConectorCopiarPlantillaCom", parametros);

        traza("      conectar ............ [OK]");
        DTOPlantillaDetalle dtoPlantillaDetalle = (DTOPlantillaDetalle)con.objeto("dtoSalida");
		traza(" ................................. [OK]");
        traza(" dtoPlantillaDetalle :  " + dtoPlantillaDetalle);
		if(dtoPlantillaDetalle != null)
		  mostrarCopiadaModificar(dtoPlantillaDetalle);
    }
	/*	modificaciones - BELC300019377 - 11/07/2005 - pperanzola 
	*/
	private void mostrarCopiadaModificar(DTOPlantillaDetalle dtoe) throws Exception 
	{	/* Llama al metodo cargarCombos() 
		llama al metodo cargarCanal() 
		llama al metodo cargarCombosMulti() //cargar los combos. 

		mostrar la pantalla emergente y modal PantallaInsertarPlantillla con: 
		- La lstResultados y el boton detalle , deshabilitados. 
		- La variable modificar a true
		*/
		pagina("contenido_plantilla_comisiones_insertar");
		cargarCombos();
		cargarCanal();
		cargarCombosMulti();

		asignarAtributo("VAR", "oidPlantilla", "valor", dtoe.getOidPlantilla().toString());
		asignarAtributo("VAR", "codPlantilla", "valor", dtoe.getCodPlantilla().toString());
		traza(" dtoDT.getOidPlantilla() " + dtoe.getOidPlantilla());

		traza(" dtoe.getDescripcion()  :  "  + dtoe.getDescripcion());
        
		if(dtoe.getDescripcion() != null)
           asignarAtributo("CTEXTO", "txtDescripcionPlantilla", "valor", dtoe.getDescripcion());

		anyadeHiddensI18N(true, "COM_PLANT_COMIS", dtoe.getOidPlantilla(), new Integer(1), "formulario", "txtDescripcionPlantilla", false);
		traza("dtoe.getOidCanal()  "  + dtoe.getOidCanal());
		if(dtoe.getOidCanal() != null){
		  
		  asignarAtributo("VAR", "oidCanal", "valor", dtoe.getOidCanal().toString());
		}
		asignarAtributo("VAR", "oidPais", "valor", sPais);
		asignarAtributo("VAR", "oidIdioma", "valor", sIdioma);

		//convertir en array en el js antes de setear al combo
		if(dtoe.getArrayPais() != null)
		    asignarAtributo("VAR", "arrPais", "valor", armaString(dtoe.getArrayPais()) );
        if(dtoe.getArrayAcceso() != null)
			asignarAtributo("VAR", "arrAcceso", "valor", armaString(dtoe.getArrayAcceso()));
        if(dtoe.getArrayMarca() != null)
		    asignarAtributo("VAR", "arrMarca", "valor", armaString(dtoe.getArrayMarca()) );
		
		//FIN convertir
        if(dtoe.getOidTipoComision() != null)
		  asignarAtributo("VAR", "oidTipoComision", "valor", dtoe.getOidTipoComision().toString());
		if(dtoe.getComparativo() != null)
		  asignarAtributo("VAR", "comparativo", "valor", ("1".equals(dtoe.getComparativo().toString()))?"COM_SI":"COM_NO");
		if(dtoe.getTratamientoDiferencial() != null   ){
		 if( !dtoe.getTratamientoDiferencial().equals("")){
			asignarAtributo("VAR", "tratDifAntiguas", "valor", ("1".equals(dtoe.getTratamientoDiferencial().toString()))?"COM_SI":"COM_NO");		 
		 }else{
			asignarAtributo("VAR", "tratDifAntiguas", "valor", "");
		 }


		}

		asignarAtributo("LISTAEDITABLE", "listado1","alto", "0");
		asignarAtributo("LISTAEDITABLE", "listado1","y", "0");
		asignarAtributo("CAPA", "capaEspacio","y", "0");
		asignarAtributo("BOTON", "primera1","y", "0");
		asignarAtributo("BOTON", "separa","y", "0");
		asignarAtributo("BOTON", "btnDetalle","y", "0");

		asignarAtributo("VAR","modificar","valor","true");

        asignarAtributo("VAR", "casoDeUso", "valor", "copiar");
    }

	//metodo convierte el array de Long en String para setear en la pantalla
	private String armaString(Long[] arr)
	{	String stringArr = "";	    
		for( int a=0 ; a < arr.length; a++ ) 
			 stringArr = a==0?(arr[a]==null?"":arr[a].toString()):stringArr+"|"+(arr[a]==null?"":arr[a].toString()); 		
		return stringArr;
	}
	
	/*Metodo que arma el array de Longs*/
	private Long[] armaArrayLong(String arr)
	{	StringTokenizer st = new StringTokenizer(arr, ",");
		Long[] arrOIDS = new Long[st.countTokens()];
		int i = 0;
		while (st.hasMoreElements()) 
		{  arrOIDS[i] = new Long(st.nextToken()); 
		   i++;
		}
		return arrOIDS;
	}

	//------------------------- UTILITIES ------------------------------------------------
    private Date toDate(String sFecha) throws Exception
    {   String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        return this.toDate(sFecha, formatoFecha);
    }
    private Date toDate(String sFecha, String formatoFecha) throws Exception 
    {   formatoFecha = formatoFecha.replace('m', 'M');	
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
        java.util.Date fecha = miFecha.parse(sFecha);
        miFecha = new SimpleDateFormat(formatoFecha);
        String fechaRes = miFecha.format(fecha);
        fecha = miFecha.parse(fechaRes);
        java.sql.Date sql = new java.sql.Date(fecha.getTime());     	  	  
        return sql;
    }
    private String dateToString(Date dFecha) throws Exception
    {   String formato = UtilidadesSession.getFormatoFecha(this);
        formato = formato.replace('m', 'M');
        SimpleDateFormat miFecha = new SimpleDateFormat(formato);
        String fechaRes = miFecha.format(dFecha);		  	  	  
        return fechaRes;
    }
}
