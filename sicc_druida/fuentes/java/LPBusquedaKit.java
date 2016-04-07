import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.mae.DTOBusquedaKit;
import es.indra.sicc.util.DTOBelcorp;

/*import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;*/
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

/*import java.lang.reflect.InvocationTargetException;*/
/*import com.evermind.server.rmi.OrionRemoteException;*/
import java.io.*;

import java.util.Vector;


public class LPBusquedaKit extends LPSICCBase {
    public LPBusquedaKit() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_kit_productos_modificar");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();

        //Recibo las variables de la pagina
        String accion = conectorParametroLimpia("accion", "", true);
        String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
        String hCodigoSap = conectorParametroLimpia("hCodigoSap", "", true);
        String hCodigoAntiguo = conectorParametroLimpia("hCodigoAntiguo", "",
                true);
        String hDescripcionCorta = conectorParametroLimpia("hDescripcionCorta",
                "", true);
        String hDescripcionSap = conectorParametroLimpia("hDescripcionSap", "",
                true);

        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

        try {
            rastreo();
            getConfiguracionMenu();

            traza("accion" + accion);

            if (accion.equals("")) {
                traza("caso de uso:" + casoDeUso);

                if (casoDeUso.equalsIgnoreCase("consultar")) {
                    asignarAtributo("VAR", "casoDeUso", "valor", "consultar");
                    asignarAtributoPagina("cod","0345");
                    
                } else {
                    if (casoDeUso.equalsIgnoreCase("modificar")) {
                        asignarAtributo("VAR", "casoDeUso", "valor", "modificar");
                        asignarAtributoPagina("cod","0402");
                    }
                }

                if ((casoDeUso.equals("vuelveModificar")) ||
                        (casoDeUso.equals("vuelveEliminar"))) {
                    asignarAtributo("VAR", "hCodigoSap", "valor", hCodigoSap);
                    asignarAtributo("VAR", "hCodigoAntiguo", "valor",
                        hCodigoAntiguo);
                    asignarAtributo("VAR", "hDescripcionCorta", "valor",
                        hDescripcionCorta);
                    asignarAtributo("VAR", "hDescripcionSap", "valor",
                        hDescripcionSap);
                }
            }

            if (accion.equals("buscar")) {
                traza("entro por buscar");

                /*esto es solo para pruebas, comentar despues
                Vector paramEntrada = new Vector();
                DTOBusquedaKit dto = new DTOBusquedaKit();
                MareBusinessID id = new MareBusinessID("MAEBuscarKit");
                DruidaConector conector = new DruidaConector();


                dto.setCodAntiguo("10");
                dto.setDescCorta("DescriCortSap 801_03");
                dto.setCodSAP("801_03");
                dto.setDescSAP("Descripcion 801_03");
                dto.setOidIdioma(new Long(1));
                dto.setOidPais(new Long(1));
                dto.setIndicadorSituacion(new Integer(0));
                dto.setTamanioPagina(new Integer(20));

                paramEntrada.add(dto);
                paramEntrada.add(id);

                traza("antes del conector");

                conector = conectar("ConectorBusquedaKits",paramEntrada);

                traza("Datos" + conector.objeto("dtoSalida"));*/
                /*fin*/
                asignarAtributo("VAR", "hPais", "valor", pais.toString());
                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
            }

            if (accion.equals("consultar")) {
                /*-se pasa el control al LPConsultarKit pasándole el oid oculto de la fila que ha seleccionado como parámetro*/
                conectorAction("LPConsultarKit");
                conectorActionParametro("accion", "");
                conectorActionParametro("casodeUso", "consultar");
                asignarAtributo("VAR", "casodeUso", "valor", "consultar");
            }

            if (accion.equals("modificar")) {
                /*-se pasa el control al LPModificarKit pasándole el oid oculto de la fila que ha seleccionado como parámetro*/
                conectorAction("LPModificarKit");
            }
        }
         catch (Exception e) {
            traza("Excepcion " + e.toString());

            this.logStackTrace(e);
            this.lanzarPaginaError(e);
            asignarAtributo("VAR", "accion", "valor", accion);
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }
}
