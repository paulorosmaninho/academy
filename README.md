# Projeto Academy
![GitHub repo size](https://img.shields.io/github/repo-size/paulorosmaninho/academy)
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/paulorosmaninho/academy/blob/master/LICENSE) 

# Sobre o projeto

https://academysb.herokuapp.com/

O projeto Academy é uma aplicação full stack web e mobile, construída durante o curso de Spring Boot do canal **Jamerson Souza** (https://www.youtube.com/c/JamersonTutoriais).

O objetivo do curso foi demonstrar conceitos do Spring Boot e Spring MVC para a construção de um CRUD com tela de login para ter acesso à aplicação.

A aplicação contém um cadastro de novos usuários para permitir acesso via login. Ao acessar a aplicação é possível cadastrar, consultar, alterar e excluir alunos.

A aplicação demonstra no canto direito superior o usuário logado e durante a inclusão ou alteração faz um registro de auditoria, demonstrando, na tela de alteração, o último usuário que fez manutenção no registro.

Após o curso foram incluídos:
* Uma tela para troca de senha e também para fazer a manutenção de usuário.
* Um módulo para usuários que esqueceram a senha. Ele gera uma nova senha e chama uma API REST para enviar o e-mail. A API de envio de e-mail também foi construída por mim.
* O nome do usuário logado que é apresentado no canto superior direito.

## Layout web
![Web 1](https://github.com/paulorosmaninho/assets/blob/master/academy/login.png)
![Web 2](https://github.com/paulorosmaninho/assets/blob/master/academy/home.png)
![Web 3](https://github.com/paulorosmaninho/assets/blob/master/academy/cadastro-aluno.png)
![Web 4](https://github.com/paulorosmaninho/assets/blob/master/academy/filtro-aluno.png)
![Web 5](https://github.com/paulorosmaninho/assets/blob/master/academy/alterar-aluno.png)

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
