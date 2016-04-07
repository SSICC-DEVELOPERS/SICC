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

package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.print.DAOPrinterSystem;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocal;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocalHome;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.dtos.rec.DTOConsolidarBoletasRecojo;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.msg.PatronCabeceraLocal;
import es.indra.sicc.entidades.msg.PatronCabeceraLocalHome;
import es.indra.sicc.entidades.msg.PatronPorPeriodoLocal;
import es.indra.sicc.entidades.msg.PatronPorPeriodoLocalHome;
import es.indra.sicc.logicanegocio.fac.DAOFACDocumentoContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DAODocuContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DAOFormulario;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOClienteSolicitud;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocLegal;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContableCabecera;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContableDetalle;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACFormulario;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOMovimientoDetalle;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DatosClienteHelper;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DocumentoFAC;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DocumentoMensajes;
import es.indra.sicc.logicanegocio.msg.MONImpresionMensajes;
import es.indra.sicc.logicanegocio.msg.MONImpresionMensajesHome;
import es.indra.sicc.logicanegocio.rec.MONGestionRecojosLocal;
import es.indra.sicc.logicanegocio.rec.MONGestionRecojosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesBD;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;



public class MONImpresionSICCBean implements SessionBean  {
    ArrayList misDetallesFactura = new ArrayList();
    private UtilidadesLog log = new UtilidadesLog();
    
    // sapaza -- PER-SiCC-2011-0138 -- 22/02/2011
    private String codigoPais;
    private HashMap periodos = new HashMap();
    
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

    // Modificado por la BELC300011627, BELC300013541
    public void generarDocFactura(DTOFACConsolidado datosConsolidado) throws MareException {
      UtilidadesLog.info("MONImpresionSICCBean.generarDocFactura(DTOFACConsolidado datosConsolidado): Entrada");
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("*** MONImpresionSICC.generarDocFactura: consolidado="+datosConsolidado);
          
      try{
            //  Agregado por HRCS - Fecha 04/05/2007 - Cambio Sicc20070216
        if (datosConsolidado.getDtoCabecera().getUnidadesAtendidasTotal()!=null && datosConsolidado.getDtoCabecera().getUnidadesAtendidasTotal().intValue()!=0) {
          // sapaza -- PER-SiCC-2011-0138 -- 22/02/2011
          invocarProcedimientoLaser(datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(),  
                 datosConsolidado.getDtoCabecera().getOidPais(), datosConsolidado.getDtoCabecera().getPeriodo());
           
          if (datosConsolidado.getIndOnline() != null && datosConsolidado.getIndOnline().booleanValue()) {
            SpoolManagerLocal spoolManager = this.getSpoolManager();	
            Long IDSpool = null;
            try {
              IDSpool = spoolManager.openSpool(datosConsolidado.getSubaccesoUsuario());
              datosConsolidado.setIDSpool(IDSpool);
            } catch (Exception re) {
              UtilidadesLog.error("*** Error en continuarFacturacion en la llamada a openSpool",re);
              String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
            }
          }
                
          String descripUbigeo=null;
          DAOFormulario miDaoFormulario=new DAOFormulario();
          DAOFACDocumentoContable dao = new DAOFACDocumentoContable(ctx.getCallerPrincipal().getName());
          
          Iterator it = (Iterator)datosConsolidado.getListaSolicitudes().iterator();          
          ArrayList listaTiposProgramas = new ArrayList();
          while (it.hasNext()) {
            DTOFACCabeceraSolicitud dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)it.next(); 
            if (!listaTiposProgramas.contains(dtoCabeceraSolicitud.getOidTipoConcursoPrograma())) {
              listaTiposProgramas.add(dtoCabeceraSolicitud.getOidTipoConcursoPrograma());  
            }            
          }
                    
          ArrayList listFormularios = miDaoFormulario.obtenerFormulario(datosConsolidado.getDtoCabecera().getTipoSolicitud(), datosConsolidado.getSubaccesoUsuario());
          DAOPrinterSystem miDaoPrinterSystem = new DAOPrinterSystem();
          ArrayList listDocumentoLegales= clasificarDocumentosLegales(listFormularios);
          ArrayList listDocumentosXML = clasificarDocumentosXML(listFormularios);
          DAODocuContable daoActivo= new DAODocuContable();
          RecordSet datosRecuperados= daoActivo.obtenerDatosDocumentos(datosConsolidado.getDtoCabecera());
          RecordSet datosRecuperadosNoLegales= daoActivo.obtenerDatosDocumentosNoLegales(datosConsolidado.getDtoCabecera());
                
          UtilidadesLog.debug("Datos legales recuperados:"+datosRecuperados.getRowCount());  
          ArrayList oidsCabecera = new ArrayList();//para modificar en fac_docum_conta_cabec
          for (int i=0; i<listDocumentoLegales.size();i++) {
            DTOFACFormulario miFormulario = (DTOFACFormulario)listDocumentoLegales.get(i);
            RecordSet detallesFormulario= this.reproducirModeloTabla(datosRecuperados);
                  
            long tipoDocu = miFormulario.getOidFormulario().longValue();
            int indImpresion;
            
            int sizeArrayTipoProgramas = listaTiposProgramas.size();
            
            for (int itProg = 0; itProg < sizeArrayTipoProgramas; itProg++) {
                Long oidTipoProgramaInc = (Long)listaTiposProgramas.get(itProg);

                UtilidadesLog.debug("Tipo Docu y Programa ------> " + tipoDocu + "     " + oidTipoProgramaInc); 
                int longRSDatosRecuperados = datosRecuperados.getRowCount();      
                for (int numLinea=0;numLinea < longRSDatosRecuperados;numLinea++) {
                  UtilidadesLog.debug("oidFormulariodatosRecuperados=" + datosRecuperados.getValueAt(numLinea,"A_FORS_OID_FORM") + ", tipoDocuFormulario=" + tipoDocu);
                  if (((BigDecimal)datosRecuperados.getValueAt(numLinea,"A_FORS_OID_FORM")).longValue() == tipoDocu) {
                    if ((oidTipoProgramaInc == null && datosRecuperados.getValueAt(numLinea, "ICTP_OID_TIPO_PROG") == null) || 
                      (oidTipoProgramaInc != null && datosRecuperados.getValueAt(numLinea, "ICTP_OID_TIPO_PROG") != null &&((BigDecimal)datosRecuperados.getValueAt(numLinea, "ICTP_OID_TIPO_PROG")).longValue() == oidTipoProgramaInc.longValue())) {                     
                          detallesFormulario.addRow(datosRecuperados.getRow(numLinea));
                    }
                  }
                }
                
                UtilidadesLog.debug("Para el documento "+i+" tenemos "+detallesFormulario.getRowCount());    
                int docLegalesAniadidos = 0;
                if (detallesFormulario.getRowCount()!=0) {
                  DTODocLegal miDTODocLegal= new DTODocLegal();
                  ArrayList paginasFormulario= obeterEstructuraPaginas(detallesFormulario);
                          
                  RecordSet rs = (RecordSet)paginasFormulario.get(0);
                  String rutina = rs.getValueAt(0, "VAL_RUTI_DISE_FORM").toString();
                  Long pais = new Long(rs.getValueAt(0, "A_PAIS_OID_PAIS").toString());
                  if (! daoActivo.verificarImpresionPercepcion(miFormulario.getOidFormulario(), pais).booleanValue()) {                      
                    datosConsolidado.setIndImprimirPercepcion(Boolean.FALSE);
                  } else {
                    datosConsolidado.setIndImprimirPercepcion(Boolean.TRUE);
                  }                
                  if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("La tasa de percepcion queda asi: " + datosConsolidado.getTasaImpuestoPercepcion());
                    UtilidadesLog.debug("El Indicador de Imprimir Percepcion queda asi: " + datosConsolidado.getIndImprimirPercepcion());
                  }  
                          
                  for (int numPagina=0; numPagina<paginasFormulario.size(); numPagina++) {
                    RecordSet miPagina= (RecordSet)paginasFormulario.get(numPagina);
                      
                    DTOFACDocumentoContable miDocumentoContable=new DTOFACDocumentoContable();
                    miDTODocLegal.añadirPagina(miDocumentoContable);
                    docLegalesAniadidos = docLegalesAniadidos + 1;
                    for (int numDetalle=0; numDetalle<miPagina.getRowCount(); numDetalle++) {
                      if (numDetalle==0) {
                        DTOFACDocumentoContableCabecera miCabe=new DTOFACDocumentoContableCabecera();
                        if (descripUbigeo==null) {
                          if (datosRecuperados != null && !datosRecuperados.esVacio()) {
                            descripUbigeo = daoActivo.obtenerDescripcionUBIGEO(new Long(((BigDecimal)datosRecuperados.getValueAt(0, "OID_VALO_ESTR_GEOP")).longValue()));
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                              UtilidadesLog.debug("La descripcion ubigeo es: "+descripUbigeo);
                          } else {
                            descripUbigeo = "";
                          }
                        }
                        miCabe.setDescripcionUbigeo(descripUbigeo);
                        rellenarDTOFACDocumentoContableCabecera((RecordSet)paginasFormulario.get(numPagina),miCabe,datosConsolidado);
                        UtilidadesLog.debug("flete sin impuestos: " + miCabe.getImporteFleteSinImpuestosTotalLocal());
                        UtilidadesLog.debug("flete total: " + miCabe.getImporteFleteTotalLocal());
                        miDocumentoContable.setCabecera(miCabe);
                        oidsCabecera.add(miDocumentoContable.getCabecera().getOidCabecera());
                        UtilidadesLog.debug("El oid cabecera es: "+miDocumentoContable.getCabecera().getOidCabecera());
                        UtilidadesLog.debug("El oid cabecera es1: "+miDocumentoContable.getCabecera().getOidCabeceraSolicitud());
                      }
                      DTOFACDocumentoContableDetalle miDet= new  DTOFACDocumentoContableDetalle();
                      rellenarDTOFACDocumentoContableDetalle((RecordSet)paginasFormulario.get(numPagina),miDet,numDetalle);
                      miDocumentoContable.addDetelle(miDet);  
                    }
                  }
                  
                          //llamo a la clase
                  UtilidadesLog.debug("es.indra.sicc.logicanegocio.fac.generaciondocumentos."+miFormulario.getRutinaDiseñoFormulario());
                  DocumentoFAC docu=getInstanciaPorNombre("es.indra.sicc.logicanegocio.fac.generaciondocumentos."+miFormulario.getRutinaDiseñoFormulario());
                  miDTODocLegal.setIndOnline(datosConsolidado.getIndOnline());
                  docu.componerFactura(miDTODocLegal);
                  DTODocumento dtoDocu= new DTODocumento();
                  dtoDocu.setDocumentoByte(docu.getDocument());
                  dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
                  dtoDocu.setTipoDocumento(miFormulario.getOidImpresoraVirtual());  
                  SpoolManagerLocal spoolManager = this.getSpoolManager();
                           
                  Long clave = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
                            
                  if (datosConsolidado.getIndOnline() != null && !datosConsolidado.getIndOnline().booleanValue()) {
                    this.actualizarSecuenciaDocumentoImpresion(clave, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), miFormulario.getOidTipoDocumentoLegal(), datosConsolidado.getIDSpool(), oidTipoProgramaInc);
                  }
                  dao.marcarDocumentoComoImpreso(oidsCabecera);
                  oidsCabecera.clear();
                  int sizeRS = detallesFormulario.getRowCount();
                  for (int x=0 ; x<sizeRS; x++ ) {
                    detallesFormulario.removeRow(0);
                  }                  
                }
            }    
          }
          
          
          
          
          
          DTODocLegal miDTODocNoLegal;
          RecordSet resultado;
          DTOFACDocumentoContable miDocumentoContable;
          DTOFACDocumentoContableCabecera miDocumentoContableCabecera;
                    
          byte[] documentoUnico = null;
          byte[] documentoAgrupado = new byte[0];
          DTOClienteSolicitud dtoClienteSolicitud = null;
            
          MONImpresionMensajes monImpresionMensajes = this.getMONImpresionMensajes();
          DTOImpresion dtoMensajesFinal[] = null;
          
