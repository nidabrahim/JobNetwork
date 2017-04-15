
package Models.Utilitaire;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Models.Beans.Etudiant;

public class EtudiantsParser {
	
	public EtudiantsParser(){}
	
	public ArrayList<Etudiant> getAllEtudiants(String urll) throws Exception {
		
		//création du parseur en appelant la méthode statique factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
			   
		//chargement du fichier XML					
		Document document = builder.parse("C:\\Users\\youssefNIDA\\Documents\\jobNetwork\\src\\etudiants.xml");
							
		//récupérer le contenu de l'élément racine		
		Element racine =  document.getDocumentElement();
					
		//récupération de tous les etudiants  inclus
		NodeList etudiants = racine.getElementsByTagName("etudiant");
			        
	
		ArrayList<Etudiant> listEtudiants = new ArrayList<Etudiant>();
	
		for( int i=0; i<etudiants.getLength(); i++ ) {
		
		 
			  Element etudiantElm=(Element) etudiants.item(i);
			  Etudiant etudiant = new Etudiant();
		  
			  //On recupere ses nodes
	          Node prenom =etudiantElm.getElementsByTagName("prenom").item(0);
	          Node nom = etudiantElm.getElementsByTagName("nom").item(0);
	          Node email =etudiantElm.getElementsByTagName("email").item(0);
	          
	          
	          etudiant.setPrenom_etudiant(prenom.getFirstChild().getNodeValue());
	          etudiant.setNom_etudiant(nom.getFirstChild().getNodeValue());
	          etudiant.setEmail_etudiant(email.getFirstChild().getNodeValue());
	          
	          listEtudiants.add(etudiant);
       
       }
		
		return listEtudiants;
	 

	}

	
}
