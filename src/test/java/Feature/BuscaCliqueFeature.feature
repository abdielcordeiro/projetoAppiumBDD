#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de buscar um produto por clique

  Contexto: 
    Dado Que o usuário esteja na tela principal clique
    Quando faz login
    E Clica em uma categoria
    E Clica no produto desejado

  @Sucesso 
  Cenário: Buscar um produto por clique com Sucesso
    Então Valida produto encontrado com sucesso

  @Falha 
  Cenário: Buscar um produto que não exista
    E Clica para adicionar mais produtos
    E Coloca a quantidade de produto desejada e adiciona
    E Clica para entrar no carinho
    Então Valida a quantidade de produtos
