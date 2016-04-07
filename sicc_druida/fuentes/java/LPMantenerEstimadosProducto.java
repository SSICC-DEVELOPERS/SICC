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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOMantenerEstimadosProducto;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import java.math.BigDecimal;

public class LPMantenerEstimadosProducto extends LPSICCBase {     
	private String accion;
    private String opcionMenu;
    private Long pais;
    private Long idioma;

    public void inicio() throws Exception {}
	public void ejecucion() throws Exception {
		rastreo();
		setTrazaFichero();

		traza("*** LPMantenerEstimadosProducto.ejecucion() - Entrada ***");

	    try {
					accion = conectorParametroLimpia("accion", "", true);
					opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
					idioma = UtilidadesSession.getIdioma(this);			
					pais = UtilidadesSession.getPais(this);

					traza("*** accion: " + accion);
					traza("*** opcionMenu: " + opcionMenu);
					traza("*** idioma: " + idioma);
					traza("*** pais: " + pais);
				 
					if(accion.equals("")){
					  this.cargarPantalla();
					}
					
                    if(accion.equals("detalle") || (accion.equalsIgnoreCase("detalleModificar"))) { //consultar o modificar
					  this.cargarPantalla();
                      detalleEstimadosProducto();
					}

					if(accion.equals("guardar")){//insertar
					   guardar();
					}

					if(accion.equals("generar")){//generar
					   generar();
					}
					
					if(accion.equals("sobreEscribir")){//
					   sobreEscribirGeneracionEstimados();
					}
					if(accion.equals("buscar")){
						this.buscarDescripcionProducto();	
						
					}

					getFormatosValidaciones();

			} catch (Exception e) {
					logStackTrace(e);
					lanzarPaginaError(e);
			}
			traza("*** LPMantenerEstimadosProducto.ejecucion() - Salida ***");
        }
         
        private void detalleEstimadosProducto() throws Exception {
              traza("*** LPMantenerEstimadosProducto.detalleEstimadosProducto() - Entrada ***");     
 
               // Obtengo los datos de la ventana llamante
              String oidEstimado  = conectorParametroLimpia("oidEstimado", "", true);
              String oidCentroDistr = conectorParametroLimpia("hCbCentroDistribucion", "", true);
  			  String descCentroDistribucion = conectorParametroLimpia("hDescCentroDistribucion", "", true);			  
              String oidLineaArmado = conectorParametroLimpia("hCbLineaArmado", "", true);
		 	  String descLineaArmado = conectorParametroLimpia("hDescLineaArmado", "", true);              
			  String oidMarca = conectorParametroLimpia("hCbMarca", "", true);
			  String descMarca = conectorParametroLimpia("hDescMarca", "", true);              
			  String oidCanal = conectorParametroLimpia("hCbCanal", "", true);
			  String descCanal = conectorParametroLimpia("hDescCanal", "", true);
			  String oidPeriodo = conectorParametroLimpia("hCbPeriodo", "", true);
			  String descPeriodo = conectorParametroLimpia("hDescPeriodo", "", true);
			  String codProducto = conectorParametroLimpia("txtCodigoProducto", "", true);
              String unidadesEstimadas = conectorParametroLimpia("txtUnidadesEstimadas", "", true);              
              String fueraPedido = conectorParametroLimpia("ChkFueraPedido", "", true);
              String oidProcedencia = conectorParametroLimpia("hOidProcedencia", "", true); // LG_V400000056 Hace falta para el CU Consultar/Modificar/Eliminar
			  String desProducto = conectorParametroLimpia("txtDesProducto","", true);

              String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
              String accion = conectorParametroLimpia("accion", "", true);              
  

              traza("*** oidEstimado" + oidEstimado);
              traza("*** oidcentroDistr" + oidCentroDistr);              
              traza("*** oidLineaArmado" + oidLineaArmado);
              traza("*** oidmarca" + oidMarca );
              traza("*** oidcanal" + oidCanal );
              traza("*** oidPeriodo" + oidPeriodo);

			  traza("*** DesCentroDistr" + descCentroDistribucion);              
              traza("*** DesLineaArmado" + descLineaArmado);
              traza("*** DesMarca" + descMarca );
              traza("*** DesCanal" + descCanal );
              traza("*** DesPeriodo" + descPeriodo);

			  traza("*** codProducto" + codProducto);
			  traza("*** desProducto" + desProducto);
              traza("*** fueraPedido" + fueraPedido);
              traza("*** unidadesEstimadas" + unidadesEstimadas);
              traza("*** opcionMenu" + opcionMenu);
              traza("*** accion" + accion);
              
              
              // Cargo la info para llenar la pagina
              asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);  
              asignarAtributo("VAR", "accion", "valor", accion);                
			  asignarAtributo("VAR", "oidEstimado", "valor", oidEstimado);
              asignarAtributo("VAR", "hCbCentroDistribucion", "valor", oidCentroDistr);
              asignarAtributo("VAR", "hDescCentroDistribucion", "valor", descCentroDistribucion);
              asignarAtributo("VAR", "hCbLineaArmado", "valor", oidLineaArmado);
              asignarAtributo("VAR", "hDescLineaArmado", "valor", descLineaArmado);			  
              asignarAtributo("VAR", "hCbMarca", "valor", oidMarca);
              asignarAtributo("VAR", "hDescMarca", "valor", descMarca);
              asignarAtributo("VAR", "hCbCanal", "valor", oidCanal);
              asignarAtributo("VAR", "hDescCanal", "valor", descCanal);
              asignarAtributo("VAR", "hCbPeriodo", "valor", oidPeriodo);  
              asignarAtributo("VAR", "hDescPeriodo", "valor", descPeriodo);
              asignarAtributo("VAR", "htxtCodigoProducto", "valor", codProducto);
			  asignarAtributo("CTEXTO", "txtDescripcionProducto", "valor", desProducto);
              asignarAtributo("VAR", "htxtUnidadesEstimadas", "valor", unidadesEstimadas);
              asignarAtributo("VAR", "hChkFueraPedido", "valor", fueraPedido);              
              
