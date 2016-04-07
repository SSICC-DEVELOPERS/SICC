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
 * 
 * Autor: Viviana Bongiovanni
 */

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTONivelPremiacion;
import es.indra.sicc.dtos.inc.DTOPremioPuntos;
import es.indra.sicc.dtos.inc.DTOPremioMonetario;
import es.indra.sicc.dtos.inc.DTOPremioDescuento;
import es.indra.sicc.dtos.inc.DTOPremioArticulo;
import es.indra.sicc.dtos.inc.DTOArticulo;
import es.indra.sicc.dtos.inc.DTOParametrosCalificacion;
import es.indra.sicc.dtos.inc.DTOPagoMonetario;
import es.indra.sicc.dtos.inc.DTOProductosLote;
import es.indra.sicc.dtos.inc.DTOLotesPremio;
import es.indra.sicc.dtos.inc.DTOProgramaNuevas;
import es.indra.sicc.dtos.inc.DTOPedidoPremiar;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.math.BigDecimal;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

// borrar poner incentivos ranking
public class LPMantenerPremiosRanking extends LPIncentivosRanking {

  DTOConcurso dtoConcurso = null;

         public LPMantenerPremiosRanking() {
           super();
         }  

         public void inicio() throws Exception {	
      pagina("contenido_premios_ranking_mantener");
         }

