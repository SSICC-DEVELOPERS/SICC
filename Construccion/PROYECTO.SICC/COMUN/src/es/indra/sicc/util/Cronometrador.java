package es.indra.sicc.util;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import java.util.Date;
import java.util.Hashtable;

public class Cronometrador 
{
    public Cronometrador(){
    }
    
    private static Hashtable metodos = new Hashtable();
    
    public static void startTransaction (String metodo){
        if (!init){
            init();
        }
        if (cronometrar){
            if (!metodos.containsKey(metodo)){
                metodos.put(metodo, new Long(System.currentTimeMillis()) );
            }else{
                UtilidadesLog.warn("ya fue insertado: "+metodo);
            }
        }
    }
    
    public static void startTransaction (String metodo, String thread){
        if (!init){
            init();
        }
        if (cronometrar){
            if (!metodos.containsKey((metodo+thread))){
                metodos.put(metodo+thread, new Long(System.currentTimeMillis()) );
            }else{
                UtilidadesLog.warn("ya fue insertado: "+(metodo+thread));
            }
        }
    }
    
    public static void endTransaction (String metodo){
        if (cronometrar){
            if (metodos.containsKey(metodo)){
                long time1 = ((Long)metodos.get(metodo)).longValue();
                long time2 = System.currentTimeMillis();
                UtilidadesLog.warn("Metodo: "+metodo+" ->>> "+(time2-time1));
                metodos.remove(metodo);
            }else{
                UtilidadesLog.warn("error, el metodo no se le aplico el startTransation: "+metodo);
            }
        }
    }
    
    private static void init(){
        init = true;
        try{
            MareMGC mgc = new MareMGC();
            mgc = (MareMGC) MareMii.getService(new MareTopic("Configuration"));
            String cronometrador = (String) mgc.getProperty("application/cronometrar");  
            if (cronometrador.equals("SI")){
                cronometrar = true;
            }            
        }catch(Exception e){
            cronometrar = false;
        }
    }
    
    public static void endTransaction (String metodo, long minTime){
        if (cronometrar){
            if (metodos.containsKey(metodo)){
                long time1 = ((Long)metodos.get(metodo)).longValue();
                long time2 = System.currentTimeMillis();
                long total = time2-time1;
                if (total>minTime){
                    UtilidadesLog.warn("Metodo: "+metodo+" ->>> "+total);
                }
                metodos.remove(metodo);
            }else{
                UtilidadesLog.warn("error, el metodo no se le aplico el startTransation: "+metodo);
            }
        }
    }
    
    public static void endTransaction (String metodo, String thread, long minTime){
        if (cronometrar){
            if (metodos.containsKey((metodo+thread))){
                long time1 = ((Long)metodos.get((metodo+thread))).longValue();
                long time2 = System.currentTimeMillis();
                long total = time2-time1;
                if (total>minTime){
                    UtilidadesLog.warn("Metodo: "+(metodo+thread)+" ->>> "+total);
                }
                metodos.remove((metodo+thread));
            }else{
                UtilidadesLog.warn("error, el metodo no se le aplico el startTransation: "+(metodo+thread));
            }
        }
    }
    
    public static void endTransaction (String metodo, String thread){
        if (cronometrar){
            if (metodos.containsKey((metodo+thread))){
                long time1 = ((Long)metodos.get((metodo+thread))).longValue();
                long time2 = System.currentTimeMillis();
                UtilidadesLog.warn("Metodo: "+(metodo+thread)+" ->>> "+(time2-time1));
                metodos.remove((metodo+thread));
            }else{
                UtilidadesLog.warn("error, el metodo no se le aplico el startTransation: "+(metodo+thread));
            }
        }
    }
    
    
    private static boolean init = false;
    private static boolean cronometrar = false;
}