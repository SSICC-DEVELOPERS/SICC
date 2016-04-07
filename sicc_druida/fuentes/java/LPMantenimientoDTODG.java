/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOParametroMarca;
import es.indra.sicc.dtos.dto.DTOParametroAcceso;
import es.indra.sicc.dtos.dto.DTOParametroBoolean;
import es.indra.sicc.dtos.dto.DTOParametroCanal;
import es.indra.sicc.dtos.dto.DTOParametroSubacceso;
import es.indra.sicc.logicanegocio.dto.ConstantesDTO;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.xml.XMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              DTO - Descuentos
 * Componente:          LPMantenimientoDTODG
 * Fecha:               03/11/2005
 * Dcoumentacion:       DMCO-DTO-BELC300014763
 * Observaciones:
 * @version             3.7
 * @author              Emilio Noziglia
 */
public class LPMantenimientoDTODG extends LPDescuentos {

    private String lDescPais = null;    
    private Long lIdioma = null;
    private Long lPais = null;
    private Long lOidMarca;
    private Long lOidCanal;
    private Long []lAccesos = null;
    private Long []lSubAccesos = null;    
    private Long lOidPeriodoDesde;
    private Long lOidPeriodoHasta;

	public final static String NO_SE_PUEDE_MODIFICAR_0015   = "0000014";

    private DTOOID  dtoOidMatrizSeleccionada = new DTOOID();
        
    public LPMantenimientoDTODG() {
          super();
    }

