<nav class="navbar navbar-expand-lg navbar-expand-md navbar-expand-sm navbar-expand-xs navbar-light bg-light mb-5">
  <div class="container-fluid">
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <form action="dispModule.do" method="post" class="collapse navbar-collapse" id="navbarSupportedContent">
      <a class="navbar-brand mt-2 mt-lg-0" onclick="window.location.href='http://localhost:8080/myProjectStruts/login.do';">
        <img
          src="https://www.seekpng.com/png/full/83-835228_fscheck-by-kurt-random-logo-png.png"
          height="20"
          alt="MDB Logo"
          loading="lazy"
          
        />
      </a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <button class="nav-link btn" onclick="this.form.metodo.value='formIns'">Inserimento Correntista</button>
        </li>
        <li class="nav-item">
          <button class="nav-link btn" onclick="this.form.metodo.value='formMod'">Modifica Correntista</button>
        </li>
        <li class="nav-item">
          <button class="nav-link btn" onclick="this.form.metodo.value='elencoTab'">Elenco Correntisti</button>
        </li>
      </ul>
      <input style="visibility: hidden;" value="xx" name="metodo">
    </form>

    <div class="d-flex align-items-center">
      <div class="dropdown">
        <a
          class="d-flex align-items-center hidden-arrow"
          href="#"
          id="navbar"
          role="button"
        >
          <img
            src="https://cdn-icons-png.flaticon.com/512/2206/2206248.png"
            class="rounded-circle"
            height="25"
            alt="Black and White Portrait of a Man"
            loading="lazy"
          />
        </a>
      
      </div>
    </div>
  </div>
</nav>

<style>
  .navbar-nav .nav-link {
    transition: background-color 0.5s ease;
  }

  .navbar-nav .nav-link:hover {
    background: rgb(169, 233, 242);
  }

 
  
</style>
