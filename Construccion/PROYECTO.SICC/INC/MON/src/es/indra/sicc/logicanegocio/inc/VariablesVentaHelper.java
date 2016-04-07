package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.inc.DTOResultadoConcursoVariablesVenta;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;

public class VariablesVentaHelper {
    private static final int CANTIDAD_PERIODOS_ACTIVAS = 3;

    /**
    * @return GerenteVariablesVenta
    * @version 1.00 10/06/2005
    * @author: Carlos Leal
    * Descripcion: recupera los atributos de un gerente.
    */
    public GerenteVariablesVenta recuperarGerente(Long oidGerente, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.recuperarGerente(Long oidGerente, Periodo periodoCierre): Entrada");

        GerenteVariablesVenta gerVarVta = new GerenteVariablesVenta();
        DAOGerentes dao = new DAOGerentes();
        gerVarVta.setOidGerente(oidGerente);
        gerVarVta.setUnidadesGerenciadas(dao.obtenerUnidadesAdministrativasGerente(periodoCierre.getOidPais(), periodoCierre.getOidMarca(),
                                                                                   periodoCierre.getOidCanal(), oidGerente));
                                                                                   
        UtilidadesLog.info("VariablesVentaHelper.recuperarGerente(Long oidGerente, Periodo periodoCierre): Salida");

        return gerVarVta;
    }

    /**
    * @return Integer
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: este metodo obtiene la cantidad de clientes incialmente activos relacionados con el gerente.
    */
    public Integer obtenerActivasIniciales(GerenteVariablesVenta gerVarVta, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerActivasIniciales(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Entrada");

        VariablesVentaHelper variablesVentaHelper = new VariablesVentaHelper();
        ArrayList arrPer = new ArrayList();
        DAOCalculoVariablesVenta dao = new DAOCalculoVariablesVenta();
        Integer resultado;

        arrPer = variablesVentaHelper.obtenerPeriodosAnteriores(periodoCierre.getOidPeriodo(), CANTIDAD_PERIODOS_ACTIVAS);

        resultado = dao.recuperarCantidadActivasIniciales(gerVarVta.getUnidadesGerenciadas(), arrPer);

        UtilidadesLog.info("VariablesVentaHelper.obtenerActivasIniciales(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Salida");

        return resultado;
    }

    /**
    * @return ArrayList
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: este metodo retorna un ArrayList de objetos de la clase periodo correspondientes al periodo de calculo y sus
    * periodos anteriores para hacer la validacion de activas iniciales y finales.
    */
    public ArrayList obtenerPeriodosAnteriores(Long oidPeriodoCalculo, int cantPeriodos)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerPeriodosAnteriores(Long oidPeriodoCalculo, int cantPeriodos): Entrada");

        ArrayList arrPeriodos = new ArrayList();
        DAOClientePremiacion dao = new DAOClientePremiacion();

        for (int i = 0; i <= cantPeriodos; i++) {
            arrPeriodos.add(dao.obtenerPeriodo(oidPeriodoCalculo, (-1) * i));
        }

        UtilidadesLog.info("VariablesVentaHelper.obtenerPeriodosAnteriores(Long oidPeriodoCalculo, int cantPeriodos): Salida");

        return arrPeriodos;
    }

