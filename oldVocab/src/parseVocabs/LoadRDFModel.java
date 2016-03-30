package parseVocabs;

import com.hp.hpl.jena.ontology.OntDocumentManager;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class LoadRDFModel {
	
	public int elements = 0;
	public boolean jenaModelExc = false;
	public String vannPrefix = null;
	public String vannNS = null;
	
	public Model model;
	
	public LoadRDFModel(String uri, String contentType) {
//		System.err.println("     Load model ");
//		System.out.println("     Load model ");
		
		// TODO Auto-generated constructor stub
		
        // try to load the file in final uri
	    // create an empty model
//		OntDocumentManager dm = new OntDocumentManager();
//		dm.setProcessImports(false);

//        OntModelSpec spec = new OntModelSpec(null, dm, null, ProfileRegistry.OWL_LANG);
        this.model = ModelFactory.createDefaultModel();
        
        try {
            if (uri != null){
            	if (uri.contains(".ttl")){
    				this.model.read(uri, null, "TTL");
    			}
    			else if (uri.contains(".n3")){
    				this.model.read(uri, null, "N3");
    			}
    			else{
    				if (contentType != null){
    					if (contentType.contains("turtle")){
    						this.model.read(uri, null, "TTL");
    					}
    					else if (contentType.contains("n3")){
    						this.model.read(uri, null, "N3");
    					}
    					else{
    						this.model.read(uri, null);
    					}
    				}
    				else{
    					this.model.read(uri, null);
    				}
    			}
            }
            else{
            	//urifinal es null. Pruebo con la uri.
//            	System.err.println("La uri es null??? ");
            }
            
            //aqui he cargado el modelo de una u otra manera. A no ser que algo falle.
    		
            int nC = 0;
            int nOP = 0;
//    		int nC = this.model.listObjects().toList().size();
//    		int nOP = this.model.listSubjects().toList().size();
    		int nDP = this.model.listStatements().toList().size();
    		
    		this.elements = nC + nOP + nDP;
    		
        }
        catch (java.lang.Exception d){
        	System.err.println(d.getMessage());
        	
        	this.jenaModelExc = true;
        }

	}

	public int getElements (){
		return this.elements;
	}

	public boolean getJenaExc (){
		return this.jenaModelExc;
	}
	
	public String getVannPrefix(){
		return this.vannPrefix;
	}
	
	public String getVannNS(){
		return this.vannNS;
	}
	
	public Model getModel(){
		return this.model;
	}
}
