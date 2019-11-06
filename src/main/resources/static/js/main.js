/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function sendData() {
    var name = document.getElementById("nameInput").value;
    var email = document.getElementById("emailInput").value;
    var company = document.getElementById("companyInput").value;
    var equip = document.getElementById("equipmentInput").value;
    var op = document.getElementById("recipientInput").value;
    var msg = document.getElementById("exampleMessage").value;

    /*alert("NOME: " + name);
    alert("EMAIL: " + email);
    alert("EMPRESA: " + company);
    alert("EQUIPAMENTO: " + equip);
    alert("TIPO: " + op);
    alert("MENSAGEM: " + msg);*/

    var xhr = new XMLHttpRequest();
    var url = "/enviar";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            //console.log(json.email + ", " + json.password);
        }
    };
    var data = JSON.stringify(
            {"contact":name,
                "email": email,
              "company": company,
              "equipment":equip,
              "type":op,
              "description":msg
          });
    xhr.send(data);
    
    //alert(data);
}