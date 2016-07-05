package com.pigatron.web.core.sequence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SequenceRepository extends MongoRepository<Sequence, String> {

    Sequence findByName(String name);

}
