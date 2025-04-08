package org.example.exreposeitory.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exreposeitory.Api.ApiResponse;
import org.example.exreposeitory.Model.User;
import org.example.exreposeitory.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.ok(userService.allUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.ok(new ApiResponse("added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody@Valid User user,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = userService.updateUser(id,user);
       if (isUpdate){
           return ResponseEntity.ok().body(new ApiResponse("update successfully"));
       }
       return ResponseEntity.badRequest().body(new ApiResponse("id is not found") );

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        Boolean isDelete = userService.deleteUser(id);
        if (isDelete){
            return ResponseEntity.ok(new ApiResponse("delete successfully"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("id is not found"));

    }
    @GetMapping("/check-username-password")
    public ResponseEntity check(@RequestParam String userName, String password){
        return ResponseEntity.ok(userService.checkUserNameAndPassword(userName,password));
    }
    @GetMapping("/get-email/{email}")
    public ResponseEntity userEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getEmail(email));
    }

    @GetMapping("/get-role/{role}")
    public ResponseEntity findRole (@PathVariable String role){
        return ResponseEntity.ok(userService.getRole(role));
    }

    @GetMapping("/get-age/{age}")
    public ResponseEntity ageGreaterThan(@PathVariable Integer age){
        return ResponseEntity.ok(userService.getAge(age));
    }





}
