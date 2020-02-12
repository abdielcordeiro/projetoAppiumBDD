#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de buscar um produto por clique

  Contexto: 
    Dado Que o usuário esteja na tela principal clique
    E Clica em uma categoria

  @Sucesso
  Cenário: Buscar um produto por clique com Sucesso
    E Clica no produto desejado
    Então Valida produto encontrado com sucesso

  @Falha
  Cenário: Buscar um produto que não exista
    E Clica no filtros
    E Adiciona filtros para buscar um produto
    Então Valida produto não encontrado pelos filtro
