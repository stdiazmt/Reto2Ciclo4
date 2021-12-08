package com.usa.ciclo4.reto2ciclo4.controller;

import com.usa.ciclo4.reto2ciclo4.model.User;
import com.usa.ciclo4.reto2ciclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

/**
 * Clase controladora de rutas
 */
public class UserController {
   
    @Autowired
    /**
	* instacia de servicio a usar
	*/
    private UserService userService;

    @GetMapping("/all")
    /**
	* método para listar todos los usuarios
	*/
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/new")
    /**
	* método para agregar usuarios
	*/
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/update")
    /**
	* método para actualizar un usuario
	*/
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    /**
	* método para eliminar usuario
	*/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }

    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email,password);
    }

    @GetMapping("/emailexist/{email}")
    /**
	* método para validar email de usuario
	*/
    public boolean emailexists (@PathVariable("email") String email){
        return userService.emailExists(email);
    }
}
