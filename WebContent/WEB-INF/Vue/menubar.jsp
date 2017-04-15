<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- START PAGE SIDEBAR -->
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="#" id="logoyd" >YD Job NETWORK</a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    <li class="xn-profile">
                        <a href="#" class="profile-mini">
                            <img src="assets/images/users/avatar.jpg" alt="John Doe"/>
                        </a>
                        <div class="profile">
                            <div class="profile-image">
                                <img src="assets/images/users/no-image.jpg" alt="John Doe"/>
                            </div>
                            <div class="profile-data">
                            <c:if test="${not empty candidat}" >
                                <div class="profile-data-name">${candidat.nom_etudiant } ${candidat.prenom_etudiant }</div>
                                <div class="profile-data-title">${candidat.email_etudiant }</div>
                            </c:if>
                            <c:if test="${not empty entrepriseSess}" >
                                <div class="profile-data-name">${entrepriseSess.nom_entreprise }</div>
                                <div class="profile-data-title">${entrepriseSess.email_entreprise }</div>
                            </c:if>
                            <c:if test="${not empty ecoleSess}" >
                                <div class="profile-data-name">${ecoleSess.nom_etablissement }</div>
                                <div class="profile-data-title">${ecoleSess.login_etablissement }</div>
                            </c:if>
                           
                            </div>
                            <div class="profile-controls">
                                
                            </div>
                        </div>                                                                        
                    </li>
                    <li class="xn-title">Menu</li>
                   <!--  <li >
                        <a href="#"><span class="fa fa-dashboard"></span> <span class="xn-text">Tableau de bord</span></a>
                    </li>  --> 
                    
                    <c:if test="${not empty candidat}" >
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-user"></span> <span class="xn-text">Profile</span></a>
                        <ul>
                            <li><a href="/jobNetwork/ProfileCandidat"><span class="fa fa-columns"></span> Consulter profile</a></li>                            
                            <!-- <li><a href="/jobNetwork/EditProfileCandidat"><span class="fa fa-wrench"></span> Editer</a></li> -->                          
                        </ul>
                    </li>
                   
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-file-text-o"></span> <span class="xn-text">CV</span></a>
                        <ul>
                        	<li><a href="/jobNetwork/etudiant_infos_generales"><span class="fa fa-columns"></span> Informations generales</a></li>
                            <li><a href="/jobNetwork/etudiant_experiencePros"><span class="fa fa-suitcase"></span> Experiences Pro</a></li>                            
                            <li><a href="/jobNetwork/etudiant_formation"><span class="fa fa-book"></span> Formations</a></li>  
                            <li><a href="/jobNetwork/etudiant_competence"><span class="fa fa-bullseye"></span> Competences</a></li>   
                            <li><a href="/jobNetwork/etudiant_langues"><span class="fa fa-comments-o"></span> Langues</a></li>                      
                        </ul>
                    </li>   
                    </c:if>
                    
                    <c:if test="${not empty entrepriseSess}" >
  					<li >
                        <a href="/jobNetwork/ProfileEntreprise"><span class="fa fa-users"></span> <span class="xn-text">Profile</span></a>
                    </li>                   
                    </c:if>
                                                                
                    <c:if test="${not empty entrepriseSess or not empty candidat }" >
                    
                    <li class="xn-openable">
                        <a href="#"><span class="glyphicon glyphicon-align-justify"></span> <span class="xn-text">Offres</span></a>                        
                        <ul>
                        	<c:if test="${not empty candidat}" >
                        	<li><a href="/jobNetwork/ListeOffresEtudiant"><span class="fa fa-search"></span> Recherche</a></li>
                        	</c:if>
                        	<c:if test="${not empty entrepriseSess}" >
                        	<li><a href="/jobNetwork/ListeOffres"><span class="fa fa-sort"></span> Mes offres</a></li>
                            <li><a href="/jobNetwork/Ajout_offre"><span class="fa fa-plus-circle"></span> Ajout</a></li>        
                            </c:if>                 
                        </ul>
                    </li>                   
                    </c:if>
                    
                     <c:if test="${not empty ecoleSess}" >
                     <li >
                        <a href="#"><span class="fa fa-home"></span> <span class="xn-text">Profile</span></a>
                    </li>
                     <li >
                        <a href="/jobNetwork/InscriptionEtudiant"><span class="fa fa-edit"></span> <span class="xn-text">Inscription des candidats</span></a>
                    </li>
                     </c:if>
                    
                    
                    <c:if test="${not empty entrepriseSess}" >
                    <li >
                        <a href="/jobNetwork/Candidatures"><span class="fa fa-list-ol"></span> <span class="xn-text">Candidatures</span></a>
                    </li>
                    
                    </c:if>
                    
                    <li >
                        <a href="/jobNetwork/AllEntreprisesController"><span class="fa fa-users"></span> <span class="xn-text">Candidats</span></a>
                    </li>
                    <li >
                        <a href="/jobNetwork/Entreprises"><span class="fa fa-table"></span> <span class="xn-text">Entreprises</span></a>
                    </li>
                    
                    <c:if test="${not empty candidat}" >
                    <li >
                        <a href="/jobNetwork/Messages"><span class="fa fa-comment-o"></span> <span class="xn-text">Messages</span></a>
                    </li>
                    <li >
                        <a href="/jobNetwork/Boite_reception"><span class="fa fa-mail-forward"></span> <span class="xn-text">Boite de reception</span></a>
                    </li>
                    </c:if>
                    
                    
                    
                    
                </ul>
                <!-- END X-NAVIGATION -->
            </div>
            <!-- END PAGE SIDEBAR -->