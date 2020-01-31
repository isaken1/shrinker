# Shrinker

## Sobre o sistema

O _Shrinker_ é um simples sistema de geração de URLs encurtadas com autenticação via JWT.

## Utilização

A aplicação se divide em duas partes: 
* O back-end feito em Java/Spring que fornece as APIs para gerenciamento dos dados e serviços de armazenamento
e autenticação, encontrado no módulo **shrinker-back**.
* O front-end escrito em Javascript utilizando o Vue.js para explicitar uma interface para interação do
usuário com o sistema, encontrado no módulo **shrinker-front**.

Dito isso, para rodar o sistema localmente, primeiramente é necessário que sejam resolvidas as dependências.
Para isso, foi escolhido o Maven como gerenciador de dependências no módulo de back-end, e para o front é
utilizado o NPM.

Para rodar o sistema Spring, também é necessário configurar três variáveis de ambiente 
(vide application-dev.properties):
* **DB_URL**: URL de conexão com o banco de dados contendo o driver a ser utilizado, o endereço do servidor
local, a porta de conexão e o nome do banco que será utilizado. Pode-se também adicionar variáveis opcionais
de configuração, se necessário.
* **DB_USERNAME**: Nome do usuário que será utilizado pelo sistema para se conectar ao banco.
* **DB_PASSWORD**: Senha de conexão com o banco.
Adicionadas estas variáveis ao ambiente (fica a seu critério adicionar outras configurações do Spring) e
resolvidas as dependências, o back-end do sistema já deve estar pronto para rodar! Basta rodar primeiro o serviço
do backend via maven e depois o front via npm (o script é o padrão do Vue, `npm run serve`)

