<!DOCTYPE html>
<html lang="en">
    
<!-- Mirrored from aqvatarius.com/themes/atlant/html/form-layouts-separated.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:55:10 GMT -->
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
        <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="css/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="css/custom.min.css" rel="stylesheet">
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
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                
                    <div class="row">
                        <div class="col-md-12">
                            
                            
                               
                                
                             <!-- START DEFAULT WIZARD -->
                            <div class="panel panel-default">
                                <div class="panel-body">   
                                    <h3>Ajout offre</h3>
                                    <div class="wizard">

                                        <ul>
                                            <li>
                                                <a href="#step-1">
                                                    <span class="stepNumber">1</span>
                                                    <span class="stepDesc">Etape 1<br /><small>Informations generales</small></span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-2">
                                                    <span class="stepNumber">2</span>
                                                    <span class="stepDesc">Etape 2<br /><small>Technologies requises</small></span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-3">
                                                    <span class="stepNumber">3</span>
                                                    <span class="stepDesc">Etape 3<br /><small>Formations</small></span>                   
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-4">
                                                    <span class="stepNumber">4</span>
                                                    <span class="stepDesc">Etape 4<br /><small>Langues</small></span>                   
                                                </a>
                                            </li>
                                        </ul>
                                        
                                        <br/>
                                        <br/>
                                        <br/>
               <form class="form-horizontal" style="margin-top: 60px;" action="AjoutOffre" method="POST"  >
               
                                        <div id="step-1">   
                                        
                                            <h4>Etape 1 Informations generales</h4>
                                            
                                    <!--        <form class="form-horizontal"> -->
                            					<div class="panel panel-default">
                                           			<div class="panel-body form-group-separated">
                                    
                                    					<div class="form-group">
                                        					<label class="col-md-3 col-xs-12 control-label">Intitule</label>
                                        						<div class="col-md-6 col-xs-12">                                            
                                           						 <div class="input-group">
                                            					    <span class="input-group-addon"><span class="fa fa-pencil"></span></span>
                                           						     <input type="text" class="form-control" name="intitule" />
                                           							 </div>                                            
                                            							<span class="help-block">Le titre de stage</span>
                                        						</div>
                                    					</div>
                                    
					                                    <div class="form-group">
					                                        <label class="col-md-3 col-xs-12 control-label">Description</label>
					                                        <div class="col-md-6 col-xs-12">                                            
					                                            <textarea class="form-control" rows="5" name="description" ></textarea>
					                                            <span class="help-block">La description de l'offre</span>
					                                        </div>
					                                    </div>
                                    
                                   
                                					</div>
                                				</div>
                                		<!-- 	</form> -->
                                            
                                            
                                       
                                        </div>
                                        
                                        <div id="step-2">
                                            
                                            <h4>Etape 2 Technologies requises</h4>
                                        
                                            <div class="col-md-12 column">
                        
						<table class="table table-bordered table-hover" id="tab_logic">
							<thead>
								<tr>
									<th class="text-center">Technologie</th>
									<th class="text-center">Statut</th>
									
								</tr>
							</thead>
							<tbody>
								
                    			<tr id='addr1'></tr>
							</tbody>
						</table>
						
						</div>
						
						<a id="add_row" class="btn btn-default pull-left" data-toggle="modal" data-target="#ajouter_technologie" >Ajouter</a>
                                        
                        </div>                      
                                        <div id="step-3">
                                            <h4>Etape 3 Formations</h4>
                                            
                                            
                                            <div class="col-md-12 column">
                        
						<table class="table table-bordered table-hover" id="tab_logicf">
							<thead>
								<tr>
									<th class="text-center">Formation</th>
									<th class="text-center">Type</th>
									<th class="text-center">Domaine</th>
									
									
								</tr>
							</thead>
							<tbody>
								
                    			<tr id='addrf1'></tr>
                    			
							</tbody>
						</table>
						
						</div>
						
						<a id="add_row" class="btn btn-default pull-left" data-toggle="modal" data-target="#ajouter_formation" >Ajouter</a>
                        
                                            
                                            
                                        </div>
                                        <div id="step-4">
                                            <h4>Etape 4 Langues</h4>
                                            
                                            
                                            <div class="col-md-12 column">
                        
						<table class="table table-bordered table-hover" id="tab_logicl">
							<thead>
								<tr>
									<th class="text-center">Langue</th>
									<th class="text-center">Statut</th>
									
								</tr>
							</thead>
							<tbody>
								
                    			<tr id='addrl1'></tr>
							</tbody>
						</table>
						
						</div>
						
						<a id="add_row" class="btn btn-default pull-left" data-toggle="modal" data-target="#ajouter_langue" >Ajouter</a>
						<!--  <input type="submit" class="btn btn-primary pull-right" value="Publier l'offre" />-->
						<button class="btn btn-primary pull-right">Ajouter</button>
                                           
                                        </div>                           

				</form>						

                                    </div>
                                </div>
                            </div>                                       
                            <!-- END DEFAULT WIZARD -->
                                
                                
                                
                           
                            
                        </div>
                    </div>                    
                    
                </div>
                <!-- END PAGE CONTENT WRAPPER -->                                                
            </div>            
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->
        
        <div class="modal animated fadeIn" id="ajouter_langue" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="smallModalHead">Ajouter une langue</h4>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-body form-horizontal form-group-separated">                        
                        
                                    <div class="panel-body form-group-separated">
                                    <div class="form-group" id="languee" >
                                        <label class="col-md-3 col-xs-5 control-label">Langue</label>
                                        <div class="col-md-9 col-xs-7">
                                            <select class="validate[required] select" id="formGender">
                                                    <option value="">Langue</option>
                                                    <option value="1">Français</option>
                                                    <option value="2">Anglais</option>
                                                    <option value="3">Arabe</option>
                                                </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label"></label>
                                        <div class="col-md-9 col-xs-7">
                                            
                                            <label class="check"><input type="checkbox" class="icheckbox" checked="checked"/> Obligatoire</label>
                                            
                                        </div>
                                        
                                    </div>
                                   
                                    
                                
                                    
                                    
                                </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" id="valideLangue" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal animated fadeIn" id="ajouter_formation" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="smallModalHead">Ajouter une formation</h4>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-body form-horizontal form-group-separated">                        
                        
                                    <div class="panel-body form-group-separated">
                                    <div class="form-group"  id="formation">
                                        <label class="col-md-3 col-xs-5 control-label">Formation</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="" placeholder="Libelle formation" class="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label"></label>
                                        <div class="col-md-9 col-xs-7">
                                        	<div  style="width:49%;float:left">
                                        		<select class="validate[required] select" id="formGender" name="select"  >
                                                    <option value="">Type</option>
                                                    <option value="1">Deug</option>
                                                    <option value="2">Licence</option>
                                                    <option value="3">Cycle d'ingenieur</option>
                                                    <option value="4">sql</option>
                                                </select>
                                             </div>
                                             <div  style="width:49%;float:right" >
                                        		<select class="validate[required] select" id="formGender" >
                                                    <option value="">Domaine</option>
                                                    <option value="1">Genie logiciel</option>
                                                    <option value="2">business intelligence</option>
                                                    <option value="3">Logistique</option>
                                                    <option value="4">Securite</option>
                                                </select>
                                             </div>
                                          
                                        </div>
                                        
                                    </div>
                                   
                                    
                                </div>
                                    
                                    
                                
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" id="valideFormation" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal animated fadeIn" id="ajouter_technologie" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="smallModalHead">Ajouter une competence</h4>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-body form-horizontal form-group-separated">                        
                        
                                    <div class="panel-body form-group-separated">
                                    <div class="form-group" id="tech" >
                                        <label class="col-md-3 col-xs-5 control-label"  >Technologie</label>
                                        <div class="col-md-9 col-xs-7">
                                            <select class="validate[required] select" id="formGender">
                                                    <option value="">Technologie</option>
                                                    <option value="1">Java</option>
                                                    <option value="2">UML</option>
                                                    <option value="3">J2ee</option>
                                                    <option value="4">sql</option>
                                                </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label"></label>
                                        <div class="col-md-9 col-xs-7">
                                            
                                            <label class="check"><input type="checkbox" class="icheckbox" checked="checked"/> Obligatoire</label>
                                            
                                        </div>
                                        
                                    </div>
                                    
                                    
                                   
                                    
                               
                                    
                                    
                                </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" id="valideTech" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
        
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
        
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-datepicker.js"></script>                
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-file-input.js"></script>
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-select.js"></script>
        <script type="text/javascript" src="js/plugins/tagsinput/jquery.tagsinput.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/smartwizard/jquery.smartWizard-2.0.min.js"></script>        
        <script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.js"></script>
        
        <!-- END PAGE PLUGINS -->
        
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
    <!-- Technologies -->
    <script type="text/jscript" > 
     $(document).ready(function(){
    	 
      	var i=1;
      
     	$("#valideTech").click(function(){
     		
     		var j=i;

     		var numlog = $("#tech").children().next().find("option:selected").attr("value");
     		var isOblg;
     		
     		var log = $("#tech").children().next().find("option:selected").text();
     		var oblg = $("#tech").next().children().next().children().find(".icheckbox");
     		if(oblg.is(':checked')){
         		isOblig = "1";
     			$('#addr'+i).html("<td>"+log+"</td> <td>Obligatoire</td>");
     			
         	}else{
         		 isOblig = "0";
             	 $('#addr'+i).html("<td>"+log+"</td> <td>Facultative</td>");
         	}

     		
      		

      		$('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');

			$.post("moreTechnologies.jsp",{"numlog":numlog,"oblig":isOblig},function(data){

     	         return false;
     	    });

      		$("div.stepContainer").height(function(n,c){
      	        return c+50;
      	        });
  	        
      		
      		
      		i++; 
      		
      		$('div.rw').html(result);

      		
      		
     	
  		});
     	
     	
     	
     	
		
     		
     	});


    </script>
    <!-- Formations -->
    <script type="text/jscript" > 
     $(document).ready(function(){
    	 
      	var i=1;
      
     	$("#valideFormation").click(function(){
     		
     		var j=i;
     		var data = {};
     		


     		var formation = $("#formation").children().next().children().val();
     		var type = $("#formation").next().children().next().children().find("select[name='select']").find("option:selected").text();
     		var domaine = $("#formation").next().children().next().children().next().find("option:selected").text();
     
     		//var numtype = $("#formation").next().children().next().children().find("select[name='select']").find("option:selected").attr("value");
     		//var numdomaine = $("#formation").next().children().next().children().next().find("option:selected").attr("value");
         	
     		$('#addrf'+i).html("<td>"+formation+"</td> <td>"+type+"</td> <td>"+domaine+"</td> ");
     			
         
      		$('#tab_logicf').append('<tr id="addrf'+(i+1)+'"></tr>');

      		$.post("moreFormations.jsp",{"formation":formation,"type":type,"domaine":domaine},function(data){

      	         return false;
      	    });

      		$("div.stepContainer").height(function(n,c){
      	        return c+50;
      	        });
  	        
      		
      		
      		i++; 
      		
      		$('div.rw').html(result);

      		
      		
     	
  		});
     	
     	
     	
     	
		
     		
     	});


    </script>
    <!-- Langues -->
    <script type="text/jscript" > 
     $(document).ready(function(){
    	 
      	var i=1;
      
     	$("#valideLangue").click(function(){
     		
     		var j=i;
     		var data = {};

     		var numlang = $("#languee").children().next().find("option:selected").attr("value");
     		var isOblg;
     		
     		var lang = $("#languee").children().next().find("option:selected").text();
     		var oblg = $("#languee").next().children().next().children().find(".icheckbox");
     		if(oblg.is(':checked')){
     			isOblig = "1";
     			$('#addrl'+i).html("<td>"+lang+"</td> <td>Obligatoire</td>");
     			
         	}else {
         		isOblig = "0";
             	$('#addrl'+i).html("<td>"+lang+"</td> <td>Facultative</td>");
         	}
     		
     		
      		$('#tab_logicl').append('<tr id="addrl'+(i+1)+'"></tr>');

      		$.post("moreLangues.jsp",{"numlang":numlang,"oblig":isOblig},function(data){

   	         return false;
   	    	});

      		$("div.stepContainer").height(function(n,c){
      	        return c+50;
      	        });
  	        
      		
      		
      		i++; 
      		
      		$('div.rw').html(result);

      		
      		
     	
  		});
     	
     	
     	
     	
		
     		
     	});


    </script>
    <noscript><div><img src="https://mc.yandex.ru/watch/25836617" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
    <!-- /Yandex.Metrika counter -->    
    </body>

<!-- Mirrored from aqvatarius.com/themes/atlant/html/form-layouts-separated.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:55:10 GMT -->
</html>






