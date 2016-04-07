package es.indra.sicc.cmn.negocio.correo;

import es.indra.mare.common.dto.*;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mln.*;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeBean;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;

import es.indra.sicc.cmn.negocio.auditoria.DTOConfiguracionRastreo;
import es.indra.sicc.cmn.negocio.auditoria.MONAuditoria;
import es.indra.sicc.cmn.negocio.auditoria.MONAuditoriaHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;

import java.io.*;

import java.util.*;

import javax.activation.*;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.mail.*;
import javax.mail.internet.*;
import es.indra.sicc.util.UtilidadesLog;
import javax.mail.internet.AddressException;


public class MONServicioCorreoElectronicoBean implements SessionBean, IServicioCorreoElectronico {
    SessionContext ctx = null;
    private boolean debug = false;

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void enviarCorreo(DTOCorreoElectronico dto) throws MareException {
        UtilidadesLog.info("MONServicioCorreoElectronico.enviarCorreo(): Entrada");
        MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
        String server = (String)mgc.getProperty("smtp.server");
        String user = (String)mgc.getProperty("smtp.user");
        String password = (String)mgc.getProperty("smtp.password");
        String from = (String)mgc.getProperty("smtp.fromAddress");

        // crea algunas propiedades y consigue la Session por defecto
        Properties props = System.getProperties();

        props.put("mail.smtp.host", server);

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(debug);

        try {
            // crea un mensaje por cada destinatario
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));

            // destinatarios
            InternetAddress[] address = new InternetAddress[1];
            InternetAddress dir = new InternetAddress(dto.getDireccion());
            address[0] = dir;

            //msg.addRecipients( Message.RecipientType.TO, "etenob@hotmail.com" );
            // ponemos el 'asunto'
            msg.setSubject(dto.getAsunto());

            // crea y rellena la primera parte del mensaje
            MimeBodyPart mbp1 = new MimeBodyPart();

            //mbp1.setText( body, "us-ascii");
            mbp1.setText(dto.getMensaje(), "iso8859-1");

            // crea el Multipart y sus partes
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);

            // adjunta el Multipart al mensaje
            msg.setContent(mp);

            // pone la fecha
            msg.setSentDate(new Date());

            // envia el mensaje
            if(((user != null) && (user.length() > 1)) || ((password != null) && (password.length() > 1))) {
                Transport tr = session.getTransport("smtp");
                tr.connect(server, user, password);
                msg.saveChanges(); // don't forget this
                tr.sendMessage(msg, address);
            } else
                Transport.send(msg, address);
        } catch(MessagingException mex) {
            // se ha producido un error al enviar un mensaje         
            // componemos el mensaje de error
            BelcorpService belcorpService = BelcorpService.getInstance();
            String msg = "Se ha producido un error al enviar el correo: " + mex.getMessage();
            LogAPP.info(msg);
            mex.printStackTrace();
            throw new MareException( msg );
        }
        UtilidadesLog.info("MONServicioCorreoElectronico.enviarCorreo(): Salida");
    }
    
    public void enviarCorreo(DTOCorreoElectronico dto, String s) throws MareException, AddressException {
        UtilidadesLog.info("MONServicioCorreoElectronico.enviarCorreo(): Entrada");
        MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
        String server = (String)mgc.getProperty("smtp.server");
        String user = (String)mgc.getProperty("smtp.user");
        String password = (String)mgc.getProperty("smtp.password");
        String from = (String)mgc.getProperty("smtp.fromAddress");

        // crea algunas propiedades y consigue la Session por defecto
        Properties props = System.getProperties();

        props.put("mail.smtp.host", server);

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(debug);

        try {
            // crea un mensaje por cada destinatario
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));

            // destinatarios
            InternetAddress[] address = new InternetAddress[1];
            InternetAddress dir = new InternetAddress(dto.getDireccion());
            address[0] = dir;

            //msg.addRecipients( Message.RecipientType.TO, "etenob@hotmail.com" );
            // ponemos el 'asunto'
            msg.setSubject(dto.getAsunto());

            // crea y rellena la primera parte del mensaje
            MimeBodyPart mbp1 = new MimeBodyPart();

            //mbp1.setText( body, "us-ascii");
            mbp1.setText(dto.getMensaje(), "iso8859-1");

            // crea el Multipart y sus partes
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);

            // adjunta el Multipart al mensaje
            msg.setContent(mp);

            // pone la fecha
            msg.setSentDate(new Date());

            // envia el mensaje
            if(((user != null) && (user.length() > 1)) || ((password != null) && (password.length() > 1))) {
                Transport tr = session.getTransport("smtp");
                tr.connect(server, user, password);
                msg.saveChanges(); // don't forget this
                tr.sendMessage(msg, address);
            } else
                Transport.send(msg, address);
        } catch(AddressException ae){
            throw new AddressException();
        } catch(MessagingException mex) {
            // se ha producido un error al enviar un mensaje         
            // componemos el mensaje de error
            BelcorpService belcorpService = BelcorpService.getInstance();
            String msg = "Se ha producido un error al enviar el correo: " + mex.getMessage();
            LogAPP.info(msg);
            mex.printStackTrace();
            throw new MareException( msg );
        }
        UtilidadesLog.info("MONServicioCorreoElectronico.enviarCorreo(): Salida");
    }

}