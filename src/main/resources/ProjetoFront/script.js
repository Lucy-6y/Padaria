// Carrinho de compras
const botoes = document.querySelectorAll(".btn-carrinho");
const contador = document.getElementById("contadorCarrinho");
const listaCarrinho = document.getElementById("listaCarrinho");
const totalCarrinho = document.getElementById("totalCarrinho");
const popup = document.getElementById("carrinhoPopup");
const iconeCarrinho = document.getElementById("iconeCarrinho");
const fecharCarrinho = document.getElementById("fecharCarrinho");

let carrinho = [];
const formaPagamentoSelect = document.getElementById("formaPagamento");
const detalhesPagamento = document.getElementById("detalhesPagamento");

formaPagamentoSelect.addEventListener("change", () => {
    const opcao = formaPagamentoSelect.value;
    detalhesPagamento.innerHTML = ""; // limpa conteúdo anterior

    if (opcao === "pix") {
        // gera um QR Code aleatório (pode usar URLs falsas para simulação)
        const codigoAleatorio = Math.random().toString(36).substring(2, 10).toUpperCase();
        const img = document.createElement("img");
        img.src = `https://api.qrserver.com/v1/create-qr-code/?size=180x180&data=PIX-${codigoAleatorio}`;
        img.alt = "QR Code Pix";
        img.classList.add("qrcode-pix");

        const texto = document.createElement("p");
        texto.textContent = "Escaneie o QR Code para realizar o pagamento.";

        detalhesPagamento.appendChild(img);
        detalhesPagamento.appendChild(texto);
    }

    else if (opcao === "credito" || opcao === "debito") {
        const labelNum = document.createElement("label");
        labelNum.textContent = "Número do cartão:";
        const inputNum = document.createElement("input");
        inputNum.type = "text";
        inputNum.placeholder = "**** **** **** ****";
        inputNum.maxLength = 19;

        const labelVal = document.createElement("label");
        labelVal.textContent = "Validade:";
        const inputVal = document.createElement("input");
        inputVal.type = "month";

        const labelCvv = document.createElement("label");
        labelCvv.textContent = "CVV:";
        const inputCvv = document.createElement("input");
        inputCvv.type = "text";
        inputCvv.maxLength = 3;
        inputCvv.placeholder = "000";

        detalhesPagamento.append(labelNum, inputNum, labelVal, inputVal, labelCvv, inputCvv);
    }

    else if (opcao === "dinheiro") {
        const labelValor = document.createElement("label");
        labelValor.textContent = "Valor entregue:";
        const inputValor = document.createElement("input");
        inputValor.type = "number";
        inputValor.min = 0;
        inputValor.step = "0.01";
        inputValor.placeholder = "Ex: 50.00";

        const troco = document.createElement("p");
        troco.id = "troco";
        troco.textContent = "";

        inputValor.addEventListener("input", () => {
            const total = parseFloat(
                document.getElementById("totalCarrinho").textContent.replace("R$ ", "").replace(",", ".")
            );
            const pago = parseFloat(inputValor.value);
            if (!isNaN(pago)) {
                const trocoValor = pago - total;
                troco.textContent =
                    trocoValor >= 0
                        ? `Troco: R$ ${trocoValor.toFixed(2).replace(".", ",")}`
                        : "Valor insuficiente 💸";
            } else {
                troco.textContent = "";
            }
        });

        detalhesPagamento.append(labelValor, inputValor, troco);
    }
});

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
    const formaPagamento = document.getElementById("formaPagamento").value;
    alert(`Forma de pagamento selecionada: ${formaPagamento.charAt(0).toUpperCase() + formaPagamento.slice(1)}`);
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
