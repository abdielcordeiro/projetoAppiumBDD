#language: pt
#Author: abdiel.cordeiro@rsinet.com.br

Funcionalidade: Ação de buscar um produto na lupa

  Contexto: 
    Dado Que o usuário esteja na tela principal
    Quando Clica no botão da lupa

  @Sucesso
  Cenário: Buscar um produto na lupa com Sucesso
    E Digita nome do produto existente 
    E Clica na lupa para buscar Sucesso
    Então busca realizada com sucesso produto encontrado

  @Falha
  Cenário: Buscar um produto que não exista
    E Digita o nome do tipo do produto inexistente
    E Clica na lupa para buscar falha
    Então valida mensagem de produto não encontrado