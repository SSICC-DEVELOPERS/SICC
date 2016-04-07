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
package es.indra.sicc.logicanegocio.app;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.app.DTOClienteChequeo;
import es.indra.sicc.dtos.app.DTOSolicCabecSecu;
import es.indra.sicc.dtos.app.DTOSolicitudCabeceraSecuenciaAcumulado;
import es.indra.sicc.dtos.app.DTOTerritorioRuta;

import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;


// Incidencia 8905 resuelta
import es.indra.sicc.dtos.fac.DTOSolicitudCabeceraSecuenciaAcum;
import es.indra.sicc.entidades.ped.SolicitudCabeceraSecuenciaLocal;
import es.indra.sicc.entidades.ped.SolicitudCabeceraSecuenciaLocalHome;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

// Eliminado mientras que copiaDTO esté comentado
//import java.math.BigDecimal;

import java.math.BigDecimal;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.util.HashMap;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONSecuYMarcasChequeoBean implements SessionBean {

	private SessionContext ctx;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
		 this.ctx = ctx;
    }

	// Incidencia 8905 resuelta. Incidencia 9407 resuelta
    public DTOFACCabeceraSolicitud[] generarSecuenciacionPorMonitor(
        DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarSecuenciacionPorMonitor(DTOFACCabeceraSolicitud[] dtoE): Entrada ");

        //Realiza la secuenciación dentro de una zona de la lista de consolidados recibidos
        //Se ordena la lista de consolidados por secuencia de zonas/rutas 
        //y por código de cliente de forma ascendente 		
        DAOAPP dao = new DAOAPP();
        Long numSecu = null;
        DTOSolicCabecSecu dtoSCS = null;
        DTOFACCabeceraSolicitud[] dtoConsolidados;

        dtoConsolidados = this.ordenarPorSecuZonaRutaYCliente(dtoE);
        
        
        /*
         * DBLG700000178 - dmorello, 17/11/2006
         * En esta hashtable se guardarán como key objetos ZonaFechaFacturacion
         * y como values objetos Long, que guardan el último numero de secuencia
         * utilizado para una zona y una fecha de facturación dadas.
         */
        Hashtable tablaNumSec = null;
        ZonaFechaFacturacion zff = null;
        if (dtoConsolidados.length > 0) {
          tablaNumSec = new Hashtable();
        }

        //Recorremos el array de DTOFACCabeceraSolicitud[]
        for (int i = 0; i < dtoConsolidados.length; i++) {
            //obtenemos el máximo número de secuencia diaria de facturación para la zona 
            //y fecha de Facturación de cada elemento de la lista, y le sumamos 1 

            Long zona = dtoConsolidados[i].getZona();
            
            
            //Se utiliza la fecha por defecto para evitar un nullPointer con la fecha
            //igualmente, el valor debe ser validado con Belcorp.
            //Gacevedo (20/09/2006)
            Date fecha = new Date(System.currentTimeMillis());
            
            
            //Segun JYepes, si no tiene fecha de facturacion, debe
            //usarse la fecha prevista de facturacion. (Gacevedo 20/09/2006)
            if(dtoConsolidados[i].getFechaFacturacion()!=null){
               fecha = new Date(dtoConsolidados[i].getFechaFacturacion().getTime());
            }else if(dtoConsolidados[i].getFechaPrevistaFacturacion()!=null){
               fecha = new Date(dtoConsolidados[i].getFechaPrevistaFacturacion().getTime());
            }

            /*
             * DBLG700000178 - dmorello, 17/11/2006
             * Si el ultimo numero de secuencia para una zona y una fecha dadas
             * esta en la hashtable se toma de ahi; en caso contrario, se
             * traera desde la BD.
             */
            //numSecu = dao.obtenerMaximaSecuFactuDiariaZonaFecha(zona, fecha);
            zff = new ZonaFechaFacturacion();
            zff.setOidZona(zona);
            zff.setFechaFacturacion(fecha);
            
            //numSecu = (Long)tablaNumSec.get(zff);
            DTOSolicitudCabeceraSecuenciaAcumulado dto
                    = (DTOSolicitudCabeceraSecuenciaAcumulado)tablaNumSec.get(zff);
            if (dto == null) {
               dto = new DTOSolicitudCabeceraSecuenciaAcumulado();
               dto.setFechaFacturacion(fecha);
               dto.setOidZona(zona);
               dto.setOidPais(dtoConsolidados[i].getOidPais());
               numSecu = this.obtenerMaximaSecuFactuDiariaZonaFecha(zona,fecha);
               if (numSecu.longValue() == 0) {
                  dto.setIndicadorUpdate(Boolean.FALSE);
               } else {
                  dto.setIndicadorUpdate(Boolean.TRUE);
               }
            } else {
               numSecu = dto.getNumeroSecuenciaAcumulado();
            }
            
            UtilidadesLog.debug("zff: " + zff);
            UtilidadesLog.debug("dto: " + dto);
            
            // Se guarda en la hashtable el DTO
            // con el ultimo nº de sec. para la zona y la fecha
            dto.setNumeroSecuenciaAcumulado(new Long(numSecu.longValue() + 1));
            tablaNumSec.put(zff,dto);
            UtilidadesLog.debug("tablaNumSec luego de agregar: " + tablaNumSec);
            
            /* Fin DBLG700000178 dmorello 17/11/2006 */
            
            dtoConsolidados[i].setNumeroSecuenciaFacturacionDiaria(new Integer(numSecu.intValue() +
                    1));
            dtoConsolidados[i].setNumeroSecuenciaImpresion(
                    new Integer(i+1)); //añadido por inciencia 19633

            /* dmorello, 20/11/2006: Se elimina el siguiente DTO porque no se usa */
            //dtoSCS = new DTOSolicCabecSecu();

            //dtoSCS.setOid(new Long(dtoConsolidados[i].getOidCabeceraSolicitud().toString()));
            //dtoSCS.setNumSecuenciaFacturacionDiaria(new Long(
            //        dtoConsolidados[i].getNumeroSecuenciaFacturacionDiaria().longValue()));
            //dtoSCS.setNumSecuenciaZonasRutas(new Long(
            //        dtoConsolidados[i].getNumeroSecuenciaZonaRuta().longValue()));
			// Pendiente de 9407
			//dtoSCS.setOidRuta(null);
			//dtoSCS.setSecuenciaRutaTerritorio(null);

            //**************incidencia 19102:**********************
            //Se comenta la llamada al método actualizarSolicitudCabeceraSecuencia
            //Esto es Para retrasar la insercion de datos despues de la llamada a insertarConsolidado.
            //this.actualizarSolicitudCabeceraSecuencia(dtoSCS);
            //************** fin incidencia 19102*******************
            //this.actualizarSolicitudCabeceraSecuencia(dtoSCS);
        }

        /* DBLG700000178 - dmorello, 20/11/2006 */
        this.actualizarSecuenciaAcum(tablaNumSec);


        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarSecuenciacionPorMonitor(DTOFACCabeceraSolicitud[] dtoE): Salida ");

        return dtoConsolidados;
    }

	// Incidencia 9672
    public DTOFACCabeceraSolicitud[] generarSecuenciacionPorRutas(
        DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarSecuenciacionPorRutas(DTOFACCabeceraSolicitud[] dtoE): Entrada");
        
        HashMap secuenciaDiaria = new HashMap();

        //Se recibe una lista de consolidados, y se ordena por el campo territorio. 
        Long numSecu = null;
        DTOSolicCabecSecu dtoSCS = null;
        DTOTerritorioRuta dtoTR = null;
        DTOFACCabeceraSolicitud[] dtoConsolidados = this.ordenarPorTerritorio(dtoE);
        
        UtilidadesLog.debug("**** info puesta por SCS, tema NUM_SECU_ZONA_RUTA !!");

        //Para cada elemento de dtoConsolidados se accede a la entidad APP:RutasTerritorios 
        //y se recuperan los atributos código de ruta y secuencia de ruta-territorio 
        //para actualizar esos datos en la entidad PED:SolicitudCabeceraSecuencia 
        
        UtilidadesLog.debug("**** El / los consolidados que recorrere: " + dtoConsolidados);
        
        for (int i = 0; i < dtoConsolidados.length; i++) {
        
            UtilidadesLog.debug("**** El oid cabecera sol. y el oid de conso. que analizo, son: " + dtoConsolidados[i].getOidCabeceraSolicitud() + " / " + dtoConsolidados[i].getOidConsolidado()); 
            UtilidadesLog.debug("**** y le corresponde el territorio: " + dtoConsolidados[i].getTerritorio());
        
            dtoTR = new DTOTerritorioRuta();
            dtoSCS = new DTOSolicCabecSecu();

            dtoTR.setOidPais(dtoConsolidados[i].getOidPais());
            dtoTR.setOidTerritorio(dtoConsolidados[i].getTerritorio());

            DAOAPP dao = new DAOAPP();
            UtilidadesLog.debug("**** voy a: obtenerRutaYSecuencias(.....con el DTOTerritorioRuta: " + dtoTR);
            dtoSCS = dao.obtenerRutaYSecuencias(dtoTR);
			
			dtoSCS.setOid(new Long(dtoConsolidados[i].getOidCabeceraSolicitud().toString()));
    
            UtilidadesLog.debug("*** dtoSCS = "+dtoSCS);        
			// Modificado por la incidencia 9672. 
			if(dtoSCS.getOidRuta()!=null){
	           
		        // Actualizo en el dtoConsolidados la secuencia zonas-rutas 
			    // y la secuencia ruta-territorio, 
				// porque posteriormente se ordenarán los consolidados por este 
				// último atributo 
                
                UtilidadesLog.debug("*** al consolidado con cabecera: " + dtoConsolidados[i].getOidCabeceraSolicitud() 
                                   + " y oid de consolidado: " + dtoConsolidados[i].getOidConsolidado() + 
                                   " le corresp. sec. zona/ruta: " + dtoSCS.getNumSecuenciaZonasRutas().intValue() + 
                                   " y ruta/terr. : " + dtoSCS.getSecuenciaRutaTerritorio());
                
	            dtoConsolidados[i].setNumeroSecuenciaZonaRuta(new Integer(
		                dtoSCS.getNumSecuenciaZonasRutas().intValue()));
			    dtoConsolidados[i].setSecuenciaRutaTerritorio(dtoSCS.getSecuenciaRutaTerritorio());

			}else{
				//se asigna un 0, para poder realizar la ordenación (debido a que no se encontro ruta 
				//al llamar al metodo obtenerRutaYsecuencias
                UtilidadesLog.debug("**** No se hallo ruta, pongo 0's  !");
				dtoConsolidados[i].setNumeroSecuenciaZonaRuta(new Integer(0));
				dtoConsolidados[i].setSecuenciaRutaTerritorio("0");
			}
			//Actualizar/insertar los campos ruta, secuencia de zonas rutas 
	        //y secuencia de ruta-territorio en la entidad PED:SolicitudCabeceraSecuencia 
		    
            //**************incidencia 19102:**********************
            //Se comenta la llamada al método actualizarSolicitudCabeceraSecuencia
            //Esto es Para retrasar la insercion de datos despues de la llamada a insertarConsolidado.
            //this.actualizarSolicitudCabeceraSecuencia(dtoSCS);
            //se setea el oidRuta a dtoConsolidados[i]
            UtilidadesLog.debug("Agregamos el oid ruta a dtoConsolidados[i] que es: "+dtoSCS.getOidRuta());
            dtoConsolidados[i].setOidRuta(dtoSCS.getOidRuta());
            //************** fin incidencia 19102*******************
		}

        // Se re-ordena la lista de consolidados dtoConsolidados 
        // por secuencia ruta-territorio y dentro de ésta por código de cliente
        
        UtilidadesLog.debug("**** voy a ordenar el arreglo de dtoConsolidados: " + dtoConsolidados);
        DTOFACCabeceraSolicitud[] dtoConsolidadosF = this.ordenarPorSecuRutaTerriYCliente(dtoConsolidados);
        UtilidadesLog.debug("**** ordenado queda: " + dtoConsolidadosF);

        for (int i = 0; i < dtoConsolidadosF.length; i++) {
            // Obtenemos el máximo número de secuencia diaria de facturación para el país,
            // ruta y fecha de Facturación de cada elemento de la lista, y le sumamos 1
            DAOAPP dao = new DAOAPP();
            UtilidadesLog.debug("*** dtoConsolidados["+i+"] = "+dtoConsolidados[i]);
            UtilidadesLog.debug("*** dtoConsolidadosF["+i+"] = "+dtoConsolidadosF[i]);
            Date fecha = new Date(dtoConsolidados[i].getFechaFacturacion().getTime());
            UtilidadesLog.debug("*** como fecha queda: " + fecha);
            
            Long ruta = new Long(dtoConsolidadosF[i].getNumeroSecuenciaZonaRuta().longValue());
            UtilidadesLog.debug("*** como ruta queda: " + ruta);
            //@ssaavedr 07/09/2005 segun charla con JF, implementamos una hash, para ver primero si
            //el valor de secuencia que voy a buscar esta en ella, dado que si siempre voy a buscarlo
            //a la tabla y luego le sumo uno, como todavia no esta persistido, siempre estare en el mismo valor!
            
            if (secuenciaDiaria.containsKey(ruta))
            {
                //al estar el la hash le sumo uno y lo guardo otra vez
                UtilidadesLog.debug("esta en la hash, lo tomo y le sumo 1");
                numSecu = new Long( ((Long)secuenciaDiaria.get(ruta)).longValue() + 1);
                secuenciaDiaria.put(ruta, numSecu);
                UtilidadesLog.debug("SCS 1, queda: " + numSecu);
            } else {
                numSecu = dao.obtenerMaximaSecuFactuDiariaPaisRutaFecha(dtoConsolidadosF[i].getOidPais(),
                                                                        ruta, fecha);
                UtilidadesLog.debug("NO esta en la hash, lo busco en la tabla y le sumo 1");                                                                        
                //como no lo halle en la hash, lo busco y lo acumulo en la misma ya sumado                                                         
                numSecu = new Long(numSecu.longValue() + 1);                                                        
                secuenciaDiaria.put(ruta, numSecu);
                UtilidadesLog.debug("SCS 2, queda: " + numSecu);
            } 
            
            UtilidadesLog.debug("*** como maxima secuencia de fact. diaria x pais ruta, queda: " + numSecu);
                    
            //dtoConsolidadosF[i].setNumeroSecuenciaFacturacionDiaria(new Integer(numSecu.intValue() + 1));
            dtoConsolidadosF[i].setNumeroSecuenciaFacturacionDiaria(new Integer(numSecu.intValue()));             
            
            dtoConsolidadosF[i].setNumeroSecuenciaImpresion(new Integer(i+1)); //añadido por incidencia 19633
            UtilidadesLog.debug("*** el atributo del dto consolidado: NumeroSecuenciaFacturacionDiaria, se actualizo con: " + dtoConsolidadosF[i].getNumeroSecuenciaFacturacionDiaria());
            
            dtoSCS = new DTOSolicCabecSecu();
            dtoSCS.setOid(dtoConsolidadosF[i].getOidCabeceraSolicitud());

            dtoSCS.setNumSecuenciaFacturacionDiaria(new Long(
                    dtoConsolidadosF[i].getNumeroSecuenciaFacturacionDiaria()
                                       .longValue()));
            //UtilidadesLog.info("*** voy a actualizar cabecera secuencia, con el DTOSolicCabecSecu: " + dtoSCS);
            
            //**************incidencia 19102:**********************
            //Se comenta la llamada al método actualizarSolicitudCabeceraSecuencia
            //Esto es Para retrasar la insercion de datos despues de la llamada a insertarConsolidado.
            //this.actualizarSolicitudCabeceraSecuencia(dtoSCS);
            //se setea el oidRuta a dtoConsolidados[i]
            UtilidadesLog.debug("Agregamos el oid ruta a dtoConsolidadosF[i]");
            //dtoConsolidadosF[i].setOidRuta(dtoConsolidados);
            //************** fin incidencia 19102*******************
            
        }

        UtilidadesLog.debug("**** el dto consolidados final que retorno es: " + dtoConsolidadosF);
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarSecuenciacionPorRutas(DTOFACCabeceraSolicitud[] dtoE): Entrada"); 
        
        return dtoConsolidadosF;
    }

    public DTOFACConsolidado[] generarMarcasChequeo(DTOFACConsolidado[] dtoE)
        throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarMarcasChequeo(DTOFACConsolidado[] dtoE): Entrada");
        //IMPORTANTE: Se eliminaron todas las llamadas a actualizarTablas ya que
        //el valor de indicador de revisión se actualiza en el dtoE y posteriormente
        //se inserta en el método insertarConsolidado

        //Se generan marcas que identifican aquellas consultoras 
        //para las que se deben realizar chequeos, bien en línea, en campo o ambas
        //Se accede a la entidad REC:ClientesAChequear para cada registro de la lista recibida 
        //y se obtiene una relación de los clientes que tienen que ser chequeados: 
        DTOClienteChequeo dtoChequeo = null;
        DTOClienteChequeo dtoChequeoLinea = null;
        DTOClienteChequeo dtoZonaChequeo = null;
        Long oidIndicadorRevision = null;

        Boolean esNuevo = null;
        Boolean esChequeoLinea = null;
        Boolean esChequeoCampo = null;
        Boolean esZonaChequeo = null;
        DAOAPP dao = null;

        for (int i = 0; i < dtoE.length; i++) {
            dtoChequeo = new DTOClienteChequeo();
            dtoChequeo.setOidPais(dtoE[i].getDtoCabecera().getOidPais());
            dtoChequeo.setOidMarca(dtoE[i].getDtoCabecera().getMarca());
            dtoChequeo.setOidCanal(dtoE[i].getDtoCabecera().getCanal());
            dtoChequeo.setOidPeriodo(dtoE[i].getDtoCabecera().getPeriodo());

            dtoChequeo.setOidClienteReceptorFactura(dtoE[i].getDtoCabecera()
                                                           .getReceptorFactura());
            dao = new DAOAPP();
            oidIndicadorRevision = dao.obtenerRevisionClientesAChequear(dtoChequeo);

            //Actualizar el atributo Indicador de revisión 
            //de la entidad PED:SolicitudCabecera con el obtenido 
            //en la entidad REC:ClientesAChequear
            //Eliminado: Ver nota arriba
            /*this.actualizarSolicitudCabecera(dtoE[i].getDtoCabecera()
                                                    .getOidCabeceraSolicitud(),
                                                    oidIndicadorRevision);*/
            
            //Seteamos el indicador de revision                                  
            dtoE[i].getDtoCabecera().setIndicadorRevision(oidIndicadorRevision);
        }

        // fin for
        for (int i = 0; i < dtoE.length; i++) { /*chequeo línea y campo*/
                        esNuevo = dao.esClienteNuevo(dtoE[i].getDtoCabecera().getOidCliente());
            if (esNuevo.booleanValue()) {
                //Se valida si el cliente nuevo debe ser chequeado en línea por un lado y en campo por otro.
                //CHEQUEO EN LINEA 
                //Se accede a la entidad REC:ConfiguracionClientesChequeoLinea
                dtoChequeoLinea = new DTOClienteChequeo();
                dtoChequeoLinea.setOidPeriodo(dtoE[i].getDtoCabecera()
                                                     .getPeriodo());
                dtoChequeoLinea.setOidSubgerencia(dtoE[i].getDtoCabecera()
                                                         .getOidSubgVentas());
                dtoChequeoLinea.setOidRegion(dtoE[i].getDtoCabecera().getRegion());
                dtoChequeoLinea.setOidZona(dtoE[i].getDtoCabecera().getZona());
                dtoChequeoLinea.setOidSeccion(dtoE[i].getDtoCabecera()
                                                     .getSeccion());

                esChequeoLinea = dao.esConfiguracionChequeoEnLinea(dtoChequeoLinea);

                if (esChequeoLinea.booleanValue()) {
                    //Actualizar el campo indicador de revisión del elemento
                    //de la lista de consolidados que nos pasaron como argumento de entra
                    dtoE[i].getDtoCabecera().setIndicadorRevision(ConstantesPED.OID_REVISION_LINEA);
                }

                //CHEQUEO EN CAMPO 
                //Se accede a la entidad REC:ConfiguracionClientesChequeoCampo 
                esChequeoCampo = dao.esConfiguracionChequeoEnCampo(dtoE[i].getDtoCabecera()
                                                                          .getPeriodo());

                if (esChequeoCampo.booleanValue()) {
                    //Si antes era en línea y ahora es en campo, debe actualizarse a ambas 
                    if (dtoE[i].getDtoCabecera().getIndicadorRevision() == ConstantesPED.OID_REVISION_LINEA) {
                        dtoE[i].getDtoCabecera().setIndicadorRevision(ConstantesPED.OID_REVISION_AMBAS);
                    } else {
                        dtoE[i].getDtoCabecera().setIndicadorRevision(null);
                    }

                   
                    if (dtoE[i].getDtoCabecera().getIndicadorRevision() == null) {
                        dtoE[i].getDtoCabecera().setIndicadorRevision(ConstantesPED.OID_REVISION_CAMPO);
                    }
                }

                //Fin chequeo campo
            }

            //Fin si es nuevo
        }

        /*Fin chequeo línea y campo*/
        for (int i = 0; i < dtoE.length; i++) { /*zonas chequeo en campo*/

            if ((dtoE[i].getDtoCabecera().getIndicadorRevision() != ConstantesPED.OID_REVISION_CAMPO) &&
                    (dtoE[i].getDtoCabecera().getIndicadorRevision() != ConstantesPED.OID_REVISION_AMBAS)) {
                dtoZonaChequeo = new DTOClienteChequeo();
                dtoZonaChequeo.setOidPeriodo(dtoE[i].getDtoCabecera()
                                                    .getPeriodo());
                dtoZonaChequeo.setOidSubgerencia(dtoE[i].getDtoCabecera()
                                                        .getOidSubgVentas());
                dtoZonaChequeo.setOidRegion(dtoE[i].getDtoCabecera().getRegion());
                dtoZonaChequeo.setOidZona(dtoE[i].getDtoCabecera().getZona());
                dtoZonaChequeo.setOidSeccion(dtoE[i].getDtoCabecera()
                                                    .getSeccion());

                esZonaChequeo = dao.esZonaChequeoEnCampo(dtoZonaChequeo);

                if (esZonaChequeo.booleanValue()) {
                    //Si antes era en línea y ahora es en campo, debe actualizarse a ambas 
                    if (dtoE[i].getDtoCabecera().getIndicadorRevision() == ConstantesPED.OID_REVISION_LINEA) {
                        dtoE[i].getDtoCabecera().setIndicadorRevision(ConstantesPED.OID_REVISION_AMBAS);
                    } else {
                        dtoE[i].getDtoCabecera().setIndicadorRevision(null);
                    }
                    if (dtoE[i].getDtoCabecera().getIndicadorRevision() == null) {
                        dtoE[i].getDtoCabecera().setIndicadorRevision(ConstantesPED.OID_REVISION_CAMPO);
                    }
                }
            }
        }

        /* Fin Zonas chequeo campo */
        //Ver nota arriba
        /*for (int i = 0; i < dtoE.length; i++) {
            //Actualizar el atributo Indicador de revisión de la entidad PED:SolicitudCabecera 
            this.actualizarSolicitudCabecera(dtoE[i].getDtoCabecera()
                                                    .getOidCabeceraSolicitud(),
                dtoE[i].getDtoCabecera().getIndicadorRevision());
        }*/
        //comprobamos el valor del indicador
        for(int i = 0; i < dtoE.length; i++)
        {
            UtilidadesLog.debug("El indicador de revision es: "+dtoE[i].getDtoCabecera().getIndicadorRevision());
        }

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarMarcasChequeo(DTOFACConsolidado[] dtoE): Salida");

        return dtoE;
    }

    private DTOFACCabeceraSolicitud[] ordenarPorSecuZonaRutaYCliente(
        DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.ordenarPorSecuZonaRutaYCliente(DTOFACCabeceraSolicitud[] dtoE): Entrada");

        //Se ordena la lista de consolidados según el número de secuencia de zonas/rutas,
        //y dentro de ese campo por el código de cliente de forma ascendente
        DTOFACCabeceraSolicitud[] dtoFCSFinal = new DTOFACCabeceraSolicitud[dtoE.length];
        DTOFACCabeceraSolicitud[] dtoFCSAux;
        Integer secuenciaMenor = null;
        Integer indiceMenor = null;
        dtoFCSAux = this.copiaDto(dtoE);

        int j = 0;
        int numMaxEle = dtoFCSAux.length;

        while (j < numMaxEle) {
			//se hace esta comprobación, por si el numeroSecuenciaZonaRuta(del primer
			//elemento que tomamos como referencia) es nulo. incidencia 11748
			if (dtoFCSAux[0].getNumeroSecuenciaZonaRuta()==null){
				dtoFCSAux[0].setNumeroSecuenciaZonaRuta(new Integer(0));
			}
            secuenciaMenor = dtoFCSAux[0].getNumeroSecuenciaZonaRuta();
            indiceMenor = new Integer(0);

            //Obtenemos cuál es el índice de la lista en el que se encuentra la secuencia menor
            for (int i = 0; i < dtoFCSAux.length; i++) {
				//se hace esta comprobación, por si el numeroSecuenciaZonaRuta de algun elemento del arrayList fuera nulo,
				//si es asi, le asignamos un cero. incidencia 11748
				if (dtoFCSAux[i].getNumeroSecuenciaZonaRuta()==null){
					dtoFCSAux[i].setNumeroSecuenciaZonaRuta(new Integer(0));
				}
                if (dtoFCSAux[i].getNumeroSecuenciaZonaRuta().intValue() < secuenciaMenor.intValue()) {
                    indiceMenor = new Integer(i);
                }
            }

            dtoFCSFinal[j] = dtoFCSAux[indiceMenor.intValue()];
            j++;

            dtoFCSAux = this.borrarElementoLista(dtoFCSAux, indiceMenor);
        }

        //Fin While
        dtoFCSAux = dtoFCSFinal;
        dtoFCSFinal = new DTOFACCabeceraSolicitud[dtoE.length];
        j = 0;

        numMaxEle = dtoFCSAux.length;

        while (j < numMaxEle) {
            Long clienteMenor = dtoFCSAux[0].getOidCliente();
            indiceMenor = new Integer(0);

            Integer secuenciaActual = dtoFCSAux[0].getNumeroSecuenciaZonaRuta();

            //Obtenemos cuál es el índice de la lista en el que se encuentra 
            //el cliente menor dentro de la misma secuencia de zonas/rutas
            int i = 0;
            int numMaxElementos = dtoFCSAux.length;

            while ((i < numMaxElementos) &&
                    (secuenciaActual == dtoFCSAux[i].getNumeroSecuenciaZonaRuta())) {
                if (dtoFCSAux[i].getOidCliente().intValue() < clienteMenor.intValue()) {
                    indiceMenor = new Integer(i);
                }

                i++;
            }

            //fin while 
            dtoFCSFinal[j] = dtoFCSAux[indiceMenor.intValue()];
            j++;

            dtoFCSAux = this.borrarElementoLista(dtoFCSAux, indiceMenor);
        }

        //fin Mientras existan elementos en la lista dtoAux /*cliente*/ 
        //En este momento la lista dtoFinal está ordenada por secuencia de zonas/rutas y código de cliente 
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.ordenarPorSecuZonaRutaYCliente(DTOFACCabeceraSolicitud[] dtoE): Salida");

        return dtoFCSFinal;
    }

    private DTOFACCabeceraSolicitud[] ordenarPorTerritorio(
        DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.ordenarPorTerritorio(DTOFACCabeceraSolicitud[] dtoE): Entrada");

        //Se ordena la lista de consolidados por territorio
        DTOFACCabeceraSolicitud[] dtoFinal = new DTOFACCabeceraSolicitud[dtoE.length];
        DTOFACCabeceraSolicitud[] dtoAux;
        Integer indiceMenor = null;

        dtoAux = this.copiaDto(dtoE);

        int j = 0;
        int numMaxEle = dtoAux.length;

        while (j < numMaxEle) {
            Long territorioMenor = dtoAux[0].getTerritorio();
            indiceMenor = new Integer(0);

            //Obtenemos cuál es el índice de la lista en el que se encuentra el territorio menor 
            for (int i = 0; i < dtoAux.length; i++) {
                if (dtoAux[i].getTerritorio().longValue() < territorioMenor.longValue()) {
                    indiceMenor = new Integer(i);
                }
            }

            dtoFinal[j] = dtoAux[indiceMenor.intValue()];
            j++;

            dtoAux = this.borrarElementoLista(dtoAux, indiceMenor);
        }

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.ordenarPorTerritorio(DTOFACCabeceraSolicitud[] dtoE): Salida");

        return dtoFinal;
    }

    private DTOFACCabeceraSolicitud[] ordenarPorSecuRutaTerriYCliente(
        DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.ordenarPorSecuRutaTerriYCliente(DTOFACCabeceraSolicitud[] dtoE): Entrada");

        //Se ordena la lista de consolidados según la secuencia ruta-territorio 
        //y dentro de ese campo por el código de cliente de forma ascendente
        DTOFACCabeceraSolicitud[] dtoFinal = new DTOFACCabeceraSolicitud[dtoE.length];
        DTOFACCabeceraSolicitud[] dtoAux;
        Integer indiceMenor = null;
        Integer secuenciaMenor = null;
        Long clienteMenor = null;
        Integer secuenciaActual = null;
        dtoAux = this.copiaDto(dtoE);

        int j = 0;
        int numMaxEle = dtoAux.length;

        while (j < numMaxEle) {
			//se hace esta comprobación, por si el numeroSecuenciaZonaRuta(del primer
			//elemento que tomamos como referencia) es nulo. incidencia 11748
			if (dtoAux[0].getSecuenciaRutaTerritorio()==null){
				dtoAux[0].setSecuenciaRutaTerritorio("0");
			}
            secuenciaMenor = new Integer(dtoAux[0].getSecuenciaRutaTerritorio());
            indiceMenor = new Integer(0);

            //Obtenemos cuál es el índice de la lista en el que se encuentra la secuencia menor 
            for (int i = 0; i < dtoAux.length; i++) {
				//se hace esta comprobación, por si el numeroSecuenciaZonaRuta de algun elemento del arrayList fuera nulo,
				//si es asi, le asignamos un cero. incidencia 11748
				if (dtoAux[i].getSecuenciaRutaTerritorio()==null){
					dtoAux[i].setSecuenciaRutaTerritorio("0");
				}
                if (new Integer(dtoAux[i].getSecuenciaRutaTerritorio()).intValue() < secuenciaMenor.intValue()) {
                    indiceMenor = new Integer(i);
                }
            }

            dtoFinal[j] = dtoAux[indiceMenor.intValue()];
            j++;

            dtoAux = borrarElementoLista(dtoAux, indiceMenor);
        }

        // fin while
        dtoAux = dtoFinal;
        dtoFinal = new DTOFACCabeceraSolicitud[dtoE.length];
        j = 0;
        numMaxEle = dtoAux.length;

        while (j < numMaxEle) {
            clienteMenor = dtoAux[0].getOidCliente();
            indiceMenor = new Integer(0);
            secuenciaActual = new Integer(dtoAux[0].getSecuenciaRutaTerritorio());

            //Obtenemos cuál es el índice de la lista en el que se encuentra 
            //el cliente menor dentro de la misma secuencia de zonas/rutas
            int i = 0;

            while ((i < dtoAux.length) &&
                    (secuenciaActual == new Integer(dtoAux[i].getSecuenciaRutaTerritorio()))) {
                if (dtoAux[i].getOidCliente().intValue() < clienteMenor.intValue()) {
                    indiceMenor = new Integer(i);
                }

                i++;
            }

            // fin while
            dtoFinal[j] = dtoAux[indiceMenor.intValue()];
            j++;

            dtoAux = this.borrarElementoLista(dtoAux, indiceMenor);
        }

        //fin while
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.ordenarPorSecuRutaTerriYCliente(DTOFACCabeceraSolicitud[] dtoE): Salida");

        return dtoFinal;
    }

    private DTOFACCabeceraSolicitud[] borrarElementoLista(
        DTOFACCabeceraSolicitud[] dtoE, Integer indice)
        throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.borrarElementoLista(DTOFACCabeceraSolicitud[] dtoE, Integer indice): Entrada");

        //Crea una lista nueva con un elemento menos que la lista de entrada, 
        //el correspondiente a la posición "indice" de la lista que se pasa 
        //como argumento de entrada no se incluye en la nueva lista 
        DTOFACCabeceraSolicitud[] dtoFinal = new DTOFACCabeceraSolicitud[dtoE.length -
            1];
        int j = 0;

        for (int i = 0; i < dtoE.length; i++) {
            if (i != indice.intValue()) {
                dtoFinal[j] = dtoE[i];
                j++;
            }
        }

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.borrarElementoLista(DTOFACCabeceraSolicitud[] dtoE, Integer indice): Salida ");

        return dtoFinal;
    }

    //INCIDENCIA BELC300008623 
    private void actualizarSolicitudCabecera(Long oidSolicitudCabecera,
        Long oidIndicadorRevision) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.actualizarSolicitudCabecera(Long oidSolicitudCabecera, Long oidIndicadorRevision): Entrada");

        //Actualiza el Indicador de Revisión del una solicitud de la entidad PED:SolicitudCabecera
        DAOSolicitud dao = new DAOSolicitud();
        dao.actualizarIndicadorRevision(oidSolicitudCabecera,oidIndicadorRevision);
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.actualizarSolicitudCabecera(Long oidSolicitudCabecera, Long oidIndicadorRevision): Salida");
    }

    private SolicitudCabeceraSecuenciaLocalHome getSolicitudCabeceraSecuenciaLocalHome() throws MareException {
        return new SolicitudCabeceraSecuenciaLocalHome();
    }


    private DTOFACCabeceraSolicitud[] copiaDto(DTOFACCabeceraSolicitud[] dtoE) {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.copiaDto(DTOFACCabeceraSolicitud[] dtoE): Entrada ");

        DTOFACCabeceraSolicitud[] dtoCopia = new DTOFACCabeceraSolicitud[dtoE.length];

		// Añadido por hsanchez dada la constante variación del DTOFACCabeceraSolicitud
        for (int i = 0; i < dtoE.length; i++) {
			dtoCopia[i] = dtoE[i];			
        }

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.copiaDto(DTOFACCabeceraSolicitud[] dtoE): Salida ");

        return dtoCopia;
    }

	
    //incidencia 19102:
    //Se cambia el método a publico
    //Esto es Para retrasar la insercion de datos despues de la llamada a insertarConsolidado.
    public void actualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE) throws MareException
    {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.actualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE): Entrada");

        // Actualiza o inserta información de una solicitud cabecera secuencia en la 
        // entidad PED:SolicitudCabeceraSecuencia     
		// Incidencia 8630 resuelta
        SolicitudCabeceraSecuenciaLocalHome home = this.getSolicitudCabeceraSecuenciaLocalHome();
        SolicitudCabeceraSecuenciaLocal local = null;

		boolean existe = true;
        try {
            local = home.findByPrimaryKey(dtoE.getOid());
        } catch (NoResultException e) {
            // No lo encontramos lo creamos	
			existe = false;
        }


		if(!existe){
			// Si no existe lo creo
            try {
				// Como alguno de estos puede ser null, creo con la UK y luego
				// modifico los no nulos
                local = home.create(dtoE.getOid());
            } catch (PersistenceException ce) {
				ctx.setRollbackOnly();
                UtilidadesLog.error("actualizarSolicitudCabeceraSecuencia: CreateException", ce);
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_INTEGRIDAD_INSERCION));
            }
		} 

	    // Realizamos una actualización, sólo se tendrán en cuenta los campos del
        // DTOE que no sean nulos
		try{
			if (dtoE.getOidRuta() != null) {
				local.setRuta(dtoE.getOidRuta());
			}

			if (dtoE.getNumSecuenciaFacturacionDiaria() != null) {
				local.setNumSecuenciaFacturacionDiaria(dtoE.getNumSecuenciaFacturacionDiaria());
			}

			if (dtoE.getSecuenciaRutaTerritorio() != null) {
				local.setSecuenciaRutaTerritorio(dtoE.getSecuenciaRutaTerritorio());
			}

			if (dtoE.getNumSecuenciaZonasRutas() != null) {
				local.setNumSecuenciaZonasRutas(dtoE.getNumSecuenciaZonasRutas());
			}
                        home.merge(local);
		} catch (Exception re) {
			ctx.setRollbackOnly();
            UtilidadesLog.error("retrocesoCuenta: Exception, actualizarSolicitudCabeceraSecuencia.setXXX", re);
				throw new MareException(re, UtilidadesError.armarCodigoError(
						CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.actualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE): Salida ");
    }

    public void reversarActualizarSolicitudCabeceraSecuencia(DTOSolicCabecSecu dtoE) throws MareException{
        SolicitudCabeceraSecuenciaLocalHome home = this.getSolicitudCabeceraSecuenciaLocalHome();
        SolicitudCabeceraSecuenciaLocal local = null;
    		boolean existe = true;
        try {
            local = home.findByPrimaryKey(dtoE.getOid());
            home.remove(local);
        } catch (NoResultException e) {
        }catch (PersistenceException e){
            UtilidadesLog.error("actualizarSolicitudCabeceraSecuencia: RemoveException",e);
            throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));         
        }
    }


      /**
       * Devuelve el máximo número de secuencia para una zona y una fecha de
       * facturacion dadas. Si no encuentra info en la BD devuelve null.
       * Este metodo se utilizara en reemplazo del que aparece en DAOAPP con el
       * mismo nombre. Difiere en que levanta la info de la tabla
       * PED_SOLIC_CABEC_SECUE_ACUMU. Por incidencia DBLG700000178.
       * @author dmorello
       */
      private Long obtenerMaximaSecuFactuDiariaZonaFecha(Long zona, Date fechaFact)
              throws MareException {
        
          UtilidadesLog.info("MONSecuYMarcasChequeoBean.obtenerMaximaSecuFactuDiariaZonaFecha(Long pais, Long zona, Date fechaFact): Entrada");
  
          // Realiza una consulta utilizando el servicio DBService. 
          // Se obtiene el máximo número de secuencia de facturación diaria para una 
          // zona comercial y una fecha de consolidado 
          
          StringBuffer consulta = new StringBuffer();
          Vector parametros = new Vector();
          
          consulta.append(" SELECT NUM_SECU_FACT_DIAR_ACUM ");
          consulta.append(" FROM PED_SOLIC_CABEC_SECUE_ACUMU ");
          consulta.append(" WHERE ZZON_OID_ZONA = ? ");
          parametros.add(zona);
          consulta.append(" AND FEC_FACT = TO_DATE(?, ?) ");
          String dateFormat = "dd/MM/yyyy";
          parametros.add(new SimpleDateFormat(dateFormat).format(fechaFact));
          parametros.add(dateFormat);
  
          // Se ejecuta la consulta 
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          RecordSet resultado = null;
          String codigoError = null;
  
          try {
              resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
          } catch (Exception e) {
              codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              UtilidadesLog.error("obtenerMaximaSecuFactuDiariaZonaFecha: Exception", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          }
          
          Long valor;
          if (! resultado.esVacio()) {
              valor = new Long(((BigDecimal) resultado.getValueAt(0, 0)).longValue());
          } else {
              valor = new Long(0);
          }
          
          UtilidadesLog.debug("Ultimo num de secuencia: " + valor);
  
          UtilidadesLog.info("MONSecuYMarcasChequeoBean.obtenerMaximaSecuFactuDiariaZonaFecha(Long pais, Long zona, Date fechaFact): Salida");
          return valor;
      }
      
      private StringBuffer generarCadenaUpdateAcum(ZonaFechaFacturacion zff, Long numSecuAcum) {
          StringBuffer update = new StringBuffer();
          String dateFormat = "dd/MM/yyyy";
          
          update.append("UPDATE PED_SOLIC_CABEC_SECUE_ACUMU SET NUM_SECU_FACT_DIAR_ACUM = ") ;
          update.append(numSecuAcum);
          update.append(" WHERE ZZON_OID_ZONA = ").append(zff.getOidZona());
          update.append(" AND FEC_FACT = TO_DATE('");
          update.append(new SimpleDateFormat(dateFormat).format(zff.getFechaFacturacion()));
          update.append("','").append(dateFormat).append("');");
          
          return update;
      }
      
      private StringBuffer generarCadenaInsercionAcum(ZonaFechaFacturacion zff, DTOSolicitudCabeceraSecuenciaAcumulado dto) {
          StringBuffer update = new StringBuffer();
          Vector parametros = new Vector();
          String dateFormat = "dd/MM/yyyy";
          
          update.append(" INSERT INTO PED_SOLIC_CABEC_SECUE_ACUMU ( ") ;
          update.append(" OID_SOLI_CABE_SECU_ACUM, FEC_FACT, ZZON_OID_ZONA, PAIS_OID_PAIS, NUM_SECU_FACT_DIAR_ACUM) ");
          update.append(" VALUES (PED_SCSA_SEQ.NEXTVAL, TO_DATE('");
          update.append(new SimpleDateFormat(dateFormat).format(zff.getFechaFacturacion()));
          update.append("', 'dd/mm/yyyy'),").append(zff.getOidZona()).append(',');
          update.append(dto.getOidPais()).append(',').append(dto.getNumeroSecuenciaAcumulado()).append(");");
          
          return update;
      }
      
      
      private void actualizarSecuenciaAcum(Hashtable tablaNumSecAcum)
              throws MareException {
              
          UtilidadesLog.info("MONSecuYMarcasChequeoBean.actualizarSecuenciaAcum(Hashtable tablaNumSecAcum): Entrada");
              
          Iterator it = tablaNumSecAcum.keySet().iterator();
          StringBuffer sb = new StringBuffer();
          while(it.hasNext()) {
              ZonaFechaFacturacion zff = (ZonaFechaFacturacion)it.next();
              DTOSolicitudCabeceraSecuenciaAcumulado dto
                       = (DTOSolicitudCabeceraSecuenciaAcumulado)tablaNumSecAcum.get(zff);
              if (dto.getIndicadorUpdate() != null && dto.getIndicadorUpdate().booleanValue()) {
                  sb.append(this.generarCadenaUpdateAcum(zff,dto.getNumeroSecuenciaAcumulado()));
              } else {
                  sb.append(this.generarCadenaInsercionAcum(zff,dto));
              }
          }
          
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          String codigoError = null;
  
          try {
               bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
          } catch (Exception e) {
              codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              UtilidadesLog.error("actualizarSecuenciaAcumulada: Exception", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          }
          
          UtilidadesLog.info("MONSecuYMarcasChequeoBean.actualizarSecuenciaAcum(Hashtable tablaNumSecAcum): Salida");
        
      }

    public void generarMarcasChequeo(DTOFACConsolidado consolidado) throws MareException{
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarMarcasChequeo(DTOFACConsolidado consolidado): Entrada");
      
        // vbongiov -- Cambio 20080756 -- 29/04/2009  
        DTOClienteChequeo dtoChequeo = null;
        Long oidIndicadorRevision = null;
        Boolean esNuevo = null;
        DAOAPP dao = new DAOAPP();
        
        esNuevo = dao.esClienteNuevo(consolidado.getDtoCabecera().getOidCliente());
        
        if (esNuevo.booleanValue()) {    
            oidIndicadorRevision = dao.obtenerRevisionClientesAChequearNuevos();
            
        } else {
        
            dtoChequeo = new DTOClienteChequeo();
            dtoChequeo.setOidPais(consolidado.getDtoCabecera().getOidPais());
            dtoChequeo.setOidMarca(consolidado.getDtoCabecera().getMarca());
            dtoChequeo.setOidCanal(consolidado.getDtoCabecera().getCanal());
            dtoChequeo.setOidPeriodo(consolidado.getDtoCabecera().getPeriodo());

            dtoChequeo.setOidClienteReceptorFactura(consolidado.getDtoCabecera()
                                                           .getReceptorFactura());
         
            oidIndicadorRevision = dao.obtenerRevisionClientesAChequear(dtoChequeo);            
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();   
        
        consolidado.getDtoCabecera().setIndicadorRevision(oidIndicadorRevision);
        StringBuffer query2 = new StringBuffer();
        query2.append(" UPDATE PED_SOLIC_CABEC SET INRE_OID_INDI_REVI = " + consolidado.getDtoCabecera().getIndicadorRevision());
        query2.append(" WHERE OID_SOLI_CABE = " + consolidado.getDtoCabecera().getOidCabeceraSolicitud());
        try {
         bs.dbService.executeUpdate(query2.toString());   
        } catch (Exception e) {              
         UtilidadesLog.error("generarMarcasChequeo: Exception", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarMarcasChequeo(DTOFACConsolidado consolidado): Salida");
    }

    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

    /**
     * CHANGELOG
     * ---------
     * 15/07/2009 - dmorello, Incidente 20090966
     *    Para evitar inserciones de registros del mismo cliente (que explotan por violacion de UK)
     *    cada vez que se genera un insert/update se actualizan los datos del hashmap, apagando los flags
     *    indicadorUpdateZona e indicadorInsertCliente
     */
    public DTOFACCabeceraSolicitud[] generarSecuenciacionPorCliente(DTOFACCabeceraSolicitud[] dtoE, Character indicadorSecuenciacion) throws MareException {
       try {
            UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarSecuenciacionPorCliente(DTOFACCabeceraSolicitud[] dtoE, Character indicadorSecuenciacion): Entrada");
            HashMap hashSecuenciaDiaria = new HashMap();
            HashMap hashMaximosSecuencia = null;
            Long oidPais = dtoE[0].getOidPais();

            this.generarInsercionTemporalCabeceras(dtoE);
            HashMap hashRutas = (HashMap)this.obtenerSecuenciasClientes();            
            
            if (indicadorSecuenciacion.equals(new Character('F'))) {
                hashMaximosSecuencia = (HashMap)this.obtenerMaximosSecuencias();    
            }

            int dtoEmide = dtoE.length;
            ArrayList arrayRutasClientes = new ArrayList();
            StringBuffer query = new StringBuffer();
            for (int i = 0; i < dtoEmide; i++) {  
                DTOSolicCabecSecu dtoSCS = (DTOSolicCabecSecu)hashRutas.get(dtoE[i].getOidCliente());
                if (dtoSCS.getIndicadorUpdateZona().booleanValue() || dtoSCS.getIndicadorInsertCliente().booleanValue()) {
                    dtoE[i].setNumeroSecuenciaZonaRuta(new Integer(dtoSCS.getNumeroSecuenciaNueva().intValue()));                    
                    dtoE[i].setOidRuta(dtoSCS.getOidRutaNueva());
                    if (indicadorSecuenciacion.equals(new Character('F'))) {
                        Long numeroSecuencia = new Long(0);
                        if (hashMaximosSecuencia.containsKey(dtoSCS.getOidRutaNueva())) {
                            numeroSecuencia = (Long)hashMaximosSecuencia.get(dtoSCS.getOidRutaNueva());
                        }
                        numeroSecuencia = new Long(numeroSecuencia.longValue() + 1);
                        dtoE[i].setSecuenciaRutaTerritorio(new String(this.rellenarHasta(dtoSCS.getNumeroSecuenciaNueva().toString(), 6).toString() +  this.rellenarHasta(numeroSecuencia.toString(), 6).toString()));
                        hashMaximosSecuencia.put(dtoSCS.getOidRutaNueva(), numeroSecuencia);
                    } else {
                        dtoE[i].setSecuenciaRutaTerritorio(new String(this.rellenarHasta(dtoSCS.getNumeroSecuenciaNueva().toString(), 6).toString() +  this.rellenarHasta("0", 6).toString()));
                    }
                    query.append(this.generarSentencias(dtoSCS, dtoE[i].getOidPais(), dtoE[i].getSecuenciaRutaTerritorio()).toString());
                    
                    // Modifico campos del DTO para que no se vuelva a hacer un insert o update
                    // del registro de APP_RUTAS_CLIEN afectado
                    dtoSCS.setIndicadorInsertCliente(Boolean.FALSE);
                    dtoSCS.setIndicadorUpdateZona(Boolean.FALSE);
                    dtoSCS.setNumSecuenciaZonasRutas(dtoSCS.getNumeroSecuenciaNueva());
                    dtoSCS.setOidRuta(dtoSCS.getOidRutaNueva());
                    dtoSCS.setSecuenciaRutaTerritorio(dtoE[i].getSecuenciaRutaTerritorio());
                } else {
                    dtoE[i].setNumeroSecuenciaZonaRuta(new Integer(dtoSCS.getNumSecuenciaZonasRutas().intValue()));                    
                    dtoE[i].setOidRuta(dtoSCS.getOidRuta());
                    dtoE[i].setSecuenciaRutaTerritorio(dtoSCS.getSecuenciaRutaTerritorio());
                }
                arrayRutasClientes.add(dtoE[i]);
            }
            
            try {
                BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
            } catch(Exception e) {
                UtilidadesLog.error("ERROR",e);
                throw new MareException(e);
            }    

            Collections.sort(arrayRutasClientes, new RutasClienteComparator());            
            
            HashMap hashFechaRuta = new HashMap();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int arrayRutasClientesLon = arrayRutasClientes.size();
            for (int i = 0; i < arrayRutasClientesLon; i++) {
                DTOFACCabeceraSolicitud dtoFACCa = (DTOFACCabeceraSolicitud)arrayRutasClientes.get(i);
                if (dtoFACCa.getFechaFacturacion()==null){
                    dtoFACCa.setFechaFacturacion(new Date(System.currentTimeMillis()));
                }
                if (dtoFACCa.getFechaPrevistaFacturacion()==null){
                    dtoFACCa.setFechaPrevistaFacturacion(new Date(System.currentTimeMillis()));
                }
                if (dtoFACCa.getFecha()==null){
                    dtoFACCa.setFecha(new Date(System.currentTimeMillis()));
                }
                Date fecha = new Date(dtoFACCa.getFechaFacturacion().getTime());
                Long ruta = new Long(dtoFACCa.getNumeroSecuenciaZonaRuta().longValue());
                if (!hashFechaRuta.containsKey(sdf.format(fecha).toString()+ruta.toString())){
                    DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = new DTOSolicitudCabeceraSecuenciaAcum();
                    dtoSolCabSecAcum.setOidPais(dtoFACCa.getOidPais());               
                    dtoSolCabSecAcum.setFechaFacturacion(fecha);
                    dtoSolCabSecAcum.setNumSecuenciaZonaRuta(ruta);
                    dtoSolCabSecAcum.setNumSecuenciaFacturacionDiariaAcum(new Long(0));
                    hashFechaRuta.put(sdf.format(fecha).toString()+ruta.toString(), dtoSolCabSecAcum);
                }            
            }
            
            hashFechaRuta = this.obtenerMaximaSecuFactuDiariaPaisRutaFecha(hashFechaRuta, oidPais);
            
            DTOFACCabeceraSolicitud[] dtoConsolidadosF = new DTOFACCabeceraSolicitud[arrayRutasClientesLon];
            
            for (int i = 0; i < arrayRutasClientesLon; i++) {
                DTOFACCabeceraSolicitud dtoFACCa = (DTOFACCabeceraSolicitud)arrayRutasClientes.get(i);
                Date fecha = new Date(dtoFACCa.getFechaFacturacion().getTime());
                Long ruta = new Long(dtoFACCa.getNumeroSecuenciaZonaRuta().longValue());
                DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)hashFechaRuta.get(sdf.format(fecha).toString()+ruta.toString());
                Integer numSecu = new Integer(dtoSolCabSecAcum.getNumSecuenciaFacturacionDiariaAcum().intValue());
                //if (arrayTiposSolicitud.contains(dtoFACCa.getTipoSolicitud()) && dtoFACCa.getNumeroUnidadesAtendidasTotal() != null && dtoFACCa.getNumeroUnidadesAtendidasTotal().longValue() > 0) {
                  numSecu = new Integer(numSecu.intValue() + 1);
                  dtoFACCa.setNumeroSecuenciaFacturacionDiaria(numSecu);
                /*} else {
                  dtoFACCa.setNumeroSecuenciaFacturacionDiaria(new Integer(0));
                } */                            

                dtoFACCa.setNumeroSecuenciaImpresion(new Integer(i+1)); 
                dtoSolCabSecAcum.setNumSecuenciaFacturacionDiariaAcum(new Long(numSecu.longValue()));
                hashFechaRuta.put(sdf.format(fecha).toString()+ruta.toString(),dtoSolCabSecAcum);    
                dtoConsolidadosF[i] = dtoFACCa;
            }
            
            this.actualizarSecuenciaAcumulada(hashFechaRuta);
      
            UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarSecuenciacionPorCliente(DTOFACCabeceraSolicitud[] dtoE, Character indicadorSecuenciacion): Salida");     
            return dtoConsolidadosF;
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
    }


    private void generarInsercionTemporalCabeceras(DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarInsercionTemporalCabeceras(DTOFACCabeceraSolicitud[] dtoE): Entrada");             
        StringBuffer query = new StringBuffer();
        
        query.append("DELETE PED_SOLIC_CABEC_TEMP2;");
        
        int totalArray = dtoE.length;
        for (int i = 0; i < totalArray; i++) {
            query.append("INSERT INTO PED_SOLIC_CABEC_TEMP2 (OID_SOLI_CABE) VALUES (").append(dtoE[i].getOidCabeceraSolicitud()).append(");");        
        }

        query.append("Analyze Table PED_SOLIC_CABEC_TEMP2 Compute Statistics;");        
        
        try {
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }    

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.generarInsercionTemporalCabeceras(DTOFACCabeceraSolicitud[] dtoE): Salida");     
    }


    private HashMap obtenerSecuenciasClientes() throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.obtenerSecuenciasClientes(): Entrada");  
        HashMap hashRutas = new HashMap();
        StringBuffer query = new StringBuffer();

        query.append("( ");
        query.append("SELECT ARC.RUTR_OID_RUTA_TRAN,  ");
        query.append("       LPAD(ART.NUM_SECU,6,'0') || LPAD(ARC.VAL_NUME_SECU,6,'0') SECUENCIARUTA,  ");
        query.append("       ART.NUM_SECU ,  ");
        query.append("       ARC.CLIE_OID_CLIE, ");
        query.append("       CASE WHEN (ART.COD_RUTA <> ZON.COD_ZONA) THEN ");
        query.append("           1 ");
        query.append("       ELSE ");
        query.append("           0 ");
        query.append("       END IND_UPDATE_ZONA, ");
        query.append("       0 IND_INSERT_CLIENTE, ");
        query.append("       CASE WHEN (ART.COD_RUTA <> ZON.COD_ZONA) THEN ");
        query.append("          (SELECT OID_RUTA_TRAN FROM APP_RUTAS_TRANS WHERE COD_RUTA = ZON.COD_ZONA) ");
        query.append("       END OID_RUTA_NUEVA, ");
        query.append("       CASE WHEN (ART.COD_RUTA <> ZON.COD_ZONA) THEN ");
        query.append("          (SELECT NUM_SECU FROM APP_RUTAS_TRANS WHERE COD_RUTA = ZON.COD_ZONA) ");
        query.append("       END NUM_SECU_NUEVA ");
        query.append("FROM APP_RUTAS_CLIEN ARC,  ");
        query.append("     APP_RUTAS_TRANS ART, ");
        query.append("     PED_SOLIC_CABEC PSC, ");
        query.append("     ZON_ZONA ZON,  ");
        query.append("     PED_SOLIC_CABEC_TEMP2 PSC2 ");
        query.append("WHERE ARC.RUTR_OID_RUTA_TRAN = ART.OID_RUTA_TRAN  ");
        query.append("  AND ART.PAIS_OID_PAIS = PSC.PAIS_OID_PAIS ");
        query.append("  AND PSC.OID_SOLI_CABE = PSC2.OID_SOLI_CABE ");
        query.append("  AND ARC.CLIE_OID_CLIE = PSC.CLIE_OID_CLIE ");
        query.append("  AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append(") ");
        query.append("UNION ALL ");
        query.append("( ");
        query.append("SELECT NULL RUTR_OID_RUTA_TRAN,  ");
        query.append("       NULL SECUENCIARUTA,  ");
        query.append("       NULL NUM_SECU,  ");
        query.append("       PSC.CLIE_OID_CLIE, ");
        query.append("       0 IND_UPDATE_ZONA, ");
        query.append("       1 IND_INSERT_CLIENTE, ");
        query.append("       (SELECT OID_RUTA_TRAN FROM APP_RUTAS_TRANS WHERE COD_RUTA = ZON.COD_ZONA) OID_RUTA_NUEVA, ");
        query.append("       (SELECT NUM_SECU FROM APP_RUTAS_TRANS WHERE COD_RUTA = ZON.COD_ZONA) NUM_SECU_NUEVA ");
        query.append("FROM PED_SOLIC_CABEC PSC, ");
        query.append("     ZON_ZONA ZON, ");
        query.append("     PED_SOLIC_CABEC_TEMP2 PSC2 ");
        query.append("WHERE PSC.OID_SOLI_CABE = PSC2.OID_SOLI_CABE  ");
        query.append("  AND PSC.CLIE_OID_CLIE NOT IN (SELECT CLIE_OID_CLIE FROM APP_RUTAS_CLIEN) ");
        query.append("  AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA  ");
        query.append(") ");
  
        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
  
        if (rs != null && !rs.esVacio()) {
            int records = rs.getRowCount();
            for (int i = 0;i < records;i++){
                DTOSolicCabecSecu dtoResultado = new DTOSolicCabecSecu();
                dtoResultado.setOidRuta(UtilidadesBD.convertirALong(rs.getValueAt(i, "RUTR_OID_RUTA_TRAN")));
                dtoResultado.setSecuenciaRutaTerritorio(UtilidadesBD.convertirAString(rs.getValueAt(i, "SECUENCIARUTA")));
                dtoResultado.setNumSecuenciaZonasRutas(UtilidadesBD.convertirALong(rs.getValueAt(i, "NUM_SECU")));
                dtoResultado.setIndicadorUpdateZona(UtilidadesBD.convertirABoolean(rs.getValueAt(i, "IND_UPDATE_ZONA")));
                dtoResultado.setIndicadorInsertCliente(UtilidadesBD.convertirABoolean(rs.getValueAt(i, "IND_INSERT_CLIENTE")));
                dtoResultado.setOidRutaNueva(UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_RUTA_NUEVA")));
                dtoResultado.setNumeroSecuenciaNueva(UtilidadesBD.convertirALong(rs.getValueAt(i, "NUM_SECU_NUEVA")));
                dtoResultado.setOidCliente(UtilidadesBD.convertirALong(rs.getValueAt(i, "CLIE_OID_CLIE")));
                hashRutas.put(UtilidadesBD.convertirALong(rs.getValueAt(i, "CLIE_OID_CLIE")), dtoResultado);
            }   
        }
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.obtenerSecuenciasClientes(): Salida");     
        return hashRutas;
    }
    
    
    private HashMap obtenerMaximosSecuencias() throws MareException {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.obtenerMaximosSecuencias(): Entrada");  
        HashMap hashMaximosSecuencia = new HashMap();
        StringBuffer query = new StringBuffer();

        query.append("SELECT ART.OID_RUTA_TRAN, ");
        query.append("       MAX(ARC.VAL_NUME_SECU) VAL_SECU_MAXI ");
        query.append("FROM APP_RUTAS_TRANS ART, ");
        query.append("     APP_RUTAS_CLIEN ARC, ");
        query.append("     PED_SOLIC_CABEC PSC, ");
        query.append("     ZON_ZONA ZON,  ");
        query.append("     PED_SOLIC_CABEC_TEMP2 PSC2  ");
        query.append("WHERE ART.PAIS_OID_PAIS = PSC.PAIS_OID_PAIS   ");
        query.append("  AND PSC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append("  AND ZON.COD_ZONA = ART.COD_RUTA ");
        query.append("  AND ART.OID_RUTA_TRAN = ARC.RUTR_OID_RUTA_TRAN ");
        query.append("  AND PSC.OID_SOLI_CABE = PSC2.OID_SOLI_CABE ");
        query.append("GROUP BY ART.OID_RUTA_TRAN  ");

        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
  
        if (rs != null && !rs.esVacio()) {
            int records = rs.getRowCount();
            for (int i = 0;i < records;i++){
                hashMaximosSecuencia.put(UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_RUTA_TRAN")), UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_SECU_MAXI")));
            }   
        }
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.obtenerMaximosSecuencias(): Salida");     
        return hashMaximosSecuencia;
    }

    private String rellenarHasta(String dato, int cantPosiciones) {        
        StringBuffer datoRelleno = new StringBuffer("");
        if (dato.length() < cantPosiciones) {
            for (int i = 0; i < (cantPosiciones - dato.length()); i++) {
                datoRelleno.append("0");
            }
        }
        return new String(datoRelleno.toString() + dato.toString());
    }
    
    private StringBuffer generarSentencias(DTOSolicCabecSecu dtoSCS, Long oidPais, String numeroSecuencia) {
        StringBuffer query = new StringBuffer();        
        
        if (dtoSCS.getIndicadorInsertCliente().booleanValue()) {
             query.append("INSERT INTO APP_RUTAS_CLIEN (");
             query.append("   OID_APP_RUTA_CLIE, ");
             query.append("   VAL_NUME_SECU, ");
             query.append("   CLIE_OID_CLIE, ");
             query.append("   PAIS_OID_PAIS, ");
             query.append("   RUTR_OID_RUTA_TRAN) ");
             query.append("VALUES ");
             query.append("(APP_APRC_SEQ.NEXTVAL,");
             query.append(numeroSecuencia.substring(6, numeroSecuencia.length())).append(",");
             query.append(dtoSCS.getOidCliente()).append(",");
             query.append(oidPais).append(",");
             query.append(dtoSCS.getOidRutaNueva());
             query.append(");");
        } else {
             query.append("UPDATE APP_RUTAS_CLIEN SET VAL_NUME_SECU = ").append(numeroSecuencia.substring(6, numeroSecuencia.length())).append(",");
             query.append(" RUTR_OID_RUTA_TRAN = ").append(dtoSCS.getOidRutaNueva()).append(" WHERE CLIE_OID_CLIE = ").append(dtoSCS.getOidCliente()).append(";");
        }
        return query;       
    }
    
    private HashMap obtenerMaximaSecuFactuDiariaPaisRutaFecha(HashMap hashFechaRuta, Long oidPais) throws MareException {
        UtilidadesLog.info("MONFacturacion.obtenerMaximaSecuFactuDiariaPaisRutaFecha(HashMap hashFechaRuta): Entrada ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT P.FEC_FACT, ");
        consulta.append("        P.NUM_SECU_ZONA_RUTA, ");
        consulta.append("        P.NUM_SECU_FACT_DIAR_ACUM ");
        consulta.append(" FROM PED_SOLIC_CABEC_SECUE_ACUMU P ");
        consulta.append(" WHERE P.PAIS_OID_PAIS = " + oidPais);
        consulta.append(" AND ( ");
        Iterator it = ((Collection)hashFechaRuta.values()).iterator();
        int count = 0;
        while (it.hasNext()){
            DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)it.next();
            java.util.Date fecha = dtoSolCabSecAcum.getFechaFacturacion();
            Long ruta = dtoSolCabSecAcum.getNumSecuenciaZonaRuta();
            if (count != 0){
                consulta.append(" OR ");
            }
            
            consulta.append("   (FEC_FACT = TO_DATE('" + sdf.format(fecha) + "','YYYY-MM-DD') ");
            consulta.append("   AND NUM_SECU_ZONA_RUTA = " + ruta + " ) ");
            count++;
        }
        consulta.append(")");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerMaximaSecuFactuDiariaPaisRutaFecha: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
       
        if(!rs.esVacio()){
          int rsMide = rs.getRowCount();
          for (int i = 0;i < rsMide;i++){
              Date fecha = this.objectToDate(rs.getValueAt(i,"FEC_FACT"));
              Long ruta = UtilidadesBD.convertirALong(rs.getValueAt(i,"NUM_SECU_ZONA_RUTA"));
              DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)hashFechaRuta.get(sdf.format(fecha).toString()+ruta.toString());                       
              dtoSolCabSecAcum.setNumSecuenciaFacturacionDiariaAcum(UtilidadesBD.convertirALong(rs.getValueAt(i,"NUM_SECU_FACT_DIAR_ACUM")));
              dtoSolCabSecAcum.setIndicadorUpdate(Boolean.TRUE);
              hashFechaRuta.put(sdf.format(fecha).toString()+ruta.toString(),dtoSolCabSecAcum);
          }
        }

        UtilidadesLog.info("MONFacturacion.obtenerMaximaSecuFactuDiariaPaisRutaFecha(HashMap hashFechaRuta): Salida ");
        return hashFechaRuta;
    }

   private void actualizarSecuenciaAcumulada (HashMap hashFechaRuta) throws MareException {
        UtilidadesLog.info("MONFacturacion.actualizarSecuenciaAcumulada(HashMap hashFechaRuta): Entrada ");

        Iterator it = ((Collection)hashFechaRuta.values()).iterator();
        StringBuffer cadena = new StringBuffer();
        while (it.hasNext()){
            DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)it.next();
            if (dtoSolCabSecAcum.getIndicadorUpdate() != null){
              if (dtoSolCabSecAcum.getIndicadorUpdate().booleanValue()){
                 cadena.append(this.generarCadenaUpdateAcum(dtoSolCabSecAcum));
              } else {
                cadena.append(this.generarCadenaInsercionAcum(dtoSolCabSecAcum));
              }
            } else {
               cadena.append(this.generarCadenaInsercionAcum(dtoSolCabSecAcum));
            }
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;

        try {            
             bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",cadena.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("actualizarSecuenciaAcumulada: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
      
        UtilidadesLog.info("MONFacturacion.actualizarSecuenciaAcumulada(HashMap hashFechaRuta): Salida ");        
    }
    
    private Date objectToDate(Object ob) {
        if (ob != null) {
            return (Date) ob;
        } else {
            return null;
        }
    }
 
     private StringBuffer generarCadenaUpdateAcum(DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum) {
      StringBuffer cadena = new StringBuffer();
      cadena.append("UPDATE PED_SOLIC_CABEC_SECUE_ACUMU SET NUM_SECU_FACT_DIAR_ACUM = " + dtoSolCabSecAcum.getNumSecuenciaFacturacionDiariaAcum());
      cadena.append(" WHERE PAIS_OID_PAIS = " + dtoSolCabSecAcum.getOidPais());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
      cadena.append("  AND FEC_FACT = TO_DATE('" + sdf.format(dtoSolCabSecAcum.getFechaFacturacion()) + "','YYYY-MM-DD')");
      cadena.append("  AND NUM_SECU_ZONA_RUTA = " + dtoSolCabSecAcum.getNumSecuenciaZonaRuta() + ";");      
      return cadena;
    }


    private StringBuffer generarCadenaInsercionAcum(DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum) {
      StringBuffer cadena = new StringBuffer();
      cadena.append("INSERT INTO PED_SOLIC_CABEC_SECUE_ACUMU (OID_SOLI_CABE_SECU_ACUM,PAIS_OID_PAIS,FEC_FACT,NUM_SECU_ZONA_RUTA, NUM_SECU_FACT_DIAR_ACUM) VALUES (");
      cadena.append("PED_SCSA_SEQ.NEXTVAL,");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
      cadena.append( dtoSolCabSecAcum.getOidPais() + "," + "TO_DATE('" + sdf.format(dtoSolCabSecAcum.getFechaFacturacion()) + "','yyyy-MM-dd'),");
      cadena.append(dtoSolCabSecAcum.getNumSecuenciaZonaRuta() + "," + dtoSolCabSecAcum.getNumSecuenciaFacturacionDiariaAcum() + ");");
      return cadena;
    }

}