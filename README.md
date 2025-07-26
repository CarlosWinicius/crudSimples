# CRUD Simples com JavaFX, FXML e JPA

Este projeto foi desenvolvido como parte do meu aprendizado em **arquitetura de software**, **JavaFX (FXML)** e **CRUD (Create, Read, Update, Delete)** utilizando **JPA/Hibernate** para persistência de dados.

O objetivo principal foi estudar como organizar um projeto Java com **boas práticas**, separando as camadas de **Controller**, **Service**, **DAO** e **Entity**, além de trabalhar com interfaces gráficas usando **JavaFX**.

---

## 🚀 Funcionalidades

- Interface gráfica com **JavaFX e FXML**.
- CRUD completo para a entidade **User**:
  - Criar usuário.
  - Listar usuários.
  - Atualizar informações.
  - Remover usuário.
- Integração com **JPA (Hibernate)** para persistência de dados.
- Conexão com banco de dados através da classe **ConnectionFactory**.

---

## 📂 Estrutura do Projeto

A estrutura principal do código fonte é organizada assim:

```
src
└── main
    ├── java
    │   ├── app
    │   │   └── Main.java                 # Ponto de entrada da aplicação
    │   ├── controllers.ui
    │   │   └── UserCreationController.java
    │   ├── model
    │   │   ├── connection
    │   │   │   └── ConnectionFactory.java
    │   │   ├── dao
    │   │   │   └── UserDAO.java
    │   │   ├── entity
    │   │   │   └── User.java
    │   │   └── services
    │   │       └── UserService.java
    ├── resources
    │   ├── META-INF
    │   │   └── persistence.xml           # Configuração JPA
    │   └── view
    │       └── UserFxml.fxml             # Layout da interface JavaFX
```

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **JavaFX (FXML)**
- **JPA (Hibernate)**
- **Maven** para gerenciamento de dependências.

---

## 📚 O que aprendi

- Criar interfaces gráficas com JavaFX e separar a lógica em **Controllers**.
- Implementar a **arquitetura em camadas** (Controller → Service → DAO → Entity).
- Usar **JPA/Hibernate** para persistir dados em banco de dados.
- Configurar o **`persistence.xml`** e a **ConnectionFactory** para conectar à base de dados.
- Gerenciar dependências e build com Maven.

---

## ▶️ Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/CarlosWinicius/crudSimples.git
   ```

2. **Abra o projeto na sua IDE** (recomendado **IntelliJ**).

3. **Configure o banco de dados** no arquivo:
   ```
   src/main/resources/META-INF/persistence.xml
   ```

4. **Execute a classe `Main.java`.**

---


Projeto criado para **fins de estudo**.
