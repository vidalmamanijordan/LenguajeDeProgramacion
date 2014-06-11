var upeu = (function($) {

	var inicio = function() {
		console.log("me cargue", "yupiii");
	};

	$(document).on("ready", inicio);

	return {
		
		cargarUrl : function(url) {
			var xhr = $.get(url);
			xhr.done(function(data) {
				$("#contenido").html(data);
			});
		},
		
		guardarAlumno : function(_url) {

			var datos = "nombre=" + $("#nombre").val() + "&paterno="
					+ $("#paterno").val() + "&materno=" + $("#materno").val();

			$.ajax({
				url : _url,
				type : "POST",
				data : datos,
				success : function(data) {
					$("#contenido").html(data);
				},
				error : function(error) {
					console.log(error);
				}
			});
		},
		
		guardarDocente : function(_url) {

			var datos = "nombre=" + $("#nombre").val() + "&paterno="
					+ $("#paterno").val() + "&materno=" + $("#materno").val();

			$.ajax({
				url : _url,
				type : "POST",
				data : datos,
				success : function(data) {
					$("#contenido").html(data);
				},
				error : function(error) {
					console.log(error);
				}
			});
		},
		
		editarAlumno : function(_url) {

			var datos = "nombre=" + $("#nombre").val() + "&paterno="
					+ $("#paterno").val() + "&materno=" + $("#materno").val()+ "&id=" + $("#id").val();

			$.ajax({
				url : _url,
				type : "POST",
				data : datos,
				success : function(data) {
					$("#contenido").html(data);
				},
				error : function(error) {
					console.log(error);
				}
			});
		}		
	};

})(jQuery);