package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ischool {
	public etu getetu(String email,String pass);
	public etu getetu(int id);
	public int ajouteretu(etu e);
	public prof getprof(int id);
	public prof getprof(String email,String pass);
	public List<annonce> listeanounce();
	public List<annonce> listeanouncep(int id);
	public int inscrirenannonce(int ida,int ide);
	public int quitterannonce(int ida,int ide);
	public int checkinscrir(int ida,int ide);
	public List<annonce> monannonce(int ide);
	public annonce getannonce(int ida);
	public List<annonce> classeannonce(String classe,  String niveau, String filiere);
	public List<annonce> classeannonce(String classe,  String niveau);
	public void supprimerannonce(int ida);
	public int ajouterannonce(annonce a);
	public void modifierannonce(annonce a);
	public List<etu> listetuannonce(int id);
	public void ajouterabscence(int ida,int ide);
	public int getpayement(int ida,int ide);
	public List<etu> listetu();
	public Date getdate(int ide , int ida);
	public List<prof> listprof();
	public List<annonce> listannonce();
	public void modiferetu(etu e);
	public int supprimeretu(int ide);
	public void modifierprof(prof p);
	public List<classe> listeclasse();
	public List<String> listschool(String classe);
	public List<String> listesc();
	public List<String> listniveau(String classe,  String niveau);
	public List listfiliere(String classe,  String niveau, String filiere);
	public void supprimerclasse(int idc);
	public classe getclasse(int idc);
	public void ajouterclasse(classe c);
	public int supprimerprof(int idp);
	public void ajouterprof(prof p);
	public void modifierclasse(classe c);
	public void setpaiment(int ide ,int ida);
	public void setpaimentne(int ide ,int ida);
	public int nombre_jour(int ide,int ida);
	public int checkcne(String cne);
	public admine getadmin(String email,String pass);
	public admine getadmin(int id);
	public int changepass(String pass,etu e);
	public int changepass(String pass,admine e);
	public int changepass(String pass,prof e);
	public List<abscence> listeabscence();
	public void supprimerabscence(int id);
	public int checkpass(String pass,String email);
	public int checketu(String pass,String email);
	public int nb_etudiants();
	public int nb_professeur();
	public int total_prix();
}
