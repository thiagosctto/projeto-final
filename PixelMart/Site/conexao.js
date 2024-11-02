const formulario = document.querySelector("form");

const Inome = document.querySelector("#nome_completo"); 
const Igenero = document.querySelector("#genero"); // Alterado para capturar pelo ID diretamente
const Icpf = document.querySelector("#cpf");
const Iemail = document.querySelector("#email");
const Isenha = document.querySelector("#password");

function cadastrar(event) {
    event.preventDefault();

    const dados = {
        nome: Inome.value, 
        genero: Igenero.value || null,  // Captura o valor diretamente
        cpf: Icpf.value,
        email: Iemail.value,
        senha: Isenha.value
    };

    // Verifique se o nome não está vazio
    if (!dados.nome) {
        alert("O nome completo é obrigatório.");
        return;
    }

    fetch("http://localhost:8080/usuarios", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(dados)
    })
    .then(async (res) => {
        const data = await res.json();
        if (res.ok) {
            limpar(); 
        } else {
            alert(`Erro: ${data.message || 'Erro desconhecido'}`);
        }
    })
    .catch(function (error) {
        alert("Erro na requisição: " + error.message);
    });
}

function limpar() {
    Inome.value = "";
    Igenero.value = ""; // Limpa o valor do campo de gênero
    Icpf.value = "";
    Iemail.value = "";
    Isenha.value = "";
}

formulario.addEventListener("submit", cadastrar);
