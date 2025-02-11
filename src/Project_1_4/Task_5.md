# Simulator phases pseudo code
This pseudo-code is extremely simplified and generalized.  
What these methods are and how they work can't be accurately shown here.

# A-phase pseudo code
```
clock.time = getNextEventTime();
startNextEvent();
```
# B-phase pseudo code
```
while (bEvents.get() > 0) {
  bEvents.process();
}
```
# C-phase pseudo-code
```
while (cEvents.get() > 0) {
  cEvents.process();
}
if (noCEventsProcessed()) {
  if (simComplete()) {
    break;
  }
  else {
    callAPhase();
  }
}
```