    public void inicio() throws Exception {
        pagina("contenido_datos_generales_descuento_crear");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        try{
            this.rastreo();
            accion = conectorParametro("accion")==null?"":
                                          conectorParametro("accion");
            casoDeUso = conectorParametro("casoDeUso")==null?"":
                                          conectorParametro("casoDeUso");
            lIdioma = UtilidadesSession.getIdioma(this);
            lPais = UtilidadesSession.getPais(this);
            lDescPais = UtilidadesSession.getDescripcionPais(this);

            traza(">>>> Acción................" + accion);
            traza(">>>> Idioma................" + lIdioma);
            traza(">>>> Pais.................." + lPais);
            traza(">>>> Descripcion  Pais..... " + lDescPais );
            traza(">>>> casoDeUso..... " + casoDeUso );
            asignarAtributo("VAR","hidDescripcionPais","valor",
                                                    lDescPais.toString());
            asignarAtributo("VAR","oidPais","valor",lPais.toString());

            /*.. Guardo la variable casodeuso en una variable del form ...*/
            asignarAtributo("VAR","hidCasoDeUso","valor",casoDeUso);
            
            if (accion.equals("")) { 
              inicializar();
              cargarPantalla();
            } else if (accion.equals("cargar pantalla")) { 
              cargarPantalla();
            } else if (accion.equals("almacenar")) { 
              almacenar(); 
              redirigir(); 
            } else if (accion.equals("redirigir")) { 
              redirigir(); 
            } else if (accion.equals("guardar")) { 
              almacenar(); 
              guardar(); // Este método se hereda de la LPDescuentos 
            } else if (accion.equals("siguiente")) { 
              siguiente();
            } 

        } catch (Exception ex) {
             logStackTrace(ex);
             //cargarPantalla();
             this.lanzarPaginaError(ex);      
		}
    }

  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param Throwable
   * @return void 
   * @description metodo que tracea la excepcion recibida por parametro
   * @reference metodo de apoyo
   */   
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
  
  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param DTOOIDs
   * @return String 
   * @description metodo que transforma a String con delimitador un array de 
   *              long recibido en un DTOOIDs 
   * @reference metodo de apoyo
   */   
    private String vAplanaInfo(DTOOIDs dtoOids) throws Exception {
      traza("LPManteniemientoDTODG.vAplanaInfo(DTOOIDs dtoOids):Entrada");
      
      Long[] lInfo = dtoOids.getOids();
      int iTamano = dtoOids.getOids().length;
      StringBuffer sElementosAplanados = new StringBuffer();

      if (iTamano >0)	{	
        for ( int i = 0; i < iTamano; i++){
          sElementosAplanados.append(lInfo[i]);
          sElementosAplanados.append(",");
        }
      } else return null;      
            
      String cadena = sElementosAplanados.toString();
      
      traza("LPManteniemientoDTODG.vAplanaInfo(DTOOIDs dtoOids):Salida");
      return  sElementosAplanados.substring(0,cadena.length()-1);
    }


  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param String
   * @param RecordSet
   * @param Vector
   * @return DruidaConector 
   * @description metodo que genera un DruidaConector en base a un recordset
   *              para asignar a una pagina druida.
   * @reference metodo de apoyo
   */ 
    private DruidaConector generarConector(String rowsetID, RecordSet datos,
      Vector columns)	throws DOMException,Exception {
        traza("LPManteniemientoDTODG.generarConector():Entrada");
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();
    
        if (columns==null) {
          columns = new Vector();
        }
    
        Vector columsDesc = datos.getColumnIdentifiers();		
        traza("datos de generar conector:" + datos);
        DruidaConector conectorValoresPosibles = new DruidaConector();				
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID",rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
        
        for (int i=0; i < sizeRows; i++) {
            Element e_row = docDestino.createElement("ROW");
            if (datos.getValueAt(i,2).toString().equals("s")) {
              e_row.setAttribute("check", "S");
            }
            e_rows.appendChild(e_row);
      
            for (int j=0;j<sizeColums;j++) {
              if (columns.contains(columsDesc.elementAt(j))) {
                Element e_campo2 = docDestino.createElement("CAMPO");
                e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).
                                                                  toString());
                e_campo2.setAttribute("TIPO","OBJECTO");
                e_campo2.setAttribute("LONGITUD","50");
                Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==
                                    null?"":datos.getValueAt(i,j).toString()));
                e_campo2.appendChild(txt);
                e_row.appendChild(e_campo2);
              }
            }
        }	
        conectorValoresPosibles.setXML(docDestino.getDocumentElement());
        traza("LPManteniemientoDTODG.generarConector():Salida");
        return conectorValoresPosibles;
	}

   /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param String
   * @param String
   * @return Long[] 
   * @throws Exception
   * @description metodo que construye un array de long en base a un string de 
   *              valores numericos separados por un delimitador
   * @reference metodo de apoyo
   */  
  public Long[] construirLineaSeleccionada(String elementosSeleccionados, 
      String delim) throws Exception {
      traza("LPManteniemientoDTODG.construirLineaSeleccionada():Entrada");
      
      StringTokenizer stk = new StringTokenizer(elementosSeleccionados,delim);
      Long[] arr = new Long[stk.countTokens()];
      int cuenta = 0;
      while (stk.hasMoreTokens()) {
        arr[cuenta] = Long.valueOf(stk.nextToken());
        cuenta++;
      }
      traza("Seleccionada:"+arr.toString());
      traza("LPManteniemientoDTODG.construirLineaSeleccionada():Salida");
      return arr;
  }

  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param void
   * @return void 
   * @description metodo que recupera los datos necesarios para comenzar con la
   *               ejecucion del caso de uso con sus distintas pestañas, e 
   *               inicializa el DTOGlobalDescuento que estara en sesion durante
   *               la ejecucion del CU.
   * @reference DMCO-DTO-BELC300014763
   */ 
    public void inicializar() throws Exception{
      traza("LPMantenimientoDTODG.inicializar():Entrada");
      
      DTOGlobalDescuento dtoDescuento = new DTOGlobalDescuento();
               
      if ("insertar".equals(casoDeUso)) { 
          DTOOID dtoMatrizSeleccionada = (DTOOID)this.
                              conectorParametroSesion("DTOMatrizSeleccionada");          
          MareBusinessID IDBusiness = new MareBusinessID(
                              "DTOConsultarMatrizDescuentos");
          Vector params = new Vector();
          params.add(dtoMatrizSeleccionada);
          params.add(IDBusiness);          
          
          traza("Consultando Matriz Descuentos...");
          DruidaConector conMatrDesc = this.conectar(
                                  "ConectorConsultarMatrizDescuentos", params);
          traza("Volvio de consultar matriz descuentos.");                   
          
          DTODatosMatrizDescuentos dtoDatosMatrDesc = (DTODatosMatrizDescuentos)
                                                conMatrDesc.objeto("dtoSalida");          
          
          dtoDescuento.setDatosMatriz(dtoDatosMatrDesc);          
          
          dtoDescuento.setIndDatosGralesDto(Boolean.FALSE);
          dtoDescuento.setIndAlcanceTipoCliente(Boolean.FALSE);
          dtoDescuento.setIndAlcanceCliente(Boolean.FALSE);
          dtoDescuento.setIndAlcanceAdministrativo(Boolean.FALSE);
          dtoDescuento.setIndBaseCalculo(Boolean.FALSE);
          dtoDescuento.setIndBaseAplicacion(Boolean.FALSE);
          
      } else if ("modificar".equals(casoDeUso)||"consultar".equals(casoDeUso)) { 

          DTOOID dtoDescSelec = (DTOOID)this.conectorParametroSesion(
                                                    "DTODescuentoSeleccionado"); 

          MareBusinessID IDBusiness = new MareBusinessID(
                                                  "DTOObtenerDatosDescuentos");
          Vector params = new Vector();
          params.add(dtoDescSelec);
          params.add(IDBusiness);
                    
          traza("Obteniendo Descuento...");
          DruidaConector conObtDatDesc = this.conectar(
                                      "ConectorObtenerDatosDescuentos", params);
          traza("Volvio de obtener descuento.");                   

          DTOGlobalDescuento dtoGlobalDTO = (DTOGlobalDescuento)conObtDatDesc.
                                                  objeto("DTOGlobalDescuento");          
          
          dtoDescuento = dtoGlobalDTO;         
          
          DTOOID dtoOidCabeDTO = new DTOOID();
          dtoOidCabeDTO.setOid(dtoDescuento.getDatosGralesDto().
                                                        getOidCabeceraDTO());
          dtoOidCabeDTO.setOidPais(lPais);
          dtoOidCabeDTO.setOidIdioma(lIdioma);
          
          IDBusiness = new MareBusinessID("DTOConsultarMatrizDescuentos");
          Vector paramsC = new Vector();
          paramsC.add(dtoOidCabeDTO);
          paramsC.add(IDBusiness);          
          
          traza("Consultando Matriz Descuentos...");
          DruidaConector conMatrDesc = this.conectar(
                                  "ConectorConsultarMatrizDescuentos", paramsC);
          traza("Volvio de consultar matriz descuentos.");                   
                    
          DTODatosMatrizDescuentos dtoDatosMatrDesc = (DTODatosMatrizDescuentos)
                                                conMatrDesc.objeto("dtoSalida");
          
          dtoDescuento.setDatosMatriz(dtoDatosMatrDesc);
                    
      } 
      
     /* // Se inicializan todas los indicadores de las pestañas a false, porque
        //ninguna se ha rellenado 
      dtoDescuento.setIndDatosGralesDto(Boolean.FALSE);
      dtoDescuento.setIndAlcanceTipoCliente(Boolean.FALSE);
      dtoDescuento.setIndAlcanceCliente(Boolean.FALSE);
      dtoDescuento.setIndAlcanceAdministrativo(Boolean.FALSE);
      dtoDescuento.setIndBaseCalculo(Boolean.FALSE);
      dtoDescuento.setIndBaseAplicacion(Boolean.FALSE);
      //BELC300021770 solo para insertar.*/ 

      dtoDescuento.setOidPais(lPais);
      dtoDescuento.setOidIdioma(lIdioma);     
      
      setDescuento(dtoDescuento);    
      traza("LPMantenimientoDTODG.inicializar():Salida");
    }
    
    /**
     * @author Emilio Noziglia
     * @since 10/11/2005
     * @param void
     * @return void 
     * @description metodo que carga la pantalla de la pestanyaDatosGenerales 
     * @reference DMCO-DTO-BELC300014763
     */ 
    public void cargarPantalla() throws Exception{
      traza("LPMantenimientoDTODG.cargarPantalla():Entrada");
  
      Long oidDescuento = null;
      DTODescuentoDG dtoDTODG = null;
      
      DTOGlobalDescuento dtoDescuento = getDescuento();      
      
      String modVig = (String)conectorParametroSesion("modificarVigente");
      
      if ("true".equals(modVig)) {
        casoDeUso = "modificar";
        asignarAtributo("VAR","hidCasoDeUso","valor",casoDeUso);
      }
      // Se recuperan los datos del descuento seleccionado en el caso de que sea 
      // un "modificar" o un "consultar" o "insertar"
      //enozigli cambio por BELC300021715
      dtoDTODG = dtoDescuento.getDatosGralesDto();
      
      if ("modificar".equals(casoDeUso)||"consultar".equals(casoDeUso)) {           
          oidDescuento = dtoDTODG.getOidDescuento(); 
          traza("VIGENCIA DEL DESCUENTO " + dtoDTODG.getVigencia());
      } else { 
          oidDescuento = null;          
      }
      //enozigli fin cambio por BELC300021715
      
      traza("LPMantenimientoDTODG.cargarPantalla() oidDescuento:"+oidDescuento);
      
      asignarAtributo("VAR","hidOidDescuento","valor",oidDescuento!=null?
                                                    oidDescuento.toString():"");

      //el if siguiente se modifico por BELC300021893 

	  if ("modificar".equals(casoDeUso) && ConstantesDTO.DESCUENTO_CADUCADO.
												equals(dtoDTODG.getVigencia())) { 

          traza("LPMantenimientoDTODG.cargarPantalla() Descuento caducado");
		  // 70000014 "El descuento no puede ser modificado"

		  asignarAtributo("VAR","hModificable","valor","no");
          throw new MareException(new Exception(), 
									UtilidadesError.armarCodigoError( 
                                    ConstantesSEG.MODULO_DTO , "",
                                    NO_SE_PUEDE_MODIFICAR_0015));

      }
      
	  asignarAtributo("VAR","hModificable","valor","si");

      //fin BELC300021893 

      
      //el if siguiente se modifico por BELC300021714
      if (("consultar".equals(casoDeUso)) || 
          ("insertar".equals(casoDeUso)) || 
          ("modificar".equals(casoDeUso) && !ConstantesDTO.DESCUENTO_CADUCADO.
                                              equals(dtoDTODG.getVigencia()))) { 
          // Recupera datos de matriz seleccionada y presenta pantalla de
          // ingreso de valores generales de descuento 
          DTODatosMatrizDescuentos dtoDatMatrDTO = dtoDescuento.getDatosMatriz(); 
          
          asignarAtributo("VAR","oidCabeceraDTO","valor",(dtoDTODG!=null&&
                              dtoDTODG.getOidCabeceraDTO()!=null)?dtoDTODG.
                                          getOidCabeceraDTO().toString():"");
          traza("LPMantenimientoDTODG.cargarPantalla() getOidCabeceraDTO():"
                +((dtoDTODG!=null&&dtoDTODG.getOidCabeceraDTO()!=null)?
                                 dtoDTODG.getOidCabeceraDTO().toString():""));
        
          try {
              Iterator iterador = dtoDatMatrDTO.getListaParametros().iterator();        
              while (iterador.hasNext()) {
                  DTOParametroMatrizDescuentos dtoP = 
                                (DTOParametroMatrizDescuentos)iterador.next();
                  String sParam = dtoP.getOidParametro().toString();
                  int para = Integer.parseInt(sParam); 
                  traza("LPMantenimientoDTODG.cargarPantalla() para:"+para);
                  switch (para) {
                        case 2: {
                          asignarAtributo("VAR","VisibleIndicador","valor",
                                              obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioIndicador","valor",
                                          obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificableIndicador","valor",
                                          obtenerValor(dtoP.getModificable()));
      
                          if("insertar".equals(casoDeUso)) {
                            ArrayList arrCulminacion = dtoP.
                                                    getListaValoresPosibles();
                            String sValorObtenido = obtenerValor (
                                                          arrCulminacion );
                            asignarAtributo("VAR","hidCulminacion","valor",
                                                            sValorObtenido );
                          }
                        } break;
                        
                        case 3: {
                            traza("Cargando Marcas");
                            RecordSet rsMarca = new RecordSet();
                            asignarAtributo("VAR","VisibleMarca","valor",
                                              obtenerValor(dtoP.getVisible()));
                            asignarAtributo("VAR","ObligatorioMarca","valor",
                                          obtenerValor(dtoP.getObligatorio()));
                            asignarAtributo("VAR","ModificableMarca","valor",
                                          obtenerValor(dtoP.getModificable()));
                            if (dtoP.getNumeroMaximoValores()!=null){
                                asignarAtributo("VAR","txtNmaximoMarca","valor",
                                      dtoP.getNumeroMaximoValores().toString());    
                            }
                            ArrayList arrMarca = dtoP.getListaValoresPosibles();
                            Iterator itMarca = arrMarca.iterator();
                            StringBuffer st = new StringBuffer();
                            rsMarca.addColumn("ID");
                            rsMarca.addColumn("Descripcion");
                            rsMarca.addColumn("porDef");
                            while (itMarca.hasNext() ) {
                                DTOParametroMarca dtoM = (DTOParametroMarca)
                                                                itMarca.next();
                                traza("dto: " + dtoM);
                                st.append(dtoM.getOidMarca());
                                st.append(",");
                                if ((dtoM.getOidMarca()!= null) && (dtoM.
                                                      getDescripcion()!=null)) {
                                Vector vect = new Vector();
                                vect.add(dtoM.getOidMarca());
                                vect.add(dtoM.getDescripcion());
                                  if (dtoM.getValorPorDefecto().booleanValue()){
                                      vect.add("s");
                                  } else {
                                      vect.add("n"); 
                                  }
                                rsMarca.addRow(vect);
                                }
                            }
                            if (rsMarca.getRowCount() > 0) {
                                traza("recordset: "+rsMarca);
                                Vector vecMarca            = rsMarca.
                                                        getColumnIdentifiers();								
                                int numColMarca            = rsMarca.
                                                        getColumnCount();
                                DruidaConector marca       = generarConector(
                                 "DTOSalida.resultado_ROWSET",rsMarca,vecMarca);
                                traza("conector marca: "+ marca.getXML());
                                asignar("COMBO","cbMarca",marca,
                                                  "DTOSalida.resultado_ROWSET");
                            }
                            if (st.length() >1) {
                                StringBuffer subcadena = st;
                                asignarAtributo("VAR","selMarca","valor",
                                        st.substring(0,subcadena.length()- 1));
                                traza("Valor Seleccionado..: "  +  
                                      st.substring(0,subcadena.length()- 1)  );
                            }
                        } break;
      
                        case 4: {
                            traza("Cargando Canales");
                            RecordSet rsCanal = new RecordSet();
                            asignarAtributo("VAR","VisibleCanal","valor",
                                              obtenerValor(dtoP.getVisible()));
                            asignarAtributo("VAR","ObligatorioCanal","valor",
                                          obtenerValor(dtoP.getObligatorio()));
                            asignarAtributo("VAR","ModificableCanal","valor",
                                          obtenerValor(dtoP.getModificable()));
                            ArrayList arrCanal = dtoP.getListaValoresPosibles();
                            Iterator itCanal = arrCanal.iterator();
                            StringBuffer st = new StringBuffer();
                            rsCanal.addColumn("ID");
                            rsCanal.addColumn("Descripcion");
                            rsCanal.addColumn("porDef");
                            while (itCanal.hasNext()) {
                                DTOParametroCanal dtoC = (DTOParametroCanal)
                                                                itCanal.next();
                                traza("dto: " + dtoC);
                                st.append(dtoC.getOidCanal());
                                st.append(",");
                                Vector vect = new Vector();
                                vect.add(dtoC.getOidCanal());
                                vect.add(dtoC.getDescripcion());
                                    if (dtoC.getValorPorDefecto().
                                                        booleanValue()) {
                                        vect.add("s");
                                    } else { 
                                        vect.add("n"); 
                                    }
      
                                if (dtoC.getValorPorDefecto().booleanValue()) {
                                  traza("Canal Elegido (1):   " + 
                                                        dtoC.getDescripcion());
                                  asignarAtributo("VAR","selCanal","valor",
                                                dtoC.getOidCanal().toString());
                                }
                                rsCanal.addRow(vect);
                            }
                            if (rsCanal.getRowCount() > 0) {
                                traza("recordset: "+ rsCanal);
                                Vector vecCanal            = rsCanal.
                                                        getColumnIdentifiers();								
                                int numColCanal            = rsCanal.
                                                              getColumnCount();
                                DruidaConector canal       = generarConector(
                                "DTOSalida.resultado_ROWSET",rsCanal,vecCanal);
                                asignar("COMBO","cbCanal",canal,
                                              "DTOSalida.resultado_ROWSET");
                            }
                            if (st.length() >1) {
                                StringBuffer subcadena = st;
                                asignarAtributo("VAR","selCanal","valor",
                                        st.substring(0,subcadena.length()- 1));
                                traza("Canal Seleccionado .... " +
                                        st.substring(0,subcadena.length()- 1));                                    
                            }   
                            
                        } break;
      
                        case 5: {
                            traza("Cargando Accesos");
                            StringBuffer oids = new StringBuffer();
                            StringBuffer desc = new StringBuffer();
                            StringBuffer canal = new StringBuffer();
                            
                            RecordSet rsAcceso = new RecordSet();                                    
                            asignarAtributo("VAR","VisibleAcceso","valor",
                                            obtenerValor(dtoP.getVisible()));
                            asignarAtributo("VAR","ObligatorioAcceso","valor",
                                          obtenerValor(dtoP.getObligatorio()));
                            asignarAtributo("VAR","ModificableAcceso","valor",
                                          obtenerValor(dtoP.getModificable()));
                            if (dtoP.getNumeroMaximoValores()!=null) {
                                asignarAtributo("VAR","txtNmaximoAcceso","valor",
                                      dtoP.getNumeroMaximoValores().toString());  
                            }
                            ArrayList arrAcceso = dtoP.getListaValoresPosibles();
                            Iterator itAcceso = arrAcceso.iterator();
                            StringBuffer st = new StringBuffer();
                            rsAcceso.addColumn("ID");
                            rsAcceso.addColumn("Descripcion");
                            rsAcceso.addColumn("porDef");
                            while (itAcceso.hasNext()) {
                                DTOParametroAcceso dtoA = (DTOParametroAcceso)
                                                                itAcceso.next();
      
                                oids.append(dtoA.getOidAcceso());
                                desc.append(dtoA.getDescripcion());
                                canal.append(dtoA.getOidCanal());
                                oids.append(",");
                                desc.append(",");
                                canal.append(",");
                            }
                            traza(">> OID     " + oids);
                            traza(">> DESC    " + desc);
                            traza(">> CANAL   " + canal); 
                            asignarAtributo("VAR", "accesoOid", "valor", 
                                                              oids.toString());
                            asignarAtributo("VAR", "accesoDesc", "valor", 
                                                              desc.toString());
                            asignarAtributo("VAR", "accesoOidPadre", "valor", 
                                                              canal.toString());
                        } break;
      
                        case 6: {
                            traza("Cargando SubAccesos");
                            RecordSet rsSubAcceso = new RecordSet();
                            StringBuffer oids = new StringBuffer();
                            StringBuffer desc = new StringBuffer();
                            StringBuffer accesos = new StringBuffer();
      
                            asignarAtributo("VAR","VisibleSubacceso","valor",
                                              obtenerValor(dtoP.getVisible()));
                            asignarAtributo("VAR","ObligatorioSubacceso","valor",
                                          obtenerValor(dtoP.getObligatorio()));
                            asignarAtributo("VAR","ModificableSubacceso","valor",
                                          obtenerValor(dtoP.getModificable()));
                            if (dtoP.getNumeroMaximoValores()!=null) {
                                asignarAtributo("VAR","txtNmaximoSubacceso",
                                "valor",dtoP.getNumeroMaximoValores().toString());  
                            }
                            ArrayList arrsubAcceso = dtoP.getListaValoresPosibles();
                            Iterator itsubAcceso = arrsubAcceso.iterator();
                            StringBuffer st = new StringBuffer();
                            rsSubAcceso.addColumn("ID");
                            rsSubAcceso.addColumn("Descripcion");
                            rsSubAcceso.addColumn("porDef");
                            while (itsubAcceso.hasNext()) {
                                DTOParametroSubacceso dtoS =
                                      (DTOParametroSubacceso)itsubAcceso.next();
                                oids.append( dtoS.getOid());                                    
                                desc.append( dtoS.getDescripcionSubacceso());
                                accesos.append(dtoS.getOidAcceso());
                                
                                oids.append(",");
                                desc.append(",");
                                accesos.append(",");
                            }
                            traza(">> OID     " + oids);
                            traza(">> DESC    " + desc);
                            traza(">> ACCESO  " + accesos);
                            asignarAtributo("VAR", "SubaccesoOid", "valor", 
                                                              oids.toString());
                            asignarAtributo("VAR", "SubaccesoDesc", "valor",
                                                              desc.toString());
                            asignarAtributo("VAR", "SubaccesoOidPadre", "valor",
                                                            accesos.toString());
                        } break;
      
                        case 7: {                              
                          asignarAtributo("VAR","VisiblePeriodoInicial",
                                      "valor",obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioPeriodoInicial",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificablePeriodoInicial",
                                  "valor",obtenerValor(dtoP.getModificable()));
                        } break;  
                        
                        case 8: {                              
                          asignarAtributo("VAR","VisiblePeriodoFinal",
                                      "valor",obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioPeriodoFinal",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificablePeriodoFinal",
                                  "valor",obtenerValor(dtoP.getModificable()));
                        } break;
            
                        case 10: {
                          traza("entro a Porcentaje");
                          asignarAtributo("VAR","VisiblePorcentaje",
                                      "valor",obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioPorcentaje",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificablePorcentaje",
                                  "valor",obtenerValor(dtoP.getModificable()));
                        } break;
            
                        case 26: {
                          traza("entro a ControlMorosidad");
                          asignarAtributo("VAR","VisibleControlMorosidad",
                                      "valor",obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioControlMorosidad",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificableControlMorosidad",
                                  "valor",obtenerValor(dtoP.getModificable()));
                          if("insertar".equals(casoDeUso)) {
                            ArrayList arrMorosidad = dtoP.getListaValoresPosibles();
                            String sValorObtenido = obtenerValor ( arrMorosidad );
                            asignarAtributo("VAR","hidMorosidad","valor", 
                                                              sValorObtenido );
                          }
                        } break;
            
                        case 27: {                               
                           asignarAtributo("VAR","VisibleControlDA",
                                      "valor",obtenerValor(dtoP.getVisible()));
                           asignarAtributo("VAR","ObligatorioControlDA",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                           asignarAtributo("VAR","ModificableControlDA",
                                  "valor",obtenerValor(dtoP.getModificable()));
                           if("insertar".equals(casoDeUso)) {
                            ArrayList arrDevolAnula = dtoP.getListaValoresPosibles();
                            String sValorObtenido = obtenerValor(arrDevolAnula);
                            asignarAtributo("VAR","hidControlDevoluciones",
                                                    "valor", sValorObtenido );
                            asignarAtributo("VAR","hidControlAnulaciones",
                                                    "valor", sValorObtenido );
                          }
                        } break;
            
                        case 28: {
                          traza("entro a Descuento Acumulativo");
                          asignarAtributo("VAR","VisibleControlDesc",
                                      "valor",obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioControlDesc",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificableControlDesc",
                                  "valor",obtenerValor(dtoP.getModificable()));
                          if("insertar".equals(casoDeUso)) {
                            ArrayList arrDescAcum = dtoP.getListaValoresPosibles();
                            String sValorObtenido = obtenerValor(arrDescAcum);
                            asignarAtributo("VAR","hidDescuentoAcumulativo",
                                                      "valor", sValorObtenido);
                          }
                        } break;
            
                        case 29: {
                          traza("entro a AfectaFactura");
                          asignarAtributo("VAR","VisibleAfectaFactura",
                                    "valor",obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioAfectaFactura",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificableAfectaFactura",
                                  "valor",obtenerValor(dtoP.getModificable()));
                          if("insertar".equals(casoDeUso)) {
                            ArrayList arrAfectaFact = dtoP.getListaValoresPosibles();
                            String sValorObtenido = obtenerValor(arrAfectaFact);
                            asignarAtributo("VAR","hidAfectaAFacturas",
                                                    "valor", sValorObtenido );
                          }
                        } break;
            
                        case 30: {
                          traza("entro a Afecta CtaCte");
                          asignarAtributo("VAR","VisibleAfectaCC","valor",
                                              obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioAfectaCC","valor",
                                        obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificableAfectaCC","valor",
                                          obtenerValor(dtoP.getModificable()));
                          if("insertar".equals(casoDeUso)) {
                            ArrayList arrAfectaCtaCte = dtoP.getListaValoresPosibles();
                            String sValorObtenido = obtenerValor(arrAfectaCtaCte);
                            asignarAtributo("VAR","hidAfectaACuentasCorrientes",
                                                    "valor", sValorObtenido );
                          }
                        } break;
            
                        case 31: {
                          //traza("entro al Comunicacion a participantes");
                          asignarAtributo("VAR","VisibleComunicacion","valor",
                                            obtenerValor(dtoP.getVisible()));
                          asignarAtributo("VAR","ObligatorioComunicacion",
                                  "valor",obtenerValor(dtoP.getObligatorio()));
                          asignarAtributo("VAR","ModificableComunicacion",
                                  "valor",obtenerValor(dtoP.getModificable()));
                          if("insertar".equals(casoDeUso)) {
                            ArrayList arrComunicParticipantes = dtoP.
                                                      getListaValoresPosibles();
                            String sValorObtenido = obtenerValor(
                                                      arrComunicParticipantes);
                            asignarAtributo("VAR",
                                "hidCdomunicacionAParticipantes","valor", 
                                  sValorObtenido );
                          }
                        } break;
                }
            }
            } catch(Exception ex) {
              logStackTrace(ex);
              this.lanzarPaginaError(ex);
            }
      } // Fin si 
      
      traza("LPMantenimientoDTODG.cargarPantalla() casoDeUso:"+casoDeUso);      
      
      if ("insertar".equals(casoDeUso)) {          
          getConfiguracionMenu("LPMantenimientoDTODG","insercion");
          asignarAtributoPagina("cod","0644");          
 
          if (dtoDTODG!=null) {
              anyadeHiddensI18N(false, "DTO_DESCU", oidDescuento,
                  new Integer(1),"formulario", "txtNombreDescuento", false);
              reasignaTraduccionesI18N(dtoDTODG.getAttTraducible(),new Integer(1));
              asignarAtributo("VAR","hVuelveErrPest","valor","S");;
              Vector vec = dtoDTODG.getAttTraducible();
              Iterator desc = vec.iterator();
              while(desc.hasNext()) {
                DTOI18nSICC dto = (DTOI18nSICC)desc.next();
                if (dto.getOidIdioma().equals(UtilidadesSession.
                                                            getIdioma(this))) {
                  asignarAtributo("CTEXTO","txtNombreDescuento","valor",
                                                dto.getValorI18n().toString());
                }
              }
              traza("insertar5");
              asignarAtributo("VAR","selPD","valor",dtoDTODG.
                                              getOidPeriodoDesde().toString());
              asignarAtributo("VAR","selPH","valor",dtoDTODG.
                                  getOidPeriodoHasta()!=null?dtoDTODG.
                                          getOidPeriodoHasta().toString():"");              
              seteaValoresDescuentoSeleccionado(dtoDTODG);
          } else {
              anyadeHiddensI18N(true, "DTO_DESCU", oidDescuento, new Integer(1),
                                    "formulario", "txtNombreDescuento", false);
          }
      } else  if ("consultar".equals(casoDeUso)) {  
          
          anyadeHiddensI18N(true, "DTO_DESCU", oidDescuento, new Integer(1),
                                      "formulario", "txtNombreDescuento", true);
          
          asignarAtributo("VAR","oidCabeceraDTO","valor",dtoDTODG.
                                                getOidCabeceraDTO().toString());
          asignarAtributo("VAR","hidNumDescuento","valor",dtoDTODG.
                                  getNumeroDescuento()!=null?dtoDTODG.
                                      getNumeroDescuento().toString():"");
          
          Vector vec = dtoDTODG.getAttTraducible();
          Iterator desc = vec.iterator();
          while(desc.hasNext()) {
            DTOI18nSICC dto = (DTOI18nSICC)desc.next();
            if (dto.getOidIdioma().equals(UtilidadesSession.getIdioma(this))){
              asignarAtributo("CTEXTO","txtNombreDescuento","valor",
                                                  dto.getValorI18n().toString());
            }
          }
          
          DTOOID dtoOidMatrizSeleccionada = new DTOOID();
          dtoOidMatrizSeleccionada.setOid(dtoDTODG.getOidCabeceraDTO());
          
          asignarAtributo("VAR","selPD","valor",dtoDTODG.getOidPeriodoDesde().
                                                                    toString());
          asignarAtributo("VAR","selPH","valor",dtoDTODG.
                              getOidPeriodoHasta()!=null?dtoDTODG.
                                      getOidPeriodoHasta().toString():"");
          getConfiguracionMenu("LPMantenimientoDTODG","consultar");
          asignarAtributoPagina("cod","0233");            
          
          seteaValoresDescuentoSeleccionado(dtoDTODG);
      } else if ("modificar".equals(casoDeUso)) {
          getConfiguracionMenu("LPMantenimientoDTODG","modificar");
          asignarAtributoPagina("cod","0354");
          

          if(ConstantesDTO.DESCUENTO_CADUCADO.equals(dtoDTODG.getVigencia())) {
              asignarAtributo("VAR","hidVigenciaDescuento","valor","C");
              anyadeHiddensI18N(false, "DTO_DESCU", oidDescuento, 
                      new Integer(1),"formulario", "txtNombreDescuento", false);
              traza("Setea hidVigenciaDescuentovalor C");
          } else if(ConstantesDTO.DESCUENTO_FUTURO.equals(
                                                    dtoDTODG.getVigencia())) {
              asignarAtributo("VAR","hidVigenciaDescuento","valor","F");
              anyadeHiddensI18N(false, "DTO_DESCU", oidDescuento, 
                      new Integer(1),"formulario", "txtNombreDescuento", false);
              traza("Setea hidVigenciaDescuento valor F");
          } else if(ConstantesDTO.DESCUENTO_VIGENTE.equals(
                                                    dtoDTODG.getVigencia())) {
              asignarAtributo("VAR","hidVigenciaDescuento","valor","V");
              anyadeHiddensI18N(true, "DTO_DESCU", oidDescuento, new Integer(1),
                                    "formulario", "txtNombreDescuento", true);
              
              traza("Setea hidVigenciaDescuento valor V");
          }
          reasignaTraduccionesI18N(dtoDTODG.getAttTraducible(),new Integer(1));
          
          asignarAtributo("VAR","hidNumDescuento","valor",dtoDTODG.
                                  getNumeroDescuento()!=null?dtoDTODG.
                                          getNumeroDescuento().toString():"");
          
          Vector vec = dtoDTODG.getAttTraducible();
          Iterator desc = vec.iterator();
          while(desc.hasNext()) {
            DTOI18nSICC dto = (DTOI18nSICC)desc.next();
            if (dto.getOidIdioma().equals(UtilidadesSession.getIdioma(this))) {
              asignarAtributo("CTEXTO","txtNombreDescuento","valor",dto.
                                                    getValorI18n().toString());
            }
          }          
          asignarAtributo("VAR","selPD","valor",dtoDTODG.getOidPeriodoDesde().
                                                                    toString());
          asignarAtributo("VAR","selPH","valor",dtoDTODG.
                            getOidPeriodoHasta()!=null?dtoDTODG.
                                    getOidPeriodoHasta().toString():"");
          
          seteaValoresDescuentoSeleccionado(dtoDTODG);
      } //Fin Si       
      asignarAtributo("VAR","casoDeUso","valor",casoDeUso);     
      
      traza("LPMantenimientoDTODG.cargarPantalla():Salida");
    }

  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param void  
   * @return void 
   * @throws Exception
   * @description metodo que se encarga de llamar a almacenar los datos de la
   *              pestanyaDatosGenerales y llamar a la carga de la 
   *              pestanyaTipoClientes.
   * @reference DMCO-DTO-BELC300014763
   */    
    public void siguiente() throws Exception{
      traza("LPMantenimientoDTODG.siguiente():Entrada");
      
      if ("insertar".equals(casoDeUso)||"modificar".equals(casoDeUso)){
          this.almacenar();
      } else {
          DTOOID sNroDesc = new DTOOID();
          sNroDesc.setOid(new Long(conectorParametro("hidOidDescuento")));
          conectorParametroSesion("DTONumeroDescuento",sNroDesc);
      }
      conectorAction("LPMantenimientoAlcanceTipoCliente");
      conectorActionParametro("accion","");
      conectorActionParametro("casoDeUso",casoDeUso);
      
      traza("LPMantenimientoDTODG.siguiente():Salida");
    }    
    
  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param DTODescuentoDG
   * @return void 
   * @throws Exception
   * @description metodo que carga en la pestanyaDatosGenerales los datos del
   *              descuento recibido por parametro
   * @reference DMCO-DTO-BELC300014763
   */       
    private void seteaValoresDescuentoSeleccionado(DTODescuentoDG dtoDescDG) 
        throws Exception {
      traza("LPMantenimientoDTODG.seteaValoresDescuentoSeleccionado():Entrada");
      
      asignarAtributo("VAR","hidOidMarca", "valor",dtoDescDG.
                    getOidMarca()!=null?dtoDescDG.getOidMarca().toString():"");      
      asignarAtributo("VAR","hidOidCanal","valor",dtoDescDG.
                    getOidCanal()!=null?dtoDescDG.getOidCanal().toString():"");
      
      if (dtoDescDG.getAccesos()!= null) {
        DTOOIDs dtoAccesos = dtoDescDG.getAccesos();
        String sAccesos = vAplanaInfo(dtoAccesos);
        if (sAccesos!= null) {
          asignarAtributo("VAR","hidAccesos","valor",sAccesos);
          traza(">>>>Accesos........" + sAccesos);
        }
      }
      
      if (dtoDescDG.getSubaccesos()!= null) {
        DTOOIDs dtoSubAccesos = dtoDescDG.getSubaccesos();
        String sSubAccesos = vAplanaInfo(dtoSubAccesos);
        if ( sSubAccesos!= null){
          asignarAtributo("VAR","hidSubAccesos","valor",sSubAccesos);
          traza(">>>>SubAccesos....." + sSubAccesos);
        }
      }
      
      asignarAtributo("VAR","hidOidPeriodoDesde","valor",dtoDescDG.
                                              getOidPeriodoDesde().toString());      
      asignarAtributo("VAR","hidOidPeriodoHasta","valor",
                      dtoDescDG.getOidPeriodoHasta()!=null?dtoDescDG.
                                            getOidPeriodoHasta().toString():"");      
      asignarAtributo("VAR", "hidDescuentoAcumulativo", "valor",
                      (dtoDescDG.getDescuentoAcumulativo().
                                  equals(new Boolean(false)))?"N":"S");      
      asignarAtributo("VAR", "hidCulminacion", "valor",
                      (dtoDescDG.getCulminacion().
                                    equals(new Boolean(false)))?"N":"S");
      asignarAtributo("VAR", "hidControlDevoluciones", "valor",
                      (dtoDescDG.getControlDevoluciones().
                                    equals(new Boolean(false)))?"N":"S");      
      asignarAtributo("VAR", "hidControlAnulaciones", "valor",
                      (dtoDescDG.getControlAnulaciones().
                                    equals(new Boolean(false)))?"N":"S");      
      asignarAtributo("VAR", "hidCdomunicacionAParticipantes", "valor",
                      (dtoDescDG.getComunicacionAParticipantes().
                                      equals(new Boolean(false)))?"N":"S");      
      asignarAtributo("VAR", "hidActiva", "valor",
                      (dtoDescDG.getActivo().equals(new Boolean(false))) ?
                                                                  "N" : "S");      
      asignarAtributo("VAR", "hidMorosidad", "valor",
                      (dtoDescDG.getMorosidad().equals( 
                            new Boolean(false))) ? "N" : "S");      
      asignarAtributo("VAR", "hidAfectaAFacturas", "valor",
                      (dtoDescDG.getAfectaAFacturas().equals(
                                  new Boolean(false))) ? "N" : "S");      
      asignarAtributo("VAR", "hidAfectaACuentasCorrientes", "valor",
                      (dtoDescDG.getAfectaACuentasCorrientes().equals(
                                        new Boolean(false))) ? "N" : "S");
                      
      traza("LPMantenimientoDTODG.seteaValoresDescuentoSeleccionado():Salida");
	}      

  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param Boolean
   * @return String 
   * @throws 
   * @description metodo que transforma un valor booleano en un String "S" o "N"
   */      
  private String obtenerValor(Boolean bool) {
      if(bool.booleanValue()) {      
        return "S";
      } else {
        return "N";
      }
  }  
  
  /**
   * @author
   * @since 10/11/2005
   * @param ArrayList
   * @return String 
   * @throws 
   * @description 
   * @reference 
   */   
  private String obtenerValor(ArrayList arrValores) {
      
      Iterator itMorosidad = arrValores.iterator();
      boolean  bFindit =  false;
      String sValorObtenido = new String();
  
      while (itMorosidad.hasNext() && !bFindit) {
          DTOParametroBoolean dtoB = (DTOParametroBoolean)itMorosidad.next();
          if ((dtoB.getOid()!= null) && (dtoB.getValor()!=null)){
              if (dtoB.getValorPorDefecto().booleanValue()) {
                  if (dtoB.getValor().toString().equals("true")) {
                      sValorObtenido = "S";
                  } else {
                      sValorObtenido = "N";
                  }
          
                  bFindit =  true;	
              }
          }
      }
      return sValorObtenido;
  }  

  /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param void
   * @return void 
   * @throws Exception
   * @description metodo guarda en sesion los valores de pestanyaDatosGenerales 
   *              en el DTOGlobalDescuento
   * @reference DMCO-DTO-BELC300014763
   */  
  public void almacenar() throws Exception{
    traza("LPMantenimientoDTODG.almacenar():Entrada");

    DTOGlobalDescuento dtoDescuento = getDescuento();
    
    DTODescuentoDG dtoDtoDG = null;
    
    if (dtoDescuento.getDatosGralesDto()!=null){
      dtoDtoDG = dtoDescuento.getDatosGralesDto();
    } else {
      dtoDtoDG = new DTODescuentoDG();
    }
    
    dtoDtoDG = recuperaDatosSeleccionados(dtoDtoDG);
    dtoDtoDG.setOidPais(lPais);
    dtoDtoDG.setOidIdioma(lIdioma);
    
    if ("insertar".equals(casoDeUso)) {    
        //-> Asignar al atributo "nacional" el valor "false", este valor será 
        //introducido por el usuario en el alcance administrativo 
        if (dtoDtoDG.getNacional()==null){ //BELC300021769
          dtoDtoDG.setNacional(Boolean.FALSE);        
        }
    } else { 
        // El atributo "nacional" no se modifcará 
        // Se quedará con el valor seteado en el alcance administrativo 
    } 
    //-> Asignar al atributo oidCabeceraDTO el valor obtenido de 
    // dtoDescuento.datosMatriz.oidCabeceraMatriz 
    traza("dtoDescuento.getDatosMatriz().getOidCabeceraMatriz()"+
                    dtoDescuento.getDatosMatriz().getOidCabeceraMatriz());
    dtoDtoDG.setOidCabeceraDTO(dtoDescuento.getDatosMatriz().
                                                getOidCabeceraMatriz());
    
    dtoDescuento.setDatosGralesDto(dtoDtoDG);    
    dtoDescuento.setIndDatosGralesDto(Boolean.TRUE);
    //indica que ya se ha rellenado la pestaña 
    
    if ("modificar".equals(casoDeUso)&&
        ConstantesDTO.DESCUENTO_VIGENTE.equals(dtoDtoDG.getVigencia())) {  
            casoDeUso = "consultar";
            this.conectorParametroSesion("modificarVigente","true");
        }
    
    setDescuento(dtoDescuento);    
    
    traza("LPMantenimientoDTODG.almacenar():Salida");
  }  
 
   /**
   * @author Emilio Noziglia
   * @since 10/11/2005
   * @param void
   * @return DTODescuentoDG 
   * @throws Exception
   * @description recupera de la página los valores de los controles
   * @reference DMCO-DTO-BELC300014763
   */  
    private DTODescuentoDG recuperaDatosSeleccionados(DTODescuentoDG 
          dtoDescDGrales) throws Exception {    
        traza("LPManteniemientoDTODG.recuperaDatosSeleccionados():Entrada");
      
        DTOOIDs dtoAccesos = new DTOOIDs ();
        DTOOIDs dtoSubAccesos = new DTOOIDs ();

        Vector vTtraducciones = recuperaTraduccionesI18N(new Integer(1));
        dtoDescDGrales.setAttTraducible(vTtraducciones);
        
        traza("oid: "+conectorParametro("hidOidDescuento").toString());
        if (!conectorParametro("hidOidDescuento").equals("")) {
            dtoDescDGrales.setOidDescuento(new Long(conectorParametro(
                                                          "hidOidDescuento")));
        }

        lOidMarca = Long.valueOf(conectorParametro("hidOidMarca"));
        dtoDescDGrales.setOidMarca(lOidMarca);
        lOidCanal = Long.valueOf(conectorParametro("hidOidCanal"));
        dtoDescDGrales.setOidCanal(lOidCanal);

        String sAccesos = conectorParametro("hidAccesos")==null?"":
                                              conectorParametro("hidAccesos");
        String sSubAccesos = conectorParametro("hidSubAccesos")==null?"":
                                            conectorParametro("hidSubAccesos");
        if (sAccesos != null)	{
            traza(">>>>>>> Accesos.." + sAccesos);
            lAccesos =  construirLineaSeleccionada(sAccesos,"|");
            traza(">>>>>>> Accesos.." + lAccesos.toString());
    		}	else {
            lAccesos = null;
        }

        dtoAccesos.setOids(lAccesos);
        dtoDescDGrales.setAccesos( dtoAccesos );

        if (sSubAccesos != null) {
          traza(">>>>>>> SubAccesos.." + sSubAccesos);
          lSubAccesos =  construirLineaSeleccionada(sSubAccesos,"|");
          traza(">>>>>>> SubAccesos.." + lSubAccesos.toString());
        } else {
          lSubAccesos = null;
        }
        
        dtoSubAccesos.setOids(lSubAccesos);
        dtoDescDGrales.setSubaccesos(dtoSubAccesos);       
        traza("hidOidPeriodoDesde: "+conectorParametro("hidOidPeriodoDesde") + 
              ", hidOidPeriodoHasta: "+conectorParametro("hidOidPeriodoHasta"));		
        
        if (!conectorParametro("hidOidPeriodoDesde").equals("")) {
            traza("hidOidPeriodoDesde: "+conectorParametro(
                                                  "hidOidPeriodoDesde"));
            lOidPeriodoDesde  = Long.valueOf(conectorParametro(
                                                  "hidOidPeriodoDesde"));
            dtoDescDGrales.setOidPeriodoDesde(lOidPeriodoDesde);
        }
        if (!conectorParametro("hidOidPeriodoHasta").equals("")) {
            traza("hidOidPeriodoHasta: "+conectorParametro(
                                                  "hidOidPeriodoHasta"));
            lOidPeriodoHasta  = Long.valueOf(conectorParametro(
                                                  "hidOidPeriodoHasta"));
            dtoDescDGrales.setOidPeriodoHasta(lOidPeriodoHasta);
        }
        traza(">>>>>>> Tomando valores de la lista");
        if(conectorParametro("hidDescuentoAcumulativo").equals("S")) {
            dtoDescDGrales.setDescuentoAcumulativo(Boolean.TRUE);
        } else {
            dtoDescDGrales.setDescuentoAcumulativo(Boolean.FALSE);
        }

        if(conectorParametro("hidCulminacion").equals("S")) {
            dtoDescDGrales.setCulminacion(Boolean.TRUE);
        } else {
            dtoDescDGrales.setCulminacion(Boolean.FALSE);
        }

        if(conectorParametro("hidControlDevoluciones").equals("S")) {
            dtoDescDGrales.setControlDevoluciones(Boolean.TRUE);
        } else {
            dtoDescDGrales.setControlDevoluciones(Boolean.FALSE);
        }

        if(conectorParametro("hidControlAnulaciones").equals("S")) {
            dtoDescDGrales.setControlAnulaciones(Boolean.TRUE);
        } else {
            dtoDescDGrales.setControlAnulaciones(Boolean.FALSE);
        }

        if(conectorParametro("hidCdomunicacionAParticipantes").equals("S")) {
            dtoDescDGrales.setComunicacionAParticipantes(Boolean.TRUE);
        } else { 
            dtoDescDGrales.setComunicacionAParticipantes(Boolean.FALSE);
        }

        if(conectorParametro("hidActiva").equals("S")) {
            dtoDescDGrales.setActivo(Boolean.TRUE);
        } else {
            dtoDescDGrales.setActivo(Boolean.FALSE);
        }

        if(conectorParametro("hidMorosidad").equals("S")) {
            dtoDescDGrales.setMorosidad(Boolean.TRUE);
        } else {
            dtoDescDGrales.setMorosidad(Boolean.FALSE);
        }

        if(conectorParametro("hidAfectaAFacturas").equals("S")) {
            dtoDescDGrales.setAfectaAFacturas(Boolean.TRUE);
        } else {
            dtoDescDGrales.setAfectaAFacturas(Boolean.FALSE);
        }

        if(conectorParametro("hidAfectaACuentasCorrientes").equals("S")) {
            dtoDescDGrales.setAfectaACuentasCorrientes(Boolean.TRUE);
        } else {
            dtoDescDGrales.setAfectaACuentasCorrientes(Boolean.FALSE);
        }

        dtoDescDGrales.setAprobado(Boolean.FALSE);

        traza("LPManteniemientoDTODG.recuperaDatosSeleccionados():Salida");
        return dtoDescDGrales;
    }

    
    
    public void reasignaTraduccionesI18N(Vector atributosTraducibles,
      Integer nroAtributoTraducible) throws Exception {
      
      Iterator itAttr = atributosTraducibles.iterator();
      
      while (itAttr.hasNext()) {
        DTOI18nSICC dto = (DTOI18nSICC)itAttr.next();
        if (dto!=null){
          String traduccion = dto.getValorI18n(); //traduccion
          Long idiomaTR = dto.getOidIdioma(); //idioma
          Long nroAtrib = dto.getOidAtriuto(); //nro. atributo traducible
          if (idiomaTR!=null&&nroAtrib!=null){
            asignarAtributo("VAR","hi18NTraduccion_"+nroAtrib+"_"+idiomaTR,
                            "valor",traduccion!=null?traduccion.toString():"");                        
          }
        }
      }
       asignarAtributo("VAR","hi18NCargado_1","valor","false");
       asignarAtributo("VAR","hBandera_1","valor","false");      
   }
  
}
