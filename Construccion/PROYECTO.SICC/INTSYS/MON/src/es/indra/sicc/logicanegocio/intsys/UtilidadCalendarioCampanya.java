package es.indra.sicc.logicanegocio.intsys;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilidadCalendarioCampanya  {
    public UtilidadCalendarioCampanya() {
    }
    
    public static String obtenerTrimestre(Date fecha){
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerTrimestre(): Entrada");
        
        SimpleDateFormat sdfMES = new SimpleDateFormat("MM");
        SimpleDateFormat sdfANIO = new SimpleDateFormat("yyyy");
        //java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        String mes = sdfMES.format(fecha);   
        //String anio = sdfANIO.format(fecha);  
        /*        
         * Modificacion segun inc.20363
           Si trimestre=1 retorna  " I" 
           Si trimestre=2 retorna " II" 
           Si trimestre=3 retorna  " III" 
           Si trimestre=4 retorna  " IV" 
        */
        
        //modificado por la incidencia 20363
        //Modificado por Inc 20082
        if ((Integer.parseInt(mes) >0)&&(Integer.parseInt(mes) <4)) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerTrimestre(): Salida");
            return new String("1");
        }
            
        if ((Integer.parseInt(mes) >3)&&(Integer.parseInt(mes) <7)) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerTrimestre(): Salida");
            return new String("2");
        }
            
        if ((Integer.parseInt(mes) >6)&&(Integer.parseInt(mes) <10)) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerTrimestre(): Salida");
            return new String("3");
        }
            
        if ((Integer.parseInt(mes) >9)&&(Integer.parseInt(mes) <13)) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerTrimestre(): Salida");
            return new String("4");
        }
            
        
        
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerTrimestre(): Salida");
        return ("");
    }

    public static String obtenerSemestre (Date fecha){
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerSemestre(Date fecha): Entrada");
        SimpleDateFormat sdfMES = new SimpleDateFormat("MM");
        SimpleDateFormat sdfANIO = new SimpleDateFormat("yyyy");
        //java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        String mes = sdfMES.format(fecha);   
        //String anio = sdfANIO.format(fecha);   

        /* Modificacion segun inc.20363
           Si semestre=1 retorna  " I" 
           Si semestre=2 retorna " II"        
        */
        //Modificado por Inc 20082
        if ((Integer.parseInt(mes) >0)&&(Integer.parseInt(mes) <7)) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerSemestre(Date fecha): Salida");
            return new String("1");
        }            
        //Modificado por Inc 20082            
        if ((Integer.parseInt(mes) >6)&&(Integer.parseInt(mes) <13)) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerSemestre(Date fecha): Salida");
            return new String("2");
        }
            
       
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerSemestre(Date fecha): Salida");
        return ("");
    }
    public static String obtenerDiaSemana (Date fecha){
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerDiaSemana(Date fecha): Entrada");
        UtilidadesLog.debug("Salida obtenerDiaSemana");
        SimpleDateFormat sdfDIASEMANA = new SimpleDateFormat("EEEEEEEEE");
        
        /* Esta mal porque toma el nro de la semana. 
        SimpleDateFormat sdfDIASEMANA = new SimpleDateFormat("FF");
        
        String diaSemana = sdfDIASEMANA.format(fecha);   
        //String diaSem = new String(diaSemana.substring(0,1).toUpperCase()+diaSemana.substring(1));
        
        //int dia = Integer.parseInt(diaSemana.substring(0,1));
        int dia = Integer.parseInt(diaSemana);
        
        switch (dia){
            case 0: return ("Lunes");
            case 1: return ("Martes");
            case 2: return ("Miercoles");
            case 3: return ("Jueves");
            case 4: return ("Viernes");
            case 5: return ("Sabado");
            case 6: return ("Domingo");
        }*/
        String diaSemana = sdfDIASEMANA.format(fecha).substring(0,2);
        if( diaSemana.equalsIgnoreCase("Mo") ){ // Monday
            return "Lunes";
        } else if( diaSemana.equalsIgnoreCase("Tu") ){ // Tuesday
            return "Martes";
        } else if( diaSemana.equalsIgnoreCase("We") ){ // Wendsday
            return "Miercoles";
        } else if( diaSemana.equalsIgnoreCase("Th") ){ // Thursday
            return "Jueves";
        } else if( diaSemana.equalsIgnoreCase("Fr") ){ // Friday
            return "Viernes";
        } else if( diaSemana.equalsIgnoreCase("Sa") ){ // Saturday
            return "Sabado";
        } else if( diaSemana.equalsIgnoreCase("Su") ){ // Sunday
            return "Domingo";
        } 
        
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerDiaSemana(Date fecha): Salida");
        //return (diaSem);
        //return ("");
        return sdfDIASEMANA.format(fecha);
    }
    public static String obtenerEstacion (Date fecha){
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerEstacion((Date fecha): Entrada");
        /*
        Si Fecha >=23/09 and Fecha <=21/12 entonces retorna "Primavera"
        Si Fecha >=22/12 and Fecha <=20/03 entonces retorna "Verano" 
        Si Fecha >=21/03 and Fecha <=21/06 entonces retorna "Otoño" 
        Si Fecha >=22/06 and Fecha <=22/09 entonces retorna "Invierno" 
        */
        
        Calendar calAuxIni = Calendar.getInstance();
        Calendar calAuxFin = Calendar.getInstance();
        
        Calendar calFecha = Calendar.getInstance();
        calFecha.setTime(fecha);
        
        calAuxIni.set(calAuxIni.YEAR,calFecha.get(calFecha.YEAR));
        calAuxFin.set(calAuxFin.YEAR,calFecha.get(calFecha.YEAR));
        
        //Primavera
        calAuxIni.set(calAuxIni.MONTH,8);
        calAuxIni.set(calAuxIni.DAY_OF_MONTH,23);

        calAuxFin.set(calAuxFin.MONTH,11);
        calAuxFin.set(calAuxFin.DAY_OF_MONTH,21);

        if ((calFecha.after(calAuxIni) && calFecha.before(calAuxFin)) || (calFecha.get(Calendar.DAY_OF_MONTH) == calAuxIni.get(Calendar.DAY_OF_MONTH) && calFecha.get(Calendar.MONTH) == calAuxIni.get(Calendar.MONTH) )) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerEstacion((Date fecha): Salida");
            return ("Primavera");
        }
            

        //Otoño
        calAuxIni.set(calAuxIni.MONTH,2);
        calAuxIni.set(calAuxIni.DAY_OF_MONTH,21);

        calAuxFin.set(calAuxFin.MONTH,5);
        calAuxFin.set(calAuxFin.DAY_OF_MONTH,21);

        if ((calFecha.after(calAuxIni) && calFecha.before(calAuxFin)) || (calFecha.get(Calendar.DAY_OF_MONTH) == calAuxIni.get(Calendar.DAY_OF_MONTH) && calFecha.get(Calendar.MONTH) == calAuxIni.get(Calendar.MONTH) )) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerEstacion((Date fecha): Salida");
            return ("Otoño");            
        }


        //Invierno
        calAuxIni.set(calAuxIni.MONTH,5);
        calAuxIni.set(calAuxIni.DAY_OF_MONTH,22);

        calAuxFin.set(calAuxFin.MONTH,8);
        calAuxFin.set(calAuxFin.DAY_OF_MONTH,22);

        if ((calFecha.after(calAuxIni) && calFecha.before(calAuxFin)) || (calFecha.get(Calendar.DAY_OF_MONTH) == calAuxIni.get(Calendar.DAY_OF_MONTH) && calFecha.get(Calendar.MONTH) == calAuxIni.get(Calendar.MONTH) )) 
        {   
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerEstacion((Date fecha): Salida");
            return ("Invierno");
        }
            

        
        //Verano
        calAuxIni.set(calAuxIni.MONTH,11);
        calAuxIni.set(calAuxIni.DAY_OF_MONTH,22);

        calAuxFin.set(calAuxFin.MONTH,2);
        calAuxFin.set(calAuxFin.DAY_OF_MONTH,20);
        
        if(calFecha.get(calFecha.MONTH) == 11)
            calAuxFin.add(calAuxFin.YEAR,1);
        else{
            if(calFecha.get(calFecha.MONTH) <= 3)
                calAuxIni.add(calAuxIni.YEAR,-1);
        }

        if ((calFecha.after(calAuxIni) && calFecha.before(calAuxFin)) || (calFecha.get(Calendar.DAY_OF_MONTH) == calAuxIni.get(Calendar.DAY_OF_MONTH) && calFecha.get(Calendar.MONTH) == calAuxIni.get(Calendar.MONTH) )) 
        {
            UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerEstacion((Date fecha): Salida");
            return ("Verano");
        }
            

        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerEstacion((Date fecha): Salida");
        return "";
    }
    public static String obtenerMes (Date fecha){
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerMes(Date fecha): Entrada");
        SimpleDateFormat sdfDIASEMANA = new SimpleDateFormat("MM");

        //java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        String mes = sdfDIASEMANA.format(fecha);   
        
        int numeroMes = Integer.parseInt(mes);
        
        switch (numeroMes){
            case 1: return ("Enero");
            case 2: return ("Febrero");
            case 3: return ("Marzo");
            case 4: return ("Abril");
            case 5: return ("Mayo");
            case 6: return ("Junio");
            case 7: return ("Julio");
            case 8: return ("Agosto");
            case 9: return ("Septiembre");
            case 10: return ("Octubre");
            case 11: return ("Noviembre");
            case 12: return ("Diciembre");
        }
       
       UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerMes(Date fecha): Salida");
        return ("");        
    }
    public static Integer obtenerNumeroSemana (Date fecha){    
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerNumeroSemana(Date fecha): Entrada");
        SimpleDateFormat sdfNUMERO = new SimpleDateFormat("w");

        //java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        String diaSemana = sdfNUMERO.format(fecha);  
        
        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerNumeroSemana(Date fecha): Salida");
        return new Integer(diaSemana);
    }
    
   /* public static void main(String args[]){
        UtilidadCalendarioCampanya ut = new UtilidadCalendarioCampanya();
        UtilidadesLog.debug(ut.obtenerSemestre(new Date()));
        UtilidadesLog.debug(ut.obtenerTrimestre(new Date()));
        UtilidadesLog.debug(ut.obtenerNumeroSemana(new Date()));
        UtilidadesLog.debug(ut.obtenerMes(new Date()));
        UtilidadesLog.debug(ut.obtenerEstacion(new Date()));
        UtilidadesLog.debug(ut.obtenerDiaSemana(new Date()));
    }*/

// Metodo obtenerPeriodoAnio creado segun incidencia BELC300021442
    public static String obtenerPeriodoAnio (String codPeri){

        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerPeriodoAnio(String codPeri=" + codPeri +" ): Entrada");

        String anio = codPeri.substring(0,4);   
        String aux = codPeri.substring(4);
        String campania = new String("");

        if ((Integer.parseInt(aux) >=1) && (Integer.parseInt(aux) <=6)) 
        {
            campania = "I";
        }            
        if ((Integer.parseInt(aux) >=7) && (Integer.parseInt(aux) <=12)) 
        {
            campania = "II";
        }            
        if ((Integer.parseInt(aux) >=13) && (Integer.parseInt(aux) <=18)) 
        {
            campania = "III";
        }            

        UtilidadesLog.info("UtilidadCalendarioCampanya.obtenerPeriodoAnio(String codPeri): Salida=" + anio + " " + campania );
        return anio + " " + campania;
    }

    
}