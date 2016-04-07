/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Españaamo
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.math.BigDecimal;

public class LPConsultaConcursoSeleccionado extends LPConsultaIntegralInc {    
    
    public LPConsultaConcursoSeleccionado() { super(); }

    public void inicio() throws Exception {
                  pagina("contenido_concurso_seleccionado_consultar");
         }

    public void ejecucion() throws Exception {
         setTrazaFichero();
                  traza("LPConsultaConcursoSeleccionado.ejecucion - Entrada");

         try{
             accion = conectorParametroLimpia("accion", "", true);
                           traza("***************** accion " + accion);

             if (accion.equals("")){
                  cargarPantalla();
             }
             else if (accion.equals("consultarMultinivel")) {
                  cargarPantallaMultinivel(); 
             }             
             else if (accion.equals("consultarPremiosProcesados")) {
                  cargarPantallaPremiosProcesadosDetalle(); 
             }
             else if (accion.equals("cargar cabecera multinivel")) {
                  cargarCabeceraMultinivel(); 
             } // vbongiov -- Cambio RI 20080810 -- 6/01/2009
                           else if (accion.equals("consultarDetalleSolicitudes")) {
                  cargarPantallaDetalleSolicitudes(); 
             }

                           cargarMenuSecundario();
                           traza("LPConsultaConcursoSeleccionado.ejecucion - Salida");
          }
                   catch(Exception ex) {
              logStackTrace(ex);
              this.lanzarPaginaError(ex);
         }
    }

         private void cargarMenuSecundario() throws Exception {     
                  traza("LPConsultaConcursoSeleccionado.cargarMenuSecundario - Entrada");
                  getConfiguracionMenu("LPConsultaConcursoSeleccionado","");  
                  
                  if (accion.equals("")){
                           asignarAtributoPagina("cod", "01052");          
                  }
                  else if (accion.equals("consultarMultinivel")) {
                           asignarAtributoPagina("cod", "00400");			
                  }
                  else if (accion.equals("consultarPremiosProcesados")) {
                           asignarAtributoPagina("cod", "2871");			
         }
                  
                  traza("LPConsultaConcursoSeleccionado.cargarMenuSecundario - Salida");
         }

