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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOSistemaPicado;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOTipoCajaProducto;
import es.indra.sicc.dtos.ape.DTOTipoCajaSublinea;
import es.indra.sicc.dtos.ape.DTOAsignacionImpresorasAPE;
import es.indra.sicc.util.DTOOIDs;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

// Gpons - 10/03/2007 - Inc. BELC400000337: Se elimina cbSistemaEtiquetado

public class LPMantenimientoSublineaArmado extends LPSICCBase {     
    private String accion;
    private String opcionMenu;
    private Long pais;
    private Long idioma;

    public void inicio() throws Exception {}
    

	public void ejecucion() throws Exception {
             rastreo();
             setTrazaFichero();

             traza("*** LPMantenimientoSublineaArmado.ejecucion() - Entrada ***");

             try {
                     accion = conectorParametroLimpia("accion", "", true);
                     opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
                     idioma = UtilidadesSession.getIdioma(this);			
                     pais = UtilidadesSession.getPais(this);

                     traza("*** accion: " + accion);
                     traza("*** opcionMenu: " + opcionMenu);
                     traza("*** idioma: " + idioma);
                     traza("*** pais: " + pais);
             
                     if (accion.equals("")) {
                        this.cargarPagina();
                     }
                                             
                     if(accion.equals("detalle") || (accion.equalsIgnoreCase("detalleModificar"))) { //consultar o modificar
                        this.cargarPagina();
                        mostrarDetalle();
                     }

                     if(accion.equals("guardar")){//insertar o modificar
                         guardar();
                     }

                     getFormatosValidaciones();

             } catch (Exception e) {
                                     logStackTrace(e);
                                     lanzarPaginaError(e);
                   }
                   traza("*** LPMantenimientoSublineaArmado.ejecucion() - Salida ***");
         }
          

         private void cargarPagina() throws Exception {
             
             traza("*** LPMantenimientoSublineaArmado.cargarPagina() - Entrada ***");
             
             if(accion.equals("")){
                  if(opcionMenu.equals("insertar")) {//insertar
                      traza("LPMantenimientoSublineaArmado.cargarPagina:opcionMenu insertar");
                      pagina("contenido_sublineas_armado_insertar");
                      asignarAtributoPagina("cod", "ApeSubLineaArmado.create.label");
                      anyadeHiddensI18N(false, "APE_SUBLI_ARMAD", null, new Integer(1), "formulario", "txtDescripcion", false);
                      asignar("VAR", "MAX_BAHIAS_SUBLINEA", ConstantesAPE.MAX_BAHIAS_SUBLINEA.toString()); 
                      asignar("VAR", "MAX_COLUMNAS_SUBLINEA", ConstantesAPE.MAX_COLUMNAS_SUBLINEA.toString());
                      asignar("VAR", "MAX_NIVELES_SUBLINEA", ConstantesAPE.MAX_NIVELES_SUBLINEA.toString());                      
                  } 
                  else  {
                      pagina("contenido_sublineas_armado_modificar");
    
                      if (opcionMenu.equals("consultar")) {
                           traza("LPMantenimientoSublineaArmado.cargarPagina:opcionMenu consultar");
                           asignarAtributoPagina("cod", "ApeSubLineaArmado.query.label");
                      }
    
                      if (opcionMenu.equals("eliminar")) {
                           traza("LPMantenimientoSublineaArmado.cargarPagina:opcionMenu eliminar");
                           asignarAtributoPagina("cod", "ApeSubLineaArmado.remove.label");
                      }
                      if (opcionMenu.equals("modificar")) {
                           traza("LPMantenimientoSublineaArmado.cargarPagina:opcionMenu modificar");
                           asignarAtributoPagina("cod", "ApeSubLineaArmado.update.label");
                      }
                  }
                  getConfiguracionMenu("LPMantenimientoSublineaArmado", opcionMenu);
             }
             else if(accion.equals("detalle") || (accion.equalsIgnoreCase("detalleModificar"))) {
                  traza("LPMantenimientoSublineaArmado.cargarPagina:accion " + accion);
                  pagina("contenido_sublineas_armado_insertar");
                  asignar("VAR", "accion", accion );
                  asignarAtributoPagina("cod", "ApeSubLineaArmado.view.label");                  
                  getConfiguracionMenu("LPMantenimientoSublineaArmado", accion);
             }
             asignarAtributo("VAR", "idioma", "valor", idioma.toString());
             asignarAtributo("VAR", "pais", "valor", pais.toString());
             asignar("VAR", "opcionMenu", opcionMenu);
             cargarCombos();
             

             traza("*** LPMantenimientoSublineaArmado.cargarPagina() - Salida ***");
         }
         

