/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.text.SimpleDateFormat;
import java.util.Vector;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.fac.DTOTiposImpuestosUbigeo;
import es.indra.sicc.dtos.mae.DTOCombosImpuestos;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOCargaInicialTerritorios;
import java.sql.SQLException;
import es.indra.mare.common.exception.MareException;
import java.lang.reflect.InvocationTargetException;

public class LPMantenimientoTiposImpuestosPorUbigeo extends LPSICCBase {
     
          
         private String accion = null;
         private String casoDeUso;
         private String opcionMenu;		 
         
         private Long pais;
         private Long idioma;

		// Definicion del constructor
		public LPMantenimientoTiposImpuestosPorUbigeo() {
			super();
		}

         public void inicio() throws Exception {}
  
		/**
		* @author Emilio Noziglia
		* @date 15/08/2007
		* @throws Exception
		* 
		*/
		public void ejecucion() throws Exception {
			
			setTrazaFichero();

			traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - ejecucion ***");

			accion = conectorParametro("accion");
			accion = (accion == null) ? "" : accion;
			casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

			traza("*** Accion:"+accion);

			idioma = UtilidadesSession.getIdioma(this);
			pais = UtilidadesSession.getPais(this); 

			try {

				if (accion.equalsIgnoreCase("") 
					&& casoDeUso.equalsIgnoreCase("insertar")) {
					 traza("*** A insertar ***");
					 insertar();
				} else if (accion.equalsIgnoreCase("") 
					&& casoDeUso.equalsIgnoreCase("consultar")) {
					cargaPGConsulta();
					consultar();
				} else if (accion.equalsIgnoreCase("") 
					&& casoDeUso.equalsIgnoreCase("eliminar")) {
					cargaPGConsulta();
					tituloEliminar();
				} else if (accion.equalsIgnoreCase("") 
					&& casoDeUso.equalsIgnoreCase("modificar")) {
					cargaPGConsulta();
					tituloModificar();
				} else if (accion.equalsIgnoreCase("modificar")) {
					cargaPGModificar();
				} else if (accion.equalsIgnoreCase("guardarModificar")) {
					traza("*** A guardar modificacion ***");
					guardar(true);
				} else if (accion.equalsIgnoreCase("guardar")) {
				    traza("*** A guardar ***");
					guardar(false);
				}

			} catch (Exception ex)  {
				logStackTrace(ex);
				lanzarPaginaError(ex);
			}

			traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - ejecucion ***");
		}

         /**
          * @author Emilio Noziglia
          * @date 15/08/2007
          * @throws Exception
          */  

         private void tituloEliminar() throws Exception {
                  traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - tituloEliminar ***");
                  
                  getConfiguracionMenu(getClass().getName(), "eliminar");                  
                  asignarAtributoPagina("cod", "0399");

                  traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - tituloEliminar ***");                
         }


		/**
		 * @author Emilio Noziglia
		 * @date 04/09/2007
         * @throws Exception
         */

