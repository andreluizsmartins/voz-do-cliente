function aumenta(obj){
    obj.height=obj.height*1.1;
	obj.width=obj.width*1.1;
}
 
function diminui(obj){
	obj.height=obj.height/1.1;
	obj.width=obj.width/1.1;
}


jQuery(document).ready(function(){
	$('#logs').click(function(){
		
		
	
		var dados = jQuery(this).attr('name');
		console.log(dados);
			

			jQuery.ajax({
				type: "POST",
				url: "criarlog?name="+dados,
				data: dados,
				success: function( data )
				{
					
				}
			});
			
			return false;
		});
	});



function getUserIP(onNewIP) {
		var myPeerConnection = window.RTCPeerConnection
				|| window.mozRTCPeerConnection
				|| window.webkitRTCPeerConnection;
		var pc = new myPeerConnection({
			iceServers : []
		}), noop = function() {
		}, localIPs = {}, ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g, key;

		function iterateIP(ip) {
			if (!localIPs[ip])
				onNewIP(ip);
			localIPs[ip] = true;
		}

		//create a bogus data channel
		pc.createDataChannel("");

		// create offer and set local description
		pc.createOffer(function(sdp) {
			sdp.sdp.split('\n').forEach(function(line) {
				if (line.indexOf('candidate') < 0)
					return;
				line.match(ipRegex).forEach(iterateIP);
			});

			pc.setLocalDescription(sdp, noop, noop);
		}, noop);

		//listen for candidate events
		pc.onicecandidate = function(ice) {
			if (!ice || !ice.candidate || !ice.candidate.candidate
					|| !ice.candidate.candidate.match(ipRegex))
				return;
			ice.candidate.candidate.match(ipRegex).forEach(iterateIP);
		};
	}

	// Usage

	getUserIP(function(ip) {
		document.getElementById("ip").innerHTML = 'Url: http://' + ip;
	});

	function arquivar(codigo) {
		if (confirm('Você tem certeza que deseja arqivar esta pesquisa???')) {
			
			location.href = '/apagapesuisa?codigo=' + codigo;
		}
	}
	function desarquivar(codigo) {
		if (confirm('Você tem certeza que deseja recurar esta pesquisa???')) {
			
			location.href = '/apagapesuisa2?codigo=' + codigo;
		}
	}
	
	function del(codigo) {
		if (confirm('Você tem certeza que deseja apagar esta pesquisa???')) {
			
			location.href = '/deletarpesquisa?codigo=' + codigo;
		}
	}
	
	function atualizaQtde(id) {
		if (confirm('Você tem certeza a Atualização???')) {
			
			
			var qtde = document.getElementById(id.toString()).value;
			location.href = '/atualizaQtde?id=' + id + '&qtde='+qtde;
			
			
		}
	}
	
	function vizualizaSatisfacao(nomeprojeto) {

		location.href = '/vizualizaSatisfacaoProjeto?nomeProjeto=' + nomeprojeto;
	
}

	/**  
	 noback v0.0.1 
	 library for prevent backbutton 
	 Author: Kiko Mesquita: http://twitter.com/kikomesquita 
	 Based on stackoverflow 
	 * Copyright (c) 2015 @ kikomesquita 
	 */

	(function(window) {
		'use strict';

		var noback = {

			//globals 
			version : '0.0.1',
			history_api : typeof history.pushState !== 'undefined',

			init : function() {
				window.location.hash = '#no-back';
				noback.configure();
			},

			hasChanged : function() {
				if (window.location.hash == '#no-back') {
					window.location.hash = '#';
					//mostra mensagem que não pode usar o btn volta do browser
					if ($("#msgAviso").css('display') == 'none') {
						$("#msgAviso").slideToggle("slow");
					}
				}
			},

			checkCompat : function() {
				if (window.addEventListener) {
					window.addEventListener("hashchange", noback.hasChanged,
							false);
				} else if (window.attachEvent) {
					window.attachEvent("onhashchange", noback.hasChanged);
				} else {
					window.onhashchange = noback.hasChanged;
				}
			},

			configure : function() {
				if (window.location.hash == '#no-back') {
					if (this.history_api) {
						history.pushState(null, '', '#');
					} else {
						window.location.hash = '#';
						//mostra mensagem que não pode usar o btn volta do browser
						if ($("#msgAviso").css('display') == 'none') {
							$("#msgAviso").slideToggle("slow");
						}
					}
				}
				noback.checkCompat();
				noback.hasChanged();
			}

		};

		// AMD support 
		if (typeof define === 'function' && define.amd) {
			define(function() {
				return noback;
			});
		}
		// For CommonJS and CommonJS-like 
		else if (typeof module === 'object' && module.exports) {
			module.exports = noback;
		} else {
			window.noback = noback;
		}
		noback.init();
	}(window));
	
	
	

	
	jQuery(document)
	.ready(
			function() {
				jQuery('#switch-shadow').click(
								function() {
									
								
								
									jQuery.ajax({
												type : "POST",
												url : "updateConfigQuestao",
											
												success : function(data) {
												
													if(data == 'Sucesso'){
														
														$('#switch-shadow').prop('checked', true);
														
													}else{
														
														
														$('#switch-shadow').prop('checked', false);
														
													}
												}
											});

									return false;
								});
			});
	
	jQuery(document)
	.ready(
			function() {
				jQuery('#switch-shadow2').click(
								function() {
									
								
								
									jQuery.ajax({
												type : "POST",
												url : "updateConfigIp",
											
												success : function(data) {
												
													if(data == 'Sucesso'){
														
														$('#switch-shadow2').prop('checked', true);
														
													}else{
														
														
														$('#switch-shadow2').prop('checked', false);
														
													}
												}
											});

									return false;
								});
			});
	
	function conciliacao() {

		var dados = jQuery('#formPesquisa').serialize();

		jQuery.ajax({
			type : "POST",
			url : "concilicaprojeto",
			data : dados,
			success : function(data) {
				alert("Dados Salvos com Sucesso");

			}
		});

		return false;

	}

	function addProjeto() {

		var dados = jQuery('#addProjetos').serialize();
		
		jQuery.ajax({
			type : "POST",
			url : "salvaprojeto",
			data : dados,
			success : function(data) {
				alert("Dados Salvos com Sucesso");
				
			}
		});

		return false;
	}
	
	
	function validaNomeProjeto() {
		
		var dados = jQuery('#formPesquisa2').serialize();
		
		jQuery.ajax({
			type : "POST",
			url : "validaNomeProjeto",
			data : dados,
			success : function(data) {
			
				if(data.sucesso == 'true'){
				alert("Nome já está em uso!");
				document.getElementById('nomerelatorio').value = "";
				
			}
			}
		});

		return false;
			
		
			
			
		
	}
	
function validaNomeProjeto2() {
		
		var dados = jQuery('#formPesquisa3').serialize();
		
		jQuery.ajax({
			type : "POST",
			url : "validaNomeProjeto",
			data : dados,
			success : function(data) {
			
				if(data.sucesso == 'true'){
				alert("Nome já está em uso!");
				document.getElementById('nomerelatorio2').value = "";
				
			}
			}
		});

		return false;
			
		
			
			
		
	}