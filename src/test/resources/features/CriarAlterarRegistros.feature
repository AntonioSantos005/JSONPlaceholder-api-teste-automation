#language: pt
#encoding: UTF-8

Funcionalidade: Criar-Alterar Registros

 	Cenario: Inserir novo registro
    Dado que o usuario deseja inserir um novo registro com um userId valido, o title "teste api jsonplaceholder title" e o body "teste api jsonplaceholder body"
    Entao o status code ao inserir um registro com sucesso deve ser 201
    	
  Cenario: Alterar registro
    Dado que o usuario deseja alterar um registro com um userId ja cadastrado, o title "teste api title alterado" e o body "teste api body alterado"
    Entao o status code ao alterar um registro com sucesso deve ser 200
  
  
  Cenario: Alterar registro inexistente
    Dado que o usuario deseja alterar um registro com um userId inexistente 00, o title "teste api title alterado" e o body "teste api body alterado"
    Entao o status code ao alterar um registro com userId inexistente deve ser 500
    #Ao informar um userId inexistente a API deveria retornar 404(not found) ou 201(created), mas o statusCode recebido é 500
  
  Cenario: Alterar parcialmente registro
    Dado que o usuario deseja alterar parcialmente um registro com um userId ja cadastrado e apenas o title "teste api title alterado parcialmente"
    Entao o status code ao alterar parcialmente um registro com sucesso deve ser 200