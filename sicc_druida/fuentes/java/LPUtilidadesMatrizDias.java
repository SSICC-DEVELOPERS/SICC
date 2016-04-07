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


import es.indra.sicc.cra.util.TADMatrizDias;
import es.indra.sicc.dtos.cra.DTOGrupoMatriz;
import es.indra.sicc.dtos.cra.DTOActividadMatriz;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;


/*import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;
import org.jdom.input.DOMBuilder;*/


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.dtos.cra.ConstantesCRA;

import es.indra.sicc.util.DTOOID;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.cra.DTOMatrizDias;
import es.indra.sicc.util.UtilidadesSession;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Mantenimiento Matriz de Dias en Modo Grafico y No Grafico
 * Componente:        Logica de Presentacion
 * Fecha:             17/05/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-CRA-001-321
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
 

// Definicion de la clase
public class LPUtilidadesMatrizDias extends LPSICCBase {

    protected static final String MODO_CREAR = "crear";
    protected static final String MODO_MODIFICAR = "modificar";
    protected static final String TIPO_GRAFICA = "grafica";
    protected static final String TIPO_NOGRAFICA = "nografica"; 
    protected static final String TIPO_CONSULTA = "consulta"; 
    protected String modoGrafico; // TIPO_GRAFICA, TIPO_NOGRAFICA, TIPO_CONSULTA 
    protected String modoCrerModificar; // MODO_CREAR, MODO_MODIFICAR
    protected String componenteGrafico; // Tiene el nombre de un componente de pantalla de tipo REJILLA.
    protected String componenteGraficoDos; // Tiene el nombre de un componente de pantalla de tipo REJILLA.
    protected String listaFueraPeriodo; // Tiene el nombre de un componente de pantalla de tipo LISTA.
    protected TADMatrizDias tadMatriz;


	/*
	private static XMLOutputter outputXML = new XMLOutputter();
	private static DOMBuilder JBuilder  = new DOMBuilder(); 
    
	{
		Format f = outputXML.getFormat().getCompactFormat();
		outputXML.setFormat(f);
	}
	*/

