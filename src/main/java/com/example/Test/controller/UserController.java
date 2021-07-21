package com.example.Test.controller;

import com.example.Test.Service.ResultService;
import com.example.Test.Service.UserService;
import com.example.Test.model.Results;
import com.example.Test.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ResultService resultService;

    @Autowired
    public UserController(UserService userService, ResultService resultService) {
        this.userService = userService;
        this.resultService = resultService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> add(@RequestBody Users users){
        return ResponseEntity.ok(userService.add(users));
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> check(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone
    ){
        if (userService.getByPhone(phone).getName().equals(name)){
            return ResponseEntity.ok(userService.getByPhone(phone));
        }
        return null;
    }

    @PostMapping("/setResult")
    public ResponseEntity<?> setResult(
            @RequestParam("userId") Integer id,
            @RequestParam("testType") String type,
            @RequestParam("quantity") Integer quantity
    ){
        Users users = userService.getOne(id);
        Results results = new Results();

        results.setUserName(users.getName());
        results.setUserLastName(users.getLastName());
        results.setUserGroup(users.getGroupNumber());
        results.setTestType(type);
        results.setQuantity(quantity);
        return ResponseEntity.ok(resultService.create(results));
    }

//    Get All Results
    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return ResponseEntity.ok(resultService.getList());
    }

//    Get Results By Group
    @GetMapping("/group")
    public ResponseEntity<?> getByGroup(@RequestParam("group") String group){
        return ResponseEntity.ok(resultService.getByGroup(group));
    }

//    Get Results bu Name and Lastname
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUserResults(@PathVariable("id") Integer id){
        Users users = userService.getOne(id);
        return ResponseEntity.ok(resultService.getByNameAndLastName(users.getName(), users.getLastName()));
    }

//    Delete By Id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        resultService.delete(id);
    }

}
