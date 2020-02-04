const name    = document.querySelector("#name"); 
const surname = document.querySelector("#surname");
const age     = document.querySelector("#age"); 
const btn = document.querySelector("#btn").addEventListener("click",function(){

request.post("http://localhost:8080/rest/person");
});

class Request{

    constructor(){
        this.xhr = new XMLHttpRequest();
    }

    try(){
        console.log("deneme");
    }

    get(url){
        this.xhr.open("GET" , url);

        this.xhr.onload =  function() {
            console.log("response:");
            console.log(this.responseText);
        } 

        this.xhr.send();
    }


    post(url){
        console.log(age.value);
        this.xhr.open("POST" , url);
        this.xhr.setRequestHeader("Content-type" , "application/json");
        let val = 
        {
            "name":name.value,
            "surname":surname.value,
            "age":age.value
        }
        this.xhr.onload = function(){
            console.log(this.status , JSON.stringify(val));
        }
        this.xhr.send(JSON.stringify(val));
    }
}


const request = new Request() ;

function say(){
    console.log(name.value , surname.value , age.value);
    let val = 
    {
        "name":name.value,
        "surname":surname.value,
        "age":age.value
    }
    console.log(val);
}

