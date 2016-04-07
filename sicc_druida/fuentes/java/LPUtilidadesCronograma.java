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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;

import es.indra.sicc.cra.util.TADCronograma;

import java.util.HashMap;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.sql.Date;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:      Cronograma
 * Componente:    LPGeneraCronogramaFase1 
 * Fecha:             02/06/2004
 * Observaciones:     
 * @version        1.0
 * @autor           Luis Ramos
 */

public class LPUtilidadesCronograma extends LPSICCBase {
  protected TADCronograma tadCronograma;
  protected String listaFueraPeriodo;
  protected String componenteGrafico;
  protected String ocultoDiasSemana;  //Para i18N de Dias de la Semana
  protected String ocultoMeses;  //Para i18N de Meses
  protected String i18NtituloZona;
  protected String i18NtituloGrupoZona;
  protected Vector diasSemana;
  protected Vector meses;
  protected String lblFija = "";
  protected String lblReferencia = "";
  protected boolean esManteCrono = false;
  protected boolean esConsCrono = false;


	public LPUtilidadesCronograma() {
		super();
	}

	public void inicio() throws Exception {
	}

	public void ejecucion() throws Exception {
	}

  /** Muestra el cronograma y la lista de fuera de periodo en la página PantallaGenerarCronogramaFase1. **/
  protected void vistaCronograma() throws Exception {
      inicializarVectores();
      muestraCronograma(); 
      muestraListaFueraPeriodo(); 
      muestraListaReferenciaOtroPeriodo();

	  if (tadCronograma.esZonas()) 
          asignarAtributo( "VAR", "hEsZona", "valor", "1");

  }

  /** Muestra la vista del cronograma en el componente REJILLA cuyo nombre viene indicado 
   * por el atributo componenteGrafico.  **/
  private void muestraCronograma () throws Exception {
        traza("metodo muestraCronograma");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element matrix = docDestino.createElement("MATRIX");
        matrix.setAttribute("cod", "181");  //i18n titulo "Tabla gráfica"
        ajustarMatriz(matrix);

        traza("--1--");

        /*  1.- Las cabeceras de las COLUMNAS se rellenan así: */
        // 1.a.- La primera con el texto "Grupo zona" 
        /*
        traza("Creando COLUMNAS.");
        Element elemColumnsUp = docDestino.createElement("COLUMNSUP");
        matrix.appendChild(elemColumnsUp);
        Element elemColUp = docDestino.createElement("COLUP");
        elemColUp.setAttribute("label", "Tabla gráfica");
        elemColumnsUp.appendChild(elemColUp); */
        
        // 1.b.- Las siguientes se rellenan desde uno hasta la cantidad de dias del periodo
        Element elemColumns = docDestino.createElement("COLUMNS");
        matrix.appendChild(elemColumns);
        //Agrego el título de la primera columna: Zona o Grupo zona
        //Element elemPriCol = docDestino.createElement("COL");
        
        traza("--2--");
        
        if (tadCronograma.esZonas()) {
              //elemPriCol.setAttribute("label", conectorParametroLimpia( i18NtituloZona, "", true ));
              elemColumns.setAttribute("cod", "236");  //i18n "Zona"
        } else {
              //elemPriCol.setAttribute("label", conectorParametroLimpia( i18NtituloGrupoZona, "", true ));       
              elemColumns.setAttribute("cod", "298");  //i18n "Grupo Zona"
        }
        //elemColumns.appendChild(elemPriCol);
        int cantDias = tadCronograma.obtieneDiasCronograma().intValue();
        Date iniPerio = tadCronograma.obtieneInicioPeriodo();
        
        traza("lalala");
        
        traza("Cant Dias crono: " + cantDias);
        
        traza("DIAS SEMANA: " + this.diasSemana);
        traza("DIAS MES: " + this.meses);
        
        
        for (int col = 0; col < cantDias; col++)  {
            Calendar c = new GregorianCalendar();
            c.setTime(iniPerio);
            c.add(Calendar.DATE, col);
            String fechaEncab = armarFechaEncabezado(c);
            //traza("Fecha Encabezado: "+fechaEncab);
            Element elemCol = docDestino.createElement("COL");
            elemCol.setAttribute("label", fechaEncab);
            elemColumns.appendChild(elemCol);
        } 

        
        traza("Creando COLUMNAS finalizado.");

        // 2.- El lateral izquierdo, ROWS, de la tabla se rellena así: 
        traza("Creando FILAS.");
        Element elemRows = docDestino.createElement("ROWS");
        matrix.appendChild(elemRows);
        // se llama a tadCronograma.obtieneGrupos() y devuelve un vector de DTOGrupoCronograma que llamamos grupos 
        Vector vecGrupos = tadCronograma.obtieneGrupos();
        //traza("Vector de Grupos: "+vecGrupos);
        // 2.b.- por cada objeto DTOGrupoCronograma (que llamamos grupo) del vector grupos se recoge 
        //el valor del atributo textoGrupo y se va rellenando cada celda.
        for (int i = 0; i < vecGrupos.size(); i++)  {
            DTOGrupoCronograma grupo = (DTOGrupoCronograma) vecGrupos.elementAt(i);
            // fila grupoZona
            Element elemRow = docDestino.createElement("ROW");
            elemRow.setAttribute("label", grupo.getTextoGrupo());
            elemRows.appendChild(elemRow);
            // 3.- Se rellenan la celdas de la matriz (por cada row) simples y repetitivas
            this.crearCeldas(docDestino, elemRow, grupo);
        }
        traza("Creando FILAS finalizado.");
        if (!esManteCrono)
            crearBotonCambiarFecha(docDestino, matrix);
        else {
            if (!esConsCrono)
                crearBotonesManteCrono(docDestino, matrix);
        }

        DruidaConector conectorCrono = new DruidaConector();
        conectorCrono.setXML(matrix);
        //traza("XML antes de transformar: " + conectorCrono.getXML());
        DruidaConector drdXSLTrans = transformar("GeneraMatrizCRA", conectorCrono);
        //traza("XML despues de transformar: " + drdXSLTrans.getXML());

        asignar("REJILLA", this.componenteGrafico, drdXSLTrans);
        asignarAtributo("CAPA", "capaTablaGrafica", "visibilidad", "visible");
        traza("Fin metodo muestraCronograma");
  }


