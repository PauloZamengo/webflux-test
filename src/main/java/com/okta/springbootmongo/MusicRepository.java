package com.okta.springbootmongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MusicRepository extends ReactiveMongoRepository<Music, Long> {
}
