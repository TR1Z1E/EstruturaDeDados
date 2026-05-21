# 💊 Sistema de Armazenamento de Medicamentos

## 📌 Descrição
Este projeto consiste em um sistema desenvolvido em Java para organização de medicamentos em estruturas de dados do tipo pilha. O sistema permite registrar medicamentos com nome e data de validade, organizando-os em uma estrutura de armazenamento composta por múltiplas pilhas (simulando caixas).

O usuário pode interagir com o sistema por meio de um menu, realizando operações como adicionar, remover e visualizar medicamentos.

---

## 🎯 Contexto do Projeto

Este sistema foi desenvolvido com base na seguinte problemática:

> “Como a modelagem de um sistema computacional pode auxiliar na coleta e organização de dados sobre o descarte de medicamentos, apoiando a tomada de decisão em saúde pública?”

O descarte incorreto de medicamentos é um problema relevante, podendo causar impactos ambientais e riscos à saúde pública. A organização adequada dessas informações pode contribuir para melhor compreensão e análise desse fenômeno.

---

## 🎯 Objetivos

### ✔️ Objetivo Geral
Desenvolver um sistema computacional simples para coleta e organização de dados sobre medicamentos.

### ✔️ Objetivos Específicos
- Criar um módulo de entrada de dados
- Estruturar o armazenamento utilizando estruturas de dados
- Permitir visualização das informações armazenadas
- Simular organização de dados para futura análise

---

## ⚙️ Funcionalidades

O sistema permite:

- ➕ Adicionar medicamentos (nome e validade)
- ➖ Remover medicamentos (seguindo o conceito de pilha - LIFO)
- 👁️ Visualizar medicamentos armazenados
- 📦 Organização em múltiplas pilhas (estrutura 3x3)

---

## 🧠 Estrutura do Sistema

O sistema é composto por:

### 🔹 Classe `Medicamento`
Responsável por armazenar:
- Nome do medicamento
- Data de validade

### 🔹 Classe `Pilha`
Implementa uma estrutura de pilha:
- Inserção (push)
- Remoção (pop)
- Exibição dos elementos

### 🔹 Classe `Armazenamento`
Responsável pela execução do sistema:
- Criação da matriz de pilhas (3x3)
- Interface com o usuário (menu interativo)

---

## 🏗️ Metodologia

O desenvolvimento foi dividido em etapas:

1. Modelagem da estrutura do sistema
2. Implementação da estrutura de dados (pilha)
3. Criação do menu interativo
4. Testes de funcionamento

---

## 📊 Resultados Esperados

O sistema permite:
- Organização estruturada de medicamentos
- Simulação de armazenamento eficiente
- Base para estudos futuros sobre descarte e análise de dados

---

## ⚠️ Limitações

- Não utiliza banco de dados real
- Não possui interface gráfica
- Não realiza análises avançadas ou uso de inteligência artificial
- Funciona apenas em ambiente local (console)

---

## 🚀 Possíveis Melhorias

- Integração com banco de dados
- Interface gráfica (GUI)
- Geração de relatórios e gráficos
- Expansão para análise de dados reais

---

## 👩‍💻 Autores
- Beatriz Rodrigues de Souza RA: 824227270
- Angelo de Sousa Junior RA: 823154734

---

## 📚 Tecnologias Utilizadas
- Java
- Estruturas de Dados (Pilha)
