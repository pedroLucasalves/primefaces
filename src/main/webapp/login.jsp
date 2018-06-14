<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html; charset=UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Academia</title>

<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap-responsive.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

</head>
<body>

	<div class="wrapper" >
		<div class="header" style="background:#26a8d2">
			<div class="container" style="border-top:#26a8d2">
				<div class="row branding">	
					<div class="span6">
						<h1 class="pull-left">
							<a href="index.html"><strong>Academia</strong></a>
							
						</h1>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="container content">
		


			
			
				<div class="well quickSignupForm" style="width:275px; margin-left:calc(100% - 290px)">
					
					<form action="j_spring_security_check" method="post">
						<h3>Acesso ao Sistema</h3>
						<%
							if (request.getParameter("msg") != null) {
								out.print("<span style='color: red;font-weight: bold;'>Usuário ou senha incorretos</span>");
							}
						%>
						<label>Login</label> <input type="text" id="usuario" name="j_username" class="span3" /> <label>Senha</label>
						<input id="senha" name="j_password" type="password" class="span3" /> <input
							class="btn btn-large btn-success btnSignup" type="submit" value="Entrar" style="background:#26a8d2"/>
					</form>
				</div>


	
	</div>
	<script>
		document.getElementById("usuario").focus();
	</script>
</body>

</html>