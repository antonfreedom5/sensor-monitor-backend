package com.yadchenko.sensors.monitor.dto;

import java.util.List;

public record UserDto(String username, List<String> roles) {}
