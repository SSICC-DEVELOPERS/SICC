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
    $Id: LPEliminarPerfiles.java,v 1.1 2009/12/03 18:42:09 pecbazalar Exp $
    Logica de eliminacion de perfiles
*/
import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusqueda;
import es.indra.sicc.dtos.men.DTOEntradaEliminarPerfil;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.sql.Date;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
//import LPSICCBase;

// $Id: LPEliminarPerfiles.java,v 1.1 2009/12/03 18:42:09 pecbazalar Exp $
// Definicion de la clase
public class LPEliminarPerfiles extends LPSICCBase // extender de LPSICCBase
 {
    private static final String LP_NAME = "LPEliminarPerfiles";
    String perfil = "";
    String accion = "";
    String perfilEliminar = "";
    String perfilBuscado = "";

    // Definicion del constructor
    public LPEliminarPerfiles() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        //la pagina por defecto
        pagina("contenido_perfil_usuario_buscar");
        asignarAtributoPagina("cod", "054");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        accion = conectorParametro("accion");
        perfil = conectorParametro("txtNombrePerfil");
        setTrazaFichero();

        // Como es LPEliminarPerfiles, la pantalla oculta estas capas debajo de la lista.
        asignarAtributo("CAPA", "capaBotonConsultar", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaBotonModificar", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaBotonCopiar", "visibilidad", "hidden");

        //asignarAtributo("CTEXTO", "txtNombrePerfil", "onshtab", "focaliza('frmBuscar.btnBuscar');" );
        perfil = (perfil == null) ? "" : perfil;
        accion = (accion == null) ? "" : accion;

        //traza("Valor de accion: " + accion.toString());

        try {
            if (accion.equals("")) { //inicio del caso de uso

                asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", perfil);
                asignarAtributo("VAR", "accion", "valor", "busca");
                asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);

                asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");

                HashMap propiedades = (HashMap) conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);

            } else
             if (accion.equals("busca")) { //ejecucion de la busqueda de perfil en base al parametro perfil, obtenido desde la pagina druida
                buscarPerfil(perfil, null);
            } else
             if (accion.equals("elimina")) { //Eliminacion del perfil seleccionado, indicado por parametro desde la pagina de druida
                perfilEliminar = conectorParametro("seleccion");
                perfilBuscado = conectorParametro("txtNombrePerfil");

                if ((perfilEliminar == null) || perfilEliminar.equals("")) {
                    //si elimina, debe seleccionar 1 perfil							
                    throw new java.lang.Exception("ERR_52");
                }

                confimaEliminar(perfilEliminar, perfilBuscado);
            } else {
                //se controla por las dudas el tipo de accion recibido.												
                throw new java.lang.Exception("ERR_53_" + accion);
            }
        } catch (Exception ex) {
            this.lanzarPaginaError(ex);
            asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
            asignarAtributo("CAPA", "capaBotonElimina", "visibilidad", "hidden");
            asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
            asignarAtributo("VAR", "accion", "valor", accion);
            asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", perfil);

            if (perfilEliminar.length() != 0) {
                asignarAtributo("VAR", "seleccion", "valor", perfilEliminar);
            }
        }

        this.getConfiguracionMenu();
    }

    private void buscarPerfil(String nombrePerfil, String mensaje) throws Exception, MareException {
        DTOEntradaCriteriosDeBusqueda DTOCriterios = (DTOEntradaCriteriosDeBusqueda) conectorParametroSesion("DTOCriteriosdeBusqueda");

        if (DTOCriterios == null) {
            DTOCriterios = new DTOEntradaCriteriosDeBusqueda();
        }

	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		DTOCriterios.setUsuario(usuario);
		DTOCriterios.setPassword(contrasenia);

        DTOCriterios.setNombrePerfil(nombrePerfil);
        DTOCriterios.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        DTOCriterios.setPrograma(UtilidadesSession.getFuncion(this));

        conectorParametroSesion("DTOCriteriosdeBusqueda", DTOCriterios);

        DruidaConector conectorBuscarPerfiles = null;
        MareBusinessID bussinesId = new MareBusinessID("MENBuscarPerfiles");

        Vector params = new Vector();
        params.add(DTOCriterios);
        params.add(bussinesId);

        conectorBuscarPerfiles = conectar("ConectorConsultarPerfiles", params);

        DTOSalida dto = (DTOSalida) conectorBuscarPerfiles.objeto("dtoSalida");
        RecordSet rPerfiles = dto.getResultado();

		DruidaConector conGenerico = generarConector("Perfiles", rPerfiles, rPerfiles.getColumnIdentifiers());
		asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");
		asignar("LISTA", "lstResultado", conGenerico, "Perfiles");
		asignarAtributo("CTEXTO", "txtNombrePerfil", "valor", nombrePerfil);
		asignarAtributo("VAR", "conectorAction", "valor", LP_NAME);
		asignarAtributo("CAPA", "capaBotonElimina", "visibilidad", "visible");

		//asignarAtributo("CAPA","capaBorde","visibilidad","visible");
		asignarAtributo("VAR", "accion", "valor", "elimina");


        if ((mensaje != null) && (mensaje.length() > 0)) {
            asignarAtributo("VAR", "mensaje", "valor", mensaje);
        }
    }

    private void confimaEliminar(String nombrePerfil, String perfilBuscado) throws Exception, MareException {
        DTOEntradaEliminarPerfil DTOPerfil = new DTOEntradaEliminarPerfil();
	    String usuario = (String)conectorParametroSesion("DruidaUsuario");
	    String contrasenia = (String)conectorParametroSesion("DruidaPassword");
		DTOPerfil.setUsuario(usuario);
		DTOPerfil.setPassword(contrasenia);
        MareBusinessID bussinesId = new MareBusinessID("MENEliminarPerfiles");
        DruidaConector ConectorEliminarPerfiles = null;

        DTOPerfil.setNombrePerfil(nombrePerfil);
        DTOPerfil.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        DTOPerfil.setPrograma(UtilidadesSession.getFuncion(this));

        Vector params = new Vector();
        params.add(DTOPerfil);
        params.add(bussinesId);

        ConectorEliminarPerfiles = conectar("ConectorEliminarPerfiles", params);

        rastreo();
		
        perfilEliminar = "";

        //le presento otra vez la busqueda
        buscarPerfil("", "");
        asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaBotonElimina", "visibilidad", "hidden");
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
