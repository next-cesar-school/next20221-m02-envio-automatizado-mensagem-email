<p align="center"> 
<img src="https://tulioalbu.github.io/Yara_API-envio-de-emails-automatizados/Yara1.png" width="400" height="400"  />
</p>

# Yara - Message in a Bottle

-   Yara é uma aplicação que permite o envio de e-mails automatizados com mensagens pré-formatadas (ou não) a usuários cadastrados em um banco de dados;

-   Com o programa é possível criar, buscar, deletar e fazer update do cadastro de usuários, associando-os a endereços eletrônicos e um id;

-   Há também um repositório de mensagens que recebe temas e textos pré-definidos, onde também é possível gerenciar de forma constante, fazendo busca por assuntos e registro;

-   Utilizando uma ferramenta auxiliar (Postman), é possível confirmar o envio, retornando data e horário. O aplicativo roda em nuvem graças ao Heroku, plataforma de Deploy. Desta forma, é possível acessar as funções em qualquer máquina. 


# Criado por

- Anuar Samir Mamede
- Allan Arruda
- Fábio Clericuzi 
- Túlio Albuquerque 

Mentoria:
- Rui Arthur Nunes
- Samuel França

Trabalho de conclusão do curso NExT - Nova Experiência de Trabalho;
Sem fins comerciais;


## O que você vai precisar para rodar locamente a aplicação

