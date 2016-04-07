/**
 * Sistema:           Belcorp - SICC
 * Modulo:            MEN - Menu
 * Componente:        LPModificarUsuarios
 * @version           2.0
 */

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaInsertarUsuarios;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
//import es.indra.druida.DruidaBase;
/* By Jalem - 26/01/2004
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
*/

public class LPModificarUsuarios extends LPSICCBase{

   /*INI-Parametros Modificacion*/
   String txtUsuario = null;
   String cbPerfil = null;
   String txtClaveDeAcceso = null;
   String rbClaveInicial = null;
   String txtPrimerApellido = null;
   String txtSegundoApellido = null;
   String txtApellidoCasada = null;
   String txtPrimerNombre = null;
   String txtSegundoNombre = null;
   String txtEmail = null;
   String txtTelefono = null;
   String cbDepartamento = null;
   String txtIdentificadorPC = null;
   String txtValidezDesde = null;
   String txtValidezHasta = null;

   String cbSociedad = null;
   String cbMarca = null;
   String cbCanal = null;
   String cbAcceso = null;
   String cbSubnivelAcceso = null;
   String cbPais = null;
   String cbSubgerenciaVentas = null;
   String cbRegion = null;
   String cbZona = null;
   String cbSeccion = null;
   String cbTerritorio = null;

   String cbPaisPorDefecto = null;
   String cbSGVPorDefecto = null;
   String cbRegionPorDefecto = null;
   String cbSeccionPorDefecto = null;
   String cbSociedadPorDefecto = null;
   String cbMarcaPorDefecto = null;
   String cbAccesoPorDefecto = null;
   String cbZonaPorDefecto = null;
   String cbTerritorioPorDefecto = null;
   String cbCanalPorDefecto = null;
   String cbSubaccesoPorDefecto = null;
   String cbTipoUsuario = null;

   String cbIdioma = null;
/*
   String txtFormatoFecha = null;
   String txtNumeroDecimal = null;
   String txtSeparadorDecimales = null;
   String txtSeparadorMiles = null;
*/
   String cbTipoRastreo = null;
   String txtFechaInicioRastreo = null;
   String txtFechaFinRastreo = null;
   String cbPantallaInicioAsociada = null;

   String cbUsuarioSustitucion = null;
   String txtFechaDesde = null;
   String txtFechaHasta = null;
   String txtaObservaciones = null;
   String cbUsuarioHabilitado = null;
   String txtFechaClave = null;

			//Inc. 6142
	String ckIndNDG = null;
	String ckIndAdmNDG = null;
	
	/*FIN-Parametros Modificacion*/

   /*INI-Parametros Buscar*/
   String accion = null;
   String pIdentificadorUsuario = null;
   String pNombre1 = null;
   String pNombre2 = null;
   String pApellido1 = null;
   String pApellido2 = null;
   String pPerfil = null;
   String pTelefono = null;
   String pDepartamento = null;
   String pValidezDesde = null;
   String pHasta = null;
   String pTipoUsuario = null;
   String pUsuarioHabilitado = null;

   String elementosSeleccionados = null;

	/*FIN-Parametros Buscar*/

   Vector paramEntrada = null;
   DTOEntradaConsultarUsuario dtoeConsultar = null;
   DTOEntradaCriteriosDeBusquedaUsuarios dtoe = null;
   DTOEntradaInsertarUsuarios dtoeModificar = null;

   DruidaConector conectorBuscar = null;
   DruidaConector conectorConsultar = null;
   DruidaConector conectorModificar = null;

   Long idioma;
   Long pais;

   public LPModificarUsuarios(){
      super();
   }

   public void inicio() throws Exception{
      //pagina("contenido_usuarios_buscar");
   }

