document.getElementById("login").addEventListener("click", ()=>{
    document.getElementById("abc").classList.add("active");
    document.getElementById("bodyId").classList.add("active-form-login");
    document.getElementById("pop-up").classList.add("active");
    document.getElementById("cancel-login-form").classList.add("active");
    
});
document.getElementById("cancel-login-form").addEventListener("click", ()=>{
    document.getElementById("abc").classList.remove("active");
    document.getElementById("bodyId").classList.remove("active-form-login");
    document.getElementById("pop-up").classList.remove("active");
    document.getElementById("cancel-login-form").classList.remove("active");
    document.getElementById("quick-view-form1").classList.remove("active");
    
});
document.getElementById('sub-pro').addEventListener("click",()=>{
   let a = document.getElementById("count-product").value;
    a>1?a-=1:a;
    document.getElementById("count-product").value=a;
})
document.getElementById('add-pro').addEventListener("click",()=>{
    var b =parseInt (document.getElementById("count-product").value);
    b<999? b+=1:b;
     document.getElementById("count-product").value=b;
 })
 function proAdd(){

    document.getElementById("abc").classList.add("active");
    document.getElementById("bodyId").classList.add("active-form-login");
    document.getElementById("quick-view-form1").classList.add("active");
    document.getElementById("cancel-login-form").classList.add("active");
        
    
 }
 var slider = document.getElementById("myRange");
 console.log(slider);
 var output = document.getElementById("demo");
 output.innerHTML = slider.value;
 
 slider.oninput = function() {
   output.innerHTML = this.value;
 }
 