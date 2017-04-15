/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.DAO.Interfaces;


import java.util.List;

import Models.Beans.CritereLangue;
import Models.Beans.CritereLogiciel;
import Models.Beans.Entreprise;
import Models.Beans.Etudiant;
import Models.Beans.Formation;
import Models.Beans.Langue;
import Models.Beans.LigneConditionLangue;
import Models.Beans.LigneConditionLogiciel;
import Models.Beans.LigneFormation;
import Models.Beans.LignePostul;
import Models.Beans.Logiciel;
import Models.Beans.OffreDeStage;
import Models.Exceptions.DAOException;



public interface EntrepriseDao {
	
	
	public Entreprise rechercherEntreprise(String email, String password) throws DAOException;
	
	public void creerEntreprise(Entreprise entreprise) throws DAOException;
	
	public void ajoutOffre(String intitule,String description,int idEntreprise) throws DAOException;
	
	public void ajouterLogiciel(CritereLogiciel Logiciel ,int oblig_logiciel) throws DAOException;
	
	public void ajouterCritere() throws DAOException;
	
	public void ajouterLangue(CritereLangue langue, int oblig_langue) throws DAOException;
	
	public void ajouterFormation(Formation formation) throws DAOException;
	
	public void publierOffre(String intitule,String description,int idEntreprise,List<LigneConditionLogiciel> listeCritereLog,List<Formation> listeCritereForm,List<LigneConditionLangue> listeCritereLang) throws DAOException;
    
	public List<OffreDeStage> getOffresByEntreprise(int id) throws DAOException;

	public OffreDeStage getOffreById(int id) throws DAOException;
	
	public List<LignePostul> getCandidatures(Entreprise entreprise) throws DAOException;
	
	public List<LignePostul> getPostulation(OffreDeStage offre) throws DAOException;
	
	public void repondreCandidature(int codeEtd , int codeStg , int decision) throws DAOException;
	
	public LignePostul getPostulaByCandidatAndOffre(int codeEtd , int codeStg) throws DAOException;
	
	public void sendMsgCandidature(int codeEtd, int codeStg, String msg) throws DAOException;
	
	public List<Entreprise> getEntreprises() throws DAOException;
	
}
