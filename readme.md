# JStack
## Java application
The java application requires exact one input argument. 
It supposed to be one of the following options:
* `deadlock` - in this case application goes into deadlock.
* `normal` - in this case application slowly but surely finished the job.

Use following command in order to compile the source core:
`mvn clean compile` 

## Test
`test.sh` - there are two tests in the script file.
The first one tests 'normal' mode, the second one tests the 'deadlock' mode.

Note: tested on following configuration
```
openjdk 21.0.1 2023-10-17
OpenJDK Runtime Environment (build 21.0.1+12-Ubuntu-222.04)
OpenJDK 64-Bit Server VM (build 21.0.1+12-Ubuntu-222.04, mixed mode, sharing)
```