#language: pt
#encoding: UTF-8

Funcionalidade: Consultar Registros

  Cenario: Consultar todos os registros
    Dado que o usuario deseja realizar uma consulta geral pela url "/posts"
    Entao o status code ao realizar uma consulta geral com sucesso deve ser 200 e deve retornar a lista com um ou mais registros cadastrados   
  
  Cenario: Consultar registro por id
    Dado que o usuario deseja realizar uma consulta de registro por um id existente
    Entao o status code ao realizar uma consulta por id com sucesso deve ser 200 e deve retornar a lista com o resusultado referente ao id
    
  Cenario: Consultar registro por id inexistente
    Dado que o usuario deseja realizar uma consulta de registro pelo id inexistente 00
    Entao o status code ao realizar uma consulta por id inexistente deve ser 404
    
  Cenario: Consultar comentarios do registro por postid
    Dado que o usuario deseja realizar uma consulta de comentario de registro pelo postid 2
    Entao o status code ao realizar uma consulta de comentarios por postid com sucesso deve ser 200 e deve retornar a lista com o resusultado referente ao postid