  private void crearCeldas(Document doc, Element elemRow, DTOGrupoCronograma grupo) throws Exception {
      traza("Creando CELDAS para el grupo " + grupo.getTextoGrupo());
      /* 3.- Las celdas contenido de la tabla (las actividades) se rellenan así: */
      Vector actividades;
      DTOActividadGrupo actividad;

      /* a- Por cada grupo sacado en el paso 2b y cada día del periodo (desde la fecha indicada por 
       * tadCronograma.obtieneInicioPeriodo() hasta la fecha resultado al sumar la anterior en número 
       * recibido de tadCronograma.obtieneDiasCronograma()) se hace 
       * tadCronograma.obtieneActividadesGrupoDia(grupo.grupoZona,diaPeriodo) y devolverá todas las actividades 
       * de un día del periodo para un grupo de zonas en forma de DTOActividadGrupo[] */
      int cantDias = tadCronograma.obtieneDiasCronograma().intValue();
      Date iniPerio = tadCronograma.obtieneInicioPeriodo();
       
      for (int diaPeriodo = 0; diaPeriodo < cantDias; diaPeriodo++) {
          //obtenemos las actividades para un dia del periodo
          Calendar c = new GregorianCalendar();
          c.setTime(iniPerio);
          c.add(Calendar.DATE, diaPeriodo);
          
          actividades = tadCronograma.obtieneActividadesGrupoDia(grupo.getOid(), new Date(c.getTime().getTime()));
          //traza("OBTIENE ACTIVIDADES grupo: "+grupo.getOid()+"  dia: "+new Date(c.getTime().getTime())+" actividades: "+actividades);

          for (int i = 0; i < actividades.size(); i++) {
              // tomo la actividad
              actividad = (DTOActividadGrupo) actividades.elementAt(i);
              // vemos si es repetiva
             // if ( ! actividadRepetitiva(actividad) ) {
                  /* 
                  * b.- Se pone la actividad (cada uno de los elementos DTOActividadGrupo  
                  * obtenidos en a)(con el enlace <a referencia a 
                  * actividad.idVista>actividad.textoActividad</a>) en la celda correspondiente
                  * (es decir la identificada por la fila del grupo y la columna del día de periodo. 
                  */
                  this.crearCeldaSimple(doc, elemRow, actividad, diaPeriodo);

              //} else {
                  /* c.- Si la actividad tuviera los valores diasFinal y diasIntervalo 
                  * mayores que 0 y distintos de null se trata de actividades repetidas. 
                  * En este caso se pondrán tantas (con el enlace <a referencia a 
                  * actividad.idVista>actividad.textoActividad</a>) como se indique 
                  * en el resultado de la siguiente operación entera: 
                  * (actividad.diaPeriodo+actividad.diasFinal-1)/actividad.diasIntervalo 
                  * y se pondrán a partir del día actividad.diaPeriodo hasta actividad.diaPeriodo+diasFinal. 
                  */
                  //this.crearCeldasRepetitivasModoGrafico(doc, elemRow, actividad);
              //} //if
          } //actividades
      } //dias periodo
      traza("Creando CELDAS finalizado.");
  }

