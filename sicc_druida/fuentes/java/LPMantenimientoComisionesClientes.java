import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesClientes;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenimientoComisionesClientes extends LPComisiones {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private String idPestanyaDest = null;
	private String marca = null;
	private String canal = null;

    private String oidTipoCliente = null;
	private String topeMaximo = null;
	private String topeMinimo = null;
	private String fechaDesde = null;
	private String fechaHasta = null;

	private String oidSubgerencia = null;
	private String oidRegion = null;
	private String oidZona = null;
	private String oidSeccion = null;
	private String oidTerritorio = null;

	private String datosDeLista = null;
	private String deshabilitoCombosZonificacion = null;
	private String deshabilitoTodoMenosTopes = null;

	public LPMantenimientoComisionesClientes() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
	  	traza("************ Entre a LPMantenimientoComisionesClientes");

		accion = conectorParametroLimpia("accion", "", true);
		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		titulo = conectorParametroLimpia("titulo", "", true);
		oidTipoPlantilla = conectorParametroLimpia("oidTipoPlantilla", "", true);
		estadoVentana = conectorParametroLimpia("estadoVentana", "", true);

		// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
		String sComisionEscalonada = conectorParametroLimpia("sComisionEscalonada", "", true);
		
 		traza("************ accion:" + accion);
 		traza("************ opcionMenu:" + opcionMenu);
		traza("************ titulo:" + titulo);
		traza("************ oidTipoPlantilla:" + oidTipoPlantilla);
		traza("************ estadoVentana:" + estadoVentana);
		
		// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
		traza("************ sComisionEscalonada:" + sComisionEscalonada);
		
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);
		
		try {			  
			if(accion.equals(""))  {
				pagina("contenido_comisiones_clientes_insertar");
				asignarAtributo("VAR", "titulo", "valor", titulo);
				asignarAtributo("VAR", "oidTipoPlantilla", "valor", oidTipoPlantilla);
				asignarAtributo("VAR", "estadoVentana", "valor", estadoVentana);

				// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010				
				asignarAtributo("VAR", "sComisionEscalonada", "valor", sComisionEscalonada);
				
				canal = conectorParametroLimpia("canalTemp", "", true);
				marca = conectorParametroLimpia("marcaTemp", "", true);

				traza("************ canal:" + canal);
				traza("************ marca:" + marca);
				
				asignarAtributo("VAR", "varOidCanal", "valor", canal);
				asignarAtributo("VAR", "varOidMarca", "valor", marca);        

				idPestanya = ConstantesCOMPestanyas.PESTANYA_CLIENTES;
				cargarPantalla();
			}
			else if(accion.equals("almacenar")) {       
				if(!opcionMenu.equals("consultar")) {
					almacenar();
				}



				idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);
		        redirigir(new Integer(idPestanyaDest));
			}
			else if(accion.equals("guardar")) {        
				almacenar();
				try {      
						traza("************ Llamando al guardar");
					this.guardar();

					if(opcionMenu.equals("insertar")) {
						this.setComision(null);
						conectorAction("LPInsertarComisiones");
					}
					else {
					  // 23192 - dmorello, 30/05/2006: Luego de guardar, corresponde cerrar la ventana modal
					  //asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          
					  asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
					}
				}
				catch(Exception e) {
				  asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
				  throw e;
				}        
			}
			else if(accion.equals("anadir")) {           
				anadir();
			}
			else if(accion.equals("modificar")) {    
				modificar();
			}

		cargarMenuSecundario();      			
		}
		catch(Exception e)  {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		} 
	}

	public void almacenar () throws Exception {
		traza("************* Entre a almacenar - LPMantenimientoComisionesClientes");   
		pagina("salidaGenerica");
    
		//Se obtiene el DTOComisiones de sesion
		DTOComisiones dtoComisiones = this.getComision(); 
		if(dtoComisiones==null) {
			dtoComisiones = new DTOComisiones();
		}
		traza("************* dtoComisiones " + dtoComisiones);    	

		//Seteando oids de marca y canal, se usaran al pasar de pestaña
		if(dtoComisiones.getOidMarca()!=null) {
			marcaTemp = dtoComisiones.getOidMarca().toString();
		}

		if(dtoComisiones.getOidCanal()!=null) {
			canalTemp = dtoComisiones.getOidCanal().toString();
		}
		
		//Se obtienen los datos de la lista
		datosDeLista = conectorParametroLimpia("datosDeLista", "", true);		

		//Si la lista esta vacia se pasa null al ArrayList comisionesClientes
		if(datosDeLista.equals("null")) {
			traza("************* La lista esta vacia, se pasa null a comisiones cliente");    
			dtoComisiones.setComisionesClientes(null);
			traza("************* Antes de llamar a setComision");    
			this.setComision(dtoComisiones); 		
			traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
			DTOComisiones dtoTemp = this.getComision(); 
			traza("************* DTOComisiones " + dtoTemp);        			
		}
		//Si la lista contiene datos, se setean
		else {
			traza("************* La lista tiene datos, se procede a almacenarlos");    
			traza("***** ANTES ******** datosDeLista " + datosDeLista);    

			int inicio = 1;
			int fin = datosDeLista.length()-1;
			
			datosDeLista = datosDeLista.substring(inicio, fin);

			traza("***** DESPUES ****** datosDeLista " + datosDeLista);    

			ArrayList comisionesClientes = new ArrayList();

			StringTokenizer stFilas = new StringTokenizer(datosDeLista,"|");
			int cantFilas = stFilas.countTokens();
			traza("************ cantidad de filas " + cantFilas);
		  
			while(stFilas.hasMoreTokens()) {
			  String elemento = stFilas.nextToken();
			  traza("************ elemento: " + elemento);

			  StringTokenizer stCampos = new StringTokenizer(elemento,",");
			  int cantCampos = stCampos.countTokens();
			  traza("************ cantidad de campos " + cantCampos);

			  int i = 0;

			  DTOComisionesClientes dtoComisionesClientes = new DTOComisionesClientes();

			  while(stCampos.hasMoreTokens()) {
				  String campo = stCampos.nextToken();
				  traza("************ campo: " + campo);

				  //Segun respuesta de incidencia 15810
				  dtoComisionesClientes.setOidComisiones(dtoComisiones.getOid());

				  if(i==0) {
					  if(campo.equals(" ")) dtoComisionesClientes.setTopeMaximo(null);
					  else dtoComisionesClientes.setTopeMaximo(new BigDecimal(campo));
				  }

				  if(i==1) {
					  if(campo.equals(" ")) dtoComisionesClientes.setTopeMinimo(null);
					  else dtoComisionesClientes.setTopeMinimo(new BigDecimal(campo));
				  }

				  if(i==2) {
					  if(campo.equals(" ")) {
						  dtoComisionesClientes.setFecAntiguedadDesde(null);
					  }
					  else {
						  Date sqlFechaDesde = toDate(campo);
						  dtoComisionesClientes.setFecAntiguedadDesde(sqlFechaDesde);
					  }					  
				  }

				  if(i==3) {
					  if(campo.equals(" ")) {
						  dtoComisionesClientes.setFecAntiguedadHasta(null);
					  }
					  else {
						  Date sqlFechaHasta = toDate(campo);
						  dtoComisionesClientes.setFecAntiguedadHasta(sqlFechaHasta);
					  }	  				  
				  }

				  if(i==4) {
					  if(campo.equals(" ")) dtoComisionesClientes.setOidTipoClienteComisionesCabecera(null);
					  else dtoComisionesClientes.setOidTipoClienteComisionesCabecera(new Long(campo));
				  }

				  if(i==5) {
					  if(campo.equals(" ")) dtoComisionesClientes.setOidSubgerencia(null);
					  else dtoComisionesClientes.setOidSubgerencia(new Long(campo));
				  }

				  if(i==6) {
					  if(campo.equals(" ")) dtoComisionesClientes.setOidRegion(null);
					  else dtoComisionesClientes.setOidRegion(new Long(campo));
				  }

				  if(i==7) {
					  if(campo.equals(" ")) dtoComisionesClientes.setOidZona(null);
					  else dtoComisionesClientes.setOidZona(new Long(campo));
				  }

				  if(i==8) {
					  if(campo.equals(" ")) dtoComisionesClientes.setOidSeccion(null);
					  else dtoComisionesClientes.setOidSeccion(new Long(campo));
				  }

				  if(i==9) {
					  if(campo.equals(" ")) dtoComisionesClientes.setOidTerritorio(null);
					  else dtoComisionesClientes.setOidTerritorio(new Long(campo));
				  }

				  if(i==10) {
					  if(campo.equals(" ")) dtoComisionesClientes.setNumero(null);
					  else dtoComisionesClientes.setNumero(new Integer(campo));
				  }		

				  if(i==11) {
					  if(campo.equals(" ")) dtoComisionesClientes.setDescTipoClienteComisionesCabecera(null);
					  else dtoComisionesClientes.setDescTipoClienteComisionesCabecera(new String(campo));
				  }

			      if(i==12) {
					  if(campo.equals(" ")) dtoComisionesClientes.setDescSubgerencia(null);
					  else dtoComisionesClientes.setDescSubgerencia(new String(campo));
				  }

				  if(i==13) {
					  if(campo.equals(" ")) dtoComisionesClientes.setDescRegion(null);
					  else dtoComisionesClientes.setDescRegion(new String(campo));
				  }

				  if(i==14) {
					  if(campo.equals(" ")) dtoComisionesClientes.setDescZona(null);
					  else dtoComisionesClientes.setDescZona(new String(campo));
				  }

				  if(i==15) {
					  if(campo.equals(" ")) dtoComisionesClientes.setDescSeccion(null);
					  else dtoComisionesClientes.setDescSeccion(new String(campo));
				  }

				  if(i==16) {
					  if(campo.equals(" ")) dtoComisionesClientes.setDescTerritorio(null);
					  else dtoComisionesClientes.setDescTerritorio(new String(campo));
				  }

				  i++;
			  }

			  traza("************* dtoComisionesClientes " + dtoComisionesClientes);        
			  comisionesClientes.add(dtoComisionesClientes);
			}

			dtoComisiones.setComisionesClientes(comisionesClientes);
		
			traza("************* Antes de llamar a setComision");    
			this.setComision(dtoComisiones); 
		
			traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
			DTOComisiones dtoTemp = this.getComision(); 
			traza("************* DTOComisiones " + dtoTemp);       

		} 
  }

	private Date toDate(String sFecha) throws Exception{
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		return this.toDate(sFecha, formatoFecha);
	}
  
	private Date toDate(String sFecha, String formatoFecha) throws Exception{		
		traza("****** formatoSesion: " + formatoFecha);
	    formatoFecha = formatoFecha.replace('m', 'M');
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
		java.util.Date fecha = miFecha.parse(sFecha);
	    miFecha = new SimpleDateFormat(formatoFecha);

		String fechaRes = miFecha.format(fecha);
		fecha = miFecha.parse(fechaRes);
	    java.sql.Date sql = new java.sql.Date(fecha.getTime());
		traza("****** sql Date: " + sql.toString());
    
		return sql;
	}

	private String dateToString(Date dFecha) throws Exception{
		String formato = UtilidadesSession.getFormatoFecha(this);
	    formato = formato.replace('m', 'M');
		SimpleDateFormat miFecha = new SimpleDateFormat(formato);
		String fechaRes = miFecha.format(dFecha);		
		return fechaRes;
  }

  	public void cargarPantalla() throws Exception {
		traza("************* Entre a cargarPantalla - LPMantenimientoComisionesClientes");

        asignarAtributo("VAR", "descPais", "valor", sDescPais);          

		/* Si estamos en el CU de Consulta ó Modificación hacer 
		-> Llamar al método "getComision()" y obtener el DTOComisiones 
		-> Mapear en la lista "lstClientes" el atributo DTOComisiones.comisionesClientes 
		Fin Si 
		
		Si estamos en CU de Consulta deshabilitar los botones añadir, modificar y eliminar */

		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		traza("************* opcionMenu " + opcionMenu);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);


		//En la pagina pregunto en que caso de uso estoy para
		//deshabilitar o no los botones añadir y modificar de la lista
		//y el icono eliminar del menu secundario.

		//El mapeo de lo que hay en el ArrayList comisionesClientes
		//del DTOComisiones con la lista clientes de la tercer pestaña
		//se ha de realizar siempre, sin importar el caso de uso		
		
		DTOComisiones dtoC = this.getComision();
		traza("************* dtoC " + dtoC);

		Boolean tratamiento = dtoC.getTratamientoDiferencial();
		traza("************* tratamiento " + tratamiento);
		asignarAtributo("VAR", "deshabilitoCombosZonificacion", "valor", tratamiento.toString());
		
		traza("************* estado " + dtoC.getOidEstado());

		if(dtoC.getOidEstado()!=null) {
			if(dtoC.getOidEstado().longValue() == ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA.longValue()) {
				asignarAtributo("VAR", "deshabilitoTodoMenosTopes", "valor", "true");
			}
			else {
				asignarAtributo("VAR", "deshabilitoTodoMenosTopes", "valor", "false");
			}
		}

		traza("************ Llamando a verificarDatosComision");
		verificarDatosComision();

		if(dtoC.getOidEstado()!=null) {
			if(dtoC.getOidEstado().longValue() == ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA.longValue()) {
				asignarAtributo("VAR", "impedirGuardarSinClientes", "valor", "true");
			}
			else {
				asignarAtributo("VAR", "impedirGuardarSinClientes", "valor", "false");
			}
		}

		if(dtoC.getComisionesClientes()!=null) {	
			traza("************* dtoC.getComisionesClientes() es distinto de null");
			ArrayList clientes = dtoC.getComisionesClientes();
			RecordSet rs = new RecordSet();
 	        
			rs.addColumn(new String("oidtipocliente"));
		    rs.addColumn(new String("desctipocliente"));
		    rs.addColumn(new String("topemaximo"));
		    rs.addColumn(new String("topeminimo"));
			rs.addColumn(new String("fechadesde"));
		    rs.addColumn(new String("fechahasta"));
		    rs.addColumn(new String("pais"));
		    rs.addColumn(new String("descsubgerencia"));
			rs.addColumn(new String("descregion"));
		    rs.addColumn(new String("desczona"));
		    rs.addColumn(new String("descseccion"));
		    rs.addColumn(new String("descterritorio"));
			rs.addColumn(new String("oidsubgerencia"));
			rs.addColumn(new String("oidregion"));
		    rs.addColumn(new String("oidzona"));
		    rs.addColumn(new String("oidseccion"));
		    rs.addColumn(new String("oidterritorio"));

  		    for (int i = 0 ; i < clientes.size(); i++) {
				DTOComisionesClientes dtoComisionesClientes = (DTOComisionesClientes)clientes.get(i);

				traza("************* dtoComisionesClientes " + dtoComisionesClientes);
				
				Long oidTipoCliente = dtoComisionesClientes.getOidTipoClienteComisionesCabecera();
				String descTipoCliente = dtoComisionesClientes.getDescTipoClienteComisionesCabecera();
				BigDecimal topeMaximo  = dtoComisionesClientes.getTopeMaximo();
				BigDecimal topeMinimo  = dtoComisionesClientes.getTopeMinimo();

				String fechaDesde;				
				if(dtoComisionesClientes.getFecAntiguedadDesde()!=null) {
					fechaDesde  = dateToString(dtoComisionesClientes.getFecAntiguedadDesde());
				}
				else {
					fechaDesde = null;
				}

				String fechaHasta;
				if(dtoComisionesClientes.getFecAntiguedadHasta()!=null) {
					fechaHasta  = dateToString(dtoComisionesClientes.getFecAntiguedadHasta());
				}
				else {
					fechaHasta = null;
				}				

				String pais = sDescPais;
				String descSubgerencia = dtoComisionesClientes.getDescSubgerencia();
				String descRegion = dtoComisionesClientes.getDescRegion();
				String descZona = dtoComisionesClientes.getDescZona();
				String descSeccion = dtoComisionesClientes.getDescSeccion();
				String descTerritorio  = dtoComisionesClientes.getDescTerritorio();
				Long oidSubgerencia = dtoComisionesClientes.getOidSubgerencia();
				Long oidRegion = dtoComisionesClientes.getOidRegion();
				Long oidZona = dtoComisionesClientes.getOidZona();
				Long oidSeccion = dtoComisionesClientes.getOidSeccion();
				Long oidTerritorio = dtoComisionesClientes.getOidTerritorio();

				Vector fila = new Vector();

				fila.add(oidTipoCliente);
				fila.add(descTipoCliente);
				fila.add(topeMaximo);
				fila.add(topeMinimo);
				fila.add(fechaDesde);
				fila.add(fechaHasta);
				fila.add(pais);
				fila.add(descSubgerencia);
				fila.add(descRegion);
				fila.add(descZona);
				fila.add(descSeccion);
				fila.add(descTerritorio);
				fila.add(oidSubgerencia);
				fila.add(oidRegion);
				fila.add(oidZona);
				fila.add(oidSeccion);
				fila.add(oidTerritorio);			

				rs.addRow(fila); 
			}
			DruidaConector conector = UtilidadesBelcorp.generarConector("ROWSET", rs,rs.getColumnIdentifiers());      
			asignar("LISTADOA", "listado1",conector, "ROWSET");
		}
	}  

	public void anadir() throws Exception {
		traza("************ Entre a anadir");
		pagina("contenido_comisiones_clientes_insertar2");

		deshabilitoCombosZonificacion = conectorParametroLimpia("deshabilitoCombosZonificacion", "", true);
		traza("************ deshabilitoCombosZonificacion " + deshabilitoCombosZonificacion);    
		asignarAtributo("VAR", "deshabilitoCombosZonificacion", "valor", deshabilitoCombosZonificacion);

		getFormatosValidaciones();

        asignarAtributo("LABELC", "lbldtPais", "valor", sDescPais);          

		ComposerViewElementList cv = crearParametrosEntrada();
		traza("************ Antes de crear conector");    
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		traza("************ Llamando a ejecucion");         
		conector.ejecucion();
		traza("************ Despues de ejecucion");    
		DruidaConector resultados = conector.getConector();
		traza("************ Despues de llamar a getConector");    
    
		traza("************ Asignando datos");    
		asignar("COMBO", "cbTipoClientes", resultados, "COMObtenerTiposClienteCOM");
		asignar("COMBO", "cbSubgerenciaVentas", resultados, "ZONRecargaSubgerenciaVentas");
	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception{	
		traza("************ Entre a crearParametrosEntrada");
		//DTOBelcorp
		DTOBelcorp dtoe = new DTOBelcorp(); 
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);

		DTOComisiones dtoComisiones = this.getComision();
		if(dtoComisiones==null) {
			traza("************ DTOComisiones es null");
			dtoComisiones = new DTOComisiones();
		}
		traza("************ dtoComisiones " + dtoComisiones);

		//DTOUnidadAdministrativa
		DTOUnidadAdministrativa dtoUnidadAdministrativa = new DTOUnidadAdministrativa();
		dtoUnidadAdministrativa.setOidPais(lPais);
		dtoUnidadAdministrativa.setOidMarca(dtoComisiones.getOidMarca());
		dtoUnidadAdministrativa.setOidCanal(dtoComisiones.getOidCanal());
		
		ComposerViewElementList lista = new ComposerViewElementList(); 
			
		//Primer componente
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("COMObtenerTiposClienteCOM");
		cve1.setDTOE(dtoe);
		
		//Segundo componente
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("ZONRecargaSubgerenciaVentas");
		cve2.setDTOE(dtoUnidadAdministrativa);
		
		lista.addViewElement(cve1);
		lista.addViewElement(cve2);
		
		return lista;
	}

	public void modificar() throws Exception {
		traza("************ Entre a modificar");
		pagina("contenido_comisiones_clientes_insertar2");
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);

		deshabilitoCombosZonificacion = conectorParametroLimpia("deshabilitoCombosZonificacion", "", true);
		traza("************ deshabilitoCombosZonificacion " + deshabilitoCombosZonificacion);    
		asignarAtributo("VAR", "deshabilitoCombosZonificacion", "valor", deshabilitoCombosZonificacion);

		deshabilitoTodoMenosTopes = conectorParametroLimpia("deshabilitoTodoMenosTopes", "", true);
		traza("************ deshabilitoTodoMenosTopes " + deshabilitoTodoMenosTopes);    
		asignarAtributo("VAR", "deshabilitoTodoMenosTopes", "valor", deshabilitoTodoMenosTopes);

		getFormatosValidaciones();

        asignarAtributo("LABELC", "lbldtPais", "valor", sDescPais);          

		ComposerViewElementList cv = crearParametrosEntrada();
		traza("************ Antes de crear conector");    
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		traza("************ Llamando a ejecucion");         
		conector.ejecucion();
		traza("************ Despues de ejecucion");    
		DruidaConector resultados = conector.getConector();
		traza("************ Despues de llamar a getConector");    
    
		traza("************ Asignando datos");    
		asignar("COMBO", "cbTipoClientes", resultados, "COMObtenerTiposClienteCOM");
		asignar("COMBO", "cbSubgerenciaVentas", resultados, "ZONRecargaSubgerenciaVentas");

		oidTipoCliente = conectorParametroLimpia("oidTipoCliente", "", true);
		topeMaximo = conectorParametroLimpia("topeMaximo", "", true);
		topeMinimo = conectorParametroLimpia("topeMinimo", "", true);
		fechaDesde = conectorParametroLimpia("fechaDesde", "", true);
		fechaHasta = conectorParametroLimpia("fechaHasta", "", true);
		oidSubgerencia = conectorParametroLimpia("oidSubgerencia", "", true);
		oidRegion = conectorParametroLimpia("oidRegion", "", true);
		oidZona = conectorParametroLimpia("oidZona", "", true);
		oidSeccion = conectorParametroLimpia("oidSeccion", "", true);
		oidTerritorio = conectorParametroLimpia("oidTerritorio", "", true);

		traza("************ oidTipoCliente " + oidTipoCliente);    
		traza("************ topeMaximo " + topeMaximo);    
		traza("************ topeMinimo " + topeMinimo);    
		traza("************ fechaDesde " + fechaDesde);    
		traza("************ fechaHasta " + fechaHasta);    
		traza("************ oidSubgerencia " + oidSubgerencia);    
		traza("************ oidRegion " + oidRegion);    
		traza("************ oidZona " + oidZona);    
		traza("************ oidSeccion " + oidSeccion);    
		traza("************ oidTerritorio " + oidTerritorio);    

		asignarAtributo("VAR", "oidTipoCliente", "valor", oidTipoCliente);
		asignarAtributo("VAR", "topeMaximo", "valor", topeMaximo);
		asignarAtributo("VAR", "topeMinimo", "valor", topeMinimo);
		asignarAtributo("VAR", "fechaDesde", "valor", fechaDesde);
		asignarAtributo("VAR", "fechaHasta", "valor", fechaHasta);
		asignarAtributo("VAR", "oidSubgerencia", "valor", oidSubgerencia);
		asignarAtributo("VAR", "oidRegion", "valor", oidRegion);
		asignarAtributo("VAR", "oidZona", "valor", oidZona);
		asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion);
		asignarAtributo("VAR", "oidTerritorio", "valor", oidTerritorio);

		asignarAtributo("VAR", "accionModificar", "valor", "modificar");
	}

	private void cargarMenuSecundario() throws Exception {     
		traza("************ Entre a cargarMenuSecundario");
	  	traza("************ accion " + accion);
		traza("************ opcionMenu " + opcionMenu);

		if (accion.equals("")) {
			if(opcionMenu.equals("insertar")) {
				getConfiguracionMenu("LPMantenimientoComisionesCliente","");
				asignarAtributoPagina("cod","0515");   
			}
			else if(opcionMenu.equals("consultar")) {
				getConfiguracionMenu("LPMantenimientoComisionesCliente","consultar");
				if(titulo.equals("EliminarComisiones")) {
					asignarAtributoPagina("cod","0558");         
				}
				else if(titulo.equals("ConsultarComisiones")) {
					asignarAtributoPagina("cod","0510");         
				}
			}
			else if(opcionMenu.equals("modificar")) {
 				getConfiguracionMenu("LPMantenimientoComisionesCliente","modificar");
				asignarAtributoPagina("cod","0520");         
			}
		}
		else if (accion.equals("anadir")) {
			getConfiguracionMenu("LPMantenimientoComisionesCliente","anadir");
			if(opcionMenu.equals("modificar")) {
				asignarAtributoPagina("cod","0520");         
			}

		}
		else if (accion.equals("modificar")) {
			getConfiguracionMenu("LPMantenimientoComisionesCliente","anadir");
			if(opcionMenu.equals("modificar")) {
				asignarAtributoPagina("cod","0520");         
			}
			if(opcionMenu.equals("consultar")) {
				asignarAtributoPagina("cod","0510");         
			}
		}
   }
}