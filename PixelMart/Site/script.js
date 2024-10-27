// Recupera o carrinho do Local Storage
let cart = JSON.parse(localStorage.getItem('cart')) || [];

// Função para adicionar um jogo ao carrinho
function addToCart(game) {
    const existingItemIndex = cart.findIndex(item => item.id === game.id);
    if (existingItemIndex === -1) {
        cart.push(game);
        localStorage.setItem('cart', JSON.stringify(cart));
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
    const cartItems = document.getElementById('cart-items');
    if (!cartItems) return;

    cartItems.innerHTML = '';

    if (cart.length === 0) {
        cartItems.innerHTML = '<li>O carrinho está vazio.</li>';
    } else {
        cart.forEach((item, index) => {
            const li = document.createElement('li');
            li.textContent = `${item.name} - R$ ${item.price.toFixed(2)}`;

            const removeButton = document.createElement('button');
            removeButton.textContent = 'Remover';
            removeButton.onclick = () => removeFromCart(index);

            li.appendChild(removeButton);
            cartItems.appendChild(li);
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

// Atualiza os itens do carrinho ao carregar a página
window.onload = function() {
    updateCartItems();
    updateCartDisplay();
};



let slideIndex = 0; 
showSlides();

function plusSlides(n) {
    showSlides(slideIndex += n); 
}

function currentSlide(n) {
    showSlides(slideIndex = n - 1); 
}

function showSlides(n = 0) {
    let slides = document.getElementsByClassName("banner-slide");
    let dots = document.getElementsByClassName("dot");
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
