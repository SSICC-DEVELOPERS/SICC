package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;

public class HelperHistorial{
   public void generarHistoriaBancaria(Long oidBanco) throws MareException{
      UtilidadesLog.info("HelperHistorial.generarHistoriaBancaria(Long oidBanco) Entrada");
      try{
         BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",obtenerHistoriaBancos(oidBanco).toString());
      }
      catch (Exception e) {
         e.printStackTrace();
         throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("HelperHistorial.generarHistoriaBancaria(Long oidBanco) Salida");
   }
   
   public void generarHistoriaCuentaCorriente(Long oidCuentaCorriente) throws MareException{
      UtilidadesLog.info("HelperHistorial.generarHistoriaCuentaCorriente(Long oidCuentaCorriente) Entrada");
      if(oidCuentaCorriente==null){
         throw new MareException("No se ha recibido el oid del movimiento bancario que debe generar historia");
      }
      try {
         BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",
                  obtenerHistoriaCuentasCorrientes(oidCuentaCorriente).toString());
      }catch (Exception e) {
         e.printStackTrace();
         throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("HelperHistorial.generarHistoriaCuentaCorriente(Long oidCuentaCorriente) Salida");
   }
   
   
   public StringBuffer obtenerHistoriaBancos(Long oidBanco) throws MareException{
      UtilidadesLog.info("HelperHistorial.obtenerHistoriaBancos(Long oidBanco) Entrada");
      if(oidBanco==null){
         throw new MareException("No se ha recibido el oid del movimiento bancario que debe generar historia");
      }
      //generamos la nueva historia e insertamos.
      StringBuffer insert = new StringBuffer();
      StringBuffer values = new StringBuffer();
      insert.append("INSERT INTO CCC_HISTO_MOVIM_BANCA ");
      insert.append("(OID_MOVI_BANC, ");
      values.append(" SELECT CCC_HMBA_SEQ.NEXTVAL, ");
      insert.append("NUM_CONS_TRAN, ");
      values.append("NUM_CONS_TRAN, ");
      insert.append("NUM_LOTE, ");
      values.append("NUM_LOTE, ");
      insert.append("COD_CONS, ");
      values.append("COD_CONS, ");
      insert.append("COD_ERRO, ");
      values.append("COD_ERRO, ");
      insert.append("VAL_DIGI_CHEQ_FACT, ");
      values.append("VAL_DIGI_CHEQ_FACT, ");
      insert.append("VAL_DOCU_APLI_ANIO, ");
      values.append("VAL_DOCU_APLI_ANIO, ");
      insert.append("VAL_DOCU_APLI_MES_SERI, ");
      values.append("VAL_DOCU_APLI_MES_SERI, ");
      insert.append("VAL_DOCU_APLI_NUME, ");
      values.append("VAL_DOCU_APLI_NUME, ");
      insert.append("VAL_DOCU_CREA_ANIO, ");
      values.append("VAL_DOCU_CREA_ANIO, ");
      insert.append("VAL_DOCU_CREA_MES_SERI, ");
      values.append("VAL_DOCU_CREA_MES_SERI, ");
      insert.append("VAL_DOCU_CREA_NUME, ");
      values.append("VAL_DOCU_CREA_NUME, ");
      insert.append("VAL_ESTA_MOVI_PEND, ");
      values.append("VAL_ESTA_MOVI_PEND, ");
      insert.append("FEC_CONTA, ");
      values.append("FEC_CONT, ");
      insert.append("FEC_MOVI_APLI, ");
      values.append("FEC_MOVI_APLI, ");
      insert.append("FEC_PAGO, ");
      values.append("FEC_PAGO, ");
      insert.append("FEC_PROC, ");
      values.append("FEC_PROC, ");
      insert.append("VAL_HORA_PROC, ");
      values.append("VAL_HORA_PROC, ");
      insert.append("VAL_HORA_NORM_ADIC, ");
      values.append("VAL_HORA_NORM_ADIC, ");
      insert.append("COD_IDEN_PROC, ");
      values.append("COD_IDEN_PROC, ");
      insert.append("IMP_PAGO, ");
      values.append("IMP_PAGO, ");
      insert.append("VAL_NOMB_OFIC, ");
      values.append("VAL_NOMB_OFIC, ");
      insert.append("NUM_CUPO, ");
      values.append("NUM_CUPO, ");
      insert.append("VAL_NUME_DOCU, ");
      values.append("VAL_NUME_DOCU, ");
      insert.append("NUM_FACT_BOLE, ");
      values.append("NUM_FACT_BOLE, ");
      insert.append("VAL_NUM_LOTE_CONT, ");
      values.append("VAL_NUME_LOTE_CONT, ");
      insert.append("VAL_OBSE, ");
      values.append("VAL_OBSE, ");
      insert.append("COD_OFIC_RECA, ");
      values.append("COD_OFIC_RECA, ");
      insert.append("VAL_USUA_PROC, ");
      values.append("VAL_USUA_PROC, ");
      insert.append("CMBA_OID_MOVI_BANC, ");
      values.append("OID_MOVI_BANC, ");
      insert.append("NUM_HIST, ");
      values.append("(SELECT NVL(MAX(NUM_HIST),-1)+1 FROM CCC_HISTO_MOVIM_BANCA WHERE CMBA_OID_MOVI_BANC = ");
      values.append(oidBanco.toString()+"), ");
      insert.append("FEC_PASO_HIST, ");
      values.append("NVL(FEC_MOVI_APLI, SYSDATE), ");
      insert.append("IMP_APLI, ");
      values.append("IMP_APLI, ");
      insert.append("VAL_IMPO_MOVI, ");
      values.append("VAL_IMPO_MOVI, ");
      insert.append("IMP_SALD_PEND, ");
      values.append("IMP_SALD_PEND, ");
      insert.append("NUM_LOTE_EXTE, ");
      values.append("NUM_LOTE_EXTE, ");
      insert.append("TCAB_OID_TIPO_CARG_ABON_ULTI, ");
      values.append("TCAB_OID_ABON_ULTI, ");
      insert.append("SUBP_OID_SUBP_CREA, ");
      values.append("SUBP_OID_MARC_CREA, ");
      insert.append("TIER_OID_ERRO, ");
      values.append("TIER_OID_ERRO, ");
      insert.append("CLIE_OID_CLIE, ");
      values.append("CLIE_OID_CLIE, ");
      insert.append("TCAB_OID_TIPO_CARG_ABON_CREA, ");
      values.append("TCAB_OID_ABON_CREA, ");
      insert.append("SOCI_OID_SOCI, ");
      values.append("SOCI_OID_SOCI, ");
      insert.append("SUBP_OID_SUBP_ULTI, ");
      values.append("SUBP_OID_MARC_ULTI, ");
      insert.append("TTRA_OID_TIPO_TRAN, ");
      values.append("TTRA_OID_TIPO_TRANS, ");
      insert.append("CCBA_OID_CUEN_CORR_BANC, ");
      values.append("CCBA_OID_CC_BANC, ");
      insert.append("SBAC_OID_SBAC, ");
      values.append("SBAC_OID_SBAC, ");
      insert.append("COD_USUA) ");
      values.append("COD_USUA ");
      values.append("FROM CCC_MOVIM_BANCA WHERE OID_MOVI_BANC = "+oidBanco.toString());
      insert.append(values);
      insert.append(";UPDATE CCC_MOVIM_BANCA SET NUM_HIST=");
      insert.append("(SELECT NVL(MAX(NUM_HIST),0)+1 FROM CCC_HISTO_MOVIM_BANCA WHERE CMBA_OID_MOVI_BANC = ");
      insert.append(oidBanco.toString());
      insert.append(") WHERE OID_MOVI_BANC = ");
      insert.append(oidBanco.toString()+";");
      UtilidadesLog.info("HelperHistorial.obtenerHistoriaBancos(Long oidBanco) Salida");
      return insert;      
   }
 
   public StringBuffer obtenerHistoriaCuentasCorrientes(Long oidCuentaCorriente) throws MareException{
      UtilidadesLog.info("HelperHistorial.obtenerHistoriaCuentasCorrientes(Long oidCuentaCorriente) Entrada");
      if(oidCuentaCorriente==null){
         throw new MareException("No se ha recibido el oid de la cuenta corriente que debe generar historia");
      }
      StringBuffer insert = new StringBuffer();
      StringBuffer values = new StringBuffer();
      insert.append("INSERT INTO CCC_HISTO_MOVIM_CC ");
      insert.append("(OID_HIST_MOVI, ");
      values.append(" SELECT CCC_HMCC_SEQ.NEXTVAL, ");
      insert.append("SUBP_OID_SUBP, ");
      values.append("SUBP_OID_SUBP_ULTI, ");
      insert.append("TCAB_OID_TIPO_CARG_ABON, ");
      values.append("TCAB_OID_TCAB_ULTI, ");
      insert.append("NUM_HIST, ");
      values.append("(SELECT NVL(MAX(NUM_HIST),-1)+1 FROM CCC_HISTO_MOVIM_CC WHERE MVCC_OID_MOVI_CC = "+oidCuentaCorriente.toString()+"), ");
      insert.append("VAL_REFE_NUME_DOCU_EXTE, ");
      values.append("VAL_REFE_NUME_DOCU_EXTE, ");
      insert.append("FEC_MOVI, ");
      values.append("FEC_ULTI_MOVI, ");
      insert.append("FEC_VENC, ");
      values.append("TRUNC(FEC_VENC), ");
      insert.append("FEC_VALO, ");
      values.append("TRUNC(FEC_VALO), ");
      insert.append("IMP, ");
      values.append("IMP_MOVI, ");
      insert.append("IMP_PAGA, ");
      values.append("IMP_PAGA, ");
      insert.append("IMP_PEN, ");
      values.append("IMP_PEND, ");
      insert.append("IMP_DIVI, ");
      values.append("IMP_DIVI, ");
      insert.append("IMP_PAGA_DIVI, ");
      values.append("IMP_PAGA_DIVI, ");
      insert.append("VAL_ULTI_DOCU_MES_SERI, ");
      values.append("VAL_ULTI_DOCU_MES_SERI, ");
      insert.append("VAL_ULTI_DOCU_ANIO, ");
      values.append("VAL_ULTI_DOCU_ANIO, ");
      insert.append("VAL_ULTI_DOCU_NUME, ");
      values.append("VAL_ULTI_DOCU_NUME, ");
      insert.append("VAL_NUME_LOTE_CONT, ");
      values.append("VAL_NUME_LOTE_CONT, ");
      insert.append("FEC_CONT, ");
      values.append("TRUNC(FEC_CONTA), ");
      insert.append("VAL_OBSE, ");
      values.append("VAL_OBSE, ");
      insert.append("CUCO_OID_CUEN_CONT, ");
      values.append("CUCO_OID_CUEN_CONT_CUOT, ");
      insert.append("TICL_OID_TIPO_CLIE, ");
      values.append("TICL_OID_TIPO_CLIE, ");
      insert.append("MASI_OID_MARC_SITU, ");
      values.append("MASI_OID_MARC_SITU, ");
      insert.append("MONE_OID_MONE, ");
      values.append("MONE_OID_MONE, ");
      insert.append("MPAB_OID_MEDI_PAGO_TEOR, ");
      values.append("MPAB_OID_MEDI_PAGO, ");
      insert.append("CLIE_OID_CLIE, ");
      values.append("CLIE_OID_CLIE, ");
      insert.append("VAL_TIPO_CAMB, ");
      values.append("IND_TIPO_CAMB, ");
      insert.append("COD_USUA, ");
      values.append("COD_USUA, ");
      insert.append("IMP_PAGO, ");
      values.append("IMP_PAGO, ");
      insert.append("IMP_MOVI, ");
      values.append("IMP_MOVI_CUEN, ");
      insert.append("IMP_MOVI_DIVI, ");
      values.append("IMP_MOVI_DIVI, ");
      insert.append("MVCC_OID_MOVI_CC, ");
      values.append("OID_MOVI_CC, ");
      insert.append("FEC_DOCU, ");
      values.append("FEC_DOCU, ");
      insert.append("IND_DESC_CARG_APLI) ");
      values.append("IND_DTO_CARG_APLI ");
      values.append("FROM CCC_MOVIM_CUENT_CORRI WHERE OID_MOVI_CC = "+oidCuentaCorriente.toString());
      insert.append(values);
      insert.append(";UPDATE CCC_MOVIM_CUENT_CORRI SET VAL_ULTI_NUME_HIST=");
      insert.append("(SELECT NVL(MAX(NUM_HIST),0)+1 FROM CCC_HISTO_MOVIM_CC WHERE MVCC_OID_MOVI_CC = ");
      insert.append(oidCuentaCorriente.toString());
      insert.append(") WHERE OID_MOVI_CC = ");
      insert.append(oidCuentaCorriente.toString()+";");
      UtilidadesLog.info("HelperHistorial.obtenerHistoriaCuentasCorrientes(Long oidCuentaCorriente) Salida");
      return insert;
   }
}