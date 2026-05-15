# Sistema de Gerenciamento de Vídeos e Playlists
Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos da FEI. Trata-se de uma aplicação desktop para gerenciar um catálogo de vídeos, permitindo o cadastro de usuários, avaliação de conteúdo e organização em listas de reprodução (playlists).
## Funcionalidades
O sistema possui um CRUD completo e interativo, incluindo:

* **Autenticação:** Cadastro de novos usuários e sistema de Login.
* **Gestão de Vídeos:** Cadastrar, listar, editar e excluir vídeos do catálogo.
* **Busca Inteligente:** Filtro de vídeos por nome em tempo real.
* **Sistema de Avaliação:** Opção de curtir (Like) e descurtir (Dislike) contabilizados no banco de dados.
* **Playlists (Favoritos):** * Criar, renomear e excluir listas de reprodução.
  * Adicionar e remover vídeos de playlists específicas.
  * Visualizar o conteúdo detalhado de cada lista.

## Tecnologias Utilizadas
* **Linguagem:** Java
* **Interface Gráfica:** Java Swing (JFrame, JTable, JOptionPane)
* **Banco de Dados:** PostgreSQL
* **Arquitetura:** Padrão DAO (Data Access Object) para separação da lógica de banco de dados da interface visual.

## Como executar o projeto
1. Clone este repositório em sua máquina.
2. Certifique-se de ter o PostgreSQL instalado e rodando.
3. Crie um banco de dados e execute os scripts de criação de tabelas (`tbusuarios`, `tbvideos`, `tbplaylists` e `tb_playlist_video`).
4. Atualize as credenciais de acesso ao banco na classe `Conexao.java`.
5. Execute a classe `Login.java` para iniciar a aplicação.

---
Desenvolvido por **[Danilo C. Machado]** 