    // Definicion del constructor
    public LPUtilidadesMatrizDias() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
		//setTrazaFichero();
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        
    }


    /**
     * Añade n grupos a la matriz de días.
     * Verifica si cada grupo esta en la matriz de dias.
     * Dependiendo del tipo la fila tendrá un formato u otro.
     */
    protected void insertaGrupos(Vector grupos) throws Exception {
        // 1.- Por cada elemento de DTOGrupoMatriz vemos si esta, sino lo agregamos a la matriz
        for (int i=0; i < grupos.size(); i++ ) {
            DTOGrupoMatriz grupoZona = (DTOGrupoMatriz)grupos.elementAt(i);
            //verifica si esta el grupoZona en la matriz
            if (this.estaGrupo(grupoZona.getGrupoZona())) {
                traza("el grupo ya esta en la matriz");
                // vistaMatriz(tadMatriz)
                // this.vistaMatriz(); //la vista se recarga en otro momento 
                // se genera el error "El grupo de zonas X ya se encuentra en la matriz, por lo que no será añadido de nuevo."
                ExcepcionParametrizada exParam = new ExcepcionParametrizada(new MareException(), 180120001);
                exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                exParam.addParameter(grupoZona.getTextoGrupo());
                throw exParam;

            } else {
                traza("se inserta el grupo" + grupoZona.getGrupoZona() + " en la matriz");
                //agregamos el gruposZona a la matrizDias, llamando a tadMatrizDias.insertaGrupo(grupo[i])
                tadMatriz.insertaGrupo(grupoZona);
            }
        }
        // 2.- Se muestra la matriz de dias, vistaMatriz(tadMatriz)
        this.vistaMatriz();     //van a pedir que no se muestre el grupo si no hay activiades en él. 
    }


    /**
     * Añade todas las actividades (una padre más el flujo de referenciadas)
     * a un grupo de la matriz de días. 
     */ 
    protected void insertaActividades(DTOGrupoMatriz grupo) throws Exception {
        /* Nota: la actividad padre esta dentro de grupos.getActividades(). Incidencia 4669. */
        // Se crea la variable Boolean bPrimera inicializada a True, para indetificar al Padre. Incidencia 9724. 
        boolean bPrimera = true;
        // 1.a.- Por cada elemento de grupo.actividades (que llamamos actividad) se hace:
        Vector actividades = grupo.getActividades();
        traza("Numero de actividades a insertar: " + actividades.size() + ", para el grupo " + grupo.getGrupoZona());
        for(int i=0; i < actividades.size(); i++) {
            DTOActividadMatriz dtoActividadMatriz = (DTOActividadMatriz) actividades.elementAt(i);
            traza("dtoActividadMatriz a insertar: " + dtoActividadMatriz);
            // Verificamos si la actividad esta en la matriz para este grupo
            if (this.estaActividad(grupo.getGrupoZona(), dtoActividadMatriz.getActividad())) {
                // Se hace vistaMatriz(tadMatriz) y se genera el error de negocio:
                traza("La actividad " + dtoActividadMatriz.getActividad() + " ya se encuentra en el grupo " + grupo.getGrupoZona() );
                // Solo hay error si se quire insertar la actividad Padre y esta ya esta en la matriz.
                if (bPrimera) {
                    // se genera el errror: "La actividad X ya se encuentra en el grupo XX. Si desea modificarla o eliminarla utilice la opción correspondiente."
                    ExcepcionParametrizada exParam = new ExcepcionParametrizada(new MareException(), 180120002);
                    exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    exParam.addParameter(dtoActividadMatriz.getTextoActividad());
                    exParam.addParameter(tadMatriz.obtieneGrupoZona(grupo.getGrupoZona()).getTextoGrupo());
                    throw exParam;
                }
            } else {
                //se llama a tadMatriz.insertaActividad(actividad, grupo.grupoZona);
                tadMatriz.insertaActividad(dtoActividadMatriz,grupo.getGrupoZona());
                traza("Actividad " + dtoActividadMatriz.getActividad() + " insertada al grupo " + grupo.getGrupoZona() + " en la matriz.");
            }
            bPrimera = false;
        }

        // 1.b.- Se actualizan los dias de periodo para el grupoZona (Faltaba en Diseño)
        tadMatriz.actualizaDiasActividadGrupo(grupo.getGrupoZona());
        traza("MatrizDias insertaActividades, con diasPeriodo actualizados: " + tadMatriz.getMatrizDias());

        // 2.- vistaMatriz(tadMatriz)
        // Mejor muestro la matriz luego de insertar las actividades para todos los grupos 
        // this.vistaMatriz();   
    }


    /**
     * Muestra la vista de la matriz en modo gráfico en el componente REJILLA,
     * cuyo nombre viene indicado por el atributo componenteGrafico. 
     */
    protected void vistaGrafica() throws Exception {
        traza("metodo vistaGrafica");
        // MatrizDias
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element matrix = docDestino.createElement("MATRIX");
		((Node)docDestino).appendChild(matrix);
        matrix.setAttribute("cod", "0045");  //i18n titulo "Tabla gráfica"
        this.ajustarMatriz(matrix, false);
        
        /* 1.- Las cabeceras de las columnas se rellenan así:  */
        traza("Creando COLUMNAS.");
        Element elemColumns = docDestino.createElement("COLUMNS");
        // 1.a.- La primera con el texto "Grupo zona" 
        elemColumns.setAttribute("cod", "298");  //i18n "Grupo Zona"
        matrix.appendChild(elemColumns);
        // 1.b.- Las siguientes se rellenan desde uno hasta la cantidad de dias del periodo
        traza("Dias de la matriz: " + tadMatriz.obtieneDiasMatriz() );
        for (int col = 1; col <= tadMatriz.obtieneDiasMatriz().intValue(); col++)  {
            Element elemCol = docDestino.createElement("COL");
            elemCol.setAttribute("label", String.valueOf(col));
            elemColumns.appendChild(elemCol);
        }
        traza("Creando COLUMNAS finalizado.");

        /* 2.- El lateral izquierdo, ROWS, de la tabla se rellena así: */
        traza("Creando FILAS.");
		traza("LOLOLOLO");
        Element elemRows = docDestino.createElement("ROWS");
        matrix.appendChild(elemRows);
        // 2.a.- se llama a tadMatriz.obtieneGruposZona() y devuelve un vector de DTOGrupoMatriz.
        Vector vecGrupos = tadMatriz.obtieneGruposZona();
        // 2.b.- por cada objeto DTOGrupoMatriz del vector grupos se utilza el textoGrupo
        for (int i = 0; i < vecGrupos.size(); i++)  {
            DTOGrupoMatriz grupo = (DTOGrupoMatriz)vecGrupos.elementAt(i);
            //si hay actividades para el grupo            
            // fila grupoZona (la agrega por mas que no existan actividades en el grupo - Incidencia 9720)
            Element elemRow = docDestino.createElement("ROW");
            elemRow.setAttribute("label", grupo.getTextoGrupo());
            elemRows.appendChild(elemRow);
            /* 3.- Se rellenan la celdas de la matriz (por cada row) simples y repetitivas */
            this.crearCeldaModoGrafico(docDestino, elemRow, grupo);
        }
        traza("Creando FILAS finalizado.");
        // Agregamos los botones modificar y elimiar
        this.crearBotonesAsociados(docDestino, matrix);

        //Presentamos la matrix en la rejillaModoGrafico
        DruidaConector conectorMatriz = new DruidaConector();
		traza("Clase Conector: "+conectorMatriz.getClass().getName());
        conectorMatriz.setXML(matrix);
        //traza("XML antes de transformar: " + conectorMatriz.getXML());
		//traza("XML antes de transformar: "+outputXML.outputString(JBuilder.build(docDestino)));
        DruidaConector drdXSLTrans = transformar("GeneraMatrizCRA", conectorMatriz);
        //traza("XML despues de transformar: " + drdXSLTrans.getXML());
        asignar("REJILLA", this.componenteGrafico, drdXSLTrans);
        asignarAtributo("CAPA", "capaTablaGrafica", "visibilidad", "visible");
    }


    /*
     * Crea las celdas de la tabla en modo grafico, asigandole actividades.
     */
    private void crearCeldaModoGrafico(Document doc, Element elemRow, DTOGrupoMatriz grupo) throws Exception {
        traza("Creando CELDAS para el grupo " + grupo.getGrupoZona());
        /* 3.- Las celdas contenido de la tabla (las actividades) se rellenan así: */
        int diasMatriz;
        Vector actividades;
        DTOActividadMatriz actividad;

        /* a- Por cada grupo sacado en el paso 2b y cada día del periodo 
         * (desde el 0 a tadMatriz.obtieneDiasMatriz() - 1) 
         * se hace tadMatriz.obtieneActividadesDia(grupo.grupoZona,diaPeriodo) 
         * y devolverá todas las actividades de un día del periodo 
         * para un grupo de zonas en forma de DTOActividadMatriz[]
         * Nota: si diaPeriodo es 0 en negocio, diaPeriodo es la columna 1 en la matrizDias y asi siguiendo.
         */
        diasMatriz = tadMatriz.obtieneDiasMatriz().intValue();
        for (int diaPeriodo = 0; diaPeriodo <= (diasMatriz - 1); diaPeriodo++) {
            //obtenemos las actividades para un dia del periodo
            actividades = tadMatriz.obtieneActividadesDia(grupo.getGrupoZona(), new Long(diaPeriodo));

            for (int i = 0; i < actividades.size(); i++) {
                // tomo la actividad
                actividad = (DTOActividadMatriz)actividades.elementAt(i);
                // vemos si es repetiva
                if ( ! actividadRepetitiva(actividad) ) {
                    /* 
                    * b.- Se pone la actividad (cada uno de los elementos DTOActividadMatriz 
                    * obtenidos en a)(con el enlace <a referencia a 
                    * actividad.idVista>actividad.textoActividad</a>) en la celda correspondiente
                    * (es decir la identificada por la fila del grupo y la columna del día de periodo. 
                    */
                    this.crearCeldaSimpleModoGrafico(doc, elemRow, actividad);

                } else {
                    /* c.- Si la actividad tuviera los valores diasFinal y diasIntervalo 
                    * mayores que 0 y distintos de null se trata de actividades repetidas. 
                    * En este caso se pondrán tantas (con el enlace <a referencia a 
                    * actividad.idVista>actividad.textoActividad</a>) como se indique 
                    * en el resultado de la siguiente operación entera: 
                    * (actividad.diaPeriodo+actividad.diasFinal-1)/actividad.diasIntervalo 
                    * y se pondrán a partir del día actividad.diaPeriodo hasta actividad.diaPeriodo+diasFinal. 
                    */
                    this.crearCeldasRepetitivasModoGrafico(doc, elemRow, actividad, diasMatriz);
                } //if
            } //actividades
        } //dias periodo
        traza("Creando CELDAS finalizado.");
    }


    /*
     * Retorn true si la actividad es repetitiva.
     */
    private boolean actividadRepetitiva(DTOActividadMatriz actividad) throws Exception {
        boolean repetitiva;
        if ( (actividad.getDiasFinal() != null) && (actividad.getDiasIntervalo() != null) &&
                    (actividad.getDiasFinal().longValue() > 0) &&
                    (actividad.getDiasIntervalo().longValue() > 0) ) {
            repetitiva = true;
        } else {
            repetitiva = false;
        }
        return repetitiva;
    }


    /*
     * Crea una celda SIMPLE de la tabla en modo grafico, asigandole actividad.
     * Nota: El diaPeriodo 0 en el tadMatriz corresponde a la columna 1 en la vista matriz, y asi siguiendo.
     * */
    private void crearCeldaSimpleModoGrafico(Document doc, Element elemRow, DTOActividadMatriz actividad) throws Exception {
        /* 
        * b.- Se pone la actividad (cada uno de los elementos DTOActividadMatriz 
        * obtenidos en a)(con el enlace <a referencia a 
        * actividad.idVista>actividad.textoActividad</a>) en la celda correspondiente
        * (es decir la identificada por la fila del grupo y la columna del día de periodo. 
        */

        //creamos la celda para la actividad
        Element cell = doc.createElement("CELL");
        traza("Celda para la actividad " + actividad.getActividad() + " en el dia " + actividad.getDiaPeriodo());
        //atributos de la celda
        cell.setAttribute("col", (new Long((actividad.getDiaPeriodo().longValue() + 1))).toString());
        cell.setAttribute("label", actividad.getTextoActividad());
        cell.setAttribute("url", "javascript:seleccionaActividad('" + actividad.getIdVista() + "')");
        //agregamos la celda a la fila
        elemRow.appendChild(cell);
    }
    

    /*
     * Crea las celdas REPETITIVAS de la tabla en modo grafico, asigandole actividad.
     * Nota: El diaPeriodo 0 en el tadMatriz corresponde a la columna 1 en la vista matriz, y asi siguiendo.
     */
    private void crearCeldasRepetitivasModoGrafico(Document doc, Element elemRow, DTOActividadMatriz actividad, int diasMatriz) throws Exception {
        /* c.- Si la actividad tuviera los valores diasFinal y diasIntervalo 
        * mayores que 0 y distintos de null se trata de actividades repetidas. 
        * En este caso se pondrán tantas (con el enlace <a referencia a 
        * actividad.idVista>actividad.textoActividad</a>) como se indique 
        * en el resultado de la siguiente operación entera: 
        * (actividad.diaPeriodo+actividad.diasFinal-1)/actividad.diasIntervalo 
        * y se pondrán a partir del día actividad.diaPeriodo hasta actividad.diaPeriodo+diasFinal. 
        */

        //obtengo desde que lugar del periodo empezaran
        int desde = actividad.getDiaPeriodo().intValue();
        //obtengo hasta que lugar del periodo se repetiran
        int hasta = actividad.getDiaPeriodo().intValue() + actividad.getDiasFinal().intValue();
        if (hasta >= diasMatriz) hasta = diasMatriz - 1;   

        //obtengo el intervalo de repeticion
        int intervalo = actividad.getDiasIntervalo().intValue();
        traza("Actividad REPETITIVA desde " + desde + " hasta " + hasta + " con intervalo " + intervalo);
        //agregamos una CELDA por cada repeticion
        for ( int pos = desde; pos <= hasta; pos += intervalo) {
            traza("pos: " + pos);
            //creamos la celda para la actividad repetitiva
            Element cell = doc.createElement("CELL");
            traza("Celda para la actividad repetitiva " + actividad.getActividad() + " en el dia " + pos);
            //atributos de la celda
            cell.setAttribute("col",(new Integer(pos + 1)).toString());
            cell.setAttribute("label", actividad.getTextoActividad());
            cell.setAttribute("url", "javascript:seleccionaActividad('" + actividad.getIdVista() + "')");
            //agregamos la celda a la fila
            elemRow.appendChild(cell);
        }
    }


    /**
     * Muestra la lista de actividades fuera de periodo en el componente LISTA,
     * cuyo nombre viene indicado por el atributo listaFueraPeriodo. 
     */
    protected void cargaListaFueraPeriodo() throws Exception {
        /* Carga la lista de activdadesFueraPeriodo */
        traza("metodo cargaListaFueraPeriodo");

        /*
         * 1.a.- tadMatriz.obtieneActividadesFueraPeriodo(); 
         */
        Vector actividadesFueraPeriodo = tadMatriz.obtieneActividadesFueraPeriodo();
        traza("actividadesFueraPeriodo: " + actividadesFueraPeriodo);

        /* 
         * 1.b.- Agrega actividades repetitivas al vector de actividades fuera de periodo.
         * Si la actividad tuviera los valores diasFinal y diasIntervalo 
         * mayores que 0 y distintos de null se trata de actividades repetidas.
         * En este caso se pondrán tantas como se como sea posible a partir del finPeriodo+1
         * cada actividad.diasIntervalo dias y hasta actividad.diasFinal.
         */
        actividadesFueraPeriodo = this.agregarActividadesRepetitivasFueraPeriodo(actividadesFueraPeriodo);
        traza("actividadesFueraPeriodoConRepetitivas: " + actividadesFueraPeriodo);

        /*
         * 2.- La cabecera de la lista (primera línea del componente LISTA) queda con las siguientes columnas:
         * "| Grupos zonas | Nº días | Días respecto actividad origen | Cód. actividad | Nombre actividad | Días para fin | Días intervalo | Fija/Referenciada |" 
         */

        /*
         * 3.- Por cada elemento de activiadesFuera se añade una línea a la lista del siguiente modo: 
         */
        DruidaConector conectorActividadesFuera = this.generaConectorActividadesFueraPeriodo(actividadesFueraPeriodo, "dtoSalida.gruposzonas_ROWSET");

        /*
         * 4.- Asignmos la lista de actividades fuera de periodo
         */
        asignar("LISTA", this.listaFueraPeriodo, conectorActividadesFuera, "dtoSalida.gruposzonas_ROWSET"); 
        asignarAtributo("VAR", "hListaFueraPeriodoMostrar", "valor", "SI");
    }

    /**
     * Muestra la lista de actividades con referencia a otra campaña en el componente LISTA,
     * cuyo nombre viene indicado por el atributo listaFueraPeriodo. 
     */
    protected void cargaListaRefOtraCampana() throws Exception {
        /* Carga la lista de activdadesFueraPeriodo */
        traza("metodo cargaListaRefOtraCampana");

        /*
         * 1.a.- tadMatriz.obtieneActividadesFueraPeriodo(); 
         */
        Vector actividadesRefOtraCamp = tadMatriz.obtieneActividadesRefOtraCampana();
        traza("actividadesRefOtraCampana: " + actividadesRefOtraCamp);

        /*
         * 2.- La cabecera de la lista (primera línea del componente LISTA) queda con las siguientes columnas:
         * "|Grupos zonas |Cód. actividad |Nombre actividad |Tipo actividad |Campañas Desplazamiento |Nombre actividad origen |Días respecto actividad origen"  
         */

        /*
         * 3.- Por cada elemento de actividadesRefOtraCamp se añade una línea a la lista del siguiente modo: 
         */
        DruidaConector conectorActividadesRefOtraCamp = this.generaConectorActividadesRefOtraCamp(actividadesRefOtraCamp, "dtoSalida.gruposzonas_ROWSET");

        /*
         * 4.- Asignmos la lista de actividades fuera de periodo
         */
        asignar("LISTA", "lstOtraCampana", conectorActividadesRefOtraCamp, "dtoSalida.gruposzonas_ROWSET"); 
        asignarAtributo("VAR", "hListaFueraPeriodoMostrar", "valor", "SI");//Se mantiene la misma bandera que Fuera de Periodo por mismo comportamiento.
    }

  /**
	* Arma un conector en base a un Vector de DTOActividadMatriz.
	*/
    private DruidaConector generaConectorActividadesRefOtraCamp(Vector actividadesRefOtraCamp, String ID_Rows) throws Exception {
        /* 3.- Por cada elemento de activiadesFuera se añade una línea a la lista del siguiente modo: */
		/*|Grupos zonas |Cód. actividad |Nombre actividad |Tipo actividad |Campañas Desplazamiento |Nombre actividad origen |Días respecto actividad origen*/
        String campoIdVista = "campoIdVista";           //Columna 0 <- actividadesRefOtraCamp.getIdVista
        String campoTextoGrupo = "textoGrupo";          //Columna 1 <- actividadesRefOtraCamp.textoGrupo 
        String campoCodigo = "codigo";                  //Columna 2 <- actividadesRefOtraCamp.codigo 
        String campoTextoActividad = "textoActividad";  //Columna 3 <- actividadesRefOtraCamp.textoActividad 
        String campoTipoActividad = "tipoActividad";    //Columna 4 <- actividadesRefOtraCamp.tipoActividad
        String campoCampDespla = "campDespla";		    //Columna 5 <- actividadesRefOtraCamp.campDesplazamiento
        String campoTextoOrigen = "textoOrigen";        //Columna 6 <- actividadesRefOtraCamp.textoActOrigen
        String campoDia = "dia";                        //Columna 7 <- actividadesRefOtraCamp.dia   
        Long diasPeriodoMatriz;
        Long numeroDias;        
        
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

        for (int i = 0; i < actividadesRefOtraCamp.size(); i++)  {
            DTOActividadMatriz actividad = (DTOActividadMatriz)actividadesRefOtraCamp.elementAt(i);

            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoIdVista);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");
            Text txtIdVista = docDestino.createTextNode(actividad.getIdVista()==null?"":actividad.getIdVista().toString());
            e_campo1.appendChild(txtIdVista);
            e_row.appendChild(e_campo1);

            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoTextoGrupo);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");
            Text txtTextoGrupo = docDestino.createTextNode(actividad.getTextoGrupo()==null?"":actividad.getTextoGrupo().toString());
            e_campo2.appendChild(txtTextoGrupo);
            e_row.appendChild(e_campo2);

            Element e_campo3 = docDestino.createElement("CAMPO");
            e_campo3.setAttribute("NOMBRE", campoCodigo);
            e_campo3.setAttribute("TIPO", "OBJECTO");
            e_campo3.setAttribute("LONGITUD", "50");
            Text txtCodigo = docDestino.createTextNode(actividad.getCodigo()==null?"":actividad.getCodigo().toString());
            e_campo3.appendChild(txtCodigo);
            e_row.appendChild(e_campo3);

            Element e_campo4 = docDestino.createElement("CAMPO");
            e_campo4.setAttribute("NOMBRE", campoTextoActividad);
            e_campo4.setAttribute("TIPO", "OBJECTO");
            e_campo4.setAttribute("LONGITUD", "50");
            Text txtTextoActividad = docDestino.createTextNode(actividad.getTextoActividad()==null?"":actividad.getTextoActividad().toString());
            e_campo4.appendChild(txtTextoActividad);
            e_row.appendChild(e_campo4);

            Element e_campo5 = docDestino.createElement("CAMPO");
            e_campo5.setAttribute("NOMBRE", campoTipoActividad);
            e_campo5.setAttribute("TIPO", "OBJECTO");
            e_campo5.setAttribute("LONGITUD", "50");
            Text txtTipoActividad = docDestino.createTextNode(actividad.getTipoActividad()==null?"":actividad.getTipoActividad().toString());
            e_campo5.appendChild(txtTipoActividad);
            e_row.appendChild(e_campo5);

            Element e_campo6 = docDestino.createElement("CAMPO");
            e_campo6.setAttribute("NOMBRE", campoCampDespla);
            e_campo6.setAttribute("TIPO", "OBJECTO");
            e_campo6.setAttribute("LONGITUD", "50");
            Text txtCampDespla = docDestino.createTextNode(actividad.getCampDesplazamiento()==null?"":actividad.getCampDesplazamiento().toString());
            e_campo6.appendChild(txtCampDespla);
            e_row.appendChild(e_campo6);

            Element e_campo7 = docDestino.createElement("CAMPO");
            e_campo7.setAttribute("NOMBRE", campoTextoOrigen);
            e_campo7.setAttribute("TIPO", "OBJECTO");
            e_campo7.setAttribute("LONGITUD", "50");
            Text txtTextoOrigen = docDestino.createTextNode(actividad.getTextoActOrigen()==null?"":actividad.getTextoActOrigen().toString());
            e_campo7.appendChild(txtTextoOrigen);
            e_row.appendChild(e_campo7);

            Element e_campo8 = docDestino.createElement("CAMPO");
            e_campo8.setAttribute("NOMBRE", campoDia);
            e_campo8.setAttribute("TIPO", "OBJECTO");
            e_campo8.setAttribute("LONGITUD", "50");
            Text txtDia = docDestino.createTextNode(actividad.getDia()==null?"":actividad.getDia().toString());
            e_campo8.appendChild(txtDia);
            e_row.appendChild(e_campo8);
        }
        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());
        return conect;
    }

    /**
     * Muestra la vista de la matriz en modo no gráfico en el componente REJILLA,
     * cuyo nombre viene indicado por el atributo componenteGrafico en caso de que esDoble sea false,
     * o por el atributo componenteGraficoDos en caso de que esDoble sea true. 
     */
    protected void vistaNoGrafica(boolean esDoble) throws Exception {
        traza("metodo vistaNoGrafica");
        // MatrizDias
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element matrix = docDestino.createElement("MATRIX");
        matrix.setAttribute("cod", "0050");  //i18n titulo "Tabla no gráfica"
        this.ajustarMatriz(matrix, true);

        /* 1.- Las cabeceras de las columnas se rellenan así: */
        traza("Creando COLUMNAS.");
        Element elemColumns = docDestino.createElement("COLUMNS");
        // 1.a.- La primera con el texto "Grupo zona" 
        elemColumns.setAttribute("cod", "298");  //i18n "Grupo Zona"
        matrix.appendChild(elemColumns);
        // 1.b.- Se llama a tadMatriz.obtieneActividades() y con el atributo textoActividad se rellena cada una de las columnas. 
        Vector actividades = tadMatriz.obtieneActividades();
        for (int i = 0; i < actividades.size(); i++) {
            Element elemCol = docDestino.createElement("COL");
            DTOActividadMatriz actividad = (DTOActividadMatriz)actividades.get(i);
            elemCol.setAttribute("label", actividad.getTextoActividad());
            elemColumns.appendChild(elemCol);
        }
        traza("Creando COLUMNAS finalizado.");

        /* 2.- El lateral izquierdo, ROWS, de la tabla se rellena así: */
        traza("Creando FILAS.");
		traza("LALALALA");
        Element elemRows = docDestino.createElement("ROWS");
        matrix.appendChild(elemRows);
        // 2.a.- se llama a tadMatriz.obtieneGruposZona() y devuelve un vector de DTOGrupoMatriz.
        Vector vecGrupos = tadMatriz.obtieneGruposZona();
        // 2.b.- por cada objeto DTOGrupoMatriz del vector grupos se utilza el textoGrupo
        for (int i = 0; i < vecGrupos.size(); i++)  {
            DTOGrupoMatriz grupo = (DTOGrupoMatriz)vecGrupos.elementAt(i);
            // fila grupoZona (la agrega por mas que no existan actividades en el grupo - Incidencia 9720)
            Element elemRow = docDestino.createElement("ROW");
            elemRow.setAttribute("label", grupo.getTextoGrupo());
            elemRows.appendChild(elemRow);
            /* 3.- Se rellenan la celdas de la matriz (por cada row) */
            this.crearCeldaModoNoGrafico(docDestino, elemRow, grupo);
        }
        traza("Creando FILAS finalizado.");
        // Agregamos los botones modificar y elimiar
        this.crearBotonesAsociados(docDestino, matrix);

        //Presentamos la matrix en la rejillaModoGrafico
        DruidaConector conectorMatriz = new DruidaConector();
        conectorMatriz.setXML(matrix);
        //traza("XML antes de transformar: " + conectorMatriz.getXML());
        DruidaConector drdXSLTrans = transformar("GeneraMatrizCRA", conectorMatriz);
        //traza("XML despues de transformar: " + drdXSLTrans.getXML());
        asignar("REJILLA", this.componenteGraficoDos, drdXSLTrans);
        asignarAtributo("CAPA", "capaTablaNoGrafica", "visibilidad", "visible");
    }


    /*
     * Crea las celdas de la tabla en modo no grafico para un grupoZona, asigandole el dia.
     */
    private void crearCeldaModoNoGrafico(Document doc, Element elemRow, DTOGrupoMatriz grupo) throws Exception {
        traza("Creando CELDAS para el grupo " + grupo.getGrupoZona());
        /* 3.- Las celdas contenido de la tabla (las actividades) se rellenan así: */
        Vector actividadesColumna;
        DTOActividadMatriz actividadColumna, actividadReal;
        /* a.- Por cada grupo sacado en el paso 2b y actividad obtenida en el paso 1b 
         * (Se aconseja usar tadMatriz.obtieneActividad(oid grupo, oid actividad) : DTOActividadMatriz)
         * se va rellenando cada celda con el valor del atributo actividad.diaPeriodo + 1
         * y como enlace <a> la referencia actividad.idVista.
         */
        // obtengo las distintas actividades (para respetar el orden de las columnas)
        actividadesColumna = tadMatriz.obtieneActividades();
        // recorro las distintas activiades segun el orden de columnas
        for (int k = 0; k < actividadesColumna.size(); k++) {
            // tomo la actividad columna 
            actividadColumna =  (DTOActividadMatriz)actividadesColumna.get(k);
            // busca actividad real que pertenece al grupo segun oidActividad
            actividadReal = tadMatriz.obtieneActividad(grupo.getGrupoZona(), actividadColumna.getActividad());
			boolean otraCampana = false;
            // si la actividad pertenece al grupo 
            if (actividadReal != null) {
				if (actividadReal.getTipoActividad().equals("Ref. Otra Camp.")||(actividadReal.getOrigen()!=null&&tadMatriz.origenReferencia(actividadesColumna,actividadReal.getOrigen()))){
					//referencia a otra campaña va - en lugar de nro de dias
					otraCampana = true;   
				}
                //creamos la celda para la actividad
                Element cell = doc.createElement("CELL");
				Long diaPeriodo = new Long((actividadReal.getDiaPeriodo().longValue() + 1));
				traza("Celda para la actividad " + actividadReal.getTextoActividad() + " cuyo dia de periodo es " + diaPeriodo);
                //atributos de la celda
                cell.setAttribute("col", (new Integer(k + 1)).toString());
				if (otraCampana) {
	                cell.setAttribute("label", "-");
				} else {
	                cell.setAttribute("label", diaPeriodo.toString());
				}
                cell.setAttribute("url", "javascript:seleccionaActividad('" + actividadReal.getIdVista() + "')");
                //agregamos la celda a la fila
                elemRow.appendChild(cell);
            }
        }
        traza("Creando CELDAS finalizado.");
    }


    /**
     * Muestra la vista de la matriz según indique el atributo modoGrafico en el componente REJILLA,
     * cuyo nombre viene indicado por el atributo componenteGrafico. 
     * Nota: El texto indicado por el atributo componenteGrafico debe ser el nombre de un componente REJILLA de la pantalla.
     */
    protected void vistaMatriz() throws Exception {
        traza("metodo vistaMatriz");
        traza("modoGrafico: " + modoGrafico);

        // A) Si (modoGrafico == TIPO_GRAFICA) hace: 
        if (this.modoGrafico.equalsIgnoreCase(TIPO_GRAFICA)) {
            this.vistaGrafica();             
            this.cargaListaFueraPeriodo();
			this.cargaListaRefOtraCampana();
        }

        // B) Si (modoGrafico == TIPO_NOGRAFICA) hace: 
        if (this.modoGrafico.equalsIgnoreCase(TIPO_NOGRAFICA)) {
            this.vistaNoGrafica(false); 
        }

        // C) Si (modoGrafico == TIPO_CONSULTA) hace: 
        if (this.modoGrafico.equalsIgnoreCase(TIPO_CONSULTA)) {
            this.vistaGrafica();
            this.cargaListaFueraPeriodo();
			this.cargaListaRefOtraCampana();
            this.vistaNoGrafica(true);
        }
        /* 
         * Importante: El texto indicado por el atributo componenteGrafico 
         * debe ser el nombre de un componente REJILLA de la pantalla.
         */
    }


    /**
     * Elimina una actividad cuyo identificador de vista es el indicado
     * por el parámetro idVista de la matriz de días.
     */
    protected void eliminaActividad(Integer idVista) throws Exception {
        // 1.- Se llama a tadMatriz.eliminaActividad(idVista) 
        tadMatriz.eliminaActividad(idVista);
        // 2.- vistaMatriz(tadMatriz); 
        this.vistaMatriz();
    }


    /**
     * Muestra la pantalla de modificación de una actividad cuyo identificador de vista
     * es el indicado por el parámetro idVista de la matriz de días. 
     */
    protected void modificaActividad(Integer idVista) throws Exception {
    
        traza("LPUtilidadesMatrizDias - metodo modificaActividad - ENTRA");
        
        // 1.- Obtenemos la actividad del tadMatriz
        DTOActividadMatriz actividad = tadMatriz.obtieneActividad(idVista);        
        
        traza("DTOActividadMatriz: ");
        traza(actividad);
        
        // 2.- Obtenemos la actividades para el grupoZona
        RecordSet rsActividadesGrupo = tadMatriz.obtieneRecordSetActividadesGrupo(actividad.getGrupo()); 
        // 3.- Obtenemos el DTOGrupoMatriz
        DTOGrupoMatriz grupo = tadMatriz.obtieneGrupoZona(actividad.getGrupo()); 
        //* 4.- Se va a mostrar la pantalla PantallaModificarActividades cargada así: */
        // - lblGrupoZonas <- grupo.textoGrupo 
        asignarAtributo("LABELC","lblValorGrupoDeZonas","valor",grupo.getTextoGrupo());
        // - cbTipoActividad <- combo con dos valores posibles: {[0,"Fija"], [1,"con Actividad Origen"]} 
        // (cargado en la pagina)


		//enozigli 06/12/2007 brecha cra1
        String tipoActividad = (actividad.getTipoActividad() == null) ? "" : actividad.getTipoActividad();
        asignarAtributo("VAR", "hCmbTipoActividad", "valor", tipoActividad);
        String campDespl = (actividad.getCampDesplazamiento() == null) ? "" : actividad.getCampDesplazamiento().toString();
        asignarAtributo("CTEXTO", "txtCampDesp", "valor", campDespl); 

		if ("Ref. Otra Camp.".equals(tipoActividad)){
			DTOMatrizDias dtoMatriz = tadMatriz.getMatrizDias();
			// - Crea un DTOActividad
			DTOActividad dtoActividad = new DTOActividad();
			dtoActividad.setOidIdioma(UtilidadesSession.getIdioma(this));
			dtoActividad.setOidPais(dtoMatriz.getOidPais());
			dtoActividad.setOidMarca(dtoMatriz.getMarca());
			dtoActividad.setOidCanal(dtoMatriz.getCanal());

			// - Crea una lista ComposerViewElementList conConsultar 
			ComposerViewElementList cvLista = new ComposerViewElementList();
			// - Crea un elemento de tipo ComposerViewElement() para cargar los actividades
			ComposerViewElement cvActividades = new ComposerViewElement();
			cvActividades.setIDBusiness("CRAObtieneActividad");
			cvActividades.setDTOE(dtoActividad);
			cvLista.addViewElement(cvActividades);
			traza("carga inicial");
			ConectorComposerView conector = new ConectorComposerView(cvLista, this.getRequest());
			conector.ejecucion();
			DruidaConector conConsultar = conector.getConector();

			traza("asginacion combos");
			asignar("COMBO", "cbActividadDeOrigen", conConsultar, "CRAObtieneActividad");
		} else {
			// - cbActividadDeOrigen <- se rellena con la variable rsActividadesGrupo 
			// y se selecciona el indicado por actividad.origen, si este valor es null no se selecciona ninguno.
			// Los registros de resultado que tengan oid = actividad.actividad no serán mostrados
			omitirActividad(rsActividadesGrupo, actividad.getActividad());
			DruidaConector conectorActividades = this.generaConector(rsActividadesGrupo, "dtoSalida.gruposzonas_ROWSET", "oid", "descripcion");
			asignar("COMBO", "cbActividadDeOrigen", conectorActividades, "dtoSalida.gruposzonas_ROWSET"); 
		}
		//fin enozigli 06/12/2007 brecha cra1

        String origen = (actividad.getOrigen() == null) ? "" : actividad.getOrigen().toString();
        asignarAtributo("VAR", "hOrigen", "valor", origen);

        // - txtDiasDesplazamiento <- actividad.dia 
        String dia = (actividad.getDia() == null) ? "" : actividad.getDia().toString();
        asignarAtributo("CTEXTO", "txtDiasDeDesplazamiento", "valor", dia); 
        // - txtCadaDias <- actividad.diasIntervalo 
        String diaIntervalo = (actividad.getDiasIntervalo() == null) ? "" : actividad.getDiasIntervalo().toString();
        asignarAtributo("CTEXTO", "txtCadaCuantosDias", "valor", diaIntervalo); 
        // - txtDiasFin <- actividad.diasFinal 
        String diaFinal = (actividad.getDiasFinal() == null) ? "" : actividad.getDiasFinal().toString();
        asignarAtributo("CTEXTO", "txtFechaFinal", "valor", diaFinal); 
        
        traza("antes de asignar checkbox repetitiva");
        // - chkRepetitiva <- S si actividad.diasIntervalo y actividad.diasFinal son no nulos y mayores que cero.
        if ( (actividad.getDiasIntervalo() != null) && (actividad.getDiasFinal() != null) &&
                (actividad.getDiasIntervalo().longValue() > 0) && (actividad.getDiasFinal().longValue() > 0) ) {
                
            traza("entro a asignacion de checkbox repetitiva");
                
            asignarAtributo("CHECKBOX", "chkRepetitiva", "check", "S");
            
            traza("paso asignacion de checkbox repetitiva");
            
        }
        
        
        // - varActividad <- actividad.actividad 
        asignarAtributo("VAR", "hVarActividad", "valor", actividad.getActividad().toString());
        // - varGrupo <- actividad.grupo 
        asignarAtributo("VAR", "hVarGrupo", "valor", actividad.getGrupo().toString());
        //- rbMoverActividadesOrigen <- Aparece marcado "No"
        asignarAtributo("RADIOB", "rbMoverActividadesOrigen", "check", "S");
        //- hIdVistaActividad <- actividad.idVista
        asignarAtributo("VAR", "hIdVistaActividad", "valor", actividad.getIdVista().toString());
        // - hTextoActividad para lblActividad1 <- actividad.textoActividad
        asignarAtributo("VAR","hTextoActividad","valor",actividad.getTextoActividad());
        // - varClaseActividad <- actividad.clase 
        asignarAtributo("VAR","hVarClaseActividad","valor",actividad.getClase().toString());
        // - varCteActividadFacturacion <- ConstantesCRA.CLASE_ACTIVIDAD_FACTURACION 
        asignarAtributo("VAR","hVarCteActividadFacturacion","valor",ConstantesCRA.CLASE_ACTIVIDAD_FACTURACION.toString());
        
        //NUEVO!!!!!!!!!!!!!
        
        DTOOID dtoOID = null;
        RecordSet resultado = null;
        DTOSalida dtoSalida = null;
        Long oidSalida = null;
        BigDecimal bOidSalida = null;
        
        Vector params = null;
        DruidaConector con = null;
        
        Boolean bChkRepetitivaEnabled = Boolean.TRUE;
        Boolean bTxtCadaDia = Boolean.TRUE;
        

		traza("**************************************");
        if (actividad != null && actividad.getClase() != null
                && actividad.getClase().equals(ConstantesCRA.CLASE_ACTIVIDAD_FACTURACION)){
			traza("LA ACTIVIDAD ES DE FACTURACION");
		} else {
			traza("LA ACTIVIDAD NO ES DE FACTURACION");
		}
		traza("**************************************");


        if (actividad != null && actividad.getClase() != null
                && actividad.getClase().equals(ConstantesCRA.CLASE_ACTIVIDAD_FACTURACION)){

            //TODO
            //Deshabilita el check chkRepetitiva de la página 
            //PantallaModificarActividades.
            bChkRepetitivaEnabled = Boolean.FALSE;
            
            MareBusinessID id = new MareBusinessID("CRAObtenerTipoFacturacion");
            
            dtoOID = new DTOOID();
            dtoOID.setOid(actividad.getGrupo());
            
            params = new Vector();
            params.add(dtoOID);
            params.add(id);
            
            con = this.conectar("ConectorObtenerTipoFacturacion", params);
            dtoSalida = (DTOSalida)con.objeto("dtoSalida");
            
            if (dtoSalida != null){
                resultado = dtoSalida.getResultado();
                
                if (resultado != null && !resultado.esVacio()){
                    bOidSalida = (BigDecimal)resultado.getValueAt(0, 0);
                
                    if (bOidSalida != null){
                        oidSalida = new Long(bOidSalida.toString());
                    }
                }
            }

            if (oidSalida != null){
                if (oidSalida.equals(ConstantesCRA.TIPO_FAC_MONO)){
                    //TODO
                    //Desactiva el check chkRepetitiva de la página PantallaModificarActividades 
                    bChkRepetitivaEnabled = Boolean.FALSE;
                } else {
                    //TODO
                    //Activa el check chkRepetitiva de la página PantallaModificarActividades                 
                    bChkRepetitivaEnabled = Boolean.TRUE;

                    if (oidSalida.equals(ConstantesCRA.TIPO_FAC_MULTI)){
                        //TODO
                        //Deshabilita el campo txtCadaDias de la página 
                        //PantallaModificarActividades 
                        bTxtCadaDia = Boolean.FALSE;
                        
						bChkRepetitivaEnabled = Boolean.FALSE;
                        //Muestra el valor ConstantesCRA.DIARIO en el campo txtCadaDias 
                        //de la página PantallaModificarActividades 
                        //txtCadaCuantosDias
                        this.asignarAtributo("CTEXTO", "txtCadaCuantosDias", "valor", 
                            ConstantesCRA.DIARIO.toString());

						this.asignarAtributo("CHECKBOX", "chkRepetitiva", "check", "S");

                    } else {
                        if (oidSalida.equals(ConstantesCRA.TIPO_FAC_SEMA)){
                            //TODO
                            //Muestra el valor ConstantesCRA.SEMANAL en el campo 
                            //txtCadaDias de la página PantallaModificarActividades
                            this.asignarAtributo("CTEXTO", "txtCadaCuantosDias", 
                                "valor", ConstantesCRA.SEMANAL.toString());

							bChkRepetitivaEnabled = Boolean.FALSE;

							this.asignarAtributo("CHECKBOX", "chkRepetitiva", "check", "S");

							bTxtCadaDia = Boolean.TRUE;

                        }
                    }
                }
            }
        }
        

		


        //Se asignan flags de estado de campo a la pagina
        if (bChkRepetitivaEnabled != null && bChkRepetitivaEnabled.booleanValue()){
            this.asignarAtributo("VAR", "hEstadoChkRepetitivaEnabled", "valor", "S");
        } else {
            this.asignarAtributo("VAR", "hEstadoChkRepetitivaEnabled", "valor", "N");
        }
        
        if (bTxtCadaDia != null && bTxtCadaDia.booleanValue()){
            this.asignarAtributo("VAR", "hEstadoTxtCadaDia", "valor", "S");
        } else {
            this.asignarAtributo("VAR", "hEstadoTxtCadaDia", "valor", "N");
        }
        
        traza("LPUtilidadesMatrizDias - metodo modificaActividad - SALE");
        
    }


    /**
     * Modifica una actividad de la matriz de días con los datos
     * que existen en el parámetro "actividad". 
     */
    protected void guardaModificacion(DTOActividadMatriz actividad) throws Exception {
        // 1.- Se llama a tadMatriz.modificaActividad(actividad);
        tadMatriz.modificaActividad(actividad);       
        // 2.- vistaMatriz(tadMatriz);
        //this.vistaMatriz();
        //Como trabaja sobre una ventama modal, luego se muestra la matriz
    }


    /**
     * Devuelve true si la actividad está en el grupo especificado
     * dentro de la matriz de días de la pantalla. 
     */
    protected boolean estaActividad(Long grupo, Long actividad) {
        // 1.- Se llama a tadMatriz.obtieneActividad(grupo,actividad). 
        DTOActividadMatriz dtoActividadMatriz = tadMatriz.obtieneActividad(grupo, actividad);
        // 2.- Si devuelve null devuelve false y en caso contrario true.
        if (dtoActividadMatriz == null) return false;            
        else return true;
    }


    /**
     * Devuelve true si el grupo especificado está dentro de la matriz de días de la pantalla. 
     */
    protected boolean estaGrupo(Long grupo) {
        // 1.- Se llama a tadMatriz.obtieneGrupoZona(grupo). 
        DTOGrupoMatriz dtoGrupoMatriz = tadMatriz.obtieneGrupoZona(grupo);
        // 2.- Si devuelve null entonces retorna false y en caso contrario true.    
        if (dtoGrupoMatriz == null) return false;
        else return true;
    }


    /**
     * Los registros de resultado que tengan oid = actividad.actividad se eliminan del recorSet
     */
    private void omitirActividad(RecordSet rsActividadesGrupo, Long oidActividad) throws Exception {
        traza("metodo omitirActividad");
        boolean encontre = false;
        traza("oidActividad " + oidActividad);
        // recorremos las actividades y eliminamos la actividad donde coincidan los oid
        int numFilas = rsActividadesGrupo.getRowCount();
        for (int i = 0; i < numFilas && (!encontre); i++) {
            // tomamos el oidActividad del recordSet
            Long oid = (Long) rsActividadesGrupo.getValueAt(i,"oid");
            traza("oid " + oid);
            // si concide la elimina del recorSet
            if (oidActividad.equals(oid)) {
                rsActividadesGrupo.removeRow(i);
                encontre = true;
                traza("actvidad omitida");
            }
        }
    }


    /**
     * Ajusta parametros de la matriz de dias.
     * Si estamos en modoGrafico TIPO_CONSULTA se ajustan, sino se toman los valores por defecto.
     */
    private void ajustarMatriz(Element matrix, boolean ajustaScroll) {
        // Si el modoGrafico es Consulta
        if ( modoGrafico.equals(TIPO_CONSULTA)) {
            // Se ajusta la posicion x, la posicion y, el ancho, el nombre del scrool y los botones.
            matrix.setAttribute("xMatrix", "13");
            matrix.setAttribute("yMatrix", "20");
            matrix.setAttribute("anchoMatrix", "790");
            matrix.setAttribute("yBotones", "318");
            if (ajustaScroll) {
                matrix.setAttribute("nombreScroll", "miscrolldos");
            }
        }
    }


    /**
     * Crea los botones modificar y eliminar asociados a la MatrizDias.
     */
    private void crearBotonesAsociados(Document docDestino, Element matrix) {
        Element elemBotones = docDestino.createElement("BOTONES");
        matrix.appendChild(elemBotones);
        // si estamos en el CU Consultar No se agregan ningun boton
        if ( ! modoGrafico.equals(TIPO_CONSULTA)) {
            Element elemBotonModificar = docDestino.createElement("BOTON");
            elemBotonModificar.setAttribute("nombre", "btnModificar1");
            elemBotonModificar.setAttribute("ID", "botonContenido");
            elemBotonModificar.setAttribute("tipo", "html");
            elemBotonModificar.setAttribute("accion", "onClickModificar();");
            elemBotonModificar.setAttribute("estado", "false");
            elemBotonModificar.setAttribute("cod", "2");       //i18n boton modificar
            elemBotonModificar.setAttribute("onclick", "onClickModificar();");
            elemBotones.appendChild(elemBotonModificar);
            Element elemBotonEliminar = docDestino.createElement("BOTON");
            elemBotonEliminar.setAttribute("nombre", "btnEliminar1");
            elemBotonEliminar.setAttribute("ID", "botonContenido");
            elemBotonEliminar.setAttribute("tipo", "html");
            elemBotonEliminar.setAttribute("accion", "onClickEliminar();");
            elemBotonEliminar.setAttribute("estado", "false");
            elemBotonEliminar.setAttribute("cod", "1254");       //i18n boton eliminar
            elemBotonEliminar.setAttribute("onclick", "onClickEliminar();");
            elemBotones.appendChild(elemBotonEliminar);
        }
    }


    /**
     * Arma un conector en base a un recordSet y los nombres de los campos
     * pasados como parámetro. En esta caso solo se aplica la petición de dos campos.
     */
    protected DruidaConector generaConector(RecordSet rs, String ID_Rows,
                        String campoCod, String campoNom) throws Exception {

        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

        for (int i = 0; i < rs.getRowCount(); i++)  {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoCod);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");
            Text txtCod = docDestino.createTextNode((rs.getValueAt(i, campoCod)==null?"":rs.getValueAt(i, campoCod).toString()));
            e_campo1.appendChild(txtCod);
            e_row.appendChild(e_campo1);

            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoNom);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");
            Text txtDesc = docDestino.createTextNode((rs.getValueAt(i, campoNom)==null?"":rs.getValueAt(i, campoNom).toString()));
            e_campo2.appendChild(txtDesc);
            e_row.appendChild(e_campo2);
        }

        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());
        return conect;
    }


    /**
     * Arma un conector en base a un Vector de DTOActividadMatriz
     * y los nombres de los campos pasados como parámetro.
     */
    private DruidaConector generaConectorActividadesFueraPeriodo(Vector actividadesFuera, String ID_Rows) throws Exception {
        /* 3.- Por cada elemento de activiadesFuera se añade una línea a la lista del siguiente modo: */
        String campoIdVista = "campoIdVista";           //Columna 0 <- actividadFuera.getIdVista
        String campoTextoGrupo = "textoGrupo";          //Columna 1 <- actividadFuera.textoGrupo 
        String campoDiaPeriodo = "diaPeriodo";          //Columna 2 <- actividadFuera.diaPeriodo 
        String campoDia = "dia";                        //Columna 3 <- actividadFuera.dia   
        String campoCodigo = "codigo";                  //Columna 4 <- actividadFuera.codigo 
        String campoTextoActividad = "textoActividad";  //Columna 5 <- actividadFuera.textoActividad 
        String campoDiasFin = "diasFin";                //Columna 6 <- actividadFuera.diasFin 
        String campoDiasIntervalo = "diasIntervalo";    //Columna 7 <- actividadFuera.diasIntervalo 
        String campoOrigen = "origen";                  //Columna 8 <- Si (actividadFuera.origen != null) pone "R" sino pone "F" 
        String referenciada = "R";
        String fija = "F";
        Long diasPeriodoMatriz;
        Long numeroDias;        
        
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

        for (int i = 0; i < actividadesFuera.size(); i++)  {
            DTOActividadMatriz actividad = (DTOActividadMatriz)actividadesFuera.elementAt(i);

            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoIdVista);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");
            Text txtIdVista = docDestino.createTextNode(actividad.getIdVista()==null?"":actividad.getIdVista().toString());
            e_campo1.appendChild(txtIdVista);
            e_row.appendChild(e_campo1);

            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoTextoGrupo);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");
            Text txtTextoGrupo = docDestino.createTextNode(actividad.getTextoGrupo()==null?"":actividad.getTextoGrupo().toString());
            e_campo2.appendChild(txtTextoGrupo);
            e_row.appendChild(e_campo2);

            Element e_campo3 = docDestino.createElement("CAMPO");
            e_campo3.setAttribute("NOMBRE", campoDiaPeriodo);
            e_campo3.setAttribute("TIPO", "OBJECTO");
            e_campo3.setAttribute("LONGITUD", "50");
            // Si el atributo diasPeriodo es mayor que o igual a diasPeriodoMAtriz, se le resta el diasPeriodoMAtriz 
            // de forma que este valor contenga el número de días en referencia al fin de periodo. Incidencia 6665.
            diasPeriodoMatriz = tadMatriz.getMatrizDias().getDias();
            if (actividad.getDiaPeriodo().longValue() >= diasPeriodoMatriz.longValue()) {
                numeroDias = new Long(actividad.getDiaPeriodo().longValue() - (diasPeriodoMatriz.longValue()-1));
            } else {
                numeroDias = actividad.getDiaPeriodo();
            }
            Text txtDiaPeriodo = docDestino.createTextNode(numeroDias==null?"":numeroDias.toString());
            e_campo3.appendChild(txtDiaPeriodo);
            e_row.appendChild(e_campo3);

            Element e_campo4 = docDestino.createElement("CAMPO");
            e_campo4.setAttribute("NOMBRE", campoDia);
            e_campo4.setAttribute("TIPO", "OBJECTO");
            e_campo4.setAttribute("LONGITUD", "50");
            Text txtDia = docDestino.createTextNode(actividad.getDia()==null?"":actividad.getDia().toString());
            e_campo4.appendChild(txtDia);
            e_row.appendChild(e_campo4);

            Element e_campo5 = docDestino.createElement("CAMPO");
            e_campo5.setAttribute("NOMBRE", campoCodigo);
            e_campo5.setAttribute("TIPO", "OBJECTO");
            e_campo5.setAttribute("LONGITUD", "50");
            Text txtCodigo = docDestino.createTextNode(actividad.getCodigo()==null?"":actividad.getCodigo().toString());
            e_campo5.appendChild(txtCodigo);
            e_row.appendChild(e_campo5);

            Element e_campo6 = docDestino.createElement("CAMPO");
            e_campo6.setAttribute("NOMBRE", campoTextoActividad);
            e_campo6.setAttribute("TIPO", "OBJECTO");
            e_campo6.setAttribute("LONGITUD", "50");
            Text txtTextoActividad = docDestino.createTextNode(actividad.getTextoActividad()==null?"":actividad.getTextoActividad().toString());
            e_campo6.appendChild(txtTextoActividad);
            e_row.appendChild(e_campo6);

            Element e_campo7 = docDestino.createElement("CAMPO");
            e_campo7.setAttribute("NOMBRE", campoDiasFin);
            e_campo7.setAttribute("TIPO", "OBJECTO");
            e_campo7.setAttribute("LONGITUD", "50");
            Text txtDiasFinal = docDestino.createTextNode(actividad.getDiasFinal()==null?"":actividad.getDiasFinal().toString());
            e_campo7.appendChild(txtDiasFinal);
            e_row.appendChild(e_campo7);

            Element e_campo8 = docDestino.createElement("CAMPO");
            e_campo8.setAttribute("NOMBRE", campoDiasIntervalo);
            e_campo8.setAttribute("TIPO", "OBJECTO");
            e_campo8.setAttribute("LONGITUD", "50");
            Text txtDiasIntervalo = docDestino.createTextNode(actividad.getDiasIntervalo()==null?"":actividad.getDiasIntervalo().toString());
            e_campo8.appendChild(txtDiasIntervalo);
            e_row.appendChild(e_campo8);

            Element e_campo9 = docDestino.createElement("CAMPO");
            e_campo9.setAttribute("NOMBRE", campoOrigen);
            e_campo9.setAttribute("TIPO", "OBJECTO");
            e_campo9.setAttribute("LONGITUD", "50");
            Text txtOrigen = docDestino.createTextNode(actividad.getOrigen() != null ? referenciada : fija );
            e_campo9.appendChild(txtOrigen);
            e_row.appendChild(e_campo9);
        }

        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());
        return conect;
    }


    /**
     * Agrega actividades repetitivas al vector de actividades fuera de periodo.
     * Se realiza para todas las actividades de cada grupo zona de la matriz de dias.
     */
    private Vector agregarActividadesRepetitivasFueraPeriodo(Vector actividadesFueraPeriodo) throws Exception {
        /*
         * Si la actividad tuviera los valores diasFinal y diasIntervalo 
         * mayores que 0 y distintos de null se trata de actividades repetidas.
         * En este caso se pondrán tantas como se como sea posible a partir del finPeriodo+1
         * cada actividad.diasIntervalo dias y hasta actividad.diasFinal.
         */
        Vector grupos, actividades;
        DTOGrupoMatriz grupoZona;
        DTOActividadMatriz actividad;

        // Por cada grupo zona de la matriz de dias 
        grupos = tadMatriz.obtieneGruposZona();
        for (int z = 0; z < grupos.size(); z++) {
            grupoZona = (DTOGrupoMatriz)grupos.elementAt(z);
            //obtenemos las actividades para un grupo zona
            actividades = tadMatriz.obtieneActividadesGrupo(grupoZona.getGrupoZona());
            // Por cada actividad del grupo zona
            for (int a = 0; a < actividades.size(); a++) {
                // tomo la actividad
                actividad = (DTOActividadMatriz)actividades.elementAt(a);
                // si es repetiva
                if ( actividadRepetitiva(actividad) ) {
                    //obtengo desde el lugar de inicio del espacio fuera de periodo
                    int desde = tadMatriz.obtieneDiasMatriz().intValue() + 1;
                    //obtengo hasta que lugar del espacio fuera de periodo se repetiran
                    int hasta = actividad.getDiaPeriodo().intValue() + actividad.getDiasFinal().intValue();
                    //obtengo el intervalo de repeticion
                    int intervalo = actividad.getDiasIntervalo().intValue();
                    traza("Actividad REPETITIVA FUERA PERIODO desde " + desde + " hasta " + hasta + " con intervalo " + intervalo);
                    //agregamos una copia de la actividad, por cada repeticion, al vector de actividades fuera de periodo.
                    for ( int pos = desde; pos <= hasta; pos += intervalo) {
                        Long diaRepite = new Long(pos);
                        traza("Para el grupo " + actividad.getGrupo() + " la actividad repetitiva " + actividad.getActividad() + " en el dia " + pos);
                        /* creamos una copia de la actividad modificandola par mostrar su instante de repeticion. */
                        DTOActividadMatriz actividadRepeticion = new DTOActividadMatriz();        
                        actividadRepeticion.setActividad(actividad.getActividad());
                        actividadRepeticion.setClase(actividad.getClase());
                        actividadRepeticion.setCodigo(actividad.getCodigo());
                        actividadRepeticion.setDiasFinal(actividad.getDiasFinal());
                        actividadRepeticion.setDiasIntervalo(actividad.getDiasIntervalo());
                        actividadRepeticion.setEsMover(actividad.getEsMover());
                        actividadRepeticion.setGrupo(actividad.getGrupo());
                        actividadRepeticion.setIdVista(actividad.getIdVista());
                        actividadRepeticion.setOid(actividad.getOid());
                        actividadRepeticion.setOrigen(actividad.getOrigen());
                        actividadRepeticion.setTextoActividad(actividad.getTextoActividad());
                        actividadRepeticion.setTextoGrupo(actividad.getTextoGrupo());
                        // dia en el periodo en el cual se repite la actividad, 
                        // luego se muestra relativo al inicion fin del periodo.
                        actividadRepeticion.setDiaPeriodo(diaRepite);
                        // dia respecto a la actividad de origen, lo mantego por no haber referencia en diseño.
                        actividadRepeticion.setDia(actividad.getDia());    
                        //agregamos la copia de la actividad
                        actividadesFueraPeriodo.add(actividadRepeticion);
                    }//repeticiones
                }//if repetitiva
            }//actividades
        }//grupos
        return actividadesFueraPeriodo;
    }
    
}
