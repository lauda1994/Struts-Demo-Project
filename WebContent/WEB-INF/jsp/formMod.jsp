<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page import="objects.contiCorrenti"%>
<%@ page import="objects.Anagrafica"%>
<!DOCTYPE html >
   
<%
	Anagrafica anagrafica = (Anagrafica) request.getAttribute("anagrafica");
contiCorrenti contoCorr = (contiCorrenti) request.getAttribute("contoCorr");
%>
<script type="text/javascript">
	function setAnagrafica(selectElement) {
		var anagrafica = {
			luogo_nascita : "${anagrafica.luogo_nascita}",
			id_comune : "${anagrafica.id_comune}"
		};
		var selectedValue = selectElement.value;
		var idComune = 0;

		if (selectedValue === "Roma") {
			idComune = 1;
		} else if (selectedValue === "Milano") {
			idComune = 2;
		} else if (selectedValue === "Napoli") {
			idComune = 3;
		} else if (selectedValue === "Torino") {
			idComune = 4;
		} else if (selectedValue === "Firenze") {
			idComune = 5;
		}
		document.getElementById("idComuneInput").value = idComune;

		anagrafica.luogo_nascita = selectedValue;
		anagrafica.id_comune = idComune;

		console.log(anagrafica.luogo_nascita + "  " + anagrafica.id_comune)
	}
	function inizializza() {
		var anagrafica = {
			luogo_nascita : "${anagrafica.luogo_nascita}",
			id_comune : "${anagrafica.id_comune}"
		};
		let selectElement = document.getElementById("cittaInp");
		let selectedValue = selectElement.value;

		if (selectedValue === "Roma") {
			idComune = 1;
		} else if (selectedValue === "Milano") {
			idComune = 2;
		} else if (selectedValue === "Napoli") {
			idComune = 3;
		} else if (selectedValue === "Torino") {
			idComune = 4;
		} else if (selectedValue === "Firenze") {
			idComune = 5;
		}

		document.getElementById("idComuneInput").value = idComune;
		anagrafica.luogo_nascita = selectedValue;
		anagrafica.id_comune = idComune;
		console.log(anagrafica.id_comune);

	}
	function annulla() {
		  let inputElements = document.getElementsByTagName('input');
		  for (let i = 0; i < inputElements.length; i++) {
		    let elementId = inputElements[i].id;
		    if (elementId === "ContoInp") {
		      inputElements[i].disabled = true;
		    } else {
		      inputElements[i].disabled = true;
		    }
		  }

		  let selectElements = document.getElementsByTagName('select');
		  for (let i = 0; i < selectElements.length; i++) {
		    selectElements[i].disabled = true;
		  }

		  let textareaElements = document.getElementsByTagName('textarea');
		  for (let i = 0; i < textareaElements.length; i++) {
		    textareaElements[i].disabled = true;
		  }

		  let submitElements = document.getElementsByTagName('button');
		  for (let i = 0; i < submitElements.length; i++) {
		    submitElements[i].disabled = true;
		  }
		}

		function modifica() {
			let inputElements = document.getElementsByTagName('input');
			for (let i = 0; i < inputElements.length; i++) {
				  let elementId = inputElements[i].id;
				if(elementId=="ContoInp"){
					inputElements[i].disabled=true;
					continue;
				}
				inputElements[i].disabled = false;
			}

			let selectElements = document.getElementsByTagName('select');
			for (let i = 0; i < selectElements.length; i++) {
				selectElements[i].disabled = false;
			}

			let textareaElements = document.getElementsByTagName('textarea');
			for (let i = 0; i < textareaElements.length; i++) {
				textareaElements[i].disabled = false;
			}

			let submitElements = document.getElementsByTagName('button');
			for (let i = 0; i < submitElements.length; i++) {
				submitElements[i].disabled = false;
			}

		}
