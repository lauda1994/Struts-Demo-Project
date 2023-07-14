<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, ">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<style>
h1 {
  color: white;
  font-size: 50px;
  font-weight: bold;
  font-family: monospace;
  letter-spacing: 7px;
  cursor: pointer;
}
    .col-md-4 h2, .col-md-4 p{
      transition: font-size 0.3s ease;
    }

  .col-md-4:hover h2{
      font-size: 50px;
        text-shadow: 0 0 10px grey, 0 0 20px grey, 0 0 40px grey;
      
      
      }
     .col-md-4:hover p{
           font-size: 25px;
             text-shadow: 0 0 10px grey, 0 0 20px grey, 0 0 40px grey;
           
     
     }
h1 span {
  transition: 0.5s ease-out;
}
h1:hover span:nth-child(1) {
  margin-right: 5px;
}

h1:hover span:nth-child(2) {
  margin-left: 30px;
}
h1:hover span {
  color:white ;
  text-shadow: 0 0 10px grey, 0 0 20px grey, 0 0 40px grey;
}
</style>
</head>

<div class="container" style="margin-top: 100px">
	<div class="row justify-content-center">
		<h1><span>Progetto</span><span>Struts</span></h1>
		<h3 >Progetto demo utilizzando le tecnologia struts apprese per
			creare un sito dinamico che unisce backend al frontend potendo
			manipolare la visualizzazione dei dati e i dati in database</h3>
	</div>
	<div class="row justify-content-center mt-5">

		<div class="col-md-4">
			<h2 style="color:white">Funzione inserimento correntista</h2>
			<p>Questa funzione permette all'utente admin di utilizzare il form di inserimento dati per aggiungere un nuovo utente correntista al database.</p>
		</div>
		<div class="col-md-4">
			<h2 style="color:white">Funzione modifica correntista</h2>
			<p>Questa funzione permette all'utente admin di utilizzare il form di modifica dove è possibile modificare o eliminare totalmente il record selezionato dal database.</p>
		</div>
		<div class="col-md-4">
			<h2 style="color:white">Funzione visualizzazione tabella correntisti</h2>
			<p>Questa funzione permette all'utente admin di visualizzare a schermo tutti i record correntisti presenti in db per visionarli.</p>
		</div>
	</div>
</div>

