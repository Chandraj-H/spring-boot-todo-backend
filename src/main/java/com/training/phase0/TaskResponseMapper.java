package com.training.phase0;

import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;

//2
//RowMapper - boundary between db and java, names here are acc to db table not java class
public class TaskResponseMapper implements RowMapper<TaskResponse> {
    @Override
    public @Nullable TaskResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TaskResponse(rs.getLong("id"), rs.getString("title"), rs.getBoolean("done"), rs.getObject("created_at", OffsetDateTime.class));
    }
}
