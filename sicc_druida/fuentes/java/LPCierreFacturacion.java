/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    $Id: LPCierreFacturacion.java,v 1.3 2011/08/18 22:35:11 peextsapaza Exp $
    DESC
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.fac.DTOCargaInicialCierre;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;


public class LPCierreFacturacion extends LPSICCBase {
    
    private String accion = null;
    private Long idioma;
    private Long pais;   

    
    public LPCierreFacturacion() {
           super();
    }


    public void inicio() throws Exception {
          // Defino el nombre de la vista
          pagina("contenido_cierre_tramitar");
    }


    public void ejecucion() throws Exception {
          
                    rastreo();
                              
                    try {
                    setTrazaFichero(); 
              traza("***Entrada - LPCierreFacturacion - ejecucion***");
                
                              this.idioma = UtilidadesSession.getIdioma(this);
                              this.pais = UtilidadesSession.getPais(this);
                              asignar("VAR", "idioma", idioma.toString());
                              asignar("VAR", "pais", pais.toString()); 
                              this.accion = conectorParametroLimpia("accion","",true);
                              
                              traza("***accion : " + accion);
                              
                              // nombre="contenido_cierre_tramitar" cod="0537" titulo="Tramitar Cierre"
                              asignarAtributo("PAGINA", "contenido_cierre_tramitar", "cod", "0537");
              asignarAtributo("PAGINA", "contenido_cierre_tramitar", "msgle", "Tramitar Cierre");
              getConfiguracionMenu("LPCierreFacturacion", "");
              
              // obtengo el valor de unas constantes de FAC que debo usar en la pagina y los
              // asigno a unas variables ocultas
              asignar("VAR", "ConstantesFAC_TIPO_CIERRE_PERIODO", ConstantesFAC.TIPO_CIERRE_PERIODO);
              asignar("VAR", "ConstantesFAC_TIPO_CIERRE_REGION", ConstantesFAC.TIPO_CIERRE_REGION);
              asignar("VAR", "ConstantesFAC_TIPO_CIERRE_ZONA", ConstantesFAC.TIPO_CIERRE_ZONA);

              if (accion.equals("")) {
                    inicializar();
              } else if (accion.equals("cerrar")) {
                    cerrar();
                    inicializar();
                    this.accion = "";  // Incidencia 11500
                    }
                              
                              traza("***Salida - LPCierreFacturacion - ejecucion***");
                    
                    } catch(Exception e) {
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
          }
     
          public void inicializar() throws Exception {
                    
                    try {
                              traza("***Entrada - LPCierreFacturacion - inicializar***");           
                    
                              // Carga la página PantallaCierreFacturacion 
                    
                              obtenerDatosIniciales();
                    
                              traza("***Salida - LPCierreFacturacion - inicializar***");            
                    } catch (Exception e) {
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
          }

          
          public void obtenerDatosIniciales() throws Exception {
          
                    try {
                              traza("***Entrada - LPCierreFacturacion - obtenerDatosIniciales***");

                              
                              DTOCargaInicialCierre dtoCarga = cargaInicialCierre();
                              
                              // sapaza -- PER-SiCC-2011-0594 -- 18/08/2011
                              if(dtoCarga.getIndicadorControlCierre().equals("1")) {
                            	  pagina("contenido_cierre_tramitar_prog");
                              }
                              
                              // alternativa: utilizar el metodo cargaCombo


                              // Crear un DTOBelcorp dtoe con: 
                              // - pais = Pais activo 
                              // - idioma = Idioma del usuario
                              DTOBelcorp dtoe = new DTOBelcorp();
                              
                              Long pais = UtilidadesSession.getPais(this);
                              Long idioma = UtilidadesSession.getIdioma(this);
                              traza("obtenerDatosIniciales  ---------> pais: " + pais);
                              traza("obtenerDatosIniciales  ---------> idioma: " + idioma);
                              dtoe.setOidPais(pais);
                           dtoe.setOidIdioma(idioma);
                              if (dtoe == null){
                              traza("obtenerDatosIniciales  ---------> dtobelcorp nulo");           
                              }else{
                              traza("obtenerDatosIniciales  ---------> dtobelcorp NO nulo");        
                              }

                              String[] idNegocios = {"SEGConsultaMarcas", "SEGConsultaCanales", "FACConsultaTiposCierre"};
                              //String[] idNegocios = {"SEGConsultaMarcas", "SEGConsultaCanales"};
                              
                              ArrayList dtos = new ArrayList();
                              dtos.add(dtoe);
                              dtos.add(dtoe);
                              dtos.add(dtoe);
                              traza("tamaño del arraylist de dtos: " + dtos.size());
                                                             
                              String[] combos = {"cbMarca", "cbCanal", "cbTipoCierre"};
                              //String[] combos = {"cbMarca", "cbCanal"};
                              traza("tamanio idNegocios: " + idNegocios.length);                     
                              traza("tamanio combos: " + combos.length);                     
                              
                              // cada usuario tiene una marca y canal por defecto que deben seleccionarse
                              Long marca = UtilidadesSession.getMarcaPorDefecto(this);
                              Long canal = UtilidadesSession.getCanalPorDefecto(this);

                              traza("marca en sesion: " + marca);
                              traza("canal en sesion: " + canal);

                              // el tercer valor de ambas matrices es "" porque el usuario no tiene un tipo de cierre por defecto
                              String[] seleccionados = {marca.toString(), canal.toString(), ""};
                              String[] columnas = {"VAL_OID", "VAL_OID", ""};
                              
                              cargaCombos(dtoe, 
                                                             idNegocios, 
                                                             dtos,
                                                             combos, 
                                                             seleccionados, 
                                                             columnas);

                              traza("despues de asignarCombos");                     
                              
                              // se asignan a los elementos de la pagina los valores por defecto del usuario
                              asignar("VAR", "marca", marca.toString());
                              traza("despues de asignar marca");                                                 
                              asignar("VAR", "canal", canal.toString()); 
                              traza("despues de asignar canal");
                              
                              // sapaza -- PER-SiCC-2011-0594 -- 18/08/2011
                              if(dtoCarga.getIndicadorControlCierre().equals("1")) {
	                              asignarAtributo( "VAR", "hFecha", "valor", hoyAString(dtoCarga.getFechaProceso()));
	                              asignarAtributo( "VAR", "hOidPeriodo", "valor", dtoCarga.getOidPeriodo().toString()); 
	                              
	                              String formato = UtilidadesSession.getFormatoFecha(this);
	                              asignarAtributo( "VAR", "hFormatoFecha", "valor", formato);
	                              
	                              asignar("VAR", "ConstantesFAC_TIPO_CIERRE_PERIODO", ConstantesFAC.TIPO_CIERRE_PERIODO);
	                              asignar("VAR", "ConstantesFAC_TIPO_CIERRE_REGION", ConstantesFAC.TIPO_CIERRE_REGION);
	                              asignar("VAR", "ConstantesFAC_TIPO_CIERRE_ZONA", ConstantesFAC.TIPO_CIERRE_ZONA);
                              }
                              
                              traza("***Salida - LPCierreFacturacion - obtenerDatosIniciales***");
                    
                    } catch (Exception e) {
                    e.printStackTrace();
              logStackTrace(e);
              lanzarPaginaError(e);
                    }
          }

          
          public void cerrar() throws Exception {
                    
                    try {
                              
                              traza("***Entrada - LPCierreFacturacion - cerrar***");
                              //pagina("salidaGenerica");
                              DTOFACCierreFacturacion dtoCierreFac = new DTOFACCierreFacturacion();
                              dtoCierreFac.setOidPais(this.pais);
                              traza("---------------- Pais: " + this.pais);
                              dtoCierreFac.setOidIdioma(this.idioma);
                              traza("---------------- Idioma: " + this.idioma);
                         
                              // - marca: la de 'cbMarca' 
                           String marca = conectorParametroLimpia("cbMarca", "", true);
                              traza("---------------- marca: " + marca);
                           dtoCierreFac.setMarca(new Long(marca));
          
                         // - canal: el de 'cbCanal' 
                           String canal = conectorParametroLimpia("cbCanal", "", true);
                              traza("---------------- canal: " + canal);
                           dtoCierreFac.setCanal(new Long(canal));
          
                         // - periodo: el de 'cdPeriodo' 
                         String periodo = conectorParametroLimpia("cbPeriodo", "", true);
                              traza("---------------- periodo: " + periodo);
                         dtoCierreFac.setPeriodo(new Long(periodo));
                         
                         String fecha = conectorParametroLimpia("hFecha", "", true);
                         if(fecha.length()>0)
                        	 dtoCierreFac.setFecha(stringAFecha(fecha));
                         
                         // - tipoCierre: el de 'cbTipoCierre' 
/*                      String tipoCierre = conectorParametroLimpia("cbTipoCierre", "", true);
                              traza("---------------- tipoCierre: " + tipoCierre);
                         dtoCierreFac.setTipoCierre(new Long(tipoCierre)); // se cambia de String a Long por BELC300011138*/
                         String oidtipoCierre = conectorParametroLimpia("cbTipoCierre", "", true);
                         String codtipoCierre = conectorParametroLimpia("codTipoCierre", "", true);                              
                              traza("----------------> OID tipoCierre: " + oidtipoCierre);
                              traza("----------------> COD tipoCierre: " + codtipoCierre);
                              /*
                              Long tipCie = null;
                              if (tipoCierre.equals("P")) {
                                         tipCie = new Long("1");
                              } else if (tipoCierre.equals("R")) {
                                         tipCie = new Long("2");
                              } else if (tipoCierre.equals("Z")) {
                                         tipCie = new Long("3");
                              }*/
          
                         dtoCierreFac.setTipoCierre(new Long(oidtipoCierre)); /*se por BELC300011138*/
                         dtoCierreFac.setCodigoTipoCierre(codtipoCierre);
                                         
                              // variables comunes para los combos multiples
                              ArrayList oids = null;
                              StringTokenizer st = null;
                              Long oid = null;
                              DTOOIDs dtoOids = null;
                              Long []matrizOids = null;
                              
                              // - regiones: el array 'listaRegiones' 
                              String listaRegiones = conectorParametroLimpia("listaRegiones", "", true);
                              traza("-------------- listaRegiones: " + listaRegiones);
                              st = new StringTokenizer(listaRegiones, "|");
                              oids = new ArrayList();
                              while (st.hasMoreTokens()) {
                                         oid = new Long(st.nextToken());
                                         oids.add(oid);      
                              }
                              matrizOids = new Long[oids.size()];
                              for (int i=0; i<oids.size(); i++) {
                                         matrizOids[i] = new Long(((Long)oids.get(i)).longValue());
                              }
          
                         dtoOids = new DTOOIDs();
                         dtoOids.setOids(matrizOids);
                         dtoCierreFac.setRegiones(dtoOids);
          
                         // - zonas: el array 'listaZonas' 
                         String listaZonas = conectorParametroLimpia("listaZonas", "", true);
                              traza("-------------- listaZonas: " + listaZonas);
                         st = new StringTokenizer(listaZonas, "|");
                         oids = new ArrayList();
                         
                              while (st.hasMoreTokens()) {
                                         oid = new Long(st.nextToken());
                                         oids.add(oid);      
                              }
                              int numeroZonas = oids.size();
                              if (numeroZonas > 0) {
                                         matrizOids = new Long[numeroZonas];
                    
                                         for (int i=0; i<oids.size(); i++) {
                                                   matrizOids[i] = new Long(((Long)oids.get(i)).longValue());
                                         }
          
                                         dtoOids = new DTOOIDs();
                           dtoOids.setOids(matrizOids);
                           dtoCierreFac.setZonas(dtoOids);
                              }
                              
                              // se llama a negocio
                              // Conector: ConectorCierreFacturacion 
                              // Fachada: MLNFCerrarFacturacion 

                              traza(dtoCierreFac);

                              Vector paramsEntrada = new Vector();
                              //Vector paramConector = new Vector();
                              
                              
                              
                              /*
                              paramConector.add(dtoCierreFac);  
                              paramConector.add(new MareBusinessID("FACCerrarFacturacion"));             
                              //paramConector.add(new MareBusinessID("FACBusinessDesconoci"));             
                              
                              traza("[ASF]Antes de Conectar ConectorCierreFacturacion");
                              DruidaConector conector = conectar("ConectorCierreFacturacion", paramConector);                                                    
                              traza("[ASF]Despues de Conectar ConectorCierreFacturacion");
                              //asignarAtributo("VAR", "ejecutar", "valor", "inserccionCorrecta()");
                                    */
                              
                              paramsEntrada.add(dtoCierreFac);
                              paramsEntrada.add(new MareBusinessID("FACCerrarFacturacion"));
                              traza("Antes de utilizar conectorCierreFacturacion");
                              DruidaConector conector = conectar("ConectorCierreFacturacion", paramsEntrada);
                              traza("Después de utilizar conectorCierreFacturacion");
                              
                              traza("***Salida - LPCierreFacturacion - cerrar***");
                                                             
                    } catch (Exception e) {
                    e.printStackTrace();
              logStackTrace(e);
              lanzarPaginaError(e);
                    }
          }
          
          private void cargaCombos(DTOBelcorp dtoBelcorp, 
                                                                                   String[] idNegocios, 
                                                                                   ArrayList dtos,
                                                                                   String[] combos, 
                                                                                   String[] seleccionados, 
                                                                                   String[] columnas) 
                    throws Exception 
          {
                    traza("*** Entrada - cargaCombos ***");
                    
                    try {
                              //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                              ComposerViewElementList listelem = new ComposerViewElementList();
                              ComposerViewElement elem = null;
                              
                              DTOBelcorp unDto = null;
          
                              for (int i = 0; i < idNegocios.length; i++) {
                                         elem=new ComposerViewElement(); 
                                         elem.setIDBusiness(idNegocios[i]);
                                         unDto = (DTOBelcorp)dtos.get(i);
                                         elem.setDTOE(unDto);
                                         // se especifica la posicion del OID y del campo con la descripcion
                                         elem.setPosOID(new Byte("0").byteValue()); 
                                         elem.setPosDesc(new Byte("1").byteValue()); 
                                         
                                         listelem.addViewElement(elem);
                              }

                              /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
                              ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());

                              conector.ejecucion();

                              DruidaConector conConsultar = conector.getConector();
          
                              /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
                              //correspondiente utilizando el String que representa el BusinessID en cada caso. */
                              if (seleccionados == null) {
                                         for(int j = 0; j < combos.length; j++) {
                                                   asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
                                         }
                              } else {
                                         for (int j = 0; j < combos.length; j++) {
                                                   if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals("")) {
                                                             asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
                                                   } else {
                                                      asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
                                             }
                                         }
                              }             
                    } catch (Exception ex) {
                              this.logStackTrace(ex);
                    }
                    traza("*** Salida - cargaCombos ***");
          }


