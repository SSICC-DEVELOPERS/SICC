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
 */

package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroDisp;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTODatosConsultora;
import es.indra.sicc.dtos.msg.DTORegistroFicheroConsultoras;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class MONCargarFicheroConsultorasBean implements SessionBean {
    SessionContext ctx;
    private int longCodigoCliente = 0;
	private FicheroListaConsultoras ficheroWrapper = null;
	
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

    private DTORegistroFicheroConsultoras obtenerRegistro()
        throws MareException {
        
        UtilidadesLog.info("MONCargarFicheroConsultorasBean.obtenerRegistro(): Entrada");
        
        Object dto = ficheroWrapper.leerRegistro();

        if (dto != null) {
            UtilidadesLog.info("MONCargarFicheroConsultorasBean.obtenerRegistro(): Salida");
        
            return (DTORegistroFicheroConsultoras) dto;
        }

        UtilidadesLog.info("MONCargarFicheroConsultorasBean.obtenerRegistro(): Salida");

        return null;
    }
    
    public int obtenerLongitudCodigoCliente(Long pais)throws MareException{
        StringBuffer sb = new StringBuffer();
        RecordSet r = null;
        sb.append(" select num_posi_nume_clie from seg_pais where oid_pais = "+pais);
        try {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
			r = bs.dbService.executeStaticQuery(sb.toString());            
		} catch (Exception e) {
			UtilidadesLog.error("ObtenerParametrizacionCodigoClientePais: ",e);
            String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        return new Integer(r.getValueAt(0,0).toString()).intValue();
    }
	
    public DTOFicheroResultado procesar(DTOFicheroDisp dtoin) 
		throws MareException {
		
        UtilidadesLog.info("MONCargarFicheroConsultorasBean.procesar(DTOFicheroDisp dtoin): Entrada");
        
		DTOFicheroResultado salida = new DTOFicheroResultado();
		DTORegistroFicheroConsultoras registro = null;
		boolean ficheroLog = false;
		longCodigoCliente = obtenerLongitudCodigoCliente(dtoin.getOidPais());
        DTODatosConsultora dtoDatos = (DTODatosConsultora)dtoin.getDatos();
		try{
			ficheroWrapper = new FicheroListaConsultoras(	dtoin.getPathFichero(),
															dtoin.getNombreFichero(), longCodigoCliente);
		}catch(MareException me){
            
            UtilidadesLog.error(me);
            
			ctx.setRollbackOnly();
			throw new MareException(me, 
				UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0013));
		}
        StringBuffer sb = new StringBuffer();
		try {
            ArrayList clientes = new ArrayList();			
            Hashtable hashtable = new Hashtable();		
            while (true) {
                registro = obtenerRegistro();
                if(registro==null || registro.getCodCliente()==null)  {
                    break;
                }
                DTODatosConsultora dtoC= new DTODatosConsultora();
                dtoC.setDatoVariable2( registro.getDatoVariable2() );
                dtoC.setDatoVariable3( registro.getDatoVariable3() );
                dtoC.setDatoVariable4( registro.getDatoVariable4() );
                dtoC.setDatoVariable5( registro.getDatoVariable5() );
                dtoC.setDatoVariable6( registro.getDatoVariable6() );
                dtoC.setDatoVariable7( registro.getDatoVariable7() );
                dtoC.setDatoVariable8( registro.getDatoVariable8() );
                dtoC.setDatoVariable9( registro.getDatoVariable9() );
                dtoC.setDatoVariable10( registro.getDatoVariable10() );
                dtoC.setCodCliente( registro.getCodCliente() );
                dtoC.setOidMensaje(dtoDatos.getOidMensaje());
                dtoC.setOidPais(dtoin.getOidPais());
                clientes.add(dtoC);
                if (!hashtable.containsKey(registro.getCodCliente())){
                    hashtable.put(registro.getCodCliente(),dtoC);
                }
            }
            ficheroWrapper.cerrarArchivo();
            int cantClientesEntrada = clientes.size();
            //this.validarListaClientes(clientes, dtoin.getOidPais());
            this.validarListaClientes(hashtable, dtoin.getOidPais());

            Iterator enumer =  clientes.iterator();
            int count = 0;
            while (enumer.hasNext()){
                DTODatosConsultora dtoC = (DTODatosConsultora)enumer.next();
                if (hashtable.containsKey(dtoC.getCodCliente())){
                    DTODatosConsultora dtoG = (DTODatosConsultora)hashtable.get(dtoC.getCodCliente());
                    if (dtoG.getOidCliente()!=null){
                        dtoC.setNombreApellidos(dtoG.getNombreApellidos());
                        dtoC.setOidCliente(dtoG.getOidCliente());
                        sb.append(this.generaInsertBuzonMensaje(dtoC));
                        count++;
                        if (count == 500){
                            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
                            sb = new StringBuffer();
                            count = 0;
                        }
                    }else{
                        StringBuffer mensaje = new StringBuffer();
                        ficheroLog = true;
                        //mensaje.append( registro );
                        mensaje.append( " (MSG-0014): No se encuentra el codigo de cliente en maestro de clientes '" + dtoC.getCodCliente() + "'");
                        LogAPP.info(mensaje); //Log de error.
                    }
                }else{
                    StringBuffer mensaje = new StringBuffer();
                    ficheroLog = true;
                    //mensaje.append( registro );
                    mensaje.append( " (MSG-0014): No se encuentra el codigo de cliente en maestro de clientes '" + dtoC.getCodCliente() + "'");
                    LogAPP.info(mensaje); //Log de error.
                }
            }
            
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
            
        }catch(Exception e){
            UtilidadesLog.error(sb.toString());
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
            
        salida.setEstatus(new Integer(-2));

        if (ficheroLog){
            //proceso correcto pero hay consultoras del fichero que no existen 
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0015));
        }
        UtilidadesLog.info("MONCargarFicheroConsultorasBean.procesar(DTOFicheroDisp dtoin): Salida");

        return salida;
    }

    /*
     * RCR PER-SiCC-2011-0530, se creo la tabla MSG_LISTA_CLIEN_TEMPO, y ahora la validacion debe utilizar
     *                      dicha tabla, además debe borrar la data antes de procesar.
     * 
     */
    private void validarListaClientes(Hashtable lista, Long oidPais) throws MareException {
        BelcorpService bs;
        RecordSet resultado = null;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
                
        try {
            StringBuffer sqlTemp = new StringBuffer("");
            StringBuffer sqlValidacion = new StringBuffer("");
            Enumeration codigosCliente = lista.keys();
            String codigoCliente = null;
            int numClientesValidadosOK = 0;
            
            // Borro los datos de la tabla temporal MSG_LISTA_CLIEN_TEMPO
            sqlTemp.append("DELETE FROM MSG_LISTA_CLIEN_TEMPO;");
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", sqlTemp.toString());
            
            UtilidadesLog.debug("--- Preparando para cargar tabla temporal...");
            sqlTemp = new StringBuffer("");
            while(codigosCliente.hasMoreElements()) {
                codigoCliente = (String)codigosCliente.nextElement();
                sqlTemp.append("INSERT INTO MSG_LISTA_CLIEN_TEMPO (COD_CLIE) VALUES ('" + codigoCliente + "');");
            }
            
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", sqlTemp.toString());
            UtilidadesLog.debug("--- La tabla temporal fue cargada...");
            
            
            // Valido los codigos y obtengo oids de cliente realizando consulta
            sqlValidacion.append(" SELECT mae.COD_CLIE, mae.OID_CLIE, mae.VAL_APE1, mae.VAL_APE2, mae.VAL_NOM1, mae.VAL_NOM2 ");
            sqlValidacion.append("   FROM MAE_CLIEN mae, ");
            sqlValidacion.append("        MSG_LISTA_CLIEN_TEMPO temp ");
            sqlValidacion.append("  WHERE mae.PAIS_OID_PAIS = " + oidPais);
            sqlValidacion.append("    AND temp.COD_CLIE = mae.COD_CLIE ");
                        
            resultado = bs.dbService.executeStaticQuery(sqlValidacion.toString());
            numClientesValidadosOK = resultado.getRowCount();
            
            UtilidadesLog.debug("      cantidad de codigos OK_" + numClientesValidadosOK);
            UtilidadesLog.debug("      cantidad de codigos NOK_" + (lista.size() - numClientesValidadosOK));
            
            
            // Borro los datos de la tabla temporal MSG_LISTA_CLIEN_TEMPO
            /*sqlTemp = new StringBuffer("");
            sqlTemp.append("DELETE FROM MSG_LISTA_CLIEN_TEMPO;");
            
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", sqlTemp.toString());*/
            
                        
            // Con los oid obtenidos cargo los valores al Hastable que recibo por
            // parametro y que utilizare, ya modificado, fuera de este metodo.
            String codClienteValidado;
            Long oidClienteValidado;
            
            for (int i = 0; i < numClientesValidadosOK; i++) {
                oidClienteValidado = new Long(((BigDecimal) resultado.getValueAt(i,1)).longValue());
                codClienteValidado = (String) resultado.getValueAt(i,0);
                DTODatosConsultora dtoC = null;
                if (lista.containsKey(codClienteValidado)){
                    dtoC = (DTODatosConsultora)lista.get(codClienteValidado);
                }
                dtoC.setCodCliente(codClienteValidado);
                dtoC.setOidCliente(oidClienteValidado);
                String ape1 = "";
                String ape2 = "";
                String nom1 = "";
                String nom2 = "";
                if (resultado.getValueAt(i,2)!=null){
                    ape1 = resultado.getValueAt(i,2).toString()+" ";
                }
                if (resultado.getValueAt(i,3)!=null){
                    ape2 = resultado.getValueAt(i,3).toString()+" ";
                }
                if (resultado.getValueAt(i,4)!=null){
                    nom1 = resultado.getValueAt(i,4).toString()+" ";
                }
                if (resultado.getValueAt(i,5)!=null){
                    nom2 = resultado.getValueAt(i,5).toString()+" ";
                }
                dtoC.setNombreApellidos(nom1+nom2+ape1+ape2);

                lista.put(codClienteValidado, dtoC);
            }
            
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al validar Codigos de cliente del archivo", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private StringBuffer generaInsertBuzonMensaje(DTODatosConsultora dto){
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO msg_buzon_mensa ");
        sb.append(" (oid_buzo_mens, clie_oid_clie, mens_oid_mens, modu_oid_modu_orig, ");
        sb.append(" peri_oid_peri, val_nom1_clie, val_nom2_clie, val_ape1_clie, ");
        sb.append(" val_ape2_clie, val_apel_casa_clie, ");
        sb.append(" num_secu, ");
        sb.append(" dato_vari_01, dato_vari_02, dato_vari_03, dato_vari_04, ");
        sb.append(" dato_vari_05, dato_vari_06, dato_vari_07, dato_vari_08, ");
        sb.append(" dato_vari_09, dato_vari_10, ");
        sb.append(" fec_grab, fec_impr, ind_list_cons, ind_esta_mens, ");
        sb.append(" ind_acti ");
        sb.append(" ) ");
        sb.append(" VALUES ( MSG_BUME_SEQ.nextval ");
        sb.append(" , "+dto.getOidCliente());
        sb.append(" , "+dto.getOidMensaje());
        sb.append(" , "+new Long(ConstantesSEG.MODULO_MSG));
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , (SELECT (NVL ((c.offset + d.algo), 0) + 1) secuencia ");
        sb.append(" FROM (SELECT 0 offset ");
        sb.append(" FROM DUAL) c, ");
        sb.append(" (SELECT MAX (c.num_secu) algo ");
        sb.append(" FROM msg_buzon_mensa c, msg_mensa d ");
        sb.append(" WHERE c.mens_oid_mens = d.oid_mens ");
        sb.append(" AND c.mens_oid_mens = "+dto.getOidMensaje());
        sb.append(" AND c.clie_oid_clie = "+dto.getOidCliente());
        sb.append(" AND d.pais_oid_pais = "+dto.getOidPais()+") d) ");
        sb.append(" , "+ajustarVariable(dto.getNombreApellidos()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable2()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable3()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable4()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable5()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable6()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable7()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable8()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable9()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable10()));
        sb.append(" , sysdate");
        sb.append(" , null");
        sb.append(" , "+new Long(1));
        sb.append(" , NULL");
        sb.append(" , "+ConstantesMSG.IND_ACTIVO);
        sb.append(" );");
        return sb;
    }
    private String ajustarVariable(String dato) {
        String retorno = "''";
        if (dato != null && dato.length() > 100 ) {
            retorno = dato.substring(0, 100).replaceAll("'","''");
            retorno = "'" + retorno + "'";
        } else if (dato!=null){
            retorno = dato.replaceAll("'","''");
            retorno = "'"+retorno+"'";
        }
        return retorno;
    }
}
