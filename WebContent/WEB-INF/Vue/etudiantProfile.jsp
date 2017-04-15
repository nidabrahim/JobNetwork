<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
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
           
                <!-- START X-NAVIGATION -->
            <%@ include file="menubar.jsp" %>
                <!-- END X-NAVIGATION -->
           
            <!-- END PAGE SIDEBAR -->

            <!-- PAGE CONTENT -->
            <div class="page-content">

                <!-- START X-NAVIGATION VERTICAL -->
                <%@ include file="menuHeader.jsp" %>
                <!-- END X-NAVIGATION VERTICAL -->                     

                <!-- START BREADCRUMB -->
                <ul class="breadcrumb">
                    <li><a href="#">Profil</a></li>                    
                </ul>
                <!-- END BREADCRUMB -->                       

                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">

                    <!-- START WIDGETS -->                    
                    <div class="row">
                        <div class="col-md-3">

                  <!-- START WIDGET SLIDER -->
                            <div class="widget widget-default widget-carousel">
                                <div class="owl-carousel" id="owl-example">
                                    <div>                                    
                                        <div class="widget-title">Total Offres</div>                                                                        
                                        <div class="widget-subtitle">Depuis inscription</div>
                                        <div class="widget-int">13</div>
                                    </div>
                                    <div>                                    
                                            <div class="widget-title">Stage Accepté</div>
                                        <div class="widget-subtitle">Depuis inscription</div>
                                        <div class="widget-int">${nbrpostulAccept }</div>
                                    </div>
                                    <div>                                    
                                        <div class="widget-title">Stage refus</div>
                                        <div class="widget-subtitle">Depuis inscription</div>
                                        <div class="widget-int">${nbrpostulRefus }</div>
                                    </div>
                                </div>                            
                                                             
                            </div>         
                            <!-- END WIDGET SLIDER -->

                        </div>
                        <div class="col-md-3">

                            <!-- START WIDGET MESSAGES -->
                            <div class="widget widget-default widget-item-icon" onclick="location.href = 'pages-messages.html';">
                                <div class="widget-item-left">
                                    <span class="fa fa-envelope"></span>
                                </div>                             
                                <div class="widget-data">
                                    <div class="widget-int num-count">10</div>
                                    <div class="widget-title">Nouveau messages</div>
                                    <div class="widget-subtitle">voir MailBox</div>
                                </div>
                            </div>                            
                            <!-- END WIDGET MESSAGES -->

                        </div>
                        <div class="col-md-3">

                            <!-- START WIDGET REGISTRED -->
                            <div class="widget widget-default widget-item-icon" onclick="location.href = 'pages-address-book.html';">
                                <div class="widget-item-left">
                                    <span class="fa fa-suitcase"></span>
                                </div>
                                <div class="widget-data">
                                    <div class="widget-int num-count">${nbrpostul }</div>
                                    <div class="widget-title">Demande</div>
                                    <div class="widget-subtitle">de stage</div>
                                </div>                           
                            </div>                            
                            <!-- END WIDGET REGISTRED -->

                        </div>
                        <div class="col-md-3">

                            <!-- START WIDGET CLOCK -->
                            <div class="widget widget-danger widget-padding-sm">
                                <div class="widget-big-int plugin-clock">00:00</div>                            
                                <div class="widget-subtitle plugin-date">Loading...</div>
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="left" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>                            
                                <div class="widget-buttons widget-c3">
                                    <div class="col">
                                        <a href="#"><span class="fa fa-clock-o"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-bell"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-calendar"></span></a>
                                    </div>
                                </div>                            
                            </div>                        
                            <!-- END WIDGET CLOCK -->

                        </div>
                    </div>
                    <!-- END WIDGETS -->                    

                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-body">                            
                                    <h2>CURRICULUM VITAE </h2>
                                 
                                    
                                    <div class="push-down-10 pull-right">
                                                                              
                                    </div>
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
                                                    <h5></h5>                      
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
            <script type="text/javascript" src="js/plugins/scrolltotop/scrolltopcontrol.js"></script>

            <script type="text/javascript" src="js/plugins/morris/raphael-min.js"></script>
            <script type="text/javascript" src="js/plugins/morris/morris.min.js"></script>       
            <script type="text/javascript" src="js/plugins/rickshaw/d3.v3.js"></script>
            <script type="text/javascript" src="js/plugins/rickshaw/rickshaw.min.js"></script>
            <script type='text/javascript' src='js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'></script>
            <script type='text/javascript' src='js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'></script>                
            <script type='text/javascript' src='js/plugins/bootstrap/bootstrap-datepicker.js'></script>                
            <script type="text/javascript" src="js/plugins/owl/owl.carousel.min.js"></script>                 

            <script type="text/javascript" src="js/plugins/moment.min.js"></script>
            <script type="text/javascript" src="js/plugins/daterangepicker/daterangepicker.js"></script>
            <!-- END THIS PAGE PLUGINS-->        

            <!-- START TEMPLATE -->
           

            <script type="text/javascript" src="js/plugins.js"></script>        
            <script type="text/javascript" src="js/actions.js"></script>

            <script type="text/javascript" src="js/demo_dashboard.js"></script>
            <!-- END TEMPLATE -->
            <!-- END SCRIPTS -->
            <script>
                                (function (i, s, o, g, r, a, m) {
                                    i['GoogleAnalyticsObject'] = r;
                                    i[r] = i[r] || function () {
                                        (i[r].q = i[r].q || []).push(arguments)
                                    }, i[r].l = 1 * new Date();
                                    a = s.createElement(o),
                                            m = s.getElementsByTagName(o)[0];
                                    a.async = 1;
                                    a.src = g;
                                    m.parentNode.insertBefore(a, m)
                                })(window, document, 'script', '../../../../www.google-analytics.com/analytics.js', 'ga');

                                ga('create', 'UA-36783416-1', 'auto');
                                ga('send', 'pageview');
            </script>
            <!-- Yandex.Metrika counter -->
            <script type="text/javascript">
                (function (d, w, c) {
                    (w[c] = w[c] || []).push(function () {
                        try {
                            w.yaCounter25836617 = new Ya.Metrika({
                                id: 25836617,
                                clickmap: true,
                                trackLinks: true,
                                accurateTrackBounce: true,
                                webvisor: true
                            });
                        } catch (e) {
                        }
                    });

                    var n = d.getElementsByTagName("script")[0],
                            s = d.createElement("script"),
                            f = function () {
                                n.parentNode.insertBefore(s, n);
                            };
                    s.type = "text/javascript";
                    s.async = true;
                    s.src = "../../../../mc.yandex.ru/metrika/watch.js";

                    if (w.opera == "[object Opera]") {
                        d.addEventListener("DOMContentLoaded", f, false);
                    } else {
                        f();
                    }
                })(document, window, "yandex_metrika_callbacks");
            </script>
            <noscript><div><img src="https://mc.yandex.ru/watch/25836617" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
            <!-- /Yandex.Metrika counter -->    
    </body>

    <!-- Mirrored from aqvatarius.com/themes/atlant/html/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:43:29 GMT -->
</html>