* [OpenJDK 17.0.2+](https://jdk.java.net/archive/);
* [Maven 4.0+](https://maven.apache.org/download.cgi);
* Você pode copiar o código direto para sua IDE. Nós usamos o [VS Code](https://code.visualstudio.com/);
* Uma ferramenta para fazer REST requests. Recomendamos o [Postman](https://www.postman.com/downloads/);
* [Spring Boot 2.7.0+](https://spring.io/projects/spring-boot);
* [JBDC Connector](https://jdbc.postgresql.org/download.html)).

No entanto, não é necessário rodar o código na sua máquina. A aplicação funciona em nuvem através do Heroku e você pode acessar as instruções no link https://api-yara-sendingemail.herokuapp.com/; 

## CRUD de Usuários

Caso que queira rodar a aplicação localmente, primeiro você terá que ir em Aplication Properties e atualizar os dados de username e senha, considerando seu banco de dados local e o endereço que enviará as mensagens pré-formatadas; 

Depois de rodar a aplicação e com o banco de dados sincronizado na sua máquina, você precisará de uma ferramenta para fazer REST Requests. Todos os testes de funcionalidade do CRUD e do envio de e-mail deste projeto foram feitos usando o Postman.

O banco de dados recebe informações sobre usuários, com os parâmetros "nameUser" e "emailUser".

Utilize o seguinte formato: 

{

"nameUser": "MariaClara",

"emailUser": "mariaclara@email.com"

}

[http://localhost:8080/users](http://localhost:8080/users) - Para uso local <div>
[https://api-yara-sendingemail.herokuapp.com/users](https://api-yara-sendingemail.herokuapp.com/users) - Para uso em nuvem
Usando essa URL request no Postman, você pode utilizar os seguintes métodos:
POST, para cadastrar usuários (recomendamos não colocar espaços em branco); 
GET, para listar todos usuários cadastrados; 

[http://localhost:8080/users/id](http://localhost:8080/users/id) - Para uso local <div>
[https://api-yara-sendingemail.herokuapp.com/users/id](https://api-yara-sendingemail.herokuapp.com/users/id) - Para uso em nuvem
Colocando o número do ID do usuário no lugar do "id", você pode usar os seguintes métodos: 
GET, para buscar o usuário por ID;
DELETE, para apagar o usuário identificado pelo ID; 
PUT, para atualizar dados do usuário identificado pelo ID. 

exemplos: [http://localhost:8080/users/12](http://localhost:8080/users/12) - Para uso local <div>
          [https://api-yara-sendingemail.herokuapp.com/users/12] (https://api-yara-sendingemail.herokuapp.com/users/12) - Para uso em nuvem

## CRUD de Mensagens

Há também uma forma de adicionar mensagens pré-formatadas na tabela, com os parâmetros "messageSubject" e "messageText".

Utilize o seguinte formato: 

{

"messageSubject": "Natal",

"messageText": "Feliz Natal !!"

}

[http://localhost:8080/message](http://localhost:8080/message) - Para uso local <div>
[https://api-yara-sendingemail.herokuapp.com/message](https://api-yara-sendingemail.herokuapp.com/message) - Para uso em nuvem
Usando essa URL request no Postman, você pode utilizar os seguintes métodos:
POST, para cadastrar mensagens; 
GET, para listar todas mensagens cadastradas; 

[http://localhost:8080/message/id](http://localhost:8080/users/id) - Para uso local <div>
[https://api-yara-sendingemail.herokuapp.com/message](https://api-yara-sendingemail.herokuapp.com/message/id) - Para uso em nuvem
Colocando o número do ID do usuário depois do "id", você pode usar os seguintes métodos: 
GET, para buscar a mensagem por ID;
DELETE, para apagar a mensagem identificado pelo ID; 
PUT, para atualizar dados da mensagem identificado pelo ID. 


## Enviando e-mails
 
Para enviar e-mails utilizando a tabela de usuários, você deve seguir o seguintes modelos: 

[http://localhost:8080/sending-email/nameUser](http://localhost:8080/sending-email/nameUser) - Para uso local <div>
[https://api-yara-sendingemail.herokuapp.com/sending-email/nameUser](https://api-yara-sendingemail.herokuapp.com/sending-email/nameUser) - Para uso em nuvem
Para mandar o e-mail para um usuário cadastrado no banco de dados, troque "nameUser" pelo nome do usuário que você quer enviar. 

Exemplo: sending-email/AllanArruda

No corpo do email, você deve preencher os campos subject e text;

Utilize o seguinte formato: 

{

"subject": "Aniversário",

"text": "Parabéns João !!"

}


Para enviar e-mail usando mensagens pré-cadastradas para usuários cadastrados, utilize a seguinte URL: 
[http://localhost:8080/sending-email/nameUser/messageSubject](http://localhost:8080/sending-email/nameUser/messageSubject) - Para uso local <div>
[https://api-yara-sendingemail.herokuapp.com/sending-email/nameUser/messageSubject](https://api-yara-sendingemail.herokuapp.com/sending-email/nameUser/messageSubject) - Para uso em nuvem

No campo "nameUser" será passado o nome conforme foi cadastrado, sem espaço, e no "messageSubject" será passado o assunto da mensagem de e-mail também conforme cadastrado no banco de dados: 

exemplo: [http://localhost:8080/sending-email/TulioAlbu/Aniversario](http://localhost:8080/sending-email/TulioAlbu/Aniversario) - Para uso local <div>
         [https://api-yara-sendingemail.herokuapp.com/sending-email/TulioAlbu/Aniversario](https://api-yara-sendingemail.herokuapp.com/sending-email/TulioAlbu/Aniversario) - Para uso em nuvem

## Nossos contatos: 

Anuar Samir Mamede:  <div>
[Github](https://github.com/SamirMamede) <div>
[Linkedin](https://www.linkedin.com/in/anuar-samir-farias-mamede-2ba299224/)

Allan Arruda:  <div>
[Github](https://github.com/allann15) <div>
[Linkedin](https://www.linkedin.com/in/allan-jorge-arruda-85166018a/)

Fábio Clericuzi:  <div>
[Github](https://github.com/Fabioclericuzi)  <div>
[Linkedin](www.linkedin.com/in/fabioclericuzi)

Túlio Albuquerque:  <div>
[Github](https://github.com/tulioalbu) <div>
[Linkedin](https://www.linkedin.com/in/tulioalbu/)




