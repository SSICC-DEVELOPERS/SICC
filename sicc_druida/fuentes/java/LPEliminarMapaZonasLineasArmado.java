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
public class LPEliminarMapaZonasLineasArmado extends LPSICCBase{

     public LPEliminarMapaZonasLineasArmado(){
              super();
     }

     public void inicio() throws Exception {
     }

     public void ejecucion() throws Exception{

        this.setTrazaFichero();
        try{
          this.rastreo();
          this.conectorAction("LPMantenimientoMapaZonasLineasArmado");
          this.conectorActionParametro("opcionMenu", "eliminar");
          this.conectorActionParametro("accion", "");

        }catch(Exception e){
          traza("Excepcion: " + e.toString());
          traza(e);
          this.lanzarPaginaError(e);
        }
    }
}

