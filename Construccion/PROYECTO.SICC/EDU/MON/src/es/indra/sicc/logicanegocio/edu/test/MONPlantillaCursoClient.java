package es.indra.sicc.logicanegocio.edu;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.edu.MONPlantillaCurso;
import es.indra.sicc.logicanegocio.edu.MONPlantillaCursoHome;
import es.indra.sicc.dtos.edu.DTOPlantillaCurso;
import es.indra.sicc.dtos.edu.DTODetallePlantillaCurso;
import es.indra.sicc.dtos.edu.DTOParametro;
import es.indra.sicc.dtos.edu.DTOCargaCursos;

import java.util.ArrayList;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

import javax.naming.NamingException;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import java.util.Hashtable;
import es.indra.sicc.util.UtilidadesLog;

public class MONPlantillaCursoClient 
{


    public static void main(String [] args)
    {
        try 
        {
            /*Para ejecutar las pruebas ir comentando y descomentando los métodos
             * abajo descriptos para ejecutar el que se desea.
             * */
             
             // /* PRUEBA 1 
            //insertaPlantilla();
            //*/ fin PRUEBA 1  
            
            // /* PRUEBA 2
            //obtieneDetallesPlantilla();
            //*/ fin PRUEBA 2
            
            ///*PRUEBA 3
            //eliminaPlantilla();
            //*/ fin PRUEBA 3  
            
            ///*PRUEBA 4
            modificaPlantilla();
            //*/ fin PRUEBA 4
            
        }
        catch(Exception ex)
        {
            System.out.println("salio por error");
            ex.printStackTrace();
        }

    }

