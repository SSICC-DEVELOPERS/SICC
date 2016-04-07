/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 25/04/2005
 * @author Gustavo Viñales
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;

public class RecuperadorDatosPremiacion {
    private ArrayList listaConcursoGanadores;
    private UtilidadesLog log = new UtilidadesLog();
    
    public RecuperadorDatosPremiacion() {
    }

    public void setListaConcursoGanadores(ArrayList listaConcursoGanadores) {
        this.listaConcursoGanadores = listaConcursoGanadores;
    }

    public ArrayList getListaConcursoGanadores() {
        return listaConcursoGanadores;
    }

    /**
     *
     * @param periodoAPremiar
     * @param clientePremiacionConcurso
     * @param clientePremiacion
     *
     *
     * @author Gustavo Viñales
     */
    public void calcularSaldoPuntaje(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Periodo periodoAPremiar)
            throws MareException {
        UtilidadesLog.info("RecuperadorDatosPremiacion.calcularSaldoPuntaje(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Periodo periodoAPremiar):Entrada");
        DAOClientePremiacionConcurso dao = new DAOClientePremiacionConcurso();

        if (periodoAPremiar != null) {
            dao.recuperarSaldoPuntos(clientePremiacion, clientePremiacionConcurso, periodoAPremiar);
        } else {
            dao.recuperarSaldoPuntosAcumulativos(clientePremiacion, clientePremiacionConcurso);
        }
        UtilidadesLog.info("RecuperadorDatosPremiacion.calcularSaldoPuntaje(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Periodo periodoAPremiar):Salida");
    }

