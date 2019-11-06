/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emmerich.HelpdeskApp.service;

import br.com.emmerich.HelpdeskApp.bean.Chamado;
import br.com.emmerich.HelpdeskApp.util.SendEmail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estagiodev
 */
@RestController
public class Service {

    private static final SendEmail sendEmail = new SendEmail();

    @PostMapping("/enviar")
    public ResponseEntity<Chamado> enviar(@RequestBody Chamado chamado) {
        System.out.println(chamado.toString());

        boolean result = sendEmail.send(chamado);

        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body(chamado);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(chamado);
    }
}
