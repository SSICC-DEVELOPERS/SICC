/**
 * Sistema:          Belcorp - SICC
 * Modulo:           MEN - Menu
 * Componente:       LPConsultarUsuario
 * Notas:			 Duplicada, para ver el funcionamiento.....	
 * @version          2.0
 */ 

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import java.io.*;

import java.util.StringTokenizer;
import java.util.Vector;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;

import es.indra.sicc.util.DTOSalida;


import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
//import LPSICCBase;

public class LPConsultarUsuario extends LPSICCBase {

	private final int SIZE_LABEL = 20;
	
	String accion           		= null;
	
	String pIdentificadorUsuario	= null;
	String pNombre1					= null;
	String pNombre2					= null;
	String pApellido1				= null;
	String pApellido2				= null;
	String pPerfil					= null;
	String pTelefono				= null;
	String pDepartamento			= null;
	String pValidezDesde			= null;
	String pHasta					= null;
	String pTipoUsuario				= null;
	String pUsuarioHabilitado		= null;
		
	String pelementosSeleccionados= null;

	Vector paramEntrada     		    = null;
	Vector datosUsuario 				= null;

	DTOEntradaCriteriosDeBusquedaUsuarios dtoe 	= null;
	DTOEntradaConsultarUsuario dtoeConsultar 	= null;

	DruidaConector conectorBuscar 		= null;
	DruidaConector conectorConsultar 	= null;      

	Long idioma;
	Long pais;
   
	public LPConsultarUsuario() {super();}
	
	public void inicio() throws Exception {

	}

