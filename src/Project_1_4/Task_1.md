# Bank Example
### Directly observable variables are:

A, arrived clients count (arrival count)
This is the number of customers that have arrived to the bank and require service. 

C, clients serviced count (completed count)
This is the number of customers that have been serviced and have left the bank.  

B, active time in service point (busy time)
How much time the customer spends at a given service point (like a teller).  

T, total simulation time (time)  
How long the simulation has been running.

### Derived variables (from the previous variables) are:

U, service point utilization related to the max capacity, U = B/T
This variable can show if the bank is under/over staffed or otherwise not operating at full capacity.  

X, service throughput, number of clients serviced related to the time, X = C/T
This variable can show obvious bottlenecks in the service system. It can be used to diagnose an issue with how customers are serviced.  

S, service time, average service time in the service point, S = B/C
This variable can show if there are issues with particular customers that are holding up the service point.  

### Additional directly observable variables are:

R𝑖, response time, the time from the customer's arrival at the service queue to the end of the service (𝑖 indicates that this is the lead time experienced by a given customer)  
This can further show issues with customer service and infrastructure. It can identify customers that are causing large holdups.  

W, waiting time, cumulative response times sum of all clients
From these last two, we can further derive the following quantities:

R, response time, average throughput time at the service point, R = W/C
N, average queue length at the service point (including the served) N = W/T