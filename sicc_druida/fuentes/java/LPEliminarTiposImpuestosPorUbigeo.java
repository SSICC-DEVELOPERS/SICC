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
import es.indra.sicc.dtos.fac.DTOTipoOfertaExcluido;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


public class LPEliminarTiposImpuestosPorUbigeo extends LPSICCBase {


                    private String accion;
                    private String opcionMenu;

                    public void inicio() throws Exception {}

                    /**
                    * @author Emilio Noziglia
                    * @date 15/08/2007
                    * @throws Exception
                    */
                    public void ejecucion() throws Exception {

                              rastreo();
                              setTrazaFichero();

                              traza("*** Entrada - LPEliminarTiposImpuestosPorUbigeo - ejecucion ***");

                              try  {
                                         conectorAction("LPMantenimientoTiposImpuestosPorUbigeo");
                                         conectorActionParametro("accion", "");
                                         conectorActionParametro("casoDeUso", "eliminar");
                                         conectorActionParametro("opcionMenu", "EliminarTiposImpuestosPorUbigeo");  

                              } catch ( Exception e ) {
                                         logStackTrace(e);
                                         lanzarPaginaError(e);
                              }


                              traza("*** Salida - LPEliminarTiposImpuestosPorUbigeo - ejecucion ***");
                    }

            
                    private void logStackTrace(Throwable e) throws Exception {
                              traza("Se produjo la excepción: " + e.getMessage());

                              ByteArrayOutputStream out = new ByteArrayOutputStream();
                              PrintStream print = new PrintStream(out);
                              e.printStackTrace(print);

                              traza("Stack Trace: " + out);
                    }
}

