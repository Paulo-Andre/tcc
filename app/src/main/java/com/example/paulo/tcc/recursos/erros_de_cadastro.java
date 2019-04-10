package com.example.paulo.tcc.recursos;

import java.util.HashMap;

public class erros_de_cadastro {
    private HashMap<Integer, String> erros;

    public erros_de_cadastro() {
        this.erros = new HashMap<>();
        this.erros.put(208, "CONTA JÁ VINCULADA");
        this.erros.put(120, "DADOS NÃO ENCONTRADO");
        this.erros.put(108, "COMANDO NÃO DISPONÍVEL");
        this.erros.put(100, "CONEXÃO FALHA");
        this.erros.put(137, "VALORES DUPLICADOS");
        this.erros.put(204, "EMAIL FALTANDO ");
        this.erros.put(205,"E-MAIL NÃO ENCONTRADO ");
        this.erros.put(203,"E-MAIL ADQUIRIDO");
        this.erros.put(140, "QUOTA EXCEDIDA");
        this.erros.put(153,"ERRO DE  EXCLUIR ARQUIVO");
        this.erros.put(111, "TIPO INCORRETO ");
        this.erros.put(123, "INVÁLIDO ACL");
        this.erros.put(112, "NOME DO CANAL INVÁLIDO");
        this.erros.put(103, "NOME DE CLASSE INVÁLIDO");
        this.erros.put(125, "ENDEREÇO DE E-MAIL INVALIDO");
        this.erros.put(160,"NOME DO EVENTO INVÁLIDO");
        this.erros.put(107, "JSON INVÁLIDO");
        this.erros.put(105, "NOME DA CHAVE INVÁLIDA");
        this.erros.put(251, "SESSÃO VINCULADA INVÁLIDA");
        this.erros.put(121, "TECLA INVÁLIDA NESTADA ");
        this.erros.put(106, "PONTEIRO INVÁLIDO");
        this.erros.put(102, "CONSULTA INVÁLIDA");
        this.erros.put(139, "NOME DE PAPEL INVÁLIDO");
        this.erros.put(209, "SESSÃO INVÁLIDA TOKEN");
        this.erros.put(250, "ID LIGADO FALTANDO");
        this.erros.put(104, "ID INCIDÊNCIA DO OBJETO");
        this.erros.put(135, "ERRO DE CAMPO REQUERIDO EM FALTA");
        this.erros.put(207, "DEVE CRIAR USUÁRIO ATRAVÉS DE ASSINATURA");
        this.erros.put(109, "NÃO INICIALIZADO");
        this.erros.put(101, "DADOS NÃO ENCONTRADO");
        this.erros.put(116, "OBJETO DEMASIADO GRANDE");
        this.erros.put(119, "OPERAÇÃO PROIBIDA");
        this.erros.put(-1, "OUTRA CAUSA");
        this.erros.put(201, "SENHA FALTANDO");
        this.erros.put(115, "PUSH MISCONFIGURED");
        this.erros.put(155, "O LIMITE DO PEDIDO EXCEDIDO");
        this.erros.put(141, "ERRO DE SCRIPT");
        this.erros.put(206, "SESSÃO FALTA");
        this.erros.put(124, "TIMEOUT");
        this.erros.put(122, "NOME DE ARQUIVO INVÁLIDO");
        this.erros.put(252, "SERVIÇO NÃO SUPORTADO");
        this.erros.put(200, "NUSERNAME AUSENTE");
        this.erros.put(202, "USERNAME TAKEN");
        this.erros.put(142, "ERRO DE VALIDAÇÃO");

    }
    public String getErro(int CodeErro){
        return this.erros.get(CodeErro);
    }
}
