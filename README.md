# Olá! 

esse é o projeto MenuApp, Este é um sistema de cardápio digital para restaurantes, desenvolvido com Spring Boot e PostgreSQL. O objetivo é permitir que estabelecimentos gerenciem seus cardápios de forma dinâmica e ofereçam aos clientes uma experiência interativa para visualizar e realizar pedidos.

O projeto foi construído utilizando as seguintes tecnologias:

*Java 17;*

*Spring Boot 3, com as seguintes implementações:*

* Spring Data JPA

* Spring Security (autenticação e autorização)

* Spring Web (APIs RESTful)

* PostgreSQL (banco de dados relacional)

* JWT (JSON Web Token para autenticação)

* Lombok (redução de boilerplate no código)

* Flyway (controle de versões do banco de dados)

* Swagger/OpenAPI (documentação da API)

## *Como Rodar o Projeto Localmente*

1️⃣ Clonar o Repositório

git clone https://github.com/seu-usuario/MenuApp.git
cd MenuApp

---

2️⃣ Configurar o Banco de Dados

O projeto já está configurado para rodar com um banco H2 em memória. Nenhuma configuração extra é necessária.

Para funcionar corretamente, edite o Application-example.Properties com os dados do banco de dados, caso queira testar, aqui está o formato padrão:

spring.flyway.enabled=false

spring.datasource.url=jdbc:h2:mem:menuapp

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=password

spring.datasource.database-to-upper=false

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true

spring.h2.console.path=/h2-console

---

## Compilar e Rodar a Aplicação

mvn clean install
mvn spring-boot:run

A aplicação estará rodando em http://localhost:8080.

 Testando a API

Acessar o Swagger

Após rodar a aplicação, acesse a documentação interativa:

👉 http://localhost:8080/swagger-ui/index.html

---

Testar Endpoints via Postman

Você pode testar os endpoints manualmente no Postman ou através do Swagger.

Exemplo de Request para Criar um Restaurante

POST /restaurantes
{
"nome": "Restaurante Exemplo",
"endereco": "Rua Exemplo, 123"
}

Exemplo de Request para Buscar Restaurantes

GET /restaurantes

---

🛠️ Personalizações Futuras

*Implementação de autenticação via JWT.*

---

### Uso de banco de dados PostgreSQL 



*Implantação em produção.*

--- 
