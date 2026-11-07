package com.training.phase0;

import java.time.OffsetDateTime;

//1
//DTO
public record TaskResponse(long id, String title, boolean done, OffsetDateTime createdAt) {
}
