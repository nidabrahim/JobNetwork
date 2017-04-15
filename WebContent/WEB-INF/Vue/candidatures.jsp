<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    
<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-mailbox-inbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:22 GMT -->
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
                    <li class="active">Candidatures</li>
                </ul>
                <!-- END BREADCRUMB -->                
                                
                <!-- START CONTENT FRAME -->
                <div class="content-frame">                                    
                    <!-- START CONTENT FRAME TOP -->
                    <div class="content-frame-top">                        
                        <div class="page-title">                    
                            <h2><span class="fa fa-inbox"></span> Candidatures <small></small></h2>
                        </div>                                                                                
                        
                        <div class="pull-right">                            
                            
                            <button class="btn btn-default content-frame-left-toggle"><span class="fa fa-bars"></span></button>
                        </div>                        
                    </div>
                    <!-- END CONTENT FRAME TOP -->
                    
                    <!-- START CONTENT FRAME LEFT -->
                    <div class="content-frame-left">
                        
                        <div class="block">
                            <div class="list-group border-bottom">
                                <a href="#" class="list-group-item active"><span class="fa fa-inbox"></span> Candidats <span class="badge badge-success">11</span></a>
                                <a href="#" class="list-group-item"><span class="fa fa-star"></span> Acceptations <span class="badge badge-warning">6</span></a>
                                <a href="#" class="list-group-item"><span class="fa fa-exclamation"></span> Refus <span class="badge badge-warning">5</span></a>
                                             
                            </div>                        
                        </div>
                        
                    </div>
                    <!-- END CONTENT FRAME LEFT -->
                    
                    <!-- START CONTENT FRAME BODY -->
                    <div class="content-frame-body">
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                
                                
                                                               
                                                                                                    
                                
                            </div>
                            <div class="panel-body  mail">
                                
                               <!-- 
                               <c:if test="${fn:length(candidatures) == '0'}">
                               <div style="text-align: center" >Aucune candidature</div>
                               </c:if>
                                -->
                               
                           
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table datatable">
                                            <thead>
                                                <tr>
                                                    <th>Candidat</th>
                                                    <th>Offre</th>
                                                    <th>Statut</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                
                                                <c:forEach items="${candidatures }" var="cand" >
                                                <tr>
                                                    <td>${cand.etudiant.nom_etudiant}</td>
                                                    <td>${cand.stage.intitule_du_stage }</td>
                                                    
                                                    <td>
                                                    	<c:if test="${cand.validation == '0'}">
                                                    		<span class="label label-warning">En attente</span>
                                                    	</c:if> 
														<c:if test="${cand.validation == '1'}">
															<span class="label label-info">Acceptée</span>
                                                    	</c:if>
                                                    </td>
                                                    <td>
                                                    	<a href="LettreDeMotivation?idEtd=${cand.etudiant.num_etudiant }&&idStg=${cand.stage.num_stage }" class="mail-text">
                                                    		<span class="glyphicon glyphicon-eye-open"></span>
                                                    	</a> 
                                                    </td>
                                                    
                                                </tr>
                                                </c:forEach>
                                                
                                                
                                            </tbody>
                                        </table>
                                     </div>
                                 </div>
                               
                                
                                <!-- 
                                <c:forEach items="${candidatures }" var="cand" >

								<c:if test="${cand.validation == '0'}"> 
								 <div class="mail-item mail-unread mail-danger">                                    
								     
								     <div class="mail-user">${cand.etudiant.nom_etudiant}</div>                                    
								     <a href="LettreDeMotivation?idEtd=${cand.etudiant.num_etudiant }&&idStg=${cand.stage.num_stage }" class="mail-text">${cand.stage.intitule_du_stage }</a>                                    
								     <div class="mail-date">
								     	<button onclick="location.href='AcceptationCandidature?codeEtd=${cand.etudiant.num_etudiant}&&codeStg=${cand.stage.num_stage }';" class="btn btn-info btn-condensed"><i class="fa fa-check"></i></button>
								     	<button onclick="location.href='RefusCandidature?codeEtd=${cand.etudiant.num_etudiant}&&codeStg=${cand.stage.num_stage }';" class="btn btn-danger btn-condensed"><i class="fa fa-times"></i></button>
								     </div>
								 </div>
								</c:if> 
								<c:if test="${cand.validation == '1'}">  
								  <div class="mail-item mail-unread mail-info">                                    
								  
								     <div class="mail-user">${cand.etudiant.nom_etudiant }</div>                                    
								     <a href="LettreDeMotivation?idEtd=${cand.etudiant.num_etudiant }&&idStg=${cand.stage.num_stage }" class="mail-text">${cand.stage.intitule_du_stage }</a>                                    
								     <div class="mail-date">
								     	<button  class="btn btn-info btn-condensed"><i class="fa fa-check"></i></button>
								     	
								     </div>
								 </div>
								 
								</c:if> 
								</c:forEach>
                                -->
                                
                                
                                                                
                                
                            </div>
                            
                            <!--  
                            <div class="panel-footer">                                
                                
                            </div> -->                           
                        </div>
                        
                    </div>
                    <!-- END CONTENT FRAME BODY -->
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

		<script type="text/javascript" src="js/plugins/datatables/jquery.dataTables.min.js"></script>
		
        <!-- START THIS PAGE PLUGINS-->        
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-datepicker.js"></script>     
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

<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-mailbox-inbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:22 GMT -->
</html>






