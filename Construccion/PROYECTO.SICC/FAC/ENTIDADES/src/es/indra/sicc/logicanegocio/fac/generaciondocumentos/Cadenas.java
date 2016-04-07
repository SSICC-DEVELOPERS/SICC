package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;


public class Cadenas
{
    public final static int AL_IZQ = 0;
    public final static int AL_DER = 1;
    
    public Cadenas()
    {
    }

    /**
     * Devuelve las posiciones de una cadena ocupadas por un carácter
     * @param cadena
     * @param car
     * @return ArrayList
     */
    public static ArrayList obtenerPosicionesCaracter(String cadena, char car)
    {
        ArrayList aPos = new ArrayList();
        for (int i = 0; i < cadena.length(); i++)
        {
            if (cadena.charAt(i) == car)
            {
                aPos.add(new Integer(i));
            }
        }
        return aPos;
    }

    public static ArrayList obtenerPosicionesCaracter(String cadena, char car1, char car2)
    {
        ArrayList aPos = new ArrayList();
        for (int i = 0; i < cadena.length(); i++)
        {
            if (cadena.charAt(i) == car1 || cadena.charAt(i)== car2)
            {
                aPos.add(new Integer(i));
            }
        }
        return aPos;
    }


    /**
     * Extrae la información de una cadena, cuyos campos están separados por el caracter '|'
     * @param sInfoDato
     * @return ArrayList
     */
    public static ArrayList extraerInfoDato(String sInfoDato, String separador)
    {
        StringTokenizer st = new StringTokenizer(sInfoDato, separador);
        String sDato = "";
        ArrayList aInfoDato = new ArrayList();
        while (st.hasMoreElements())
        {
            aInfoDato.add(st.nextToken());
        }
        return aInfoDato;
    }

    /**
     * Completa una cadena con blancos por la derecha
     * @param cadena
     * @param iLongMax
     * @param iAlineacion
     * @return String
     */
    public static String completarBlancos(String cadena, int iLongMax, int iAlineacion)
    {
        String sRespuesta = cadena;
        for (int i = cadena.length(); i < iLongMax; i++)
        {
            sRespuesta = agregarBlanco(sRespuesta, iAlineacion);
        }
        return sRespuesta;
    }

    /**
     * Agrega un carácter en blanco por la derecha a la cadena 
     * @param cadena
     * @param iAlineacion
     * @return String
     */
    public static String agregarBlanco(String cadena, int iAlineacion)
    {
        String sRespuesta = cadena;
        char cBlanco = ' ';
        sRespuesta = agregarCaracter(sRespuesta, iAlineacion, cBlanco);
        return sRespuesta;
    }

    /**
     * Agrega un carácter a una cadena por el lado que marque la alineación
     * iAlineacion = 0 (Izquierda), alineación = 1 (Derecha)
     * @param cadena
     * @param iAlineacion
     * @param car
     * @return String
     */
    public static String agregarCaracter(String cadena, int iAlineacion, char car)
    {
        String sRespuesta = cadena;
        String sCaracter = "" + car;
        if (iAlineacion == AL_IZQ)
        {
            sRespuesta += sCaracter;
        }
        else if (iAlineacion == AL_DER)
        {
            sRespuesta = sCaracter + sRespuesta;
        }
        return sRespuesta;
    }

    /**
     * Devuelve un número leído en forma de cadena
     * @param numero
     * @return String
     */
    public static String numberToString(BigDecimal numero)
    {
        return "Cino mil Seiscientos Treinta y cuatro";
    }

    // Modificado por la BELC300019433
    public static String[] dividirCadena(String cadena, int iLongMax) {
        /*
         * Si han llamado a esta función, quiere decir que cadena tiene una
         * longitud superior a iLongMax. Debemos separar cadena en dos cadenas.
         * La primera empezará en 0, e irá hasta el anterior espacio en blanco
         * a la posición iLongMax que nos encontramos. La segunda será desde ese
         * punto hasta el final
         */ 
         int breakPoint = cadena.lastIndexOf(' ', iLongMax);
         String[] split = new String[2];
         
         // Si no hemos encontrado por dónde partir, lo hacemos por la longitud máxima.
         if(breakPoint == -1) {
             split[0] = cadena.substring(0, iLongMax-1);
             split[1] = cadena.substring(iLongMax-1, cadena.length());
         } else {
             // El espacio se pierde. Si hay un salto de línea, no es necesario.
             split[0] = cadena.substring(0, breakPoint);
             split[1] = cadena.substring(breakPoint+1, cadena.length());
         }
         return split;
    }
}