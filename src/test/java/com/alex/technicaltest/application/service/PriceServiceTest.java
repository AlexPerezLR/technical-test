package com.alex.technicaltest.application.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.alex.technicaltest.aplication.service.price.DomainPriceServiceImpl;
import com.alex.technicaltest.domain.dto.inbound.PriceRequestDto;
import com.alex.technicaltest.domain.dto.outbound.PriceResponseDto;
import com.alex.technicaltest.domain.port.PriceRepository;

@SpringBootTest
@ActiveProfiles({"junit"})
public class PriceServiceTest {

    @Mock
    private PriceRepository priceRepo;

    @InjectMocks
    private DomainPriceServiceImpl priceService;

    @Test
    public void getPriceByParams(){
        List<PriceResponseDto> fakeList = List.of(
            PriceResponseDto.builder()
                .brandId(1L)
                .productId(4L)
                .priority(0)
                .build(),
            PriceResponseDto.builder()
                .brandId(2L)
                .productId(3L)
                .priority(1)
                .build(),
            PriceResponseDto.builder()
                .brandId(5L)
                .productId(8L)
                .priority(2)
                .build()
            );

        PriceRequestDto request = new PriceRequestDto();
        Mockito.when(priceRepo.getByRequestParams(request))
                .thenReturn(fakeList);

        PriceResponseDto result = priceService.getPriceByParams(request);

        assertTrue(result.getProductId()==8L, "The object returned is not the one with highest priority.");
    }
}
