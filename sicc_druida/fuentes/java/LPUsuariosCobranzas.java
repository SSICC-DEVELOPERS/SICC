import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOUsuarioCobranzas;
import es.indra.sicc.dtos.men.DTOIdentUsuario;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.Vector;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LPUsuariosCobranzas extends LPSICCBase
{   
    private String accion = "";
    private String oidUsuarioCob = "";
	private String sPais = "";     
	private String sDescPais = "";
    private String sIdioma = "";    
    private String casoDeUso = "";    
    private String idUsuario = "";
    private String estadoAnterior = "";    
    private String codUsuario = "";
    private String nombre = "";    
    private String estadoUsuario = "";
    private String fechaUltimoEstado = "";
    private String jefeCobranza = "";
    private String usuarioSupervisorEspecial = "";
    private String usuarioExterno = "";
    private String turnoHorarioEntrada = "";
    private String turnoHorarioSalida = "";
    private String codUsuarioSupervisor = "";
    private String codUsuarioRespaldo = "";
    private String observaciones = "";
	private String usuarioSupervisorEspecialAnterior = "";
          
	public LPUsuariosCobranzas() {super();}
	
	public void inicio() throws Exception 
    {    
    }

	public void ejecucion() throws Exception 
	{
      rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPUsuariosCobranzas - ejecucion ***");
		
		sPais = UtilidadesSession.getPais(this).toString();    
      traza(" pais en ejecucion: " + sPais);
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		try  
		{	
			//rastreo();
			accion = conectorParametroLimpia("accion", "", true);
			casoDeUso = conectorParametroLimpia("casoDeUso", "", true);


			traza("***** caso de uso '"+ casoDeUso +"'");      
			traza("***** accion      '"+ accion +"'");      

			if("insertar".equals(accion)){
				//traza("en insertar antes de llamar metodo mostrarPgUsuariosCob");         
				    mostrarPgUsuariosCob();
                asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
                asignarAtributoPagina("cod","0935");
			}
         if("modificar usuario".equals(accion) || "detalle usuario".equals(accion)){
                //traza("entro en modificar usuario");        
                oidUsuarioCob = conectorParametroLimpia("oidUsuarioCob", "", true);        
                mostrarPgUsuariosCob();

                if("modificar usuario".equals(accion)){
                    asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
                    asignarAtributoPagina("cod","0936");
                }
                if("detalle usuario".equals(accion)){
                    asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
                    asignarAtributoPagina("cod","0938");
                }
         }      
         if("modificar".equals(accion) || "eliminar".equals(accion) || "consultar".equals(accion)) {
     				mostrarPgBuscarUsuariosCob();        
                if("modificar".equals(accion))
                    asignarAtributoPagina("cod","0936");
                if("consultar".equals(accion))
                    asignarAtributoPagina("cod","0938");
                if("eliminar".equals(accion))
                    asignarAtributoPagina("cod","0937");      
         }
			if("recuperar nombre".equals(accion)){	
                recuperarNombre();   
			}
         if("guardar".equals(accion)){
				   guardarUsuarioCobranzas();
					traza("asignando casoDeUso ");
					asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
		         asignarAtributoPagina("cod","0935");
		   }
		 } 
		catch ( Exception e ) {

			traza("******** Entro al catch debido a...");
			asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
			e.printStackTrace(); 
			lanzarPaginaError(e);
		}	
        getConfiguracionMenu();
		  traza("*** Salida - LPUsuariosCobranzas - ejecucion ***");
	}
    
	private void mostrarPgUsuariosCob() throws Exception
	{
		traza("*** Entrada - LPUsuariosCobranzas - mostrarPgUsuariosCob() ***");
        //traza("entre metodo mostrarPgUsuariosCob()");
        /*Llamar al metodo cargarCombo() 
            Si accion="detalle usuario"{ 
            Llamar al metodo recuperarCampos() con el oidUsuarioCob procedente de la pantalla 
            Muestra la pantalla PanatallaUsuariosCobranzas con: 
            -oidUsuarioCob= DTOUsuarioCobranzas.oid 
            - codUsuario= codusuario recepcionado de la pantallaBuscarUsuariosCob. campo deshabilitado 
            - nombre= name recepcionado de la pantallaBuscarUsuariosCob. campo deshabilitado 
            - cbEstadoUsuario= valor correspondiente al DTOUsuarioCobranzas.oidEstadoUsuario // procedente de recuperarCampos 
            - los demas valores del DTOUsuarioCobranzas 
            Deshabilitar todos los campos //puesto que se trata de una consulta } */		
        /*if("detalle usuario".equals(accion))
        {   if(oidUsuarioCob != null && !"".equals(oidUsuarioCob))
          {   //DTOSalida dto  = new DTOSalida();
              //DTOUsuarioCobranzas dto = (DTOUsuarioCobranzas)recuperarCampos(new Long(oidUsuarioCob));                          
              pagina("contenido_usuarios_cobranzas_insertar"); // PanatallaUsuariosCobranzas
              // TODO:
              cargarCombo();
          }
        }*/
        /*Si accion="insertar"{ 
        Muestra la pantalla PanatallaUsuariosCobranzas con: 
        - campo nombre deshabilitado. 
        - fechaUltimoEstado= fecha del sistema 
        } */      
        if("insertar".equals(accion))
        {   //traza("2  contenido_usuarios_cobranzas_insertar ");
            pagina("contenido_usuarios_cobranzas_insertar");
            //traza("3");
            String dFechaTmp = null;
            java.util.Date hoy = new java.util.Date(System.currentTimeMillis() );
            String formatoFecha = UtilidadesSession.getFormatoFecha(this);
            formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.
            SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);
            try {
                dFechaTmp = simpledateformat.format(hoy);					
            } catch(Exception e) {}				
            asignarAtributo("CTEXTO","txtFechaUltimoEstado","valor",  dFechaTmp.toString());
            asignarAtributo("VAR", "accion", "valor", "insertar");
            cargarCombo(); 
			
        }
        /*Si accion="modificar usuario"{ 
        Llamar al metodo recuperarCampos() con el oidUsuarioCob procedente de la pantalla 
        Muestra la pantalla PanatallaUsuariosCobranzas con: 
        -oidUsuarioCob= oidUsuarioCob recepcionado de la pantallaBuscarUsuariosCob (campo oculto) //seria el mismo que el DTOSalida.oid 
        - codUsuario= codUsuario recepcionado de la pantallaBuscarUsuariosCob. campo deshabilitado 
        - nombre= name recepcionado de la pantallaBuscarUsuariosCob. campo deshabilitado 
        - cbEstadoUsuario= valor correspondiente al DTOSalida.oidEstadoUsuario // procedente de recuperarCampos 
        - estadoAnterior= DTOSalida.oidEstadoUsuario //Se almacena en una variable, el oidEstadoUsuario con el fin de saber cual era el estado anterior. 
        - los demas valores del DTOSalida //procedentes de recuperarCampos() 
        } */
        if("cerrar".equals(accion))
        { 
            pagina("contenido_usuarios_cobranzas_insertar");
            asignarAtributo("VAR", "cerrarVentana", "valor", "1");           
        }
    
        if("modificar usuario".equals(accion) || "detalle usuario".equals(accion))
        { 
            pagina("contenido_usuarios_cobranzas_insertar");            
            oidUsuarioCob = conectorParametroLimpia("oid", "", true);
            //traza("oidUsuarioCob:  " + oidUsuarioCob);
            if(oidUsuarioCob != null && !"".equals(oidUsuarioCob))
            { 
                DTOUsuarioCobranzas dtos = new DTOUsuarioCobranzas();
                //traza("CALL: recuperarCampos(new Long(oidUsuarioCob) :  " + oidUsuarioCob);
                dtos = recuperarCampos(new Long(oidUsuarioCob));          
                if(dtos != null)
                {   //traza("      recuperarCampos(new Long(oidUsuarioCob)  ...... [OK] ");          
                    cargarCombo();              
                    asignarAtributo("VAR","oidUsuarioCob", "valor", oidUsuarioCob);                
                    if(dtos.getIdUsuario() != null)
                        asignarAtributo("VAR","idUsuario","valor", dtos.getIdUsuario().toString());                
                    if(dtos.getCodUsuario() != null)
                        asignarAtributo("CTEXTO","txtCodUsuario","valor",  dtos.getCodUsuario());                
                        asignarAtributo("CTEXTO","txtCodUsuario","disabled", "true");                
                    if(dtos.getNombre() != null)
                        asignarAtributo("CTEXTO","txtNombre","valor",  dtos.getNombre());                  
                    if(dtos.getOidEstadoUsuario() != null)
                    {   //traza(" oidEstadoUsuario -> " + dtos.getOidEstadoUsuario().toString());
                        asignarAtributo("VAR","oidEstadoUsuario","valor",  dtos.getOidEstadoUsuario().toString());
						//Incidencia 14377 Marta Montiel
						asignarAtributo("VAR","estadoAnterior","valor",  dtos.getOidEstadoUsuario().toString());
                    }                                    
                    if(dtos.getFechaUltimoEstado() != null) // fecha
                        asignarAtributo("CTEXTO","txtFechaUltimoEstado","valor",  dateToString(dtos.getFechaUltimoEstado()));          
                    if(dtos.getTurnoHorarioSalida() != null)
                        asignarAtributo("CTEXTO","txtTurnoHorarioSalida","valor",  dtos.getTurnoHorarioSalida());
                    if(dtos.getTurnoHorarioEntrada() != null)
                        asignarAtributo("CTEXTO","txtTurnoHorarioEntrada","valor",  dtos.getTurnoHorarioEntrada());
                    if(dtos.getCodUsuarioRespaldo() != null)
                        asignarAtributo("CTEXTO","txtCodUsuarioRespaldo","valor",  dtos.getCodUsuarioRespaldo());
                    if(dtos.getCodUsuarioSupervisor() != null)
                        asignarAtributo("CTEXTO","txtCodUsuarioSupervisor","valor",  dtos.getCodUsuarioSupervisor());             
                    if(dtos.getObservaciones() != null)    
                        asignarAtributo("AREATEXTO","areatxtObservaciones","valor",  dtos.getObservaciones());                            
                    if(dtos.getIndJefeCobranza() != null)
                        asignarAtributo("CHECKBOX","ckJefeCobranza","check",  (dtos.getIndJefeCobranza().booleanValue())?"S":"N"); 
                    if(dtos.getIndUsuarioSupervisor() != null)
					{
                        asignarAtributo("CHECKBOX","ckUsuarioSupervisorEspecial","check",  (dtos.getIndUsuarioSupervisor().booleanValue())?"S":"N");                          
						// inc. 16641 idedough  20/04/05
						asignarAtributo("VAR","IndUsuarioSupervisorAnterior","valor",  (dtos.getIndUsuarioSupervisor().booleanValue())?"1":"0");
					}
					if(dtos.getIndUsuarioExterno() != null)    
                        asignarAtributo("CHECKBOX","ckUsuarioExterno","check",  (dtos.getIndUsuarioExterno().booleanValue())?"S":"N");                
                
				
				}
                else
                {
                    //pagina("salidaGenerica"); 
                    //asignarAtributo("VAR", "cerrarVentana", "valor", "0"); 
                    asignarAtributo("VAR", "hCerrar", "valor", "1");
                    //asignarAtributo("VAR", "ejecutar", "valor", "registroFueraCondicion()");
                }
                /* dtos.getEstadoAnterior(); */
            }
        }	    
    traza("*** Salida - LPUsuariosCobranzas - mostrarPgUsuariosCob() ***");
	 }

    private void mostrarPgBuscarUsuariosCob() throws Exception
	{
        pagina("contenido_usuarios_cobranzas_modificar");
		cargarCombo();
        asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
	}

	private void cargarCombo() throws Exception
    { 
	traza("*** Entrada - LPUsuariosCobranzas - cargarCombo() ***");
		/*Crear un DTOBelcorp dtoe con: 
		- pais = Pais activo 
		- idioma = Idioma del usuario 
		Crear una lista ComposerViewElementList 
		//estado usuario 
		Crear un elemento de tipo ComposerViewElement() para cargar los estados de usuarios 
		elem.IDBusiness="COBObtenerEstadoUsuario"; 
		elem.DTOE=dtoe; 
		Añadir el elemento a la lista 
		Invocar al subsistema GestorCargaPantalla 
		Asigna el combo: 
		- cbEstadoUsuario <- COBObtenerEstadoUsuario */

		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(new Long(sPais));
		dtoe.setOidIdioma(new Long(sIdioma));
		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();

		cve.setIDBusiness("COBObtenerEstadoUsuarioCob");
		cve.setDTOE(dtoe);
		list.addViewElement(cve);

		ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
        conector.ejecucion();
        DruidaConector con = conector.getConector();

      asignar("COMBO", "cbEstadoUsuario", con, "COBObtenerEstadoUsuarioCob");

		  	traza("*** Salida - LPUsuariosCobranzas - cargarCombo() ***");
	}

	private void loadComboByBID(String _cmb_name, String _bid) throws Exception
	{   DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(new Long(sPais)); dtoe.setOidIdioma(new Long(sIdioma));
		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();
		cve.setIDBusiness(_bid);cve.setDTOE(dtoe);list.addViewElement(cve);
		ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
		conector.ejecucion();DruidaConector con = conector.getConector();
		asignar("COMBO", _cmb_name, con, _bid);
	}

	private void recuperarNombre () throws Exception
	{   
		traza("LPUsuariosCobranzas.recuperarNombre(): Entrada ");
		/*- Crear un DTOE del tipo DTOIdentUsuario con el codUsuario recibido de la pantalla: 
		DTOE.codUsuario=codUsuario 
		- Invocar conector ConectorObtenerUsuario con el DTOE 
		- Crear IDBusiness="MENObtenerUsuario" 
		- Obtiene DTOS del tipo DTOIdentUsuario. */    
        
        
        pagina("salidaGenerica");    
        traza("**** ejecutó pagina('salidaGenerica'); ");
        
        DTOIdentUsuario dtoe = new DTOIdentUsuario();
                
        codUsuario = conectorParametroLimpia("txtCodUsuario", "", true);
        traza("**** se obtine codigo de usuario ingresado (" + codUsuario+")");
        //traza("codUsuario en recuperarNombre:  " + codUsuario);
        

        dtoe.setCodUsuario(codUsuario.toUpperCase());    
  		  traza("**** MAYUSC de codigo de usuario ingresado (" + codUsuario.toUpperCase()+")");
		  
   	  MareBusinessID businessID = new MareBusinessID("MENObtenerUsuario");
	     Vector params = new Vector();
        params.add(dtoe);
		  params.add(businessID);
		
 		  traza("**** por obtener datos del usuario (" + codUsuario+")");
        DruidaConector conectorObtenerUsuario = conectar("ConectorObtenerUsuario", params);
        
        traza("**** por obtener datos del usuario y asignarlo a un DTOIdentUsuario ");
        DTOIdentUsuario dtos = (DTOIdentUsuario)conectorObtenerUsuario.objeto("DTOIdentUsuario");    
		  traza("**** se obtien DTOIdentUsuario: "+ dtos);
        
        
		  /*
			- Crear funcion javascript que asigne a la pantallaUsuariosCobranza el campo: 
		     nombre= DTOS.cadenaNombre y a la variable idUsuario=DTOS.idUsuario 
			  
		  */    
        if(dtos.getIdUsuario() != null && dtos.getCadenaNombre() != null)
        {

				asignarAtributo("VAR", "cerrarVentana", "valor", "0"); 
				traza("**** asignando a VAR 'cerrarVentana' <-- '0' ");

            asignarAtributo("VAR", "ejecutar", "valor", "setear('" + dtos.getIdUsuario().toString() + "','" + dtos.getCadenaNombre() + "')");         
				traza("**** asignando a VAR 'ejecutar' <-- "+ dtos.getIdUsuario().toString() + "','" + dtos.getCadenaNombre());
				
        }
        else
        {
            asignarAtributo("VAR", "cerrarVentana", "valor", "0"); 
				traza("**** asignando a VAR 'cerrarVentana' <-- '0' ");

				asignarAtributo("VAR", "ejecutar", "valor", "avisar('" + codUsuario + "')");   
				traza("**** asignando a VAR 'ejecutar' <-- " + "avisar('" + codUsuario + "')");

				traza("**** por mostrar mensaje de 'codigo no en' ");
				//el mensaje que muestra es 'El código de cliente no existe' debemos poner uno que diga 'El código de usuario es inexistente'
				//asignarAtributo("PAGINA", "salidaGenerica", "onload", "cdos_mostrarAlert(GestionarMensaje('UICAL0003'));close();");	
				//asignarAtributo("PAGINA", "salidaGenerica", "onload", "mostrarAlert()");	
				asignarAtributo("VAR", "ejecutar", "valor", "mostrarAlert()");	

		  }
        
        traza("LPUsuariosCobranzas.recuperarNombre():Salida ");
        
	}

	private void addSCRIPT(String _codigo_script) throws Exception
	{   Element element = getXML().getDocumentElement();
		NodeList javascript = element.getElementsByTagName("JAVASCRIPT");
		CDATASection cdata = null; Element script = null;
		// cree elemento "JAVASCRIPT" en xml de Druida si no existe
		if(javascript.getLength() == 0)
		{   script = element.getOwnerDocument().createElement("JAVASCRIPT");
			cdata = element.getOwnerDocument().createCDATASection(_codigo_script);
			script.appendChild(cdata);
			element.insertBefore(script,
			element.getElementsByTagName("FORMULARIO").item(0));
		}  // solo agrega codigo de js dentro de tag "JAVASCRIPT" existente de tipo CDATA
		else
		{   script = (Element)javascript.item(0);
            NodeList lista = script.getChildNodes();
            int largo = lista.getLength();
            for(int i = 0; i < largo; i++)
            {   Node actual = lista.item(i);
                if(actual.getNodeType() == Node.CDATA_SECTION_NODE)
                {   cdata = (CDATASection)actual;
                    cdata.setData(_codigo_script);
                    break;
                }
            }
		}
	}

	private void guardarUsuarioCobranzas() throws Exception
	{   /*- Crear un DTOE del tipo DTOUsuarioCobranzas con los parametros recibidos de la pantalla: 
		DTOE.oidUsuarioCob=oidUsuarioCob 
		DTOE.idUsuario=idUsuario 
		DTOE.codUsuario=codUsuario 
		DTOE.nombre=nombre 
		DTOE.oidEstadoUsuario=oidEstadoUsuario 
		DTOE.estadoAnterior= estadoAnterior //en el caso de insercion vendra a null, porq no tiene estado anterior 
		DTOE.fechaUltimoEstado=fechaUltimoEstado 
		DTOE.indJefeCobranza=indJefeCobranza 
		DTOE.indUsuarioSupervisor=indUsuarioSupervisor 
		DTOE.indUsuarioExterno=indUsuarioExterno 
		DTOE.turnoHorarioEntrada=turnoHorarioEntrada 
		DTOE.turnoHorarioSalida=turnoHorarioSalida 
		DTOE.codUsuarioSupervisor=codUsuarioSupervisor 
		DTOE.codUsuarioRespaldo=codUsuarioRespaldo 
		DTOE.observaciones=observaciones 

		- Invocar conector ConectorGuardarUsuarioCobranzas con el DTOE 
		- Crear IDBusiness="COBGuardarUsuarioCobranzas*/

		pagina("salidaGenerica");
//		pagina("contenido_usuarios_cobranzas_insertar");
		
		
        oidUsuarioCob =  conectorParametroLimpia("oidUsuarioCob", "", true); 		
        codUsuario = conectorParametroLimpia("txtCodUsuario", "", true);		
        nombre = conectorParametroLimpia("txtNombre", "", true);
        estadoUsuario = conectorParametroLimpia("cbEstadoUsuario", "", true);
		estadoAnterior = conectorParametroLimpia("estadoAnterior", "", true);
        fechaUltimoEstado = conectorParametroLimpia("txtFechaUltimoEstado", "", true);    
        jefeCobranza = conectorParametroLimpia("ckJefeCobranza", "", true);
        usuarioSupervisorEspecial = conectorParametroLimpia("ckUsuarioSupervisorEspecial", "", true);        

		usuarioSupervisorEspecialAnterior = conectorParametroLimpia("IndUsuarioSupervisorAnterior", "", true);

        usuarioExterno = conectorParametroLimpia("ckUsuarioExterno", "", true);    
        turnoHorarioEntrada = conectorParametroLimpia("txtTurnoHorarioEntrada", "", true);
        turnoHorarioSalida = conectorParametroLimpia("txtTurnoHorarioSalida", "", true);
        codUsuarioSupervisor = conectorParametroLimpia("txtCodUsuarioSupervisor", "", true);	
        codUsuarioRespaldo = conectorParametroLimpia("txtCodUsuarioRespaldo", "", true);    
        observaciones = conectorParametroLimpia("areatxtObservaciones", "", true);    
        idUsuario = conectorParametroLimpia("idUsuario", "", true);

		traza("********** oidUsuarioCob " + oidUsuarioCob);
		traza("********** codUsuario " + codUsuario);
		traza("********** nombre " + nombre);
		traza("********** estadoUsuario " + estadoUsuario);
		traza("********** estadoAnterior " + estadoAnterior);
		traza("********** fechaUltimoEstado " + fechaUltimoEstado);
		traza("********** jefeCobranza " + jefeCobranza);
		traza("********** usuarioSupervisorEspecial " + usuarioSupervisorEspecial);
		traza("********** usuarioSupervisorEspecialAnterior " + usuarioSupervisorEspecialAnterior);
		traza("********** usuarioExterno " + usuarioExterno);
		traza("********** turnoHorarioEntrada " + turnoHorarioEntrada);
		traza("********** turnoHorarioSalida " + turnoHorarioSalida);

		traza("********** codUsuarioSupervisor " + codUsuarioSupervisor);
		traza("********** codUsuarioRespaldo " + codUsuarioRespaldo);
		codUsuarioSupervisor = codUsuarioSupervisor.toUpperCase();
		codUsuarioRespaldo = codUsuarioRespaldo.toUpperCase();
		traza("********** UPPER codUsuarioSupervisor " + codUsuarioSupervisor);
		traza("********** UPPER codUsuarioRespaldo " + codUsuarioRespaldo);

		traza("********** observaciones " + observaciones);
		traza("********** idUsuario " + idUsuario);

		traza("4");
        //estadoAnterior = conectorParametroLimpia("estadoAnterior", "", true);        
        //traza("seteo ");    
        DTOUsuarioCobranzas dtoe = new DTOUsuarioCobranzas();	
        dtoe.setIdUsuario(("".equals(idUsuario))?null:new Long(idUsuario));	
        dtoe.setNombre(("".equals(nombre))?null:nombre);    
		/*
        dtoe.setEstadoAnterior("".equals(estadoUsuario)?null:new Long(estadoUsuario));        
        */
		//Incidencia 14377 Modificado Marta Montiel
		dtoe.setEstadoAnterior("".equals(estadoAnterior)?null:new Long(estadoAnterior));
		if(!"".equals(usuarioSupervisorEspecial))
            dtoe.setIndUsuarioSupervisor("S".equals(usuarioSupervisorEspecial)?Boolean.TRUE:Boolean.FALSE);
	    if(!"".equals(usuarioSupervisorEspecialAnterior))
            dtoe.setIndUsuarioSupervisorAnterior("1".equals(usuarioSupervisorEspecialAnterior)?Boolean.TRUE:Boolean.FALSE);
        if(!"".equals(jefeCobranza))
            dtoe.setIndJefeCobranza("S".equals(jefeCobranza)?Boolean.TRUE:Boolean.FALSE);     
        if(!"".equals(usuarioExterno)) 
            dtoe.setIndUsuarioExterno("S".equals(usuarioExterno)?Boolean.TRUE:Boolean.FALSE);   
		dtoe.setOidEstadoUsuario("".equals(estadoUsuario)?null:new Long(estadoUsuario));     
        dtoe.setTurnoHorarioEntrada("".equals(turnoHorarioEntrada)?null:turnoHorarioEntrada);
		dtoe.setTurnoHorarioSalida("".equals(turnoHorarioSalida)?null:turnoHorarioSalida);		
        dtoe.setFechaUltimoEstado("".equals(fechaUltimoEstado)?null:toDate(fechaUltimoEstado));
        dtoe.setCodUsuario("".equals(codUsuario)?null:codUsuario);
        // codes usuario respaldo/supervisor
        dtoe.setCodUsuarioSupervisor("".equals(codUsuarioSupervisor)?null:codUsuarioSupervisor);
        dtoe.setCodUsuarioRespaldo("".equals(codUsuarioRespaldo)?null:codUsuarioRespaldo);    
        dtoe.setObservaciones("".equals(observaciones)?null:observaciones);	
		
		if(!oidUsuarioCob.equals("")) {
			traza("********** Entre al segundo if");
			traza("********** oidUsuarioCob " + oidUsuarioCob);
			dtoe.setOidUsuarioCobranza(new Long(oidUsuarioCob)); 
		}

		traza("seteo ");
		//pagina("contenido_usuarios_cobranzas_insertar");
        // pais, idioma
		//sPais = UtilidadesSession.getPais(this).toString();
        traza("sPais:  " + sPais);
        dtoe.setOidPais(new Long(sPais));
        //dtoe.setOidIdioma(new Long(sIdioma));
		MareBusinessID businessID = new MareBusinessID("COBGuardarUsuarioCobranzas");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);

		String caso = conectorParametroLimpia("casoDeUso", "", true);
        traza("************ caso " + caso);

		try {
	        traza("antes de guardar");
			DruidaConector con = conectar("ConectorGuardarUsuarioCobranzas", params); 
			traza("despues de guardar" + accion);
			//Comentado por Cristian Valenzuela
	        //accion = ("modificar".equals(accion))?"cerrar":"insertar";    
		    //mostrarPgUsuariosCob();			

			if(caso.equals("insertar")) {
		      traza("********** Ejecutar llama a reInicio");
			  asignarAtributo("VAR","ejecutar","valor","reInicio()");
	        }
		    else {
			  traza("********** Ejecutar llama a reModifica");
	          asignarAtributo("VAR","ejecutar","valor","reModifica();");
		    }      
		}
		catch (Exception e) {
			traza("******************* Entrando al catch...");
			traza("******************* accion " + accion);
			traza("******************* casoDeUso " + casoDeUso);
			asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso );
	        if(caso.equals("insertar")) {
               asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarI()");
		    }
			else {
	          asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarM()");
		    }  
			throw e;
		}
	}

    private DTOUsuarioCobranzas recuperarCampos(Long oidUsuarioCob) throws Exception
	{   /*- Crear un DTOE del tipo DTOOid con el oidUsuarioCob recibido de la pantalla: 
		DTOE.oid=oidUsuarioCob 
		- Invocar conector ConectorRecuperarUsuarioCob con el DTOE 
		- Crear IDBusiness="COBRecuperarUsuarioCob" 
		- Obtiene DTOS del tipo DTOUsuarioCobranzas  */
        //traza("# in recuperarCampos(Long oidUsuarioCob)");
        DTOOID dtoe = new DTOOID();
        dtoe.setOid(oidUsuarioCob);
        MareBusinessID businessID = new MareBusinessID("COBRecuperarUsuarioCob");
		Vector params = new Vector();
        params.add(dtoe); params.add(businessID);
        //traza("# conectar ->  ConectorRecuperarUsuarioCob ");
		DruidaConector con = conectar("ConectorRecuperarUsuarioCob", params);
        //traza("# conectar ->  ConectorRecuperarUsuarioCob ....... [OK] ");   
        DTOSalida dtos = new DTOSalida();    
        dtos = (DTOSalida)con.objeto("DTOSalida");   
        //traza(dtos);    
        RecordSet rs = new RecordSet();   
        rs = dtos.getResultado();
        DTOUsuarioCobranzas dtoUsuCob = null;    
        if(!rs.esVacio())
        {
            //dtoUsuCob.setIdUsuario(new Long());
            //dtoUsuCob.setNombre(rs.getValueAt(0,1).toString());      
            //DTOIdentUsuario dtoe2 = new DTOIdentUsuario(); 
            dtoUsuCob = new DTOUsuarioCobranzas();
            codUsuario = conectorParametroLimpia("codUsuario", "", true);
            nombre = conectorParametroLimpia("nombre", "", true);
            idUsuario = conectorParametroLimpia("idUsuario", "", true);      
            //traza("idUsuario en recuperarNombre:  " + idUsuario);
            //traza("codUsuario en recuperarNombre:  " + codUsuario);
            dtoUsuCob.setIdUsuario(new Long(idUsuario));      
            //traza("nombre en recuperarNombre:  " + nombre);
            dtoUsuCob.setNombre(nombre);      
            dtoUsuCob.setCodUsuario(codUsuario);     
            if(rs.getValueAt(0,"IND_USU_SUP") != null) 
                dtoUsuCob.setIndUsuarioSupervisor(("1".equals(rs.getValueAt(0,"IND_USU_SUP").toString()))?Boolean.TRUE:Boolean.FALSE);
            if(rs.getValueAt(0,"IND_JEFE_COB") != null)
                dtoUsuCob.setIndJefeCobranza(("1".equals(rs.getValueAt(0,"IND_JEFE_COB").toString()))?Boolean.TRUE:Boolean.FALSE);
            if(rs.getValueAt(0,"IND_USU_EXTE") != null)
                dtoUsuCob.setIndUsuarioExterno(("1".equals(rs.getValueAt(0,"IND_USU_EXTE").toString()))?Boolean.TRUE:Boolean.FALSE);      
            if(rs.getValueAt(0,"OID_ESTADO") != null)     
                dtoUsuCob.setOidEstadoUsuario(new Long(rs.getValueAt(0,"OID_ESTADO").toString()));            
            if(rs.getValueAt(0,"TURNO_SALIDA") != null)
                dtoUsuCob.setTurnoHorarioSalida(rs.getValueAt(0,"TURNO_SALIDA").toString());
            if(rs.getValueAt(0,"TURNO_ENTRADA") != null)
                dtoUsuCob.setTurnoHorarioEntrada(rs.getValueAt(0,"TURNO_ENTRADA").toString());      
            if(rs.getValueAt(0,"FECHA_ULTIMO_ESTADO") != null)
                dtoUsuCob.setFechaUltimoEstado(toDate(rs.getValueAt(0,"FECHA_ULTIMO_ESTADO").toString(),"yyyy-MM-dd"));      
            if(rs.getValueAt(0,"OID") != null )
                dtoUsuCob.setOidUsuarioCobranza(new Long(rs.getValueAt(0,"OID").toString())); 
            if(rs.getValueAt(0,"RESPALDO") != null && !rs.getValueAt(0,"RESPALDO").equals("") )
                dtoUsuCob.setCodUsuarioRespaldo(rs.getValueAt(0,"RESPALDO").toString());
            if(rs.getValueAt(0,"SUPERVISOR") != null && !rs.getValueAt(0,"SUPERVISOR").equals("") )
                dtoUsuCob.setCodUsuarioSupervisor(rs.getValueAt(0,"SUPERVISOR").toString());      
            if(rs.getValueAt(0,"OBSERVACIONES") != null && !rs.getValueAt(0,"OBSERVACIONES").equals("") )
                dtoUsuCob.setObservaciones(rs.getValueAt(0,"OBSERVACIONES").toString());       
            //dtoUsuCob.setEstadoAnterior(new Long(1));
        }    
		return dtoUsuCob;
    }
  
    //------------------------- UTILITIES ------------------------------------------------
    private Date toDate(String sFecha) throws Exception
    {   String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        return this.toDate(sFecha, formatoFecha);
    }

    private Date toDate(String sFecha, String formatoFecha) throws Exception 
    {		
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

    private String dateToString(Date dFecha) throws Exception
    {
        String formato = UtilidadesSession.getFormatoFecha(this);
        formato = formato.replace('m', 'M');
        SimpleDateFormat miFecha = new SimpleDateFormat(formato);
        String fechaRes = miFecha.format(dFecha);		  	  	  
        return fechaRes;
  }
}

