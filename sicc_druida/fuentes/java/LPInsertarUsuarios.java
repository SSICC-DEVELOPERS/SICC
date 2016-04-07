import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.men.DTOEntradaInsertarUsuarios;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
//import es.indra.druida.DruidaBase;
/* By - jalem 26/01/2004
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
*/

public class LPInsertarUsuarios extends LPSICCBase {

      //Levanto los datos de la pagina.
      String cbPerfil = null;
      String txtUsuario = null;
      String txtClaveAcceso = null;
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
      String cbPais = null;
      String cbRegion = null;
      String cbZona = null;
      String cbSeccion = null;
      String cbTerritorio = null;
      String cbPaisPorDefecto = null;
      String cbRegionPorDefecto = null;
      String cbZonaPorDefecto = null;
      String cbSeccionPorDefecto = null;
      String cbSociedad = null;
      String cbMarca = null;
      String cbCanal = null;
      String cbAcceso = null;
      String cbSubacceso = null;
      String cbTipoUsuario = null;
      String cbIdioma = null;
/*
      String txtFormatoFecha = null;
      String txtNumeroDecimal = null;
      String txtSeparadorDecimales = null;
      String txtSeparadorMiles = null;
*/      
      String cbTipoRastreo = null;
      String cbUsuarioSustitucion = null;
      String cmbUsuarioHabilitado = null;
      String txtFechaDesde = null;
      String txtFechaHasta = null;
      String txtaObservaciones = null;
      String cbPantallaInicioAsociada = null;
      
      //V3
      String cbSubgerenciaVentas = null;
      String cbSGVPorDefecto = null;
      String cbTerritorioPorDefecto = null;
      String cbSociedadPorDefecto = null;
      String cbMarcaPorDefecto = null;
      String cbCanalPorDefecto = null;
      String cbAccesoPorDefecto = null;
      String cbSubaccesoPorDefecto = null;
      String txtFechaInicioRastreo = null;
      String txtFechaFinRastreo = null;

		//Inc. 6142
      String ckIndNDG = null;
      String ckIndAdmNDG = null;

      /***************************************/

      DTOEntradaInsertarUsuarios dtoeInsertar = null;
                  DruidaConector conectorInsertarUsuarios = null;
                  Long idioma = null;
                  Long pais 	= null;

    public LPInsertarUsuarios() {super();}

    public void inicio() throws Exception {
          pagina("contenido_usuario_insertar");
    }

    public void ejecucion() throws Exception {
			setTrazaFichero();
			rastreo();
			String accion = conectorParametroLimpia("accion","",true);
			traza("accion: " + accion);

			idioma = UtilidadesSession.getIdioma( this );
			pais = UtilidadesSession.getPais( this );

			asignarAtributo("VAR","hUsuarioActual", "valor", UtilidadesSession.getIdUsuario(this) );
            asignarAtributo("VAR", "hIdioma", "valor",((idioma == null) ? "" : idioma.toString()));

          try
          {
                  if ( accion.equals("") ){

                 asignarAtributo("VAR","accion","valor","Inserta");


				String dFechaTmp = null;
				java.util.Date hoy = new java.util.Date(System.currentTimeMillis() );

				String formatoFecha = UtilidadesSession.getFormatoFecha(this);
				formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.
				 SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);
				try {
					dFechaTmp = simpledateformat.format(hoy);
					
				} catch(Exception e) {}
				
				asignarAtributo("LABELC","txtFechaCambioClave","valor",  dFechaTmp.toString());

				traza("llama prepararMantenimientoUsuarios()");
				prepararMantenimientoUsuarios();
				 //traza(this.getXML().getDocumentElement());
				traza("sale prepararMantenimientoUsuarios()");	

				  } 
           }catch (Exception ex) {
					  traza(" " + ex);
					  this.lanzarPaginaError(ex);
                      asignarAtributo("VAR", "accion", "valor", "");
                      asignarAtributo("VAR", "conectorAction", "valor", "LPInsertarUsuarios");			
                           }
                            
