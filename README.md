# 🚀 NeuroSpace — Sistema de Análise Biomédica para Missões Espaciais

Sistema desenvolvido em **Java** para gerenciamento e monitoramento biomédico de astronautas em missões espaciais, com foco na **saúde física e psicológica antes, durante e após viagens espaciais**.

---

## 👨‍💻 Integrantes

| RM         | Nome                            |
| ---------- | ------------------------------- |
| **563490** | Matheus Tozarelli Egea          |
| **565573** | Luara Martins de Oliveira Ramos |
| **563643** | Rafael Lorenzini Xavier         |
| **563082** | Felipe Ferrari Sumida           |

---

## 🎥 Vídeo do Projeto

📺 Assista à demonstração do sistema:

**Vídeo:** https://www.youtube.com/watch?v=U26wUABxdiQ

---

## 📋 Descrição do Projeto

O **NeuroSpace** é um sistema desenvolvido para gerenciamento e monitoramento de missões espaciais com foco na análise biomédica de astronautas.

O sistema permite:

✅ Cadastrar missões espaciais
✅ Monitorar indicadores físicos e psicológicos
✅ Comparar dados biomédicos entre Terra e órbita
✅ Calcular índices de risco biomédico
✅ Relacionar missões aos Objetivos de Desenvolvimento Sustentável (ODS)

Além disso, o projeto conecta inovação tecnológica e saúde espacial, promovendo aplicações ligadas à ciência, bem-estar e desenvolvimento sustentável.

---

## 🚨 Problema Escolhido

Missões espaciais de longa duração podem gerar impactos severos na saúde dos astronautas devido à:

* Microgravidade;
* Isolamento prolongado;
* Permanência em ambientes extremos;
* Alterações biológicas decorrentes da viagem espacial.

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

O **NeuroSpace** auxilia no acompanhamento dessas mudanças por meio de registros biomédicos e cálculo de índices de risco.

---

## 🌍 ODS Relacionadas

### 🎯 ODS Principal

**ODS 3 — Saúde e Bem-Estar**

O sistema contribui para estudos voltados à preservação da saúde física e mental dos astronautas, promovendo monitoramento preventivo, análise biomédica e acompanhamento pós-missão.

### 🔗 ODS vinculadas ao projeto

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
* Relacionar missões às ODS;
* Permitir busca, listagem e atualização de missões;
* Gerar relatórios analíticos comparativos entre Terra e espaço.

---

## ⚙️ Funcionalidades

### 1️⃣ Cadastro de Missões

Permite registrar:

* Nome da missão;
* Área de impacto;
* Objetivo da missão;
* ODS relacionada;
* Tecnologia utilizada;
* Prioridade da missão;
* Status operacional.

### 2️⃣ Análise Física 🧬

Monitoramento de:

* Qualidade do sono;
* Energia cognitiva;
* Massa muscular;
* Alterações pós-viagem em órbita.

### 3️⃣ Análise Psicológica 🧠

Monitoramento de:

* Estabilidade emocional;
* Índice de socialização;
* Foco comportamental;
* Alterações psicológicas pós-viagem.

### 4️⃣ Busca de Missões 🔎

Busca por:

* Nome da missão;
* Área de impacto;
* Número da ODS.

### 5️⃣ Atualização de Status 📈

Permite alterar o status entre:

* Planejada;
* Em andamento;
* Concluída;
* Cancelada.

Com atualização automática das informações biomédicas quando necessário.

### 6️⃣ Relatório Analítico Pós-Viagem 📊

Exibe:

* Média biomédica na Terra;
* Média biomédica em órbita;
* Variação percentual da saúde;
* Índice de risco calculado.

### 7️⃣ Resumo Final do Sistema 📌

Mostra:

* Total de missões cadastradas;
* Quantidade por status;
* Missão com maior prioridade.

---

## 🧠 Conceitos de Programação Aplicados

### 🔹 Herança

A classe abstrata **Missao** é utilizada como base para:

* `AnaliseFisica`
* `AnalisePsicologica`

### 🔹 Polimorfismo

Uso do método:

```java
calcularRisco()
```

Sobrescrito em cada tipo de análise.

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

Centraliza regras comuns do sistema.

### 🔹 Tratamento de Exceções

Validação de entrada utilizando:

```java
try/catch
```

Para evitar falhas por entradas inválidas.

---

## 📂 Estrutura do Projeto

```txt
br.com.neurospace.cadastro
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

## ▶️ Como Executar

### Pré-requisitos

É necessário possuir:

* Java JDK 8 ou superior;
* Eclipse, IntelliJ IDEA ou VSCode com suporte para Java.

### Execução

1. Clone ou baixe o projeto;
2. Abra a pasta na IDE;
3. Execute:

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

## 🛠️ Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)
* Herança
* Polimorfismo
* Encapsulamento
* Classes Abstratas
* Tratamento de Exceções
* Estruturas de Controle
* ArrayList

---

## 🚀 Conclusão

O **NeuroSpace** demonstra a aplicação prática de conceitos de **Programação Orientada a Objetos (POO)**, modelagem de sistemas e análise biomédica aplicada ao contexto espacial.

O sistema combina gerenciamento operacional, monitoramento de saúde e análise comparativa pós-missão, oferecendo uma solução organizada para acompanhamento físico e psicológico de astronautas em ambientes extremos.
