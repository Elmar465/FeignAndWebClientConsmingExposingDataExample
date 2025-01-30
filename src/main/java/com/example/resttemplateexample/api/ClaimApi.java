package com.example.resttemplateexample.api;


import com.example.resttemplateexample.clients.UserClient;
import com.example.resttemplateexample.model.UserModel;
import com.example.resttemplateexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/claims")
@RequiredArgsConstructor
public class ClaimApi {

    private final RestTemplate restTemplate;
    private final UserService userService;
    private final WebClient webClient;
    private final UserClient userClient;


    @GetMapping("/get")
    public UserModel warranty() {
        // restTemplate.getForObject("http://localhost:8080/users/getUserById/1", UserModel.class);
//        UserModel  warranty =  webClient.get().uri("http://localhost:8080/users/getUserById/2", WarrantyModel.class)
//                 .header("Accept", "application/json")
//                 .header("Content-Type", "application/json")
//                 .header("userName", "application/json")
//                 .retrieve()
//                 .bodyToMono(UserModel.class)
//                 .timeout(Duration.ofMillis(10000))
//                 .block();

        //Feign Client implementation
        UserModel userModel = userClient.getUserById(1);
    return  userModel;
    }

    //* i Commented feign client you can turn and change api request from interface

//    @PostMapping("/create")
//    public UserModel create(@RequestBody UserModel userModel) {
//        return userClient.createUser(userModel);
//    }

    //* i Commented feign client you can turn and change api request from interface

//    @PutMapping("/update")
//    public UserModel update() {
//        return userClient.updateUser(102,"Ali100@Gmail.com");
//    }


    //* i Commented feign client you can turn and change api request from interface

//    @DeleteMapping("/delete")
//    void delete() {
//        userClient.deleteUser(3);
//    }


    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers(){
        return userClient.getAllUser();
    }


    @PostMapping("/add")
    public UserModel create(@RequestBody UserModel userModel) {
        return  webClient.post()
                .uri("http://localhost:8085/users/createUser")
                .bodyValue(userModel)
                .retrieve()
                .bodyToMono(UserModel.class)
                .block();
    }

    @PutMapping("/update")
    public UserModel updateUser(UserModel model) {
        return webClient
                .put()
                .uri("http://localhost:8085/users/updateAUser/1/Elmar565@gmail.com")
                .bodyValue(model)
                .retrieve()
                .bodyToMono(UserModel.class)
                .block();
    }


    @DeleteMapping("/delete")
    public void deleteUser(){
        webClient
                .method(HttpMethod.DELETE)
                .uri("http://localhost:8085/users/2")
                .retrieve()
                .bodyToMono(UserModel.class)
                .block();
    }
}