		 private void cargarCombos() throws Exception {
                traza("*** LPMantenimientoSublineaArmado.cargarCombos() - Entrada ***");
                
                Vector dtos = new Vector();
                Vector idBusiness = new Vector();
                Vector comboBox = new Vector();

                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                dtoBelcorp.setOidIdioma(idioma);
                dtoBelcorp.setOidPais(pais);

                DTOSiccPaginacion dtoSiccPaginacion = new DTOSiccPaginacion();
                dtoSiccPaginacion.setOidIdioma(idioma);
                dtoSiccPaginacion.setOidPais(pais);

                DTOTipoCajaProducto dtoTcp = new DTOTipoCajaProducto();
                dtoTcp.setOidIdioma(idioma);
                dtoTcp.setOidPais(pais);
                
                //Carga de Combo Centro Distribucion
                idBusiness.add("APEObtenerDescripcionesCD"); 
                comboBox.add("cbCentroDistribucion");                
                dtos.add(dtoBelcorp);
                //Fin Carga de Combo Centro Distribucion
                
                //Carga de Combo Sistema Picado
                idBusiness.add("APEConsultarSistemaPicado");
                comboBox.add("cbSistemaPicado");
                dtos.add(dtoSiccPaginacion);
                //Fin Carga de Combo Sistema Picado
                
                //Carga de Combo Codigo de Impresora //ciglesias 480
                idBusiness.add("APEConsultarCodigosImpresora");
                comboBox.add("cbCodigoImpresora");
                dtos.add(dtoSiccPaginacion);
                //Fin Carga de Combo Sistema Picado


               if (opcionMenu.equals("insertar") 
                    || accion.equalsIgnoreCase("detalleModificar") ||  accion.equals("detalle")) {

                   //Carga de Combo lstTipoCajaSublinea.tipoCajaProducto  
                   idBusiness.add("APEBuscarTipoCajaProducto");
                   comboBox.add("comboTipoCajaProducto");  
                   dtos.add(dtoTcp);
                   //FIN Carga de Combo lstTipoCajaSublinea.tipoCajaProducto  

                    if (opcionMenu.equals("insertar")) {
                        cargarCodigoSublinea();
                    }
                }
                cargarCombos(dtos,idBusiness,comboBox);

			   /*
				* Recupero el valor por defecto para el combo cbCentroDistribucion
				* y lo asigno a la variable hidden.
				* NOTA (dmorello, 19/01/2007):
				* En el DMCO se indica hacerlo usando ConectorComposerView
				* pero se optó por esta forma, ya que así es como viene haciéndose.
				* Esta forma de implementar hizo necesario crear el
				* ConectorObtenerValoresDefecto, que no figura en el modelo.
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
			   
			   traza("*** LPMantenimientoSublineaArmado.cargarCombos() - Salida ***");
         }


         
		 private void cargarCodigoSublinea() throws Exception {
                traza("*** LPMantenimientoSublineaArmado.cargarCodigoSublinea() - Entrada ***");

                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                dtoBelcorp.setOidIdioma(idioma);
                dtoBelcorp.setOidPais(pais);
        
                Vector parametros = new Vector();
                parametros.add(dtoBelcorp);
                parametros.add(new MareBusinessID("APEObtenerProximoCodigoSublinea"));

                traza("*** antes de conectar para obtener proximo codigo sublinea");
                DruidaConector conectorObtenerProximoCodigoSublinea = conectar("ConectorObtenerProximoCodigoSublinea", parametros);
                traza("*** despues de conectar para obtener proximo codigo sublinea");

                DTOOID dtoOid = (DTOOID) conectorObtenerProximoCodigoSublinea.objeto("CODIGO");
                Long proxCodSublinea = dtoOid.getOid();
                traza("***proxCodSublinea: " + proxCodSublinea);
                asignar("VAR", "hTxtCodigoSublinea", proxCodSublinea.toString());
                
                traza("*** LPMantenimientoSublineaArmado.cargarCodigoSublinea() - Salida ***");
         }                
          

         private void cargarCombos(Vector dtos, Vector idBusiness, Vector comboBox) throws Exception {
                  traza("*** Entrada - LPMantenimientoSublineaArmado - cargarCombos ***");
         
                  ComposerViewElementList list = new ComposerViewElementList();
                  ComposerViewElement element = null;
         
                  for (int i = 0; i < idBusiness.size(); i++) { 
                      element = new ComposerViewElement(); 
                      element.setIDBusiness((String)idBusiness.get(i));
                      traza("*** idBusiness: , " + idBusiness.get(i));
                      element.setDTOE((DTOBelcorp)dtos.get(i));
                      
					  if (element.getIDBusiness().equals("APEConsultarSistemaPicado")) {					//Refefinimos la posición de las columnas porque el resultado de 
						// la operación de negocio no es estándar
                            element.setPosDesc((byte)2);
                      }else{
                            element.setPosDesc((byte)1);
                      }
                      list.addViewElement(element);
                  }
                  
                  // Obtener un RowSet que contiene los datos solicitados por list.
                  ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
                 
                  ccv.ejecucion();
                  DruidaConector dc = ccv.getConector();
         
                  // Asignar los datos obtenidos a los combos.
                  for(int i = 0; i < comboBox.size(); i++) {
                           asignar("COMBO", (String)comboBox.get(i), dc, (String)idBusiness.get(i)); 
                      }

         
                  traza("*** Salida - LPMantenimientoSublineaArmado - cargarCombos ***");
         }   

    
    private void mostrarDetalle ()throws Exception {
        traza("Entra a mostrarDetalle");
        
        cargarCombos();

       //Utilizando los datos de la lstResultados rellenar la pantalla. 
       
        String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        String accion = conectorParametroLimpia("accion", "", true);                 
        
        String oidSublinea = conectorParametroLimpia("hOidSublinea", "", true);
        
        String oidCentroDist = conectorParametroLimpia("hCbCentroDistribucion", "", true);
        String descCentroDist = conectorParametroLimpia("hDescCentroDistribucion", "", true);
        
        String oidLineaArmado = conectorParametroLimpia("hCbLineaArmado", "", true);
        String descLinea = conectorParametroLimpia("hDescLineaArmado", "", true);        
        
        String codigoSublinea = conectorParametroLimpia("hCodSubLineaArmado", "", true);
        String descSublinea = conectorParametroLimpia("hDescSubLineaArmado", "", true);
        
        String oidSistPicado = conectorParametroLimpia("hCbSistPicado", "", true);
        String descSistPicado = conectorParametroLimpia("hDescSistPicado", "", true);
        
        String descLetraAnaquel = conectorParametroLimpia("hDescLetraAnaquel", "", true);
        String chkImprimirListaPicado = conectorParametroLimpia("hChkImprimirListaPicado", "", true);
        String chkPostVenta = conectorParametroLimpia("hChkPostVenta", "", true);
        String chkFrenteEspalda = conectorParametroLimpia("hChkFrenteEspalda", "", true);
        String txtBahiasFrente = conectorParametroLimpia("hTxtBahiasFrente", "", true);
        String txtBahiasEspalda = conectorParametroLimpia("hTxtBahiasEspalda", "", true);
        String txtNivelesFrente = conectorParametroLimpia("hTxtNivelesFrente", "", true);                
        String txtNivelesEspalda = conectorParametroLimpia("hTxtNivelesEspalda", "", true);
        String txtColumnasBahiaFrente = conectorParametroLimpia("hTxtColumnasBahiaFrente", "", true);
        String txtColumnasBahiaEspalda = conectorParametroLimpia("hTxtColumnasBahiaEspalda", "", true);
        String txtNumeroOrdenBalanceo = conectorParametroLimpia("hTxtNumeroOrdenBalanceo", "", true); 
		
        String oidCodigoImpresora = conectorParametroLimpia("hOidCodigoImpresora", "", true); 
        String txtNroImpresoraPTL = conectorParametroLimpia("hTxtNroImpresoraPTL", "", true); 

        traza("*** opcionMenu" + opcionMenu);
        traza("*** accion" + accion);
        traza("*** oidSublinea" + oidSublinea);
        traza("*** hCbCentroDistribucion" + oidCentroDist);
        traza("*** descCentroDist" + descCentroDist);
        traza("*** oidLineaArmado" + oidLineaArmado);
        traza("*** descLinea" + descLinea);
        traza("*** codigoSublinea" + codigoSublinea);
        traza("*** descSublinea" + descSublinea);
        traza("*** oidSistPicado" + oidSistPicado);
        traza("*** descSistPicado" + descSistPicado);
        traza("*** descLetraAnaquel" + descLetraAnaquel);
        traza("*** chkImprimirListaPicado" + chkImprimirListaPicado);
        traza("*** chkPostVenta" + chkPostVenta);
        traza("*** chkFrenteEspalda" + chkFrenteEspalda);
        traza("*** chkFrenteEspalda" + chkFrenteEspalda);
        traza("*** chkFrenteEspalda" + chkFrenteEspalda);
        traza("*** txtNivelesFrente" + txtNivelesFrente);
        traza("*** txtNivelesEspalda" + txtNivelesEspalda);
        traza("*** txtColumnasBahiaFrente" + txtColumnasBahiaFrente);
        traza("*** txtColumnasBahiaEspalda" + txtColumnasBahiaEspalda);
        traza("*** txtNumeroOrdenBalanceo" + txtNumeroOrdenBalanceo);
        traza("*** oidCodigoImpresora" + oidCodigoImpresora);
        traza("*** txtNroImpresoraPTL" + txtNroImpresoraPTL);
        
        // Cargo la info para llenar la pagina
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);  
        asignarAtributo("VAR", "accion", "valor", accion);   
        
        asignarAtributo("VAR", "hOidSublinea", "valor", oidSublinea);
        asignarAtributo("VAR", "hCbCentroDistribucion", "valor", oidCentroDist);
        asignarAtributo("VAR", "hDescCentroDistribucion", "valor", descCentroDist);
        asignarAtributo("VAR", "hCbLineaArmado", "valor", oidLineaArmado);
        asignarAtributo("VAR", "hDescLineaArmado", "valor", descLinea);
        asignarAtributo("VAR", "hTxtCodigoSublinea", "valor", codigoSublinea);			          
        asignarAtributo("VAR", "hTxtDescripcion", "valor", descSublinea);	
        asignarAtributo("VAR", "hCbSistemaPicado", "valor", oidSistPicado);			          
        asignarAtributo("VAR", "hDescSistPicado", "valor", descSistPicado);			          
        asignarAtributo("VAR", "hDescLetraAnaquel", "valor", descLetraAnaquel);			          
        asignarAtributo("VAR", "hChkImprimirListaPicado", "valor", chkImprimirListaPicado);			          
        asignarAtributo("VAR", "hChkPostVenta", "valor", chkPostVenta);			          
        asignarAtributo("VAR", "hChkFrenteEspalda", "valor", chkFrenteEspalda);			          
        asignarAtributo("VAR", "hTxtBahiasFrente", "valor", txtBahiasFrente);			          
        asignarAtributo("VAR", "hTxtBahiasEspalda", "valor", txtBahiasEspalda);			          
        asignarAtributo("VAR", "hTxtNivelesFrente", "valor", txtNivelesFrente);			          
        asignarAtributo("VAR", "hTxtNivelesEspalda", "valor", txtNivelesEspalda);			                  
        asignarAtributo("VAR", "hTxtColumnasBahiaFrente", "valor", txtColumnasBahiaFrente);			                  
        asignarAtributo("VAR", "hTxtColumnasBahiaEspalda", "valor", txtColumnasBahiaEspalda);			          
        asignarAtributo("VAR", "hTxtNumeroOrdenBalanceo", "valor", txtNumeroOrdenBalanceo);			                  

        asignarAtributo("VAR", "hOidCodigoImpresora", "valor", oidCodigoImpresora);			                  
        asignarAtributo("VAR", "hTxtNroImpresoraPTL", "valor", txtNroImpresoraPTL);			                  


        asignar("VAR", "MAX_BAHIAS_SUBLINEA", ConstantesAPE.MAX_BAHIAS_SUBLINEA.toString()); 
        asignar("VAR", "MAX_COLUMNAS_SUBLINEA", ConstantesAPE.MAX_COLUMNAS_SUBLINEA.toString());
        asignar("VAR", "MAX_NIVELES_SUBLINEA", ConstantesAPE.MAX_NIVELES_SUBLINEA.toString());
       
        DTOOID dtoOidSublinea = new DTOOID();
        dtoOidSublinea.setOid(new Long(oidSublinea));
        dtoOidSublinea.setOidPais(pais);
        dtoOidSublinea.setOidIdioma(idioma);
        
        cargarTiposCajaSublinea(dtoOidSublinea); 
         
        boolean soloLectura;
        if (opcionMenu.equals("modificar")) {
            //asignarAtributo("VAR", "hDescripcion", "valor", sDescripcionTipoCajaProducto);  // Memoria de fLimpiar
            soloLectura = false;
        } else { // consultar eliminar
            //asignarAtributoElemento("txtDescripcion", "disabled", "S"); // Deshabilita
            soloLectura = true;
        }
        
        anyadeHiddensI18N(true, "APE_SUBLI_ARMAD", new Long(oidSublinea), new Integer(1), 
                          "formulario", "txtDescripcion", soloLectura);        
        
        if (opcionMenu.equalsIgnoreCase("modificar")) {
            //Se deshabilitan los combos cbCentroDistribucion y 
            //cbLinea de la pantalla y el combo de la lista para todos los registros de la misma. 
        }else{ 
            //Se deshabilitan todos los campos y botones de la pantalla 
        }
    }
    
    
    //Metodo en construccion
     private void cargarTiposCajaSublinea (DTOOID dtoOidSublinea) throws Exception {
      traza("Entra a cargarTiposCajaSublinea");
        
      MareBusinessID mareBusinessID = new MareBusinessID("APEBuscarTipoCajaSublinea");
      Vector params = new Vector();              
      params.addElement(dtoOidSublinea);
      params.addElement(mareBusinessID);
   
      traza("antes del conector");
      DruidaConector dc  = conectar("ConectorBuscarTipoCajaSublinea", params);
      traza("despues del conector");
      
      DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
      
      // Obtiene los detalles
      RecordSet rsDetalle = dtoSalida.getResultado();
      
      // Armo Lista
      RecordSet rs = new RecordSet();          
      rs.addColumn("oid");
      rs.addColumn("oidTipoCajaProducto");  //comboTipoCajaProducto
      rs.addColumn("numCaja"); //Capacidad Anaque
      rs.addColumn("oidDetalle"); 
      
      
      int cant = rsDetalle.getRowCount();
      
      for(int i=0; i<cant; i++){
         traza("TICP_OID_TIPO_CAJA_PROD" + rsDetalle.getValueAt(i,"TICP_OID_TIPO_CAJA_PROD").toString());
         traza("NUM_CAJA" + rsDetalle.getValueAt(i,"NUM_CAJA").toString());
         traza("OID_TIPO_CAJA_SUBL" + rsDetalle.getValueAt(i,"OID_TIPO_CAJA_SUBL").toString());
         
         rs.addRow(new Object[] {
             Integer.toString(i), 
             ((BigDecimal)rsDetalle.getValueAt(i,"TICP_OID_TIPO_CAJA_PROD")).toString(),
             ((BigDecimal)rsDetalle.getValueAt(i,"NUM_CAJA")).toString(), 
             ((BigDecimal)rsDetalle.getValueAt(i,"OID_TIPO_CAJA_SUBL")).toString()}); 
      }
      
      asignar("LISTADOA", "listado1", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");      
     }        


        private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
              StringBuffer salida = new StringBuffer();
              int sizeColums = datos.getColumnCount();
              int sizeRows = datos.getRowCount();
              
              if ( columns == null ){
                 columns = new Vector();
              }
          
              Vector columsDesc = datos.getColumnIdentifiers();          
              
              DruidaConector conectorValoresPosibles = new DruidaConector();
              
              XMLDocument xmlDoc  = new XMLDocument();
              Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");                    
              Element e_rows = docDestino.createElement("ROWSET");
              e_rows.setAttribute("ID",rowsetID);
              docDestino.getDocumentElement().appendChild(e_rows);
              
              for (int i=0; i < sizeRows; i++){
                 Element e_row = docDestino.createElement("ROW");
                 e_rows.appendChild(e_row);
          
                 Element e_campo0   = docDestino.createElement("CAMPO");
          
                 for(int j=0; j < sizeColums; j++){
                   if( columns.contains(columsDesc.elementAt(j))){
                     Element e_campo2   = docDestino.createElement("CAMPO");
                     
                     if(j == 0){
                        e_campo0.setAttribute("NOMBRE","oculto");
                     }else{
                        e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
                     }
                     e_campo2.setAttribute("TIPO","OBJECTO");
                     e_campo2.setAttribute("LONGITUD","50");
                     Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
                     e_campo2.appendChild(txt0);
                     e_row.appendChild(e_campo2);
                   }
                 }
              }
              conectorValoresPosibles.setXML(docDestino.getDocumentElement());
              return conectorValoresPosibles;
         }
          
         
         private void guardar() throws Exception {
                traza("*** Entrada - LPMantenimientoSublineaArmado.guardar() ***");

                pagina("salidaGenerica");
                asignar("VAR", "ejecutar", "guardarCorrecto()");
                asignar("VAR", "ejecutarError", "guardarError()");
                
                DTOSublineaArmado dtoSublineaArmado = crearDTOSublinea();

                if (opcionMenu.equalsIgnoreCase("insertar")) {                
                    traza("*** insertar ***" );
                    MareBusinessID id = new MareBusinessID("APEInsertarSublineaArmado");
                    Vector parameters = new Vector();
                    parameters.add(dtoSublineaArmado);
                    parameters.add(id);
                    DruidaConector conector = conectar("ConectorInsertarSublineaArmado", parameters);                          
                }
                else if (opcionMenu.equalsIgnoreCase("modificar")){  
           
                    String detallesEliminados = conectorParametroLimpia("detallesEliminados", "", true);
                    dtoSublineaArmado.setTipoCajaSublineasEliminados(armarDetallesEliminados(detallesEliminados));
                                   
                    MareBusinessID id = new MareBusinessID("APEModificarSublineaArmado");
                    Vector parameters = new Vector();
                    parameters.add(dtoSublineaArmado);
                    parameters.add(id);
                    DruidaConector conector = conectar("ConectorInsertarSublineaArmado", parameters);                          
                }
                anyadeHiddensI18N(false, "APE_SUBLI_ARMAD", null, new Integer(1), "formulario", "txtDescripcion", false);                
                traza("*** Salida - LPMantenimientoSublineaArmado.guardar() ***");
         }
         
         private DTOSublineaArmado crearDTOSublinea() throws Exception {
                traza("*** Entrada - LPMantenimientoSublineaArmado.crearDTOSublinea() ***");
               
                String oidSublinea = conectorParametroLimpia("hOidSublinea", "", true);
                String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);
                String cbLineaArmado = conectorParametroLimpia("cbLineaArmado", "", true);
                String txtCodigoSublinea = conectorParametroLimpia("txtCodigoSublinea", "", true);
                String txtDescripcion = conectorParametroLimpia("txtDescripcion", "", true);
                String cbSistemaPicado = conectorParametroLimpia("cbSistemaPicado", "", true);
                String chkSublineaPostVenta = conectorParametroLimpia("chkSublineaPostVenta", "", true);
                String cbLetraAnaquel = conectorParametroLimpia("cbLetraAnaquel", "", true);
                String chkImprimirListaPicado = conectorParametroLimpia("chkImprimirListaPicado", "", true);                
                String chkFrenteEspalda = conectorParametroLimpia("chkFrenteEspalda", "", true);
                String txtBahiasSublineaFrente = conectorParametroLimpia("txtBahiasSublineaFrente", "", true);
                String txtBahiasSublineaEspalda = conectorParametroLimpia("txtBahiasSublineaEspalda", "", true);
                String txtNroNivelesFrente = conectorParametroLimpia("txtNroNivelesFrente", "", true);                
                String txtNroNivelesEspalda = conectorParametroLimpia("txtNroNivelesEspalda", "", true);                                
                String txtNroColumnasBahiaFrente = conectorParametroLimpia("txtNroColumnasBahiaFrente", "", true);                
                String txtNroColumnasBahiaEspalda = conectorParametroLimpia("txtNroColumnasBahiaEspalda", "", true);                
                String txtNroOrdenBalanceo = conectorParametroLimpia("txtNroOrdenBalanceo", "", true);                                
                String listaDetalles = conectorParametroLimpia("listaDetalles", "", true);                 
                String cbCodigoImpresora = conectorParametroLimpia("cbCodigoImpresora", "", true); //ciglesias incidencia 480
                String txtNroImpresoraPTL = conectorParametroLimpia("txtNroImpresoraPTL", "", true); //ciglesias incidencia 480
				
                traza("Cabecera: ");
                traza("*** oidSublinea : " + oidSublinea);
                traza("*** cbCentroDistribucion : " + cbCentroDistribucion);
                traza("*** cbLineaArmado : " + cbLineaArmado);
                traza("*** txtCodigoSublinea : " + txtCodigoSublinea);
                traza("*** txtDescripcion : " + txtDescripcion);
                traza("*** cbSistemaPicado : " + cbSistemaPicado);
                traza("*** chkSublineaPostVenta : " + chkSublineaPostVenta);
                traza("*** cbLetraAnaquel : " + cbLetraAnaquel.toCharArray()[0]);                
                traza("*** chkImprimirListaPicado : " + chkImprimirListaPicado);
                traza("*** chkFrenteEspalda : " + chkFrenteEspalda);
                traza("*** txtBahiasSublineaFrente : " + txtBahiasSublineaFrente);                
                traza("*** txtBahiasSublineaEspalda : " + txtBahiasSublineaEspalda);
                traza("*** txtNroNivelesFrente : " + txtNroNivelesFrente);
                traza("*** txtNroNivelesEspalda : " + txtNroNivelesEspalda);
                traza("*** txtNroColumnasBahiaFrente : " + txtNroColumnasBahiaFrente);
                traza("*** txtNroColumnasBahiaEspalda : " + txtNroColumnasBahiaEspalda);
                traza("*** txtNroOrdenBalanceo : " + txtNroOrdenBalanceo);
                traza("Detalle: ");                
                traza("*** listaDetalles : " + listaDetalles);
                traza("*** cbCodigoImpresora : " + cbCodigoImpresora);
                traza("*** txtNroImpresoraPTL : " + txtNroImpresoraPTL);

                
                DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
                dtoLineaArmado.setOid(new Long(cbLineaArmado));
                
                DTOSistemaPicado dtoSistemaPicado = new DTOSistemaPicado();
                dtoSistemaPicado.setOid(new Long(cbSistemaPicado));

				DTOAsignacionImpresorasAPE dtoAsignacionImpresoras = new DTOAsignacionImpresorasAPE();
				if(!cbCodigoImpresora.equals("")) {
					dtoAsignacionImpresoras.setImpresoraVirtual(new Long(cbCodigoImpresora));
				}

				if (!txtNroImpresoraPTL.equals("")) {
					dtoAsignacionImpresoras.setNroImpresoraPTL(new Long(txtNroImpresoraPTL));
				}
/*
- sublinea.asignacionImpresora = cbCodigoImpresora

Crear el DTOAsignacionImpresora y setear
DTOAsignacionImpresora.impresoraVirtual = cbCodigoImpresora
DTOAsignacionImpresoras.sublinea = cbSubLinea

Setear el DTOAsignacionImpresora en el DTOSublineaArmado

/* fin BELC400000430 */ 

                
                DTOSublineaArmado dtoSublineaArmado = new DTOSublineaArmado();

				dtoSublineaArmado.setImpresora(dtoAsignacionImpresoras);
                
                Vector traducciones = recuperaTraduccionesI18N(new Integer(1));
                
                if (opcionMenu.equalsIgnoreCase("insertar")) {
                    traducciones = quitarTraduccionesEnBlanco(traducciones);
                    dtoSublineaArmado.setOid(null);
                } else {
                    dtoSublineaArmado.setOid(new Long(oidSublinea));
                }
                
                dtoSublineaArmado.setCodigoSublinea(new Long(txtCodigoSublinea));
                
                dtoSublineaArmado.setAttriTraducible(traducciones);
                
                dtoSublineaArmado.setDescripcionSublinea(txtDescripcion);
                
                dtoSublineaArmado.setLetraParaAnaquel(cbLetraAnaquel.toCharArray()[0]);
                
                //VALIDAR N - S / 0 - 1
                dtoSublineaArmado.setPostVenta(chkSublineaPostVenta.equals("S")?Boolean.TRUE:Boolean.FALSE);
                dtoSublineaArmado.setImprimirListaPicado(chkImprimirListaPicado.equals("S")?Boolean.TRUE:Boolean.FALSE);
                dtoSublineaArmado.setFrenteEspalda(chkFrenteEspalda.equals("S")?Boolean.TRUE:Boolean.FALSE);
                
                dtoSublineaArmado.setBahiasFrente(txtBahiasSublineaFrente.equals("")?null:Integer.valueOf(txtBahiasSublineaFrente));
                dtoSublineaArmado.setBahiaEspalda(txtBahiasSublineaEspalda.equals("")?null:Integer.valueOf(txtBahiasSublineaEspalda));
                dtoSublineaArmado.setNumeroNivelesFrente(txtNroNivelesFrente.equals("")?null:Integer.valueOf(txtNroNivelesFrente));
                dtoSublineaArmado.setNumeroNivelesEspalda(txtNroNivelesEspalda.equals("")?null:Integer.valueOf(txtNroNivelesEspalda));
                dtoSublineaArmado.setNumeroColumnasFrente(txtNroColumnasBahiaFrente.equals("")?null:Integer.valueOf(txtNroColumnasBahiaFrente));
                dtoSublineaArmado.setNumeroColumnasEspalda(txtNroColumnasBahiaEspalda.equals("")?null:Integer.valueOf(txtNroColumnasBahiaEspalda));
                dtoSublineaArmado.setNumeroOrdenBalanceo(txtNroOrdenBalanceo.equals("")?null:new Long(txtNroOrdenBalanceo));
                
                dtoSublineaArmado.setLineaArmado(dtoLineaArmado);
                dtoSublineaArmado.setSistemaPicado(dtoSistemaPicado);

				//INC. BELC400000340 
                dtoSublineaArmado.setCentroDistribucion(new Long(cbCentroDistribucion));
				//Fin INC. BELC400000340

                //Crear un array de DTOTipoCajaSublinea tiposCajasSublinea 
                Vector detalleTiposCajasSublinea= new Vector();
          
   
                /*
                Por cada fila de la lstTipoCajaSublinea{ 

                Crear un DTOTipoCajaProducto tipoCajaProducto 
                    - tipoCajaProducto.oid = el oid de tipoCajaProducto de la linea de la lista 
                
                Crear un DTOTipoCajaSublinea tipoCajaSublinea 
                - tipoCajaSublinea.oid = oidTipoCajaSublinea 
                - tipoCajaSublinea.numeroCaja = capacidadAnaquel 
                - tipoCajaSublinea.tipoCajaProducto = tipoCajaProducto 
                - tipoCajaSublinea.sublinea = sublinea 
                } 
                */   
                traza("Detalle");
                // Arma el detalle
                if(!listaDetalles.equals("")) {
                  
                    StringTokenizer stkListaDetalles = new StringTokenizer(listaDetalles,"|");
                    StringTokenizer stkRegDetalle = null;
                    
                    DTOTipoCajaProducto dtoTipoCajaProducto = null;
                    DTOTipoCajaSublinea dtoTipoCajaSublinea = null;
                    
                    String oidTipoCajaSublinea = null;
                    String tipoCaja = null;
                    String capacidadAnaquel = null;
                    String oidEliminado = null;
                        
                    while (stkListaDetalles.hasMoreTokens()) {
                      stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"#");
        
                      oidTipoCajaSublinea = stkRegDetalle.nextToken();
                      traza("oidTipoCajaSublinea" + oidTipoCajaSublinea);
                      
                      dtoTipoCajaSublinea = new DTOTipoCajaSublinea();

                      tipoCaja = stkRegDetalle.nextToken();
                      traza("tipoCaja" + tipoCaja);
                      dtoTipoCajaProducto = new DTOTipoCajaProducto();
                      dtoTipoCajaProducto.setOid(Long.valueOf(tipoCaja));
                      dtoTipoCajaSublinea.setTipoCajaProducto(dtoTipoCajaProducto);
                      
                      capacidadAnaquel = stkRegDetalle.nextToken();
                      traza("capacidadAnaquel" + capacidadAnaquel);
                      dtoTipoCajaSublinea.setNumCaja(Long.valueOf(capacidadAnaquel));
                      
                      oidEliminado = stkRegDetalle.nextToken();
                      traza("oidEliminado" + oidEliminado);
                      dtoTipoCajaSublinea.setOid(oidEliminado.equals("BLANCO")?null:Long.valueOf(oidEliminado));                      
                      
                      traza("dtoTipoCajaSublinea: " + dtoTipoCajaSublinea);            
                      detalleTiposCajasSublinea.add(dtoTipoCajaSublinea);
                    }
                }          
                
