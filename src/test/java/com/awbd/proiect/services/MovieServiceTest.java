package com.awbd.proiect.services;

import com.awbd.proiect.repositories.MovieRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
    @Mock
    MovieRepository productRepository;

    @InjectMocks
    MovieServiceImpl productService;

}
