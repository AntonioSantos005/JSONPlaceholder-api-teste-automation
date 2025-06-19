#language: pt
#encoding: UTF-8

Funcionalidade: Apagar Registros

 Cenario: Apagar registro
    Dado que o usuario deseja apagar um registro que possua um userId valido
    Entao o status code ao apagar um registro com sucesso deve ser 200