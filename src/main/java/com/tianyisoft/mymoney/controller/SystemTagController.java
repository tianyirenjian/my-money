package com.tianyisoft.mymoney.controller;

import com.tianyisoft.mymoney.entity.SystemTag;
import com.tianyisoft.mymoney.service.SystemTagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tianyi
 */
@RestController
@RequestMapping("/system_tags")
public class SystemTagController {
    private final SystemTagService tagService;

    public SystemTagController(SystemTagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("")
    public List<SystemTag> list() {
        return tagService.list();
    }

    @PostMapping("")
    public SystemTag save(@RequestBody @Validated SystemTag tag) {
        tagService.save(tag);
        return tagService.find(tag.getId());
    }

    @GetMapping("/{id}")
    public SystemTag find(@PathVariable Integer id) {
        return tagService.find(id);
    }

    @PutMapping("/{id}")
    public SystemTag update(@RequestBody @Validated SystemTag tag, @PathVariable Integer id) {
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
