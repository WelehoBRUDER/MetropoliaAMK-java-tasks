## Call Centre Simulation: Clock 0 (Initialize simulation)
| Event | Time |
|:-----:|:----:|
| B1    | 5    |
| B2    | 10   |
## Call Centre Simulation: Clock 5 (Event B1)

| Event | Time |
|:-----:|:----:|
| B3    | 6    |
| B2    | 10   |
| B1    | 10   |

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| A     | Empty        | Idle   | Empty        | Idle   | Empty        | Idle   |
| B     | X1           | Idle   | Empty        | Idle   | Empty        | Idle   |
| C     | Empty        | X1     | Empty        | Idle   | Empty        | Idle   |

## Call Centre Simulation: Clock 6 (Event B3)

| Event | Time |
|:-----:|:----:|
| B2    | 10   |
| B1    | 10   |
| B4    | 10   |

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|:-----:|:------------:|:------:|:------------:|:------:|:------------:|:------:|
| B     | Empty        | Idle   | X1           | Idle   | Empty        | Idle   |
| C     | Empty        | Idle   | Empty        | X1     | Empty        | Idle   |

## Call Centre Simulation: Clock 10 (Events B2,B1,B4)

| Event | Time |
|:-----:|:----:|
| B3    | 11   |
| B1    | 15   |
| B2    | 20   |

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|:-----:|:------------:|:------:|:------------:|:------:|:------------:|:------:|
| B     | X2,Y1        | Idle   | Empty        | Idle   | Empty        | Idle   |
| C     | X2           | Y1     | Empty        | Idle   | Empty        | Idle   |

## Call Centre Simulation: Clock 11 (Event B3)

| Event | Time |
|:-----:|:----:|
| B3    | 12   |
| B1    | 15   |
| B5    | 18   |
| B2    | 20   |

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|:-----:|:------------:|:------:|:------------:|:------:|:------------:|:------:|
| B     | X2           | Idle   | Empty        | Idle   | Y1           | Idle   |
| C     | Empty        | X2     | Empty        | Idle   | Empty        | Y1     |

## Call Centre Simulation: Clock 12 (Event B3)

| Event | Time |
|:-----:|:----:|
| B1    | 15   |
| B4    | 16   |
| B5    | 18   |
| B2    | 20   |

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|:-----:|:------------:|:------:|:------------:|:------:|:------------:|:------:|
| B     | Empty        | Idle   | X2           | Idle   | Empty        | Y1     |
| C     | Empty        | Idle   | Empty        | X2     | Empty        | Y1     |

## Call Centre Simulation: Clock 15 (Event B1)

| Work complete |   |
|:-------------:|:-:|
| X             | 1 |
| Y             | 0 |

| Event | Time |
|:-----:|:----:|
| B4    | 16   |
| B3    | 16   |
| B5    | 18   |
| B1    | 20   |
| B2    | 20   |

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|:-----:|:------------:|:------:|:------------:|:------:|:------------:|:------:|
| B     | X3           | Idle   | Empty        | X2     | Empty        | Y1     |
| C     | Empty        | X3     | Empty        | X2     | Empty        | Y1     |

## Call Centre Simulation: Clock 16 (Events B3, B4)

| Event | Time |
|:-----:|:----:|
| B5    | 18   |
| B1    | 20   |
| B2    | 20   |
