function validateSignup(){
    var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    var phoneno = /^\d{10}$/;
    var passw=  /^[A-Za-z]\w{7,14}$/;
    let name=document.getElementById("fullname").value
    let email=document.getElementById("email").value
    let address=document.getElementById("address").value
    let phone=document.getElementById("phone").value
    let password=document.getElementById("password").value
    let cpassword=document.getElementById("cpassword").value
    if(name==''||email==''||address==''||phone==''||password==''||cpassword==''){
        alert("Enter all the details")
    } else if(!(email.match(validRegex))){
        alert("Invalid email address!");
    }else if(!(phone.match(phoneno))){
        alert("Invalid phone number")
    }else if(!(password.match(passw))){
        alert("The password must 7 to 16 characters with characters, numeric digits, underscore and first character must be a letter.")
    }else if(password!=cpassword){
        alert("The passwords do not match")
    } else{
        alert("Registered Successfully")
        document.getElementsByClassName("submitbutton").item(0).type="submit"
    }
}