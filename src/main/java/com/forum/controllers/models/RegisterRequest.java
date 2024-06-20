package com.forum.controllers.models;

import com.forum.repositories.entities.UserRole;

public record RegisterRequest(String login, String password, UserRole role) {
}
