/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.bel.DTOMantenimientoCaja;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;


public class LPMantenimientoCaja extends LPSICCBase {

  private Long pais = null;
  private Long idioma = null;
    
  private String accion = null;
  private String opcionMenu = null;
    
  public LPMantenimientoCaja(){
    super();
  }
  
  public void inicio() throws Exception {}
  
  public void ejecucion() throws Exception {
          rastreo();
          setTrazaFichero();
          traza("*** Entrada - LPMantenimientoCaja  - ejecucion ***");
                    try  {
								accion = conectorParametroLimpia("accion", "", true);
								opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
								
								pais = UtilidadesSession.getPais(this); 
								idioma = UtilidadesSession.getIdioma(this);
				
								if (accion.equals("")) {
									cargarPagina(); 
								} else if (accion.equals("guardar")) {
									guardar();
								} else if (accion.equals("modificar")) {
									modificar();
								} else if (accion.equals("detalle")) {
									detalle();
								} else if (accion.equals("eliminar")) {
									eliminar();
								}

                    }
                    catch ( Exception e )  {
                              traza("....Excepcion LPMantenimientoCaja - opcionMenu: " + opcionMenu);
     
                              UtilidadesLog.info("");
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
           traza("*** Salida - LPMantenimientoCaja  - ejecucion ***");
      } 
      
    private void logStackTrace(Throwable e) throws Exception {
          traza("Se produjo la excepcion: " + e.getMessage());
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(baos);
          e.printStackTrace(ps);
          traza("Stack Trace: " + baos.toString());
		}		
    
    public void cargarPagina() throws Exception{
 
	traza("*** Entrada - LPMantenimientoCaja  - inicializar ***");
	traza("pais: " + pais.toString() );
	traza("idioma: " + idioma.toString() );
	traza("accion: " + accion );

	opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
	traza("opcionMenu : " + opcionMenu);

	if (opcionMenu.equals("insertar")) {
		cargarPGInsertarCaja();
	}else {
		if (opcionMenu.equals("modificar") 
				|| opcionMenu.equals("consultar") 
				|| opcionMenu.equals("eliminar")) {
				
				cargarPGConsultarCaja();
				if (opcionMenu.equals("modificar")){
					asignarAtributo("VAR", "casoUso", "valor","ModificarCaja");
				}else if (opcionMenu.equals("consultar")){
					asignarAtributo("VAR", "casoUso", "valor","ConsultarCaja");
				}else if (opcionMenu.equals("eliminar")){
					asignarAtributo("VAR", "casoUso", "valor","EliminarCaja");
				}
			}
	}

	cargarCombosCanalYRespCierreCaja();
	traza("opcionMenu: " + opcionMenu);
	asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
	asignarAtributo("VAR", "accion", "valor",accion);

	asignarAtributo("VAR", "pais", "valor", pais.toString());
	asignarAtributo("VAR", "idioma", "valor", idioma.toString());			
    }
    
    private void cargarCombosCanalYRespCierreCaja() throws Exception {
    
      traza("*** Entrada - LPMantenimientoCaja  - cargarCombosCanalYRespCierreCaja ***");
      
      DTOBelcorp dtoe = new DTOBelcorp();
		DTOOID dtoe2 = new DTOOID();
						
      pais = UtilidadesSession.getPais(this); 
      idioma = UtilidadesSession.getIdioma(this);
      dtoe.setOidPais(pais);
      dtoe.setOidIdioma(idioma);
      
		dtoe2.setOidPais(pais);
		dtoe2.setOidIdioma(idioma);
      //	Crear una lista ComposerViewElementList
      ComposerViewElementList lista = new ComposerViewElementList();
      
      ComposerViewElement elem1 = new ComposerViewElement();
      elem1.setIDBusiness("SEGConsultaCanales");
      elem1.setDTOE(dtoe);
      lista.addViewElement(elem1);
      
      /************** RESP CIERRE CAJA *******************/
      ComposerViewElement elem2 = new ComposerViewElement();
      elem2.setIDBusiness("MENObtenerUsuarios");
      elem2.setDTOE(dtoe);
      lista.addViewElement(elem2);
      /************** FIN RESP CIERRE CAJA *******************/

		  
      /************** TIPO CAJA *******************/
      ComposerViewElement elem3 = new ComposerViewElement();
      elem3.setIDBusiness("BELObtenerTiposCaja");
      elem3.setDTOE(dtoe2);
      lista.addViewElement(elem3);
      /************** FIN TIPO CAJA *******************/
      
      // Invocar al  subsistema GestorCargaPantalla
      ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      
      asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
      asignar("COMBO", "cbRespCierreCaja", resultados, "MENObtenerUsuarios");
		asignar("COMBO", "cbTipoCaja", resultados, "BELObtenerTiposCaja");
      
      traza("*** salida - LPMantenimientoCaja  - cargarCombosCanalYRespCierreCaja ***");
    }
    
    private void cargarPGInsertarCaja() throws Exception{
		 traza("*** Entrada - LPMantenimientoCaja  - cargarPGInsertarCaja ***");

		  pagina("contenido_mantenimiento_cajas_insertar");
        this.getFormatosValidaciones();
        
        if(opcionMenu.equals("insertar")){
			getConfiguracionMenu("LPMantenimientoCaja","insertar");
            this.asignarAtributoPagina("cod", "BelCaja.create.label");				
        }else{
          if(opcionMenu.equals("modificar")){
            getConfiguracionMenu("LPMantenimientoCaja","modificarDetalle");
            this.asignarAtributoPagina("cod", "BelCaja.update.label");	

          }else{
            if(accion.equals("detalle")){
            getConfiguracionMenu("LPMantenimientoCaja","detalle");
            this.asignarAtributoPagina("cod", "BelCaja.view.label");	
            
           }
          } 
        } 
      traza("*** Salida - LPMantenimientoCaja  - cargarPGInsertarCaja ***"); 
		}	
    
    private void cargarPGConsultarCaja() throws Exception{
		  traza("*** Entrada - LPMantenimientoCaja  - cargarPGConsultarCaja ***");

		  pagina("contenido_mantenimiento_cajas_consultar");
        this.getFormatosValidaciones();
        
        if(opcionMenu.equals("consultar")){
			getConfiguracionMenu("LPMantenimientoCaja","consultar");
            this.asignarAtributoPagina("cod", "BelCaja.query.label");				
        }else if(opcionMenu.equals("eliminar")){
              getConfiguracionMenu("LPMantenimientoCaja","eliminar");
              this.asignarAtributoPagina("cod", "BelCaja.remove.label");
		  }else if(opcionMenu.equals("modificar")){
              getConfiguracionMenu("LPMantenimientoCaja","modificar");
              this.asignarAtributoPagina("cod", "BelCaja.update.label");
		  }

      traza("*** Salida - LPMantenimientoCaja  - cargarPGConsultarCaja ***"); 

	}	
    
    public void guardar() throws Exception {
      /*
          Armamos un DTOMantenimientoCaja (dto) con los datos de la pantalla, 
          en el caso de los combos se guarda el oid: 
          - dto.oid = oidCaja 
          - dto.subacceso = cbSubacceso 
          - dto.codigoCaja = txtCodCaja 
          - dto.respCierreCaja = cbRespCierreCaja 
          - dto.tipoCaja = cbTipoCaja 
          - dto.pais = el de sesión 
          
          Invocamos al conector ConectorActualizarCaja con el dto creado y el
          IdBusiness "BELActualizarCaja"

       */
        traza("******************* Antes de crearDtoMantenimientoCaja...");
        DTOMantenimientoCaja dto = crearDtoMantenimientoCaja();
		  opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		  pagina("salidaGenerica");
        traza("******************* Luego de crearDtoMantenimientoCaja...");
        MareBusinessID businessID = new MareBusinessID("BELActualizarCaja");
        
        Vector parametros = new Vector();
        parametros.add(dto);
        parametros.add(businessID);

        traza("******************* Antes de conectar");
        
        conectar("ConectorActualizarCaja", parametros);
        
        traza("******************* Despues de conectar");
		asignarAtributo("VAR", "ejecutar", "valor", "reiniciar('" + opcionMenu+ "')");

    }
    
    private DTOMantenimientoCaja crearDtoMantenimientoCaja() throws Exception{
    
        DTOMantenimientoCaja dto = new DTOMantenimientoCaja();
        //----- tipo caja
        traza("******************* obteniendo tipo caja...");
        Long oidCaja = conectorParametro("oidCaja").equals("") 
                                      ? null 
                                      : new Long(conectorParametro("oidCaja"));
        dto.setOidCaja( oidCaja );
        //----- canal
        traza("******************* obteniendo canal...");
        Long oidCanal = conectorParametro("cbCanal").equals("") 
                                      ? null 
                                      : new Long(conectorParametro("cbCanal"));
        dto.setOidCanal( oidCanal );
        //---- acceso
        traza("******************* obteniendo acceso...");
        Long oidAcceso =  conectorParametro("cbAcceso").equals("") 
                                      ? null 
                                      : new Long(conectorParametro("cbAcceso"));
        dto.setOidAcceso( oidAcceso );
        //-----subacceso
        traza("******************* obteniendo subacceso...");
        Long oidSubacceso = conectorParametro("cbSubacceso").equals("") 
                                      ? null 
                                      : new Long(conectorParametro("cbSubacceso"));
        dto.setOidSubacceso( oidSubacceso );
        //-----codigo caja
        traza("******************* obteniendo codigo caja...");
        dto.setCodigoCaja (conectorParametroLimpia("txtCodigoCaja", "", true)); 
        //----oid resp caja
        traza("******************* obteniendo oid resp caja...");
        Long oidRespCaja = conectorParametro("cbRespCierreCaja").equals("") 
                                      ? null 
                                      : new Long(conectorParametro("cbRespCierreCaja"));
        dto.setOidRespCierreCaja ( oidRespCaja );
        //----tipo caja
        traza("******************* obteniendo tipo caja ...");
        Long oidTipoCaja = conectorParametro("cbTipoCaja").equals("") 
                                      ? null 
                                      : new Long(conectorParametro("cbTipoCaja"));
        dto.setOidTipoCaja(oidTipoCaja);
         //----pais
        traza("******************* obteniendo pais ...");
        dto.setOidPais (this.pais);
        
        return dto;
    }
    
    public void modificar() throws Exception {
        /* 
          Cargamos todos los campos de la pantalla PaginaInsertarCaja 
          con los mismos datos que la página PaginaConsultarCaja 
          Mapear los datos recibidos desde la ventana llamante 
          (elemento seleccionado de la lista) con los respectivos valores de la pantalla 
          PaginaInsertarCaja.oidCaja = oid del elemento seleccionado de la lista 
          accion = "modificar" 
          Mostrar la página PGInsertarCaja solo seran editables 
          los campos cbRespCierreCaja y cbTipoCaja 
          Cerrar Modal
        */
        traza("*** Entrada - LPMantenimientoCaja  - modificar ***");
        cargarPGInsertarCaja();
        cargarCombos();
        asignarAtributo("CTEXTO", 
                                "txtCodigoCaja", 
                                "valor",
                                conectorParametroLimpia("codCaja", "", true) );
        
        asignarAtributo("VAR", "accion",  "valor", "modificar" );
		  asignarAtributo("VAR", "idioma",  "valor", conectorParametroLimpia("idioma", "", true) );	
		  asignarAtributo("VAR", "pais","valor", conectorParametroLimpia("oidPais", "", true));
		  asignarAtributo("VAR", "oidCaja",  "valor", conectorParametroLimpia("oidCaja", "", true) );
		  asignarAtributo("VAR", "opcionMenu", "valor","modificar");
    }
    
    private void cargarCombos() throws Exception {
    
        traza("*** Entrada - LPMantenimientoCaja  - cargarCombos ***");
        cargarCombosCanalYRespCierreCaja();

         traza("-------  asigna atributo canal ---");
        asignarAtributo("VAR", 
                              "oidCanal", 
                              "valor", 
                              conectorParametroLimpia("oidCanal", "", true)); 
		  
        traza("-------  asigna atributo acceso ---");
        asignarAtributo("VAR", 
                              "oidAcceso", 
                              "valor", 
                              conectorParametroLimpia("oidAcceso", "", true)); 
        
        traza("-------  asigna atributo subacceso ---");                              
        asignarAtributo("VAR", 
                              "oidSubacceso", 
                              "valor", 
                              conectorParametroLimpia("oidSubacceso", "", true));
        
        traza("-------  asigna atributo tipo caja ---");                              
        asignarAtributo("VAR", 
                              "oidTipoCaja", 
                              "valor", 
                              conectorParametroLimpia("oidTipoCaja", "", true));     
		  
		  traza("-------  asigna atributo canal ---");
        asignarAtributo("VAR", 
                              "oidRespCierreCaja", 
                              "valor", 
                              conectorParametroLimpia("oidRespCierreCaja", "", true)); 

        traza("*** Salida - LPMantenimientoCaja  - cargarCombos ***");    
    }
    
    public void detalle() throws Exception {
      /*
        Mapear los datos recibidos desde la ventana llamante
		  (elemento seleccionado de la lista) con los respectivos 
		  valores de la pantalla 
        accion = "detalle" 
        Mostrar la página PGInsertarCaja con todos 
		  los botones y campos deshabilitados 
        Cerrar Modal
      */
        traza("*** Entrada - LPMantenimientoCaja  - modificar ***");
        cargarPGInsertarCaja();
        cargarCombos();
        asignarAtributo("CTEXTO", 
															"txtCodigoCaja", 
															"valor",
															conectorParametroLimpia("codCaja", "", true) );
        
        asignarAtributo("VAR", "accion",  "valor", "detalle" );
		  asignarAtributo("VAR", "idioma",  "valor", conectorParametroLimpia("idioma", "", true) );
		  asignarAtributo("VAR", "oidCaja",  "valor", conectorParametroLimpia("oidCaja", "", true) );
		  asignarAtributo("VAR", "opcionMenu", "valor","detalle");
    }

    public void eliminar() throws Exception {
		traza("*** Entrada - LPMantenimientoCaja  - eliminar ***");
		DTOOIDs dto = new DTOOIDs();
		String hOids = (String)conectorParametroLimpia("hOidsEliminar", "", true);
		traza("hOids: " + hOids );
		pagina("salidaGenerica");

		try{
			StringTokenizer st = new StringTokenizer(hOids,"[,]");
			Long[] oids = new Long[ st.countTokens() ];
			for( int i = 0; st.hasMoreTokens() ; i++){
				oids[i] = new Long( st.nextToken() );
				traza("oids[i]: " + oids[i].toString() );
			}
			dto.setOids(oids);
			traza("oids: " + oids.toString() );
		}catch(NoSuchElementException e){
			traza("NoSuchElementException e: " + e);
		}

		MareBusinessID businessID = new MareBusinessID("BELEliminarCajas");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);
		traza("parametros :  " + parametros.toString() );
		conectar("ConectorEliminarCajas", parametros);

		asignarAtributo("VAR", "ejecutar", "valor", "listado1.eliminarSelecc();");
		traza("*** Salida - LPMantenimientoCaja  - eliminar ***");
	}
}