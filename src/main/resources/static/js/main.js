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

    var httpRequest = new XMLHttpRequest();

    var url = "/enviar";
    httpRequest.open("POST", url, /* async = */ false);
    httpRequest.setRequestHeader("Content-Type", "application/json");

    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            alert(JSON.parse(httpRequest.responseText));
        }
    };
    var data = JSON.stringify(
        {
            "contact": name,
            "email": email,
            "company": company,
            "equipment": equip,
            "type": op,
            "description": msg
        });
    httpRequest.send(data);

    if (httpRequest.status === 201) {
        onSuccessPopup();
    } else {
        onFailedPopup();
    }
}

function onSuccessPopup() {
    alert("Chamado enviado com sucesso!");
}

function onFailedPopup() {
    alert("Falha ao enviar chamado!");
}