    /**
    * @return Integer
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: este metodo obtiene la cantidad de clientes activos finales relacionados con el gerente.
    */
    public Integer obtenerActivasFinales(GerenteVariablesVenta gerVarVta, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerActivasFinales(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Entrada");

        VariablesVentaHelper variablesVentaHelper = new VariablesVentaHelper();
        ArrayList arrPer = new ArrayList();
        DAOCalculoVariablesVenta dao = new DAOCalculoVariablesVenta();
        Integer resultado;

        arrPer = variablesVentaHelper.obtenerPeriodosAnteriores(periodoCierre.getOidPeriodo(), CANTIDAD_PERIODOS_ACTIVAS);
        resultado = dao.recuperarCantidadActivasFinales(gerVarVta.getUnidadesGerenciadas(), arrPer);

        UtilidadesLog.info("VariablesVentaHelper.obtenerActivasFinales(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Salida");

        return resultado;
    }

    /**
    * @return Integer
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    */
    public Integer obtenerEntregadas(GerenteVariablesVenta gerVarVta, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerEntregadas(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Entrada");

        DAOClientePremiacion dao = new DAOClientePremiacion();
        DAOCalculoVariablesVenta daoCalcu = new DAOCalculoVariablesVenta();
        Periodo periodoAnterior = dao.obtenerPeriodo(periodoCierre.getOidPeriodo(), -1);

        Integer cantReg = daoCalcu.recuperarEntregadas(gerVarVta, periodoAnterior);
        UtilidadesLog.debug("****Cantidad de registros: " + cantReg);
        UtilidadesLog.info("VariablesVentaHelper.obtenerEntregadas(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Salida");

        return cantReg;
    }

    /**
    * @return Integer
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: obtiene el valor de capitalizacion segun los valores recibidos por parametro.
    */
    public Integer obtenerCapitalizacion(ResultadoVariablesVenta resVarVta) {
        UtilidadesLog.info("VariablesVentaHelper.obtenerCapitalizacion(ResultadoVariablesVenta resVarVta): Entrada");

        //Implementacion: Retornar resVarVta.activasFinales - resVarVta.activasIniciales
        Integer resultado = new Integer(((resVarVta.getActivasFinales() != null) ? resVarVta.getActivasFinales().intValue() : 0) -
                                        ((resVarVta.getActivasIniciales() != null) ? resVarVta.getActivasIniciales().intValue() : 0));

        UtilidadesLog.info("VariablesVentaHelper.obtenerCapitalizacion(ResultadoVariablesVenta resVarVta): Salida");

        return resultado;
    }

    /**
    * @return Double
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripción: Calcula la retención, es decir el número de activas del periodo
    * actual dividido el número de activas en el último periodo del ejecicio anterior.
    * Modificado: Carlos Leal Inc 19191
    */
    public Double obtenerRetencion(GerenteVariablesVenta gerVarVta, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerRetencion(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Entrada");

        DAOCargaVariablesVenta dao = new DAOCargaVariablesVenta();
        Integer activasFinalesActuales;
        Periodo periodoEjercicioAnterior;
        Integer activasFinalesAnteriores;
        double resultado;

        activasFinalesActuales = obtenerActivasFinales(gerVarVta, periodoCierre);

        UtilidadesLog.debug("****activasFinalesActuales: " + activasFinalesActuales);
        periodoEjercicioAnterior = dao.obtenerUltimoPeriodoEjercicioAnterior(periodoCierre);
        UtilidadesLog.debug("****periodoEjercicioAnterior: " + periodoEjercicioAnterior);
        activasFinalesAnteriores = obtenerActivasFinales(gerVarVta, periodoEjercicioAnterior);
        UtilidadesLog.debug("****activasFinalesAnteriores: " + activasFinalesAnteriores);

        if ((activasFinalesAnteriores != null) && (activasFinalesAnteriores.intValue() != 0) && (activasFinalesActuales != null)) {
            resultado = (activasFinalesActuales.doubleValue() / activasFinalesAnteriores.doubleValue()) * 100;
        } else {
            UtilidadesLog.debug("****resultado: 0");
            UtilidadesLog.info("VariablesVentaHelper.obtenerRetencion(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Salida");

            return new Double(0);
        }

        UtilidadesLog.debug("****resultado: " + resultado);
        UtilidadesLog.info("VariablesVentaHelper.obtenerRetencion(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Salida");

        return new Double(resultado);
    }

    /**
    * @return BigDecimal
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: calcula el precio promedio unitario para los valores recibidos por parametro.
    * Modificado: Carlos Leal Inc 19192 e Inc 19641
    */
    public void obtenerPrecioPromedioUnitario(DTOResultadoConcursoVariablesVenta dtoRes)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerPrecioPromedioUnitario(DTOResultadoConcursoVariablesVenta dtoRes): Entrada");

        BigDecimal resultado = null;
        
        UtilidadesLog.debug("dtoRes.getTotalUnidadesVendidas(): " + dtoRes.getTotalUnidadesVendidas());
        UtilidadesLog.debug("dtoRes.getTotalVentaNetaEstadisticable(): " + dtoRes.getTotalVentaNetaEstadisticable());

        if ((dtoRes.getTotalUnidadesVendidas() != null) && (dtoRes.getTotalUnidadesVendidas().intValue() != 0) &&
                (dtoRes.getTotalVentaNetaEstadisticable() != null)) {
            resultado = new BigDecimal((dtoRes.getTotalVentaNetaEstadisticable()).doubleValue() / (dtoRes.getTotalUnidadesVendidas()).doubleValue());
        } else {
            resultado = new BigDecimal(0);
            UtilidadesLog.debug("****Resultado: 0");
            UtilidadesLog.info("VariablesVentaHelper.obtenerPrecioPromedioUnitario(DTOResultadoConcursoVariablesVenta dtoRes): Salida");
        }

        UtilidadesLog.debug("****Resultado: " + resultado);
        UtilidadesLog.info("VariablesVentaHelper.obtenerPrecioPromedioUnitario(DTOResultadoConcursoVariablesVenta dtoRes): Salida");

        //Cleal Inc 19641
        dtoRes.setPrecioPromedioUnitario(resultado);
    }

    /**
    * @return void
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: calcula el promedio de venta por pedido.
    * Modificado: Carlos Leal Inc 19193 y Inc 19641
    */
    public void obtenerPromedioVentaPedidos(DTOResultadoConcursoVariablesVenta dtoRes)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.generarRegistroCC(DTOFACConsolidado dtoConso): Entrada");

        //Implementacion: Retornar dtoRes.totalVentaNetaEstadisticable / dtoRes.numeroPedidos.
        BigDecimal resultado = null;

        if ((dtoRes.getNumeroPedidos() != null) && ((dtoRes.getNumeroPedidos()).intValue() != 0) &&
                (dtoRes.getTotalVentaNetaEstadisticable() != null)) {
            resultado = new BigDecimal((dtoRes.getTotalVentaNetaEstadisticable()).doubleValue() / (dtoRes.getNumeroPedidos()).doubleValue());
        } else {
            //Cleal Inc 19641
            resultado = new BigDecimal(0);
            UtilidadesLog.debug("****Resultado: 0");

            //Cleal Inc 19641
            UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioVentaPedidos(DTOResultadoConcursoVariablesVenta dtoRes): Salida");
        }

        UtilidadesLog.debug("****Resultado: " + resultado);

        //Cleal Inc 19641
        dtoRes.setPromedioVentaPedidos(resultado);
        UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioVentaPedidos(DTOResultadoConcursoVariablesVenta dtoRes): Salida");
    }

    /**
    * @return void
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: calcula la venta promedio de unidades.
    */
    public void obtenerPromedioUnidadesPedidos(DTOResultadoConcursoVariablesVenta dtoRes)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioUnidadesPedidos(DTOResultadoConcursoVariablesVenta dtoRes): Entrada");

        Double resultado = null;

        if ((dtoRes.getNumeroPedidos() != null) && (dtoRes.getNumeroPedidos().intValue() != 0) && (dtoRes.getTotalUnidadesVendidas() != null)) {
            resultado = new Double((dtoRes.getTotalUnidadesVendidas()).doubleValue() / (dtoRes.getNumeroPedidos()).doubleValue());

            //Cleal Inc 19641
            dtoRes.setPromedioUnidadesPedidos(resultado);
            UtilidadesLog.debug("****Resultado: " + resultado);
            UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioUnidadesPedidos(DTOResultadoConcursoVariablesVenta dtoRes): Salida");
        } else {
            //Cleal Inc 19641
            dtoRes.setPromedioUnidadesPedidos(new Double(0));
            UtilidadesLog.debug("****Resultado: 0");
            UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioUnidadesPedidos(DTOResultadoConcursoVariablesVenta dtoRes): Salida");
        }
    }