         private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());
         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
         if (e instanceof MareException) {
           MareException e2=(MareException)e;
           traza("Es una mare Exception con codigo de error: "+e2.getCode());
         }
         e.printStackTrace(out);
         traza("stack Trace : " +  pila.toString());
    }
    
         public void cargarPantalla() throws Exception {
                  traza("LPConsultaConcursoSeleccionado.cargarPantalla - Entrada");
                  
                  dtoCabecera = getCabecera(); 
                  traza("*************** dtoCabecera " + dtoCabecera);
                           
                  // Setear los atributos de dtoCabecera en la pantalla
                  if (dtoCabecera.getCodigoCliente() != null)	{
                           String codigoCliente = dtoCabecera.getCodigoCliente();
                           traza("*********** codigoCliente" + codigoCliente);
                           asignarAtributo("VAR", "codigoCliente", "valor", 
                           codigoCliente); 
                  }
                  
                  if (dtoCabecera.getNombreApellidos() != null) {
                           String nombreApellidos = dtoCabecera.getNombreApellidos();
                           traza("***********  nombreApellidos" + nombreApellidos);
                           asignarAtributo("VAR", "nombreApellidos", "valor", 
                           nombreApellidos); 
                  }
                  
                  if (dtoCabecera.getNumeroConcurso() != null) {
                           String numeroConcurso = dtoCabecera.getNumeroConcurso();
                           traza("*********** numeroConcurso" + numeroConcurso);
                           asignarAtributo("VAR", "numeroConcurso", "valor", 
                           numeroConcurso); 
                  }
                  
                  if (dtoCabecera.getNombreConcurso() != null) {
                           String descripcionConcurso = dtoCabecera.getNombreConcurso();
                           traza("*********** descripcionConcurso" + descripcionConcurso);
                           asignarAtributo("VAR", "descripcionConcurso", "valor", 
                           descripcionConcurso); 
                  }
                  
                  if (dtoCabecera.getPeriodoInicial() != null) {
                           String periodoInicial = dtoCabecera.getPeriodoInicial();
                           traza("*********** periodoInicial" + periodoInicial);
                           asignarAtributo("VAR", "periodoInicial", "valor", 
                           periodoInicial); 
                  }
                  
                  if (dtoCabecera.getPeriodoFinal() != null) {
                           String periodoFinal = dtoCabecera.getPeriodoFinal();
                           traza("*********** periodoFinal" + periodoFinal);
                           asignarAtributo("VAR", "periodoFinal", "valor", 
                           periodoFinal); 
                  }

                  // Se setean las variables ocultas de la pantalla
                  if (dtoCabecera.getOidConcurso() != null) {
                           String oidConcurso = dtoCabecera.getOidConcurso().toString();
                           traza("*********** oidConcurso" + oidConcurso);
                           asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso); 
                  }
                  
                  if (dtoCabecera.getOidCliente() != null) {
                           String oidCliente = dtoCabecera.getOidCliente().toString();
                           traza("*********** oidCliente" + oidCliente);
                           asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
                  }
                  
                  if (dtoCabecera.getOidRegion() != null)	{
                           String oidRegion = dtoCabecera.getOidRegion().toString();
                           traza("*********** oidRegion" + oidRegion);
                           asignarAtributo("VAR", "oidRegion", "valor", oidRegion); 
                  }
                  
                  if (dtoCabecera.getOidZona() != null) {
                           String oidZona = dtoCabecera.getOidZona().toString();
                           traza("*********** oidZona" + oidZona);
                           asignarAtributo("VAR", "oidZona", "valor", oidZona); 
                  }
                  
                  if (dtoCabecera.getOidSeccion() != null) {
                           String oidSeccion = dtoCabecera.getOidSeccion().toString();
                           traza("*********** oidSeccion" + oidSeccion);
                           asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
                  }
                  
                  if (dtoCabecera.getOidPais() != null) {
                           String oidPais = dtoCabecera.getOidPais().toString();
                           traza("*********** oidPais" + oidPais);
                           asignarAtributo("VAR", "oidPais", "valor", oidPais); 
                  }
                  
                  if (dtoCabecera.getOidIdioma() != null)	{
                           String oidIdioma = dtoCabecera.getOidIdioma().toString();
                           traza("*********** oidIdioma" + oidIdioma);
                           asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
                  }
                  
                  if (dtoCabecera.getOidPlantilla() != null)	{
                           String oidPlantilla = dtoCabecera.getOidPlantilla().toString();
                           traza("*********** oidPlantilla" + oidPlantilla);
                           asignarAtributo("VAR", "oidPlantilla", "valor", oidPlantilla); 
                  }

                  MareBusinessID businessID = 
                  new MareBusinessID("INCConsultarConcursoSeleccionado");
                  Vector parametros = new Vector();      
         parametros.add(dtoCabecera);
                  parametros.add(businessID);

                  traza("******************* Antes de conectar");
                  DruidaConector con = conectar("ConectorConsultarConcursoSeleccionado", 
                  parametros);			
                  traza("******************* Despues de conectar");
                           
                  DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida"); 			
                  traza("******************* dtoSalida " + dtoSalida);
                  RecordSet rs = dtoSalida.getResultado();
                  traza("******************* rs " + rs);

         // vbongiov -- Cambio RI 20080810 -- 6/01/2009
                  if(!rs.esVacio()) {
                           traza("******************* rs es distinto de vacio");

                           BigDecimal nivelAlcanzado = 
                           (BigDecimal) rs.getValueAt(0,"NIVEL_ALCANZADO");
                           traza("******************* nivelAlcanzado" + nivelAlcanzado);
                           if(nivelAlcanzado!=null) {
                                    asignarAtributo("VAR", "nivelAlcanzado", "valor", 
                                    nivelAlcanzado.toString()); 
                           }

                           String situacion =  (String)rs.getValueAt(0,"SITUACION");
                           traza("******************* situacion" + situacion);
                           if(situacion!=null) {
                                    asignarAtributo("VAR", "situacion", "valor", situacion); 
                           }

                           // vbongiov -- INC-014 -- 14/10/2008
                           BigDecimal totalPuntaje = 
                           (BigDecimal) rs.getValueAt(0,"SALDO_PUNTAJE");
                           traza("******************* totalPuntaje" + totalPuntaje);
                           if(totalPuntaje!=null) {
                                    asignarAtributo("VAR", "totalPuntaje", "valor", 
                                    totalPuntaje.toString()); 
                           }

                           String codDuplaCyz = 
                           (String) rs.getValueAt(0,"COD_DUPLACYZ");
                           traza("******************* codDuplaCyz" + codDuplaCyz);
                           if(codDuplaCyz!=null) {
                                    asignarAtributo("VAR", "codDuplaCyz", "valor", 
                                    codDuplaCyz); 
                           }

                           String nombreDuplaCyz = 
                           (String) rs.getValueAt(0,"NOMBRE_DUPLACYZ");
                           traza("******************* nombreDuplaCyz" + nombreDuplaCyz);
                           if(nombreDuplaCyz!=null) {
                                    asignarAtributo("VAR", "nombreDuplaCyz", "valor", 
                                    nombreDuplaCyz); 
                           }


                           BigDecimal ventaBase = 
                           (BigDecimal) rs.getValueAt(0,"VENTA_BASE");
                           traza("******************* ventaBase" + ventaBase);
                           if(ventaBase!=null) {
                                    asignarAtributo("VAR", "ventaBase", "valor", 
                                    ventaBase.toString()); 
                           }

             // vbongiov -- RI 20070467 -- 19/09/2008
             /*
                           BigDecimal metaPersonalizada = 
                           (BigDecimal) rs.getValueAt(0,"META_PERSONALIZADA");
                           traza("******************* metaPersonalizada" + metaPersonalizada);
                           if(metaPersonalizada!=null) {
                                    asignarAtributo("VAR", "metaPersonalizada", "valor", 
                                    metaPersonalizada.toString()); 
                           }*/

                           BigDecimal totalPuntajeObtenido = 
                           (BigDecimal) rs.getValueAt(0,"TOTAL_PUNTAJE_OBTENIDO");
                           traza("******************* totalPuntajeObtenido" + 
                           totalPuntajeObtenido);
                           if(totalPuntajeObtenido!=null) {
                                    asignarAtributo("VAR", "totalPuntajeObtenido", "valor", 
                                    totalPuntajeObtenido.toString()); 
                           }

                           BigDecimal totalPuntajePerdido = 
                           (BigDecimal) rs.getValueAt(0,"TOTAL_PUNTAJE_PERDIDO");
                           traza("******************* totalPuntajePerdido" + 
                           totalPuntajePerdido);
                           if(totalPuntajePerdido!=null) {
                                    asignarAtributo("VAR", "totalPuntajePerdido", "valor", 
                                    totalPuntajePerdido.toString()); 
                           }

                           BigDecimal totalPuntajeUtilizado = 
                           (BigDecimal) rs.getValueAt(0,"TOTAL_PUNTAJE_UTILIZADO");
                           traza("******************* totalPuntajeUtilizado" + 
                           totalPuntajeUtilizado);
                           if(totalPuntajeUtilizado!=null) {
                                    asignarAtributo("VAR", "totalPuntajeUtilizado", "valor", 
                                    totalPuntajeUtilizado.toString()); 
                           }

                           BigDecimal saldoPuntaje = 
                           (BigDecimal) rs.getValueAt(0,"SALDO_PUNTAJE");
                           traza("******************* saldoPuntaje" + saldoPuntaje);
                           if(saldoPuntaje!=null) {
                                    asignarAtributo("VAR", "saldoPuntaje", "valor", 
                                    saldoPuntaje.toString()); 
                           }

                           BigDecimal puntajeDisponible = 
                           (BigDecimal) rs.getValueAt(0,"SALDO_PUNTAJE");
                           traza("******************* puntajeDisponible" + puntajeDisponible);
                           if(puntajeDisponible!=null) {
                                    asignarAtributo("VAR", "puntajeDisponible", "valor", 
                                    puntajeDisponible.toString());
                           }
                  }

                  if(dtoCabecera.getOidBaseCalculo()!=null) {
                           if (dtoCabecera.getOidBaseCalculo().longValue() == 
                           ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.longValue())	{
                                    asignarAtributo("VAR", "recomendacion", "valor",  "habilitar");
                           }
                  }

                  if(dtoCabecera.getMultinivel()!=null) {
                           if (dtoCabecera.getMultinivel().booleanValue() == true)	{
                                    asignarAtributo("VAR", "multinivel", "valor",  "habilitar");
                           }
                  }
                           
                  traza("LPConsultaConcursoSeleccionado.cargarPantalla - Salida");
         }


         private ComposerViewElementList crearParametrosEntrada() throws Exception {    		 
                   traza("LPConsultaConcursoSeleccionado.crearParametrosEntrada - Entrada");
                   DTOOIDs dtoe = new DTOOIDs();
                   Long[] oids = new Long[2];
                   oids[0] = dtoCabecera.getOidPeriodoInicial();
                   oids[1] = dtoCabecera.getOidPeriodoFinal();
                   dtoe.setOids(oids);

          ComposerViewElementList lista = new ComposerViewElementList(); 
          ComposerViewElement cve = null;          
    
          cve = new ComposerViewElement();
          cve.setIDBusiness("CRAObtenerPeriodosEntre");
          cve.setDTOE(dtoe);
          lista.addViewElement(cve);
                   traza("LPConsultaConcursoSeleccionado.crearParametrosEntrada - Salida");
          return lista;
    }

         public void cargarPantallaMultinivel() throws Exception {
                  traza("LPConsultaConcursoSeleccionado.cargarPantallaMultinivel - Entrada");

                  pagina("contenido_multinivel_consultar");		
                  
                  dtoCabecera = getCabecera(); 
         
                  if (dtoCabecera.getNumeroConcurso() != null) {
                           String laNumeroConcurso = 
                           dtoCabecera.getNumeroConcurso().toString();
                           traza("************** laNumeroConcurso" + laNumeroConcurso);
                           asignarAtributo("VAR", "laNumeroConcurso", "valor", 
                           laNumeroConcurso); 
                  }
                  if (dtoCabecera.getNombreConcurso() != null) {
                           String laDescripcionConcurso = 
                           dtoCabecera.getNombreConcurso().toString();
                           traza("************** laDescripcionConcurso" + 
                           laDescripcionConcurso);
                           asignarAtributo("VAR", "laDescripcionConcurso", "valor", 
                           laDescripcionConcurso); 
                  }
                  
                  if (dtoCabecera.getOidConcurso() != null) {
                           String oidConcurso = dtoCabecera.getOidConcurso().toString();
                           traza("************** oidConcurso" + oidConcurso);
                           asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso); 
                  }
                  if (dtoCabecera.getOidCliente() != null) {
                           String oidCliente = dtoCabecera.getOidCliente().toString();
                           traza("************** oidCliente" + oidCliente);
                           asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
                  }
                  if (dtoCabecera.getOidRegion() != null) {
                           String oidRegion = dtoCabecera.getOidRegion().toString();
                           traza("************** oidRegion" + oidRegion);
                           asignarAtributo("VAR", "oidRegion", "valor", oidRegion); 
                  }
                  if (dtoCabecera.getOidZona() != null) {
                           String oidZona = dtoCabecera.getOidZona().toString();
                           traza("************** oidZona" + oidZona);
                           asignarAtributo("VAR", "oidZona", "valor", oidZona); 
                  }
                  if (dtoCabecera.getOidSeccion() != null) {
                           String oidSeccion = dtoCabecera.getOidSeccion().toString();
                           traza("************** oidSeccion" + oidSeccion);
                           asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
                  }
                  if (dtoCabecera.getOidPais() != null) {
                           String oidPais = dtoCabecera.getOidPais().toString();
                           traza("************** oidPais" + oidPais);
                           asignarAtributo("VAR", "oidPais", "valor", oidPais); 
                  }
                  if (dtoCabecera.getOidIdioma() != null) {
                           String oidIdioma = dtoCabecera.getOidIdioma().toString();
                           traza("************** oidIdioma" + oidIdioma);
                           asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
                  }
                  
                  ComposerViewElementList cv = this.crearParametrosEntrada();
         ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
         asignar("COMBO", "cbCampana", resultados, "CRAObtenerPeriodosEntre");
                  traza("LPConsultaConcursoSeleccionado.cargarPantallaMultinivel - Salida");
         }

         public void cargarPantallaPremiosProcesadosDetalle() throws Exception {
                  traza("LPConsultaConcursoSeleccionado.cargarPantallaPremiosProcesadosDetalle - Entrada");

                  pagina("contenido_premios_procesados");
                  dtoCabecera = getCabecera();

                  if (dtoCabecera.getCodigoCliente() != null) {
                           String laCodigoCliente = dtoCabecera.getCodigoCliente();
                           traza("laCodigoCliente" + laCodigoCliente);
                           asignarAtributo("VAR", "laCodigoCliente", "valor", 
                           laCodigoCliente); 
                  }
                  if (dtoCabecera.getNombreApellidos() != null) {
                           String laNombreApellido = dtoCabecera.getNombreApellidos();
                           traza("laNombreApellido" + laNombreApellido);
                           asignarAtributo("VAR", "laNombreApellido", "valor", 
                           laNombreApellido); 
                  }
                  if (dtoCabecera.getNumeroConcurso() != null) {
                           String laNumeroConcurso = dtoCabecera.getNumeroConcurso();
                           traza("laNumeroConcurso" + laNumeroConcurso);
                           asignarAtributo("VAR", "laNumeroConcurso", "valor", 
                           laNumeroConcurso); 
                  }
                  if (dtoCabecera.getNombreConcurso() != null) {
                           String laDescripcionConcurso = dtoCabecera.getNombreConcurso();
                           traza("laDescripcionConcurso" + laDescripcionConcurso);
                           asignarAtributo("VAR", "laDescripcionConcurso", "valor", 
                           laDescripcionConcurso); 
                  }

                  if (dtoCabecera.getOidConcurso() != null) {
                           String oidConcurso = dtoCabecera.getOidConcurso().toString();
                           traza("oidConcurso" + oidConcurso);
                           asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso); 
                  }
                  if (dtoCabecera.getOidCliente() != null) {
                           String oidCliente = dtoCabecera.getOidCliente().toString();
                           traza("oidCliente" + oidCliente);
                           asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
                  }
                  if (dtoCabecera.getOidRegion() != null)	{
                           String oidRegion = dtoCabecera.getOidRegion().toString();
                           traza("oidRegion" + oidRegion);
                           asignarAtributo("VAR", "oidRegion", "valor", oidRegion); 
                  }
                  if (dtoCabecera.getOidZona() != null) {
                           String oidZona = dtoCabecera.getOidZona().toString();
                           traza("oidZona" + oidZona);
                           asignarAtributo("VAR", "oidZona", "valor", oidZona); 
                  }
                  if (dtoCabecera.getOidSeccion() != null) {
                           String oidSeccion = dtoCabecera.getOidSeccion().toString();
                           traza("oidSeccion" + oidSeccion);
                           asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
                  }
                  if (dtoCabecera.getOidPais() != null) {
                           String oidPais = dtoCabecera.getOidPais().toString();
                           traza("oidPais" + oidPais);
                           asignarAtributo("VAR", "oidPais", "valor", oidPais); 
                  }
                  if (dtoCabecera.getOidIdioma() != null) {
                           String oidIdioma = dtoCabecera.getOidIdioma().toString();
                           traza("oidIdioma" + oidIdioma);
                           asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
                  }

                  traza("LPConsultaConcursoSeleccionado.cargarPantallaPremiosProcesadosDetalle - Salida");
         }

         // vbongiov -- Cambio RI 20080810 -- 6/01/2009
         public void cargarPantallaDetalleSolicitudes() throws Exception {
                  traza("LPConsultaConcursoSeleccionado.cargarPantallaDetalleSolicitudes - Entrada");

                  pagina("contenido_detalles_solicitudes");
                  dtoCabecera = getCabecera();

                  if (dtoCabecera.getCodigoCliente() != null) {
                           String laCodigoCliente = dtoCabecera.getCodigoCliente();
                           traza("laCodigoCliente" + laCodigoCliente);
                           asignarAtributo("VAR", "laCodigoCliente", "valor", 
                           laCodigoCliente); 
                  }
                  if (dtoCabecera.getNombreApellidos() != null) {
                           String laNombreApellido = dtoCabecera.getNombreApellidos();
                           traza("laNombreApellido" + laNombreApellido);
                           asignarAtributo("VAR", "laNombreApellido", "valor", 
                           laNombreApellido); 
                  }
                  if (dtoCabecera.getNumeroConcurso() != null) {
                           String laNumeroConcurso = dtoCabecera.getNumeroConcurso();
                           traza("laNumeroConcurso" + laNumeroConcurso);
                           asignarAtributo("VAR", "laNumeroConcurso", "valor", 
                           laNumeroConcurso); 
                  }
                  if (dtoCabecera.getNombreConcurso() != null) {
                           String laDescripcionConcurso = dtoCabecera.getNombreConcurso();
                           traza("laDescripcionConcurso" + laDescripcionConcurso);
                           asignarAtributo("VAR", "laDescripcionConcurso", "valor", 
                           laDescripcionConcurso); 
                  }

                  if (dtoCabecera.getOidConcurso() != null) {
                           String oidConcurso = dtoCabecera.getOidConcurso().toString();
                           traza("oidConcurso" + oidConcurso);
                           asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso); 
                  }
                  if (dtoCabecera.getOidCliente() != null) {
                           String oidCliente = dtoCabecera.getOidCliente().toString();
                           traza("oidCliente" + oidCliente);
                           asignarAtributo("VAR", "oidCliente", "valor", oidCliente); 
                  }
                  if (dtoCabecera.getOidRegion() != null)	{
                           String oidRegion = dtoCabecera.getOidRegion().toString();
                           traza("oidRegion" + oidRegion);
                           asignarAtributo("VAR", "oidRegion", "valor", oidRegion); 
                  }
                  if (dtoCabecera.getOidZona() != null) {
                           String oidZona = dtoCabecera.getOidZona().toString();
                           traza("oidZona" + oidZona);
                           asignarAtributo("VAR", "oidZona", "valor", oidZona); 
                  }
                  if (dtoCabecera.getOidSeccion() != null) {
                           String oidSeccion = dtoCabecera.getOidSeccion().toString();
                           traza("oidSeccion" + oidSeccion);
                           asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion); 
                  }
                  if (dtoCabecera.getOidPais() != null) {
                           String oidPais = dtoCabecera.getOidPais().toString();
                           traza("oidPais" + oidPais);
                           asignarAtributo("VAR", "oidPais", "valor", oidPais); 
                  }
                  if (dtoCabecera.getOidIdioma() != null) {
                           String oidIdioma = dtoCabecera.getOidIdioma().toString();
                           traza("oidIdioma" + oidIdioma);
                           asignarAtributo("VAR", "oidIdioma", "valor", oidIdioma); 
                  }

                  traza("LPConsultaConcursoSeleccionado.cargarPantallaDetalleSolicitudes - Salida");
         }

         public void cargarCabeceraMultinivel() throws Exception {
                  traza("LPConsultaConcursoSeleccionado.cargarCabeceraMultinivel - Entrada");
         pagina("salidaGenerica");
         this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 

                  dtoCabecera = getCabecera();
                  String oidCampania = this.conectorParametroLimpia("oidCampania", "", true);
                  traza("****** oidCampania " + oidCampania);
                  dtoCabecera.setOidCampania(Long.valueOf(oidCampania));

                  MareBusinessID businessID = new MareBusinessID("INCConsultarMultinivel");
                  Vector parametros = new Vector();      
                  parametros.add(dtoCabecera);
                  parametros.add(businessID);

                  traza("******************* Antes de conectar");
                  DruidaConector con = conectar("ConectorConsultarMultinivel", parametros);		
                  traza("******************* Despues de conectar");
                  
                  DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida"); 		
                  traza("******************* dtoSalida " + dtoSalida);

                  RecordSet rs = dtoSalida.getResultado();
                  traza("******************* rs " + rs);

                  if(!rs.esVacio()) {
                           String codigoMadre = (String) rs.getValueAt(0,"LACODIGOMADRE");
                           traza("******************* codigoMadre" + codigoMadre);						
                           if(codigoMadre==null) codigoMadre = "";

                           String nombreApellido = (String) rs.getValueAt(0,"LANOMBREAPELLIDO");
                           traza("******************* nombreApellido" + nombreApellido);			
                           if(nombreApellido==null) nombreApellido = "";

                           String estado = (String) rs.getValueAt(0,"LAESTADO");
                           traza("******************* estado" + estado);			
                           if(estado==null) estado = "";

                           BigDecimal importeVenta = 
                           (BigDecimal) rs.getValueAt(0,"LAIMPORTEVENTA");		
                           traza("******************* importeVenta" + importeVenta);
                           String strImporteVenta;
                           if(importeVenta!=null) strImporteVenta = new String(importeVenta.toString());
                           else strImporteVenta = "";

                           BigDecimal importeInicial = 
                           (BigDecimal) rs.getValueAt(0,"LAIMPORTEINICIAL");
                           traza("******************* importeInicial" + importeInicial);
                           String strImporteInicial;
                           if(importeInicial!=null) strImporteInicial = new String(importeInicial.toString());
                           else strImporteInicial = "";

                           BigDecimal importePagado = 
                           (BigDecimal) rs.getValueAt(0,"LAIMPORTEPAGADO");
                           traza("******************* importePagado" + importePagado);
                           String strImportePagado;
                           if(importePagado!=null) strImportePagado = new String(importePagado.toString());
                           else strImportePagado = "";

                           String docIdentidad = (String) rs.getValueAt(0,"LADOCUMIDENTIDAD");
                           traza("******************* docIdentidad" + docIdentidad);			
                           if(docIdentidad==null) docIdentidad = "";

                           String zona = (String) rs.getValueAt(0,"LAZONA");
                           traza("******************* zona" + zona);
                           if(zona==null) zona = "";

                           String baseCalculo = (String) rs.getValueAt(0,"LABASECALCULO");
                           traza("******************* baseCalculo" + baseCalculo);
                           if(baseCalculo==null) baseCalculo = "";

                           String lograCalificacion = (String) rs.getValueAt(0,"LALOGRACALIFICACION");
                           traza("******************* lograCalificacion" + lograCalificacion);
                           if(lograCalificacion==null) lograCalificacion = "";

                           BigDecimal totalHijasInicio = 
                           (BigDecimal) rs.getValueAt(0,"LANROTOTALHIJASINICIO");
                           traza("******************* totalHijasInicio" + totalHijasInicio);
                           String strTotalHijasInicio;
                           if(totalHijasInicio!=null) strTotalHijasInicio = new String(totalHijasInicio.toString());
                           else strTotalHijasInicio = "";

                           BigDecimal hijasNuevas = 
                           (BigDecimal) rs.getValueAt(0,"LANROHIJASNUEVAS");
                           traza("******************* hijasNuevas" + hijasNuevas);
                           String strHijasNuevas;
                           if(hijasNuevas!=null) strHijasNuevas = new String(hijasNuevas.toString());
                           else strHijasNuevas = "";

                           BigDecimal totalHijasCierre = 
                           (BigDecimal) rs.getValueAt(0,"LANROTOTALHIJASCIERRE");
                           traza("******************* totalHijasCierre" + totalHijasCierre);
                           String strTotalHijasCierre;
                           if(totalHijasCierre!=null) strTotalHijasCierre = new String(totalHijasCierre.toString());
                           else strTotalHijasCierre = "";

                           BigDecimal hijasActivasCierre = 
                           (BigDecimal) rs.getValueAt(0,"LANROHIJASACTIVASCIERRE");
                           traza("******************* hijasActivasCierre" + hijasActivasCierre);
                           String strHijasActivasCierre;
                           if(hijasActivasCierre!=null) strHijasActivasCierre = new String(hijasActivasCierre.toString());
                           else strHijasActivasCierre = "";

                           BigDecimal promedioPedidoHijas = 
                           (BigDecimal) rs.getValueAt(0,"LAPROMEDIOPEDIDOHIJAS");
                           traza("******************* promedioPedidoHijas" + promedioPedidoHijas);
                           String strPromedioPedidoHijas;
                           if(promedioPedidoHijas!=null) strPromedioPedidoHijas = new String(promedioPedidoHijas.toString());
                           else strPromedioPedidoHijas = "";

                           BigDecimal pedidosHijasRed = 
                           (BigDecimal) rs.getValueAt(0,"LAPEDIDOSHIJASRED");
                           traza("******************* pedidosHijasRed" + pedidosHijasRed);
                           String strPedidosHijasRed;
                           if(pedidosHijasRed!=null) strPedidosHijasRed = new String(pedidosHijasRed.toString());
                           else strPedidosHijasRed = "";

                           String pedidosMadreRed = (String) rs.getValueAt(0,"LAPEDIDOSMADRERED");
                           traza("******************* pedidosMadreRed" + pedidosMadreRed);
                           if(pedidosMadreRed==null) pedidosMadreRed = "";

                           BigDecimal importeVentaRed = 
                           (BigDecimal) rs.getValueAt(0,"LAIMPORTEVENTARED");
                           traza("******************* importeVentaRed" + importeVentaRed);
                           String strImporteVentaRed;
                           if(importeVentaRed!=null) strImporteVentaRed = new String(importeVentaRed.toString()); 
                           else strImporteVentaRed = "";

                           asignarAtributo("VAR", "ejecutar", "valor", "cargarCabeceraMultinivel('"+
                                      codigoMadre + "','" +		
                                      nombreApellido + "','" +
                                  estado + "','" +
                             strImporteVenta + "','" +
                                      strImporteInicial + "','" +		
                                      strImportePagado + "','" +
                                  docIdentidad + "','" +
                             zona + "','" +
                                      baseCalculo + "','" +		
                                  lograCalificacion + "','" +
                             strTotalHijasInicio + "','" +
                                      strHijasNuevas + "','" +		
                                      strTotalHijasCierre + "','" +
                                  strHijasActivasCierre + "','" +
                             strPromedioPedidoHijas + "','" +
                                  strPedidosHijasRed + "','" +
                             pedidosMadreRed + "','" +
                                      strImporteVentaRed + "')");
                  }
                  else {
                           asignarAtributo("VAR", "ejecutar", "valor", "vuelveSinDatos()");
                  }

                  traza("LPConsultaConcursoSeleccionado.cargarCabeceraMultinivel - Salida");
         }
}
