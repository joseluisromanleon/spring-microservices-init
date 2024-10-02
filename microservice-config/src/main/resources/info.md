Este micro servicio funciona como una configuracion  de configuraciones

es decir que el contiene todos los "aplications.properties"  de cada uno de los microservicios  

asi el se encarga de guardar la configuración de todos los microservicios  
cada vez que un microservicio se va a cargar  ira al ConfigServer y  
solicita su configuracion propia  para poder trabajar en sus parametros. 
así no tenemos que estar trasteando con cada configServer