</script>
<body onload="inizializza()">

	<div id="divForm" class="container ">
	  <h2 id="descrIns">Modifica record</h2>
	
  <form id="formMod" action="DispAction.do" method="post">
  			<input style="visibility: hidden;" value="xx" name="metodo">
  
    <div class="row">
      <div class="col-md-6">
        <label for="nomeMod" class="form-label">Nome*:</label>
        <input type="text" id="nomeInp" class="form-control" name="nomeInp" placeholder="Nome" value="${anagrafica.nome}" disabled>
      </div>
      <div class="col-md-6">
        <label for="cognomeMod" class="form-label">Cognome*:</label>
        <input type="text" id="cognomeInp" class="form-control" name="cognomeInp" placeholder="Cognome" value="${anagrafica.cognome}" disabled>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="nomeUserMod" class="form-label">Telefono1*:</label>
        <input type="tel" class="form-control" name="telefono1" id="telefono1Inp" maxlength="10" pattern="[0-9]{10}" value="${anagrafica.telefono1}" disabled required>
      </div>
      <div class="col-md-6">
        <label for="nomeUserMod" class="form-label">Telefono2:</label>
        <input type="tel" class="form-control" id="telefono2Inp" name="telefono2" maxlength="10" pattern="[0-9]{10}" value="${anagrafica.telefono2}" disabled>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="indMod" class="form-label">Indirizzo*:</label>
        <input type="text" value="${anagrafica.indirizzo}" id="indInp" class="form-control" name="indirizzo" placeholder="Via Roma 10" disabled>
      </div>
      <div class="col-md-6">
        <label for="tipoMod" class="form-label">Città di nascita*:</label>
        <select id="cittaInp" class="form-control" name="citta" onchange="setAnagrafica(this)" disabled>
          <option value="" disabled>Scegli città</option>
          <option value="Roma" ${anagrafica.luogo_nascita == 'Roma' ? 'selected' : ''}>Roma</option>
          <option value="Milano" ${anagrafica.luogo_nascita == 'Milano' ? 'selected' : ''}>Milano</option>
          <option value="Napoli" ${anagrafica.luogo_nascita == 'Napoli' ? 'selected' : ''}>Napoli</option>
          <option value="Torino" ${anagrafica.luogo_nascita == 'Torino' ? 'selected' : ''}>Torino</option>
          <option value="Firenze" ${anagrafica.luogo_nascita == 'Firenze' ? 'selected' : ''}>Firenze</option>
        </select>
        <input type="hidden" id="idComuneInput" name="idComune" />
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="pwMod" class="form-label">Ragione sociale*:</label>
        <input type="text" id="ragSocInps" class="form-control" name="ragSocInps" value="${anagrafica.rag_soc}" required minlength="10" disabled>
      </div>
      <div class="col-md-6">
        <label for="dataNascMod" class="form-label">Data di nascita*:</label>
        <input type="date" id="dataNascInp" class="form-control" value="${anagrafica.data_nascita}" name="dataNasc" required disabled>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="numConto" class="form-label">Numero Conto*:</label>
        <input type="number" class="form-control" name="numConto" value="${contoCorr.codCC}" id="ContoInp" maxlength="12" pattern="[0-9]{12}" disabled>
      </div>
      <div class="col-md-6">
        <label for="codFisc" class="form-label">Codice Fiscale*:</label>
        <input value="${anagrafica.cod_fiscale}" type="text" class="form-control" name="codFisc" id="codFInp" pattern="[a-zA-Z0-9]{16}" disabled>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="codFisc" class="form-label">Partita Iva:</label>
        <input type="number" value="${anagrafica.partita_iva}" class="form-control" name="pIvaInp" pattern="[0-9]{12}" disabled>
      </div>
      <div class="col-md-6">
        <label for="email">Email*:</label>
        <input type="email" value="${anagrafica.email}" class="form-control" name="email" id="emailInp" pattern="[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,}" disabled>
      </div>
    </div>
    <input style="visibility:hidden" name="inputAnag" type="text" id="codAnag" value="${anagrafica.cod_anag}">
     <div class="bottoniForm">
      <div class="row">
        <div class="col-md-6">
          <button type="submit" name="salva" onclick="this.form.metodo.value='modifDb'" class="btn btn-primary" disabled>Salva</button>
          <button type="button" id="annulla" onclick="annulla()" class="btn btn-secondary">Annulla</button>
              <button type="button" onclick="modifica()" class="btn" style="background-color:yellow;color:cyan;font-weight: bold;">Modifica</button>
          <button type="submit" name="elimina" id="deleteButt" onclick="this.form.metodo.value='eliminaRecord'" style=color:cyan;font-weight: bold; class="btn btn-danger">Elimina</button>
        </div>
      </div>  
      </div>
  </form>
</div>

<style>
 #divForm{
    border-radius:10px;
  background: rgba(255, 255, 255, 0.7);
    }
</style>

	