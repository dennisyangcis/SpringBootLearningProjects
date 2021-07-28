package org.yangcis.webfluxlearning.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yangcis.webfluxlearning.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: yangyinqi1991@gmail.com
 * @date: 2021/7/28
 * @description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        users.put(1L, new User(1L, "longzhonghua", 28));
        users.put(2L, new User(2L, "longzhiran", 2));
    }

    /**
     * Get all users in system
     *
     * @return All user
     */
    @GetMapping("/list")
    public Flux<User> getAll() {
        return Flux.fromIterable(new ArrayList<>(users.values()));
    }

    /**
     * Get specific user with id
     *
     * @param id User id
     * @return user
     */
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return Mono.justOrEmpty(users.get(id));
    }

    /**
     * Add new user
     *
     * @param user New user
     * @return response message
     */
    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(User user) {
        users.put(user.getId(), user);
        return Mono.just(new ResponseEntity<>("Add successfully", HttpStatus.CREATED));
    }

    /**
     * Modify current user
     *
     * @param id user id
     * @param user user body
     * @return user
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> putUser(@PathVariable Long id, User user) {
        user.setId(id);
        users.put(id, user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    /**
     * Delete exist user
     *
     * @param id user id
     * @return response message
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id) {
        users.remove(id);
        return Mono.just(new ResponseEntity<>("Delete successfully", HttpStatus.CREATED));
    }
}
