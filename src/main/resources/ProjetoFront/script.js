// Carrinho de compras
const botoes = document.querySelectorAll(".btn-carrinho");
const contador = document.getElementById("contadorCarrinho");
const listaCarrinho = document.getElementById("listaCarrinho");
const totalCarrinho = document.getElementById("totalCarrinho");
const popup = document.getElementById("carrinhoPopup");
const iconeCarrinho = document.getElementById("iconeCarrinho");
const fecharCarrinho = document.getElementById("fecharCarrinho");

let carrinho = [];

botoes.forEach(botao => {
    botao.addEventListener("click", () => {
        const card = botao.parentElement;
        const nome = card.getAttribute("data-nome");
        const preco = parseFloat(card.getAttribute("data-preco"));
        carrinho.push({ nome, preco });
        atualizarCarrinho();
    });
});

iconeCarrinho.addEventListener("click", () => {
    popup.classList.toggle("ativo");
});

fecharCarrinho.addEventListener("click", () => {
    popup.classList.remove("ativo");
});

function atualizarCarrinho() {
    contador.textContent = carrinho.length;
    listaCarrinho.innerHTML = "";
    let total = 0;

    carrinho.forEach(item => {
        const li = document.createElement("li");
        li.textContent = `${item.nome} - R$ ${item.preco.toFixed(2)}`;
        listaCarrinho.appendChild(li);
        total += item.preco;
    });

    totalCarrinho.textContent = "R$ " + total.toFixed(2).replace(".", ",");
}