    /**
     * @param clientePremiacion
     * @param clientePremiacionConcurso
     * @param concurso
     *
     * @author Sergio Platas
     * @date 23/06/2005
     */
    public void cargarPremios(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion)
            throws MareException {
        
        UtilidadesLog.info("RecuperadorDatosPremiacion.cargarPremios(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Entrada");
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("concurso: " + concurso);
        /*
         * Descripción:
         * 1.-Si concurso.tipoPremiacion==ConstantasINC.TIPO_PREMIACION_BOLSA_PREMIOS entonces
         *    Se invoca al método recuperarPremiosElegidos(clientePremiacionConcurso) que nos devuelve
         *    un arrayList que le asignaremos al atributo premiosElegidos
         *
         *    @FIXME FALTA DEFINIR QUE ES EL PERIODO FINAL DE DESPACHO POR PARTE DE PERU
         *    Si el ArrayList no contiene ningun elemento entonces:
         *    -invocamos al método recuperarPremiosNivelesPremiacion() pasandole
         *    clientePremiacionConcurso que nos devuelve un arrayList que le asignaremos al atributo
         *    premiosElegidos
         *    fin Si.
         *    2.-Si concurso.tipoPremiacion==ConstantesINC.TIPO_PREMIACION_POR_NIVELES entonces
         *    2.1. Si concurso.accesoNivelSuperior==FALSE
         *    -invocamos al método recuperarPremiosMultinivel() pasandole clientePremiacionConcurso,
         *     concurso, clientePremiacion que nos devuelve un arrayList que le asignaremos al atributo
         *     premiosElegidos
         *     2.2. Si clientePremicacionConcurso.accesoNivelSuperior==TRUE
         *     - Se hace un find en la entidad Metas Tipo Venta filtrando por oidConcurso y
         *     oidCliente y recuperamos el oidDeNivel
         *     - Con ese oid invocamos al método DAOClientePremiacionConcurso.recuperarPremioPorNivel
         *     que nos devuelve un objeto de tipo Premio que añadiremos al array premiosEscogidos
         */
        ArrayList premiosElegidos = new ArrayList();
        DAOClientePremiacionConcurso daocli = new DAOClientePremiacionConcurso();

        //jrivas 1/8/2005
        //inc 20269
        /*
        0.- Si concurso.programaNuevas entonces
            Si concurso.requisitosProgramaNuevas != null && concurso.requisitosProgramaNuevas.nivelPremiacion != null entonces
                 Invocar al método DAOClientePremiacionConcurso.recuperarPremioPorNivel pasandole concurso.requisitosProgramaNuevas.nivelPremiacion
                 que nos devuelve un objeto de tipo Premio que añadiremos al array clientePremiacionConcurso.premiosEscogidos.
            FSi
            Terminar el método.
         FSi
        */
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("RecuperadorDatosPremiacion ------ >>> concurso.getProgramaNuevas() " + concurso.getProgramaNuevas());

        if (concurso.getProgramaNuevas()) {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("RecuperadorDatosPremiacion ------ >>> concurso.getRequisitosProgramaNuevas() " +
                               concurso.getRequisitosProgramaNuevas());

            if (concurso.getRequisitosProgramaNuevas() != null) {
                Long oidNivelPremiacionAux = concurso.obtenerNivelPremiacionNuevas(clientePremiacionConcurso.getNumeroPeriodosEvaluados());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("RecuperadorDatosPremiacion ------ >>> oidNivelPremiacionAux " + oidNivelPremiacionAux);

                if (oidNivelPremiacionAux != null) {
                    //  Se agrego un parametro null, Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
                    Premio premio = daocli.recuperarPremioPorNivel(oidNivelPremiacionAux, null);
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("RecuperadorDatosPremiacion ------ >>> premio " + premio);
                    premiosElegidos.add(premio);
                }
            }
            clientePremiacionConcurso.setPremiosEscogidos(premiosElegidos);
            UtilidadesLog.info("RecuperadorDatosPremiacion.cargarPremios(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Salida");
            return;
        }

        if (ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS.equals(concurso.getTipoPremiacion())) {
            // INCIDENCIA 19246: 'recuperarPremiosElegidos()' RECIBE 2 PARÁMETROS
            premiosElegidos = daocli.recuperarPremiosElegidos(clientePremiacionConcurso, clientePremiacion);
            clientePremiacionConcurso.setPremiosEscogidos(premiosElegidos);

            if (premiosElegidos.size() < 1) {
                // INCIDENCIA 19246: 'recuperarPremiosElegidos()' RECIBE 2 PARÁMETROS
                premiosElegidos = daocli.recuperarPremiosNivelesPremiacion(clientePremiacionConcurso, clientePremiacion);
                UtilidadesLog.debug("Antes de setear premios escogidos");
                clientePremiacionConcurso.setPremiosEscogidos(premiosElegidos);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("despues de setear premios escogidos " + clientePremiacionConcurso.getPremiosEscogidos());
            }
        }

        if (ConstantesINC.TIPO_PREMIACION_POR_NIVELES.equals(concurso.getTipoPremiacion())) {
            // Inc.19749   
            if (concurso.getAccesoNivelSuperior() == false) {
                daocli.recuperarPremiosMultinivel(clientePremiacionConcurso, clientePremiacion, concurso);
            }

            //2.2. Si clientePremicacionConcurso.accesoNivelSuperior==TRUE
            //*     - Se hace un find en la entidad Metas Tipo Venta filtrando por oidConcurso y
            //*     oidCliente y recuperamos el oidDeNivel
            //*     - Con ese oid invocamos al método DAOClientePremiacionConcurso.recuperarPremioPorNivel
            //*     que nos devuelve un objeto de tipo Premio que añadiremos al array premiosEscogidos
            // INCIDENCIA 19246: NO EXISTE EN MODELO 'clientePremicacionConcurso.accesoNivelSuperior'
            // Resp.: 'accesoNivelSuperior' es un atributo del 'concurso'
            if (concurso.getAccesoNivelSuperior() == true) {

                Long oidPremio = this.recuperarNivelMeta(clientePremiacion.getOidCliente(), concurso.getOidConcurso());
                if(oidPremio!=null){
                    //  Se agrego un parametro null, Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
                    clientePremiacionConcurso.getPremiosEscogidos().add(daocli.recuperarPremioPorNivel(oidPremio, null));
                }
            }
        }
        
        // vbongiov -- Cambio 20080811 -- 26/08/2009
        if (ConstantesINC.OID_TIPO_PREMIACION_SORTEO.equals(concurso.getTipoPremiacion())) {
          
            UtilidadesLog.debug("Sorteo no hay premios");
        }        
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("Termine con clientePremiacionConcurso.getPremiosEscogidos() " + clientePremiacionConcurso.getPremiosEscogidos());
          
        UtilidadesLog.info("RecuperadorDatosPremiacion.cargarPremios(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Salida");
    }

    /**
     *
     * @param concursos
     * @param clientePremiacion
     */
    public void obtenerDatosTransformasPuntosPremios(ClientePremiacion clientePremiacion, ArrayList concursos)
            throws MareException {
        UtilidadesLog.info("RecuperadorDatosPremiacion.obtenerDatosTransformasPuntosPremios(ClientePremiacion clientePremiacion, ArrayList concursos):Entrada");
        Iterator it = clientePremiacion.getClientesPremiacionConcurso().values().iterator();

        while (it.hasNext()) {
            ClientePremiacionConcurso clientePremiacionConcurso = (ClientePremiacionConcurso) it.next();
            Concurso concurso = findConcurso(clientePremiacionConcurso.getOidConcurso(), concursos);
            cargarPremios(concurso, clientePremiacionConcurso, clientePremiacion);
        }
        UtilidadesLog.info("RecuperadorDatosPremiacion.obtenerDatosTransformasPuntosPremios(ClientePremiacion clientePremiacion, ArrayList concursos):Salida");
    }