  private void crearCeldaSimple(Document doc, Element elemRow, DTOActividadGrupo actividad, int diaPeriodo) throws Exception {
      /* 
      * b.- Se pone la actividad (cada uno de los elementos DTOActividadGrupo  
      * obtenidos en a)(con el enlace <a referencia a 
      * actividad.idVista>actividad.textoActividad</a>) en la celda correspondiente
      * (es decir la identificada por la fila del grupo y la columna del día de periodo. 
      */

      //creamos la celda para la actividad
      Element cell = doc.createElement("CELL");
      traza("Celda para la actividad " + actividad.getActividad());
      //atributos de la celda
      //cell.setAttribute("col", (new Long((actividad.getDiaPeriodo().longValue() + 1))).toString());
      cell.setAttribute("col", (diaPeriodo + 1) + "");
      cell.setAttribute("label", actividad.getTextoActividad());
      if (actividad.getIndFija() != null && actividad.getIndFija().booleanValue()) {
          traza("Encontró fija");
          cell.setAttribute("color", "red");
      }
      if (!esConsCrono)
          cell.setAttribute("url", "javascript:seleccionaActividad('" + actividad.getIdVista() + "')");
      //agregamos la celda a la fila
      elemRow.appendChild(cell);
  }
  
  /** Crea el boton que va debajo de la lista **/
  private void crearBotonCambiarFecha(Document docDestino, Element matrix) {
      Element elemBotones = docDestino.createElement("BOTONES");
      matrix.appendChild(elemBotones);
      Element elemBotonCambiarFecha = docDestino.createElement("BOTON");
      elemBotonCambiarFecha.setAttribute("nombre", "btnCambiarFecha");
      elemBotonCambiarFecha.setAttribute("ID", "botonContenido");
      elemBotonCambiarFecha.setAttribute("tipo", "html");
      elemBotonCambiarFecha.setAttribute("accion", "cambiarFecha();");
      elemBotonCambiarFecha.setAttribute("estado", "false");
      elemBotonCambiarFecha.setAttribute("cod", "1978"); 
      elemBotonCambiarFecha.setAttribute("onclick", "cambiarFecha();");
      elemBotonCambiarFecha.setAttribute("ontab", "focoTabBtnCrono();");
      elemBotonCambiarFecha.setAttribute("onshtab", "focalizaBotonHTML('botonContenido','btnGenerar');");
      //elemBotonCambiarFecha.setAttribute("ancho", "100%");
      elemBotones.appendChild(elemBotonCambiarFecha);

  }


