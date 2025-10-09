const form = document.getElementById('formCadastro');

form.addEventListener('submit', function(event) {
    event.preventDefault(); // evitar o envio automático

    // Aqui você pode adicionar validações extras se quiser

    // Se tudo estiver OK, redireciona para a padaria.html
    window.location.href = 'padaria.html';
});