              if (opcionMenu.equals("consultar") || opcionMenu.equals("eliminar") || opcionMenu.equals("modificar")) {
                  asignarAtributo("VAR", "hCbProcedencia", "valor", oidProcedencia); // LG_V400000056 Hace falta para el CU Consultar/Eliminar/Modificar
              }
              
              traza("*** LPMantenerEstimadosProducto.detalleEstimadosProducto() - Salida ***");     
         }

        private void cargarPantalla() throws Exception {
			traza("*** LPMantenerEstimadosProducto.cargarPantalla() - Entrada ***");
            
            if(accion.equals("")){
                if(opcionMenu.equals("insertar")) {//insertar
                    traza("LPMantenerEstimadosProducto.cargarPantalla:opcionMenu insertar");
                    pagina("contenido_estimados_producto_insertar");
                    asignarAtributoPagina("cod", "ApeEstimadosProd.create.label");
    
                } 
                else if(opcionMenu.equals("generar")) {//generar
                    traza("LPMantenerEstimadosProducto.cargarPantalla:opcionMenu generar");
					pagina("contenido_estimados_producto_generar");
                    asignarAtributoPagina("cod", "ApeEstimadosProd.generar.label");
				}			
				else  {
                    pagina("contenido_estimados_producto_modificar");
    
                    if (opcionMenu.equals("consultar")) {
                        traza("LPMantenerEstimadosProducto.cargarPantalla:opcionMenu consultar");
                        asignarAtributoPagina("cod", "ApeEstimadosProd.query.label");
                    }
    
                    if (opcionMenu.equals("eliminar")) {
                        traza("LPMantenerEstimadosProducto.cargarPantalla:opcionMenu eliminar");
                        asignarAtributoPagina("cod", "ApeEstimadosProd.remove.label");
    
                    }
                    if (opcionMenu.equals("modificar")) {
                        traza("LPMantenerEstimadosProducto.cargarPantalla:opcionMenu modificar");
                        asignarAtributoPagina("cod", "ApeEstimadosProd.update.label");
                    }
                }
                getConfiguracionMenu("LPMantenerEstimadosProducto", opcionMenu);
            }
            else if(accion.equals("detalle") || (accion.equalsIgnoreCase("detalleModificar"))) {
                traza("LPMantenimientoCentroDistribucion.cargarPantalla:accion " + accion);
                pagina("contenido_estimados_producto_insertar");
                asignar("VAR", "accion", accion );
                asignarAtributoPagina("cod", "ApeEstimadosProd.view.label");                
                getConfiguracionMenu("LPMantenerEstimadosProducto", accion);
            }
            asignarAtributo("VAR", "idioma", "valor", idioma.toString());
            asignarAtributo("VAR", "pais", "valor", pais.toString());
            asignar("VAR", "opcionMenu", opcionMenu);
			cargarCombos();

			traza("*** LPMantenerEstimadosProducto.cargarPantalla() - Salida ***");
		}
        
        private void cargarCombos() throws Exception {
			  traza("*** LPMantenerEstimadosProducto.cargarCombos() - Entrada ***");
              
              DTOBelcorp dtoBelcorp = new DTOBelcorp();
              dtoBelcorp.setOidIdioma(idioma);
              dtoBelcorp.setOidPais(pais);

              String[] idBusiness = new String[] {"APEObtenerDescripcionesCD","SEGObtenerMarcasSinFiltro",
                                                  "SEGObtenerCanalesSinFiltro"};
              String[] comboBox = new String[] {"cbCentroDistribucion", "cbMarca", "cbCanal" };                

              cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
              
              if (opcionMenu.equals("insertar") || accion.equalsIgnoreCase("detalleModificar") || 
	  	 		  accion.equals("detalle")){

                 idBusiness = new String[] {"APEObtenerProcedencia"};
                 comboBox = new String[] {"cbProcedencia"};                
                 cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
  
                 //Seleccionar en el cbProcedencia el elemento donde oid == ConstantesAPE.OID_PROCEDENCIA_MANUAL 
                 asignarAtributo("VAR", "hCbProcedencia", "valor", ConstantesAPE.OID_PROCEDENCIA_MANUAL.toString());

              }
              
              
			/*
			 * Recupero el valor por defecto para el combo cbCentroDistribucion
			 * y lo asigno a la variable hidden.
			 * NOTA (dmorello, 19/01/2007):
			 * En el DMCO se indica hacerlo usando ConectorComposerView
			 * pero se optó por esta forma, ya que así es como viene haciéndose.
			 * Esta forma de implementar hizo necesario crear el
			 * ConectorObtenerValoresDefecto, que no figura en el modelo.
			 * 
			 * // Recupera los oids de los valores por defecto para cada combo
			 *  Crear un elemento de tipo ComposerViewElement() para cargar los periodos
			 *  elem.IDBusiness = "APEObtenerValoresDefecto";
			 *  elem.DTOE = dtoe;
			 *  Añadir el elemento a la lista
			 *
			 */
			//  Ejecuto esto sólo cuando no voy a levantar la modal.
			if (accion.equals("")) {
				Vector parametros = new Vector();
				parametros.add(dtoBelcorp);
				parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));

				traza("*** antes de conectar para obtener valores por defecto");
				DruidaConector conector2 = conectar("ConectorObtenerValoresDefecto", parametros);
				traza("*** despues de conectar para obtener valores por defecto");

				DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
				RecordSet rs = dtoSalida.getResultado();
				traza("*** rs: " + rs);

				/*
				 * Aqui guardo todas las lineas de armado por defecto
				 * Los OIDs van separados por pipes y luego se envian a la pagina
				 */
				StringBuffer lineasDef = new StringBuffer();

				int size = rs.getRowCount();
				for (int i = 0; i < size; i++) {
					Object combo = rs.getValueAt(i, "COMBO");
					if (ConstantesAPE.CONFIGURACION_CD.equals(combo)) {
						asignar("VAR", "hOidCentroDistribucionDefecto", rs.getValueAt(i, "OID").toString());
					} else if (ConstantesAPE.LINEA_ARMADO.equals(combo)) {
						lineasDef.append(rs.getValueAt(i, "OID").toString()).append('|');
					}
				}

				// Borro el ultimo pipe, a fin de hacer un split en JavaScript
				int length = lineasDef.length();
				if (length > 0) {
					lineasDef.delete(length-1, length);
				}
				asignar("VAR", "hOidsLineasArmadoDefecto", lineasDef.toString());
				// Fin 
			}              
              
              

			  traza("*** LPMantenerEstimadosProducto.cargarCombos() - Salida ***");
        }
        
		private void generar() throws Exception {
			traza("LPMantenerEstimadosProducto.generar() - Entrada");
			pagina("salidaGenerica");
		
			String oidEstimado = conectorParametroLimpia("oidEstimado", "", true);
			String oidLineaVenta = conectorParametroLimpia("oidLineaVenta", "", true);
			String oidLineaMav = conectorParametroLimpia("oidLineaMav", "", true);
			String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);

			traza("***** oidEstimado " + oidEstimado);
			traza("***** oidLineaVenta " + oidLineaVenta);
			traza("***** oidLineaMav " + oidLineaMav);
			traza("***** oidPeriodo " + oidPeriodo);

			DTOMantenerEstimadosProducto dto = new DTOMantenerEstimadosProducto();
	
			if(!oidEstimado.equals("")) {
				dto.setOidEstimado(new Long(oidEstimado));
			}

			if(!oidLineaVenta.equals("")) {
				dto.setOidLineaArmado(new Long(oidLineaVenta));
			}

			if(!oidLineaMav.equals("")) {
				dto.setOidLineaArmadoMAV(new Long(oidLineaMav));
			}

			dto.setOidPeriodo(new Long(oidPeriodo));
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);

			MareBusinessID businessID = new MareBusinessID("APEGenerarEstimadoProducto");
			Vector parametros = new Vector();
			parametros.add(dto);
			parametros.add(businessID);

			try {
				traza("******************* Antes de conectar");
				DruidaConector con = conectar("ConectorGenerarEstimadosProducto", parametros);
				traza("******************* Despues de conectar");
				DTOMantenerEstimadosProducto dtoSalida = (DTOMantenerEstimadosProducto)con.objeto("dtoSalida");	
				traza("******************* DTOMantenerEstimadosProducto.sobreEscribir " + 
				dtoSalida.getSobreEscribir());

				if(dtoSalida.getSobreEscribir()!=null && dtoSalida.getSobreEscribir().booleanValue()==true) {
					asignarAtributo("VAR","ejecutar","valor","fGenerarOK('true')");        
				}
				else {
					asignarAtributo("VAR","ejecutar","valor","fGenerarOK('false')");        
				}
			}
			catch(Exception e) {
				traza("******************* Entrando al catch...");	
				asignarAtributo("VAR", "ejecutarError", "valor", "fGenerarERR()");  
				throw e;
			}

			traza("LPMantenerEstimadosProducto.generar() - Salida");
		}

		private void sobreEscribirGeneracionEstimados() throws Exception {
			traza("LPMantenerEstimadosProducto.sobreEscribirGeneracionEstimados() - Entrada");
			pagina("salidaGenerica");
		
			String oidEstimado = conectorParametroLimpia("oidEstimado", "", true);
			String oidLineaVenta = conectorParametroLimpia("oidLineaVenta", "", true);
			String oidLineaMav = conectorParametroLimpia("oidLineaMav", "", true);
			String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);
			String mantenerEstimadosManuales = conectorParametroLimpia("mantenerEstimadosManuales", "", true);

			traza("***** oidEstimado " + oidEstimado);
			traza("***** oidLineaVenta " + oidLineaVenta);
			traza("***** oidLineaMav " + oidLineaMav);
			traza("***** oidPeriodo " + oidPeriodo);
			traza("***** mantenerEstimadosManuales " + mantenerEstimadosManuales);			

			DTOMantenerEstimadosProducto dto = new DTOMantenerEstimadosProducto();
	
			if(!oidEstimado.equals("")) {
				dto.setOidEstimado(new Long(oidEstimado));
			}

			if(!oidLineaVenta.equals("")) {
				dto.setOidLineaArmado(new Long(oidLineaVenta));
			}

			if(!oidLineaMav.equals("")) {
				dto.setOidLineaArmadoMAV(new Long(oidLineaMav));
			}

			dto.setOidPeriodo(new Long(oidPeriodo));
			dto.setMantenerEstimadosManuales(new Boolean(mantenerEstimadosManuales));
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);

			MareBusinessID businessID = new MareBusinessID("APESobreEscribirGeneracionEstimados");
			Vector parametros = new Vector();
			parametros.add(dto);
			parametros.add(businessID);

			try {
				traza("******************* Antes de conectar");
				DruidaConector con = conectar("ConectorSobreEscribirGeneracionEstimados", parametros);
				traza("******************* Despues de conectar");

				asignarAtributo("VAR","ejecutar","valor","fSobreEscribirOK()");        
			}
			catch(Exception e) {
				traza("******************* Entrando al catch...");	
				asignarAtributo("VAR", "ejecutarError", "valor", "fSobreEscribirERR()");  
				throw e;
			}

			traza("LPMantenerEstimadosProducto.sobreEscribirGeneracionEstimados() - Salida");
		}
         
        private void guardar() throws Exception {
              traza("*** Entrada - LPMantenerEstimadosProducto.guardar() ***");

              pagina("salidaGenerica");

              asignar("VAR", "ejecutar", "guardarCorrecto()");
              asignar("VAR", "ejecutarError", "guardarError()");
              
              DTOMantenerEstimadosProducto dto = crearDTOMantenerEstimadosProducto();
			  

              MareBusinessID id = new MareBusinessID("APEGuardarEstimadosProducto");
              Vector parameters = new Vector();
              parameters.add(dto);
              parameters.add(id);
              DruidaConector conector = conectar("ConectorGuardarEstimadosProducto", parameters);			

              traza("*** Salida - LPMantenerEstimadosProducto.guardar() ***");
        }
        

        private DTOMantenerEstimadosProducto crearDTOMantenerEstimadosProducto() throws Exception {
              traza("*** Entrada - LPMantenerEstimadosProducto.crearDTOMantenerEstimadosProducto() ***");

              DTOMantenerEstimadosProducto dto = new DTOMantenerEstimadosProducto();
              if (opcionMenu.equalsIgnoreCase("insertar")) {
                  dto.setOidEstimado(null);
              } 
              else {                                          
                String oidEstimado = conectorParametroLimpia("oidEstimado", "", true);
                traza("*** oidEstimado : " + oidEstimado);                                
                dto.setOidEstimado(new Long(oidEstimado));
              }                  
              String oidLineaArmado = conectorParametroLimpia("cbLineaArmado", "", true);
              String oidPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
              String codProducto = conectorParametroLimpia("txtCodigoProducto", "", true);
              String unidEstimadas = conectorParametroLimpia("txtUnidadesEstimadas", "", true);
              /* BELC400000345 - dmorello, 24/04/2007: Se eliminó ChkFueraPedido */
			  //String fueraPedido = conectorParametroLimpia("ChkFueraPedido", "", true);
              String oidProcedencia = conectorParametroLimpia("cbProcedencia", "", true);              
              
              traza("*** oidLineaArmado : " + oidLineaArmado);
              traza("*** oidPeriodo : " + oidPeriodo);
              traza("*** codProducto : " + codProducto);
              traza("*** unidEstimadas : " + unidEstimadas);
              //traza("*** fueraPedido : " + fueraPedido);
              traza("*** oidProcedencia : " + oidProcedencia);
              
			  if (opcionMenu.equalsIgnoreCase("insertar") || opcionMenu.equalsIgnoreCase("modificar")) {
				  traza(" *** Como es APE Estimados Producto (Insertar o Modificar) --> la Procedencia se grabara como 'Manual'");
                  oidProcedencia = ConstantesAPE.OID_PROCEDENCIA_MANUAL.toString();
			  }
              
              dto.setOidPais(pais);
              dto.setOidIdioma(idioma);
              dto.setOidLineaArmado(new Long(oidLineaArmado));
              dto.setOidPeriodo(new Long(oidPeriodo));
              dto.setCodigoProducto(codProducto);
              dto.setUnidadesEstimadas(new Long(unidEstimadas));
              /* BELC400000345 - dmorello, 24/04/2007: Se eliminó ChkFueraPedido */
              //dto.setFueraPedido(new Boolean(fueraPedido.equalsIgnoreCase("S") ? "true" : "false"));
              dto.setOidProcedencia(new Long(oidProcedencia));
              
              traza("*** dto : " + dto);                  
              traza("*** Salida - LPMantenerEstimadosProducto.crearDTOMantenerEstimadosProducto() ***");                  
              return dto;
        }         

