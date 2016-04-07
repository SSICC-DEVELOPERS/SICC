//import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.dtos.car.DTOEjecutivo;
import es.indra.sicc.dtos.car.DTOAsignaciones;
import es.indra.sicc.dtos.car.DTOAsignacionesEjecutivo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class LPEjecutivosCuenta extends LPSICCBase {
  private String mAccion = null;
  private String mCasoDeUso = null;
  private String mPais = null;     
  private String mIdioma = null;
  private DruidaConector resp = null;

  private Long marcaDefecto = null;
  private Long canalDefecto = null;
  private Long sgvDefecto = null;
  private Integer regionDefecto = null;  
  private Long zonaDefecto = null;
  
  private Long pestania = null;
  private String codigoPagina = null;
  private String strEjecutivo = null;

  public LPEjecutivosCuenta() { super(); }

  public void inicio() throws Exception { }
  
	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       
	 * @version     
	 * @autor
	 * Fecha:		19/07/2005
	 * @modified	mmaidana
	 * Se modifico el metodo ejecucion por Inc. BELC300014826
	 */
	public void ejecucion() throws Exception {
        setTrazaFichero();    
   traza("******* Entrada: LPEjecutivosCuenta.ejecucion() ");

        marcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
        canalDefecto = UtilidadesSession.getCanalPorDefecto(this);
        sgvDefecto = UtilidadesSession.getSGVPorDefecto(this);
        regionDefecto = UtilidadesSession.getRegion(this);
        zonaDefecto = UtilidadesSession.getZonaPorDefecto(this);
        
        mPais = UtilidadesSession.getPais(this).toString();
        mIdioma = UtilidadesSession.getIdioma(this).toString();
        mAccion = conectorParametro("accion");        

        //IDPrincipal = conectorParametroLimpia("cbEjecutivoCuenta", "", true);

        traza("************** Marca x def_" + marcaDefecto);        
        mCasoDeUso = conectorParametro("casoDeUso");
        traza("************** Caso de Uso_" + mCasoDeUso);
        traza("************** Accion_" + mAccion);

        codigoPagina = obtenerCodigoPagina();

        try {

            if (mAccion.equals("inserta"))  {
            
                String asignaciones = "";
                String oidEjecutivo = "";
                String idprincipal = "";
                String oidJerarquia = "";
                if (mCasoDeUso != null)
                    if (mCasoDeUso.equals("consultarInsert") || mCasoDeUso.equals("modificarInsert") || mCasoDeUso.equals("eliminarInsert")) {
                        asignaciones = conectorParametro("asignaciones");
                        oidEjecutivo = conectorParametro("oidEjecutivo");
                        idprincipal = conectorParametro("IDPrincipal");
                        oidJerarquia = conectorParametro("oidJerarquia");                        
                        traza("Estas son als asignaciones: " + asignaciones);
                        traza("Este es el oid ejecutivo: " + oidEjecutivo);
                    }

                traza("******* LOAD PAG contenido_ejecutivos_cuenta_insertar2");
					 pagina("contenido_ejecutivos_cuenta_insertar2");

                asignarAtributo("VAR","hPais","valor",mPais);

                if (mCasoDeUso != null)
                    if (mCasoDeUso.equals("consultarInsert") || mCasoDeUso.equals("modificarInsert") || mCasoDeUso.equals("eliminarInsert")){
                        asignarAtributo("VAR","asignaciones","valor",asignaciones);
                        asignarAtributo("VAR","oidEjecutivo","valor",oidEjecutivo);
                        asignarAtributo("VAR","IDPrincipal","valor",idprincipal);
                        asignarAtributo("VAR","oidJerarquia","valor",oidJerarquia);
                    }

                pestania = new Long(2);
                cargarCampos();
            }

            if (mAccion.equals("asignaEjecutivo"))  {

                String asignaciones = "";
                String oidEjecutivo = "";
                String idprincipal = "";
                String oidJerarquia = "";
                if (mCasoDeUso.equals("consultarInsert") || mCasoDeUso.equals("modificarInsert") || mCasoDeUso.equals("eliminarInsert")) {
                    asignaciones = conectorParametro("asignaciones");
                    oidEjecutivo = conectorParametro("oidEjecutivo");
                    idprincipal = conectorParametro("IDPrincipal");
                    oidJerarquia = conectorParametro("oidJerarquia");                        
                }
					
					 traza("******* LOAD PAG contenido_ejecutivos_cuenta_insertar");
                pagina("contenido_ejecutivos_cuenta_insertar");
                asignarAtributo("VAR","hPais","valor",mPais); 

                String foco = conectorParametroLimpia("focoUltimo", "", true);                
                traza("!!!!!!!! foco " + foco);
                asignarAtributo("VAR","focoUltimo","valor",foco);

                if (mCasoDeUso.equals("consultarInsert") || mCasoDeUso.equals("modificarInsert") || mCasoDeUso.equals("eliminarInsert")){
                    asignarAtributo("VAR","asignaciones","valor",asignaciones);
                    asignarAtributo("VAR","oidEjecutivo","valor",oidEjecutivo);
                    asignarAtributo("VAR","IDPrincipal","valor",idprincipal);
                    asignarAtributo("VAR","oidJerarquia","valor",oidJerarquia);
                }

                pestania = new Long(1);
                cargarCampos();

            }
            
            if (mAccion.equals("modifica"))  {
                /*Selecciona como pagina a mostrar "BuscarEjecutivoCuenta" 
                Llama al metodo cargarCamposCriterio() 
                habilita el boton modificar 
                muestra la pantalla */
               traza("******* LOAD PAG contenido_ejecutivos_cuenta_modificar");
					 pagina("contenido_ejecutivos_cuenta_modificar");

                Long marcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
                Long canalDefecto = UtilidadesSession.getCanalPorDefecto(this);

                String sMarDefecto = marcaDefecto.toString();
                String sCanDefecto = canalDefecto.toString();

                traza("************** marcaDefecto " + sMarDefecto);
                traza("************** canalDefecto " + sCanDefecto);

                asignarAtributo("VAR","marcaDefecto","valor", sMarDefecto);
                asignarAtributo("VAR","canalDefecto","valor", sCanDefecto);               
                cargarCamposCriterio();
            }
        
            if (mAccion.equals("elimina"))  {
                /*Selecciona como pagina a mostrar "BuscarEjecutivoCuenta" 
                Llama al metodo cargarCamposCriterio() 
                habilita el boton eliminar y detalle 
                muestra la pantalla */
					
					traza("******* LOAD PAG contenido_ejecutivos_cuenta_modificar");
                pagina("contenido_ejecutivos_cuenta_modificar");
                Long marcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
                Long canalDefecto = UtilidadesSession.getCanalPorDefecto(this);

                String sMarDefecto = marcaDefecto.toString();
                String sCanDefecto = canalDefecto.toString();

                traza("************** marcaDefecto " + sMarDefecto);
                traza("************** canalDefecto " + sCanDefecto);

                asignarAtributo("VAR","marcaDefecto","valor", sMarDefecto);
                asignarAtributo("VAR","canalDefecto","valor", sCanDefecto);
                
                cargarCamposCriterio();                
            }

            if (mAccion.equals("consulta"))  {
                /*Selecciona como pagina a mostrar "BuscarEjecutivoCuenta" 
                Llama al metodo cargarCamposCriterio() 
                habilita el boton detalle 
					 muestra la pantalla */
                
					 traza("******* LOAD PAG contenido_ejecutivos_cuenta_modificar");
					 pagina("contenido_ejecutivos_cuenta_modificar");

                Long marcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
                Long canalDefecto = UtilidadesSession.getCanalPorDefecto(this);

                String sMarDefecto = marcaDefecto.toString();
                String sCanDefecto = canalDefecto.toString();

                traza("************** marcaDefecto " + sMarDefecto);
                traza("************** canalDefecto " + sCanDefecto);

                asignarAtributo("VAR","marcaDefecto","valor", sMarDefecto);
                asignarAtributo("VAR","canalDefecto","valor", sCanDefecto);   
                cargarCamposCriterio();
            }

            if (mAccion.equals("guardarEjecutivo"))  {
                pagina("salidaGenerica");
                asignarAtributo("VAR","ejecutar","valor","guardoCorrectamente()");
                asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");
                pestania = new Long(1);                
                guardarEjecutivo();
//                cargarCampos();
                /*Selecciona como pagina a mostrar "InsertaEjecutivoCuenta" 
                Llama al metodo guardarEjecutivo() 
                Llama al metodo cargarCampos() 
                muestra la pantalla */            
            }

            if (mAccion.equals("guardarAsignaciones"))  {
                pagina("salidaGenerica");
                asignarAtributo("VAR","ejecutar","valor","guardoCorrectamente()");
                asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");
                guardarAsignaciones();
                //pagina("contenido_ejecutivos_cuenta_insertar");
                //cargarCampos();
                /*Selecciona como pagina a mostrar "InsertaEjecutivoCuenta" 
                Llama al metodo guardarAsignaciones() 
                Llama al metodo cargarCampos() 
                muestra la pantalla             */
            } 
        
            if (mAccion.equals("modificaEjecutivo"))  {
                strEjecutivo = conectorParametro("oidEjecutivo")==null?"":conectorParametro("oidEjecutivo");
						
					traza("******* LOAD PAG contenido_ejecutivos_cuenta_insertar");
                pagina("contenido_ejecutivos_cuenta_insertar");

                pestania = new Long(1);
                cargarEjecutivo();
                cargarCampos();
                llenarCamposEjecutivo();
                /*Selecciona como pagina a mostrar "InsertaEjecutivoCuenta" 
                Llama al metodo cargarEjecutivo() y obtiene el DruidaConector de respuesta 
                Si se genera una excepcion se muestra un mensaje de error al usuario y se cierra 
                la ventana modal. 
                Llama al metodo cargarCampos() 
                Llenar pantalla Ejecutivo 
                Deshabilita todos los campos "Usuario" de la pestaña "EjecutivosDefinicion" y "EjecutivosCuenta" de la pestaña "EjecutivosUnidadesAdministrativas" 
                Habilita el boton volver y guardar. 
                muestra la pantalla */
            }
        
            if (mAccion.equals("consultaEjecutivo"))  {
            
                strEjecutivo = conectorParametro("oidEjecutivo")==null?"":conectorParametro("oidEjecutivo");

                //pagina("contenido_ejecutivos_cuenta_insertar2");
                
					 traza("******* LOAD PAG contenido_ejecutivos_cuenta_insertar");
                pagina("contenido_ejecutivos_cuenta_insertar");

                pestania = new Long(1);
                cargarEjecutivo();
                cargarCampos();
                llenarCamposEjecutivo();

                /*Selecciona como pagina a mostrar "InsertaEjecutivoCuenta" 
                Llama al metodo cargarEjecutivo() y obtiene el DruidaConector de respuesta 
                Si se genera una excepcion se muestra un mensaje de error al usuario y se cierra la ventana modal. 
                Llama al metodo cargarCampos() 
                Llenar pantalla Ejecutivo llamando el metodo llenarCamposejecutivo() 
                
                Deshabilita todos los campos de la pantalla 
                Habilita el boton volver 
                muestra la pantalla */            
            }

            //Se asigna el oid del pais de la sesion del usuario al campo tipo VAR "pais" de la pantalla.
            traza("AL MENU SECUNDARIO: " + mCasoDeUso);
            if (!mAccion.equals("guardarEjecutivo") && !mAccion.equals("guardarAsignaciones"))  {
                asignarAtributoPagina("cod",codigoPagina);
                asignarAtributo("VAR","accion","valor",mAccion);
                asignarAtributo("VAR","casoDeUso","valor",mCasoDeUso);       
                asignarAtributo("VAR","hPais","valor",mPais);
                asignarAtributo("VAR","hIdioma","valor",mIdioma);

            }            
            getConfiguracionMenu("LPEjecutivosCuenta",mCasoDeUso);
            
        }
        catch ( Exception e )  {
          traza("pincho la lp principal");
          ByteArrayOutputStream pila = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(pila);
          e.printStackTrace(out);
          traza("EL STACK ES COMO SIGUE : " +  pila.toString());
              e.printStackTrace(); 
              e.getMessage();
              lanzarPaginaError(e);
        }
	
	 traza("******* Salida: LPEjecutivosCuenta.ejecucion() ");
    }

    private void cargarCampos() throws Exception {
	 traza("******* Entrada: LPEjecutivosCuenta.cargarCampos() ");

        DTOBelcorp dto = new  DTOBelcorp();
        dto.setOidPais(new Long(mPais));
        dto.setOidIdioma(new Long(mIdioma));
        ComposerViewElementList cv = crearParametrosEntrada(dto);
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        traza("******* Pestania value_" + pestania.intValue());
		  if (pestania.intValue() == 1)  {
        
            asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");        //(Pestaña EjecutivosUnidadesAdministrativas)
				traza("******* Cargado Combo_cbMarca");

            asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");        //(Pestaña EjecutivosUnidadesAdministrativas) 
				traza("******* Cargado Combo_cbCanal");
				
				/*
				  comento x inc BELC300014826
				  asignar("COMBO", "cbEjecutivoCuenta", resultados, "CARObtenerEjecutivos");        //(Pestaña EjecutivosUnidadesAdministrativas) 
            
				  agrega x inc BELC300014826
				  asignar("COMBO", "cbEjecutivoCuenta", resultados, "MENObtenerUsuarios"); 
				*/

				/**********/
					if(mCasoDeUso.equals("consultarInsert") || mCasoDeUso.equals("modificarInsert")|| mCasoDeUso.equals("insertar") || mCasoDeUso.equals("eliminarInsert")){
							traza("******* Se obtiene Ejecutivos de Cuenta");
							asignar("COMBO", "cbEjecutivoCuenta", resultados, "CARObtenerEjecutivos");        //(Pestaña EjecutivosUnidadesAdministrativas)			
							traza("******* cbEjecutivoCuenta <--- 'Ejecutivos de Cuenta' ");
					}else{
							 
							traza("******* Se obtiene Usuarios (MEN) ");
							asignar("COMBO", "cbEjecutivoCuenta", resultados, "MENObtenerUsuarios"); 			
							traza("******* cbEjecutivoCuenta <--- 'Usuarios (MEN)'  ");
					}
				/**********/				
				
				asignar("COMBO", "cbNivelRiesgo", resultados, "CARNivelesRiesgo");        //(Pestaña EjecutivosUnidadesAdministrativas)
				traza("******* Cargado Combo_cbNivelRiesgo");

            asignarAtributo("VAR","marcaDefecto","valor", marcaDefecto.toString());
            asignarAtributo("VAR","canalDefecto","valor", canalDefecto.toString());
            asignarAtributo("VAR","sgvDefecto","valor", sgvDefecto.toString());
            asignarAtributo("VAR","regionDefecto","valor", regionDefecto.toString());
            asignarAtributo("VAR","zonaDefecto","valor", zonaDefecto.toString());
				
	         traza("******* Marca x def_" + marcaDefecto.toString());
	 		   traza("******* Canal x def_" + canalDefecto.toString());
				traza("******* SubGe x def_" + sgvDefecto.toString());
				traza("******* Regio x def_" + regionDefecto.toString());
				traza("******* Zona  x def_" + zonaDefecto.toString());


            if ((marcaDefecto != null) || (canalDefecto != null)){
                asignar("COMBO", "cbSubgerenciaVentas", resultados, "ZONObtenerSubgerenciasVentas");        //(Pestaña EjecutivosUnidadesAdministrativas)
					 traza("******* Cargado Combo_cbSubgerenciaVentas");

					 asignar("COMBO", "cbRegion", resultados, "ZONObtenerRegiones");        //(Pestaña EjecutivosUnidadesAdministrativas) 
                traza("******* Cargado Combo_cbRegion");

					 //@ssaavedr, al no ser oblig. la region la zona debera estar vacia (inc.: BELC300024045)   asignar("COMBO", "cbZona", resultados, "ZONObtenerZonas");        //(Pestaña EjecutivosUnidadesAdministrativas) 					 
                //traza("******* Cargado Combo_cbZona");

					/* 
					 if(true){
                    asignar("COMBO", "cbRegion", resultados, "ZONObtenerRegiones");        //(Pestaña EjecutivosUnidadesAdministrativas) 
                    if(true)
                        asignar("COMBO", "cbZona", resultados, "ZONObtenerZonas");        //(Pestaña EjecutivosUnidadesAdministrativas) 
                }
					 */
            }

        }else{
           //comento por inc 23771
			  // asignar("COMBO", "cbEjecutivoCuenta", resultados, "CARObtenerEjecutivos");        //(Pestaña EjecutivosUnidadesAdministrativas) 

			  //agrego por inc 23771 ,cargo los usuarios(MEN) 		
			  
			  if(mCasoDeUso.equals("modificarInsert")){

				  if(mAccion.equals("inserta")){
						asignar("COMBO", "cbEjecutivoCuenta", resultados, "CARObtenerEjecutivos");        //(Pestaña EjecutivosUnidadesAdministrativas)			
						traza("******* cbEjecutivoCuenta <--- 'Ejecutivos de Cuenta' ");
				  }
			  
			  }else{

           asignar("COMBO", "cbEjecutivoCuenta", resultados, "MENObtenerUsuarios");//(Pestaña EjecutivosDefinicion)
			  traza("******* cbEjecutivoCuenta <---'Usuarios (MEN)'");
			  }

			  asignar("COMBO", "cbJerarquia", resultados, "CARObtenerJerarquias");        //(Pestaña EjecutivosDefinicion)
			  traza("******* Cargado cbJerarquia");
			 
        }
        
			traza("******* Salida: LPEjecutivosCuenta.cargarCampos() ");

        // Si se recibe una excepcion se muestra la pantalla correspondiente con el 
        // mensaje de error recibido en la excepcion. 
    }


    private void cargarCamposCriterio() throws Exception {
	traza("******* Entrada: LPEjecutivosCuenta.cargarCamposCriterio() ");

        DTOBelcorp dto = new  DTOBelcorp();
        dto.setOidPais(new Long(mPais));
        dto.setOidIdioma(new Long(mIdioma));

		ComposerViewElementList cv = crearParametrosEntradaBase(dto);
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
    
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");        //(Pestaña EjecutivosUnidadesAdministrativas) 
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");        //(Pestaña EjecutivosUnidadesAdministrativas) 
		asignar("COMBO", "cbNivelRiesgo", resultados, "CARNivelesRiesgo");        //(Pestaña EjecutivosUnidadesAdministrativas) 

		asignar("COMBO", "cbJerarquia", resultados, "CARObtenerJerarquias");        //(Pestaña EjecutivosDefinicion)
			
			//comenta x inc BELC300014826
         //asignar("COMBO", "cbEjecutivoCuenta", resultados, "CARObtenerEjecutivos");        //(Pestaña EjecutivosUnidadesAdministrativas) 
		  
			//agrega x inc BELC300014826
		   asignar("COMBO", "cbEjecutivoCuenta", resultados, "MENObtenerUsuarios");
        
	traza("******* Salida: LPEjecutivosCuenta.cargarCamposCriterio() ");
    }


    private void guardarEjecutivo() throws Exception {
	 traza("******* Entrada: LPEjecutivosCuenta.guardarEjecutivo() ");
        /*Creo un DTOEjecutivo y le asigna el IDPrincipal recibido y el oid de la jerarquia 
         * seleccionada. 
        Si el parametro "oidEjecutivo" es diferente de "" (vacio) se le asigna al atributo oidEjecutivo 
        el valor correspondiente. */
        
        DTOEjecutivo dtoEjecutivo = new DTOEjecutivo();
        
        String strIDPrincipal = conectorParametro("IDPrincipal")==null?"":conectorParametro("IDPrincipal");
        String strOidJerarquia = conectorParametro("oidJerarquia")==null?"":conectorParametro("oidJerarquia");
        String strOidEjecutivo = conectorParametro("oidEjecutivo")==null?"":conectorParametro("oidEjecutivo");

        if (strOidEjecutivo != null)  {
            dtoEjecutivo.setOidEjecutivo(new Long(strOidEjecutivo));                
        }

        dtoEjecutivo.setIDPrincipal(new Long(strIDPrincipal));
        dtoEjecutivo.setJerarquia(new Long(strOidJerarquia));
        dtoEjecutivo.setOidPais(new Long(mPais));
        dtoEjecutivo.setOidIdioma(new Long(mIdioma));
        dtoEjecutivo.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoEjecutivo.setPrograma(UtilidadesSession.getFuncion(this));
        
        MareBusinessID idBusiness = new MareBusinessID("CAREjecutivoGuardar");

        traza("******* Este es el DTO que se armo: " + dtoEjecutivo);
        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoEjecutivo);
        paramEntrad.addElement(idBusiness);

        traza("******* Antes del conector");
        DruidaConector  conector = conectar("CARGuardarEjecutivo", paramEntrad);
        traza("******* Despues del conector");

//        Si se recibe una excepcion se muestra un mensaje de error al usuario,sino se muestra la 
//        pantalla "InsertaEjecutivoCuenta".        
    traza("******* Salida: LPEjecutivosCuenta.guardarEjecutivo() ");
    }

    private void guardarAsignaciones() throws Exception {
	 traza("******* Entrada: LPEjecutivosCuenta.guardarAsignaciones() ");
        /*Creo un DTOAsignaciones, y para cada fila recibida desde la pantalla se crea un DTOAsignacionesEjecutivo, 
        con los datos recibidos. 
        Para cada fila se recibe desde la pantalla y se asigna de la siguiente manera: 

        oidAsignacion -> dto.oidAsignacion 
        oidEjecutivo -> dto.oidEjecutivo 
        oidSubgerencia -> dto.oidSgv 
        oidRegion -> dto.oidRegion 
        oidZona -> dto.oidZona 
        oidNivelRiesgo -> dto.oidNivelRiego 
        (Para aquello valores recibidos que sean igual a "" (vacio) 
        al campo correspondiente del DTO se le debe asignar NULL) */

        String strListado = conectorParametro("hListado")==null?"":conectorParametro("hListado");
        traza("Este es el listado que recibo de la pagina:" + strListado);
        String[] arrAsignacion = construirLineas(strListado,"#");
        traza("Este son las lineas de la pagina: " + arrAsignacion.toString());
        for (int i=0 ; i<arrAsignacion.length; i++)  {
            traza("Linea uno: " + arrAsignacion[i]);
        }
        

        DTOAsignaciones dtoAsignaciones = obtenerAsiganaciones(arrAsignacion);
        traza("Ya cree el dtoAsignaciones...");

        MareBusinessID idBusiness = new MareBusinessID("CARAsignaEjecutivoGuardar");

        traza("Creo el idBusiness...");
        dtoAsignaciones.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoAsignaciones.setPrograma(UtilidadesSession.getFuncion(this));
            
        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoAsignaciones);
        paramEntrad.addElement(idBusiness);

        traza("Ya se seteo el vector...");
        DruidaConector  conector = conectar("CARGuardarAsignaEjecutivo", paramEntrad);
        traza("Se invoco al conector....");

