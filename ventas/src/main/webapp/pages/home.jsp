<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Bienvenido al sistema</title>
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<script type="text/javascript" src="resources/js/vendor/jquery.js"></script>
</head>
<body>
	<div id="contenedor">
		<header>
			<h1>University System</h1>
		</header>
		<nav>
			<ul>
				<li onclick="upeu.cargarUrl('alumnos');">Alumnos</li>
				<li onclick="upeu.cargarUrl('docentes');">Docentes</li>
				<li>Cursos</li>
				<li>Salir</li>
			</ul>
		</nav>
		<section>
			<article id="contenido">
				<img alt="Universidad Peruana Union" width="250"
					src="resources/img/logo.png">
			</article>
		</section>
	</div>
	<script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>