         public void ejecucion() throws Exception{

                  setTrazaFichero();

                  accion = conectorParametroLimpia("accion", "", true);
                  opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

                  asignarAtributo("VAR", "accion", "valor", accion);
    asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
   
                  traza("opcionMenu: " + opcionMenu);
    traza("accion: " + accion);
    
    traza("idPestanyaDest: " + conectorParametroLimpia("idPestanyaDest", "", true));
    
    try{
    
         // Pestañas
         super.obtenerFlagsPestanyas();
    
         // Seteo Pais e Idioma
         Long pais = UtilidadesSession.getPais(this);
         Long idioma = UtilidadesSession.getIdioma(this);
    
         asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()) );
         asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()) );    
 
         if(opcionMenu.equals("Crear Concurso Ranking")){
            asignarAtributoPagina("cod", "0508");
         } else if(opcionMenu.equals("Consultar Concurso Ranking")){
            asignarAtributoPagina("cod", "0525");
         } else if(opcionMenu.equals("Modificar Concurso Ranking")){
            asignarAtributoPagina("cod", "0524");
         }
         
         //Obtengo el consurso de session
         dtoConcurso = super.getConcurso();
  
         traza("dtoConcurso inicial: " + dtoConcurso);
         

         // Acciones
         if( accion.equals("") ){
              this.cargarPantalla();
         } else if( accion.equals("cargar mantener nivel") ){
              this.cargarPantallaMantenerNivel();
         } else if( accion.equals("almacenar niveles") ){
              this.almacenarNivel();
         } else if( accion.equals("almacenar") ){
              this.almacenar();
              super.redirigir();
         } else if( accion.equals("guardar") ){
              this.almacenar();
              super.guardar();
         } else if( accion.equals("redirigir") ){
              super.redirigir();
         }

    }catch (Exception e){   
  
        traza(e);      
        this.lanzarPaginaError(e);
  
    }
     // Configura menu secundario
          getConfiguracionMenu();

         }//fin ejecucion
  

  public void cargarPantalla() throws Exception {
      // Validaciones
      this.getFormatosValidaciones();         
      
      // Pestañas - asigna los hiddens
      super.cargarFlagsPestanyas();
      
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null && dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           traza("antes del conector.ejecucion");
           conector.ejecucion();
           traza("luego del conector");
           DruidaConector resultados = conector.getConector();
           
           traza("antes de asignar al COMBO");  
           asignar("COMBO","cbPeriodoDespacho",resultados,"CRAObtienePeriodos");   
           traza("despues de asignar al COMBO");      
      
      }
     
      // Manejo de habilitaciones
      asignarAtributo("VAR","IND_ACTIVO","valor", ConstantesINC.IND_ACTIVO.equals(new Integer(1))?"S":"N");
      asignarAtributo("VAR","IND_INACTIVO","valor", ConstantesINC.IND_INACTIVO.equals(new Integer(1))?"S":"N");
     
      
      // Carga los datos de la pestaña si ya fue cargada
      if(dtoConcurso.getIndPremios()!=null && dtoConcurso.getIndPremios().booleanValue()){
           traza("Se ha rellenado la pestania");
           asignarAtributo("VAR","oidParamGralesPremiacion","valor", convString(dtoConcurso.getParamGralesPremiacion().getOidParamGralesPremiacion()));           
           asignarAtributo("CTEXTO","txtNumNiveles","valor", convString(dtoConcurso.getParamGralesPremiacion().getNroNiveles()));           
           asignarAtributo("VAR","hCbPeriodoDespacho","valor", convString(dtoConcurso.getParamGralesPremiacion().getOidPeriodo()));           
           asignarAtributo("CHECKBOX","ckComunicacion","check", checkValor(dtoConcurso.getParamGralesPremiacion().getIndComunicacion()));
           
           if(checkValor(dtoConcurso.getParamGralesPremiacion().getIndComunicacion()).equals("S"))
                asignarAtributo("CTEXTO","txtMensaje","valor", convString(dtoConcurso.getParamGralesPremiacion().getMensaje()));

           
           // Carga los datos de los niveles
           if(dtoConcurso.getIndNivelPremiacion()!=null && dtoConcurso.getIndNivelPremiacion().booleanValue()){
                // Guarda en una variable de session el DTONivelesPremiacion
                DTONivelesPremiacion dtoNivelesPremiacion = dtoConcurso.getListaNivelesPremiacion();
                dtoNivelesPremiacion.setNumeroPremioMax(dtoConcurso.getParamGralesPremiacion().getNumeroPremio());
                this.setNivelesPremiacion(dtoNivelesPremiacion);
           } else {
                this.setNivelesPremiacion(null);
           }
           
      } else {
           this.setNivelesPremiacion(null);
      }
      
  }  


  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
            
      DTOPeriodo dtoP = new DTOPeriodo();
      dtoP.setOidPais(UtilidadesSession.getPais(this));
      dtoP.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoP.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
      dtoP.setCanal(dtoConcurso.getParamGenerales().getOidCanal());
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null && dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           ComposerViewElement combo2 = new ComposerViewElement();         
           combo2.setIDBusiness("CRAObtienePeriodos");
           combo2.setDTOE(dtoP);
                
           lista.addViewElement(combo2);
      }
      
      return lista;
  }
  
  
  // Convierte el valor del check de boolean a String
  private String checkValor(Boolean val) throws Exception {
      if(val !=null && val.booleanValue()){
           return "S";
      } else if(val !=null && !val.booleanValue()) {
           return "N";
      } else
           return "";
  }
  
  
  // Controla valores nulos
  private String convString(Object val) throws Exception {
      if(val !=null)
           return val.toString();     
      else
           return "";
  }
  
  
  public void cargarPantallaMantenerNivel() throws Exception {
  
      pagina("contenido_nivel_ranking_mantener");
      // Validaciones
      this.getFormatosValidaciones();     
      
      opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
      asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      
      // Carga de combo de datos Niveles
      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      Vector paramEntrada  = new Vector();
      paramEntrada.add(dtoBel);
      paramEntrada.add(new MareBusinessID("INCObtenerTipoPremio"));
             
                           traza("antes conector tipo premio");
                           DruidaConector conectorTipoPremio = conectar("ConectorObjeto", paramEntrada);
                           traza("despues conector tipo premio");
      
      DTOSalida dtoSalida = (DTOSalida)conectorTipoPremio.objeto("DTOSalida");
      RecordSet rsTipoPremio = agregarBlanco(dtoSalida);
      
      asignar("COMBO","cbTipoPremio",generarConector("ROWSET", rsTipoPremio, (Vector)rsTipoPremio.getColumnIdentifiers()),"ROWSET");
        
      // Carga de combos de las capas
      ComposerViewElementList cv = crearParametrosEntradaNiveles();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      traza("antes del conector.ejecucion");
      conector.ejecucion();
      traza("despues del conector");
      DruidaConector resultados = conector.getConector();
    
      traza("antes de asignar los COMBOS");
      // Puntos
      asignar("COMBO","cbConcursoDestino",resultados,"INCCargarNroConcursoVersion");    
      asignar("COMBO","cbTipoPremioPuntos1",resultados,"INCObtenerTipoPremiosPuntos");    
      // Monetario
      asignar("COMBO","cbTipoPremioMonetario2",resultados,"INCObtenerTipoPremioMonetario");        
      asignar("COMBO","cbMoneda",resultados,"SEGObtenerMonedasPorPais");   
      asignar("COMBO","cbFormaPago",resultados,"INCObtenerFormaPago");    
      asignar("COMBO","cbCumplimiento",resultados,"INCObtenerTipoCumplimiento");   
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null && dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           asignar("COMBO","cbPeriodoControl",resultados,"CRAObtienePeriodos"); 
      }
      // Descuento
      asignar("COMBO","cbTipoPremioDescuento5",resultados,"INCObtenerTipoDescuento");   
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null && dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           asignar("COMBO","cbPeriodoAplicacionDesde",resultados,"CRAObtienePeriodos");    
           asignar("COMBO","cbPeriodoAplicacionHasta",resultados,"CRAObtienePeriodos");    
      }
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null) {
           asignar("COMBO","cbMarca",resultados,"SEGRecuperarMarcasProductoMP");   
      }
      asignar("COMBO","cbUnidadNegocio",resultados,"MAEObtenerUnidadesNegocioPorPais");   
      asignar("COMBO","cbNegocio",resultados,"MAEObtenerNegocioPorPais");    
      asignar("COMBO","cbSupergenerico",resultados,"MAEObtenerSuperGenericosPorPais");    
      asignar("COMBO","cbGenerico",resultados,"MAEObtenerGenericosPorPais");   
      
      //Articulos
      asignar("COMBO","cbCenServGar",resultados,"INCObtenerCentroServicio");   
      asignar("COMBO","cbCenServEntrega",resultados,"INCObtenerCentroServicio");
      
      traza("despues de asignar los COMBOS");
      
      asignarAtributo("VAR","hOidMarca","valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
      
      // Hidden para habilitaciones
      asignarAtributo("VAR","IND_ACTIVO","valor", ConstantesINC.IND_ACTIVO.equals(new Integer(1))?"S":"N");
      asignarAtributo("VAR","IND_INACTIVO","valor", ConstantesINC.IND_INACTIVO.equals(new Integer(1))?"S":"N");     
      asignarAtributo("VAR","OID_TIPO_PREMIO_PUNTOS","valor", ConstantesINC.OID_TIPO_PREMIO_PUNTOS.toString());
      asignarAtributo("VAR","OID_TIPO_PREMIO_MONETARIO","valor", ConstantesINC.OID_TIPO_PREMIO_MONETARIO.toString());
      asignarAtributo("VAR","OID_TIPO_PREMIO_ARTICULO","valor", ConstantesINC.OID_TIPO_PREMIO_ARTICULO.toString());
      asignarAtributo("VAR","OID_TIPO_PREMIO_DESCUENTO","valor", ConstantesINC.OID_TIPO_PREMIO_DESCUENTO.toString());
      
      // Puntos
      asignarAtributo("VAR","OID_TIPO_PREM_PTOS_CANT_FIJA","valor", ConstantesINC.OID_TIPO_PREM_PTOS_CANT_FIJA.toString());
      asignarAtributo("VAR","OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT.toString());
      asignarAtributo("VAR","OID_TIPO_PREM_PTOS_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_PTOS_PUNTAJE_OBT.toString());
      // Monetario
      asignarAtributo("VAR","OID_TIPO_PREM_MONET_CANT_FIJA","valor", ConstantesINC.OID_TIPO_PREM_MONET_CANT_FIJA.toString());
      asignarAtributo("VAR","OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT.toString());
      asignarAtributo("VAR","OID_TIPO_PREM_MONET_PUNTAJE_OBT","valor", ConstantesINC.OID_TIPO_PREM_MONET_PUNTAJE_OBT.toString());
      asignarAtributo("VAR","OID_TIPO_DET_METAS_BONO_ANUAL","valor", ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.toString());
      asignarAtributo("VAR","OID_TIPO_CUMPLIMIENTO_TOTAL","valor", ConstantesINC.OID_TIPO_CUMPLIMIENTO_TOTAL.toString());
      
      asignarAtributo("VAR","hOidTipoDeterminacionMetas","valor", "");
      
      // Descuento
      asignarAtributo("VAR","OID_TIPO_DESCUENTO_IMPORTE","valor", ConstantesINC.OID_TIPO_DESCUENTO_IMPORTE.toString());
      asignarAtributo("VAR","OID_TIPO_DESCUENTO_PORCENTAJE","valor", ConstantesINC.OID_TIPO_DESCUENTO_PORCENTAJE.toString());
      
      // Borrar ver si debe ir
      // Articulos
      String indPremiosElectivos = conectorParametroLimpia("hIndPremiosElectivosPremios", "", true);  
      asignarAtributo("VAR","hIndPremiosElectivosPremios","valor", indPremiosElectivos);
      
      // Carga la lista datos de Niveles
      // Número de niveles a visualizar
      String numeroNiveles = conectorParametroLimpia("numeroNiveles", "", true);  
      int numNiveles = Integer.valueOf(numeroNiveles).intValue();
      
      asignarAtributo("VAR","numeroNiveles","valor", numeroNiveles);
      
      // Recordset auxiliar
      RecordSet rs = new RecordSet();          
      rs.addColumn("oid");
      rs.addColumn("numNivel");
      rs.addColumn("puntajeServicio");
      rs.addColumn("tipoPremio");
      rs.addColumn("nivelElegible");    
      rs.addColumn("cantFijaPuntos");
      rs.addColumn("cantDesde");
      rs.addColumn("cantHasta");
      rs.addColumn("puntosProdExigidos");        
      rs.addColumn("numAspirantes");    
      rs.addColumn("oidNivel"); 
      
      // Lista de niveles premiacion
      DTONivelesPremiacion dtoNivelesPremiacion = this.getNivelesPremiacion();
      int cantNiveles = 0;
      StringBuffer datosNiveles = new StringBuffer();
      int numPremio = 0;
      
      if(dtoNivelesPremiacion!=null) {
           // Cantidad de niveles ingresados por el usuario
           cantNiveles = dtoNivelesPremiacion.getListaNiveles()==null?0:dtoNivelesPremiacion.getListaNiveles().length;
      }
      
      // El usuario ha ingresado niveles
      if(dtoConcurso.getIndNivelPremiacion().booleanValue() || cantNiveles!=0 ){
           traza("Hay registros de niveles");
           DTONivelPremiacion[] dtoNivelPremiacionArr = dtoNivelesPremiacion.getListaNiveles();
           DTONivelPremiacion dtoNivelPremiacion = null;
           DTOPremioPuntos dtoPremioPuntos = null;
           DTOPremioMonetario dtoPremioMonetario = null;
           DTOPremioDescuento dtoPremioDescuento = null;
           DTOPremioArticulo dtoPremioArticulo = null;
           ArrayList arrLstArticulos = null;
           StringBuffer articulos = new StringBuffer();
           DTOArticulo dtoArticulo = null;     
           ArrayList arrLstPagos = null;
           StringBuffer pagos = null;
           DTOPagoMonetario dtoPagoMonetario = null;  
           ArrayList arrLstLotes = null;
           StringBuffer lotes = null;
           ArrayList arrLstProdLotes = null;
           StringBuffer prodLotes = null;
           DTOLotesPremio dtoLotesPremio = null;
           DTOProductosLote dtoProductosLote = null;
           
           
           traza("numNiveles: " + numNiveles);
           traza("cantNiveles: " + cantNiveles);
           
           for(int i=0; i<numNiveles; i++){
                if(i<cantNiveles) {
                    // Se desea visualizar este nivel ingresado por el usuario
                    dtoNivelPremiacion = dtoNivelPremiacionArr[i];
                    traza("dtoNivelPremiacion: " + dtoNivelPremiacion);
                    traza("1");
                    rs.addRow(new Object[] {
                         Integer.toString(i), 
                         dtoNivelPremiacion.getNumeroNivel()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getNumeroNivel().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getPuntajeServicio()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getPuntajeServicio().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getOidTipoPremio(),
                         dtoNivelPremiacion.getIndNivelSelectivo()==null?"N":(dtoNivelPremiacion.getIndNivelSelectivo().booleanValue()?"S":"N"),
                         dtoNivelPremiacion.getCantidadFijaPuntos()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getCantidadFijaPuntos().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getCantidadDesde()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getCantidadDesde().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getCantidadHasta()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getCantidadHasta().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getPuntosProductosExigidos()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dtoNivelPremiacion.getPuntosProductosExigidos().toString(), this.FORMATO_DEFAULT, this),
                         dtoNivelPremiacion.getNumeroAspirantes()==null?"":dtoNivelPremiacion.getNumeroAspirantes().toString(),
                         dtoNivelPremiacion.getOid()==null?"":dtoNivelPremiacion.getOid().toString()});    
                    traza("2");
                         // Arma registro de niveles
                         if(dtoNivelPremiacion.getIndPremiosPuntos().booleanValue()){
                             dtoPremioPuntos = dtoNivelPremiacion.getPremioPuntos();
                             traza("3");
                             datosNiveles.append("%").append(Integer.toString(i).toString());
                             datosNiveles.append("#").append(ConstantesINC.OID_TIPO_PREMIO_PUNTOS.toString());
                             datosNiveles.append("#").append(dtoPremioPuntos.getNumeroPremio().toString());
                             datosNiveles.append("#").append(dtoPremioPuntos.getOidConcursoDestino().toString());
                             datosNiveles.append("#").append(dtoPremioPuntos.getOidTipoPremioPuntos().toString());
                             datosNiveles.append("#").append(dtoPremioPuntos.getCantidad()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioPuntos.getCantidad().toString(), this.FORMATO_DEFAULT, this));
                             datosNiveles.append("#").append(dtoPremioPuntos.getPorcentaje()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioPuntos.getPorcentaje().toString(), this.FORMATO_DEFAULT, this));
                             datosNiveles.append("#").append(dtoPremioPuntos.getOidPremioPuntos()==null?"BLANCO":dtoPremioPuntos.getOidPremioPuntos().toString());
                             traza("4");
                             // Busca el maximo numero de premio ingresado
                             if(numPremio < dtoPremioPuntos.getNumeroPremio().intValue()){
                                  numPremio = dtoPremioPuntos.getNumeroPremio().intValue(); 
                             }
                             
                         } else if(dtoNivelPremiacion.getIndPremiosDescuento().booleanValue()){
                             dtoPremioDescuento = dtoNivelPremiacion.getPremioDescuento();
                             traza("5");
                             datosNiveles.append("%").append(Integer.toString(i).toString());
                             datosNiveles.append("#").append(ConstantesINC.OID_TIPO_PREMIO_DESCUENTO.toString());
                             datosNiveles.append("#").append(dtoPremioDescuento.getNumeroPremio().toString());
                             datosNiveles.append("#").append(dtoPremioDescuento.getOidTipoDescuento().toString());
                             datosNiveles.append("#").append(dtoPremioDescuento.getCantidadDescuento()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioDescuento.getCantidadDescuento().toString(), this.FORMATO_MONEDA, this));
                             datosNiveles.append("#").append(dtoPremioDescuento.getPorcentajeDescuento()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioDescuento.getPorcentajeDescuento().toString(), this.FORMATO_DEFAULT, this));                             
                             datosNiveles.append("#").append(dtoPremioDescuento.getOidPeriodoAplicacionDesde()==null?"BLANCO":dtoPremioDescuento.getOidPeriodoAplicacionDesde().toString());
                             datosNiveles.append("#").append(dtoPremioDescuento.getOidPeriodoAplicacionHasta()==null?"BLANCO":dtoPremioDescuento.getOidPeriodoAplicacionHasta().toString());
                             datosNiveles.append("#").append(dtoPremioDescuento.getOidPremioDescuento()==null?"BLANCO":dtoPremioDescuento.getOidPremioDescuento().toString());
                             traza("6");
                             // Busca el maximo numero de premio ingresado
                             if(numPremio < dtoPremioDescuento.getNumeroPremio().intValue()){
                                  numPremio = dtoPremioDescuento.getNumeroPremio().intValue(); 
                             }
                             traza("7");
                             // Obtiene los articulos
                             arrLstArticulos = dtoPremioDescuento.getLstArticulos();
                             traza("8");
                             if(arrLstArticulos!=null){
                                  articulos = new StringBuffer();
                                  int cantArt = arrLstArticulos.size();
                                  traza("cantArt: " + cantArt);
                                                                  traza("arrLstArticulos: " + arrLstArticulos);
                                  
                                  for(int j=0; j<cantArt; j++){
                                      dtoArticulo = (DTOArticulo)arrLstArticulos.get(j);
                                      
                                      articulos.append("|").append(dtoArticulo.getMarca());
                                      articulos.append("&").append(dtoArticulo.getUnidadNegocio()==null?"BLANCO":dtoArticulo.getUnidadNegocio());
                                      articulos.append("&").append(dtoArticulo.getNegocio()==null?"BLANCO":dtoArticulo.getNegocio());
                                      articulos.append("&").append(dtoArticulo.getSupergenerico()==null?"BLANCO":dtoArticulo.getSupergenerico());
                                      articulos.append("&").append(dtoArticulo.getGenerico()==null?"BLANCO":dtoArticulo.getGenerico());
                                      articulos.append("&").append(dtoArticulo.getCodigoProducto()==null?"BLANCO":dtoArticulo.getCodigoProducto());
                                      articulos.append("&").append(dtoArticulo.getOidMarca().toString());
                                      articulos.append("&").append(dtoArticulo.getOidUnidadNegocio()==null?"BLANCO":dtoArticulo.getOidUnidadNegocio().toString());
                                      articulos.append("&").append(dtoArticulo.getOidNegocio()==null?"BLANCO":dtoArticulo.getOidUnidadNegocio().toString());
                                      articulos.append("&").append(dtoArticulo.getOidSupergenerico()==null?"BLANCO":dtoArticulo.getOidSupergenerico().toString());
                                      articulos.append("&").append(dtoArticulo.getOidGenerico()==null?"BLANCO":dtoArticulo.getOidGenerico().toString());
                                      articulos.append("&").append(dtoArticulo.getOidProducto()==null?"BLANCO":dtoArticulo.getOidProducto().toString());
                                      articulos.append("&").append(dtoArticulo.getOidProductoDescuento()==null?"BLANCO":dtoArticulo.getOidProductoDescuento().toString());
                                      
                                  }
                                  datosNiveles.append("#").append(articulos.length()==0?"BLANCO":articulos.toString().substring(1));
                                  
                                  traza("10");
                             } else {
                                  datosNiveles.append("#BLANCO");
                             }
                             
                         } else if(dtoNivelPremiacion.getIndPremiosMonetarios().booleanValue()){
                             dtoPremioMonetario = dtoNivelPremiacion.getPremioMonetario();
                             traza("11");
                             datosNiveles.append("%").append(Integer.toString(i).toString());
                             datosNiveles.append("#").append(ConstantesINC.OID_TIPO_PREMIO_MONETARIO.toString());
                             datosNiveles.append("#").append(dtoPremioMonetario.getNumeroPremio().toString());
                             datosNiveles.append("#").append(dtoPremioMonetario.getOidTipoPremioMonetario().toString());
                             datosNiveles.append("#").append(dtoPremioMonetario.getCantidad()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioMonetario.getCantidad().toString(), this.FORMATO_MONEDA, this));
                             datosNiveles.append("#").append(dtoPremioMonetario.getPorcentaje()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoPremioMonetario.getPorcentaje().toString(), this.FORMATO_DEFAULT, this));                             
                             datosNiveles.append("#").append(dtoPremioMonetario.getOidMoneda().toString());
                             datosNiveles.append("#").append(dtoPremioMonetario.getOidFormaPago().toString());
                             datosNiveles.append("#").append(dtoPremioMonetario.getOidPremioMonetario()==null?"BLANCO":dtoPremioMonetario.getOidPremioMonetario().toString());
                             traza("12");
                             // Busca el maximo numero de premio ingresado
                             if(numPremio < dtoPremioMonetario.getNumeroPremio().intValue()){
                                  numPremio = dtoPremioMonetario.getNumeroPremio().intValue(); 
                             }
                             traza("13");
                             // Verifica Otros Datos
                             if(dtoConcurso.getParamCalificacion()!= null && 
                                 ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.equals(dtoConcurso.getParamCalificacion().getOidTipoDeterminacionMetas())) {
                                 
                                 // Hay Otros Datos
                                 datosNiveles.append("#").append(dtoPremioMonetario.getIndPagoPartes().booleanValue()?"S":"N");
                                 datosNiveles.append("#").append(dtoPremioMonetario.getOidCumplimiento()==null?"BLANCO":dtoPremioMonetario.getOidCumplimiento().toString());
                                 datosNiveles.append("#").append(dtoPremioMonetario.getIndDescontarPagosAnticipados().booleanValue()?"S":"N");
                             
                                  // Obtiene los Pagos
                                  arrLstPagos = dtoPremioMonetario.getLstPagosMonetarios();
                                  
                                  if(arrLstPagos!=null){
                                      pagos = new StringBuffer();
                                      int cantPagos = arrLstPagos.size();
                                      traza("cantPagos: " + cantPagos);
                                      
                                      for(int j=0; j<cantPagos; j++){
                                           dtoPagoMonetario = (DTOPagoMonetario)arrLstPagos.get(j);
                                           
                                           pagos.append("|").append(dtoPagoMonetario.getNumeroPago());
                                           pagos.append("&").append(UtilidadesBelcorp.formateaNumeroSICC(dtoPagoMonetario.getPremio().toString(), this.FORMATO_DEFAULT, this));
                                           pagos.append("&").append(dtoPagoMonetario.getPeriodoControl());
                                           pagos.append("&").append(dtoPagoMonetario.getOidPeriodoControl());                                           
                                           pagos.append("&").append(dtoPagoMonetario.getOidPagoMonetario()==null?"BLANCO":dtoPagoMonetario.getOidPagoMonetario().toString());
                                           
                                      }
                                      datosNiveles.append("#").append(pagos.length()==0?"BLANCO":pagos.toString().substring(1));
                                      
                                      
                                  } else {
                                      datosNiveles.append("#BLANCO");
                                  }
                             
                             } else {
                                  // No hay Otros Datos
                                  datosNiveles.append("#BLANCO");
                                  datosNiveles.append("#BLANCO");
                                  datosNiveles.append("#BLANCO");
                                  datosNiveles.append("#BLANCO");
                             }
                         } else if(dtoNivelPremiacion.getIndPremiosArticulos().booleanValue()){
                             dtoPremioArticulo = dtoNivelPremiacion.getPremioArticulo();
                             traza("14");
                             datosNiveles.append("%").append(Integer.toString(i).toString());
                             datosNiveles.append("#").append(ConstantesINC.OID_TIPO_PREMIO_ARTICULO.toString());                            
                             datosNiveles.append("#").append(dtoPremioArticulo.getNumeroUnidadesPremioArticulo().toString());     
                             datosNiveles.append("#").append(dtoPremioArticulo.getOidPremioArticulo()==null?"BLANCO":dtoPremioArticulo.getOidPremioArticulo().toString());
                            
                             // Obtiene los Lotes
                             arrLstLotes = dtoPremioArticulo.getLstLotesPremio();
                             
                             if(arrLstLotes!=null){
                                  lotes = new StringBuffer();
                                  int cantLotes = arrLstLotes.size();
                                  traza("cantLotes: " + cantLotes);
                                  
                                  for(int j=0; j<cantLotes; j++){
                                      dtoLotesPremio = (DTOLotesPremio)arrLstLotes.get(j);
                                      
                                      // Busca el maximo numero de premio ingresado
                                      if(numPremio < dtoLotesPremio.getNumeroPremio().intValue()){
                                           numPremio = dtoLotesPremio.getNumeroPremio().intValue(); 
                                      }
                                      
                                      lotes.append("$").append(dtoLotesPremio.getNumeroPremio());
                                      lotes.append(";").append(dtoLotesPremio.getDescripcionLote());                                                                                
                                      
                                      // Obtiene los Lotes
                                      arrLstProdLotes = dtoLotesPremio.getLstProductosLote();
                                      
                                      if(arrLstProdLotes!=null){
                                      
                                           int cantProdLotes = arrLstProdLotes.size();
                                           traza("cantProdLotes: " + cantProdLotes);
                                           
                                           prodLotes = new StringBuffer();
                                           
                                           for(int k=0; k<cantProdLotes; k++){
                                           
                                                dtoProductosLote = (DTOProductosLote)arrLstProdLotes.get(k);
                                           
                                                prodLotes.append("|").append(dtoProductosLote.getCodigoProducto());
                                                prodLotes.append("&").append(UtilidadesBelcorp.formateaNumeroSICC(dtoProductosLote.getNumeroUnidades().toString(), this.FORMATO_DEFAULT, this));                            
                                                prodLotes.append("&").append(UtilidadesBelcorp.formateaNumeroSICC(dtoProductosLote.getPrecioPublico().toString(), this.FORMATO_MONEDA, this));                            
                                                prodLotes.append("&").append(dtoProductosLote.getIndDespachaArticulo().booleanValue()?"S":"N");
                                                prodLotes.append("&").append(dtoProductosLote.getCodVentaFicticio()==null?"BLANCO":dtoProductosLote.getCodVentaFicticio().toString());                                                
                                                // vbongiov --17/09/2007
                                                prodLotes.append("&").append(dtoProductosLote.getIndCentroServGar().booleanValue()?"S":"N");
                                                prodLotes.append("&").append(dtoProductosLote.getDescCentSerGar()==null?"BLANCO":dtoProductosLote.getDescCentSerGar());
                                                prodLotes.append("&").append(dtoProductosLote.getNumMeses()==null?"BLANCO":UtilidadesBelcorp.formateaNumeroSICC(dtoProductosLote.getNumMeses().toString(), this.FORMATO_DEFAULT, this));                            
                                                prodLotes.append("&").append(dtoProductosLote.getObservaciones()==null?"BLANCO":dtoProductosLote.getObservaciones());
                                                prodLotes.append("&").append(dtoProductosLote.getIndTipoEntrega());
                                                prodLotes.append("&").append(dtoProductosLote.getDescCentSerEntrega()==null?"BLANCO":dtoProductosLote.getDescCentSerEntrega());
                                                prodLotes.append("&").append(dtoProductosLote.getOidCentroServGar()==null?"BLANCO":dtoProductosLote.getOidCentroServGar().toString());
                                                prodLotes.append("&").append(dtoProductosLote.getOidCentroServEntrega()==null?"BLANCO":dtoProductosLote.getOidCentroServEntrega().toString());
                                                prodLotes.append("&").append(dtoProductosLote.getOidProducto()==null?"BLANCO":dtoProductosLote.getOidProducto().toString());
                                                prodLotes.append("&").append(dtoProductosLote.getOidProductoLote()==null?"BLANCO":dtoProductosLote.getOidProductoLote().toString());
                                           }  
                                           
                                           // Obtiene los productos del lote
                                           lotes.append(";").append(prodLotes.length()==0?"BLANCO":prodLotes.toString().substring(1));
                                      
                                      } else {
                                           lotes.append(";BLANCO");
                                      }
                                      
                                      lotes.append(";").append(dtoLotesPremio.getOidLotePremio()==null?"BLANCO":dtoLotesPremio.getOidLotePremio().toString());
                                  }
                                  
                                  // Obtiene los lotes
                                  datosNiveles.append("#").append(lotes.length()==0?"BLANCO":lotes.toString().substring(1));
                                  
                                  
                             } else {
                                  datosNiveles.append("#BLANCO");
                             }
                         }                        
                         
                         traza("datosNiveles: " + datosNiveles.toString().substring(1));
                         
                } else {
                    // Se desea ingresar nuevos registros
                    traza("Nuevo registro de niveles");
                    rs.addRow(new Object[] {Integer.toString(i), Integer.toString(i+1), "", "", "", "", "", "", "", "", ""});
                
                    datosNiveles.append("%").append(Integer.toString(i).toString()).append("#BLANCO");
                 
                }                   
           }
         
      } else {           
           traza("No hay registros de niveles");
           for(int i=0;i<numNiveles;i++){
                rs.addRow(new Object[] {Integer.toString(i), Integer.toString(i+1), "", "", "", "", "", "", "", "", ""});
                
                datosNiveles.append("%").append(Integer.toString(i).toString()).append("#BLANCO");
                
                // Maximo numero de Premio ingresado
                numPremio = 0;
           }
      }
      
      asignar("LISTADOA", "listado", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");
      asignarAtributo("VAR","datosNiveles","valor", datosNiveles.length()==0?"":datosNiveles.toString().substring(1));
      
      asignarAtributo("VAR","numeroPremio","valor", new Integer(numPremio).toString());  
           

           // INC 21869 - dmorello, 14/12/2005
           // Se asigna al combo cbMoneda el valor correspondiente a la moneda local del país
           DTOOID dtoOidPais = new DTOOID();
           dtoOidPais.setOid(UtilidadesSession.getPais(this));
           Vector params  = new Vector();
           params.add(dtoOidPais);
           params.add(new MareBusinessID("ObtenerMonedaDefault"));
          
                           traza("antes conector moneda default");
                           DruidaConector conectorMonedaDefault = conectar("ConectorObjeto", params);
                           traza("despues conector moneda default");

           DTOOID dtoValorDefectoMoneda = (DTOOID)conectorMonedaDefault.objeto("DTOSalida");
           traza("oid moneda devuelto: " + dtoValorDefectoMoneda.getOid().toString());
           asignarAtributo("VAR","oidMonedaDefault","valor",dtoValorDefectoMoneda.getOid().toString());
           // Fin agregado INC 21869
      
  }
  
  
  private RecordSet agregarBlanco(DTOSalida dtoSalida) throws Exception{
      RecordSet tipoPremioQuery = null;
      RecordSet tipoPremio = new RecordSet();
      
      if(dtoSalida!=null){
           tipoPremioQuery = dtoSalida.getResultado();
           
           tipoPremio.setColumnIdentifiers(tipoPremioQuery.getColumnIdentifiers());
           
           tipoPremio.addRow(new Object[] {"", ""});
           
           for(int i=0; i < tipoPremioQuery.getRowCount(); i++){
                tipoPremio.addRow(tipoPremioQuery.getRow(i));
           }
      }
      return tipoPremio;
  }
  
  
  private ComposerViewElementList crearParametrosEntradaNiveles() throws Exception{
      traza("metodo ComposerViewElementList Niveles");
      ComposerViewElementList lista = new ComposerViewElementList();
      
      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      DTOPeriodo dtoP = new DTOPeriodo();
      dtoP.setOidPais(UtilidadesSession.getPais(this));
      dtoP.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoP.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
      dtoP.setCanal(dtoConcurso.getParamGenerales().getOidCanal());
      
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOidPais(UtilidadesSession.getPais(this));
      dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoOid.setOid(dtoConcurso.getParamGenerales().getOidMarca());
      
      DTOBuscarNumConcurso dtoBn = new DTOBuscarNumConcurso();
      dtoBn.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoBn.setOidPais(UtilidadesSession.getPais(this));
      dtoBn.setIndActivo(Integer.valueOf("1")); 
    
     
      ComposerViewElement combo2 = new ComposerViewElement();             
      combo2.setIDBusiness("INCCargarNroConcursoVersion");
      combo2.setDTOE(dtoBn);
           
      lista.addViewElement(combo2);
      
      ComposerViewElement combo3 = new ComposerViewElement();             
      combo3.setIDBusiness("INCObtenerTipoPremiosPuntos");
      combo3.setDTOE(dtoBel);
           
      lista.addViewElement(combo3);
      
      ComposerViewElement combo4 = new ComposerViewElement();             
      combo4.setIDBusiness("INCObtenerTipoPremioMonetario");
      combo4.setDTOE(dtoBel);
           
      lista.addViewElement(combo4);
      
      ComposerViewElement combo5 = new ComposerViewElement();             
      combo5.setIDBusiness("SEGObtenerMonedasPorPais");
      combo5.setDTOE(dtoBel);
           
      lista.addViewElement(combo5);
      
      ComposerViewElement combo6 = new ComposerViewElement();             
      combo6.setIDBusiness("INCObtenerFormaPago");
      combo6.setDTOE(dtoBel);
           
      lista.addViewElement(combo6);     
      
      ComposerViewElement combo7 = new ComposerViewElement();             
      combo7.setIDBusiness("INCObtenerTipoCumplimiento");
      combo7.setDTOE(dtoBel);
           
      lista.addViewElement(combo7);      
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null && dtoConcurso.getParamGenerales().getOidCanal()!=null) {
           ComposerViewElement combo8 = new ComposerViewElement();         
           combo8.setIDBusiness("CRAObtienePeriodos");
           combo8.setDTOE(dtoP);
                
           lista.addViewElement(combo8);
      }
      
      ComposerViewElement combo9 = new ComposerViewElement();         
      combo9.setIDBusiness("INCObtenerTipoDescuento");
      combo9.setDTOE(dtoBel);
           
      lista.addViewElement(combo9);
      
      if(dtoConcurso.getParamGenerales().getOidMarca()!=null) {
           ComposerViewElement combo10 = new ComposerViewElement();         
           combo10.setIDBusiness("SEGRecuperarMarcasProductoMP");
           combo10.setDTOE(dtoOid);
                
           lista.addViewElement(combo10);
      }
      
      ComposerViewElement combo11 = new ComposerViewElement();         
      combo11.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
      combo11.setDTOE(dtoBel);
           
      lista.addViewElement(combo11);          
      
      ComposerViewElement combo12 = new ComposerViewElement();         
      combo12.setIDBusiness("MAEObtenerNegocioPorPais");
      combo12.setDTOE(dtoBel);
           
      lista.addViewElement(combo12);          
      
      ComposerViewElement combo13 = new ComposerViewElement();         
      combo13.setIDBusiness("MAEObtenerSuperGenericosPorPais");
      combo13.setDTOE(dtoBel);
           
      lista.addViewElement(combo13);   
      
      ComposerViewElement combo14 = new ComposerViewElement();         
      combo14.setIDBusiness("MAEObtenerGenericosPorPais");
      combo14.setDTOE(dtoBel);
           
      lista.addViewElement(combo14);   
      
      ComposerViewElement combo15 = new ComposerViewElement();      
      combo15.setIDBusiness("INCObtenerCentroServicio");
      combo15.setDTOE(dtoBel);
             
      lista.addViewElement(combo15);
      
      return lista;
  }
  
  
  
  public void almacenarNivel() throws Exception {
         
      pagina("salidaGenerica");
      
      try{
           String listaDatosNiveles = conectorParametroLimpia("listaDatosNiveles", "", true);        
           String datosNiveles = conectorParametroLimpia("datosNiveles", "", true);   
           String oidTipoDeterminacionMetas = conectorParametroLimpia("hOidTipoDeterminacionMetas", "", true);   
           
           DTONivelesPremiacion dtoNivelesPremiacion = new DTONivelesPremiacion();
           ArrayList arrLstNivelesPremiacion = new ArrayList();
           ArrayList arrLstNumeroNiveles = new ArrayList();
           
           // Guardo el numero de premio maximo
           Vector numeroPremioM = new Vector();
           Integer numeroPremioMax = new Integer(0);     
           numeroPremioM.add(numeroPremioMax);
           
           if(!listaDatosNiveles.equals("")) {
           
                StringTokenizer stkListaDatosNiveles = new StringTokenizer(listaDatosNiveles,"|");
                StringTokenizer stkDatosNiveles = new StringTokenizer(datosNiveles,"%");
                
                StringTokenizer stkRegNiveles = null;
                DTONivelPremiacion dtoNivelPremiacion = null;
                
                String premio = null;
                DTOPremioPuntos dtoPremioPuntos = null;
                DTOPremioMonetario dtoPremioMonetario = null;
                DTOPremioDescuento dtoPremioDescuento = null;
                DTOPremioArticulo dtoPremioArticulo = null;           
              
                String numNivel = null;
                String puntajeServ = null;
                Long tipoPremio = null;
                String descTipoPremio = null;
                String nivelElegible = null;
                String cantFijaPuntos = null;
                String cantDesde = null;
                String cantHasta = null;
                String puntosProdExigidos = null;
                String numAspirantes = null;
                String oidPremio = null;
                
                // Recorre los registros
                while (stkListaDatosNiveles.hasMoreTokens()) {
                    stkRegNiveles = new StringTokenizer(stkListaDatosNiveles.nextToken(),"#");
                    dtoNivelPremiacion = new DTONivelPremiacion();
                    
                    numNivel = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setNumeroNivel(numNivel.equals("BLANCO")?null:Integer.valueOf(numNivel));
                    
                    // Se guarda para la validacion de consultoras nuevas
                    arrLstNumeroNiveles.add(Integer.valueOf(numNivel));
                    
                    puntajeServ = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setPuntajeServicio(puntajeServ.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(puntajeServ, this.FORMATO_DEFAULT)));
                    
                    tipoPremio = Long.valueOf(stkRegNiveles.nextToken());
                    dtoNivelPremiacion.setOidTipoPremio(tipoPremio);
                    
                    descTipoPremio = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setDescripcion(descTipoPremio);
                    
                    nivelElegible = stkRegNiveles.nextToken();
                    nivelElegible = nivelElegible.equals("BLANCO")?null:nivelElegible;
                    dtoNivelPremiacion.setIndNivelSelectivo(nivelElegible.equals("S")?Boolean.TRUE:Boolean.FALSE);
                    
                    cantFijaPuntos = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setCantidadFijaPuntos(cantFijaPuntos.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(cantFijaPuntos, this.FORMATO_DEFAULT)));
                    
                    cantDesde = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setCantidadDesde(cantDesde.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(cantDesde, this.FORMATO_DEFAULT)));
                    
                    cantHasta = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setCantidadHasta(cantHasta.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(cantHasta, this.FORMATO_DEFAULT)));
                    
                    puntosProdExigidos = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setPuntosProductosExigidos(puntosProdExigidos.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(puntosProdExigidos, this.FORMATO_DEFAULT)));
                    
                    numAspirantes = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setNumeroAspirantes(numAspirantes.equals("BLANCO")?null:Integer.valueOf(numAspirantes));
                    
                    oidPremio = stkRegNiveles.nextToken();
                    dtoNivelPremiacion.setOid(oidPremio.equals("BLANCO")?null:Long.valueOf(oidPremio));
             
                    // Almacena los datos del premio
                    premio = stkDatosNiveles.nextToken();
                    
                    if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_PUNTOS)){
                         // Almacena el Premio Puntos
                         dtoPremioPuntos = almacenarPremioPuntos(premio, numeroPremioM);
                         
                         traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioPuntos(dtoPremioPuntos);            
                         
                    } else if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_DESCUENTO)){
                         // Almacena el Premio Descuento
                         dtoPremioDescuento = almacenarPremioDescuento(premio, numeroPremioM);
                         
                         traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioDescuento(dtoPremioDescuento); 
                         
                    } else if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_MONETARIO)){
                         // Almacena el Premio Monetario
                         dtoPremioMonetario = almacenarPremioMonetario(premio, numeroPremioM, oidTipoDeterminacionMetas, numNivel);
                         
                         traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioMonetario(dtoPremioMonetario); 
                         
                    } else if(tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_ARTICULO)){
                         // Almacena el Premio Articulos
                         dtoPremioArticulo = almacenarPremioArticulo(premio, numeroPremioM);
                         
                         traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
                         
                         dtoNivelPremiacion.setIndPremiosArticulos(Boolean.TRUE);
                         dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                         dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                         
                         dtoNivelPremiacion.setPremioArticulo(dtoPremioArticulo); 
                    }
                    
                    traza("dtoNivelPremiacion nivel: " + numNivel);
                    traza("dtoNivelPremiacion valor: " + dtoNivelPremiacion);
                    
                    // Almacena el registro de nivel
                    arrLstNivelesPremiacion.add(dtoNivelPremiacion);                
                
                }           
           }
                  
           
           // Convierte el ArrayList en DTONivelPremiacion[]
           dtoNivelesPremiacion.setListaNiveles((DTONivelPremiacion[])arrLstNivelesPremiacion.toArray(new DTONivelPremiacion[0]));        
           
           traza("niveles length: " + dtoNivelesPremiacion.getListaNiveles().length);
           traza("numeroPremioMax: " + ((Integer)numeroPremioM.get(0)).intValue());
           
           // Almacena el numero de premio maximo
           dtoNivelesPremiacion.setNumeroPremioMax((Integer)numeroPremioM.get(0));
           
           // Guarda el DTONivelesPremiacion
           this.setNivelesPremiacion(dtoNivelesPremiacion);
           
           // Cierra la ventana modal
           asignarAtributo("VAR", "ejecutar", "valor", "cerrarModal()");
           
      } catch(Exception e){
                              asignarAtributo("VAR", "ejecutarError", "valor", "errorAlmacenarNivel()");
                              throw e;
                    }	
      
  }
  
  
  public DTOPremioArticulo almacenarPremioArticulo(String premioArticulo, Vector numeroPremioM) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-oidPremioArticulos
           3-listaLotes  
      */
     
      String oidPremioArticulo = null;
      String listaLotes = null;
      
      traza("premioArticulo: " + premioArticulo);
           
      StringTokenizer stkPremioArt = new StringTokenizer(premioArticulo,"#");
      DTOPremioArticulo dtoPremioArticulo = new DTOPremioArticulo();
      
      dtoPremioArticulo.setOidPais(UtilidadesSession.getPais(this));
           traza("dtoPremioArticulo.getOidPais(): " + dtoPremioArticulo.getOidPais());
      
      traza("oid: " + stkPremioArt.nextToken());
      traza("tipo Premio: " + stkPremioArt.nextToken());
             
      dtoPremioArticulo.setNumeroUnidadesPremioArticulo(Integer.valueOf(stkPremioArt.nextToken()));
      
      oidPremioArticulo = stkPremioArt.nextToken();
      dtoPremioArticulo.setOidPremioArticulo(oidPremioArticulo.equals("BLANCO")?null:Long.valueOf(oidPremioArticulo));
    
         
      // Almacena la lista de lotes
      listaLotes = stkPremioArt.nextToken(); 
      traza("listaLotes: " + listaLotes);
      
      if(!listaLotes.equals("BLANCO")){
      
           ArrayList arrLstLotes = new ArrayList();
           ArrayList arrLstProdLotes = null;
           StringTokenizer stkLotes = new StringTokenizer(listaLotes,"$");
           StringTokenizer stkLote = null;
           String listaProdLotes = null;
           StringTokenizer stkProdArticulo = null;
           StringTokenizer stkProd = null;
           DTOLotesPremio dtoLotesPremio = null;
           DTOProductosLote dtoProductosLote = null;
         
           String numeroPremio = null;
           String despachoArticulo = null;
           String codVentaFicticio = null;
           String oidProducto = null;
           String oidProdLote = null;
           String oidLote = null;
           String indCentSerGar = null;    
           String numMeses = null;
           String obs = null;
           String oidCentSerGar = null;
           String oidCentSerEntrega = null;
           
           while (stkLotes.hasMoreTokens()) {
           
                stkLote = new StringTokenizer(stkLotes.nextToken(),";");
                dtoLotesPremio = new DTOLotesPremio();
                
                numeroPremio = stkLote.nextToken();
                dtoLotesPremio.setNumeroPremio(Integer.valueOf(numeroPremio));  
                
                // Obtiene el numero de premio maximo
                if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
                   numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
                }
                
                dtoLotesPremio.setDescripcionLote(stkLote.nextToken());  
                
                listaProdLotes = stkLote.nextToken();
                traza("listaProdLotes: " + listaProdLotes);
                
                oidLote = stkLote.nextToken();
                dtoLotesPremio.setOidLotePremio(oidLote.equals("BLANCO")?null:Long.valueOf(oidLote));
                
                arrLstProdLotes = new ArrayList();
                
                if(!listaProdLotes.equals("BLANCO")){
                
                    stkProdArticulo = new StringTokenizer(listaProdLotes,"|");
                    
                    while (stkProdArticulo.hasMoreTokens()) {
           
                         stkProd = new StringTokenizer(stkProdArticulo.nextToken(),"&");
                         dtoProductosLote = new DTOProductosLote();
                         
                         dtoProductosLote.setCodigoProducto(stkProd.nextToken());  
                         
                         dtoProductosLote.setNumeroUnidades(Integer.valueOf(desFormatearNumero(stkProd.nextToken(), this.FORMATO_DEFAULT)));  
                         
                         dtoProductosLote.setPrecioPublico(new BigDecimal(desFormatearNumero(stkProd.nextToken(), this.FORMATO_MONEDA)));  
                         
                         despachoArticulo = stkProd.nextToken();
                         dtoProductosLote.setIndDespachaArticulo(despachoArticulo.equals("S")?Boolean.TRUE:Boolean.FALSE);  
                         
                         codVentaFicticio = stkProd.nextToken();
                         dtoProductosLote.setCodVentaFicticio(codVentaFicticio.equals("BLANCO")?null:codVentaFicticio);  
                         
                         indCentSerGar = stkProd.nextToken();
                         dtoProductosLote.setIndCentroServGar(indCentSerGar.equals("S")?Boolean.TRUE:Boolean.FALSE);
                         
                         dtoProductosLote.setDescCentSerGar(stkProd.nextToken());  
          
                         numMeses = stkProd.nextToken();
                         dtoProductosLote.setNumMeses(numMeses.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(numMeses, this.FORMATO_DEFAULT)));  
          
                         obs = stkProd.nextToken();
                         dtoProductosLote.setObservaciones(obs.equals("BLANCO")?null:obs); 
          
                         dtoProductosLote.setIndTipoEntrega(stkProd.nextToken());  
          
                         dtoProductosLote.setDescCentSerEntrega(stkProd.nextToken());  
          
                         oidCentSerGar = stkProd.nextToken();
                         dtoProductosLote.setOidCentroServGar(oidCentSerGar.equals("BLANCO")?null:Long.valueOf(oidCentSerGar));  
          
                         oidCentSerEntrega = stkProd.nextToken();
                         dtoProductosLote.setOidCentroServEntrega(oidCentSerEntrega.equals("BLANCO")?null:Long.valueOf(oidCentSerEntrega));  
                                   
                         oidProducto = stkProd.nextToken();
                         dtoProductosLote.setOidProducto(oidProducto.equals("BLANCO")?null:Long.valueOf(oidProducto));    
                         
                         oidProdLote = stkProd.nextToken();
                         dtoProductosLote.setOidProductoLote(oidProdLote.equals("BLANCO")?null:Long.valueOf(oidProdLote));   
                        
                         arrLstProdLotes.add(dtoProductosLote);
                    }
                    
                    // Almacena la lista de productos del lote
                    dtoLotesPremio.setLstProductosLote(arrLstProdLotes);
                         
                } else {
                    dtoLotesPremio.setLstProductosLote(null);
                }
                
                // Almacena la lista de productos del lote
                arrLstLotes.add(dtoLotesPremio);
                
           }
           
           // Almacena la lista de lotes
           dtoPremioArticulo.setLstLotesPremio(arrLstLotes);
      
      } else {
           dtoPremioArticulo.setLstLotesPremio(null);
      }
      
      return dtoPremioArticulo;    
  }
    
  
  public DTOPremioMonetario almacenarPremioMonetario(String premioMonetario, Vector numeroPremioM, String oidTipoDeterminacionMetas, String numNivel) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-numPremio            
           3-tipoPremMonet
           4-cant
           5-porcenj
           6-oidMoneda
           7-oidFormaPago
           8-oidPremioMonet
           9-pagoPartes
           10-oidCumplimiento
           11-descontarPagos
           12-listaPago
      */
      
      String numeroPremio = null;
      String cant = null;
      String porcenj = null;
      String oidPremioMonet = null;
      String pagoPartes = null;
      String descontarPagosAnticipandos = null;      
      String listaPagos = null;
      
      traza("premioMonetario: " + premioMonetario);
           
      StringTokenizer stkPremioMonet = new StringTokenizer(premioMonetario,"#");
      DTOPremioMonetario dtoPremioMonetario = new DTOPremioMonetario();
      
      dtoPremioMonetario.setOidPais(UtilidadesSession.getPais(this));
      
      traza("oid: " + stkPremioMonet.nextToken());
      traza("tipo Premio: " + stkPremioMonet.nextToken());
      
      numeroPremio = stkPremioMonet.nextToken();
      dtoPremioMonetario.setNumeroPremio(Integer.valueOf(numeroPremio));      
      
      dtoPremioMonetario.setOidTipoPremioMonetario(Long.valueOf(stkPremioMonet.nextToken()));
      
      cant = stkPremioMonet.nextToken();
      dtoPremioMonetario.setCantidad(cant.equals("BLANCO")?null:new BigDecimal(desFormatearNumero(cant, this.FORMATO_DEFAULT)));
      
      porcenj = stkPremioMonet.nextToken();
      dtoPremioMonetario.setPorcentaje(porcenj.equals("BLANCO")?null:new BigDecimal(desFormatearNumero(porcenj, this.FORMATO_DEFAULT)));
      
      dtoPremioMonetario.setOidMoneda(Long.valueOf(stkPremioMonet.nextToken()));
      
      dtoPremioMonetario.setOidFormaPago(Long.valueOf(stkPremioMonet.nextToken()));
      
      oidPremioMonet = stkPremioMonet.nextToken();
      dtoPremioMonetario.setOidPremioMonetario(oidPremioMonet.equals("BLANCO")?null:Long.valueOf(oidPremioMonet));
      
      // Obtiene el numero de premio maximo
      if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
           numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
      }
      
      // Hay Otros Datos
      if(oidTipoDeterminacionMetas.equals(ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.toString())) {
           // Almacena otros datos
           pagoPartes = stkPremioMonet.nextToken();
           dtoPremioMonetario.setIndPagoPartes(pagoPartes.equals("S")?Boolean.TRUE:Boolean.FALSE);
           
           dtoPremioMonetario.setOidCumplimiento(Long.valueOf(stkPremioMonet.nextToken()));
           
           descontarPagosAnticipandos = stkPremioMonet.nextToken();
           dtoPremioMonetario.setIndDescontarPagosAnticipados(descontarPagosAnticipandos.equals("S")?Boolean.TRUE:Boolean.FALSE);
           
           // Pagos
           listaPagos = stkPremioMonet.nextToken(); 
           
           if(!listaPagos.equals("BLANCO")){
           
                ArrayList arrLstPagos = new ArrayList();
                StringTokenizer stkPagos = new StringTokenizer(listaPagos,"|");
                StringTokenizer stkPago = null;
                DTOPagoMonetario dtoPagoMonetario = null;
             
                String premioPorcj = null;
                BigDecimal premioPorcentaje = null; 
                BigDecimal totalPorcentaje = new BigDecimal(0);
                String oidPago = null;
                
                while (stkPagos.hasMoreTokens()) {
                    stkPago = new StringTokenizer(stkPagos.nextToken(),"&");
                    dtoPagoMonetario = new DTOPagoMonetario();
                    
                    dtoPagoMonetario.setNumeroPago(Integer.valueOf(stkPago.nextToken()));  
                    
                    premioPorcj = stkPago.nextToken();
                    premioPorcentaje = new BigDecimal(desFormatearNumero(premioPorcj, this.FORMATO_DEFAULT));                    
                    dtoPagoMonetario.setPremio(premioPorcentaje);
                    
                    // Sumo los premioPorcentaje
                    totalPorcentaje = totalPorcentaje.add(premioPorcentaje);
                    
                    dtoPagoMonetario.setPeriodoControl(stkPago.nextToken());  
                    
                    dtoPagoMonetario.setOidPeriodoControl(Long.valueOf(stkPago.nextToken()));  
                    
                    oidPago = stkPago.nextToken();
                    dtoPagoMonetario.setOidPagoMonetario(oidPago.equals("BLANCO")?null:Long.valueOf(oidPago));
                    
                    arrLstPagos.add(dtoPagoMonetario);
                }
                
                traza("totalPorcentaje: " + totalPorcentaje.toString());
                // Verifica que la suma de porcentajes sea 100
                if(totalPorcentaje.compareTo(new BigDecimal(100))!=0){
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(
                                      ConstantesSEG.MODULO_INC, "", "0014") );

                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(numNivel);
                    
                    throw ex;
                }
                
                dtoPremioMonetario.setLstPagosMonetarios(arrLstPagos);
           
           } else {
                dtoPremioMonetario.setLstPagosMonetarios(null);
           }
           
      } else {
           // No se parametrizan Otros Datos
           dtoPremioMonetario.setIndPagoPartes(Boolean.FALSE);
           dtoPremioMonetario.setOidCumplimiento(null);
           dtoPremioMonetario.setIndDescontarPagosAnticipados(Boolean.FALSE);
           dtoPremioMonetario.setLstPagosMonetarios(null);
      }
      
      return dtoPremioMonetario;    
  }
  
  
  
  public DTOPremioDescuento almacenarPremioDescuento(String premioDescuento, Vector numeroPremioM) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-numPremio            
           3-tipoPremDesc
           4-cant
           5-porcenj
           6-periodoDesde
           7-periodoHasta
           8-oidPremioDesc
           9-listaArticulos
      */
      String numeroPremio = null;
      String cant = null;
      String porcenj = null;
      String periodoHasta = null;
      String oidPremioDesc = null;
      String listaArticulos = null;
      
      traza("premioDescuento: " + premioDescuento);
           
      StringTokenizer stkPremioDesc = new StringTokenizer(premioDescuento,"#");
      DTOPremioDescuento dtoPremioDescuento = new DTOPremioDescuento();
      
      dtoPremioDescuento.setOidPais(UtilidadesSession.getPais(this));
      
      traza("oid: " + stkPremioDesc.nextToken());
      traza("tipo Premio: " + stkPremioDesc.nextToken());
      
      numeroPremio = stkPremioDesc.nextToken();
      dtoPremioDescuento.setNumeroPremio(Integer.valueOf(numeroPremio));      
      
      dtoPremioDescuento.setOidTipoDescuento(Long.valueOf(stkPremioDesc.nextToken()));
      
      cant = stkPremioDesc.nextToken();
      dtoPremioDescuento.setCantidadDescuento(cant.equals("BLANCO")?null:new BigDecimal(desFormatearNumero(cant, this.FORMATO_DEFAULT)));
      
      porcenj = stkPremioDesc.nextToken();
      dtoPremioDescuento.setPorcentajeDescuento(porcenj.equals("BLANCO")?null:new BigDecimal(desFormatearNumero(porcenj, this.FORMATO_DEFAULT)));
      
      dtoPremioDescuento.setOidPeriodoAplicacionDesde(Long.valueOf(stkPremioDesc.nextToken()));
      
      periodoHasta = stkPremioDesc.nextToken();
      dtoPremioDescuento.setOidPeriodoAplicacionHasta(periodoHasta.equals("BLANCO")?null:Long.valueOf(periodoHasta));
      
      oidPremioDesc = stkPremioDesc.nextToken();
      dtoPremioDescuento.setOidPremioDescuento(oidPremioDesc.equals("BLANCO")?null:Long.valueOf(oidPremioDesc));
      
      // Obtiene el numero de premio maximo
      if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
           numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
      }
      
      // Almacena la lista de articulos
      listaArticulos = stkPremioDesc.nextToken(); 
      
      if(!listaArticulos.equals("BLANCO")){
      
           ArrayList arrLstArticulos = new ArrayList();
           StringTokenizer stkArticulos = new StringTokenizer(listaArticulos,"|");
           StringTokenizer stkArticulo = null;
           DTOArticulo dtoArticulo = null;
         
           String uniNegDesc = null;
           String negDesc = null;
           String superGenerDesc = null;
           String generDesc = null;
           String codProd = null;
           String oidUniNeg = null;
           String oidNeg = null;
           String oidSuperGener = null;
           String oidGener = null;
           String oidProd = null;
           String oidArticulo = null;
           
           while (stkArticulos.hasMoreTokens()) {
                stkArticulo = new StringTokenizer(stkArticulos.nextToken(),"&");
                dtoArticulo = new DTOArticulo();
                
                dtoArticulo.setMarca(stkArticulo.nextToken());  
                
                uniNegDesc = stkArticulo.nextToken();
                dtoArticulo.setUnidadNegocio(uniNegDesc.equals("BLANCO")?null:uniNegDesc);
                
                negDesc = stkArticulo.nextToken();
                dtoArticulo.setNegocio(negDesc.equals("BLANCO")?null:negDesc);
                
                superGenerDesc = stkArticulo.nextToken();
                dtoArticulo.setSupergenerico(superGenerDesc.equals("BLANCO")?null:superGenerDesc);
                
                generDesc = stkArticulo.nextToken();
                dtoArticulo.setGenerico(generDesc.equals("BLANCO")?null:generDesc);
                
                codProd = stkArticulo.nextToken();
                dtoArticulo.setCodigoProducto(codProd.equals("BLANCO")?null:codProd);
                
                dtoArticulo.setOidMarca(Long.valueOf(stkArticulo.nextToken()));  
                
                oidUniNeg = stkArticulo.nextToken();
                dtoArticulo.setOidUnidadNegocio(oidUniNeg.equals("BLANCO")?null:Long.valueOf(oidUniNeg));
                
                oidNeg = stkArticulo.nextToken();
                dtoArticulo.setOidNegocio(oidNeg.equals("BLANCO")?null:Long.valueOf(oidNeg));
                
                oidSuperGener = stkArticulo.nextToken();
                dtoArticulo.setOidSupergenerico(oidSuperGener.equals("BLANCO")?null:Long.valueOf(oidSuperGener));
                
                oidGener = stkArticulo.nextToken();
                dtoArticulo.setOidGenerico(oidGener.equals("BLANCO")?null:Long.valueOf(oidGener));
                
                oidProd = stkArticulo.nextToken();
                dtoArticulo.setOidProducto(oidProd.equals("BLANCO")?null:Long.valueOf(oidProd));
                
                oidArticulo = stkArticulo.nextToken();
                dtoArticulo.setOidProductoDescuento(oidArticulo.equals("BLANCO")?null:Long.valueOf(oidArticulo));
                
                arrLstArticulos.add(dtoArticulo);
           }
           
           dtoPremioDescuento.setLstArticulos(arrLstArticulos);
      
      } else {
           dtoPremioDescuento.setLstArticulos(null);
      }
      
      return dtoPremioDescuento;    
  }
  
  
  public DTOPremioPuntos almacenarPremioPuntos(String premioPuntos, Vector numeroPremioM) throws Exception {
      /*  0-ind
           1-tipoPremiacion
           2-numPremio 
           3-concDest
           4-tipoPremPuntos
           5-cant
           6-porcenj
           7-oidPremioPuntos
      */
      String numeroPremio = null;
      String cant = null;
      String porcenj = null;
      String oidPremioPuntos = null;
      
      traza("premioPuntos: " + premioPuntos);
           
      StringTokenizer stkPremioPuntos = new StringTokenizer(premioPuntos,"#");
      DTOPremioPuntos dtoPremioPuntos = new DTOPremioPuntos();
      
      traza("oid: " + stkPremioPuntos.nextToken());
      traza("tipo Premio: " + stkPremioPuntos.nextToken());
      
      numeroPremio = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setNumeroPremio(Integer.valueOf(numeroPremio));
      
      dtoPremioPuntos.setOidConcursoDestino(Long.valueOf(stkPremioPuntos.nextToken()));
      dtoPremioPuntos.setOidTipoPremioPuntos(Long.valueOf(stkPremioPuntos.nextToken()));
      
      cant = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setCantidad(cant.equals("BLANCO")?null:Integer.valueOf(desFormatearNumero(cant, this.FORMATO_DEFAULT)));
      
      porcenj = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setPorcentaje(porcenj.equals("BLANCO")?null:new BigDecimal(desFormatearNumero(porcenj, this.FORMATO_DEFAULT)));
      
      oidPremioPuntos = stkPremioPuntos.nextToken();
      dtoPremioPuntos.setOidPremioPuntos(oidPremioPuntos.equals("BLANCO")?null:Long.valueOf(oidPremioPuntos));
      
      // Obtiene el numero de premio maximo
      if(((Integer)numeroPremioM.get(0)).intValue() < Integer.valueOf(numeroPremio).intValue()){
           numeroPremioM.set(0,Integer.valueOf(numeroPremio)); 
      }
      
      return dtoPremioPuntos;    
  }
  
  public void almacenar() throws Exception {  
      traza("sin salidaGenerica");

      String datosObligatorios = conectorParametroLimpia("datosObligatorios", "", true);        
      String oidParamGralesPremiacion = conectorParametroLimpia("oidParamGralesPremiacion", "", true);  
      String txtNumNiveles = conectorParametroLimpia("txtNumNiveles", "", true);          
      String cbPeriodoDespacho = conectorParametroLimpia("cbPeriodoDespacho", "", true);   
      String ckComunicacion = conectorParametroLimpia("ckComunicacion", "", true);        
      String txtMensaje = conectorParametroLimpia("txtMensaje", "", true);   
      
      DTONivelesPremiacion dtoNivelesPremiacion = null;
      
      // Guardo los datos ingresados en el dtoConcurso
      dtoConcurso.setIndPremios(Boolean.TRUE);
      traza("datosObligatorios: " + datosObligatorios);
      dtoConcurso.setIndObligPremios(datosObligatorios.equals("true")?Boolean.TRUE:Boolean.FALSE);
      
      // Verifica si hay que registros en la base de datos
      opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      if(opcionMenu.equals("Modificar Concurso Ranking") && !dtoConcurso.getIndObligPremios().booleanValue()) {
           dtoConcurso.setIndBorradoPremios(Boolean.TRUE);
      }
      
      DTOParametrosGeneralesPremiacion dtoParamGenerPrem = new DTOParametrosGeneralesPremiacion();
      
      dtoParamGenerPrem.setOidPais(UtilidadesSession.getPais(this));
      dtoParamGenerPrem.setOidParamGralesPremiacion(oidParamGralesPremiacion.equals("")?null:new Long(oidParamGralesPremiacion));
      dtoParamGenerPrem.setNroNiveles(txtNumNiveles.equals("")?null:new Integer(txtNumNiveles));
      dtoParamGenerPrem.setOidPeriodo(cbPeriodoDespacho.equals("")?null:new Long(cbPeriodoDespacho));
      dtoParamGenerPrem.setIndComunicacion(ckComunicacion.equals("S")?Boolean.TRUE:Boolean.FALSE);
      dtoParamGenerPrem.setMensaje(txtMensaje.equals("")?null:txtMensaje);
      
      dtoParamGenerPrem.setIndPeriodoDespacho(Boolean.FALSE);
      dtoParamGenerPrem.setIndPremiosAcumulativosNiveles(Boolean.FALSE);
      dtoParamGenerPrem.setIndNivelesRotativos(Boolean.FALSE);
      dtoParamGenerPrem.setNroRotaciones(null);
      dtoParamGenerPrem.setIndAccesoNivelPremioSuperior(Boolean.FALSE);
      dtoParamGenerPrem.setIndPremiosElectivos(Boolean.FALSE);
      dtoParamGenerPrem.setOidTipoEleccion(null);
      
      
      // Obtiene los niveles de premiacion
      dtoNivelesPremiacion = this.getNivelesPremiacion();
     
      // Guarda el numero de premio maximo
      if(dtoNivelesPremiacion!= null) {
           traza("dtoNivelesPremiacion.getNumeroPremioMax(): " + dtoNivelesPremiacion.getNumeroPremioMax().toString());
           dtoParamGenerPrem.setNumeroPremio(dtoNivelesPremiacion.getNumeroPremioMax());
      } else {
           dtoParamGenerPrem.setNumeroPremio(Integer.valueOf("0"));
      }
             
      traza("DTOParametrosGeneralesPremiacion: " + dtoParamGenerPrem);
      // Guarda los parametros generales de premiacion
      dtoConcurso.setParamGralesPremiacion(dtoParamGenerPrem);    
      
      traza("DTONivelesPremiacion: " + dtoNivelesPremiacion);   
      // Guarda los niveles de premiacion
      if(dtoNivelesPremiacion!=null) {
           dtoConcurso.setIndNivelPremiacion(Boolean.TRUE);
           dtoConcurso.setListaNivelesPremiacion(dtoNivelesPremiacion);
           
      } else {
           dtoConcurso.setIndNivelPremiacion(Boolean.FALSE);
           dtoConcurso.setListaNivelesPremiacion(null);
      }
      
      super.setConcurso(dtoConcurso);
      
      traza("dtoConcurso final: " + super.getConcurso());
      
  }
  
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
      StringBuffer salida = new StringBuffer();
      int sizeColums = datos.getColumnCount();
      int sizeRows = datos.getRowCount();
      
      if ( columns == null ){
         columns = new Vector();
      }
  
      Vector columsDesc = datos.getColumnIdentifiers();          
      
      DruidaConector conectorValoresPosibles = new DruidaConector();
      
      XMLDocument xmlDoc  = new XMLDocument();
      Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");                    
      Element e_rows = docDestino.createElement("ROWSET");
      e_rows.setAttribute("ID",rowsetID);
      docDestino.getDocumentElement().appendChild(e_rows);
      
      for (int i=0; i < sizeRows; i++){
         Element e_row = docDestino.createElement("ROW");
         e_rows.appendChild(e_row);
  
         Element e_campo0   = docDestino.createElement("CAMPO");
  
         for(int j=0; j < sizeColums; j++){
           if( columns.contains(columsDesc.elementAt(j))){
             Element e_campo2   = docDestino.createElement("CAMPO");
             
             if(j == 0){
                e_campo0.setAttribute("NOMBRE","oculto");
             }else{
                e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
             }
             e_campo2.setAttribute("TIPO","OBJECTO");
             e_campo2.setAttribute("LONGITUD","50");
             Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
             e_campo2.appendChild(txt0);
             e_row.appendChild(e_campo2);
           }
         }
      }
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      traza("DruidaConector: " + conectorValoresPosibles.getXML());
      return conectorValoresPosibles;
         }

  // Obtiene el DTONivelesPremiacion auxiliar
  public DTONivelesPremiacion getNivelesPremiacion() throws Exception {
      DTONivelesPremiacion dtoNivelesPremiacion = null;
      
      try{
           dtoNivelesPremiacion = (DTONivelesPremiacion)this.getSessionCache().get("DTONivelesPremiacion");
      }catch(Exception e){
         traza("no se encontro el DTONivelesPremiacion en sesion");
      }
      
      traza("dtoNivelesPremiacion: " + dtoNivelesPremiacion);
      
      return dtoNivelesPremiacion;
  }
  
  // Setea el DTONivelesPremiacion auxiliar
  public void setNivelesPremiacion(DTONivelesPremiacion dto){
      this.getSessionCache().put("DTONivelesPremiacion", dto);           
  }

}

