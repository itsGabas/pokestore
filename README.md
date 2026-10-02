# 🎒 Pokestore API

API REST de uma loja Pokémon, feita com **Spring Boot** e **PostgreSQL**. Permite cadastrar, listar, atualizar e remover produtos como Pokébolas, poções, Rare Candies e até baby Pokémons.

> Projeto de estudo para fixar os fundamentos do desenvolvimento back-end com Java: camadas, persistência com JPA, API REST e containers com Docker.

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| **Java 21** | Linguagem |
| **Spring Boot 4** | Framework principal |
| **Spring Web MVC** | Camada REST |
| **Spring Data JPA / Hibernate** | Persistência e acesso ao banco |
| **PostgreSQL 16** | Banco de dados relacional |
| **Docker Compose** | Sobe o banco automaticamente |
| **Spring Security** | Presente no projeto, liberado durante o desenvolvimento |
| **Lombok** | Redução de código repetitivo |
| **Maven** | Gerenciamento de dependências |

---

## 🧱 Estrutura do projeto

```
src/main/java/br/com/first/crud/
├── config/        # Configurações (SecurityConfig)
├── controller/    # Endpoints REST
├── model/         # Entidades JPA e enums
├── repository/    # Interfaces de acesso ao banco
├── service/       # Regras de negócio
└── CrudApplication.java
```

A aplicação segue a arquitetura em camadas: **Controller → Service → Repository → Banco**.

---

## 🚀 Como rodar

### Pré-requisitos

- [Java 21](https://adoptium.net/)
- [Docker](https://www.docker.com/) instalado e **aberto**
- Maven (ou use o wrapper `mvnw` que já vem no projeto)

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/itsGabas/pokestore.git
cd pokestore

# 2. Rode a aplicação
./mvnw spring-boot:run        # Linux/Mac
mvnw.cmd spring-boot:run      # Windows
```

Não é preciso subir o banco manualmente: com o **Spring Boot Docker Compose Support**, a aplicação lê o `compose.yaml`, sobe o container do PostgreSQL e configura a conexão sozinha.

A API fica disponível em `http://localhost:8080`.

> O PostgreSQL do container usa a porta **5433** no host, para não conflitar com um Postgres local na 5432.

---

## 📡 Endpoints

Base: `/produtos`

| Método | Rota | Descrição | Retorno |
|---|---|---|---|
| `GET` | `/produtos` | Lista todos os produtos | `200 OK` |
| `GET` | `/produtos/{id}` | Busca um produto pelo ID | `200 OK` / `404` |
| `POST` | `/produtos` | Cadastra um novo produto | `201 Created` |
| `PUT` | `/produtos/{id}` | Atualiza um produto existente | `200 OK` / `404` |
| `DELETE` | `/produtos/{id}` | Remove um produto | `204 No Content` / `404` |

### Exemplo de requisição

`POST /produtos`

```json
{
  "nome": "Ultraball",
  "descricao": "Pokébola de alta taxa de captura",
  "categoria": "POKEBALL",
  "preco": 12.50,
  "quantidade": 100
}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "nome": "Ultraball",
  "descricao": "Pokébola de alta taxa de captura",
  "categoria": "POKEBALL",
  "preco": 12.50,
  "quantidade": 100
}
```

### Categorias disponíveis

`POKEBALL` · `POCAO` · `DOCE` · `POKEMON` · `OUTROS`

---

## 🗺️ Próximos passos

- [ ] DTOs de entrada e saída (não expor a entidade)
- [ ] Validação de dados com Bean Validation
- [ ] Tratamento global de erros com `@RestControllerAdvice`
- [ ] Filtro por categoria e busca por nome
- [ ] Testes unitários e de integração
- [ ] Documentação com Swagger/OpenAPI
- [ ] Autenticação com JWT
- [ ] Migrations com Flyway
- [ ] Deploy

---

## 👨‍💻 Autor

Feito por **Gabriel** ([@itsGabas](https://github.com/itsGabas)) como parte da minha jornada de estudos em desenvolvimento back-end com Java.
