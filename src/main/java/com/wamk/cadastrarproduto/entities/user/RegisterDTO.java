package com.wamk.cadastrarproduto.entities.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
