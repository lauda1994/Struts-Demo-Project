<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inserisci nuovo record</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <style>
    .form-control {
      width: 100%;
    }

    @media (min-width: 576px) {
      .form-control {
        width: 100%;
        max-width: 100%;
      }
    }
    #mainForm{
    border-radius:10px;
  background: rgba(255, 255, 255, 0.7);
    }
  </style>
</head>
<body>

<div class="container" id="mainForm">
  <h2 id="descrIns">Inserisci nuovo record</h2>
  <div id="divIns">
    <form id="formIns" action="insert.do" method="post">
      <div class="row">
        <div class="col-md-4">
          <label for="nomeMod" class="form-label">Nome*:</label>
          <input type="text" id="nomeInp" class="form-control" name="nomeInp" placeholder="Nome">
        </div>
        <div class="col-md-4">
          <label for="cognomeIns" class="form-label">Cognome*:</label>
          <input type="text" id="cognomeInp" class="form-control" name="cognomeInp" placeholder="Cognome">
        </div>
        <div class="col-md-4">
          <label for="nomeUserMod" class="form-label">Telefono1*:</label>
          <input type="tel" class="form-control" name="telefono1" id="telefono1Inp" maxlength="10" pattern="[0-9]{10}" required>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <label for="nomeUserMod" class="form-label">Telefono2:</label>
          <input type="tel" class="form-control" name="telefono2" id="telefono2Inp" maxlength="10" pattern="[0-9]{10}">
        </div>
        <div class="col-md-4">
          <label for="indIns" class="form-label">Indirizzo*:</label>
          <input type="text" id="indInp" class="form-control" name="indirizzo" placeholder="Via Roma 10">
        </div>
        <div class="col-md-4">
          <label for="tipoIns" class="form-label">Città*:</label>
          <select id="cittaInp" class="form-control" name="citta">
            <option value="" selected disabled>Scegli città nascita</option>
            <option value="1">Roma</option>
            <option value="2">Milano</option>
            <option value="3">Napoli</option>
            <option value="4">Torino</option>
            <option value="5">Firenze</option>
          </select>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <label for="pwIns" class="form-label">Ragione sociale*:</label>
          <input type="text" id="ragSocInps" class="form-control" name="ragSocInps" required minlength="10">
        </div>
        <div class="col-md-4">
          <label for="dataNascIns" class="form-label">Data di nascita*:</label>
          <input type="date" id="dataNascInp" class="form-control" name="dataNasc" required>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <label for="numConto" class="form-label">Numero Conto*:</label>
          <input type="number" class="form-control" name="numConto" id="nContoInp" maxlength="12" pattern="[0-9]{12}">
        </div>
        <div class="col-md-4">
          <label for="codFisc" class="form-label">Codice Fiscale*:</label>
          <input type="text" class="form-control" name="codFisc" id="codFInp" pattern="[a-zA-Z0-9]{16}">
        </div>
         <div class="col-md-4">
          <label for="email" class="form-label">Email*:</label>
          <input type="email" class="form-control" name="email" id="emailInp" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}">
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <label for="codFisc" class="form-label">Partita Iva:</label>
          <input type="number" class="form-control" name="pIvaInp" pattern="[0-9]{11}">
        </div>
        <div class="col-md-4">
          <label for="radioGender" class="form-label">Scegli Gender*:</label>
          <div class="form-check">
            <input type="radio" id="option1" class="form-check-input" name="options" value="M">
            <label for="option1" class="form-check-label">Maschio</label>
          </div>
          <div class="form-check">
            <input type="radio" id="option2" class="form-check-input" name="options" value="F">
            <label for="option2" class="form-check-label">Femmina</label>
          </div>
        </div>
       
      </div>
      <div class="row">
        <div class="col-md-6">
          <button type="submit" class="btn btn-primary m-3">Salva</button>
          <button type="submit" class="btn btn-secondary">Annulla</button>
          
        </div>
       
      </div>
    </form>
  </div>
</div>

</body>
</html>
