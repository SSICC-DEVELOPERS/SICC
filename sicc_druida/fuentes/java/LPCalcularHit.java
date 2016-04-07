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
 */
 
/**
 * @author SPLATAS
 * @fecha  25/01/2007
 * Notas: C.U. Calcular Hit
 */


public class LPCalcularHit extends LPSICCBase {
    
    public void inicio() throws Exception  {}
    
    public void ejecucion() throws Exception {
        traza(" LPCalcularHit.ejecucion(): Entrada ");
        
        pagina("contenido_hit_calcular");
        
        conectorAction("LPMantenerCalculoHit");
        conectorActionParametro("accion", "");
        conectorActionParametro("opcionMenu", "calcular");
        
        traza(" LPCalcularHit.ejecucion(): Salida ");
    }
    
    
    
    
}