    private static void insertaPlantilla() throws Exception{
            Context context = getInitialContext();
            MONPlantillaCursoHome mONPlantillaCursoHome = (MONPlantillaCursoHome)PortableRemoteObject.narrow(context.lookup("MONPlantillaCurso"), MONPlantillaCursoHome.class);
            MONPlantillaCurso mONPlantillaCurso;

            mONPlantillaCurso = mONPlantillaCursoHome.create();
            DTOPlantillaCurso dto = new DTOPlantillaCurso();
            
            //sets
            dto.setOidPais(new Long(1));
            ArrayList arrayList = new ArrayList();
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso = new DTODetallePlantillaCurso();
            
            DTOParametro dtoPara = new DTOParametro();
            dtoPara.setOid(new Long(0));
            dtoDetallePlantillaCurso.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso.setParametro(dtoPara);
            dtoDetallePlantillaCurso.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso1 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara1 = new DTOParametro();
            dtoPara1.setOid(new Long(1));
            dtoDetallePlantillaCurso1.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso1.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso1.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso1.setParametro(dtoPara1);
            dtoDetallePlantillaCurso1.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso1);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso2 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara2 = new DTOParametro();
            dtoPara2.setOid(new Long(2));
            dtoDetallePlantillaCurso2.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso2.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso2.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso2.setParametro(dtoPara2);
            //dtoDetallePlantillaCurso.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso2);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso3 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara3 = new DTOParametro();
            dtoPara3.setOid(new Long(3));
            dtoDetallePlantillaCurso3.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso3.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso3.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso3.setParametro(dtoPara3);
            dtoDetallePlantillaCurso3.setValor(new String("nombre curso --SCS"));
            arrayList.add(dtoDetallePlantillaCurso3);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso4 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara4 = new DTOParametro();
            dtoPara4.setOid(new Long(4));
            dtoDetallePlantillaCurso4.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso4.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso4.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso4.setParametro(dtoPara4);
            dtoDetallePlantillaCurso4.setValor(new String("objetivo curso --SCS"));
            arrayList.add(dtoDetallePlantillaCurso4);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso5 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara5 = new DTOParametro();
            dtoPara5.setOid(new Long(5));
            dtoDetallePlantillaCurso5.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso5.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso5.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso5.setParametro(dtoPara5);
            dtoDetallePlantillaCurso5.setValor(new String("contenido curso --SCS"));
            arrayList.add(dtoDetallePlantillaCurso5);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso6 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara6 = new DTOParametro();
            dtoPara6.setOid(new Long(6));
            dtoDetallePlantillaCurso6.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso6.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso6.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso6.setParametro(dtoPara6);
            dtoDetallePlantillaCurso6.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso6);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso7 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara7 = new DTOParametro(); 
            dtoPara7.setOid(new Long(7));
            dtoDetallePlantillaCurso7.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso7.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso7.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso7.setParametro(dtoPara7);
            dtoDetallePlantillaCurso7.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso7);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso8 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara8 = new DTOParametro();
            dtoPara8.setOid(new Long(9));
            dtoDetallePlantillaCurso8.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso8.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso8.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso8.setParametro(dtoPara8);
            dtoDetallePlantillaCurso8.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso8);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso9 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara9 = new DTOParametro();
            dtoPara9.setOid(new Long(10));
            dtoDetallePlantillaCurso9.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso9.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso9.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso9.setParametro(dtoPara9);
            dtoDetallePlantillaCurso9.setValor(new String("01/01/2006"));
            arrayList.add(dtoDetallePlantillaCurso9);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso10 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara10 = new DTOParametro();
            dtoPara10.setOid(new Long(11)); 
            dtoDetallePlantillaCurso10.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso10.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso10.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso10.setParametro(dtoPara10);
            dtoDetallePlantillaCurso10.setValor(new String("01/01/2006"));
            arrayList.add(dtoDetallePlantillaCurso10);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso11 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara11 = new DTOParametro();
            dtoPara11.setOid(new Long(12));
            dtoDetallePlantillaCurso11.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso11.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso11.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso11.setParametro(dtoPara11);
            dtoDetallePlantillaCurso11.setValor(new String("01/01/2007"));
            arrayList.add(dtoDetallePlantillaCurso11);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso12 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara12 = new DTOParametro();
            dtoPara12.setOid(new Long(13));
            dtoDetallePlantillaCurso12.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso12.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso12.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso12.setParametro(dtoPara12);
            dtoDetallePlantillaCurso12.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso12);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso13 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara13 = new DTOParametro();
            dtoPara13.setOid(new Long(14));
            dtoDetallePlantillaCurso13.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso13.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso13.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso13.setParametro(dtoPara13);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso13);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso14 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara14 = new DTOParametro();
            dtoPara14.setOid(new Long(15));
            dtoDetallePlantillaCurso14.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso14.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso14.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso14.setParametro(dtoPara14);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso14);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso15 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara15 = new DTOParametro();
            dtoPara15.setOid(new Long(16));
            dtoDetallePlantillaCurso15.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso15.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso15.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso15.setParametro(dtoPara15);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso15);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso16 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara16 = new DTOParametro();
            dtoPara16.setOid(new Long(17));
            dtoDetallePlantillaCurso16.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso16.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso16.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso16.setParametro(dtoPara16);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso16);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso17 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara17 = new DTOParametro();
            dtoPara17.setOid(new Long(18));
            dtoDetallePlantillaCurso17.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso17.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso17.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso17.setParametro(dtoPara17);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso17);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso18 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara18 = new DTOParametro();
            dtoPara18.setOid(new Long(19));
            dtoDetallePlantillaCurso18.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso18.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso18.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso18.setParametro(dtoPara18);
            dtoDetallePlantillaCurso18.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso18);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso19 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara19 = new DTOParametro();
            dtoPara19.setOid(new Long(20));
            dtoDetallePlantillaCurso19.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso19.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso19.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso19.setParametro(dtoPara19);
            dtoDetallePlantillaCurso19.setValor(new String("2"));
            arrayList.add(dtoDetallePlantillaCurso19);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso20 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara20 = new DTOParametro();
            dtoPara20.setOid(new Long(21));
            dtoDetallePlantillaCurso20.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso20.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso20.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso20.setParametro(dtoPara20);
            dtoDetallePlantillaCurso20.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso20);            
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso22 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara22 = new DTOParametro();
            dtoPara22.setOid(new Long(22));
            dtoDetallePlantillaCurso22.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso22.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso22.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso22.setParametro(dtoPara22);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso22);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso23 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara23 = new DTOParametro();
            dtoPara23.setOid(new Long(23));
            dtoDetallePlantillaCurso23.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso23.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso23.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso23.setParametro(dtoPara23);
            dtoDetallePlantillaCurso23.setValor(new String("material"));
            arrayList.add(dtoDetallePlantillaCurso23);            
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso24 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara24 = new DTOParametro();
            dtoPara24.setOid(new Long(24));
            dtoDetallePlantillaCurso24.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso24.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso24.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso24.setParametro(dtoPara24);
            dtoDetallePlantillaCurso24.setValor(new String("6"));
            arrayList.add(dtoDetallePlantillaCurso24);            
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso25 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara25 = new DTOParametro();
            dtoPara25.setOid(new Long(25));
            dtoDetallePlantillaCurso25.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso25.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso25.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso25.setParametro(dtoPara25);
            //dtoDetallePlantillaCurso.setValor(new String("6"));
            arrayList.add(dtoDetallePlantillaCurso25);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso26 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara26 = new DTOParametro();
            dtoPara26.setOid(new Long(26));
            dtoDetallePlantillaCurso26.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso26.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso26.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso26.setParametro(dtoPara26);
            //dtoDetallePlantillaCurso.setValor(new String("6"));
            arrayList.add(dtoDetallePlantillaCurso26);      
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso27 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara27 = new DTOParametro();
            dtoPara27.setOid(new Long(27));
            dtoDetallePlantillaCurso27.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso27.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso27.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso27.setParametro(dtoPara27);
            dtoDetallePlantillaCurso27.setValor(new String("2"));
            arrayList.add(dtoDetallePlantillaCurso27);          
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso28 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara28 = new DTOParametro();
            dtoPara28.setOid(new Long(28));
            dtoDetallePlantillaCurso28.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso28.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso28.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso28.setParametro(dtoPara28);
            //dtoDetallePlantillaCurso.setValor(new String("2"));
            arrayList.add(dtoDetallePlantillaCurso28);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso29 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara29 = new DTOParametro();
            dtoPara29.setOid(new Long(29));
            dtoDetallePlantillaCurso29.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso29.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso29.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso29.setParametro(dtoPara29);
            dtoDetallePlantillaCurso29.setValor(new String("15"));
            arrayList.add(dtoDetallePlantillaCurso29);  

            DTODetallePlantillaCurso dtoDetallePlantillaCurso30 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara30 = new DTOParametro();
            dtoPara30.setOid(new Long(30));
            dtoDetallePlantillaCurso30.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso30.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso30.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso30.setParametro(dtoPara30);
            //dtoDetallePlantillaCurso.setValor(new String("15"));
            arrayList.add(dtoDetallePlantillaCurso30);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso31 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara31 = new DTOParametro();
            dtoPara31.setOid(new Long(31));
            dtoDetallePlantillaCurso31.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso31.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso31.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso31.setParametro(dtoPara31);
            //dtoDetallePlantillaCurso.setValor(new String("15"));
            arrayList.add(dtoDetallePlantillaCurso31);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso32 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara32 = new DTOParametro();
            dtoPara32.setOid(new Long(32));
            dtoDetallePlantillaCurso32.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso32.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso32.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso32.setParametro(dtoPara32);
            dtoDetallePlantillaCurso32.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso32);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso33 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara33 = new DTOParametro();
            dtoPara33.setOid(new Long(33));
            dtoDetallePlantillaCurso33.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso33.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso33.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso33.setParametro(dtoPara33);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso33); 
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso34 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara34 = new DTOParametro();
            dtoPara34.setOid(new Long(34));
            dtoDetallePlantillaCurso34.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso34.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso34.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso34.setParametro(dtoPara34);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso34);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso35 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara35 = new DTOParametro();
            dtoPara35.setOid(new Long(35));
            dtoDetallePlantillaCurso35.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso35.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso35.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso35.setParametro(dtoPara35);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso35);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso36 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara36 = new DTOParametro();
            dtoPara36.setOid(new Long(36));
            dtoDetallePlantillaCurso36.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso36.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso36.setObligatorio(new Boolean(false));
            dtoDetallePlantillaCurso36.setParametro(dtoPara36);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso36);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso37 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara37 = new DTOParametro();
            dtoPara37.setOid(new Long(37));
            dtoDetallePlantillaCurso37.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso37.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso37.setObligatorio(new Boolean(false));
            dtoDetallePlantillaCurso37.setParametro(dtoPara37);
            dtoDetallePlantillaCurso37.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso37);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso38 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara38 = new DTOParametro();
            dtoPara38.setOid(new Long(38));
            dtoDetallePlantillaCurso38.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso38.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso38.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso38.setParametro(dtoPara38);
            dtoDetallePlantillaCurso38.setValor(new String("01/01/2005"));
            arrayList.add(dtoDetallePlantillaCurso38);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso39 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara39 = new DTOParametro();
            dtoPara39.setOid(new Long(39));
            dtoDetallePlantillaCurso39.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso39.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso39.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso39.setParametro(dtoPara39);
            dtoDetallePlantillaCurso39.setValor(new String("1002"));
            arrayList.add(dtoDetallePlantillaCurso39);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso40 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara40 = new DTOParametro();
            dtoPara40.setOid(new Long(40));
            dtoDetallePlantillaCurso40.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso40.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso40.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso40.setParametro(dtoPara40);
            dtoDetallePlantillaCurso40.setValor(new String("5"));
            arrayList.add(dtoDetallePlantillaCurso40);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso41 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara41 = new DTOParametro();
            dtoPara41.setOid(new Long(41));
            dtoDetallePlantillaCurso41.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso41.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso41.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso41.setParametro(dtoPara41);
            dtoDetallePlantillaCurso41.setValor(new String("0"));
            arrayList.add(dtoDetallePlantillaCurso41);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso42 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara42 = new DTOParametro();
            dtoPara42.setOid(new Long(42));
            dtoDetallePlantillaCurso42.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso42.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso42.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso42.setParametro(dtoPara42);
            dtoDetallePlantillaCurso42.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso42);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso43 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara43 = new DTOParametro();
            dtoPara43.setOid(new Long(43));
            dtoDetallePlantillaCurso43.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso43.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso43.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso43.setParametro(dtoPara43);
            dtoDetallePlantillaCurso43.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso43);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso44 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara44 = new DTOParametro();
            dtoPara44.setOid(new Long(44));
            dtoDetallePlantillaCurso44.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso44.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso44.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso44.setParametro(dtoPara44);
            dtoDetallePlantillaCurso44.setValor(new String("descripcion detallada--SCS"));
            arrayList.add(dtoDetallePlantillaCurso44);  
            
            DTOI18nSICC[] i18N = new DTOI18nSICC[1];
            
            DTOI18nSICC registro = new DTOI18nSICC();
            registro.setOidIdioma(new Long(1));
            registro.setValorI18n(new String("nombre plantilla curso cabecera"));
            
            i18N[0] = registro;
            
            dto.setAttriTraducible(i18N);
            
            dto.setDetalles(arrayList);
            
            mONPlantillaCurso.insertaPlantilla(dto);
    }

    private static void obtieneDetallesPlantilla() throws Exception{
            Context context = getInitialContext();
            MONPlantillaCursoHome mONPlantillaCursoHome = (MONPlantillaCursoHome)PortableRemoteObject.narrow(context.lookup("MONPlantillaCurso"), MONPlantillaCursoHome.class);
            MONPlantillaCurso mONPlantillaCurso;

            mONPlantillaCurso = mONPlantillaCursoHome.create();
            DTOOID dto = new DTOOID(); 
             
            dto.setOid(new Long(1086));
            dto.setOidIdioma(new Long(1)); 
            dto.setOidPais(new Long(1));
            
            DTOCargaCursos dtoSalida = new DTOCargaCursos();
            dtoSalida = mONPlantillaCurso.obtieneDetallesPlantilla(dto);
            
            UtilidadesLog.debug("resultado de: obtieneDetallesPlantilla.....: " + dtoSalida);
    }

    private static void eliminaPlantilla() throws Exception{
            Context context = getInitialContext();
            MONPlantillaCursoHome mONPlantillaCursoHome = (MONPlantillaCursoHome)PortableRemoteObject.narrow(context.lookup("MONPlantillaCurso"), MONPlantillaCursoHome.class);
            MONPlantillaCurso mONPlantillaCurso;

            mONPlantillaCurso = mONPlantillaCursoHome.create();
            DTOOIDs dto = new DTOOIDs();
            
            Long[] oids = new Long[1];
            oids[0] = new Long(108555);
            dto.setOids(oids);
            mONPlantillaCurso.eliminaPlantilla(dto);
    }
  
        private static void modificaPlantilla() throws Exception{
            Context context = getInitialContext();
            MONPlantillaCursoHome mONPlantillaCursoHome = (MONPlantillaCursoHome)PortableRemoteObject.narrow(context.lookup("MONPlantillaCurso"), MONPlantillaCursoHome.class);
            MONPlantillaCurso mONPlantillaCurso;

            mONPlantillaCurso = mONPlantillaCursoHome.create();
            
            //sets
            DTOPlantillaCurso dto = new DTOPlantillaCurso(); 
            dto.setOidPais(new Long(1));
            dto.setOid(new Long(1086));
            ArrayList arrayList = new ArrayList();
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso = new DTODetallePlantillaCurso();
            
            DTOParametro dtoPara = new DTOParametro();
            dtoPara.setOid(new Long(0));
            dtoDetallePlantillaCurso.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso.setParametro(dtoPara);
            dtoDetallePlantillaCurso.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso1 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara1 = new DTOParametro();
            dtoPara1.setOid(new Long(1));
            dtoDetallePlantillaCurso1.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso1.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso1.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso1.setParametro(dtoPara1);
            dtoDetallePlantillaCurso1.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso1);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso2 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara2 = new DTOParametro();
            dtoPara2.setOid(new Long(2));
            dtoDetallePlantillaCurso2.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso2.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso2.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso2.setParametro(dtoPara2);
            //dtoDetallePlantillaCurso.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso2);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso3 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara3 = new DTOParametro();
            dtoPara3.setOid(new Long(3));
            dtoDetallePlantillaCurso3.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso3.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso3.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso3.setParametro(dtoPara3);
            dtoDetallePlantillaCurso3.setValor(new String("nombre curso --SCS"));
            arrayList.add(dtoDetallePlantillaCurso3);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso4 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara4 = new DTOParametro();
            dtoPara4.setOid(new Long(4));
            dtoDetallePlantillaCurso4.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso4.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso4.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso4.setParametro(dtoPara4);
            dtoDetallePlantillaCurso4.setValor(new String("objetivo curso --SCS"));
            arrayList.add(dtoDetallePlantillaCurso4);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso5 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara5 = new DTOParametro();
            dtoPara5.setOid(new Long(5));
            dtoDetallePlantillaCurso5.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso5.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso5.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso5.setParametro(dtoPara5);
            dtoDetallePlantillaCurso5.setValor(new String("contenido curso --SCS"));
            arrayList.add(dtoDetallePlantillaCurso5);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso6 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara6 = new DTOParametro();
            dtoPara6.setOid(new Long(6));
            dtoDetallePlantillaCurso6.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso6.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso6.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso6.setParametro(dtoPara6);
            dtoDetallePlantillaCurso6.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso6);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso7 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara7 = new DTOParametro(); 
            dtoPara7.setOid(new Long(7));
            dtoDetallePlantillaCurso7.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso7.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso7.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso7.setParametro(dtoPara7);
            dtoDetallePlantillaCurso7.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso7);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso8 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara8 = new DTOParametro();
            dtoPara8.setOid(new Long(9));
            dtoDetallePlantillaCurso8.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso8.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso8.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso8.setParametro(dtoPara8);
            dtoDetallePlantillaCurso8.setValor(new String("1"));
            arrayList.add(dtoDetallePlantillaCurso8);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso9 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara9 = new DTOParametro();
            dtoPara9.setOid(new Long(10));
            dtoDetallePlantillaCurso9.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso9.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso9.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso9.setParametro(dtoPara9);
            dtoDetallePlantillaCurso9.setValor(new String("01/01/2006"));
            arrayList.add(dtoDetallePlantillaCurso9);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso10 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara10 = new DTOParametro();
            dtoPara10.setOid(new Long(11)); 
            dtoDetallePlantillaCurso10.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso10.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso10.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso10.setParametro(dtoPara10);
            dtoDetallePlantillaCurso10.setValor(new String("01/01/2006"));
            arrayList.add(dtoDetallePlantillaCurso10);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso11 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara11 = new DTOParametro();
            dtoPara11.setOid(new Long(12));
            dtoDetallePlantillaCurso11.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso11.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso11.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso11.setParametro(dtoPara11);
            dtoDetallePlantillaCurso11.setValor(new String("01/01/2007"));
            arrayList.add(dtoDetallePlantillaCurso11);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso12 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara12 = new DTOParametro();
            dtoPara12.setOid(new Long(13));
            dtoDetallePlantillaCurso12.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso12.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso12.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso12.setParametro(dtoPara12);
            dtoDetallePlantillaCurso12.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso12);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso13 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara13 = new DTOParametro();
            dtoPara13.setOid(new Long(14));
            dtoDetallePlantillaCurso13.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso13.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso13.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso13.setParametro(dtoPara13);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso13);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso14 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara14 = new DTOParametro();
            dtoPara14.setOid(new Long(15));
            dtoDetallePlantillaCurso14.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso14.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso14.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso14.setParametro(dtoPara14);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso14);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso15 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara15 = new DTOParametro();
            dtoPara15.setOid(new Long(16));
            dtoDetallePlantillaCurso15.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso15.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso15.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso15.setParametro(dtoPara15);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso15);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso16 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara16 = new DTOParametro();
            dtoPara16.setOid(new Long(17));
            dtoDetallePlantillaCurso16.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso16.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso16.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso16.setParametro(dtoPara16);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso16);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso17 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara17 = new DTOParametro();
            dtoPara17.setOid(new Long(18));
            dtoDetallePlantillaCurso17.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso17.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso17.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso17.setParametro(dtoPara17);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso17);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso18 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara18 = new DTOParametro();
            dtoPara18.setOid(new Long(19));
            dtoDetallePlantillaCurso18.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso18.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso18.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso18.setParametro(dtoPara18);
            dtoDetallePlantillaCurso18.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso18);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso19 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara19 = new DTOParametro();
            dtoPara19.setOid(new Long(20));
            dtoDetallePlantillaCurso19.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso19.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso19.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso19.setParametro(dtoPara19);
            dtoDetallePlantillaCurso19.setValor(new String("2"));
            arrayList.add(dtoDetallePlantillaCurso19);
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso20 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara20 = new DTOParametro();
            dtoPara20.setOid(new Long(21));
            dtoDetallePlantillaCurso20.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso20.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso20.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso20.setParametro(dtoPara20);
            dtoDetallePlantillaCurso20.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso20);            
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso22 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara22 = new DTOParametro();
            dtoPara22.setOid(new Long(22));
            dtoDetallePlantillaCurso22.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso22.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso22.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso22.setParametro(dtoPara22);
            //dtoDetallePlantillaCurso.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso22);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso23 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara23 = new DTOParametro();
            dtoPara23.setOid(new Long(23));
            dtoDetallePlantillaCurso23.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso23.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso23.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso23.setParametro(dtoPara23);
            dtoDetallePlantillaCurso23.setValor(new String("material"));
            arrayList.add(dtoDetallePlantillaCurso23);            
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso24 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara24 = new DTOParametro();
            dtoPara24.setOid(new Long(24));
            dtoDetallePlantillaCurso24.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso24.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso24.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso24.setParametro(dtoPara24);
            dtoDetallePlantillaCurso24.setValor(new String("6"));
            arrayList.add(dtoDetallePlantillaCurso24);            
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso25 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara25 = new DTOParametro();
            dtoPara25.setOid(new Long(25));
            dtoDetallePlantillaCurso25.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso25.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso25.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso25.setParametro(dtoPara25);
            //dtoDetallePlantillaCurso.setValor(new String("6"));
            arrayList.add(dtoDetallePlantillaCurso25);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso26 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara26 = new DTOParametro();
            dtoPara26.setOid(new Long(26));
            dtoDetallePlantillaCurso26.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso26.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso26.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso26.setParametro(dtoPara26);
            //dtoDetallePlantillaCurso.setValor(new String("6"));
            arrayList.add(dtoDetallePlantillaCurso26);      
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso27 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara27 = new DTOParametro();
            dtoPara27.setOid(new Long(27));
            dtoDetallePlantillaCurso27.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso27.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso27.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso27.setParametro(dtoPara27);
            dtoDetallePlantillaCurso27.setValor(new String("2"));
            arrayList.add(dtoDetallePlantillaCurso27);          
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso28 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara28 = new DTOParametro();
            dtoPara28.setOid(new Long(28));
            dtoDetallePlantillaCurso28.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso28.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso28.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso28.setParametro(dtoPara28);
            //dtoDetallePlantillaCurso.setValor(new String("2"));
            arrayList.add(dtoDetallePlantillaCurso28);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso29 = new DTODetallePlantillaCurso();
            DTOParametro dtoPara29 = new DTOParametro();
            dtoPara29.setOid(new Long(29));
            dtoDetallePlantillaCurso29.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso29.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso29.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso29.setParametro(dtoPara29);
            dtoDetallePlantillaCurso29.setValor(new String("15"));
            arrayList.add(dtoDetallePlantillaCurso29);  

            DTODetallePlantillaCurso dtoDetallePlantillaCurso30 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara30 = new DTOParametro();
            dtoPara30.setOid(new Long(30));
            dtoDetallePlantillaCurso30.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso30.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso30.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso30.setParametro(dtoPara30);
            //dtoDetallePlantillaCurso.setValor(new String("15"));
            arrayList.add(dtoDetallePlantillaCurso30);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso31 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara31 = new DTOParametro();
            dtoPara31.setOid(new Long(31));
            dtoDetallePlantillaCurso31.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso31.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso31.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso31.setParametro(dtoPara31);
            //dtoDetallePlantillaCurso.setValor(new String("15"));
            arrayList.add(dtoDetallePlantillaCurso31);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso32 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara32 = new DTOParametro();
            dtoPara32.setOid(new Long(32));
            dtoDetallePlantillaCurso32.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso32.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso32.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso32.setParametro(dtoPara32);
            dtoDetallePlantillaCurso32.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso32);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso33 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara33 = new DTOParametro();
            dtoPara33.setOid(new Long(33));
            dtoDetallePlantillaCurso33.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso33.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso33.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso33.setParametro(dtoPara33);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso33); 
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso34 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara34 = new DTOParametro();
            dtoPara34.setOid(new Long(34));
            dtoDetallePlantillaCurso34.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso34.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso34.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso34.setParametro(dtoPara34);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso34);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso35 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara35 = new DTOParametro();
            dtoPara35.setOid(new Long(35));
            dtoDetallePlantillaCurso35.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso35.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso35.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso35.setParametro(dtoPara35);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso35);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso36 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara36 = new DTOParametro();
            dtoPara36.setOid(new Long(36));
            dtoDetallePlantillaCurso36.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso36.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso36.setObligatorio(new Boolean(false));
            dtoDetallePlantillaCurso36.setParametro(dtoPara36);
            //dtoDetallePlantillaCurso.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso36);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso37 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara37 = new DTOParametro();
            dtoPara37.setOid(new Long(37));
            dtoDetallePlantillaCurso37.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso37.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso37.setObligatorio(new Boolean(false));
            dtoDetallePlantillaCurso37.setParametro(dtoPara37);
            dtoDetallePlantillaCurso37.setValor(new String("10"));
            arrayList.add(dtoDetallePlantillaCurso37);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso38 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara38 = new DTOParametro();
            dtoPara38.setOid(new Long(38));
            dtoDetallePlantillaCurso38.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso38.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso38.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso38.setParametro(dtoPara38);
            dtoDetallePlantillaCurso38.setValor(new String("01/01/2005"));
            arrayList.add(dtoDetallePlantillaCurso38);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso39 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara39 = new DTOParametro();
            dtoPara39.setOid(new Long(39));
            dtoDetallePlantillaCurso39.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso39.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso39.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso39.setParametro(dtoPara39);
            dtoDetallePlantillaCurso39.setValor(new String("1002"));
            arrayList.add(dtoDetallePlantillaCurso39);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso40 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara40 = new DTOParametro();
            dtoPara40.setOid(new Long(40));
            dtoDetallePlantillaCurso40.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso40.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso40.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso40.setParametro(dtoPara40);
            dtoDetallePlantillaCurso40.setValor(new String("5"));
            arrayList.add(dtoDetallePlantillaCurso40);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso41 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara41 = new DTOParametro();
            dtoPara41.setOid(new Long(41));
            dtoDetallePlantillaCurso41.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso41.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso41.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso41.setParametro(dtoPara41);
            dtoDetallePlantillaCurso41.setValor(new String("0"));
            arrayList.add(dtoDetallePlantillaCurso41);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso42 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara42 = new DTOParametro();
            dtoPara42.setOid(new Long(42));
            dtoDetallePlantillaCurso42.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso42.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso42.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso42.setParametro(dtoPara42);
            dtoDetallePlantillaCurso42.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso42);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso43 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara43 = new DTOParametro();
            dtoPara43.setOid(new Long(43));
            dtoDetallePlantillaCurso43.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso43.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso43.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso43.setParametro(dtoPara43);
            dtoDetallePlantillaCurso43.setValor(new String("N"));
            arrayList.add(dtoDetallePlantillaCurso43);  
            
            DTODetallePlantillaCurso dtoDetallePlantillaCurso44 = new DTODetallePlantillaCurso(); 
            DTOParametro dtoPara44 = new DTOParametro();
            dtoPara44.setOid(new Long(44));
            dtoDetallePlantillaCurso44.setVisible(new Boolean(true));
            dtoDetallePlantillaCurso44.setModificable(new Boolean(true));
            dtoDetallePlantillaCurso44.setObligatorio(new Boolean(true));
            dtoDetallePlantillaCurso44.setParametro(dtoPara44);
            dtoDetallePlantillaCurso44.setValor(new String("descripcion detallada--SCS"));
            arrayList.add(dtoDetallePlantillaCurso44);  
            
            DTOI18nSICC[] i18N = new DTOI18nSICC[1];
            
            DTOI18nSICC registro = new DTOI18nSICC();
            registro.setOidIdioma(new Long(1));
            registro.setValorI18n(new String("nombre plantilla curso cabecera"));
            
            i18N[0] = registro;
            
            dto.setAttriTraducible(i18N);
            
            dto.setDetalles(arrayList);
            
            mONPlantillaCurso.modificaPlantilla(dto);
    }
    
    private static Context getInitialContext() throws NamingException
    {
        Hashtable env = new Hashtable();
        // Standalone OC4J connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "PRUEBAS");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        
        //env.put(Context.SECURITY_PRINCIPAL, "admin");
        //env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        
        env.put(Context.PROVIDER_URL, "ormi://cdos0075:23791/mare");
        //env.put(Context.PROVIDER_URL, "ormi://cdos02ap:3104/sicc_server");

        return new InitialContext(env);
    }
    
}