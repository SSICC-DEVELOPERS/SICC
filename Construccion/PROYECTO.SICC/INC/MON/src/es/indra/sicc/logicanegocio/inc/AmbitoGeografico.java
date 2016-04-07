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
 * @author Dante Castiglione
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class AmbitoGeografico implements Serializable {
    private Long oidSubgerencia;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;
    private Long oidTerritorio;

    /** Descripcion: corresponde al gerente de la subgerencia.*/
    private Gerente subgerente;

    /** Descripcion: corresponde al gerente de Region */
    private Gerente gerenteRegion;

    /** Descripcion: corresponde al gerente de Zona */
    private Gerente gerenteZona;

    /** Descripcion: corresponde al gerente de Seccion */
    private Gerente lider;

    public AmbitoGeografico() {
    }

    public void setGerenteRegion(Gerente gerenteRegion) {
        this.gerenteRegion = gerenteRegion;
    }

    public Gerente getGerenteRegion() {
        return gerenteRegion;
    }

    public void setGerenteZona(Gerente gerenteZona) {
        this.gerenteZona = gerenteZona;
    }

    public Gerente getGerenteZona() {
        return gerenteZona;
    }

    public void setLider(Gerente lider) {
        this.lider = lider;
    }

    public Gerente getLider() {
        return lider;
    }

    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidSeccion(Long oidSeccion) {
        this.oidSeccion = oidSeccion;
    }

    public Long getOidSeccion() {
        return oidSeccion;
    }

    public void setOidSubgerencia(Long oidSubgerencia) {
        this.oidSubgerencia = oidSubgerencia;
    }

    public Long getOidSubgerencia() {
        return oidSubgerencia;
    }

    public void setOidTerritorio(Long oidTerritorio) {
        this.oidTerritorio = oidTerritorio;
    }

    public Long getOidTerritorio() {
        return oidTerritorio;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setSubgerente(Gerente subgerente) {
        this.subgerente = subgerente;
    }

    public Gerente getSubgerente() {
        return subgerente;
    }

    /*
     * Compara si es igual a la zona geográfica que le entra por cabecera
     */
    public boolean equalsAmbito(AmbitoGeografico ambitoEntrada) {
        UtilidadesLog.info("AmbitoGeografico.equalsAmbito(AmbitoGeografico "
            +"ambitoEntrada)Entrada");

        if (ambitoEntrada == null) {
            UtilidadesLog.info("AmbitoGeografico.equalsAmbito(AmbitoGeografico"
                 +" ambitoEntrada):Salida NULL");

            return false;
        } else {
            if (oidSubgerencia != null) {
                if (!oidSubgerencia.equals(ambitoEntrada.getOidSubgerencia())) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbito(Ambito"
                        +"Geografico ambitoEntrada)Salida oidSubgerencia");

                    return false;
                }
            }

            if (oidRegion != null) {
                if (!oidRegion.equals(ambitoEntrada.getOidRegion())) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbito(Ambito"
                        +"Geografico ambitoEntrada): Salida oidRegion");

                    return false;
                }
            }

            if (oidZona != null) {
                if (!oidZona.equals(ambitoEntrada.getOidZona())) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbito(Ambito"
                        +"Geografico ambitoEntrada): Salida oidZona");

                    return false;
                }
            }

            if (oidSeccion != null) {
                if (!oidSeccion.equals(ambitoEntrada.getOidSeccion())) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbito(Ambito"
                        +"Geografico ambitoEntrada): Salida oidSeccion");

                    return false;
                }
            }

            if (oidTerritorio != null) {
                if (!oidTerritorio.equals(ambitoEntrada.getOidTerritorio())) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbito(Ambito"
                        +"Geografico ambitoEntrada): Salida oidTerritorio");

                    return false;
                }
            }

            UtilidadesLog.info("AmbitoGeografico.equalsAmbito(AmbitoGeografico"
                +"ambitoEntrada): Salida");

            return true;
        }
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   6/04/2006
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc 22684
     */
    public boolean equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente) {
        UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente): Entrada");

        if (ambitoEntrada == null) {
            UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente):Salida NULL");

            return false;
            
        } else {
        
            if (ambitoEntrada.getSubgerente()!= null && ambitoEntrada.getSubgerente().getOidCliente()!=null &&
                ambitoEntrada.getSubgerente().getOidCliente().equals(oidGerente)) {
                
                if (this.oidSubgerencia !=null && this.oidSubgerencia.equals(ambitoEntrada.getOidSubgerencia())) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente):Salida oidSubgerencia");

                    return true;
                }
            }
            
            if (ambitoEntrada.getGerenteRegion()!= null && ambitoEntrada.getGerenteRegion().getOidCliente()!=null &&
                ambitoEntrada.getGerenteRegion().getOidCliente().equals(oidGerente)) {
                
                if (this.oidSubgerencia !=null && this.oidSubgerencia.equals(ambitoEntrada.getOidSubgerencia()) &&
                    ((this.oidRegion == null) || (this.oidRegion !=null && this.oidRegion.equals(ambitoEntrada.getOidRegion())))) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente):Salida OidRegion");

                    return true;
                }
            }
            
            if (ambitoEntrada.getGerenteZona()!= null && ambitoEntrada.getGerenteZona().getOidCliente()!=null &&
                ambitoEntrada.getGerenteZona().getOidCliente().equals(oidGerente)) {
                
                if (this.oidSubgerencia !=null && this.oidSubgerencia.equals(ambitoEntrada.getOidSubgerencia()) &&
                    ((this.oidRegion == null) || (this.oidRegion !=null && this.oidRegion.equals(ambitoEntrada.getOidRegion()))) &&
                    ((this.oidZona == null) || (this.oidZona !=null && this.oidZona.equals(ambitoEntrada.getOidZona())))) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente):Salida OidZona");

                    return true;
                }
            }
            
            if (ambitoEntrada.getLider()!= null && ambitoEntrada.getLider().getOidCliente()!=null &&
                ambitoEntrada.getLider().getOidCliente().equals(oidGerente)) {
                
                if (this.oidSubgerencia !=null && this.oidSubgerencia.equals(ambitoEntrada.getOidSubgerencia()) &&
                    ((this.oidRegion == null) || (this.oidRegion !=null && this.oidRegion.equals(ambitoEntrada.getOidRegion()))) &&
                    ((this.oidZona == null) || (this.oidZona !=null && this.oidZona.equals(ambitoEntrada.getOidZona()))) &&
                    ((this.oidSeccion == null) || (this.oidSeccion !=null && this.oidSeccion.equals(ambitoEntrada.getOidSeccion())))) {
                    UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente):Salida OidSeccion");

                    return true;
                }
            }          

            UtilidadesLog.info("AmbitoGeografico.equalsAmbitoGerente(AmbitoGeografico ambitoEntrada, Long oidGerente): Salida FALSE");

            return false;
        }
    }
    
    
    public String toString(){
      Field[] campos = this.getClass().getDeclaredFields();
      Method[] metodos = this.getClass().getMethods();
      StringBuffer buffer = new StringBuffer( this.getClass().getName() );
      String nombreMetodoBuscado = null;
      Field campo = null;
      try{
        for( int i = 0; i<campos.length ; i++){
            campo = campos[i];
            nombreMetodoBuscado = "get" + campo.getName();
            for( int j = 0; j< metodos.length; j++){
                if( metodos[j].getName().equalsIgnoreCase( nombreMetodoBuscado ) ){
                  buffer.append( "\n" + metodos[j].getName() +"() : " + metodos[j].invoke(this, new Object[0] ) );
                  break;
                }
            }
        }
      }catch(Exception e){
        UtilidadesLog.error(this.getClass() + ".toString()",e);
      }
      return buffer.toString();
    }
}
