🎓 Trabalho de Avaliação: Estruturas de Dados em Java
Este projeto acadêmico foca na implementação manual (do zero) de estruturas de dados clássicas — Pilhas 🥞, Filas ➡️ e Listas Ligadas ⛓️ (Simples e Duplamente) — utilizando a linguagem Java 💻.

O principal desafio e requisito do projeto é a proibição estrita 🛑 do uso de quaisquer bibliotecas de coleções prontas do java.util (como Stack, Queue, LinkedList, ArrayList, etc.). Todo o gerenciamento de memória 🧠, ponteiros 👆 e nós (Nodes) é feito manualmente.

📝 Nota sobre a Nomenclatura (Padrão Inglês 🌍)

Para simular um ambiente de desenvolvimento profissional e praticar as convenções da indústria de software 🧑‍💻, todo o código-fonte do projeto (nomes de classes, métodos e variáveis) foi intencionalmente escrito em inglês (ex: OrderQueue, SongNode, addFirst()).

Esta abordagem ajuda a familiarizar o desenvolvedor com os padrões globais de codificação 🌐, tornando o código mais legível e manutenível em um contexto internacional. A documentação (como este README) permanece em português para descrever os requisitos.

📂 Estrutura do Projeto
O trabalho é dividido em duas partes principais e independentes:

1. ☕️ Sistema de Cafeteria (Pilha e Fila)
Esta aplicação simula um sistema de gerenciamento de pedidos para uma cafeteria, utilizando duas estruturas de dados distintas:

OrderQueue (Fila de Pedidos): Implementada com uma Lista Simplesmente Ligada, gerencia os pedidos pendentes 📋. Segue o princípio FIFO (First-In, First-Out), onde o primeiro pedido a entrar é o primeiro a ser servido.

OrderStack (Pilha de Cancelados): Implementada com uma Lista Simplesmente Ligada, gerencia os pedidos que foram cancelados ❌. Segue o princípio LIFO (Last-In, First-Out), permitindo que o último pedido cancelado seja o primeiro a ser restaurado.

O sistema permite adicionar ✅, servir 🍽️, cancelar ↩️ e restaurar pedidos, movendo os itens entre a fila e a pilha.

Arquivos 🗃️:

CafeteriaDemo.java (Classe principal com menu)

OrderQueue.java (Implementação da Fila)

OrderStack.java (Implementação da Pilha)

SinglyNode.java (Nó da lista simples)

Order.java (Classe de dados)

2. 🎵 Gerenciador de Músicas (Lista Duplamente Ligada)
Esta aplicação simula um player de música básico 🎧 com gerenciamento de playlists, utilizando uma Lista Duplamente Ligada (Playlist.java).

O uso de uma lista duplamente ligada é essencial aqui, pois permite a navegação eficiente em ambos os sentidos (para a música next ⏭️ e previous ⏮️), o que seria ineficiente em uma lista simplesmente ligada.

Funcionalidades Principais:

Navegação: Avançar para a próxima música e voltar para a anterior.

Gerenciamento: Adicionar músicas no início ➕, fim ou em posição específica.

Remoção: Remover uma música pelo título ➖.

Ordenação: Ordenar a playlist por título ou artista 📊 (usando Bubble Sort simples).

Visualização: Listar todas as músicas 📜 e "tocar" (exibir) a música atual ▶️.

Arquivos 🗃️:

MusicManager.java (Classe principal com menu)

Playlist.java (Implementação da Lista Duplamente Ligada)

SongNode.java (Nó da lista dupla, com ponteiros next e previous)

Song.java (Classe de dados)

Meus agradecimentos ao professor Juliano!