   public void ejecucion() throws Exception{

      setTrazaFichero();
	  rastreo();
      accion = conectorParametroLimpia("accion", "", true);   //recogeCadena(conectorParametro("accion"));
      //traza("accion de entrada: " + accion);
	 String usuario = (String)conectorParametroSesion("DruidaUsuario");
	 String contrasenia = (String)conectorParametroSesion("DruidaPassword");

                  idioma = UtilidadesSession.getIdioma( this );
                  pais = UtilidadesSession.getPais( this );
    asignarAtributo("VAR","hUsuarioActual", "valor", UtilidadesSession.getIdUsuario(this) );
      try{

          if(accion.equals("")){
             pagina("contenido_usuarios_buscar");
                           asignarAtributoPagina("cod", "042");
                           generarHiddenFormatoFecha();

             obtenerCombosBusqueda(idioma); //llena perfiles y departamentos

             asignarAtributo("VAR", "accion", "valor", "Buscar");
             asignarAtributo("VAR","casoDeUso", "valor", "Modificar");
             asignarAtributo("VAR", "conectorAction", "valor", "LPModificarUsuarios");

          }

          if(accion.equals("Buscar") || accion.equals("VolverModifica")){

             dtoe = new DTOEntradaCriteriosDeBusquedaUsuarios();
			 dtoe.setUsuario(usuario);
			 dtoe.setPassword(contrasenia);

             obtenerParametrosBusqueda(dtoe, accion);

             pagina("contenido_usuarios_buscar");
                           asignarAtributoPagina("cod", "042");
                           generarHiddenFormatoFecha();

             mostrarResultadosBusqueda();
          }
      } catch(Exception ex){
          pagina("contenido_usuarios_buscar");
                   asignarAtributoPagina("cod", "042");		
                   generarHiddenFormatoFecha();
          obtenerCombosBusqueda(idioma); //llena perfiles y departamentos                                             
          this.lanzarPaginaError(ex);
          asignarAtributo("VAR", "accion", "valor", "Buscar");
          asignarAtributo("VAR", "conectorAction", "valor", "LPModificarUsuarios");

          asignarAtributo("CTEXTO", "txtUsuario", "valor", pIdentificadorUsuario);
          asignarAtributo("CTEXTO", "txtPrimerNombre", "valor", pNombre1);
          asignarAtributo("CTEXTO", "txtSegundoNombre", "valor", pNombre2);
          asignarAtributo("CTEXTO", "txtPrimerApellido", "valor", pApellido1);
          asignarAtributo("CTEXTO", "txtSegundoApellido", "valor", pApellido2);
          asignarAtributo("VAR", "hPerfil", "valor", pPerfil);                                                                   //asignarAtributo("COMBO","cbPerfil", "valor", pPerfil);
          asignarAtributo("CTEXTO", "txtTelefono", "valor", pTelefono);
          asignarAtributo("VAR", "hDepartamento", "valor", pDepartamento);                                   //asignarAtributo("COMBO","cbDepartamento", "valor", pDepartamento);
          asignarAtributo("CTEXTO", "txtValidezDesde", "valor", pValidezDesde);

		  asignarAtributo("CTEXTO", "txtValidezDesde", "valor", pHasta);
         //asignarAtributo("CTEXTO", "txtHasta", "valor", sTmp);



          asignarAtributo("VAR", "hTipoUsuario", "valor", pTipoUsuario);                                     //asignarAtributo("COMBO","cbTipoUsuario", "valor", pTipoUsuario);
          asignarAtributo("VAR", "hUsuarioHabilitado", "valor", pUsuarioHabilitado);     //asignarAtributo("RADIO","rbUsuarioHabilitado", "valor", pUsuarioHabilitado);
      }

      try{
          if(accion.equals("Modificar")){
             pagina("contenido_usuario_modificar");

			  asignarAtributo("CTEXTO", "txtClaveAcceso", "req", "N");
			  asignarAtributo("CTEXTO", "txtConfirmarClaveAcceso", "req", "N");
	        String dFechaTmp = null;
			java.util.Date hoy = new java.util.Date(System.currentTimeMillis() );

			String formatoFecha = UtilidadesSession.getFormatoFecha(this);
			formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.
	         SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);
			try {
				dFechaTmp = simpledateformat.format(hoy);
				
			} catch(Exception e) {}


			 asignarAtributo("LABELC","txtFechaCambioClave","valor",  dFechaTmp.toString());


			  elementosSeleccionados = recogeCadena(conectorParametro("elementosSeleccionados"));

             dtoeConsultar = new DTOEntradaConsultarUsuario();

			 dtoeConsultar.setUsuario(usuario);
			 dtoeConsultar.setPassword(contrasenia);

             dtoeConsultar.setIdUsuario(elementosSeleccionados);

             paramEntrada = new Vector();
             paramEntrada.add(dtoeConsultar);
             paramEntrada.add(new MareBusinessID("MENConsultarUsuarios"));
             conectorConsultar = conectar("ConectorConsultarUsuarios", paramEntrada);

             //Obtengo valores del usuario elegido.
             obtenerResultadoConsulta(conectorConsultar); 

			 asignarResultadoConsulta();
             
             //Obtengo valores de la base.
             prepararMantenimientoUsuarios();

             asignarAtributo("VAR", "accion", "valor", "ejecutarModifica");
             asignarAtributo("VAR", "conectorAction", "valor", "LPModificarUsuarios");
             asignarAtributo("VAR", "elementosSeleccionados", "valor", elementosSeleccionados);

          }

      } catch(Exception ex){
          pagina("contenido_usuario_modificar");
		 asignarAtributo("VAR", "duplicado", "valor", "duplicado");                  
        this.lanzarPaginaError(ex);

          asignarAtributo("VAR", "accion", "valor", "Modificar");
          asignarAtributo("VAR", "conectorAction", "valor", "LPModificarUsuarios");

          asignarAtributo("VAR", "elementosSeleccionados", "valor", elementosSeleccionados);
      }

      try{
          if(accion.equals("ejecutarModifica")){
			 pagina("salidaGenerica");
			 //asignarAtributo("VAR", "debugWindow", "valor", "true");
             //pagina("contenido_usuario_modificar");
             obtenerParametrosModificacion(); //de la página

             ///crear dto modificacion, guardar en sesion ese dto;
             dtoeModificar = new DTOEntradaInsertarUsuarios();
			 dtoeModificar.setUsuario(usuario);
			 dtoeModificar.setPassword(contrasenia);
             asignarValoresADTO(dtoeModificar);
			//traza(dtoeModificar);                           

             conectorParametroSesion("dtoeModificar", dtoeModificar);


             paramEntrada = new Vector();
             paramEntrada.add(dtoeModificar);
             paramEntrada.add(new MareBusinessID("MENModificarUsuarios"));
             conectorModificar = conectar("ConectorModificarUsuarios", paramEntrada);
			 asignarAtributo("VAR","ejecutar","valor","reConsulta()");
          }
      } catch(Exception ex){
                   this.lanzarPaginaError(ex);

      }

