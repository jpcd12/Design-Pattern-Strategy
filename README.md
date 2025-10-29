# Design-Pattern-Strategy
Repositório referente a atividade 08 de Engenharia de Software III, sobre o Design Pattern: Strategy

## Exemplo de Cálculo de Média

Projeto demonstrativo do padrão de projeto Strategy em Java. A aplicação isola diferentes formas de calcular a média (Aritmética e Geométrica) em estratégias independentes e permite que a disciplina escolha a estratégia em tempo de execução.

## Visão Geral
- Estratégias implementadas:
  - Média Aritmética: média = (p1 + p2) / 2 — aprovado se média ≥ 5.0
  - Média Geométrica: média = √(p1 × p2) — aprovado se média ≥ 7.0
- Não há condicionais para selecionar a fórmula; a decisão é feita por injeção da estratégia (via construtor ou setter).
- O projeto está organizado por pacotes conforme recomendado.

## Estrutura de pacotes
- br.padroes.strategy.app
  - Main.java (ponto de entrada)
- br.padroes.strategy.strategy
  - MediaStrategy.java (interface)
  - Aritmetica.java (implementação)
  - Geometrica.java (implementação)
- br.padroes.strategy.model
  - Disciplina.java (context)

Exemplo de layout de pastas (a partir do diretório do projeto):
```
src/
└── br/
    └── padroes/
        └── strategy/
            ├── app/
            │   └── Main.java
            ├── strategy/
            │   ├── MediaStrategy.java
            │   ├── Aritmetica.java
            │   └── Geometrica.java
            └── model/
                └── Disciplina.java
```

## Requisitos
- JDK 8+ instalado
- Linha de comando (Terminal / CMD / PowerShell)

## Compilação (linha de comando)
A partir da raiz do projeto (onde está a pasta `src`), execute:
```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```
Observação: em Windows, substitua `$(find src -name "*.java")` por uma listagem adequada (ou use um build tool como Maven/Gradle). Alternativamente, compile pacote por pacote:
```bash
javac -d out src/br/padroes/strategy/strategy/*.java src/br/padroes/strategy/model/*.java src/br/padroes/strategy/app/*.java
```

## Execução
Após compilação, execute a classe Main:
```bash
java -cp out br.padroes.strategy.app.Main
```

## Saída Esperada
A execução imprime a saída formatada com duas casas decimais. Exemplo:

=== MÉDIA ARITMÉTICA ===
P1: 10,00  P2: 5,00  Média: 7,50  Situação: Aprovado

=== MÉDIA GEOMÉTRICA ===
P1: 10,00  P2: 5,00  Média: 7,07  Situação: Aprovado

(obs.: a vírgula decimal depende do Locale; o Main usa Locale pt-BR para exibir vírgula)

## Como trocar a estratégia
A estratégia é injetada em `Disciplina` via construtor (ou via `setEstrategia`).
- Para usar média aritmética:
  - `new Disciplina(new Aritmetica())`
- Para usar média geométrica:
  - `new Disciplina(new Geometrica())`

Exemplo no `Main`:
```java
testarEstrategia(new Aritmetica(), ptBr);
testarEstrategia(new Geometrica(), ptBr);
```

## Validações e Boas Práticas
- `Disciplina#setP1` e `setP2` validam notas entre 0.0 e 10.0 (lançam IllegalArgumentException se fora do intervalo).
- `Disciplina` delega o cálculo e verificação de situação para a `MediaStrategy`.
- Use `@Override` nas implementações das estratégias.
- Evite condicionais para escolher algoritmos; adote Strategy para manter o código aberto para extensão e fechado para modificação.

## Extensões sugeridas
- Ler notas via `Scanner` para execução interativa no console.
- Adicionar novas estratégias (por exemplo, média ponderada) apenas implementando `MediaStrategy`.
- Criar testes unitários com JUnit para validar cálculos e validações.
- Empacotar com Maven ou Gradle para builds automatizados.

---

Autor: João Pedro Carvalho Duarte