    private Concurso findConcurso(Long oidConcurso, ArrayList concursos) {
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("oidConcurso: " + oidConcurso + " concursos: " + concursos );
          
        for (Iterator it = concursos.iterator(); it.hasNext();) {
            Concurso conc = (Concurso) it.next();

            if (conc.getOidConcurso().equals(oidConcurso)) {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("return: " + conc);
                return conc;
            }
        }
        UtilidadesLog.debug("return null");
        return null;
    }

    public void obtenerDatosCalificacionPremiacion(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso)
            throws MareException {
        UtilidadesLog.info("RecuperadorDatosPremiacion.obtenerDatosCalificacionPremiacion(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso):Entrada");
        DAOClientePremiacionConcurso dao = new DAOClientePremiacionConcurso();
        Concurso concurso = new DespacharPremiosHelper().obtenerConcurso(clienteConcurso.getOidConcurso());
        Periodo periodoAPremiar = dao.recuperarPeriodoAPremiar(clientePremiacion, concurso);
        calcularSaldoPuntaje(clientePremiacion, clienteConcurso, periodoAPremiar);
        //INC-137 jrivas 6/7/2006
        clienteConcurso.setSaldoPuntosConcurso(dao.recuperarSaldoPuntos(clientePremiacion.getOidCliente(), concurso));
        UtilidadesLog.info("RecuperadorDatosPremiacion.obtenerDatosCalificacionPremiacion(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso):Salida");
    }
    
    //Agregado jrivas 16/8/2005
    //inc 19272
    /*1.- Deberemos hacer una consulta en la que recuperemos de MetasTipoVenta usando oidCliente y oidConcuros,
    el campo montoVenta, con ese dato tendremos que consultar en la tabla niveles de premiacion filtrando por
    concurso, el registro en el que cantidadInicialPuntos<=montoVenta<=cantidadFinalPuntos y devolver su oid*/
    public Long recuperarNivelMeta(Long oidCliente, Long oidConcurso) throws MareException {
        UtilidadesLog.info("RecuperadorDatosPremiacion.recuperarNivelMeta(Long oidCliente, Long oidConcurso):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            query.append(" SELECT OID_PARA_NIVE_PREM ");
            query.append("   FROM INC_METAS_TIPO_VENTA MTV, ");
            query.append("        INC_PARAM_NIVEL_PREMI PNP, ");
            query.append("        INC_PARAM_GENER_PREMI PGP ");
            query.append("  WHERE MTV.COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append("    AND MTV.CLIE_OID_CLIE = " + oidCliente);
            query.append("    AND PGP.COPA_OID_PARA_GRAL = MTV.COPA_OID_PARA_GRAL ");
            query.append("    AND PGP.OID_PARA_GENE_PREM = PNP.PAGP_OID_PARA_GENE_PREM ");
            query.append("    AND NUM_CANT_INIC_PUNT <= IMP_MONTO_VENTA ");
            query.append("    AND IMP_MONTO_VENTA <= NUM_CANT_FINA_PUNT ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long oidNivel; 
        if (respuesta.esVacio()) {
            oidNivel = null;
        } else {
            oidNivel = new Long(((BigDecimal) respuesta.getValueAt(0, "OID_PARA_NIVE_PREM")).longValue());
        }
        UtilidadesLog.info("RecuperadorDatosPremiacion.recuperarNivelMeta(Long oidCliente, Long oidConcurso):Salida");
        return oidNivel;
    }
    
    // gPineda - DBLG700000298 - 25/01/2007
    public Long recuperarNumNivelMeta(Long oidCliente, Long oidConcurso) throws MareException {
        UtilidadesLog.info("RecuperadorDatosPremiacion.recuperarNumNivelMeta(Long oidCliente, Long oidConcurso):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            query.append(" SELECT PNP.NUM_NIVE ");
            query.append("   FROM INC_METAS_TIPO_VENTA MTV, ");
            query.append("        INC_PARAM_NIVEL_PREMI PNP, ");
            query.append("        INC_PARAM_GENER_PREMI PGP ");
            query.append("  WHERE MTV.COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append("    AND MTV.CLIE_OID_CLIE = " + oidCliente);
            query.append("    AND PGP.COPA_OID_PARA_GRAL = MTV.COPA_OID_PARA_GRAL ");
            query.append("    AND PGP.OID_PARA_GENE_PREM = PNP.PAGP_OID_PARA_GENE_PREM ");
            query.append("    AND NUM_CANT_INIC_PUNT <= IMP_MONTO_VENTA ");
            query.append("    AND IMP_MONTO_VENTA <= NUM_CANT_FINA_PUNT ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long oidNivel; 
        if (respuesta.esVacio()) {
            oidNivel = null;
        } else {
            oidNivel = new Long(((BigDecimal) respuesta.getValueAt(0, "NUM_NIVE")).longValue());
        }
        UtilidadesLog.info("RecuperadorDatosPremiacion.recuperarNumNivelMeta(Long oidCliente, Long oidConcurso):Salida");
        return oidNivel;
    }

}
