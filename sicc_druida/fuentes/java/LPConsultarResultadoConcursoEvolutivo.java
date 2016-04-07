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
 * la dalistribución de este código sin permiso expreso.
 *
 *
 * @autor: Sergio Platas
 * @date: 26/07/2005
 */
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.inc.DTOPremiosConsuelo;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;


public class LPConsultarResultadoConcursoEvolutivo extends LPSICCBase {
    private String accion = null;

    public LPConsultarResultadoConcursoEvolutivo() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_resultado_concurso_evolutivo_consultar");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("Entró a 'ejecucion()'");

        try {
            accion = (conectorParametro("accion") == null) ? ""
                                                           : conectorParametro(
                    "accion");
            traza("La acción es: " + accion);

            if (accion.equals("")) {
                this.inicializar();
            }
        } catch (Exception ex) {
            this.lanzarPaginaError(ex);
        }

        getConfiguracionMenu();
        traza("Sale de 'ejecucion()'");
    }

    public void inicializar() throws Exception {
        traza("Entró a 'inicializar()'");

        // Carga de combo de datos Niveles
        DTOSiccPaginacion dtoBel = new DTOSiccPaginacion();
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoBel);
        paramEntrada.add(new MareBusinessID("INCRecuperarConcursosRanking"));

        traza("antes conector");
        DruidaConector conectorRecupConcRank = conectar("ConectorRecuperarConcursosRanking",
                paramEntrada);
        traza("ConectorRecuperarConcursosRanking trajo --> " +
            conectorRecupConcRank);

        asignar("LISTADOA", "listado1", conectorRecupConcRank,
            "dtoSalida.resultado_ROWSET");
        traza("ASIGNADA !!!!!");

        traza("Sale de 'inicializar()'");
    }
}