	public void ejecucion() throws Exception {
		setTrazaFichero();

		accion           		= conectorParametroLimpia("accion","",true);
		pelementosSeleccionados	= conectorParametroLimpia("elementosSeleccionados","",true);

		pIdentificadorUsuario	= conectorParametroLimpia("txtUsuario","",true);
		pNombre1				= conectorParametroLimpia("txtPrimerNombre","",true);
		pNombre2				= conectorParametroLimpia("txtSegundoNombre","",true);
		pApellido1				= conectorParametroLimpia("txtPrimerApellido","",true);
		pApellido2				= conectorParametroLimpia("txtSegundoApellido","",true);
		pPerfil					= conectorParametroLimpia("cbPerfil","",true);
		pTelefono				= conectorParametroLimpia("txtTelefono","",true);
		pDepartamento			= conectorParametroLimpia("cbDepartamento","",true);
		pValidezDesde			= conectorParametroLimpia("txtValidezDesde","",true);
		pHasta					= conectorParametroLimpia("txtHasta","",true);
		pTipoUsuario			= conectorParametroLimpia("cbTipoUsuario","",true);
		pUsuarioHabilitado		= conectorParametroLimpia("rbUsuarioHabilitado","",true);

		idioma = UtilidadesSession.getIdioma( this );
		pais = UtilidadesSession.getPais( this );
					
		dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
		dtoeConsultar = new DTOEntradaConsultarUsuario();

		String usuario = (String)conectorParametroSesion("DruidaUsuario");
		String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		dtoe.setUsuario(usuario);
		dtoe.setPassword(contrasenia);
		dtoeConsultar.setUsuario(usuario);
		dtoeConsultar.setPassword(contrasenia);

		traza("accion: " + accion);

		traza("contenido de pidentificador********" + pIdentificadorUsuario);
		
		if (accion.equals("")){
			pagina("contenido_usuarios_buscar");
			
			obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
						
			asignarAtributo("VAR","accion", "valor", "Buscar");
			asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuario");
		}
		
		try
		{
			if( accion.equals("Buscar") || accion.equals("VolverConsulta") ) {

				dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
				dtoe.setUsuario(usuario);
				dtoe.setPassword(contrasenia);
				//DTO: DATA TRANSFER OBJECT	

				obtenerParametrosBusqueda(dtoe, accion);

				pagina("contenido_usuarios_buscar");

				mostrarResultadosBusqueda();
			}
		} catch (Exception ex) {
					
					this.lanzarPaginaError(ex);
					
					pagina("contenido_usuarios_buscar");				

					asignarAtributo("VAR","accion", "valor", "Buscar");

					/***
						Con la función asignarAtributo() se setean variables de pantalla, 
						con valores que deseemos. Este método es para componentes que 
						contienen un solo valor. En el caso de combos o listas, la función 
						es asignar().
					**/


					asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuario");

					asignarAtributo("CTEXTO","txtUsuario", "valor", pIdentificadorUsuario);
					asignarAtributo("CTEXTO","txtPrimerNombre", "valor", pNombre1);
					asignarAtributo("CTEXTO","txtSegundoNombre", "valor", pNombre2);
					asignarAtributo("CTEXTO","txtPrimerApellido", "valor", pApellido1);
					asignarAtributo("CTEXTO","txtSegundoApellido", "valor", pApellido2);

					asignarAtributo("VAR","hPerfil", "valor", pPerfil);								
					//asignarAtributo("COMBO","cbPerfil", "valor", pPerfil);
					
					asignarAtributo("CTEXTO","txtTelefono", "valor", pTelefono);
					
					asignarAtributo("VAR","hDepartamento", "valor", pDepartamento);				
					//asignarAtributo("COMBO","cbDepartamento", "valor", pDepartamento);
					
					asignarAtributo("CTEXTO","txtValidezDesde", "valor", pValidezDesde);
					asignarAtributo("CTEXTO","txtHasta", "valor", pHasta);		

					asignarAtributo("VAR","hTipoUsuario", "valor", pTipoUsuario);					
					//asignarAtributo("COMBO","cbTipoUsuario", "valor", pTipoUsuario);

					asignarAtributo("VAR","hUsuarioHabilitado", "valor", pUsuarioHabilitado);	
					//asignarAtributo("RADIO","rbUsuarioHabilitado", "valor", pUsuarioHabilitado);
		}			
		
      try
      {
			if( accion.equals("Consultar") ){
				
				dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
				dtoe.setUsuario(usuario);
				dtoe.setPassword(contrasenia);
				obtenerParametrosBusqueda(dtoe, accion);
				
				pagina("contenido_usuario_consultar");
				
				pelementosSeleccionados = conectorParametroLimpia("elementosSeleccionados","",true);
				//pelementosSeleccionados = (String) conectorParametroSesion("elementosSeleccionados");

				conectorParametroSesion("elementosSeleccionados",pelementosSeleccionados);

				/**
				conectorParametroSesion= La función conectorParametroSesion() asigna un valor a una variable 
										 de sesión.

				**/
				
				dtoeConsultar.setIdUsuario(pelementosSeleccionados);

				/**				
				Aca se setea el id del usuario con los elementos seleccionados
				**/

				conectorParametroSesion("dtoeConsultar",dtoeConsultar);


				/**
				El orden en que se agregan los elementos al vector 
				paramEntrada es justamente ese: primero el dto y luego el businessId.
				**/
					
				paramEntrada = new Vector();
				paramEntrada.add( dtoeConsultar );
				paramEntrada.add( new MareBusinessID("MENConsultarUsuarios") );


				/**
				conectar() se encarga de ejecutar el método de negocio, con el parámetro 
				indicado, invocando al conector que corresponde.

				**/

				conectorConsultar = conectar("ConectorConsultarUsuarios", paramEntrada);					
				
				traza( "salida de la consulta: " + conectorConsultar.getXML().toString() );

				Vector vIdUsuario = valorVector("IdUsuario", conectorConsultar);
				Vector vPerfil = valorVector("Perfil", conectorConsultar);
				Vector vApellidoCasada = valorVector("ApellidoCasada", conectorConsultar);
				Vector vDepartamento = valorVector("Departamento", conectorConsultar);
				Vector vEmail = valorVector("Email", conectorConsultar);
				Vector vSociedad = valorVector("Sociedad", conectorConsultar);
				Vector vFechaInicioRastreo = valorVector("FechaInicioRastreo", conectorConsultar);
				Vector vFechaFinalRastreo = valorVector("FechaFinalRastreo", conectorConsultar);
				Vector vFechaSustitucionDesde = valorVector("FechaSustitucionDesde", conectorConsultar);
				Vector vFechaSustitucionHasta = valorVector("FechaSustitucionHasta", conectorConsultar);
/*
				Vector vFormatoFecha = valorVector("FormatoFecha", conectorConsultar);
				Vector vFormatoNumerico = valorVector("FormatoNumerico", conectorConsultar);
				Vector vFormatoNumericoSeparadorDecimales = valorVector("FormatoNumericoSeparadorDecimales", conectorConsultar);
				Vector vFormatoNumericoSeparadorMiles = valorVector("FormatoNumericoSeparadorMiles", conectorConsultar);
*/
				Vector vIdentificadorPc = valorVector("IdentificadorPc", conectorConsultar);
				Vector vIdioma = valorVector("Idioma", conectorConsultar);
				Vector vIndicacionClaveInicial = valorVector("IndicacionClaveInicial", conectorConsultar);
				Vector vMarca = valorVector("Marca", conectorConsultar);
				Vector vObservacionesSustitucion = valorVector("ObservacionesSustitucion", conectorConsultar);
				Vector vPaisDefecto = valorVector("PaisDefecto", conectorConsultar);
				Vector vPantallaInicioAsociada = valorVector("PantallaInicioAsociada", conectorConsultar);
				Vector vPeriodoValidezFechaDesde = valorVector("PeriodoValidezFechaDesde", conectorConsultar);
				Vector vPeriodoValidezFechaHasta = valorVector("PeriodoValidezFechaHasta", conectorConsultar);
				Vector vPrimerApellido = valorVector("PrimerApellido", conectorConsultar);
				Vector vPrimerNombre = valorVector("PrimerNombre", conectorConsultar);
				Vector vRastreoAcceso = valorVector("RastreoAcceso", conectorConsultar);
				Vector vSeccionDefecto = valorVector("SeccionDefecto", conectorConsultar);
				Vector vRegionPorDefecto = valorVector("RegionPorDefecto", conectorConsultar);
				Vector vSegundoApellido = valorVector("SegundoApellido", conectorConsultar);
				Vector vSegundoNombre = valorVector("SegundoNombre", conectorConsultar);
				Vector vTelefonoContacto = valorVector("TelefonoContacto", conectorConsultar);
				Vector vTipoUsuario = valorVector("TipoUsuario", conectorConsultar);
				Vector vUsuarioHabilitado = valorVector("UsuarioHabilitado", conectorConsultar);
				Vector vUsuarioSustitucion = valorVector("UsuarioSustitucion", conectorConsultar);
				Vector vZonaPorDefecto = valorVector("ZonaPorDefecto", conectorConsultar);
				Vector vAcceso = valorVector("Acceso", conectorConsultar);
				Vector vCanal = valorVector("Canal", conectorConsultar);
				Vector vPais = valorVector("Pais", conectorConsultar);
				Vector vRegion = valorVector("Region", conectorConsultar);
				Vector vSeccion = valorVector("Seccion", conectorConsultar);
				Vector vSubnivelAcceso = valorVector("SubnivelAcceso", conectorConsultar);
				Vector vTerritorio = valorVector("Territorio", conectorConsultar);
				Vector vZona = valorVector("Zona", conectorConsultar);
				
				//v3
				Vector vSociedadDefecto = valorVector("SociedadPorDefecto", conectorConsultar);
				Vector vMarcaDefecto = valorVector("MarcaPorDefecto", conectorConsultar);
				Vector vCanalDefecto = valorVector("CanalPorDefecto", conectorConsultar);
				Vector vAccesoDefecto = valorVector("AccesoPorDefecto", conectorConsultar);
				Vector vSubaccesoDefecto = valorVector("SubaccesoPorDefecto", conectorConsultar);				
				Vector vSubgerenciaVentas = valorVector("SubgerenciaVentas", conectorConsultar);
				Vector vSubgerenciaVentasDefecto = valorVector("SubgerenciaVentasDefecto", conectorConsultar);
				Vector vTerritorioPorDefecto = valorVector("TerritorioPorDefecto", conectorConsultar);
				
				asignar("LABELC","lblIdentificadorUsuario", recogeCadena( (String) vIdUsuario.get(0)) );


				//asignar("LABELC","lblIndicacionClaveInicial", recogeCadena( (String) vIndicacionClaveInicial.get(0)) );

				asignar("VAR","hIndicacionClaveInicial", recogeCadena( (String) vIndicacionClaveInicial.get(0)) );				
				asignar("LABELC","lblPerfil", recogeCadena( (String) vPerfil.get(0)) );

				//asignar("VAR","hPerfil", recogeCadena( (String) vPerfil.get(0)) );

				asignar("LABELC","lblPrimerApellido", recogeCadena( (String) vPrimerApellido.get(0)) );
				asignar("LABELC","lblSegundoApellido", recogeCadena( (String) vSegundoApellido.get(0)) );
				asignar("LABELC","lblApellidoCasada", recogeCadena( (String) vApellidoCasada.get(0)) );
				asignar("LABELC","lblPrimerNombre", recogeCadena( (String) vPrimerNombre.get(0)) );
				asignar("LABELC","lblSegundoNombre", recogeCadena( (String) vSegundoNombre.get(0)) );
				asignar("LABELC","lblEMail", recogeCadena( (String) vEmail.get(0)) );
				asignar("LABELC","lblTelefono", recogeCadena( (String) vTelefonoContacto.get(0)) );

				asignar("VAR","hDepartamento", recogeCadena((String) vDepartamento.get(0)) );
				
				asignar("LABELC","lblIdentificadorPC", recogeCadena( (String) vIdentificadorPc.get(0)) );

				String sTmp = ""; 
				long lTmp = 0;
				
				sTmp = recogeCadena((String) vPeriodoValidezFechaDesde.get(0));
				if ( sTmp!=null && !(sTmp.equals(""))){
					try{
						lTmp = Long.parseLong( sTmp );
						sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
					}catch(Exception e) {}
				}
				asignar("LABELC","", sTmp );
				
				sTmp = recogeCadena((String) vPeriodoValidezFechaHasta.get(0));
				if ( sTmp!=null && !(sTmp.equals(""))){
					try{
						lTmp = Long.parseLong( sTmp );
						sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
					}catch(Exception e) {}
				}
				asignar("LABELC","lblValidezHasta", sTmp );
								
				asignar("VAR","hPais", recogeCadena((String) vPais.get(0)) );
				asignarAtributo("LABELC","lblPais","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vPais.get(0))) );
				
				asignar("VAR","hSubgerenciaVentas", recogeCadena((String) vSubgerenciaVentas.get(0)) );
				asignarAtributo("LABELC","lblSubgerencia","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vSubgerenciaVentas.get(0))) );
				
				asignar("VAR","hRegion", recogeCadena( (String) vRegion.get(0)) );
				asignarAtributo("LABELC","lblRegion","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vRegion.get(0))) );
				
				asignar("VAR","hZona", recogeCadena( (String) vZona.get(0)) );
				asignarAtributo("LABELC","lblZona","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vZona.get(0))) );
				
				asignar("VAR","hSeccion", recogeCadena( (String) vSeccion.get(0)) );
				asignarAtributo("LABELC","lblSeccion","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vSeccion.get(0))) );
				
				asignar("VAR","hTerritorio", recogeCadena((String) vTerritorio.get(0)) );
				asignarAtributo("LABELC","lblTerritorio","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vTerritorio.get(0))) );
				
				asignar("VAR","hPaisDefecto", recogeCadena((String) vPaisDefecto.get(0)) );
				asignar("VAR","hSGVDefecto", recogeCadena((String) vSubgerenciaVentasDefecto.get(0)) );
				asignar("VAR","hRegionDefecto", recogeCadena((String) vRegionPorDefecto.get(0)) );
				asignar("VAR","hZonaDefecto", recogeCadena((String) vZonaPorDefecto.get(0)) );
				asignar("VAR","hSeccionDefecto", recogeCadena((String) vSeccionDefecto.get(0)) );
				asignar("VAR","hTerritorioDefecto", recogeCadena((String) vTerritorioPorDefecto.get(0)) );

				asignar("VAR","hSociedadDefecto", recogeCadena((String) vSociedadDefecto.get(0)) );
				asignar("VAR","hMarcaDefecto", recogeCadena((String) vMarcaDefecto.get(0)) );
				asignar("VAR","hCanalDefecto", recogeCadena((String) vCanalDefecto.get(0)) );
				asignar("VAR","hAccesoDefecto", recogeCadena((String) vAccesoDefecto.get(0)) );
				asignar("VAR","hSubaccesoDefecto", recogeCadena((String) vSubaccesoDefecto.get(0)) );

				asignar("VAR","hSociedad", recogeCadena((String) vSociedad.get(0)) );
				asignarAtributo("LABELC","lblSociedad","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vSociedad.get(0))) );
				
				asignar("VAR","hMarca", recogeCadena((String) vMarca.get(0)) );
				asignarAtributo("LABELC","lblMarca","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vMarca.get(0))) );
				
				asignar("VAR","hCanal", recogeCadena((String) vCanal.get(0)) );
				asignarAtributo("LABELC","lblCanal","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vCanal.get(0))) );
				
				asignar("VAR","hAcceso", recogeCadena((String) vAcceso.get(0)) );
				asignarAtributo("LABELC","lblAcceso","alto","" + SIZE_LABEL*obtenerCantFilas(recogeCadena((String) vAcceso.get(0)) ) );
				
				asignar("VAR","hSubnivelAcceso", recogeCadena((String) vSubnivelAcceso.get(0)) );					
				asignarAtributo("LABELC","lblSubnivelAcceso","alto","" + SIZE_LABEL*obtenerCantFilas( recogeCadena((String) vSubnivelAcceso.get(0)) ) );

				asignar("VAR","hTipoUsuario", recogeCadena((String) vTipoUsuario.get(0)) );
				asignar("VAR","hIdioma", recogeCadena((String) vIdioma.get(0)) );

				sTmp = recogeCadena((String) vFechaInicioRastreo.get(0));
				if ( sTmp!=null && !(sTmp.equals(""))){
					try{
						lTmp = Long.parseLong( sTmp );
						sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
					}catch(Exception e) {}
				}
				asignar("LABELC","lblFechaInicioRastreo", sTmp );

				sTmp = recogeCadena((String) vFechaFinalRastreo.get(0));
				if ( sTmp!=null && !(sTmp.equals(""))){
					try{
						lTmp = Long.parseLong( sTmp );
						sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
					}catch(Exception e) {}
				}
				asignar("LABELC","lblFechaFinRastreo", sTmp );
/*
				asignar("LABELC","lblFormatoFecha", recogeCadena((String) vFormatoFecha.get(0)) );
				asignar("LABELC","lblNumeroDecimal", recogeCadena((String) vFormatoNumerico.get(0)) );
				asignar("LABELC","lblSeparadorDecimales", recogeCadena((String) vFormatoNumericoSeparadorDecimales.get(0)) );
				asignar("LABELC","lblSeparadorMiles", recogeCadena((String) vFormatoNumericoSeparadorMiles.get(0)) );
*/
				asignar("VAR","hRastreoAcceso", recogeCadena((String) vRastreoAcceso.get(0)) );				
				asignar("VAR","hFuncionDirecta", recogeCadena((String) vPantallaInicioAsociada.get(0)) );
				asignar("LABELC","lblUsuarioSustitucion", recogeCadena((String) vUsuarioSustitucion.get(0)) );
				asignar("VAR","hUsuarioHabilitado", recogeCadena((String) vUsuarioHabilitado.get(0)) );

				sTmp = recogeCadena((String) vFechaSustitucionDesde.get(0));
				if ( sTmp!=null && !(sTmp.equals(""))){
					try{
						lTmp = Long.parseLong( sTmp );
						sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
					}catch(Exception e) {}
				}
				asignar("LABELC","lblFechaDesde", sTmp);

				sTmp = recogeCadena((String) vFechaSustitucionHasta.get(0));
				if ( sTmp!=null && !(sTmp.equals(""))){
					try{
						lTmp = Long.parseLong( sTmp );
						sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
					}catch(Exception e) {}
				}
				asignar("LABELC","lblFechaHasta", sTmp);
				
				asignar("LABELC","lblObservaciones", recogeCadena((String) vObservacionesSustitucion.get(0)) );

				prepararMantenimientoUsuarios();
			}
		} catch (Exception ex) {
			    // jalem: antes habia Throwable, cambie por Excepcion (Vivi)
				
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				traza("------\r\n" + sw.toString() + "------\r\n");

			
					this.lanzarPaginaError(ex);
			   
					/*BelcorpError belcorpError = new BelcorpError();
					DTOError dtoError = belcorpError.obtenerError(ex, idioma.toString() , pais.toString() );
					
					asignarAtributo("VAR", "errCodigo", "valor", "" + dtoError.getCodigoError() );
					asignarAtributo("VAR", "errDescripcion", "valor", dtoError.getDescripcionError() );
					*/
					
					pagina("contenido_usuario_consultar");

					asignarAtributo("VAR","accion", "valor", "Consultar");
					asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuario");
					
					asignarAtributo("VAR","elementosSeleccionados", "valor", pelementosSeleccionados);
		}
		
		getConfiguracionMenu(); //menú secundario
	}

    private void prepararMantenimientoUsuarios() throws Exception{
			Vector paramEntrada  = null;
			Vector rowsets = new Vector();
			Vector nombresJS = new Vector();
			String codigoJS = "";
			String resultado = "";
			HashMap params = new HashMap();
			DruidaConector conectorAlterado;

			MareDTO dtoe = new MareDTO();
			dtoe.setProperty("idioma", idioma );
					
			paramEntrada  = new Vector();
			paramEntrada.add( dtoe );
			paramEntrada.add( new MareBusinessID("MENObtieneDatosPantalla") );
			DruidaConector conectorMantenimiento = conectar("ConectorRecuperaDatosPantalla",  paramEntrada );

			nombresJS.add("vSociedad");				rowsets.add("dtoSalida.empresas_ROWSET");
			nombresJS.add("vDepartamento");			rowsets.add("dtoSalida.departamentos_ROWSET");
			nombresJS.add("vMarca");					rowsets.add("dtoSalida.marcas_ROWSET");
			nombresJS.add("vCanal");					rowsets.add("dtoSalida.canales_ROWSET");
			nombresJS.add("vAcceso");					rowsets.add("dtoSalida.accesos_ROWSET");
			nombresJS.add("vSubacceso");				rowsets.add("dtoSalida.subaccesos_ROWSET");
			nombresJS.add("vPerfil");					rowsets.add("dtoSalida.perfiles_ROWSET");
			nombresJS.add("vFuncionMenu");			rowsets.add("dtoSalida.funcionesMenu_ROWSET");
			nombresJS.add("vIdioma");					rowsets.add("dtoSalida.idiomas_ROWSET");
			nombresJS.add("vUsuarioSustitucion");	rowsets.add("dtoSalida.usuariosSustitucion_ROWSET");
			nombresJS.add("vPais");						rowsets.add("dtoSalida.paises_ROWSET");
			nombresJS.add("vSubgerencias");			rowsets.add("dtoSalida.subgerencias_ROWSET");
			nombresJS.add("vRegion");					rowsets.add("dtoSalida.regiones_ROWSET");
			nombresJS.add("vZona");						rowsets.add("dtoSalida.zonas_ROWSET");
			nombresJS.add("vSeccion");					rowsets.add("dtoSalida.secciones_ROWSET");
			nombresJS.add("vTerritorio");				rowsets.add("dtoSalida.territorios_ROWSET");

			for (int i=0; i<rowsets.size() ; i++)
			{
				params.clear();
				params.put("rowset", rowsets.get(i) );
				conectorAlterado = transformar("prepararMantenimientoUsuarios", conectorMantenimiento, params);
				resultado =(String) ((Element)((Node)conectorAlterado.getXML())).getChildNodes().item(0).getNodeValue();
				codigoJS = codigoJS + "var " + nombresJS.get(i) + " = " + resultado + "; ";
			}
			
			DruidaDOMObjeto objetoJS = crearJAVASCRIPT( codigoJS );
			asignar("JAVASCRIPT", "arraysJS", objetoJS);
    }

	private void mostrarResultadosBusqueda() throws Exception {

		asignarAtributo("CTEXTO","txtUsuario", "valor", pIdentificadorUsuario);
		asignarAtributo("CTEXTO","txtPrimerNombre", "valor", pNombre1);
		asignarAtributo("CTEXTO","txtSegundoNombre", "valor", pNombre2);
		asignarAtributo("CTEXTO","txtPrimerApellido", "valor", pApellido1);
		asignarAtributo("CTEXTO","txtSegundoApellido", "valor", pApellido2);
		asignarAtributo("VAR","hPerfil", "valor", pPerfil);								//asignarAtributo("COMBO","cbPerfil", "valor", pPerfil);		
		asignarAtributo("CTEXTO","txtTelefono", "valor", pTelefono);		
		asignarAtributo("VAR","hDepartamento", "valor", pDepartamento);				//asignarAtributo("COMBO","cbDepartamento", "valor", pDepartamento);		
		asignarAtributo("CTEXTO","txtValidezDesde", "valor", pValidezDesde);
		asignarAtributo("CTEXTO","txtHasta", "valor", pHasta);		
		asignarAtributo("VAR","hTipoUsuario", "valor", pTipoUsuario);					//asignarAtributo("COMBO","cbTipoUsuario", "valor", pTipoUsuario);
		asignarAtributo("VAR","hUsuarioHabilitado", "valor", pUsuarioHabilitado);	//asignarAtributo("RADIO","rbUsuarioHabilitado", "valor", pUsuarioHabilitado);

		DTOEntradaCriteriosDeBusquedaUsuarios dtoe = (DTOEntradaCriteriosDeBusquedaUsuarios) conectorParametroSesion("dtoeBuscar");
	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		dtoe.setUsuario(usuario);
		dtoe.setPassword(contrasenia);
		
		paramEntrada = new Vector();
		paramEntrada.add( dtoe );
		paramEntrada.add( new MareBusinessID("MENBuscarUsuarios") );
		conectorBuscar = conectar("ConectorBuscarUsuario", paramEntrada);

		asignarAtributo("CAPA","capaLista","y","401");
		asignarAtributo("CAPA","capaBoton2","y","548");
		
		asignarAtributo("CAPA","capaLista","visibilidad","visible");
		asignarAtributo("CAPA","capaBoton2","visibilidad","visible");
		asignarAtributo("VAR","casoDeUso", "valor", "consultar");
		
		asignar("LISTA","lstLista",conectorBuscar,"dtoSalida.resultado_ROWSET");

		asignarAtributo("VAR","accion", "valor", "Buscar");
		asignarAtributo("VAR","conectorAction", "valor", "LPConsultarUsuario");
		
		obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
	}

	private void obtenerParametrosBusqueda(DTOEntradaCriteriosDeBusquedaUsuarios dtoe, String accion) throws Exception{
		
		String origen = "sesion";
		
		if ( accion.equals("Buscar") ) origen = "pagina";
		
		if (origen.equals("sesion") ){
			
			//traza("saca de sesion");
			//Se recoge el DTOEntradaGenerico de la sesión. 		
			dtoe = (DTOEntradaCriteriosDeBusquedaUsuarios) conectorParametroSesion("dtoeBuscar");

		    String usuario = (String)conectorParametroSesion("DruidaUsuario");
			String contrasenia = (String)conectorParametroSesion("DruidaPassword");
			dtoe.setUsuario(usuario);
			dtoe.setPassword(contrasenia);

			pIdentificadorUsuario 	= (String) dtoe.getIdUsuario();
			pNombre1    				= (String) dtoe.getNombreUsuario1();
			pNombre2    				= (String) dtoe.getNombreUsuario2();
			pApellido1    				= (String) dtoe.getApellidoUsuario1();
			pApellido2    				= (String) dtoe.getApellidoUsuario2();

			pPerfil						= (String) dtoe.getPerfil();
			pTelefono					= (String) dtoe.getTelefonoContacto();
			pDepartamento				= (String) dtoe.getDepartamento();
			pValidezDesde				= (String) dtoe.getValidezDesde();
			pHasta						= (String) dtoe.getValidezHasta();
			pTipoUsuario				= (String) dtoe.getTipoUsuario();
			pUsuarioHabilitado		= (String) dtoe.getUsuarioHabilitado();

		} else { //pagina.
			
			//traza("saca de pagina");
			pIdentificadorUsuario	= conectorParametroLimpia("txtUsuario","",true);
			pNombre1						= conectorParametroLimpia("txtPrimerNombre","",true);
			pNombre2						= conectorParametroLimpia("txtSegundoNombre","",true);
			pApellido1					= conectorParametroLimpia("txtPrimerApellido","",true);
			pApellido2					= conectorParametroLimpia("txtSegundoApellido","",true);
			pPerfil						= conectorParametroLimpia("cbPerfil","",true);
			pTelefono					= conectorParametroLimpia("txtTelefono","",true);
			pDepartamento				= conectorParametroLimpia("cbDepartamento","",true);
			pValidezDesde				= conectorParametroLimpia("txtValidezDesde","",true);
			pHasta						= conectorParametroLimpia("txtHasta","",true);
			pTipoUsuario				= conectorParametroLimpia("cbTipoUsuario","",true);
			pUsuarioHabilitado		= conectorParametroLimpia("rbUsuarioHabilitado","",true);
			
		    String usuario = (String)conectorParametroSesion("DruidaUsuario");
			String contrasenia = (String)conectorParametroSesion("DruidaPassword");
			dtoe.setUsuario(usuario);
			dtoe.setPassword(contrasenia);

			dtoe.setIdUsuario( pIdentificadorUsuario );
			dtoe.setNombreUsuario1( pNombre1 );
			dtoe.setNombreUsuario2( pNombre2 );
			dtoe.setApellidoUsuario1( pApellido1 );
			dtoe.setApellidoUsuario2( pApellido2 );
			dtoe.setPerfil( pPerfil );
			dtoe.setTelefonoContacto( pTelefono );
			dtoe.setDepartamento( pDepartamento );
			dtoe.setValidezDesde( pValidezDesde );
			dtoe.setValidezHasta( pHasta );
			dtoe.setTipoUsuario( pTipoUsuario );
			dtoe.setUsuarioHabilitado( pUsuarioHabilitado );

			//Se almacena el DTOEntradaGenerico en sesión. 
			conectorParametroSesion("dtoeBuscar",dtoe);
		}
	}

	private void obtenerCombosBusqueda(Long idioma) throws Exception {

		paramEntrada = new Vector();
		
		MareDTO dtoe = new MareDTO();
		dtoe.setProperty("idioma", idioma);
		
		paramEntrada.add( dtoe );
		paramEntrada.add( new MareBusinessID("MENCargaDatosEnPantalla") );
		conectorBuscar = conectar("ConectorCargaDatosPantalla", paramEntrada);

		asignar("COMBO","cbPerfil",conectorBuscar,"dtoSalida.perfiles_ROWSET");
		asignar("COMBO","cbDepartamento",conectorBuscar,"dtoSalida.departamentos_ROWSET");
	}
	
	private int obtenerCantFilas(String cadena){
		int valor = 1;
		
		StringTokenizer stk = new StringTokenizer(cadena,"|");
		if ( stk.countTokens() > 0)
			return stk.countTokens();
		else
			return valor;		
	}
	
	private String recogeCadena(String param){
		if (param==null)
			return "";
		else
			return param;	
	}
}
