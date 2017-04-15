<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    
<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-mailbox-message.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:22 GMT -->
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
        <link rel="stylesheet" type="text/css" id="theme" href="css/theme-default2.css"/>
      
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
                    <li><a href="#">Boite de reception</a></li>
                    <li class="active">Message</li>
                </ul>
                <!-- END BREADCRUMB -->                
                
                <!-- START CONTENT FRAME -->
                <div class="content-frame">                                    
                    <!-- START CONTENT FRAME TOP -->
                    <div class="content-frame-top">                        
                        <div class="page-title">                    
                            <h2><span class="fa fa-file-text"></span> Lettre de motivation</h2>
                        </div>                                                                                
                        
                        <div class="pull-right">                                                                                    
                           
                            <button class="btn btn-default content-frame-left-toggle"><span class="fa fa-bars"></span></button>
                        </div>                        
                    </div>
                    <!-- END CONTENT FRAME TOP -->
                    <div class="contCvLettre" >
                    <!-- START CONTENT FRAME LEFT -->
                    <div style="float : left;width: 325px;height: 534px;padding-top: 28px;background: rgba(0, 0, 0, 0.02);border-right: 1px solid #DDD;">
                    
                    
                        
                        <div class="row"  >
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">                            
                                    <h4>LETTRE DE MOTIVATION </h4>
                            
                            <div class="panel-body" style="padding: 6px;font-size: 13px;border: 1px black;border: 1px solid #DDD;background: rgba(0, 0, 0, 0.02);" >
                            	<p><strong>Offre : ${postulaLTM.stage.intitule_du_stage}</strong></p>
                                
                                ${postulaLTM.lettre_motivation}
                                
                                
                            </div>
                            
                            
                        </div>
                        </div>
                        </div>
                        </div></div>
                        
                   
                    <!-- END CONTENT FRAME LEFT -->
                    
                    <!-- START CONTENT FRAME BODY -->
                    <div class="content-frame-body" style="margin-left: 315px;" >
                        
                        <c:if test="${postulaLTM.validation == '0'}">
	                        <div class="pull-right">
	                        	<div class="mail-date">
									<button onclick="location.href='AcceptationCandidature?codeEtd=${postulaLTM.etudiant.num_etudiant}&&codeStg=${postulaLTM.stage.num_stage }';" class="btn btn-info btn-condensed"><i class="fa fa-check"></i></button>
									<button onclick="location.href='RefusCandidature?codeEtd=${postulaLTM.etudiant.num_etudiant}&&codeStg=${postulaLTM.stage.num_stage }';" class="btn btn-danger btn-condensed"><i class="fa fa-times"></i></button>
								</div>
	                        </div>
	                        <br><br>
                        </c:if> 
                        
                     
                            
                            
                                
                       <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">                            
                                    <h2>CURRICULUM VITAE </h2>
                                 
                                    <!-- INVOICE -->
                                    <div class="invoice">

                                        <div class="row">
                                            <div class="col-md-4">

                                                <div class="invoice-address">
                                                    <h5>${candidat.nom_etudiant } ${candidat.prenom_etudiant }</h5>
                                                    <p>${candidat.email_etudiant }</p>
                                                    <p>${candidat.adresse_etudiant }</p>
                                                    <p>${candidat.code_postal } ${candidat.ville_etudiant } </p>
                                                    <p>${candidat.tel_gsm_etudiant }</p>
                                                    <p>${candidat.tel_fixe_etudiant }</p>
                                                </div>

                                            </div>
                                            <div class="col-md-8">

                                                <div class="invoice-address text-center">
                                                    <h3></h3>
                                                                        
                                                </div>                                        

                                            </div>

                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="invoice-address">
                                                    <table class="table table-striped">
                                                        <thead><h3>Langues</h3></thead>
                                                        
                                                     <c:forEach items="${ListeLangue }" var="lgnlangue" >
                                                        
                                                        <tr>
                                                            <td width="200">${lgnlangue.langue.libele_langue }</td><td class="text-right">${lgnlangue.niv_langue.libele_niv_langue }</td>
                                                        </tr>
                                                        
                                                     </c:forEach>
                                                        
                                                        
                                                    </table>

                                                </div>                                        

                                            </div>
                                            <div class="col-md-9">

                                                <table class="table">
                                                    <thead> <h3>Formations</h3></thead>
                                                    
                                                 <c:forEach items="${ListeFormation }" var="formation" >
                                                    
                                                    <tr>
                                                        <td>
                                                            <strong>${formation.libele_formation }</strong>
                                                            <p>Diplome de ${formation.type_formation } en ${formation.domaine_formation } specialise en ${formation.libele_formation } </p>
                                                        </td>
                                                        <td class="text-center">${formation.type_formation }</td>
                                                        <td class="text-center">${formation.domaine_formation }</td>
                                                        
                                                    </tr>
                                                    
                                                  </c:forEach>
                                                    
                                                </table>
                                            </div>
                                        </div>

                                        <div class="row">
                                              <div class="col-md-3">
                                                <div class="invoice-address">
                                                    <table class="table table-striped">
                                                        <thead><h3>Logiciels</h3></thead>
                                                        
                                                     <c:forEach items="${ListeCompetence }" var="competence" >
                                                        
                                                        <tr>
                                                            <td width="200">${competence.logiciel.libele_logiciel }</td><td class="text-right">${competence.niv_logiciel.libele_logiciel }</td>
                                                        </tr>
                                                        
                                                     </c:forEach>
                                                        
                                                    </table>

                                                </div>                                        

                                            </div>
                                            <div class="col-md-9">

                                                <table class="table">
                                                    <thead> <h3>Experience professionnel</h3></thead>
                                                    
                                                <c:forEach items="${ListeExperiencePros }" var="expro" >
                                                    
                                                    <tr>
                                                        <td>
                                                            <strong>${expro.fonction }</strong>
                                                            <p>${expro.employeur_experience_pro }</p>
                                                        </td>
                                                        <td class="text-center"></td>
                                                        <td class="text-center">${expro.date_debut }</td>
                                                        <td class="text-center">${expro.date_fin }</td>
                                                    </tr>
                                                    
                                                 </c:forEach>
                                                    
                                                    
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END INVOICE -->

                                </div>
                            </div>
                        </div>

                    </div>
                                
                            
                            
                            
                        
                        
                        
                        <!-- 
                           <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="pull-left">
                                    <img src="assets/images/users/user2.jpg" class="panel-title-image" alt="John Doe"/>
                                    <h3 class="panel-title">${postulaLTM.etudiant.nom_etudiant} ${postulaLTM.etudiant.prenom_etudiant} <small>${postulaLTM.etudiant.email_etudiant}</small></h3>
                                </div>
                                
                            </div>
                            <div class="panel-body">
                                <h3>Offre intitule "${postulaLTM.stage.intitule_du_stage}" <small class="pull-right text-muted"><span class="fa fa-clock-o"></span></small></h3>
                                ${postulaLTM.lettre_motivation}
                                
                                
                            </div>
                            
                            <div class="panel-footer">
                                
                            </div>
                        </div>  -->
                    </div>
                    <!-- END CONTENT FRAME BODY -->
                    </div>
                </div>
                <!-- END CONTENT FRAME -->                    
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
        
        <script type="text/javascript" src="js/plugins/summernote/summernote.js"></script>    
        <!-- END THIS PAGE PLUGINS-->        

        <!-- START TEMPLATE -->
      
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>        
        <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->
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

<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-mailbox-message.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:23 GMT -->
</html>






