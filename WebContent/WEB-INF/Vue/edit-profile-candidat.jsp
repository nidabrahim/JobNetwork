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
        <link rel="stylesheet" type="text/css" href="css/cropper/cropper.min.css"/>
        <!--  EOF CSS INCLUDE -->        
        
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
                    <li class="active">Profile</li>
                </ul>
                <!-- END BREADCRUMB -->                                                
                
                <!-- PAGE TITLE -->
                <div class="page-title">                    
                    <h2><span class="fa fa-cogs"></span> Profile</h2>
                </div>
                <!-- END PAGE TITLE -->                     
                
                <!-- PAGE CONTENT WRAPPER -->
                <div class="page-content-wrap">
                    
                    <div class="row">
                       <!--  <div class="col-md-12">
                            <div class="alert alert-warning" role="alert">
                                <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">?</span><span class="sr-only">Close</span></button>
                                <strong>Important!</strong> Main feature of this page is "Change photo" function. Press button "Change photo" and try to use this awesome feature.
                            </div>                            
                        </div> -->
                    </div>     
                    
                    <div class="row">                        
                        <div class="col-md-3 col-sm-4 col-xs-5">
                            <form id="jvalidate" role="form" class="form-horizontal" action="javascript:alert('Form #validate2 submited');">
                            
                            <div class="panel panel-default">                                
                                <div class="panel-body">
                                    <h3><span class="fa fa-user"></span> John Doe</h3>
                                    <p>Web Developer / Administrator</p>
                                    <div class="text-center" id="user_image">
                                        <img src="assets/images/users/no-image.jpg" class="img-thumbnail"/>
                                    </div>                                    
                                </div>
                                <div class="panel-body form-group-separated">
                                    
                                    <div class="form-group">                                        
                                        <div class="col-md-12 col-xs-12">
                                            <a href="#" class="btn btn-primary btn-block btn-rounded" data-toggle="modal" data-target="#modal_change_photo">Change Photo</a>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">#ID</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="5221" class="form-control" disabled/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Login</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="johndoe" class="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">E-mail</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="" name="email" class="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">                                        
                                        <div class="col-md-12 col-xs-12">
                                            <a href="#" class="btn btn-danger btn-block btn-rounded" data-toggle="modal" data-target="#modal_change_password">Change password</a>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                            </form>
                            
                        </div>
                        <div class="col-md-6 col-sm-8 col-xs-7">
                            
                            <form action="#" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3><span class="fa fa-pencil"></span> Informations generales</h3>
                                    <p>La visualisation et la mise a jour de CV.</p>
                                </div>
                                <div class="panel-body form-group-separated">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Nom</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Nom" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Prenom</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Prenom" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Date naissance</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="" class="mask_date form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Adresse</label>
                                        <div class="col-md-9 col-xs-7">
                                            <textarea class="form-control" rows="5"></textarea>
                                        </div>
                                    </div>                                          
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </form>
                            
                            <form action="#" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3><span class="fa fa-pencil"></span> Experience Professionnelle</h3>
                                    <p></p>
                                </div>
                                <div class="panel-body form-group-separated">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Entreprise</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="employeur" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Fonction</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Prenom" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Date</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Date debut" class="form-control" style="width:49%;float:left" />
                                            <input type="text" value="Date fin" class="form-control" style="width:49%;float:right" />
                                            
                                        </div>
                                        
                                    </div>
                                                                            
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="panel-body form-group-separated">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Entreprise</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="employeur" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Fonction</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Prenom" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Date</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Date debut" class="form-control" style="width:49%;float:left" />
                                            <input type="text" value="Date fin" class="form-control" style="width:49%;float:right" />
                                            
                                        </div>
                                        
                                    </div>
                                                                            
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12 col-xs-12" style="padding-top:10px;padding-bottom:10px">
                                            <a  style="width:60%;margin-left:20%" href="#" class="btn btn-danger btn-block btn-rounded" data-toggle="modal" data-target="#ajouter_poste">Ajouter un poste</a>
                                    </div>
                                    
                                </div>
                                
                            </div>
                            </form>
                            
                            <form action="#" class="form-horizontal">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3><span class="fa fa-pencil"></span> Formations</h3>
                                    <p></p>
                                </div>
                                <div class="panel-body form-group-separated">
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Formation</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="" placeholder="Libelle formation" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label"></label>
                                        <div class="col-md-9 col-xs-7">
                                            
                                        	<div  style="width:49%;float:left">
                                        		<select class="validate[required] select" id="formGender"  >
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
                                                    <option value="2">Busniss intelegent</option>
                                                    <option value="3">Logistique</option>
                                                    <option value="4">Securite</option>
                                                </select>
                                             </div>
                                          
                                       
                                            
                                        </div>
                                        
                                    </div>
                                                                            
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="panel-body form-group-separated">
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Formation</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="" placeholder="Libelle formation" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label"></label>
                                        <div class="col-md-9 col-xs-7">
                                            
                                        	<div  style="width:49%;float:left">
                                        		<select class="validate[required] select" id="formGender"  >
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
                                                    <option value="2">Busniss intelegent</option>
                                                    <option value="3">Logistique</option>
                                                    <option value="4">Securite</option>
                                                </select>
                                             </div>
                                          
                                       
                                            
                                        </div>
                                        
                                    </div>
                                                                            
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="col-md-12 col-xs-12 form-group-separated" style="padding-top:10px;padding-bottom:10px">
                                       <a  style="width:60%;margin-left:20%" href="#" class="btn btn-danger btn-block btn-rounded" data-toggle="modal" data-target="#ajouter_formation">Ajouter un poste</a>
                                 </div>
                                
                            </div>
                            </form>
                            
                           <!--  <div class="panel panel-default tabs">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab1" data-toggle="tab">Contacts</a></li>
                                    <li><a href="#tab2" data-toggle="tab">Send Message</a></li>                                    
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane panel-body active" id="tab1">                                                                                
                                        
                                        <div class="list-group list-group-contacts border-bottom">
                                            <a href="#" class="list-group-item">            
                                                <div class="list-group-status status-online"></div>
                                                <img src="assets/images/users/user3.jpg" class="pull-left" alt="Nadia Ali">
                                                <span class="contacts-title">Nadia Ali</span>
                                                <p>Singer-Songwriter</p>                                    
                                                <div class="list-group-controls">
                                                    <button class="btn btn-primary btn-rounded"><span class="fa fa-pencil"></span></button>
                                                </div>                                    
                                            </a>                                                                
                                            <a href="#" class="list-group-item">                   
                                                <div class="list-group-status status-online"></div>
                                                <img src="assets/images/users/user.jpg" class="pull-left" alt="Dmitry Ivaniuk">
                                                <span class="contacts-title">Dmitry Ivaniuk</span>
                                                <p>Web Developer/Designer</p>                                    
                                                <div class="list-group-controls">
                                                    <button class="btn btn-primary btn-rounded"><span class="fa fa-pencil"></span></button>
                                                </div>                                    
                                            </a>
                                            <a href="#" class="list-group-item">                   
                                                <div class="list-group-status status-away"></div>
                                                <img src="assets/images/users/user2.jpg" class="pull-left" alt="John Doe">
                                                <span class="contacts-title">John Doe</span>
                                                <p>UI/UX Designer</p>                     
                                                <div class="list-group-controls">
                                                    <button class="btn btn-primary btn-rounded"><span class="fa fa-pencil"></span></button>
                                                </div>
                                            </a>                                
                                        </div>
                                        
                                    </div>
                                    <div class="tab-pane panel-body" id="tab2">                                        
                                        <p>Feel free to contact us for any issues you might have with our products.</p>
                                        <div class="form-group">
                                            <label>E-mail</label>
                                            <input type="email" class="form-control" placeholder="youremail@domain.com">
                                        </div>
                                        <div class="form-group">
                                            <label>Subject</label>
                                            <input type="email" class="form-control" placeholder="Message subject">
                                        </div>                                
                                        <div class="form-group">
                                            <label>Message</label>
                                            <textarea class="form-control" placeholder="Your message" rows="3"></textarea>
                                        </div>                                
                                    </div>                                                                        
                                    
                                </div>
                                
                            </div> -->

                        </div>
                        
                        <div class="col-md-3">
                            <div class="panel panel-default form-horizontal">
                                <div class="panel-body">
                                    <h3><span class="fa fa-info-circle"></span> Contact</h3>
                                    <p>Les informations de contact</p>
                                </div>
                                <div class="panel-body form-group-separated">                                    
                                    <div class="form-group">
                                        <label class="col-md-4 col-xs-5 control-label">Tel GSM</label>
                                        <div class="col-md-8 col-xs-7 line-height-30">
                                        <input type="text" value="" class="mask_phone form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 col-xs-5 control-label">Tel Fixe</label>
                                        <div class="col-md-8 col-xs-7 line-height-30">
                                        <input type="text" value="" class="mask_phone form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 col-xs-5 control-label">CP</label>
                                        <div class="col-md-8 col-xs-7">
                                        <input type="text" value="Code postal" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 col-xs-5 control-label">Ville</label>
                                        <div class="col-md-8 col-xs-7 line-height-30">
                                        <input type="text" value="Ville" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                            
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h3><span class="fa fa-cog"></span> Langues</h3>
                                    <p></p>
                                </div>
                                <div class="panel-body form-horizontal form-group-separated">                                    
                                    <div class="form-group">
                                        <label class="col-md-4 col-xs-5 control-label">Francais</label>
                                        <div class="col-md-8 col-xs-7">
                                        	<select class="validate[required] select" id="formGender">
                                                    <option value="">Niveau</option>
                                                    <option value="1">Courant</option>
                                                    <option value="0">Intermidiaire</option>
                                                </select>
                                           <!--   <label class="switch">
                                                <input type="checkbox" checked value="1"/>
                                                <span></span>
                                            </label> -->
                                        </div>
                                    </div>                                    
                                    
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                            <a  style="width:50%" href="#" class="btn btn-danger btn-block btn-rounded" data-toggle="modal" data-target="#ajouter_langue">Ajouter</a>
                                    
                                        </div>
                                    </div>
                                    
                                    
                                            
                                    
                                    
                                    
                                </div>
                            </div>
                            
                            <div class="panel panel-default form-horizontal">
                                <div class="panel-body">
                                    <h3><span class="fa fa-info-circle"></span> Competences</h3>
                                    <p></p>
                                </div>
                                <div class="panel-body form-group-separated">                                    
                                    <div class="form-group">
                                        <label class="col-md-4 col-xs-5 control-label">Logiciek1</label>
                                        <div class="col-md-8 col-xs-7 line-height-30">
                                        		<select class="validate[required] select" id="formGender">
                                                    <option value="">Niveau</option>
                                                    <option value="1">Courant</option>
                                                    <option value="2">Intermidiaire</option>
                                                    
                                                </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-md-12 col-xs-5">
                                            <button class="btn btn-primary btn-rounded pull-right">Save</button>
                                            <a  style="width:50%" href="#" class="btn btn-danger btn-block btn-rounded" data-toggle="modal" data-target="#ajouter_competence">Ajouter</a>
                                    
                                        </div>
                                    </div>
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
        
        <!-- MODALS -->
        <div class="modal animated fadeIn" id="modal_change_photo" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="smallModalHead">Changer photo</h4>
                    </div>                    
                    <form id="cp_crop" method="post" action="http://aqvatarius.com/themes/atlant/html/assets/crop_image.php">
                    <div class="modal-body">
                        <div class="text-center" id="cp_target">Mettre a jour votre photo. Seulement les fichiers .jpg .</div>
                        <input type="hidden" name="cp_img_path" id="cp_img_path"/>
                        <input type="hidden" name="ic_x" id="ic_x"/>
                        <input type="hidden" name="ic_y" id="ic_y"/>
                        <input type="hidden" name="ic_w" id="ic_w"/>
                        <input type="hidden" name="ic_h" id="ic_h"/>                        
                    </div>                    
                    </form>
                    <form id="cp_upload" method="post" enctype="multipart/form-data" action="http://aqvatarius.com/themes/atlant/html/assets/upload_image.php">
                    <div class="modal-body form-horizontal form-group-separated">
                        <div class="form-group">
                            <label class="col-md-4 control-label">Nouveau Photo</label>
                            <div class="col-md-4">
                                <input type="file" class="fileinput btn-info" name="file" id="cp_photo" data-filename-placement="inside" title="Select file"/>
                            </div>                            
                        </div>                        
                    </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success disabled" id="cp_accept">Accept</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal animated fadeIn" id="modal_change_password" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="smallModalHead">Changer mot de passe</h4>
                    </div>
                    <div class="modal-body">
                        <p>Saisissez votre nouveau mot de passe</p>
                    </div>
                    <form id="jvalidate" role="form" class="form-horizontal" action="javascript:alert('Form #validate2 submited');">
                    <div class="modal-body form-horizontal form-group-separated">                        
                        <div class="form-group">
                            <label class="col-md-3 control-label">Ancien password</label>
                            <div class="col-md-9">
                                <input type="password" class="form-control" name="old_password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Nouveau password</label>
                            <div class="col-md-9">
                                <input type="password" class="form-control" name="password" id="password2"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">Repeter</label>
                            <div class="col-md-9">
                                <input type="password" class="form-control" name="re-password"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>      
        
        <div class="modal animated fadeIn" id="ajouter_poste" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="smallModalHead">Ajouter un poste</h4>
                    </div>
                    <div class="modal-body">
                        <p></p>
                    </div>
                    <div class="modal-body form-horizontal form-group-separated">                        
                        <div class="panel-body form-group-separated">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Entreprise</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="employeur" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Fonction</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Prenom" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Date</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="Date debut" class="form-control" style="width:49%;float:left" />
                                            <input type="text" value="Date fin" class="form-control" style="width:49%;float:right" />
                                            
                                        </div>
                                        
                                    </div>
                                    
                                </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Valider</button>
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
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Formation</label>
                                        <div class="col-md-9 col-xs-7">
                                            <input type="text" value="" placeholder="Libelle formation" class="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label"></label>
                                        <div class="col-md-9 col-xs-7">
                                        	<div  style="width:49%;float:left">
                                        		<select class="validate[required] select" id="formGender"  >
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
                                                    <option value="2">Busniss intelegent</option>
                                                    <option value="3">Logistique</option>
                                                    <option value="4">Securite</option>
                                                </select>
                                             </div>
                                          
                                        </div>
                                        
                                    </div>
                                   
                                    
                                </div>
                                    
                                    
                                
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
        
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
                                    <div class="panel-body form-group-separated">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Langue</label>
                                        <div class="col-md-9 col-xs-7">
                                            <select class="validate[required] select" id="formGender">
                                                    <option value="">Langue</option>
                                                    <option value="1">Français</option>
                                                    <option value="0">Anglais</option>
                                                    <option value="0">Arabe</option>
                                                </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Votre niveau</label>
                                        <div class="col-md-9 col-xs-7">
                                            
                                            <select class="validate[required] select" id="formGender">
                                                    <option value="">Niveau</option>
                                                    <option value="1">Courant</option>
                                                    <option value="0">Intermidiaire</option>
                                                </select>
                                            
                                        </div>
                                        
                                    </div>
                                   
                                    
                                </div>
                                    
                                    
                                </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal animated fadeIn" id="ajouter_competence" tabindex="-1" role="dialog" aria-labelledby="smallModalHead" aria-hidden="true">
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
                                    <div class="panel-body form-group-separated">
                                    <div class="form-group">
                                        <label class="col-md-3 col-xs-5 control-label">Technologie</label>
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
                                        <label class="col-md-3 col-xs-5 control-label">Votre niveau</label>
                                        <div class="col-md-9 col-xs-7">
                                            
                                            <select class="validate[required] select" id="formGender">
                                                    <option value="">Niveau</option>
                                                    <option value="1">Courant</option>
                                                    <option value="0">Intermidiaire</option>
                                                </select>
                                            
                                        </div>
                                        
                                    </div>
                                   
                                    
                                </div>
                                    
                                    
                                </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Valider</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                    </div>
                </div>
            </div>
        </div>
                
        <!-- EOF MODALS -->
        
        <!-- BLUEIMP GALLERY -->
        <div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
            <div class="slides"></div>
            <h3 class="title"></h3>
            <a class="prev">?</a>
            <a class="next">?</a>
            <a class="close">?</a>
            <a class="play-pause"></a>
            <ol class="indicator"></ol>
        </div>      
        <!-- END BLUEIMP GALLERY -->        
        
        <!-- START PRELOADS -->
        <audio id="audio-alert" src="audio/alert.mp3" preload="auto"></audio>
        <audio id="audio-fail" src="audio/fail.mp3" preload="auto"></audio>
        <!-- END PRELOADS -->          
        
    <!-- START SCRIPTS -->
        <!-- START PLUGINS -->
        <script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="js/plugins/jquery/jquery-ui.min.js"></script>
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap.min.js"></script>
        
        <script type="text/javascript" src="js/plugins/jquery/jquery-migrate.min.js"></script>
        <!-- END PLUGINS -->

        <!-- START THIS PAGE PLUGINS-->        
        <script type='text/javascript' src='js/plugins/icheck/icheck.min.js'></script>
        <script type="text/javascript" src="js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js"></script>  
        
        <script type="text/javascript" src="js/plugins/bootstrap/bootstrap-file-input.js"></script>
        <script type="text/javascript" src="js/plugins/form/jquery.form.js"></script>
        
        <script type="text/javascript" src="js/plugins/cropper/cropper.min.js"></script>
        
        <script type='text/javascript' src='js/plugins/bootstrap/bootstrap-datepicker.js'></script>        
        <script type='text/javascript' src='js/plugins/bootstrap/bootstrap-select.js'></script>        

        <script type='text/javascript' src='js/plugins/validationengine/languages/jquery.validationEngine-en.js'></script>
        <script type='text/javascript' src='js/plugins/validationengine/jquery.validationEngine.js'></script>        

        <script type='text/javascript' src='js/plugins/jquery-validation/jquery.validate.js'></script>                

        <script type='text/javascript' src='js/plugins/maskedinput/jquery.maskedinput.min.js'></script>
        
        <!-- END THIS PAGE PLUGINS-->        

        <!-- START TEMPLATE -->
              
        
        <script type="text/javascript" src="js/plugins.js"></script>        
        <script type="text/javascript" src="js/actions.js"></script>
        
        <script type="text/javascript" src="js/demo_edit_profile.js"></script>
        <!-- END TEMPLATE -->
        
        <script type="text/javascript">
            var jvalidate = $("#jvalidate").validate({
                ignore: [],
                rules: {                                            
                        login: {
                                required: true,
                                minlength: 2,
                                maxlength: 8
                        },
                        password: {
                                required: true,
                                minlength: 5,
                                maxlength: 10
                        },
                        're-password': {
                                required: true,
                                minlength: 5,
                                maxlength: 10,
                                equalTo: "#password2"
                        },
                        age: {
                                required: true,
                                min: 18,
                                max: 100
                        },
                        email: {
                                required: true,
                                email: true
                        },
                        date: {
                                required: true,
                                date: true
                        },
                        credit: {
                                required: true,
                                creditcard: true
                        },
                        site: {
                                required: true,
                                url: true
                        }
                    }                                        
                });                                    

        </script>

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

<!-- Mirrored from aqvatarius.com/themes/atlant/html/pages-edit-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 16 Nov 2016 16:54:17 GMT -->
</html>






