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
package es.indra.sicc.entidades.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.EntidadSICCAuditableBean;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.SecuenciadorOID;

import java.lang.StringBuffer;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import java.sql.Timestamp;

public class BuzonMensajesBean extends EntidadSICCAuditableBean {

	  private EntityContext context;
  public Long activo;
    public String datoVariable1;
	  private Long oid;
	  private Long numeroSecuencial;
    public String datoVariable10;
    public String datoVariable11;
    public String datoVariable12;
    public String datoVariable13;
    public String datoVariable14;
    public String datoVariable15;
    public String datoVariable16;
    public String datoVariable17;
    public String datoVariable18;
    public String datoVariable19;
    public String datoVariable20;
    public Long oidPeriodo;
    public Long oidCliente;
	  private Long oidMensaje;
	  private Long modulo;
    public String nombre1Cliente;
	  private String nombre2Cliente;
    public String apellido1Cliente;
    public String apellido2Cliente;
    public String apellidoCasadaCliente;
    public String datoVariable2;
    public String datoVariable3;
    public String datoVariable4;
    public String datoVariable5;
    public String datoVariable6;
    public String datoVariable7;
    public String datoVariable8;
    public String datoVariable9;
    private Long numeroLoteImpresion;
    public Timestamp fechaGrabacion;
    public Timestamp fechaImpresion;
    public Long esConsultora;
    public Long estadoMensaje;

    public void ejbPostCreate() {
    }                         
    
	public Long ejbCreate( Long paramNumeroSecuencial,Long paramOidCliente,Long paramOidMensaje,Long paramModulo) throws MareException{                           
        oid = SecuenciadorOID.obtenerSiguienteValor("MSG_BUME_SEQ");
		numeroSecuencial = paramNumeroSecuencial;
		oidCliente = paramOidCliente;
		oidMensaje = paramOidMensaje;
		modulo = paramModulo;
		try {
			BelcorpService rs = BelcorpService.getInstance();
			String sql = " INSERT INTO msg_buzon_mensa ( OID_BUZO_MENS ,NUM_SECU ,CLIE_OID_CLIE ,MENS_OID_MENS ,MODU_OID_MODU_ORIG ) VALUES (  ? , ? , ? , ? , ? ) ";
			Vector v = new Vector();			
            v.add(oid);
			v.add(paramNumeroSecuencial);
			v.add(paramOidCliente);
			v.add(paramOidMensaje);
			v.add(paramModulo);			                    
            rs.dbService.executePreparedUpdate(sql,v);
            super.ejbCreate();
			return oid;
		} catch (Exception ex) {      
			throw new MareException("BuzonMensa. No se pudo crear el Entity Bean: " + ex.getMessage());
		} 
	}

	public void ejbPostCreate( Long paramNumeroSecuencial,Long paramOidCliente,Long paramOidMensaje,Long paramModulo){
	}

	public Long ejbFindByPrimaryKey(Long pkey) throws FinderException {
		try{
			BelcorpService rs = BelcorpService.getInstance();
			String query = " SELECT * FROM msg_buzon_mensa WHERE 1=1  AND OID_BUZO_MENS = ? ";
			Vector v = new Vector();
			v.add(pkey);
			RecordSet r = rs.dbService.executePreparedQuery(query, v);
			if (r.getRowCount() != 1)
				throw new FinderException("Entidad no existente");
			return pkey;
		} catch (Exception ex) {
			throw new FinderException("BuzonMensa." + ex.getMessage());
		}

	}

	public void ejbActivate(){
	}

