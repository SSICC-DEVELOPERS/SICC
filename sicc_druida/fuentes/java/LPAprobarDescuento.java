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
 */
 /*
    INDRA/CAR/PROY
    $Id: LPAprobarDescuento.java,v 1.1 2009/12/03 18:40:33 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:         
 * Componente:        LPAprobarDescuento.java
 * Fecha:             05/08/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * @version           1.0
 * @autor             Andrés Pollitzer
 */


import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTOAprobarDescuento;
import es.indra.sicc.dtos.dto.DTOAprobacionDescuento;
import java.util.ArrayList;
import es.indra.druida.DruidaConector;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;


public class LPAprobarDescuento extends LPSICCBase {

  String accion;

  String oidDescuentoSel;
  String oidDescuentoSeleccionado;
  String aprobar;


	public LPAprobarDescuento ()  {
      super();
  }

  public void inicio() throws Exception  {

  }

  public void ejecucion() throws Exception  {
    try{
        setTrazaFichero();

      accion = conectorParametroLimpia("accion","",true);

      oidDescuentoSel = conectorParametroLimpia("oidDtoSel","",true);
      oidDescuentoSeleccionado = conectorParametroLimpia("hOidDescuentoSel","",true);
      

        traza(" ");
        traza("********************************************************");
        traza("******* ejecucion() LPAprobarDescuento ********");
        traza("********************************************************");
        traza("accion : "               + accion);

        traza("oidDescuentoSel : "            + oidDescuentoSel);
        traza("oidDescuentoSeleccionado : "   + oidDescuentoSeleccionado);
        

//accion == "" ---------------------------------------------------------------------------
      if (accion.equals(""))  {
          traza("Entra en accion vacia");
        cargarPagina();
        getConfiguracionMenu("LPAprobarDescuento","");
          traza("Sale de accion vacia");
      }
//accion == "guardar" ---------------------------------------------------------------------------
      else if (accion.equals("guardar"))  {
          traza("Entra en accion guardar");
        guardar();
        getConfiguracionMenu("LPAprobarDescuento","guardar");
          traza("Sale de accion guardar");
      }
      asignarAtributo("VAR","accion","valor",accion);

    } catch (Exception e) {
        lanzarPaginaError(e);

     }

  }//fin ejecucion();


//-----------------------------------------------------------------------------------------------------------------------------
  private void cargarPagina() throws Exception  {
    pagina("contenido_matriz_aprobar");
    //-> Tomar del request el valor del parámetro oidDescuento y crear con él un DTOOID
    DTOOID dtoOID = new DTOOID();
    dtoOID.setOid( Long.valueOf(oidDescuentoSel) );
    UtilidadesSession sesion = new UtilidadesSession();
    dtoOID.setOidIdioma( sesion.getIdioma(this) );
    Vector objBusiness = new Vector();
    objBusiness.add(dtoOID);
    //-> Crear idBusiness = "DTOCargarAprobarDescuento" 
    objBusiness.add( new MareBusinessID("DTOCargarAprobarDescuento") );
      traza("cargarPagina() objBusiness: " + objBusiness);
    //-> Asignar conector "ConectorCargarAprobarDescuento" con idBusiness y dto creados 
    DruidaConector con = conectar("ConectorCargarAprobarDescuento",objBusiness);
      traza("con.getXML(): " + con.getXML() );
    //-> Recuperar DTOAprobarDescuento y mapearlo en la pantalla, el arributo
    //listaTiposCliente se mapea en la lista editable "listaTiposCliente"
    DTOAprobarDescuento dtoAprobarDescOut = (DTOAprobarDescuento) con.objeto("DTOAprobarDescuento");
      traza("01: " + dtoAprobarDescOut.getDescripcionDescuento() );
    asignarAtributo("LABELC","lbldtDescripcion","valor",dtoAprobarDescOut.getDescripcionDescuento());
      traza("02: " + dtoAprobarDescOut.getDescripcionPeriodoDesde() );
    asignarAtributo("LABELC","lbldtPeriodoDesde","valor",dtoAprobarDescOut.getDescripcionPeriodoDesde());
      traza("03: " + dtoAprobarDescOut.getDescripcionPeriodoHasta() );
    if ( dtoAprobarDescOut.getDescripcionPeriodoHasta() == null )  {
      asignarAtributo("LABELC","lbldtPeriodoHasta","valor","");
    }
    else  {
      asignarAtributo("LABELC","lbldtPeriodoHasta","valor",dtoAprobarDescOut.getDescripcionPeriodoHasta());
    }
      traza("04: " + dtoAprobarDescOut.getIndicadorActivo().toString() );
    asignarAtributo("VAR","hLbldtIndicadorActiva","valor",dtoAprobarDescOut.getIndicadorActivo().toString());
    ArrayList al = dtoAprobarDescOut.getListaTiposCliente();
          traza("05: " + al.toString() );
    DruidaConector conector = generarConector(al);
      traza("conector: " + conector.getXML() );
    asignar("LISTADOA","listado1",conector,"resultado");
    asignarAtributo("VAR","hOidDescuentoSel","valor",oidDescuentoSel);
  }
//-----------------------------------------------------------------------------------------------------------------------------
  private void guardar() throws Exception  {
    try  {
      pagina("salidaGenerica"); //ya que se realiza en modo oculto
      //-> Tomar de pantalla el valor del campo "aprobar", si = true y no = false, y
      //el campo oidDescuento oculto
      aprobar = conectorParametroLimpia("rbAprobar","",true);
        traza("aprobar: " + aprobar );
      //-> Crear objeto DTOAprobacionDescuento y guardar los valores obtenidos
      DTOAprobacionDescuento dtoAprobacionDto = new DTOAprobacionDescuento();
      dtoAprobacionDto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoAprobacionDto.setPrograma(UtilidadesSession.getFuncion(this));
      dtoAprobacionDto.setOidDescuento(Long.valueOf(oidDescuentoSeleccionado));
      if ( aprobar.equals("S") ) dtoAprobacionDto.setAprobado( Boolean.TRUE ); //Nota: corresponde al valor del campo IND_APRO en la tabla DTO_DESCU
      else dtoAprobacionDto.setAprobado(Boolean.FALSE);
      Vector objBusiness = new Vector();
      objBusiness.add ( dtoAprobacionDto );
      //-> Crear idBusiness = "DTOAprobarDescuento"
      objBusiness.add( new MareBusinessID("DTOAprobarDescuento") );
        traza("guardar() objBusiness: " + objBusiness);
      //-> Asignar conector "ConectorAprobarDescuento" con idBusiness y dto creados
      DruidaConector con = conectar("ConectorAprobarDescuento",objBusiness);
      //-> Mostrar mensaje con el código "GEN-0206"
      asignarAtributo("VAR","ejecutar", "valor", "fPostGuardar()");
    } catch (Exception e)  {
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");
        throw e;
      }

    //-> Ir a la página principal de la aplicación (igual que si se pulsase el botón salir)
    //i7396 Se refiere a la pantalla de inicio. No está especificado que se reinicie el caso de uso,
    //por tanto no hay que reiniciarlo.


  }
//-----------------------------------------------------------------------------------------------------------------------------
  private DruidaConector generarConector(ArrayList al) throws Exception {
      traza("Entra en generarConector");
    DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document docDestino = docBuilder.newDocument();
    Element rowset2 = docDestino.createElement("ROWSET2");
  
    Element rowset = docDestino.createElement("ROWSET");
    rowset.setAttribute("ID", "resultado");
    rowset2.appendChild(rowset);
 
    for (int i = 0; i < al.size(); i++) {
      Element elemRow = docDestino.createElement("ROW");
      rowset.appendChild(elemRow);
 
      Element elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "Ident");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      Text txt = docDestino.createTextNode(i+"");
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

      elemDato = docDestino.createElement("CAMPO");
      elemDato.setAttribute("NOMBRE", "DESC_TIPO_CLIE");
      elemDato.setAttribute("TIPO", "STRING");
      elemDato.setAttribute("LONGITUD", "50");
      String dato = al.get(i) == null ? "" : (String)al.get(i);
      txt = docDestino.createTextNode(dato);
      elemDato.appendChild(txt);
      elemRow.appendChild(elemDato);

    }
    DruidaConector conectorLista = new DruidaConector();
    conectorLista.setXML(rowset2);
      traza("Sale de generarConector");
    return conectorLista;
  }



}//fin clase