          protected void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                                         
                    traza("Stack Trace: " + baos.toString());
    }

      private String hoyAString(java.sql.Date fechaProceso) throws Exception {
          String formato = UtilidadesSession.getFormatoFecha(this);
          
          traza("Formato fecha: "+formato);
          int pos = formato.indexOf("mm");
          if ( pos > -1) 
              formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
          SimpleDateFormat sdf = new SimpleDateFormat(formato);
          String fecha = "";
          
          if(fechaProceso != null)
        	  fecha = sdf.format(fechaProceso);
          else
        	  fecha = sdf.format(new java.util.Date());
          
          traza("Fecha: "+fecha);

          return fecha;
      }

      private java.util.Date stringAFecha(String fecha) throws Exception {
          if (fecha.trim().equals(""))
              return null;
          String formato = UtilidadesSession.getFormatoFecha(this);
          int pos = formato.indexOf("mm");
          if ( pos > -1) 
              formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
          SimpleDateFormat sdf = new SimpleDateFormat(formato);

          return sdf.parse(fecha);
          
      }

      private DTOCargaInicialCierre cargaInicialCierre() throws Exception {
          traza("Inicio cargaInicialCierre");
          DTOBelcorp dtoBel = new DTOBelcorp();
          dtoBel.setOidPais(UtilidadesSession.getPais(this));
          dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

          MareBusinessID bizId = new MareBusinessID("FACCargaInicialCierre");

          Vector params = new Vector();
          params.addElement( dtoBel );
          params.addElement( bizId );

          traza( "Antes conector: " + dtoBel);
          DruidaConector dc  =	conectar( "ConectorCargaInicialMonitor" , params );
          traza( "dc ");

          DTOCargaInicialCierre dtoS = (DTOCargaInicialCierre) dc.objeto("dtoSalida");
          return dtoS;
      }

}   




