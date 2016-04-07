package es.indra.sicc.logicanegocio.intsys;
import es.indra.sicc.dtos.intsys.DTOINTCampaniaAnio;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TiemposCampanya  {

    private ArrayList campanyas;

    public TiemposCampanya() {
    }
    
    public ArrayList generarTiempoCampanya(Date fechaInicio, String codCanal, String codPeriodoOrigen, String anyoPeriodoCorporativo, Date fechaFin){
        UtilidadesLog.info("TiemposCampanya.generarTiempoCampanya(Date fechaInicio, String codCanal, String codPeriodoOrigen, String anyoPeriodoCorporativo): Entrada");
        ArrayList listaDias = new ArrayList();
        RegistroDiaCampanya registroDia = null;
        ArrayList periodos = null;
        DTOINTCampaniaAnio periodo = null;
        
        Calendar inicio = Calendar.getInstance();
        inicio.setTimeInMillis(fechaInicio.getTime());
        Calendar fin = Calendar.getInstance();
        fin.setTimeInMillis(fechaFin.getTime()); 
        fin.add(Calendar.DATE,1);

        while(inicio.before(fin)){
            periodos = obtenerDatosCampanya(new Date(inicio.getTimeInMillis()));
            
            /* gPineda - 02/02/2007 - INT-DATPRD5
            for(int i=0;i<periodos.size();i++){
                periodo = (DTOINTCampaniaAnio) periodos.get(i);*/
            if( periodos.size() > 0 ){
                periodo = (DTOINTCampaniaAnio) periodos.get(0);
                // public         RegistroDiaCampanya(Date fechaDia,String codCanalOrigen,String codPeriodoOrigen,String anyoPeriodoCorporativo, String codPeriodoFecha, Date inicioPeriodo,   Date finPeriodo
                registroDia = new RegistroDiaCampanya(inicio.getTime(),codCanal,codPeriodoOrigen, anyoPeriodoCorporativo,periodo.getCodigoPeriodo(),periodo.getInicioPeriodo(),periodo.getFinPeriodo());
                
                listaDias.add(registroDia);}
            //}
            inicio.add(Calendar.DATE,1);
        }

        UtilidadesLog.info("TiemposCampanya.generarTiempoCampanya(Date fechaInicio, String codCanal, String codPeriodoOrigen, String anyoPeriodoCorporativo): Salida");

        return listaDias;
    }
    
    private ArrayList obtenerDatosCampanya (Date fecha){
        UtilidadesLog.info("TiemposCampanya.obtenerDatosCampanya(Date fecha): Entrada");
        
        ArrayList listaPeriodos = new ArrayList();
        DTOINTCampaniaAnio datosCampanya = null;
        DTOINTCampaniaAnio periodo = null;
        for(int i=0;i<campanyas.size();i++){
            periodo = (DTOINTCampaniaAnio) campanyas.get(i);
            if((fecha.compareTo(periodo.getFechaInicio()) >= 0) && (fecha.compareTo(periodo.getFechaFin()) <= 0)){
                datosCampanya = new DTOINTCampaniaAnio();
                datosCampanya.setCodigoPeriodo(periodo.getCodigoPeriodo());
                
                if(fecha.compareTo(periodo.getFechaInicio()) == 0)
                    datosCampanya.setInicioPeriodo(Boolean.TRUE);                
                else
                    datosCampanya.setInicioPeriodo(Boolean.FALSE);

                if(fecha.compareTo(periodo.getFechaFin()) == 0)
                    datosCampanya.setFinPeriodo(Boolean.TRUE) ;
                else
                    datosCampanya.setFinPeriodo(Boolean.FALSE) ;

                listaPeriodos.add(datosCampanya);
            }
        }
        
        UtilidadesLog.info("TiemposCampanya.obtenerDatosCampanya(Date fecha): Salida");
        return listaPeriodos;
    }

    public ArrayList getCampanyas() {
        return campanyas;
    }

    public void setCampanyas(ArrayList campanyas) {
        this.campanyas = campanyas;
    }
    
    public static void main(String[] args){
       TiemposCampanya tiempos = new TiemposCampanya();
       ArrayList lista = new ArrayList();
       
       DTOINTCampaniaAnio campania1 = new DTOINTCampaniaAnio();
       campania1.setCodigoPeriodo("Codigo1");
       campania1.setFechaInicio(new Date());
       Calendar calendar = Calendar.getInstance();
       calendar.add(Calendar.MONTH,6);
       campania1.setFechaFin(calendar.getTime());
       lista.add(campania1);
       
       DTOINTCampaniaAnio campania2 = new DTOINTCampaniaAnio();
       campania2.setCodigoPeriodo("Codigo1");
       campania2.setFechaInicio(new Date());
       calendar.add(Calendar.MONTH,2);
       campania2.setFechaFin(calendar.getTime());
       lista.add(campania2);
       tiempos.setCampanyas(lista);
       
        ArrayList listaRslt = tiempos.generarTiempoCampanya(new Date(),"1","1","1", new Date());
        UtilidadesLog.debug(listaRslt);       
    }
    
}