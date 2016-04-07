package es.indra.sicc.logicanegocio.com;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.com.DTOClasificarComisiones;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.sicc.dtos.com.DTOClienteComision;

import es.indra.sicc.entidades.com.CongeladosLocal;
import es.indra.sicc.entidades.com.CongeladosLocalHome;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocal;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocalHome;
import es.indra.sicc.logicanegocio.com.MONCalcularComisiones;
import es.indra.sicc.logicanegocio.com.MONCalcularComisionesHome;

//import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.COMEjbLocators;
import java.rmi.RemoteException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCalculoComisionesBean implements SessionBean 
{
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
        this.ctx=ctx;
    }
    
    SessionContext ctx;

    /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */ 
    public void clasificarComisiones(DTOClasificarComisiones dtoEntrada) throws MareException {
        try{
        UtilidadesLog.info("MONCalculoComisionesBean.clasificarComisiones(DTOClasificarComisiones dtoEntrada): Entrada");        
        
//->LLamar al DAOClasificarComisiones.buscarComisiones(dto:DTOClasificarComisiones):DTOSalida 
        DAOClasificarComisiones daoC = new DAOClasificarComisiones();
        DTOSalida dtoS = daoC.buscarComisiones(dtoEntrada);
        RecordSet rsComisiones = dtoS.getResultado();
//->Crear un DTOColeccion "comisiones" 
        DTOColeccion comisiones = new DTOColeccion();
        ArrayList arCom = new ArrayList();
        Long periodoAux = null;
        
UtilidadesLog.debug(" Cantidad de comisiones a procesar:  " + rsComisiones.getRowCount());        
//->(A)Por cada registro del recordset recibido hacer lo siguiente: 
        for( int i = 0; i < rsComisiones.getRowCount(); i++ ) {

//-->Crear un DTOComisiones "dtoComision" 
            DTOComisiones dtoComision = new DTOComisiones();
            dtoComision.setOidPais(dtoEntrada.getOidPais());
//-->Setear los datos con los recibidos en el recorset al dtoComision 
            Long oid = new Long(((BigDecimal) rsComisiones.getValueAt(i, "OID_COMI")).longValue());
            dtoComision.setOid(oid);
UtilidadesLog.debug("Comision Recuperada: " + oid.toString());
            String codigo = rsComisiones.getValueAt(i, "COD_COMI").toString();
            dtoComision.setCodigo(codigo);
            
            Integer version = new Integer(((BigDecimal) rsComisiones.getValueAt(i, "NUM_VERS")).intValue());
            dtoComision.setVersion(version);
            
            if (rsComisiones.getValueAt(i, "PERD_OID_PERI")!= null)
            {
                Long lPer = (new Long(((BigDecimal)rsComisiones.getValueAt(i,"PERD_OID_PERI")).toString()));
                dtoComision.setOidPeriodoDesde(lPer);
            }
            
            Long lTipoPlan = (new Long(((BigDecimal)rsComisiones.getValueAt(i,"TPLA_OID_TIPO_PLAN")).toString()));
            dtoComision.setOidTipoComision(lTipoPlan);
            
            Long lPlanComi = (new Long(((BigDecimal)rsComisiones.getValueAt(i,"PLCO_OID_PLAN_COMI")).toString()));
            dtoComision.setOidPlantillasComisones(lPlanComi);
            
            String IndVentaCob = rsComisiones.getValueAt(i,"IND_VENT_COBR").toString();
            dtoComision.setIndVentaCobranza(IndVentaCob);
            
            Integer periodosEspera = rsComisiones.getValueAt(i,"NUM_PERI_ESPE")!=null?Integer.valueOf(rsComisiones.getValueAt(i,"NUM_PERI_ESPE").toString()):null; 
            dtoComision.setPeriodosEspera(periodosEspera);
            
            arCom.add(dtoComision);
        
//-->Asignar el dtoComision al DTOColeccion "comisiones" 
//->(A) fin 
        }//for
        
        comisiones.setLista(arCom);

//->(B)Por cada elemento contenido en comisiones hago lo siguiente:
        int registros = arCom.size();
        Boolean bCalculada = null;
UtilidadesLog.debug("Cantidad de Comisiones:  " + registros);
        for (int i=0; i<registros; i++){
            //FOR(B)
            bCalculada = Boolean.FALSE;
//--> Creo un DTOComisiones dtoComision 
//            DTOComisiones dtoComision = new DTOComisiones();
            DTOComisiones dtoComision = (DTOComisiones)arCom.get(i);

UtilidadesLog.debug("====================  Procesando Comision:  " + dtoComision.getOid().toString());

            // Periodo de calculo
            if(dtoComision.getPeriodosEspera()!=null && dtoComision.getPeriodosEspera().intValue()!=0) {
                periodoAux = daoC.obtenerPeriodoNAnterior(dtoEntrada.getOidPeriodo(), dtoComision.getPeriodosEspera());
            } else{
                periodoAux = dtoEntrada.getOidPeriodo();
            }
            
            UtilidadesLog.debug("periodoAux: " + periodoAux);

//--> DTOSalida dtoGerentes = DAOClasificarComisiones.recuperarGerentes(dtoComision.get(oidComision):Long):DTOSalida 
            DTOSalida dtoGerentes = daoC.recuperarGerentes(dtoComision);
//--> Con el dtoGerentes armar un ArrayList "gerentes" con los oidClientes recuperados en el recordset 
            RecordSet rsGerentes = dtoGerentes.getResultado();
            ArrayList arGerentes = validarListaGerentes(rsGerentes);
            
            if(arGerentes != null)
            {
                String  codigoEmpleado = null;
//--> (C) Por cada elemento de gerentes hacer lo siguiente: 
                int iTam = arGerentes.size();
                UtilidadesLog.debug("Cantidad de Gerentes Recuperados:  " + iTam);
                int j = 0;
///*Se verifica si la comision ya está calculada en cuyo caso, de estar calculada, se toma la siguiente comisión*/ 
                while ( j < iTam && bCalculada == Boolean.FALSE )
                {
//->Si DAOClasificarComisiones.comprobarComisionesCalculadas(oidCliente:Long, oidComision:Long, oidPeriodo:Long):Boolean 
//pasar a la siguiente comision de "comisiones" 
                    DTOClienteComision dtoCliente = (DTOClienteComision)arGerentes.get(j);
                    Long lOidCliente = dtoCliente.getOid();
                    codigoEmpleado = dtoCliente.getCodigoEmpleado();
                    
                    UtilidadesLog.debug("Procesando Comision: " + dtoComision.getOid());
                    UtilidadesLog.debug("Procesando cliente:  " + lOidCliente);
                    UtilidadesLog.debug("Procesando Periodo:  " + dtoEntrada.getOidPeriodo());
                    bCalculada = daoC.comprobarComisionesCalculadas(lOidCliente,
                            dtoComision.getOid(), periodoAux);
                    j++;
//->fin si 
//--> (C) fin
                }
                if (bCalculada == Boolean.FALSE)
                {
                    UtilidadesLog.debug("No hay comisiones calculadas para este periodo se procede a calcularlas ");
//--> Long oidAcceso = Llamar al método privado recuperarAcceso(oidComision) 
                    Long []aAcceso = recuperarAccesos(dtoComision.getOid(), dtoEntrada.getOidCanal()); 
                    if ( aAcceso != null )
                    {
                        UtilidadesLog.debug("Procesando Accesos: " + aAcceso);
//--> Creo un DTODatosCalculoComision "dtoCalculo" asignándole ademas el ArrayList de gerentes 
                        DTODatosCalculosComision dtoCalculo = new DTODatosCalculosComision();
                        dtoCalculo.setOidIdioma(dtoEntrada.getOidIdioma());
                        dtoCalculo.setOidPais(dtoEntrada.getOidPais());
//--> Asignar a dtoCalculo.set(oidAcceso) = oidAcceso 
                        dtoCalculo.setOidAccesos(aAcceso);
                        dtoCalculo.setOidCanal(dtoEntrada.getOidCanal());
                        dtoCalculo.setOidMarca(dtoEntrada.getOidMarca());                    
                        dtoCalculo.setOidPeriodo(periodoAux);
                        dtoCalculo.setOidComision(dtoComision.getOid());                     
                        dtoCalculo.setGerentes(arGerentes);
                        dtoCalculo.setOidTipoPlantilla(dtoComision.getOidTipoComision());
                        dtoCalculo.setOidPlantilla(dtoComision.getOidPlantillasComisones());
                        dtoCalculo.setVersion(dtoComision.getVersion());
                        dtoCalculo.setCodigoEmpleado(codigoEmpleado);

                        UtilidadesLog.debug("Acceso:             " + aAcceso);
                        UtilidadesLog.debug("Canal:              " + dtoEntrada.getOidCanal());
                        UtilidadesLog.debug("Marca:              " + dtoEntrada.getOidMarca());                    
                        UtilidadesLog.debug("Periodo:            " + periodoAux);
                        UtilidadesLog.debug("Oid:                " + dtoComision.getOid());                     
                        UtilidadesLog.debug("Gerentes:           " + arGerentes);
                        UtilidadesLog.debug("Tipo Comision:      " + dtoComision.getOidTipoComision());
                        UtilidadesLog.debug("Plant Comisiones:   " + dtoComision.getOidPlantillasComisones());
                        UtilidadesLog.debug("Version:            " + dtoComision.getVersion());
                        UtilidadesLog.debug("Empleado:           " + codigoEmpleado);
                        
                        MONCalcularComisionesHome monCalComHome=null;
                        MONCalcularComisiones monCalCom=null;
//--> Si dtoComision.get(indVentaCobranza) = ConstantesCOM.COMISION_VENTAS 
UtilidadesLog.debug("Ind Venta-Cobranza:  " + dtoComision.getIndVentaCobranza());
                        if( dtoComision.getIndVentaCobranza().equals( ConstantesCOM.COMISION_VENTAS) )
                        {
//MONCalcularComisiones.calcularComisionesXVentas(dtoCalculo: DTODatosCalculoComision):Void
                            try{
                                UtilidadesLog.debug("Procesando Comision X Venta...." );
                                //monCalComHome = (MONCalcularComisionesHome)UtilidadesEJB.getHome("MONCalcularComisiones", MONCalcularComisionesHome.class);
                                monCalComHome = COMEjbLocators.getMONCalcularComisionesHome();
                                monCalCom = monCalComHome.create();
                                monCalCom.calcularComisionesXVenta(dtoCalculo);
                            }
                            catch (RemoteException rex) {
                                UtilidadesLog.debug(rex);
                                throw new MareException( rex,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                            catch (CreateException cex) {
                                UtilidadesLog.error(cex);
                                throw new MareException(cex,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                            UtilidadesLog.debug("Comision X Venta PROCESADA...." );
//--> fin si 
                        }
//--> Si dtoComision.get(indVentaCobranza) = ConstantesCOM.COMISION_COBRANZAS 
                        if( dtoComision.getIndVentaCobranza().equals( ConstantesCOM.COMISION_COBRANZAS))
                        {
//MONCalcularComisiones.calcularComisionesXCobranzas(dtoCalculo: DTODatosCalculoComision):Void
                            try{
                                UtilidadesLog.debug("Procesando Comisiones X Cobranza...." );
                                monCalComHome = COMEjbLocators.getMONCalcularComisionesHome();
                                monCalCom = monCalComHome.create();
                                monCalCom.calcularComisionesXCobranzas(dtoCalculo);
                            }
                            catch (RemoteException rex) {
                                UtilidadesLog.debug(rex);
                                throw new MareException( rex,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                            catch (CreateException cex) {
                                UtilidadesLog.error(cex);                                
                                throw new MareException(cex,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                            UtilidadesLog.debug("Comisiones X Cobranza PROCESADA...." );
//--> fin si 
                        }
                    }
//-> Pasar a la siguiente comision 
                }//bCalculada == FALSE 
            }
//->(B) fin 
        }//FOR (B)

UtilidadesLog.debug("Comisiones Procesadas..." );

//-> DTOSalida dtoGerentes = DAOClasificarComisiones.recuperarGerentesComisionados(dto.get(oidPeriodo)):DTOSalida 
        DTOSalida dtoGtesComi = daoC.recuperarGerentesComisionados(dtoEntrada.getOidPeriodo());
        RecordSet rsGteComi = dtoGtesComi.getResultado();
        
        if(rsGteComi!=null && !rsGteComi.esVacio())
        {
            //int iTam = arGtesComi.size();
            int iTam = rsGteComi.getRowCount();            
            UtilidadesLog.debug("Cantidad de Gerentes Comisionados a procesar: " + iTam);        
//-> (4)Por cada uno de los gerentes del ArrayList gerentes hacer lo siguiente:
            for (int j=0;j < iTam; j++){
            
            Double totalImporte = null;
            Long lOidCliente = new Long(((BigDecimal) rsGteComi.getValueAt(j, "CLIE_OID_CLIE")).longValue());
            UtilidadesLog.debug("Procesando cliente: " + lOidCliente);
//   --> DTOSalida "congelados"
//   --> congelados = DAOClasificarComisiones.obtenerCongelado (rs.get(oidCliente), dto.get(oidPeriodo))
            DTOSalida dtoSalida = daoC.obtenerCongelado(lOidCliente, dtoEntrada.getOidPeriodo());
            RecordSet congelados = dtoSalida.getResultado();
            UtilidadesLog.debug("congelados: " + congelados);
            
            if (!congelados.esVacio())
            {
//       Si la busqueda anterior trae datos entonces:
//       --> El cliente esta congelado
//       --> DTOSalida comisionesCalculadas = DAOClasificarComisiones.comisionesCalculadas(rs.get(oidCliente):Long, dto.oidPeriodo:Long):DTOSalida
                UtilidadesLog.debug("El cliente esta congelado ");
                DTOSalida comisionesCalculadas = daoC.comisionesCalculadas(lOidCliente, dtoEntrada.getOidPeriodo());
                RecordSet comCalc = comisionesCalculadas.getResultado();
                UtilidadesLog.debug("comisiones Calculadas: "  + comCalc);
                if (!comCalc.esVacio())
                {
                    ComisionesCalculadasLocalHome comlh = this.getComisionesCalculadasLocalHome();
                    ComisionesCalculadasLocal comcl = null;
                    Double lImporte = new Double(((BigDecimal) congelados.getValueAt(0, "IMP_CONG")).doubleValue());
//       --> totalImporte = comisionesCalculadas.totalImporte
                    totalImporte = new Double(((BigDecimal) comCalc.getValueAt(0, "TOT_IMP_COMI")).doubleValue());
                    
                    UtilidadesLog.debug("Importe Congelado:   " + lImporte.toString());
                    UtilidadesLog.debug("Total Importe:       " + totalImporte.toString());
//                 --> Si totalImporte > congelados.get(importe)
                    if (totalImporte.doubleValue() > lImporte.doubleValue())                    
                        continue; //->Pasa al siguiente gerente
//                  sino
                    else 
                    {
                        UtilidadesLog.debug("Cantidad de Comisiones calculadas  " + comCalc.getRowCount());
//	                    -> Si la cantidad de registros del comisionesCalculadas = 1 entonces:
                        if (comCalc.getRowCount() == 1 )
                        {
//	                        Modificar la entidad "Comisiones Calculadas" asi:
// 	                        --> En la entidad ComisionesCalculadas hacer un findByPK(comisionesCalculadas.get(oidComisionCalculada))
                            try{
                                    UtilidadesLog.debug("Haciendo findByPrimaryKey de ComisionesCalculadas");
                                    Long lComision = new Long(((BigDecimal) comCalc.getValueAt(0, 
                                    "OID_COMI_CALC")).longValue());
                            UtilidadesLog.debug("Comision Calculada a buscar.... : " + lComision.toString());
                                    comcl = comlh.findByPrimaryKey(lComision);
                            
                            } catch(NoResultException nre) {
                                UtilidadesLog.debug(nre);
                            } catch(PersistenceException pex) {
                                ctx.setRollbackOnly();
                                throw new MareException(pex, 
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                            }

                            UtilidadesLog.debug("FINALIZO BUSQUEDA DE ComisionesCalculadas");
//	                        --> comisionesCalculadas.set(importe) = congelados.get(importe)
                            comcl.setImporte(new Double(lImporte.doubleValue()));
//	                        --> comisionesCalculadas.set(importeSinCongelacion) = totalImporte
                            comcl.setImporteSinCongelacion(new Double(totalImporte.doubleValue()));
                            
                            comlh.merge(comcl);
                        }                
//	                    sino 
                        else
                        {
//                          --> Por cada registro del recorset 
                            for (int h = 0; h< comCalc.getRowCount(); h++)
                            {
                                try{                                    
                                    Long lOidComision = new Long(((BigDecimal) comCalc.getValueAt(h, 
                                    "OID_COMI_CALC")).longValue());
                                    UtilidadesLog.debug("Buscando Comision Calculada " + lOidComision);                                    
                                    comcl = comlh.findByPrimaryKey(lOidComision);
                                } catch(NoResultException nre) {
                                    UtilidadesLog.debug(nre);
                                } catch(PersistenceException pex) {
                                    ctx.setRollbackOnly();
                                    throw new MareException(pex, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                }
                
                                Double importe = new Double(((BigDecimal) comCalc.getValueAt(h, "IMP_COMI")).doubleValue());
                                UtilidadesLog.debug("importe  " + importe.toString());                        
//                              se modifica el importe asignandole el proporsional a congelados.get(importe)                    
//	                            --> El proporsional sera el valor del importe congelado dividido la cantidad de comisiones calculadas.
                                comcl.setImporte(new Double(lImporte.doubleValue()/comCalc.getRowCount()));
//	                            --> comisiones calculada.set(importeSincongelacion) = recordset.get(importe)
                                comcl.setImporteSinCongelacion(new Double(importe.doubleValue()));
                                
                                comlh.merge(comcl);
                            }
                        }
//	            fin si
                    }
//	        fin si
                    Boolean bIndDescongAutomat = new Boolean( congelados.getValueAt(0, "IND_DESC_AUTO").toString());
UtilidadesLog.debug("Indicador Descongelado automatico... : " + bIndDescongAutomat.toString());
//            --> Si congelados.get(indDescongAutomat)== true
                    if( bIndDescongAutomat.equals(Boolean.TRUE)){
                    
                        CongeladosLocalHome conlh = this.getCongeladosLocalHome();
                        CongeladosLocal concl = null;
                        Long lOidCong = new Long(((BigDecimal) congelados.getValueAt(0, "OID_CONG")).longValue());
UtilidadesLog.debug("Oid Congelado a buscar   " + lOidCong.toString());                    
//	    -> En la entidad congelados hacer un findByPK(congelados.get(oidCongelado))
                        try{
                                concl = conlh.findByPrimaryKey(lOidCong);
                           
                        } catch(NoResultException nre) {
                            UtilidadesLog.debug(nre);
                        } catch(PersistenceException pex) {
                            ctx.setRollbackOnly();
                            throw new MareException(pex, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                        UtilidadesLog.debug("Se encontro el congelado...");                    
//	                -> Actualizar la entidad "Congelados" cambiando: Cliente, Fecha hasta = fecha del sistema, 
//                  importe = totalImporte                     
                        concl.setClienteDatosBasicos(lOidCliente);
                        Date fechaSistema = new Date(System.currentTimeMillis()); 
                        UtilidadesLog.debug("Fecha Sistema: " + fechaSistema);
                        concl.setFechaHasta(fechaSistema);
                        concl.setImporte(new BigDecimal(totalImporte.doubleValue()));
                        
                        conlh.merge(concl);
//	     fin si
                    }
//     fin si  
                }
            }
//   --> Pasa al siguiente gerente
//->(4)fin
            } //End For
        }//Fin Del if arGtesComi!= null
        UtilidadesLog.info("MONCalculoComisionesBean.clasificarComisiones(DTOClasificarComisiones dtoEntrada): Salida");        
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            if (ex instanceof MareException)
                throw (MareException)ex;
            
            throw new MareException(ex,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public Long[] recuperarAccesos(Long oidComision, Long oidCanal) 
        throws MareException {
        UtilidadesLog.info("MONCalculoComisionesBean.recuperarAccesos(Long oidComision, Long oidCanal): Entrada");
//-> Crear un Long oidAcceso 
//-> oidAcceso = LLamar al DAOClasificarComisiones recuperarAcceso(oidComision:Long) 
//-> retornar oidAcceso
        Long aAcceso[] = null;
        DAOClasificarComisiones daoC = new DAOClasificarComisiones();
        DTOSalida dtoS = daoC.recuperarAccesos(oidComision, oidCanal);
        RecordSet rsAccesos = dtoS.getResultado();
        
        if(rsAccesos!=null){
			if(!rsAccesos.esVacio()){
				int n=rsAccesos.getRowCount();
				aAcceso = new Long[n];
				
				for(int i= 0;i<n;i++){
                DTOClienteComision dtoCliente = new DTOClienteComision();
					Long lAcceso = new Long(((BigDecimal) rsAccesos.getValueAt(i, "ACCE_OID_ACCE")).longValue());
                    
                    UtilidadesLog.debug("Oid Acceso Obtenido: " + lAcceso);
                    aAcceso[i] = lAcceso;
				}
			}
		}
        
        UtilidadesLog.info("MONCalculoComisionesBean.recuperarAccesos(Long oidComision, Long oidCanal): Salida");        
        return aAcceso;
    }
    
     /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    private ArrayList validarListaGerentes(RecordSet rs) throws MareException{
        UtilidadesLog.info("MONCalculoComisionesBean.validarListaGerentes(RecordSet rs): Entrada");
        ArrayList array = null;		
        Long oidClienteAnt = null;
        Long oidCliente = null;
        DTOClienteComision dtoCliente;
        Long lOidCliente;
        String sCodEmple;
        
        if(rs!=null){
          if(!rs.esVacio()){
            int n=rs.getRowCount();
            array = new ArrayList();
            
            // Valida valores unicos de topeMax y topeMin
            for(int i= 0;i<n;i++){
                oidCliente = new Long(((BigDecimal) rs.getValueAt(i, "OID_CLIE")).longValue());
                
                if(oidClienteAnt != null && oidCliente.equals(oidClienteAnt)) {
                    UtilidadesLog.debug("No iguales valores topes Max y Min para un mismo cliente");
                    throw new MareException(null, null, 
                          UtilidadesError.armarCodigoError(
                          ConstantesSEG.MODULO_COM, "", ErroresDeNegocio.COM_0014));  
                }
                
                oidClienteAnt = oidCliente;
            }
            
            
            // Arma arrary
            for(int i= 0;i<n;i++){
                    dtoCliente = new DTOClienteComision();
                    lOidCliente = new Long(((BigDecimal) rs.getValueAt(i, "OID_CLIE")).longValue());
                    
                    dtoCliente.setOid(lOidCliente);
                    UtilidadesLog.debug("Oid Cliente Obtenidos: " + lOidCliente);
                    
                    if (rs.getValueAt(i, "COD_EMPL") !=null) {
                        sCodEmple = rs.getValueAt(i, "COD_EMPL").toString();
                        dtoCliente.setCodigoEmpleado(sCodEmple);
                        UtilidadesLog.debug("Codigo Empleado Obtenidos: " + sCodEmple);
                    }
                    
                     if (rs.getValueAt(i, "VAL_TOPE_MAXI") !=null) {
                        BigDecimal topeMax = (BigDecimal)rs.getValueAt(i, "VAL_TOPE_MAXI");
                        dtoCliente.setTopeMaximo(topeMax);
                        UtilidadesLog.debug("Tope Max Obtenidos: " + topeMax);
                    }
                    
                     if (rs.getValueAt(i, "VAL_TOPE_MINI") !=null) {
                        BigDecimal topeMin = (BigDecimal)rs.getValueAt(i, "VAL_TOPE_MINI");
                        dtoCliente.setTopeMinimo(topeMin);
                        UtilidadesLog.debug("Tope Min Obtenidos: " + topeMin);
                    }
                    
                    array.add(dtoCliente);
            }
          }
		}

        UtilidadesLog.info("MONCalculoComisionesBean.validarListaGerentes(RecordSet rs): Salida");
        return array;
    }
    
    private CongeladosLocalHome getCongeladosLocalHome()  throws MareException {
            
       return new CongeladosLocalHome();
    }


     private ComisionesCalculadasLocalHome getComisionesCalculadasLocalHome()  throws MareException {
        
       return new ComisionesCalculadasLocalHome();
    }

}