	public void ejbLoad(){
		oid = new Long(context.getPrimaryKey().toString());
        try {

            BelcorpService rs = BelcorpService.getInstance();

            String query = " SELECT * FROM msg_buzon_mensa WHERE 1=1  AND OID_BUZO_MENS = ? ";

            Vector v = new Vector();
            v.add(oid);

            RecordSet r = rs.dbService.executePreparedQuery(query, v);
            numeroSecuencial = cambiarTipo((BigDecimal) r.getValueAt(0, "NUM_SECU"));

            //Modifico Hugo A. Mansi
            //Fecha de modificación 17/15/2004
            //Incidencia 11496
            //******************************************************************************/
            if (r.getValueAt(0, "DATO_VARI_01") != null) {
                datoVariable1 = (String) r.getValueAt(0, "DATO_VARI_01");
            }

            if (r.getValueAt(0, "DATO_VARI_02") != null) {
                datoVariable2 = (String) r.getValueAt(0, "DATO_VARI_02");
            }

            if (r.getValueAt(0, "DATO_VARI_03") != null) {
                datoVariable3 = (String) r.getValueAt(0, "DATO_VARI_03");
            }

            if (r.getValueAt(0, "DATO_VARI_04") != null) {
                datoVariable4 = (String) r.getValueAt(0, "DATO_VARI_04");
            }

            if (r.getValueAt(0, "DATO_VARI_05") != null) {
                datoVariable5 = (String) r.getValueAt(0, "DATO_VARI_05");
            }

            if (r.getValueAt(0, "DATO_VARI_06") != null) {
                datoVariable6 = (String) r.getValueAt(0, "DATO_VARI_06");
            }

            if (r.getValueAt(0, "DATO_VARI_07") != null) {
                datoVariable7 = (String) r.getValueAt(0, "DATO_VARI_07");
            }

            if (r.getValueAt(0, "DATO_VARI_08") != null) {
                datoVariable8 = (String) r.getValueAt(0, "DATO_VARI_08");
            }

            if (r.getValueAt(0, "DATO_VARI_09") != null) {
                datoVariable9 = (String) r.getValueAt(0, "DATO_VARI_09");
            }

            if (r.getValueAt(0, "DATO_VARI_10") != null) {
                datoVariable10 = (String) r.getValueAt(0, "DATO_VARI_10");
            }

            if (r.getValueAt(0, "DATO_VARI_11") != null) {
                datoVariable11 = (String) r.getValueAt(0, "DATO_VARI_11");
            }

            if (r.getValueAt(0, "DATO_VARI_12") != null) {
                datoVariable12 = (String) r.getValueAt(0, "DATO_VARI_12");
            }

            if (r.getValueAt(0, "DATO_VARI_13") != null) {
                datoVariable13 = (String) r.getValueAt(0, "DATO_VARI_13");
            }

            if (r.getValueAt(0, "DATO_VARI_14") != null) {
                datoVariable14 = (String) r.getValueAt(0, "DATO_VARI_14");
            }

            if (r.getValueAt(0, "DATO_VARI_15") != null) {
                datoVariable15 = (String) r.getValueAt(0, "DATO_VARI_15");
            }

            if (r.getValueAt(0, "DATO_VARI_16") != null) {
                datoVariable16 = (String) r.getValueAt(0, "DATO_VARI_16");
            }

            if (r.getValueAt(0, "DATO_VARI_17") != null) {
                datoVariable17 = (String) r.getValueAt(0, "DATO_VARI_17");
            }

            if (r.getValueAt(0, "DATO_VARI_18") != null) {
                datoVariable18 = (String) r.getValueAt(0, "DATO_VARI_18");
            }

            if (r.getValueAt(0, "DATO_VARI_19") != null) {
                datoVariable19 = (String) r.getValueAt(0, "DATO_VARI_19");
            }

            if (r.getValueAt(0, "DATO_VARI_20") != null) {
                datoVariable20 = (String) r.getValueAt(0, "DATO_VARI_20");
            }

            if (r.getValueAt(0, "IND_ACTI") != null) {
                activo = cambiarTipo((BigDecimal) r.getValueAt(0, "IND_ACTI"));
            }

            if (r.getValueAt(0, "IND_ESTA_MENS") != null) {
                estadoMensaje = cambiarTipo((BigDecimal) r.getValueAt(0, "IND_ESTA_MENS"));
            }

            if (r.getValueAt(0, "PERI_OID_PERI") != null) {
                oidPeriodo = cambiarTipo((BigDecimal) r.getValueAt(0, "PERI_OID_PERI"));
            }

            if (r.getValueAt(0, "CLIE_OID_CLIE") != null) {
                oidCliente = cambiarTipo((BigDecimal) r.getValueAt(0, "CLIE_OID_CLIE"));
            }

            oidMensaje = cambiarTipo((BigDecimal) r.getValueAt(0, "MENS_OID_MENS"));

            modulo = cambiarTipo((BigDecimal) r.getValueAt(0, "MODU_OID_MODU_ORIG"));

            if (r.getValueAt(0, "VAL_NOM1_CLIE") != null) {
                nombre1Cliente = (String) r.getValueAt(0, "VAL_NOM1_CLIE");
            }

            if (r.getValueAt(0, "VAL_NOM2_CLIE") != null) {
                nombre2Cliente = (String) r.getValueAt(0, "VAL_NOM2_CLIE");
            }

            if (r.getValueAt(0, "VAL_APE1_CLIE") != null) {
                apellido1Cliente = (String) r.getValueAt(0, "VAL_APE1_CLIE");
            }

            if (r.getValueAt(0, "VAL_APE2_CLIE") != null) {
                apellido2Cliente = (String) r.getValueAt(0, "VAL_APE2_CLIE");
            }

            if (r.getValueAt(0, "VAL_APEL_CASA_CLIE") != null) {
                apellidoCasadaCliente = (String) r.getValueAt(0, "VAL_APEL_CASA_CLIE");
            }

            if (r.getValueAt(0, "NUM_LOTE_IMPR") != null) {
                numeroLoteImpresion = cambiarTipo((BigDecimal) r.getValueAt(0, "NUM_LOTE_IMPR"));
            }

            if (r.getValueAt(0, "FEC_GRAB") != null) {
                fechaGrabacion = new Timestamp(((java.sql.Date) r.getValueAt(0, "FEC_GRAB")).getTime());
            }

            if (r.getValueAt(0, "FEC_IMPR") != null) {
                fechaImpresion = new Timestamp(((java.sql.Date) r.getValueAt(0, "FEC_IMPR")).getTime());
            }

            if (r.getValueAt(0, "IND_LIST_CONS") != null) {
                esConsultora = cambiarTipo((BigDecimal) r.getValueAt(0, "IND_LIST_CONS"));
            }
      //hasta acá modificó Hugo Mansi
			//incidencia 11496
			//******************************************************************************/
            
        } catch (Exception ex) {
            throw new EJBException("BuzonMensa. " + oid + " no se pudo cargar." + ex.getMessage());
        }
	}

