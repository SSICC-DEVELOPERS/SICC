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
    $Id: LPMantenimientoFormasPagoDetalle.java,v 1.1 2009/12/03 18:32:19 pecbazalar Exp $
    DESC
*/

import java.util.Vector;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.ArrayList;

import java.math.BigDecimal;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.druida.DruidaConector;
 
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes;

import es.indra.sicc.dtos.bel.DTOFormaPagoDetalle;
import es.indra.sicc.dtos.bel.DTOEDetalleFormaPago;
import es.indra.sicc.dtos.cra.DTOActividad;

import java.lang.String;
import java.lang.Character;



// Definicion de la clase
public class LPMantenimientoFormasPagoDetalle extends LPSICCBase {
    // Definicion del constructor
    private String accion = null;

    public LPMantenimientoFormasPagoDetalle() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

         // Defino el nombre de la vista
         //pagina("");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
          try{
                    setTrazaFichero();
                    traza("***Entrada - LPMantenimientoFormasPagoDetalle - ejecucion***");
                      
                    this.accion = conectorParametroLimpia("accion","",true);
                    
                    //Acción "insertar" 
					//-> Llamar al método privado "cargarPaginaInsertar" 
					 if ( this.accion.equals("insertar")) {
                              cargarPaginaInsertar();
                    }
					//Acción "modificar" 
					//-> Llamar al método privado "cargarPaginaModificar" 
					 if ( this.accion.equals("modificar")) {
                              cargarPaginaModificar();
                    }
					//Acción "consultar" 
					//-> Llamar al método privado "cargarPaginaBusqueda" 
					 if ( this.accion.equals("consultar")) {
                              cargarPaginaBusqueda();
                    }
					//Acción "detalle" 
					//-> Llamar al método privado "cargarPaginaDetalle" 
					 if ( this.accion.equals("detalle")) {
                              cargarPaginaDetalle();
                    }
					//Acción "guardar" 
					//-> Llamar al método privado "guardar"
					 if ( this.accion.equals("guardar")) {
                             guardar();
                    }
                    
                    getConfiguracionMenu("LPMantenimientoFormasPagoDetalle",this.accion);
                    traza("***Salida - LPMantenimientoFormasPagoDetalle - ejecucion***");
          }catch(Exception e){
                    logStackTrace(e);
                    lanzarPaginaError(e);
          }
    }
    
    private void cargarPaginaInsertar() throws Exception {
        traza("***Entrada - LPMantenimientoFormasPagoDetalle - cargarPaginaInsertar");
        //Documentation
		//-> Asignar página "contenido_formas_pago_detalle_insertar" 
		pagina("contenido_formas_pago_detalle_insertar");
		asignarAtributo("PAGINA","contenido_formas_pago_detalle_insertar","cod","0364");
		asignarAtributo("PAGINA","contenido_formas_pago_detalle_insertar","msgle","Insertar Formas Pago Detalle"); 
		
		getConfiguracionMenu("LPMantenimientoFormasPagoDetalle", "Insertar");
		//-> Crear objeto DTOBelcorp introduciendo pais e idioma de sesión 
		UtilidadesSession session = new UtilidadesSession();
       	//Long pais = new Long(1);
       	Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        	
        //Guardar las varibles de sesion en los campos ocultos
        	
        asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma",idioma.toString());
		
		
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
	    dtoBelcorp.setOidPais(pais);
	    dtoBelcorp.setOidIdioma(idioma);
        //-> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
		//- idBusiness "BELObtenerFormasPagoCabecera" y DTOBelcorp => llena combo formaPagoCabecera 
		//- idBusiness "BELObtenerMediosPagoCombo" y DTOBelcorp => llena combo medioPago 
		//- idBusiness "SEGConsultarMarcas" => llena combo marca 
		//- idBusiness "SEGConsultaCanales" y DTOBelcorp => llena combo canal 
        //Creamos el array con los ids
        
	    String [] idNegocios = new String[4];
	    idNegocios[0]="BELObtenerFormasPagoCabecera";
	    idNegocios[1]="BELObtenerMediosPagoCombo"; 
		idNegocios[2]="SEGConsultaMarcas";
		idNegocios[3]="SEGConsultaCanales";
		//Creamos el array con los nombres de los combos
		String [] combos = new String[4];
	    combos[0]="cbFormaPago";
	    combos[1]="cbCodigoMedioPago"; 
		combos[2]="cbMarca";
		combos[3]="cbCanal";
        //Llamamos al subsistema
	 	cargaCombos(dtoBelcorp,idNegocios,combos,null,null);
        //-> Mostrar página con botones añadir y modificar habilitados, y los demás 
		//campos habilitados para llenarlos el usuario 
        //?????????????????????????????????????????????? 
        asignar("VAR", "accion","insertar");
        asignar("VAR","tipoAccion","insertar");
		Long canal = null;
		Long marca = null;
		try {
			canal = UtilidadesSession.getCanalPorDefecto(this);
			marca = UtilidadesSession.getMarcaPorDefecto(this);
		} catch (Exception e) {
   		}
		if (canal != null) {
			asignar("VAR", "canalPorDefecto", canal.toString());
		}
		if (marca != null) {
			asignar("VAR", "marcaPorDefecto", marca.toString());
		}
        traza("***Salida - LPMantenimientoFormasPagoDetalle - cargarPaginaInsertar");
	}
	
	private void cargarPaginaModificar() throws Exception {
		traza("***Entrada - LPMantenimientoFormasPagoDetalle - cargarPaginaModificar");
		//Documentation
		//-> Asignar página "contenido_formas_pago_detalle_insertar_detalle" 
		pagina("contenido_formas_pago_detalle_insertar_detalle");
		asignarAtributo("PAGINA","contenido_formas_pago_detalle_insertar_detalle","cod","0365");
		
		//getConfiguracionMenu("LPMantenimientoFormasPagoDetalle", "Modificar");
		UtilidadesSession session = new UtilidadesSession();
        //Long pais = new Long(1);
        Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        	
        asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma",idioma.toString());
       
		//-> Tomar de la pantalla llamante (pantalla de inserción de Formas de Pago Detalle)
		// los datos siguientes del registro seleccionado: 
		//- descripcionFormaPagoCabecera
		//- posicionDetalle 
		//- oidMedioPago 
		//- porcentajePago 
		//- indicadorDeDias 
		//- numeroDeDias 
		//- oidMarca 
		//- oidCanal 
		//- oidActividad 
		//??????????????????????????????????????????????????????????????????????
		//-> Crear objeto DTOActividad, llenando sólamente los atributos oidPais,
		//oidMarca y oidCanal con los datos correspondientes obtenidos en la actividad anterior. 
		
		
		traza("***cargarPaginaModificar -  Recogida de parametros");
			
		String oidFormaPagoDetalle = conectorParametroLimpia("oidFormaPagoDetalle","",true);
				
		String descripcionFormaPagoCabecera = conectorParametroLimpia("descripcionFormaPagoCabecera","",true);
				
		String posicionDetalle = conectorParametroLimpia("posicionDetalle","",true);
		
		String porcentajePago = conectorParametroLimpia("porcentajePago","",true);
		
		String indicadorDeDias = conectorParametroLimpia("indicadorDeDias","",true);
		//Las filas que se cargaron de base de datos no envían indicadorDias, sí envian la descripcion
		if (indicadorDeDias.equals("")) {
			String desIndicadorDeDias = conectorParametroLimpia("DesIndicadorDeDias","",true);
			if (desIndicadorDeDias != null) {
			 	if (desIndicadorDeDias.equals("N")) {
				 	indicadorDeDias = new String("00");
			 	}
			 	if (desIndicadorDeDias.equals("F")) {
				 	indicadorDeDias = new String("02");
			 	}
			 	if (desIndicadorDeDias.equals("D")) {
				 	indicadorDeDias = new String("01");
			 	}
			 	if (desIndicadorDeDias.equals("A")) {
				 	indicadorDeDias = new String("03");	
			 	}
			}

		}
		
		String numeroDeDias = conectorParametroLimpia("numeroDeDias","",true);
					
		String oidMedioPago = conectorParametroLimpia("oidMedioPago","",true);
		
		String oidMarca = conectorParametroLimpia("oidMarca","",true);
		
		String oidCanal = conectorParametroLimpia("oidCanal","",true);
		
		String oidActividad = conectorParametroLimpia("oidActividad","",true);
		
		
		traza("***cargarPaginaModificar -  Carga Combo Actividad");
		
		if((!oidCanal.equals(""))&&(!oidMarca.equals(""))){
			
			DTOActividad dtoactividad = new DTOActividad();
			
			dtoactividad.setOidPais(session.getPais(this));
			dtoactividad.setOidIdioma(session.getIdioma(this));
			dtoactividad.setOidCanal(new Long(oidCanal));
			dtoactividad.setOidMarca(new Long(oidMarca));
			
			// Se llama al subsistema de carga de pantalla
			ComposerViewElementList listelem = new ComposerViewElementList();
			ComposerViewElement elem = new ComposerViewElement();
        		elem.setIDBusiness("CRAObtieneActividad");
        		elem.setDTOE(dtoactividad);
        		listelem.addViewElement(elem);
        	
			ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
			conector.ejecucion();
			DruidaConector conConsultar = conector.getConector();
			
			// Se carga el combo actividad
			if(!(oidActividad.equals(""))){
				asignar("COMBO","cbActividad",conConsultar,"CRAObtieneActividad","OID_ACTI",oidActividad);
			}else{
				asignar("COMBO","cbActividad",conConsultar,"CRAObtieneActividad");
			}
		}	
	
		//-> Crear objeto DTOBelcorp con pais e idioma de la sesión 
		//-> Llamar al subsistema GestorCargaPantalla con los siguientes datos 
		//- idBusiness = "BELObtenerFormasPagoCabecera" y DTOBelcorp => llena combo formaPagoCabecera 
		//- idBusiness = "BELObtenerMediosPagoCombo" y DTOBelcorp => llena combo medioPago 
		//- idBusiness = "SEGConsultaMarcas" => llena combo marca 
		//- idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena combo canal 
		//- idBusiness = "CRAObtieneActividad" y DTOActividad => llena combo actividad
		
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
       	dtoBelcorp.setOidPais(pais);
        dtoBelcorp.setOidIdioma(idioma);
	    //Creamos el array con los ids
	    String [] idNegocios = new String[3];
	    idNegocios[0]="BELObtenerMediosPagoCombo"; 
		idNegocios[1]="SEGConsultaMarcas";
		idNegocios[2]="SEGConsultaCanales";
	
		//Creamos el array con los nombres de los combos
		String [] combos = new String[3];
       	combos[0]="cbCodigoMedioPago"; 
		combos[1]="cbMarca";
		combos[2]="cbCanal";
		
		//Creamos el array con los preseleccionados
		String [] seleccionados = new String[3];
        seleccionados[0]=oidMedioPago; 
		seleccionados[1]=oidMarca;
		seleccionados[2]=oidCanal;
		
		String [] columnas = new String[3];
	    columnas[0]="OID_MEDI_PAGO"; 
		columnas[1]="VAL_OID";
		columnas[2]="VAL_OID";
		
		 
        //Llamamos al subsistema
        	
		cargaCombos(dtoBelcorp,idNegocios,combos,seleccionados,columnas);
		
		//-> Mapear los datos obtenidos de la pantalla llamante en la pantalla 
		//"contenido_formas_pago_detalle_insertar_detalle" y mostrar la página, que permitirá al 
		//usuario modificar aquellos datos que desee 
		//descripcionFormaPagoCabecera 
		asignar("VAR","oidFormaPagoDetalle",oidFormaPagoDetalle);
		asignar("LABELC","lbldtFormaPago", descripcionFormaPagoCabecera);
		asignar("VAR","desCabecera",descripcionFormaPagoCabecera);
		//posicionDetalle
		asignar("VAR","posicion",posicionDetalle);
		//porcentajePago
		asignar("CTEXTO","txtPorcentajePago", porcentajePago);
		//indicadorDeDias 
		//asignarAtributo("COMBO","cbIndicadroDias","textoinicial", indicadorDeDias);
		//numeroDeDias
		asignar("CTEXTO","txtNumDias", numeroDeDias);
		//oidMedioPago  
		asignar("VAR","oidMedioPago",oidMedioPago);
		traza("***Modifico");
		//oidMarca  		
		asignar("VAR","oidMarca",oidMarca);
		//oidCanal			
		asignar("VAR","oidCanal",oidCanal);
		//oidActividad 	
		asignar("VAR","oidActividad",oidActividad);
		
		//-> Mostrar el botón "aceptar", que será el que pulse el usuario para aceptar los cambios ***********************************		
		asignar("VAR", "tipoAccion","modificar");
		
		//Para seleccionar el dato del combo Indicador de dias
		asignar("VAR","cargaComboDias",indicadorDeDias);
		    
		traza("***Salida - LPMantenimientoFormasPagoDetalle - cargarPaginaModificar");
	}
	
	private void cargarPaginaBusqueda() throws Exception {
		traza("***Entrada - LPMantenimientoFormasPagoDetalle - cargarPaginaBusqueda");
		//-> Asignar página "contenido_formas_pago_detalle_consultar" 
		pagina("contenido_formas_pago_detalle_consultar");
		asignarAtributo("PAGINA","contenido_formas_pago_detalle_consultar","cod","0366");
		asignarAtributo("PAGINA","contenido_formas_pago_detalle_consultar","msgle","Consultar Formas Pago Detalle");
		
		getConfiguracionMenu("LPMantenimientoFormasPagoDetalle", "consultar");
		//-> Crear objeto DTOBelcorp introduciendo pais e idioma de sesión 
		//-> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
		//- idBusiness "BELObtenerFormasPagoCabecera" y DTOBelcorp => llena combo formaPagoCabecera 
		//- idBusiness "SEGConsultaCanales" y DTOBelcorp => llena combo canal 
		//- idBusiness "SEGConsultarMarcas" => llena combo marca 
		//- idBusiness "BELObtenerMediosPagoCombo" y DTOBelcorp => llena combo medioPago 
		UtilidadesSession session = new UtilidadesSession();
       	Long pais = session.getPais(this);
        Long idioma = session.getIdioma(this);
        	
        //Guardar las varibles de sesion en los campos ocultos
        	
        asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma",idioma.toString());
		
		
		DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(pais);
       	dtoBelcorp.setOidIdioma(idioma);
	    
	    //Creamos el array con los ids
	    String [] idNegocios = new String[4];
	    idNegocios[0]="BELObtenerMediosPagoCombo"; 
		idNegocios[1]="SEGConsultaMarcas";
		idNegocios[2]="SEGConsultaCanales";
		idNegocios[3]="BELObtenerFormasPagoCabecera";
		
		//Creamos el array con los nombres de los combos
		String [] combos = new String[4];
       	combos[0]="cbMedioPago"; 
		combos[1]="cbMarca";
		combos[2]="cbCanal";
		combos[3]="cbFormaPago";
		
		//Creamos el array con los preseleccionados
		cargaCombos(dtoBelcorp,idNegocios,combos,null,null);
		
		//-> Mostrar página con botón buscar habilitado y campos habilitados para llenarlos el usuario********************************
		asignar("VAR", "tipoAccion","consultar");
 
		
		traza("***Salida - LPMantenimientoFormasPagoDetalle - cargarPaginaBusqueda");
	}
	
	private void cargarPaginaDetalle() throws Exception {
		 traza("***Entrada - LPMantenimientoFormasPagoDetalle - cargarPaginaDetalle");
		 //-> Asignar página "contenido_formas_pago_detalle_insertar_detalle" 
		 pagina("contenido_formas_pago_detalle_insertar_detalle");
		 asignarAtributo("PAGINA","contenido_formas_pago_detalle_insertar_detalle","cod","0366");
		 
		 getConfiguracionMenu("LPMantenimientoFormasPagoDetalle", "Detalle");
		 //-> Tomar de la pantalla llamante el oid del detalle que se quiere consultar
		 //-> Crear objeto DTOOID con el oid obtenido en actividad anterior 
		 UtilidadesSession session = new UtilidadesSession();
	     //Long pais = new Long(1);
	     Long pais = session.getPais(this);
	     Long idioma = session.getIdioma(this);
		 String oid = conectorParametroLimpia("oid","",true);
		 String descFormaPago = conectorParametroLimpia("descFormaPago","",true);
		 DTOOID dtoOid=new DTOOID();
	     dtoOid.setOidIdioma(idioma);
	     dtoOid.setOidPais(pais);
	     dtoOid.setOid(new Long(oid));
	     
	     //- Se crea idNegocio "BELConsultarFormaPagoDetalle" 
	     MareBusinessID idBussiness = new MareBusinessID("BELConsultarFormaPagoDetalle");
	        
	     //Almacenamos los parametros de entrada
	     Vector paramEntrada = new Vector();
	     paramEntrada.addElement(dtoOid);
	     paramEntrada.addElement(idBussiness);
	      
	     //- Se invoca al ConectorConsultarFormaPagoDetalle 
	     DruidaConector conector = conectar("ConectorConsultarFormaPagoDetalle", paramEntrada);
	     //> Recuperar objeto "DTOFormaPagoDetalle" respuesta     
	     DTOFormaPagoDetalle dtoCarga = (DTOFormaPagoDetalle) conector.objeto("DTOFormaPagoDetalle");
	     
	     //-> Mapear el contenido del dto obtenido en actividad anterior en la pantalla 
	     //"contenido_formas_pago_detalle_insertar_detalle" y mostrar la página, 
	     //sólo se permite consultar, por lo que todos los campos están deshabilitados 
		 
		 String oidFormaPagoDetalle =null;
		 if( dtoCarga.getOidFormaPagoDetalle() != null) {
			oidFormaPagoDetalle=dtoCarga.getOidFormaPagoDetalle().toString();
		 }
		
		 String porcentajePago = "";
		 if( dtoCarga.getPorcentajePago() != null) {
		 	porcentajePago = dtoCarga.getPorcentajePago().toString();
		 }
		 Character indicadorDeDias = null;
		 if(dtoCarga.getIndicadorDeDias()!= null) {
		 	indicadorDeDias =  dtoCarga.getIndicadorDeDias();
		 }	
		
		 String numeroDeDias = "";
		 if( dtoCarga.getNumeroDeDias() != null) {
		 	numeroDeDias = dtoCarga.getNumeroDeDias().toString();
		 }	
		
		 String oidMedioPago = "";
		 if( dtoCarga.getOidMedioPago() != null) {
		 	oidMedioPago = dtoCarga.getOidMedioPago().toString();
		 }
		 String oidMarca = "";
		 if( dtoCarga.getOidMarca() != null) {
		 	oidMarca = dtoCarga.getOidMarca().toString();
		 }
		 String oidCanal = "";
		 if( dtoCarga.getOidCanal() != null) {
		 	oidCanal = dtoCarga.getOidCanal().toString();
		 } 
		 String oidActividad = "";
		 if( dtoCarga.getOidActividad() != null) {
		 	oidActividad = dtoCarga.getOidActividad().toString();
		 } 
	     //Creamos el array con los ids
	     String [] idNegocios = new String[3];
	     idNegocios[0]="BELObtenerMediosPagoCombo"; 
		 idNegocios[1]="SEGConsultaMarcas";
		 idNegocios[2]="SEGConsultaCanales";
		 //Creamos el array con los nombres de los combos
		 String [] combos = new String[3];
       	 combos[0]="cbCodigoMedioPago"; 
		 combos[1]="cbMarca";
		 combos[2]="cbCanal";
		 //Creamos el array con los preseleccionados
		 String [] seleccionados = new String[3];
         seleccionados[0]=oidMedioPago; 
		 seleccionados[1]=oidMarca;
		 seleccionados[2]=oidCanal;
		 
		 String [] columnas = new String[3];
	     columnas[0]="OID_MEDI_PAGO"; 
		 columnas[1]="VAL_OID";
		 columnas[2]="VAL_OID";
	     DTOBelcorp dtoBelcorp = new DTOBelcorp();
         dtoBelcorp.setOidPais(pais);
         dtoBelcorp.setOidIdioma(idioma);
	     cargaCombos(dtoBelcorp,idNegocios,combos,seleccionados,columnas);
		 
		 //Cargamos el combo Actividad
		 if((!oidCanal.equals(""))&&(!oidMarca.equals(""))){
			
			DTOActividad dtoactividad = new DTOActividad();
			
			dtoactividad.setOidPais(session.getPais(this));
			dtoactividad.setOidIdioma(session.getIdioma(this));
			dtoactividad.setOidCanal(new Long(oidCanal));
			dtoactividad.setOidMarca(new Long(oidMarca));
			
			// Se llama al subsistema de carga de pantalla
			ComposerViewElementList listelem = new ComposerViewElementList();
			ComposerViewElement elem = new ComposerViewElement();
        	elem.setIDBusiness("CRAObtieneActividad");
        	elem.setDTOE(dtoactividad);
        	listelem.addViewElement(elem);
        	
			ConectorComposerView conector1 = new ConectorComposerView(listelem, this.getRequest());
			conector1.ejecucion();
			DruidaConector conConsultar = conector1.getConector();
			
			// Se carga el combo actividad
			if(!(oidActividad.equals(""))){
				asignar("COMBO","cbActividad",conConsultar,"CRAObtieneActividad","OID_ACTI",oidActividad);
			}else{
				asignar("COMBO","cbActividad",conConsultar,"CRAObtieneActividad");
			}
		}
		
		
		 //descripcionFormaPagoCabecera 
		 asignar("LABELC","lbldtFormaPago", descFormaPago);
		 //porcentajePago
		 asignar("CTEXTO","txtPorcentajePago", porcentajePago);
		 //indicadorDeDias 
		 String codigo = "";
		 if (indicadorDeDias != null) {
		 	if (indicadorDeDias.equals(new Character('N'))) {
			 	codigo = new String("00");
		 	}
		 	if (indicadorDeDias.equals(new Character('F'))) {
			 	codigo = new String("02");
		 	}
		 	if (indicadorDeDias.equals(new Character('D'))) {
			 	codigo = new String("01");
		 	}
		 	if (indicadorDeDias.equals(new Character('A'))) {
			 	codigo = new String("03");	
		 	}
		}
		 asignar("VAR","cargaComboDias",codigo);
		 asignarAtributoElemento("cbIndicadorDias", "valorinicial", codigo);
		 asignarAtributoElemento("cbIndicadorDias", "textoinicial", indicadorDeDias.toString());
		 //numeroDeDias
		 asignar("CTEXTO","txtNumDias", numeroDeDias);

		//Deshabilitar los campos. Solo se va a poder consultar
		 asignarAtributoElemento("cbMarca", "disabled", "S");
		 asignarAtributoElemento("cbCanal", "disabled", "S");
		 asignarAtributoElemento("cbActividad", "disabled", "S");
         asignarAtributoElemento("cbCodigoMedioPago", "disabled", "S");
         asignarAtributoElemento("cbIndicadorDias", "disabled", "S");
         asignarAtributoElemento("txtPorcentajePago", "disabled", "S");
         asignarAtributoElemento("txtNumDias", "disabled", "S");
		 
		 
		 //-> Se oculta el botón de esta pantalla llamado "aceptar", para salir de la pantalla 
		 //el usuario pulsará "volver", que cerrará la página volviendo el control a la pantalla llamante.
		asignar("VAR", "tipoAccion","detalle");

		traza("***Salida - LPMantenimientoFormasPagoDetalle - cargarPaginaDetalle");
	}


	private void guardar() throws Exception {
		
		traza("*** Entrada - guardar ***");
		
		pagina("salidaGenerica");
		asignar("VAR", "ejecutar","fGuardadoCorrecto()");
		asignar("VAR", "ejecutarError", "fGuardadoInCorrecto()");
		DTOEDetalleFormaPago dtoedetalle = new DTOEDetalleFormaPago();
		
		dtoedetalle.setOidFormaPagoCabecera(new Long(conectorParametroLimpia("oidFormaPago","",true)));
		
		UtilidadesSession session = new UtilidadesSession();
	    Long pais = session.getPais(this);
	    Long idioma = session.getIdioma(this);
		
		dtoedetalle.setOidPais(pais);
		dtoedetalle.setOidIdioma(idioma);
		
		//Recogemos la cadena formada con todos los datos del la ListaEditable
		String parametro = conectorParametroLimpia("cadena", "", true);
		
		//creamos el ArrayList donde se van a guardar los DTOFormaPagoDetalle
		ArrayList array = new ArrayList();
		traza("*** Cominezo de recorrido de StringTokenizer ***");
		//Recorremos la cadena sacando las celdas del la Lista Editable
		StringTokenizer st = new StringTokenizer(parametro, "#");
              while (st.countTokens() > 0) {
                        String fila = st.nextToken();
                        traza("*** fila recogida ***"+ fila);
                        if (!fila.equals("")) {
                                 //Obtenemos los valores de la fila
                                 StringTokenizer stFila = new StringTokenizer(fila, "@");
                                 		  
                                          if (stFila.countTokens() > 0) {
                                         		DTOFormaPagoDetalle dtoforma = new DTOFormaPagoDetalle();
                                     			dtoforma.setOidFormaPagoDetalle(new Long(obtenerStringTokenizer(new StringTokenizer(fila, "@"),10)));
												dtoforma.setOidMedioPago(new Long(obtenerStringTokenizer(new StringTokenizer(fila, "@"),11)));
												dtoforma.setPorcentajePago(new Integer(obtenerStringTokenizer(new StringTokenizer(fila, "@"),3)));
												dtoforma.setIndicadorDeDias(new Character(obtenerStringTokenizer(new StringTokenizer(fila, "@"),5).charAt(0)));
												if(dtoforma.getIndicadorDeDias().equals(new Character('N'))){
													dtoforma.setNumeroDeDias(new Integer(obtenerStringTokenizer(new StringTokenizer(fila, "@"),6)));
												}
												String oid = obtenerStringTokenizer(new StringTokenizer(fila, "@"),14);
												if(!oid.equals("-")){
													dtoforma.setOidActividad(new Long(obtenerStringTokenizer(new StringTokenizer(fila, "@"),14)));
												}			
												array.add(dtoforma);							
                                          }
                        }
      		 }
      		 //Introducir dto creado en el arrayList del dto DTOEDetalleFormaPago 
      		
      	     dtoedetalle.setListaRegistrosDetalle(array);
          
             MareBusinessID idbusiness = new MareBusinessID("BELGuardarDetalleFormaPago");
             
             Vector param = new Vector();
             param.add(dtoedetalle);
             param.add(idbusiness);
             DruidaConector conector = conectar("ConectorGuardarDetalleFormaPago",param);
                  		
		traza("*** Salida - guardar ***");
		
	}   
	    
	  private void cargaCombos(DTOBelcorp dtoBelcorp, String[] idNegocios, String[] combos, String[] seleccionados, String[] columnas) throws Exception {
		traza("*** Entrada - cargaCombos ***");
		try {
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = null;
		
		for (int i = 0; i < idNegocios.length; i++) {
			elem=new ComposerViewElement(); 
			elem.setIDBusiness(idNegocios[i]);
			elem.setDTOE(dtoBelcorp);
			listelem.addViewElement(elem);
		}
		
		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
		//correspondiente utilizando el String que representa el BusinessID en cada caso. */
		if (seleccionados == null) {
			for(int j = 0; j < combos.length; j++) {
				asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			}
		} else {
			for (int j = 0; j < combos.length; j++) {
				if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals(""))
							asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
			   	else
			   		asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			}
		}		
		} catch (Exception ex) {
			this.logStackTrace(ex);
		}
		traza("*** Salida - cargaCombos ***");
	}
	
	private String obtenerStringTokenizer(StringTokenizer st, int i){
		
		int cont=0;
		while (st.hasMoreTokens() && cont<i) {
		   st.nextToken();
		   cont++;
		}
		
		return st.nextToken().toString();
		
	}
	
	protected void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());

         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);
                      
         traza("Stack Trace: " + baos.toString());
    }
}