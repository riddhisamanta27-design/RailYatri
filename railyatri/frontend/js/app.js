const API_BASE_URL = 'http://localhost:8081/api';

// Utility to get URL parameters
function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

// Utility to display error messages inline
function showError(elementId, message) {
    const element = document.getElementById(elementId);
    if(element) {
        element.textContent = message;
        element.style.color = 'var(--danger-color)';
        element.style.fontSize = '0.85rem';
        element.style.marginTop = '5px';
    } else {
        alert(message);
    }
}

// Utility to clear errors
function clearError(elementId) {
    const element = document.getElementById(elementId);
    if(element) {
        element.textContent = '';
    }
}

// Ensure active state on bottom navigation
function setActiveNav() {
    const currentPage = window.location.pathname.split('/').pop();
    const navItems = document.querySelectorAll('.bottom-nav .nav-item');
    navItems.forEach(item => {
        item.classList.remove('active');
        if (item.getAttribute('href') === currentPage || (currentPage === '' && item.getAttribute('href') === 'index.html')) {
            item.classList.add('active');
        }
    });
}

document.addEventListener('DOMContentLoaded', setActiveNav);
