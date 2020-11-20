package com.tianyisoft.mymoney.controller;

import com.tianyisoft.mymoney.entity.UserTag;
import com.tianyisoft.mymoney.service.UserTagService;
import com.tianyisoft.mymoney.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tianyi
 */
@RestController
@RequestMapping("/user_tags")
public class UserTagController {
    private final UserTagService tagService;

    public UserTagController(UserTagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("")
    public List<UserTag> list() {
        return tagService.list();
    }

    @PostMapping("")
    public UserTag save(@RequestBody @Validated UserTag tag, HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        Object user = request.getAttribute("user");
        tag.setUserId((Integer) Utils.getFieldValueFromObject(user, "id"));
        tagService.save(tag);
        return tagService.find(tag.getId());
    }

    @GetMapping("/{id}")
    public UserTag find(@PathVariable Integer id) {
        return tagService.find(id);
    }

    @PutMapping("/{id}")
    public UserTag update(@RequestBody @Validated UserTag tag, @PathVariable Integer id) {
        tag.setId(id);
        tagService.update(tag);
        return tagService.find(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Integer id) {
        tagService.destroy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
