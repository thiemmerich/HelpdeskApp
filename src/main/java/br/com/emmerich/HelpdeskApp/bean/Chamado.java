/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emmerich.HelpdeskApp.bean;

/**
 *
 * @author estagiodev
 */
public class Chamado {

    private String contact;
    private String email;
    private String company;
    private String equipment;
    private String type;
    private String description;

    public Chamado(String contact, String company, String email, String equipment, String type, String description) {
        this.contact = contact;
        this.company = company;
        this.email = email;
        this.equipment = equipment;
        this.type = type;
        this.description = description;
    }

    public Chamado() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Nome: " + this.contact + "\n"
                + "Empresa: " + this.company + "\n"
                + "Email: " + this.email + "\n"
                + "Equipamento: " + this.equipment + "\n"
                + "Tipo: " + this.type + "\n"
                + "Mensagem: " + this.description;
    }

    
}
