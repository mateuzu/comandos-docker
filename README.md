# Comandos Docker
Repositório com exemplo básico de uma comunicação entre um serviço de cadastro de usuário e um bancos de dados containerizados. 

## Funcionalidades 🛠️
O foco desse repositório é listar os principais comandos Docker para criação de imagens customizadas e containers. Por conta disso, as funcionalidades são simples e se resumem às operações de CRUD com a entidade User.

- Cadastro de usuário
- Buscar um usuário pelo ID
- Buscar todos usuários
- Deletar um usuário pelo ID

## Comandos 💡
Alguns comandos utilizados para criar e manipular containers
### Comandos de manipulação de containers
- `docker ps -a`: Lista todos os containers e seus status
    - `docker ps`: Lista todos os containers que estão em execução
- `docker run image:latest`: Executa um container
	- `docker run -d image:latest`: Executa um container mas sem ocupar o console
    - `-p`: Especifica e expõe a porta de execução
    - `-e`: Especifica uma variável de ambiente
    - `--name`: Especifica o nome do container
    - `--network`: Especifica uma rede onde o container irá executar
- `docker logs nome_container`: Exibe todo o log do container
- `docker stop nome_container`: Interrompe a execução do container
- `docker rm nome_container`: Exclui o container
- `docker exec -it nome_container command`: Executa comandos dentro do container
	- `docker exec -it nome_container /bin/bash`: Nesse exemplo, abre um terminal bash dentro do container
- `docker inspect nome_container`: Exibe informações do container (id, status, network e etc)

### Comandos de manipulação de imagens
- `docker images`: Lista todas as imagens
- `docker search image`: Faz uma busca no Docker Hub e exibe todas imagens encontradas
    - `docker search mysql`: Por exemplo, busca no Docker Hub imagens relacionadas ao MySQL
- `docker pull image`: Baixa a imagem localmente
- `docker rmi nome_image`: Deleta a imagem e todos seus arquivos atrelados

### Comandos de imagens customizáveis
- `docker build .`: Compilar imagens customizadas (Dockerfile) para executar containers

<br>

## Dockerfile 📝
O arquivo Dockerfile instrui o Docker sobre como construir uma imagem customizada para criação de um container.

```dockerfile
FROM openjdk:17
VOLUME /tmp
ADD ./target/test-docker-0.0.1-SNAPSHOT.jar test-docker.jar
ENTRYPOINT [ "java", "-jar", "/test-docker.jar" ]
```
- *FROM*: Imagem base que será utilizada para criação do container do projeto.
- *VOLUME*: Cria uma pasta para armazenar informações.
- *ADD*: Adiciona o arquivo *.jar* do projeto na imagem. Esse arquivo é necessário para executar o sistema. 
- *ENTRYPOINT*: Especifica os comandos que serão executados quando o container iniciar.

<br>

## Arquivo JAR ⚙️
Para gerar o arquivo JAR de um projeto Spring utilizando Maven como gerenciador de dependências:
- Abrir o CMD na pasta raiz do projeto
- Utilizar o comando:
    - `./mvnw clean package`: Gera a build do projeto
    - `./mvnw clean package -DskipTests`: Gera a build do projeto, porém não executa os testes da aplicação

Por padrão, o Maven armazena o arquivo JAR com o projeto compilado e empacotado na pasta *target*

<br>

## Tecnologias 💻
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40" style="max-width: 100%;"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="spring" width="40" height="40" style="max-width: 100%;"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" alt="spring" width="40" height="40" style="max-width: 100%;"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" alt="spring" width="40" height="40" style="max-width: 100%;">

- Java
- Spring Boot
- PostgreSQL
- Docker