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
/** Metodo construido por Diseño Técnico */

package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.dtos.msg.DTOImpresion;

public class Parseador {

	private static Parseador parseador = null;
    private Parseador() {
	}
    
    public static Parseador getInstance(){
        if (parseador == null){
            parseador = new Parseador();
        }
        return parseador;
    }

    public String sustituirEtiquetasVariables(String texto, DTOImpresion datos){    
        StringBuffer salida=new StringBuffer("");
        StringBuffer textoEtiqueta = null;//new StringBuffer("");
        int valor;
        int inicio;
        int fin;
        int i=0;
        boolean finalizar=false;
        char [] textoChar = texto.toCharArray();
        char caracter;  
        while (i<texto.length()){
            caracter=textoChar[i]; 
            inicio=i;
            if(caracter=='<'){
                textoEtiqueta= new StringBuffer(String.valueOf(caracter));
                i++;
                finalizar=false;
                while (!finalizar){
                    caracter=textoChar[i];
                    textoEtiqueta.append(caracter);
                    if(caracter=='>'){
                        fin=i;
                        finalizar=true;
                    }
                    i++;
                }
                //UtilidadesLog.debug("ETIQUETA:"+textoEtiqueta);
                if(textoEtiqueta.toString().endsWith("01>")||textoEtiqueta.toString().endsWith("02>")||textoEtiqueta.toString().endsWith("03>")||
                textoEtiqueta.toString().endsWith("04>")||textoEtiqueta.toString().endsWith("05>")||textoEtiqueta.toString().endsWith("06>")||
                textoEtiqueta.toString().endsWith("07>")||textoEtiqueta.toString().endsWith("08>")||textoEtiqueta.toString().endsWith("09>")||
                textoEtiqueta.toString().endsWith("10>")||textoEtiqueta.toString().endsWith("11>")||textoEtiqueta.toString().endsWith("12>")||
                textoEtiqueta.toString().endsWith("13>")||textoEtiqueta.toString().endsWith("14>")||textoEtiqueta.toString().endsWith("15>")||
                textoEtiqueta.toString().endsWith("16>")||textoEtiqueta.toString().endsWith("17>")||textoEtiqueta.toString().endsWith("18>")||
                textoEtiqueta.toString().endsWith("19>")||textoEtiqueta.toString().endsWith("20>")){
                    //UtilidadesLog.debug("He localizado una etiqueta valida");
                    //UtilidadesLog.debug("SUBSTRING:"+textoEtiqueta.substring(textoEtiqueta.length()-3,textoEtiqueta.length()-1));
                    valor= Integer.parseInt(textoEtiqueta.substring(textoEtiqueta.length()-3,textoEtiqueta.length()-1));
                    switch (valor){
                        case 1 :
                            if (datos.getDatoVariable1()!=null){
                                salida.append(datos.getDatoVariable1());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 2 :
                            if (datos.getDatoVariable2()!=null){
                                salida.append(datos.getDatoVariable2());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 3 :
                            if (datos.getDatoVariable3()!=null){
                                salida.append(datos.getDatoVariable3());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 4 :
                            if (datos.getDatoVariable4()!=null){
                                salida.append(datos.getDatoVariable4());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 5 :
                            if (datos.getDatoVariable5()!=null){
                                salida.append(datos.getDatoVariable5());
                            }else{
                                salida.append("");
                            }
                            break; 
                        case 6 :
                            if (datos.getDatoVariable6()!=null){
                                salida.append(datos.getDatoVariable6());
                            }else{
                                salida.append("");
                            }
                            break; 
                        case 7 :
                            if (datos.getDatoVariable7()!=null){
                                salida.append(datos.getDatoVariable7());
                            }else{
                                salida.append("");
                            }
                            break; 
                        case 8 :
                            if (datos.getDatoVariable8()!=null){
                                salida.append(datos.getDatoVariable8());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 9 :
                            if (datos.getDatoVariable9()!=null){
                                salida.append(datos.getDatoVariable9());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 10 :
                            if (datos.getDatoVariable10()!=null){
                                salida.append(datos.getDatoVariable10());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 11 :
                            if (datos.getDatoVariable11()!=null){
                                salida.append(datos.getDatoVariable11());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 12 :
                            if (datos.getDatoVariable12()!=null){
                                salida.append(datos.getDatoVariable12());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 13 :
                            if (datos.getDatoVariable13()!=null){
                                salida.append(datos.getDatoVariable13());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 14 :
                            if (datos.getDatoVariable14()!=null){
                                salida.append(datos.getDatoVariable14());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 15 :
                            if (datos.getDatoVariable15()!=null){
                                salida.append(datos.getDatoVariable15());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 16 :
                            if (datos.getDatoVariable16()!=null){
                                salida.append(datos.getDatoVariable16());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 17 :
                            if (datos.getDatoVariable17()!=null){
                                salida.append(datos.getDatoVariable17());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 18 :
                            if (datos.getDatoVariable18()!=null){
                                salida.append(datos.getDatoVariable18());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 19 :
                            if (datos.getDatoVariable19()!=null){
                                salida.append(datos.getDatoVariable19());
                            }else{
                                salida.append("");
                            }
                            break;
                        case 20 :
                            if (datos.getDatoVariable20()!=null){
                                salida.append(datos.getDatoVariable20());
                            }else{
                                salida.append("");
                            }
                            break;
                    }
                }else{
                    salida.append(textoEtiqueta);
                }
            }else{
                salida.append(caracter);
                i++;
            }
        }
        //UtilidadesLog.debug("SALIDA:"+salida);  
        return salida.toString();
    }
}