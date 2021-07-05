package com.okta.springbootmongo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/music")
public class MusicController {

    private MusicRepository musicRepository;

    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @PostMapping()
    public @ResponseBody
    Mono<Music> addMusic(@RequestBody Music music){
        return musicRepository.save(music);
    }

    @GetMapping
    public @ResponseBody
    Flux<Music> getAllMusics(){
        return musicRepository.findAll();
    }

}
