<h1 align="center"> Sistema-Multas-Trânsito </h1>

# Integrantes 
- Breno Amorim Candido
- Bruno Augusto dos Santos Pereira
- Gabriel Ferreira Delinardi
- Gabriel Frigo Sena

# Vídeo do Grupo
O vídeo abaixo é um explicativo do projeto e demonstração de seu funcionamento:
- Link Youtube: https://www.youtube.com/watch?v=BnzyrNhD3tc

# Introdução
O projeto em que trabalhamos DETRAN/SP consiste no desenvolvimento de um sistema em **Java** para controle e gerenciamento de multas de trânsito na cidade de São Paulo. Este sistema deve atender a diferentes tipos de infrações, como excesso de velocidade, desrespeito ao rodízio municipal de veículos e circulação irregular em corredores exclusivos de ônibus. O objetivo é automatizar a análise de ocorrências e aplicação de multas, fornecendo uma solução eficiente e moderna para o gerenciamento de infrações.

### Principais características do sistema:
1. **Classes e Regras de Negócio**:  
   O sistema se baseia em uma estrutura de classes modelada em UML. Inclui a classe abstrata **RegraMulta**, que representa uma multa genérica, e subclasses específicas que implementam regras para os diferentes tipos de infrações. Por exemplo, uma regra de velocidade verifica o limite permitido para uma via específica, enquanto uma regra de rodízio considera horários e placas.

2. **Base de Dados**:  
   As ocorrências de trânsito são armazenadas em uma **BaseDeDados**, com listas separadas para ocorrências processadas, não processadas e multas geradas. A base de dados também armazena as regras que são inicializadas programaticamente no início do sistema.

3. **Interface do Usuário**:  
   O sistema inclui uma interface para:
   - Cadastrar ocorrências de trânsito.
   - Registrar e visualizar regras de multas.
   - Exibir as multas calculadas, com possibilidade de filtragem por **data** e **placa do veículo**.

4. **Processamento das Ocorrências**:  
   O sistema lê uma base de dados inicial de ocorrências, processa cada uma conforme as regras definidas, e gera multas classificadas em níveis:  
      - **0:** Sem multa  
      - **1:** Multa leve  
      - **2:** Multa média  
      - **3:** Multa grave  

5. **Validação e Usabilidade**:  
   Para evitar erros, foram projetadas validações adequadas nas entradas do usuário, como a seleção de logradouros predefinidos. Há também suporte para inicialização manual de regras, abrangendo ao menos 10 logradouros e 25 regras no total.

6. **Repositório GitHub**:  
   O projeto exige a criação de um repositório no **GitHub**, contendo todo o código-fonte, documentação em formato README, orientações para executar o sistema e rastreamento de versões.

7. **Apresentação em Vídeo**:  
   Além do código, o grupo deve preparar e apresentar um vídeo explicativo, com duração entre 10 e 20 minutos, demonstrando a funcionalidade do sistema. Todos os integrantes devem participar da apresentação para que suas notas sejam integralmente atribuídas.

### Objetivo Geral:
O sistema busca automatizar e melhorar o controle de trânsito, facilitando o gerenciamento de infrações e o cumprimento das normas municipais. O projeto une conceitos de programação orientada a objetos, design de interfaces e validação de dados, propondo uma solução tecnológica eficaz para um problema urbano relevante.
