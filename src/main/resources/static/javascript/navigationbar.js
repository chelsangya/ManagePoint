class Header extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
      <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
      integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
      <style>
      :root {
        --primary: #121147;
        --secondary: #ebdfdf;
      }
      *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      header {
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: flex-start;
        background: var(--primary);
        padding: 1%;
        border-bottom: 3px solid var(--secondary);
      }
      .links {
        display: flex;
        justify-content: space-around;
        width: 60%;
      }

      .links a {
        font-size: 1.3rem;
        margin: 2%;
        text-decoration: none;
        color: var(--secondary);
        font-weight: 400;
        padding: 1% 3%;
        display: flex;
        align-items: center;
      }
      .links a:hover {
        border: 1px solid var(--secondary);
        border-radius: 7px;
        color: var(--primary);
        background-color: var(--secondary);
        transition: 0.2s ease-in-out;
      }
      .links a img{
        border-radius: 50%;
        width: 50px;
        margin-right: 15px;
      }

      #menu-bar {
        font-size: 3rem;
        cursor: pointer;
        color: var(--secondary);
        border: 0.1rem solid var(--secondary);
        border-radius: 0.3rem;
        padding: 0.5rem 1.5rem;
        display: none;
      }
      @media (max-width: 768px) {
        header {
          /* display: flex; */
          /* flex-direction: column; */
          width: 100vw;
          justify-content: space-between;
          align-items: center;
          flex-wrap: wrap;
        }
        .links {
          display: none;
        }
        header img{
            width: 80%;
        }
        #menu-bar {
          display: block;
          float: right;
        }
        .show_nav {
          padding-top: 2%;
          display: flex;
          width: 100vw;
          height: 100vh;
          overflow: hidden;
          flex-direction: column;
          justify-content: flex-start;
          align-items: center;
        }
        .show_nav a{
            background-color: var(--secondary);
            width: 70vw;
            font-size: 2rem;
            border-radius: 10px;
            color: var(--primary);
            height: 10vh;
            align-items: center;
        }
      }
    </style>
    <header>
      <a href="#" class="logo"
        ><img  src="./assets/MP_logo.png" alt="logo" /></a
      >
      <div id="menu-bar" class="fas fa-bars"></div>
      <div class="links">
        <a th:href="@{~/dashboard/subscriber}">Subscribers</a>
        <a th:href="@{~/dashboard/broadcast}">Broadcasts</a>
        <a th:href="@{~/dashboard/learn}">Learn</a>
        <a  th:href="@{~/dashboard/profile}"
          ><img
           src="./assets/MP_logo.png"
            alt="Profile Pic"
            srcset=""
          />Sangya</a
        >
      </div>
    </header>
    
    
  

   
      `;
    }
}

customElements.define('navigation-bar', Header);