    private Long cambiarTipo(BigDecimal newdato) {
        if (newdato != null)
            return (new Long(newdato.toString()));
        else
            return null;
    }

	public void ejbPassivate(){
	}
    
	public void ejbRemove() {
		Long pkey = (Long) context.getPrimaryKey();
		try {
		  BelcorpService rs = BelcorpService.getInstance();
		  String query = " DELETE FROM msg_buzon_mensa WHERE 1=1  AND OID_BUZO_MENS = "+pkey+" ";
//		  Vector v = new Vector();
//			v.add(pkey);
//		  if(rs.dbService.executePreparedUpdate(query,v) != 1){
          if(rs.dbService.executeUpdate(query) != 1){
		    throw new RemoveException( pkey + " no se pudo eliminar");
		  }
          super.ejbRemove();
		} catch (Exception ex) {
            ex.printStackTrace();
//		  throw new RemoveException("BuzonMensa. " + ex.getMessage());
		} 
	}

	public void ejbStore(){
		try {
			BelcorpService rs = BelcorpService.getInstance();
			StringBuffer statement = new StringBuffer();
			String values = new String();
			statement.append("UPDATE MSG_BUZON_MENSA SET ");
			Vector v = new Vector();
			if (this.oid!= null){
				statement.append("OID_BUZO_MENS = ?,");
				v.add(this.oid);
			}else{  
				statement.append("OID_BUZO_MENS = NULL,");
			}
			if (this.numeroSecuencial!= null){
				statement.append("NUM_SECU = ?,");
				v.add(this.numeroSecuencial);
			}else{  
				statement.append("NUM_SECU = NULL,");
			}
			if (this.datoVariable10!= null){
				statement.append("DATO_VARI_10 = ?,");
				v.add(this.datoVariable10);
			}else{  
				statement.append("DATO_VARI_10 = NULL,");
			}
			if (this.datoVariable11!= null){
				statement.append("DATO_VARI_11 = ?,");
				v.add(this.datoVariable11);
			}else{  
				statement.append("DATO_VARI_11 = NULL,");
			}
			if (this.datoVariable12!= null){
				statement.append("DATO_VARI_12 = ?,");
				v.add(this.datoVariable12);
			}else{  
				statement.append("DATO_VARI_12 = NULL,");
			}
			if (this.datoVariable13!= null){
				statement.append("DATO_VARI_13 = ?,");
				v.add(this.datoVariable13);
			}else{  
				statement.append("DATO_VARI_13 = NULL,");
			}
			if (this.datoVariable14!= null){
				statement.append("DATO_VARI_14 = ?,");
				v.add(this.datoVariable14);
			}else{  
				statement.append("DATO_VARI_14 = NULL,");
			}
			if (this.datoVariable15!= null){
				statement.append("DATO_VARI_15 = ?,");
				v.add(this.datoVariable15);
			}else{  
				statement.append("DATO_VARI_15 = NULL,");
			}
			if (this.datoVariable16!= null){
				statement.append("DATO_VARI_16 = ?,");
				v.add(this.datoVariable16);
			}else{  
				statement.append("DATO_VARI_16 = NULL,");
			}
			if (this.datoVariable17!= null){
				statement.append("DATO_VARI_17 = ?,");
				v.add(this.datoVariable17);
			}else{  
				statement.append("DATO_VARI_17 = NULL,");
			}
			if (this.datoVariable18!= null){
				statement.append("DATO_VARI_18 = ?,");
				v.add(this.datoVariable18);
			}else{  
				statement.append("DATO_VARI_18 = NULL,");
			}
			if (this.datoVariable19!= null){
				statement.append("DATO_VARI_19 = ?,");
				v.add(this.datoVariable19);
			}else{  
				statement.append("DATO_VARI_19 = NULL,");
			}
			if (this.datoVariable20!= null){
				statement.append("DATO_VARI_20 = ?,");
				v.add(this.datoVariable20);
			}else{  
				statement.append("DATO_VARI_20 = NULL,");
			}
			if (this.estadoMensaje!= null){
				statement.append("IND_ESTA_MENS = ?,");
				v.add(this.estadoMensaje);
			}else{  
				statement.append("IND_ESTA_MENS = NULL,");
			}
			if (this.activo!= null){
				statement.append("IND_ACTI = ?,");
				v.add(this.activo);
			}else{  
				statement.append("IND_ACTI = NULL,");
			}
			if (this.oidPeriodo!= null){
				statement.append("PERI_OID_PERI = ?,");
				v.add(this.oidPeriodo);
			}else{  
				statement.append("PERI_OID_PERI = NULL,");
			}
			if (this.oidCliente!= null){
				statement.append("CLIE_OID_CLIE = ?,");
				v.add(this.oidCliente);
			}else{  
				statement.append("CLIE_OID_CLIE = NULL,");
			}
			if (this.oidMensaje!= null){
				statement.append("MENS_OID_MENS = ?,");
				v.add(this.oidMensaje);
			}else{  
				statement.append("MENS_OID_MENS = NULL,");
			}
			if (this.modulo!= null){
				statement.append("MODU_OID_MODU_ORIG = ?,");
				v.add(this.modulo);
			}else{  
				statement.append("MODU_OID_MODU_ORIG = NULL,");
			}
			if (this.nombre1Cliente!= null){
				statement.append("VAL_NOM1_CLIE = ?,");
				v.add(this.nombre1Cliente);
			}else{  
				statement.append("VAL_NOM1_CLIE = NULL,");
			}
			if (this.nombre2Cliente!= null){
				statement.append("VAL_NOM2_CLIE = ?,");
				v.add(this.nombre2Cliente);
			}else{  
				statement.append("VAL_NOM2_CLIE = NULL,");
			}
			if (this.apellido1Cliente!= null){
				statement.append("VAL_APE1_CLIE = ?,");
				v.add(this.apellido1Cliente);
			}else{  
				statement.append("VAL_APE1_CLIE = NULL,");
			}
			if (this.apellido2Cliente!= null){
				statement.append("VAL_APE2_CLIE = ?,");
				v.add(this.apellido2Cliente);
			}else{  
				statement.append("VAL_APE2_CLIE = NULL,");
			}
			if (this.apellidoCasadaCliente!= null){
				statement.append("VAL_APEL_CASA_CLIE = ?,");
				v.add(this.apellidoCasadaCliente);
			}else{  
				statement.append("VAL_APEL_CASA_CLIE = NULL,");
			}
			if (this.datoVariable1!= null){
				statement.append("DATO_VARI_01 = ?,");
				v.add(this.datoVariable1);
			}else{  
				statement.append("DATO_VARI_01 = NULL,");
			}
			if (this.datoVariable2!= null){
				statement.append("DATO_VARI_02 = ?,");
				v.add(this.datoVariable2);
			}else{  
				statement.append("DATO_VARI_02 = NULL,");
			}
			if (this.datoVariable3!= null){
				statement.append("DATO_VARI_03 = ?,");
				v.add(this.datoVariable3);
			}else{  
				statement.append("DATO_VARI_03 = NULL,");
			}
			if (this.datoVariable4!= null){
				statement.append("DATO_VARI_04 = ?,");
				v.add(this.datoVariable4);
			}else{  
				statement.append("DATO_VARI_04 = NULL,");
			}
			if (this.datoVariable5!= null){
				statement.append("DATO_VARI_05 = ?,");
				v.add(this.datoVariable5);
			}else{  
				statement.append("DATO_VARI_05 = NULL,");
			}
			if (this.datoVariable6!= null){
				statement.append("DATO_VARI_06 = ?,");
				v.add(this.datoVariable6);
			}else{  
				statement.append("DATO_VARI_06 = NULL,");
			}
			if (this.datoVariable7!= null){
				statement.append("DATO_VARI_07 = ?,");
				v.add(this.datoVariable7);
			}else{  
				statement.append("DATO_VARI_07 = NULL,");
			}
			if (this.datoVariable8!= null){
				statement.append("DATO_VARI_08 = ?,");
				v.add(this.datoVariable8);
			}else{  
				statement.append("DATO_VARI_08 = NULL,");
			}
			if (this.datoVariable9!= null){
				statement.append("DATO_VARI_09 = ?,");
				v.add(this.datoVariable9);
			}else{  
				statement.append("DATO_VARI_09 = NULL,");
			}
			if (this.numeroLoteImpresion!= null){
				statement.append("NUM_LOTE_IMPR = ?,");
				v.add(this.numeroLoteImpresion);
			}else{  
				statement.append("NUM_LOTE_IMPR = NULL,");
			}
			if (this.fechaGrabacion!= null){
				statement.append("FEC_GRAB = ?,");
				v.add(this.fechaGrabacion);
			}else{  
				statement.append("FEC_GRAB = NULL,");
			}
			if (this.fechaImpresion!= null){
				statement.append("FEC_IMPR = ?,");
				v.add(this.fechaImpresion);
			}else{  
				statement.append("FEC_IMPR = NULL,");
			}
			if (this.esConsultora!= null){
				statement.append("IND_LIST_CONS = ?,");
				v.add(this.esConsultora);
			}else{  
				statement.append("IND_LIST_CONS = NULL,");
			}
			statement.deleteCharAt(statement.length()-1); 
			statement.append("  WHERE 1=1  AND OID_BUZO_MENS = ?  ");
			v.add(this.oid);
			if (rs.dbService.executePreparedUpdate(statement.toString(),v) == 0){
				throw new Exception("Error en el EJBStore");
			}        
            super.ejbStore();
		} catch (Exception ex) {      
			throw new EJBException("BuzonMensa. " + ex.getMessage());
		} 
	}

