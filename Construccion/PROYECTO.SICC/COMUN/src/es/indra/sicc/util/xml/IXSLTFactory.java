package es.indra.sicc.util.xml;

import java.io.ByteArrayInputStream;
import java.io.File;

import javax.xml.transform.Transformer;


/**
 * Interface <code>IXSLTFactory</code>.
 * Interface a implementar para los motores de XSL
 * @autor     Software Factory Argentina (INDRA SI S.A)
 * @version   1.0
 */
public abstract interface IXSLTFactory {
   public abstract Transformer getTransformer() throws Exception;

   public abstract Transformer getTransformer(String xslSource)
      throws Exception;

   public abstract Transformer getTransformer(ByteArrayInputStream xslSource)
      throws Exception;

   public abstract Transformer getTransformer(File xslSource)
      throws Exception;
}
