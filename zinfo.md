### se trata de un proyecto modular  es decir:
### que es un proyecto padre que tendrá dentro los microservicios o microproyectos

# Llamada para grabar todas las dependencias en el archivo txt
## mvn dependency:tree > C:\CLASES2023\2DAW_2324\DWES\Trim2\Microservices\SpringMicroservices\dependency-tree.txt

# COMANDOS PARA VERIFICAR DATOS DE LA APLICACION.

hostname
mvn dependency:purge-local-repository   
mvn clean install  
java --version
mvn dependency:tree
mvn test
echo $env:JAVA_HOME
where javac
Get-Command javac | Select-Object Source  
mvn -rf :microservice-eureka  
mvn <args> -rf :microservice-gateway    
Get-Service postgresql*   
Stop-Service postgresql*
Get-Service postgresql
Get-Service postgresql | Where-Object {$_.Status -eq "Running"}      
psql (PostgreSQL) 15.4 (server)      
psql -- version
systemctl status postgresql  