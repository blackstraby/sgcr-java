/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 *
 * @author ariel
 */
public class ValidarProduto {

    public ValidarProduto() {
    }

    public boolean validarNome(InterfaceProduto prod) {

        String nome = prod.getNome();

        if (nome.length() >= 4 && nome.length() < 25) {
            return true;
        } else {
            return false;
        }
    }
}
