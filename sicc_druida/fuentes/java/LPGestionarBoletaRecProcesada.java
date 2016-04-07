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
 *
 * Autor: Viviana Bongiovanni
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.sql.Timestamp;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.dtos.rec.DTOBuscarBolRecProcesadas;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LPGestionarBoletaRecProcesada extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
           
    public LPGestionarBoletaRecProcesada() {      
           super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
           try {      
           setTrazaFichero();
           String accion = conectorParametroLimpia("accion", "", true);
           traza("accion: " + accion);
           
           pais = UtilidadesSession.getPais(this);
           idioma = UtilidadesSession.getIdioma(this);
           
           if(accion.equals("") || accion.equals("gestionarBolProcesadas")) { 
             this.cargarPantalla();
             
           } else if(accion.equals("eliminarBolRecojoOK")){ 
             this.eliminarBolRecojoOK();              
           } 
           
      } catch (Exception e){   
             traza(e);      
             this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
    }
    

  private void eliminarBolRecojoOK() throws Exception{
      pagina("salidaGenerica");
           asignarAtributo("VAR","cerrarVentana","valor", "false");  
      
      try {      
             String txtFecCaptura = conectorParametroLimpia("txtFecCaptura", "", true); 
             String formatoFechaPais = conectorParametroLimpia("hFormatoFechaPais", "", true); 
             String cbEstado = conectorParametroLimpia("cbEstado", "", true); 
                    
             DTOBuscarBolRecProcesadas dtoBuscarBolRecProcesadas = new DTOBuscarBolRecProcesadas();      
             dtoBuscarBolRecProcesadas.setFechaCaptura(txtFecCaptura.equals("")?null:txtFecCaptura);
             dtoBuscarBolRecProcesadas.setFormatoFechaPais(formatoFechaPais);
             dtoBuscarBolRecProcesadas.setOidEstadoRecojo(cbEstado.equals("")?null:Long.valueOf(cbEstado));
             dtoBuscarBolRecProcesadas.setOidPais(pais);
             dtoBuscarBolRecProcesadas.setUsuario(UtilidadesSession.getIdUsuario(this));
             
             traza("dtoBuscarBolRecProcesadas: " + dtoBuscarBolRecProcesadas);
            
             MareBusinessID id = new MareBusinessID("RECEliminarBolRecojoOK");                
             Vector paramEntrada = new Vector();
         
             paramEntrada.add(dtoBuscarBolRecProcesadas);
             paramEntrada.add(id);
             traza("*************** Antes de conectar");
             DruidaConector con = conectar("ConectorEliminarBolRecojoOK", paramEntrada);             
             traza("*************** Despues de conectar");
             
             asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
             
             
      } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "focalizaFechaCaptura();");
           throw e;
      }
  }
    
  private void cargarPantalla() throws Exception{

    pagina("contenido_gestionar_boleta_rec_procesada");
    
    asignarAtributoPagina("cod", "3272");
    
    // Validaciones
    getFormatosValidaciones();
    
    String txtFecCaptura = conectorParametroLimpia("txtFecCaptura", "", true);
    String oidEstado = conectorParametroLimpia("oidEstado", "", true);
    
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));

         if(txtFecCaptura == ""){
                  Timestamp fec_actu = new Timestamp(System.currentTimeMillis()); 
                  java.sql.Date fd = new java.sql.Date(fec_actu.getTime()); 
                  traza("fecha actual: " + fd);            

                  txtFecCaptura = transformaFechas(fd);
         }

    asignarAtributo("VAR","hTxtFecCaptura","valor", txtFecCaptura);
    asignarAtributo("VAR","hOidEstado","valor", oidEstado);
         
    this.cargarCombos();
  }

    
  private void cargarCombos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
  
    traza(resultados.getXML());
           
    asignar("COMBO","cbEstado",resultados,"RECObtenerEstadoRecojo");   
  }
    
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
      ComposerViewElement estadoRecojo = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
             
      estadoRecojo.setIDBusiness("RECObtenerEstadoRecojo");
      estadoRecojo.setDTOE(dtoBel);
             
      lista.addViewElement(estadoRecojo);
      
      return lista;
    }

  private String transformaFechas(Date fechaBD) throws Exception { 
      
      traza("TransformaFechas");
      // Transforma las Fechas para mostrar en pantalla, en formato de Sesión.
      String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
      formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
      //traza("Antes: " + fechaBD.toString() );
      SimpleDateFormat sFormat = new SimpleDateFormat(formatoFechaSesion);
      String sBuffer = sFormat.format(fechaBD);
      //traza("Despues: " + sBuffer.toString() );

      return sBuffer;
    
  }

   
}

