/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */


import LPSICCBase;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Subm�dulo:         Mantenimiento Matriz de Dias en Modo Grafico y No Grafico
 * Componente:        Logica de Presentacion
 * Fecha:             17/05/2004
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del 
 *                    Modelo de Componentes SICC-DMCO-CRA-001-321
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
 

// Definicion de la clase
public class LPCreaMatrizDiasGrafica extends LPSICCBase {

    private static final String MODO_CREAR = "crear";
    private static final String TIPO_GRAFICA = "grafica";
    private String accion;


    // Definicion del constructor
    public LPCreaMatrizDiasGrafica() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_matriz_dias_grafico_insertar");
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
                asignarAtributo("VAR","accion","valor","creaGrafica");
                asignarAtributo("VAR","varModo","valor",MODO_CREAR);
                asignarAtributo("VAR","varTipo","valor",TIPO_GRAFICA);
                // Invoca a LPMantieneMatrizDias cambiando la accion = "creaGrafica"
                conectorAction("LPMantieneMatrizDias");
                conectorActionParametro("accion","creaGrafica");
                conectorActionParametro("hMarca",conectorParametro("hMarca"));
                conectorActionParametro("hCanal",conectorParametro("hCanal"));
                conectorActionParametro("varModo",conectorParametro("varModo"));
                conectorActionParametro("varTipo",conectorParametro("varTipo"));
            }
            
        } catch (Exception ex ) {
            this.lanzarPaginaError(ex);
        }
    }
      
}
