// menu bar

const navToggle = document.querySelector("#menu-bar");
const link = document.querySelector(".links");

navToggle.addEventListener("click", function () {
    navToggle.classList.toggle("fa-times");
    link.classList.toggle("show_nav");
});