    /**
    * @return Double
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: calcula el porcentaje de actividad de las consultoras activas.
    * Modificado: Carlos Leal Inc 19196 y Inc  19641
    */
    public void obtenerPorcentajeActividad(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerPorcentajeActividad(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Entrada");

        Double resultado = null;

        //Implementacion:Retornar (dtoRes.numeroPedidos / gerVarVta.resultadosVariables.activasFinales) * 100
        if ((gerVarVta.getResultadosVariables().getActivasFinales() != null) &&
                (gerVarVta.getResultadosVariables().getActivasFinales().intValue() != 0) && (dtoRes.getNumeroPedidos() != null)) {
            resultado = new Double((dtoRes.getNumeroPedidos().doubleValue() / gerVarVta.getResultadosVariables().getActivasFinales().doubleValue()) * 100);
            UtilidadesLog.debug("****resultado: " + resultado);

            //Cleal Inc 19641
            dtoRes.setPorcentajeActividad(resultado);
            UtilidadesLog.info("VariablesVentaHelper.obtenerPorcentajeActividad(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Salida");
        } else {
            UtilidadesLog.info("VariablesVentaHelper.obtenerPorcentajeActividad(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Salida");
            dtoRes.setPorcentajeActividad(new Double(0));
        }
    }

    /**
    * @return void
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: calcula el promedio de solicitudes por pedidos.
    * Modificado: Carlos Leal Inc 19197 y Inc 19641
    */
    public void obtenerPromedioOrdenesPedidos(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioOrdenesPedidos(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Entrada");

        //Implementacion:Retornar gerVarVta.resultadosVariables.numeroOrdenes/ dtoRes.numeroPedidos
        Double resultado = null;

        if ((dtoRes.getNumeroPedidos() != null) && (dtoRes.getNumeroPedidos().intValue() != 0) &&
                (gerVarVta.getResultadosVariables().getNumeroOrdenes() != null)) {
            resultado = new Double(gerVarVta.getResultadosVariables().getNumeroOrdenes().doubleValue() / dtoRes.getNumeroPedidos().doubleValue());
            UtilidadesLog.debug("****resultado: " + resultado);

            //Cleal 19641
            dtoRes.setPromedioOrdenesPedidos(resultado);
            UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioOrdenesPedidos(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Salida");
        } else {
            dtoRes.setPromedioOrdenesPedidos(new Double(0));
            UtilidadesLog.info("VariablesVentaHelper.obtenerPromedioOrdenesPedidos(DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Salida");
        }
    }

    /**
    * @return Integer
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: obtiene el numero de solicitudes de los clientes asociados a un gerente.
    */
    public Integer obtenerNumeroSolicitudes(GerenteVariablesVenta gerVarVta, Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerNumeroSolicitudes(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Entrada");

        VariablesVentaHelper variablesVentaHelper = new VariablesVentaHelper();
        ArrayList arrPer = new ArrayList();
        DAOCalculoVariablesVenta dao = new DAOCalculoVariablesVenta();
        Integer nroSolicitudes = null;

        arrPer = variablesVentaHelper.obtenerPeriodosAnteriores(periodoCierre.getOidPeriodo(), CANTIDAD_PERIODOS_ACTIVAS);
        nroSolicitudes = new Integer((dao.recuperarCantidadSolicitudes(gerVarVta.getUnidadesGerenciadas(), arrPer)).intValue());

        UtilidadesLog.info("VariablesVentaHelper.obtenerNumeroSolicitudes(GerenteVariablesVenta gerVarVta, Periodo periodoCierre): Salida");

        return nroSolicitudes;
    }

    /**
    * @return void
    * @version 1.00 14/06/2005
    * @author: Carlos Leal
    * Descripcion: este método determina si un gerente es ganador e invoca al método de grabacion en la
    * entidad INC:CandidataGanadora
    **/
    public void determinarGanadoras(InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.determinarGanadoras(InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Entrada");

        DAOCargaVariablesVenta dao = new DAOCargaVariablesVenta();

        if (cumpleTipoDeterminacion(infoGerConc, dtoRes.getOidConcurso(), gerVarVta.getOidGerente())) {
            UtilidadesLog.debug("cumple cumpleTipoDeterminacion");
            if(this.esGerenteGanador(infoGerConc, dtoRes, gerVarVta)) {
                UtilidadesLog.debug("esGerenteGanador");
                dao.guardarCandidatoGanador(infoGerConc, dtoRes, gerVarVta);
            }
        }

        UtilidadesLog.info("VariablesVentaHelper.determinarGanadoras(InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Salida");
    }

    /**
    * @return boolean
    * @version 1.00 14/06/2005
    * @author: Carlos Leal
    * Descripcion: determina si el gerente recibido por parametro es ganador para el concurso recibido por parametro.
    **/
    private boolean cumpleTipoDeterminacion(InfoGerentesConcursos infoGerConc, Long oidConcurso, Long oidGerente)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.cumpleTipoDeterminacion(InfoGerentesConcursos infoGerConc, Long oidConcurso, Long oidGerente): Entrada");
        /*
          1.- Obtener gerVarVta = infoGerConc.getGerente(oidGerente)
          2.- Obtener concurso = infoGerConc.getConcurso(oidConcurso)
          3.- Si concurso.oidTipoDeterminacionMeta == ConstantesINC.TIPO_DETERMINACION_METAS_FINAL_CONCURSO
          Si !infoGerConc.periodoCierre.equals(concurso.periodoHasta)
          retornar false
          FSi
          FSi
          Si concurso.oidTipoDeterminacionMeta == ConstantesINC.TIPO_DETERMINACION_METAS_BONO_ANUAL
          Si !infoGerConc.contienePeriodoControl(oidConcurso)
          retornar false
          FSi
          FSi
          4.- Retornar true.
         */
        GerenteVariablesVenta gerVarVta;
        ConcursoVariablesVenta concurso;

        gerVarVta = infoGerConc.getGerente(oidGerente);
        concurso = infoGerConc.getConcurso(oidConcurso);
        
        UtilidadesLog.debug("oidGerente: " + oidGerente);
        UtilidadesLog.debug("oidConcurso: " + oidConcurso);
        UtilidadesLog.debug("concurso.getOidTipoDeterminacionMeta(): " + concurso.getOidTipoDeterminacionMeta());

        if (concurso.getOidTipoDeterminacionMeta().equals(ConstantesINC.TIPO_DETERMINACION_METAS_FINAL_CONCURSO)) {
            if (!infoGerConc.getPeriodoCierre().getOidPeriodo().equals(concurso.getPeriodoHasta().getOidPeriodo())) {
                return false;
            }
        }

        if (concurso.getOidTipoDeterminacionMeta().equals(ConstantesINC.TIPO_DETERMINACION_METAS_BONO_ANUAL)) {
            if (!infoGerConc.contenidoEnPeriodoControl(oidConcurso)) {
                return false;
            }
        }

        UtilidadesLog.info("VariablesVentaHelper.cumpleTipoDeterminacion(InfoGerentesConcursos infoGerConc, Long oidConcurso, Long oidGerente): Salida");

        return true;
    }

    /**
    * @return BigDecimal
    * @version 1.00 14/06/2005
    * @author: Carlos Leal
    * Descripcion: obtiene el valor de rotacion del gerente recibido por parametro.
    * Modificado: Carlos Leal Inc 19215
    **/
    public BigDecimal obtenerRotacion(GerenteVariablesVenta gerVarVta) {
        UtilidadesLog.info("VariablesVentaHelper.obtenerRotacion(GerenteVariablesVenta gerVarVta): Entrada");

        //Retornar: (gerVarVta.resultadosVariables.egresos - gerVarVta.resultadosVariables.reingresos) / 
        //gerVarVta.resultadosVariables.activasIniciales
        if ((gerVarVta.getResultadosVariables().getActivasIniciales() != null) && (gerVarVta.getResultadosVariables().getEgresos() != null) &&
                (gerVarVta.getResultadosVariables().getReingresos() != null) &&
                (gerVarVta.getResultadosVariables().getActivasIniciales().intValue() != 0)) {
            BigDecimal rotacion = new BigDecimal((gerVarVta.getResultadosVariables().getEgresos().doubleValue() -
                                                 gerVarVta.getResultadosVariables().getReingresos().doubleValue()) / gerVarVta.getResultadosVariables()
                                                                                                                              .getActivasIniciales()
                                                                                                                              .doubleValue());
            UtilidadesLog.debug("****rotacion: " + rotacion);
            UtilidadesLog.info("VariablesVentaHelper.obtenerRotacion(GerenteVariablesVenta gerVarVta): Salida");

            return rotacion;
        } else {
            UtilidadesLog.debug("****rotacion: 0");
            UtilidadesLog.info("VariablesVentaHelper.obtenerRotacion(GerenteVariablesVenta gerVarVta): Salida");

            return new BigDecimal(0);
        }
    }

    /**
    * @return boolean
    * @version 1.00 15/06/2005
    * @author: Carlos Leal
    * Descripcion: determina si el gerente recibido es ganador.
    **/
    private boolean esGerenteGanador(InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.esGerenteGanador(InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta gerVarVta): Entrada");

        DAOCalculoVariablesVenta dao = new DAOCalculoVariablesVenta();
        MetasVentaProyectada mtasVtaProy = new MetasVentaProyectada();
        ConcursoVariablesVenta concVarVta = infoGerConc.getConcurso(dtoRes.getOidConcurso());
        
        UtilidadesLog.debug("concVarVta.getOidConcurso(): " + concVarVta.getOidConcurso());
        UtilidadesLog.debug("concVarVta.getPeriodosControl(): " + concVarVta.getPeriodosControl());        

        if (concVarVta.getOidTipoDeterminacionMeta().equals(ConstantesINC.TIPO_DETERMINACION_METAS_POR_PERIODO)) {
            UtilidadesLog.debug("****Entro por TIPO_DETERMINACION_METAS_POR_PERIODO");
            mtasVtaProy = dao.recuperarMetasGerenteConcurso(gerVarVta, concVarVta, infoGerConc.getPeriodoCierre(), infoGerConc.getPeriodoCierre());
        }

        if (concVarVta.getOidTipoDeterminacionMeta().equals(ConstantesINC.TIPO_DETERMINACION_METAS_FINAL_CONCURSO)) {
            UtilidadesLog.debug("****Entro por TIPO_DETERMINACION_METAS_FINAL_CONCURSO");
            mtasVtaProy = dao.recuperarMetasGerenteConcurso(gerVarVta, concVarVta,
                                                            concVarVta.getPeriodoDesde(),
                                                            concVarVta.getPeriodoHasta());
            dao.acumularResultadosGerenteConcurso(gerVarVta, concVarVta, dtoRes, infoGerConc);
        }
        
        if (concVarVta.getOidTipoDeterminacionMeta().equals(ConstantesINC.TIPO_DETERMINACION_METAS_BONO_ANUAL)) {
            UtilidadesLog.debug("****Entro por TIPO_DETERMINACION_METAS_BONO_ANUAL");
            mtasVtaProy = dao.recuperarMetasGerenteConcurso(gerVarVta, concVarVta, 
                                                            concVarVta.getPeriodoControlAnterior(infoGerConc.getPeriodoCierre(), concVarVta.getPeriodoDesde()), 
                                                            infoGerConc.getPeriodoCierre());
                                                
            dao.acumularResultadosGerenteConcurso(gerVarVta, concVarVta, dtoRes, infoGerConc);
        }        

        return cumpleVariables(dtoRes, gerVarVta.getResultadosVariables(), mtasVtaProy, concVarVta);
    }

    /**
    * @return boolean
    * @version 1.00 15/06/2005
    * @author: Carlos Leal
    * Descripcion: este método verifica si los resultados de variables de venta cumplen con las metas proyectadas.
    **/
    private boolean cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta,
                                    ConcursoVariablesVenta conc) {
        UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Entrada");
        
        if(metasVenta != null){

            //1.- Si concurso.ventaEstadisticable && !(dtoRes.totalVentaNetaEstadisticable < metasVenta.ventaNetaEstadisticable) 
            //entonces retornar false. 
            UtilidadesLog.debug("****cumple getVentaNetaEstadisticable? ****");
            UtilidadesLog.debug("conc.getVentaEstadisticable(): " + conc.getVentaEstadisticable());
            UtilidadesLog.debug("dtoRes.getTotalVentaNetaEstadisticable(): " + dtoRes.getTotalVentaNetaEstadisticable());
            UtilidadesLog.debug("metasVenta.getVentaNetaEstadisticable(): " + metasVenta.getVentaNetaEstadisticable());
            
            if ((conc.getVentaEstadisticable() != null) && (dtoRes.getTotalVentaNetaEstadisticable() != null) &&
                    (metasVenta.getVentaNetaEstadisticable() != null) && conc.getVentaEstadisticable().booleanValue() &&
                    dtoRes.getTotalVentaNetaEstadisticable().doubleValue() < metasVenta.getVentaNetaEstadisticable().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getVentaNetaEstadisticable ****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //2.- Si concurso.activas && !(resVar.activasIniciales < metasVenta.activasIniciales) entonces retornar false. 
            UtilidadesLog.debug("****cumple getActivasIniciales? ****");
            UtilidadesLog.debug("conc.getActivas(): " + conc.getActivas());
            UtilidadesLog.debug("resVar.getActivasIniciales(): " + resVar.getActivasIniciales());
            UtilidadesLog.debug("metasVenta.getActivasIniciales(): " + metasVenta.getActivasIniciales());
            
            if ((conc.getActivas() != null) && (resVar.getActivasIniciales() != null) && (metasVenta.getActivasIniciales() != null) &&
                    conc.getActivas().booleanValue() && resVar.getActivasIniciales().intValue() < metasVenta.getActivasIniciales().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getActivasIniciales****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //3.- Si concurso.ingreso && !(resVar.ingresos < metasVenta.ingresos) entonces retornar false. 
            UtilidadesLog.debug("****cumple getIngresos? ****");
            UtilidadesLog.debug("conc.getIngreso(): " + conc.getIngreso());
            UtilidadesLog.debug("resVar.getIngresos(): " + resVar.getIngresos());
            UtilidadesLog.debug("metasVenta.getIngresos(): " + metasVenta.getIngresos());
            
            if ((conc.getIngreso() != null) && (resVar.getIngresos() != null) && (metasVenta.getIngresos() != null) && conc.getIngreso().booleanValue() &&
                    resVar.getIngresos().intValue() < metasVenta.getIngresos().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getIngresos****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //4.- Si concurso.reingreso && !(resVar.reingresos < metasVenta.reingresos) entonces retornar false. 
            UtilidadesLog.debug("****cumple getReingresos? ****");
            UtilidadesLog.debug("conc.getReingreso(): " + conc.getReingreso());
            UtilidadesLog.debug("resVar.getReingresos(): " + resVar.getReingresos());
            UtilidadesLog.debug("metasVenta.getReingresos(): " + metasVenta.getReingresos());
            
            if ((conc.getReingreso() != null) && (resVar.getReingresos() != null) && (metasVenta.getReingresos() != null) &&
                    conc.getReingreso().booleanValue() && resVar.getReingresos().intValue() < metasVenta.getReingresos().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getReingresos****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //5.- Si concurso.egresos && !(resVar.egresos < metasVenta.egresos) entonces retornar false. 
            UtilidadesLog.debug("****cumple getEgresos? ****");
            UtilidadesLog.debug("conc.getEgresos(): " + conc.getEgresos());
            UtilidadesLog.debug("resVar.getEgresos(): " + resVar.getEgresos());
            UtilidadesLog.debug("metasVenta.getEgresos(): " + metasVenta.getEgresos());
            
            if ((conc.getEgresos() != null) && (resVar.getEgresos() != null) && (metasVenta.getEgresos() != null) && conc.getEgresos().booleanValue() &&
                    resVar.getEgresos().intValue() < metasVenta.getEgresos().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getEgresos****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //6.- Si concurso.entregadas && !(resVar.entregadas < metasVenta.numeroEntregadas) entonces retornar false. 
            UtilidadesLog.debug("****cumple getEntregadas? ****");
            UtilidadesLog.debug("conc.getEntregadas(): " + conc.getEntregadas());
            UtilidadesLog.debug("resVar.getEntregadas(): " + resVar.getEntregadas());
            UtilidadesLog.debug("metasVenta.getNumeroEntregadas(): " + metasVenta.getNumeroEntregadas());
            
            if ((conc.getEntregadas() != null) && (resVar.getEntregadas() != null) && (metasVenta.getNumeroEntregadas() != null) &&
                    conc.getEntregadas().booleanValue() && resVar.getEntregadas().intValue() < metasVenta.getNumeroEntregadas().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getEntregadas****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //7.- Si concurso.recibidas && !(resVar.recibidas < metasVenta.numeroRecibidas) entonces retornar false. 
            UtilidadesLog.debug("****cumple getRecibidas? ****");
            UtilidadesLog.debug("conc.getRecibidas(): " + conc.getRecibidas());
            UtilidadesLog.debug("resVar.getRecibidas(): " + resVar.getRecibidas());
            UtilidadesLog.debug("metasVenta.getNumeroRecibidas(): " + metasVenta.getNumeroRecibidas());
            
            if ((conc.getRecibidas() != null) && (resVar.getRecibidas() != null) && (metasVenta.getNumeroRecibidas() != null) &&
                    conc.getRecibidas().booleanValue() && resVar.getRecibidas().intValue() < metasVenta.getNumeroRecibidas().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getRecibidas****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //8.- Si concurso.capitalizacion && !(resVar.capitalizacion < metasVenta.capitalizacion) entonces retornar false. 
            UtilidadesLog.debug("****cumple getCapitalizacion? ****");
            UtilidadesLog.debug("conc.getCapitalizacion(): " + conc.getCapitalizacion());
            UtilidadesLog.debug("resVar.getCapitalizacion(): " + resVar.getCapitalizacion());
            UtilidadesLog.debug("metasVenta.getCapitalizacion(): " + metasVenta.getCapitalizacion());
            
            if ((conc.getCapitalizacion() != null) && (resVar.getCapitalizacion() != null) && (metasVenta.getCapitalizacion() != null) &&
                    conc.getCapitalizacion().booleanValue() && resVar.getCapitalizacion().intValue() < metasVenta.getCapitalizacion().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getCapitalizacion****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 9.- Si concurso.activasFinales && !(resVar.activasFinales < metasVenta.activasFinales) entonces retornar false.
            UtilidadesLog.debug("****cumple getActivasFinales? ****");
            UtilidadesLog.debug("conc.getActivasFinales(): " + conc.getActivasFinales());
            UtilidadesLog.debug("resVar.getActivasFinales(): " + resVar.getActivasFinales());
            UtilidadesLog.debug("metasVenta.getActivasFinales(): " + metasVenta.getActivasFinales());
            
            if ((conc.getActivasFinales() != null) && (resVar.getActivasFinales() != null) && (metasVenta.getActivasFinales() != null) &&
                    conc.getActivasFinales().booleanValue() && resVar.getActivasFinales().intValue() < metasVenta.getActivasFinales().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables- No cumple getActivasFinales****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 10.- Si concurso.actividad && !(dtoRes.porcentajeActividad < metasVenta.actividad) entonces retornar false. 
            UtilidadesLog.debug("****cumple getPorcentajeActividad? ****");
            UtilidadesLog.debug("conc.getActividad(): " + conc.getActividad());
            UtilidadesLog.debug("dtoRes.getPorcentajeActividad(): " + dtoRes.getPorcentajeActividad());
            UtilidadesLog.debug("metasVenta.getActividad(): " + metasVenta.getActividad());
            
            if ((conc.getActividad() != null) && (dtoRes.getPorcentajeActividad() != null) && (metasVenta.getActividad() != null) &&
                    conc.getActividad().booleanValue() && dtoRes.getPorcentajeActividad().doubleValue() < metasVenta.getActividad().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables- No cumple getPorcentajeActividad****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 11.- Si concurso.numeroPedidos && !(dtoRes.numeroPedidos < metasVenta.numeroPedidos) entonces retornar false. 
            UtilidadesLog.debug("****cumple getNumeroPedidos? ****");
            UtilidadesLog.debug("conc.getNumeroPedidos(): " + conc.getNumeroPedidos());
            UtilidadesLog.debug("dtoRes.getNumeroPedidos(): " + dtoRes.getNumeroPedidos());
            UtilidadesLog.debug("metasVenta.getNumeroPedidos(): " + metasVenta.getNumeroPedidos());
            
            if ((conc.getNumeroPedidos() != null) && (metasVenta.getNumeroPedidos() != null) && (dtoRes.getNumeroPedidos() != null) &&
                    conc.getNumeroPedidos().booleanValue() && dtoRes.getNumeroPedidos().intValue() < metasVenta.getNumeroPedidos().intValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getNumeroPedidos****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 12.- Si concurso.precioPromedioUnitario && !(dtoRes.precioPromedioUnitario < metasVenta.precioPromedioUnitario) entonces retornar false. 
            UtilidadesLog.debug("****cumple getPrecioPromedioUnitario? ****");
            UtilidadesLog.debug("conc.getPrecioPromedioUnitario(): " + conc.getPrecioPromedioUnitario());
            UtilidadesLog.debug("dtoRes.getPrecioPromedioUnitario(): " + dtoRes.getPrecioPromedioUnitario());
            UtilidadesLog.debug("metasVenta.getPrecioPromedioUnitario(): " + metasVenta.getPrecioPromedioUnitario());
            
            if ((conc.getPrecioPromedioUnitario() != null) && (dtoRes.getPrecioPromedioUnitario() != null) &&
                    (metasVenta.getPrecioPromedioUnitario() != null) && conc.getPrecioPromedioUnitario().booleanValue() &&
                    dtoRes.getPrecioPromedioUnitario().doubleValue() < metasVenta.getPrecioPromedioUnitario().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables- No cumple getPrecioPromedioUnitario****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 13.- Si concurso.promedioVentaPedido && !(dtoRes.promedioVentaPedidos < metasVenta.promedioVentaPedido) entonces retornar false. 
            UtilidadesLog.debug("****cumple getPromedioVentaPedido? ****");
            UtilidadesLog.debug("conc.getPromedioVentaPedido(): " + conc.getPromedioVentaPedido());
            UtilidadesLog.debug("dtoRes.getPromedioVentaPedidos(): " + dtoRes.getPromedioVentaPedidos());
            UtilidadesLog.debug("metasVenta.getPromedioVentaPedido(): " + metasVenta.getPromedioVentaPedido());
            
            if ((conc.getPromedioVentaPedido() != null) && (dtoRes.getPromedioVentaPedidos() != null) && (metasVenta.getPromedioVentaPedido() != null) &&
                    conc.getPromedioVentaPedido().booleanValue() &&
                    dtoRes.getPromedioVentaPedidos().doubleValue() < metasVenta.getPromedioVentaPedido().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getPromedioVentaPedido****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 14.- Si concurso.promedioUnidadesPedido && !(dtoRes.promedioUnidadesPedidos < metasVenta.promedioUnidadesPedido) entonces retornar false. 
            UtilidadesLog.debug("****cumple getPromedioUnidadesPedidos? ****");
            UtilidadesLog.debug("conc.getPromedioUnidadesPedido(): " + conc.getPromedioUnidadesPedido());
            UtilidadesLog.debug("dtoRes.getPromedioUnidadesPedidos(): " + dtoRes.getPromedioUnidadesPedidos());
            UtilidadesLog.debug("metasVenta.getPromedioUnidadesPedido(): " + metasVenta.getPromedioUnidadesPedido());
            
            if ((conc.getPromedioUnidadesPedido() != null) && (dtoRes.getPromedioUnidadesPedidos() != null) &&
                    (metasVenta.getPromedioUnidadesPedido() != null) && conc.getPromedioUnidadesPedido().booleanValue() &&
                    dtoRes.getPromedioUnidadesPedidos().doubleValue() < metasVenta.getPromedioUnidadesPedido().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getPromedioUnidadesPedidos****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //      15.- Si concurso.promedioOrdenesPedido && !(dtoRes.promedioOrdenesPedidos < metasVenta.promedioOrdenesPedido) entonces retornar false. 
            UtilidadesLog.debug("****cumple getPromedioOrdenesPedido? ****");
            UtilidadesLog.debug("conc.getPromedioOrdenesPedido(): " + conc.getPromedioOrdenesPedido());
            UtilidadesLog.debug("dtoRes.getPromedioOrdenesPedidos(): " + dtoRes.getPromedioOrdenesPedidos());
            UtilidadesLog.debug("metasVenta.getPromedioOrdenesPedido(): " + metasVenta.getPromedioOrdenesPedido());
            
            if ((conc.getPromedioOrdenesPedido() != null) && (dtoRes.getPromedioOrdenesPedidos() != null) &&
                    (metasVenta.getPromedioOrdenesPedido() != null) && conc.getPromedioOrdenesPedido().booleanValue() &&
                    dtoRes.getPromedioOrdenesPedidos().doubleValue() < metasVenta.getPromedioOrdenesPedido().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getPromedioOrdenesPedido****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            // 16.- Si concurso.retencion && !(resVar.porcentajeRetencion < metasVenta.retencion) entonces retornar false. 
            UtilidadesLog.debug("****cumple getPorcentajeRetencion? ****");
            UtilidadesLog.debug("conc.getRetencion(): " + conc.getRetencion());
            UtilidadesLog.debug("resVar.getPorcentajeRetencion(): " + resVar.getPorcentajeRetencion());
            UtilidadesLog.debug("metasVenta.getRetencion(): " + metasVenta.getRetencion());
            
            if ((conc.getRetencion() != null) && (resVar.getPorcentajeRetencion() != null) && (metasVenta.getRetencion() != null) &&
                    conc.getRetencion().booleanValue() && resVar.getPorcentajeRetencion().doubleValue() < metasVenta.getRetencion().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables - No cumple getPorcentajeRetencion****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //       17.- Si concurso.rotacion && !(resVar.rotacion < metasVenta.rotacion) entonces retornar false. 
            UtilidadesLog.debug("****cumple getRotacion? ****");
            UtilidadesLog.debug("conc.getRotacion(): " + conc.getRotacion());
            UtilidadesLog.debug("resVar.getRotacion(): " + resVar.getRotacion());
            UtilidadesLog.debug("metasVenta.getRotacion(): " + metasVenta.getRotacion());
            
            if ((conc.getRotacion() != null) && (resVar.getRotacion() != null) && (metasVenta.getRotacion() != null) &&
                    conc.getRotacion().booleanValue() && resVar.getRotacion().doubleValue() < metasVenta.getRotacion().doubleValue()) {
                UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables- No cumple getRotacion****");
                UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
                return false;
            }
    
            //18.- En caso de no haber entrado en ningun punto de los anteriores se debe retornar true.
            UtilidadesLog.debug("cumpleVariables: TRUE");
            UtilidadesLog.debug("****Salio VariablesVentaHelper.cumpleVariables****");
            UtilidadesLog.info("VariablesVentaHelper.cumpleVariables(DTOResultadoConcursoVariablesVenta dtoRes, ResultadoVariablesVenta resVar, MetasVentaProyectada metasVenta, ConcursoVariablesVenta conc): Salida");
            return true;
        }
        
        UtilidadesLog.debug("cumpleVariables: FALSE");
        UtilidadesLog.info("VariablesVentaHelper.generarRegistroCC(DTOFACConsolidado dtoConso): Salida");
        return false;
    }

    /**
    * @return DTOResultadoConcursoVariablesVenta
    * @version 1.00 15/06/2005
    * @author: Carlos Leal
    * Descripcion: obtiene el monto y unidades vendidas para el cliente y concurso recibidos por
    * paramtro en la unidadAdministrativa del gerente.
    **/
    public DTOResultadoConcursoVariablesVenta obtenerMontoUnidadesVenta(Long oidConcurso, InfoGerentesConcursos infoGerConc,
                                                                        GerenteVariablesVenta gerVarVta)
            throws MareException {
        UtilidadesLog.info("VariablesVentaHelper.obtenerMontoUnidadesVenta(Long oidConcurso, InfoGerentesConcursos infoGerConc,GerenteVariablesVenta gerVarVta): Entrada");

        DAOCalculoVariablesVenta dao = new DAOCalculoVariablesVenta();
        DTOResultadoConcursoVariablesVenta dTOResConcVarVta = new DTOResultadoConcursoVariablesVenta();

        if (infoGerConc.getConcurso(oidConcurso).getIndProductosExigidos().booleanValue()) {
            dTOResConcVarVta = dao.recuperarMontoUnidadesConExigencias(oidConcurso, infoGerConc, gerVarVta);
        } else {
            dTOResConcVarVta = dao.recuperarMontoUnidadesSinExigencias(oidConcurso, infoGerConc, gerVarVta);
        }

        UtilidadesLog.info("VariablesVentaHelper.obtenerMontoUnidadesVenta(Long oidConcurso, InfoGerentesConcursos infoGerConc,GerenteVariablesVenta gerVarVta): Salida");

        return dTOResConcVarVta;
    }
}
