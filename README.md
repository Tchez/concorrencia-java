# Sistema de Reserva de Assentos para Cinema em Java

## Sobre o Projeto

Este projeto é uma implementação de um sistema de reserva de assentos para cinema, desenvolvido como parte do meu estudo para a disciplina de Sistemas Paralelos e Distribuídos. O objetivo deste projeto é aplicar conceitos de concorrência, threads e sincronização em Java, utilizando o modificador `synchronized` para garantir a segurança das threads durante as reservas de assentos.

A motivação por trás deste projeto é aprofundar meu entendimento sobre programação concorrente e explorar desafios comuns enfrentados ao desenvolver sistemas que requerem sincronização e gestão de estado compartilhado entre múltiplas threads.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- **Reserva de Assentos:** Permite a reserva de assentos disponíveis numa sala de cinema.
- **Verificação de Disponibilidade:** Verifica se um determinado assento está disponível para reserva.
- **Cancelamento de Reservas:** Permite cancelar uma reserva, liberando o assento para ser reservado por outro usuário.

## Como Executar

Para executar este projeto, você precisará ter o Java instalado em sua máquina. Siga os passos abaixo:

1. Clone este repositório para sua máquina local usando `git clone https://github.com/Tchez/concorrencia-java.git`.
2. Navegue até a pasta do projeto.
3. Compile o código com `javac NomeDoArquivo.java`.
4. Execute o programa com `java NomeDaClassePrincipal`.

## Estrutura do Projeto

O projeto é estruturado da seguinte forma:

- `Cinema.java`: Representa o cinema e contém as salas de exibição.
- `Sala.java`: Representa uma sala de exibição dentro do cinema.
- `Assento.java`: Representa um assento na sala de exibição.
- `SistemaDeReserva.java`: Contém a lógica de negócios para a reserva de assentos.

## Desafios e Aprendizados

Durante o desenvolvimento deste projeto, enfrentei diversos desafios, especialmente relacionados à garantia de que o sistema seja thread-safe e à prevenção de condições de corrida. Utilizar o modificador `synchronized` para sincronizar o acesso a blocos de código críticos foi fundamental para resolver esses desafios. Este projeto me permitiu compreender melhor a importância da sincronização em sistemas que operam em ambientes concorrentes.

## Contribuições

Sugestões de melhorias e contribuições são sempre bem-vindas! Sinta-se à vontade para fazer um fork do projeto e enviar um pull request com suas sugestões.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE.md para detalhes.

## Contato

Marco Antônio Martins - [LinkedIn](https://www.linkedin.com/in/tchez/)
