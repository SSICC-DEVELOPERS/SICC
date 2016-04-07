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
 */
package es.indra.sicc.logicanegocio.inc;


//import java.lang.IELIMINANDO FACTORIAnteger;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class FactoriaConcurso {
    private static FactoriaConcurso factoriaConcurso = null;
    private ArrayList listaConcursos = null;

    //Agregado por jrivas 30/5/2005
    private Periodo minPeriodoDesde = null;
    private Periodo maxPeriodoHasta = null;
    private static UtilidadesLog log = new UtilidadesLog();
    
    private FactoriaConcurso() {
        listaConcursos = new ArrayList();
    }

    public Periodo getMinPeriodoDesde() {
        return minPeriodoDesde;
    }

    public Periodo getMaxPeriodoHasta() {
        return maxPeriodoHasta;
    }

    //jrivas 14/7/2005
    //Eliminado INC 19771

    /*public void limpiarLista() {
        listaConcursos.clear();
        minPeriodoDesde = null;
        maxPeriodoHasta = null;
    }*/

    //jrivas 14/7/2005
    //Insertado INC 19771
    public static void refrescarConcursos() throws MareException {
        UtilidadesLog.info("FactoriaConcurso.refrescarConcursos():Entrada");
        UtilidadesLog.warn("ELIMINANDO FACTORIA");
        factoriaConcurso = null;
        //jrivas 17/2/2009 20090836
        actualizarRefrescoConcurso();
        UtilidadesLog.info("FactoriaConcurso.refrescarConcursos():Salida");
    }

    //modificado por Noziglia C.  
    public static synchronized FactoriaConcurso getFactoriaConcurso()
            throws MareException/*
    1.- Si el atributo factoriaConcurso == null entonces
    -Llamamos al constructor privado FactoriaConcurso() y se lo asignamos al atributo factoriaConcurso
    -<<BELC300019452>>Llamamos al método DAOConcursos.obtenerConcursos().
    Asignamos a listaConcursos lo que nos devuelve el método.
    -<<BELC300019452>>Se debe actualizar los atributos de minPeriodoDesde y
    maxPeriodoDesde con el minimoperiodo desde y el maximo periodo hasta de todos los concursos
    2.- Devolvemos el atributo factoriaConcurso

    */
     {
        UtilidadesLog.info("FactoriaConcurso.getFactoriaConcurso():Entrada");
        //jrivas 17/2/2009 20090836
        //if (factoriaConcurso == null) {
        if (factoriaConcurso == null || validarRefresco()) {
            UtilidadesLog.debug("va a cargar factoriaConcurso");
            factoriaConcurso = new FactoriaConcurso();

            DAOConcursos daoC = new DAOConcursos();
            factoriaConcurso.listaConcursos = daoC.obtenerConcursos();

            if (factoriaConcurso.listaConcursos.size() > 0) {
                Concurso conc = (Concurso) factoriaConcurso.listaConcursos.get(0);
                Periodo maxPer = conc.getPeriodoHasta();
                Periodo minPer = conc.getPeriodoDesde();

                for (int i = 1; i < factoriaConcurso.listaConcursos.size(); i++) {
                    conc = (Concurso) factoriaConcurso.listaConcursos.get(i);

                    Periodo perConcDesd = conc.getPeriodoDesde();
                    Periodo perConcHasta = conc.getPeriodoHasta();

                    if (perConcDesd.menorQue(minPer)) {
                        minPer = perConcDesd;
                    }

                    if (perConcHasta.mayorQue(maxPer)) {
                        maxPer = perConcHasta;
                    }
                }

                factoriaConcurso.minPeriodoDesde = minPer;
                factoriaConcurso.maxPeriodoHasta = maxPer;
            }
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 25/03/2010                
          UtilidadesLog.debug("factoriaConcurso.listaConcursos.size(): " + factoriaConcurso.listaConcursos.size());
          
        UtilidadesLog.info("FactoriaConcurso.getFactoriaConcurso():Salida");
        return factoriaConcurso;
    }

    public java.util.ArrayList getConcursos(Long pais) throws MareException {
        /*
         * Los Puntos 1 y 1.1 fueron suprimidos  BELC300019452
          1.- Si listaConcursos no tiene ningun elemento en la Hashtable deberemos llamar al DAOConcursos.obtenerConcursos()
          y asignar el resultado al atributo listaConcursos
          1.1 - En caso de modificar listaConcurso, se debe actualizar los atributos de minPeriodoDesde y maxPeriodoDesde
          con el minimo periodo desde y el maximo periodo hasta de todos los concursos

          2.- Devolvemos en un ArrayList los elementos de listaConcursos que conicidan con el pais que se pasa por parámetro */
        UtilidadesLog.info("FactoriaConcurso.getConcursos(Long pais):Entrada");
        Cronometrador.startTransaction("FactoriaConcurso.getConcursos()");
        /**
         * PERFORMANCE
         * Hay que revisar porque recarga siempre los concursos en memoria, a pesar de que no se refresca.
         */
        ArrayList listaConcu = new ArrayList();
        Concurso conc;

        for (int i = 0; i < listaConcursos.size(); i++) {
            conc = (Concurso) factoriaConcurso.listaConcursos.get(i);

            if (conc.getOidPais().equals(pais)) {
                listaConcu.add(conc);
            }
        }

        UtilidadesLog.info("FactoriaConcurso.getConcursos(Long pais):Salida");
        Cronometrador.endTransaction("FactoriaConcurso.getConcursos()");
        return listaConcu;
    }

    /**
     * Fecha de Creacion: 20/05/2005
     * Autor: Damasia Maneiro
     * Comentario:
     *
     */
    public ArrayList getConcursosPorOID(DTOOIDs oids) throws MareException {
        /*
         * 2.- Deberemos devolver en una ArrayList los objetos concurso almacenados en el atributo listaConcursos que tengan
         * los OIDs contenidos en objeto de entrada (oids) */
        /* */
        UtilidadesLog.info("FactoriaConcurso.getConcursosPorOID(DTOOIDs oids):Entrada");
        ArrayList aux = new ArrayList();

        if ((listaConcursos.size() > 0) && (oids != null) && (oids.getOids() != null)) {
            Concurso concurso = new Concurso();
            Long[] oidsConcurso = oids.getOids();

            //realizo una interseccion entre listaConcursos y los enviados por oids
            for (int pos = 0; oidsConcurso.length > pos; pos++) {
                //UtilidadesLog.debug("busca concurso: " + oidsConcurso[pos]);
                for (int pos2 = 0; listaConcursos.size() > pos2; pos2++) {
                    concurso = (Concurso) listaConcursos.get(pos2);
                    //UtilidadesLog.debug("concurso de comparación: " + concurso.getOidConcurso());
                    if (concurso.getOidConcurso().equals(oidsConcurso[pos])) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("encontro concurso: " + oidsConcurso[pos]);
                          
                        aux.add(concurso);
                    }
                }
            }
        }
        UtilidadesLog.info("FactoriaConcurso.getConcursosPorOID(DTOOIDs oids):Salida");
        return aux;
    }

    /**
     * Agregado por Jrivas 30/5/2005
     */

    //INC 18747 que retorna?

    /*   DT gmamano 02/06/05


     Se le pasa un oidPeriodo y devuelve un ArrayList, la documentacion del metodo la he actualizado:

     Devuelvo los concursos en el que el periodo que se pasa por parámetro este dentro de fecha inicio y fecha fin del
     concurso y que tengan baseCalculo=ConstantesINC.BASE_CALCULO_MONTO o
     baseCalculo=ConstantesINC.BASE_CALCULO_UNIDADES

     */
    public ArrayList getConcursosMontoUnidades(Periodo per) {
        UtilidadesLog.info("FactoriaConcurso.getConcursosMontoUnidades(Periodo per):Entrada");
        ArrayList salida = new ArrayList();
        Concurso concurso = new Concurso();

        for (int i = 0; listaConcursos.size() > i; i++) {
            concurso = (Concurso) listaConcursos.get(i);

            if (per.contenidoEn(concurso.getPeriodoDesde(), concurso.getPeriodoHasta())) {
                if (ConstantesINC.OID_FORMA_CALC_BASE_CALC.equals(concurso.getFormaCalculo()) &&
                (ConstantesINC.BASE_CALCULO_MONTO.equals(concurso.getBaseCalculo()) ||
                        ConstantesINC.BASE_CALCULO_UNIDADES.equals(concurso.getBaseCalculo()))) {
                    salida.add(concurso);
                }
            }
        }
        UtilidadesLog.info("FactoriaConcurso.getConcursosMontoUnidades(Periodo per):Salida");
        return salida;
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Long periodoEntrada
     * @return ArrayList
     * @documentation
     *
     * @date
     */
    public ArrayList getConcursosMultinivel(Long periodoEntrada)
            throws MareException {
        UtilidadesLog.info("FactoriaConcurso.getConcursosMultinivel(Long periodoEntrada):Entrada");

        /*
        Documentation
        1.- Calculo el periodo: hago un findByUk() en la entidad CRAPeriodo pasandole periodo,
        con esos datos compondremos un objeto Periodo e invocaremos a su método
        CalcularPeriodoPosterior(con.periodosEsparaParaCalculo)


        Se deberán devolver los concursos, que cumplan:


        multinivel == TRUE
        activo == TRUE <--- INC 19452
        baseCalculo == ConstantesINC.BASE_CALCULO_UNIDADES || ConstantesINC.BASE_CALCULO_MONTO
        periodo == al oid del periodo resultante de hacer un findByUk() en la entidad CRAPeriodo
        pasandole periodo, con esos datos compondremos un objeto Periodo e invocaremos a su método
        CalcularPeriodoPosterior(con.periodosEsparaParaCalculo).
        */
        UtilidadesLog.debug("****Entro FactoriaConcurso.getConcursosMultinivel****");

        try {
            ArrayList retorno = new ArrayList();
            PeriodoLocalHome periodoLocalHome = this.getPeriodoLocalHome();
            PeriodoLocal periodo = periodoLocalHome.findByPrimaryKey(periodoEntrada);

            Periodo a = new Periodo();

            ArrayList aux = this.getConcursos(periodo.getOidPais());
            Concurso concurso;

            UtilidadesLog.debug("Buscamos los concurso Multinivel");

            for (int i = 0; i < aux.size(); i++) {
                concurso = ((Concurso) aux.get(i));
                a.setOidPeriodo(concurso.getPeriodoDesde().getOidPeriodo());

                if ((concurso.getMultiNivel() == true) &&
                        (ConstantesINC.BASE_CALCULO_UNIDADES.equals(concurso.getBaseCalculo()) ||
                        ConstantesINC.BASE_CALCULO_MONTO.equals(concurso.getBaseCalculo())) &&
                        periodoEntrada.equals(a.calcularPeriodoPosterior(concurso.getPeriodosEsperaParaCalculo()).getOidPeriodo())) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 25/03/2010                                        
                      UtilidadesLog.debug("El concurso numero " + concurso.getNumeroConcurso() + " es Multinivel.");
                    retorno.add(concurso);
                } else {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 25/03/2010                
                      UtilidadesLog.debug("El concurso " + concurso.getNumeroConcurso() + " no es calculoMonto o calculoUnidades o no es el periodo donde se debe evaluar.");
                }
            }

            UtilidadesLog.info("FactoriaConcurso.getConcursosMultinivel(Long periodoEntrada):Salida");

            return retorno;
            
        } catch (NoResultException nre) {
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            UtilidadesLog.error("ERROR ", pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    private PeriodoLocalHome getPeriodoLocalHome(){
            return new PeriodoLocalHome();
    }
    
    //jrivas 17/2/2009 20090836
    private static void actualizarRefrescoConcurso() throws MareException {
        UtilidadesLog.info("FactoriaConcurso.actualizarRefrescoConcurso() - Entrada");
        StringBuffer query = new StringBuffer();
        query.append("DELETE INC_ULTIM_ACTUA_CONCU; ");
        query.append("INSERT INTO INC_ULTIM_ACTUA_CONCU (VAL_SERV, FEC_CREA) VALUES ('" + ConfigFactory.getBatchConfig().getServer() + "', SYSDATE);");
        ejecutarInsert(query);
        UtilidadesLog.info("FactoriaConcurso.actualizarRefrescoConcurso() - Salida");
    }    
    
    //jrivas 17/2/2009 20090836
    private static boolean validarRefresco() throws MareException {
        UtilidadesLog.info("FactoriaConcurso.validarRefresco() - Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        String codigoError;

        try {
            bs = BelcorpService.getInstance();
            query.append("SELECT VAL_SERV FROM INC_ULTIM_ACTUA_CONCU");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if (respuesta.esVacio()) {
                //No hay datos. Nadia refresco actualizo concursos.
                UtilidadesLog.info("FactoriaConcurso.validarRefresco() - Salida FALSE");
                return false;
            } else {
                String servidor;
                for (int i = 0; i < respuesta.getRowCount(); i++) {
                      servidor = respuesta.getValueAt(i, "VAL_SERV").toString();
                      if (servidor.equals(ConfigFactory.getBatchConfig().getServer())) {
                          //Servidor ya actualizado.
                          UtilidadesLog.info("FactoriaConcurso.validarRefresco() - Salida FALSE 2");
                          return false;
                      }
                }
                //Servidor no actualizado.
                //Inserto registro para indicar que ya se refresco
                query = new StringBuffer();
                query.append("INSERT INTO INC_ULTIM_ACTUA_CONCU (VAL_SERV, FEC_CREA) VALUES ('" + ConfigFactory.getBatchConfig().getServer() + "', SYSDATE);");
                ejecutarInsert(query);
                UtilidadesLog.info("FactoriaConcurso.validarRefresco() - Salida TRUE");
                return true;
            }

        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        


    }        
    
    //jrivas 17/2/2009 20090836
    private static void ejecutarInsert(StringBuffer query) throws MareException {
        UtilidadesLog.info("FactoriaConcurso.ejecutarInsert() - Entrada");
        
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("Error en ejecutarInsert ",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }            
        UtilidadesLog.info("FactoriaConcurso.ejecutarInsert() - Salida");
    }    

    public static UtilidadesLog getlog() {
      return log;
    }
    
}
