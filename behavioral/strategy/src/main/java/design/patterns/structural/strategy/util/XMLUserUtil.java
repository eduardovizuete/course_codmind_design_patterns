package design.patterns.structural.strategy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLUserUtil {
    
    private static final Logger logger = Logger.getLogger(XMLUserUtil.class.getName());
    
    private static final String ROL_XPATH = "Users/User[@userName='%s' and @password='%s']/@rol";
    
    public static String getRolByPrincipal(String userName, String password){
        InputStream file = null;
        try {
            file = XMLUserUtil.class.getClassLoader().getResourceAsStream("META-INF/UserFile.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            String xpath = String.format(ROL_XPATH, userName, password);
            String rol = xPath.compile(xpath).evaluate(xmlDocument);
            return rol;
        } catch (IOException | ParserConfigurationException | XPathExpressionException | SAXException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try { 
                file.close(); 
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
