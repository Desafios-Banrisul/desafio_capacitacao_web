# Desafio DB WEB

Este projeto foi desevolvido para capacitacção de testes automatizdos do time DB - Banrisul, e tem como objetivo realizar uma jornada de usuário completa no site [Automação Batista](https://seubarriga.wcaquino.me/logout). 

1. Acessaro site
2. Acessar a plataforma
3. Criar contas de Receitas e Despesas
4. Inserir movimentações
5. Validar as movimentações inseridas
6. Validar saldo conforme as movimentações criadas

## Tecnologias Utilizadas

Este projeto conta com as seguintes tecnologias:  

- [Java](https://www.java.com/pt-BR/)
- [Git](https://git-scm.com)
- [Maven](https://maven.apache.org/download.cgi)
- [JUnit 5](https://junit.org/junit5/)

## Padrões Utilizados

**Main/Java**

- **Browser** : Classes de abstracao.

- **Report** :  Classes de configuração do relatório de execução dos testes.

- **Utils** :  Métodos auxiliares.


**Test/Java**

- **Enun** : Listas com elementos fixos. 

- **PageObjects** : Classes de mapeamento dos WebElements.

- **Tasks** : Classes de iteração com os WebElements.

- **TestCases** : Classes e métodos de Testes.

- **TestSuites** : Coleção de casos de testes.

- **Validations** : Classes de validação do jornada do usuário.

## Execução do projeto

* Faça clone do projeto na sua máquina, para isso utilize o comando abaixo

```
git clone https://github.com/Desafios-Banrisul/desafio_capacitacao_web.git
```
Em seguida, abra o projeto desafio_capacitacao_web na IDEA de sua preferência
- Navegue até a pasta src/test/java/TestsSuites
- Executar um Run 

## Relatórios de Teste

Para visualizar os reports, após a execução, abra a pasta raiz do projeto e acesse a pasta "Report" e abra o aquivo html no seu navegador de preferência.


