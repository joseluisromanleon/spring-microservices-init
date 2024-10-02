
# Podriamos trabajar como se hace automaticamente con los crud de Repository
# pero aqui vamos a trabajar creando los DAO nosotros 

## No obstante voy a dejar tambien creado el paquete repository tal como se configuraría.

# usualmente se crearia una interface con la anotacion @Repository  como se ve en el ejemplo.

public interface IUserRepository extend CrudRepository<UserEntity, Long>{   }

entonces IUserRepository   utilizaria los DAOs que tiene por defecto  nosotros actuariamos directamente
el repository    podemos ver los metodos que se crearon en el No-Bean de CrudRepository   CTRL + click

asi que nosotros no estariamos trabajando con DAO  sino con Repository. 