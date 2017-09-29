# rabbitmq-example

This project shows a simple Rabbit MQ project. One commit does the sending and receiving synchronizedly. The second commit, show the
receiver working asynchronizedly, by passing the picked up message, and passing it to a `CompletableFuture`
