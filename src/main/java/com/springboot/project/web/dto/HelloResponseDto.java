package com.springboot.project.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.PrintWriter;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}