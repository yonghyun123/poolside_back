package poolside.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poolside.controller.dto.request.OptionSaveRequestDto;
import poolside.controller.dto.request.PriceSaveRequestDto;
import poolside.controller.dto.response.OptionResponseDto;
import poolside.controller.dto.response.PriceResponseDto;
import poolside.entity.Option;
import poolside.entity.Price;
import poolside.repository.OptionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OptionService {
    private final OptionRepository optionRepository;

    //저장
    @Transactional
    public Long save(OptionSaveRequestDto saveOption) {
        return optionRepository.save(saveOption.toEntity()).getId();
    }

    //변경
    @Transactional
    public Long update(Long id , OptionSaveRequestDto updateOption) {
        Option option = optionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        option.update(updateOption.getDescription(),
                updateOption.getPrice());
        return id;
    }

    //삭제 로직 확인 필요
    @Transactional
    public Long delete(Long id) {
        Option option = optionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        optionRepository.delete(option);
        return id;
    }

    //단건조회(id)
    public OptionResponseDto findPriceById(Long id) {
        Option option = optionRepository.findById(id).orElseThrow(() -> new NoSuchElementException("값이 존재하지 않습니다"));
        return new OptionResponseDto(option);
    }

    //전체조회
    public List<OptionResponseDto> findOptions() {
        List<Option> allOptions = optionRepository.findAll();
        return allOptions.stream()
                .map(option -> new OptionResponseDto(option))
                .collect(Collectors.toList());
    }
}
