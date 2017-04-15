<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    
<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-blog-post.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:34 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>        
        <!-- META SECTION -->
        <title>Job Network</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="image/x-icon" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default.css"/>
        <!-- EOF CSS INCLUDE -->                                    
    </head>
    <body>
        <!-- START PAGE CONTAINER -->
        <div class="page-container">
            
            <!-- START PAGE SIDEBAR -->
            <%@ include file="menubar.jsp" %>
            <!-- END PAGE SIDEBAR -->
            
            <!-- PAGE CONTENT -->
            <div class="page-content">
                
                <!-- START X-NAVIGATION VERTICAL -->
                <%@ include file="menuHeader.jsp" %>
                <!-- END X-NAVIGATION VERTICAL -->                    
                
                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Offre</li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE TITLE -->
                <div class="page-title">                    
                    <h2><span class="fa fa-arrow-circle-o-left"></span> Offre <small>N ${id }</small></h2>
                </div>
                <!-- END PAGE TITLE -->                
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap"  >
                    
                    <div class="row">
                        <div class="col-md-9">
                            
                            <div class="panel panel-default">
                                <div class="panel-body posts">
                                            
                                    <div class="post-item">
                                        <div class="post-title">
                                            ${uneOffre.intitule_du_stage }
                                        </div>
                                        <div class="post-date"><span class="fa fa-calendar"></span> 07/12/2016 <a href="pages-profile.html">Par ${uneOffre.entreprise.nom_entreprise }</a></div>
                                        <div class="post-text"> 
                                        	<h4>Description</h4>                                           
                                            <p>L'entreprise <strong>${uneOffre.entreprise.nom_entreprise }</strong> cherche des candidats pour un stage qui s'intitule <strong>${uneOffre.intitule_du_stage }</strong>, ${uneOffre.description }.</p>
                                            
                                            <h4>Formations requises</h4>
                                            
                                            <ul>
                                            
                                            <c:forEach items="${listeFormation}" var="formation" >
                                            
                                                <li><a >${formation.type_formation } : ${formation.domaine_formation }</a></li>
                                                
                                            </c:forEach>
                                                
                                            </ul>
                                        </div>
                                        
                                       <c:if test="${not empty candidat }" >
                                       <c:if test="${dejaPostuler == '0'}"> 
                                        <div class="pull-right">
                                        	<a href="EnvoieCandidature?idOffre=${id}"><button class="btn btn-danger"><span class="fa fa-envelope"></span>Postule</button></a>
                                    	</div>
                                       </c:if>
                                       </c:if>
                                        
                                    </div>                                            
                                       
                                    <h3 class="push-down-20">Commentaires</h3>
                                    
                                    <ul id="commentaires" class="media-list">
                                    
                                    <c:forEach items="${offreComments }" var="oneComment" >
                                    
                                        <li class="media">
                                            <a class="pull-left" href="#">
                                                <img class="media-object img-text" src="assets/images/users/no-image.jpg" alt="Dmitry Ivaniuk" width="64">
                                            </a>
                                            <div class="media-body">
                                                <h4 class="media-heading">${ oneComment.candidat.nom_etudiant } ${ oneComment.candidat.prenom_etudiant }</h4>
                                                <p>${oneComment.text_com}</p>
                                                <p class="text-muted">${oneComment.date_com}</p>
                                                                                                                                        
                                            </div>                                            
                                        </li>
                                        
                                     </c:forEach>
                                        
                                    </ul>                                    
                                    
                                   <c:if test="${ not empty candidat}" >
                                    
                                    <div class="comment-write" style="border-top: 1px dashed #F5F5F5;padding: 14px;" >                                                
                                        <textarea id="texte_comment" class="form-control" placeholder="Ecrire un commentaire" rows="1" style="width:93%;float:left" ></textarea>   
                                        
                                        <div class="pull-right" style="line-height: 2.428571;margin-right:2%">
                                           <a  id="poster"><span class="fa fa-share"></span></a>
                                           <input type="hidden" value="${id}" />
                                        </div>                                             
                                    </div>
                                    
                                    </c:if>
                                    
                                </div>
                            </div>
                            
                        </div>
                        <div class="col-md-3">
                        
                        	

                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3>Langues</h3>
                                    <div class="links">
                                    
                                    <c:forEach items="${listeLangue}" var="lang" >
                                    
                                        <a href="#"><span class="label label-default" style="float:left" >${lang.libele_langue }</span></a>
                                        
                                    </c:forEach>
                                        
                                     </div>
                                </div>
                            </div>
                            
                          
                            
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3>Technologies</h3>
                                    <ul class="list-tags push-up-10">
                                    
                                    <c:forEach items="${listeLogiciels}" var="log" >
                                   
                                        <li><a href="#"><span class="fa fa-tag"></span> ${log.libele_logiciel }</a></li>
                                        
                                    </c:forEach>
                                        
                                    </ul>
                                </div>
                            </div>                            
                            
                        </div>
                    </div>
                                                            
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                       
                                
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->
        
        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> Log <strong>Out</strong> ?</div>
                    <div class="mb-content">
                        <p>Are you sure you want to log out?</p>                    
                        <p>Press No if youwant to continue work. Press Yes to logout current user.</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="pages-login.html" class="btn btn-success btn-lg">Yes</a>
                            <button class="btn btn-default btn-lg mb-control-close">No</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->

        <!-- START PRELOADS -->
        <audio id="audio-alert" src="audio/alert.mp3" preload="auto"></audio>
        <audio id="audio-fail" src="audio/fail.mp3" preload="auto"></audio>
        <!-- END PRELOADS -->          
        
    <!-- START SCRIPTS -->
        <!-- START PLUGINS -->
        <script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="js/plugins/jquery/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap.min.js"></script>        
        <!-- END PLUGINS -->

        <!-- START THIS PAGE PLUGINS-->        
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>                
        <!-- END THIS PAGE PLUGINS-->        

        <!-- START TEMPLATE -->
        
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>
        <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->         
    
    <script type="text/jscript" > 
	     $(document).ready(function(){

	    	 $("#poster").click(function(){


	    		 	var d = new Date();
		    		 var month = new Array();
		    		 month[0] = "Janvier";
		    		 month[1] = "Février";
		    		 month[2] = "Mars";
		    		 month[3] = "Avril";
		    		 month[4] = "Mai";
		    		 month[5] = "Juin";
		    		 month[6] = "Juillet";
		    		 month[7] = "Août";
		    		 month[8] = "Septembre";
		    		 month[9] = "Octobre";
		    		 month[10] = "Novembre";
		    		 month[11] = "Decembre";
		    		 var mois = month[d.getMonth()];
		    	 var fullDate = mois+" "+d.getDate()+", "+d.getFullYear()+", "+d.getHours()+":"+d.getMinutes();
	    		 
	    		 var comment = $("div.comment-write").children().val(); 
	    		 var refOffre = $(this).next().val(); 

	    		 /*$.post("posterCommentaire.jsp",{"comment":comment,"fullDate":fullDate,"refOffre":refOffre},function(data){

	    			 $("#commentaires").append(data);
	       	         return false;
	       	     });*/

	       	  	$.post("/jobNetwork/ListeOffres",{"comment":comment,"fullDate":fullDate,"refOffre":refOffre},function(dataa){

	       	  		$.post("posterCommentaire.jsp",{"comment":comment,"fullDate":fullDate},function(data){

		    			 $("#commentaires").append(data);
		    			 return false;
	       	  		});
	       	  		
	       	         return false;
	       	     });

	    		 $("div.comment-write").children().val("");
	    		 $("div.page-content-wrap").height(300);
	    		/* $("div.row").height(function(n,c){
		       	        return c+50;
		       	        });*/
	    		 
			 });
		     
	     });
     </script>
    
    
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','../../../../www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-36783416-1', 'auto');
        ga('send', 'pageview');
    </script>
    <!-- Yandex.Metrika counter -->
    <script type="text/javascript">
        (function (d, w, c) {
            (w[c] = w[c] || []).push(function() {
                try {
                    w.yaCounter25836617 = new Ya.Metrika({
                        id:25836617,
                        clickmap:true,
                        trackLinks:true,
                        accurateTrackBounce:true,
                        webvisor:true
                    });
                } catch(e) { }
            });

            var n = d.getElementsByTagName("script")[0],
                s = d.createElement("script"),
                f = function () { n.parentNode.insertBefore(s, n); };
            s.type = "text/javascript";
            s.async = true;
            s.src = "../../../../mc.yandex.ru/metrika/watch.js";

            if (w.opera == "[object Opera]") {
                d.addEventListener("DOMContentLoaded", f, false);
            } else { f(); }
        })(document, window, "yandex_metrika_callbacks");
    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/25836617" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->    
    </body>

<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-blog-post.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:34 GMT -->
</html>






