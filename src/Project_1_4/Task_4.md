# Pseudo-code
```
void () {
  Simulator.start();
}

start() {
  Simulator.clock.time = 0;
  while (true) {
    Simulator.clock.nextEvent();
    if (endOfSimulation()) {
      break;
    }
  }

  clock.nextEvent() {
    Event event = GetNextEvent();
    Clock.time += event.time;
    event.process();
  }

  bool endOfSimulation() {
    return EventQueue.isEmpty();
  }
}

```