          try
          {
             if ( accion.equals("Inserta") ){
				 pagina("salidaGenerica");

                 dtoeInsertar = new DTOEntradaInsertarUsuarios();

				 String usuario = (String)conectorParametroSesion("DruidaUsuario");
				 String contrasenia = (String)conectorParametroSesion("DruidaPassword");
				 dtoeInsertar.setUsuario(usuario);
				 dtoeInsertar.setPassword(contrasenia);					

                 obtenerParametrosPagina();
                 asignarValoresADTO(dtoeInsertar);

  			     conectorParametroSesion("dtoeInsertar",dtoeInsertar);

				 MareBusinessID id = new MareBusinessID("MENInsertarUsuarios");
				 Vector paramEntrada = new Vector();
				 paramEntrada.addElement(dtoeInsertar);
				 paramEntrada.addElement(id);
				 
                 UtilidadesLog.debug(dtoeInsertar);
                 
				 conectorInsertarUsuarios = conectar("ConectorInsertarUsuarios", paramEntrada);
				 asignarAtributo("VAR","ejecutar","valor","reInicio()");


             }
                           }catch (Exception ex) {
                                             
                                             this.lanzarPaginaError(ex);
                           }

                           getConfiguracionMenu(); //menú secundario
          }

    private void prepararMantenimientoUsuarios() throws Exception{
        //generarHiddenFormatoFecha();
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

    private void obtenerParametrosPagina(){
          cbPerfil = conectorParametroLimpia("cbPerfil","",true);
          txtUsuario = conectorParametroLimpia("txtUsuario","",true);
          txtClaveAcceso = conectorParametroLimpia("txtClaveAcceso","",true);
          rbClaveInicial = conectorParametroLimpia("rbClaveInicial","",true);
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
          cbSociedad = conectorParametroLimpia("cbSociedad","",true);
          cbMarca = conectorParametroLimpia("cbMarca","",true);
          cbCanal = conectorParametroLimpia("cbCanal","",true);
          cbAcceso = conectorParametroLimpia("cbAcceso","",true);
          cbSubacceso = conectorParametroLimpia("cbSubacceso","",true);
          cbPais = conectorParametroLimpia("cbPais","",true);
          cbSubgerenciaVentas = conectorParametroLimpia("cbSubgerenciaVentas","",true); //New
          cbRegion = conectorParametroLimpia("cbRegion","",true);
          cbZona = conectorParametroLimpia("cbZona","",true);
          cbSeccion = conectorParametroLimpia("cbSeccion","",true);
          cbTerritorio = conectorParametroLimpia("cbTerritorio","",true);
          cbPaisPorDefecto = conectorParametroLimpia("cbPaisPorDefecto","",true);
          cbSGVPorDefecto = conectorParametroLimpia("cbSGVPorDefecto","",true); //New
          cbRegionPorDefecto = conectorParametroLimpia("cbRegionPorDefecto","",true);
          cbZonaPorDefecto = conectorParametroLimpia("cbZonaPorDefecto","",true);
          cbSeccionPorDefecto = conectorParametroLimpia("cbSeccionPorDefecto","",true);
          cbTerritorioPorDefecto = conectorParametroLimpia("cbTerritorioPorDefecto","",true); //New
          cbSociedadPorDefecto = conectorParametroLimpia("cbSociedadPorDefecto","",true); //New          
          cbMarcaPorDefecto = conectorParametroLimpia("cbMarcaPorDefecto","",true); //New
          cbCanalPorDefecto = conectorParametroLimpia("cbCanalPorDefecto","",true); //New          
          cbAccesoPorDefecto = conectorParametroLimpia("cbAccesoPorDefecto","",true); //New
          cbSubaccesoPorDefecto = conectorParametroLimpia("cbSubaccesoPorDefecto","",true); //New
          cbTipoUsuario = conectorParametroLimpia("cbTipoUsuario","",true);
          cbIdioma = conectorParametroLimpia("cbIdioma","",true);
          cbTipoRastreo = conectorParametroLimpia("cbTipoRastreo","",true);
          txtFechaInicioRastreo = conectorParametroLimpia("txtFechaInicioRastreo","",true); //New
          txtFechaFinRastreo = conectorParametroLimpia("txtFechaFinRastreo","",true); //New      
          
          cbPantallaInicioAsociada = conectorParametroLimpia("cbPantallaInicioAsociada","",true);
          
          cbUsuarioSustitucion = conectorParametroLimpia("cbUsuarioSustitucion","",true);
          txtFechaDesde = conectorParametroLimpia("txtFechaSustitucionDesde","",true);
          txtFechaHasta = conectorParametroLimpia("txtFechaSustitucionHasta","",true);
          txtaObservaciones = conectorParametroLimpia("areatxtObservaciones","",true);
          cmbUsuarioHabilitado = conectorParametroLimpia("rbUsuarioHabilitado","",true);

          ckIndNDG = conectorParametroLimpia("ckIndNDG","",true);
          ckIndAdmNDG = conectorParametroLimpia("ckAdminNDG","",true);
		
    }

    private void asignarValoresADTO(DTOEntradaInsertarUsuarios dtoe) throws Exception{
		  ArrayList perfiles = new ArrayList();
  		  String perf = recogeCadena(cbPerfil);
              if ( !perf.equals("") )
              {
				 StringTokenizer tokenizer = new StringTokenizer(perf, "|");
				while (tokenizer.hasMoreTokens())
				{
                 perfiles.add(tokenizer.nextToken());
				}


              }
              dtoe.setPerfil( perfiles ); 
          
		  //dtoe.setPerfil( recogeCadena(cbPerfil) );
          dtoe.setIdUsuario( recogeCadena(txtUsuario) );                            
          dtoe.setClaveAcceso( recogeCadena(txtClaveAcceso) );
          dtoe.setIndicacionClaveInicial( recogeCadena(rbClaveInicial) );
          dtoe.setPrimerApellido( recogeCadena(txtPrimerApellido) );
          dtoe.setSegundoApellido( recogeCadena(txtSegundoApellido) );
          dtoe.setApellidoCasada( recogeCadena(txtApellidoCasada) );
          dtoe.setPrimerNombre( recogeCadena(txtPrimerNombre) );
          dtoe.setSegundoNombre( recogeCadena(txtSegundoNombre) );
          dtoe.setEmail( recogeCadena(txtEmail) );
          dtoe.setTelefonoContacto( recogeCadena(txtTelefono) );
          dtoe.setDepartamento( recogeCadena(cbDepartamento) );
          dtoe.setIdentificadorPc( recogeCadena(txtIdentificadorPC) );
          dtoe.setPeriodoValidezFechaDesde( recogeCadena(txtValidezDesde) );
          dtoe.setPeriodoValidezFechaHasta( recogeCadena(txtValidezHasta) );
          dtoe.setPais( recogeCadena(cbPais) );
          dtoe.setRegion( recogeCadena(cbRegion) );
          dtoe.setZona( recogeCadena(cbZona) );
          dtoe.setSeccion( recogeCadena(cbSeccion) );
          dtoe.setTerritorio( recogeCadena(cbTerritorio) );
          dtoe.setPaisDefecto( recogeCadena(cbPaisPorDefecto) );
          dtoe.setRegionPorDefecto( recogeCadena(cbRegionPorDefecto) );
          dtoe.setZonaPorDefecto( recogeCadena(cbZonaPorDefecto) );
          dtoe.setSeccionDefecto( recogeCadena(cbSeccionPorDefecto) );
          dtoe.setSociedad( recogeCadena(cbSociedad) );
          dtoe.setMarca( recogeCadena(cbMarca) );
          dtoe.setCanal( recogeCadena(cbCanal) );
          dtoe.setAcceso( recogeCadena(cbAcceso) );
          dtoe.setSubnivelAcceso( recogeCadena(cbSubacceso) );
          dtoe.setTipoUsuario( recogeCadena(cbTipoUsuario) );
          dtoe.setIdioma( recogeCadena(cbIdioma) );

         try{
          dtoe.setFormatoFecha( UtilidadesSession.getFormatoFecha(this) );
         }catch(Exception e){}

          dtoe.setRastreoAcceso( recogeCadena(cbTipoRastreo) );                             
          dtoe.setUsuarioSustitucion( recogeCadena(cbUsuarioSustitucion) );
          dtoe.setUsuarioHabilitado( recogeCadena(cmbUsuarioHabilitado) );
          dtoe.setFechaSustitucionDesde( recogeCadena(txtFechaDesde) );
          dtoe.setFechaSustitucionHasta( recogeCadena(txtFechaHasta) );
          dtoe.setObservacionesSustitucion( recogeCadena(txtaObservaciones) );

          // Si no es "", toma el primer elemento luego de pasarla x un StringTokenizer.
          String sPantallaInicio = recogeCadena(cbPantallaInicioAsociada);
              if ( !sPantallaInicio.equals("") )
              {
                 StringTokenizer tokenizer = new StringTokenizer(sPantallaInicio, "|");
                 sPantallaInicio = tokenizer.nextToken();
              }
              dtoe.setPantallaInicioAsociada( sPantallaInicio );            
			   dtoe.setSubgerenciaVentas( cbSubgerenciaVentas );
			   dtoe.setSubgerenciaVentasDefecto( cbSGVPorDefecto );
			   dtoe.setTerritorioPorDefecto( cbTerritorioPorDefecto );
			   dtoe.setSociedadPorDefecto( cbSociedadPorDefecto );
			   dtoe.setMarcaPorDefecto( cbMarcaPorDefecto );
			   dtoe.setCanalPorDefecto( cbCanalPorDefecto );
			   dtoe.setAccesoPorDefecto( cbAccesoPorDefecto );
			   dtoe.setSubaccesoPorDefecto( cbSubaccesoPorDefecto );
			   dtoe.setFechaInicioRastreo( txtFechaInicioRastreo );
			   dtoe.setFechaFinalRastreo( txtFechaFinRastreo );

			   dtoe.setIndNDG( ckIndNDG );
			   dtoe.setIndAdmNDG( ckIndAdmNDG );
	 }


/*    private void asignarResultadoConsulta() throws Exception{   
          asignarAtributo("CTEXTO","txtUsuario", "valor", txtUsuario);
          asignarAtributo("CTEXTO","txtClaveAcceso", "valor", txtClaveAcceso);
          asignarAtributo("CTEXTO","txtConfirmarClaveAcceso", "valor", txtClaveAcceso);          
          asignarAtributo("VAR","hIndicacionClaveInicial", "valor", rbClaveInicial);
          asignarAtributo("VAR","hPerfil", "valor", cbPerfil);
          asignarAtributo("CTEXTO","txtPrimerApellido", "valor", txtPrimerApellido);
          asignarAtributo("CTEXTO","txtSegundoApellido", "valor", txtSegundoApellido);
          asignarAtributo("CTEXTO","txtApellidoCasada", "valor", txtApellidoCasada);
          asignarAtributo("CTEXTO","txtPrimerNombre", "valor", txtPrimerNombre);
          asignarAtributo("CTEXTO","txtSegundoNombre", "valor", txtSegundoNombre);
          asignarAtributo("CTEXTO","txtEmail", "valor", txtEmail);
          asignarAtributo("CTEXTO","txtTelefono", "valor", txtTelefono);
          asignarAtributo("VAR","hDepartamento", "valor", cbDepartamento);
          asignarAtributo("CTEXTO","txtIdentificadorPC", "valor", txtIdentificadorPC);
          asignarAtributo("CTEXTO","txtValidezDesde", "valor", txtValidezDesde);
          asignarAtributo("CTEXTO","txtValidezHasta", "valor", txtValidezHasta);
          asignarAtributo("VAR","hPais", "valor", cbPais);
          asignarAtributo("VAR","hRegion", "valor", cbRegion);
          asignarAtributo("VAR","hZona", "valor", cbZona);
          asignarAtributo("VAR","hSeccion", "valor", cbSeccion);
          asignarAtributo("VAR","hTerritorio", "valor", cbTerritorio);
          asignarAtributo("VAR","hPaisPorDefecto", "valor", cbPaisPorDefecto);
          asignarAtributo("VAR","hRegionPorDefecto", "valor", cbRegionPorDefecto);
          asignarAtributo("VAR","hZonaPorDefecto", "valor", cbZonaPorDefecto);
          asignarAtributo("VAR","hSeccionPorDefecto", "valor", cbSeccionPorDefecto);
          asignarAtributo("VAR","hSociedad", "valor", cbSociedad);
          asignarAtributo("VAR","hMarca", "valor", cbMarca);
          asignarAtributo("VAR","hCanal", "valor", cbCanal);
          asignarAtributo("VAR","hAcceso", "valor", cbAcceso);
          asignarAtributo("VAR","hSubnivelAcceso", "valor", cbSubacceso);
          asignarAtributo("VAR","hTipoUsuario", "valor", cbTipoUsuario);
          asignarAtributo("VAR","hIdioma", "valor", cbIdioma);
          asignarAtributo("VAR","hTipoRastreo", "valor", cbTipoRastreo);
          asignarAtributo("VAR","hFuncionDirecta", "valor", cbPantallaInicioAsociada);
          asignarAtributo("VAR","hUsuarioSustitucion", "valor", cbUsuarioSustitucion);
          asignarAtributo("VAR","hUsuarioHabilitado", "valor", cmbUsuarioHabilitado);
          asignarAtributo("CTEXTO","txtFechaSustitucionDesde", "valor", txtFechaDesde);
          asignarAtributo("CTEXTO","txtFechaSustitucionHasta", "valor", txtFechaHasta);
          asignarAtributo("AREATEXTO","areatxtObservaciones", "valor", txtaObservaciones);
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

          }*/

          private String recogeCadena(String cadena){
                if ( (cadena == null) || (cadena.length()==0) )
                      return "";
                return cadena;
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

