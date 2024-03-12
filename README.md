# Sistema de Reserva de Assentos para Cinema em Java

## Sobre o Projeto

Este projeto implementa um sistema de reserva de assentos para cinema em Java, desenvolvido como um desafio prático para a disciplina de Sistemas Paralelos e Distribuídos. O objetivo é explorar e aplicar conceitos de programação concorrente, como threads, sincronização e locks explícitos, para gerenciar o acesso concorrente a recursos compartilhados (neste caso, os assentos do cinema) de forma segura e eficaz.

A motivação por trás deste desafio é aprofundar o entendimento sobre como desenvolver sistemas que requerem sincronização fina e gerenciamento de estado compartilhado em um ambiente multithread, enfrentando e superando os desafios comuns associados à concorrência.

## Desafio

O principal desafio é garantir que, em um ambiente com múltiplas threads tentando reservar assentos simultaneamente, nenhuma condição de corrida ocorra, e cada assento possa ser reservado por apenas um "usuário" por vez. Além disso, o sistema deve permitir o cancelamento de reservas, mantendo a integridade e consistência do estado dos assentos através de todas as operações concorrentes.

## Estratégia de Solução

Para enfrentar esse desafio, o projeto envolve algumas estratégias chave:

- **Uso de Locks Explícitos (`ReentrantLock`):** Para garantir a exclusividade do acesso aos assentos durante as operações de reserva e cancelamento, evitando sobreposições nas modificações do estado dos assentos.

- **Simulação de Concorrência com Variação de Comportamento:** Cada thread simula um usuário tentando fazer uma reserva, introduzindo um atraso aleatório no início de suas operações para emular o comportamento variado de usuários em um sistema real.

- **Cancelamento Condicionado pela Reserva:** Uma thread que consegue reservar um assento espera um breve intervalo antes de cancelar sua reserva, simulando um cenário onde reservas são reconsideradas ou ajustadas.

### Componentes Principais

- `Main.java`: Configura e inicia a simulação, criando threads que representam usuários tentando reservar o mesmo assento em intervalos aleatórios.

- `MovieTheater.java`: Representa o cinema e contém uma lista de salas de exibição.

- `Room.java`: Modela uma sala de cinema, gerenciando um conjunto de assentos e fornecendo métodos sincronizados para operações de reserva e cancelamento.

- `Seat.java`: Representa um assento individual na sala de cinema, incluindo informações sobre seu estado de reserva.

- `ReservationSystem.java`: Fornece uma interface para as ações de reserva e cancelamento, interagindo com as salas e assentos para atualizar seus estados.

- `ReservationTask.java`: Executa a lógica para tentar reservar um assento específico, introduzindo variação nos tempos de ação através de atrasos aleatórios e executando cancelamento após a reserva bem-sucedida.

## Desafios e Aprendizados

A implementação deste sistema revelou a complexidade do gerenciamento de estados compartilhados em ambientes concorrentes, destacando a importância de estratégias de sincronização eficazes e o uso cuidadoso de locks para prevenir condições de corrida e garantir a segurança das threads.

## Como Executar

1. Clone o repositório para sua máquina local.
2. Compile o código usando `javac src/*.java` dentro do diretório do projeto.
3. Execute o programa com `java src.Main`.

## Contribuições

Feedback e contribuições são bem-vindos para aprimorar a eficácia e a eficiência do sistema de reserva de assentos :)

## Contato

Marco Antônio Martins - [LinkedIn](https://www.linkedin.com/in/tchez/)
