# Projeto Academy
![GitHub repo size](https://img.shields.io/github/repo-size/paulorosmaninho/academy)
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/paulorosmaninho/academy/blob/master/LICENSE) 

### Disponível no Heroku através da URL: https://academysb.herokuapp.com/

# Sobre o projeto

O projeto Academy é uma aplicação full stack web e mobile, construída durante o curso de Spring Boot do canal **Jamerson Souza** (https://www.youtube.com/c/JamersonTutoriais).

O objetivo do curso foi demonstrar conceitos do Spring Boot e Spring MVC para a construção de um CRUD com tela de login para ter acesso à aplicação.

A aplicação contém um cadastro de novos usuários para permitir acesso via login. Ao acessar a aplicação é possível cadastrar, consultar, alterar e excluir alunos.

A aplicação demonstra no canto direito superior o usuário logado e durante a inclusão ou alteração faz um registro de auditoria, demonstrando, na tela de alteração, o último usuário que fez manutenção no registro.

## Novos recursos implementados após o curso:
* Controle de sessão que força o usuário se logar caso tenha saído da aplicação.
* Envio de e-mail de boas vindas após o cadastro do usuário.
* Um módulo para recuperação de senha de usuário. Esse módulo gera uma nova senha e envia um e-mail ao usuário.
* Uma tela para fazer a manutenção do usuário e trocar de senha. O sistema também envia um e-mail ao usuário informando que a senha foi trocada.
* Paginação em todas as telas que possuem listas.
* Inclusão de Modal com mensagens padronizadas de confirmação de ação.
* Apresentação do nome do usuário logado que é apresentado no canto superior direito.

## Layout responsivo para web e mobile

### Tela de Login
![Web 1](https://github.com/paulorosmaninho/assets/blob/master/academy/login.png)

### Menu responsivo para mobile
![Web 2](https://github.com/paulorosmaninho/assets/blob/master/academy/menu-mobile-responsivo.png)

### Home
![Web 3](https://github.com/paulorosmaninho/assets/blob/master/academy/home.png)

### Tela de cadastro do aluno
![Web 4](https://github.com/paulorosmaninho/assets/blob/master/academy/cadastro-aluno.png)

### Filtro de alunos
![Web 5](https://github.com/paulorosmaninho/assets/blob/master/academy/filtro-aluno.png)

### Lista de alunos ativos paginada
![Web 6](https://github.com/paulorosmaninho/assets/blob/master/academy/pesquisa-alunos-ativos.png)

### Tela de alteração de aluno
![Web 7](https://github.com/paulorosmaninho/assets/blob/master/academy/alterar-aluno.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- Thymeleaf
## Front end
- HTML / CSS / JS
- Bootstrap
## Implantação em produção
- Back e front end: Heroku
- Banco de dados: PostgreSQL

# Como executar o projeto

```bash
# clonar repositório
git clone https://github.com/paulorosmaninho/academy.git
# entrar na pasta local do projeto
exemplo: cd academy
# executar o comando abaixo
mvnw spring-boot:run
# abrir o browser de sua preferência e digitar
localhost:8080
```

## Back end
Pré-requisitos: 
Java versão 17
PostgreSQL versão 13

# Autor
Paulo Rosmaninho

https://www.linkedin.com/in/paulorosmaninho
