package net.cavitos.media.player.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cavitos.media.player.service.AudioCdPlayerService;

@RestController
@RequestMapping("/v1/player/audio-cd")
public class AudioCdPlayerController {

    private final AudioCdPlayerService audioCdPlayerService;

    public AudioCdPlayerController(final AudioCdPlayerService audioCdPlayerService) {

        this.audioCdPlayerService = audioCdPlayerService;
    }

    @GetMapping("/play")
    public ResponseEntity play() {

        audioCdPlayerService.prepare();

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/stop")
    public ResponseEntity stop() {

        audioCdPlayerService.stop();

        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
