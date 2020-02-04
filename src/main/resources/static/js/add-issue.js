const header  = document.querySelector("#header");
const content = document.querySelector("#content");
const btn = document.querySelector("#btn").addEventListener("click" ,function(){
    send(new Request());
});

class Request {

    constructor(){
        this.xhr =new XMLHttpRequest();
    }
    post(url , data){
        this.xhr.open("POST" , url);
        this.xhr.setRequestHeader("Content-type" , "application/json");

        this.xhr.onload = function (){
            console.log(this.status , data);
        }
        this.xhr.send(data);
    }
}
function send(request){
    console.log(header.value , content.value);

    let response = 
    {
        "header":header.value,
        "content":content.value    
    };

    console.log(response);
    request.post("http://localhost:8080/rest/issue" , JSON.stringify(response));
}