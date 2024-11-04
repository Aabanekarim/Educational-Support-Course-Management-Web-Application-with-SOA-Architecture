import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.*;

import com.admine;
import com.annonce;
import com.classe;
import com.etu;
import com.prof;

public class connectapi {
	
	
	String urlapi =  "http://localhost:8080/projetsoa/UtilisateurService/";
	
	List<com.etu> listetu(){
		
		List<etu> students=new ArrayList<etu>();
		try {
		urlapi+="getetudiant";
		URL url = new URL(urlapi);

	    // Open connection
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    // Set request method
	    conn.setRequestMethod("GET");

	    // Get response code
	    int responseCode = conn.getResponseCode();

	    // Check if request was successful
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        // Read response
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer responseBuffer = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	            responseBuffer.append(inputLine);
	        }
	        in.close();
		
		
        JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();

        
		for (JsonValue jsonValue : jsonArray) {
            JsonObject jsonObject = jsonValue.asJsonObject();
            etu student = new etu();

            // Fill Etudiant properties
            student.setId(jsonObject.getInt("id"));
            student.setClasse(jsonObject.getString("classe"));
            student.setCne(jsonObject.getString("cne"));
            student.setNom(jsonObject.getString("nom"));
            student.setPrenom(jsonObject.getString("prenom"));
            student.setEmail(jsonObject.getString("email"));
            student.setPass(jsonObject.getString("pass"));

            // Add the filled Etudiant object to the list
            students.add(student);
        }
        
    }
    conn.disconnect();
} catch (IOException d) {
    // Handle exception
    d.printStackTrace();
}
		
		return students;
		
		
	}
	
	
	List<annonce> monannonce(int id){
		List<annonce> annonces = new ArrayList<annonce>();
		
		try {
			urlapi+="getetudiantannonces/"+id;
			URL url = new URL(urlapi);

		    // Open connection
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		    // Set request method
		    conn.setRequestMethod("GET");

		    // Get response code
		    int responseCode = conn.getResponseCode();

		    // Check if request was successful
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        // Read response
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        String inputLine;
		        StringBuffer responseBuffer = new StringBuffer();
		        while ((inputLine = in.readLine()) != null) {
		            responseBuffer.append(inputLine);
		        }
		        in.close();
			
			
	        JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
	        JsonArray jsonArray = jsonReader.readArray();
	        jsonReader.close();

	        
			for (JsonValue jsonValue : jsonArray) {
	            JsonObject jsonObject = jsonValue.asJsonObject();
	            annonce a= new annonce();
	            a.setId(jsonObject.getInt("id"));
	            a.setClasse(jsonObject.getString("classe"));
	            a.setFiliere(jsonObject.getString("filiere"));
	            a.setJour(jsonObject.getString("jour"));
	            a.setMatier(jsonObject.getString("matier"));
	            a.setNiveau(jsonObject.getString("niveau"));
	            a.setPrix(jsonObject.getInt("prix"));
	            a.setSeance(jsonObject.getString("seance"));
	            
	            JsonObject profObject = jsonObject.getJsonObject("prof");
	            prof p = new prof();
	            
	            p.setId(profObject.getInt("id"));
	            p.setCom(profObject.getString("com"));
	            p.setEmail(profObject.getString("email"));
	            p.setNom(profObject.getString("nom"));
	            p.setPrenom(profObject.getString("prenom"));
	            p.setPass(profObject.getString("pass"));
	            
	            a.setProf(p);
	            
	            annonces.add(a);
	        }
	        
	    }
	    conn.disconnect();
	} catch (IOException d) {
	    // Handle exception
	    d.printStackTrace();
	}

		
		return annonces;
		
	}
	
	
	List<annonce> listeanounce(){
		List<annonce> annonces = new ArrayList<annonce>();
		try {
			urlapi+="getannonce";
			URL url = new URL(urlapi);

		    // Open connection
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		    // Set request method
		    conn.setRequestMethod("GET");

		    // Get response code
		    int responseCode = conn.getResponseCode();

		    // Check if request was successful
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        // Read response
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        String inputLine;
		        StringBuffer responseBuffer = new StringBuffer();
		        while ((inputLine = in.readLine()) != null) {
		            responseBuffer.append(inputLine);
		        }
		        in.close();
			
			
	        JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
	        JsonArray jsonArray = jsonReader.readArray();
	        jsonReader.close();

	        
			for (JsonValue jsonValue : jsonArray) {
	            JsonObject jsonObject = jsonValue.asJsonObject();
	            annonce a= new annonce();
	            a.setId(jsonObject.getInt("id"));
	            a.setClasse(jsonObject.getString("classe"));
	            a.setFiliere(jsonObject.getString("filiere"));
	            a.setJour(jsonObject.getString("jour"));
	            a.setMatier(jsonObject.getString("matier"));
	            a.setNiveau(jsonObject.getString("niveau"));
	            a.setPrix(jsonObject.getInt("prix"));
	            a.setSeance(jsonObject.getString("seance"));
	            
	            JsonObject profObject = jsonObject.getJsonObject("prof");
	            prof p = new prof();
	            
	            p.setId(profObject.getInt("id"));
	            p.setCom(profObject.getString("com"));
	            p.setEmail(profObject.getString("email"));
	            p.setNom(profObject.getString("nom"));
	            p.setPrenom(profObject.getString("prenom"));
	            p.setPass(profObject.getString("pass"));
	            
	            a.setProf(p);
	            
	            annonces.add(a);
	        }
	        
	    }
	    conn.disconnect();
	} catch (IOException d) {
	    // Handle exception
	    d.printStackTrace();
	}

		
		
		return annonces;
	}
	
	
	void ajouteretu(etu e) {
		urlapi+="addetudiant/"+e.getNom()+"/"+e.getPrenom()+"/"+e.getClasse()+"/"+e.getCne();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
		
	}
	
	
	void inscrirenannonce(int ida,int ide) {
		urlapi+="signinannonce/"+ida+"/"+ide;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	
	void quitterannonce(int ida , int ide) {
		
		urlapi+="quitannonce/"+ida+"/"+ide;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("DELETE");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	
	List<annonce> classeannonce(String classe,String niv,String fil){
		List<annonce> annonces = new ArrayList<annonce>();
		try {
			urlapi+="getfiliereannonces/"+classe+"/"+niv+"/"+fil;
			URL url = new URL(urlapi);

		    // Open connection
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		    // Set request method
		    conn.setRequestMethod("GET");

		    // Get response code
		    int responseCode = conn.getResponseCode();

		    // Check if request was successful
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        // Read response
		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        String inputLine;
		        StringBuffer responseBuffer = new StringBuffer();
		        while ((inputLine = in.readLine()) != null) {
		            responseBuffer.append(inputLine);
		        }
		        in.close();
			
			
	        JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
	        JsonArray jsonArray = jsonReader.readArray();
	        jsonReader.close();

	        
			for (JsonValue jsonValue : jsonArray) {
	            JsonObject jsonObject = jsonValue.asJsonObject();
	            annonce a= new annonce();
	            a.setId(jsonObject.getInt("id"));
	            a.setClasse(jsonObject.getString("classe"));
	            a.setFiliere(jsonObject.getString("filiere"));
	            a.setJour(jsonObject.getString("jour"));
	            a.setMatier(jsonObject.getString("matier"));
	            a.setNiveau(jsonObject.getString("niveau"));
	            a.setPrix(jsonObject.getInt("prix"));
	            a.setSeance(jsonObject.getString("seance"));
	            
	            JsonObject profObject = jsonObject.getJsonObject("prof");
	            prof p = new prof();
	            
	            p.setId(profObject.getInt("id"));
	            p.setCom(profObject.getString("com"));
	            p.setEmail(profObject.getString("email"));
	            p.setNom(profObject.getString("nom"));
	            p.setPrenom(profObject.getString("prenom"));
	            p.setPass(profObject.getString("pass"));
	            
	            a.setProf(p);
	            
	            annonces.add(a);
	        }
	        
	    }
	    conn.disconnect();
	} catch (IOException d) {
	    // Handle exception
	    d.printStackTrace();
	}
		return annonces;
	}
	
	
	void supprimerannonce(int id) {
		urlapi+="removeannonce/"+id;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("DELETE");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
	}
	
	
	void ajouterannonce(annonce a) {
		urlapi+="addannonce/"+a.getMatier()+"/"+a.getClasse()+"/"+a.getNiveau()+"/"+a.getFiliere()+"/"+a.getSeance()+"/"+a.getJour()+"/"+a.getProf().getId()+"/"+a.getPrix();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
		
	}
	
	
	void modifierannonce(annonce a) {
		//editannonce/{ida}/{matier}/{classe}/{niv}/{fil}/{temp}/{seance}/{idp}/{prix}
		urlapi+="editannonce/"+a.getId()+"/"+a.getMatier()+"/"+a.getClasse()+"/"+a.getNiveau()+"/"+a.getFiliere()+"/"+a.getJour()+"/"+a.getSeance()+"/"+a.getProf().getId()+"/"+a.getPrix();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	
	List<com.etu> listetuannonce(int ida){
		
		List<etu> students=new ArrayList<etu>();
		try {
		urlapi+="getannonceetudiant/"+ida;
		URL url = new URL(urlapi);

	    // Open connection
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    // Set request method
	    conn.setRequestMethod("GET");

	    // Get response code
	    int responseCode = conn.getResponseCode();

	    // Check if request was successful
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        // Read response
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer responseBuffer = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	            responseBuffer.append(inputLine);
	        }
	        in.close();
		
		
        JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();

        
		for (JsonValue jsonValue : jsonArray) {
            JsonObject jsonObject = jsonValue.asJsonObject();
            etu student = new etu();

            // Fill Etudiant properties
            student.setId(jsonObject.getInt("id"));
            student.setClasse(jsonObject.getString("classe"));
            student.setCne(jsonObject.getString("cne"));
            student.setNom(jsonObject.getString("nom"));
            student.setPrenom(jsonObject.getString("prenom"));
            student.setEmail(jsonObject.getString("email"));
            student.setPass(jsonObject.getString("pass"));

            // Add the filled Etudiant object to the list
            students.add(student);
        }
        
    }
    conn.disconnect();
} catch (IOException d) {
    // Handle exception
    d.printStackTrace();
}
		
		return students;
		
		
	}
	
	void modiferetu(etu e) {
		urlapi+="editetudiant/"+e.getId()+"/"+e.getNom()+"/"+e.getPrenom()+"/"+e.getClasse()+"/"+e.getEmail()+"/"+e.getPass();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
		
	}
	
	
	void ajouterabscence(int ida,int id) {
		urlapi+="addabscence/"+ida+"/"+id;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
		
	}
	
	void supprimeretu(int id) {
		urlapi+="removeetudiant/"+id;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("DELETE");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
	}
	
	void modifierprof(prof p) {
		
		urlapi+="editprof/"+p.getId()+"/"+p.getNom()+"/"+p.getPrenom()+"/"+p.getCom()+"/"+p.getEmail()+"/"+p.getPass();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	
	void supprimerprof(int id) {
		
		urlapi+="removeprof/"+id;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("DELETE");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	void ajouterprof(prof p) {
		
		urlapi+="addprof/"+p.getNom()+"/"+p.getPrenom()+"/"+p.getCom()+"/"+p.getPass();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	void modifierclasse(classe c) {
		
		urlapi+="editclass/"+c.getId()+"/"+c.getSchool()+"/"+c.getNiveau()+"/"+c.getFiliere()+"/"+c.getMatiere()+"/"+c.getProf().getId();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	void ajouterclasse(classe c) {
		
		urlapi+="addclass/"+c.getSchool()+"/"+c.getNiveau()+"/"+c.getFiliere()+"/"+c.getMatiere();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
        }
		
	}
	
void setpaiment(int ide,int ida) {
		
		urlapi+="setpayment/"+ide+"/"+ida;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}


	void changepass(String pass,etu e) {
		
		urlapi+="changepasswordetudiant/"+pass+"/"+e.getId();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	
void changepass(String pass,prof e) {
		
		urlapi+="changepasswordprof/"+pass+"/"+e.getId();
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}

	void changepass(String pass,admine e) {
	
	urlapi+="changepasswordadmine/"+pass+"/"+e.getId();
	try {
        // Create URL object
        URL url = new URL(urlapi);

        // Open connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set request method
        conn.setRequestMethod("GET");

        // Get response code
        int responseCode = conn.getResponseCode();

        // Check if request was successful
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer responseBuffer = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseBuffer.append(inputLine);
            }
            in.close();

            // Forward response or process it further
           } else {
            // Handle error response
            }
        conn.disconnect();
    } catch (IOException d) {
        // Handle exception
        d.printStackTrace();
         }
	
}
	
	
	void supprimerclasse(int id) {
		
		urlapi+="removeclasse/"+id;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("DELETE");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}
	
	
void supprimerabscence(int id) {
		
		urlapi+="removeabscence/"+id;
		try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("DELETE");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Forward response or process it further
               } else {
                // Handle error response
                }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
             }
		
	}


	prof getprof(int id) {
		com.prof p = null;
		urlapi += "getprof/"+id;

        try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Convert JSON response to ArrayList<Classe>
                JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
                JsonObject jsonObject = jsonReader.readObject();
                jsonReader.close();

                
                p = new com.prof(jsonObject.getInt("id"),jsonObject.getString("nom"),jsonObject.getString("prenom"),jsonObject.getString("com"),jsonObject.getString("email"),jsonObject.getString("pass"));
                
                    
                

            } else {
                // Handle error response
              }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
       }
		return p;
		
	}
	
	
	etu getetu(int id) {
		com.etu e = null;
		urlapi += "getetudient/"+id;

        try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Convert JSON response to ArrayList<Classe>
                JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
                JsonObject jsonObject = jsonReader.readObject();
                jsonReader.close();

                
                e = new com.etu(jsonObject.getInt("id"),jsonObject.getString("nom"),jsonObject.getString("prenom"),jsonObject.getString("classe"),jsonObject.getString("cne"),jsonObject.getString("email"),jsonObject.getString("pass"));
                
                    
                

            } else {
                // Handle error response
              }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
       }
		return e;
		
	}
	
	admine getadmine(int id) {
		com.admine p = null;
		urlapi += "getadmin/"+id;

        try {
            // Create URL object
            URL url = new URL(urlapi);

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();

                // Convert JSON response to ArrayList<Classe>
                JsonReader jsonReader = Json.createReader(new StringReader(responseBuffer.toString()));
                JsonObject jsonObject = jsonReader.readObject();
                jsonReader.close();

                
                p = new com.admine(jsonObject.getInt("id"),jsonObject.getString("nom"),jsonObject.getString("prenom"),jsonObject.getString("email"),jsonObject.getString("pass"));
                
                    
                

            } else {
                // Handle error response
              }
            conn.disconnect();
        } catch (IOException d) {
            // Handle exception
            d.printStackTrace();
       }
		return p;
		
	}

	
}
