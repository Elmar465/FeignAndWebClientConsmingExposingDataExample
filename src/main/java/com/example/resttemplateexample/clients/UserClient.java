package com.example.resttemplateexample.clients;


import com.example.resttemplateexample.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "userClient", url = "http://localhost:8085/users")
public interface UserClient {

    @GetMapping("getUserById/{id}")
    UserModel getUserById(@PathVariable("id") Integer id);

    @PostMapping("/createUser")
    UserModel createUser(@RequestBody UserModel userModel);

    @PutMapping("/updateAUser/{id}/{email}")
    UserModel updateUser(@PathVariable("id")Integer id  , @PathVariable("email") String email);


    @DeleteMapping("{id}")
    void deleteUser(@PathVariable("id") Integer id);

    @GetMapping("/getALlUser")
    List<UserModel> getAllUser();
}
