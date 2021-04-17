package com.lambdaschool.zoos.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Auditing implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String uname;
        uname = "System";
        return Optional.of(uname);
    }
}
