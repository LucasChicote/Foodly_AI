# Foodly AI - Assistente de Restaurantes

Chatbot desenvolvido com Spring Boot + Spring AI + Vaadin, integrado à API da OpenAI. O assistente responde perguntas sobre restaurantes, gastronomia e a plataforma Foodly.

## Tecnologias

- Java 25
- Spring Boot 4.0.5
- Spring AI 2.0.0-M4
- Vaadin 25.1.0
- OpenAI GPT-4o-mini

## Como rodar

**1. Pré-requisitos**

- Java 25 instalado
- Conta na OpenAI com créditos disponíveis
- IntelliJ IDEA

**2. Configurar a chave da OpenAI**

Abra o arquivo `src/main/resources/application.properties` e substitua pelo valor da sua chave:

```
spring.ai.openai.api-key=sua chave aqui
```

**3. Rodar o projeto**

No IntelliJ, abra o arquivo `ChatProfApplication.java` e clique na seta verde ao lado do método `main`. Selecione **Run 'ChatProfApplication'**.

**4. Acessar o chat**

Após a aplicação iniciar, acesse no navegador:

```
http://localhost:8080/home
```

## Exemplos de perguntas

- Quais são os pratos mais populares da culinária italiana?
- Me recomende um prato para quem não gosta de peixe.
- Quais opções vegetarianas existem nos restaurantes?
- Como funciona a plataforma Foodly?
- Como faço um pedido no Foodly?
- Qual a diferença entre massas frescas e secas?
- Quais pratos são bons para quem tem restrição ao glúten?
- Me indique um restaurante bom para jantar a dois.
- Quais são as culinárias mais pedidas no Foodly?
- O que devo observar no cardápio de um restaurante?

## Grupo
- Lucas Chicote - RM: 559366
- Lucas Gomes - RM: 559607
- Henrique - RM: 560698
