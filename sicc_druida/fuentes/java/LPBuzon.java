//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.StringTokenizer;

import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTORedirigirDetalle;
import es.indra.sicc.dtos.cal.DTOCliente;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.w3c.dom.Element;

public class LPBuzon extends LPSICCBase {
  private String accion = null;
  private String opcionMenu = null;

  private String sPais = null;     
  private String sIdioma = null;
  private String sDescPais = null;   

  private String codBuzon = null;
  private String secuenciaActividad = null;
  private String descripcionBuzon = null;
  private String codCliente = null;
  private String fechaActividadDesde = null;
  private String fechaActividadHasta = null;

  private String idUsuario = null;
  private String descripcion = null;

  private String oidDetalle = null;
  private String oidCabecera = null;
  private String descripcionActividad = null;
  private String oidContacto = null;
  private String oidGestion = null;
  private String observaciones = null;

  private String oidsDetalle = null;
  private String codBuzonActual = null;

  private String listaOidDetalle = null;
  private String oidCabeceraNuevo = null;

  public LPBuzon() { super(); }

  public void inicio() throws Exception {
   opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
   if(opcionMenu.equals("ConsultarBuzon") || opcionMenu.equals("Actualizar Buzon")){
		pagina("contenido_buzon_modificar");      
   }else{
		pagina("contenido_buzon_crear"); 
   }
	
  }
  
  public void ejecucion() throws Exception {    
    setTrazaFichero();    

    sPais = UtilidadesSession.getPais(this).toString();
    sDescPais = UtilidadesSession.getDescripcionPais(this).toString();
    sIdioma = UtilidadesSession.getIdioma(this).toString();

    accion = conectorParametroLimpia("accion", "", true);
    
	asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	//traza("************** Entre a LPBuzon");
	//traza("************** accion : " + accion);
	//traza("************** opcionMenu : " + opcionMenu);    
	//traza("************** sPais : " + sPais);
	//traza("************** sDescPais : " + sDescPais);    
	//traza("************** sIdioma : " + sIdioma);    
    
    try {
	    if(accion.equals(""))  {            
		   inicializar();
        }          
        else if(accion.equals("mostrar cabecera")) {           
	        mostrarPgCabecera();
        }
		else if(accion.equals("insertar cabecera")) {
			insertarCabecera();
        }
		else if(accion.equals("mostrar detalle")) {   
            mostrarPgDetalle();
        }
		else if(accion.equals("insertar detalle")) {           
            insertarDetalle();
        }
		else if(accion.equals("buscar cabecera")) {           
			DTOBusqueda dtoBusqueda = crearDtoCabecera();
			obtenerCabecera(dtoBusqueda);
        }
		else if(accion.equals("actualizar detalle")) {           
            actualizarDetalle();
        }
		else if(accion.equals("redirigir detalle")) {           
            mostrarPgRedirigir();
        }
		else if(accion.equals("redirigir actividad")) {           
            redirigirActividad();
        }
		else if(accion.equals("procesar actividad")) {           
            procesarActividad();
        }   
		seteaTitulo();
    }
    catch ( Exception e )  {
	  seteaTitulo();	
	  //traza("accion  " + accion );
	  //traza("opcionMenu  " + opcionMenu);
	  if(accion.equals("buscar cabecera") && opcionMenu.equals("Actualizar Buzon")){		 
		  pagina("contenido_buzon_modificar");          
	  	  asignarAtributo("VAR", "opcionMenu", "valor", "ActualizarBuzon");	
		  asignarAtributoPagina("cod","0590");
	  }else if(accion.equals("buscar cabecera") && opcionMenu.equals("ConsultarBuzon")){
		  pagina("contenido_buzon_modificar");          
	  	  asignarAtributo("VAR", "opcionMenu", "valor", "ConsultarBuzon");	
		  asignarAtributoPagina("cod","0591");
	  }
	  asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	  lanzarPaginaError(e);
	  ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      e.printStackTrace(out);
      traza("EL STACK ES COMO SIGUE : " +  pila.toString());
	}
	cargarMenuSecundario();   
//	getConfiguracionMenu();
  }

