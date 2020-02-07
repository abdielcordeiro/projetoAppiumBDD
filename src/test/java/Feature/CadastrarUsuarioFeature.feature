#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de Cadastrar um Usuário no aplicativo

  Contexto: 
    Dado O usuário esta home do aplicativo para cadastrar
    Quando Navega para o login
    E clicar em cadastrar novo usuário

  @Sucesso @Cadastro
  Cenário: Cadastrar um usuário com sucesso
    Dado preenche formulario de cadastro sucesso
    E Clica no botão de registrar
    Então Valida usuário cadastrardo com sucesso

  @Falha
  Cenário: Cadastrar um usuário com falha
    Dado preenche formulario de cadastro falha
    E Clica no botão de registrar
    Então valida mensagem de usuário incorreto