/*****************************************************************************************************************
Class LPAprobarDescuento {Java}
*******************************

Operation --Not Named-- ejecucion (), in Class LPAprobarDescuento

Documentation
Si acción = "" entonces 
-> ejecutar método privado "cargarPagina" 
Si no Si acción = "guardar" entonces 
-> ejecutar método privado "guardar" 
Fin Si
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- cargarPagina (), in Class LPAprobarDescuento

Documentation
-> Asignar página "contenido_matriz_aprobar" 
-> Tomar del request el valor del parámetro oidDescuento y crear con él un DTOOID
-> Crear idBusiness = "DTOCargarAprobarDescuento" 
-> Asignar conector "ConectorCargarAprobarDescuento" con idBusiness y dto creados 
-> Recuperar DTOAprobarDescuento y mapearlo en la pantalla, el arributo listaTiposCliente se mapea en la lista editable "listaTiposCliente"
-----------------------------------------------------------------------------------------------------------------------------

Operation --Not Named-- guardar (), in Class LPAprobarDescuento

Documentation
-> Tomar de pantalla el valor del campo "aprobar", si = true y no = false, y el campo oidDescuento oculto 
-> Crear objeto DTOAprobacionDescuento y guardar los valores obtenidos 
-> Crear idBusiness = "DTOAprobarDescuento" 
-> Asignar conector "ConectorAprobarDescuento" con idBusiness y dto creados 
-> Mostrar mensaje con el código "GEN-0206" 
-> Ir a la página principal de la aplicación (igual que si se pulsase el botón salir)
*****************************************************************************************************************/