  private void inicializar() throws Exception {      
	
	//traza("************** Entre a inicializar" + opcionMenu);

	if(opcionMenu.equals("Crear Buzon")) {
		DTOBusqueda dtoe = new DTOBusqueda();

		dtoe.setOidCabecera(null);
		dtoe.setCodBuzon(null);
		dtoe.setDescripBuzon(null);
		dtoe.setSecActividad(null);
		dtoe.setDescripActividad(null);
		dtoe.setCodCliente(null);
		dtoe.setFechaActividadDesde(null);
		dtoe.setFechaActividadHasta(null);
		dtoe.setOidPais(new Long(sPais));
		obtenerCabecera(dtoe);
	}

	else if(opcionMenu.equals("Actualizar Buzon")) {
		pagina("contenido_buzon_modificar");          
		asignarAtributo("VAR", "opcionMenu", "valor", "ActualizarBuzon");
	}

	else if(opcionMenu.equals("Redirigir Buzon")) {
		DTOBusqueda dtoe = new DTOBusqueda();
		//traza("entre en Redirigir Buzon ");
		dtoe.setOidCabecera(null);
		dtoe.setCodBuzon(null);
		dtoe.setDescripBuzon(null);
		dtoe.setSecActividad(null);
		dtoe.setDescripActividad(null);
		dtoe.setCodCliente(null);
		dtoe.setFechaActividadDesde(null);
		dtoe.setFechaActividadHasta(null);
		dtoe.setOidPais(new Long(sPais));
		obtenerCabecera(dtoe);
	}

	else if(opcionMenu.equals("ConsultarBuzon")) {
		pagina("contenido_buzon_modificar");          
		asignarAtributo("VAR", "opcionMenu", "valor", "ConsultarBuzon");
	}
  }

  private void mostrarPgCabecera() throws Exception {     	  
    //traza("************** Entre a mostrarPgCabecera");

	pagina("contenido_buzon_cabecera_insertar");        		

	DTOBelcorp dtoe = new DTOBelcorp();

	dtoe.setOidPais(new Long(sPais));
	dtoe.setOidIdioma(new Long(sIdioma));

	ComposerViewElementList lista = new ComposerViewElementList();
	ComposerViewElement composer1 = new ComposerViewElement();

	composer1.setIDBusiness("MENObtenerUsuarios");
    composer1.setDTOE(dtoe);

	lista.addViewElement(composer1);

	ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
    conector.ejecucion();

	DruidaConector con = conector.getConector();
    asignar("COMBO", "cbUsuario", con, "MENObtenerUsuarios");
  }

  private void insertarCabecera() throws Exception {	
    //traza("************** Entre a insertarCabecera");
	pagina("salidaGenerica");
	codBuzon = conectorParametroLimpia("codBuzon", "", true);
    idUsuario = conectorParametroLimpia("idUsuario", "", true);
    descripcion = conectorParametroLimpia("descripcion", "", true);	

    //traza("************** codBuzon " + codBuzon);
    //traza("************** idUsuario " + idUsuario);
    //traza("************** descripcion " + descripcion);
	
	DTOCabecera dtoe = new DTOCabecera();
	dtoe.setCodBuzon(codBuzon);
	dtoe.setIdUsuario(idUsuario);		
	dtoe.setDescripcion(descripcion);
	dtoe.setOidPais(new Long(sPais));
	//traza("antes de la llamada  " + dtoe);
	MareBusinessID businessID = new MareBusinessID("CALInsertarCabeceraBuzon");
    Vector parametros = new Vector();
    parametros.add(dtoe);
    parametros.add(businessID);
    DruidaConector con = conectar("ConectorInsertarCabeceraBuzon", parametros);
	asignarAtributo("VAR","ejecutar","valor","reInicio()");
  }

