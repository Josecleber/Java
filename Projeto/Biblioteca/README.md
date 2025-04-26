# Sistema de Gerenciamento de Biblioteca (Java + Swing + H2)

Este é um sistema desktop de gerenciamento de biblioteca com interface gráfica feito em Java. Ele permite:

- Cadastro, listagem, edição e exclusão de livros, usuários e empréstimos
- Validação de estoque antes de registrar empréstimos
- Interface gráfica usando `Swing`
- Banco de dados em memória com `H2`

---

## Tecnologias Utilizadas

- Java 8+
- Swing (interface gráfica)
- JDBC
- H2 Database (em memória)
- Estrutura MVC com DAOs

---

## Estrutura de Pacotes

- `conexao/` – Conexão com o banco H2
- `livro/` – Entidade e DAO de livros
- `usuario/` – Entidade e DAO de usuários
- `emprestimo/` – Entidade e DAO de empréstimos
- `show/` – Interface gráfica (telas e menu principal)

---

## Como Executar

### 1. Abra o projeto no IntelliJ ou outro IDE Java

> Certifique-se de que o SDK do Java esteja configurado

### 2. Rode a classe principal:

```java
show.BibliotecaApp
```

# Banco de Dados

Utiliza o H2 em memória

Tabelas são criadas automaticamente na primeira execução

# Exemplo de Fluxo

Abra a aplicação

Clique em "Gerenciar Livros" e adicione um novo livro

Clique em "Gerenciar Usuários" e adicione um usuário

Clique em "Gerenciar Empréstimos" e registre um novo empréstimo usando os IDs dos dois anteriores

## Autores

José Cleber Alves da Cruz Mendes  

Joaquim Marcelo Zaiden

Luiz Gustavo Moreira Lima

Bryan Henrique Oliveira Evangelista

Projeto apresentado na UNIUBE, 2024.
Curso: Engenharia da Computação – Uniube
