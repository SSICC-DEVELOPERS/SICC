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
    INDRA/CAR/sicc
    $Id: LPConsultarPerfiles.java,v 1.1 2009/12/03 18:41:33 pecbazalar Exp $
    Logica de Presentacion de la Consulta de Perfiles
*/
import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusqueda;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.Vector;

//import LPSICCBase;

public class LPConsultarPerfiles extends LPSICCBase {
    private static final String LP_NAME = "LPConsultarPerfiles";
    private String perfil = "";
    private String accion = "";
    private String seleccionado = "";

    public LPConsultarPerfiles() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_perfil_usuario_buscar");
    }

    public void ejecucion() throws Exception {
        try {
            setTrazaFichero();

            accion = conectorParametroLimpia("accion", "", true);
            perfil = conectorParametroLimpia("txtNombrePerfil", "", true);
            seleccionado = conectorParametroLimpia("seleccion", "", true);

            if (accion.equals("")) {
                asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", "");
                asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
                asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");
                asignarAtributo("CAPA", "capaBotonModificar", "visibilidad", "hidden");
                asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");
                asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
            }

            if (accion.equals("busca")) {
                buscarPerfil(perfil, "");
            }

            if (accion.equals("consulta")) {
                //muestro la pantalla de consulta con los datos del perfil;
                consultarPefil(seleccionado);
            }

            getConfiguracionMenu(); //MenuSecundario
        } catch (Exception e) {
			  traza("entro al catch principal");
            lanzarPaginaError(e);
            asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
            asignarAtributo("VAR", "accion", "valor", accion);
            asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", perfil);
        }
    }

    private void buscarPerfil(String nombrePerfil, String mensaje) throws Exception {
        asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", nombrePerfil);
        asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);

        DTOEntradaCriteriosDeBusqueda DTOCriterios = (DTOEntradaCriteriosDeBusqueda) conectorParametroSesion("DTOCriteriosdeBusqueda");

        if (DTOCriterios == null) {
            DTOCriterios = new DTOEntradaCriteriosDeBusqueda();
        }
	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
		String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		DTOCriterios.setUsuario(usuario);
		DTOCriterios.setPassword(contrasenia);

        DTOCriterios.setNombrePerfil(nombrePerfil);
        conectorParametroSesion("DTOCriteriosdeBusqueda", DTOCriterios);

        DruidaConector conector = null;
        MareBusinessID bussinesId = new MareBusinessID("MENBuscarPerfiles");

        Vector params = new Vector();
        params.add(DTOCriterios);
        params.add(bussinesId);
		  traza("antes del try");
try
{
	     conector = conectar("ConectorConsultarPerfiles", params);
}
catch (Exception ex)
{
					traza("entro al catch");
                asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");
                asignarAtributo("CAPA", "capaBotonModificar", "visibilidad", "hidden");
                asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");
                asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
					 asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", nombrePerfil);
					throw ex;
}

   

        DTOSalida dto = (DTOSalida) conector.objeto("dtoSalida");
        RecordSet rPerfiles = dto.getResultado();

        //traza("Valor de rPerfiles: " + rPerfiles.toString());
        if (rPerfiles.getRowCount() == 0) {
            asignarAtributo("VAR", "mensaje", "valor", "139");
            asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
            asignarAtributo("CAPA", "capaBorde", "visibilidad", "hidden");
            asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
            asignarAtributo("VAR", "accion", "valor", "busca");
        } else {
            DruidaConector conGenerico = generarConector("Perfiles", rPerfiles, rPerfiles.getColumnIdentifiers());
            asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");

            asignar("LISTA", "lstResultado", conGenerico, "Perfiles");
            asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
            asignarAtributo("CAPA", "capaBotonConsulta", "visibilidad", "visible");
            asignarAtributo("CAPA", "capaBorde", "visibilidad", "visible");
            asignarAtributo("VAR", "accion", "valor", "consulta");

            if ((mensaje != null) && (mensaje.length() > 0)) {
                asignarAtributo("VAR", "mensaje", "valor", mensaje);
            }
        }
    }

    private void consultarPefil(String nombrePerfil) throws Exception, MareException {
        pagina("contenido_perfil_usuarios_consultar");
        asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
        asignarAtributo("VAR", "accion", "valor", "busca");
        asignarAtributo("VAR", "seleccion", "valor", nombrePerfil);
        asignarAtributo("VAR", "txtNombrePerfil", "valor", perfil);

        //traigo las asociadas al Perfil
        DTOEntradaCriteriosDeBusqueda DTOCriteriosPerfil = new DTOEntradaCriteriosDeBusqueda();

		String usuario = (String)conectorParametroSesion("DruidaUsuario");
		String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		DTOCriteriosPerfil.setUsuario(usuario);
		DTOCriteriosPerfil.setPassword(contrasenia);

        DTOCriteriosPerfil.setNombrePerfil(nombrePerfil);
        DTOCriteriosPerfil.setOidIdioma(UtilidadesSession.getIdioma(this));

        MareBusinessID bussinesIdPerfil = new MareBusinessID("MENConsultarPerfiles");
        DruidaConector ConectorConsultarPerfil = null;
        Vector paramsPerfil = new Vector();
        paramsPerfil.add(DTOCriteriosPerfil);
        paramsPerfil.add(bussinesIdPerfil);
        ConectorConsultarPerfil = conectar("ConectorConsultarFuncionesPerfil", paramsPerfil);
        //traza("ConectorConsultarPerfil		:" + ConectorConsultarPerfil.getXML());

        DruidaConector ConectorConsultarPerfilXSL = transformar("XSLConsultarPerfiles", ConectorConsultarPerfil);
        //traza("ConectorConsultarPerfilXSL	:" + ConectorConsultarPerfilXSL.getXML());
        asignar("REJILLA", "salida", ConectorConsultarPerfilXSL);
    }

    /***
    * Genera un conector XML, a partir de un Rowsert que contiene los datos a cargar.
    * @param rowsetId, Identificador del rowset.
    * @param datos, Rowset con los datos a cargar.
    * @param colums, Indica las columnas del rowset a completar.
    */
    private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception {
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
                    e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                    e_campo2.setAttribute("TIPO", "OBJECTO");
                    e_campo2.setAttribute("LONGITUD", "50");

                    Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null) ? "" : datos.getValueAt(i, j).toString()));
                    e_campo2.appendChild(txt);
                    e_row.appendChild(e_campo2);
                }
            }
        }

        conectorValoresPosibles.setXML(docDestino.getDocumentElement());

        return conectorValoresPosibles;
    }
}
