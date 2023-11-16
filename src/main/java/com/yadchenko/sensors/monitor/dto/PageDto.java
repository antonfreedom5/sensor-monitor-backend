package com.yadchenko.sensors.monitor.dto;

import java.util.List;

public record PageDto<T>(List<T> content, Long totalElements) {}
