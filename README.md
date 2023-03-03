### API GUARDIAS CENTRO
---

### ÍNDICE
1. [INTRODUCCIÓN](#introducción)
2. [CONFIGURACIÓN](#configuración)
3. [CONTROLADOR](#controlador)
4. [MODELO](#modelo)
5. [MÉTODOS](#métodos)

## INTRODUCCIÓN
API para la gestión de guardias, Nos permite establecer la comunicación entre la base de datos y las aplicaciones. 

## CONFIGURACIÓN
En la capa de configuración, se encuentra el Swagger, en la clase SwaggerObject.java , que es desde donde hemos realizado las pruebas, para comprobar las peticiones y el funcionamiento, con este támbien podemos documentar de forma más visual la API.

## CONTROLADOR
Se encuentran los objetos que se ejecutaran al recibir las peticiones, en este caso, serán: AvisoController.java, GuardiaController.java, HorarioController.java, HorarioGuardiaController.java, ProfesorController.java y ProfesorTienePerfilController.java.

## MODELO
En este paquete encontramos las clases, repositorios y enumerados, que dan forma a los datos que esta devuelve. Nos permitira mapear los objetos correctamente, establecer, nulos, nombres de columnas sobras las cuales hacen referencia los campos.

## MÉTODOS

 **Aviso**
 ```sh
  obtenerListaAvisos() -- Devuelve lista de avisos
  obtenerAvisosIdProfesor(@RequestParam Integer id) -- Obtiene una lista de avisos por el id del profesor
  crearAviso(@RequestBody AvisosGuardia nuevo) -- Crea un aviso
  actualizarAviso(@RequestBody AvisosGuardia editar, @PathVariable Integer id) -- Modifica un aviso
  borrarAviso(@PathVariable Integer id) -- Borra un aviso
  ```
  
 **Guardia**
 ```sh
  obtenerGuardias() -- Devuelve lista de guardias
  obtenerGuardiaId(@PathVariable Integer id) -- Devuelve guardia por Id
  nuevaGuardia(@RequestBody Guardia nueva) -- Crea una nueva guardia
  actualizarGuardia(@RequestBody Guardia editar, @PathVariable Integer id) -- Modifica el objeto guardia
  borrarGuardia(@PathVariable Integer id) -- Borra una guardia
  obtenerGuardiasSinSustitucion() -- Obtiene todas las gaurdias que no tiene sustituto
  setGuardiaEstado(@PathVariable Integer id,@RequestParam Estado estado) -- Modifica el estado de una guardia
 ```
 
 **Horario**
 ```sh
  getAll() -- Devuelve todos los horarios
  getHorarios(@RequestParam(name = "profesor id") Integer profesorId,@RequestParam(name = "diaSemana") Integer diaSemana) -- Devuelve una lista de horarios por profesor y día
  obtenerHorariosProfesor(@RequestParam Integer id) -- Devuelve una lista con todos los horarios de un profesor
  setIdSustitucion(@PathVariable Integer id,@RequestParam Byte genera) -- Modifica si se va a generar una guardia o no
 ```
 
 **Horario guardia**
 ```sh
  obtenerUno(@RequestParam Integer id) -- Obtiene la lista de los horarios guardia, por id del profesor
  setRealizadas(@RequestParam Integer profesorId, @RequestParam Integer diaSemana, @RequestParam Integer horario) -- Incrementa en uno, el número de guardias      realizadas en un horario
 ```
 
 **Profesor**
 ```sh
  obtenerListaProfesores() -- Devuelve la lista de profesores
  obtenerUno(@PathVariable Integer id) -- Obtiene un profesor por id
  login(@RequestParam String user, @RequestParam String pwd) -- Autentificación, recibe usuario y contraseña
  nuevoProfesor(@RequestBody Profesor nuevo) -- Crea un nuevo profesor
  actualizarProfesor(@RequestBody Profesor editar,@PathVariable Integer id) -- Modifica un objeto profesor
  borrarProfesor(@PathVariable Integer id) -- Borra un profesor
  setIdSustitucion(@PathVariable Integer id,@RequestParam Integer idSustitucion) -- Modifica el id del profesor el cual sustituye 
  ```
  
  **Profesor tiene perfil**
  ```sh 
  obtenerPerfil(@RequestParam Integer id) -- Controla si el perfil del profesor pertenece a la dirección o administración, recibe el id de un profesor.
  ```
---

```sh
Jesús Bueno González
Ana Belen Fernández San Miguel
Andrea Murillo González
Laura Tejera Aldazábal
```
