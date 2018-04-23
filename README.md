# Api-Saraiva
Api-Saraiva: Spring Boot

Para executar o programa será necessario ter instalado:
java8 
mongodb
maven

API:

GET: Inserir um livro da base saraiva, para base local
localhost:8080/api/book/external/sku/9731889

GET:Listar todos o livros da base:
localhost:8080/api/book

DELETE: Deletar um sku da base 
localhost:8080/api/book/9731885

GET: listar todos os livros, filtrando por preco e limit
localhost:8080/api/book?price=19.90&limit=1


