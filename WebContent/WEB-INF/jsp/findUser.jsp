<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html>
<html>
<head>
 
</head>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <fieldset>
                <legend>Ricerca Correntista</legend>
                <form action="EffettuaModifica.do" method="POST" onsubmit="return validazioneForm()">
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col">
                                <input type="radio" name="tipoRicerca" value="nome" id="radioCognome">
                                <label for="radioCognome">Anagrafica:</label>
                            </div>
                            <div class="col mb-2">
                                <select class="form-control" name="Cognome" id="inputCognome" onchange="ajaxCall()">
                                    <option disabled selected>Seleziona un cognome</option>
                                    <c:forEach var="anagrafica" items="${listaAnagrafica}">
                                        <option value="${anagrafica.cognome}">${anagrafica.cognome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col">
                                <select class="form-control" name="Nome" id="inputNome">
                                    <option id="nomiOption" disabled selected>Seleziona un nome</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mt-4">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="tipoRicerca" value="" id="radioCodiceConto">
                            <label class="form-check-label" for="radioCodiceConto">Conto Corrente:</label>
                        </div>
                        <select class="form-control" name="CodiceConto" id="inputCodiceConto">
                            <option disabled selected>Seleziona un conto</option>
                            <c:forEach var="contiCorrente" items="${listaCc}">
                                <option value="${contiCorrente.codCC}">${contiCorrente.codCC}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Cerca</button>
                </form>
            </fieldset>
        </div>
    </div>
</div>




    <script>
        function validazioneForm() {
            let radioButtons = document.getElementsByName('tipoRicerca');
            let isRadioButtonSelected = false;

            for (let i = 0; i < radioButtons.length; i++) {
                if (radioButtons[i].checked) {
                    isRadioButtonSelected = true;
                    break;
                }
            }

            if (!isRadioButtonSelected) {
                alert('Selezionare una modalità di ricerca');
                return false;
            }

            let inputCognome = document.getElementById('inputCognome');
            let inputNome = document.getElementById('inputNome');
            let inputCodiceConto = document.getElementById('inputCodiceConto');

            if (radioButtons[0].checked && inputCognome.selectedIndex === 0) {
                alert('Selezionare un cognome');
                return false;
            }

            if (radioButtons[0].checked && inputNome.selectedIndex === 0) {
                alert('Selezionare un nome');
                return false;
            }

            if (radioButtons[1].checked && inputCodiceConto.selectedIndex === 0) {
                alert('Selezionare un conto');
                return false;
            }

            return true;
        }

        function ajaxCall() {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var response = xhr.responseText;
                    var nomi = response.split(",");

                    var selectNomi = document.getElementById("inputNome");
                    selectNomi.innerHTML = "";
                    var option = document.createElement("option");
                    option.text = "Seleziona un nome";
                    option.disabled=true;
                    selectNomi.add(option);
                    for (var i = 0; i < nomi.length; i++) {
                        var option = document.createElement("option");
                        option.text = nomi[i];
                        selectNomi.add(option);
                        
                    }
                }
            };
            xhr.open("GET", "AjaxCognomi.do?Cognome=" + document.getElementById("inputCognome").value, true);
            xhr.send();
        }
    </script>
</body>
</html>
