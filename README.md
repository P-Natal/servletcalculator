Projeto para a aula de Desenvolvimento de Aplicações corporativas (UFF-SI).
Calculadora java servlet.

Como usar:
O projeto foi feito usando Maven, logo o build é realizado pelo mesmo. Fazemos isso com: "mvn clean install".
O build gera um arquivo .war na pasta target, mas não precisamos tocar nele. 
Eu optei por executar a aplicação via docker, então para subir o projeto, usamos o docker-compose.yml presente 
na raiz do projeto. Fazemos isso com o comando "docker-compose up".

Com o start do docker, podemos acessar a página inicial da aplicação em "localhost:8080".

A Calculadora:
Na página inicial podemos entrar com os valores para calcular e selecionar as operações. Clicando em "Calculate" 
somos redirecionados para a página "Result" que não só mostra os resultados do cálculo, como apresenta duas novas 
opções: "Go Back" para retornar à página inicial e "Check number of hits" que nos redireciona para a página de "Hits", 
que mostra a quantidade de vezes que a calculadora foi utilizada (Cookie). 

Cookies:
Na proposta do trabalho, foi solicitado que junto do resultado já fosse apresentado o número de vezes que a 
página foi acessada. Fiz uma pequena alteração nesse escopo, nessa aplicação vc pode escolher visualizar essa 
informação em outra página. Além disso, ela conta a quantidade de vezes que a calculadora foi utilizada, e não
A quantidade de acessos às páginas. 