  private void mostrarPgDetalle() throws Exception {     
    //traza("************** Entre a mostrarPgDetalle  "  + opcionMenu);

	pagina("contenido_buzon_detalle_insertar");        		

	DTOBelcorp dtoe = new DTOBelcorp();

	dtoe.setOidPais(new Long(sPais));
	dtoe.setOidIdioma(new Long(sIdioma));

	ComposerViewElementList lista = new ComposerViewElementList();
	ComposerViewElement composer1 = new ComposerViewElement();

	composer1.setIDBusiness("CALObtenerGestiones");
    composer1.setDTOE(dtoe);

	lista.addViewElement(composer1);

	ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
    conector.ejecucion();

	DruidaConector con = conector.getConector();
    asignar("COMBO", "cbGestion", con, "CALObtenerGestiones");

	asignarAtributo("VAR", "secuenciaActividad", "valor", (secuenciaActividad!=null?secuenciaActividad:""));
	oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
	asignarAtributo("VAR", "oidCabecera", "valor", oidCabecera);
	asignarAtributo("VAR", "oidPais", "valor", sPais);
	asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);	
	
  }

  private void insertarDetalle() throws Exception {   
    //traza("************** Entre a insertarDetalle");
	oidDetalle = conectorParametroLimpia("oidDetalle", "", true);
	oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
	secuenciaActividad = conectorParametroLimpia("secuenciaActividad", "", true);
	descripcionActividad = conectorParametroLimpia("descripcionActividad", "", true);
	oidContacto = conectorParametroLimpia("oidContacto", "", true);
	oidGestion = conectorParametroLimpia("oidGestion", "", true);	
	observaciones = conectorParametroLimpia("observaciones", "", true);	
	//traza("oidDetalle " + oidDetalle);
	//traza("oidCabecera  " + oidCabecera);
	//traza("oidContacto  " + oidContacto );
	//traza("oidGestion  " + oidGestion);
	//traza("observaciones  " + observaciones);
	//traza("secuenciaActividad  " + secuenciaActividad);
	//traza("descripcionActividad  " + descripcionActividad);
	pagina("salidaGenerica");
	DTODetalle dtoe = new DTODetalle();

	dtoe.setOidDetalle(oidDetalle.equals("")?null:new Long(oidDetalle));
	dtoe.setOidCabecera(oidCabecera.equals("")?null:new Long(oidCabecera));
	dtoe.setSecuenciaActividad( secuenciaActividad.equals("")?null:new Long(secuenciaActividad)  );
	dtoe.setDescripcionActividad(descripcionActividad);
	dtoe.setOidContacto( oidContacto.equals("")?null:new Long(oidContacto) );
	dtoe.setOidGestion( oidGestion.equals("")?null:new Long(oidGestion));
	dtoe.setObservaciones(observaciones);

	MareBusinessID businessID = new MareBusinessID("CALInsertarDetalleBuzon");
    Vector parametros = new Vector();
    parametros.add(dtoe);
    parametros.add(businessID);
	//traza("antes de conector");
	DruidaConector con = conectar("ConectorInsertarDetalleBuzon", parametros);     
//	asignarAtributo("VAR","ejecutar","valor","window.close();");
    
  }

  private void obtenerCabecera(DTOBusqueda dtoe) throws Exception {   
      //traza("************** Entre a obtenerCabecera");  
  	  pagina("contenido_buzon_crear");  
      MareBusinessID businessID = new MareBusinessID("CALObtenerCabeceraBuzon");
      Vector parametros = new Vector();
      parametros.add(dtoe);
      parametros.add(businessID);

	  //traza("************** Antes de conectar dtoe   " + dtoe);
	  DruidaConector con = conectar("ConectorObtenerCabecera", parametros);
	  //traza("despues de conectar");
	 /* DTOSalida dsal = (DTOSalida)con.objeto("dtoSalida");

	  RecordSet recLista = new RecordSet();
        recLista = dsal.getResultado();
        int lon = recLista.getRowCount();
	  //traza("************** Despues de conectar" + String.valueOf(lon) );  
	 */

	  if(opcionMenu.equals("Crear Buzon")) {
  		pagina("contenido_buzon_crear");          

		asignarAtributo("VAR", "habilitaBotonRedirigir", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonProcesarActividad", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonActualizar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonGuardar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonEliminar", "valor", "false");

		asignarAtributo("VAR", "oidIdioma", "valor", sIdioma);
		asignarAtributo("VAR", "oidPais", "valor", sPais);
		//traza(" antes de asignar a la lista opcionMenu " + opcionMenu);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);	
		asignar("LISTADOA", "listado1",con, "dtoSalida.resultado_ROWSET");	
	  }
	  else if(opcionMenu.equals("Actualizar Buzon")) {
		pagina("contenido_buzon_crear");  
		//traza("Actualizar Buzon 1");
		asignarAtributo("VAR", "habilitaBotonInsertarCabecera", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonInsertarDetalle", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonProcesarActividad", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonRedirigir", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonGuardar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonEliminar", "valor", "false");
		//traza("Actualizar Buzon 2 ");
	    codBuzon = conectorParametroLimpia("codBuzon", "", true);
	    secuenciaActividad = conectorParametroLimpia("secuenciaActividad", "", true);
	    descripcionBuzon = conectorParametroLimpia("descripcionBuzon", "", true);
		codCliente = conectorParametroLimpia("codCliente", "", true);
	    fechaActividadDesde = conectorParametroLimpia("fechaActividadDesde", "", true);
	    fechaActividadHasta = conectorParametroLimpia("fechaActividadHasta", "", true);
		//traza("Actualizar Buzon 3 ");
		asignarAtributo("VAR", "codBuzon", "valor", codBuzon);
		asignarAtributo("VAR", "secuenciaActividad", "valor", secuenciaActividad);
		asignarAtributo("VAR", "descripcionBuzon", "valor", descripcionBuzon);
		asignarAtributo("VAR", "codCliente", "valor", codCliente);
		asignarAtributo("VAR", "fechaActividadDesde", "valor", fechaActividadDesde);
		asignarAtributo("VAR", "fechaActividadHasta", "valor", fechaActividadHasta);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignar("LISTADOA", "listado1",con, "dtoSalida.resultado_ROWSET");	

	  }
	  else if(opcionMenu.equals("Redirigir Buzon")) {
		pagina("contenido_buzon_crear");

		asignarAtributo("VAR", "habilitaBotonInsertarCabecera", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonInsertarDetalle", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonProcesarActividad", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonActualizar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonGuardar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonEliminar", "valor", "false");
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignar("LISTADOA", "listado1",con, "dtoSalida.resultado_ROWSET");	
	  }
	  else if(opcionMenu.equals("ConsultarBuzon")) {
		//traza("ConsultarBuzon");
		pagina("contenido_buzon_crear");

		asignarAtributo("VAR", "habilitaBotonInsertarCabecera", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonInsertarDetalle", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonActualizar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonRedirigir", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonGuardar", "valor", "false");
		asignarAtributo("VAR", "habilitaBotonEliminar", "valor", "false");

	    codBuzon = conectorParametroLimpia("codBuzon", "", true);
	    secuenciaActividad = conectorParametroLimpia("secuenciaActividad", "", true);
	    descripcionBuzon = conectorParametroLimpia("descripcionBuzon", "", true);
		codCliente = conectorParametroLimpia("codCliente", "", true);
	    fechaActividadDesde = conectorParametroLimpia("fechaActividadDesde", "", true);
	    fechaActividadHasta = conectorParametroLimpia("fechaActividadHasta", "", true);
		
		asignarAtributo("VAR", "codBuzon", "valor", codBuzon);
		asignarAtributo("VAR", "secuenciaActividad", "valor", secuenciaActividad);
		asignarAtributo("VAR", "descripcionBuzon", "valor", descripcionBuzon);
		asignarAtributo("VAR", "codCliente", "valor", codCliente);
		asignarAtributo("VAR", "fechaActividadDesde", "valor", fechaActividadDesde);
		asignarAtributo("VAR", "fechaActividadHasta", "valor", fechaActividadHasta);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignar("LISTADOA", "listado1",con, "dtoSalida.resultado_ROWSET");	
	  }
  }

  private void actualizarDetalle() throws Exception {    
    //traza("************** Entre a actualizarDetalle");  	  

	pagina("contenido_buzon_detalle_insertar");        		

	DTOBelcorp dtoe = new DTOBelcorp();

	dtoe.setOidPais(new Long(sPais));
	dtoe.setOidIdioma(new Long(sIdioma));

	codCliente = conectorParametroLimpia("codCliente", "", true);

	DTOCliente dtoeCli = new DTOCliente();
	dtoeCli.setCodCliente(codCliente);
	dtoeCli.setOidPais(new Long(sPais));

	ComposerViewElementList lista = new ComposerViewElementList();
	ComposerViewElement composer1 = new ComposerViewElement();
	ComposerViewElement composer2 = new ComposerViewElement();

	composer1.setIDBusiness("CALObtenerGestiones");
    composer1.setDTOE(dtoe);

	lista.addViewElement(composer1);

	composer2.setIDBusiness("CALObtenerContactosPorCliente");
    composer2.setDTOE(dtoeCli);

	lista.addViewElement(composer2);

	ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
    conector.ejecucion();

	DruidaConector con = conector.getConector();
	
	asignar("COMBO", "cbContacto", con, "CALObtenerContactosPorCliente");
    asignar("COMBO", "cbGestion", con, "CALObtenerGestiones");

	oidCabecera = conectorParametroLimpia("oidCabecera", "", true); 
	oidDetalle = conectorParametroLimpia("oidDetalle", "", true);
	secuenciaActividad = conectorParametroLimpia("secuenciaActividad", "", true);
	descripcionActividad = conectorParametroLimpia("descripcionActividad", "", true);
	codCliente = conectorParametroLimpia("codCliente", "", true);
	oidContacto = conectorParametroLimpia("oidContacto", "", true);
	oidGestion = conectorParametroLimpia("oidGestion", "", true);
	observaciones = conectorParametroLimpia("observaciones", "", true);
	//traza("oidCabecera     oidCabecera   " + oidCabecera);
	//traza("antes de asignar a los hidden en la modificacion " + oidDetalle + " " + secuenciaActividad + " " + descripcionActividad);
	asignarAtributo("CTEXTO","txtDescripcionActividad","valor", descripcionActividad);
	asignarAtributo("CTEXTO","txtCodCliente","valor", codCliente);
	asignarAtributo("AREATEXTO","atxtObservaciones","valor", observaciones);

	asignarAtributo("VAR", "oidCliente", "valor", codCliente);
	asignarAtributo("VAR", "descripcionActividad", "valor", descripcionActividad);
	asignarAtributo("VAR", "observaciones", "valor", observaciones);
	asignarAtributo("VAR", "oidDetalle", "valor", oidDetalle);
	asignarAtributo("VAR", "secuenciaActividad", "valor", secuenciaActividad);
	asignarAtributo("VAR", "oidContacto", "valor", oidContacto);
	asignarAtributo("VAR", "oidGestion", "valor", oidGestion);
	asignarAtributo("VAR", "oidCabecera", "valor", oidCabecera);
	asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	asignarAtributo("VAR", "oidPais", "valor", sPais);
	//traza("antes de setear el paissssssssss    " + sPais );

  }

  private void mostrarPgRedirigir() throws Exception {    
    //traza("************** Entre a mostrarPgRedirigir");  	  	  

	pagina("contenido_buzon_redirigir");        		
	DTOBelcorp dtoe = new DTOBelcorp();
	dtoe.setOidPais(new Long(sPais));
	dtoe.setOidIdioma(new Long(sIdioma));
	ComposerViewElementList lista = new ComposerViewElementList();
	ComposerViewElement composer1 = new ComposerViewElement();

	composer1.setIDBusiness("CALObtenerCodBuzon");
    composer1.setDTOE(dtoe);
	lista.addViewElement(composer1);
	
	ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
    conector.ejecucion();
	DruidaConector con = conector.getConector();
	//traza("antes de asignar");
//    asignar("COMBO", "cbCodBuzonNuevo", con, "CALObtenerGestiones");
	asignar("COMBO", "cbCodBuzonNuevo", con, "CALObtenerCodBuzon");
	oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
	oidsDetalle = conectorParametroLimpia("oidsDetalle", "", true);
	codBuzonActual = conectorParametroLimpia("codBuzon", "", true);

	//traza("oidCabecera  " + oidCabecera + "oidsDetalle  " + oidsDetalle + "codBuzonActual  " + codBuzonActual);
	
	asignarAtributo("VAR", "oidCabecera", "valor", oidCabecera);
	asignarAtributo("LABELC", "lbldtCodBuzonActual", "valor", codBuzonActual);
	asignarAtributo("VAR", "oidsDetalle", "valor", oidsDetalle);
	
  }

  private void redirigirActividad() throws Exception {     
    //traza("************** Entre a redirigirActividad");  	  	  
	pagina("salidaGenerica");
	Long[] valores = null;

	oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
	listaOidDetalle = conectorParametroLimpia("oidsDetalle", "", true);	
	oidCabeceraNuevo = conectorParametroLimpia("oidCabeceraNuevo", "", true);
	//traza("oidCabecera  " + oidCabecera  );
	//traza("listaOidDetalle  " + listaOidDetalle );
	//traza("oidCabeceraNuevo  " + oidCabeceraNuevo);
	
	StringTokenizer st = new StringTokenizer(listaOidDetalle, ",");
	valores = new Long[st.countTokens()];
	int i = 0;
    while (st.hasMoreElements()) {
		valores[i] = Long.valueOf(st.nextToken());
		i = i+1;
	//traza("String.valueOf(i)   " + String.valueOf(i)); 
    }
	DTORedirigirDetalle dtoe = new DTORedirigirDetalle();
	
	dtoe.setOidCabecera(new Long(oidCabecera));
	dtoe.setListaOidDetalle(valores);
	dtoe.setOidCabeceraNuevo(new Long(oidCabeceraNuevo));

	MareBusinessID businessID = new MareBusinessID("CALRedirigirActividad");
    Vector parametros = new Vector();
    parametros.add(dtoe);
    parametros.add(businessID);
	//traza("antes de conectar");
    DruidaConector con = conectar("ConectorRedirigirActividad", parametros);
	//traza("despues de conectar redirigirActividad");
  }

  private void procesarActividad() throws Exception {   
    //traza("************** Entre a procesarActividad");  	  	  
	pagina("salidaGenerica");
//	pagina("contenido_buzon_crear");
	oidDetalle = conectorParametroLimpia("oidDetalle", "", true);
	//traza("oidDetalle  " + oidDetalle);
	DTODetalle dtoe = new DTODetalle();
	dtoe.setOidDetalle(new Long(oidDetalle));

	MareBusinessID businessID = new MareBusinessID("CALProcesarActividad");
    Vector parametros = new Vector();
    parametros.add(dtoe);
    parametros.add(businessID);
	//traza("antes de conectar procesarActividad");
    DruidaConector con = conectar("ConectorProcesarActividad", parametros);
	asignarAtributo("VAR","ejecutar","valor","reInicio()");
  }


	private void seteaTitulo() throws Exception {
		//traza("la opcion de menu antes de setear el titulo  " + opcionMenu);
		if (opcionMenu.equals("Crear Buzon"))
		{
			if(accion.equals("mostrar detalle")){
				asignarAtributoPagina("cod","0588");
			}else if(accion.equals("mostrar cabecera")){
				asignarAtributoPagina("cod","0587");
			}
			else{
				//traza("Antes de 0586");
				asignarAtributoPagina("cod","0586");
			}	
		}
		else if(opcionMenu.equals("Redirigir Buzon") || accion.equals("redirigir detalle") ) {

			asignarAtributoPagina("cod","0589");
		}
		else if(opcionMenu.equals("ConsultarBuzon")) {

			asignarAtributoPagina("cod","0591");
		}
		else if(opcionMenu.equals("Actualizar Buzon")) {

			asignarAtributoPagina("cod","0590");
		}
	}

  private DTOBusqueda crearDtoCabecera() throws Exception {  
    //traza("************** Entre a crearDtoCabecera");  	  	  
	
	codBuzon = conectorParametroLimpia("codBuzon", "", true);
	secuenciaActividad = conectorParametroLimpia("secuenciaActividad", "", true);
	descripcionBuzon = conectorParametroLimpia("descripcionBuzon", "", true);
	codCliente = conectorParametroLimpia("codCliente", "", true);
	fechaActividadDesde = conectorParametroLimpia("fechaActividadDesde", "", true);
	fechaActividadHasta = conectorParametroLimpia("fechaActividadHasta", "", true);	
	descripcionActividad = conectorParametroLimpia("descripcionActividad", "", true);	


	DTOBusqueda	dtoe = new DTOBusqueda();
	//traza("antes de setear en el dtoe" + secuenciaActividad);
	dtoe.setOidPais(new Long(sPais));
	dtoe.setCodBuzon(codBuzon);
	dtoe.setSecActividad(secuenciaActividad.equals("")?null:new Long(secuenciaActividad));
	dtoe.setDescripBuzon(descripcionBuzon);
	dtoe.setCodCliente(codCliente);
	dtoe.setFechaActividadDesde(fechaActividadDesde.equals("")?null:toDate(fechaActividadDesde));
	dtoe.setFechaActividadHasta(fechaActividadHasta.equals("")?null:toDate(fechaActividadHasta));
	dtoe.setDescripActividad(descripcionActividad);



	//traza("**************por salir de crearDtoCabecera");
	return dtoe;
  }

  //Para pasar un String a un Date
  private Date toDate(String sFecha) throws Exception{
    //traza("************** Entre a toDate");  	  	  
	//traza("************** sFecha " + sFecha);  	  	  

	String formatoFecha = UtilidadesSession.getFormatoFecha(this);
    return this.toDate(sFecha, formatoFecha);
  }

  private Date toDate(String sFecha, String formatoFecha) throws Exception {		
    //traza("************** Entre a toDate");  	  	  
	//traza("************** sFecha " + sFecha);  	  	  
	//traza("************** formatoFecha " + formatoFecha);  	  	  

    formatoFecha = formatoFecha.replace('m', 'M');	
	SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
	java.util.Date fecha = miFecha.parse(sFecha);
    miFecha = new SimpleDateFormat(formatoFecha);

	String fechaRes = miFecha.format(fecha);
	fecha = miFecha.parse(fechaRes);
    java.sql.Date sql = new java.sql.Date(fecha.getTime());    
	//traza("************** sql " + sql);  	  	  
	return sql;
  }

  private String dateToString(Date dFecha) throws Exception{
    //traza("************** Entre a dateToString");  	  	  
    //traza("************** dFecha " + dFecha);  	  	  

    String formato = UtilidadesSession.getFormatoFecha(this);
    formato = formato.replace('m', 'M');
	SimpleDateFormat miFecha = new SimpleDateFormat(formato);
	String fechaRes = miFecha.format(dFecha);		  
    //traza("************** fechaRes " + fechaRes);  	  	  
	return fechaRes;
  }

  private void cargarMenuSecundario() throws Exception {  
    //traza("************** Entre a cargarMenuSecundario" + accion);  	  	  

	if (accion.equals("")) {
		//getConfiguracionMenu("LPBuzon","");
		getConfiguracionMenu();
    }
	else if(accion.equals("mostrar cabecera")) {
		getConfiguracionMenu("LPBuzon","mostrar cabecera");
	}
	else if(accion.equals("insertar cabecera")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","insertar cabecera");
	}
	else if(accion.equals("mostrar detalle")) {
		getConfiguracionMenu("LPBuzon","mostrar detalle");
	}
	else if(accion.equals("insertar detalle")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","insertar detalle");
	}
	else if(accion.equals("buscar cabecera")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","buscar cabecera");
	}
	else if(accion.equals("actualizar detalle")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","actualizar detalle");
	}
	else if(accion.equals("redirigir detalle")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","redirigir detalle");
	}
	else if(accion.equals("redirigir actividad")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","redirigir actividad");
	}
	else if(accion.equals("procesar actividad")) {
		//falta la linea correspondiente en el archivo menusecundario.properties 
		getConfiguracionMenu("LPBuzon","procesar actividad");
	}
  }
}