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

import es.indra.sicc.dtos.mav.DTOEnvioIniFinPeriodo;
import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPEnvioIniFinPeriodo extends LPSICCBase {
    
    private String accion = null;
    private Long idioma;
    private Long pais;   

    
    public LPEnvioIniFinPeriodo() {
        super();
    }


    public void inicio() throws Exception {
        // Defino el nombre de la pantalla
        pagina("contenido_envio_inifin_periodo");
    }


    public void ejecucion() throws Exception {
        rastreo();
                              
        try {
            setTrazaFichero(); 
            traza("***Entrada - LPEnvioIniFinPeriodo - ejecucion***");
                
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            asignar("VAR", "idioma", idioma.toString());
            asignar("VAR", "pais", pais.toString()); 
            this.accion = conectorParametroLimpia("accion","",true);
            
            traza("***accion : " + accion);
                              
            asignarAtributo("PAGINA", "contenido_envio_inifin_periodo", "cod", "01071");
              
            if (accion.equals("")) {
                inicializar();
            } else if (accion.equals("aceptar")) {
                aceptar();
            }

            traza("***Salida - LPEnvioIniFinPeriodo - ejecucion***");
            
        } catch(Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }
     
    public void inicializar() throws Exception {
        try {
            traza("***Entrada - LPEnvioIniFinPeriodo - inicializar***");           
            obtenerDatosIniciales();

            getConfiguracionMenu("LPEnvioIniFinPeriodo", "");
            traza("***Salida - LPEnvioIniFinPeriodo - inicializar***");            
        } catch (Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }
          
    public void obtenerDatosIniciales() throws Exception {
        try {
              traza("***Entrada - LPEnvioIniFinPeriodo - obtenerDatosIniciales***");
              DTOBelcorp dtoe = new DTOBelcorp();
              
              Long pais = UtilidadesSession.getPais(this);
              Long idioma = UtilidadesSession.getIdioma(this);
              traza("obtenerDatosIniciales  ---------> pais: " + pais);
              traza("obtenerDatosIniciales  ---------> idioma: " + idioma);
              dtoe.setOidPais(pais);
              dtoe.setOidIdioma(idioma);
              
              String[] idNegocios = {"SEGConsultaMarcas", "SEGConsultaCanales", "MAVObtenerTiposDespachoIniFinPeriodo"};
              
              ArrayList dtos = new ArrayList();
              dtos.add(dtoe);
              dtos.add(dtoe);
              dtos.add(dtoe);
              traza("tamaño del arraylist de dtos: " + dtos.size());
                                             
              String[] combos = {"cbMarca", "cbCanal", "cbTipoDespacho"};
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

              traza("***Salida - LPEnvioIniFinPeriodo - obtenerDatosIniciales***");
        
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }

    public void aceptar() throws Exception {
      traza("***Entrada - LPEnvioIniFinPeriodo - aceptar***");
      pagina("salidaGenerica");
      
      DTOEnvioIniFinPeriodo dtoEnvioIniFinPeriodo = new DTOEnvioIniFinPeriodo();
      dtoEnvioIniFinPeriodo.setOidPais(this.pais);
      traza("---------------- Pais: " + this.pais);
      dtoEnvioIniFinPeriodo.setOidIdioma(this.idioma);
      traza("---------------- Idioma: " + this.idioma);
     
       // - marca: la de 'cbMarca' 
       String marca = conectorParametroLimpia("cbMarca", "", true);
       traza("---------------- marca: " + marca);
       dtoEnvioIniFinPeriodo.setMarca(new Long(marca));

       // - canal: el de 'cbCanal' 
       String canal = conectorParametroLimpia("cbCanal", "", true);
       traza("---------------- canal: " + canal);
       dtoEnvioIniFinPeriodo.setCanal(new Long(canal));

       // - periodo: el de 'cbPeriodo' 
       String periodo = conectorParametroLimpia("cbPeriodo", "", true);
       traza("---------------- periodo: " + periodo);
       dtoEnvioIniFinPeriodo.setPeriodo(new Long(periodo));

       // - actividades: lista de actividades
       String actividades = conectorParametroLimpia( "hActividades", "", true );
       traza("---------------- actividades: " + actividades);
       dtoEnvioIniFinPeriodo.setActividades(actividades.trim().equals("") ? null : this.obtenerActividades(actividades));
       
        Vector paramsEntrada = new Vector();
        
        paramsEntrada.add(dtoEnvioIniFinPeriodo);
        paramsEntrada.add(new MareBusinessID("MAVProcesarEnvioIniFinPeriodoMenu"));
        
        traza("Antes de utilizar ConectorProcesarEnvioIniFinPeriodo");
        DruidaConector conector = conectar("ConectorProcesarEnvioIniFinPeriodo", paramsEntrada);
        traza("Después de utilizar ConectorProcesarEnvioIniFinPeriodo");
        
        asignarAtributo("VAR", "cerrarVentana", "valor", "false");		
        asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
        traza("***Salida - LPEnvioIniFinPeriodo - aceptar***");
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

    private ArrayList obtenerActividades(String oidsActividades) throws Exception {
        StringTokenizer oidsActividadesTk = new StringTokenizer(oidsActividades,",");
        ArrayList actividades = new ArrayList();
        
        while (oidsActividadesTk.hasMoreTokens()) {
          Long oidActividad = new Long(oidsActividadesTk.nextToken());
          actividades.add(oidActividad);
        }
        return actividades;
    }
  
    protected void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
                             
        traza("Stack Trace: " + baos.toString());
    }

}   




