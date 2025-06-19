
# JSONPlaceholder API Test Automation

Este projeto é uma automação de testes para APIs RESTful utilizando Java com Cucumber, JUnit e Allure Reports. Ele testa os endpoints do serviço JSONPlaceholder, simulando operações de criação, consulta, alteração e exclusão de registros.

## 🔧 Tecnologias utilizadas

- Java 11+
- Cucumber
- JUnit
- Gradle
- Allure Reports
- JSONPlaceholder (API fake pública)

## 📁 Estrutura do Projeto

```
src
├── test
│   ├── java
│   │   ├── listener                # Custom listener para eventos de execução
│   │   ├── model                   # Modelos de dados usados nos testes
│   │   ├── runners                 # Runners do Cucumber
│   │   ├── singleton               # Gerenciadores de estado
│   │   ├── stepsDefinitions        # Definições dos passos em Gherkin
│   │   ├── testAPI                 # Classe principal com os testes automatizados
│   │   └── utils                   # Utilitários auxiliares
│   └── resources
│       ├── Dados                   # Dados de entrada usados nos testes
│       ├── features                # Arquivos .feature em Gherkin
│       └── allure.properties       # Configuração do Allure
```

## 🚀 Como executar o projeto

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/agibanktest.git
cd agibanktest
```

2. Execute os testes com o Gradle:

```bash
./gradlew clean test
```

3. Para gerar o relatório Allure:

```bash
allure serve build/allure-results
```

## 🧪 Funcionalidades testadas

- Criação e alteração de registros
- Consulta de registros
- Exclusão de registros

Os testes estão descritos em arquivos `.feature` localizados na pasta `src/test/resources/features`.

## 📝 Observações

- Este projeto foi desenvolvido para fins de aprendizado e demonstração de automação de testes de API.
- A API utilizada (`https://jsonplaceholder.typicode.com`) é pública e gratuita para testes, portanto os dados não são persistidos.

## 👤 Autor

Antônio de Sousa – [LinkedIn](https://www.linkedin.com/in/antoniosousas/)
