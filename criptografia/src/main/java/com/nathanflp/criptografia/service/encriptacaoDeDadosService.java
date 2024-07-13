package com.nathanflp.criptografia.service;

import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class encriptacaoDeDadosService {

    private static final StrongTextEncryptor encriptador;

    static {
        encriptador = new StrongTextEncryptor();
        encriptador.setPassword(System.getenv("chave_criptografia"));
    }

    public static String criptografar(String data){
        return encriptador.encrypt(data);
    }

    public static String descriptografar(String data){
        return encriptador.decrypt(data);
    }

}
