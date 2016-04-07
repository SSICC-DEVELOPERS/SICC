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

package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOMovimientoAcumulado;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOCabeceraReporte;
import es.indra.sicc.dtos.ped.DTOMovimiento;
import es.indra.sicc.dtos.ped.ConstantesPedFaltantes;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.entidades.ped.ReporteFaltantesLocal;
import es.indra.sicc.entidades.ped.ReporteFaltantesLocalHome;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocal;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.util.UtilidadesLog;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import java.math.BigDecimal;
import java.sql.Date;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.dtos.ped.DTOMovimientoDiario;
import es.indra.sicc.dtos.ped.DTODatosAcumulados;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class CNInformeFaltantes {

    //la idea es retornar el oid de la creacion del registro en la entidad: PED_REPOR_FALTA
    //en el metodo genera(..., dado que este es void.
    private Long oidLote;

  private SessionContext ctx;

  public CNInformeFaltantes(SessionContext context) {
    this.ctx = context; 
  }    
  public CNInformeFaltantes(){
  }

  /*  1.- DTOInformeFaltantes dtoInforme = obtiene(dto); 
      2.- Si dtoInforme.loteReporteFaltantes = null lanza la siguiente MareException: 
              PED-009 "Opción no autorizada: debe tener informe generado" 
      3.- genera(dtoInforme) 
      4.- Devuelve dtoInforme
  */
    public DTOInformeFaltantes muestra(DTOEInformeFaltantes dtoe) throws MareException{
    
        UtilidadesLog.info("CNInformeFaltantes.muestra(DTOEInformeFaltantes dtoe): Entrada");
        DTOInformeFaltantes dtoInforme = obtiene(dtoe);
        if ((dtoInforme == null || dtoInforme.getLoteReporteFaltantes() == null)&&
                (dtoe.getOperacion()!=ConstantesPedFaltantes.OP_GENERA)) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_009));
        }
        genera(dtoInforme, dtoe.getOperacion(), dtoe.getOidLoteReporteFaltantes());
        
        if (dtoe.getOperacion() == ConstantesPedFaltantes.OP_GENERA) {
            UtilidadesLog.debug("la opcion es genera, al dtoInforme le agrego el oid de Lote: " + oidLote);
            dtoInforme.setOid(oidLote);
        }  
        
        //a ver.........
        dtoInforme.setPeriodo(new Long(0));
        UtilidadesLog.info("CNInformeFaltantes.muestra(DTOEInformeFaltantes dtoe): Salida");         
        return dtoInforme;
    }


   /* 1.- DAOInformeFaltantes.obtieneReportesNoAprobados((DTOBelcorp)dto) 
      2.- Coge los registros devueltos y hace lo siguiente por cada uno de ellos: 
      2.a.- DAOInformeFaltantes.deshaceLoteSolicitudes(dto.pais, registro.lote) 
      2.b.- Se hace un remove del EJBentity ReporteFaltantes del 
            objeto cuyo oid es igual a registro.oid. 
      3.- muestra(dto)
   */
    public DTOInformeFaltantes generaNuevo(DTOEInformeFaltantes dtoe) throws MareException{
        UtilidadesLog.info("CNInformeFaltantes.generaNuevo(DTOEInformeFaltantes dtoe): Entrada ");
        try{
            DAOInformesFaltantes infoFaltantes = new DAOInformesFaltantes();
            DTOBelcorp dtob = new DTOBelcorp();
            dtob.setOidPais(dtoe.getOidPais());
            dtob.setOidIdioma(dtoe.getOidIdioma());
            if(dtoe.getOidLoteReporteFaltantes()!=null){
                //.1
                RecordSet rs = infoFaltantes.obtieneReportesNoAprovados(dtob);
                UtilidadesLog.debug("Obtuvo ");
                //.2
                for (int i = 0; i < rs.getRowCount(); i++){
                    UtilidadesLog.debug("Entra en el loop");
                    //.2.a
                    infoFaltantes.deshaceLoteSolicitudes(dtoe.getOidPais(), BigToLong( rs.getValueAt(i,"LOTE" )));
                    //ReporteFaltantesLocalHome rFLocalHome = this.getReporteFaltantesLocalHome();    
                    Long oid = BigToLong(rs.getValueAt(i,"OID" ));
                    /*ReporteFaltantesLocal rFLocal = rFLocalHome.findByPrimaryKey(oid);             
                    UtilidadesLog.debug("BORRRREEEEEEEEEEEEEEEEEEEEEEEEEEE");
                    rFLocal.remove();         */
                    BelcorpService bs;
                    StringBuffer buf = new StringBuffer();
                    try {
                        bs = BelcorpService.getInstance();
                    } catch(MareMiiServiceNotFoundException e) {
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }
                    //.2.b
                    buf.append("DELETE FROM ped_repor_falta ");
                    buf.append("WHERE ped_repor_falta.OID_REPO_FALT = "+oid+" ");
                    int rowDeleted = bs.dbService.executeUpdate(buf.toString());
                }   
                UtilidadesLog.debug("Sale de GeneraNuevo");
            }
            //.3
            UtilidadesLog.info("CNInformeFaltantes.generaNuevo(DTOEInformeFaltantes dtoe): Salida ");            
            return muestra(dtoe);
        }/*
        catch (NamingException ne){
        ne.printStackTrace();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
        catch (FinderException fe){
        fe.printStackTrace();
        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } 
        catch (RemoveException re){
        re.printStackTrace();
        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }*/ 
        catch (Exception e){
            if (e instanceof MareException){
                throw (MareException) e;
            }
            UtilidadesLog.error("Exception:  ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }

   /*   
      Proceso: 
      ======= 
      1.- DTOInformeFaltantes dtoInforme = obtieneReporteLote(dto.oidLoteReporteFaltantes); 
      2.- Si dtoInforme.loteReporteFaltantes == null lanza la siguiente MareException: 
      PED-009 "Opción no autorizada: debe tener informe generado" 
      3.- Si dtoInforme.usuarioAprobacion != null o si dtoInforme.fechaAprobacion != null entonces lanza la siguiente MareException: 
      PED-010 "Informe ya aprobado" 
      4.- genera(dtoInforme) 
      5.- DAOInformeFaltantes.apruebaLoteSolicitudes(dtoInforme.pais, dtoInforme.loteReporteFaltantes) 
      6.- Se actualizan los atributos de la entidad (EJB Entity) ReporteFaltantes: 
      - fechaAprobacion = fecha del sistema 
      - usuarioAprobacion = usuario activo del sistema 
      cuyo oid es dtoInforme.oid 
      7.- Devuelve dtoInforme     
   */
  public DTOInformeFaltantes aprueba(DTOEInformeFaltantes dtoe, String user) throws MareException{
        UtilidadesLog.info("CNInformeFaltantes.aprueba(DTOEInformeFaltantes dtoe, String user): Entrada ");
        //cambio por incidencia 11410
        DTOInformeFaltantes dtoInforme = obtieneReporteLote(dtoe); 
        if (dtoInforme == null || dtoInforme.getLoteReporteFaltantes() == null)
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_009));
        if (((dtoInforme.getUsuarioAprobacion() != null)&&(!dtoInforme.getUsuarioAprobacion().equals(""))) || 
            (dtoInforme.getFechaAprobacion() != null))   
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_010));
        
        genera(dtoInforme, dtoe.getOperacion(), dtoe.getOidLoteReporteFaltantes());
        dtoInforme.setOid(oidLote);
        
        DAOInformesFaltantes infoFaltantes = new DAOInformesFaltantes();
        UtilidadesLog.debug("voy a aprobar lote de solicitudes...");
        infoFaltantes.apruebaLoteSolicitudes(dtoInforme.getOidPais(), dtoInforme.getLoteReporteFaltantes());
        UtilidadesLog.debug("aprobé lote de solicitudes...");
        //Cambio incidencia 11410
        try {
          Date fecha = new Date(System.currentTimeMillis());
          ReporteFaltantesLocalHome rFLocalHome = new ReporteFaltantesLocalHome();  
          UtilidadesLog.debug("para poner datos de aprobacion, busco en rep. falt. el oid: " + dtoInforme.getOid());
          ReporteFaltantesLocal inst = rFLocalHome.findByPrimaryKey(dtoInforme.getOid());

          UtilidadesLog.debug("seteo fecha de aprobacion y usuario: " + fecha + " - " + user);
          inst.setFechaAprobacion(fecha);
          inst.setUsuarioAprobacion(user);
          
          try {
              rFLocalHome.merge(inst);
          } catch (PersistenceException e) {
              UtilidadesLog.error("PersistenceException al actualizar: " + e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        } catch (NoResultException e){
            UtilidadesLog.error("NoResultException: " + e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e){
            UtilidadesLog.error("PersistenceException: " + e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("CNInformeFaltantes.aprueba(DTOEInformeFaltantes dtoe, String user): Salida ");
        return dtoInforme;
  }

  /*  
      Incidencia 11410
      Obtiene el primer reporte de faltantes que cumpla el país dado y rellena un DTOInformeFaltantes con la información de este reporte. 
      
      Proceso: 
      ======= 
      1.- Se crea un DTOInformeFaltantes (dtos) rellenado con la siguiente información: 
      - dtos.pais = dto.pais 
      - dtos.idioma = dto.idioma 
      - dtos.fechaIni = dto.fechaInicio 
      - dtos.fechaFin = dto.fechaFin 
      
      2.- Si dto.operacion <> ConstantesPedFaltantes.OP_GENERA 
      2.a.- DAOInformeFaltantes.obtieneReporteLote(dto.oidLoteReporteFaltantes) 
      2.b.- Si el RecordSet obtenido en el paso anterior no está vacío, se coge el primer registro (que llamaremos registro): 
      - dtos.loteReporteFaltantes = registro.lote 
      - dtos.fechaEjecucion = registro.fechaejecucion 
      - dtos.fechaAprobacion = registro.fechaaprobacion 
      - dtos.usuarioAprobacion = registro.usuarioaprobacion 
      - dtos.oid = registro.oid 
      - dtos.periodo = registro.periodo 
      Fin del Si 
      3.- Devuelve el DTOInformeFaltantes relleno.
      
   */
  private DTOInformeFaltantes obtiene(DTOEInformeFaltantes dtoe) throws MareException{
          UtilidadesLog.info("CNInformeFaltantes.obtiene(DTOEInformeFaltantes dtoe): Entrada ");
          //cambio por Incidencia 11410
          DTOInformeFaltantes dtoS = new DTOInformeFaltantes();
          dtoS.setOidPais(dtoe.getOidPais());
          dtoS.setOidIdioma(dtoe.getOidIdioma());
          dtoS.setFechaIni(dtoe.getFechaInicio());
          dtoS.setFechaFin(dtoe.getFechaFin());
          if(dtoe.getOperacion()!=ConstantesPedFaltantes.OP_GENERA){
              DAOInformesFaltantes infoFaltantes = new DAOInformesFaltantes();
              RecordSet registro = infoFaltantes.obtieneReporteLote(dtoe.getOidLoteReporteFaltantes());
              UtilidadesLog.debug("Lote obtenido "+ registro);
              if (!(registro.esVacio())){
                dtoS.setLoteReporteFaltantes(BigToLong(registro.getValueAt(0,"LOTE")));
                dtoS.setFechaEjecucion((Date)registro.getValueAt(0,"FECHAEJECUCION"));
                dtoS.setFechaAprobacion((Date)registro.getValueAt(0,"FECHAAPROBACION"));
                if ((registro.getValueAt(0,"USUARIOAPROBACION")!=null)&&(!registro.getValueAt(0,"USUARIOAPROBACION").equals(""))){
                    dtoS.setUsuarioAprobacion((String)registro.getValueAt(0,"USUARIOAPROBACION").toString());
                }
                dtoS.setOid(BigToLong(registro.getValueAt(0,"OID")));
                //dtoS.setPeriodo(BigToLong(registro.getValueAt(0,"PERIODO")));
                //a ver,..........
                dtoS.setPeriodo(new Long(0));
              }
          }
          UtilidadesLog.info("CNInformeFaltantes.obtiene(DTOEInformeFaltantes dtoe): Salida ");
          return dtoS;
   }


  /*
      1.- Long lote = dto.loteReporteFaltantes. 
      2.- DTOCabeceraReporte[] dtoCabeceras = obtieneSolicitudes(dto) 
      3.- Si dto.loteReporteFaltantes es null hace: 
      3.a.- Crea un DTONumeroSolicitud (dtoNumero) y se rellena así: 
      - pais = dto.pais 
      - idioma = dto.idioma 
      - operacion = ConstantesPedFaltantes.COD_OPER_FALTANTES 
      3.b.- llama a MONProcesoPED.generaNumeroDocumento(dtoNumero) y devuelve un número (en formato String) que llamaremos numeroDoc. 
      3.c.- dto.loteReporteFaltantes = numeroDoc (transformando el String en Long) 
      4.- Hace dto.cabecera = dtoCabeceras. 
      5.- tadReporte = new TADReporteFaltantes(dto); 
      6.- Por cada elemento de dto.cabecera (que llamamos cabecera) se hace: 
          - obtieneMovimientos(cabecera); 
      7.- DAOInformeFaltantes.actualizaLoteSolicitudes(dto.pais, lote, dto.loteReporteFaltantes) 
      8.- dto = tadReporte.getInforme(); 
   */
   /*private void genera2(DTOInformeFaltantes dtoe) throws MareException{
      try{
         UtilidadesLog.info("Entra a genera");
         Long lote = dtoe.getLoteReporteFaltantes(); 
         DTOCabeceraReporte[] dtoCabeceras = obtieneSolicitudes(dtoe); 
         if (dtoe.getLoteReporteFaltantes() == null){
              DTONumeroSolicitud dtoNumero = new DTONumeroSolicitud();
              dtoNumero.setOidPais(dtoe.getOidPais());
              dtoNumero.setOidIdioma(dtoe.getOidIdioma());
              dtoNumero.setOperacion(ConstantesPedFaltantes.COD_OPER_FALTANTES);
              MONProcesosPEDHome mProcesoPEDHome = this.getMONProcesosPEDHome();
              MONProcesosPED mProcesoPED = mProcesoPEDHome.create();
              String numeroDoc = mProcesoPED.generaNumeroDocumento(dtoNumero);
              dtoe.setLoteReporteFaltantes( new Long (numeroDoc)); 
         }
         UtilidadesLog.info("Antes del TAD");
         dtoe.setCabecera(dtoCabeceras );
         TADReporteFaltantes tadReporte = new TADReporteFaltantes(dtoe);
         UtilidadesLog.info("Va a ciclar por las cabeceras");
         for (int i = 0; i < dtoCabeceras.length; i++){
              UtilidadesLog.info("ciclo numero: "+i);
             DTOCabeceraReporte cabecera = dtoCabeceras[i];
             obtieneMovimientos(cabecera);
         }
         DAOInformesFaltantes infFaltantes = new DAOInformesFaltantes();
         //infFaltantes.actualizaLoteSolicitudes(dtoe.getOidPais(),lote, dtoe.getLoteReporteFaltantes());
         UtilidadesLog.info("termina de Actualiza Lote");
         dtoe = tadReporte.getInforme();
         UtilidadesLog.info("Sale de genera");
      }
      catch (CreateException ce){
            ce.printStackTrace();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      } 
      catch (NamingException ne){
        ne.printStackTrace();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
      catch (RemoteException re){
        re.printStackTrace();
        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(Exception e){
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
    }*/

      /*
        1.- Se crea un array de DTOCabeceraReporte sin ningún elemento 
            que llamaremos cabeceras. 
        2.- Invoca a DAOInformeFaltantes.obtieneSolicitudesFaltantes(dto) 
            y por cada registro obtenido se hace: 
        2.a.- Se crea un objeto DTOCabeceraReporte dtoCabecera relleno con: 
        - dtoCabecera.idioma = dto.idioma 
        - dtoCabecera.solicitud = registro.oid 
        - dtoCabecera.pais = registro.pais 
        - dtoCabecera.txtPais = registro.txtpais 
        - dtoCabecera.periodo = registro.periodo 
        - dtoCabecera.txtPeriodo = registro.txtperiodo 
        - dtoCabecera.canal = registro.canal 
        - dtoCabecera.txtCanal = registro.txtcanal 
        - dtoCabecera.marca = registro.marca 
        - dtoCabecera.txtMarca = registro.txtmarca 
        - dtoCabecera.acceso = registro.acceso 
        - dtoCabecera.txtAcceso = registro.txtacceso 
        - dtoCabecera.unidadNegocio = registro.unidadnegocio 
        - dtoCabecera.txtUnidadNegocio = registro.txtunidadnegocio 
        - dtoCabecera.subacceso = registro.subacceso 
        2.b.- Se añade dtoCabecera al array cabeceras. 
        3.- Devuelve cabeceras 
     */
    private DTOCabeceraReporte[] obtieneSolicitudes(DTOInformeFaltantes dtoe) throws Exception{
          UtilidadesLog.info("CNInformeFaltantes.obtieneSolicitudes(DTOInformeFaltantes dtoe): Entrada ");
          DTOCabeceraReporte [] cabeceras = null;
          DAOInformesFaltantes infoFaltantes = new DAOInformesFaltantes();
          RecordSet rs = infoFaltantes.obtieneSolicitudesFaltantes(dtoe);
          UtilidadesLog.debug("Obtuvo solicitudes faltantes");
          cabeceras = new DTOCabeceraReporte[rs.getRowCount()] ;

          for (int i = 0; i < rs.getRowCount() ; i++) 
          {
            DTOCabeceraReporte dtoCabecera = new DTOCabeceraReporte();
            dtoCabecera.setOidIdioma(dtoe.getOidIdioma());
            dtoCabecera.setSolicitud(BigToLong( rs.getValueAt(i,"OID")));
            dtoCabecera.setOidPais(BigToLong( rs.getValueAt(i,"PAIS")));
            dtoCabecera.setTxtPais((String)rs.getValueAt(i,"TXTPAIS"));
            dtoCabecera.setPeriodo(BigToLong(rs.getValueAt(i,"PERIODO")));
            dtoCabecera.setTxtPeriodo((String)rs.getValueAt(i,"TXTPERIODO"));
            dtoCabecera.setCanal(BigToLong(rs.getValueAt(i,"CANAL")));
            dtoCabecera.setTxtCanal((String)rs.getValueAt(i,"TXTCANAL"));
            dtoCabecera.setMarca(BigToLong(rs.getValueAt(i,"MARCA")));
            dtoCabecera.setTxtMarca((String)rs.getValueAt(i,"TXTMARCA"));
            dtoCabecera.setAcceso(BigToLong(rs.getValueAt(i,"ACCESO")));
            dtoCabecera.setTxtAcceso((String)rs.getValueAt(i,"TXTACCESO"));
            dtoCabecera.setUnidadNegocio(BigToLong(rs.getValueAt(i,"UNIDADNEGOCIO")));
            dtoCabecera.setTxtUnidadNegocio((String)rs.getValueAt(i,"TXTUNIDADNEGOCIO"));
            dtoCabecera.setSubacceso(BigToLong(rs.getValueAt(i,"SUBACCESO")));
            UtilidadesLog.debug("antes de asignar");
            cabeceras[i] = dtoCabecera;   
          }
          UtilidadesLog.info("CNInformeFaltantes.obtieneSolicitudes(DTOInformeFaltantes dtoe): Salida ");
          return cabeceras;
  }

  /*
   - Se llama a DAOInformeFaltantes.obtienePosicionesFaltantes(dto) 
   y por cada registro devuelto se hace:
      1.- Llama a (BEL) EstadosMercancia.findByUK(dto.pais, 
                         ConstantesPedFaltantes.COD_ESTA_LIBRE_DISPOS) 
          y recoge el oid del objeto devuelto 
          (a este oid lo llamamos estadoMercancia). 
      2.- Llama a (BEL) Stock.findByClaveUnica(registro.almacen, 
                              estadoMercancia, registro.producto) 
           y recoge el saldo del objeto devuelto (lo llamamos stockDisponible). 

      3.- dto.codigoVenta = registro.codigoventa 
      4.- Boolean indicadorAhorro = esIndicadorAhorro(dto) 
      5.- Se crea un DTOMovimiento lo llamamos dtoMov relleno así: 
          - dtoMov.pais = dto.pais 
          - dtoMov.idioma = dto.idioma 
          - dtoMov.posicion = registro.oid 
          - dtoMov.almacen = registro.almacen 
          - dtoMov.txtAlmacen = registro.txtalmacen 
          - dtoMov.negocio = registro.negocio 
          - dtoMov.txtNegocio = registro.txtnegocio 
          - dtoMov.demanda = registro.unidadesatender 
          - dtoMov.indAhorro = indicadorAhorro 
          - dtoMov.stockDisponible = stockDisponible 
          - dtoMov.faltante = 0 
          - dtoMov.unidades = 0 
          - dtoMov.indDiario = True 
          - dtoMov.producto = registro.producto 
          - dtoMov.txtProducto = registro.txtproducto 
      6.- tadReporte.insertaMovimiento(dto, dtoMov); 
      7.- generaAcumulados(dto, dtoMov); 
   */
 /* private void obtieneMovimientos(DTOCabeceraReporte dtoe) throws MareException{
      UtilidadesLog.info("Entra en obtieneMovimientos");
        try{
              DAOInformesFaltantes infoFaltantes = new DAOInformesFaltantes();
              RecordSet rs = infoFaltantes.obtienePosicionesFaltantes(dtoe);
              for (int i = 0; i < rs.getRowCount() ; i++) 
              {
                EstadosMercanciaLocalHome estMercanciasLH = this.getEstadosMercanciaLocalHome();
                EstadosMercanciaLocal estMercanciasL = 
                estMercanciasLH.findByUK(dtoe.getOidPais(),ConstantesPedFaltantes.COD_ESTA_LIBRE_DISPOS);
                Long estadoMercancia = estMercanciasL.getOid();

                StockLocalHome stockLH = this.getStockLocalHome();
                StockLocal stockL = 
                stockLH.findByClaveUnica(BigToLong(rs.getValueAt(i,"ALMACEN")),estadoMercancia, BigToLong(rs.getValueAt(i,"PRODUCTO")));
                Long stockDisponible = stockL.getSaldo();

                dtoe.setCodigoVenta((String)rs.getValueAt(i,"CODIGOVENTA"));
                Boolean indicadorAhorro = esIndicadorAhorro(dtoe);

                DTOMovimiento dtoMov = new DTOMovimiento();
                dtoMov.setOidPais(dtoe.getOidPais());
                dtoMov.setOidIdioma(dtoe.getOidIdioma());
                dtoMov.setPosicion(BigToLong(rs.getValueAt(i,"OID")));
                dtoMov.setAlmacen(BigToLong(rs.getValueAt(i,"ALMACEN")));
                dtoMov.setTxtAlmacen((String)rs.getValueAt(i,"TXTALMACEN"));
                dtoMov.setNegocio(BigToLong(rs.getValueAt(i,"NEGOCIO")));
                dtoMov.setTxtNegocio((String)rs.getValueAt(i,"TXTNEGOCIO"));
                dtoMov.setDemanda(BigToLong(rs.getValueAt(i,"UNIDADESATENDER")));
                dtoMov.setIndAhorro(indicadorAhorro); 
                dtoMov.setStockDisponible(stockDisponible);
                dtoMov.setFaltante(new Long(0));
                dtoMov.setUnidades(new Long(0));
                dtoMov.setIndDiario(new Boolean(true));
                dtoMov.setProducto(BigToLong(rs.getValueAt(i,"PRODUCTO")));
                dtoMov.setTxtProducto((String)rs.getValueAt(i,"TXTPRODUCTO"));

                TADReporteFaltantes tadReporte = new TADReporteFaltantes();
                UtilidadesLog.info("antes del TAD insertaMovimientos");
                tadReporte.insertaMovimiento(dtoe, dtoMov);
                generaAcumulados(dtoe,dtoMov);
                UtilidadesLog.info("Sale de generaAcumulados");
              }
          } 
          catch (NamingException ne){
            ne.printStackTrace();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
           catch (FinderException fe){
              fe.printStackTrace();
              throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
           }  catch(Exception e){
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
           }
           UtilidadesLog.info("Sale de obtieneMovimientos");
    }*/

      /*
        - Se llama a DAOInformeFaltantes.obtienePosicionesAcumuladas(dto, dtoMov) 
        y por cada registro devuelto se hace: 
        1.- Boolean indicadorAhorro = esIndicadorAhorro(dto) 
        2.- Se crea un DTOMovimiento lo llamamos dtoMov relleno así: 
        - dtoMov.pais = dto.pais 
        - dtoMov.idioma = dto.idioma 
        - dtoMov.posicion = registro.oid 
        - dtoMov.almacen = registro.almacen 
        - dtoMov.txtAlmacen = registro.txtalmacen 
        - dtoMov.negocio = registro.negocio 
        - dtoMov.txtNegocio = registro.txtnegocio 
        - dtoMov.demanda = registro.unidadesatender 
        - dtoMov.indAhorro = indicadorAhorro 
        - dtoMov.stockDisponible = 0 
        - dtoMov.faltante = 0 
        - dtoMov.unidades = registro.unidadesatender-registro.unidadescomprometidas 
        - dtoMov.indDiario = False 
        - dtoMov.producto = registro.producto 
        - dtoMov.txtProducto = registro.txtproducto 
        3.- tadReporte.insertaMovimiento(dto, dtoMov); 
    */
    /*private void generaAcumulados(DTOCabeceraReporte dtoC, DTOMovimiento dtoM) throws MareException {
          DAOInformesFaltantes infoFaltantes = new DAOInformesFaltantes();
          RecordSet rs = infoFaltantes.obtienePosicionesAcumuladas(dtoC, dtoM);
          for (int i = 0; i < rs.getRowCount() ; i++){
            Boolean indicadorAhorro = esIndicadorAhorro(dtoC);
            DTOMovimiento dtoMov = new DTOMovimiento();
            dtoMov.setOidPais(dtoC.getOidPais());
            dtoMov.setOidIdioma(dtoC.getOidIdioma());
            dtoMov.setPosicion(BigToLong(rs.getValueAt(i,"OID")));
            dtoMov.setAlmacen(BigToLong(rs.getValueAt(i,"ALMACEN")));
            dtoMov.setTxtAlmacen((String)rs.getValueAt(i,"TXTALMACEN"));
            dtoMov.setNegocio(BigToLong(rs.getValueAt(i,"NEGOCIO")));
            dtoMov.setTxtNegocio((String)rs.getValueAt(i,"TXTNEGOCIO"));
            dtoMov.setDemanda(BigToLong(rs.getValueAt(i,"UNIDADESATENDER")));
            dtoMov.setIndAhorro(indicadorAhorro); 
            dtoMov.setStockDisponible(new Long(0));
            dtoMov.setFaltante(new Long(0));
            long resultado;
            long op1;
            long op2;
            if ( rs.getValueAt(i,"UNIDADESATENDER") == null)
               op1 = 0;
            else
               op1 = ((BigDecimal) rs.getValueAt(i,"UNIDADESATENDER")).longValue();
            if ( rs.getValueAt(i,"UNIDADESCOMPROMETIDAS") == null) 
               op2 = 0;
            else             
               op2 = ((BigDecimal) rs.getValueAt(i,"UNIDADESCOMPROMETIDAS")).longValue();
            resultado = op1 - op2;   
            dtoMov.setUnidades(new Long(resultado));
            dtoMov.setIndDiario(new Boolean(false));
            dtoMov.setProducto(BigToLong(rs.getValueAt(i,"PRODUCTO")));
            dtoMov.setTxtProducto((String)rs.getValueAt(i,"TXTPRODUCTO"));
            TADReporteFaltantes tadReporte = new TADReporteFaltantes();
            tadReporte.insertaMovimiento(dtoC, dtoMov);
          }
  }*/
  
  /*
    return (IServiceMF.contarCodigoVenta(dto.pais, dto.marca,dto.canal, dto.acceso, dto.subacceso, ConstantesPedFaltantes.COD_CATALOGO_AHORRO, dto.codigoVenta) > 0) 
  */
  private Boolean esIndicadorAhorro(DTOCabeceraReporte dtoe) throws MareException{
      UtilidadesLog.info("CNInformeFaltantes.esIndicadorAhorro(DTOCabeceraReporte dtoe): Entrada ");
      Integer comparator = null;
      try{
        MONMantenimientoMFHome mfHome = this.getMONMantenimientoMFHome();
        MONMantenimientoMF mf = mfHome.create();

//se resolvio INCIDENCIA nro 6484: COD_CATALOGO_AHORRO sera Long
        comparator = mf.contarCodigoVenta(dtoe.getOidPais(), dtoe.getMarca(), dtoe.getCanal(), dtoe.getAcceso(), dtoe.getSubacceso(), dtoe.getCodigoVenta(), ConstantesPedFaltantes.COD_CATALOGO_AHORRO);
      } catch (NamingException ne){
        UtilidadesLog.error("NamingException: ",ne);
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException re){
        UtilidadesLog.error("RemoteException: ",re);
        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException ce){
        UtilidadesLog.error("CreateException: ",ce);
        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      UtilidadesLog.info("CNInformeFaltantes.esIndicadorAhorro(DTOCabeceraReporte dtoe): Salida ");      
      if (comparator != null) 
         return (Boolean.valueOf(comparator.compareTo(new Integer(0))> 0));
      else
         return (Boolean.FALSE);
  }

  private Long BigToLong(Object num){
          if (num != null) 
              return (new Long(((BigDecimal) num).longValue()));
          else 
              return null;
  }

  private MONMantenimientoMFHome getMONMantenimientoMFHome() throws NamingException{
    final InitialContext context = new InitialContext();
    return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"), MONMantenimientoMFHome.class);
  }
  
  private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException{
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }

  private EstadosMercanciaLocalHome getEstadosMercanciaLocalHome() throws NamingException{
    final InitialContext context = new InitialContext();
    return (EstadosMercanciaLocalHome)context.lookup("java:comp/env/EstadosMercancia");
  }

  private StockLocalHome getStockLocalHome() throws NamingException{
    final InitialContext context = new InitialContext();
    return (StockLocalHome)context.lookup("java:comp/env/Stock");
  }

  //surge por incidencia 11410
  public DTOInformeFaltantes obtieneReporteLote(DTOEInformeFaltantes dtoe) throws MareException  {/*
    Obtiene el primer reporte de faltantes que cumpla el país y lote dados y rellena un DTOInformeFaltantes con la información de este reporte. 

    Proceso: 
    ======= 
    1.- DAOInformeFaltantes.obtieneReporteLote(oidLoteReporteFaltantes) 
    2.- Se crea un DTOInformeFaltantes (dtos) rellenado con la siguiente información: 
    - dtos.pais = dto.pais 
    - dtos.idioma = dto.idioma 
    - dtos.fechaIni = dto.fechaInicio 
    - dtos.fechaFin = dto.fechaFin 
    3.- Si el RecordSet obtenido en el paso 1 no está vacío, se coge el primer registro (que llamaremos registro): 
    - dtos.loteReporteFaltantes = registro.lote 
    - dtos.fechaEjecucion = registro.fechaejecucion 
    - dtos.fechaAprobacion = registro.fechaaprobacion 
    - dtos.usuarioAprobacion = registro.usuarioaprobacion 
    - dtos.oid = registro.oid 
    - dtos.periodo = registro.periodo 
    4.- Devuelve el DTOInformeFaltantes relleno. 
    */
    UtilidadesLog.info("CNInformeFaltantes.obtieneReporteLote(DTOEInformeFaltantes dtoe): Entrada ");
    DAOInformesFaltantes dao = new DAOInformesFaltantes();
    //.1
    RecordSet registro = dao.obtieneReporteLote(dtoe.getOidLoteReporteFaltantes());    
    //.2
    DTOInformeFaltantes dtoS = new DTOInformeFaltantes();
    dtoS.setOidPais(dtoe.getOidPais());
    dtoS.setOidIdioma(dtoe.getOidIdioma());
    dtoS.setFechaIni(dtoe.getFechaInicio());
    dtoS.setFechaFin(dtoe.getFechaFin());
    //.3
    if(!registro.esVacio()){
        dtoS.setLoteReporteFaltantes(BigToLong(registro.getValueAt(0,"LOTE")));
        dtoS.setFechaEjecucion((Date)registro.getValueAt(0,"FECHAEJECUCION"));
        dtoS.setFechaAprobacion((Date)registro.getValueAt(0,"FECHAAPROBACION"));
        dtoS.setUsuarioAprobacion((String)registro.getValueAt(0,"USUARIOAPROBACION"));
        dtoS.setOid(BigToLong(registro.getValueAt(0,"OID")));
        //dtoS.setPeriodo(BigToLong(registro.getValueAt(0,"PERIODO")));
        //a ver,..........
        dtoS.setPeriodo(new Long(0));
    }
    //.4
    UtilidadesLog.info("CNInformeFaltantes.obtieneReporteLote(DTOEInformeFaltantes dtoe): Salida ");
    return dtoS;
  }
  
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 19/07/2005
  * @Recibe: DTOInformeFaltantes dtoe, int operacion, Long oidLoteRepFttes
  * @Retorna: void 
  * @Descripción: genera los datos para el armado del reporte de faltantes en parte
  *               cliente y actualiza el GP del lote de solicitudes.
  * @Referencia: BELC300015591
  */ 
  private void genera(DTOInformeFaltantes dtoe, int operacion, Long oidLoteRepFttes) throws MareException{
    UtilidadesLog.info("CNInformeFaltantes.genera(DTOInformeFaltantes dtoe, int operacion, Long oidLoteRepFttes): Entrada ");
    try {
        UtilidadesLog.debug("Entra a genera con DTOInformeFaltantes: "+dtoe+" operacion: "+operacion+" oidLoteRepFttes: "+oidLoteRepFttes);
        
        DAOInformesFaltantes daoInfoFalt = new DAOInformesFaltantes(ctx);        
        
        ArrayList movimientoDiarios = daoInfoFalt.obtieneSolicitudesMovimientos(dtoe);        
        DTOMovimientoDiario dtoMovDiaAct = null;
        ArrayList cabecerasReporte = new ArrayList();
        if ((movimientoDiarios!=null)&&(!movimientoDiarios.isEmpty())){
          Iterator itMovDiarios = movimientoDiarios.iterator();    
          dtoMovDiaAct = (DTOMovimientoDiario)itMovDiarios.next();//primer movimiento diario
          
          ArrayList movimientoAcumulados = null;
         
          movimientoAcumulados = daoInfoFalt.obtienePosicionesAcumuladas(dtoe,dtoMovDiaAct.getPeriodo());
       
          if (dtoe.getLoteReporteFaltantes() == null){
                DTONumeroSolicitud dtoNumero = new DTONumeroSolicitud();
                dtoNumero.setOidPais(dtoe.getOidPais());
                dtoNumero.setOidIdioma(dtoe.getOidIdioma());
                dtoNumero.setOperacion(ConstantesPedFaltantes.COD_OPER_FALTANTES);
                MONProcesosPEDHome mProcesoPEDHome = this.getMONProcesosPEDHome();
                MONProcesosPED mProcesoPED = mProcesoPEDHome.create();
                String numeroDoc = mProcesoPED.generaNumeroDocumento(dtoNumero);
                dtoe.setLoteReporteFaltantes( new Long (numeroDoc));
          }
          
          DTOMovimientoDiario ultimoMovimiento = new DTOMovimientoDiario();
          ArrayList productosCriticos = new ArrayList();
          ArrayList negocioAlmacen = new ArrayList();
          
          Long ultimoNegocio = dtoMovDiaAct.getNegocio();
          Long ultimaUnidadNegocio = dtoMovDiaAct.getUnidadNegocio();
          Long ultimoAlmacen = dtoMovDiaAct.getAlmacen();
          Boolean ultimoIndAhorro = dtoMovDiaAct.getIndAhorro();
          
          long auxDemanda = 0;
          long auxStock = 0;
          boolean fin = false;          
          UtilidadesLog.debug("-----------------------INICIO-------------------------");
          UtilidadesLog.debug("----UNEG:"+dtoMovDiaAct.getUnidadNegocio()+"-----NEG:"+dtoMovDiaAct.getNegocio()+"---ALM:"+dtoMovDiaAct.getAlmacen()+"----");
          
          while (!fin) {              
              DTOCabeceraReporte cabecera = new DTOCabeceraReporte();
              DTOMovimientoDiario dtoMovDiarUNeg = dtoMovDiaAct;
              cabecera.setAcceso(dtoMovDiaAct.getAcceso());
              cabecera.setTxtAcceso(dtoMovDiaAct.getTxtAcceso());
              cabecera.setUnidadNegocio(dtoMovDiaAct.getUnidadNegocio());
              cabecera.setTxtUnidadNegocio(dtoMovDiaAct.getTxtUnidadNegocio());
              cabecera.setPeriodo(dtoMovDiaAct.getPeriodo());
              cabecera.setTxtPeriodo(dtoMovDiaAct.getTxtPeriodo());
              cabecera.setCanal(dtoMovDiaAct.getCanal());
              cabecera.setTxtCanal(dtoMovDiaAct.getTxtCanal());
              cabecera.setMarca(dtoMovDiaAct.getMarca());
              cabecera.setTxtMarca(dtoMovDiaAct.getTxtMarca());
              cabecera.setOidPais(dtoMovDiaAct.getOidPais());
              cabecera.setTxtPais(dtoMovDiaAct.getTxtPais());             
              
              while (dtoMovDiaAct.getUnidadNegocio().equals(ultimaUnidadNegocio)&&(!fin)) {
                    DTOMovimientoDiario dtoMovDiarNegoAlmc = dtoMovDiaAct;
                    while ((dtoMovDiaAct.getNegocio().equals(ultimoNegocio))&&
                            (dtoMovDiaAct.getAlmacen().equals(ultimoAlmacen))&&
                            (dtoMovDiaAct.getIndAhorro().equals(ultimoIndAhorro))&&(!fin)) {
                          long demandaDiaAct = dtoMovDiaAct.getDemanda()!=null?dtoMovDiaAct.getDemanda().longValue():0;  
                          long stockDiaAct = dtoMovDiaAct.getStockDisponible()!=null?dtoMovDiaAct.getStockDisponible().longValue():0;  
                          auxDemanda += demandaDiaAct;
                          auxStock += stockDiaAct;
                          
                          if (determinarProductoCritico(dtoMovDiaAct).booleanValue()) {
                              DTOMovimiento dtoMovDCrit = traspasarDatosDiario(dtoMovDiaAct, dtoMovDiaAct.getDemanda(), dtoMovDiaAct.getStockDisponible(), dtoMovDiaAct.getUnidades(), (dtoMovDiaAct.getFaltante()!=null)?dtoMovDiaAct.getFaltante():new Double(0));
                              productosCriticos.add(dtoMovDCrit);
  
                              DTODatosAcumulados dtoAcumProd = obtenerAcumuladoProducto(dtoMovDiaAct.getNegocio(),dtoMovDiaAct.getAlmacen(),dtoMovDiaAct.getProducto(),movimientoAcumulados);
                              DTOMovimiento dtoMovACrit = traspasarDatosAcumulado(dtoMovDiaAct,dtoAcumProd.getDemanda(),dtoAcumProd.getFaltantes(),dtoAcumProd.getUnidades());
                              productosCriticos.add(dtoMovACrit);
                              
                          }
                          if(itMovDiarios.hasNext()){
                            dtoMovDiaAct = (DTOMovimientoDiario)itMovDiarios.next();
                            UtilidadesLog.debug("----UNEG:"+dtoMovDiaAct.getUnidadNegocio()+"-----NEG:"+dtoMovDiaAct.getNegocio()+"---ALM:"+dtoMovDiaAct.getAlmacen()+"----");
                          } else {
                            UtilidadesLog.debug("-------------------------FIN--------------------------");
                            fin = true;
                          }
                    }//Fin Mientras mismo negocio y almacen 
  
                    Long lDemanda = new Long(auxDemanda);
                    Long lStock = new Long(auxStock);
                    Long unidades = calcularUnidades(lDemanda, lStock);
                    Double faltante = calcularFaltante(unidades, lDemanda);
                    if (faltante.longValue()<0){
                        unidades = new Long(0);
                        faltante = new Double(0);
                    }
                    DTODatosAcumulados dtoAcum = obtenerAcumulados(ultimoNegocio,ultimoAlmacen,movimientoAcumulados);
                    
                    //Diario
                    DTOMovimiento dtoMovD = traspasarDatosDiario(dtoMovDiarNegoAlmc,lDemanda,lStock,unidades,faltante);                  
                    negocioAlmacen.add(dtoMovD);
                    
                    //Acumulado
                    DTOMovimiento dtoMovA = traspasarDatosAcumulado(dtoMovDiarNegoAlmc,dtoAcum.getDemanda(),dtoAcum.getFaltantes(),dtoAcum.getUnidades());
                    negocioAlmacen.add(dtoMovA);
                    
                    ultimoNegocio = dtoMovDiaAct.getNegocio();
                    ultimoAlmacen = dtoMovDiaAct.getAlmacen();
                    ultimoIndAhorro = dtoMovDiaAct.getIndAhorro();
                    auxDemanda = 0;
                    auxStock = 0;
              }//Fin Mientras misma unidad de negocio 
  
              //Se asignan los productos criticos a la cabecera del reporte 
              if ((productosCriticos!=null)&&(!productosCriticos.isEmpty())){
                  cabecera.setMovimientoProducto((DTOMovimiento[])productosCriticos.toArray(new DTOMovimiento[productosCriticos.size()]));
              } else {
                  DTOMovimiento dtomovprod = new DTOMovimiento();
                  dtomovprod.setAlmacen(null);
                  dtomovprod.setDemanda(null);
                  dtomovprod.setFaltante(null);
                  dtomovprod.setIndAhorro(Boolean.FALSE);
                  dtomovprod.setIndDiario(Boolean.TRUE);
                  dtomovprod.setNegocio(null);
                  dtomovprod.setOidIdioma(null);
                  dtomovprod.setOidPais(null);
                  dtomovprod.setPosicion(null);
                  dtomovprod.setProducto(null);
                  dtomovprod.setStockDisponible(null);
                  dtomovprod.setUnidades(null);
                  dtomovprod.setTxtAlmacen(new String(" "));
                  dtomovprod.setTxtNegocio(new String(" "));
                  dtomovprod.setTxtProducto(new String(" "));  
                  
                  DTOMovimiento dtomovprod2 = new DTOMovimiento();
                  dtomovprod2.setAlmacen(null);
                  dtomovprod2.setDemanda(null);
                  dtomovprod2.setFaltante(null);
                  dtomovprod2.setIndAhorro(Boolean.TRUE);
                  dtomovprod2.setIndDiario(Boolean.FALSE);
                  dtomovprod2.setNegocio(null);
                  dtomovprod2.setOidIdioma(null);
                  dtomovprod2.setOidPais(null);
                  dtomovprod2.setPosicion(null);
                  dtomovprod2.setProducto(null);
                  dtomovprod2.setStockDisponible(null);
                  dtomovprod2.setUnidades(null);
                  dtomovprod2.setTxtAlmacen(new String(" "));
                  dtomovprod2.setTxtNegocio(new String(" "));
                  dtomovprod2.setTxtProducto(new String(" ")); 
                  DTOMovimiento[] dtosmovprod = {dtomovprod,dtomovprod2};       
                  cabecera.setMovimientoProducto(dtosmovprod);
              }
              //Se asignan las categorias a la cabecera del reporte 
              cabecera.setMovimientoCategoria((DTOMovimiento[])(negocioAlmacen.toArray(new DTOMovimiento[negocioAlmacen.size()])));              
              //Se guarda la cabecera 
              cabecerasReporte.add(cabecera);
              //Se continua con la siguiente linea de negocio 
              negocioAlmacen = new ArrayList();
              productosCriticos = new ArrayList();
              ultimaUnidadNegocio = dtoMovDiaAct.getUnidadNegocio(); 
          }//Fin Mientras movimientosDiarios
        
        } else {        
            if (operacion == ConstantesPedFaltantes.OP_GENERA) {
              UtilidadesLog.debug("no hay movimientos, se lanza el error. 10050 = No existen solicitudes, para generar el informe.");
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_050));
            } else {
              UtilidadesLog.debug("no hay movimientos, se lanza el error. 10009 = Opción no autorizada: debe tener informe generado");
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_009));
            }
        }
    
        dtoe.setCabecera((DTOCabeceraReporte[])cabecerasReporte.toArray(new DTOCabeceraReporte[cabecerasReporte.size()]));
        
        if (operacion == ConstantesPedFaltantes.OP_GENERA) {
             DAOInformesFaltantes infFaltantes = new DAOInformesFaltantes();
             infFaltantes.actualizaLoteSolicitudes(dtoe.getOidPais(), dtoe.getLoteReporteFaltantes(),dtoe.getFechaIni(),dtoe.getFechaFin());
             UtilidadesLog.debug("Termina de Actualiza Lote.");         
        }
        
        //actualizo la tabla de Rep. faltantes
        
        //de acuerdo a inc: BELC300012422, desaparece periodo y aparece pais, obligatorio!        
        if (operacion == ConstantesPedFaltantes.OP_GENERA) {
             UtilidadesLog.debug("Voy a crear registro en tabla de reporte faltantes....");
             try {
                ReporteFaltantesLocalHome rFLocalHome = new ReporteFaltantesLocalHome();    
                ReporteFaltantesLocal inst = rFLocalHome.create(dtoe.getOidPais(), dtoe.getLoteReporteFaltantes(), new Date(System.currentTimeMillis()));
                //tomo el oid del registro que acabo de crear
                oidLote = inst.getOid();
                UtilidadesLog.debug("Cree registro en tabla de reporte faltantes....");
             } catch (PersistenceException e) {
                 UtilidadesLog.debug("PersistenceException: ", e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
        } else {
             UtilidadesLog.debug("No es generacion. de rep., no creo registro en rep. falt, asigno: oidLote = oidLoteRepFttes, que es: " + oidLoteRepFttes);
             oidLote = oidLoteRepFttes;
        }
        
        UtilidadesLog.debug("Sale de genera con DTOInformeFaltantes:"+dtoe+" oidLote:"+oidLote);
      
      } catch (CreateException ce){
            UtilidadesLog.error("CreateException: ",ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      } catch (NamingException ne){
            UtilidadesLog.error("NamingException",ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException re){
            UtilidadesLog.error("RemoteException: ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }        
      UtilidadesLog.info("CNInformeFaltantes.genera(DTOInformeFaltantes dtoe, int operacion, Long oidLoteRepFttes): Salida ");
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 18/07/2005
  * @Recibe: Long demanda, Long stock
  * @Retorna: Long unidades 
  * @Descripción: calcula las unidades que salen de la diferencia entre demanda y stock
  * @Referencia: BELC300015591
  */ 
  private Long calcularUnidades(Long demanda, Long stock) {
        
        UtilidadesLog.info("CNInformeFaltantes.calcularUnidades(Long demanda, Long stock): Entrada  ");
        UtilidadesLog.debug("entra a calcularUnidades con demanda: "+ demanda + " stock: "+ stock);
        long ldemanda = (demanda!=null)?demanda.longValue():0;
        long lstock = (stock!=null)?stock.longValue():0;
        long unidades = ldemanda-lstock;
        UtilidadesLog.debug("sale de calcularUnidades con unidades: "+ unidades);
        UtilidadesLog.info("CNInformeFaltantes.calcularUnidades(Long demanda, Long stock): Salida  ");
        return new Long(unidades);
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 18/07/2005
  * @Recibe: Long unidades, Long demanda
  * @Retorna: Long faltante 
  * @Descripción: calcula el porcentaje de faltante de unidades respecto a la demanda
  * @Referencia: BELC300015591
  */ 
  private Double calcularFaltante(Long unidades, Long demanda) {
        UtilidadesLog.info("CNInformeFaltantes.calcularFaltante(Long unidades, Long demanda): Entrada ");
        UtilidadesLog.debug("entra a calcularFaltante con unidades: "+ unidades + " demanda: " + demanda);
        double lunidades = (unidades!=null)?unidades.longValue():0;
        double ldemanda = (demanda!=null)?demanda.longValue():0;
        double lfaltante = 0;
        if (ldemanda!=0) {
           lfaltante = (lunidades/ldemanda)*100;
        }    
        UtilidadesLog.debug("sale de calcularFaltante con faltante:"+lfaltante);
        UtilidadesLog.info("CNInformeFaltantes.calcularFaltante(Long unidades, Long demanda): Salida ");
        return new Double(lfaltante);
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 18/07/2005
  * @Recibe: DTOMovimientoDiario movDiario
  * @Retorna: Boolean 
  * @Descripción: determina si un producto es critico o no de acuerdo al faltante
  *               para satisfacer la demanda.
  * @Referencia: BELC300015591
  */ 
  private Boolean determinarProductoCritico(DTOMovimientoDiario movDiario) {
        UtilidadesLog.info("CNInformeFaltantes.determinarProductoCritico(DTOMovimientoDiario movDiario): Entrada  ");
        UtilidadesLog.debug("entra a determinarProductoCritico con DTOMovimientoDiario:"+movDiario);
        
        boolean result = false;
        Long unidades = this.calcularUnidades(movDiario.getDemanda(),movDiario.getStockDisponible());
        Double faltante = this.calcularFaltante(unidades, movDiario.getDemanda());
        if (faltante.doubleValue()<0){
          unidades = new Long(0);
          faltante = new Double(0);
        }
        
        double umbral = (movDiario.getUmbral()!=null)?movDiario.getUmbral().doubleValue():0;
        if (faltante.doubleValue()>umbral){    
            result = true;
        } else {
          
            result = false;          
        }            
        movDiario.setUnidades(unidades);
        movDiario.setFaltante(faltante);  
        UtilidadesLog.debug("sale de determinarProductoCritico con movDiario:"+movDiario+" result:"+result);  
        UtilidadesLog.info("CNInformeFaltantes.determinarProductoCritico(DTOMovimientoDiario movDiario): Salida  ");
        return Boolean.valueOf(result);
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 18/07/2005
  * @Recibe: Long negocio, Long almacen, ArrayList movAcumulados
  * @Retorna: DTODatosAcumulados con unidades, demanda y % de faltantes
  * @Descripción: obtiene los totales acumulados de unidades, demanda y % de
  *               faltantes para un negocio y almacen.
  * @Referencia: BELC300015591 (y JFDelPeso)
  */ 
  private DTODatosAcumulados obtenerAcumulados(Long negocio, Long almacen, ArrayList movAcumulados) {
        UtilidadesLog.info("CNInformeFaltantes.obtenerAcumulados(Long negocio, Long almacen, ArrayList movAcumulados): Entrada ");
        UtilidadesLog.debug("entra a obtenerAcumulados con negocio:"+negocio+" almacen:"+almacen+" movAcumulados:"+movAcumulados);

        DTODatosAcumulados dtoDatosAcum = new DTODatosAcumulados();       
        long auxDemanda = 0;
        long auxUnidades = 0;        
        Long unidades = null;
        Long demanda = null;
        Double faltante = null;
        boolean encontro = false;
        if (movAcumulados!=null){
          Iterator itMovAcum = movAcumulados.iterator();
          
          while(itMovAcum.hasNext()) {
              DTOMovimientoAcumulado dtoMovAcum = (DTOMovimientoAcumulado)itMovAcum.next();
              Long negocioActual = dtoMovAcum.getNegocio();
              Long almacenActual = dtoMovAcum.getAlmacen();
              
              if (((negocio==null&&negocioActual==null)||
                   (negocio!=null&&negocio.equals(negocioActual)))&&
                  ((almacen==null&&almacenActual==null)||
                   (almacen!=null&&almacen.equals(almacenActual)))){
                      long demandaActual = dtoMovAcum.getUnidadesPorAtender()!=null?dtoMovAcum.getUnidadesPorAtender().longValue():0;
                      long unidComprActual = dtoMovAcum.getUnidadesComprometidas()!=null?dtoMovAcum.getUnidadesComprometidas().longValue():0;
                      auxDemanda += demandaActual;
                      auxUnidades += (demandaActual-unidComprActual);
                      encontro = true;
              } else {
                      if (encontro) break;
              }
          }
        }
        unidades = new Long(auxUnidades);
        demanda = new Long(auxDemanda);
        faltante = this.calcularFaltante(unidades, demanda);
        if (faltante.doubleValue()<0) {
            faltante = new Double(0);
            unidades = new Long(0);
        }
        dtoDatosAcum.setDemanda(demanda);
        dtoDatosAcum.setFaltantes(faltante);
        dtoDatosAcum.setUnidades(unidades);

        UtilidadesLog.debug("sale de obtenerAcumulados con dtoDatosAcum:" + dtoDatosAcum);    
        UtilidadesLog.info("CNInformeFaltantes.obtenerAcumulados(Long negocio, Long almacen, ArrayList movAcumulados): Salida ");        
        return dtoDatosAcum;
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 18/07/2005
  * @Recibe: Long negocio, Long almacen, Long producto, ArrayList movAcumulado
  * @Retorna: DTODatosAcumulados 
  * @Descripción: obtiene los totales acumulados de unidades, demanda y % de
  *               faltantes para un negocio, almacen y producto.
  * @Referencia: BELC300015591
  */ 
  private DTODatosAcumulados obtenerAcumuladoProducto(Long negocio, Long almacen, Long producto, ArrayList movAcumulados) {
        UtilidadesLog.info("CNInformeFaltantes.obtenerAcumuladoProducto(Long negocio, Long almacen, Long producto, ArrayList movAcumulados): Entrada ");
        UtilidadesLog.debug("entra a obtenerAcumuladoProducto con negocio:"+negocio+" almacen:"+almacen+" producto:"+producto+" movAcumulados:"+movAcumulados);
        
        DTODatosAcumulados dtoDatosAcum = new DTODatosAcumulados();

        long auxDemanda = 0;
        long auxUnidades = 0;        
        Long unidades = null;
        Long demanda = null;
        Double faltante = null;
        boolean encontro = false;
        if (movAcumulados!=null){
          Iterator itMovAcum = movAcumulados.iterator();
          
          while(itMovAcum.hasNext()) {
              DTOMovimientoAcumulado dtoMovAcum = (DTOMovimientoAcumulado)itMovAcum.next();
              Long negocioActual = dtoMovAcum.getNegocio();
              Long almacenActual = dtoMovAcum.getAlmacen();
              Long productoActual = dtoMovAcum.getProducto();
              
              if (((negocio==null&&negocioActual==null)||
                   (negocio!=null&&negocio.equals(negocioActual)))&&
                  ((almacen==null&&almacenActual==null)||
                   (almacen!=null&&almacen.equals(almacenActual)))&&
                   ((producto==null&&productoActual==null)||
                   (producto!=null&&producto.equals(productoActual)))){
                      long demandaActual = dtoMovAcum.getUnidadesPorAtender()!=null?dtoMovAcum.getUnidadesPorAtender().longValue():0;
                      long unidComprActual = dtoMovAcum.getUnidadesComprometidas()!=null?dtoMovAcum.getUnidadesComprometidas().longValue():0;
                      auxDemanda += demandaActual;
                      auxUnidades += (demandaActual-unidComprActual);
                      encontro = true;
              } else {
                      if (encontro) break;
              }
          }
        }
        unidades = new Long(auxUnidades);
        demanda = new Long(auxDemanda);
        faltante = this.calcularFaltante(unidades, demanda);
        if (faltante.doubleValue()<0) {
            faltante = new Double(0);
            unidades = new Long(0);
        }        
        dtoDatosAcum.setDemanda(demanda);
        dtoDatosAcum.setFaltantes(faltante);
        dtoDatosAcum.setUnidades(unidades);        
        UtilidadesLog.debug("sale de obtenerAcumuladoProducto con dtoDatosAcum:"+dtoDatosAcum);    
        UtilidadesLog.info("CNInformeFaltantes.obtenerAcumuladoProducto(Long negocio, Long almacen, Long producto, ArrayList movAcumulados): Salida ");        
        return dtoDatosAcum;
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 20/07/2005
  * @Recibe: DTOMovimientoDiario dtoMovDiario, Long demanda, Long stock, Long unidades, Long faltante
  * @Retorna: DTOMovimiento 
  * @Descripción: metodo para traspasar los datos al DTOMovimiento diario.
  */ 
  private DTOMovimiento traspasarDatosDiario(DTOMovimientoDiario dtoMovDiario, Long demanda, Long stock, Long unidades, Double faltante){
      UtilidadesLog.info("CNInformeFaltantes.traspasarDatosDiario(DTOMovimientoDiario dtoMovDiario, Long demanda, Long stock, Long unidades, Double faltante): Entrada ");
      DTOMovimiento dtoRes = new DTOMovimiento();
      dtoRes.setAlmacen(dtoMovDiario.getAlmacen());
      dtoRes.setTxtAlmacen(dtoMovDiario.getTxtAlmacen());
      dtoRes.setNegocio(dtoMovDiario.getNegocio());
      dtoRes.setTxtNegocio(dtoMovDiario.getTxtNegocio());
      dtoRes.setIndDiario(Boolean.TRUE);
      dtoRes.setIndAhorro(dtoMovDiario.getIndAhorro());
      dtoRes.setTxtProducto(dtoMovDiario.getTxtProducto());
      dtoRes.setDemanda(demanda);
      dtoRes.setStockDisponible(stock);
      dtoRes.setFaltante(faltante);
      dtoRes.setUnidades(unidades);
      UtilidadesLog.info("CNInformeFaltantes.traspasarDatosDiario(DTOMovimientoDiario dtoMovDiario, Long demanda, Long stock, Long unidades, Double faltante): Salida ");
      return dtoRes;
  }
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 20/07/2005
  * @Recibe: DTOMovimientoDiario dtoMovDiario, Long demanda, Long faltante, Long unidades
  * @Retorna: DTOMovimiento 
  * @Descripción: metodo para traspasar los datos al DTOMovimiento Acumulado.
  */ 
  private DTOMovimiento traspasarDatosAcumulado(DTOMovimientoDiario dtoMovDiario, Long demanda, Double faltante, Long unidades){
      UtilidadesLog.info("CNInformeFaltantes.traspasarDatosAcumulado(DTOMovimientoDiario dtoMovDiario, Long demanda, Double faltante, Long unidades): Entrada ");
      DTOMovimiento dtoRes = new DTOMovimiento();
      dtoRes.setAlmacen(dtoMovDiario.getAlmacen());
      dtoRes.setTxtAlmacen(dtoMovDiario.getTxtAlmacen());
      dtoRes.setNegocio(dtoMovDiario.getNegocio());
      dtoRes.setTxtNegocio(dtoMovDiario.getTxtNegocio());
      dtoRes.setIndDiario(Boolean.FALSE);
      dtoRes.setIndAhorro(dtoMovDiario.getIndAhorro());
      dtoRes.setTxtProducto(dtoMovDiario.getTxtProducto());
      dtoRes.setDemanda(demanda);      
      dtoRes.setFaltante(faltante);
      dtoRes.setUnidades(unidades);
      UtilidadesLog.info("CNInformeFaltantes.traspasarDatosAcumulado(DTOMovimientoDiario dtoMovDiario, Long demanda, Double faltante, Long unidades): Salida ");
      return dtoRes;
  }  
}