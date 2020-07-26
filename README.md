# guest-reservation


## Consume external property file from config server
Instead of using local application.properties file, consuming external property file stroed in a remote config server.


> Config POM file
>>  adding dependency spring-cloud-config-client
>>> adding dependency management section about  spring-cloud-dependencies 
>>>> adding repository section, pointing to spring-milestones

> add bootstrap.properties at the resource folder. 
>> desinating the external property file name
>>> designating the uri pointing to config server.