  /** Crea el boton que va debajo de la lista **/
  private void crearBotonesManteCrono(Document docDestino, Element matrix) {
      Element elemBotones = docDestino.createElement("BOTONES");
      matrix.appendChild(elemBotones);
      Element elemBotonCambiarFecha = docDestino.createElement("BOTON");
      elemBotonCambiarFecha.setAttribute("nombre", "btnEliminarActividad");
      elemBotonCambiarFecha.setAttribute("ID", "botonContenido");
      elemBotonCambiarFecha.setAttribute("tipo", "html");
      elemBotonCambiarFecha.setAttribute("accion", "eliminaActividad();");
      elemBotonCambiarFecha.setAttribute("estado", "false");
      elemBotonCambiarFecha.setAttribute("cod", "2410"); 
      elemBotonCambiarFecha.setAttribute("onclick", "eliminaActividad();");
      //elemBotonCambiarFecha.setAttribute("ontab", "focoTabBtnCrono();");
      elemBotonCambiarFecha.setAttribute("onshtab", "focalizaBotonHTML('botonContenido','btnBuscar');");
      elemBotones.appendChild(elemBotonCambiarFecha);

      elemBotonCambiarFecha = docDestino.createElement("BOTON");
      elemBotonCambiarFecha.setAttribute("nombre", "btnCambiarFecha");
      elemBotonCambiarFecha.setAttribute("ID", "botonContenido");
      elemBotonCambiarFecha.setAttribute("tipo", "html");
      elemBotonCambiarFecha.setAttribute("accion", "cambiarFecha();");
      elemBotonCambiarFecha.setAttribute("estado", "false");
      elemBotonCambiarFecha.setAttribute("cod", "1978"); 
      elemBotonCambiarFecha.setAttribute("onclick", "cambiarFecha();");
      elemBotones.appendChild(elemBotonCambiarFecha);

      elemBotonCambiarFecha = docDestino.createElement("BOTON");
      elemBotonCambiarFecha.setAttribute("nombre", "AnadirTablaGrafica");
      elemBotonCambiarFecha.setAttribute("ID", "botonContenido");
      elemBotonCambiarFecha.setAttribute("tipo", "html");
      elemBotonCambiarFecha.setAttribute("accion", "insertaActividad();");
      elemBotonCambiarFecha.setAttribute("estado", "false");
      elemBotonCambiarFecha.setAttribute("cod", "187"); 
      elemBotonCambiarFecha.setAttribute("onclick", "insertaActividad();");
      elemBotonCambiarFecha.setAttribute("ontab", "focoTabBtnCrono();");
      elemBotones.appendChild(elemBotonCambiarFecha);
  }

  /** Arma un string de la forma Lunes 3 mayo **/
  private String armarFechaEncabezado(Calendar c) throws Exception {
  
        traza("LPUtilidadesCronograma - armarFechaEncabezado - ENTRA");
  
      String diaSem = obtenerDiaSem(c.get(Calendar.DAY_OF_WEEK)-1);
      
      traza("--a--");
      
      String diaMes = c.get(Calendar.DAY_OF_MONTH) + "";

      traza("--b--");
      
      String mes = obtenerMes(c.get(Calendar.MONTH));

        traza("LPUtilidadesCronograma - armarFechaEncabezado - SALE");

      return diaSem + " " + diaMes + " " + mes;
  }

  /** Obtiene Lunes, Martes, ... **/
  private String obtenerDiaSem(int n) throws Exception {
      return (String) diasSemana.get(n);
  }

  /** Obtiene Enero, Febrero, ... **/
  private String obtenerMes(int n) throws Exception {
      return (String) meses.get(n);
  }


  /** Inicializa los vectores de meses y dias de la semana **/
  private void inicializarVectores() throws Exception {
      String hDias = conectorParametroLimpia( ocultoDiasSemana, "", true );
      String hMeses = conectorParametroLimpia( ocultoMeses, "", true );
      diasSemana = obtenerVectorDeOculto(hDias);
      meses = obtenerVectorDeOculto(hMeses);
  }

  /** Para obtener el vector de meses y dias de la semana **/
  private Vector obtenerVectorDeOculto(String oculto) throws Exception {
      Vector vRes = new Vector();

  		StringTokenizer stkOculto = new StringTokenizer(oculto,"|");

      while (stkOculto.hasMoreTokens()) {
          String sElem = (String) stkOculto.nextToken();
          vRes.add(sElem);
        
      }

      traza("El vector de ocultos es: "+vRes);
      return vRes;
  }