                traza("detalleTiposCajasSublinea: " + detalleTiposCajasSublinea);
                dtoSublineaArmado.setTipoCajaSublineas(detalleTiposCajasSublinea);
                traza("dtoSublineaArmado.setTipoCajaSublineas: " + dtoSublineaArmado.getTipoCajaSublineas());
                traza("*** Salida - LPMantenimientoSublineaArmado.crearDTOSublinea() ***");
                return dtoSublineaArmado;
         }
         
         private DTOOIDs armarDetallesEliminados(String detallesEliminados) throws Exception{
              DTOOIDs oidsDetallesEliminados = null;
              traza("detallesEliminados: " + detallesEliminados);
              
              if(!detallesEliminados.equals("")){
                  oidsDetallesEliminados = new DTOOIDs();
                  StringTokenizer stkDetallesEliminados = new StringTokenizer(detallesEliminados,",");
                  
                  Long[] oids = new Long[stkDetallesEliminados.countTokens()];
                  int k = 0;
                  
                  while (stkDetallesEliminados.hasMoreTokens()) {
                    oids[k] = Long.valueOf(stkDetallesEliminados.nextToken());
                    k++;
                  }  
                  oidsDetallesEliminados.setOids(oids);          
              }
              traza("oidsDetallesEliminados: " + oidsDetallesEliminados);
              return oidsDetallesEliminados;
         }
    /**
     * Limpieza de descripciones internacionalizables en blanco. Quitamos los
     * dto de los idiomas que no tienen una descripcion para que no se
     * inserte en blanco ya que sino no funciona la recuperacion de la
     * descripcion por defecto cuando no se guardo una alternativa.
     */
    private Vector quitarTraduccionesEnBlanco(Vector traducciones) throws Exception {
            ArrayList traduccionesEnBlanco = new ArrayList();
            traza(" traducciones antes_" + traducciones);
            
            Iterator iter = traducciones.iterator();
            
            while (iter.hasNext()) {
                DTOI18nSICC i18n = (DTOI18nSICC) iter.next();
                String descripcionI18n = (String)i18n.getValorI18n();
                
                if (descripcionI18n == null || descripcionI18n.equals(" ")) {
                    traduccionesEnBlanco.add(i18n);
                }
            }
            traducciones.removeAll(traduccionesEnBlanco);
            traza(" traducciones despues_" + traducciones);
            return traducciones;
    }
    
    

     private void logStackTrace(Throwable e) throws Exception {
                       traza("Se produjo la excepcion: " + e.getMessage());		
                       ByteArrayOutputStream baos = new ByteArrayOutputStream();
                       PrintStream ps = new PrintStream(baos);
                       e.printStackTrace(ps);		
                       traza("Stack Trace: " + baos.toString());
     }    

 /*
     private String getDescripcionI18N(Vector vec, Long idioma) throws Exception {
        Iterator iter = vec.iterator();

        while (iter.hasNext()) {
            DTOI18nSICC dtoI18 = (DTOI18nSICC)iter.next();
            
            if (dtoI18.getOidIdioma().equals(idioma)) {
                return dtoI18.getValorI18n();
            }
        }
        return "";
    } 
   
*/  

}

