#language: pt
#Author: abdiel.cordeiro@rsinet.com.br
Funcionalidade: Ação de Cadastrar um Usuário no aplicativo

  Contexto: 
    Dado O usuário esta home do aplicativo para cadastrar
    Quando Navega para o login
    E clicar em cadastrar novo usuário

  @SucessoCadastro
 Esquema do Cenário: Cadastrar um usuário com sucesso
    Dado preenche formulario de cadastro sucesso "<qntLinhas>"
    E Clica no botão de registrar
    Então Valida usuário cadastrardo com sucesso

Exemplos:
	|qntLinhas|
	| 1	|
	| 2	|
	| 3	|

  @Falha
  Cenário: Cadastrar um usuário com falha
    Dado preenche formulario de cadastro falha
    E Clica no botão de registrar
    Então valida mensagem de usuário incorreto
