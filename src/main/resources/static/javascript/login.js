function validateLogin(){
    let email=document.getElementById("l-email").value
    let password=document.getElementById("l-password").value
    if(email==''||password==''){
        alert("Enter all the fields")
    }
}