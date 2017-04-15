<!DOCTYPE html>
<html lang="en">
    
<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-messages.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:52:07 GMT -->
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
                <ul class="breadcrumb push-down-0">
                    <li><a href="#">Home</a></li>
                    <li class="active">Messages</li>
                </ul>
                <!-- END BREADCRUMB -->                
                                
                <!-- START CONTENT FRAME -->
                <div class="content-frame">                                    
                    <!-- START CONTENT FRAME TOP -->
                    <div class="content-frame-top">                        
                        <div class="page-title">                    
                            <h2><span class="fa fa-comments"></span> Messages</h2>
                        </div>                                                    
                        <div class="pull-right">                            
                            <a href="/jobNetwork/AllEntreprisesController" ><button class="btn btn-danger"><span class="fa fa-book"></span> Contacts</button></a>
                            <button class="btn btn-default content-frame-right-toggle"><span class="fa fa-bars"></span></button>
                        </div>                           
                    </div>
                    <!-- END CONTENT FRAME TOP -->
                    
                    <!-- START CONTENT FRAME RIGHT -->
                    <div class="content-frame-right">
                        
                        <div class="list-group list-group-contacts border-bottom push-down-10">
                        
                        <c:forEach items="${lastMessages }" var="onelastMsg" >
                         
                            <a href="/jobNetwork/MessagesContact?refContact=${onelastMsg.emetteur.num_etudiant }" class="list-group-item">                                 
                                <div class="list-group-status status-online"></div>
                                <img src="assets/images/users/no-image.jpg" class="pull-left" alt="Dmitry Ivaniuk">
                                <span class="contacts-title">${onelastMsg.emetteur.nom_etudiant } ${onelastMsg.emetteur.prenom_etudiant }</span>
                                <p>${onelastMsg.texte_msg }</p>
                            </a>                                
                            
                         </c:forEach>
                                                                                            
                            <!-- <a href="#" class="list-group-item active">         
                                <div class="list-group-status status-online"></div>
                                <img src="assets/images/users/no-image.jpg" class="pull-left" alt="John Doe">
                                <div class="contacts-title">John Doe <span class="label label-danger">5</span></div>
                                <p>This project is awesome</p>                                       
                            </a> -->
                                                     
                        </div>
                        
                        
                        
                    </div>
                    <!-- END CONTENT FRAME RIGHT -->
                
                    <!-- START CONTENT FRAME BODY -->
                    <div class="content-frame-body content-frame-body-left">
                        
                        <div class="messages messages-img" id="panelMessages" >
                        
                        
                        <c:forEach items="${messages }" var="onemsg" >
                        
                        <c:if test="${candidat.num_etudiant == onemsg.emetteur.num_etudiant }">
                            <div class="item in">
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
                            
                            <div class="item">
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
                            
                        </div>                        
                        
                        <div class="panel panel-default push-up-10">
                            <div class="panel-body panel-body-search">
                                <div class="input-group">
                                    <div class="input-group-btn">
                                        <button  class="btn btn-default"><span class="fa fa-comment"></span></button>
                                        
                                    </div>
                                    <input type="text" id="inputMsg" class="form-control" placeholder="Votre message..."/>
                                    <div class="input-group-btn">
                                        <button id="envoieMsg" class="btn btn-default">Envoi</button>
                                        <input type="hidden" id="refRecepteur" value="${refLastRecepteur }" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- END CONTENT FRAME BODY -->      
                </div>
                <!-- END PAGE CONTENT FRAME -->
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

        <!-- THIS PAGE PLUGINS -->
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        <!-- END PAGE PLUGINS -->     

        <!-- START TEMPLATE -->
        
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>        
        <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->       
    
    <script type="text/jscript" > 
	     $(document).ready(function(){

	    	 $("#envoieMsg").click(function(){


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
	    		 
	    		 var message = $("#inputMsg").val(); 
	    		 var recepteur = $("#refRecepteur").val();

	    		 $.post("/jobNetwork/MessagesContact",{"message":message,"fullDate":fullDate,"recepteur":recepteur},function(data){
	    			 
	    			 //$("div#panelMessages").append(data);
	       	         return false;
	       	     });

	    		 $("#inputMsg").val("");
	    		 /*$("div.page-content-wrap").height(300);*/
	    		
	    		 
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
    
    <script type="text/jscript" >
     $(document).ready(function (){

    	 setInterval(function(){refresh() }, 2000);
    
    	 function refresh() {
 			
     		 var recepteur = $("#refRecepteur").val();
     		
     		 $.post("/jobNetwork/refraichMsgController",{"recepteur":recepteur},function(dataa){
     			 
     			 $.post("refraichMsg.jsp",{},function(data){
     				
     			 	$("div#panelMessages").html(data);
     			 	return false;
 	       	     });

     			 
        	         return false;
        	     });
        	    
     		  
     	 }
 		 
    		  
     });
     
     </script>
    
    </body>
    
     

<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-messages.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:52:10 GMT -->
</html>






