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

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPais;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.util.UtilidadesSession;

import java.util.StringTokenizer;
import java.util.Vector;

public final class LPCambiarPais extends LPSICCBase {

   public LPCambiarPais() {
      super();
   }

   public void inicio() throws Exception {
      pagina("contenido_pais_cambiar");
   }

   public void ejecucion() throws Exception {
      setTrazaFichero();

      String accion = "";
      String paisPorDefecto = "";

      accion = conectorParametroLimpia("accion", "", true);
      paisPorDefecto = conectorParametroLimpia("hidCodPaisDefecto", "", true);

      try {
         if (accion.equals("")) {
            asignarAtributo("VAR", "hidCodPaisDefecto", "valor", UtilidadesSession.getPais(this).toString());
            Vector paramEntrada = null;
            MareBusinessID id = null;
            es.indra.druida.DruidaConector conector = new es.indra.druida.DruidaConector();

            id = new MareBusinessID("MENConsultaPaises");

            DTOInternacional inte = new DTOInternacional();
            inte.setOidIdioma(UtilidadesSession.getIdioma(this));
            paramEntrada = new Vector();
            paramEntrada.add(inte);
            paramEntrada.add(id);

            conector = conectar("ConectorBusquedaPais", paramEntrada);
            asignar("COMBO", "cbNuePaisDefecto", conector, "dtoSalida.resultado_ROWSET");
            getConfiguracionMenu();
         } else if (accion.equals("guardar")) {
				pagina("salidaGenerica");
            Vector paramEntrada = null;
            MareBusinessID id = null;
            es.indra.druida.DruidaConector conector = new es.indra.druida.DruidaConector();
            DTOEntradaCambiarPais dtoe = new DTOEntradaCambiarPais();

			String user = (String)conectorParametroSesion("DruidaUsuario");
			String contrasenia = (String)conectorParametroSesion("DruidaPassword");
			dtoe.setUsuario(user);
			dtoe.setPassword(contrasenia);

            traza("******************** Entre a guardar - LPCambiarPais");
            traza("******************** paisPorDefecto: " + paisPorDefecto);

            id = new MareBusinessID("MENCambiaPaisPorDefecto");
            String strUsuario = UtilidadesSession.getIdUsuario(this);
            StringTokenizer st2 = new StringTokenizer(strUsuario, " ");
            String usu = st2.nextToken();
            traza("******************** usu: " + usu);
            dtoe.setIdUsuario(usu);
            dtoe.setNuevoPais(new Integer(paisPorDefecto));
            dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

            traza("Idioma: " + dtoe.getOidIdioma());

            traza("******************** dtoe: " + dtoe);

            paramEntrada = new Vector();
            paramEntrada.add(dtoe);
            paramEntrada.add(id);

            MareCredentials aux = UtilidadesSession.getMareCredentials(this);

            String usuario = new String();
            usuario = aux.getUser().getName();
            traza("******************** usuario: " + usuario);

            StringTokenizer st1 = new StringTokenizer(usuario, " ");
            String usuarioReal = st1.nextToken();
            traza("******************** usuarioReal: " + usuarioReal);

            traza("******************** Antes de llamar a ConectorCambiarPais");
            conector = conectar("ConectorCambiarPais", paramEntrada);
            traza("******************** Despues de llamar a ConectorCambiarPais");
            MareDTO tito = (MareDTO) conector.objeto("vacio");
            String url = (String) tito.getProperty("vacio");
            traza("******************** url: " + url);
				String funcionEjecutar = "inicio('" + usuarioReal + "','" + aux.getPassword().toString() + "','" + url + "');";
            asignarAtributo("VAR", "ejecutar", "valor", funcionEjecutar);
				traza("Ejecutando: "+funcionEjecutar);
         }
      } catch (Exception ex) {
         lanzarPaginaError(ex);
      }
   }
}