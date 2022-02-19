jQuery(document).ready(function(){
		jQuery('#form').submit(function(){
			
			
		
			var dados = jQuery( this ).serialize();

			jQuery.ajax({
				type: "POST",
				url: "updatePesquisa2",
				data: dados,
				success: function( data )
				{
					Materialize.toast('Comentário salvo com sucesso', 3000, 'rounded');
				}
			});
			
			return false;
		});
	});
