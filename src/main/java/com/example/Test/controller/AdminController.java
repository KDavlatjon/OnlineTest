package com.example.Test.controller;

import com.example.Test.Service.UserService;
import com.example.Test.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private  final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(userService.getOne(id));
    }

    @GetMapping("/list")
    public ResponseEntity<?> CustomerList(){
        return ResponseEntity.ok(userService.getList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        userService.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id,@RequestBody Users users){
        return ResponseEntity.ok(userService.update(id, users));
    }

}
