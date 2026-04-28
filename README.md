# Comunicação Interprocessos - Cliente/Servidor em Java

## Descrição

Este projeto implementa um sistema simples de comunicação cliente-servidor utilizando **sockets em Java**, para a disciplina de **Sistemas Operacionais**. O servidor aguarda conexões de clientes e responde às mensagens recebidas, enquanto que o cliente se conecta ao servidor, envia mensagens digitadas pelo usuário e exibe as respostas recebidas.

---

## Sumário

- [Autores](#autores)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar](#como-executar)
- [Funcionamento](#funcionamento)
  - [Servidor](#servidor)
  - [Cliente](#cliente)
- [Exemplo de Uso](#exemplo-de-uso)
- [Conceitos Aplicados](#conceitos-aplicados)
- [Observação](#observação)

---

## Autores

<b>Discentes:</b><br>
<a href="https://github.com/izalouyza">Izadora Louyza Silva Figueiredo</a><br>
<a href="https://github.com/livianlucena">Lívian Maria Lucena Gomes Pinheiro</a><br>
<a href="https://github.com/tivitoriarocha">Maria Vitória Fernandes Rocha</a><br>
<a href="https://github.com/Victor350br">Victor Hugo de Oliveira</a><br>

---

## Estrutura do Projeto

```
comunicacaointerprocessos/
│
├── src/
│   ├── Cliente.java
│   └── Servidor.java
│
├── .gitignore
└── README.md
```

---

## Tecnologias Utilizadas

* Java
* API de Sockets (`java.net`)
* Entrada e saída de dados (`java.io`)

---

## Como Executar

### 1. Compilar os arquivos

Dentro da pasta `src`:

```bash
javac Cliente.java Servidor.java
```

---

### 2. Executar o Servidor

```bash
java Servidor
```

Saída esperada:

```
INICIANDO SERVIDOR...
Aguardando conexão de cliente...
```

---

### 3. Executar o Cliente

Em outro terminal:

```bash
java Cliente
```

---

## Funcionamento

### Servidor

* Escuta conexões na porta **12345**
* Aceita um cliente
* Recebe mensagens
* Responde com:

  ```
  Mensagem recebida com sucesso!
  ```
* Encerra quando recebe `"sair"`

---

### Cliente

* Conecta ao servidor (`localhost:12345`)
* Permite digitar mensagens via teclado
* Envia mensagens ao servidor
* Exibe respostas recebidas
* Encerra ao digitar `"sair"`

---

## Exemplo de Uso

### Cliente:

```
[Cliente] > Olá
```

### Servidor:

```
[Cliente] > Olá
```

### Cliente recebe:

```
[Servidor] > Mensagem recebida com sucesso!
```

---

## Conceitos Aplicados

* Comunicação cliente-servidor
* Sockets TCP
* Streams de entrada e saída
* Programação concorrente (conceito base, versão atual com 1 cliente)

---

## Observação

Certifique-se de executar primeiro o **Servidor** antes do **Cliente**, caso contrário a conexão não será estabelecida.