  /** 
  * Muestra la lista de actividades con referencia a otros periodos LISTA cuyo nombre viene 
  * indicado por el atributo listaFueraPeriodo.
  **/
  private void muestraListaFueraPeriodo() throws Exception {
	  traza("Obtiene grupos: "+tadCronograma.obtieneGrupos());
      Vector grupos = tadCronograma.obtieneGrupos(); 
      Vector oidGrupos = new Vector();
      for (int i = 0; i < grupos.size(); i++) {
          DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
          oidGrupos.add(dtoG.getOid());
      }
	  traza("despues for: "+oidGrupos);
	  Vector actividadesFuera = tadCronograma.obtieneActividadesFueraPeriodo(); 
      traza("Vector Fuera: "+actividadesFuera);
      if (actividadesFuera.size() > 0) {
          DruidaConector conector = generarConectorActividadesFueraPeriodo(actividadesFuera);
          traza("Fuera: "+conector.getXML());
          asignar( "LISTADOA", "listado2", conector,"fueraDePeriodo" );
          asignarAtributo("VAR", "hMostrarFuera", "valor", "1");
      }
  
  }


  /**
  * Genera el conector para presentar la actividades fuera de periodo.
  */
  private DruidaConector generarConectorActividadesFueraPeriodo(Vector vActsFuera) throws Exception {
        traza("Inicio generarConector");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "fueraDePeriodo");
        rowset2.appendChild(rowset);

