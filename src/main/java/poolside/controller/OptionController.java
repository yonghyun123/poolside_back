package poolside.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import poolside.common.dto.Response;
import poolside.controller.dto.request.OptionSaveRequestDto;
import poolside.controller.dto.response.OptionResponseDto;
import poolside.service.OptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")

public class OptionController {
    private final OptionService optionService;

    @PostMapping("/options")
    public Response<Long> addOption(@RequestBody OptionSaveRequestDto saveOption) {
        return Response.ok(optionService.save(saveOption));
    }

    @PutMapping("/options/{id}")
    public Response<Long> updateOption(@PathVariable Long id, OptionSaveRequestDto updateOption){
        return Response.ok(optionService.update(id, updateOption));
    }

    @DeleteMapping("/options/{id}")
    public Response<Long> deleteOption(@PathVariable Long id) {
        return Response.ok(optionService.delete(id));
    }

    @GetMapping("/options/{id}")
    public Response<OptionResponseDto> findOptionById(@PathVariable Long id) {
        return Response.ok(optionService.findPriceById(id));
    }

    @GetMapping("/options")
    public Response<List<OptionResponseDto>> findOptions() {
        return Response.ok(optionService.findOptions());
    }
}