/*

// Recupera los oids de los valores por defecto para cada combo 
Crear un elemento de tipo ComposerViewElement() para cargar los periodos 
elem.IDBusiness = "APEObtenerValoresDefecto"; 
elem.DTOE = dtoe; 
Añadir el elemento a la lista 

Invocar al subsistema GestorCargaPantalla 

Con los valores recuperados a partir del IDBusiness "APEObtenerValoresDefecto", contenidos en el RecordSet dentro del DTOSalida, setear los valores por defecto de los combos de la siguiente manera: 
- Si registro[i].combo == ConstantesAPE.CONFIGURACION_CD 
{ 
setear el combo cbCentroDistribucion con el valor correspondiente a registro[i].oid 
} 
 * */        

        private void cargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
                traza("*** Entrada - LPMantenerEstimadosProducto - cargarCombos ***");
        
                ComposerViewElementList list = new ComposerViewElementList();
                ComposerViewElement element = null;
        
                for (int i = 0; i < idBusiness.length; i++) { 
                    element = new ComposerViewElement(); 
                    element.setIDBusiness(idBusiness[i]);
                    traza("*** idBusiness[i]: , " + idBusiness[i]);
                    element.setDTOE(dto);
                    list.addViewElement(element);
                }
                
                traza("***dto : , " + dto);
        
                // Obtener un RowSet que contiene los datos solicitados por list.
                ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
               
                ccv.ejecucion();
                DruidaConector dc = ccv.getConector();
        
                // Asignar los datos obtenidos a los combos.
                if (selected != null && column != null) {
                    for (int i = 0; i < comboBox.length; i++) {
                        if (selected[i] != null && column[i] != null) {
                            asignar("COMBO", comboBox[i], dc, idBusiness[i], column[i], selected[i]);
                        } else {
                            asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
                        }
                    }
                } else {
                    for(int i = 0; i < comboBox.length; i++) {
                        asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
                    }
                }
        
                traza("*** Salida - LPMantenerEstimadosProducto - cargarCombos ***");
        }   
         
        private void logStackTrace(Throwable e) throws Exception {
			traza("Se produjo la excepcion: " + e.getMessage());		
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			e.printStackTrace(ps);		
			traza("Stack Trace: " + baos.toString());
        }
		//Agregado por cambio 20090839
		private void buscarDescripcionProducto() throws Exception{
				traza("777777777LPMantenerEstimadosProducto.buscarDescripcionProducto(): Entrada");
                  pagina("salidaGenerica");
                  try{
                           String codigoProducto = conectorParametroLimpia("txtCodigoProducto", "", true);
                           String oidProd = null;
                           String desProducto= null;
                           traza("7777777codigoProducto: " + codigoProducto);

                           DTOMantenerEstimadosProducto dtoP = new DTOMantenerEstimadosProducto();
                           dtoP.setOidPais(pais);
                           dtoP.setOidIdioma(idioma);
                           dtoP.setCodigoProducto(new String(codigoProducto));
                           MareBusinessID businessID = new MareBusinessID("APEDesProductoInter");
                           
                           Vector para = new Vector(); 
                           para.add(dtoP);
                           para.add(businessID);
                           
                           traza("7777777777 Antes de conectar");
                           DruidaConector dc =	conectar("ConectorObtenerProducto", para);
						   traza("777777777 Despues de conectar");

                           DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida");
                           RecordSet rs = dtoSalida.getResultado(); 							
                           traza("rs: " + rs);
                           
                           
                           oidProd   =  ((BigDecimal)rs.getValueAt(0,"VAL_OID")).toString();
                           desProducto = (String)rs.getValueAt(0,"VAL_I18N");			  
                           
                           traza("77777777oidProducto: " + oidProd);
                           traza("77777777desProducto: " + desProducto);
                           //asignarAtributo("VAR", "oidProducto", "valor", oidProd);
                           //asignarAtributo("VAR", "desProducto", "valor", desProducto);
                           asignarAtributo("VAR", "cerrarVentana", "valor", "false");
                           asignarAtributo("VAR", "ejecutar", "valor", "fverProducto('" + this.replace(desProducto,"'", " ") + "');");  
				  }catch(Exception e){
						             traza("********* Entrando al Catch");
									 e.printStackTrace();
                                     asignarAtributo("VAR", "ejecutarError", "valor", "fProductoERR()");
									 throw e;

				  }
		}
		//Agregado por cambio 20090839
		public static String replace(String s, String s1, String s2){  

             int i = 0; 
             int j = 0; 
             int k = s1.length(); 

             StringBuffer stringbuffer = null; 
             String s3 = s; 

             while((j = s.indexOf(s1, i)) >= 0)
             { 

                      if(stringbuffer == null) 
                        { 
                             stringbuffer = new StringBuffer(s.length() * 2); 
                        } 
                        stringbuffer.append(s.substring(i, j)); 
                        stringbuffer.append(s2); 
                        i = j + k; 
             } 

             if(i != 0) 
             { 
                        stringbuffer.append(s.substring(i)); 
                        s3 = stringbuffer.toString(); 
             } 

             return s3; 

   }


}
