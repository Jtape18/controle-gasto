# 💸 Finance App - Controle de Gastos

Sistema de controle financeiro pessoal com autenticação via JWT, arquitetura limpa (Clean Architecture) e documentação Swagger. Permite o cadastro de usuários, gerenciamento de categorias e controle de transações.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.5.3
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- JPA / Hibernate
- Maven
- Swagger (OpenAPI)
- Docker

## 📦 Estrutura de Pastas

O projeto segue o padrão de **Clean Architecture**, dividido em camadas:

```
src/main/java/com/josepaulo/finance
│
├── application/useCases        # Casos de uso (regras de negócio)
├── config                      # Configurações globais (segurança, Swagger, etc)
├── domain                      # Entidades, enums e interfaces de repositórios
├── infra/database/repositories# Implementações dos repositórios
├── infra/security              # Filtros e serviços de JWT
├── interfaces/controller       # Controllers REST
├── interfaces/dto             # DTOs para entrada/saída de dados
```

## ✅ Funcionalidades já implementadas

### 🔐 Autenticação

- Registro de usuário (`/auth/register`)
- Login (`/auth/login`)
- Proteção dos endpoints via JWT (middleware)
- Senha criptografada com BCrypt
- Documentação dos endpoints com Swagger

### 👤 Usuários

- Listagem de todos os usuários (autenticado)
- Busca por número de WhatsApp (futuro)

### 🗂️ Categorias

- Criar categoria
- Listar categorias
- Atualizar categoria
- Deletar categoria
- Buscar por ID

> Todos os endpoints de categorias requerem token JWT.

## 📄 Documentação Swagger

Acesse:

```
http://localhost:8080/swagger-ui/index.html
```

Use o botão **Authorize** e cole o token JWT no formato:

```
Bearer eyJhbGciOi...
```

## 🛠️ Como rodar o projeto

### Requisitos

- Java 17
- Maven
- Docker (opcional para PostgreSQL)

### 1. Subir banco com Docker

```bash
docker-compose up -d
```

### 2. Rodar o projeto

```bash
./mvnw spring-boot:run
```

### 3. Gerar novo token (exemplo)

- Registre um novo usuário via `POST /auth/register`
- Faça login via `POST /auth/login`
- Copie o token retornado

## 🗃️ Variáveis de Ambiente

O projeto já usa `application.properties` para configurações locais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/finance
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
security.jwt.secret=yourBase64EncodedSecret
security.jwt.expiration=86400000
```

> Para gerar uma `secret` em Base64:  
> `echo -n "your-plain-secret" | base64`

---

## 📌 Próximos passos

- [ ] CRUD de transações
- [ ] Relatórios por mês e por categoria
- [ ] Integração com WhatsApp API (Meta Cloud API)
- [ ] Testes unitários e de integração

---

## 👨‍💻 Autor

Desenvolvido por José Paulo — Estudante de Análise e Desenvolvimento de Sistemas e Dev Backend apaixonado por boas práticas e arquitetura limpa.