         private void cargaPGModificar() throws Exception {
					traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - cargaPGModificar ***");

					pagina("contenido_tip_imp_ubigeo_insertar");

					getConfiguracionMenu(getClass().getName(), "modificar"); 
					asignarAtributoPagina("cod", "0398");

					this.getFormatosValidaciones();
						   
					asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
					asignarAtributo("VAR", "idioma", "valor", idioma.toString());
					asignarAtributo("VAR", "pais", "valor", pais.toString());
					asignarAtributo("VAR", "casoDeUso", "valor", "modificar");

					DTOBelcorp dto = new DTOBelcorp();				 
					dto.setOidPais(pais);
					dto.setOidIdioma(idioma);

					MareBusinessID id = new MareBusinessID("FACBuscarCbTiposImpuestosUbigeo");
					Vector parametros = new Vector();
					parametros.add(dto);
					parametros.add(id);
					  
					DTOCombosImpuestos dtoCbImp = (DTOCombosImpuestos) conectar("ConectorBuscarTiposImpuestosPorUbigeo",parametros).objeto("DTOCombosImpuestos"); 


					RecordSet rsIndImp = (RecordSet)dtoCbImp.getTasasImpuestos();

					Vector colIndImp = rsIndImp.getColumnIdentifiers();
					DruidaConector indImp = generarConector("DTOSalida.indImpuestos_ROWSET",rsIndImp, colIndImp);
					traza("indicadoresImpuestos "+rsIndImp);
					traza("indicadoresImpuestos "+rsIndImp.getColumnIdentifiers());
					asignar("COMBO", "cbIndImpuesto", indImp, "DTOSalida.indImpuestos_ROWSET");  

					MareBusinessID bid = new MareBusinessID("MAECargaInicialTerritorios");
					Vector paramEntrada = new Vector();
					DTOBelcorp dtoe = new DTOBelcorp();
					dtoe.setOidPais(pais);
					dtoe.setOidIdioma(idioma);
					paramEntrada.addElement(dtoe); 
					paramEntrada.addElement(bid);
					traza("conectando a ConectorCargaInicialTerritorios");
					DruidaConector conector = conectar("ConectorCargaInicialTerritorios",paramEntrada);
					traza("esta conectado a ConectorCargaInicialTerritorios");
					DTOCargaInicialTerritorios dtos = (DTOCargaInicialTerritorios) conector.objeto("dtoSalida");            
					String lbls = "";
					traza("Niveles: " + dtos.getNiveles().get(0).toString());
					for(int i = 0;i < dtos.getNiveles().size();i++) {                 
						 lbls += ((i == 0)?"":"_") + (dtos.getNiveles()).get(i).toString();                 
						 asignarAtributo("CAPA", "capaCombo" + (i+1), "visibilidad", "V");                                  
					}   

					asignarAtributo("VAR", "hidComboLabels", "valor", lbls);

					traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - cargaPGModificar ***");             
         } 

		/**
		 * @author Emilio Noziglia
		 * @date 15/08/2007
         * @throws Exception
         */

         private void insertar() throws Exception {
					traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - insertar ***");

					pagina("contenido_tip_imp_ubigeo_insertar");

					getConfiguracionMenu(getClass().getName(), "insertar"); 
					asignarAtributoPagina("cod", "0310");

					this.getFormatosValidaciones();
						   
					asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
					asignarAtributo("VAR", "idioma", "valor", idioma.toString());
					asignarAtributo("VAR", "pais", "valor", pais.toString());
					asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);

					DTOBelcorp dto = new DTOBelcorp();				 
					dto.setOidPais(pais);
					dto.setOidIdioma(idioma);

					MareBusinessID id = new MareBusinessID("FACBuscarCbTiposImpuestosUbigeo");
					Vector parametros = new Vector();
					parametros.add(dto);
					parametros.add(id);
					  
					DTOCombosImpuestos dtoCbImp = (DTOCombosImpuestos) conectar("ConectorBuscarTiposImpuestosPorUbigeo",parametros).objeto("DTOCombosImpuestos"); 


					RecordSet rsIndImp = (RecordSet)dtoCbImp.getTasasImpuestos();

					Vector colIndImp = rsIndImp.getColumnIdentifiers();
					DruidaConector indImp = generarConector("DTOSalida.indImpuestos_ROWSET",rsIndImp, colIndImp);
					traza("indicadoresImpuestos "+rsIndImp);
					traza("indicadoresImpuestos "+rsIndImp.getColumnIdentifiers());
					asignar("COMBO", "cbIndImpuesto", indImp, "DTOSalida.indImpuestos_ROWSET");  


					RecordSet rsCanales = (RecordSet)dtoCbImp.getCanales();
					Vector colCanales = rsCanales.getColumnIdentifiers();
					DruidaConector canales = generarConector("DTOSalida.canales_ROWSET",rsCanales, colCanales);
					traza("canales "+rsCanales);
					traza("canales "+rsCanales.getColumnIdentifiers());
					asignar("COMBO", "cbCanal", canales, "DTOSalida.canales_ROWSET");  


					RecordSet rsAccesos = (RecordSet)dtoCbImp.getAccesos();

					RecordSet rsSubaccesos = (RecordSet)dtoCbImp.getSubaccesos();


					DruidaConector conAcceso = generaConector(rsAccesos, "dtoSalida",
						  "VAL_OID", "VAL_I18N", "CANA_OID_CANA", null, null, null);