          //<inicio>modificado por Sapaza, fecha 13-09-2007, incidencia Sicc-20070418
          boolean imprimirMensajes = false;
          DTOFACFormulario formul = null;
          for (int i=0;i<listDocumentosXML.size();i++) {
            formul = (DTOFACFormulario)listDocumentosXML.get(i);  
            if (esDocumentoMensaje(formul.getRutinaDiseñoFormulario()))
                imprimirMensajes = true;
          }
          if(imprimirMensajes) {
              try {
                dtoMensajesFinal = monImpresionMensajes.imprimirMensajesFacturacion(datosConsolidado);
              } catch (Exception re) {
                UtilidadesLog.error("ERROR",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
              }
          }
          //<fin>modificado por Sapaza, fecha 13-09-2007, incidencia Sicc-20070418
          Long oidDocumentoGenerado = null;
          for (int i=0;i<listDocumentosXML.size();i++) {
            formul = (DTOFACFormulario)listDocumentosXML.get(i);  
            documentoUnico = new byte[0];
            UtilidadesLog.debug("Se va a imprimir: "+ formul.getRutinaDiseñoFormulario());
           if (esDocumentoNoLegal(formul.getRutinaDiseñoFormulario())){
                if (formul.getRutinaDiseñoFormulario().equals("ListaDePicado")){
                    if (datosConsolidado.getDtoCabeceraListaPicado() == null)
                        //sapaza -- cambio Optimizacion Logs -- 05/03/2010, Recategorizacion de nivel ERROR a INFO
                        UtilidadesLog.info("Datos del consolidado, para la lista de picado vacios, no se generará la misma!!");
                    else
                        documentoUnico = procesarDocumentoNoLegalListaPicado(formul, datosConsolidado);
                }else{
                    documentoUnico = procesarDocumentoNoLegal(formul, datosConsolidado, datosRecuperados, datosRecuperadosNoLegales, dtoClienteSolicitud);
                }                           
            }else if (esDocumentoMensaje(formul.getRutinaDiseñoFormulario())){
                documentoUnico = procesarDocumentoMensaje(formul, datosConsolidado, datosRecuperados, datosRecuperadosNoLegales, dtoClienteSolicitud, dtoMensajesFinal);
            }
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("Salida IMpresa: "+new String(documentoUnico));
              
            if (formul.getIndicadorSpoolIndividual()) {
              DTODocumento dtoDocu= new DTODocumento();
              dtoDocu.setDocumentoByte(documentoUnico);
              dtoDocu.setDocumento(new String(documentoUnico));
              dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
              dtoDocu.setTipoDocumento(formul.getOidImpresoraVirtual());
              SpoolManagerLocal spoolManager = this.getSpoolManager();
              UtilidadesLog.debug("MONImpresionSICC.generarDocFactura manda a imprimir documentos XML");
              oidDocumentoGenerado = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
            } else {
              documentoAgrupado = this.concatenaByte(documentoAgrupado, documentoUnico);
            }
          }
          if (documentoAgrupado.length > 0) {
            DTODocumento dtoDocu= new DTODocumento();
            dtoDocu.setDocumentoByte(documentoAgrupado);
            dtoDocu.setDocumento(new String(documentoUnico));
            dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
            dtoDocu.setTipoDocumento(formul.getOidImpresoraVirtual());
            SpoolManagerLocal spoolManager = this.getSpoolManager();
            UtilidadesLog.debug("MONImpresionSICC.generarDocFactura manda a imprimir documentos XML");              
            oidDocumentoGenerado = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
            
            // sapaza -- PER-SiCC-2011-0138 -- 22/02/2011
            StringBuffer actualizar = new StringBuffer();
            actualizar.append("UPDATE GEN_DOCUM_IMPRI ");
            actualizar.append("   SET SOCA_OID_SOLI_CABE = " + datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
            actualizar.append(" WHERE OID_DOCU_IMPR = " + oidDocumentoGenerado);
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            bs.dbService.executeUpdate(actualizar.toString());
          }
          
          if (datosConsolidado.getIndOnline() != null && datosConsolidado.getIndOnline().booleanValue()) {
              this.getSpoolManager().closeSpool(datosConsolidado.getIDSpool());
          }    
              
          StringBuffer consulta = new StringBuffer();
          consulta.append("UPDATE PED_SOLIC_CABEC ");
          consulta.append("SET IND_IMPR = 1 ");
          consulta.append("WHERE OID_SOLI_CABE = " + datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud() );
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executeUpdate(consulta.toString());
       } else {
          UtilidadesLog.info("No se generan documentos de facturacion porque el Numero de Unidades Atentidas en el Consolidado con Oid["+ datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud() +"] es 0.");
              
          StringBuffer consulta = new StringBuffer();
          consulta.append("UPDATE PED_SOLIC_CABEC ");
          consulta.append("SET IND_IMPR = 0 ");
          consulta.append("WHERE OID_SOLI_CABE = " + datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud() );
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executeUpdate(consulta.toString());
        }
      } catch (Exception e)  {
        UtilidadesLog.error("ERROR ",e);
        throw new MareException (e); //agregado por Sergio Apaza, PER-SiCC-2010-0015 Controlar Transaccionalidad al Generar Paquete Documentario            
      } 
      UtilidadesLog.info("MONImpresionSICCBean.generarDocFactura(DTOFACConsolidado datosConsolidado): Salida");
	}
  
   private Long bigDecimalToLong(Object numero) {
     if (numero != null) {
       return new Long(((BigDecimal) numero).longValue());
     } else {
       return null;
     }
  }

   private Integer bigDecimalToInteger(Object numero) {
    if (numero != null) {
      return new Integer(((BigDecimal) numero).intValue());
    } else {
      return null;
    }
  }

   private Float bigDecimalToFloat(Object numero) {
        if (numero != null) {
            return new Float(((BigDecimal) numero).floatValue());
        } else {
            return new Float(0);
        }
   }
    
    private byte[] procesarDocumentoNoLegalListaPicado(DTOFACFormulario formul, DTOFACConsolidado datosConsolidado) throws Exception{
        UtilidadesLog.info("MONImpresionSICCBean.procesarDocumentoNoLegalListaPicado(DTOFACFormulario formul, DTOFACConsolidado datosConsolidado): Entrada");
        DocumentoFAC docu=getInstanciaPorNombre("es.indra.sicc.logicanegocio.fac.generaciondocumentos."+formul.getRutinaDiseñoFormulario());
        docu.componerFactura(datosConsolidado);
        UtilidadesLog.info("MONImpresionSICCBean.procesarDocumentoNoLegalListaPicado(DTOFACFormulario formul, DTOFACConsolidado datosConsolidado): Salida");
        return docu.getDocument();
    }
    
    /**
     * CHANGELOG
     * ---------
     * 21/08/2009 - dmorello, Cambio 20080765 - Se maneja por separado el caso BoletaRecojoColombia
     */
    private byte[] procesarDocumentoNoLegal(DTOFACFormulario formul, DTOFACConsolidado datosConsolidado,RecordSet datosRecuperados, RecordSet datosRecuperadosNoLegales, DTOClienteSolicitud dtoClienteSolicitud) throws Exception {
        String rutina=formul.getRutinaDiseñoFormulario();         
        DTODocLegal miDTODocNoLegal = new DTODocLegal();
        DTOFACDocumentoContable miDocumentoContable = new DTOFACDocumentoContable();
        DTOFACDocumentoContableCabecera miDocumentoContableCabecera = new DTOFACDocumentoContableCabecera();
        miDocumentoContable.setCabecera(miDocumentoContableCabecera);
        miDTODocNoLegal.añadirPagina(miDocumentoContable); 
        miDocumentoContableCabecera.setNumeroDecimales(datosConsolidado.getDtoCabecera().getNumeroDecimalesRedondeo());
        if (!datosRecuperados.esVacio() &&datosRecuperados.getValueAt(0, "OID_VALO_ESTR_GEOP")!=null){
            miDocumentoContable.getCabecera().setOidUbigeo(new Long(((BigDecimal)datosRecuperados.getValueAt(0, "OID_VALO_ESTR_GEOP")).longValue()));
        }
        this.rellenarDTOFACDocumentoNoLegal(datosRecuperadosNoLegales, miDocumentoContable.getCabecera(), datosConsolidado);
        if (rutina.equals("DetalleFacturaColombia")) {
            this.rellenarDTOFACDocumentoContableCabecera(datosRecuperados, miDocumentoContable.getCabecera(), datosConsolidado);
            miDocumentoContable.setDetalle(this.misDetallesFactura);
        } else {
            this.rellenarDTOFACDocumentoNoLegal(datosRecuperadosNoLegales, miDocumentoContable.getCabecera(), datosConsolidado);
        }        
        if (rutina.equals("BoletaDeDespacho")) {
            HashMap hashDatosPremios = (HashMap)this.generarHashDatosPremios(datosConsolidado.getListaSolicitudes());
            miDocumentoContable.getCabecera().setHashDatosPremios(hashDatosPremios);
            miDocumentoContableCabecera.setListaSolicitudes((ArrayList)datosConsolidado.getListaSolicitudes());
            miDocumentoContableCabecera.setIndicadorRevision(datosConsolidado.getDtoCabecera().getIndicadorRevision());            
        }
   
        if(rutina.equals("CuponDePagoPeru")){
            this.componerDatosCCC(datosConsolidado, miDTODocNoLegal);
            DAODocuContable daoDocuContable = new DAODocuContable();
            daoDocuContable.actualizarFechaGeneracionCuponCliente(datosConsolidado.getDtoCabecera().getFechaFacturacion(), datosConsolidado.getDtoCabecera().getOidCliente());
        }   
        /* Agregado por Cambio FAC-001 ------ AL */
        if (rutina.equals("BoletaEntregaColombia") || rutina.equals("SolicitudPostVenta")) {
           miDocumentoContableCabecera.setListaSolicitudes((ArrayList)datosConsolidado.getListaSolicitudes());
           miDocumentoContableCabecera.setIndPedidoServicio(datosConsolidado.getDtoCabecera().getIndPedidoServicio());
           miDocumentoContableCabecera.setTelefonoFijo(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "TELEF_FIJO")));
           miDocumentoContableCabecera.setTelefonoCelular(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "TELEF_CEL")));
           miDocumentoContableCabecera.setListaDetalle((ArrayList)datosConsolidado.getListaPosiciones());
           miDocumentoContableCabecera.setMunicipio(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "MUNICIPIO")));
           miDocumentoContableCabecera.setDepartamento(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "DEPARTAMENTO")));
           miDocumentoContableCabecera.setBarrio(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "VAL_BARR")));
           miDocumentoContableCabecera.setFechaEntrega(datosConsolidado.getDtoCabecera().getFechaEntrega());
           miDocumentoContableCabecera.setPrimerPedido(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "PRI_PED")));           
           miDocumentoContableCabecera.setIdSpool(datosConsolidado.getIDSpool());           
        } else if (rutina.equals("BoletaRecojoColombia")) {
           /* dmorello, 21/08/2009 - Se separa del if anterior este bloque y se modifica */
           
           MONGestionRecojosLocalHome homeGest = this.getMONGestionRecojosLocalHome();
           MONGestionRecojosLocal monGest = null;
           try {
               monGest = homeGest.create();
           } catch (CreateException e) {
               String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
           }
           
           // Se consolidan las boletas de recojo
           DTOConsolidarBoletasRecojo dtoCons = new DTOConsolidarBoletasRecojo();
           dtoCons.setOidPais(datosConsolidado.getDtoCabecera().getOidPais());
           dtoCons.setOidCliente(datosConsolidado.getDtoCabecera().getOidCliente());
           dtoCons.setOidConsolidado(datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
           UtilidadesLog.debug("dtoCons: " + dtoCons);
           
           miDocumentoContable = monGest.consolidarBoletasRecojoDesdeFAC(dtoCons, miDocumentoContable);
           
           // indPedidoServicio y fechaEntrega ya vienen seteados desde REC
           // Se setean otros campos de miDocumentoContableCabecera
           miDocumentoContableCabecera = miDocumentoContable.getCabecera();
           miDocumentoContableCabecera.setListaSolicitudes((ArrayList)datosConsolidado.getListaSolicitudes());
           miDocumentoContableCabecera.setTelefonoFijo(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "TELEF_FIJO")));
           miDocumentoContableCabecera.setTelefonoCelular(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "TELEF_CEL")));
           miDocumentoContableCabecera.setListaDetalle((ArrayList)datosConsolidado.getListaPosiciones());
           miDocumentoContableCabecera.setMunicipio(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "MUNICIPIO")));
           miDocumentoContableCabecera.setDepartamento(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "DEPARTAMENTO")));
           miDocumentoContableCabecera.setBarrio(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "VAL_BARR")));
           miDocumentoContableCabecera.setPrimerPedido(UtilidadesBD.convertirAString(datosRecuperados.getValueAt(0, "PRI_PED")));           
           miDocumentoContableCabecera.setIdSpool(datosConsolidado.getIDSpool());           
        }

        /* Agregado por Cambio FAC-001 ------ AL */   
        
        /* Agregado por Cambio FAC-003-COL ------ AL */
        if (rutina.equals("CuponDePagoColombia")) {
            miDocumentoContableCabecera.setDiasCruce(UtilidadesBD.convertirALong(datosRecuperados.getValueAt(0, "DIAS_CRUCE")));        
        }
        /* Agregado por Cambio FAC-003-COL ------ AL */

        DocumentoFAC docu = getInstanciaPorNombre("es.indra.sicc.logicanegocio.fac.generaciondocumentos." + formul.getRutinaDiseñoFormulario());
        UtilidadesLog.debug("El usuario es: " + ctx.getCallerPrincipal().getName());
        miDTODocNoLegal.setUsuario(ctx.getCallerPrincipal().getName());
        
        if (dtoClienteSolicitud == null){
            DatosClienteHelper datosClienteHelper = new DatosClienteHelper();
            ArrayList listaPaginas = miDTODocNoLegal.getlistaPaginas();
            DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(0);              
            dtoClienteSolicitud = datosClienteHelper.obtenerDatosCliente(docuContable.getCabecera().getOidCabeceraSolicitud(), miDTODocNoLegal.getUsuario());
        }
        docu.setDtoClienteSolicitud(dtoClienteSolicitud);
        docu.componerFactura(miDTODocNoLegal);
        
        /*
         * Cerrar spool cuando la ejecucion en online
         */
        return docu.getDocument();
    }
    
    private byte[] procesarDocumentoMensaje(DTOFACFormulario formul, DTOFACConsolidado datosConsolidado,RecordSet datosRecuperados, RecordSet datosRecuperadosNoLegales, DTOClienteSolicitud dtoClienteSolicitud, DTOImpresion dtoMensajesFinal[]) throws Exception{
        ArrayList listaPatrones = this.obtenerPatronDocumento(formul.getOidFormulario(), datosConsolidado.getDtoCabecera().getPeriodo());
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("Patrones seleccionados: "+listaPatrones);
        
        byte[] documentoAgrupado = new byte[0];
        if (listaPatrones.size()>0) {
            ArrayList array = new ArrayList();
            if (dtoMensajesFinal != null){
                for(int k=0;k<dtoMensajesFinal.length;k++){
                    array.add(dtoMensajesFinal[k]);
                }
                for(int t = 0; t< listaPatrones.size(); t++){
                    DTODocumento dtoDoc = this.getDocumentoMensajes((Long)listaPatrones.get(t), array);
                    documentoAgrupado = this.concatenaByte(documentoAgrupado, dtoDoc.getDocumentoByte());
                }
            }
        }
        return documentoAgrupado;
    }
    
    
	
    private ArrayList obeterEstructuraPaginas(RecordSet registroEntrada){ 
        UtilidadesLog.info("MONImpresionSICCBean.obeterEstructuraPaginas(RecordSet registroEntrada): Entrada");
        
        ArrayList salida= new ArrayList();
        boolean fin=false;
        int oidCabAux=Integer.MAX_VALUE;
        RecordSet recordSetActivo=null;
        RecordSet auxRecord= this.reproducirModeloTabla(registroEntrada);
    
        int oidRecuperado;
  
        for(int i=0; i<registroEntrada.getRowCount(); i++){
              oidRecuperado=((BigDecimal)registroEntrada.getValueAt(i,"A_OID_CABE")).intValue();
              
              if(oidCabAux != oidRecuperado){
                 if(recordSetActivo!=null){
                    salida.add(recordSetActivo);
                }
               
                RecordSet registro= this.reproducirModeloTabla(auxRecord);
                registro.addRow(registroEntrada.getRow(i)); 
               
                oidCabAux=oidRecuperado;
                recordSetActivo= registro; 
                
             }else{
                recordSetActivo.addRow(registroEntrada.getRow(i)); 
             }
        }
        salida.add(recordSetActivo);
        UtilidadesLog.info("MONImpresionSICCBean.obeterEstructuraPaginas(RecordSet registroEntrada): Salida");
         
        return salida;
    }

    /**
     * CHANGELOG
     * ---------
     * dmorello, 23/06/2009 - Cambio 20090900
     *     Se setea en el DTOFACDocumentoContableCabecera el valor del flag IND_IMPR_PROD_FUER_CAJA_BOLS
     *     que viene en el parametro "entrada"
     * dmorello, 26/06/2009 - Cambio 20090900
     *     Se incluyen productos con indicador fuera caja/bolsa == null en el documento no legal
     * dmorello, 02/07/2009 - Cambio 20090900
     *     Si el flag IND_IMPR_PROD_FUER_CAJA_BOLS esta activo, no se incluyen en el documento no legal
     *     los premios con indicador fuera caja/bolsa nulo.
     */
    public DTOFACDocumentoContableCabecera rellenarDTOFACDocumentoNoLegal(RecordSet entrada, DTOFACDocumentoContableCabecera dtoEntrada, DTOFACConsolidado datosConsolidado) {
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoNoLegal(RecordSet entrada, DTOFACDocumentoContableCabecera dtoEntrada, DTOFACConsolidado datosConsolidado): Entrada");
       
       DAODocuContable daoActi= new DAODocuContable();
        DTOFACCabeceraSolicitud cabe=  datosConsolidado.getDtoCabecera();     
        
        if (dtoEntrada.getOidUbigeo() != null && (dtoEntrada.getDescripcionUbigeo()==null || dtoEntrada.getDescripcionUbigeo().trim().length()==0)){
            try {
                dtoEntrada.setDescripcionUbigeo(daoActi.obtenerDescripcionUBIGEO(dtoEntrada.getOidUbigeo()));
            } catch(Exception e) {
                UtilidadesLog.error("ERROR",e);
            }
        }
    
    try {
        dtoEntrada.setNumeroSecuenciaFacturacionDiaria(cabe.getNumeroSecuenciaFacturacionDiaria());
        dtoEntrada.setNumConsolidado(cabe.getNumeroConsolidado());
        dtoEntrada.setTotalAPagarLocal(cabe.getTotalAPagarLocal());
        dtoEntrada.setFechaFacturacion(cabe.getFechaFacturacion());
        dtoEntrada.setNumeroSolicitud(cabe.getNumeroSolicitud());
        dtoEntrada.setOidPais(cabe.getOidPais());
        dtoEntrada.setOidCliente(cabe.getOidCliente());
        dtoEntrada.setOidIdioma(cabe.getOidIdioma());
        dtoEntrada.setOidCabeceraSolicitud(cabe.getOidCabeceraSolicitud());
        dtoEntrada.setTasaImpuestoPercepcion(datosConsolidado.getTasaImpuestoPercepcion());
        dtoEntrada.setIndImprimirPercepcion(datosConsolidado.getIndImprimirPercepcion());

    
      if (!entrada.esVacio()) {
        dtoEntrada.setApellido1(entrada.getValueAt(0,"VAL_APE1")!=null?entrada.getValueAt(0,"VAL_APE1").toString():"");
        dtoEntrada.setApellido2(entrada.getValueAt(0,"VAL_APE2")!=null?entrada.getValueAt(0,"VAL_APE2").toString():"");
        dtoEntrada.setNombre1(entrada.getValueAt(0,"VAL_NOM1")!=null?entrada.getValueAt(0,"VAL_NOM1").toString():"");
        dtoEntrada.setNombre2(entrada.getValueAt(0,"VAL_NOM2")!=null?entrada.getValueAt(0,"VAL_NOM2").toString():"");        
        dtoEntrada.setCodCliente(UtilidadesBD.convertirAString(entrada.getValueAt(0,"COD_CLIE")));
        /* Se modifica por Migracion ---- AL --- 05/11/2008 */
        //dtoEntrada.setNombreVia(UtilidadesBD.convertirAString(entrada.getValueAt(0, "VAL_DIRE_COMP")));
        dtoEntrada.setNombreVia(new String(""));
        /* Se modifica por Migracion ---- AL --- 05/11/2008 */
        dtoEntrada.setNumUnidadesAtendidas(UtilidadesBD.convertirAInteger(entrada.getValueAt(0, "NUM_UNID_ATEN_TOTA")));
        dtoEntrada.setCodZona(UtilidadesBD.convertirAString(entrada.getValueAt(0,"COD_ZONA")));
        dtoEntrada.setOidZona(UtilidadesBD.convertirALong(entrada.getValueAt(0,"OID_ZONA")));
        dtoEntrada.setTelefono(UtilidadesBD.convertirAString(entrada.getValueAt(0,"VAL_TEXT_COMU")));
        dtoEntrada.setCodSeccion(UtilidadesBD.convertirAString(entrada.getValueAt(0,"COD_SECC")));
        dtoEntrada.setCodTerritorio(UtilidadesBD.convertirAString(entrada.getValueAt(0,"COD_TERR")));
        dtoEntrada.setNombrePeriodo(UtilidadesBD.convertirAString(entrada.getValueAt(0,"VAL_NOMB_PERI")));  
        dtoEntrada.setCodRegion(UtilidadesBD.convertirAString(entrada.getValueAt(0,"COD_REGI")));
        dtoEntrada.setCodPeriodo(UtilidadesBD.convertirAString(entrada.getValueAt(0,"COD_PERI")));
        dtoEntrada.setOidPeriodo(this.bigDecimalToLong(entrada.getValueAt(0,"OID_PERI")));        
      }
      
        UtilidadesLog.debug("Antes de Hash ----- Rellenar No Legal");
        HashMap hashSolicitudesOrigen = (HashMap)this.generarHashSolicitudes(datosConsolidado.getListaSolicitudes());

        DTOFACPosicionSolicitud detalle;
        ArrayList detalles=(ArrayList)datosConsolidado.getListaPosiciones();
        dtoEntrada.setUnidadesFueraCaja(new Integer(0));
        dtoEntrada.setUnidadesEnBolsa(new Integer(0));
        dtoEntrada.setUnidadesPremiosCaja(new Integer(0));
        ArrayList arrayFueraCaja = new ArrayList();
        int valor;
        if (detalles != null){
          for (int i = 0; i < detalles.size(); i++) {
            detalle = (DTOFACPosicionSolicitud)detalles.get(i);
            String indicador = null;

            if (detalle.getIndicadorDentroFueraCajaBolsa() != null){
              indicador = detalle.getIndicadorDentroFueraCajaBolsa().toUpperCase();
            }
            if (detalle.getUnidadesAtendidas().intValue() > 0) {
              DTOFACCabeceraSolicitud solicitudOrigen = (DTOFACCabeceraSolicitud)hashSolicitudesOrigen.get(detalle.getOidCabecera());
              if("F".equals(indicador)) {
                valor = dtoEntrada.getUnidadesFueraCaja().intValue();
                dtoEntrada.setUnidadesFueraCaja(new Integer(valor + detalle.getUnidadesAtendidas().intValue()));
                detalle.setCodigoTipoProgramaConcurso(((DTOFACCabeceraSolicitud)hashSolicitudesOrigen.get(detalle.getOidCabecera())).getCodigoTipoProgramaConcu());
                arrayFueraCaja.add(detalle);
              } else if("B".equals(indicador)) {
                valor = dtoEntrada.getUnidadesEnBolsa().intValue();
                dtoEntrada.setUnidadesEnBolsa(new Integer(valor + detalle.getUnidadesAtendidas().intValue()));
                detalle.setCodigoTipoProgramaConcurso(((DTOFACCabeceraSolicitud)hashSolicitudesOrigen.get(detalle.getOidCabecera())).getCodigoTipoProgramaConcu());
                arrayFueraCaja.add(detalle);
              } else if (solicitudOrigen.getCodigoTipoProgramaConcu() != null
                    && ! Boolean.TRUE.equals(dtoEntrada.getIndImpresionProdFueraCajaBolsa())) {
                valor = dtoEntrada.getUnidadesPremiosCaja().intValue();
                dtoEntrada.setUnidadesPremiosCaja(new Integer(valor + detalle.getUnidadesAtendidas().intValue()));
                detalle.setCodigoTipoProgramaConcurso(solicitudOrigen.getCodigoTipoProgramaConcu());
                arrayFueraCaja.add(detalle);
              }
            }
          }
        }
        Collections.sort(arrayFueraCaja, new ProductoComparator());
        dtoEntrada.setListaDetalle(arrayFueraCaja);     
        
        // Cambio 20090900 - dmorello, 23/06/2009
        boolean indImprProd = UtilidadesBD.convertirABoolean(entrada.getValueAt(0, "IND_IMPR_PROD_FUER_CAJA_BOLS"));
        UtilidadesLog.debug("indImprProd: " + indImprProd);
        dtoEntrada.setIndImpresionProdFueraCajaBolsa(Boolean.valueOf(indImprProd));
        
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoNoLegal(RecordSet entrada, DTOFACDocumentoContableCabecera dtoEntrada, DTOFACConsolidado datosConsolidado): Salida");
    } catch (Exception e){
       UtilidadesLog.error(" **** ERROR" + e); 
    }
        // Modificado por la BELC300011955
        return dtoEntrada;
    }

    private HashMap generarHashSolicitudes(ArrayList arraySolicitudes) {
        HashMap hash = new HashMap();
        Iterator it = (Iterator)arraySolicitudes.iterator();
        
        while (it.hasNext()) {
          DTOFACCabeceraSolicitud cabecera = (DTOFACCabeceraSolicitud)it.next();
          hash.put(cabecera.getOidCabeceraSolicitud(), cabecera);        
        }        
        return hash;
    }

    private HashMap generarHashDatosPremios(ArrayList arraySolicitudes) throws MareException {
        ArrayList arraySoliTipoC = new ArrayList();        
        Iterator it = (Iterator)arraySolicitudes.iterator();
        HashMap hashDatos = new HashMap();
        while (it.hasNext()) {
          DTOFACCabeceraSolicitud cabecera = (DTOFACCabeceraSolicitud)it.next();
          if (cabecera.getCodigoTipoProgramaConcu() != null && cabecera.getCodigoTipoProgramaConcu().equals("C")) {
            arraySoliTipoC.add(cabecera.getOidCabeceraSolicitud());            
          }    
        }    
        if (arraySoliTipoC.size() > 0){
         DAODocuContable daoActivo= new DAODocuContable();
         hashDatos = (HashMap)daoActivo.recuperarDatosPremios(arraySoliTipoC);
        }                
        return hashDatos;
    }

   

   
  

    // Modificado por la 12124
    private void rellenarDTOFACDocumentoNoLegalCabeceraCCC(DTOFACDocumentoContableCabecera dtoEntrada)throws MareException{
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoNoLegalCabeceraCCC(DTOFACDocumentoContableCabecera dtoEntrada): Entrada");
        
        /*IMPORTANTE!!!!
        Deberemos llamar al método "calcularFechaDeVencimiento" q se debe diseñar (mirar incidencia: BELC300011135) 
        */
        
        StringBuffer sb = new StringBuffer("select IND_MOST_VENC_CUPO from fac_param_factu d where d.PAIS_OID_PAIS = ");
        sb.append(dtoEntrada.getOidPais());
        
        RecordSet rs = new RecordSet();
        
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        // Modificado por la 12124
        if(!rs.esVacio()){
            if(((BigDecimal)rs.getValueAt(0,"IND_MOST_VENC_CUPO")).floatValue()==0){
                dtoEntrada.setMostrarFechaVencimiento(false);
            }else{
                dtoEntrada.setMostrarFechaVencimiento(true);
            }
        }
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoNoLegalCabeceraCCC(DTOFACDocumentoContableCabecera dtoEntrada): Salida");
    }
  
  //incidencia 11135
  //se modifica la cabecera de entrada. Se quita el DTOFACDocumentoContableDetalle por el DTOMovimientoDetalla
  private void rellenarDTOFACDocuntoNoLegalDetalle(RecordSet entrada, DTOMovimientoDetalle dtoEntrada, int indice){
 
      UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocuntoNoLegalDetalle(RecordSet entrada, DTOMovimientoDetalle dtoEntrada, int indice): Entrada");
  
      //  Modificado por HRCS - Fecha 10/07/2007 - Cambio Sicc20070318
      if (entrada.getValueAt(indice,"FEC_PAGO_BANC")!=null) {
        dtoEntrada.setFechaMovimiento((Date)entrada.getValueAt(indice,"FEC_PAGO_BANC"));      
      }
      else if (entrada.getValueAt(indice,"FEC_PAGO_BANC")==null && entrada.getValueAt(indice,"FEC_MOVI")!=null)    {
        dtoEntrada.setFechaMovimiento((Date)entrada.getValueAt(indice,"FEC_MOVI"));    
      }
      else if (entrada.getValueAt(indice,"FEC_PAGO_BANC")==null && entrada.getValueAt(indice,"FEC_MOVI")==null && entrada.getValueAt(indice,"FEC_VALO")!=null)    {
        dtoEntrada.setFechaMovimiento((Date)entrada.getValueAt(indice,"FEC_VALO"));
      }
      else {
        dtoEntrada.setFechaMovimiento((Date)entrada.getValueAt(indice,"FEC_DOCU"));
      }
      
      if(entrada.getValueAt(indice,"IMP_PAGA")!=null){
          dtoEntrada.setImporteMovimiento(new Double((entrada.getValueAt(indice,"IMP_PAGA").toString())));
      }
      if(entrada.getValueAt(indice,"COD_PROC")!=null){
        dtoEntrada.setCodProceso(entrada.getValueAt(indice,"COD_PROC").toString());
      }
      if(entrada.getValueAt(indice,"NUM_IDEN_CUOT")!=null){
        dtoEntrada.setNumIdentCuota(entrada.getValueAt(indice,"NUM_IDEN_CUOT").toString());
      }
      if(entrada.getValueAt(indice,"VAL_INDI_CONS")!=null){
        dtoEntrada.setValIndConsulta(entrada.getValueAt(indice,"VAL_INDI_CONS").toString());
      }
      
      if(entrada.getValueAt(indice,"VAL_EJER_CUOT")!=null){
        dtoEntrada.setEjercicioIdentificadorCuota(entrada.getValueAt(indice,"VAL_EJER_CUOT").toString());
      }
      
      if(entrada.getValueAt(indice,"FECHAVENC")!=null){
          dtoEntrada.setFechaVencimiento((Date)entrada.getValueAt(indice,"FECHAVENC"));
      }
      
      if(entrada.getValueAt(indice,"ULTICUPO")!=null){
          dtoEntrada.setFechaUltimaGeneracion((Date)entrada.getValueAt(indice,"ULTICUPO"));
      }
      
      if(entrada.getValueAt(indice,"DES_TIPO_CARGO_ABONO")!=null){
          dtoEntrada.setDescripcionTipoCargoAbono(entrada.getValueAt(indice,"DES_TIPO_CARGO_ABONO").toString());
      }
      //    Agregado por HRCS - Fecha 21/06/2007 - Cambio Sicc20070296
      if(entrada.getValueAt(indice,"CONSOLIDADO")!=null){
          dtoEntrada.setConsolidado( new Long( ((BigDecimal)entrada.getValueAt(indice,"CONSOLIDADO")).longValue() ) );
      }
     UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocuntoNoLegalDetalle(RecordSet entrada, DTOMovimientoDetalle dtoEntrada, int indice): Salida");
 
  }

    public void rellenarDTOFACDocumentoContableCabecera(RecordSet entrada,DTOFACDocumentoContableCabecera dtoEntrada,DTOFACConsolidado datosConsolidado){
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoContableCabecera(RecordSet entrada,DTOFACDocumentoContableCabecera dtoEntrada,DTOFACConsolidado datosConsolidado): Entrada");
    
        DTOFACCabeceraSolicitud miCabecera = datosConsolidado.getDtoCabecera();
    
        dtoEntrada.setRutinaDiseñoFormulario(entrada.getValueAt(0,"VAL_RUTI_DISE_FORM").toString());
        dtoEntrada.setNombrePeriodo(entrada.getValueAt(0,"VAL_NOMB_PERI").toString());
        dtoEntrada.setNumeroPrograma(entrada.getValueAt(0,"VAL_RUTI_DISE_FORM").toString());
        dtoEntrada.setValPeriodo(entrada.getValueAt(0,"VAL_NOMB_PERI").toString());
        dtoEntrada.setApellido1(entrada.getValueAt(0,"A_VAL_APE1")!=null?entrada.getValueAt(0,"A_VAL_APE1").toString():"");
        dtoEntrada.setApellido2(entrada.getValueAt(0,"A_VAL_APE2")!=null?entrada.getValueAt(0,"A_VAL_APE2").toString():"");
        dtoEntrada.setNombre1(entrada.getValueAt(0,"A_VAL_NOM1")!=null?entrada.getValueAt(0,"A_VAL_NOM1").toString():"");
        dtoEntrada.setNombre2(entrada.getValueAt(0,"A_VAL_NOM2")!=null?entrada.getValueAt(0,"A_VAL_NOM2").toString():"");
        dtoEntrada.setDNI(entrada.getValueAt(0,"A_VAL_NUME_IDEN_NNAL")!=null?entrada.getValueAt(0,"A_VAL_NUME_IDEN_NNAL").toString():"");
        dtoEntrada.setNumIdentificacionFiscal(entrada.getValueAt(0,"A_VAL_NUME_IDEN_FISC")!=null?entrada.getValueAt(0,"A_VAL_NUME_IDEN_FISC").toString():"");
        dtoEntrada.setIdFiscalSociedadVentas(entrada.getValueAt(0,"VAL_IDEN_FISC")!=null?entrada.getValueAt(0,"VAL_IDEN_FISC").toString():"");
        dtoEntrada.setCodPeriodo(entrada.getValueAt(0,"COD_PERI").toString());
        dtoEntrada.setPrecioCatSinImpTotLoc(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_VAL_PREC_CATA_IMPU")));        
        dtoEntrada.setPrecioContSinImpTotLoc(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_VAL_PREC_CONT_IMPU")));
        dtoEntrada.setNumDocContableInterno(UtilidadesBD.convertirAInteger(entrada.getValueAt(0,"A_NUM_DOCU_CONT_INTE")));
        dtoEntrada.setCodTerritorio(entrada.getValueAt(0,"COD_TERR").toString());
        dtoEntrada.setCodZona(entrada.getValueAt(0,"COD_ZONA")!=null?entrada.getValueAt(0,"COD_ZONA").toString():"");
        dtoEntrada.setImporteImpuestosTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_IMPU_TOTA_LOCA")));
        dtoEntrada.setTelefono(entrada.getValueAt(0,"VAL_TEXT_COMU")!=null?entrada.getValueAt(0,"VAL_TEXT_COMU").toString():"");
        dtoEntrada.setPrecioCataTotaLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_VAL_PREC_CATA_TOTA_LOCA")));
        dtoEntrada.setPrecioContTotaLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_VAL_PREC_CONT_TOTA_LOCA")));
        dtoEntrada.setImpDesc1TotLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_DES1_TOTA_LOCA")));
        dtoEntrada.setImporteDescuentoTotaLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_DESC_TOTA_LOCA")));
        dtoEntrada.setImporteFleteTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_FLET_TOTA_LOCA")));
        dtoEntrada.setImporteFleteSinImpuestosTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_FLET_IMPU_TOTA_LOCA")));
        dtoEntrada.setTotalAPagarLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_VAL_TOTA_PAGA_LOCA")));
        dtoEntrada.setNumUnidadesAtendidas(UtilidadesBD.convertirAInteger(entrada.getValueAt(0,"A_NUM_UNID_ATEN_TOTA")));
        dtoEntrada.setMoneda(entrada.getValueAt(0,"VAL_NOMB_CORT_MONE")!=null?entrada.getValueAt(0,"VAL_NOMB_CORT_MONE").toString():"");
        dtoEntrada.setNombreVia(entrada.getValueAt(0,"A_VAL_DIRE_COMP")!=null?entrada.getValueAt(0,"A_VAL_DIRE_COMP").toString():"");
        dtoEntrada.setOidCabecera(UtilidadesBD.convertirALong(entrada.getValueAt(0,"A_OID_CABE")));
        dtoEntrada.setNumDocReferencia(entrada.getValueAt(0,"SOLIREF")!=null?entrada.getValueAt(0,"SOLIREF").toString():"");
        dtoEntrada.setCodPeriodoRefe(entrada.getValueAt(0,"PERIREF")!=null?entrada.getValueAt(0,"PERIREF").toString():"");
        dtoEntrada.setImpDesc1SinImpTotLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_DES1_SIN_IMPU_TOTA")));
        dtoEntrada.setImpDesc3TotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_DES3_TOTAL_LOCA")));
        dtoEntrada.setImpDesc3SinImpTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(0,"A_IMP_DES3_SIN_IMPU_TOTA")));
       
        dtoEntrada.setDescripTipoSolicitud(entrada.getValueAt(0,"DTS")!=null?entrada.getValueAt(0,"DTS").toString():"");
        
        dtoEntrada.setNumeroDocOrigen(miCabecera.getNumeroDocumentoOrigen());
        dtoEntrada.setOidCabeceraSolicitud(miCabecera.getOidCabeceraSolicitud());
        dtoEntrada.setFechaFacturacion(miCabecera.getFechaFacturacion());
        dtoEntrada.setCodCliente(entrada.getValueAt(0,"COD_CLIE")!=null?entrada.getValueAt(0,"COD_CLIE").toString():"");
        dtoEntrada.setNumConsolidado(new Long(miCabecera.getNumeroSolicitud().longValue()));
        dtoEntrada.setOidTipoSolicitud(miCabecera.getTipoSolicitud());
        dtoEntrada.setNumeroSecuenciaFacturacionDiaria(miCabecera.getNumeroSecuenciaFacturacionDiaria());
        dtoEntrada.setNumeroSolicitud(miCabecera.getNumeroSolicitud());
        dtoEntrada.setNumeroDocOrigen(miCabecera.getNumeroDocumentoOrigen());
        // Modificado por SICC20070413 - Rafael Romero - 13/09/2007
        //dtoEntrada.setGlosa(miCabecera.getObservaciones());
        dtoEntrada.setGlosa((String)entrada.getValueAt(0,"A_VAL_OBSE"));
        // Fin modificado SICC20070413
        UtilidadesLog.debug("Numero de solicitud es: "+dtoEntrada.getNumeroSolicitud());
        UtilidadesLog.debug("Numero de consolidado es: "+dtoEntrada.getNumConsolidado());
        dtoEntrada.setTasaImpuestoPercepcion(datosConsolidado.getTasaImpuestoPercepcion());
        dtoEntrada.setIndImprimirPercepcion(datosConsolidado.getIndImprimirPercepcion());
        /* Agregado por Cambio FAC-003 ------ AL */
        dtoEntrada.setOidTipoProgramaConcurso(UtilidadesBD.convertirALong(entrada.getValueAt(0, "ICTP_OID_TIPO_PROG")));        
        dtoEntrada.setCodigoTipoProgramaConcurso(entrada.getValueAt(0, "COD_TIPO_PROG")!=null?entrada.getValueAt(0, "COD_TIPO_PROG").toString():"");
        dtoEntrada.setPeriodoInicioConcurso(entrada.getValueAt(0, "PERI_INI_CONCU")!=null?entrada.getValueAt(0, "PERI_INI_CONCU").toString():"");
        dtoEntrada.setPeriodoFinConcurso(entrada.getValueAt(0, "PERI_FIN_CONCU")!=null?entrada.getValueAt(0, "PERI_FIN_CONCU").toString():"");
        dtoEntrada.setNumeroConcurso(entrada.getValueAt(0, "NUM_CONCU")!=null?entrada.getValueAt(0, "NUM_CONCU").toString():"");
        /* Agregado por Cambio FAC-003 ------ AL */
        /* Agregado por Cambio FAC-005 ------ AL */
        dtoEntrada.setTasaImpuesto(datosConsolidado.getDtoCabecera().getTasaImpuesto());
        dtoEntrada.setTasaImpuestoFlete(datosConsolidado.getDtoCabecera().getTasaImpuestoFlete());
        /* Agregado por Cambio FAC-005 ------ AL */
         /* Agregado por Cambio FAC-001 ------ AL */
        dtoEntrada.setCodigoBarras(UtilidadesBD.convertirAString(entrada.getValueAt(0, "COD_BARRAS")));
        dtoEntrada.setSerieDocumentoLegal(UtilidadesBD.convertirAString(entrada.getValueAt(0, "A_VAL_SERI_DOCU_LEGA")));
        dtoEntrada.setNumeroDocumentoLegal(UtilidadesBD.convertirALong(entrada.getValueAt(0, "A_NUM_DOCU_LEGA")));
        dtoEntrada.setTelefonoFijo(UtilidadesBD.convertirAString(entrada.getValueAt(0, "TELEF_FIJO")));
        dtoEntrada.setTelefonoCelular(UtilidadesBD.convertirAString(entrada.getValueAt(0, "TELEF_CEL")));
        dtoEntrada.setBarrio(UtilidadesBD.convertirAString(entrada.getValueAt(0, "VAL_BARR")));
        dtoEntrada.setPrimerPedido(UtilidadesBD.convertirAString(entrada.getValueAt(0, "PRI_PED")));        
        dtoEntrada.setOidPais(datosConsolidado.getOidPais());
        dtoEntrada.setMunicipio(UtilidadesBD.convertirAString(entrada.getValueAt(0, "MUNICIPIO")));
        dtoEntrada.setDepartamento(UtilidadesBD.convertirAString(entrada.getValueAt(0, "DEPARTAMENTO")));
        dtoEntrada.setSaldoAnterior(UtilidadesBD.convertirAFloat(entrada.getValueAt(0, "SAL_DEUD_ANTE")));
        if (dtoEntrada.getSaldoAnterior() == null) {
           dtoEntrada.setSaldoAnterior(new Float(0)); 
        }
        dtoEntrada.setOidCliente(datosConsolidado.getDtoCabecera().getOidCliente());
        dtoEntrada.setNumeroDecimales(UtilidadesBD.convertirAInteger(entrada.getValueAt(0, "NUM_DECI")));
        dtoEntrada.setCodRegion(UtilidadesBD.convertirAString(entrada.getValueAt(0, "COD_REGI")));        
        dtoEntrada.setCodSeccion(UtilidadesBD.convertirAString(entrada.getValueAt(0, "COD_SECC")));        
        dtoEntrada.setOidPeriodo(UtilidadesBD.convertirALong(entrada.getValueAt(0, "A_PERD_OID_PERI")));        
        dtoEntrada.setOidZona(UtilidadesBD.convertirALong(entrada.getValueAt(0, "A_ZZON_OID_ZONA")));        

        /* Agregado por Cambio FAC-001 ------ AL */
        /* Agregado por Cambio FAC-003-COL ------ AL */
        dtoEntrada.setDiasCruce(UtilidadesBD.convertirALong(entrada.getValueAt(0, "DIAS_CRUCE")));            
        /* Agregado por Cambio FAC-003-COL ------ AL */  
        dtoEntrada.setImporteRedondeoLocal(datosConsolidado.getDtoCabecera().getImporteRedondeoLocal());
        dtoEntrada.setIvaAsumidoEmpresa(UtilidadesBD.convertirAFloat(entrada.getValueAt(0, "VAL_IMPO_IVA_ASUM_EMPR")));
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoContableCabecera(RecordSet entrada,DTOFACDocumentoContableCabecera dtoEntrada,DTOFACConsolidado datosConsolidado): Salida");
    }


    // Modificado por la BELC300011728. Pasa de private a public
    /**
     * CHANGELOG
     * ---------
     * dmorello, 09/06/2009 - Cambio 20090922 - Se setea al DTO el campo importeImpuestoProductoNacional
     */
    public void rellenarDTOFACDocumentoContableDetalle(RecordSet entrada,DTOFACDocumentoContableDetalle dtoEntrada,int numDetalle){
        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoContableDetalle(RecordSet entrada,DTOFACDocumentoContableDetalle dtoEntrada,int numDetalle): Entrada");
    
        dtoEntrada.setPrecioCatalUnitLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_CATA_UNIT_LOCA")));
        dtoEntrada.setPrecioContUnitLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_CONT_UNIT_LOCA")));
        dtoEntrada.setPrecioSinImpuUnitLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_SIN_IMPU_UNIT")));
        dtoEntrada.setPrecioSinImpuTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_SIN_IMPU_TOTA_LOCA")));
        dtoEntrada.setPrecioFactUnitLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_FACT_UNIT_LOCA")));
        dtoEntrada.setPrecioFactTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_FACT_TOTA_LOCA")));
        dtoEntrada.setPrecioCatalTotLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_CATA_TOTA_LOCA"))); 
        dtoEntrada.setPrecioContTotLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_CONT_TOTA_LOCA")));
        dtoEntrada.setPrecioNetoTotalLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_NETO_TOTA_LOCA")));
        dtoEntrada.setPrecioNetoUnitarioLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle,"B_VAL_PREC_NETO_UNIT_LOCA")));
        dtoEntrada.setUnidadesAtendidas(UtilidadesBD.convertirALong(entrada.getValueAt(numDetalle,"B_NUM_UNID_ATEN")));
        dtoEntrada.setNoImprimible(UtilidadesBD.convertirABoolean(entrada.getValueAt(numDetalle,"B_IND_NO_IMPR")).booleanValue());

        if(entrada.getValueAt(numDetalle,"COD_SAP")!=null){
            dtoEntrada.setCodigoProducto(entrada.getValueAt(numDetalle,"COD_SAP").toString());
        }
        
        if(entrada.getValueAt(numDetalle,"DES_CORT")!=null){
            dtoEntrada.setDescripcionProd(entrada.getValueAt(numDetalle,"DES_CORT").toString());
        }        
        
        if(entrada.getValueAt(numDetalle,"VAL_CODI_VENT")!=null){
            dtoEntrada.setCodigoVenta(entrada.getValueAt(numDetalle,"VAL_CODI_VENT").toString());
        }
      
        //modificado por incidencia 19926
        UtilidadesLog.debug("El indicador dentro caja bolsa es: "+entrada.getValueAt(numDetalle,"B_IND_DENT_FUER_CAJA_BOLS"));
        if(entrada.getValueAt(numDetalle,"B_IND_DENT_FUER_CAJA_BOLS")!=null){
            dtoEntrada.setIndicadorDentroFueraCajaBolsa(entrada.getValueAt(numDetalle,"B_IND_DENT_FUER_CAJA_BOLS").toString());
        }else{
            dtoEntrada.setIndicadorDentroFueraCajaBolsa(entrada.getValueAt(numDetalle,"C").toString());
        }
     
        //Añadido por incidencia BELC300021757 y BEL300021212
        if(entrada.getValueAt(numDetalle,"B_VAL_PREC_CATA_UNIT_LOCA")!=null && entrada.getValueAt(numDetalle,"B_VAL_PREC_CONT_UNIT_LOCA")!=null){
            float precCataUnitLoca = ((BigDecimal)entrada.getValueAt(numDetalle,"B_VAL_PREC_CATA_UNIT_LOCA")).floatValue();
            float precContUnitLoca = ((BigDecimal)entrada.getValueAt(numDetalle,"B_VAL_PREC_CONT_UNIT_LOCA")).floatValue();
            dtoEntrada.setValorVenta(new Float(precCataUnitLoca + precContUnitLoca));
        }
        
        //  Agregado por HRCS - Fecha 06/06/2007 - Cambio Sicc20070274
        if (entrada.getValueAt(numDetalle,"PERIREF")!=null) {
            dtoEntrada.setCodPeriodo( entrada.getValueAt(numDetalle,"PERIREF").toString() );
        } else {  //  El periodo de la Solicitud no llega nulo
            dtoEntrada.setCodPeriodo( entrada.getValueAt(numDetalle,"COD_PERI").toString() );
        }
        
        /* Agregado por Cambio FAC-001 ------ AL */
        dtoEntrada.setCodigoVentaFicticio(UtilidadesBD.convertirALong(entrada.getValueAt(numDetalle, "VAL_CODI_VENT_FICT")));  
        dtoEntrada.setPorcentajeDescuento(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle, "B_VAL_PORC_DESC")));
        dtoEntrada.setImporteDescTotaLocal(UtilidadesBD.convertirAFloat(entrada.getValueAt(numDetalle, "B_IMP_DESC_TOTA_LOCA")));
        dtoEntrada.setUnidadesSolicitadas(UtilidadesBD.convertirALong(entrada.getValueAt(numDetalle, "NUM_UNID_COMPR")));
        dtoEntrada.setOidFormaPago(UtilidadesBD.convertirALong(entrada.getValueAt(numDetalle, "FOPA_OID_FORM_PAGO")));
        /* Agregado por Cambio FAC-001 ------ AL */        
        
        // Cambio 20090922
        dtoEntrada.setImporteImpuestoProductoNacional((BigDecimal)entrada.getValueAt(numDetalle, "IMP_IMPU_TOTA_PROD_NACI"));

        UtilidadesLog.info("MONImpresionSICCBean.rellenarDTOFACDocumentoContableDetalle(RecordSet entrada,DTOFACDocumentoContableDetalle dtoEntrada,int numDetalle): Salida");
    }


 private RecordSet reproducirModeloTabla(RecordSet tablaEntrada)
 {
   UtilidadesLog.info("MONImpresionSICCBean.reproducirModeloTabla(RecordSet tablaEntrada): Entrada");
   RecordSet salida= new RecordSet();
   salida.setColumnModel(tablaEntrada.getColumnModel());
   for(int i=0;i<tablaEntrada.getColumnCount();i++)
   { 
     salida.setColumnIdentifiers(tablaEntrada.getColumnIdentifiers());    
   } 
   
   Vector nombres= salida.getColumnIdentifiers();
   UtilidadesLog.info("MONImpresionSICCBean.reproducirModeloTabla(RecordSet tablaEntrada): Salida");
   return salida;
 }

