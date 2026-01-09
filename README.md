API REST de Transações e Estatísticas

Uma API REST simples, rápida e direta ao ponto para registrar transações financeiras e gerar estatísticas agregadas em tempo real.
Construída com Java + Spring Boot, pensando em clareza, validações corretas e concorrência sem dor de cabeça.

Ideal para estudos, desafios técnicos e aquele projeto que começa simples… mas já nasce organizado

O que essa API faz?

✅ Registra transações com valor e data/hora

✅ Valida transações inválidas (valor ≤ 0 ou data no futuro)

✅ Armazena tudo em memória

✅ Retorna estatísticas agregadas das transações:

quantidade (count)

soma (sum)

média (avg)

mínimo (min)

máximo (max)

✅ Permite limpar todas as transações

Tecnologias usadas

Java

Spring Boot

Spring Web

Bean Validation (Jakarta Validation)

Concurrent Collections (ConcurrentLinkedQueue)

Maven (padrão Spring)

Endpoints disponíveis
➕ Criar uma transação

POST `/transacao`

Request Body:

`{
  "valor": 150.75,
  "dataHora": "2026-01-08T10:30:00-03:00"
}`


Regras de validação:

valor deve ser maior que 0

dataHora não pode estar no futuro

Respostas:

201 Created → transação criada com sucesso

422 Unprocessable Entity → dados inválidos

Remover todas as transações

DELETE `/transacao`

Resposta:

200 OK → todas as transações foram apagadas

📈 Obter estatísticas

GET `/estatistica`

Resposta:

`{
  "count": 3,
  "sum": 450.75,
  "avg": 150.25,
  "min": 100.00,
  "max": 200.75
}`

Esses dados são calculados a partir das transações atualmente armazenadas em memória.

⚠️ Observações importantes

As transações são armazenadas apenas em memória
reiniciou a aplicação, perdeu tudo

O serviço já está preparado para uso concorrente

Existe um comentário no código indicando um possível filtro de últimos 60 segundos, mas atualmente não está ativo

Possíveis melhorias futuras

Filtrar estatísticas por janela de tempo (ex: últimos 60s)

Persistência em banco de dados

Testes unitários e de integração

Documentação com Swagger/OpenAPI

Dockerização

▶️ Como executar

Clone o repositório

Abra em sua IDE favorita

Execute a aplicação Spring Boot

A API estará disponível em:

`http://localhost:1234`

📄 Licença

Projeto para fins educacionais e de estudo.
