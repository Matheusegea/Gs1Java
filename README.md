# 🚀 NeuroSpace - Sistema de Análise Biomédica para Missões Espaciais

## 📋 Descrição

O **NeuroSpace** é um sistema desenvolvido em **Java** para gerenciamento e monitoramento de missões espaciais, com foco na análise da saúde **física** e **psicológica** de astronautas antes, durante e após viagens espaciais.

O sistema permite cadastrar missões, monitorar indicadores biomédicos, acompanhar alterações biológicas causadas pela permanência no espaço e gerar análises comparativas entre os dados coletados na Terra e os registrados em órbita.

Além disso, o projeto relaciona as missões aos **Objetivos de Desenvolvimento Sustentável (ODS)**, promovendo aplicações voltadas para inovação, saúde e desenvolvimento científico.

---

## 🚨 Problema Escolhido

Missões espaciais de longa duração podem gerar impactos severos na saúde dos astronautas devido à microgravidade, isolamento e permanência prolongada em ambientes extremos.

Entre os principais problemas monitorados pelo sistema estão:

### 🧬 Impactos Físicos

* Perda de massa muscular;
* Alterações na qualidade do sono;
* Redução da eficiência cognitiva;
* Desgaste biológico em ambiente orbital.

### 🧠 Impactos Psicológicos

* Estresse emocional;
* Isolamento psicológico;
* Alterações comportamentais;
* Redução da estabilidade mental.

O **NeuroSpace** busca auxiliar no acompanhamento dessas mudanças, permitindo registrar dados biomédicos e calcular índices de risco para cada missão.

---

## 🌍 ODS Relacionada

O projeto possui foco principal na:

### 🎯 ODS 3 — Saúde e Bem-Estar

O sistema contribui para estudos relacionados à preservação da saúde física e mental de astronautas, promovendo monitoramento preventivo, análise biomédica e acompanhamento pós-missão.

Além disso, o sistema permite vinculação com outras ODS disponíveis:

* ODS 1 — Erradicação da pobreza;
* ODS 2 — Fome zero e agricultura sustentável;
* ODS 3 — Saúde e bem-estar;
* ODS 4 — Educação de qualidade;
* ODS 9 — Indústria, inovação e infraestrutura;
* ODS 13 — Ação contra a mudança global do clima.

---

## 🎯 Objetivos do Projeto

* Gerenciar missões espaciais;
* Realizar análises físicas e psicológicas dos astronautas;
* Calcular índices de risco biomédico;
* Monitorar alterações biológicas pós-viagem;
* Relacionar missões aos Objetivos de Desenvolvimento Sustentável (ODS);
* Permitir busca, listagem e atualização de missões;
* Gerar relatórios analíticos comparativos entre Terra e espaço.

---

## ⚙️ Funcionalidades

### 1. Cadastro de Missões

Permite registrar:

* Nome da missão;
* Área de impacto;
* Objetivo da missão;
* ODS relacionada;
* Tecnologia utilizada;
* Prioridade da missão;
* Status operacional.

---

### 2. Análise Física 🧬

Monitoramento de:

* Qualidade do sono;
* Energia cognitiva;
* Massa muscular;
* Alterações pós-viagem em órbita.

---

### 3. Análise Psicológica 🧠

Monitoramento de:

* Estabilidade emocional;
* Índice de socialização;
* Foco comportamental;
* Alterações psicológicas pós-viagem.

---

### 4. Busca de Missões 🔎

Busca por:

* Nome da missão;
* Área de impacto;
* Número da ODS.

---

### 5. Atualização de Status 📈

Permite alterar o status entre:

* Planejada;
* Em andamento;
* Concluída;
* Cancelada.

Com atualização automática das informações biomédicas quando necessário.

---

### 6. Relatório Analítico Pós-Viagem 📊

Exibe:

* Média biomédica na Terra;
* Média biomédica em órbita;
* Variação percentual da saúde;
* Índice de risco calculado.

---

### 7. Resumo Final do Sistema 📌

Mostra:

* Total de missões cadastradas;
* Quantidade por status;
* Missão com maior prioridade.

---

## 🧠 Conceitos de Programação Aplicados

O projeto utiliza conceitos importantes da Programação Orientada a Objetos (POO):

### 🔹 Herança

A classe abstrata `Missao` é utilizada como base para:

* `AnaliseFisica`
* `AnalisePsicologica`

### 🔹 Polimorfismo

Uso do método:

```java
calcularRisco()
```

sobrescrito em cada tipo de análise.

### 🔹 Encapsulamento

Uso de:

* atributos privados;
* getters;
* setters.

### 🔹 Classe Abstrata

A classe:

```java
Missao
```

centraliza regras comuns do sistema.

### 🔹 Tratamento de Exceções

Validação de entrada utilizando:

```java
try/catch
```

para evitar falhas por entradas inválidas.

---

## 📂 Estrutura do Projeto

```txt
br.com.neurospace
│
├── model
│   ├── Missao.java
│   ├── AnaliseFisica.java
│   └── AnalisePsicologica.java
│
└── test
    └── Main.java
```

---

## 👨‍💻 Integrantes

| RM     | Nome                            |
| ------ | ------------------------------- |
| 563490 | Matheus Tozarelli Egea          |
| 565573 | Luara Martins de Oliveira Ramos |
| 563643 | Rafael Lorenzini Xavier         |
| 563082 | Felipe Ferrari Sumida           |

---

## ▶️ Como Executar

### Pré-requisitos

É necessário possuir:

* Java JDK 8 ou superior;
* Eclipse, IntelliJ IDEA ou VSCode com suporte para Java.

### Execução

1. Clone ou baixe o projeto;

2. Abra a pasta na IDE;

3. Execute o arquivo:

```txt
Main.java
```

4. Utilize o menu interativo via terminal.

---

## 📌 Menu Principal

```txt
1 - Cadastrar missão
2 - Listar missões
3 - Buscar missão
4 - Alterar status
5 - Exibir variação percentual pós-viagem
6 - Exibir resumo final
0 - Sair
```

---

## 🎥 Link do Vídeo / Caminho

Adicionar aqui o link do vídeo do projeto:

```txt
[Cole aqui o link do vídeo](https://www.youtube.com/watch?v=U26wUABxdiQ)
```

---

## 🛠️ Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)
* Herança
* Polimorfismo
* Encapsulamento
* Classes Abstratas
* Tratamento de Exceções
* Estruturas de Controle
* Coleções (`ArrayList`)

---

## 🚀 Conclusão

O **NeuroSpace** demonstra a aplicação prática de conceitos de **Programação Orientada a Objetos**, modelagem de sistemas e análise biomédica em um cenário de missões espaciais.

O sistema combina gerenciamento operacional, monitoramento de saúde e análise comparativa pós-missão, oferecendo uma solução organizada para acompanhamento físico e psicológico de astronautas em ambientes extremos.
