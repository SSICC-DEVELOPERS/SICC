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


import LPSICCBase;


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
public class LPConsultaMatrizDias extends LPSICCBase {

    private String accion;
    private static final String TIPO_CONSULTA = "consulta";


    // Definicion del constructor
    public LPConsultaMatrizDias() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_matriz_dias_grafico_consultar");
    }


    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        this.setTrazaFichero();

        accion = conectorParametro("accion");
        if (accion==null) accion = "";
        traza("accion: " + accion);

        try {
            rastreo();
            if (accion.equals("")) {
                asignarAtributo("VAR","accion","valor","consulta");
                asignarAtributo("VAR","varTipo","valor",TIPO_CONSULTA);
                // Invoca a LPMantieneMatrizDias cambiando la accion = "consulta" 
                conectorAction("LPMantieneMatrizDias");
                conectorActionParametro("accion","consulta");
                conectorActionParametro("hMarca",conectorParametro("hMarca"));
                conectorActionParametro("hCanal",conectorParametro("hCanal"));
                conectorActionParametro("varTipo",conectorParametro("varTipo"));
            }
            
        } catch (Exception ex ) {
            this.lanzarPaginaError(ex);
        }
    }
      
}