	public Collection ejbFindAll() throws  FinderException, RemoteException {
		try{
			BelcorpService rs = BelcorpService.getInstance();
			String query = "  SELECT * FROM msg_buzon_mensa WHERE 1=1  ";
			Vector v = new Vector();
			RecordSet r = rs.dbService.executePreparedQuery(query, v);
			ArrayList res = new ArrayList();
			for (int i=0;i< r.getRowCount();i++){				
				oid = (Long)r.getValueAt(i,"OID_BUZO_MENS");
				res.add(oid);
			}
			return res;
		} catch (Exception ex) {
			throw new FinderException("BuzonMensa." + ex.getMessage());
		}
//        return new Vector();
	}
	public void setEntityContext(EntityContext ctx){
		this.context = ctx;
	}

	public void unsetEntityContext(){
		this.context = null;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getNumeroSecuencial() {
		return numeroSecuencial;
	}

	public void setNumeroSecuencial(Long newNumeroSecuencial) {
		numeroSecuencial = newNumeroSecuencial;
	}

	public String getDatoVariable10() {
		return datoVariable10;
	}

	public void setDatoVariable10(String newDatoVariable10) {
		datoVariable10 = newDatoVariable10;
	}

	public String getDatoVariable11() {
		return datoVariable11;
	}

	public void setDatoVariable11(String newDatoVariable11) {
		datoVariable11 = newDatoVariable11;
	}

	public String getDatoVariable12() {
		return datoVariable12;
	}

	public void setDatoVariable12(String newDatoVariable12) {
		datoVariable12 = newDatoVariable12;
	}

	public String getDatoVariable13() {
		return datoVariable13;
	}

	public void setDatoVariable13(String newDatoVariable13) {
		datoVariable13 = newDatoVariable13;
	}

	public String getDatoVariable14() {
		return datoVariable14;
	}

	public void setDatoVariable14(String newDatoVariable14) {
		datoVariable14 = newDatoVariable14;
	}

	public String getDatoVariable15() {
		return datoVariable15;
	}

	public void setDatoVariable15(String newDatoVariable15) {
		datoVariable15 = newDatoVariable15;
	}

	public String getDatoVariable16() {
		return datoVariable16;
	}

	public void setDatoVariable16(String newDatoVariable16) {
		datoVariable16 = newDatoVariable16;
	}

	public String getDatoVariable17() {
		return datoVariable17;
	}

	public void setDatoVariable17(String newDatoVariable17) {
		datoVariable17 = newDatoVariable17;
	}

	public String getDatoVariable18() {
		return datoVariable18;
	}

	public void setDatoVariable18(String newDatoVariable18) {
		datoVariable18 = newDatoVariable18;
	}

	public String getDatoVariable19() {
		return datoVariable19;
	}

	public void setDatoVariable19(String newDatoVariable19) {
		datoVariable19 = newDatoVariable19;
	}

	public String getDatoVariable20() {
		return datoVariable20;
	}

	public void setDatoVariable20(String newDatoVariable20) {
		datoVariable20 = newDatoVariable20;
	}



	public Long getActivo() {
		return activo;
	}

	public void setActivo(Long newActivo) {
		activo = newActivo;
	}



	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidMensaje() {
		return oidMensaje;
	}

	public void setOidMensaje(Long newOidMensaje) {
		oidMensaje = newOidMensaje;
	}



	public Long getModulo() {
		return modulo;
	}

	public void setModulo(Long newModulo) {
		modulo = newModulo;
	}

	public String getNombre1Cliente() {
		return nombre1Cliente;
	}

	public void setNombre1Cliente(String newNombre1Cliente) {
		nombre1Cliente = newNombre1Cliente;
	}

	public String getNombre2Cliente() {
		return nombre2Cliente;
	}

	public void setNombre2Cliente(String newNombre2Cliente) {
		nombre2Cliente = newNombre2Cliente;
	}

	public String getApellido1Cliente() {
		return apellido1Cliente;
	}

	public void setApellido1Cliente(String newApellido1Cliente) {
		apellido1Cliente = newApellido1Cliente;
	}

	public String getApellido2Cliente() {
		return apellido2Cliente;
	}

	public void setApellido2Cliente(String newApellido2Cliente) {
		apellido2Cliente = newApellido2Cliente;
	}

	public String getApellidoCasadaCliente() {
		return apellidoCasadaCliente;
	}

	public void setApellidoCasadaCliente(String newApellidoCasadaCliente) {
		apellidoCasadaCliente = newApellidoCasadaCliente;
	}

	public String getDatoVariable1() {
		return datoVariable1;
	}

	public void setDatoVariable1(String newDatoVariable1) {
		datoVariable1 = newDatoVariable1;
	}

	public String getDatoVariable2() {
		return datoVariable2;
	}

	public void setDatoVariable2(String newDatoVariable2) {
		datoVariable2 = newDatoVariable2;
	}

	public String getDatoVariable3() {
		return datoVariable3;
	}

	public void setDatoVariable3(String newDatoVariable3) {
		datoVariable3 = newDatoVariable3;
	}

	public String getDatoVariable4() {
		return datoVariable4;
	}

	public void setDatoVariable4(String newDatoVariable4) {
		datoVariable4 = newDatoVariable4;
	}

	public String getDatoVariable5() {
		return datoVariable5;
	}

	public void setDatoVariable5(String newDatoVariable5) {
		datoVariable5 = newDatoVariable5;
	}

	public String getDatoVariable6() {
		return datoVariable6;
	}

	public void setDatoVariable6(String newDatoVariable6) {
		datoVariable6 = newDatoVariable6;
	}

	public String getDatoVariable7() {
		return datoVariable7;
	}

	public void setDatoVariable7(String newDatoVariable7) {
		datoVariable7 = newDatoVariable7;
	}

	public String getDatoVariable8() {
		return datoVariable8;
	}

	public void setDatoVariable8(String newDatoVariable8) {
		datoVariable8 = newDatoVariable8;
	}

	public String getDatoVariable9() {
		return datoVariable9;
	}

	public void setDatoVariable9(String newDatoVariable9) {
		datoVariable9 = newDatoVariable9;
	}



	public Long getNumeroLoteImpresion() {
		return numeroLoteImpresion;
	}

	public void setNumeroLoteImpresion(Long newNumeroLoteImpresion) {
		numeroLoteImpresion = newNumeroLoteImpresion;
	}





	public java.sql.Timestamp getFechaGrabacion() {
		return fechaGrabacion;
	}

	public void setFechaGrabacion(java.sql.Timestamp newFechaGrabacion) {
		fechaGrabacion = newFechaGrabacion;
	}

	public java.sql.Timestamp getFechaImpresion() {
		return fechaImpresion;
	}

	public void setFechaImpresion(java.sql.Timestamp newFechaImpresion) {
		fechaImpresion = newFechaImpresion;
	}

	public Long getEsConsultora() {
		return esConsultora;
	}

	public void setEsConsultora(Long newEsConsultora) {
		esConsultora = newEsConsultora;
	}

    public Long getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(Long newEstadoMensaje) {
        estadoMensaje = newEstadoMensaje;
    }

  public Long ejbFindByUk(Long oidMensaje, Long oidCliente, Long numSecu)throws FinderException, RemoteException  {
     Vector parametros = new Vector();

           // UK formada por campos: MENS_OID_MENS, CLIE_OID_CLIE, NUM_SECU
	   String consulta = "SELECT OID_BUZO_MENS FROM MSG_BUZON_MENSA " +
	 					"WHERE MENS_OID_MENS = ? " +
						"AND CLIE_OID_CLIE = ? " +
						"AND NUM_SECU = ?";

	   parametros.add(oidMensaje);
	   parametros.add(oidCliente);		
	   parametros.add(numSecu);

	   BelcorpService bs;
	   RecordSet resultado;

	   try {
	      resultado = ejecutaConsulta(consulta, parametros);
	   } catch (EJBException ex) {
	      throw new EJBException();
	   }

      if (resultado.esVacio()) {
           throw new FinderException();
      }
      return new Long(((BigDecimal)resultado.getValueAt(0, "OID_BUZO_MENS")).longValue());
  }

  private RecordSet ejecutaConsulta(String query, Vector argumentos)
        throws EJBException {
		
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new EJBException(e);
        }

        RecordSet res;

        try {
            res = bs.dbService.executePreparedQuery(query, argumentos);
        } catch (Exception e) {
            throw new EJBException(e);
        }
		    //loguearSql("**** BMP MovimientosBancarios: ", query, argumentos);
        return res;
    }


}