package com.example.resttemplateexample.api;


import com.example.resttemplateexample.clients.UserClient;
import com.example.resttemplateexample.model.UserModel;
import com.example.resttemplateexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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


    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel) {
        return userClient.createUser(userModel);
    }


    @PutMapping("/update")
    public UserModel update() {
        return userClient.updateUser(102,"Ali100@Gmail.com");
    }

//
//    @PostMapping("/add")
//    public UserModel createUser(@RequestBody  UserModel userModel) {
//        return webClient.post()
//                .uri("http://localhost:8080/users/create")
//                .body(Mono.just(userModel), UserModel.class)
//                .retrieve()
//                .bodyToMono(UserModel.class)
//                .block(Duration.ofMillis(1000));
//    }
//    public String createUser(@RequestBody UserModel user) {
//        return userService.createUser(user).getUserName();
//    }
}
