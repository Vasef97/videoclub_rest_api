package com.ltp.videoclubs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.videoclubs.entity.Videoclub;
import com.ltp.videoclubs.service.VideoclubService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/videoclub")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Videoclub Controller", description = "Create and retrieve videoclub info.")
public class VideoclubController {

    @Autowired
    VideoclubService videoclubService;

    @GetMapping("/{id}")
     @Operation(summary = "Get info for a specific videoclub.")
    public ResponseEntity<Videoclub> getVideoclub(@PathVariable Long id) {
        return new ResponseEntity<>(videoclubService.getVideoclub(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a videoclub.")
    public ResponseEntity<Videoclub> createVideoclub(@RequestBody Videoclub videoclub) {
        return new ResponseEntity<>(videoclubService.saveVideoclub(videoclub), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update videoclub info.")
    public ResponseEntity<Videoclub> updateVideoclub(@PathVariable Long id, @RequestBody Videoclub videoclub) {
        videoclubService.updateVideoclub(id, videoclub);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a videoclub.")
    public ResponseEntity<HttpStatus> deleteVideoclub(@PathVariable Long id) {
        videoclubService.deleteVideoclub(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @GetMapping("/all")
    @Operation(summary = "Get all videoclubs.")
    public ResponseEntity<Iterable<Videoclub>> getVideoclubs() {
        return new ResponseEntity<>(videoclubService.getVideoclubs(), HttpStatus.OK);
    }

}