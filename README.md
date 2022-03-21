# Teste Fullstack - Varredura

Teste Fullstack

## Configurando

### Configurando o Docker

Crie uma Network no Docker para os containers com o comando:

`docker network create pr-varredura`

As imagens presentes no *docker-compose* fazem parte da mesma Network.

Crie o Volume para o container do PostgreSQL presente no *docker-compose* (cuidado caso você já tenha um Volume com esse nome criado):

`docker volume create pgdata`

### Configurando o Projeto

Edite o arquivo *application.yml* no projeto **pr-search** e coloque a sua chave da API do serviço da INTELX no campo "key.intx".

Para rodar o projeto, baixe as dependências do Maven de todos os projetos dentro da pasta *backend* e rode o comando no terminal dentro do diretório de **CADA PROJETO PRESENTE NA PASTA**:

`./mvnw clean package -DskipTests`

Caso você esteja utilizando Linux, talvez seja necessário garantir a permissão do arquivo *mvnw* encontrado nas pastas de todos os projetos. Caso precise, rode o comando no terminal:

`sudo chmod +x mvnw`

## Buildando o projeto

Com as configurações necessárias do Docker, a chave da API da INTELX e com as dependências do Maven baixadas em **cada projeto** presente na pasta *backend*, vamos fazer o Build do Docker.

Na pasta **raiz** (onde o *docker-compose* está), rode o seguinte comando no terminal:

`sudo docker-compose build`

Isso irá montar cada Imagem *Dockerfile* presente na raiz de **cada projeto** presente na pasta *backend*.

Após o Build, rode todo o projeto com:

`sudo docker-compose up`

Espere aproximadamente *1 minuto* para os Servidores estabilizarem.

**Obs:** Após iniciar o projeto pela primeira vez, entre no arquivo *application-dev.yml* do projeto pr-base e altere a propriedade "jpa.hibernate.ddl-auto" para: ***none***.

Caso as tabelas do Banco de Dados não foram criadas automaticamente ao iniciar o projeto, rode o script *create.sql*.

## Configuração alternativa ao Docker

Caso opte por não utilizar Docker, entre nos projetos que são **clientes** do servidor *Eureka* e altere o campo "eureka.client.serviceUrl.defaultZone" para (os projetos **clientes** Eureka são: pr-base, pr-search e pr-gateway):

`http://localhost:8761/eureka`

## Informações sobre o Backend 

Mais informações sobre o Backend está presente no README da pasta *backend*.
