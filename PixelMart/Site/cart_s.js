
// Carrinho de compras
let cart = JSON.parse(localStorage.getItem('cart')) || [];

// Função para adicionar um jogo ao carrinho
function addToCart(game) {
    const existingItemIndex = cart.findIndex(item => item.id === game.id);
    if (existingItemIndex === -1) {
        cart.push(game);
        localStorage.setItem('cart', JSON.stringify(cart));
        updateCartItems();
        updateCartDisplay();
        alert(`${game.name} foi adicionado ao carrinho!`);
    } else {
        alert(`${game.name} já está no carrinho!`);
    }
}

// Função para atualizar o contador do carrinho
function updateCartDisplay() {
    const cartCount = cart.length;
    const cartTotal = cart.reduce((total, item) => total + item.price, 0);

    const cartCountElement = document.getElementById('cart-count');
    const cartTotalElement = document.getElementById('cart-total');

    if (cartCountElement) {
        cartCountElement.textContent = cartCount;
    }
    if (cartTotalElement) {
        cartTotalElement.textContent = `R$ ${cartTotal.toFixed(2)}`;
    }
}

// Função para atualizar os itens do carrinho
function updateCartItems() {
    const cartItemsContainer = document.getElementById('cart-items');
    const buttonsContainer = document.getElementById('buttons-container'); // Contêiner dos botões
    if (!cartItemsContainer || !buttonsContainer) return;

    cartItemsContainer.innerHTML = ''; // Limpa o conteúdo existente

    if (cart.length === 0) {
        cartItemsContainer.innerHTML = '<p style="color: red; font-size: 18px;">Seu carrinho está vazio.</p>';
        buttonsContainer.style.display = 'none';  // Esconde os botões
    } else {
        buttonsContainer.style.display = 'block';  // Exibe os botões
        cart.forEach((item, index) => {
            const cartItem = document.createElement('div');
            cartItem.classList.add('cart-item');
            cartItem.innerHTML = `
                <img src="${item.image}" alt="${item.name}" class="cart-item-image">
                <div class="item-info">
                    <h2>${item.name}</h2>
                    <p class="price">R$ ${item.price.toFixed(2)}</p>
                </div>
                <button class="remove-item" onclick="removeFromCart(${index})">Remover</button>
            `;
            cartItemsContainer.appendChild(cartItem);
        });
    }

    updateCartDisplay();
}

// Função para remover um item do carrinho
function removeFromCart(index) {
    cart.splice(index, 1);
    localStorage.setItem('cart', JSON.stringify(cart));
    updateCartItems();
}

// Função para finalizar a compra
function finalizePurchase() {
    alert('Compra finalizada com sucesso!');
    localStorage.removeItem('cart');
    updateCartItems();
}

// Função para continuar comprando
function continueShopping() {
    window.location.href = 'index.html';
}

// Atualiza os itens do carrinho ao carregar a página
window.onload = function() {
    updateCartItems();
    updateCartDisplay();
};

// Slide banner
let slideIndex = 0;
showSlides();

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlide(n) {
    showSlides(slideIndex = n - 1);
}

function showSlides(n = 0) {
    const slides = document.getElementsByClassName("banner-slide");
    const dots = document.getElementsByClassName("dot");
    if (n >= slides.length) { slideIndex = 0; }
    if (n < 0) { slideIndex = slides.length - 1; }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[slideIndex].style.display = "block";
    dots[slideIndex].className += " active";
}

setInterval(function() {
    plusSlides(1);
}, 10000);
