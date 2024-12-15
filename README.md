### Hackathon CESUPA: Gerenciador de Módulos Habitacionais

---

#### **Sobre o Hackathon**

O Hackathon foi uma atividade avaliativa realizada no CESUPA para encerrar o semestre de forma prática e desafiadora. O desafio consistia em desenvolver um **Gerenciador de Módulos Habitacionais**, utilizando exclusivamente a linguagem **Java**. A atividade reforçou os conceitos de programação orientada a objetos, estrutura de dados e boas práticas de desenvolvimento.

---

#### **Objetivo do Projeto**

Desenvolver uma aplicação funcional em Java que permita:  
- **Cadastro e gerenciamento de módulos habitacionais**, incluindo atributos como localização, tamanho, status e capacidade.  
- **Atualização do status de cada módulo** (disponível, ocupado, em manutenção).  
- **Relatórios simples** sobre ocupação e disponibilidade dos módulos.  
- **Organização e busca** por módulos com base em critérios específicos.

---

#### **Requisitos do Projeto**

1. **Funcionalidades obrigatórias:**
   - Sistema para cadastrar, editar, excluir e listar módulos habitacionais.
   - Organização dos módulos em listas ou estruturas adequadas (ex.: ArrayList ou HashMap).
   - Implementação de filtros para busca por status, localização ou capacidade.
   - Menu interativo no console para navegação entre as opções.

2. **Especificações técnicas:**
   - Linguagem: **Java** (versão mínima 8).
   - Estrutura do projeto organizada em pacotes (ex.: `model`, `service`, `main`).
   - Uso de **POO** (classes para representar módulos habitacionais e serviços de gestão).
   - Validação de entradas e tratamento de exceções.

3. **Entrega final:**
   - Código documentado.
   - Arquivo `README` explicando o funcionamento do sistema.
   - Demonstração do programa em execução.

---

#### **Critérios de Avaliação**

- **Funcionalidade**: o programa atende a todos os requisitos propostos.
- **Estrutura e organização do código**: aplicação das melhores práticas de desenvolvimento em Java.
- **Clareza**: menu interativo e mensagens intuitivas para o usuário.
- **Originalidade**: ideias criativas para apresentar ou organizar os dados.
- **Tratamento de erros**: validação e estabilidade do sistema.

---

#### **Exemplo de Menu**

```plaintext
=== Gerenciador de Módulos Habitacionais ===
1. Cadastrar novo módulo
2. Listar módulos
3. Atualizar status de um módulo
4. Buscar módulos por filtro
5. Excluir módulo
6. Sair
Escolha uma opção: 
```

---

#### **Exemplo de Estrutura do Código**

1. **Pacote `model`:**
   - Classe `ModuloHabitacional` com atributos como `id`, `localizacao`, `status` e `capacidade`.

2. **Pacote `service`:**
   - Classe `ModuloService` para gerenciar a lógica de cadastro, listagem, busca e atualização.

3. **Pacote `main`:**
   - Classe `App` contendo o menu principal e interação com o usuário.

---

#### **Agradecimentos**

Agradecemos ao CESUPA pela iniciativa e aos professores pela orientação. O Hackathon proporcionou uma experiência prática essencial para consolidar nosso aprendizado.

---

#### **Autores**

Este projeto foi desenvolvido pelos estudantes de **Ciência da Computação - CESUPA**, como parte do Hackathon de final de semestre.  
Para mais informações, entre em contato com a coordenação do curso.
