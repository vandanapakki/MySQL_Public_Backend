<b>Running the service - </b>

1. Start docker by running command " docker-compose up " to start mysql db instance on local

Note - If the port is already in use, make sure to remove older docker images 
(docker stop $(docker ps -aq)
docker rm $(docker ps -aq))

2. Run the application which connects to local db instance
