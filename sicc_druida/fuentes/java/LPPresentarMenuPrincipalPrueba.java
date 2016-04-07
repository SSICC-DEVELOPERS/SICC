/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * $Id: LPPresentarMenuPrincipalPrueba.java,v 1.1 2009/12/03 18:41:00 pecbazalar Exp $
 */

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.IMareService;
import es.indra.mare.common.mii.MareTopic;
import java.io.PrintStream;
import java.sql.*;
import java.util.Hashtable;
import java.util.Vector;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.configuration.Configuration;
import java.util.Vector;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


import es.indra.sicc.util.IVariablesSesion;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;

//MGU
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.*;

import java.rmi.RemoteException;
import java.math.BigDecimal;

// By Jalem - 26/1/2004  import es.indra.sicc.util.BelcorpError;

import es.indra.sicc.util.UtilidadesSession;

// By Jalem - 26/1/2004 import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LPPresentarMenuPrincipalPrueba extends LPSICCBase{
   private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService";
   private int nextRow = 1;

   public LPPresentarMenuPrincipalPrueba(){
      super();
   }

   public void inicio() throws Exception{
      pagina("menu_usuario");
   }

   public void ejecucion() throws Exception{
      setTrazaFichero();
      String idUsuario = "";
      MareCredentials credenciales = (MareCredentials)conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS);
      if(credenciales != null){
         MGUService mgu = (MGUService)MareMii.getService(
                 new MareTopic(NOMBRE_SERVICIO_MGUSERVICE, credenciales));
         try{
            if(mgu.authenticate()){

               if(credenciales.getUser() != null){
                  UserIDSICC oUsuario = (UserIDSICC)credenciales.getUser();
                  if(oUsuario.getSubstitutionUser() == null){
                     idUsuario = oUsuario.toString();
                  } else{
                     idUsuario = oUsuario.getSubstitutionUser().toString();
                  }

						DTOEntradaObtieneFuncion dtoe2 = new DTOEntradaObtieneFuncion();
						
						//traza("$$$ idUsuario: " + idUsuario);
						dtoe2.setIdUsuario(idUsuario);
						//traza( UtilidadesSession.getIdioma(this).toString() );
						dtoe2.setIdIdioma( UtilidadesSession.getIdioma(this) );


						//MareBusinessID id = new MareBusinessID("MENConsultaFuncionesMenu");
                  MareBusinessID id = new MareBusinessID("MENObtieneMenu");
                  Vector paramConsultarFunciones = new Vector();
                  paramConsultarFunciones.addElement(dtoe2);
                  paramConsultarFunciones.addElement(id);

                  DruidaConector Conectorejemplorejilla = conectar("ConectorConsultarFunciones", paramConsultarFunciones);
				  //traza("Conector Menu " + Conectorejemplorejilla.getXML());
                  DTOSalida dto = (DTOSalida)Conectorejemplorejilla.objeto("dtoSalida");

														  
						traza("################## RECORDSET #######################");
						traza(dto.getResultado());
						traza("################## RECORDSET #######################");


				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			traza("a");
				Properties props = new Properties();
				props.setProperty("user", "USU_PERU");
			traza("b");
				props.setProperty("password", "usu_peru");
			traza("c");
				Connection con = DriverManager.getConnection( 
				   "jdbc:oracle:thin:@192.168.118.100:1527:SICCV3D2", props);
			traza("d");
				Statement stmt = con.createStatement(); 
				ResultSet rs= null;
				StringBuffer buf = new StringBuffer();

            buf.append(" SELECT   oid_func, nom_func, val_nomb_prog, func_oid_func, ind_nive,  ");
            buf.append(" 				DECODE (NAME, NULL, 0, 1) AS habilitado, nivel ");
            buf.append("     FROM (SELECT     LEVEL - 1 AS nivel, oid_func, nom_func, val_nomb_prog, ");
            buf.append("                      ind_nive, func_oid_func, ");
            buf.append("                      SYS_CONNECT_BY_PATH (nom_func, '#') AS PATH ");
            buf.append("                 FROM (SELECT oid_func, val_i18n AS nom_func, val_nomb_prog, ");
            buf.append("                              ind_nive, func_oid_func ");
            buf.append("                         FROM men_funci, gen_i18n_sicc ");
            buf.append("                        WHERE attr_enti = 'MEN_FUNCI' ");
            buf.append("                          AND attr_num_atri = 1 ");
            buf.append("                          AND idio_oid_idio = 1 ");
            buf.append("                          AND val_oid = oid_func ");
            buf.append("                       UNION ALL ");
            buf.append("                       SELECT oid_func, val_i18n AS nom_func, val_nomb_prog, ");
            buf.append("                              ind_nive, func_oid_func ");
            buf.append("                         FROM men_funci a, gen_i18n_sicc b ");
            buf.append("                        WHERE attr_enti = 'MEN_FUNCI' ");
            buf.append("                          AND attr_num_atri = 1 ");
            buf.append("                          AND idio_oid_idio = 1 ");
            buf.append("                          AND val_oid = oid_func ");
            buf.append("                          AND NOT EXISTS ( ");
            buf.append("                                 SELECT 1 ");
            buf.append("                                   FROM men_funci c, gen_i18n_sicc d ");
            buf.append("                                  WHERE attr_enti = 'MEN_FUNCI' ");
            buf.append("                                    AND attr_num_atri = 1 ");
            buf.append("                                    AND idio_oid_idio = 1 ");
            buf.append("                                    AND val_oid = oid_func ");
            buf.append("                                    AND c.oid_func = a.oid_func) ");
            buf.append("                       UNION ");
            buf.append("                       SELECT oid_func, val_i18n AS nom_func, val_nomb_prog, ");
            buf.append("                              ind_nive, 2 ");
            buf.append("                         FROM men_favor, men_funci, gen_i18n_sicc ");
            buf.append("                        WHERE men_favor.func_oid_func = men_funci.oid_func ");
            buf.append("                          AND val_usua = 'usuario1' ");
            buf.append("                          AND attr_enti = 'MEN_FUNCI' ");
            buf.append("                          AND attr_num_atri = 1 ");
            buf.append("                          AND idio_oid_idio = 1 ");
            buf.append("                          AND val_oid = oid_func ");
            buf.append("                       UNION ALL ");
            buf.append("                       SELECT oid_func, val_i18n AS nom_func, val_nomb_prog, ");
            buf.append("                              ind_nive, 2 ");
            buf.append("                         FROM men_favor a, men_funci b, gen_i18n_sicc c ");
            buf.append("                        WHERE a.func_oid_func = b.oid_func ");
            buf.append("                          AND val_usua = 'usuario1' ");
            buf.append("                          AND attr_enti = 'MEN_FUNCI' ");
            buf.append("                          AND attr_num_atri = 1 ");
            buf.append("                          AND idio_oid_idio = 1 ");
            buf.append("                          AND val_oid = oid_func ");
            buf.append("                          AND NOT EXISTS ( ");
            buf.append("                                 SELECT oid_func, val_i18n AS nom_func, ");
            buf.append("                                        val_nomb_prog, ind_nive, 2 ");
            buf.append("                                   FROM men_favor a1, ");
            buf.append("                                        men_funci b1, ");
            buf.append("                                        gen_i18n_sicc c1 ");
            buf.append("                                  WHERE a1.func_oid_func = b1.oid_func ");
            buf.append("                                    AND val_usua = 'usuario1' ");
            buf.append("                                    AND attr_enti = 'MEN_FUNCI' ");
            buf.append("                                    AND attr_num_atri = 1 ");
            buf.append("                                    AND idio_oid_idio = 1 ");
            buf.append("                                    AND val_oid = oid_func ");
            buf.append("                                    AND b1.oid_func = b.oid_func)) ");
            buf.append("           CONNECT BY PRIOR oid_func = func_oid_func ");
            buf.append("           START WITH oid_func = 1), ");
            buf.append("          (SELECT DISTINCT (SELECT NAME ");
            buf.append("                              FROM principals ");
            buf.append("                             WHERE idprincipal = idrole) AS NAME ");
            buf.append("                      FROM memberof ");
            buf.append("                CONNECT BY PRIOR idrole = idmember ");
            buf.append("                START WITH idmember IN ( ");
            buf.append("                              SELECT idprincipal ");
            buf.append("                                FROM principals ");
            buf.append("                               WHERE NAME IN ( ");
            buf.append("                                        SELECT perfiles.NAME ");
            buf.append("                                          FROM memberof m, ");
            buf.append("                                               principals p, ");
            buf.append("                                               (SELECT p.idprincipal, p.NAME ");
            buf.append("                                                  FROM principals p, ");
            buf.append("                                                       principals p2, ");
            buf.append("                                                       memberof m ");
            buf.append("                                                 WHERE p2.NAME = 'PerfilesSICC' ");
            buf.append("                                                   AND m.idmember = ");
            buf.append("                                                                 p2.idprincipal ");
            buf.append("                                                   AND m.idrole = p.idprincipal) perfiles ");
            buf.append("                                         WHERE m.idrole = perfiles.idprincipal ");
            buf.append("                                           AND p.idprincipal = m.idmember ");
            buf.append("                                           AND p.NAME = 'usuario1') ");
            buf.append("                                                                   )) ");
            buf.append("    WHERE NAME = TO_CHAR (oid_func) ");
            buf.append(" ORDER BY PATH ");

			traza("e");
				rs = stmt.executeQuery(buf.toString());

				RecordSet recordSet = new RecordSet(rs);
				
					
						traza("################## RECORDSET RESULTSE#######################");
						traza(recordSet);
						traza("################## RECORDSET #######################");

//					DruidaDOMObjeto d = crearArbol(dto.getResultado());
					DruidaDOMObjeto d = crearArbol(recordSet);
                  asignar("FORMULARIO", "frmSalida", d);

						/*traza("################## PAGINA #######################");
						traza(this.getXML().getDocumentElement());
						traza("################## PAGINA #######################");*/

						//traza("Paso el asignar");
						//asignar("REJILLA", "salida", crearArbol(dto.getResultado()));
						
                  //DruidaConector ConectorejemplorejillaXSL = transformar("xslPresentarMenu4niveles", Conectorejemplorejilla);
						//traza("conector transaformado: "+ConectorejemplorejillaXSL.getXML());
                  //asignar("REJILLA", "salida", ConectorejemplorejillaXSL);
               }
            } else{
               //no deberia pasar
            }
         } catch(RemoteException re){

            traza("ERROR: " + re.toString());
            traza("********************************************************************************");
            traza("********************************************************************************");
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            re.printStackTrace(out);
            traza("EL STACK ES COMO SIGUE : " + pila.toString());
            traza("********************************************************************************");
            traza("********************************************************************************");

            if(re.detail instanceof MareMguInvalidCredentials){
               MareMguInvalidCredentials mgue =
                       (MareMguInvalidCredentials)re.detail;
               if(mgue.getCode() == MareMguInvalidCredentials.EXPIRED){
                  asignarAtributo("VAR", "validado", "valor", "E");
               } else{
                  asignarAtributo("VAR", "errCodigo", "valor", "" + mgue.getCode());
                  asignarAtributo("VAR", "errDescripcion", "valor", mgue.toString());
               }
            } else{
               if(re.detail instanceof MareMguAccessException){
                  asignarAtributo("VAR", "errCodigo", "valor", "");
                  asignarAtributo("VAR", "errDescripcion", "valor", "ERR_45");
               } else{
                  asignarAtributo("VAR", "errCodigo", "valor", "");
                  asignarAtributo("VAR", "errDescripcion", "valor", re.detail.toString());
               }
            }
         } catch(Exception e){
			// jalem cambie ha excepction (antes throwable)
            traza("ERROR: " + e.toString());
            traza("********************************************************************************");
            traza("********************************************************************************");
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            traza("EL STACK ES COMO SIGUE : " + pila.toString());
            traza("********************************************************************************");
            traza("********************************************************************************");
            
 
		   this.lanzarPaginaError(e);
			
			/* jalem 23/01/2004
			BelcorpError belcorpError = new BelcorpError();
            DTOError dtoError = belcorpError.obtenerError(e);
            asignarAtributo("VAR", "errCodigo", "valor", "" + dtoError.getCodigoError());
            asignarAtributo("VAR", "errDescripcion", "valor", dtoError.getDescripcionError());
			*/
         }
      }
   }


   private void traza(String param) throws Exception{
      System.out.println(param);
      super.traza(param);
   }




   private DruidaDOMObjeto crearArbol(RecordSet recordSet) throws Exception{

      DruidaDOMObjeto miObj = new DruidaDOMObjeto();
      Document document = getXML();

      Element element = document.createElement("ARBOL");
      element.setAttribute("x", "0");
      element.setAttribute("y", "0");
      element.setAttribute("nombre", "menu");
	  element.setAttribute("id", "menu");
      element.setAttribute("ancho", "256");
      element.setAttribute("alto", "");
      element.setAttribute("colorf", "#999999");
      element.setAttribute("visibilidad", "");
		element.setAttribute("incx", "5");
		element.setAttribute("incy", "5");
      element.setAttribute("altofila", "20");
		element.setAttribute("indentado", "10");
		element.setAttribute("imgFondo", "menunivel");
		//element.setAttribute("icorama", "si");

		Element element2 = document.createElement("ICONOS");
      element.appendChild(element2);

      Element element3_0 = document.createElement("ICONO");
      element3_0.setAttribute("src", "b.gif");
      element2.appendChild(element3_0);

      Element element3_1 = document.createElement("ICONO");
      element3_1.setAttribute("src", "flechaMenuVert.gif");
      element2.appendChild(element3_1);

      Element element3_2 = document.createElement("ICONO");
      element3_2.setAttribute("src", "flechaMenuHorz.gif");
      element2.appendChild(element3_2);

      Element element4 = document.createElement("RAMA");
      element4.setAttribute("nombre", "root");
      element4.setAttribute("icono", "");
      element4.setAttribute("codigo", "root");
      element4.setAttribute("texto", "BELCORP");
      element.appendChild(element4);

      crearHijos(element4, document, recordSet);

      miObj.setXML(element);

		//traza("Elemento: "+element);

      return miObj;
   }

   private void crearHijos(Element padre, Document document, RecordSet recordSet) throws Exception{
      Element element;


      Vector filaSig, fila = recordSet.getRow(nextRow);


      int levelOriginal = ((BigDecimal)fila.elementAt(6)).intValue();
        while((levelOriginal == ((BigDecimal)fila.elementAt(6)).intValue()) && (nextRow < recordSet.getRowCount())){
        ++nextRow;
         if(nextRow == recordSet.getRowCount()){
            element = document.createElement("HOJA");
            element.setAttribute("nombre", ((BigDecimal)fila.elementAt(0)).toString()); 
            element.setAttribute("codigo", ((BigDecimal)fila.elementAt(0)).toString());
            element.setAttribute("texto", (String)fila.elementAt(1));
            if(((BigDecimal)fila.elementAt(5)).intValue() == 1 && ((String)fila.elementAt(4)).equals("1")){
					element.setAttribute("icono", "0");
               element.setAttribute("onclick", "callMenu(\\'" + (String)fila.elementAt(2) + "&idFuncion=" +
                       ((BigDecimal)fila.elementAt(0)).toString() + "\\');");
            } else{
					element.setAttribute("icono", "2");
               element.setAttribute("onclick", "");
            }
            padre.appendChild(element);
         }else{
            filaSig = recordSet.getRow(nextRow);
            if(((BigDecimal)filaSig.elementAt(6)).intValue() <= levelOriginal){
               // HOJA
               element = document.createElement("HOJA");
               element.setAttribute("nombre", ((BigDecimal)fila.elementAt(0)).toString());
               element.setAttribute("codigo", ((BigDecimal)fila.elementAt(0)).toString());
               element.setAttribute("texto", (String)fila.elementAt(1));
               if(((BigDecimal)fila.elementAt(5)).intValue() == 1 && ((String)fila.elementAt(4)).equals("1")){
				  element.setAttribute("icono", "0");
                  element.setAttribute("onclick", "callMenu(\\'" + (String)fila.elementAt(2) + "&idFuncion=" +
                          ((BigDecimal)fila.elementAt(0)).toString() + "\\');");
               } else{
						element.setAttribute("icono", "2");
                        element.setAttribute("onclick", "");
               }
            } else{
               // NIVEL INTERMEDIO
               element = document.createElement("RAMA");
               element.setAttribute("nombre", ((BigDecimal)fila.elementAt(0)).toString());
               element.setAttribute("icono", "2");
               element.setAttribute("codigo", ((BigDecimal)fila.elementAt(0)).toString());
               element.setAttribute("texto", (String)fila.elementAt(1));
               element.setAttribute("onclick", "true");
               /*if(((BigDecimal)fila.elementAt(0)).intValue() == 656){
                  System.out.println("");					//	ESTO NO ESTABA COMENTADO!!!!!
               }*/							
               crearHijos(element, document, recordSet);
            }

            padre.appendChild(element);
            if(nextRow < recordSet.getRowCount()){
               fila = recordSet.getRow(nextRow);
            }
         }
      }
   }

}
