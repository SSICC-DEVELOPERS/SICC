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
package es.indra.sicc.logicanegocio.fac.generaciondocumentos;


//import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;


public class FactoriaSerializador {
    private static FactoriaSerializador factoriaSerializador;
    private ArrayList listaSerializadores; //tiene 

    private FactoriaSerializador() {
        UtilidadesLog.info("FactoriaSerializador.FactoriaSerializador(): Entrada"); 
        listaSerializadores = new ArrayList();
        UtilidadesLog.info("FactoriaSerializador.FactoriaSerializador(): Salida"); 
    }

    public SerializadorMensajes getSerializador(DTOOID dtoE) {
        UtilidadesLog.info("FactoriaSerializador.getSerializador(DTOOID dtoE): Entrada"); 

        /* 1.- Analizamos el atributo listaSerializador:

        SerializadorMensaje miSerializador

        -Deberemos comprobar si dentro de ese ArrayList existe algun objeto SerializadorMensaje q
        ue tenga en su argumento patronAsociado un oidPatron igual== DTOE.oid
        -si existe lo devolvemos
        -si no existe creamos un objeto SerializadorMensaje nuevo invocando a su constructor SerializadorMensajes(DTOE),lo añadimos a la listaSerializador y lo devolvemos (el nuevo SerializadorMensaje).
        */
        
        /*
         * Se omite este segmento de codigo momentaneamente, a raiz de la incidencia 20233
         * hasta que se re-implemente una nueva solucion para el problema que se planteaba
         * pperez 08/09/2005
        for (int i = 0; i < this.listaSerializadores.size(); i++) {
            if (  this.listaSerializadores.get(i)!=null
                && ((SerializadorMensajes)this.listaSerializadores.get(i)).getPatronAsociado() !=null
                && ((SerializadorMensajes)this.listaSerializadores.get(i)).getPatronAsociado().getOidPatron() !=null){
                if (((SerializadorMensajes) this.listaSerializadores.get(i)).getPatronAsociado()
                         .getOidPatron().equals(dtoE.getOid())) {
                    return ((SerializadorMensajes) this.listaSerializadores.get(i));
                }
            }
        }
        */


        UtilidadesLog.info("FactoriaSerializador.getSerializador(DTOOID dtoE): Salida"); 

        SerializadorMensajes serializadorMensajes = new SerializadorMensajes(dtoE);
        this.listaSerializadores.add(serializadorMensajes);

        return serializadorMensajes;
    }

    public static synchronized FactoriaSerializador getFactoriaSerializador() {
        /*1.- Si el atributo FactoriaASerializador == null entonces
                -Llamamos al constructor privado FactoriaSerializadro() y se lo asiganamos al atributo FactoriaSerializador
                2.- Devolvemos el atributo FactoriaSerializador. */
        UtilidadesLog.info("FactoriaSerializador.getFactoriaSerializador(): Entrada"); 
        if (factoriaSerializador == null) {
            factoriaSerializador = new FactoriaSerializador();
        }

        UtilidadesLog.info("FactoriaSerializador.getFactoriaSerializador(): Salida"); 

        return factoriaSerializador;
    }

    public void inicializarListaSerializador() {
        //llamar al método clear() del atributo listaSerializadores
        UtilidadesLog.info("FactoriaSerializador.inicializarListaSerializador(): Entrada"); 
        listaSerializadores.clear();
        UtilidadesLog.info("FactoriaSerializador.inicializarListaSerializador(): Salida"); 
    }
}
