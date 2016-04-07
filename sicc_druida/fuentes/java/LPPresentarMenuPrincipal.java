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
 * $Id: LPPresentarMenuPrincipal.java,v 1.1 2009/12/03 18:38:26 pecbazalar Exp $
 */

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

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

public class LPPresentarMenuPrincipal extends LPSICCBase{
   private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService";
   private int nextRow = 1;

   public LPPresentarMenuPrincipal(){
      super();
   }

   public void inicio() throws Exception{
      pagina("menu_usuario");
   }

   public void ejecucion() throws Exception{
      setTrazaFichero();
	  	//traza("### Entrar a LPPresentarMenuPrincipal");
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

						String usuario = (String)conectorParametroSesion("DruidaUsuario");
						String contrasenia = (String)conectorParametroSesion("DruidaPassword");
						dtoe2.setUsuario(usuario);
						dtoe2.setPassword(contrasenia);
						
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
						/*				  
						traza("###################################################");
						traza(dto.getResultado());
						traza("###################################################!");
						*/
					DruidaDOMObjeto d = crearArbol(dto.getResultado());
                  asignar("FORMULARIO", "frmSalida", d);

				 //traza(this.getXML().getDocumentElement());
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
      element4.setAttribute("nombre", extenderLongitudCodigo("root", 12));
      element4.setAttribute("icono", "");
      element4.setAttribute("codigo", extenderLongitudCodigo("root", 12));
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
            element.setAttribute("nombre", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12)); 
            element.setAttribute("codigo", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
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
               element.setAttribute("nombre", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
               element.setAttribute("codigo", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
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
               element.setAttribute("nombre", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
               element.setAttribute("icono", "2");
               element.setAttribute("codigo", extenderLongitudCodigo(((BigDecimal)fila.elementAt(0)).toString(), 12));
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


	private String extenderLongitudCodigo(String codigo, int cantidad) {
		String salida = "";
		for (int i = 0 ; i < (cantidad - codigo.length()); i ++) {
			salida = salida.concat("0");
		}
		salida = salida.concat(codigo);
		return salida;
	}

}
