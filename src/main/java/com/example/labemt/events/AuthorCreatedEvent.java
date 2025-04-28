package com.example.labemt.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.LocalDateTime;

@Getter
public class AuthorCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public AuthorCreatedEvent(Object source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public AuthorCreatedEvent(Object source, Clock clock) {
        super(source, clock);
        this.when = when;
    }
}
