# Resistence Star Wars 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/roalbuquerque/swResistence-letsCode/blob/master/LICENSE) 

# Sobre o projeto

O "Resistence-letsCode" é uma API REST construída durante um evento organizado pela [Let's Code](https://letscode.com.br/ "Site da Let's Code").

A aplicação consiste em uma apresentação de informações referente Soldados, categorias, inventário e itens de inventário, de personagens do mundo Star Wars que são coletados pelo backend feito em Spring boot com banco de dados H2. 

## Modelo conceitual
#### O modelo conceitual abaixo foi criado na ferramenta online https://moqups.com/
![Modelo Conceitual](https://github.com/roalbuquerque/swResistence-letsCode/blob/master/modelo.png)

## Padrão de camadas
![Padrão de Camadas](https://github.com/roalbuquerque/swResistence-letsCode/blob/master/padraoCamadas.png)

## Teste de requisição
#### Importar o arquivo: "letsCode.postman_collection.json" na API client 'Postman' para testar as requisições.
Existem requisições para consultar todos os itens ou por id, para Categorias, Soldados, Inventário e Itens.

### [NEGOCIAÇÃO]
Abaixo a imagem apresenta a requição do serviço de negociação, onde que os soldados (2) participantes da negociação (troca de itens do inventário) poderão realizar a troca de itens se ambos não forem traidores e se o total de pontos dos itens do inventário, forem iguais.  

Pontuação de itens:
  - ITEM      -  PONTOS
- 1 Arma     - 4 pontos
- 1 Munição  - 3 pontos
- 1 Água     - 2 pontos
- 1 Comida   - 1 ponto

![Teste de requisitção](https://github.com/roalbuquerque/swResistence-letsCode/blob/master/TestEndpoints1.png)

- Para testar se a troca de itens funcionou, executar a query abaixo no banco h2 verificando os dois soldados (http://localhost:8080/h2-console):
```bash
SELECT *
FROM Tb_inventory a
INNER JOIN Tb_item b
ON a.soldier_id = b.inventory_id
where a.soldier_id = 1
and inventory_status = 'ATIVO'
```

### [ACUSAÇÃO]
- Caso um soldado desconfie que outro soldado esta com atitudes suspeitas de traição da resistência, ele pode acusá-lo.
- A imagem abaixo representa o endpoint de acusação, onde é passado o id do soldado que vai fazer a acusação e o id do soldado que será acusado. 
- Caso o soldado acusado tenha recebido 3 acusações de outros soldados, o mesmo será categorizado como traidor.

![Teste realizacao de acusação](https://github.com/roalbuquerque/swResistence-letsCode/blob/master/TestEndpoints4.png)

- Para testar se a acusação de soldado traidor funcionou, executar a query abaixo no banco h2 (http://localhost:8080/h2-console):

```bash
SELECT *
FROM Tb_soldier a
INNER JOIN Tb_accusation b
ON a.id = b.soldier_id
where a.id = 3
```
### [ATUALIZAÇÃO DE LOCALIZAÇÃO]

- Através do serviço abaixo é possível atualizar a localização (Latitude e longitude) do soldado, mantendo sempre a localização anterior:

![Teste atualização de localização](https://github.com/roalbuquerque/swResistence-letsCode/blob/master/updateLocation.png)

### [DEMAIS RELATÓRIOS]

Outros relatórios existentes: 
1. Porcentagem de traidores.
2. Porcentagem de rebeldes.
3. Quantidade média de cada tipo de recurso por rebelde (Ex: 2 armas por rebelde).
4. Pontos perdidos devido a traidores.


# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Spring Data JPA
- Maven
## Ferramentas de Apoio
- Postman
## Banco de dados: 
- H2
## Testes
- Testes de integração
# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/roalbuquerque/swResistence-letsCode.git

# entrar na pasta do projeto back end
cd backend

# Abrir o projeto no "Spring Tool Suite 4" ou similar

# executar o projeto
Botão direito sobre a classe "SwResistenceApplication.java" e >Run As>Spring Boot App

# o que acontece depois de executar o projeto backend
O banco será criado conforme scripts em import.sql

```

# Autor

Rafael de Oliveira Albuquerque

📫 Você pode me encontrar aqui:
<p align="left">
  <a href="https://www.linkedin.com/in/rafaeloliveiraalbuquerque/" alt="Linkedin">
  <img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/rafaeloliveiraalbuquerque/" /></a>

