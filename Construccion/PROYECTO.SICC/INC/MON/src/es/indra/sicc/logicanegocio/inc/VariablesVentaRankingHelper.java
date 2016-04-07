package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class VariablesVentaRankingHelper {
    public static final int CANTIDAD_PERIODOS_ACTIVAS_INICIALES = 2;
    public static final int CANTIDAD_PERIODOS_ACTIVAS_FINALES = 1;

    /**
    * @return Void
    * @version 1.00 27/06/2005
    * @author: Sergio Saavedra
    * Descripcion: Este metodo obtiene el porcentaje de ordenes por pedido en
    * todos los periodos que que conforman el concurso y almacena los resultados en el objeto
    * de la clase GerenteConcursoVariablesVentaRanking pasado por parametro.
    */
      public void calcularPOPRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPOPRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Entrada");
        UtilidadesLog.debug("Empezo calcularPOPRanking, recibo : " + gerConcVarVentRank);

        DAOCalculoVariablesVentaRanking daoCVVR = new DAOCalculoVariablesVentaRanking();
        RecordSet rsResultado = daoCVVR.recuperarNumeroSolicitudes(gerConcVarVentRank.getUnidadAdministrativaGerente(),
                                                                   gerConcVarVentRank.getPeriodoDesde(), gerConcVarVentRank.getPeriodoHasta(), gerConcVarVentRank.getConcurso());

        if ((rsResultado != null) && (rsResultado.getRowCount() > 0)) {
            UnidadAdministrativa registro = new UnidadAdministrativa();
            Object o = null;

            for (int i = 0; i < rsResultado.getRowCount(); i++) {
                registro.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                BigDecimal numeroPedidos = (BigDecimal) gerConcVarVentRank.obtenerVariableResultado(registro,
                                                                                                    ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS);

                /*
                 * Modificación por Diego Morello - 01/07/2005
                 * Si numeroPedidos == 0, debe invocarse setVariableResultado
                 * con valor (en este caso Object o) == 0
                 */
                if (numeroPedidos==null || numeroPedidos.longValue() == 0) {
                    o = new BigDecimal(0);
                } else {
                    BigDecimal numSolicitudes = (BigDecimal)rsResultado.getValueAt(i, "COUNT");
                    o = numSolicitudes.divide(numeroPedidos, 2, BigDecimal.ROUND_HALF_UP);
                }

                /* Fin modificación */
                gerConcVarVentRank.setVariableResultado(registro, ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO, o);
            }
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPOPRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Salida");
    }

    /**
    * @return Void
    * @version 1.00 27/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo obtiene la cantidad de pedidos realizados en todos los periodos
    * que que conforman el concurso y almacena los resultados en el objeto de la clase
    * GerenteConcursoVariablesVentaRanking pasado por parametro.
    */
    public void calcularNumeroPedidosRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularNumeroPedidosRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Entrada");
        DAOCalculoVariablesVentaRanking daoCVVR = new DAOCalculoVariablesVentaRanking();

        UtilidadesLog.debug("Empezo calcularNumeroPedidosRanking, recibo : " + gerConcVarVentRank);

        RecordSet rsResultado = daoCVVR.recuperarNumeroPedidos(gerConcVarVentRank.getUnidadAdministrativaGerente(),
                                                               gerConcVarVentRank.getPeriodoDesde(), gerConcVarVentRank.getPeriodoHasta(), gerConcVarVentRank.getConcurso() );

        if ((rsResultado != null) && (rsResultado.getRowCount() > 0)) {
            UnidadAdministrativa registro = new UnidadAdministrativa();
            Object o = null;

            for (int i = 0; i < rsResultado.getRowCount(); i++) {
                registro.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                gerConcVarVentRank.setVariableResultado(registro, ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS,
                                                        (BigDecimal)rsResultado.getValueAt(i, "COUNT"));
            }
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularNumeroPedidosRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Salida");
    }

    /**
    * @return Void
    * @version 1.00 27/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo obtiene la cantidad de consultoras recividas en el periodo de
    * inicio del concurso y almacena los resultados en el objeto de la clase
    * GerenteConcursoVariablesVentaRanking pasado por parametro
    */
    public void calcularRecibidasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularRecibidasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Entrada");
        DAOCalculoVariablesVentaRanking daoCVVR = new DAOCalculoVariablesVentaRanking();

        UtilidadesLog.debug("Empezo calcularRecibidasRanking, recibo : " + gerConcVarVentRank);

        RecordSet rsResultado = daoCVVR.recuperarRecibidas(gerConcVarVentRank.getUnidadAdministrativaGerente(), gerConcVarVentRank.getPeriodoDesde(), gerConcVarVentRank.getConcurso()  );

        if ((rsResultado != null) && (rsResultado.getRowCount() > 0)) {
            UnidadAdministrativa registro = new UnidadAdministrativa();
            Object o = null;

            for (int i = 0; i < rsResultado.getRowCount(); i++) {
                registro.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                gerConcVarVentRank.setVariableResultado(registro, ConstantesRanking.VAR_VTA_RANK_RECIBIDAS,
                                                        (BigDecimal)rsResultado.getValueAt(i, "COUNT"));
            }
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularRecibidasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Salida");
    }

    /**
    * @return Void
    * @version 1.00 27/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo obtiene la cantidad de consultoras entregadas en el periodo
    * anterior al inicio del concurso y almacena los resultados en el objeto de la clase
    * GerenteConcursoVariablesVentaRanking pasado por parametro
    */
    public void calcularEntregadasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularEntregadasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Entrada");
        DAOClientePremiacion daoCP = new DAOClientePremiacion();

        UtilidadesLog.debug("Empezo calcularEntregadasRanking, recibo : " + gerConcVarVentRank);

        Periodo periodoAnteriorDesdeConcurso = daoCP.obtenerPeriodo(gerConcVarVentRank.getPeriodoDesde().getOidPeriodo(), -1);
        DAOCalculoVariablesVentaRanking daoCVVR = new DAOCalculoVariablesVentaRanking();
        RecordSet rsResultado = daoCVVR.recuperarEntregadas(gerConcVarVentRank.getUnidadAdministrativaGerente(), periodoAnteriorDesdeConcurso, gerConcVarVentRank.getConcurso() );

        if ((rsResultado != null) && (rsResultado.getRowCount() > 0)) {
            UnidadAdministrativa registro = new UnidadAdministrativa();
            Object o = null;

            for (int i = 0; i < rsResultado.getRowCount(); i++) {
                registro.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                gerConcVarVentRank.setVariableResultado(registro, ConstantesRanking.VAR_VTA_RANK_ENTREGADAS,
                                                        (BigDecimal)rsResultado.getValueAt(i, "COUNT"));
            }
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularEntregadasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank):Salida");
    }

    /**
    * @return Void
    * @version 1.00 27/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo obtiene la cantidad de consultoras cambiaron su estado a
    * (codigoEstado) dentro de los periodos que conforman el concurso y almacena los
    * resultados en el objeto de la clase GerenteConcursoVariablesVentaRanking pasado
    * por parametro
    */
    public void calcularCantidadConsultorasPorEstado(GerenteConcursoVariablesVentaRanking gerConcVarVentRank, Integer codigoEstado,
                                                     Integer codigoVariable)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularCantidadConsultorasPorEstado(GerenteConcursoVariablesVentaRanking gerConcVarVentRank, Integer codigoEstado,"+
                                                     "Integer codigoVariable):Entrada");
        UtilidadesLog.debug("Empezo calcularCantidadConsultorasPorEstado, recibo : " + gerConcVarVentRank + " - " + codigoEstado + " - " +
                           codigoVariable);

        DAOCalculoVariablesVentaRanking daoCVVR = new DAOCalculoVariablesVentaRanking();

        RecordSet rsResultado = daoCVVR.recuperarCantidadConsultorasPorEstado(gerConcVarVentRank.getUnidadAdministrativaGerente(),
                                                                              gerConcVarVentRank.getPeriodoDesde(),
                                                                              gerConcVarVentRank.getPeriodoHasta(), new Long(codigoEstado.intValue()), 
                                                                              gerConcVarVentRank.getConcurso());

        if ((rsResultado != null) && (rsResultado.getRowCount() > 0)) {
            UnidadAdministrativa registro = new UnidadAdministrativa();
            Object o = null;
          
            for (int i = 0; i < rsResultado.getRowCount(); i++) {
                registro.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                gerConcVarVentRank.setVariableResultado(registro, codigoVariable, (BigDecimal)rsResultado.getValueAt(i, "COUNT"));
            }
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularCantidadConsultorasPorEstado(GerenteConcursoVariablesVentaRanking gerConcVarVentRank, Integer codigoEstado,"+
                                             "Integer codigoVariable):Salida");

    }

    /**
     * Este metodo se encarga de calcular el porcentaje de rotacion y almacena
     * el resultado en la variable porcentajeRotacion del objeto pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularPorcentajeRotacionRanking(ResultadoVariablesVentaRanking resultVarVtaRank) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeRotacionRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Entrada");

        BigDecimal rot = null;

        // Calculo y asigno
        // Si activasIniciales es cero, el valor de rotacion a asignar debe ser cero
        if (resultVarVtaRank.getActivasIniciales()==null || resultVarVtaRank.getActivasIniciales().longValue() == 0) {
            rot = new BigDecimal("0");
        } else {
            // Preparo los valores que usare para calcular
            BigDecimal egresos = resultVarVtaRank.getEgresos()!= null?resultVarVtaRank.getEgresos():new BigDecimal(0);
            BigDecimal reingresos = resultVarVtaRank.getReingresos()!= null?resultVarVtaRank.getReingresos():new BigDecimal(0);
            BigDecimal activasInic = new BigDecimal(resultVarVtaRank.getActivasIniciales().toString());

            // Calculo: rotacion = (egresos - reingresos) / activasInic
            rot = egresos.subtract(reingresos).divide(activasInic, 2, BigDecimal.ROUND_HALF_UP);
        }

        resultVarVtaRank.setRotacion(rot);
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeRotacionRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Salida");
    }

    /**
     * Este metodo se encarga de calcular el porcentaje de retencion y almacena
     * el resultado en la variable porcentajeRetencion del objeto pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularPorcentajeRetencionRanking(ResultadoVariablesVentaRanking resultVarVtaRank, Integer actFinUltPeriEjercAnt) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeRetencionRanking(ResultadoVariablesVentaRanking resultVarVtaRank, Integer actFinUltPeriEjercAnt):Entrada");
        UtilidadesLog.debug("**** Entro en calcularPorcentajeRetencionRanking; recibo: " + resultVarVtaRank + " actFinUltPeriEjercAnt: " + actFinUltPeriEjercAnt);
        BigDecimal ret = null;

        // Si actFinUltPeriEjercAnt == 0, el valor de retención a asignar debe ser cero
        if (actFinUltPeriEjercAnt == null || actFinUltPeriEjercAnt.intValue() == 0) {
            ret = new BigDecimal("0");
        } else {
            BigDecimal activasFinales = resultVarVtaRank.getActivasFinales()!=null?new BigDecimal(resultVarVtaRank.getActivasFinales().toString()):new BigDecimal(0);
            BigDecimal actFinUlt = new BigDecimal(actFinUltPeriEjercAnt.toString());
            BigDecimal aux = activasFinales.divide(actFinUlt, 2, BigDecimal.ROUND_HALF_UP);
            ret = aux.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
        }

        resultVarVtaRank.setRetencion(ret);
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeRetencionRanking(ResultadoVariablesVentaRanking resultVarVtaRank, Integer actFinUltPeriEjercAnt):Salida");
    }

    /**
      * Este metodo se encarga de calcular el promedio de unidades por pedido
      * y almacena el resultado en la variable pup del objeto pasado por parametro
      *
      * Sistema: Belcorp
      * Módulo:  INC
      * Fecha:   28/06/2005
      * @version 1.00
      * @autor   Diego Morello
      */
    public void calcularPUPRanking(ResultadoVariablesVentaRanking resultVarVtaRank) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPUPRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Entrada");
        UtilidadesLog.debug("**** Entro en calcularPUPRanking; recibo: " + resultVarVtaRank);
        BigDecimal pup = null;

        // Si numeroPedidos es cero, el valor de PUP debe ser cero
        if (resultVarVtaRank.getNumeroPedidos()==null || resultVarVtaRank.getNumeroPedidos().longValue() == 0) {
            pup = new BigDecimal("0");
        } else {
            BigDecimal unidades = resultVarVtaRank.getUnidades()!= null?new BigDecimal(resultVarVtaRank.getUnidades().toString()):new BigDecimal(0);
            BigDecimal numeroPedidos = resultVarVtaRank.getNumeroPedidos();
            pup = unidades.divide(numeroPedidos, 2, BigDecimal.ROUND_HALF_UP);
        }

        resultVarVtaRank.setPup(pup);
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPUPRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Salida");
    }

    /**
     * Este metodo se encarga de calcular el promedio de venta por pedido
     * y almacena el resultado en la variable pvp del objeto pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularPVPRanking(ResultadoVariablesVentaRanking resultVarVtaRank) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPVPRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Entrada");
        UtilidadesLog.debug("**** Entro en calcularPVPRanking; recibo: " + resultVarVtaRank);
        BigDecimal importeVentas = resultVarVtaRank.getImporteVentas()!=null?resultVarVtaRank.getImporteVentas():new BigDecimal(0);
        BigDecimal numeroPedidos = resultVarVtaRank.getNumeroPedidos()!=null?resultVarVtaRank.getNumeroPedidos():new BigDecimal(0);
        BigDecimal pvp = null;

        // Si numeroPedidos == 0, el valor de PVP debe ser cero
        if (numeroPedidos.equals(new BigDecimal("0"))) {
            pvp = new BigDecimal("0");
        } else {
            pvp = importeVentas.divide(numeroPedidos, 2, BigDecimal.ROUND_HALF_UP);
        }

        resultVarVtaRank.setPvp(pvp);
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPVPRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Salida");
    }

    /**
     * Este metodo se encarga de calcular el precio promedio unitario y almacena
     * el resultado en la variable ppu del objeto pasado por parametro
     *
      * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularPPURanking(ResultadoVariablesVentaRanking resultVarVtaRank) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPPURanking(ResultadoVariablesVentaRanking resultVarVtaRank):Entrada");
        UtilidadesLog.debug("**** Entro en calcularPPURanking; recibo: " + resultVarVtaRank);
        BigDecimal ppu = null;

        // Si unidades == 0, el valor de PPU a asignar debe ser cero
        if (resultVarVtaRank.getUnidades()== null || resultVarVtaRank.getUnidades().longValue() == 0) {
            ppu = new BigDecimal("0");
        } else {
            BigDecimal unidades = resultVarVtaRank.getUnidades()!=null? new BigDecimal(resultVarVtaRank.getUnidades().toString()):new BigDecimal(0);
            BigDecimal importeVentas = resultVarVtaRank.getImporteVentas()!= null?resultVarVtaRank.getImporteVentas():new BigDecimal(0);
            ppu = importeVentas.divide(unidades, 2, BigDecimal.ROUND_HALF_UP);
        }

        resultVarVtaRank.setPpu(ppu);
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPPURanking(ResultadoVariablesVentaRanking resultVarVtaRank):Salida");
    }

    /**
      * Este metodo se encarga de calcular a diferencia entre las activas
      * iniciales y finales y almacena el resultado en la variable capitalizacion
      * del objeto pasado por parametro
      *
      * Sistema: Belcorp
      * Módulo:  INC
      * Fecha:   28/06/2005
      * @version 1.00
      * @autor   Diego Morello
      */
    public void calcularCapitalizacionRanking(ResultadoVariablesVentaRanking resultVarVtaRank) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularCapitalizacionRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Entrada");
        long actInic = resultVarVtaRank.getActivasIniciales()!=null? resultVarVtaRank.getActivasIniciales().longValue():0;
        long actFin = resultVarVtaRank.getActivasFinales()!=null? resultVarVtaRank.getActivasFinales().longValue():0;
        BigDecimal capitalizacion = new BigDecimal((actFin - actInic));
        resultVarVtaRank.setCapitalizacion(capitalizacion);
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularCapitalizacionRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Salida");
    }

    /**
      * Este metodo se encarga de calcular el porcentaje de consultoras activas
      * finales función del Número de pedidos y almacena el resultado en la
      * variable porcentajeActividad del objeto pasado por parametro
      *
      * Sistema: Belcorp
      * Módulo:  INC
      * Fecha:   28/06/2005
      * @version 1.00
      * @autor   Diego Morello
      */
    public void calcularPorcentajeActividadRanking(ResultadoVariablesVentaRanking resultVarVtaRank) {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeActividadRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Entrada");
        UtilidadesLog.debug("**** Entro en calcularPorcentajeActividadRanking; recibo: " + resultVarVtaRank);

        BigDecimal numeroPedidos = resultVarVtaRank.getNumeroPedidos()!= null? resultVarVtaRank.getNumeroPedidos():new BigDecimal(0);
        BigDecimal actFin = resultVarVtaRank.getActivasFinales()!= null? new BigDecimal(resultVarVtaRank.getActivasFinales().toString()): new BigDecimal(0);
        BigDecimal porcentaje = null;

        // Si el divisor es cero, el resultado del cálculo debe ser cero
        if (actFin.equals(new BigDecimal("0"))) {
            porcentaje = new BigDecimal("0");
        } else {
            porcentaje = numeroPedidos.divide(actFin, 2, BigDecimal.ROUND_HALF_UP);
        }

        resultVarVtaRank.setPorcentajeActividad(porcentaje);

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeActividadRanking(ResultadoVariablesVentaRanking resultVarVtaRank):Salida");
    }

    private HashMap obtenerActivasFinalesEjercicioAnterior(UnidadAdministrativa uniAdmGer, Periodo periodoCierre, GerenteConcursoVariablesVentaRanking gerConcVarVentRank )
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.obtenerActivasFinalesEjercicioAnterior(UnidadAdministrativa uniAdmGer, Periodo periodoCierre):Entrada");
        DAOCargaVariablesVenta daoCarga = new DAOCargaVariablesVenta();
        Periodo ultPeriodoEjercAnt = daoCarga.obtenerUltimoPeriodoEjercicioAnterior(periodoCierre);

        VariablesVentaHelper vvHelper = new VariablesVentaHelper();
        Long oidPeriodo = ultPeriodoEjercAnt.getOidPeriodo();
        ArrayList arrPer = vvHelper.obtenerPeriodosAnteriores(oidPeriodo, this.CANTIDAD_PERIODOS_ACTIVAS_FINALES);

        UtilidadesLog.debug("PeriodosAnteriores: " + arrPer);

        ArrayList arrPerEjercAnt = new ArrayList();
        arrPerEjercAnt.add(ultPeriodoEjercAnt);
        arrPerEjercAnt.add(ultPeriodoEjercAnt);
        arrPerEjercAnt.add(arrPer.get(1));

        DAOCalculoVariablesVentaRanking daoCalc = new DAOCalculoVariablesVentaRanking();
        RecordSet rsResultado = daoCalc.recuperarActivasPorPeriodo(uniAdmGer, arrPerEjercAnt, gerConcVarVentRank.getConcurso() );

        HashMap map = new HashMap();
        int rows = rsResultado.getRowCount();

        for (int i = 0; i < rows; i++) {
            UnidadAdministrativa key = new UnidadAdministrativa();

            BigDecimal decOidSubgerencia = (BigDecimal) rsResultado.getValueAt(i, "OID_SUBG_VENT");
            BigDecimal decOidRegion = (BigDecimal) rsResultado.getValueAt(i, "OID_REGI");
            BigDecimal decOidZona = (BigDecimal) rsResultado.getValueAt(i, "OID_ZONA");
            BigDecimal decOidSeccion = (BigDecimal) rsResultado.getValueAt(i, "OID_SECC");

            key.setOidSubgerencia(  decOidSubgerencia!=null?  new Long(decOidSubgerencia.longValue()) :null);
            key.setOidRegion(       decOidRegion!=null?       new Long(decOidRegion.longValue())      :null);
            key.setOidZona(         decOidZona!=null?         new Long(decOidZona.longValue())        :null);
            key.setOidSeccion(      decOidSeccion!=null?      new Long(decOidSeccion.longValue())     :null);

            BigDecimal count = (BigDecimal) rsResultado.getValueAt(i, "COUNT");
            Integer value = new Integer(count.intValue());
            
            UtilidadesLog.debug("UnidadAdministrativa : " + key.toString());
            UtilidadesLog.debug("value: " + value);

            map.put(key, value);
        }
        UtilidadesLog.info("VariablesVentaRankingHelper.obtenerActivasFinalesEjercicioAnterior(UnidadAdministrativa uniAdmGer, Periodo periodoCierre):Salida");
        return map;
    }

    /**
     * Este metodo se encarga de calcular las variables que dependen del valor
     * de otra calculadas previamente. Las variables a calcular son:
     * PorcentajeActividad, Capitalizacion, PPU, PVP, PUP, PorcentajeRetencion,
     * PorcentajeRotacion
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   29/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularVariablesDependientes(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularVariablesDependientes(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank, Periodo periodoCierre):Entrada");
        UtilidadesLog.debug("Empezo calcularVariablesDependientes, recibo: " + gerConcVarVtaRank + " - " + periodoCierre);

        HashMap actFinUltPeriEjercAnt = null;

        if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION).booleanValue()) {
            UnidadAdministrativa uniAdm = gerConcVarVtaRank.getUnidadAdministrativaGerente();
            actFinUltPeriEjercAnt = this.obtenerActivasFinalesEjercicioAnterior(uniAdm, periodoCierre, gerConcVarVtaRank);
        }

        HashMap resultVarVtaRank = gerConcVarVtaRank.getResultados();
        Iterator iteradorEntries = resultVarVtaRank.entrySet().iterator();

        while (iteradorEntries.hasNext()) {
            // Tomo una entrada del HashMap resultVarVtaRank
            Map.Entry entry = (Map.Entry) iteradorEntries.next();
            ResultadoVariablesVentaRanking value = (ResultadoVariablesVentaRanking) entry.getValue();

            // Trabajo con key o value de dicha entrada segun sea necesario
            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD).booleanValue()) {
                this.calcularPorcentajeActividadRanking(value);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION).booleanValue()) {
                this.calcularCapitalizacionRanking(value);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO).booleanValue()) {
                this.calcularPPURanking(value);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO).booleanValue()) {
                this.calcularPVPRanking(value);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO).booleanValue()) {
                this.calcularPUPRanking(value);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION).booleanValue()) {
                UtilidadesLog.debug("entry.getKey()- UnidadAdministrativa: " + ((UnidadAdministrativa)entry.getKey()).toString());
                Integer cantActFinUltPeriEjercAnt = (Integer) actFinUltPeriEjercAnt.get(entry.getKey());
                this.calcularPorcentajeRetencionRanking(value, cantActFinUltPeriEjercAnt);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION).booleanValue()) {
                this.calcularPorcentajeRotacionRanking(value);
            }
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularVariablesDependientes(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank, Periodo periodoCierre):Salida");
    }

    /**
    * @return Void
    * @version 1.00 27/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo obtiene la cantidad de clientes activos y la cantidad de
    * clientes constantes durante los periodos del concurso relacionados con el gerente y
    * almacena los resultados en el objeto de la clase GerenteConcursoVariablesVentaRanking
    * pasado por parametro
    */
    public void calcularActivasFinalesConstanciaRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularActivasFinalesConstanciaRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank, Periodo periodoCierre):Entrada");

        DAOVariablesVentaRanking daoVar = new DAOVariablesVentaRanking();
        DAOCalculoVariablesVentaRanking daoCVar = new DAOCalculoVariablesVentaRanking();

        UtilidadesLog.debug("dentro de calcularActivasFinalesConstanciaRanking, recibo : " + gerConcVarVentRank + " y periodo: " + periodoCierre);

        ArrayList periodosConcurso = daoVar.recuperarPeriodosConcurso(gerConcVarVentRank.getConcurso());
        UtilidadesLog.debug("recuperarPeriodosConcurso retorna: " + periodosConcurso);

        //Estas variables se utilizan para realizar cortes de control por Unidad Administrativa y por
        //Consultora y para contabilizar los totales de activas y constantes 
        UnidadAdministrativa ultUniAdmProcesada = null;
        Long ultConsultoraProcesada = null;
        Date ultFechaContactoProcesada = null;
        int cantActivas = 0;
        int cantConstantes = 0;
        HashMap mapPedidos = new HashMap();

        Long Aux = null;

        // Modificacion por Diego Morello - 14/07/2005 - Creo aqui la instancia de UnidadAdministrativa
        UnidadAdministrativa uniAdm = new UnidadAdministrativa();
        Date fechaContacto = null;

        ArrayList arraryPeriodosAVerificar = null;

        Periodo periodoHasta = (periodoCierre.menorQue(gerConcVarVentRank.getPeriodoHasta()) ||
                               periodoCierre.equals(gerConcVarVentRank.getPeriodoHasta())) ? periodoCierre : gerConcVarVentRank.getPeriodoHasta();

        RecordSet rsResultado = daoCVar.recuperarDetallePedidos(gerConcVarVentRank.getUnidadAdministrativaGerente(),
                                                                gerConcVarVentRank.getPeriodoDesde(), periodoHasta,
                                                                gerConcVarVentRank.getConcurso());

        if ((rsResultado != null) && (rsResultado.getRowCount() > 0)) {
            Object o = null;

            for (int i = 0; i < rsResultado.getRowCount(); i++) {
                uniAdm.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                uniAdm.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                uniAdm.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                uniAdm.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                fechaContacto = (Date) rsResultado.getValueAt(i, "FECHACONTACTO");

                if (rsResultado.getValueAt(i, "OID_CLIE") != null) {
                    Aux = new Long(((BigDecimal) rsResultado.getValueAt(i, "OID_CLIE")).toString());
                }

                if (!Aux.equals(ultConsultoraProcesada)) {
                    if (ultConsultoraProcesada != null) {
                        arraryPeriodosAVerificar = this.obtenerPeridosAVerificar(periodosConcurso, ultFechaContactoProcesada,
                                                                                 periodoCierre.getFechaHasta());

                        if (this.esConstante(arraryPeriodosAVerificar, mapPedidos).booleanValue()) {
                            cantConstantes++;
                        }

                        if (this.esActiva(arraryPeriodosAVerificar, mapPedidos).booleanValue()) {
                            cantActivas++;
                        }
                        
                        mapPedidos = new HashMap();
                    }

                    ultConsultoraProcesada = Aux;
                    ultFechaContactoProcesada = fechaContacto;
                }

                if (!uniAdm.equalsUA(ultUniAdmProcesada)) {
                    if (ultUniAdmProcesada != null) {
                        gerConcVarVentRank.setVariableResultado(ultUniAdmProcesada, ConstantesRanking.VAR_VTA_RANK_CONSTANCIA,
                                                                new BigDecimal(Integer.toString(cantConstantes)));

                        gerConcVarVentRank.setVariableResultado(ultUniAdmProcesada, ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES,
                                                                (Object) new Integer(cantActivas));
                    }

                    // Modificado por Diego Morello - 14/07/2005
                    // Las siguientes tres líneas no van fuera del IF
                    cantActivas = 0;
                    cantConstantes = 0;
                    // vbongiov -- 7/11/2006
                    ultUniAdmProcesada = (UnidadAdministrativa)deepCopy(uniAdm);
                }

                if (rsResultado.getValueAt(i, "OID_PERI") != null) {
                    mapPedidos.put(new Long(((BigDecimal) rsResultado.getValueAt(i, "OID_PERI")).toString()),
                                   new Long(((BigDecimal) rsResultado.getValueAt(i, "OID_PERI")).toString()));
                }
                
            } //fin lazo....
            
            // Evalua el ultimo/os registros no procesdos
            arraryPeriodosAVerificar = this.obtenerPeridosAVerificar(periodosConcurso, fechaContacto, periodoCierre.getFechaHasta());

            if (this.esConstante(arraryPeriodosAVerificar, mapPedidos).booleanValue()) {
                cantConstantes++;
            }

            if (this.esActiva(arraryPeriodosAVerificar, mapPedidos).booleanValue()) {
                cantActivas++;
            }

            gerConcVarVentRank.setVariableResultado(uniAdm, ConstantesRanking.VAR_VTA_RANK_CONSTANCIA,
                                                    new BigDecimal(Integer.toString(cantConstantes)));
            gerConcVarVentRank.setVariableResultado(uniAdm, ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES, new Integer(cantActivas));
           
        } //fin , rsResultado no vacio....

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularActivasFinalesConstanciaRanking(GerenteConcursoVariablesVentaRanking gerConcVarVentRank, Periodo periodoCierre):Salida");
    }

    /**
    * @return Void
    * @version 1.00 29/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo verifica si una consultora fue activa durante un concurso.
    * Para ello revisa que la consultora no tenga dos periodos consecutivos si haber pasado
    * solicitudes
    */
    public Boolean esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Entrada");
       
        UtilidadesLog.debug("dentro de esActiva, recibo : " + arraryPeriodosAVerificar + " y el hash, es: " + mapPedidos);
        // vbongiov -- BELC300024307 -- 9/10/2006
        if ((arraryPeriodosAVerificar != null) && (arraryPeriodosAVerificar.size() > 0)) {
        
            int ultimaPosicion = arraryPeriodosAVerificar.size() - 1;
        
            if(ultimaPosicion >= 0){
                Periodo registro = (Periodo) arraryPeriodosAVerificar.get(ultimaPosicion);

                if (mapPedidos.containsKey(registro.getOidPeriodo())) {
                    UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida TRUE 1");
                    return Boolean.TRUE;
                    
                } else if (ultimaPosicion >= 1){
                    registro = (Periodo) arraryPeriodosAVerificar.get(ultimaPosicion-1);

                    if (mapPedidos.containsKey(registro.getOidPeriodo())) {
                        UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida TRUE 2");
                        return Boolean.TRUE;
                    // vbongiov -- DBLG700000255 -- 15/01/2007    
                    } else {
                        UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida FALSE 2");
                        return Boolean.FALSE;
                    }
                } else {
                    UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida FALSE 1");
                    return Boolean.FALSE;
                }
            } else {
                UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida FALSE 3");
                return Boolean.FALSE;
            }
        }
        
        UtilidadesLog.info("VariablesVentaRankingHelper.esActiva(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida FALSE 4");
        return Boolean.FALSE;
    }

    /**
    * @return Void
    * @version 1.00 29/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo verifica si una consultora fue constante durante un concurso.
    * Para ello revisa que la consultora haya pasado solicitudes en todos los periodos
    */
    public Boolean esConstante(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.esConstante(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Entrada");
        UtilidadesLog.debug("dentro de esConstante, recibo : " + arraryPeriodosAVerificar + " y el hash, es: " + mapPedidos);

        if (arraryPeriodosAVerificar.size() == mapPedidos.size()) {
            UtilidadesLog.info("VariablesVentaRankingHelper.esConstante(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida");
            return new Boolean(true);
        } else {
            UtilidadesLog.info("VariablesVentaRankingHelper.esConstante(ArrayList arraryPeriodosAVerificar, HashMap mapPedidos):Salida");
            return new Boolean(false);
        }
    }

    /**
    * @return Void
    * @version 1.00 29/06/2005
    * @author: Sergio Saavedra
    * Descripción: Este metodo retorna un array de periodos con los periodos del concurso
    * que estan entre la fecha de primer contacto del cliente y la fecha de cierre
    */
    public ArrayList obtenerPeridosAVerificar(ArrayList periodosConcurso, Date fechaContacto, Date fechaCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.obtenerPeridosAVerificar(ArrayList periodosConcurso, Date fechaContacto, Date fechaCierre):Entrada");
        UtilidadesLog.debug("dentro de obtenerPeridosAVerificar, recibo : " + periodosConcurso + " f contacto: " + fechaContacto + " f cierre: " +
                           fechaCierre);

        ArrayList periodosARetornar = new ArrayList();

        if (fechaContacto == null) {
            if ((periodosConcurso != null) && (periodosConcurso.size() > 0)) {
                for (int j = 0; j < periodosConcurso.size(); j++) {
                    Periodo registro = (Periodo) periodosConcurso.get(j);

                    if (registro.getFechaHasta().getTime() <= fechaCierre.getTime()) {
                        periodosARetornar.add(registro);
                    }
                }
            }
        } else {
            if ((periodosConcurso != null) && (periodosConcurso.size() > 0)) {
                for (int j = 0; j < periodosConcurso.size(); j++) {
                    Periodo registro = (Periodo) periodosConcurso.get(j);

                    if ((registro.getFechaDesde().getTime() >= fechaContacto.getTime()) &&
                            (registro.getFechaHasta().getTime() <= fechaCierre.getTime())) {
                        periodosARetornar.add(registro);
                    }
                }
            }
        }

        UtilidadesLog.debug("antes de ordenar: " + periodosARetornar);

        ComparadorPeriodos comparator = new ComparadorPeriodos();
        Collections.sort(periodosARetornar, comparator);
        UtilidadesLog.debug("luego de ordenar: " + periodosARetornar);
        UtilidadesLog.info("VariablesVentaRankingHelper.obtenerPeridosAVerificar(ArrayList periodosConcurso, Date fechaContacto, Date fechaCierre):Salida");
        return periodosARetornar;
    }

    /**
     * Este metodo obtiene la cantidad de clientes incialmente activos relacionados
     * con el gerente y almacena los resultados en el objeto de la clase
     * GerenteConcursoVariablesVentaRanking pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   04/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularActivasInicialesRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularActivasInicialesRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank):Entrada");

        VariablesVentaHelper vvHelper = new VariablesVentaHelper();
        Long oidPeriodoDesde = gerConcVarVtaRank.getPeriodoDesde().getOidPeriodo();
        ArrayList arrPer = vvHelper.obtenerPeriodosAnteriores(oidPeriodoDesde, this.CANTIDAD_PERIODOS_ACTIVAS_INICIALES);

        DAOCalculoVariablesVentaRanking dao = new DAOCalculoVariablesVentaRanking();
        UnidadAdministrativa uniAdm = gerConcVarVtaRank.getUnidadAdministrativaGerente();
        RecordSet rsResultado = dao.recuperarActivasPorPeriodo(uniAdm, arrPer, gerConcVarVtaRank.getConcurso());

        int rows = rsResultado.getRowCount();
        Object o = null;

        for (int i = 0; i < rows; i++) {
            UnidadAdministrativa unidad = new UnidadAdministrativa();
  
            unidad.setOidSubgerencia(((o = rsResultado.getValueAt(i, "OID_SUBG_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            unidad.setOidRegion(((o = rsResultado.getValueAt(i, "OID_REGI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            unidad.setOidZona(((o = rsResultado.getValueAt(i, "OID_ZONA")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            unidad.setOidSeccion(((o = rsResultado.getValueAt(i, "OID_SECC")) != null) ? new Long(((BigDecimal) o).toString()) : null);
           
            // Almaceno en gerConcVarVtaRank
            BigDecimal decCount = (BigDecimal) rsResultado.getValueAt(i, "COUNT");
            Long count = new Long(decCount.longValue());
            gerConcVarVtaRank.setVariableResultado(unidad, ConstantesRanking.VAR_VTA_RANK_ACTIVAS_INICIALES, count);
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularActivasInicialesRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank):Salida");
    }

    public void calcularVentasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularVentasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank):Entrada");

        DAOCalculoVariablesVentaRanking dao = new DAOCalculoVariablesVentaRanking();
        RecordSet rsMontoUnidades = null;

        Long gerente = gerConcVarVtaRank.getGerente();
        Long concurso = gerConcVarVtaRank.getConcurso();
        Periodo periodoDesde = gerConcVarVtaRank.getPeriodoDesde();
        Periodo periodoHasta = gerConcVarVtaRank.getPeriodoHasta();
        UnidadAdministrativa uniAdm = gerConcVarVtaRank.getUnidadAdministrativaGerente();

        // Recupero monto y unidades
        if (gerConcVarVtaRank.getIndProductosExigidos()) {
            rsMontoUnidades = dao.recuperarMontoUnidadesConExigencias(gerente, concurso, periodoDesde, periodoHasta, uniAdm);
        } else {
            rsMontoUnidades = dao.recuperarMontoUnidadesSinExigencias(gerente, concurso, periodoDesde, periodoHasta, uniAdm);
        }

        int rows = rsMontoUnidades.getRowCount();

        for (int i = 0; i < rows; i++) {
            UnidadAdministrativa unidadAdm = new UnidadAdministrativa();

            // Tomo información del registro
            BigDecimal decOidSubgerencia = (BigDecimal) rsMontoUnidades.getValueAt(i, "OID_SUBG_VENT");
            BigDecimal decOidRegion = (BigDecimal) rsMontoUnidades.getValueAt(i, "OID_REGI");
            BigDecimal decOidZona = (BigDecimal) rsMontoUnidades.getValueAt(i, "OID_ZONA");
            BigDecimal decOidSeccion = (BigDecimal) rsMontoUnidades.getValueAt(i, "OID_SECC");
            BigDecimal decUnidades = (BigDecimal) rsMontoUnidades.getValueAt(i, "UNIDADES");
            BigDecimal monto = (BigDecimal) rsMontoUnidades.getValueAt(i, "MONTO");

            // Preparo la información para asignarla a unidadAdm
            Long unidades = new Long(decUnidades.longValue());
            
            unidadAdm.setOidSubgerencia(  decOidSubgerencia!=null?  new Long(decOidSubgerencia.longValue()) :null);
            unidadAdm.setOidRegion(       decOidRegion!=null?       new Long(decOidRegion.longValue())      :null);
            unidadAdm.setOidZona(         decOidZona!=null?         new Long(decOidZona.longValue())        :null);
            unidadAdm.setOidSeccion(      decOidSeccion!=null?      new Long(decOidSeccion.longValue())     :null);
           
            // Asigno...
            gerConcVarVtaRank.setVariableResultado(unidadAdm, ConstantesRanking.VAR_VTA_RANK_VENTAS, monto);
            gerConcVarVtaRank.setVariableResultado(unidadAdm, ConstantesRanking.VAR_VTA_RANK_UNIDADES, unidades);
        }

        UtilidadesLog.info("VariablesVentaRankingHelper.calcularVentasRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank):Salida");
    }

    /**
     * Este metodo se encarga de calcular el porcentaje de cobranza y almacena
     * los resultados en el objeto de la clase GerenteConcursoVariablesVentaRanking
     * pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   12/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularPorcentajeCobranzaRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank)
            throws MareException {
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeCobranzaRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank):Entrada");
        UtilidadesLog.debug("Empezo calcularPorcentajeCobranzaRanking con GerenteConcursoVariablesVentaRanking: " + gerConcVarVtaRank);
        
        DAOVariablesVentaRanking daoVar = new DAOVariablesVentaRanking();
        Long diasGracia = daoVar.recuperarDiasGracia(gerConcVarVtaRank.getConcurso());
        
        if(diasGracia==null) {
            diasGracia = Long.valueOf("0"); 
        }

        DAOCalculoVariablesVentaRanking daoCalc = new DAOCalculoVariablesVentaRanking();
        HashMap consultorasConMovimientos = daoCalc.recuperarCantidadConsultorasConMovimientos(gerConcVarVtaRank.getUnidadAdministrativaGerente(),
                                                                                               gerConcVarVtaRank.getPeriodoDesde(),
                                                                                               gerConcVarVtaRank.getPeriodoHasta(), diasGracia,
                                                                                               Boolean.FALSE, gerConcVarVtaRank.getConcurso() );
        HashMap consultorasConMovimientosVencidos = daoCalc.recuperarCantidadConsultorasConMovimientos(gerConcVarVtaRank.getUnidadAdministrativaGerente(),
                                                                                                       gerConcVarVtaRank.getPeriodoDesde(),
                                                                                                       gerConcVarVtaRank.getPeriodoHasta(),
                                                                                                       diasGracia, Boolean.TRUE, gerConcVarVtaRank.getConcurso());

        // Recorro las consultoras con movimientos
        Iterator it = consultorasConMovimientos.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();

            Integer cantConsSinVenc = null;

            if (consultorasConMovimientosVencidos.containsKey(entry.getKey())) {
                int value = ((Integer) entry.getValue()).intValue();
                int valueVenc = ((Integer) consultorasConMovimientosVencidos.get(entry.getKey())).intValue();
                cantConsSinVenc = new Integer(value - valueVenc);
            } else {
                cantConsSinVenc = (Integer) entry.getValue();
            }

            BigDecimal aux1 = new BigDecimal(cantConsSinVenc.toString());
            BigDecimal aux2 = new BigDecimal(entry.getValue().toString());
            BigDecimal valor = null;

            if (aux2.equals(new BigDecimal("0"))) {
                valor = new BigDecimal("0");
            } else {
                valor = aux1.divide(aux2, 2, BigDecimal.ROUND_HALF_UP);
            }

            gerConcVarVtaRank.setVariableResultado((UnidadAdministrativa) entry.getKey(), ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_COBRANZA, valor);
        }
        UtilidadesLog.info("VariablesVentaRankingHelper.calcularPorcentajeCobranzaRanking(GerenteConcursoVariablesVentaRanking gerConcVarVtaRank):Salida");
    }
    
    /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.info("MONVariablesVentaBean.deepCopy(Object oldObj):Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
 
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
 
            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            UtilidadesLog.info("MONVariablesVentaBean.deepCopy(Object oldObj):Salida");
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.error("ERROR ", e);
            UtilidadesLog.debug("Exception en deepCopy = " + e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                UtilidadesLog.debug("Exception en deepCopy = " + ex);
                throw new MareException(ex);
            }
        }
    }
}
