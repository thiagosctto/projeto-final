document.addEventListener("DOMContentLoaded", function() {
    const formLogin = document.querySelector("#formLogin");
    const Iusuario = document.querySelector("#username");
    const Isenha = document.querySelector("#password");

    // Função de login que é chamada ao submeter o formulário
    function login(event) {
        event.preventDefault(); // Previne o envio padrão do formulário

        const dados = {
            usuario: Iusuario.value,
            senha: Isenha.value
        };

        fetch("http://localhost:8080/auth/login", {  // URL do seu backend
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(dados)  // Envia os dados do usuário e senha em formato JSON
        })
        .then(async (res) => {
            if (res.ok) {
                const data = await res.json(); // Processa a resposta JSON
                alert("Login realizado com sucesso!");
                // Aqui você pode adicionar ações pós-login, como redirecionamento
                window.location.href = 'index.html'; // Redireciona para a página de sucesso
            } else {
                alert("Usuário ou senha incorretos.");
            }
        })
        .catch((error) => {
            alert("Erro na requisição: " + error.message);
        });
    }

    // Adiciona o ouvinte de evento para o envio do formulário
    formLogin.addEventListener("submit", login);
});
