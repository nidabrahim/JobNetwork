

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${messages }" var="onemsg" >
                        
                        <c:if test="${candidat.num_etudiant == onemsg.emetteur.num_etudiant }">
                            <div class="item in item-visible">
                                <div class="image">
                                    <img src="assets/images/users/no-image.jpg" alt="John Doe">
                                </div>
                                <div class="text">
                                    <div class="heading">
                                        <a href="#">${onemsg.emetteur.nom_etudiant } ${onemsg.emetteur.prenom_etudiant }</a>
                                        <span class="date">${onemsg.date_msg }</span>
                                    </div>
                                    ${onemsg.texte_msg }
                                </div>
                            </div>
                            
                         </c:if>
                         <c:if test="${candidat.num_etudiant != onemsg.emetteur.num_etudiant }">
                            
                            <div class="item item-visible">
                                <div class="image">
                                    <img src="assets/images/users/no-image.jpg" alt="Dmitry Ivaniuk">
                                </div>                                
                                <div class="text">
                                    <div class="heading">
                                        <a href="#">${onemsg.emetteur.nom_etudiant } ${onemsg.emetteur.prenom_etudiant }</a>
                                        <span class="date">${onemsg.date_msg }</span>
                                    </div>                                    
                                    ${onemsg.texte_msg }
                                </div>
                            </div>
                            
                         </c:if>
                            
</c:forEach>