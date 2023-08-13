package poolside.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poolside.controller.dto.request.PriceSaveRequestDto;
import poolside.controller.dto.response.PriceResponseDto;
import poolside.controller.dto.response.ProductResponseDto;
import poolside.entity.Price;
import poolside.repository.PriceRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PriceService {
    private final PriceRepository priceRepository;

    //저장
    @Transactional
    public Long save(PriceSaveRequestDto savePrice) {
        return priceRepository.save(savePrice.toEntity()).getId();
    }

    //변경
    @Transactional
    public Long update(Long id , PriceSaveRequestDto updatePrice) {
        Price price = priceRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        price.update(updatePrice.getProductId(),
                updatePrice.getSeasonDvcd(),
                updatePrice.getDescription(),
                updatePrice.getStartDate(),
                updatePrice.getEndDate(),
                updatePrice.getChildPrice(),
                updatePrice.getAddPrice(),
                updatePrice.getTotPrice());
        return id;
    }

    //삭제 로직 확인 필요
    @Transactional
    public Long delete(Long id) {
        Price price = priceRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        priceRepository.delete(price);
        return id;
    }

    //단건조회(id)
    public PriceResponseDto findPriceById(Long id) {
        Price price = priceRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        return new PriceResponseDto(price);
    }

    //전체조회
    public List<PriceResponseDto> findPrices() {
        List<Price> allPrices = priceRepository.findAll();
        return allPrices.stream()
                .map(price -> new PriceResponseDto(price))
                .collect(Collectors.toList());
    }
}
