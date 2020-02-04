const Tbody  = document.querySelector("#tbody");

function editIssue(e){
    let i = e.target.parentElement.parentElement.textContent.slice(0,1);
    fetch("http://localhost:8080/rest/addissue",{
        method: 'POST',
        body: JSON.stringify(datalist[i-1]),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }})
}
function deleteIssue(e){
    e.target.parentElement.parentElement.remove();
    let i = e.target.parentElement.parentElement.textContent.slice(0,1);
    fetch("http://localhost:8080/rest/issue/" + datalist[i-1].id,{
        method: 'DELETE',
        body: JSON.stringify(datalist[i-1]),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }})

}
function createElement(dataList){
    var i=1;
    dataList.forEach(element => {
        let tr  = document.createElement("tr");

        //id
        let id = document.createElement("p")
        id.innerHTML = i;
        id.style="float:left;"
        //header
        let tdh = document.createElement("td");
        let a   = document.createElement("a");
        a.innerHTML = element.header ;
        a.href = "/";
        //content
        let tdc = document.createElement("td");

        if (element.content.length > 50 ){
            tdc.innerHTML = element.content.slice(0,50) + "...";

        }else[
            tdc.innerHTML = element.content
        ]
        //edit button
        let editbtn = document.createElement("a");
        editbtn.className = "btn btn-primary"
        editbtn.innerHTML = "edit"
        editbtn.addEventListener("click",(e)=>{
            editIssue(e);
        });
        //delete button
        let deletebtn = document.createElement("a");
        deletebtn.className = "btn btn-danger"
        deletebtn.innerHTML = "del"
        deletebtn.addEventListener("click",(e)=> deleteIssue(e));
        tdh.appendChild(id);
        tdh.appendChild(a);
        tdc.appendChild(editbtn);
        tdc.appendChild(deletebtn);
        tr.appendChild(tdh);
        tr.appendChild(tdc);

        Tbody.appendChild(tr);
        i++;
    });
}

class Request {

    get(url){
        return new Promise((resolve , reject)=> {
            fetch(url)
            .then(response => response.json())
            .then((data) => resolve(data))
            .catch( (err) => reject(err));
        })
    }

}

const request = new Request();
var datalist;


request.get("http://localhost:8080/rest/issue")
.then( (response) => {
    createElement(response);
    datalist = response ;
})
.catch((err) => console.log(err));