private RecordSet reproducirModeloTabla2(RecordSet tablaEntrada)
{
  UtilidadesLog.info("MONImpresionSICCBean.reproducirModeloTabla2(RecordSet tablaEntrada): Entrada");
  if(tablaEntrada==null)
  {
    
  }
  
  RecordSet salida= RecordSet.clone(tablaEntrada);
  
  
  while(salida.getRowCount()!=0)
  {
    salida.removeRow(0);
  }
  
  UtilidadesLog.info("MONImpresionSICCBean.reproducirModeloTabla2(RecordSet tablaEntrada): Salida");  
  return salida;
}


  private ArrayList clasificarDocumentosLegales(ArrayList listaEntrada)
  {
    UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosLegales(ArrayList listaEntrada): Entrada");
    DTOFACFormulario dtoAux;
    ArrayList salida=new ArrayList();
    for(int i=0; i<listaEntrada.size();i++)
    {
      dtoAux=(DTOFACFormulario)listaEntrada.get(i);
      if(dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF1Peru")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaPeru1")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaPeru2")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoBvPeru")
      || dtoAux.getRutinaDiseñoFormulario().equals("DocuNotaDebito")
      || dtoAux.getRutinaDiseñoFormulario().equals("GuiaDeRemisionPeru")
      || dtoAux.getRutinaDiseñoFormulario().equals("BoletaVentaPeru")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF1Peru")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF2Peru")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaEcuador1")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaEcuador2")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF1Ecuador")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF2Ecuador")
      /* Agregado por Cambio FAC-001 ------ AL */
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaColombia1")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaColombia2")      
      /* Agregado por Cambio FAC-001 ------ AL */
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaPanama1")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaPanama2")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF1Panama")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF2Panama")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaGuatemala1")
      || dtoAux.getRutinaDiseñoFormulario().equals("FacturaGuatemala2")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF1Guatemala")
      || dtoAux.getRutinaDiseñoFormulario().equals("NotaCreditoF2Guatemala")
      )
      {
        salida.add(dtoAux);
      }
    }
  UtilidadesLog.debug("NUMERO DE DOCUMENTOS LEGALES RECUPERADOS: "+salida.size()); 
  UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosLegales(ArrayList listaEntrada): Salida");
  return salida;
  }

  private ArrayList clasificarDocumentosMensajes(ArrayList listaEntrada)
  {
    UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosMensajes(ArrayList listaEntrada): Entrada");
    DTOFACFormulario dtoAux;
    ArrayList salida=new ArrayList();
    for(int i=0; i<listaEntrada.size();i++)
    {
      dtoAux=(DTOFACFormulario)listaEntrada.get(i);
	  // Modificado por la BELC300011756 
	  if(dtoAux.getRutinaDiseñoFormulario().equals("DocumentoMensajes")) {
        salida.add(dtoAux);
      }
    }

    UtilidadesLog.debug("NUMERO DE DOCUMENTOS DE MENSAJE RECUPERADOS: "+salida.size());
    UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosMensajes(ArrayList listaEntrada): Entrada");
  return salida;
  }
    private boolean esDocumentoNoLegal (String rutina){
        if (rutina.equals("BoletaDeDespacho")||
             rutina.equals("OrdenDeCompraSimplificada")||
             rutina.equals("ListaDePicado")||
             rutina.equals("CuponDePagoPeru")
             /* Agregado por Cambio FAC-001 ------ AL */
             || rutina.equals("DetalleFacturaColombia")
             || rutina.equals("BoletaRecojoColombia")
             || rutina.equals("CuponDePagoColombia")
             || rutina.equals("BoletaEntregaColombia")
             || rutina.equals("OCSimplificadaColombia")
             || rutina.equals("SolicitudPostVenta")
             /* Agregado por Cambio FAC-001 ------ AL */
             ){
            return true;
        }
        return false;
    }
    
    private boolean esDocumentoMensaje (String rutina){
        if ((rutina!=null)&&
            (rutina.equals("DocumentoMensajes"))){
            return true;
        }
        return false;
    }
  
    private ArrayList clasificarDocumentosXML(ArrayList listaEntrada){
        UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosXML(ArrayList listaEntrada): Entrada");
        DTOFACFormulario dtoAux;
        ArrayList salida=new ArrayList();
        for(int i=0; i<listaEntrada.size();i++){
            dtoAux=(DTOFACFormulario)listaEntrada.get(i);
            if(dtoAux.getRutinaDiseñoFormulario().equals("BoletaDeDespacho")
            ||dtoAux.getRutinaDiseñoFormulario().equals("OrdenDeCompraSimplificada")
            ||dtoAux.getRutinaDiseñoFormulario().equals("CuponDePagoPeru")
            ||dtoAux.getRutinaDiseñoFormulario().equals("ListaDePicado")                            
            ||dtoAux.getRutinaDiseñoFormulario().equals("DocumentoMensajes")
            /* Agregado por Cambio FAC-001 ------ AL */
            ||dtoAux.getRutinaDiseñoFormulario().equals("DetalleFacturaColombia")
            ||dtoAux.getRutinaDiseñoFormulario().equals("BoletaRecojoColombia")
            ||dtoAux.getRutinaDiseñoFormulario().equals("CuponDePagoColombia")
            ||dtoAux.getRutinaDiseñoFormulario().equals("BoletaEntregaColombia")
            ||dtoAux.getRutinaDiseñoFormulario().equals("OCSimplificadaColombia")
            ||dtoAux.getRutinaDiseñoFormulario().equals("SolicitudPostVenta")
            /* Agregado por Cambio FAC-001 ------ AL */
            ){
                salida.add(dtoAux);
            }
        }
          
        UtilidadesLog.debug("NUMERO DE DOCUMENTOS XML RECUPERADOS: "+salida.size());  
        UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosXML(ArrayList listaEntrada): Salida");
        return salida;
    }

  private ArrayList clasificarDocumentosNoLegales(ArrayList listaEntrada)
  {
    UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosNoLegales(ArrayList listaEntrada): Entrada");
    DTOFACFormulario dtoAux;
    ArrayList salida=new ArrayList();
    for(int i=0; i<listaEntrada.size();i++)
    {
      dtoAux=(DTOFACFormulario)listaEntrada.get(i);
      if(dtoAux.getRutinaDiseñoFormulario().equals("BoletaDeDespacho")
      ||dtoAux.getRutinaDiseñoFormulario().equals("OrdenDeCompraSimplificada")
      ||dtoAux.getRutinaDiseñoFormulario().equals("CuponDePagoPeru"))
      {
        salida.add(dtoAux);
      }
    }
    
  UtilidadesLog.debug("NUMERO DE DOCUMENTOS NO LEGALES RECUPERADOS: "+salida.size());  
  UtilidadesLog.info("MONImpresionSICCBean.clasificarDocumentosNoLegales(ArrayList listaEntrada): Salida");
  return salida;
  }

 public DocumentoFAC getInstanciaPorNombre(String s)
        throws ClassNotFoundException, Exception
   {
        UtilidadesLog.info("MONImpresionSICCBean.getInstanciaPorNombre(String s): Entrada");
        try {
            DocumentoFAC obj = null;
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer = stringbuffer.append(s);
            Class class1 = null;
            class1 = Class.forName(stringbuffer.toString());
            Class aclass[] = new Class[0];
            Constructor constructor = class1.getConstructor(aclass);
            Object aobj[] = new Object[0];
            obj = (DocumentoFAC)constructor.newInstance(aobj);
            
            UtilidadesLog.info("MONImpresionSICCBean.getInstanciaPorNombre(String s): Salida");
            
            return obj;
        } catch(NoSuchMethodException _ex) {
            throw new Exception("NoSuchMethodException");
        } catch(IllegalAccessException _ex) {
            throw new Exception("IllegalAccessException");
        } catch(InstantiationException _ex) {
            throw new Exception("InstantiationException");
        } catch(InvocationTargetException _ex) {
            throw new Exception("InvocationTargetException");
        }
        
    }
	 private SpoolManagerLocal getSpoolManager() throws MareException {
        UtilidadesLog.info("MONImpresionSICCBean.getSpoolManager(): Entrada");
        SpoolManagerLocal ejb = null;

        try {
            ejb = this.getSpoolManagerLocalHome().create();
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONImpresionSICCBean.getSpoolManager(): Salida");

        return ejb;
    }

	public DTODocumento getDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal) throws MareException {
		UtilidadesLog.info("MONImpresionSICCBean.getDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal): Entrada");
		DocumentoMensajes documentoMensajes = new DocumentoMensajes();
        try {
            documentoMensajes.componerFactura(dtoMensajesFinal,oidPatron);
        } catch (MareException e) {
            UtilidadesLog.error("ERROR",e);
            if(e.getCode()==UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE)) {
                this.ctx.setRollbackOnly();
                throw e;
            }
        }

		byte array[] = documentoMensajes.getDocument();
		
		DTODocumento dto = new DTODocumento();
		dto.setDocumentoByte(array);
    // Modificado por la BELC300012643
		dto.setDocumento(new String(array));

		//3.- Devolvemos el DTODocumento.
		UtilidadesLog.info("MONImpresionSICCBean.getDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal): Salida");
		return dto;
	}

	// Parámetros de entrada modificados por la BELC300011627. Añadidos:
	// dtoLoteImpresion :DTOLoteImpresion, oidImpresoraVirtual: Long
	public void imprimirDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal, Long oidImpresoraVirtual, Integer secuencia, Long oidSubacceso) throws MareException{
		UtilidadesLog.info("MONImpresionSICCBean.imprimirDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal, Long oidImpresoraVirtual, Long oidSubacceso): Entrada");
		DTODocumento dtoDoc = this.getDocumentoMensajes(oidPatron, dtoMensajesFinal);
    dtoDoc.setTipoDocumento(oidImpresoraVirtual);
    dtoDoc.setNumSecuencia(secuencia);
		SpoolManagerLocal spool = this.getSpoolManager();
		try{
			Long idSpool = spool.openSpool(oidSubacceso);
			spool.addPrintableDocuments(dtoDoc,idSpool);
			spool.closeSpool(idSpool);
		}catch(Exception re){
			UtilidadesLog.error("ERROR",re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
		}

		
		UtilidadesLog.info("MONImpresionSICCBean.imprimirDocumentoMensajes(Long oidPatron, ArrayList dtoMensajesFinal, Long oidImpresoraVirtual, Long oidSubacceso): Salida");
	}

	
	private MONImpresionMensajes getMONImpresionMensajes() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONImpresionSICCBean.getMONImpresionMensajes(): Entrada");
        MONImpresionMensajesHome home = (MONImpresionMensajesHome)UtilidadesEJB.getHome(
        "MONImpresionMensajes", MONImpresionMensajesHome.class);
        // Se obtiene el interfaz remoto
        MONImpresionMensajes ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("ERROR",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONImpresionSICCBean.getMONImpresionMensajes(): Salida");
        return ejb;
	}

	public DTODocumento visualizarDocumentoFacturacion(DTOOID oidDocumentoContable, Long subacceso) throws MareException {
		UtilidadesLog.info("MONImpresionSICCBean.visualizarDocumentoFacturacion(DTOOID oidDocumentoContable, Long subacceso): Entrada");
		DAODocuContable dao = new DAODocuContable();
        Long idiomaPorDefecto = oidDocumentoContable.getOidIdioma();
        if (idiomaPorDefecto == null){
            idiomaPorDefecto= RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
        }
            DTODocLegal dto = dao.obtenerDatosVisualizacion(oidDocumentoContable.getOid(), subacceso, idiomaPorDefecto);
            
        // Añadido por la BELC300018205
        ArrayList array = dto.getlistaPaginas();
        DTOFACDocumentoContable dtoDocumentoContable = (DTOFACDocumentoContable)array.get(0);
        DTOFACDocumentoContableCabecera dtoDocumentoCabecera = dtoDocumentoContable.getCabecera();
        dtoDocumentoCabecera.setDescripcionUbigeo(dao.obtenerDescripcionUBIGEO(dtoDocumentoCabecera.getOidUbigeo()));
        dtoDocumentoContable.setCabecera(dtoDocumentoCabecera);
        dtoDocumentoCabecera.setIndicadorReimpresion(Boolean.TRUE);
        array.set(0, dtoDocumentoContable);
        dto.setListaPaginas(array);
        
        DatosClienteHelper datosClienteHelper = new DatosClienteHelper();
        ArrayList listaPaginas=dto.getlistaPaginas();
        dto.setUsuario(ctx.getCallerPrincipal().getName());
        DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);              
        DTOClienteSolicitud dtoClienteSolicitud = datosClienteHelper.obtenerDatosCliente(docuContable.getCabecera().getOidCabeceraSolicitud(), dto.getUsuario());
    
    		DTODocumento documento = this.componerDoc(dto, dtoClienteSolicitud);
		
		UtilidadesLog.info("MONImpresionSICCBean.visualizarDocumentoFacturacion(DTOOID oidDocumentoContable, Long subacceso): Salida");
		return documento;
	}


    // Modificado por la BELC300015675
    public DTODocumento componerDoc(DTODocLegal datosDoc, DTOClienteSolicitud dtoClie) throws MareException {
        UtilidadesLog.info("MONImpresionSICCBean.componerDoc(DTODocLegal datosDoc): Entrada");
        ArrayList lista = datosDoc.getlistaPaginas();
        DTOFACDocumentoContable dtoFACDC = null;
        DTODocumento documento = new DTODocumento();
        if (lista.size() !=0) {
            dtoFACDC = (DTOFACDocumentoContable)lista.get(0); //el atributo cabecera es el mismo para todos los elem. de la lista
            DocumentoFAC documentoFAC;
            
            try{
                documentoFAC = this.getInstanciaPorNombre("es.indra.sicc.logicanegocio.fac.generaciondocumentos."+dtoFACDC.getCabecera().getRutinaDiseñoFormulario());
            }catch(Exception e){
                UtilidadesLog.error("ERROR",e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));	
            }
            documentoFAC.setDtoClienteSolicitud(dtoClie);
            documentoFAC.componerFactura(datosDoc);
            byte[] array = documentoFAC.getDocument();
            DTOFACDocumentoContable dtoDocumentoContable = (DTOFACDocumentoContable)datosDoc.getlistaPaginas().get(0);
            documento.setNumSecuencia(new Integer(1));
            documento.setTipoDocumento(dtoDocumentoContable.getCabecera().getTipoDocumento());
            documento.setDocumentoByte(array);
            documento.setDocumento(new String(array));
        }	
        UtilidadesLog.info("MONImpresionSICCBean.componerDoc(DTODocLegal datosDoc): Salida");
        //4.- Devolvemos el DTODocumento. 
        return documento;
    }

    // Añadido por hsanchez. BELC300011728
    // Modificado por la 12092
    public DTODocLegal componerDatosCCC(DTOFACConsolidado datosConsolidado, DTODocLegal miDTODocNoLegal) throws MareException {
        UtilidadesLog.info("MONImpresionSICCBean.componerDatosCCC(DTOFACConsolidado datosConsolidado, DTODocLegal miDTODocNoLegal): Entrada");
        DAODocuContable daoActivo = new DAODocuContable(); 
        try{
            //modificado por incidencia 11135
            this.rellenarDTOFACDocumentoNoLegalCabeceraCCC(((DTOFACDocumentoContable)((ArrayList)miDTODocNoLegal.getlistaPaginas()).get(0)).getCabecera());
            RecordSet datosCCC = daoActivo.obtenerDatosCCC(datosConsolidado.getDtoCabecera(), ((DTOFACDocumentoContable)miDTODocNoLegal.getlistaPaginas().get(0)).getCabecera().getMostrarFechaVencimiento());
            int numDetalles = datosCCC.getRowCount();
            DTOMovimientoDetalle dto=null;
            ArrayList array=null;
            for (int i=0; i<numDetalles;i++){   
                dto = new DTOMovimientoDetalle();
                this.rellenarDTOFACDocuntoNoLegalDetalle(datosCCC,dto,i);
                //jrivas 24/10/2008 inc. 11135
                //miDTODocNoLegal.getlistaPaginas().add(0,dto);
                ((DTOFACDocumentoContable)((ArrayList)miDTODocNoLegal.getlistaPaginas()).get(0)).addMovimientos(dto);                    
            }
        } catch(Exception e) {
            UtilidadesLog.error("Error",e);
        }

        UtilidadesLog.info("MONImpresionSICCBean.componerDatosCCC(DTOFACConsolidado datosConsolidado, DTODocLegal miDTODocNoLegal): Salida");
        // Modificado por la 12092
        return miDTODocNoLegal;
    }

    // Método creado por la 12960, y modificado por la 12960
    public ArrayList obtenerPatronDocumento(Long oidForm, Long oidPeriodo) throws MareException{
        UtilidadesLog.info("MONImpresionSICCBean.obtenerPatronDocumento(Long oidForm, Long oidPeriodo): Entrada");
        ArrayList salida = new ArrayList();
        PatronCabeceraLocalHome patronCabeceraLocalHome = this.getPatronCabeceraLocalHome();
        PatronPorPeriodoLocalHome patronPorPeriodoLocalHome = this.getPatronPorPeriodoLocalHome();

        PatronCabeceraLocal patronCabeceraLocal = null;
        PatronPorPeriodoLocal patronPorPeriodoLocal = null;
        Long patronResultado = null;
        
        Vector patronesCabecera = null;
        Vector patronesPeriodo = null;
        try {
            patronesCabecera = new Vector(patronCabeceraLocalHome.findByFormulario(oidForm));            
        } catch (NoResultException e) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        // No he recuperado registros
        if(patronesCabecera.size()==0){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "MONImpresionSICC.obtenerPatronDocumento No hay datos en patronCabeceraLocalHome.findByFormulario("+oidForm+")";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }

        // Variable temporal que almacena el valor booleano del IND_ACTIVO
        boolean temporal;
        if(ConstantesMSG.IND_ACTIVO.intValue()==0) {
            temporal = false;
        } else {
            temporal = true;
        }
        
        for(int i = 0; i<patronesCabecera.size(); i++){
            patronCabeceraLocal = (PatronCabeceraLocal) patronesCabecera.get(i);
            Long oidPatron = patronCabeceraLocal.getOid();
            if (patronCabeceraLocal.getIndPatronPeriodo().booleanValue()){
                try {
                    // Solo puede haber 1 o ningun elemento en el finder
                    Long periodoCopo = getPeriodoLocalHome().findByPrimaryKey(oidPeriodo).getOidPeriodoCorporativo();
                    patronesPeriodo = new Vector(patronPorPeriodoLocalHome.findByPatronPeriodo(oidPatron, periodoCopo));
                } catch (NoResultException e) {
                    // Esto no debería de suceder
                    String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(e, UtilidadesError.armarCodigoError(error));
                } 
                // Si recupero un registro
                if(patronesPeriodo.size()==1) {
                    patronPorPeriodoLocal = (PatronPorPeriodoLocal) patronesPeriodo.get(0);
                    //modificado por Sapaza - fecha 27/08/2007 - cambio Sicc20070398
                    patronResultado = patronPorPeriodoLocal.getOidPatron();
                    //patronResultado = patronPorPeriodoLocal.getOidPatronOrigen();
                    salida.add(patronResultado);
                }
            }else{
                salida.add(oidPatron);
            }
        }
        
        UtilidadesLog.info("MONImpresionSICCBean.obtenerPatronDocumento(Long oidForm, Long oidPeriodo): Salida");
        return salida;
    }

    private PatronCabeceraLocalHome getPatronCabeceraLocalHome() throws MareException {
        return new PatronCabeceraLocalHome();
    }

    private PatronPorPeriodoLocalHome getPatronPorPeriodoLocalHome() throws MareException {
        return new PatronPorPeriodoLocalHome();
    }

    private byte[] concatenaByte(byte[] origen, byte[] concatenar) {
        UtilidadesLog.info("MONImpresionSICCBean.concatenaByte(byte[] origen, byte[] concatenar): Entrada");
        byte[] resultado = new byte[origen.length+concatenar.length];
        int i;
        for(i = 0; i<origen.length; i++) {
            resultado[i] = origen[i];
        }
        for(i = 0; i<concatenar.length; i++) {
            resultado[origen.length+i] = concatenar[i];
        }
        UtilidadesLog.info("MONImpresionSICCBean.concatenaByte(byte[] origen, byte[] concatenar): Salida");
        return resultado;
    }

    public DTODocumento visualizarDocumentoFacturacion(DTOOID dtoOid) throws MareException {
		UtilidadesLog.info("MONImpresionSICCBean.visualizarDocumentoFacturacion(DTOOID dtoOid): Entrada");
        DTODocumento dtoDocumento = this.visualizarDocumentoFacturacion(dtoOid, null);
        
		UtilidadesLog.info("MONImpresionSICCBean.visualizarDocumentoFacturacion(DTOOID dtoOid): Salida");
        return dtoDocumento;
    }

    public void enviarFantasmas(ArrayList listaFantasma, Long idSpool, Integer numSecuenciaImpresion, ArrayList listaDocumentos) throws MareException
    {
        UtilidadesLog.info("MONImpresionSICCBean.enviarFantasmas(ArrayList listaFantasma, Long idSpool, Integer numSecuenciaImpresion, ArrayList listaDocumentos): Entrada");
        DTOFACFormulario fantasma=null;
        DTOFACFormulario documentos=null;
        ArrayList arrImprimir = new ArrayList(); //contendra objetos del tipo DTODocumento
        boolean esta; //flag
        for (int i=0; i< listaFantasma.size();i++) {
            esta=false;
            fantasma=(DTOFACFormulario)listaFantasma.get(i);
            for (int j=0; j< listaDocumentos.size();j++) {
                documentos=(DTOFACFormulario)listaDocumentos.get(j);
                if (documentos.getRutinaDiseñoFormulario().equals(fantasma.getRutinaDiseñoFormulario())){
                    esta=true;
                    break;
                }
            }
            if (!esta) {
                //guardamos en el array List fantasma
                UtilidadesLog.debug("Agregamos para imprimir: "+fantasma);
                arrImprimir.add(fantasma);
            }
        }
        //mandamos a imprimir
        DTODocumento dto=null;
        SpoolManagerLocal spool = this.getSpoolManager();
        UtilidadesLog.debug("El tamano del array a imprimir es: "+arrImprimir.size());
        for (int i=0; i<arrImprimir.size();i++){
            dto = new DTODocumento();
            dto.setNumSecuencia(numSecuenciaImpresion);
            dto.setTipoDocumento(((DTOFACFormulario)arrImprimir.get(i)).getOidImpresoraVirtual());
            try {
                UtilidadesLog.debug("Mandamos a Imprimir el DTODocumento: " + dto);
                UtilidadesLog.debug("Con el idSpool: "+idSpool);
                spool.addPrintableDocuments(dto,idSpool);
            } catch(Exception re) {
                UtilidadesLog.error("ERROR",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }
        UtilidadesLog.info("MONImpresionSICCBean.enviarFantasmas(ArrayList listaFantasma, Long idSpool, Integer numSecuenciaImpresion, ArrayList listaDocumentos): Salida");
    }
    
    private BelcorpService getBelcorpService() {
        UtilidadesLog.info("DAODocuContable.getBelcorpService(): Entrada");    
        try {
            UtilidadesLog.info("DAODocuContable.getBelcorpService(): Salida"); 
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " +
                mmsnfe.getMessage(), mmsnfe);
        }
    }

    private PeriodoLocalHome getPeriodoLocalHome() throws MareException{
        return new PeriodoLocalHome();
    }

    private void actualizarSecuenciaDocumentoImpresion(Long documentoImpresion, Long oidConsolidado, Long tipoDocumento, Long spool, Long oidTipoPrograma) throws MareException {
        UtilidadesLog.info("actualizarSecuenciaDocumentoImpresion: Entrada ");

        try {
            StringBuffer query = new StringBuffer();

            query.append(" UPDATE FAC_SECUE_DOCUM_INTER ");
            query.append(" SET GDIM_OID_DOCU_IMPR = " + documentoImpresion );
            query.append(" WHERE SOCA_OID_SOLI_CABE = " + oidConsolidado );
            query.append(" AND TIDO_OID_TIPO_DOCU = " + tipoDocumento );
            query.append(" AND GSPO_OID_SPOO = " + spool );
            if (oidTipoPrograma != null) {
              query.append(" AND ICTP_OID_TIPO_PROG = " + oidTipoPrograma);
            } else {
              query.append(" AND ICTP_OID_TIPO_PROG IS NULL ");
            }

            BelcorpService bs = BelcorpService.getInstance();            
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("actualizarSecuenciaDocumentoImpresion: Salida ");
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
        }
    }    

    private SpoolManagerLocalHome getSpoolManagerLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (SpoolManagerLocalHome)context.lookup("java:comp/env/ejb/local/SpoolManager");
    }
    
    
    
    private void insertarUpdatesDocumentosGenerados (StringBuffer query) throws Exception {
        UtilidadesLog.info("MONImpresionSICCBean.insertarUpdatesDocumentosGenerados (StringBuffer query): Entrada");       
        BelcorpService bs = UtilidadesEJB.getBelcorpService();         
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        UtilidadesLog.info("MONImpresionSICCBean.insertarUpdatesDocumentosGenerados (StringBuffer query): Salida");
    }

    private StringBuffer generarUpdatesDocumentoGenerado (Long oidDocumentoGenerado, Long oidCabeceraSolicitud, boolean generaNumeroLegal) {
        UtilidadesLog.info("MONImpresionSICCBean.generarInsercionDocumentoGenerado(Long oidDocumentoGenerado, Long oidCabeceraSolicitud, boolean generaNumeroLegal): Entrada");
        StringBuffer query = new StringBuffer();
        
        query.append("UPDATE GEN_DOCUM_IMPRI ");
        query.append("SET SOCA_OID_SOLI_CABE = ").append(oidCabeceraSolicitud); 
        if (generaNumeroLegal) {
            query.append("    , IND_GENE_NUME_LEGA = 1"); 
        } else {
            query.append("    , IND_GENE_NUME_LEGA = 0"); 
        }
        query.append("WHERE OID_DOCU_IMPR = ").append(oidDocumentoGenerado).append(";"); 
        
        UtilidadesLog.info("MONImpresionSICCBean.generarInsercionDocumentoGenerado(Long oidDocumentoGenerado, Long oidCabeceraSolicitud, boolean generaNumeroLegal): Salida");
        return query;
    }

    public void generarDocFacturaColombia(DTOFACConsolidado datosConsolidado) throws MareException {
      UtilidadesLog.info("MONImpresionSICCBean.generarDocFacturaColombia(DTOFACConsolidado datosConsolidado): Entrada");
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
        UtilidadesLog.debug("*** MONImpresionSICC.generarDocFacturaColombia: consolidado="+datosConsolidado);
        
      try{       
        if (datosConsolidado.getDtoCabecera().getUnidadesAtendidasTotal()!=null && datosConsolidado.getDtoCabecera().getUnidadesAtendidasTotal().intValue()!=0) {
          if (datosConsolidado.getIndOnline() != null && datosConsolidado.getIndOnline().booleanValue()) {
            SpoolManagerLocal spoolManager = this.getSpoolManager();	
            Long IDSpool = null;
            try {
              IDSpool = spoolManager.openSpool(datosConsolidado.getSubaccesoUsuario());
              datosConsolidado.setIDSpool(IDSpool);
            } catch (Exception re) {
              UtilidadesLog.error("*** Error en continuarFacturacion en la llamada a openSpool",re);
              String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
            }
          }
                
          String descripUbigeo = null;
          DAOFormulario miDaoFormulario = new DAOFormulario();
          DAOFACDocumentoContable dao = new DAOFACDocumentoContable(ctx.getCallerPrincipal().getName());
          StringBuffer stringInsercionDocumentosGenerados = new StringBuffer();
          
          Iterator it = (Iterator)datosConsolidado.getListaSolicitudes().iterator();
          ArrayList listaTiposProgramas = new ArrayList();
          while (it.hasNext()) {
            DTOFACCabeceraSolicitud dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)it.next(); 
            if (!listaTiposProgramas.contains(dtoCabeceraSolicitud.getOidTipoConcursoPrograma())) {
              listaTiposProgramas.add(dtoCabeceraSolicitud.getOidTipoConcursoPrograma());  
            }            
          }
                    
          ArrayList listFormularios = miDaoFormulario.obtenerFormulario(datosConsolidado.getDtoCabecera().getTipoSolicitud(), datosConsolidado.getSubaccesoUsuario());
          DAOPrinterSystem miDaoPrinterSystem = new DAOPrinterSystem();
          ArrayList listDocumentoLegales= clasificarDocumentosLegales(listFormularios);
          ArrayList listDocumentosXML = clasificarDocumentosXML(listFormularios);
          DAODocuContable daoActivo = new DAODocuContable();
          RecordSet datosRecuperados = daoActivo.obtenerDatosDocumentos(datosConsolidado.getDtoCabecera());
          RecordSet datosRecuperadosNoLegales = daoActivo.obtenerDatosDocumentosNoLegales(datosConsolidado.getDtoCabecera());
                
          UtilidadesLog.debug("Datos legales recuperados:"+datosRecuperados.getRowCount());  
          ArrayList oidsCabecera = new ArrayList();//para modificar en fac_docum_conta_cabec
          for (int i=0; i<listDocumentoLegales.size();i++) {
            DTOFACFormulario miFormulario = (DTOFACFormulario)listDocumentoLegales.get(i);
            RecordSet detallesFormulario= this.reproducirModeloTabla(datosRecuperados);
                  
            long tipoDocu = miFormulario.getOidFormulario().longValue();
            int indImpresion;
            
            int sizeArrayTipoProgramas = listaTiposProgramas.size();
            
            for (int itProg = 0; itProg < sizeArrayTipoProgramas; itProg++) {
                Long oidTipoProgramaInc = (Long)listaTiposProgramas.get(itProg);

                UtilidadesLog.debug("Tipo Docu y Programa ------> " + tipoDocu + "     " + oidTipoProgramaInc); 
                int longRSDatosRecuperados = datosRecuperados.getRowCount();      
                for (int numLinea=0;numLinea < longRSDatosRecuperados;numLinea++) {
                  UtilidadesLog.debug("oidFormulariodatosRecuperados=" + datosRecuperados.getValueAt(numLinea,"A_FORS_OID_FORM") + ", tipoDocuFormulario=" + tipoDocu);
                  if (((BigDecimal)datosRecuperados.getValueAt(numLinea,"A_FORS_OID_FORM")).longValue() == tipoDocu) {
                    if ((oidTipoProgramaInc == null && datosRecuperados.getValueAt(numLinea, "ICTP_OID_TIPO_PROG") == null) || 
                      (oidTipoProgramaInc != null && datosRecuperados.getValueAt(numLinea, "ICTP_OID_TIPO_PROG") != null &&((BigDecimal)datosRecuperados.getValueAt(numLinea, "ICTP_OID_TIPO_PROG")).longValue() == oidTipoProgramaInc.longValue())) {                     
                          detallesFormulario.addRow(datosRecuperados.getRow(numLinea));
                    }
                  }
                }
                
                UtilidadesLog.debug("Para el documento "+i+" tenemos "+detallesFormulario.getRowCount());    
                int docLegalesAniadidos = 0;
                if (detallesFormulario.getRowCount()!=0) {
                  DTODocLegal miDTODocLegal= new DTODocLegal();
                  ArrayList paginasFormulario= obeterEstructuraPaginas(detallesFormulario);
                          
                  RecordSet rs = (RecordSet)paginasFormulario.get(0);
                  String rutina = rs.getValueAt(0, "VAL_RUTI_DISE_FORM").toString();
                  Long pais = new Long(rs.getValueAt(0, "A_PAIS_OID_PAIS").toString());
                  if (! daoActivo.verificarImpresionPercepcion(miFormulario.getOidFormulario(), pais).booleanValue()) {                      
                    datosConsolidado.setIndImprimirPercepcion(Boolean.FALSE);
                  } else {
                    datosConsolidado.setIndImprimirPercepcion(Boolean.TRUE);
                  }                
                  UtilidadesLog.debug("La tasa de percepcion queda asi: " + datosConsolidado.getTasaImpuestoPercepcion());
                  UtilidadesLog.debug("El Indicador de Imprimir Percepcion queda asi: " + datosConsolidado.getIndImprimirPercepcion());
                          
                  for (int numPagina=0; numPagina<paginasFormulario.size(); numPagina++) {
                    RecordSet miPagina= (RecordSet)paginasFormulario.get(numPagina);
                      
                    DTOFACDocumentoContable miDocumentoContable=new DTOFACDocumentoContable();
                    miDTODocLegal.añadirPagina(miDocumentoContable);
                    docLegalesAniadidos = docLegalesAniadidos + 1;
                    for (int numDetalle=0; numDetalle<miPagina.getRowCount(); numDetalle++) {
                      if (numDetalle==0) {
                        DTOFACDocumentoContableCabecera miCabe=new DTOFACDocumentoContableCabecera();
                        if (descripUbigeo==null) {
                          if (datosRecuperados != null && !datosRecuperados.esVacio()) {
                            descripUbigeo = daoActivo.obtenerDescripcionUBIGEO(new Long(((BigDecimal)datosRecuperados.getValueAt(0, "OID_VALO_ESTR_GEOP")).longValue()));
                            UtilidadesLog.debug("La descripcion ubigeo es: "+descripUbigeo);
                          } else {
                            descripUbigeo = "";
                          }
                        }
                        miCabe.setDescripcionUbigeo(descripUbigeo);
                        rellenarDTOFACDocumentoContableCabecera((RecordSet)paginasFormulario.get(numPagina),miCabe,datosConsolidado);
                        UtilidadesLog.debug("flete sin impuestos: " + miCabe.getImporteFleteSinImpuestosTotalLocal());
                        UtilidadesLog.debug("flete total: " + miCabe.getImporteFleteTotalLocal());
                        miDocumentoContable.setCabecera(miCabe);
                        oidsCabecera.add(miDocumentoContable.getCabecera().getOidCabecera());
                        UtilidadesLog.debug("El oid cabecera es: "+miDocumentoContable.getCabecera().getOidCabecera());
                        UtilidadesLog.debug("El oid cabecera es1: "+miDocumentoContable.getCabecera().getOidCabeceraSolicitud());
                      }
                      DTOFACDocumentoContableDetalle miDet= new  DTOFACDocumentoContableDetalle();
                      rellenarDTOFACDocumentoContableDetalle((RecordSet)paginasFormulario.get(numPagina),miDet,numDetalle);
                      miDocumentoContable.addDetelle(miDet);  
                    }
                  }
                  
                          //llamo a la clase
                  UtilidadesLog.debug("es.indra.sicc.logicanegocio.fac.generaciondocumentos."+miFormulario.getRutinaDiseñoFormulario());
                  DocumentoFAC docu=getInstanciaPorNombre("es.indra.sicc.logicanegocio.fac.generaciondocumentos."+miFormulario.getRutinaDiseñoFormulario());
                  miDTODocLegal.setIndOnline(datosConsolidado.getIndOnline());
                  
                  if (miFormulario.getRutinaDiseñoFormulario().equals("FacturaColombia1") || miFormulario.getRutinaDiseñoFormulario().equals("FacturaColombia2")) {
                      ArrayList listaPaginasDetalleFactura = miDTODocLegal.getlistaPaginas();
                      DTOFACDocumentoContable docuContableDetalleFactura = (DTOFACDocumentoContable)listaPaginasDetalleFactura.get(0);
                      this.misDetallesFactura = new ArrayList((ArrayList)docuContableDetalleFactura.getDetalle());
                  }
                  docu.componerFactura(miDTODocLegal);
                  DTODocumento dtoDocu= new DTODocumento();
                  dtoDocu.setDocumentoByte(docu.getDocument());
                  dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
                  dtoDocu.setTipoDocumento(miFormulario.getOidImpresoraVirtual());  
                  SpoolManagerLocal spoolManager = this.getSpoolManager();
                           
                  Long clave = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
                    
                  stringInsercionDocumentosGenerados.append(this.generarUpdatesDocumentoGenerado(clave, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), false).toString());                                                 
                  if (datosConsolidado.getIndOnline() != null && !datosConsolidado.getIndOnline().booleanValue()) {
                    this.actualizarSecuenciaDocumentoImpresion(clave, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), miFormulario.getOidTipoDocumentoLegal(), datosConsolidado.getIDSpool(), oidTipoProgramaInc);
                  }
                  dao.marcarDocumentoComoImpreso(oidsCabecera);
                  oidsCabecera.clear();
                  int sizeRS = detallesFormulario.getRowCount();
                  for (int x=0 ; x<sizeRS; x++ ) {
                    detallesFormulario.removeRow(0);
                  }                  
                }
            }    
          }
          
          DTODocLegal miDTODocNoLegal;
          RecordSet resultado;
          DTOFACDocumentoContable miDocumentoContable;
          DTOFACDocumentoContableCabecera miDocumentoContableCabecera;
                    
          byte[] documentoUnico = null;
          byte[] documentoAgrupado = new byte[0];
          DTOClienteSolicitud dtoClienteSolicitud = null;
            
          MONImpresionMensajes monImpresionMensajes = this.getMONImpresionMensajes();
          DTOImpresion dtoMensajesFinal[] = null;
          
          boolean imprimirMensajes = false;
          DTOFACFormulario formul = null;
          for (int i=0;i<listDocumentosXML.size();i++) {
            formul = (DTOFACFormulario)listDocumentosXML.get(i);  
            if (esDocumentoMensaje(formul.getRutinaDiseñoFormulario()))
                imprimirMensajes = true;
          }
          if(imprimirMensajes) {
              try {
                dtoMensajesFinal = monImpresionMensajes.imprimirMensajesFacturacion(datosConsolidado);
              } catch (Exception re) {
                UtilidadesLog.error("ERROR",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
              }
          }

          Long oidDocumentoGenerado = null;
          Long oidImpresoraVirtualAnterior = null;
          boolean generoBoletaEntrega = false;
          boolean generoDetalleFactura = false;
          boolean insertoBoletaEntrega = false;
          
          for (int i = 0; i < listDocumentosXML.size(); i++) {
            formul = (DTOFACFormulario)listDocumentosXML.get(i);  
            if (oidImpresoraVirtualAnterior == null) {
                oidImpresoraVirtualAnterior = (Long)formul.getOidImpresoraVirtual();
            }             
            documentoUnico = new byte[0];
            UtilidadesLog.debug("Se va a imprimir: "+ formul.getRutinaDiseñoFormulario());
            if (formul.getRutinaDiseñoFormulario().equals("BoletaEntregaColombia")){
                generoBoletaEntrega = true;
            }
            if (formul.getRutinaDiseñoFormulario().equals("DetalleFacturaColombia")){
                generoDetalleFactura = true;
            }
            if (esDocumentoNoLegal(formul.getRutinaDiseñoFormulario())){
                if (formul.getRutinaDiseñoFormulario().equals("ListaDePicado")){
                    if (datosConsolidado.getDtoCabeceraListaPicado() == null)
                        //sapaza -- cambio Optimizacion Logs -- 05/03/2010, Recategorizacion de nivel ERROR a INFO
                        UtilidadesLog.info("Datos del consolidado, para la lista de picado vacios, no se generará la misma!!");
                    else
                        documentoUnico = procesarDocumentoNoLegalListaPicado(formul, datosConsolidado);
                }else{
                    documentoUnico = procesarDocumentoNoLegal(formul, datosConsolidado, datosRecuperados, datosRecuperadosNoLegales, dtoClienteSolicitud);
                }                           
            }else if (esDocumentoMensaje(formul.getRutinaDiseñoFormulario())){
                documentoUnico = procesarDocumentoMensaje(formul, datosConsolidado, datosRecuperados, datosRecuperadosNoLegales, dtoClienteSolicitud, dtoMensajesFinal);
            }
            UtilidadesLog.debug("Salida IMpresa: "+new String(documentoUnico));            
            
            if (generoDetalleFactura) {
               if (documentoAgrupado.length > 0) {
                  DTODocumento dtoDocu= new DTODocumento();
                  dtoDocu.setDocumentoByte(documentoAgrupado);
                  dtoDocu.setDocumento(new String(documentoAgrupado));
                  dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
                  dtoDocu.setTipoDocumento(oidImpresoraVirtualAnterior);
                  SpoolManagerLocal spoolManager = this.getSpoolManager();
                  UtilidadesLog.debug("MONImpresionSICC.generarDocFacturaColombia manda a imprimir documentos XML");
                  oidDocumentoGenerado = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
                  documentoAgrupado = new byte[0];
               }          
               DTODocumento dtoDocu= new DTODocumento();
               dtoDocu.setDocumentoByte(documentoUnico);
               dtoDocu.setDocumento(new String(documentoUnico));
               dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
               dtoDocu.setTipoDocumento(formul.getOidImpresoraVirtual());
               SpoolManagerLocal spoolManager = this.getSpoolManager();
               UtilidadesLog.debug("MONImpresionSICC.generarDocFacturaColombia manda a imprimir documentos XML");
               oidDocumentoGenerado = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool()); 
               stringInsercionDocumentosGenerados.append(this.generarUpdatesDocumentoGenerado(oidDocumentoGenerado, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), generoDetalleFactura).toString());
               oidImpresoraVirtualAnterior = (Long)formul.getOidImpresoraVirtual();                 
               generoDetalleFactura = false; 
               documentoUnico = new byte[0];
            }            
            
            //sapaza -- correcion de documentoAgrupado -- 09/11/2010
            if ((oidImpresoraVirtualAnterior.longValue() != formul.getOidImpresoraVirtual().longValue()) && (documentoAgrupado.length > 0) ) {
              DTODocumento dtoDocu= new DTODocumento();
              dtoDocu.setDocumentoByte(documentoAgrupado);
              dtoDocu.setDocumento(new String(documentoAgrupado));
              dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
              dtoDocu.setTipoDocumento(oidImpresoraVirtualAnterior);
              SpoolManagerLocal spoolManager = this.getSpoolManager();
              UtilidadesLog.debug("MONImpresionSICC.generarDocFacturaColombia manda a imprimir documentos XML");
              oidDocumentoGenerado = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
              if (generoBoletaEntrega) {
                if (insertoBoletaEntrega) {
                    stringInsercionDocumentosGenerados.append(this.generarUpdatesDocumentoGenerado(oidDocumentoGenerado, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), true).toString());
                    insertoBoletaEntrega = false;
                    generoBoletaEntrega = false;
                } else {
                    stringInsercionDocumentosGenerados.append(this.generarUpdatesDocumentoGenerado(oidDocumentoGenerado, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), false).toString());                
                    insertoBoletaEntrega = true;
                }
              } else {
                stringInsercionDocumentosGenerados.append(this.generarUpdatesDocumentoGenerado(oidDocumentoGenerado, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), false).toString());
              }
              oidImpresoraVirtualAnterior = (Long)formul.getOidImpresoraVirtual();  
              documentoAgrupado = new byte[0];
              documentoAgrupado = this.concatenaByte(documentoAgrupado, documentoUnico);
            } else {
              documentoAgrupado = this.concatenaByte(documentoAgrupado, documentoUnico);
              oidImpresoraVirtualAnterior = (Long)formul.getOidImpresoraVirtual();  
            }          
          }
          if (documentoAgrupado.length > 0) {
            DTODocumento dtoDocu= new DTODocumento();
            dtoDocu.setDocumentoByte(documentoAgrupado);
            dtoDocu.setDocumento(new String(documentoAgrupado));
            dtoDocu.setNumSecuencia(datosConsolidado.getDtoCabecera().getNumeroSecuenciaImpresion());
            dtoDocu.setTipoDocumento(formul.getOidImpresoraVirtual());
            SpoolManagerLocal spoolManager = this.getSpoolManager();
            UtilidadesLog.debug("MONImpresionSICC.generarDocFactura manda a imprimir documentos XML");              
            oidDocumentoGenerado = spoolManager.addPrintableDocuments(dtoDocu, datosConsolidado.getIDSpool());
            stringInsercionDocumentosGenerados.append(this.generarUpdatesDocumentoGenerado(oidDocumentoGenerado, datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), generoBoletaEntrega).toString());            
          }
              
          
          this.insertarUpdatesDocumentosGenerados(stringInsercionDocumentosGenerados);
          
          if (datosConsolidado.getIndOnline() != null && datosConsolidado.getIndOnline().booleanValue()) {
             if (this.validarTipoSpool(datosConsolidado.getOidPais())) {
                this.getSpoolManager().closeSpoolColombia(datosConsolidado.getIDSpool());
             } else {
                this.getSpoolManager().closeSpool(datosConsolidado.getIDSpool());
             }
          }    
              
          StringBuffer consulta = new StringBuffer();
          consulta.append("UPDATE PED_SOLIC_CABEC ");
          consulta.append("SET IND_IMPR = 1 ");
          consulta.append("WHERE OID_SOLI_CABE = " + datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud() );
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executeUpdate(consulta.toString());
       } else {
          UtilidadesLog.info("No se generan documentos de facturacion porque el Numero de Unidades Atentidas en el Consolidado con Oid["+ datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud() +"] es 0.");
              
          StringBuffer consulta = new StringBuffer();
          consulta.append("UPDATE PED_SOLIC_CABEC ");
          consulta.append("SET IND_IMPR = 0 ");
          consulta.append("WHERE OID_SOLI_CABE = " + datosConsolidado.getDtoCabecera().getOidCabeceraSolicitud() );
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executeUpdate(consulta.toString());
        }
      } catch (Exception e)  {
        UtilidadesLog.error("ERROR ",e);
        throw new MareException (e); //agregado por Sergio Apaza, PER-SiCC-2010-0015 Controlar Transaccionalidad al Generar Paquete Documentario                    
      } 
      UtilidadesLog.info("MONImpresionSICCBean.generarDocFacturaColombia(DTOFACConsolidado datosConsolidado): Salida");
    }
    
  private boolean validarTipoSpool(Long oidPais) throws MareException {
    UtilidadesLog.info("MONFacturacionBean.validarTipoSpool(Long oidPais): Entrada");
    Boolean indicadorTipoSpool = new Boolean(false);
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT IND_SPOO_SIN_PRE_IMPR ");
    query.append("FROM SEG_PARAM_INTER_PAIS ");
    query.append("WHERE PAIS_OID_PAIS = ").append(oidPais);
    
    RecordSet rs = null;
    rs = UtilidadesBD.executeQuery(query.toString());
    

    if (rs != null && !rs.esVacio()) {          
      indicadorTipoSpool = UtilidadesBD.convertirABoolean(rs.getValueAt(0, "IND_SPOO_SIN_PRE_IMPR"));          
    }

    UtilidadesLog.info("MONFacturacionBean.validarTipoSpool(Long oidPais): Salida");
    return indicadorTipoSpool.booleanValue();
  }


    private MONGestionRecojosLocalHome getMONGestionRecojosLocalHome() throws MareException {
        Object home = UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONGestionRecojos");
        return (MONGestionRecojosLocalHome)home;
    }
    
    // sapaza -- PER-SiCC-2011-0138 -- 22/02/2011
    private void invocarProcedimientoLaser(Long oidSolicitud, Long oidPais, Long oidPeriodo) throws Exception {
        UtilidadesLog.info("MONImpresionSICCBean.invocarProcedimientoLaser (Long oidSolicitud, Long oidPais, Long oidPeriodo): Entrada");       
        
        if(this.codigoPais == null ){
            StringBuffer query = new StringBuffer();
            
            query.append("SELECT COD_PAIS ");
            query.append("  FROM SEG_PAIS ");
            query.append(" WHERE OID_PAIS = ").append(oidPais);
            
            RecordSet rs = null;
            rs = UtilidadesBD.executeQuery(query.toString());

            this.codigoPais = rs.getValueAt(0, "COD_PAIS").toString();          
        }
        if(this.periodos.get(oidPeriodo.toString())==null) {
            StringBuffer query = new StringBuffer();
            
            query.append("SELECT cor.COD_PERI ");
            query.append("  FROM CRA_PERIO per, SEG_PERIO_CORPO cor ");
            query.append(" WHERE per.PERI_OID_PERI = cor.OID_PERI ");
            query.append("   AND per.OID_PERI = ").append(oidPeriodo);
            
            RecordSet rs = null;
            rs = UtilidadesBD.executeQuery(query.toString());

            this.periodos.put(oidPeriodo.toString(), rs.getValueAt(0, "COD_PERI").toString());          
        }
        
        ArrayList params = new ArrayList();
        params.add(oidSolicitud.toString());
        params.add(codigoPais.toString());
        params.add(this.periodos.get(oidPeriodo.toString()).toString());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();         
        bs.dbService.executeProcedure("PQ_PLANI.IMP_PR_PROCE_DETAL_FACTU_PERF", params);
        UtilidadesLog.info("MONImpresionSICCBean.invocarProcedimientoLaser (Long oidSolicitud, Long oidPais, Long oidPeriodo): Salida");
    }    
    
}