					asignar("COMBO", "lstAcceso", conAcceso, "dtoSalida");

					DruidaConector conSubacceso = generaConector(rsSubaccesos, "dtoSalida",
						  "VAL_OID", "VAL_I18N", "OID_ACCE", "CANA_OID_CANA", null, null);

					asignar("COMBO", "lstSubacceso", conSubacceso, "dtoSalida");


					MareBusinessID bid = new MareBusinessID("MAECargaInicialTerritorios");
					Vector paramEntrada = new Vector();
					DTOBelcorp dtoe = new DTOBelcorp();
					dtoe.setOidPais(pais);
					dtoe.setOidIdioma(idioma);
					paramEntrada.addElement(dtoe); 
					paramEntrada.addElement(bid);
					traza("conectando a ConectorCargaInicialTerritorios");
					DruidaConector conector = conectar("ConectorCargaInicialTerritorios",paramEntrada);
					traza("esta conectado a ConectorCargaInicialTerritorios");
					DTOCargaInicialTerritorios dtos = (DTOCargaInicialTerritorios) conector.objeto("dtoSalida");            
					String lbls = "";
					traza("Niveles: " + dtos.getNiveles().get(0).toString());
					for(int i = 0;i < dtos.getNiveles().size();i++) {                 
						 lbls += ((i == 0)?"":"_") + (dtos.getNiveles()).get(i).toString();                 
						 asignarAtributo("CAPA", "capaCombo" + (i+1), "visibilidad", "V");                                  
					}   

					asignarAtributo("VAR", "hidComboLabels", "valor", lbls);

					traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - insertar ***");             
         } 

		  private DruidaConector generarConector(String rowsetID, RecordSet datos,
				   Vector columns) throws DOMException, Exception {
				   StringBuffer salida = new StringBuffer();

				   int sizeColums = datos.getColumnCount();
				   int sizeRows = datos.getRowCount();

				   if (columns == null) {
						columns = new Vector();
				   }

				   Vector columsDesc = datos.getColumnIdentifiers();

				   DruidaConector conectorValoresPosibles = new DruidaConector();
				   XMLDocument xmlDoc = new XMLDocument();
				   Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
				   Element e_rows = docDestino.createElement("ROWSET");
				   e_rows.setAttribute("ID", rowsetID);
				   docDestino.getDocumentElement().appendChild(e_rows);

				   for (int i = 0; i < sizeRows; i++) {
						Element e_row = docDestino.createElement("ROW");
						e_rows.appendChild(e_row);

						for (int j = 0; j < sizeColums; j++) {
							  if (columns.contains(columsDesc.elementAt(j))) {
									Element e_campo2 = docDestino.createElement("CAMPO");
									e_campo2.setAttribute("NOMBRE",
										  columsDesc.elementAt(j).toString());
									e_campo2.setAttribute("TIPO", "OBJECTO");
									e_campo2.setAttribute("LONGITUD", "50");

									Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
												 ? "" : datos.getValueAt(i, j).toString()));
									e_campo2.appendChild(txt);
									e_row.appendChild(e_campo2);
							  }
						}
				   }

				   conectorValoresPosibles.setXML(docDestino.getDocumentElement());

				   return conectorValoresPosibles;
			}

 
			private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
				 String campoNom, String campoF, String campoG, String campoH, String campoI) throws Exception {
				 XMLDocument xmlDoc = new XMLDocument();
				 Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

				 String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);

				 Element e_rows = docDestino.createElement("ROWSET");
				 e_rows.setAttribute("ID", ID_Rows);
				 docDestino.getDocumentElement().appendChild(e_rows);

				 for (int i = 0; i < rs.getRowCount(); i++) {
					 Element e_row = docDestino.createElement("ROW");
					 e_rows.appendChild(e_row);

					 Element e_campo1 = docDestino.createElement("CAMPO");
					 e_campo1.setAttribute("NOMBRE", campoCod);
					 e_campo1.setAttribute("TIPO", "OBJECTO");
					 e_campo1.setAttribute("LONGITUD", "50");

					 Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? ""
																											  : rs.getValueAt(
								   i, campoCod).toString()));
					 e_campo1.appendChild(txtCod);
					 e_row.appendChild(e_campo1);

					 Element e_campo2 = docDestino.createElement("CAMPO");
					 e_campo2.setAttribute("NOMBRE", campoNom);
					 e_campo2.setAttribute("TIPO", "OBJECTO");
					 e_campo2.setAttribute("LONGITUD", "50");

					 Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? ""
																												: rs.getValueAt(
								   i, campoNom).toString()));
					 e_campo2.appendChild(txtDesc);
					 e_row.appendChild(e_campo2);

					 if (campoF != null) {
						  Element e_campo3 = docDestino.createElement("CAMPO");
						  e_campo3.setAttribute("NOMBRE", campoF);
						  e_campo3.setAttribute("TIPO", "OBJECTO");
						  e_campo3.setAttribute("LONGITUD", "50");

						  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? ""
																											  : rs.getValueAt(
										i, campoF).toString()));
						  e_campo3.appendChild(txtF);
						  e_row.appendChild(e_campo3);
					 }
					 if (campoG != null) {
						  Element e_campo4 = docDestino.createElement("CAMPO");
						  e_campo4.setAttribute("NOMBRE", campoG);
						  e_campo4.setAttribute("TIPO", "OBJECTO");
						  e_campo4.setAttribute("LONGITUD", "50");

						  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoG) == null) ? ""
																											  : rs.getValueAt(
										i, campoG).toString()));
						  e_campo4.appendChild(txtF);
						  e_row.appendChild(e_campo4);
					 }  
					 if (campoH != null) {
						  Element e_campo5 = docDestino.createElement("CAMPO");
						  e_campo5.setAttribute("NOMBRE", campoG);
						  e_campo5.setAttribute("TIPO", "OBJECTO");
						  e_campo5.setAttribute("LONGITUD", "50");

						  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoH) == null) ? ""
																											  : rs.getValueAt(
										i, campoH).toString()));
						  e_campo5.appendChild(txtF);
						  e_row.appendChild(e_campo5);
					 }        
					 if (campoI != null) {
						  Element e_campo6 = docDestino.createElement("CAMPO");
						  e_campo6.setAttribute("NOMBRE", campoI);
						  e_campo6.setAttribute("TIPO", "OBJECTO");
						  e_campo6.setAttribute("LONGITUD", "50");

						  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoI) == null) ? ""
																											  : rs.getValueAt(
										i, campoI).toString()));
						  e_campo6.appendChild(txtF);
						  e_row.appendChild(e_campo6);
					 }               
				 }

				 DruidaConector conect = new DruidaConector();
				 conect.setXML(docDestino.getDocumentElement());

				 return conect;
			} 

         /**
          * @author Emilio Noziglia
          * @date 15/08/2007
          * @throws Exception
          */  

         private void cargaPGConsulta() throws Exception {
                  traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - cargaPGConsulta ***");
                  
                  pagina("contenido_tip_imp_ubigeo_consultar");

				  this.getFormatosValidaciones();
                  
                  asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
                  asignarAtributo("VAR", "idioma", "valor", idioma.toString());
                  asignarAtributo("VAR", "pais", "valor", pais.toString());
                  asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);

                  traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - cargaPGConsulta ***");                
         }

         /**
          * @author Emilio Noziglia
          * @date 15/08/2007
          * @throws Exception
          */  

         private void consultar() throws Exception {
                  traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - consultar ***");
                  
                  getConfiguracionMenu(getClass().getName(), "consultar");                  
                  asignarAtributoPagina("cod", "0400");
				  
                  traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - consultar ***");                
         }

         /**
          * @author Emilio Noziglia
          * @date 15/08/2007
          * @throws Exception
          */  

         private void tituloModificar() throws Exception {
                  traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - tituloModificar ***");
                  
                  getConfiguracionMenu(getClass().getName(), "modificar");                  
				  asignarAtributoPagina("cod", "0398");
				  
                  traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - tituloModificar ***");                
         }

         /**
          * @author Emilio Nozigli
          * @date 15/08/2007
          * @throws Exception
          */
          
          private void guardar(boolean modificacion) throws Exception {
                traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - guardar ***");

                pagina("salidaGenerica");

                asignar("VAR", "ejecutar", "guardarCorrecto()");
                asignar("VAR", "ejecutarError", "guardarError()");
                
                DTOTiposImpuestosUbigeo  dto = crearDTOTiposImpuestosUbigeo(modificacion);

                MareBusinessID id = new MareBusinessID("FACGuardarTiposImpuestosUbigeo");
                Vector parameters = new Vector();
                parameters.add(dto);
                parameters.add(id);

                DruidaConector conector = conectar("ConectorGuardarTiposImpuestosUbigeo", parameters);                     

                traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - guardar ***");
          }
         
         /**
          * @author Emilio Noziglia
          * @date 15/08/2007
          * @throws Exception
          */
          private DTOTiposImpuestosUbigeo crearDTOTiposImpuestosUbigeo(boolean modificacion) throws Exception {
				traza("*** Entrada - LPMantenimientoTiposImpuestosPorUbigeo - crearDTOTiposImpuestosUbigeo ***");

                DTOTiposImpuestosUbigeo dto = new DTOTiposImpuestosUbigeo();

				String indicadorImpuesto = conectorParametroLimpia("cbIndImpuesto", "", true);

				if (modificacion) {
					String oidTipoImpUbigeo = conectorParametroLimpia("hidOidTipoImp", "", true);
					dto.setOidTipoImpuestoUbigeo(new Long(oidTipoImpUbigeo));
				} else {
					String canal = conectorParametroLimpia("cbCanal", "", true);
					String acceso = conectorParametroLimpia("cbAcceso", "", true);
					String subacceso = conectorParametroLimpia("cbSubacceso", "", true);
					String ubigeo = conectorParametroLimpia("txtUnidGeografica", "", true);

					String ng1 = conectorParametroLimpia("cbNivel1", "", true);
					String ng2 = conectorParametroLimpia("cbNivel2", "", true);
					String ng3 = conectorParametroLimpia("cbNivel3", "", true);
					String ng4 = conectorParametroLimpia("cbNivel4", "", true);
					String ng5 = conectorParametroLimpia("cbNivel5", "", true);
					String ng6 = conectorParametroLimpia("cbNivel6", "", true);
					String ng7 = conectorParametroLimpia("cbNivel7", "", true);
					String ng8 = conectorParametroLimpia("cbNivel8", "", true);
					String ng9 = conectorParametroLimpia("cbNivel9", "", true);

					dto.setCanal(new Long(canal));
					dto.setAcceso(new Long(acceso));
					dto.setSubacceso(new Long(subacceso));
					dto.setUbigeo(ubigeo);
					dto.setOidIdioma(idioma);
					dto.setOidPais(pais);
					if (ng9!=null&&!ng9.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng9));
					} else if (ng8!=null&&!ng8.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng8));
					} else if (ng7!=null&&!ng7.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng7));
					} else if (ng6!=null&&!ng6.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng6));
					} else if (ng5!=null&&!ng5.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng5));
					} else if (ng4!=null&&!ng4.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng4));
					} else if (ng3!=null&&!ng3.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng3));
					} else if (ng2!=null&&!ng2.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng2));
					} else if (ng1!=null&&!ng1.equals("")) {
						dto.setOidValEstruGeopo(new Long(ng1));
					}
				}
				dto.setModificacion(new Boolean(modificacion));
				dto.setIndicadorImpuesto(new Long(indicadorImpuesto));

                traza("*** dto : " + dto);                    
                traza("*** Salida - LPMantenimientoTiposImpuestosPorUbigeo - crearDTOTiposImpuestosUbigeo ***");                    
                return dto;
          }           

 
         /**
          * @author Emilio Noziglia
          * @date 15/08/2007
          * @throws Exception
          */		  
          private void logStackTrace(Throwable e) throws Exception {
              traza("Se produjo la excepción: " + e.getMessage());
    
              ByteArrayOutputStream out = new ByteArrayOutputStream();
              PrintStream print = new PrintStream(out);
              e.printStackTrace(print);
    
              traza("Stack Trace: " + out);
         }
}

