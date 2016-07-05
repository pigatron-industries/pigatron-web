package com.pigatron.web.core.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

    public static final int DEFAULT_START_VALUE = 100;

    private SequenceRepository sequenceRepository;

    @Autowired
    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public Sequence createSequence(String name, int startValue) {
        Sequence sequence = sequenceRepository.findByName(name);
        if(sequence == null) {
            sequence = new Sequence(name, startValue);
        }
        sequenceRepository.save(sequence);
        return sequence;
    }

    private Sequence createSequence(String name) {
        Sequence sequence = new Sequence(name, DEFAULT_START_VALUE);
        sequenceRepository.save(sequence);
        return sequence;
    }

    public int getNextValue(String name) {
        Sequence sequence = sequenceRepository.findByName(name);
        if(sequence == null) {
            sequence = createSequence(name);
        }
        int value = sequence.getNextValue();
        sequenceRepository.save(sequence);
        return value;
    }

}