//        Si se recibe una excepcion se muestra un mensaje de error al usuario,sino se muestra la pantalla "InsertaEjecutivoCuenta".
		traza("******* Salida: LPEjecutivosCuenta.guardarAsignaciones() ");
    }


    private void cargarEjecutivo() throws Exception {
		traza("******* Entrada: LPEjecutivosCuenta.cargarEjecutivo() ");
        /*Creo un DTOOID y le asigna el oidEjecutivo recibido desde la pantalla. */
        DTOOID dtoOid = new DTOOID();

        traza("***************** Ejecutivo de cuenta_" + strEjecutivo);
        dtoOid.setOid(new Long(strEjecutivo));
        MareBusinessID idBusiness = new MareBusinessID("CAREjecutivoConsulta");

        dtoOid.setOidIdioma(new Long(mIdioma));

        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoOid);
        paramEntrad.addElement(idBusiness);

        
        this.resp = conectar("CARConsultaEjecutivo", paramEntrad);
        traza("***************** Llamada conector. Ok");
	
	   traza("******* Salida: LPEjecutivosCuenta.cargarEjecutivo() ");
    }

    private void llenarCamposEjecutivo() throws Exception {
		traza("******* Entrada: LPEjecutivosCuenta.llenarCamposEjecutivo() ");
      
		 DTOEjecutivo dtoEjecutivo = (DTOEjecutivo) resp.objeto("dtoSalida");
        /*Toma todos los datos correspondiente del conector en "resp" y llena los 
         * campos de la pantalla de la siguiente manera: */

        Long ejecutivo = dtoEjecutivo.getOidEjecutivo();
        Long jerarquia = dtoEjecutivo.getJerarquia();
        Long iDPrincipal = dtoEjecutivo.getIDPrincipal();
        /*
        Pais de la session -> campo oculto Pais 
        dto.oidEjecutivo -> oidEjecutivo 
        dto.oidJerarquia -> Jerarquia 
        dto.IDPrincipal - > Usuarios  */
       
		  traza("******* pais_"+mPais.toString());
		  traza("******* ejecutivo_"+ejecutivo.toString());
		  traza("******* jerarquia_"+jerarquia.toString());
		  traza("******* iDPrincipal_"+iDPrincipal.toString());		 

        asignarAtributo("VAR","hPais","valor",mPais.toString());
        asignarAtributo("VAR","oidEjecutivo","valor",ejecutivo.toString());
        asignarAtributo("VAR","oidJerarquia","valor",jerarquia.toString());
        asignarAtributo("VAR","IDPrincipal","valor",iDPrincipal.toString());

        traza("********* Asignaciones_" + dtoEjecutivo.getAsignaciones());

        String strAsignaciones = strObtenerAsignaciones(dtoEjecutivo.getAsignaciones(),ejecutivo);

        traza("********* String de asignaciones_" + strAsignaciones);
        asignarAtributo("VAR","asignaciones","valor",strAsignaciones);
        /*
        En la pestaña EjecutivosUnidadesAdministrativas solo se debe llenar con los datos 
        recibido la TablaAsociaciones. 
        Para esto se hace un asignar de los datos recibidos en el dto.Asignaciones a la 
        ListaEditables "TablaAsociaciones". 
         */
		traza("******* Salida: LPEjecutivosCuenta.llenarCamposEjecutivo() ");
    }

    private ComposerViewElementList crearParametrosEntrada(DTOBelcorp dto) throws Exception {
		traza("******* Entrada: LPEjecutivosCuenta.crearParametrosEntrada() ");
        
		  
		  ComposerViewElementList lista = new ComposerViewElementList();
        
		  traza("******* Marca x def_" + marcaDefecto);
		  traza("******* Canal x def_" + canalDefecto);

        if ((marcaDefecto != null) || (canalDefecto != null))  { //Si existe un valor por defecto para el usuario para la marca o el canal Entonces: 

            /*DTOUnidadAdministrativa, asignandole el valor de la marca y/o canal por defecto y el páis de la sesion activa. 
            MareBusinessID="ZONObtenerSubgerenciasVentas" 
            posOID=1 
            posDesc=3 */
            ComposerViewElement cmb7 = new ComposerViewElement();

            DTOUnidadAdministrativa dtoUniAdmin = new DTOUnidadAdministrativa();
            dtoUniAdmin.setOidIdioma(new Long(mIdioma));
            dtoUniAdmin.setOidPais(new Long(mPais));
            dtoUniAdmin.setOidMarca(marcaDefecto);
				
            cmb7.setIDBusiness("ZONObtenerSubgerenciasVentas");
            cmb7.setDTOE(dtoUniAdmin);
            cmb7.setPosOID((byte)0);
            cmb7.setPosDesc((byte)4);
            lista.addViewElement(cmb7);
				traza("******* x Hacer__ZONObtenerSubgerenciasVentas");

				traza("******* Subgerencia x def_" + this.sgvDefecto);
				
				if (this.sgvDefecto != null)  { //Si además existe un valor por defecto para la SGV entonces: 
                /*DTOUnidadAdministrativa, con el valor de la subgerencia de venta por defecto. 
                MareBusinessID="ZONObtenerRegiones" 
                posOID=1 
                posDesc=3 */
                ComposerViewElement cmb8 = new ComposerViewElement();
                cmb8.setDTOE(dtoUniAdmin);
                cmb8.setIDBusiness("ZONObtenerRegiones");
                cmb8.setPosOID((byte)0);
                cmb8.setPosDesc((byte)5);                
                lista.addViewElement(cmb8);

					 traza("******* x Hacer__ZONObtenerRegiones");

						traza("******* Region x def_" + this.regionDefecto);

					   if (this.regionDefecto != null)  { //Si además existe un valor por defecto para la Region entonces: 
                    /*DTOUnidadAdministrativa, con el valor de la region por defecto. 
                    MareBusinessID="ZONObtenerZonas" 
                    posOID=1 
                    posDesc=3 */
                    ComposerViewElement cmb9 = new ComposerViewElement();
                    cmb9.setDTOE(dtoUniAdmin);
                    cmb9.setIDBusiness("ZONObtenerZonas");
                    cmb9.setPosOID((byte)0);
                    cmb9.setPosDesc((byte)5);                
                    lista.addViewElement(cmb9);
						  traza("******* x Hacer__ZONObtenerZonas");
                }
            
            }

        }

        ComposerViewElement cmb1 = new ComposerViewElement();
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidIdioma(new Long(mIdioma));
        dtoOid.setOidPais(new Long(mPais));
        cmb1.setDTOE(dtoOid);
        cmb1.setIDBusiness("CARNivelesRiesgo");
        lista.addViewElement(cmb1);
		  traza("******* x Hacer__CARNivelesRiesgo");

		  
		  /*		  
		    comenta x inc BELC300014826
          cmb6.setIDBusiness("CARObtenerEjecutivos");

		    agrega x inc BELC300014826        
		    cmb6.setIDBusiness("MENObtenerUsuarios");
          lista.addViewElement(cmb6);
		   
			*/
			
			/*******************************************************************/

			/*
			 * Si es "insertar" necesitamos para:
			 *
			 * Pestaña Ejecutivos de cuenta  ---> Se cargará de la entidad Usuarios (MEN)
			 *
			 * Pestaña Unidades administrativas ---> Se cargará de la entidad Ejecutivos de cuenta (CAR) 
			 */

			traza("******* caso de uso: '" + mCasoDeUso+ "'");
			traza("******* accion     : '"+ mAccion +"'");
			
			ComposerViewElement cmb4 = new ComposerViewElement();
   	   cmb4.setDTOE(dto);
	      cmb4.setPosOID((byte)0);
		   cmb4.setPosDesc((byte)1);
		   cmb4.setIDBusiness("CARObtenerEjecutivos");
		   lista.addViewElement(cmb4);
		   traza("******* x Hacer__CARObtenerEjecutivos");

			ComposerViewElement cmb6 = new ComposerViewElement();
         cmb6.setDTOE(dto);
	      cmb6.setPosDesc((byte)1);
	      cmb6.setPosOID((byte)0);
			cmb6.setIDBusiness("MENObtenerUsuarios");			
			lista.addViewElement(cmb6);
			traza("******* x Hacer__MENObtenerUsuarios");

			/*
			if(mCasoDeUso.equals("insertar")){
					
					ComposerViewElement cmb6 = new ComposerViewElement();
			      cmb6.setDTOE(dto);
			      cmb6.setPosDesc((byte)1);
			      cmb6.setPosOID((byte)0);
		 			cmb6.setIDBusiness("MENObtenerUsuarios");			
					lista.addViewElement(cmb6);

					traza("******* x Hacer__MENObtenerUsuarios");

					ComposerViewElement cmb4 = new ComposerViewElement();
 				   cmb4.setDTOE(dto);
				   cmb4.setPosOID((byte)0);
				   cmb4.setPosDesc((byte)1);
				   cmb4.setIDBusiness("CARObtenerEjecutivos");
				   lista.addViewElement(cmb4);

				   traza("******* x Hacer__CARObtenerEjecutivos");

			}
			*/


			/***
			if(mCasoDeUso.equals("consultarInsert") || mCasoDeUso.equals("modificarInsert") ){

					ComposerViewElement cmb4 = new ComposerViewElement();
 				   cmb4.setDTOE(dto);
				   cmb4.setPosOID((byte)0);
				   cmb4.setPosDesc((byte)1);
				   cmb4.setIDBusiness("CARObtenerEjecutivos");
				   lista.addViewElement(cmb4);

				   traza("******* x Hacer__CARObtenerEjecutivos");

			}else{
					ComposerViewElement cmb6 = new ComposerViewElement();
			      cmb6.setDTOE(dto);
			      cmb6.setPosDesc((byte)1);
			      cmb6.setPosOID((byte)0);
		 			cmb6.setIDBusiness("MENObtenerUsuarios");			
					lista.addViewElement(cmb6);

					traza("******* x Hacer__MENObtenerUsuarios");
			}
			******/
			/*
			if(mCasoDeUso.equals("modificarInsert")){
					ComposerViewElement cmb4 = new ComposerViewElement();
 				   cmb4.setDTOE(dto);
				   cmb4.setPosOID((byte)0);
				   cmb4.setPosDesc((byte)1);
				   cmb4.setIDBusiness("CARObtenerEjecutivos");
				   lista.addViewElement(cmb4);
				   traza("******* x Hacer__CARObtenerEjecutivos");
					
						if(mAccion.equals("inserta")){
						ComposerViewElement cmb6 = new ComposerViewElement();
						cmb6.setDTOE(dto);
						cmb6.setPosDesc((byte)1);
						cmb6.setPosOID((byte)0);
						cmb6.setIDBusiness("MENObtenerUsuarios");			
						lista.addViewElement(cmb6);
						traza("******* x Hacer__MENObtenerUsuarios");
					}
			}			
			if(mCasoDeUso.equals("consultarInsert")){

					ComposerViewElement cmb4 = new ComposerViewElement();
 				   cmb4.setDTOE(dto);
				   cmb4.setPosOID((byte)0);
				   cmb4.setPosDesc((byte)1);
				   cmb4.setIDBusiness("CARObtenerEjecutivos");
				   lista.addViewElement(cmb4);
				   traza("******* x Hacer__CARObtenerEjecutivos");
					
					if(mAccion.equals("inserta")){
						ComposerViewElement cmb6 = new ComposerViewElement();
						cmb6.setDTOE(dto);
						cmb6.setPosDesc((byte)1);
						cmb6.setPosOID((byte)0);
						cmb6.setIDBusiness("MENObtenerUsuarios");			
						lista.addViewElement(cmb6);
						traza("******* x Hacer__MENObtenerUsuarios");
					}

			}else{
					ComposerViewElement cmb6 = new ComposerViewElement();
			      cmb6.setDTOE(dto);
			      cmb6.setPosDesc((byte)1);
			      cmb6.setPosOID((byte)0);
		 			cmb6.setIDBusiness("MENObtenerUsuarios");			
					lista.addViewElement(cmb6);

					traza("******* x Hacer__MENObtenerUsuarios");
			}*/

			/*******************************************************************/
         
		  

        ComposerViewElement cmb2 = new ComposerViewElement();
        cmb2.setDTOE(dto);
        cmb2.setIDBusiness("SEGConsultaMarcas");
        cmb2.setPosOID((byte)0);
        cmb2.setPosDesc((byte)1);
        lista.addViewElement(cmb2);        

			traza("******* x Hacer__SEGConsultaMarcas");

        ComposerViewElement cmb3 = new ComposerViewElement();
        cmb3.setDTOE(dto);
        cmb3.setIDBusiness("SEGConsultaCanales");
        cmb3.setPosOID((byte)0);
        cmb3.setPosDesc((byte)1);
        lista.addViewElement(cmb3);

		  traza("******* x Hacer__SEGConsultaCanales");

        /*
		  ComposerViewElement cmb4 = new ComposerViewElement();
        cmb4.setDTOE(dto);
        cmb4.setPosOID((byte)0);
        cmb4.setPosDesc((byte)1);
        cmb4.setIDBusiness("CARObtenerEjecutivos");
        lista.addViewElement(cmb4);
		  traza("******* x Hacer__CARObtenerEjecutivos");
			*/

        ComposerViewElement cmb5 = new ComposerViewElement();
        cmb5.setDTOE(dto);
        cmb5.setPosOID((byte)0);
        cmb5.setPosDesc((byte)1);
        cmb5.setIDBusiness("CARObtenerJerarquias");
        lista.addViewElement(cmb5);
        
  		  traza("******* x Hacer__CARObtenerJerarquias");

		  traza("******* Salida: LPEjecutivosCuenta.crearParametrosEntrada() ");
        return lista;
    }

    private ComposerViewElementList crearParametrosEntradaBase(DTOBelcorp dto) throws Exception {
	 traza("******* Entrada: LPEjecutivosCuenta.crearParametrosEntradaBase() ");

		  ComposerViewElementList lista = new ComposerViewElementList();
        
        ComposerViewElement cmb1 = new ComposerViewElement();

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidIdioma(new Long(mIdioma));
        dtoOid.setOidPais(new Long(mPais));
        cmb1.setDTOE(dtoOid);
        cmb1.setIDBusiness("CARNivelesRiesgo");
        lista.addViewElement(cmb1);
		  
		  traza("******* (1) ");
        ComposerViewElement cmb2 = new ComposerViewElement();
        cmb2.setDTOE(dto);
        cmb2.setIDBusiness("SEGConsultaMarcas");
        cmb2.setPosOID((byte)0);
        cmb2.setPosDesc((byte)1);
        lista.addViewElement(cmb2);        

		  traza("******* (2) ");
        ComposerViewElement cmb3 = new ComposerViewElement();
        cmb3.setDTOE(dto);
        cmb3.setIDBusiness("SEGConsultaCanales");
        cmb3.setPosOID((byte)0);
        cmb3.setPosDesc((byte)1);
        lista.addViewElement(cmb3);

        traza("******* (3) ");
		  ComposerViewElement cmb4 = new ComposerViewElement();
        cmb4.setDTOE(dto);
        cmb4.setPosOID((byte)0);
        cmb4.setPosDesc((byte)1);
        cmb4.setIDBusiness("CARObtenerEjecutivos");
        lista.addViewElement(cmb4);

        traza("******* (4) ");
        ComposerViewElement cmb5 = new ComposerViewElement();
        cmb5.setDTOE(dto);
        cmb5.setPosOID((byte)0);
        cmb5.setPosDesc((byte)1);
        cmb5.setIDBusiness("CARObtenerJerarquias");
        lista.addViewElement(cmb5);

			traza("******* (5) ");
        ComposerViewElement cmb6 = new ComposerViewElement();
        cmb6.setDTOE(dto);

		  //comento x inc BELC300014826
        // cmb6.setIDBusiness("CARObtenerEjecutivos");

			//agrega x inc BELC300014826
		  cmb6.setIDBusiness("MENObtenerUsuarios");
        
		  
		  lista.addViewElement(cmb6);

        traza("la lista es " + lista);

	traza("******* Salida: LPEjecutivosCuenta.crearParametrosEntradaBase() ");
        return lista;

    }

    private String[] construirLineas(String elementos, String delim) throws Exception {
      traza("******* Entrada: LPEjecutivosCuenta.construirLineas() ");
		  
		  StringTokenizer stk = new StringTokenizer(elementos, delim);
		String[] arr = new String[stk.countTokens()];
		int cuenta = 0;
        while (stk.hasMoreTokens()) {
			arr[cuenta] = stk.nextToken();
			cuenta++;
        }

		  traza("******* Salida: LPEjecutivosCuenta.construirLineas() ");
        return arr;
    }

    private DTOAsignaciones obtenerAsiganaciones(String[] asignaciones) throws Exception {
		traza("******* Entrada: LPEjecutivosCuenta.obtenerAsiganaciones() ");
		  
		  DTOAsignaciones dtoAsignaciones = new DTOAsignaciones();
        ArrayList aAsignEjecu = new ArrayList();

        for (int i=0;i<asignaciones.length;i++ ) {

            DTOAsignacionesEjecutivo dtoAsignacionesEJ = new DTOAsignacionesEjecutivo();
            String[] strAsign = construirLineas(asignaciones[i],"|");

            traza("Esta es una linea de la pantalla: ");
            for (int j=0 ;j<strAsign.length ;j++ )  {
                traza("Atributo: " + strAsign[j]);
            }

            if (!strAsign[0].startsWith("cod"))  {
                dtoAsignacionesEJ.setOidAsignacion(new Long(strAsign[0]));
            }

            dtoAsignacionesEJ.setOidEjecutivo(new Long(strAsign[1]));
            dtoAsignacionesEJ.setOidSgv(new Long(strAsign[4]));


			//pzerbino Incidencia BELC300021711 31/5/2006
			//dtoAsignacionesEJ.setOidRegion(new Long(strAsign[5]));
 	        //dtoAsignacionesEJ.setOidZona(new Long(strAsign[6]));
			//@ssaavedr region-zona, no son oblig.!

			traza("***** Asigno 6 strAsign[5]  " + strAsign[5]);
			if (strAsign[5].equals("_")){
                 dtoAsignacionesEJ.setOidRegion(null);	
            }else{
				 dtoAsignacionesEJ.setOidRegion(new Long(strAsign[5]));
            }
            traza("***** Asigno 7  strAsign[6]  " + strAsign[6]);
            if (strAsign[6].equals("_")){
                 dtoAsignacionesEJ.setOidZona(null);	
            }else{
	             dtoAsignacionesEJ.setOidZona(new Long(strAsign[6]));
            }

			
			dtoAsignacionesEJ.setOidNivelRiesgo(new Long(strAsign[7]));
            traza("Este es el DTO que se genero: " + dtoAsignacionesEJ);
            aAsignEjecu.add(dtoAsignacionesEJ);
        }
        
        dtoAsignaciones.setAsignaciones(aAsignEjecu);

		 traza("******* Salida: LPEjecutivosCuenta.obtenerAsiganaciones() ");
		 return dtoAsignaciones;
    }

    private String strObtenerAsignaciones(RecordSet rAsignaciones, Long oidEjecutivo)  throws Exception {
		traza("******* Entrada: LPEjecutivosCuenta.strObtenerAsignaciones() ");
		  String asignaciones = "";

        traza("Esta es la cantidad de registros2: " + rAsignaciones.getRowCount());
        for (int i=0; i<rAsignaciones.getRowCount(); i++)  {

            
            Long oidAsig =  new Long(((BigDecimal) rAsignaciones.getValueAt(i,0)).longValue());
            String usuario = (String) rAsignaciones.getValueAt(i,1);
            String marca = (String) rAsignaciones.getValueAt(i,2);
            String canal = (String) rAsignaciones.getValueAt(i,3);
            String subGerencia = (String) rAsignaciones.getValueAt(i,4);
            String region = ((String) rAsignaciones.getValueAt(i,5))==null?"":((String)rAsignaciones.getValueAt(i,5));
            String zona = ((String) rAsignaciones.getValueAt(i,6))==null?"":((String)rAsignaciones.getValueAt(i,6));
            String nivel = (String) rAsignaciones.getValueAt(i,7);
            Long oidUsuario =  oidEjecutivo;
            Long oidMarca =  new Long(((BigDecimal) rAsignaciones.getValueAt(i,9)).longValue());
            Long oidCanal =  new Long(((BigDecimal) rAsignaciones.getValueAt(i,10)).longValue());
            Long oidSGV =  new Long(((BigDecimal) rAsignaciones.getValueAt(i,11)).longValue());
			String oidRegion =  ((BigDecimal)rAsignaciones.getValueAt(i,12))==null?"":(((BigDecimal)rAsignaciones.getValueAt(i,12)).toString());
			String oidZona =  ((BigDecimal)rAsignaciones.getValueAt(i,13))==null?"":(((BigDecimal)rAsignaciones.getValueAt(i,13)).toString());
            Long oidNivel =  new Long(((BigDecimal) rAsignaciones.getValueAt(i,14)).longValue());

            asignaciones += oidAsig + "," + usuario + "," + marca + "," + canal + "," + subGerencia + "," + region + "," + 
                            zona + "," + nivel + "," + oidUsuario + "," + oidMarca + "," + oidCanal + "," + 
                            oidSGV + "," + oidRegion + "," + oidZona + "," + oidNivel + "|";
        }

		  traza("******* Salida: LPEjecutivosCuenta.strObtenerAsignaciones() ");
        return asignaciones;
    }

    private String obtenerCodigoPagina() throws Exception {
	traza("******* Entrada: LPEjecutivosCuenta.obtenerCodigoPagina() ");
        String codigo = null;
        if (mCasoDeUso != null){
            if (mCasoDeUso.equals("modificar") || mCasoDeUso.equals("modificarInsert"))
                codigo = "0441";
            if (mCasoDeUso.equals("eliminar") || mCasoDeUso.equals("eliminarInsert"))
                codigo = "0442";
            if (mCasoDeUso.equals("consultar") || mCasoDeUso.equals("consultarInsert"))
                codigo = "0443";
            if (mCasoDeUso.equals("insertar"))
                codigo = "0440";
        }
		  traza("******* Salida: LPEjecutivosCuenta.obtenerCodigoPagina() ");
        return codigo;
    }
}