        for (int i = 0; i < vActsFuera.size(); i++) {
            DTOActividadGrupo dtoA = (DTOActividadGrupo) vActsFuera.get(i);
            traza("Actividad en zona: "+dtoA.getTextoGrupo());
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "Ident");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(i+"");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "zona");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            //txt = docDestino.createTextNode(dtoA.getTextoGrupo());
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoGrupo()+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoGrupo()+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            String formato = UtilidadesSession.getFormatoFecha(this);
      			traza("FORMATO: "+formato);
            int pos = formato.indexOf("mm");
            if ( pos > 0) 
                formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String fecha = sdf.format(dtoA.getFechaPrevista());

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "fechaPrevista");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            //txt = docDestino.createTextNode(fecha);
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+fecha+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+fecha+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "fecha0");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            //txt = docDestino.createTextNode(dtoA.getFecha0() == null ?"":dtoA.getFecha0().toString());
            String sFecha0 = dtoA.getFecha0() == null ?"":dtoA.getFecha0().toString();
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+sFecha0+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+sFecha0+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "codigo");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            //txt = docDestino.createTextNode(dtoA.getCodigo());
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+dtoA.getCodigo()+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+dtoA.getCodigo()+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "textoActividad");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoActividad()+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoActividad()+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "origen");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            //txt = docDestino.createTextNode(dtoA.getActividadOrigen() != null ? lblReferencia : lblFija);
            String sFR = dtoA.getActividadOrigen() != null ? lblReferencia : lblFija;
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+sFR+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+sFR+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            //IdVista de la actividad
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "idVista");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            txt = docDestino.createTextNode(dtoA.getIdVista().intValue() + "");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

        }

        DruidaConector conectorCrono = new DruidaConector();
        conectorCrono.setXML(rowset2);

        return conectorCrono;
  }


  /** 
  * Muestra la lista de actividades fuera de periodo en el componente LISTA cuyo nombre viene 
  * indicado por el atributo listaReferenciaOtroPeriodo.  
  **/
  private void muestraListaReferenciaOtroPeriodo() throws Exception {
	  traza("obtieneGrupos(): " + tadCronograma.obtieneGrupos());
      Vector grupos = tadCronograma.obtieneGrupos(); 
      Vector oidGrupos = new Vector();
      for (int i = 0; i < grupos.size(); i++) {
          DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
          oidGrupos.add(dtoG.getOid());
      }
	  traza("oidGrupos: " + oidGrupos);
	  Vector actividadesRefOtroPeri = tadCronograma.obtieneActividadesReferenciaOtroPeriodo(); 
      traza("actividadesRefOtroPeri: " + actividadesRefOtroPeri);

/*	  if (tadCronograma.esZonas()) {
		  traza("RefeOtroPeri - Fase 2");
	      asignarAtributo("LISTAEDITABLE", "listado3", "cod", "1");	
	  }
*/
      if (actividadesRefOtroPeri.size() > 0) {
          DruidaConector conector = generarConectorReferenciaOtroPeriodo(actividadesRefOtroPeri);
          traza("RefeOtroPeri: " + conector.getXML());
          asignar( "LISTADOA", "listado3", conector, "refeOtroPeriodo" );
      }
  }


  /**
  * Genera el conector para presentar la actividades con referencia a otro periodo.
  */
  private DruidaConector generarConectorReferenciaOtroPeriodo(Vector vActsRefOtroPeri) throws Exception {
        traza("Inicio generarConectorReferenciaOtroPeriodo");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "refeOtroPeriodo");
        rowset2.appendChild(rowset);

        for (int i = 0; i < vActsRefOtroPeri.size(); i++) {
            DTOActividadGrupo dtoA = (DTOActividadGrupo) vActsRefOtroPeri.get(i);
            traza("ActividadEnZona: " + dtoA.getTextoGrupo());
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "Ident");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(i+"");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			// zona o grupo de zonas
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "zona");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoGrupo()+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoGrupo()+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			//fecha
            String formato = UtilidadesSession.getFormatoFecha(this);
      		traza("FORMATO: "+formato);
            int pos = formato.indexOf("mm");
            if (pos > 0) 
                formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String fecha = sdf.format(dtoA.getFechaPrevista());

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "fechaPrevista");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");

		    if (dtoA.getFechaPrevista()!=null) {
				if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
					txt = docDestino.createTextNode("|||"+fecha+"|actFija");
				} else {
					txt = docDestino.createTextNode("|||"+fecha+"|datosCampos");
				}
			} else {
				txt = docDestino.createTextNode("|||-|actFija");
			}
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			// codigo actividad
			elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "codigo");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+dtoA.getCodigo()+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+dtoA.getCodigo()+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			// nombre actividad
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "textoActividad");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoActividad()+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+dtoA.getTextoActividad()+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			// dias respecto actividad origen
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "fecha0");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            String sFecha0 = dtoA.getFecha0() == null ?"":dtoA.getFecha0().toString();
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+sFecha0+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+sFecha0+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			// periodo referencia
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "periodoReferencia");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            String periodoReferencia = dtoA.getNombrePeriodoReferencia() == null ?"":dtoA.getNombrePeriodoReferencia().toString();
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+periodoReferencia+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+periodoReferencia+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);
			
			// codigo actividad origen
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "codigoActividadOrigen");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            String codigoActividadOrigen = dtoA.getCodigoActividadOrigen() == null ?"":dtoA.getCodigoActividadOrigen().toString();
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+codigoActividadOrigen+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+codigoActividadOrigen+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

			// nombre actividad origen
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "nombreActividadOrigen");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            String nombreActividadOrigen = dtoA.getNombreActividadOrigen() == null ?"":dtoA.getNombreActividadOrigen().toString();
            if (dtoA.getIndFija() != null && dtoA.getIndFija().booleanValue()) {
                txt = docDestino.createTextNode("|||"+nombreActividadOrigen+"|actFija");
            } else {
                txt = docDestino.createTextNode("|||"+nombreActividadOrigen+"|datosCampos");
            }
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            //IdVista de la actividad
            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "idVista");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            txt = docDestino.createTextNode(dtoA.getIdVista().intValue() + "");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);
        }

        DruidaConector conectorCrono = new DruidaConector();
        conectorCrono.setXML(rowset2);

        return conectorCrono;
  }


   /** Ajusta parametros de la matriz. **/
    private void ajustarMatriz(Element matrix) {
         // Si el modoGrafico es Consulta
         if (!esManteCrono) {
             //matrix.setAttribute("xMatrix", "15");
             matrix.setAttribute("yMatrix", "20");
             matrix.setAttribute("anchoMatrix", "788");
             matrix.setAttribute("yBotones", "298");
         }
    }


	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException)
		{
			
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}


	/*
	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}
	*/

}