      getConfiguracionMenu();

   }

    private void prepararMantenimientoUsuarios() throws Exception{
        this.getFormatosValidaciones();
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
		asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
		asignar("COMBO", "cbPais", resultados, "REPRecuperarPaises");
		asignar("COMBO", "cbIdioma", resultados, "CMNRecuperarIdiomasSEG");
		asignar("COMBO", "cbPerfil", resultados, "MENRecuperaPerfiles");
		asignar("COMBO", "cbDepartamento", resultados, "SEGObtenerDepartamentos");
        asignar("COMBO", "cbSociedad", resultados, "MENRecargaSociedades");

    }

   private String recogeCadena(String param){
      if(param == null)
          return "";
      else
          return param;
   }

   private void obtenerParametrosBusqueda(DTOEntradaCriteriosDeBusquedaUsuarios dtoe, String accion) throws Exception{
      String origen = "sesion";

      if(accion.equals("Buscar")) origen = "pagina";

      if(origen.equals("sesion")){
          //Se recoge el DTOEntradaGenerico de la sesión.
          dtoe = (DTOEntradaCriteriosDeBusquedaUsuarios)conectorParametroSesion("dtoeBuscar");

		  String usuario = (String)conectorParametroSesion("DruidaUsuario");
		  String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		  dtoe.setUsuario(usuario);
		  dtoe.setPassword(contrasenia);

          pIdentificadorUsuario = (String)dtoe.getIdUsuario();
          pNombre1 = (String)dtoe.getNombreUsuario1();
          pNombre2 = (String)dtoe.getNombreUsuario2();
          pApellido1 = (String)dtoe.getApellidoUsuario1();
          pApellido2 = (String)dtoe.getApellidoUsuario2();

          //pPerfil = (String)dtoe.getPerfil();
          pTelefono = (String)dtoe.getTelefonoContacto();
          pDepartamento = (String)dtoe.getDepartamento();
          pValidezDesde = (String)dtoe.getValidezDesde();
          pHasta = (String)dtoe.getValidezHasta();
          pTipoUsuario = (String)dtoe.getTipoUsuario();
          pUsuarioHabilitado = (String)dtoe.getUsuarioHabilitado();

      } else{ //pagina.
          pIdentificadorUsuario = recogeCadena(conectorParametro("txtUsuario"));
          pNombre1 = recogeCadena(conectorParametro("txtPrimerNombre"));
          pNombre2 = recogeCadena(conectorParametro("txtSegundoNombre"));
          pApellido1 = recogeCadena(conectorParametro("txtPrimerApellido"));
          pApellido2 = recogeCadena(conectorParametro("txtSegundoApellido"));
          pPerfil = recogeCadena(conectorParametro("cbPerfil"));
          pTelefono = recogeCadena(conectorParametro("txtTelefono"));
          pDepartamento = recogeCadena(conectorParametro("cbDepartamento"));
          pValidezDesde = recogeCadena(conectorParametro("txtValidezDesde"));
          pHasta = recogeCadena(conectorParametro("txtHasta"));
          pTipoUsuario = recogeCadena(conectorParametro("cbTipoUsuario"));
          pUsuarioHabilitado = recogeCadena(conectorParametro("rbUsuarioHabilitado"));

          dtoe.setIdUsuario(pIdentificadorUsuario);
          dtoe.setNombreUsuario1(pNombre1);
          dtoe.setNombreUsuario2(pNombre2);
          dtoe.setApellidoUsuario1(pApellido1);
          dtoe.setApellidoUsuario2(pApellido2);
/*		  ArrayList perfiles = new ArrayList();
			if ( !pPerfil.equals("") )	{
				StringTokenizer tokenizer = new StringTokenizer(pPerfil, "|");
				while (tokenizer.hasMoreTokens()) {
					perfiles.add(tokenizer.nextToken());
				}
			}*/
		   dtoe.setPerfil( pPerfil ); 		
          dtoe.setTelefonoContacto(pTelefono);
          dtoe.setDepartamento(pDepartamento);
          dtoe.setValidezDesde(pValidezDesde);
          dtoe.setValidezHasta(pHasta);
          dtoe.setTipoUsuario(pTipoUsuario);
          dtoe.setUsuarioHabilitado(pUsuarioHabilitado);
          dtoe.setFormatoFecha(UtilidadesSession.getFormatoFecha(this) );
          conectorParametroSesion("dtoeBuscar", dtoe);
      }
   }

   private void mostrarResultadosBusqueda() throws Exception{

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
                  asignar("LISTADOA","listado1",conectorBuscar,"dtoSalida.resultado_ROWSET");

                  asignarAtributo("VAR","accion", "valor", "Buscar");
                  asignarAtributo("VAR","conectorAction", "valor", "LPModificarUsuarios");
                  
                  obtenerCombosBusqueda(idioma); //llena perfiles y departamentos
   }

   private void obtenerResultadoConsulta(DruidaConector conector) throws Exception{


		traza(conector.getXML());

           String sTmp = ""; 
           long lTmp = 0;

      txtUsuario = recogeCadena((String)valorVector("IdUsuario", conector).get(0));
	  cbPerfil = recogeCadena((String)valorVector("Perfil", conector).get(0));
	  txtClaveDeAcceso = "";
	  txtApellidoCasada = recogeCadena((String)valorVector("ApellidoCasada", conector).get(0));
	  cbDepartamento = recogeCadena((String)valorVector("Departamento", conector).get(0));
	  txtEmail = recogeCadena((String)valorVector("Email", conector).get(0));
	  cbSociedad = recogeCadena((String)valorVector("Sociedad", conector).get(0));

           sTmp = "";
            lTmp = 0;

           sTmp = recogeCadena((String)valorVector("FechaSustitucionDesde", conector).get(0));
           if ( sTmp!=null && !(sTmp.equals(""))){
                try{
                                    lTmp = Long.parseLong( sTmp );
                                    sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
                           }catch(Exception e) {}
            }
            txtFechaDesde = sTmp;
		   //traza("FechaSustitucionDesde " + txtFechaDesde);
      //txtFechaDesde = recogeCadena((String)valorVector("FechaSustitucionDesde", conector).get(0));

           sTmp = "";
           lTmp = 0;
           sTmp = recogeCadena((String)valorVector("FechaSustitucionHasta", conector).get(0));
           if ( sTmp!=null && !(sTmp.equals(""))){
                try{
                                    lTmp = Long.parseLong( sTmp );
                                    sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
                           }catch(Exception e) {}
            }
         txtFechaHasta = sTmp;
		   //traza("FechaSustitucionHasta " + txtFechaHasta);

      txtIdentificadorPC = recogeCadena((String)valorVector("IdentificadorPc", conector).get(0));
	  cbIdioma = recogeCadena((String)valorVector("Idioma", conector).get(0));
	  rbClaveInicial = recogeCadena((String)valorVector("IndicacionClaveInicial", conector).get(0));
	  cbMarca = recogeCadena((String)valorVector("Marca", conector).get(0));
	  txtaObservaciones = recogeCadena((String)valorVector("ObservacionesSustitucion", conector).get(0));
	  //traza("orseb " + txtaObservaciones);
	  cbPaisPorDefecto = recogeCadena((String)valorVector("PaisDefecto", conector).get(0));
	  cbPantallaInicioAsociada = recogeCadena((String)valorVector("PantallaInicioAsociada", conector).get(0));

            sTmp = ""; 
            lTmp = 0;
          
           sTmp = recogeCadena((String)valorVector("PeriodoValidezFechaDesde", conector).get(0));
           if ( sTmp!=null && !(sTmp.equals(""))){
                try{
                                    lTmp = Long.parseLong( sTmp );
                                    sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
                           }catch(Exception e) {}
            }
           txtValidezDesde = sTmp;
		   //traza("txtValidezDesde " + txtValidezDesde);
                  
           sTmp = "";
            lTmp = 0;

           sTmp = recogeCadena((String)valorVector("PeriodoValidezFechaHasta", conector).get(0));
           if ( sTmp!=null && !(sTmp.equals(""))){
                try{
                                    lTmp = Long.parseLong( sTmp );
                                    sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
                           }catch(Exception e) {}
            }
            txtValidezHasta = sTmp;
		   //traza("txtValidezHasta " + txtValidezHasta);



      txtPrimerApellido = recogeCadena((String)valorVector("PrimerApellido", conector).get(0));
	  txtPrimerNombre = recogeCadena((String)valorVector("PrimerNombre", conector).get(0));
	  cbTipoRastreo = recogeCadena((String)valorVector("RastreoAcceso", conector).get(0));
	  cbSeccionPorDefecto = recogeCadena((String)valorVector("SeccionDefecto", conector).get(0));
	  cbRegionPorDefecto = recogeCadena((String)valorVector("RegionPorDefecto", conector).get(0));
	  txtSegundoApellido = recogeCadena((String)valorVector("SegundoApellido", conector).get(0));
	  txtSegundoNombre = recogeCadena((String)valorVector("SegundoNombre", conector).get(0));
	  txtTelefono = recogeCadena((String)valorVector("TelefonoContacto", conector).get(0));
	  cbTipoUsuario = recogeCadena((String)valorVector("TipoUsuario", conector).get(0));
	  cbUsuarioHabilitado = recogeCadena((String)valorVector("UsuarioHabilitado", conector).get(0));
 	  Vector vUsuarioSustitucion = valorVector("UsuarioSustitucion", conectorConsultar);
		String u1 = "";
		String u2 = "";
		if ((vUsuarioSustitucion.get(0)!=null) || (!vUsuarioSustitucion.get(0).equals("")))	{
			StringTokenizer sust = new StringTokenizer((String) vUsuarioSustitucion.get(0), "|");
			try	{
				u1 = sust.nextToken();
				traza(u1);
				u2 = sust.nextToken();
				traza(u2);
			} catch (Exception x) {
			}

		}

		//asignar("LABELC","lblUsuarioSustitucion", u2);
	  cbUsuarioSustitucion = u1;
	  //cbUsuarioSustitucion = recogeCadena((String)valorVector("UsuarioSustitucion", conector).get(0));
	  cbZonaPorDefecto = recogeCadena((String)valorVector("ZonaPorDefecto", conector).get(0));

	  ckIndNDG = recogeCadena((String)valorVector("indNDG", conector).get(0));
	  ckIndAdmNDG = recogeCadena((String)valorVector("indAdmNDG", conector).get(0));
	  
	  cbAcceso = recogeCadena((String)valorVector("Acceso", conector).get(0));
	  cbCanal = recogeCadena((String)valorVector("Canal", conector).get(0));
	  cbPais = recogeCadena((String)valorVector("Pais", conector).get(0));
	  cbRegion = recogeCadena((String)valorVector("Region", conector).get(0));
	  cbSeccion = recogeCadena((String)valorVector("Seccion", conector).get(0));
	  cbSubnivelAcceso = recogeCadena((String)valorVector("SubnivelAcceso", conector).get(0));
	  cbTerritorio = recogeCadena((String)valorVector("Territorio", conector).get(0));
	  cbZona = recogeCadena((String)valorVector("Zona", conector).get(0));

	  cbSociedadPorDefecto = recogeCadena((String)valorVector("SociedadPorDefecto", conector).get(0));
	  cbMarcaPorDefecto = recogeCadena((String)valorVector("MarcaPorDefecto", conector).get(0));
	  cbCanalPorDefecto = recogeCadena((String)valorVector("CanalPorDefecto", conector).get(0));
	  cbAccesoPorDefecto = recogeCadena((String)valorVector("AccesoPorDefecto", conector).get(0));
	  cbSubaccesoPorDefecto = recogeCadena((String)valorVector("SubaccesoPorDefecto", conector).get(0));
	  cbSubgerenciaVentas = recogeCadena((String)valorVector("SubgerenciaVentas", conector).get(0));
	  cbSGVPorDefecto = recogeCadena((String)valorVector("SubgerenciaVentasDefecto", conector).get(0));
	  cbTerritorioPorDefecto = recogeCadena((String)valorVector("TerritorioPorDefecto", conector).get(0));

            sTmp = ""; 
            lTmp = 0;
                                    
           sTmp = recogeCadena((String)valorVector("FechaInicioRastreo", conector).get(0));
           if ( sTmp!=null && !(sTmp.equals(""))){
                try{
                                    lTmp = Long.parseLong( sTmp );
                                    sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
                           }catch(Exception e) {}
            }
           txtFechaInicioRastreo = sTmp;
		   //traza("txtFechaInicioRastreo " + txtFechaInicioRastreo);


            sTmp = ""; 
            lTmp = 0;
                                    
           sTmp = recogeCadena((String)valorVector("FechaFinalRastreo", conector).get(0));
           if ( sTmp!=null && !(sTmp.equals(""))){
                try{
                                    lTmp = Long.parseLong( sTmp );
                                    sTmp = UtilidadesBelcorp.fechalongToString(this, lTmp);
                           }catch(Exception e) {}
            }
           txtFechaFinRastreo = sTmp;
		   //traza("txtFechaFinRastreo " + txtFechaFinRastreo);
         
   }

   //Asigno los valores a la pagina.
   private void asignarResultadoConsulta() throws Exception{
      asignarAtributo("CTEXTO", "txtUsuario", "valor", txtUsuario);
      asignarAtributo("CTEXTO", "txtClaveAcceso", "valor", txtClaveDeAcceso);
      asignarAtributo("VAR", "hIndicacionClaveInicial", "valor", rbClaveInicial);
      asignarAtributo("VAR", "hPerfil", "valor", cbPerfil);
      asignarAtributo("CTEXTO", "txtPrimerApellido", "valor", txtPrimerApellido);
      asignarAtributo("CTEXTO", "txtSegundoApellido", "valor", txtSegundoApellido);
      asignarAtributo("CTEXTO", "txtApellidoCasada", "valor", txtApellidoCasada);
      asignarAtributo("CTEXTO", "txtPrimerNombre", "valor", txtPrimerNombre);
      asignarAtributo("CTEXTO", "txtSegundoNombre", "valor", txtSegundoNombre);
      asignarAtributo("CTEXTO", "txtEmail", "valor", txtEmail);
      asignarAtributo("CTEXTO", "txtTelefono", "valor", txtTelefono);
      asignarAtributo("VAR", "hDepartamento", "valor", cbDepartamento);
      asignarAtributo("CTEXTO", "txtIdentificadorPC", "valor", txtIdentificadorPC);
      asignarAtributo("CTEXTO", "txtValidezDesde", "valor", txtValidezDesde);
      asignarAtributo("CTEXTO", "txtValidezHasta", "valor", txtValidezHasta);
      asignarAtributo("VAR", "hPais", "valor", cbPais);
      asignarAtributo("VAR", "hRegion", "valor", cbRegion);
      asignarAtributo("VAR", "hZona", "valor", cbZona);
      asignarAtributo("VAR", "hSeccion", "valor", cbSeccion);
      asignarAtributo("VAR", "hTerritorio", "valor", cbTerritorio);
      asignarAtributo("VAR", "hPaisPorDefecto", "valor", cbPaisPorDefecto);
      asignarAtributo("VAR", "hRegionPorDefecto", "valor", cbRegionPorDefecto);
      asignarAtributo("VAR", "hZonaPorDefecto", "valor", cbZonaPorDefecto);
      asignarAtributo("VAR", "hSeccionPorDefecto", "valor", cbSeccionPorDefecto);
      asignarAtributo("VAR", "hSociedad", "valor", cbSociedad);
      asignarAtributo("VAR", "hMarca", "valor", cbMarca);
      asignarAtributo("VAR", "hCanal", "valor", cbCanal);
      asignarAtributo("VAR", "hAcceso", "valor", cbAcceso);
      asignarAtributo("VAR", "hSubnivelAcceso", "valor", cbSubnivelAcceso);
      asignarAtributo("VAR", "hTipoUsuario", "valor", cbTipoUsuario);
      asignarAtributo("VAR", "hIdioma", "valor", cbIdioma);
      asignarAtributo("VAR", "hTipoRastreo", "valor", cbTipoRastreo);
      asignarAtributo("VAR", "hFuncionDirecta", "valor", cbPantallaInicioAsociada);
      asignarAtributo("VAR", "hUsuarioHabilitado", "valor", cbUsuarioHabilitado);
      asignarAtributo("VAR", "hUsuarioSustitucion", "valor", cbUsuarioSustitucion);
	  //traza(cbUsuarioSustitucion);
      asignarAtributo("CTEXTO", "txtFechaSustitucionDesde", "valor", txtFechaDesde);
      asignarAtributo("CTEXTO", "txtFechaSustitucionHasta", "valor", txtFechaHasta);
      asignarAtributo("AREATEXTO", "areatxtObservaciones", "valor", txtaObservaciones);
                  //v3
      asignarAtributo("VAR","hSubgerenciaVentas", "valor", cbSubgerenciaVentas);
      asignarAtributo("VAR","hSGVPorDefecto", "valor", cbSGVPorDefecto);
      asignarAtributo("VAR","hTerritorioPorDefecto", "valor", cbTerritorioPorDefecto);
      asignarAtributo("VAR","hSociedadPorDefecto", "valor", cbSociedadPorDefecto);
      asignarAtributo("VAR","hMarcaPorDefecto", "valor", cbMarcaPorDefecto);
      asignarAtributo("VAR","hCanalPorDefecto", "valor", cbCanalPorDefecto);
      asignarAtributo("VAR","hAccesoPorDefecto", "valor", cbAccesoPorDefecto);
      asignarAtributo("VAR","hSubaccesoPorDefecto", "valor", cbSubaccesoPorDefecto);
      asignarAtributo("CTEXTO","txtFechaInicioRastreo", "valor", txtFechaInicioRastreo);
      asignarAtributo("CTEXTO","txtFechaFinRastreo", "valor", txtFechaFinRastreo);

      asignarAtributo("VAR","hIndNDG", "valor", ckIndNDG);
      asignarAtributo("VAR","hIndAdmNDG", "valor", ckIndAdmNDG);
	}

   private void obtenerParametrosModificacion() throws Exception{
      txtUsuario = conectorParametroLimpia("txtUsuario","",true);
      txtClaveDeAcceso = conectorParametroLimpia("txtClaveAcceso","",true);
      rbClaveInicial = conectorParametroLimpia("rbClaveInicial","",true);
      cbPerfil = conectorParametroLimpia("cbPerfil","",true);
      txtPrimerApellido = conectorParametroLimpia("txtPrimerApellido","",true);
      txtSegundoApellido = conectorParametroLimpia("txtSegundoApellido","",true);
      txtApellidoCasada = conectorParametroLimpia("txtApellidoCasada","",true);
      txtPrimerNombre = conectorParametroLimpia("txtPrimerNombre","",true);
      txtSegundoNombre = conectorParametroLimpia("txtSegundoNombre","",true);
      txtEmail = conectorParametroLimpia("txtEmail","",true);
      txtTelefono = conectorParametroLimpia("txtTelefono","",true);
      cbDepartamento = conectorParametroLimpia("cbDepartamento","",true);
      txtIdentificadorPC = conectorParametroLimpia("txtIdentificadorPC","",true);
      txtValidezDesde = conectorParametroLimpia("txtValidezDesde","",true);
      txtValidezHasta = conectorParametroLimpia("txtValidezHasta","",true);
      cbPais = conectorParametroLimpia("cbPais","",true);
      cbRegion = conectorParametroLimpia("cbRegion","",true);
      cbZona = conectorParametroLimpia("cbZona","",true);
      cbSeccion = conectorParametroLimpia("cbSeccion","",true);
      cbTerritorio = conectorParametroLimpia("cbTerritorio","",true);
      cbPaisPorDefecto = conectorParametroLimpia("cbPaisPorDefecto","",true);
      cbRegionPorDefecto = conectorParametroLimpia("cbRegionPorDefecto","",true);
      cbZonaPorDefecto = conectorParametroLimpia("cbZonaPorDefecto","",true);
      cbSeccionPorDefecto = conectorParametroLimpia("cbSeccionPorDefecto","",true);
      cbSociedad = conectorParametroLimpia("cbSociedad","",true);
      cbMarca = conectorParametroLimpia("cbMarca","",true);
      cbCanal = conectorParametroLimpia("cbCanal","",true);
      cbAcceso = conectorParametroLimpia("cbAcceso","",true);
      cbSubnivelAcceso = conectorParametroLimpia("cbSubacceso","",true);
      cbTipoUsuario = conectorParametroLimpia("cbTipoUsuario","",true);
      cbIdioma = conectorParametroLimpia("cbIdioma","",true);


/*
      txtFormatoFecha = conectorParametroLimpia("txtFormatoFecha","",true);
      txtNumeroDecimal = conectorParametroLimpia("txtNumeroDecimales","",true);
      txtSeparadorDecimales = conectorParametroLimpia("txtSeparadorDecimales","",true);
      txtSeparadorMiles = conectorParametroLimpia("txtSeparadorMiles","",true);
*/
      cbTipoRastreo = conectorParametroLimpia("cbTipoRastreo","",true);
      cbPantallaInicioAsociada = conectorParametroLimpia("cbPantallaInicioAsociada","",true);
      cbUsuarioSustitucion = conectorParametroLimpia("cbUsuarioSustitucion","",true);
      cbUsuarioHabilitado = conectorParametroLimpia("rbUsuarioHabilitado","",true);
      txtFechaDesde = conectorParametroLimpia("txtFechaSustitucionDesde","",true);
      txtFechaHasta = conectorParametroLimpia("txtFechaSustitucionHasta","",true);
      txtaObservaciones = conectorParametroLimpia("areatxtObservaciones","",true);
      
      //v3
      cbSGVPorDefecto = conectorParametroLimpia("cbSGVPorDefecto","",true);
      cbTerritorioPorDefecto = conectorParametroLimpia("cbTerritorioPorDefecto","",true);
      cbSociedadPorDefecto = conectorParametroLimpia("cbSociedadPorDefecto","",true);
      cbMarcaPorDefecto = conectorParametroLimpia("cbMarcaPorDefecto","",true);
      cbCanalPorDefecto = conectorParametroLimpia("cbCanalPorDefecto","",true);
      cbAccesoPorDefecto = conectorParametroLimpia("cbAccesoPorDefecto","",true);
      cbSubaccesoPorDefecto = conectorParametroLimpia("cbSubaccesoPorDefecto","",true);
      txtFechaInicioRastreo = conectorParametroLimpia("txtFechaInicioRastreo","",true);
      txtFechaFinRastreo = conectorParametroLimpia("txtFechaFinRastreo","",true);
      cbSubgerenciaVentas = conectorParametroLimpia("cbSubgerenciaVentas","",true);

		 ckIndNDG = conectorParametroLimpia("ckIndNDG","",true);
		 ckIndAdmNDG = conectorParametroLimpia("ckAdminNDG","",true);

   }

   private void asignarValoresADTO(DTOEntradaInsertarUsuarios dtoeModificar) throws Exception{
      dtoeModificar.setIdUsuario(txtUsuario);
      dtoeModificar.setClaveAcceso(txtClaveDeAcceso);
      dtoeModificar.setIndicacionClaveInicial(rbClaveInicial);
	  ArrayList perfiles = new ArrayList();

	  String perf = cbPerfil;
		  if ( !perf.equals("") )
		  {
			 StringTokenizer tokenizer = new StringTokenizer(perf, "|");
			while (tokenizer.hasMoreTokens())
			{
			 perfiles.add(tokenizer.nextToken());
			}
		  }
		  dtoeModificar.setPerfil( perfiles ); 	  

//	  dtoeModificar.setPerfil(cbPerfil);
      dtoeModificar.setPrimerApellido(txtPrimerApellido);
      dtoeModificar.setSegundoApellido(txtSegundoApellido);
      dtoeModificar.setApellidoCasada(txtApellidoCasada);
      dtoeModificar.setPrimerNombre(txtPrimerNombre);
      dtoeModificar.setSegundoNombre(txtSegundoNombre);
      dtoeModificar.setEmail(txtEmail);
      dtoeModificar.setTelefonoContacto(txtTelefono);
      dtoeModificar.setDepartamento(cbDepartamento);
      dtoeModificar.setIdentificadorPc(txtIdentificadorPC);
      dtoeModificar.setPeriodoValidezFechaDesde(txtValidezDesde);
      dtoeModificar.setPeriodoValidezFechaHasta(txtValidezHasta);
      dtoeModificar.setPais(cbPais);
      dtoeModificar.setRegion(cbRegion);
      dtoeModificar.setZona(cbZona);
      dtoeModificar.setSeccion(cbSeccion);
      dtoeModificar.setTerritorio(cbTerritorio);
      dtoeModificar.setPaisDefecto(cbPaisPorDefecto);
      dtoeModificar.setRegionPorDefecto(cbRegionPorDefecto);
      dtoeModificar.setZonaPorDefecto(cbZonaPorDefecto);
      dtoeModificar.setSeccionDefecto(cbSeccionPorDefecto);
      dtoeModificar.setSociedad(cbSociedad);
      dtoeModificar.setMarca(cbMarca);
      dtoeModificar.setCanal(cbCanal);
      dtoeModificar.setAcceso(cbAcceso);
      dtoeModificar.setSubnivelAcceso(cbSubnivelAcceso);
      dtoeModificar.setTipoUsuario(cbTipoUsuario);
      dtoeModificar.setIdioma(cbIdioma);

                  try{
         dtoeModificar.setFormatoFecha( UtilidadesSession.getFormatoFecha(this) );
                  }catch(Exception e){}

/*
      dtoeModificar.setFormatoFecha(txtFormatoFecha);
      dtoeModificar.setFormatoNumerico(txtNumeroDecimal);
      dtoeModificar.setFormatoNumericoSeparadorDecimales(txtSeparadorDecimales);
      dtoeModificar.setFormatoNumericoSeparadorMiles(txtSeparadorMiles);
*/
      dtoeModificar.setRastreoAcceso(cbTipoRastreo);

      dtoeModificar.setUsuarioSustitucion(cbUsuarioSustitucion);
      dtoeModificar.setUsuarioHabilitado(cbUsuarioHabilitado);
      dtoeModificar.setFechaSustitucionDesde(txtFechaDesde);
      dtoeModificar.setFechaSustitucionHasta(txtFechaHasta);
      dtoeModificar.setObservacionesSustitucion(txtaObservaciones);
	  dtoeModificar.setSubgerenciaVentas(cbSubgerenciaVentas);
	  dtoeModificar.setSubgerenciaVentasDefecto(cbSGVPorDefecto);
	  dtoeModificar.setTerritorioPorDefecto(cbTerritorioPorDefecto);
      dtoeModificar.setSociedadPorDefecto(cbSociedadPorDefecto);
      dtoeModificar.setMarcaPorDefecto(cbMarcaPorDefecto);
      dtoeModificar.setCanalPorDefecto(cbCanalPorDefecto);
      dtoeModificar.setAccesoPorDefecto(cbAccesoPorDefecto);
      dtoeModificar.setSubaccesoPorDefecto(cbSubaccesoPorDefecto);
      dtoeModificar.setFechaInicioRastreo(txtFechaInicioRastreo);
      dtoeModificar.setFechaFinalRastreo(txtFechaFinRastreo);

        // Si no es "", toma el primer elemento luego de pasarla x un StringTokenizer.
      String sPantallaInicio = recogeCadena(cbPantallaInicioAsociada);
      if ( !sPantallaInicio.equals("") ) {
                 StringTokenizer tokenizer = new StringTokenizer(sPantallaInicio, "|");
                 sPantallaInicio = tokenizer.nextToken();
      }
      dtoeModificar.setPantallaInicioAsociada( sPantallaInicio );            
		dtoeModificar.setIndNDG( ckIndNDG );
		dtoeModificar.setIndAdmNDG( ckIndAdmNDG );

   }

   private void obtenerCombosBusqueda(Long idioma) throws Exception{

      paramEntrada = new Vector();

      MareDTO dtoe = new MareDTO();
      dtoe.setProperty("idioma", idioma);

      paramEntrada.add(dtoe);
      paramEntrada.add(new MareBusinessID("MENCargaDatosEnPantalla"));
	  conectorBuscar = conectar("ConectorCargaDatosPantalla", paramEntrada);
      asignar("COMBO", "cbPerfil", conectorBuscar, "dtoSalida.perfiles_ROWSET");
      asignar("COMBO", "cbDepartamento", conectorBuscar, "dtoSalida.departamentos_ROWSET");
   }


	private void logStackTrace(Throwable e) {
     ByteArrayOutputStream os = new ByteArrayOutputStream();
	 PrintStream ps = new PrintStream(os);

	 e.printStackTrace(ps);
     try {
		traza("Se produjo la excepcion: " 
			+ e.getMessage() 
			+ "\n" 
			+ "stackTrace = " 
		    + os.toString());
     }
     catch (Exception ex) {
        //traza ("Error en logStackTrace: " + ex.getMessage ());
		e.printStackTrace ();
     }
	}

    private ComposerViewElementList crearParametrosEntrada() throws Exception{
        traza("metodo crearParametrosEntrada() ");
        DTOBelcorp dtoBel = new DTOBelcorp();

        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
			   
        ComposerViewElementList lista = new ComposerViewElementList();
			 
        //Carga de combo marca
        ComposerViewElement cvCbMarca = new ComposerViewElement();
        cvCbMarca.setIDBusiness("SEGConsultaMarcas");
        cvCbMarca.setDTOE(dtoBel);
			 
        //Carga de combo canales
        ComposerViewElement cvCbCanales = new ComposerViewElement();
        cvCbCanales.setIDBusiness("SEGConsultaCanales");
        cvCbCanales.setDTOE(dtoBel);
             
        //Carga de combo paises
        ComposerViewElement cvCbPaises = new ComposerViewElement();
        cvCbPaises.setIDBusiness("REPRecuperarPaises");
        cvCbPaises.setDTOE(dtoBel);
             
        //Carga de combo idiomas
        ComposerViewElement cvCbIdioma = new ComposerViewElement();
        cvCbIdioma.setIDBusiness("CMNRecuperarIdiomasSEG");
        cvCbIdioma.setDTOE(dtoBel);

        //Carga de combo perfiles
        ComposerViewElement cvCbPerfil = new ComposerViewElement();
        cvCbPerfil.setIDBusiness("MENRecuperaPerfiles");
        //cvCbPerfil.setDTOE(dtoBel);

        //Carga de combo departamento
        ComposerViewElement cvCbDepartamento = new ComposerViewElement();
        cvCbDepartamento.setIDBusiness("SEGObtenerDepartamentos");
        cvCbDepartamento.setDTOE(dtoBel);

        //Carga de combo departamento
        ComposerViewElement cvCbSociedad = new ComposerViewElement();
        cvCbSociedad.setIDBusiness("MENRecargaSociedades");
        cvCbSociedad.setDTOE(new DTOString());

        lista.addViewElement(cvCbMarca);
        lista.addViewElement(cvCbCanales);   
        lista.addViewElement(cvCbPaises);
        lista.addViewElement(cvCbIdioma);
        lista.addViewElement(cvCbPerfil);
        lista.addViewElement(cvCbDepartamento);
        lista.addViewElement(cvCbSociedad);
		
		return lista;
	}

}

