package es.indra.sicc.cra.util;
import java.sql.Date;

public class Utilites {
    private Utilites() {
    }

    /**
     * Devuelta la cantidad de dias que hay entre endDate y beginDate.
     */
    public static long diffDays(java.sql.Date beginDate, java.sql.Date endDate) {
        long dias = (long) (endDate.getTime() -
            beginDate.getTime());

        //segundos
        dias = dias / 1000L;

        //minutos
        dias = dias / 60L;

        //horas
        dias = dias / 60L;

        //dias
        dias = dias / 24L;

        return dias;
    }
}
